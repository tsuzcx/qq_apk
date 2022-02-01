package com.tencent.mm.plugin.shake.ui;

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
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.plugin.shake.d.d.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class TVInfoUI
  extends MMPreference
  implements com.tencent.mm.am.h, r.a
{
  private TextView EUj;
  private boolean OZL = false;
  private String PEC = "";
  private d.a PED;
  private boolean PEE = false;
  private com.tencent.mm.plugin.shake.d.c PEF;
  protected ProgressDialog lzP = null;
  private long msgId;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  private ImageView wBY;
  
  private void a(final d.a parama)
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
      this.EUj.setVisibility(8);
    }
    for (;;)
    {
      this.wBY = ((ImageView)findViewById(R.h.gbd));
      if (!Util.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(R.h.gbc);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28579);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.plugin.report.service.h.OAn.b(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28579);
          }
        });
        this.wBY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28580);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.plugin.report.service.h.OAn.b(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28580);
          }
        });
      }
      addIconOptionMenu(0, R.k.icons_outlined_more, new TVInfoUI.3(this));
      if ((!Util.isNullOrNil(parama.field_id)) && (!this.PEE) && (!getIntent().getBooleanExtra("key_TV_come_from_shake", false)))
      {
        int i = getIntent().getIntExtra("key_TV_getProductInfoScene", 0);
        Log.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[] { parama.field_id, Integer.valueOf(i) });
        bh.aZW().a(new com.tencent.mm.plugin.shake.c.a.c(parama.field_id, i), 0);
        this.PEE = true;
      }
      this.wBY.setVisibility(0);
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
      this.EUj.setText(parama.field_topic);
    }
  }
  
  private void gSz()
  {
    AppMethodBeat.i(28593);
    this.msgId = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (bh.baz()))
    {
      bh.bCz();
      cc localcc = com.tencent.mm.model.c.bzD().sl(this.msgId);
      if ((localcc != null) && (localcc.field_msgId > 0L))
      {
        localcc.BT(this.PEF.bTC());
        bh.bCz();
        com.tencent.mm.model.c.bzD().a(this.msgId, localcc);
      }
    }
    AppMethodBeat.o(28593);
  }
  
  public int getHeaderResourceId()
  {
    return R.i.goG;
  }
  
  public int getLayoutId()
  {
    return R.i.goF;
  }
  
  public int getResourceId()
  {
    return R.o.hbt;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28591);
    setMMTitle(R.l.gUl);
    this.screen = getPreferenceScreen();
    this.titleTv = ((TextView)findViewById(R.h.gbe));
    this.EUj = ((TextView)findViewById(R.h.gbf));
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
    this.PED = com.tencent.mm.plugin.shake.d.d.aVU(str1);
    if (this.PED == null)
    {
      Log.e("MicroMsg.TVInfoUI", "initView(), tv == null");
      finish();
      AppMethodBeat.o(28591);
      return;
    }
    a(this.PED);
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
    r.b(this);
    initView();
    AppMethodBeat.o(28587);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28590);
    r.c(this);
    super.onDestroy();
    AppMethodBeat.o(28590);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28589);
    bh.aZW().b(552, this);
    super.onPause();
    AppMethodBeat.o(28589);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(28594);
    Log.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.PED == null) || (this.PED.PjJ == null))
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
        if ((j < 0) || (j >= this.PED.PjJ.size()))
        {
          Log.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.PED.PjJ.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (com.tencent.mm.plugin.shake.d.b)this.PED.PjJ.get(j);
        if (paramf == null)
        {
          Log.w("MicroMsg.TVInfoUI", "actionList == null");
          AppMethodBeat.o(28594);
          return false;
        }
        if ((k < 0) || (k >= paramf.sXD.size()))
        {
          Log.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramf.sXD.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (b.a)paramf.sXD.get(k);
        if (paramf == null)
        {
          Log.w("MicroMsg.TVInfoUI", "action == null");
          AppMethodBeat.o(28594);
          return false;
        }
        Log.v("MicroMsg.TVInfoUI", "action type:" + paramf.type + ", target:" + paramf.MOW + ", targetDesc:" + paramf.PEQ + ", targetDesc2:" + paramf.PER);
        if (paramf.type == 3)
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf.MOW);
          paramPreference.putExtra("show_bottom", false);
          paramPreference.putExtra("geta8key_scene", 10);
          paramPreference.putExtra("srcUsername", paramf.PER);
          com.tencent.mm.plugin.shake.b.pFn.h(paramPreference, this);
          AppMethodBeat.o(28594);
          return true;
        }
        if (paramf.type != 4) {
          break label644;
        }
        bh.bCz();
        paramPreference = com.tencent.mm.model.c.bzA().JE(paramf.MOW);
        if (paramPreference == null) {
          continue;
        }
        localIntent = new Intent();
        if ((com.tencent.mm.contact.d.rs(paramPreference.field_type)) && (paramPreference.iZC()) && (af.bHf().Mn(paramf.MOW) != null) && (paramf.PEQ.equals("1")))
        {
          localIntent.putExtra("Chat_User", paramf.MOW);
          localIntent.putExtra("finish_direct", true);
          com.tencent.mm.plugin.shake.b.pFn.d(localIntent, this);
          continue;
        }
        localIntent.putExtra("Contact_User", paramf.MOW);
      }
      catch (Exception paramf)
      {
        Log.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        Log.printErrStackTrace("MicroMsg.TVInfoUI", paramf, "", new Object[0]);
        AppMethodBeat.o(28594);
        return false;
      }
      localIntent.putExtra("force_get_contact", true);
      com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      continue;
      label644:
      if (paramf.type == 5)
      {
        paramPreference = new kw();
        paramPreference.hMB.actionCode = 11;
        paramPreference.hMB.result = paramf.MOW;
        paramPreference.hMB.context = this;
        paramPreference.callback = null;
        paramPreference.asyncPublish(Looper.myLooper());
      }
      else if (paramf.type == 6)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("key_product_id", paramf.MOW);
        paramPreference.putExtra("key_product_scene", 9);
        com.tencent.mm.br.c.b(this, "product", ".ui.MallProductUI", paramPreference);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28588);
    super.onResume();
    bh.aZW().a(552, this);
    AppMethodBeat.o(28588);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(28596);
    if (paramp == null)
    {
      Log.w("MicroMsg.TVInfoUI", "scene == null");
      AppMethodBeat.o(28596);
      return;
    }
    if (paramp.getType() == 552)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, R.l.gUm, 0).show();
        AppMethodBeat.o(28596);
        return;
      }
      if (this.PED == null)
      {
        Log.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
        AppMethodBeat.o(28596);
        return;
      }
      paramString = (com.tencent.mm.plugin.shake.c.a.c)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (paramString = (ctg)c.c.b(paramString.rr.otC); paramString == null; paramString = null)
      {
        Log.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
        AppMethodBeat.o(28596);
        return;
      }
      if (paramString.aazh != null)
      {
        Log.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + paramString.aazh);
        paramString = com.tencent.mm.plugin.shake.d.d.aVU(paramString.aazh);
        if ((this.PED != null) && (this.PED.field_xml != null) && (paramString != null) && (paramString.field_xml != null) && (!this.PED.field_xml.equals(paramString.field_xml)))
        {
          this.PED = paramString;
          a(this.PED);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI
 * JD-Core Version:    0.7.0.1
 */