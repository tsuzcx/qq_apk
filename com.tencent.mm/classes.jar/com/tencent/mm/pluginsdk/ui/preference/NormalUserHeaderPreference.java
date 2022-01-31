package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cn;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.l.a;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference
  extends Preference
  implements d.a, l.a, m.b
{
  MMActivity bER;
  ad dnp;
  private boolean jAt = false;
  private String kzG;
  private TextView lbC;
  private TextView lkM;
  private ImageView mVu;
  private boolean mXp;
  private boolean mXw = false;
  private boolean mYA = false;
  private ClipboardManager mzz;
  private ImageView obJ;
  int ocd;
  public String saA;
  public String saB;
  private Button siA;
  private TextView siB;
  private ImageView siC;
  private CheckBox siD;
  private ImageView siE;
  private ImageView siF;
  private LinearLayout siG;
  private Button siH;
  private FMessageListView siI;
  private int siJ = 0;
  private boolean siK = false;
  private boolean siL = false;
  private boolean siM = false;
  private boolean siN = false;
  private boolean siO = false;
  private boolean siP = false;
  private boolean siQ = false;
  private boolean siR = false;
  private String siS;
  private ProfileMobilePhoneView siT;
  private ProfileDescribeView siU;
  private ProfileLabelView siV;
  private TextView siW;
  public View.OnClickListener siX;
  public String siY = null;
  private TextView siv;
  private TextView siw;
  private TextView six;
  private View siy;
  private Button siz;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    init();
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    init();
  }
  
  private boolean bsu()
  {
    return (this.jAt) && (this.dnp != null);
  }
  
  private void bww()
  {
    a.b.a(this.mVu, this.dnp.field_username);
    int i;
    if (this.mVu != null)
    {
      i = com.tencent.mm.cb.a.aa(this.mContext, R.f.BigAvatarSize);
      int j = com.tencent.mm.cb.a.fromDPToPix(this.bER, 88);
      if (i <= j) {
        break label85;
      }
      i = j;
    }
    label85:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.ab(this.mContext, R.f.LargerPadding), 0);
      this.mVu.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void cnX()
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if ((this.siE != null) && (s.gY(this.dnp.field_username)))
    {
      this.siL = this.dnp.Bk();
      localObject = this.siE;
      if (this.siL)
      {
        i = 0;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    else if ((this.siF != null) && (s.gY(this.dnp.field_username)))
    {
      localObject = this.dnp.field_username;
      if (n.omF == null) {
        break label133;
      }
      bool = n.omF.MQ((String)localObject);
      label100:
      this.siK = bool;
      localObject = this.siF;
      if (!this.siK) {
        break label138;
      }
    }
    label133:
    label138:
    for (int i = j;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      return;
      i = 8;
      break;
      bool = false;
      break label100;
    }
  }
  
  private void cnY()
  {
    Object localObject;
    if ((q.gS(this.dnp.field_username)) || (bk.pm(this.dnp.field_conRemark).length() <= 0))
    {
      this.siw.setVisibility(8);
      this.lbC.setText(j.a(this.bER, bk.pm(this.dnp.Bp()) + " ", this.lbC.getTextSize()));
      if (this.siQ)
      {
        this.siz.setVisibility(0);
        this.siW.setVisibility(8);
        if (ad.aaU(this.dnp.field_username))
        {
          this.siW.setText(R.l.contact_set_des_only);
          int i = R.h.line_username;
          if (this.siG != null)
          {
            localObject = this.siG.findViewById(i);
            if (localObject != null) {
              ((View)localObject).setVisibility(8);
            }
          }
        }
        if ((!this.mYA) || (com.tencent.mm.n.a.gR(this.dnp.field_type))) {
          break label578;
        }
        this.siA.setVisibility(0);
      }
    }
    for (;;)
    {
      if (ad.hd(this.dnp.field_username)) {
        this.lbC.setText("");
      }
      if ((this.ocd == 76) && (this.dnp.field_username != null) && (this.dnp.field_username.endsWith("@stranger"))) {
        this.lbC.setText(j.a(this.bER, bk.pm(this.dnp.field_nickname) + " ", this.lbC.getTextSize()));
      }
      if ((this.siA.getVisibility() == 0) && (this.siw.getVisibility() == 0))
      {
        localObject = (LinearLayout.LayoutParams)this.siw.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
        this.siw.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      if (this.siO)
      {
        this.siz.setVisibility(0);
        this.siW.setVisibility(8);
        break;
      }
      if (com.tencent.mm.n.a.gR(this.dnp.field_type)) {
        this.siz.setVisibility(8);
      }
      boolean bool1 = this.siU.P(this.dnp);
      boolean bool2 = this.siV.P(this.dnp);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.siW.setVisibility(8);
      break;
      this.lbC.setText(j.a(this.bER, bk.pm(this.dnp.field_conRemark) + " ", this.lbC.getTextSize()));
      this.siw.setVisibility(0);
      this.siw.setText(j.a(this.bER, this.mContext.getString(R.l.contact_info_nickname) + this.dnp.Bp(), this.siw.getTextSize()));
      this.siz.setVisibility(8);
      break;
      label578:
      if (this.siP)
      {
        this.siA.setVisibility(0);
        if (com.tencent.mm.cb.a.fh(this.bER))
        {
          this.siA.setTextSize(0, this.bER.getResources().getDimensionPixelSize(R.f.HintTextSize));
          this.siz.setTextSize(0, this.bER.getResources().getDimensionPixelSize(R.f.HintTextSize));
        }
      }
      else
      {
        this.siA.setVisibility(8);
      }
    }
  }
  
  private void cnZ()
  {
    this.siD.setClickable(false);
    if (((s.gY(this.dnp.field_username)) || (ad.aaU(this.dnp.field_username))) && (com.tencent.mm.n.a.gR(this.dnp.field_type)) && (!q.gS(this.dnp.field_username)))
    {
      this.siD.setVisibility(0);
      if (this.dnp.Bi())
      {
        this.siD.setChecked(true);
        this.siN = true;
        return;
      }
      this.siD.setChecked(false);
      this.siD.setVisibility(8);
      this.siN = false;
      return;
    }
    this.siN = false;
    this.siD.setVisibility(8);
  }
  
  private void init()
  {
    this.jAt = false;
    this.mzz = ((ClipboardManager)this.bER.getSystemService("clipboard"));
  }
  
  private void initView()
  {
    int j = 0;
    if (!bsu()) {
      y.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.jAt + "contact = " + this.dnp);
    }
    do
    {
      return;
      if (!this.mXw) {
        break;
      }
      this.siB.setVisibility(0);
      this.lbC.setText(j.a(this.bER, bk.pm(this.dnp.Bp()) + " ", this.lbC.getTextSize()));
      bww();
      this.siH.setVisibility(8);
      this.lkM.setVisibility(8);
      this.siI.setVisibility(8);
      if ((this.siI.getVisibility() == 8) && (this.siW.getVisibility() == 8) && (this.siV.getVisibility() == 8) && (this.siU.getVisibility() == 8) && (this.six.getVisibility() == 8)) {
        this.siy.setVisibility(8);
      }
      this.siz.setVisibility(8);
      this.siA.setVisibility(8);
      this.siD.setVisibility(8);
      if (this.siV != null) {
        this.siV.setVisibility(8);
      }
      if (this.siT != null) {
        this.siT.setVisibility(8);
      }
      if (this.siU != null) {
        this.siU.setVisibility(8);
      }
      if (this.siW != null) {
        this.siW.setVisibility(8);
      }
    } while (this.siw == null);
    this.siw.setVisibility(8);
    return;
    boolean bool = ad.hd(this.dnp.field_username);
    label446:
    Object localObject;
    label491:
    int i;
    if (bool)
    {
      this.lbC.setText("");
      if (ad.aaZ(q.Gj()).equals(this.dnp.field_username))
      {
        this.siH.setVisibility(0);
        this.siH.setOnClickListener(new NormalUserHeaderPreference.1(this));
      }
      this.obJ.setVisibility(0);
      this.siM = true;
      if (this.dnp.sex != 1) {
        break label893;
      }
      this.obJ.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, R.k.ic_sex_male));
      this.obJ.setContentDescription(this.mContext.getString(R.l.profile_sex_male_desc));
      if (this.dnp.field_verifyFlag != 0)
      {
        this.siC.setVisibility(0);
        if (am.a.dVA == null) {
          break label968;
        }
        localObject = BackwardSupportUtil.b.e(am.a.dVA.hL(this.dnp.field_verifyFlag), 2.0F);
        this.siC.setImageBitmap((Bitmap)localObject);
        if (localObject != null) {
          break label974;
        }
        i = 0;
        label507:
        this.siJ = i;
      }
      bww();
      this.mVu.setOnClickListener(new NormalUserHeaderPreference.2(this));
      if (!ad.aaT(this.dnp.field_username)) {
        break label983;
      }
      this.lkM.setText(this.mContext.getString(R.l.app_field_qquin) + this.dnp.Br());
      label584:
      if (!s.hN(this.dnp.field_username)) {
        break label1296;
      }
      this.six.setVisibility(0);
      label605:
      cnY();
      cnX();
      cnZ();
      if (!bk.bl(this.siS)) {
        break label1308;
      }
      this.siv.setVisibility(8);
      label636:
      this.siz.setOnClickListener(new NormalUserHeaderPreference.3(this));
      this.siA.setOnClickListener(new NormalUserHeaderPreference.4(this));
      i = j;
      if (this.siM) {
        i = com.tencent.mm.cb.a.fromDPToPix(this.bER, 17) + 0;
      }
      j = this.siJ + i;
      i = j;
      if (this.siK) {
        i = j + com.tencent.mm.cb.a.fromDPToPix(this.bER, 27);
      }
      j = i;
      if (this.siL) {
        j = i + com.tencent.mm.cb.a.fromDPToPix(this.bER, 27);
      }
      i = j;
      if (this.siN) {
        i = j + com.tencent.mm.cb.a.fromDPToPix(this.bER, 30);
      }
      if (!com.tencent.mm.cb.a.fh(this.mContext)) {
        break label1408;
      }
      i += com.tencent.mm.cb.a.fromDPToPix(this.bER, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cb.a.fromDPToPix(this.bER, 60);
      localObject = this.bER.getResources().getDisplayMetrics();
      this.lbC.setMaxWidth(((DisplayMetrics)localObject).widthPixels - (i + j));
      this.lkM.setLongClickable(true);
      this.lkM.setOnLongClickListener(new NormalUserHeaderPreference.5(this));
      return;
      this.lbC.setText(j.a(this.bER, bk.pm(this.dnp.field_nickname) + " ", this.lbC.getTextSize()));
      break;
      label893:
      if (this.dnp.sex == 2)
      {
        this.obJ.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, R.k.ic_sex_female));
        this.obJ.setContentDescription(this.mContext.getString(R.l.profile_sex_female_desc));
        break label446;
      }
      if (this.dnp.sex != 0) {
        break label446;
      }
      this.obJ.setVisibility(8);
      this.siM = false;
      break label446;
      label968:
      localObject = null;
      break label491;
      label974:
      i = ((Bitmap)localObject).getWidth();
      break label507;
      label983:
      if (ad.aaR(this.dnp.field_username))
      {
        this.lkM.setText(this.mContext.getString(R.l.app_field_weibo) + this.dnp.Br());
        break label584;
      }
      if (this.mXp)
      {
        if (com.tencent.mm.n.a.gR(this.dnp.field_type))
        {
          cnW();
          break label584;
        }
        if ((this.dnp.cCC == null) || (this.dnp.cCC.equals("")))
        {
          this.lkM.setText(R.l.app_empty_string);
          break label584;
        }
        this.lkM.setText(this.dnp.cCC);
        break label584;
      }
      if (bool)
      {
        this.lkM.setText((bk.pm(r.gX(this.dnp.getProvince())) + " " + bk.pm(this.dnp.getCity())).trim());
        break label584;
      }
      if ((!ad.aaS(this.dnp.field_username)) && (this.bER.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((bk.bl(this.dnp.vk())) && ((ad.aaX(this.dnp.field_username)) || (s.hj(this.dnp.field_username))))
        {
          this.lkM.setVisibility(8);
          break label584;
        }
        if (com.tencent.mm.n.a.gR(this.dnp.field_type))
        {
          cnW();
          break label584;
        }
      }
      this.lkM.setVisibility(8);
      break label584;
      label1296:
      this.six.setVisibility(8);
      break label605;
      label1308:
      if ((!q.gS(this.dnp.field_username)) && (bk.pm(this.dnp.field_conRemark).length() > 0)) {
        this.lkM.setVisibility(8);
      }
      this.siv.setVisibility(0);
      this.siv.setText(j.a(this.bER, this.bER.getString(R.l.contact_info_chatroom_nickname) + this.siS, this.siv.getTextSize()));
      break label636;
      label1408:
      i += com.tencent.mm.cb.a.fromDPToPix(this.bER, 64);
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    y.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      return;
      paramm = (String)paramObject;
      y.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + paramm + ", contact = " + this.dnp);
      if (!bsu())
      {
        y.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.jAt + "contact = " + this.dnp);
        return;
      }
    } while ((bk.pm(paramm).length() <= 0) || (this.dnp == null) || (!this.dnp.field_username.equals(paramm)));
    au.Hx();
    this.dnp = c.Fw().abl(paramm);
    ai.d(new NormalUserHeaderPreference.6(this));
  }
  
  public final void a(ad paramad, int paramInt, String paramString)
  {
    boolean bool2 = true;
    onDetach();
    au.Hx();
    c.Fw().a(this);
    au.Hx();
    c.Fx().a(this);
    o.JQ().d(this);
    this.dnp = paramad;
    this.ocd = paramInt;
    this.kzG = paramString;
    this.mXp = this.bER.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
    this.siR = this.bER.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
    this.siO = this.bER.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
    this.siP = this.bER.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
    this.siQ = this.bER.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
    this.mYA = this.bER.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
    this.siS = this.bER.getIntent().getStringExtra("Contact_RoomNickname");
    if (paramad.field_deleteFlag == 1)
    {
      bool1 = true;
      this.mXw = bool1;
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label233;
      }
    }
    label233:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("initView: contact username is null", bool1);
      initView();
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(bv parambv)
  {
    ai.d(new NormalUserHeaderPreference.7(this, parambv));
  }
  
  public final void bB(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.equals(this.dnp.field_username))) {
      this.siO = paramBoolean;
    }
  }
  
  public final void bC(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.equals(this.dnp.field_username))) {
      this.siP = paramBoolean;
    }
  }
  
  public final void cnW()
  {
    ad.ctZ();
    this.lkM.setVisibility(0);
    if (!bk.bl(this.dnp.vk()))
    {
      this.lkM.setText(this.mContext.getString(R.l.app_field_username) + this.dnp.vk());
      return;
    }
    if ((!ad.aaX(this.dnp.field_username)) && (!s.hj(this.dnp.field_username)))
    {
      String str = bk.pm(this.dnp.Br());
      this.lkM.setText(this.mContext.getString(R.l.app_field_username) + str);
      return;
    }
    this.lkM.setVisibility(8);
  }
  
  public final void kk(String paramString)
  {
    if (!bsu()) {
      y.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.jAt + "contact = " + this.dnp);
    }
    do
    {
      return;
      if (bk.pm(paramString).length() <= 0)
      {
        y.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = " + paramString);
        return;
      }
    } while (!paramString.equals(this.dnp.field_username));
    initView();
  }
  
  public final void onBindView(View paramView)
  {
    y.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.lbC = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.lkM = ((TextView)paramView.findViewById(R.h.contact_info_username_tv));
    this.siB = ((TextView)paramView.findViewById(R.h.contact_info_account_deleted_tv));
    this.siv = ((TextView)paramView.findViewById(R.h.contact_info_chatroom_nickname_tv));
    this.siw = ((TextView)paramView.findViewById(R.h.contact_info_nickname_when_has_remark_tv));
    this.siz = ((Button)paramView.findViewById(R.h.contact_info_remarkname_btn));
    this.siA = ((Button)paramView.findViewById(R.h.contact_info_snspermission_btn));
    this.siT = ((ProfileMobilePhoneView)paramView.findViewById(R.h.mobile_phone));
    Object localObject = this.siT;
    au.Hx();
    ((ProfileMobilePhoneView)localObject).saK = ((Boolean)c.Dz().get(ac.a.uqp, Boolean.valueOf(false))).booleanValue();
    this.siU = ((ProfileDescribeView)paramView.findViewById(R.h.desc_info));
    this.siV = ((ProfileLabelView)paramView.findViewById(R.h.label_info));
    this.siW = ((TextView)paramView.findViewById(R.h.set_desc_and_label_tv));
    this.siU.setOnClickListener(this.siX);
    this.siV.setOnClickListener(this.siX);
    this.siW.setOnClickListener(this.siX);
    if ((q.gS(this.dnp.field_username)) || ((!bk.bl(this.dnp.field_username)) && (s.hN(this.dnp.field_username))))
    {
      this.siW.setVisibility(8);
      this.siT.setVisibility(8);
      this.siU.setVisibility(8);
      this.siV.setVisibility(8);
      this.six = ((TextView)paramView.findViewById(R.h.contact_info_hing_tv));
      this.siH = ((Button)paramView.findViewById(R.h.contact_info_edit_btn));
      this.siI = ((FMessageListView)paramView.findViewById(R.h.contact_info_fmessage_listview));
      localObject = new a.a();
      ((a.a)localObject).talker = this.dnp.field_username;
      ((a.a)localObject).scene = this.ocd;
      ((a.a)localObject).kzG = this.kzG;
      ((a.a)localObject).sii = this.dnp.cCQ;
      ((a.a)localObject).type = 0;
      if (this.ocd != 18) {
        break label873;
      }
      ((a.a)localObject).type = 1;
      label419:
      this.siI.setFMessageArgs((a.a)localObject);
      this.siy = paramView.findViewById(R.h.small_category);
      this.siG = ((LinearLayout)paramView.findViewById(R.h.head_root));
      this.mVu = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
      this.obJ = ((ImageView)paramView.findViewById(R.h.contact_info_sex_iv));
      this.siC = ((ImageView)paramView.findViewById(R.h.contact_info_vuserinfo_iv));
      this.siD = ((CheckBox)paramView.findViewById(R.h.contact_info_star_iv));
      this.siE = ((ImageView)paramView.findViewById(R.h.contact_info_sns_iv));
      this.siF = ((ImageView)paramView.findViewById(R.h.contact_info_sns_black_iv));
      this.jAt = true;
      initView();
      if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
        break label892;
      }
      y.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.siI.setVisibility(8);
      if ((this.siI.getVisibility() == 8) && (this.siW.getVisibility() == 8) && (this.siV.getVisibility() == 8) && (this.siU.getVisibility() == 8) && (this.six.getVisibility() == 8)) {
        this.siy.setVisibility(8);
      }
    }
    String str1;
    for (;;)
    {
      super.onBindView(paramView);
      return;
      localObject = this.siT;
      str1 = this.saA;
      String str2 = this.saB;
      y.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { str1, str2 });
      ((ProfileMobilePhoneView)localObject).saA = str1;
      ((ProfileMobilePhoneView)localObject).saB = str2;
      ((ProfileMobilePhoneView)localObject).bsP();
      if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
        this.siT.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.siU.P(this.dnp);
        boolean bool2 = this.siV.P(this.dnp);
        if ((!bool1) && (!bool2)) {
          break label794;
        }
        this.siW.setVisibility(8);
        break;
        this.siT.setVisibility(0);
      }
      label794:
      if ((this.siQ) || (this.siO)) {
        this.siW.setVisibility(8);
      }
      for (;;)
      {
        if ((this.siY == null) || ((!this.siY.equals("ContactWidgetBottleContact")) && (!this.siY.equals("ContactWidgetQContact")))) {
          break label871;
        }
        this.siW.setVisibility(8);
        break;
        this.siW.setVisibility(0);
      }
      label871:
      break;
      label873:
      if (!com.tencent.mm.model.bd.hR(this.ocd)) {
        break label419;
      }
      ((a.a)localObject).type = 2;
      break label419;
      label892:
      if ((this.kzG != null) && (this.kzG.length() != 0)) {
        break label1029;
      }
      y.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.ocd + ", verifyTicket = " + this.kzG);
      this.siI.setVisibility(8);
      if ((this.siI.getVisibility() == 8) && (this.siW.getVisibility() == 8) && (this.siV.getVisibility() == 8) && (this.siU.getVisibility() == 8) && (this.six.getVisibility() == 8)) {
        this.siy.setVisibility(8);
      }
    }
    label1029:
    y.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.ocd);
    if (this.ocd == 18)
    {
      y.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.bh.d.RZ().abW(this.dnp.field_username);
      localObject = b.a(this.bER, (cn[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1286;
      }
      y.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.siI.setVisibility(8);
      if ((this.siI.getVisibility() != 8) || (this.siW.getVisibility() != 8) || (this.siV.getVisibility() != 8) || (this.siU.getVisibility() != 8) || (this.six.getVisibility() != 8)) {
        break;
      }
      this.siy.setVisibility(8);
      break;
      if (com.tencent.mm.model.bd.hR(this.ocd))
      {
        y.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.bh.d.Sa().act(this.dnp.field_username);
        localObject = b.a(this.bER, (bt[])localObject);
      }
      else
      {
        y.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.bh.d.RX().abS(this.dnp.field_username);
        localObject = b.a(this.bER, (ax[])localObject);
      }
    }
    label1286:
    y.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      str1 = localObject[i];
      if (str1 != null) {
        y.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + str1.username + ", nickname = " + str1.nickname + ", digest = " + str1.dTF + ", addScene = " + str1.ocd);
      }
      i += 1;
    }
    if (ad.aaU(this.dnp.field_username))
    {
      this.siI.setVisibility(8);
      this.siI.setHide(true);
    }
    for (;;)
    {
      if ((this.siI.getVisibility() == 0) || (this.siW.getVisibility() == 0) || (this.siV.getVisibility() == 0) || (this.siU.getVisibility() == 0) || (this.six.getVisibility() == 0)) {
        this.siy.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        str1 = localObject[i];
        this.siI.a(str1);
        i += 1;
      }
      break;
      this.siI.setVisibility(0);
      this.siI.setHide(false);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    if (this.siI != null) {
      this.siI.detach();
    }
    return super.onCreateView(paramViewGroup);
  }
  
  public final void onDetach()
  {
    if (this.siI != null) {
      this.siI.detach();
    }
    if (this.siR) {
      com.tencent.mm.bh.d.RY().abQ(this.dnp.field_username);
    }
    this.bER.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.siO);
    this.bER.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.siP);
    au.Hx();
    c.Fw().b(this);
    o.JQ().e(this);
    au.Hx();
    c.Fx().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */