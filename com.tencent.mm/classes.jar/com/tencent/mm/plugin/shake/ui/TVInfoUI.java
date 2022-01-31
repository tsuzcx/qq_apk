package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.shake.e.a.a;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class TVInfoUI
  extends MMPreference
  implements com.tencent.mm.ai.f, x.a
{
  private long cpO;
  protected ProgressDialog eeN = null;
  private ImageView kvC;
  private boolean qAs = false;
  private String qRK = "";
  private TextView qRL;
  private c.a qRM;
  private com.tencent.mm.plugin.shake.e.b qRN;
  private boolean qxU = false;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(24923);
    if (parama == null)
    {
      ab.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(24923);
      return;
    }
    this.titleTv.setText(parama.field_title);
    if (bo.isNullOrNil(parama.field_topic)) {
      this.qRL.setVisibility(8);
    }
    for (;;)
    {
      this.kvC = ((ImageView)findViewById(2131828648));
      if (!bo.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(2131828649);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new TVInfoUI.1(this, parama));
        this.kvC.setOnClickListener(new TVInfoUI.2(this, parama));
      }
      addIconOptionMenu(0, 2130839668, new TVInfoUI.3(this));
      if ((!bo.isNullOrNil(parama.field_id)) && (!this.qAs) && (!getIntent().getBooleanExtra("key_TV_come_from_shake", false)))
      {
        int i = getIntent().getIntExtra("key_TV_getProductInfoScene", 0);
        ab.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[] { parama.field_id, Integer.valueOf(i) });
        aw.Rc().a(new com.tencent.mm.plugin.shake.d.a.b(parama.field_id, i), 0);
        this.qAs = true;
      }
      this.kvC.setVisibility(0);
      setBackBtn(new TVInfoUI.4(this));
      ab.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
      al.d(new TVInfoUI.5(this, parama));
      AppMethodBeat.o(24923);
      return;
      this.qRL.setText(parama.field_topic);
    }
  }
  
  private void ciL()
  {
    AppMethodBeat.i(24924);
    this.cpO = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0L);
    if ((this.cpO > 0L) && (aw.RG()))
    {
      aw.aaz();
      bi localbi = com.tencent.mm.model.c.YC().kB(this.cpO);
      if (localbi.field_msgId > 0L)
      {
        localbi.kk(this.qRN.aon());
        aw.aaz();
        com.tencent.mm.model.c.YC().a(this.cpO, localbi);
      }
    }
    AppMethodBeat.o(24924);
  }
  
  public int getHeaderResourceId()
  {
    return 2130971045;
  }
  
  public int getLayoutId()
  {
    return 2130971044;
  }
  
  public int getResourceId()
  {
    return 2131165308;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24922);
    setMMTitle(2131302948);
    this.screen = getPreferenceScreen();
    this.titleTv = ((TextView)findViewById(2131828651));
    this.qRL = ((TextView)findViewById(2131828650));
    String str2 = getIntent().getStringExtra("key_TV_xml");
    String str1 = str2;
    if (bo.isNullOrNil(str2))
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_TV_xml_bytes");
      str1 = str2;
      if (arrayOfByte != null) {
        str1 = new String(arrayOfByte);
      }
    }
    ab.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[] { str1 });
    this.qRM = com.tencent.mm.plugin.shake.e.c.Zl(str1);
    if (this.qRM == null)
    {
      ab.e("MicroMsg.TVInfoUI", "initView(), tv == null");
      finish();
      AppMethodBeat.o(24922);
      return;
    }
    a(this.qRM);
    AppMethodBeat.o(24922);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(24926);
    if (paramString != null)
    {
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("MicroMsg.TVInfoUI", "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]", new Object[] { paramString, Boolean.valueOf(bool) });
        try
        {
          al.d(new TVInfoUI.7(this, paramString, paramBitmap));
          AppMethodBeat.o(24926);
          return;
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[] { paramString.getLocalizedMessage() });
          ab.printErrStackTrace("MicroMsg.TVInfoUI", paramString, "", new Object[0]);
          AppMethodBeat.o(24926);
          return;
        }
      }
    }
    ab.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
    AppMethodBeat.o(24926);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24918);
    super.onCreate(paramBundle);
    x.b(this);
    initView();
    AppMethodBeat.o(24918);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24921);
    x.c(this);
    super.onDestroy();
    AppMethodBeat.o(24921);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24920);
    aw.Rc().b(552, this);
    super.onPause();
    AppMethodBeat.o(24920);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24925);
    ab.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.qRM == null) || (this.qRM.qDK == null))
    {
      ab.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
      AppMethodBeat.o(24925);
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
        ab.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.qRM.qDK.size()))
        {
          ab.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.qRM.qDK.size()) });
          AppMethodBeat.o(24925);
          return false;
        }
        paramf = (com.tencent.mm.plugin.shake.e.a)this.qRM.qDK.get(j);
        if (paramf == null)
        {
          ab.w("MicroMsg.TVInfoUI", "actionList == null");
          AppMethodBeat.o(24925);
          return false;
        }
        if ((k < 0) || (k >= paramf.fQb.size()))
        {
          ab.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramf.fQb.size()) });
          AppMethodBeat.o(24925);
          return false;
        }
        paramf = (a.a)paramf.fQb.get(k);
        if (paramf == null)
        {
          ab.w("MicroMsg.TVInfoUI", "action == null");
          AppMethodBeat.o(24925);
          return false;
        }
        ab.v("MicroMsg.TVInfoUI", "action type:" + paramf.type + ", target:" + paramf.qRW + ", targetDesc:" + paramf.qRY + ", targetDesc2:" + paramf.qRZ);
        if (paramf.type == 3)
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf.qRW);
          paramPreference.putExtra("show_bottom", false);
          paramPreference.putExtra("geta8key_scene", 10);
          paramPreference.putExtra("srcUsername", paramf.qRZ);
          com.tencent.mm.plugin.shake.a.gmO.i(paramPreference, this);
          AppMethodBeat.o(24925);
          return true;
        }
        if (paramf.type != 4) {
          break label642;
        }
        aw.aaz();
        paramPreference = com.tencent.mm.model.c.YA().arw(paramf.qRW);
        if (paramPreference == null) {
          continue;
        }
        localIntent = new Intent();
        if ((com.tencent.mm.n.a.je(paramPreference.field_type)) && (paramPreference.dwz()))
        {
          z.afi().rK(paramf.qRW);
          if (paramf.qRY.equals("1"))
          {
            localIntent.putExtra("Chat_User", paramf.qRW);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.gmO.d(localIntent, this);
            continue;
          }
        }
        localIntent.putExtra("Contact_User", paramf.qRW);
      }
      catch (Exception paramf)
      {
        ab.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ab.printErrStackTrace("MicroMsg.TVInfoUI", paramf, "", new Object[0]);
        AppMethodBeat.o(24925);
        return false;
      }
      localIntent.putExtra("force_get_contact", true);
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      continue;
      label642:
      if (paramf.type == 5)
      {
        paramPreference = new hf();
        paramPreference.cwn.actionCode = 11;
        paramPreference.cwn.result = paramf.qRW;
        paramPreference.cwn.context = this;
        paramPreference.callback = null;
        com.tencent.mm.sdk.b.a.ymk.a(paramPreference, Looper.myLooper());
      }
      else if (paramf.type == 6)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("key_product_id", paramf.qRW);
        paramPreference.putExtra("key_product_scene", 9);
        d.b(this, "product", ".ui.MallProductUI", paramPreference);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24919);
    super.onResume();
    aw.Rc().a(552, this);
    AppMethodBeat.o(24919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(24927);
    if (paramm == null)
    {
      ab.w("MicroMsg.TVInfoUI", "scene == null");
      AppMethodBeat.o(24927);
      return;
    }
    if (paramm.getType() == 552)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, 2131302949, 0).show();
        AppMethodBeat.o(24927);
        return;
      }
      if (this.qRM == null)
      {
        ab.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
        AppMethodBeat.o(24927);
        return;
      }
      paramString = (com.tencent.mm.plugin.shake.d.a.b)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (aqm)paramString.rr.fsW.fta; paramString == null; paramString = null)
      {
        ab.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
        AppMethodBeat.o(24927);
        return;
      }
      if (paramString.wzV != null)
      {
        ab.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + paramString.wzV);
        paramString = com.tencent.mm.plugin.shake.e.c.Zl(paramString.wzV);
        if ((this.qRM != null) && (this.qRM.field_xml != null) && (paramString != null) && (paramString.field_xml != null) && (!this.qRM.field_xml.equals(paramString.field_xml)))
        {
          this.qRM = paramString;
          a(this.qRM);
        }
      }
    }
    AppMethodBeat.o(24927);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI
 * JD-Core Version:    0.7.0.1
 */