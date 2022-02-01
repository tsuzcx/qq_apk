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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.e.a.a;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;

public class TVInfoUI
  extends MMPreference
  implements g, u.a
{
  protected ProgressDialog fts = null;
  private long msgId;
  private ImageView odV;
  protected f screen;
  private TextView titleTv;
  private String xBQ = "";
  private TextView xBR;
  private c.a xBS;
  private boolean xBT = false;
  private com.tencent.mm.plugin.shake.e.b xBU;
  private boolean xdz = false;
  
  private void a(final c.a parama)
  {
    AppMethodBeat.i(28592);
    if (parama == null)
    {
      ac.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(28592);
      return;
    }
    this.titleTv.setText(parama.field_title);
    if (bs.isNullOrNil(parama.field_topic)) {
      this.xBR.setVisibility(8);
    }
    for (;;)
    {
      this.odV = ((ImageView)findViewById(2131306165));
      if (!bs.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(2131306164);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28579);
            com.tencent.mm.plugin.report.service.h.wUl.f(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            AppMethodBeat.o(28579);
          }
        });
        this.odV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28580);
            com.tencent.mm.plugin.report.service.h.wUl.f(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            AppMethodBeat.o(28580);
          }
        });
      }
      addIconOptionMenu(0, 2131690603, new TVInfoUI.3(this));
      if ((!bs.isNullOrNil(parama.field_id)) && (!this.xBT) && (!getIntent().getBooleanExtra("key_TV_come_from_shake", false)))
      {
        int i = getIntent().getIntExtra("key_TV_getProductInfoScene", 0);
        ac.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[] { parama.field_id, Integer.valueOf(i) });
        az.agi().a(new com.tencent.mm.plugin.shake.d.a.b(parama.field_id, i), 0);
        this.xBT = true;
      }
      this.odV.setVisibility(0);
      setBackBtn(new TVInfoUI.4(this));
      ac.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
      ap.f(new Runnable()
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
      this.xBR.setText(parama.field_topic);
    }
  }
  
  private void dAj()
  {
    AppMethodBeat.i(28593);
    this.msgId = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (az.agM()))
    {
      az.ayM();
      bo localbo = com.tencent.mm.model.c.awD().vP(this.msgId);
      if (localbo.field_msgId > 0L)
      {
        localbo.rf(this.xBU.aNl());
        az.ayM();
        com.tencent.mm.model.c.awD().a(this.msgId, localbo);
      }
    }
    AppMethodBeat.o(28593);
  }
  
  public int getHeaderResourceId()
  {
    return 2131495810;
  }
  
  public int getLayoutId()
  {
    return 2131495809;
  }
  
  public int getResourceId()
  {
    return 2131951752;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28591);
    setMMTitle(2131762884);
    this.screen = getPreferenceScreen();
    this.titleTv = ((TextView)findViewById(2131306166));
    this.xBR = ((TextView)findViewById(2131306167));
    String str2 = getIntent().getStringExtra("key_TV_xml");
    String str1 = str2;
    if (bs.isNullOrNil(str2))
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_TV_xml_bytes");
      str1 = str2;
      if (arrayOfByte != null) {
        str1 = new String(arrayOfByte);
      }
    }
    ac.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[] { str1 });
    this.xBS = com.tencent.mm.plugin.shake.e.c.asu(str1);
    if (this.xBS == null)
    {
      ac.e("MicroMsg.TVInfoUI", "initView(), tv == null");
      finish();
      AppMethodBeat.o(28591);
      return;
    }
    a(this.xBS);
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
        ac.d("MicroMsg.TVInfoUI", "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]", new Object[] { paramString, Boolean.valueOf(bool) });
        try
        {
          ap.f(new Runnable()
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
          ac.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[] { paramString.getLocalizedMessage() });
          ac.printErrStackTrace("MicroMsg.TVInfoUI", paramString, "", new Object[0]);
          AppMethodBeat.o(28595);
          return;
        }
      }
    }
    ac.e("MicroMsg.TVInfoUI", "onUpdateEnable pic, url  is null ");
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
    az.agi().b(552, this);
    super.onPause();
    AppMethodBeat.o(28589);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(28594);
    ac.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.xBS == null) || (this.xBS.xml == null))
    {
      ac.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
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
        ac.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.xBS.xml.size()))
        {
          ac.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.xBS.xml.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (com.tencent.mm.plugin.shake.e.a)this.xBS.xml.get(j);
        if (paramf == null)
        {
          ac.w("MicroMsg.TVInfoUI", "actionList == null");
          AppMethodBeat.o(28594);
          return false;
        }
        if ((k < 0) || (k >= paramf.lio.size()))
        {
          ac.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramf.lio.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (a.a)paramf.lio.get(k);
        if (paramf == null)
        {
          ac.w("MicroMsg.TVInfoUI", "action == null");
          AppMethodBeat.o(28594);
          return false;
        }
        ac.v("MicroMsg.TVInfoUI", "action type:" + paramf.type + ", target:" + paramf.cyy + ", targetDesc:" + paramf.xCe + ", targetDesc2:" + paramf.xCf);
        if (paramf.type == 3)
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf.cyy);
          paramPreference.putExtra("show_bottom", false);
          paramPreference.putExtra("geta8key_scene", 10);
          paramPreference.putExtra("srcUsername", paramf.xCf);
          com.tencent.mm.plugin.shake.a.iyx.i(paramPreference, this);
          AppMethodBeat.o(28594);
          return true;
        }
        if (paramf.type != 4) {
          break label642;
        }
        az.ayM();
        paramPreference = com.tencent.mm.model.c.awB().aNt(paramf.cyy);
        if (paramPreference == null) {
          continue;
        }
        localIntent = new Intent();
        if ((com.tencent.mm.n.b.ln(paramPreference.field_type)) && (paramPreference.fad()))
        {
          af.aCW().AE(paramf.cyy);
          if (paramf.xCe.equals("1"))
          {
            localIntent.putExtra("Chat_User", paramf.cyy);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.iyx.d(localIntent, this);
            continue;
          }
        }
        localIntent.putExtra("Contact_User", paramf.cyy);
      }
      catch (Exception paramf)
      {
        ac.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ac.printErrStackTrace("MicroMsg.TVInfoUI", paramf, "", new Object[0]);
        AppMethodBeat.o(28594);
        return false;
      }
      localIntent.putExtra("force_get_contact", true);
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      continue;
      label642:
      if (paramf.type == 5)
      {
        paramPreference = new ig();
        paramPreference.dju.actionCode = 11;
        paramPreference.dju.result = paramf.cyy;
        paramPreference.dju.context = this;
        paramPreference.callback = null;
        com.tencent.mm.sdk.b.a.GpY.a(paramPreference, Looper.myLooper());
      }
      else if (paramf.type == 6)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("key_product_id", paramf.cyy);
        paramPreference.putExtra("key_product_scene", 9);
        d.b(this, "product", ".ui.MallProductUI", paramPreference);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28588);
    super.onResume();
    az.agi().a(552, this);
    AppMethodBeat.o(28588);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28596);
    if (paramn == null)
    {
      ac.w("MicroMsg.TVInfoUI", "scene == null");
      AppMethodBeat.o(28596);
      return;
    }
    if (paramn.getType() == 552)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, 2131762885, 0).show();
        AppMethodBeat.o(28596);
        return;
      }
      if (this.xBS == null)
      {
        ac.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
        AppMethodBeat.o(28596);
        return;
      }
      paramString = (com.tencent.mm.plugin.shake.d.a.b)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (paramString = (bet)paramString.rr.hvs.hvw; paramString == null; paramString = null)
      {
        ac.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
        AppMethodBeat.o(28596);
        return;
      }
      if (paramString.EUm != null)
      {
        ac.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + paramString.EUm);
        paramString = com.tencent.mm.plugin.shake.e.c.asu(paramString.EUm);
        if ((this.xBS != null) && (this.xBS.field_xml != null) && (paramString != null) && (paramString.field_xml != null) && (!this.xBS.field_xml.equals(paramString.field_xml)))
        {
          this.xBS = paramString;
          a(this.xBS);
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