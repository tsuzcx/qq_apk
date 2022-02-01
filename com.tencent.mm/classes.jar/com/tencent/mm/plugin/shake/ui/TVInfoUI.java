package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.a.ju;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.e.a.a;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class TVInfoUI
  extends MMPreference
  implements com.tencent.mm.an.i, u.a
{
  private boolean IQP = false;
  private String Jrd = "";
  private TextView Jre;
  private c.a Jrf;
  private boolean Jrg = false;
  private com.tencent.mm.plugin.shake.e.b Jrh;
  protected ProgressDialog iXX = null;
  private long msgId;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  private ImageView txC;
  
  private void a(final c.a parama)
  {
    AppMethodBeat.i(28592);
    if (parama == null)
    {
      Log.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(28592);
      return;
    }
    this.titleTv.setText(parama.field_title);
    if (Util.isNullOrNil(parama.field_topic)) {
      this.Jre.setVisibility(8);
    }
    for (;;)
    {
      this.txC = ((ImageView)findViewById(R.h.dYp));
      if (!Util.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(R.h.dYo);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28579);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            h.IzE.a(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28579);
          }
        });
        this.txC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28580);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            h.IzE.a(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28580);
          }
        });
      }
      addIconOptionMenu(0, R.k.icons_outlined_more, new TVInfoUI.3(this));
      if ((!Util.isNullOrNil(parama.field_id)) && (!this.Jrg) && (!getIntent().getBooleanExtra("key_TV_come_from_shake", false)))
      {
        int i = getIntent().getIntExtra("key_TV_getProductInfoScene", 0);
        Log.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[] { parama.field_id, Integer.valueOf(i) });
        bh.aGY().a(new com.tencent.mm.plugin.shake.d.a.b(parama.field_id, i), 0);
        this.Jrg = true;
      }
      this.txC.setVisibility(0);
      setBackBtn(new TVInfoUI.4(this));
      Log.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28583);
          TVInfoUI.a(TVInfoUI.this, parama);
          TVInfoUI.b(TVInfoUI.this, parama);
          AppMethodBeat.o(28583);
        }
      });
      AppMethodBeat.o(28592);
      return;
      this.Jre.setText(parama.field_topic);
    }
  }
  
  private void fDL()
  {
    AppMethodBeat.i(28593);
    this.msgId = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (bh.aHB()))
    {
      bh.beI();
      ca localca = com.tencent.mm.model.c.bbO().Oq(this.msgId);
      if (localca.field_msgId > 0L)
      {
        localca.Jn(this.Jrh.bvq());
        bh.beI();
        com.tencent.mm.model.c.bbO().a(this.msgId, localca);
      }
    }
    AppMethodBeat.o(28593);
  }
  
  public int getHeaderResourceId()
  {
    return R.i.elC;
  }
  
  public int getLayoutId()
  {
    return R.i.elB;
  }
  
  public int getResourceId()
  {
    return R.o.eXS;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28591);
    setMMTitle(R.l.eRF);
    this.screen = getPreferenceScreen();
    this.titleTv = ((TextView)findViewById(R.h.dYq));
    this.Jre = ((TextView)findViewById(R.h.dYr));
    String str2 = getIntent().getStringExtra("key_TV_xml");
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_TV_xml_bytes");
      str1 = str2;
      if (arrayOfByte != null) {
        str1 = new String(arrayOfByte);
      }
    }
    Log.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[] { str1 });
    this.Jrf = com.tencent.mm.plugin.shake.e.c.aYd(str1);
    if (this.Jrf == null)
    {
      Log.e("MicroMsg.TVInfoUI", "initView(), tv == null");
      finish();
      AppMethodBeat.o(28591);
      return;
    }
    a(this.Jrf);
    AppMethodBeat.o(28591);
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28595);
    if (paramString != null)
    {
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.TVInfoUI", "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]", new Object[] { paramString, Boolean.valueOf(bool) });
        try
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28586);
              if ((TVInfoUI.e(TVInfoUI.this) != null) && (TVInfoUI.e(TVInfoUI.this).equals(paramString)))
              {
                if ((TVInfoUI.f(TVInfoUI.this) != null) && (paramBitmap != null))
                {
                  TVInfoUI.f(TVInfoUI.this).setImageBitmap(paramBitmap);
                  TVInfoUI.g(TVInfoUI.this);
                }
                TVInfoUI.h(TVInfoUI.this);
              }
              AppMethodBeat.o(28586);
            }
          });
          AppMethodBeat.o(28595);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[] { paramString.getLocalizedMessage() });
          Log.printErrStackTrace("MicroMsg.TVInfoUI", paramString, "", new Object[0]);
          AppMethodBeat.o(28595);
          return;
        }
      }
    }
    Log.e("MicroMsg.TVInfoUI", "onUpdateEnable pic, url  is null ");
    AppMethodBeat.o(28595);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28587);
    super.onCreate(paramBundle);
    u.b(this);
    initView();
    AppMethodBeat.o(28587);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28590);
    u.c(this);
    super.onDestroy();
    AppMethodBeat.o(28590);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28589);
    bh.aGY().b(552, this);
    super.onPause();
    AppMethodBeat.o(28589);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(28594);
    Log.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.Jrf == null) || (this.Jrf.IZR == null))
    {
      Log.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
      AppMethodBeat.o(28594);
      return false;
    }
    for (;;)
    {
      Intent localIntent;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        int j = i / 100;
        int k = i % 100;
        Log.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.Jrf.IZR.size()))
        {
          Log.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.Jrf.IZR.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (com.tencent.mm.plugin.shake.e.a)this.Jrf.IZR.get(j);
        if (paramf == null)
        {
          Log.w("MicroMsg.TVInfoUI", "actionList == null");
          AppMethodBeat.o(28594);
          return false;
        }
        if ((k < 0) || (k >= paramf.pSC.size()))
        {
          Log.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramf.pSC.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (a.a)paramf.pSC.get(k);
        if (paramf == null)
        {
          Log.w("MicroMsg.TVInfoUI", "action == null");
          AppMethodBeat.o(28594);
          return false;
        }
        Log.v("MicroMsg.TVInfoUI", "action type:" + paramf.type + ", target:" + paramf.GRy + ", targetDesc:" + paramf.Jrr + ", targetDesc2:" + paramf.Jrs);
        if (paramf.type == 3)
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf.GRy);
          paramPreference.putExtra("show_bottom", false);
          paramPreference.putExtra("geta8key_scene", 10);
          paramPreference.putExtra("srcUsername", paramf.Jrs);
          com.tencent.mm.plugin.shake.a.mIG.h(paramPreference, this);
          AppMethodBeat.o(28594);
          return true;
        }
        if (paramf.type != 4) {
          break label642;
        }
        bh.beI();
        paramPreference = com.tencent.mm.model.c.bbL().RG(paramf.GRy);
        if (paramPreference == null) {
          continue;
        }
        localIntent = new Intent();
        if ((com.tencent.mm.contact.d.rk(paramPreference.field_type)) && (paramPreference.hxX()))
        {
          af.bjv().Uo(paramf.GRy);
          if (paramf.Jrr.equals("1"))
          {
            localIntent.putExtra("Chat_User", paramf.GRy);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.mIG.d(localIntent, this);
            continue;
          }
        }
        localIntent.putExtra("Contact_User", paramf.GRy);
      }
      catch (Exception paramf)
      {
        Log.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        Log.printErrStackTrace("MicroMsg.TVInfoUI", paramf, "", new Object[0]);
        AppMethodBeat.o(28594);
        return false;
      }
      localIntent.putExtra("force_get_contact", true);
      com.tencent.mm.by.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      continue;
      label642:
      if (paramf.type == 5)
      {
        paramPreference = new ju();
        paramPreference.fHe.actionCode = 11;
        paramPreference.fHe.result = paramf.GRy;
        paramPreference.fHe.context = this;
        paramPreference.callback = null;
        EventCenter.instance.asyncPublish(paramPreference, Looper.myLooper());
      }
      else if (paramf.type == 6)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("key_product_id", paramf.GRy);
        paramPreference.putExtra("key_product_scene", 9);
        com.tencent.mm.by.c.b(this, "product", ".ui.MallProductUI", paramPreference);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28588);
    super.onResume();
    bh.aGY().a(552, this);
    AppMethodBeat.o(28588);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28596);
    if (paramq == null)
    {
      Log.w("MicroMsg.TVInfoUI", "scene == null");
      AppMethodBeat.o(28596);
      return;
    }
    if (paramq.getType() == 552)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, R.l.eRG, 0).show();
        AppMethodBeat.o(28596);
        return;
      }
      if (this.Jrf == null)
      {
        Log.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
        AppMethodBeat.o(28596);
        return;
      }
      paramString = (com.tencent.mm.plugin.shake.d.a.b)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (paramString = (cdq)d.c.b(paramString.rr.lBS); paramString == null; paramString = null)
      {
        Log.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
        AppMethodBeat.o(28596);
        return;
      }
      if (paramString.Tlx != null)
      {
        Log.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + paramString.Tlx);
        paramString = com.tencent.mm.plugin.shake.e.c.aYd(paramString.Tlx);
        if ((this.Jrf != null) && (this.Jrf.field_xml != null) && (paramString != null) && (paramString.field_xml != null) && (!this.Jrf.field_xml.equals(paramString.field_xml)))
        {
          this.Jrf = paramString;
          a(this.Jrf);
        }
      }
    }
    AppMethodBeat.o(28596);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI
 * JD-Core Version:    0.7.0.1
 */