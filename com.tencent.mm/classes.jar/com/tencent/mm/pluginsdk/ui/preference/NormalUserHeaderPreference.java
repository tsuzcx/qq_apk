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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
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
  implements d.a, m.a, n.b
{
  MMActivity cmc;
  ad contact;
  private String egF;
  private boolean lJS;
  private String mVw;
  private TextView nIh;
  private TextView nzx;
  private ClipboardManager oZF;
  private boolean pAl;
  private boolean pAr;
  private boolean pCc;
  private ImageView pxZ;
  private ImageView qPQ;
  int qQk;
  private TextView uuy;
  private String vRr;
  private String vRs;
  private TextView waV;
  private TextView waW;
  private View waX;
  private Button waY;
  private Button waZ;
  private TextView wba;
  private ImageView wbb;
  private CheckBox wbc;
  private ImageView wbd;
  private ImageView wbe;
  private LinearLayout wbf;
  private Button wbg;
  private FMessageListView wbh;
  private RelativeLayout wbi;
  private ImageView wbj;
  private int wbk;
  private boolean wbl;
  private boolean wbm;
  private boolean wbn;
  private boolean wbo;
  private boolean wbp;
  private boolean wbq;
  private boolean wbr;
  private boolean wbs;
  private String wbt;
  private ProfileMobilePhoneView wbu;
  private ProfileDescribeView wbv;
  private ProfileLabelView wbw;
  private TextView wbx;
  public View.OnClickListener wby;
  public String wbz;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28081);
    this.lJS = false;
    this.wbk = 0;
    this.wbl = false;
    this.wbm = false;
    this.wbn = false;
    this.wbo = false;
    this.wbp = false;
    this.wbq = false;
    this.wbr = false;
    this.pCc = false;
    this.wbs = false;
    this.pAr = false;
    this.egF = "";
    this.wbz = null;
    this.cmc = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(28081);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28082);
    this.lJS = false;
    this.wbk = 0;
    this.wbl = false;
    this.wbm = false;
    this.wbn = false;
    this.wbo = false;
    this.wbp = false;
    this.wbq = false;
    this.wbr = false;
    this.pCc = false;
    this.wbs = false;
    this.pAr = false;
    this.egF = "";
    this.wbz = null;
    this.cmc = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(28082);
  }
  
  private static boolean Xh(String paramString)
  {
    AppMethodBeat.i(28086);
    if (com.tencent.mm.plugin.sns.b.n.raT != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.b.n.raT.Xh(paramString);
      AppMethodBeat.o(28086);
      return bool;
    }
    AppMethodBeat.o(28086);
    return false;
  }
  
  private boolean cbQ()
  {
    return (this.lJS) && (this.contact != null);
  }
  
  private void chm()
  {
    AppMethodBeat.i(28087);
    a.b.c(this.pxZ, this.contact.field_username);
    int i;
    if (this.pxZ != null)
    {
      i = com.tencent.mm.cb.a.ao(this.mContext, 2131427497);
      int j = com.tencent.mm.cb.a.fromDPToPix(this.cmc, 88);
      if (i <= j) {
        break label95;
      }
      i = j;
    }
    label95:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.ap(this.mContext, 2131427775), 0);
      this.pxZ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(28087);
      return;
    }
  }
  
  private void dpc()
  {
    AppMethodBeat.i(28088);
    this.wba.setVisibility(0);
    this.nzx.setText(j.b(this.cmc, bo.nullAsNil(this.contact.Oe()) + " ", this.nzx.getTextSize()));
    chm();
    this.wbg.setVisibility(8);
    this.nIh.setVisibility(8);
    this.wbh.setVisibility(8);
    if ((this.wbh.getVisibility() == 8) && (this.wbx.getVisibility() == 8) && (this.wbw.getVisibility() == 8) && (this.wbv.getVisibility() == 8) && (this.uuy.getVisibility() == 8)) {
      this.waX.setVisibility(8);
    }
    this.waY.setVisibility(8);
    this.waZ.setVisibility(8);
    this.wbc.setVisibility(8);
    if (this.wbw != null) {
      this.wbw.setVisibility(8);
    }
    if (this.wbu != null) {
      this.wbu.setVisibility(8);
    }
    if (this.wbv != null) {
      this.wbv.setVisibility(8);
    }
    if (this.wbx != null) {
      this.wbx.setVisibility(8);
    }
    if (this.waW != null) {
      this.waW.setVisibility(8);
    }
    AppMethodBeat.o(28088);
  }
  
  private void dpe()
  {
    AppMethodBeat.i(28091);
    int i = 0;
    if (this.wbn) {
      i = com.tencent.mm.cb.a.fromDPToPix(this.cmc, 17) + 0;
    }
    int j = i + this.wbk;
    i = j;
    if (this.wbl) {
      i = j + com.tencent.mm.cb.a.fromDPToPix(this.cmc, 27);
    }
    j = i;
    if (this.wbm) {
      j = i + com.tencent.mm.cb.a.fromDPToPix(this.cmc, 27);
    }
    i = j;
    if (this.wbo) {
      i = j + com.tencent.mm.cb.a.fromDPToPix(this.cmc, 30);
    }
    if (com.tencent.mm.cb.a.gt(this.mContext)) {
      i += com.tencent.mm.cb.a.fromDPToPix(this.cmc, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cb.a.fromDPToPix(this.cmc, 60);
      DisplayMetrics localDisplayMetrics = this.cmc.getResources().getDisplayMetrics();
      this.nzx.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(28091);
      return;
      i += com.tencent.mm.cb.a.fromDPToPix(this.cmc, 64);
    }
  }
  
  private void dpf()
  {
    int j = 0;
    AppMethodBeat.i(28097);
    ImageView localImageView;
    if ((this.wbd != null) && (t.nH(this.contact.field_username)))
    {
      this.wbm = this.contact.NZ();
      localImageView = this.wbd;
      if (this.wbm)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.wbe != null) && (t.nH(this.contact.field_username)))
    {
      this.wbl = Xh(this.contact.field_username);
      localImageView = this.wbe;
      if (!this.wbl) {
        break label124;
      }
    }
    label124:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(28097);
      return;
      i = 8;
      break;
    }
  }
  
  private void dpg()
  {
    AppMethodBeat.i(28098);
    if (bo.isNullOrNil(this.wbt))
    {
      this.waV.setVisibility(8);
      AppMethodBeat.o(28098);
      return;
    }
    if ((!r.nB(this.contact.field_username)) && (bo.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.nIh.setVisibility(8);
    }
    this.waV.setVisibility(0);
    this.waV.setText(j.b(this.cmc, this.cmc.getString(2131298570) + this.wbt, this.waV.getTextSize()));
    AppMethodBeat.o(28098);
  }
  
  private void dph()
  {
    AppMethodBeat.i(28099);
    if ((r.nB(this.contact.field_username)) || (bo.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.waW.setVisibility(8);
      this.nzx.setText(j.b(this.cmc, bo.nullAsNil(this.contact.Oe()) + " ", this.nzx.getTextSize()));
      if (this.wbr)
      {
        this.waY.setVisibility(0);
        this.wbx.setVisibility(8);
        if (ad.arf(this.contact.field_username))
        {
          this.wbx.setText(2131298849);
          dpi();
        }
        if ((!this.pCc) || (com.tencent.mm.n.a.je(this.contact.field_type))) {
          break label557;
        }
        this.waZ.setVisibility(0);
      }
    }
    for (;;)
    {
      if (ad.nM(this.contact.field_username)) {
        this.nzx.setText("");
      }
      if ((this.qQk == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.nzx.setText(j.b(this.cmc, bo.nullAsNil(this.contact.field_nickname) + " ", this.nzx.getTextSize()));
      }
      if ((this.waZ.getVisibility() == 0) && (this.waW.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.waW.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131427854);
        this.waW.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(28099);
      return;
      if (this.wbp)
      {
        this.waY.setVisibility(0);
        this.wbx.setVisibility(8);
        break;
      }
      if (com.tencent.mm.n.a.je(this.contact.field_type)) {
        this.waY.setVisibility(8);
      }
      boolean bool1 = this.wbv.S(this.contact);
      boolean bool2 = this.wbw.S(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.wbx.setVisibility(8);
      break;
      this.nzx.setText(j.b(this.cmc, bo.nullAsNil(this.contact.field_conRemark) + " ", this.nzx.getTextSize()));
      this.waW.setVisibility(0);
      this.waW.setText(j.b(this.cmc, this.mContext.getString(2131298681) + this.contact.Oe(), this.waW.getTextSize()));
      this.waY.setVisibility(8);
      break;
      label557:
      if (this.wbq)
      {
        this.waZ.setVisibility(0);
        if (com.tencent.mm.cb.a.gt(this.cmc))
        {
          this.waZ.setTextSize(0, this.cmc.getResources().getDimensionPixelSize(2131427758));
          this.waY.setTextSize(0, this.cmc.getResources().getDimensionPixelSize(2131427758));
        }
      }
      else
      {
        this.waZ.setVisibility(8);
      }
    }
  }
  
  private void dpi()
  {
    AppMethodBeat.i(28100);
    if (this.wbf == null)
    {
      AppMethodBeat.o(28100);
      return;
    }
    View localView = this.wbf.findViewById(2131823118);
    if (localView == null)
    {
      AppMethodBeat.o(28100);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(28100);
  }
  
  private void dpj()
  {
    AppMethodBeat.i(28101);
    this.wbc.setClickable(false);
    if (((t.nH(this.contact.field_username)) || (ad.arf(this.contact.field_username))) && (com.tencent.mm.n.a.je(this.contact.field_type)) && (!r.nB(this.contact.field_username)))
    {
      this.wbc.setVisibility(0);
      if (this.contact.NY())
      {
        this.wbc.setChecked(true);
        this.wbo = true;
        AppMethodBeat.o(28101);
        return;
      }
      this.wbc.setChecked(false);
      this.wbc.setVisibility(8);
      this.wbo = false;
      AppMethodBeat.o(28101);
      return;
    }
    this.wbo = false;
    this.wbc.setVisibility(8);
    AppMethodBeat.o(28101);
  }
  
  private void dpk()
  {
    AppMethodBeat.i(28105);
    if (!com.tencent.mm.plugin.story.api.n.isShowStoryCheck())
    {
      this.wbi.setVisibility(8);
      AppMethodBeat.o(28105);
      return;
    }
    e locale = (e)g.G(e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.wbi.setVisibility(0);
      this.wbj.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.wbf.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.cmc, 166);
      this.wbf.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.egF);
      AppMethodBeat.o(28105);
      return;
      this.wbi.setVisibility(8);
      this.wbj.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.wbf.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.wbf.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(28083);
    this.lJS = false;
    this.oZF = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    AppMethodBeat.o(28083);
  }
  
  private void initView()
  {
    AppMethodBeat.i(28089);
    if (!cbQ())
    {
      ab.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lJS + "contact = " + this.contact);
      AppMethodBeat.o(28089);
      return;
    }
    if (this.pAr)
    {
      dpc();
      AppMethodBeat.o(28089);
      return;
    }
    boolean bool = ad.nM(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.nzx.setText("");
      if (ad.ark(r.Zn()).equals(this.contact.field_username)) {
        this.wbg.setVisibility(8);
      }
      this.qPQ.setVisibility(0);
      this.wbn = true;
      if (this.contact.dqC != 1) {
        break label494;
      }
      this.qPQ.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131231426));
      this.qPQ.setContentDescription(this.mContext.getString(2131302184));
      if (this.contact.field_verifyFlag != 0)
      {
        this.wbb.setVisibility(0);
        if (ao.a.flK == null) {
          break label569;
        }
        localBitmap = BackwardSupportUtil.b.k(ao.a.flK.kx(this.contact.field_verifyFlag), 2.0F);
        this.wbb.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label574;
        }
        i = 0;
        label245:
        this.wbk = i;
      }
      chm();
      dpk();
      this.pxZ.setOnClickListener(new NormalUserHeaderPreference.1(this));
      this.wbj.setOnClickListener(new NormalUserHeaderPreference.2(this));
      if (!ad.are(this.contact.field_username)) {
        break label582;
      }
      this.nIh.setText(this.mContext.getString(2131296944) + this.contact.Og());
      label341:
      if (!t.ow(this.contact.field_username)) {
        break label894;
      }
      this.uuy.setVisibility(0);
    }
    for (;;)
    {
      dph();
      dpf();
      dpj();
      dpg();
      this.waY.setOnClickListener(new NormalUserHeaderPreference.3(this));
      this.waZ.setOnClickListener(new NormalUserHeaderPreference.4(this));
      dpe();
      this.nIh.setLongClickable(true);
      this.nIh.setOnLongClickListener(new NormalUserHeaderPreference.5(this));
      AppMethodBeat.o(28089);
      return;
      this.nzx.setText(j.b(this.cmc, bo.nullAsNil(this.contact.field_nickname) + " ", this.nzx.getTextSize()));
      break;
      label494:
      if (this.contact.dqC == 2)
      {
        this.qPQ.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131231425));
        this.qPQ.setContentDescription(this.mContext.getString(2131302183));
        break label187;
      }
      if (this.contact.dqC != 0) {
        break label187;
      }
      this.qPQ.setVisibility(8);
      this.wbn = false;
      break label187;
      label569:
      localBitmap = null;
      break label231;
      label574:
      i = localBitmap.getWidth();
      break label245;
      label582:
      if (ad.arc(this.contact.field_username))
      {
        this.nIh.setText(this.mContext.getString(2131296956) + this.contact.Og());
        break label341;
      }
      if (this.pAl)
      {
        if (com.tencent.mm.n.a.je(this.contact.field_type))
        {
          dpd();
          break label341;
        }
        if ((this.contact.dqM == null) || (this.contact.dqM.equals("")))
        {
          this.nIh.setText(2131296919);
          break label341;
        }
        this.nIh.setText(this.contact.dqM);
        break label341;
      }
      if (bool)
      {
        this.nIh.setText((bo.nullAsNil(s.nG(this.contact.getProvince())) + " " + bo.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!ad.ard(this.contact.field_username)) && (this.cmc.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((bo.isNullOrNil(this.contact.Hq())) && ((ad.ari(this.contact.field_username)) || (t.nS(this.contact.field_username))))
        {
          this.nIh.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.n.a.je(this.contact.field_type))
        {
          dpd();
          break label341;
        }
      }
      this.nIh.setVisibility(8);
      break label341;
      label894:
      this.uuy.setVisibility(8);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(28103);
    ab.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(28103);
      return;
    }
    paramn = (String)paramObject;
    ab.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + paramn + ", contact = " + this.contact);
    if (!cbQ())
    {
      ab.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lJS + "contact = " + this.contact);
      AppMethodBeat.o(28103);
      return;
    }
    if (bo.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(28103);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      com.tencent.mm.model.aw.aaz();
      this.contact = c.YA().arw(paramn);
      al.d(new NormalUserHeaderPreference.6(this));
    }
    AppMethodBeat.o(28103);
  }
  
  public final void a(ad paramad, int paramInt, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(28095);
    onDetach();
    com.tencent.mm.model.aw.aaz();
    c.YA().a(this);
    com.tencent.mm.model.aw.aaz();
    c.YB().a(this);
    o.acQ().d(this);
    this.contact = paramad;
    this.qQk = paramInt;
    this.mVw = paramString;
    this.pAl = this.cmc.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
    this.wbs = this.cmc.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
    this.wbp = this.cmc.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
    this.wbq = this.cmc.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
    this.wbr = this.cmc.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
    this.pCc = this.cmc.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
    this.wbt = this.cmc.getIntent().getStringExtra("Contact_RoomNickname");
    if (paramad.field_deleteFlag == 1)
    {
      bool1 = true;
      this.pAr = bool1;
      this.egF = this.cmc.getIntent().getStringExtra("room_name");
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
        break label262;
      }
    }
    label262:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("initView: contact username is null", bool1);
      initView();
      AppMethodBeat.o(28095);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(ad paramad, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(28094);
    this.vRr = paramString2;
    this.vRs = paramString3;
    a(paramad, paramInt, paramString1);
    AppMethodBeat.o(28094);
  }
  
  public final void a(bv parambv)
  {
    AppMethodBeat.i(28104);
    al.d(new NormalUserHeaderPreference.7(this, parambv));
    AppMethodBeat.o(28104);
  }
  
  public final void cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28092);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.wbp = paramBoolean;
    }
    AppMethodBeat.o(28092);
  }
  
  public final void ce(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28093);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.wbq = paramBoolean;
    }
    AppMethodBeat.o(28093);
  }
  
  public final void dpd()
  {
    AppMethodBeat.i(28090);
    this.nIh.setVisibility(0);
    if (!bo.isNullOrNil(this.contact.Hq()))
    {
      this.nIh.setText(this.mContext.getString(2131296950) + this.contact.Hq());
      AppMethodBeat.o(28090);
      return;
    }
    if ((!ad.ari(this.contact.field_username)) && (!t.nS(this.contact.field_username)))
    {
      String str = bo.nullAsNil(this.contact.Og());
      this.nIh.setText(this.mContext.getString(2131296950) + str);
      AppMethodBeat.o(28090);
      return;
    }
    this.nIh.setVisibility(8);
    AppMethodBeat.o(28090);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(28085);
    ab.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.nzx = ((TextView)paramView.findViewById(2131821498));
    this.nIh = ((TextView)paramView.findViewById(2131823100));
    this.wba = ((TextView)paramView.findViewById(2131823119));
    this.waV = ((TextView)paramView.findViewById(2131823125));
    this.waW = ((TextView)paramView.findViewById(2131823121));
    this.waY = ((Button)paramView.findViewById(2131823122));
    this.waZ = ((Button)paramView.findViewById(2131823123));
    this.wbu = ((ProfileMobilePhoneView)paramView.findViewById(2131823129));
    Object localObject = this.wbu;
    com.tencent.mm.model.aw.aaz();
    ((ProfileMobilePhoneView)localObject).vRD = ((Boolean)c.Ru().get(ac.a.yAp, Boolean.FALSE)).booleanValue();
    this.wbv = ((ProfileDescribeView)paramView.findViewById(2131823130));
    this.wbw = ((ProfileLabelView)paramView.findViewById(2131823131));
    this.wbx = ((TextView)paramView.findViewById(2131823128));
    this.wbv.setOnClickListener(this.wby);
    this.wbw.setOnClickListener(this.wby);
    this.wbx.setOnClickListener(this.wby);
    if ((r.nB(this.contact.field_username)) || ((!bo.isNullOrNil(this.contact.field_username)) && (t.ow(this.contact.field_username))))
    {
      this.wbx.setVisibility(8);
      this.wbu.setVisibility(8);
      this.wbv.setVisibility(8);
      this.wbw.setVisibility(8);
      this.uuy = ((TextView)paramView.findViewById(2131823134));
      this.wbg = ((Button)paramView.findViewById(2131823126));
      this.wbh = ((FMessageListView)paramView.findViewById(2131823132));
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.qQk;
      ((a.a)localObject).mVw = this.mVw;
      ((a.a)localObject).waH = this.contact.dra;
      ((a.a)localObject).type = 0;
      if (this.qQk != 18) {
        break label866;
      }
      ((a.a)localObject).type = 1;
      label424:
      this.wbh.setFMessageArgs((a.a)localObject);
      this.waX = paramView.findViewById(2131823127);
      this.wbf = ((LinearLayout)paramView.findViewById(2131823111));
      this.pxZ = ((ImageView)paramView.findViewById(2131821497));
      this.qPQ = ((ImageView)paramView.findViewById(2131823113));
      this.wbb = ((ImageView)paramView.findViewById(2131823114));
      this.wbc = ((CheckBox)paramView.findViewById(2131823117));
      this.wbd = ((ImageView)paramView.findViewById(2131823116));
      this.wbe = ((ImageView)paramView.findViewById(2131823115));
      this.wbj = ((ImageView)paramView.findViewById(2131823110));
      this.wbi = ((RelativeLayout)paramView.findViewById(2131823109));
      this.lJS = true;
      initView();
      if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
        break label885;
      }
      ab.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.wbh.setVisibility(8);
      if ((this.wbh.getVisibility() == 8) && (this.wbx.getVisibility() == 8) && (this.wbw.getVisibility() == 8) && (this.wbv.getVisibility() == 8) && (this.uuy.getVisibility() == 8)) {
        this.waX.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(28085);
      return;
      this.wbu.hT(this.vRr, this.vRs);
      if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
        this.wbu.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.wbv.S(this.contact);
        boolean bool2 = this.wbw.S(this.contact);
        if ((!bool1) && (!bool2)) {
          break label787;
        }
        this.wbx.setVisibility(8);
        break;
        this.wbu.setVisibility(0);
      }
      label787:
      if ((this.wbr) || (this.wbp)) {
        this.wbx.setVisibility(8);
      }
      for (;;)
      {
        if ((this.wbz == null) || ((!this.wbz.equals("ContactWidgetBottleContact")) && (!this.wbz.equals("ContactWidgetQContact")))) {
          break label864;
        }
        this.wbx.setVisibility(8);
        break;
        this.wbx.setVisibility(0);
      }
      label864:
      break;
      label866:
      if (!bf.kD(this.qQk)) {
        break label424;
      }
      ((a.a)localObject).type = 2;
      break label424;
      label885:
      if ((this.mVw != null) && (this.mVw.length() != 0)) {
        break label1022;
      }
      ab.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.qQk + ", verifyTicket = " + this.mVw);
      this.wbh.setVisibility(8);
      if ((this.wbh.getVisibility() == 8) && (this.wbx.getVisibility() == 8) && (this.wbw.getVisibility() == 8) && (this.wbv.getVisibility() == 8) && (this.uuy.getVisibility() == 8)) {
        this.waX.setVisibility(8);
      }
    }
    label1022:
    ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.qQk);
    if (this.qQk == 18)
    {
      ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.bi.d.alj().asg(this.contact.field_username);
      localObject = b.a(this.cmc, (cu[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1279;
      }
      ab.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.wbh.setVisibility(8);
      if ((this.wbh.getVisibility() != 8) || (this.wbx.getVisibility() != 8) || (this.wbw.getVisibility() != 8) || (this.wbv.getVisibility() != 8) || (this.uuy.getVisibility() != 8)) {
        break;
      }
      this.waX.setVisibility(8);
      break;
      if (bf.kD(this.qQk))
      {
        ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.bi.d.alk().asF(this.contact.field_username);
        localObject = b.a(this.cmc, (bt[])localObject);
      }
      else
      {
        ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.bi.d.alh().asc(this.contact.field_username);
        localObject = b.a(this.cmc, (ax[])localObject);
      }
    }
    label1279:
    ab.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + localObject.length);
    int j = localObject.length;
    int i = 0;
    b localb;
    while (i < j)
    {
      localb = localObject[i];
      if (localb != null) {
        ab.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.fjL + ", addScene = " + localb.qQk);
      }
      i += 1;
    }
    if (ad.arf(this.contact.field_username))
    {
      this.wbh.setVisibility(8);
      this.wbh.setHide(true);
    }
    for (;;)
    {
      if ((this.wbh.getVisibility() == 0) || (this.wbx.getVisibility() == 0) || (this.wbw.getVisibility() == 0) || (this.wbv.getVisibility() == 0) || (this.uuy.getVisibility() == 0)) {
        this.waX.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.wbh.a(localb);
        i += 1;
      }
      break;
      this.wbh.setVisibility(0);
      this.wbh.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28084);
    if (this.wbh != null) {
      this.wbh.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(28084);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(28096);
    if (this.wbh != null) {
      this.wbh.detach();
    }
    if (this.wbs) {
      com.tencent.mm.bi.d.ali().asa(this.contact.field_username);
    }
    this.cmc.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.wbp);
    this.cmc.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.wbq);
    com.tencent.mm.model.aw.aaz();
    c.YA().b(this);
    o.acQ().e(this);
    com.tencent.mm.model.aw.aaz();
    c.YB().b(this);
    AppMethodBeat.o(28096);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(28102);
    if (!cbQ())
    {
      ab.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lJS + "contact = " + this.contact);
      AppMethodBeat.o(28102);
      return;
    }
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      ab.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28102);
      return;
    }
    if (paramString.equals(this.contact.field_username)) {
      initView();
    }
    AppMethodBeat.o(28102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */