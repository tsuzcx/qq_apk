package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private String bVI;
  private ad dnp;
  private String fGK = "";
  private int fhj = 9;
  private ArrayList<String> mVS;
  private String mWy;
  private MMTagPanel mZk;
  private bv nlZ;
  private TextView vKA;
  private View vKB;
  private View vKC;
  private TextView vKK;
  private EditText vMB;
  private int vMC;
  private String vMD = "";
  private TextView vME = null;
  private EditText vMF = null;
  private TextView vMG = null;
  private String vMH = "";
  private boolean vMI = false;
  private ModRemarkNameUI.a vMJ = new ModRemarkNameUI.a(this, (byte)0);
  private View vMK;
  
  protected final int getLayoutId()
  {
    return R.i.mod_remark_name;
  }
  
  protected final void initView()
  {
    this.bVI = getIntent().getStringExtra("Contact_User");
    if ((this.bVI != null) && (this.bVI.length() > 0))
    {
      au.Hx();
      this.dnp = com.tencent.mm.model.c.Fw().abl(this.bVI);
      au.Hx();
      this.nlZ = com.tencent.mm.model.c.Fx().Id(this.bVI);
      if ((this.dnp == null) || (ah.bl(this.dnp.field_username)))
      {
        this.dnp = new ad(this.bVI);
        this.dnp.dk(ah.pm(this.vMD));
        this.dnp.df(ah.pm(this.fGK));
      }
    }
    this.vMB = ((EditText)findViewById(R.h.contact_info_mod_remark_name_et));
    Object localObject1 = new ModRemarkNameUI.1(this);
    Object localObject2 = new h.a();
    ((h.a)localObject2).smK = ((MMEditText.b)localObject1);
    this.vMB.addTextChangedListener((TextWatcher)localObject2);
    com.tencent.mm.ui.tools.a.c.d(this.vMB).Ig(100).a(null);
    if ((this.dnp != null) && (this.vMC != 3))
    {
      if (this.vMC == 4)
      {
        this.vMB.setText(j.a(this, ah.pm(this.vMD), this.vMB.getTextSize()));
        this.vMB.setSelection(this.vMB.getText().length());
      }
    }
    else
    {
      if (this.vMC != 0) {
        break label1106;
      }
      setMMTitle(R.l.contact_info_mod_remarkname);
      localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(this.dnp.field_username);
      if ((localObject1 != null) && (!ah.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx().equals(this.vMB.getText()))) {
        break label976;
      }
      label320:
      addTextOptionMenu(0, getString(R.l.app_save), new ModRemarkNameUI.2(this));
      if ((this.vMB == null) || (this.vMB.getText().toString().trim().length() <= 0)) {
        break label1239;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          ModRemarkNameUI.this.finish();
          return true;
        }
      });
      this.vME = ((TextView)findViewById(R.h.contact_info_remark_desc_tv));
      this.vMF = ((EditText)findViewById(R.h.contact_info_mod_remark_desc_et));
      this.vMG = ((TextView)findViewById(R.h.wordcount));
      this.vKC = findViewById(R.h.contact_info_mod_remark_desc_container);
      com.tencent.mm.ui.tools.a.c.d(this.vMF).Ig(800).a(null);
      this.vMG.setText(com.tencent.mm.ui.tools.f.bi(800, this.vMF.getEditableText().toString()));
      this.vMF.append(j.a(this, ah.pm(this.vMH), this.vMF.getTextSize()));
      this.vME.append(j.a(this, ah.pm(this.vMH), this.vME.getTextSize()));
      if (this.nlZ != null)
      {
        this.vMF.setText(j.a(this, ah.pm(this.nlZ.field_conDescription), this.vMF.getTextSize()));
        this.vME.setText(j.a(this, ah.pm(this.nlZ.field_conDescription), this.vMF.getTextSize()));
      }
      this.vMF.addTextChangedListener(new ModRemarkNameUI.b(this, (byte)0));
      this.vME.setOnClickListener(new ModRemarkNameUI.4(this));
      return;
      if (!ah.bl(this.dnp.field_conRemark))
      {
        if ((this.vMC == 0) && (!ah.bl(this.fGK)))
        {
          this.vMB.setText(j.a(this, this.fGK, this.vMB.getTextSize()));
          break;
        }
        this.vMB.setText(j.a(this, ah.pm(this.dnp.field_conRemark), this.vMB.getTextSize()));
        break;
      }
      if (!ah.bl(this.fGK))
      {
        this.vMB.setText(j.a(this, ah.pm(this.fGK), this.vMB.getTextSize()));
        break;
      }
      if (!ah.bl(this.dnp.field_nickname))
      {
        if ((this.vMC == 0) && (!ah.bl(this.vMD)) && (!com.tencent.mm.n.a.gR(this.dnp.field_type)))
        {
          this.vMB.setText(j.a(this, ah.pm(this.vMD), this.vMB.getTextSize()));
          break;
        }
        this.vMB.setText(j.a(this, ah.pm(this.dnp.field_nickname), this.vMB.getTextSize()));
        break;
      }
      if (!ah.bl(this.vMD))
      {
        this.vMB.setText(j.a(this, ah.pm(this.vMD), this.vMB.getTextSize()));
        break;
      }
      localObject1 = this.dnp.field_nickname;
      if ((ah.bl((String)localObject1)) || (((String)localObject1).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label964;
        }
        this.vMB.setText(j.a(this, ah.pm(this.dnp.Bq()), this.vMB.getTextSize()));
        break;
      }
      label964:
      this.vMB.setText("");
      break;
      label976:
      this.vKA = ((TextView)findViewById(R.h.mode_remark_mobile_name));
      this.vKB = findViewById(R.h.mod_remark_mobile_name_area);
      this.vKB.setVisibility(0);
      this.vKA.setText(ah.pm(getString(R.l.contact_info_set_reamrk_mobile_name, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx() })));
      localObject2 = new k(getString(R.l.write_contact_remark));
      ((k)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx()), 0, ((k)localObject2).length(), 17);
      this.vKA.append(" ");
      this.vKA.append((CharSequence)localObject2);
      this.vKA.setMovementMethod(LinkMovementMethod.getInstance());
      break label320;
      label1106:
      if (this.vMC == 3)
      {
        setMMTitle(R.l.tag_rename);
        this.vMB.setHint("");
        if (!ah.bl(this.vMD)) {
          this.vMB.setText(this.vMD);
        }
        localObject1 = (TextView)findViewById(R.h.contact_info_mod_remark_name_hint_tv);
        ((TextView)localObject1).setText(R.l.set_tag_name);
        ((TextView)localObject1).setVisibility(0);
        findViewById(R.h.mod_remark_name_desc).setVisibility(8);
        break label320;
      }
      if (this.vMC != 4) {
        break label320;
      }
      setMMTitle(R.l.room_my_displayname);
      this.vMB.setHint("");
      localObject1 = (TextView)findViewById(R.h.contact_info_mod_remark_name_hint_tv);
      ((TextView)localObject1).setText(R.l.room_self_nick_name_tip);
      ((TextView)localObject1).setVisibility(0);
      break label320;
      label1239:
      enableOptionMenu(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    super.onCreate(paramBundle);
    this.fhj = getIntent().getIntExtra("Contact_Scene", 9);
    this.vMC = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.vMD = ah.pm(getIntent().getStringExtra("Contact_Nick"));
    this.fGK = ah.pm(getIntent().getStringExtra("Contact_RemarkName"));
    this.vMI = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    this.vMK = findViewById(R.h.contact_info_mod_label_con);
    int i;
    if (this.vMC != 0)
    {
      this.vMK.setVisibility(8);
      this.mZk = ((MMTagPanel)findViewById(R.h.contact_info_mod_label_et));
      this.mZk.setPanelClickable(false);
      this.vKK = ((TextView)findViewById(R.h.contact_info_label_tv));
      this.vKK.setText(R.l.mod_label_hint);
      this.mZk.setOnClickListener(this.vMJ);
      this.vKK.setOnClickListener(this.vMJ);
      if ((this.dnp == null) || (!ad.aaU(this.dnp.field_username))) {
        break label231;
      }
      i = 1;
      label208:
      if ((i != 0) && (this.vMB != null)) {
        break label236;
      }
    }
    for (;;)
    {
      return;
      this.vMK.setVisibility(0);
      break;
      label231:
      i = 0;
      break label208;
      label236:
      paramBundle = (ViewGroup)this.vMB.getParent();
      int k = paramBundle.getChildCount();
      i = j;
      while (i < k)
      {
        View localView = paramBundle.getChildAt(i);
        j = localView.getId();
        if ((j != R.h.contact_info_mod_remark_name_hint_tv) && (j != R.h.contact_info_mod_remark_name_et)) {
          localView.setVisibility(8);
        }
        i += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    au.Hx();
    this.nlZ = com.tencent.mm.model.c.Fx().Id(this.bVI);
    if (this.nlZ != null)
    {
      this.mWy = this.nlZ.field_contactLabels;
      this.mVS = ((ArrayList)com.tencent.mm.plugin.label.a.a.bdA().Gm(this.mWy));
    }
    if (!ah.bl(this.mWy))
    {
      this.mZk.setVisibility(0);
      this.vKK.setVisibility(8);
      if ((this.mVS != null) && (!this.mVS.isEmpty())) {
        this.mZk.a(this.mVS, this.mVS);
      }
      return;
    }
    this.mZk.setVisibility(8);
    this.vKK.setVisibility(0);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        y.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
        Toast.makeText(this, getString(R.l.room_save_to_group_card_fail, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      finish();
    }
  }
  
  private final class c
    extends ClickableSpan
  {
    public String fGK;
    
    public c(String paramString)
    {
      this.fGK = paramString;
    }
    
    public final void onClick(View paramView)
    {
      ModRemarkNameUI.a(ModRemarkNameUI.this).setText(j.a(ModRemarkNameUI.this, ah.pm(this.fGK), ModRemarkNameUI.a(ModRemarkNameUI.this).getTextSize()));
      ModRemarkNameUI.a(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.a(ModRemarkNameUI.this).getText().length());
      ModRemarkNameUI.l(ModRemarkNameUI.this).setVisibility(8);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(ModRemarkNameUI.this.getResources().getColor(R.e.blue_text_color));
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI
 * JD-Core Version:    0.7.0.1
 */