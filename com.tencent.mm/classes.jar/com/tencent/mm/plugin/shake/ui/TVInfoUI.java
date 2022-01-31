package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.shake.e.a.a;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class TVInfoUI
  extends MMPreference
  implements com.tencent.mm.ah.f, x.a
{
  private long bIt;
  protected ProgressDialog dnm = null;
  protected com.tencent.mm.ui.base.preference.f dnn;
  private TextView eXr;
  private ImageView iux;
  private boolean nKs = false;
  private boolean nMK = false;
  private String odD = "";
  private TextView odE;
  private c.a odF;
  private com.tencent.mm.plugin.shake.e.b odG;
  
  private void a(c.a parama)
  {
    if (parama == null)
    {
      y.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
      finish();
      return;
    }
    this.eXr.setText(parama.field_title);
    if (bk.bl(parama.field_topic)) {
      this.odE.setVisibility(8);
    }
    for (;;)
    {
      this.iux = ((ImageView)findViewById(R.h.tvinfo_header_img));
      if (!bk.bl(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(R.h.tvinfo_detail_play_img);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new TVInfoUI.1(this, parama));
        this.iux.setOnClickListener(new TVInfoUI.2(this, parama));
      }
      addIconOptionMenu(0, R.g.mm_title_btn_menu, new TVInfoUI.3(this));
      if ((!bk.bl(parama.field_id)) && (!this.nMK) && (!getIntent().getBooleanExtra("key_TV_come_from_shake", false)))
      {
        int i = getIntent().getIntExtra("key_TV_getProductInfoScene", 0);
        y.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[] { parama.field_id, Integer.valueOf(i) });
        au.Dk().a(new com.tencent.mm.plugin.shake.d.a.b(parama.field_id, i), 0);
        this.nMK = true;
      }
      this.iux.setVisibility(0);
      setBackBtn(new TVInfoUI.4(this));
      y.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
      ai.d(new TVInfoUI.5(this, parama));
      return;
      this.odE.setText(parama.field_topic);
    }
  }
  
  private void bxK()
  {
    this.bIt = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0L);
    if ((this.bIt > 0L) && (au.DK()))
    {
      au.Hx();
      bi localbi = com.tencent.mm.model.c.Fy().fd(this.bIt);
      if (localbi.field_msgId > 0L)
      {
        localbi.ed(this.odG.UO());
        au.Hx();
        com.tencent.mm.model.c.Fy().a(this.bIt, localbi);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    y.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.odF == null) || (this.odF.nPR == null))
    {
      y.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
      return false;
    }
    Intent localIntent;
    try
    {
      int i = Integer.valueOf(paramPreference.mKey).intValue();
      int j = i / 100;
      int k = i % 100;
      y.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if ((j < 0) || (j >= this.odF.nPR.size()))
      {
        y.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.odF.nPR.size()) });
        return false;
      }
      paramf = (com.tencent.mm.plugin.shake.e.a)this.odF.nPR.get(j);
      if (paramf == null)
      {
        y.w("MicroMsg.TVInfoUI", "actionList == null");
        return false;
      }
      if ((k < 0) || (k >= paramf.eAm.size()))
      {
        y.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramf.eAm.size()) });
        return false;
      }
      paramf = (a.a)paramf.eAm.get(k);
      if (paramf == null)
      {
        y.w("MicroMsg.TVInfoUI", "action == null");
        return false;
      }
      y.v("MicroMsg.TVInfoUI", "action type:" + paramf.type + ", target:" + paramf.odP + ", targetDesc:" + paramf.odR + ", targetDesc2:" + paramf.odS);
      if (paramf.type == 3)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf.odP);
        paramPreference.putExtra("show_bottom", false);
        paramPreference.putExtra("geta8key_scene", 10);
        paramPreference.putExtra("srcUsername", paramf.odS);
        com.tencent.mm.plugin.shake.a.eUR.j(paramPreference, this);
      }
      else if (paramf.type == 4)
      {
        au.Hx();
        paramPreference = com.tencent.mm.model.c.Fw().abl(paramf.odP);
        if (paramPreference == null) {
          break label707;
        }
        localIntent = new Intent();
        if ((com.tencent.mm.n.a.gR(paramPreference.field_type)) && (paramPreference.cua()))
        {
          z.My().kQ(paramf.odP);
          if (paramf.odR.equals("1"))
          {
            localIntent.putExtra("Chat_User", paramf.odP);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.eUR.e(localIntent, this);
          }
        }
      }
    }
    catch (Exception paramf)
    {
      y.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
      y.printErrStackTrace("MicroMsg.TVInfoUI", paramf, "", new Object[0]);
      return false;
    }
    localIntent.putExtra("Contact_User", paramf.odP);
    localIntent.putExtra("force_get_contact", true);
    d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    break label707;
    if (paramf.type == 5)
    {
      paramPreference = new hc();
      paramPreference.bOW.actionCode = 11;
      paramPreference.bOW.result = paramf.odP;
      paramPreference.bOW.context = this;
      paramPreference.bFJ = null;
      com.tencent.mm.sdk.b.a.udP.a(paramPreference, Looper.myLooper());
    }
    else if (paramf.type == 6)
    {
      paramPreference = new Intent();
      paramPreference.putExtra("key_product_id", paramf.odP);
      paramPreference.putExtra("key_product_scene", 9);
      d.b(this, "product", ".ui.MallProductUI", paramPreference);
    }
    label707:
    return true;
  }
  
  public final int axE()
  {
    return R.i.tv_info_header_view;
  }
  
  protected final int getLayoutId()
  {
    return R.i.tv_info;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.scan_tv_detail_title);
    this.dnn = this.vdd;
    this.eXr = ((TextView)findViewById(R.h.tvinfo_title));
    this.odE = ((TextView)findViewById(R.h.tvinfo_topic_tv));
    String str2 = getIntent().getStringExtra("key_TV_xml");
    String str1 = str2;
    if (bk.bl(str2))
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_TV_xml_bytes");
      str1 = str2;
      if (arrayOfByte != null) {
        str1 = new String(arrayOfByte);
      }
    }
    y.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[] { str1 });
    this.odF = com.tencent.mm.plugin.shake.e.c.MD(str1);
    if (this.odF == null)
    {
      y.e("MicroMsg.TVInfoUI", "initView(), tv == null");
      finish();
      return;
    }
    a(this.odF);
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if (paramString != null)
    {
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.TVInfoUI", "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]", new Object[] { paramString, Boolean.valueOf(bool) });
        try
        {
          ai.d(new TVInfoUI.7(this, paramString, paramBitmap));
          return;
        }
        catch (Exception paramString)
        {
          y.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[] { paramString.getLocalizedMessage() });
          y.printErrStackTrace("MicroMsg.TVInfoUI", paramString, "", new Object[0]);
          return;
        }
      }
    }
    y.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    x.b(this);
    initView();
  }
  
  protected void onDestroy()
  {
    x.c(this);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    au.Dk().b(552, this);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    au.Dk().a(552, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (paramm == null) {
      y.w("MicroMsg.TVInfoUI", "scene == null");
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramm.getType() != 552);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          y.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          Toast.makeText(this, R.l.scan_tv_get_tvinfo_fail_tips, 0).show();
          return;
        }
        if (this.odF == null)
        {
          y.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
          return;
        }
        paramString = (com.tencent.mm.plugin.shake.d.a.b)paramm;
        if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
        for (paramString = (akz)paramString.dmK.ecF.ecN; paramString == null; paramString = null)
        {
          y.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
          return;
        }
      } while (paramString.sDW == null);
      y.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + paramString.sDW);
      paramString = com.tencent.mm.plugin.shake.e.c.MD(paramString.sDW);
    } while ((this.odF == null) || (this.odF.field_xml == null) || (paramString == null) || (paramString.field_xml == null) || (this.odF.field_xml.equals(paramString.field_xml)));
    this.odF = paramString;
    a(this.odF);
  }
  
  public final int xj()
  {
    return R.o.tv_info_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI
 * JD-Core Version:    0.7.0.1
 */