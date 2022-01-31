package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private String aVs;
  private String cCJ;
  private ad dnp;
  private ProgressDialog ecf;
  private String exA;
  private int fhj;
  private String lCb;
  private MMTagPanel mZk;
  private List<String> mZl;
  private m.b mZm = new ContactRemarkInfoModUI.1(this);
  private String siS;
  private String username;
  private TextView vKA;
  private View vKB;
  private View vKC;
  private String vKD;
  private boolean vKE = false;
  private boolean vKF = false;
  private boolean vKG = false;
  private boolean vKH = false;
  private boolean vKI = false;
  private ContactRemarkInfoModUI.a vKJ = new ContactRemarkInfoModUI.a(this, (byte)0);
  private TextView vKK;
  private ScrollView vKL;
  private ProfileEditPhoneNumberView vKM;
  private String vKN;
  private String vKO;
  private String vKP;
  boolean vKQ = true;
  boolean vKR = false;
  private boolean vKS = false;
  private MMClearEditText vKr;
  private TextView vKs;
  private MMEditText vKt;
  private TextView vKu;
  private TextView vKv;
  private TextView vKw;
  private TextView vKx;
  private ImageView vKy;
  private ImageView vKz;
  
  private void B(boolean paramBoolean, int paramInt)
  {
    if (this.vKG)
    {
      this.vKu.setVisibility(8);
      if ((paramBoolean) && (ah.bl(this.cCJ)))
      {
        this.vKv.setVisibility(0);
        this.vKC.setVisibility(8);
      }
      for (;;)
      {
        this.vKr.setVisibility(0);
        return;
        if (paramInt == R.h.contact_info_remark_desc_tv)
        {
          this.vKv.setVisibility(8);
          this.vKC.setVisibility(0);
        }
      }
    }
    this.vKu.setVisibility(0);
    this.vKv.setVisibility(0);
    this.vKr.setVisibility(8);
    this.vKC.setVisibility(8);
  }
  
  private void adR(String paramString)
  {
    if (ah.bl(paramString)) {}
    do
    {
      do
      {
        return;
        paramString = new com.tencent.mm.vfs.b(paramString);
      } while (!paramString.exists());
      if (paramString.length() > 204800L)
      {
        com.tencent.mm.ui.base.h.b(this, getString(R.l.contact_info_change_remarkimage_error_too_big), null, true);
        return;
      }
      float f = com.tencent.mm.cb.a.getDensity(this);
      paramString = BackwardSupportUtil.b.e(this.vKD, f);
    } while (paramString == null);
    this.vKw.setVisibility(8);
    this.vKz.setVisibility(8);
    this.vKy.setVisibility(0);
    this.vKy.setImageBitmap(paramString);
    this.vKE = true;
  }
  
  private String adS(String paramString)
  {
    if (!e.bK(paramString)) {
      paramString = null;
    }
    int i;
    Object localObject;
    do
    {
      do
      {
        return paramString;
        i = BackwardSupportUtil.ExifHelper.YS(paramString);
        localObject = new StringBuilder();
        com.tencent.mm.bb.c.PO();
        localObject = com.tencent.mm.bb.c.mK(this.username) + ".tmp";
        if (!com.tencent.mm.sdk.platformtools.c.a(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
        {
          y.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
          return null;
        }
        paramString = (String)localObject;
      } while (i == 0);
      paramString = (String)localObject;
    } while (com.tencent.mm.sdk.platformtools.c.a((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject));
    y.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
    return null;
  }
  
  private void bsQ()
  {
    au.Hx();
    this.dnp = com.tencent.mm.model.c.Fw().abl(this.username);
    this.lCb = this.dnp.field_contactLabelIds;
    this.mZl = com.tencent.mm.plugin.label.a.a.bdA().Gn(this.lCb);
    if (!ah.bl(this.lCb))
    {
      this.mZk.setVisibility(0);
      this.vKK.setVisibility(8);
      this.mZk.a(this.mZl, this.mZl);
      return;
    }
    this.mZk.setVisibility(8);
    this.vKK.setVisibility(0);
  }
  
  private void cHt()
  {
    this.vKs.setFocusableInTouchMode(true);
    this.vKs.requestFocus();
    this.vKr.clearFocus();
    this.vKt.clearFocus();
    this.vKM.clearFocus();
    XM();
  }
  
  private void cHu()
  {
    com.tencent.mm.bb.c.PO();
    Bitmap localBitmap = com.tencent.mm.bb.c.mN(this.username);
    if (localBitmap != null)
    {
      this.vKw.setVisibility(8);
      this.vKz.setVisibility(8);
      this.vKy.setVisibility(0);
      this.vKy.setImageBitmap(localBitmap);
    }
    this.vKE = true;
  }
  
  private void cHv()
  {
    if (!this.vKS) {}
    Object localObject3;
    Object localObject1;
    do
    {
      return;
      localObject2 = new axq();
      ((axq)localObject2).ttJ = this.username;
      localObject3 = new beo();
      localObject1 = this.vKM.getPhoneNumberList();
      if (localObject1 == null) {}
      for (int i = 0;; i = ((ArrayList)localObject1).size())
      {
        ((beo)localObject3).hPS = i;
        ((beo)localObject3).tzz = new LinkedList();
        if (localObject1 == null) {
          break;
        }
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ben localben = new ben();
          localben.tzy = str;
          ((beo)localObject3).tzz.add(localben);
        }
      }
      ((axq)localObject2).ttF = ((beo)localObject3);
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new i.a(60, (com.tencent.mm.bv.a)localObject2));
      au.Hx();
      localObject2 = com.tencent.mm.model.c.Fw().abl(this.username);
    } while ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).dBe <= 0) || (!com.tencent.mm.n.a.gR(((ao)localObject2).field_type)));
    if (localObject1 != null)
    {
      localObject3 = ((ArrayList)localObject1).iterator();
      for (localObject1 = "";; localObject1 = (String)localObject1 + ",")
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject3).next();
        localObject1 = (String)localObject1 + (String)localObject2;
      }
    }
    Object localObject2 = "";
    y.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject2 });
    this.dnp.dM((String)localObject2);
    au.Hx();
    com.tencent.mm.model.c.Fw().U(this.dnp);
  }
  
  private boolean cHw()
  {
    String str = this.vKt.getText().toString();
    return ((this.cCJ == null) || (!this.cCJ.equals(str))) && ((!ah.bl(this.cCJ)) || (!ah.bl(str)));
  }
  
  private boolean cHx()
  {
    return (!ah.bl(this.vKD)) || (this.vKI);
  }
  
  private void cHy()
  {
    this.vKI = true;
    this.vKz.setVisibility(8);
    this.vKw.setVisibility(0);
    this.vKy.setVisibility(8);
    this.vKy.setImageBitmap(null);
    xE();
  }
  
  private void goBack()
  {
    boolean bool1 = cHx();
    boolean bool2 = ny(true);
    boolean bool3 = cHw();
    if ((bool1) || (bool2) || (bool3))
    {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.contact_info_remark_info_cancel_alert), null, getString(R.l.contact_info_remark_info_cancel_alert_save), getString(R.l.contact_info_remark_info_cancel_alert_cancel), new ContactRemarkInfoModUI.9(this), new ContactRemarkInfoModUI.11(this));
      return;
    }
    XM();
    finish();
  }
  
  private boolean ny(boolean paramBoolean)
  {
    String str = this.vKr.getText().toString();
    if (!paramBoolean) {
      if (((this.aVs != null) && (this.aVs.equals(str))) || ((ah.bl(this.aVs)) && (ah.bl(str)))) {}
    }
    for (;;)
    {
      return true;
      return false;
      if (((this.aVs == null) || (!this.aVs.equals(str))) && ((!ah.bl(this.aVs)) || (!ah.bl(str)))) {}
      for (int i = 1; (i == 0) || ((str != null) && (str.equals(this.dnp.field_nickname))); i = 0) {
        return false;
      }
    }
  }
  
  private void xE()
  {
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.vKM;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.saC == null) {
        break label156;
      }
      bool = true;
    }
    for (;;)
    {
      this.vKS = bool;
      if ((!cHw()) && (!cHx()) && (!ny(false)) && (!this.vKS)) {
        break;
      }
      enableOptionMenu(true);
      return;
      if (localProfileEditPhoneNumberView.saC == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.saC.length)
      {
        bool = true;
      }
      else
      {
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label156;
          }
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.saC[i]))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        label156:
        bool = false;
      }
    }
    enableOptionMenu(false);
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_remark_info_mod;
  }
  
  protected final void initView()
  {
    this.vKs = ((TextView)findViewById(R.h.contact_info_mod_remark_name_hint_tv));
    this.vKu = ((TextView)findViewById(R.h.contact_info_remark_name_tv));
    this.vKv = ((TextView)findViewById(R.h.contact_info_remark_desc_tv));
    this.vKw = ((TextView)findViewById(R.h.contact_info_remark_image_tv));
    this.vKr = ((MMClearEditText)findViewById(R.h.contact_info_mod_remark_name_et));
    this.vKt = ((MMEditText)findViewById(R.h.contact_info_mod_remark_desc_et));
    this.vKy = ((ImageView)findViewById(R.h.remark_pic_display));
    this.vKz = ((ImageView)findViewById(R.h.remark_pic_failed));
    this.vKx = ((TextView)findViewById(R.h.wordcount));
    this.vKC = findViewById(R.h.contact_info_mod_remark_desc_container);
    this.vKM = ((ProfileEditPhoneNumberView)findViewById(R.h.mod_phone_number));
    this.vKM.jgl = this.dnp;
    Object localObject1 = this.vKM;
    Object localObject2 = this.vKN;
    String str = this.vKO;
    ((ProfileEditPhoneNumberView)localObject1).saA = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).saB = str;
    ((ProfileEditPhoneNumberView)localObject1).bsP();
    this.vKM.saF = new ContactRemarkInfoModUI.10(this);
    this.mZk = ((MMTagPanel)findViewById(R.h.contact_info_mod_label_et));
    this.mZk.setPanelClickable(false);
    this.vKL = ((ScrollView)findViewById(R.h.scrollview));
    this.vKK = ((TextView)findViewById(R.h.contact_info_label_tv));
    this.vKK.setText(R.l.mod_label_hint);
    this.mZk.setOnClickListener(this.vKJ);
    this.vKK.setOnClickListener(this.vKJ);
    setMMTitle(R.l.contact_info_mod_remarkinfo);
    label650:
    int i;
    if (!ah.bl(this.aVs))
    {
      this.vKr.setText(j.a(this, ah.pm(this.aVs), this.vKr.getTextSize()));
      this.vKu.setText(j.a(this, ah.pm(this.aVs), this.vKu.getTextSize()));
      this.vKr.setSelection(this.vKr.getText().length());
      localObject1 = j.a(this, ah.pm(this.cCJ), this.vKv.getTextSize());
      this.vKt.setText((CharSequence)localObject1);
      this.vKt.setSelection(this.vKt.getText().length());
      if (!ah.bl(this.cCJ))
      {
        this.vKv.setText(j.a(this, ah.pm(this.cCJ), this.vKv.getTextSize()));
        this.vKv.setTextColor(getResources().getColor(R.e.normal_text_color));
      }
      this.vKu.setOnClickListener(new ContactRemarkInfoModUI.12(this));
      this.vKv.setOnClickListener(new ContactRemarkInfoModUI.13(this));
      this.vKr.addTextChangedListener(new ContactRemarkInfoModUI.14(this));
      this.vKx.setText(com.tencent.mm.ui.tools.f.bi(800, this.vKt.getEditableText().toString()));
      this.vKt.setOnFocusChangeListener(new ContactRemarkInfoModUI.15(this));
      this.vKt.addTextChangedListener(new ContactRemarkInfoModUI.b(this, (byte)0));
      if (ah.bl(this.exA)) {
        break label927;
      }
      this.vKw.setVisibility(8);
      this.vKy.setVisibility(0);
      com.tencent.mm.bb.c.PO();
      if (com.tencent.mm.bb.c.mL(this.username)) {
        break label920;
      }
      com.tencent.mm.bb.c.PO().a(this.username, this.exA, new com.tencent.mm.bb.c.a()
      {
        public final void bY(final boolean paramAnonymousBoolean)
        {
          ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              if (!paramAnonymousBoolean)
              {
                com.tencent.mm.ui.base.h.bC(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(R.l.app_err_system_busy_tip));
                ContactRemarkInfoModUI.s(ContactRemarkInfoModUI.this).setVisibility(0);
                ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).setVisibility(8);
                ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this).setVisibility(8);
                return;
              }
              ContactRemarkInfoModUI.v(ContactRemarkInfoModUI.this);
            }
          });
        }
      });
      this.vKy.setOnClickListener(new ContactRemarkInfoModUI.16(this));
      this.vKw.setOnClickListener(new ContactRemarkInfoModUI.17(this));
      localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(this.dnp.field_username);
      if ((localObject1 != null) && (!ah.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx().equals(this.vKr.getText().toString()))) {
        break label947;
      }
      i = 0;
      label730:
      if ((i == 0) && (this.fhj == 14) && (!ah.bl(this.siS)) && (!this.siS.equals(this.vKr.getText().toString()))) {
        break label1078;
      }
      label773:
      a(0, getString(R.l.app_finish), new ContactRemarkInfoModUI.18(this), s.b.uNx);
      setBackBtn(new ContactRemarkInfoModUI.2(this));
      if (!ah.bl(this.aVs)) {
        break label1218;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.vKz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
        }
      });
      if (!this.vKH)
      {
        this.vKG = true;
        B(true, -1);
      }
      cHt();
      return;
      this.vKr.setText(j.a(this, ah.pm(this.dnp.Bp()), this.vKr.getTextSize()));
      this.vKu.setText(j.a(this, ah.pm(this.dnp.Bp()), this.vKr.getTextSize()));
      break;
      label920:
      cHu();
      break label650;
      label927:
      this.vKw.setVisibility(0);
      this.vKy.setVisibility(8);
      break label650;
      label947:
      this.vKA = ((TextView)findViewById(R.h.mode_remark_mobile_name));
      this.vKB = findViewById(R.h.mod_remark_mobile_name_area);
      this.vKB.setVisibility(0);
      this.vKA.setText(ah.pm(getString(R.l.contact_info_set_reamrk_mobile_name, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx() })));
      localObject2 = new k(getString(R.l.write_contact_remark));
      ((k)localObject2).setSpan(new ContactRemarkInfoModUI.c(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx()), 0, ((k)localObject2).length(), 17);
      this.vKA.append(" ");
      this.vKA.append((CharSequence)localObject2);
      this.vKA.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label730;
      label1078:
      this.vKA = ((TextView)findViewById(R.h.mode_remark_mobile_name));
      this.vKB = findViewById(R.h.mod_remark_mobile_name_area);
      this.vKB.setVisibility(0);
      this.vKA.setText(j.a(this, ah.pm(getString(R.l.contact_info_set_reamrk_chatroom_name, new Object[] { this.siS })), this.vKA.getTextSize()));
      localObject1 = new k(getString(R.l.write_contact_remark));
      ((k)localObject1).setSpan(new ContactRemarkInfoModUI.c(this, this.siS), 0, ((k)localObject1).length(), 17);
      this.vKA.append(" ");
      this.vKA.append((CharSequence)localObject1);
      this.vKA.setMovementMethod(LinkMovementMethod.getInstance());
      break label773;
      label1218:
      enableOptionMenu(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null) {
      y.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
    }
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          case 100: 
            localContext = getApplicationContext();
            au.Hx();
            paramIntent = l.f(localContext, paramIntent, com.tencent.mm.model.c.FG());
          }
        } while (paramIntent == null);
        this.vKD = adS(paramIntent);
        adR(this.vKD);
        this.vKF = true;
        this.vKI = false;
        xE();
        return;
        Context localContext = getApplicationContext();
        au.Hx();
        paramIntent = com.tencent.mm.ui.tools.a.g(localContext, paramIntent, com.tencent.mm.model.c.FG());
      } while (paramIntent == null);
      this.vKD = adS(paramIntent);
      adR(this.vKD);
      this.vKF = true;
      this.vKI = false;
      xE();
      return;
    } while (!paramIntent.getBooleanExtra("response_delete", false));
    cHy();
    return;
    if ((ny(true)) || (cHw()) || (cHx()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
    {
      enableOptionMenu(true);
      return;
    }
    enableOptionMenu(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    super.onCreate(paramBundle);
    au.Dk().a(575, this);
    au.Dk().a(576, this);
    this.fhj = getIntent().getIntExtra("Contact_Scene", 9);
    this.siS = getIntent().getStringExtra("Contact_RoomNickname");
    this.vKH = getIntent().getBooleanExtra("view_mode", false);
    this.vKP = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.vKN = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.vKO = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (ah.bl(this.username)) {
      finish();
    }
    label330:
    for (;;)
    {
      return;
      au.Hx();
      this.dnp = com.tencent.mm.model.c.Fw().abl(this.username);
      this.aVs = this.dnp.field_conRemark;
      this.cCJ = this.dnp.cCJ;
      this.exA = this.dnp.cCK;
      this.lCb = this.dnp.field_contactLabelIds;
      this.mZl = com.tencent.mm.plugin.label.a.a.bdA().Gn(this.lCb);
      initView();
      xE();
      if ((this.dnp != null) && (ad.aaU(this.dnp.field_username))) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (this.vKr == null)) {
          break label330;
        }
        paramBundle = (ViewGroup)this.vKr.getParent();
        ViewGroup localViewGroup = (ViewGroup)paramBundle.getParent();
        int k = localViewGroup.getChildCount();
        i = j;
        while (i < k)
        {
          View localView = localViewGroup.getChildAt(i);
          if (localView != paramBundle) {
            localView.setVisibility(8);
          }
          i += 1;
        }
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    au.Dk().b(575, this);
    au.Dk().b(576, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      return true;
    }
    return false;
  }
  
  protected void onPause()
  {
    au.Hx();
    com.tencent.mm.model.c.Fw().b(this.mZm);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this.mZm);
    bsQ();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.ecf != null)
    {
      this.ecf.dismiss();
      this.ecf = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.h.b(this, getString(R.l.app_err_server_busy_tip), null, true);
      return;
    }
    if (paramm.getType() == 575)
    {
      if (this.vKD != null)
      {
        paramString = new com.tencent.mm.vfs.b(this.vKD);
        if (paramString.exists())
        {
          com.tencent.mm.bb.c.PO();
          paramString.n(new com.tencent.mm.vfs.b(com.tencent.mm.bb.c.mK(this.username)));
        }
      }
      paramString = ((com.tencent.mm.bb.b)paramm).exA;
      if (!ah.bl(paramString)) {
        this.exA = paramString;
      }
    }
    for (;;)
    {
      finish();
      return;
      if (paramm.getType() == 576)
      {
        this.vKD = null;
        this.exA = null;
        this.vKE = false;
        au.Hx();
        this.dnp = com.tencent.mm.model.c.Fw().abl(this.username);
        this.dnp.dH("");
        au.Hx();
        com.tencent.mm.model.c.Fw().a(this.username, this.dnp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI
 * JD-Core Version:    0.7.0.1
 */