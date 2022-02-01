package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.n.a;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference
  extends Preference
  implements e.a, n.a, n.b
{
  private TextView Dke;
  private String ETv;
  private String ETw;
  private TextView FfZ;
  private ProfileLabelView FgA;
  private TextView FgB;
  public View.OnClickListener FgC;
  public String FgD;
  private TextView Fga;
  private View Fgb;
  private Button Fgc;
  private Button Fgd;
  private TextView Fge;
  private ImageView Fgf;
  private CheckBox Fgg;
  private ImageView Fgh;
  private ImageView Fgi;
  private LinearLayout Fgj;
  private Button Fgk;
  private FMessageListView Fgl;
  private RelativeLayout Fgm;
  private ImageView Fgn;
  private int Fgo;
  private boolean Fgp;
  private boolean Fgq;
  private boolean Fgr;
  private boolean Fgs;
  private boolean Fgt;
  private boolean Fgu;
  private boolean Fgv;
  private boolean Fgw;
  private String Fgx;
  private ProfileMobilePhoneView Fgy;
  private ProfileDescribeView Fgz;
  am contact;
  MMActivity fLP;
  private String fPi;
  private boolean qhs;
  private String txJ;
  private TextView uGm;
  private TextView upn;
  private ImageView wPJ;
  private boolean wRV;
  private boolean wSb;
  private boolean wTK;
  private ClipboardManager wkW;
  private ImageView yOG;
  int yPa;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31868);
    this.qhs = false;
    this.Fgo = 0;
    this.Fgp = false;
    this.Fgq = false;
    this.Fgr = false;
    this.Fgs = false;
    this.Fgt = false;
    this.Fgu = false;
    this.Fgv = false;
    this.wTK = false;
    this.Fgw = false;
    this.wSb = false;
    this.fPi = "";
    this.FgD = null;
    this.fLP = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31868);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31869);
    this.qhs = false;
    this.Fgo = 0;
    this.Fgp = false;
    this.Fgq = false;
    this.Fgr = false;
    this.Fgs = false;
    this.Fgt = false;
    this.Fgu = false;
    this.Fgv = false;
    this.wTK = false;
    this.Fgw = false;
    this.wSb = false;
    this.fPi = "";
    this.FgD = null;
    this.fLP = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31869);
  }
  
  private static boolean auM(String paramString)
  {
    AppMethodBeat.i(31873);
    if (com.tencent.mm.plugin.sns.b.o.zbV != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.b.o.zbV.auM(paramString);
      AppMethodBeat.o(31873);
      return bool;
    }
    AppMethodBeat.o(31873);
    return false;
  }
  
  private boolean dAs()
  {
    return (this.qhs) && (this.contact != null);
  }
  
  private void dJx()
  {
    AppMethodBeat.i(31874);
    a.b.c(this.wPJ, this.contact.field_username);
    int i;
    if (this.wPJ != null)
    {
      i = com.tencent.mm.cc.a.ax(this.mContext, 2131165188);
      int j = com.tencent.mm.cc.a.fromDPToPix(this.fLP, 88);
      if (i <= j) {
        break label95;
      }
      i = j;
    }
    label95:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cc.a.ay(this.mContext, 2131165483), 0);
      this.wPJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(31874);
      return;
    }
  }
  
  private void feF()
  {
    AppMethodBeat.i(31875);
    this.Fge.setVisibility(0);
    this.upn.setText(k.b(this.fLP, bt.nullAsNil(this.contact.adu()) + " ", this.upn.getTextSize()));
    dJx();
    this.Fgk.setVisibility(8);
    this.uGm.setVisibility(8);
    this.Fgl.setVisibility(8);
    if ((this.Fgl.getVisibility() == 8) && (this.FgB.getVisibility() == 8) && (this.FgA.getVisibility() == 8) && (this.Fgz.getVisibility() == 8) && (this.Dke.getVisibility() == 8)) {
      this.Fgb.setVisibility(8);
    }
    this.Fgc.setVisibility(8);
    this.Fgd.setVisibility(8);
    this.Fgg.setVisibility(8);
    if (this.FgA != null) {
      this.FgA.setVisibility(8);
    }
    if (this.Fgy != null) {
      this.Fgy.setVisibility(8);
    }
    if (this.Fgz != null) {
      this.Fgz.setVisibility(8);
    }
    if (this.FgB != null) {
      this.FgB.setVisibility(8);
    }
    if (this.Fga != null) {
      this.Fga.setVisibility(8);
    }
    AppMethodBeat.o(31875);
  }
  
  private void feH()
  {
    AppMethodBeat.i(31878);
    int i = 0;
    if (this.Fgr) {
      i = com.tencent.mm.cc.a.fromDPToPix(this.fLP, 17) + 0;
    }
    int j = i + this.Fgo;
    i = j;
    if (this.Fgp) {
      i = j + com.tencent.mm.cc.a.fromDPToPix(this.fLP, 27);
    }
    j = i;
    if (this.Fgq) {
      j = i + com.tencent.mm.cc.a.fromDPToPix(this.fLP, 27);
    }
    i = j;
    if (this.Fgs) {
      i = j + com.tencent.mm.cc.a.fromDPToPix(this.fLP, 30);
    }
    if (com.tencent.mm.cc.a.im(this.mContext)) {
      i += com.tencent.mm.cc.a.fromDPToPix(this.fLP, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cc.a.fromDPToPix(this.fLP, 60);
      DisplayMetrics localDisplayMetrics = this.fLP.getResources().getDisplayMetrics();
      this.upn.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(31878);
      return;
      i += com.tencent.mm.cc.a.fromDPToPix(this.fLP, 64);
    }
  }
  
  private void feI()
  {
    int j = 0;
    AppMethodBeat.i(31884);
    ImageView localImageView;
    if ((this.Fgh != null) && (w.zi(this.contact.field_username)))
    {
      this.Fgq = this.contact.adn();
      localImageView = this.Fgh;
      if (this.Fgq)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.Fgi != null) && (w.zi(this.contact.field_username)))
    {
      this.Fgp = auM(this.contact.field_username);
      localImageView = this.Fgi;
      if (!this.Fgp) {
        break label124;
      }
    }
    label124:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(31884);
      return;
      i = 8;
      break;
    }
  }
  
  private void feJ()
  {
    AppMethodBeat.i(31885);
    if (bt.isNullOrNil(this.Fgx))
    {
      this.FfZ.setVisibility(8);
      AppMethodBeat.o(31885);
      return;
    }
    if ((!u.za(this.contact.field_username)) && (bt.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.uGm.setVisibility(8);
    }
    this.FfZ.setVisibility(0);
    this.FfZ.setText(k.b(this.fLP, this.fLP.getString(2131757629) + this.Fgx, this.FfZ.getTextSize()));
    AppMethodBeat.o(31885);
  }
  
  private void feK()
  {
    AppMethodBeat.i(31886);
    if ((u.za(this.contact.field_username)) || (bt.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.Fga.setVisibility(8);
      this.upn.setText(k.b(this.fLP, bt.nullAsNil(this.contact.adu()) + " ", this.upn.getTextSize()));
      if (this.Fgv)
      {
        this.Fgc.setVisibility(0);
        this.FgB.setVisibility(8);
        if (am.aSQ(this.contact.field_username))
        {
          this.FgB.setText(2131757927);
          feL();
        }
        if ((!this.wTK) || (com.tencent.mm.o.b.lM(this.contact.field_type))) {
          break label560;
        }
        this.Fgd.setVisibility(0);
      }
    }
    for (;;)
    {
      if (am.zs(this.contact.field_username)) {
        this.upn.setText("");
      }
      if ((this.yPa == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.upn.setText(k.b(this.fLP, bt.nullAsNil(this.contact.field_nickname) + " ", this.upn.getTextSize()));
      }
      if ((this.Fgd.getVisibility() == 0) && (this.Fga.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Fga.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165568);
        this.Fga.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(31886);
      return;
      if (this.Fgt)
      {
        this.Fgc.setVisibility(0);
        this.FgB.setVisibility(8);
        break;
      }
      if (com.tencent.mm.o.b.lM(this.contact.field_type)) {
        this.Fgc.setVisibility(8);
      }
      boolean bool1 = this.Fgz.aa(this.contact);
      boolean bool2 = this.FgA.aa(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.FgB.setVisibility(8);
      break;
      this.upn.setText(k.b(this.fLP, bt.nullAsNil(this.contact.field_conRemark) + " ", this.upn.getTextSize()));
      this.Fga.setVisibility(0);
      this.Fga.setText(k.b(this.fLP, this.mContext.getString(2131757742) + this.contact.adu(), this.Fga.getTextSize()));
      this.Fgc.setVisibility(8);
      break;
      label560:
      if (this.Fgu)
      {
        this.Fgd.setVisibility(0);
        if (com.tencent.mm.cc.a.im(this.fLP))
        {
          this.Fgd.setTextSize(0, this.fLP.getResources().getDimensionPixelSize(2131165466));
          this.Fgc.setTextSize(0, this.fLP.getResources().getDimensionPixelSize(2131165466));
        }
      }
      else
      {
        this.Fgd.setVisibility(8);
      }
    }
  }
  
  private void feL()
  {
    AppMethodBeat.i(31887);
    if (this.Fgj == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    View localView = this.Fgj.findViewById(2131301430);
    if (localView == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(31887);
  }
  
  private void feM()
  {
    AppMethodBeat.i(31888);
    this.Fgg.setClickable(false);
    if (((w.zi(this.contact.field_username)) || (am.aSQ(this.contact.field_username))) && (com.tencent.mm.o.b.lM(this.contact.field_type)) && (!u.za(this.contact.field_username)))
    {
      this.Fgg.setVisibility(0);
      if (this.contact.adm())
      {
        this.Fgg.setChecked(true);
        this.Fgs = true;
        AppMethodBeat.o(31888);
        return;
      }
      this.Fgg.setChecked(false);
      this.Fgg.setVisibility(8);
      this.Fgs = false;
      AppMethodBeat.o(31888);
      return;
    }
    this.Fgs = false;
    this.Fgg.setVisibility(8);
    AppMethodBeat.o(31888);
  }
  
  private void feN()
  {
    AppMethodBeat.i(31892);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      this.Fgm.setVisibility(8);
      AppMethodBeat.o(31892);
      return;
    }
    com.tencent.mm.plugin.story.api.e locale = (com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.Fgm.setVisibility(0);
      this.Fgn.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.Fgj.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(this.fLP, 166);
      this.Fgj.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.fPi);
      AppMethodBeat.o(31892);
      return;
      this.Fgm.setVisibility(8);
      this.Fgn.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.Fgj.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.Fgj.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(31870);
    this.qhs = false;
    this.wkW = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    AppMethodBeat.o(31870);
  }
  
  private void initView()
  {
    AppMethodBeat.i(31876);
    if (!dAs())
    {
      ad.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.qhs + "contact = " + this.contact);
      AppMethodBeat.o(31876);
      return;
    }
    if (this.wSb)
    {
      feF();
      AppMethodBeat.o(31876);
      return;
    }
    boolean bool = am.zs(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.upn.setText("");
      if (am.aSZ(u.aAm()).equals(this.contact.field_username)) {
        this.Fgk.setVisibility(8);
      }
      this.yOG.setVisibility(0);
      this.Fgr = true;
      if (this.contact.ePk != 1) {
        break label495;
      }
      this.yOG.setImageDrawable(com.tencent.mm.cc.a.l(this.fLP, 2131690323));
      this.yOG.setContentDescription(this.mContext.getString(2131762052));
      if (this.contact.field_verifyFlag != 0)
      {
        this.Fgf.setVisibility(0);
        if (as.a.hFQ == null) {
          break label570;
        }
        localBitmap = BackwardSupportUtil.b.o(as.a.hFQ.or(this.contact.field_verifyFlag), 2.0F);
        this.Fgf.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label575;
        }
        i = 0;
        label245:
        this.Fgo = i;
      }
      dJx();
      feN();
      this.wPJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31858);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username;
          paramAnonymousView = (View)localObject;
          if (am.zs((String)localObject)) {
            paramAnonymousView = am.aSZ((String)localObject);
          }
          localObject = new Intent(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", paramAnonymousView);
          paramAnonymousView = NormalUserHeaderPreference.b(NormalUserHeaderPreference.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31858);
        }
      });
      this.Fgn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31859);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.story.api.o.bi(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31859);
        }
      });
      if (!am.aSP(this.contact.field_username)) {
        break label583;
      }
      this.uGm.setText(this.mContext.getString(2131755753) + this.contact.adw());
      label341:
      if (!w.Ag(this.contact.field_username)) {
        break label896;
      }
      this.Dke.setVisibility(0);
    }
    for (;;)
    {
      feK();
      feI();
      feM();
      feJ();
      this.Fgc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31860);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          NormalUserHeaderPreference.c(NormalUserHeaderPreference.this);
          paramAnonymousView = NormalUserHeaderPreference.this;
          ba.aBQ();
          localObject = c.azp().Bf(paramAnonymousView.contact.field_username);
          if ((localObject != null) && ((int)((com.tencent.mm.o.b)localObject).gfj != 0) && (((aw)localObject).field_username.equals(paramAnonymousView.contact.field_username))) {
            paramAnonymousView.contact = ((am)localObject);
          }
          if (!com.tencent.mm.o.b.lM(paramAnonymousView.contact.field_type))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.yPa);
            ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
            ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.contact.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousView.contact.field_conRemark);
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31860);
            return;
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.yPa);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_RoomNickname", paramAnonymousView.fLP.getIntent().getStringExtra("Contact_RoomNickname"));
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      });
      this.Fgd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31861);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 3);
          com.tencent.mm.bs.d.b(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31861);
        }
      });
      feH();
      this.uGm.setLongClickable(true);
      this.uGm.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31865);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText() != null) && (NormalUserHeaderPreference.e(NormalUserHeaderPreference.this) != null))
          {
            localObject = NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText().toString();
            int i = ((String)localObject).indexOf(':');
            paramAnonymousView = (View)localObject;
            if (i >= 0)
            {
              paramAnonymousView = (View)localObject;
              if (i < ((String)localObject).length()) {
                paramAnonymousView = ((String)localObject).substring(i + 1).trim();
              }
            }
            localObject = new SpannableString(NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText());
            ((SpannableString)localObject).setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getResources().getColor(2131100539)), i + 1, NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText().length(), 33);
            NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).setText((CharSequence)localObject);
            localObject = new com.tencent.mm.ui.widget.b.a(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.d(NormalUserHeaderPreference.this));
            ((com.tencent.mm.ui.widget.b.a)localObject).Lai = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(31862);
                paramAnonymous2ContextMenu.add(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755701));
                AppMethodBeat.o(31862);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).KJz = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(31863);
                if (paramAnonymous2Int == 0)
                {
                  NormalUserHeaderPreference.e(NormalUserHeaderPreference.this).setText(paramAnonymousView);
                  h.ck(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755702));
                }
                AppMethodBeat.o(31863);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).KLB = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(31864);
                NormalUserHeaderPreference.this.feG();
                AppMethodBeat.o(31864);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).el(0, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(31865);
          return true;
        }
      });
      AppMethodBeat.o(31876);
      return;
      this.upn.setText(k.b(this.fLP, bt.nullAsNil(this.contact.field_nickname) + " ", this.upn.getTextSize()));
      break;
      label495:
      if (this.contact.ePk == 2)
      {
        this.yOG.setImageDrawable(com.tencent.mm.cc.a.l(this.fLP, 2131690322));
        this.yOG.setContentDescription(this.mContext.getString(2131762051));
        break label187;
      }
      if (this.contact.ePk != 0) {
        break label187;
      }
      this.yOG.setVisibility(8);
      this.Fgr = false;
      break label187;
      label570:
      localBitmap = null;
      break label231;
      label575:
      i = localBitmap.getWidth();
      break label245;
      label583:
      if (am.aSN(this.contact.field_username))
      {
        this.uGm.setText(this.mContext.getString(2131755766) + this.contact.adw());
        break label341;
      }
      if (this.wRV)
      {
        if (com.tencent.mm.o.b.lM(this.contact.field_type))
        {
          feG();
          break label341;
        }
        if ((this.contact.ePw == null) || (this.contact.ePw.equals("")))
        {
          this.uGm.setText(2131755726);
          break label341;
        }
        this.uGm.setText(this.contact.ePw);
        break label341;
      }
      if (bool)
      {
        this.uGm.setText((bt.nullAsNil(v.zh(this.contact.getProvince())) + " " + bt.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!am.aSO(this.contact.field_username)) && (this.fLP.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((bt.isNullOrNil(this.contact.VA())) && ((am.aSX(this.contact.field_username)) || (w.zC(this.contact.field_username))))
        {
          this.uGm.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.o.b.lM(this.contact.field_type))
        {
          feG();
          break label341;
        }
      }
      this.uGm.setVisibility(8);
      break label341;
      label896:
      this.Dke.setVisibility(8);
    }
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(31889);
    if (!dAs())
    {
      ad.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.qhs + "contact = " + this.contact);
      AppMethodBeat.o(31889);
      return;
    }
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      ad.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(31889);
      return;
    }
    if (paramString.equals(this.contact.field_username)) {
      initView();
    }
    AppMethodBeat.o(31889);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(31890);
    ad.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(31890);
      return;
    }
    paramn = (String)paramObject;
    ad.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + paramn + ", contact = " + this.contact);
    if (!dAs())
    {
      ad.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.qhs + "contact = " + this.contact);
      AppMethodBeat.o(31890);
      return;
    }
    if (bt.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(31890);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      ba.aBQ();
      this.contact = c.azp().Bf(paramn);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(31866);
          NormalUserHeaderPreference.f(NormalUserHeaderPreference.this);
          NormalUserHeaderPreference.g(NormalUserHeaderPreference.this);
          NormalUserHeaderPreference.h(NormalUserHeaderPreference.this);
          FMessageListView localFMessageListView;
          if (NormalUserHeaderPreference.i(NormalUserHeaderPreference.this) != null)
          {
            localFMessageListView = NormalUserHeaderPreference.i(NormalUserHeaderPreference.this);
            if (com.tencent.mm.o.b.lM(NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_type)) {
              break label75;
            }
          }
          label75:
          for (boolean bool = true;; bool = false)
          {
            localFMessageListView.setReplyBtnVisible(bool);
            AppMethodBeat.o(31866);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(31890);
  }
  
  public final void a(am paramam, int paramInt, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31882);
    onDetach();
    ba.aBQ();
    c.azp().a(this);
    ba.aBQ();
    c.azq().a(this);
    p.aEk().d(this);
    this.contact = paramam;
    this.yPa = paramInt;
    this.txJ = paramString;
    this.wRV = this.fLP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
    this.Fgw = this.fLP.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
    this.Fgt = this.fLP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
    this.Fgu = this.fLP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
    this.Fgv = this.fLP.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
    this.wTK = this.fLP.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
    this.Fgx = this.fLP.getIntent().getStringExtra("Contact_RoomNickname");
    if (paramam.field_deleteFlag == 1)
    {
      bool1 = true;
      this.wSb = bool1;
      this.fPi = this.fLP.getIntent().getStringExtra("room_name");
      if (bt.nullAsNil(paramam.field_username).length() <= 0) {
        break label262;
      }
    }
    label262:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("initView: contact username is null", bool1);
      initView();
      AppMethodBeat.o(31882);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(am paramam, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31881);
    this.ETv = paramString2;
    this.ETw = paramString3;
    a(paramam, paramInt, paramString1);
    AppMethodBeat.o(31881);
  }
  
  public final void a(final cf paramcf)
  {
    AppMethodBeat.i(31891);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31867);
        if ((NormalUserHeaderPreference.a(NormalUserHeaderPreference.this) != null) && (paramcf != null) && (NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username.equals(paramcf.field_encryptUsername)))
        {
          NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).sR(paramcf.field_conRemark);
          if (!NormalUserHeaderPreference.j(NormalUserHeaderPreference.this))
          {
            ad.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.k(NormalUserHeaderPreference.this) + "contact = " + NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
            AppMethodBeat.o(31867);
            return;
          }
          NormalUserHeaderPreference.f(NormalUserHeaderPreference.this);
        }
        AppMethodBeat.o(31867);
      }
    });
    AppMethodBeat.o(31891);
  }
  
  public final void cD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31879);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.Fgt = paramBoolean;
    }
    AppMethodBeat.o(31879);
  }
  
  public final void cE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31880);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.Fgu = paramBoolean;
    }
    AppMethodBeat.o(31880);
  }
  
  public final void feG()
  {
    AppMethodBeat.i(31877);
    this.uGm.setVisibility(0);
    if (!bt.isNullOrNil(this.contact.VA()))
    {
      this.uGm.setText(this.mContext.getString(2131755760) + this.contact.VA());
      AppMethodBeat.o(31877);
      return;
    }
    if ((!am.aSX(this.contact.field_username)) && (!w.zC(this.contact.field_username)))
    {
      String str = bt.nullAsNil(this.contact.adw());
      this.uGm.setText(this.mContext.getString(2131755760) + str);
      AppMethodBeat.o(31877);
      return;
    }
    this.uGm.setVisibility(8);
    AppMethodBeat.o(31877);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31872);
    ad.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.upn = ((TextView)paramView.findViewById(2131298631));
    this.uGm = ((TextView)paramView.findViewById(2131298662));
    this.Fge = ((TextView)paramView.findViewById(2131298595));
    this.FfZ = ((TextView)paramView.findViewById(2131298607));
    this.Fga = ((TextView)paramView.findViewById(2131298632));
    this.Fgc = ((Button)paramView.findViewById(2131298637));
    this.Fgd = ((Button)paramView.findViewById(2131298645));
    this.Fgy = ((ProfileMobilePhoneView)paramView.findViewById(2131302365));
    Object localObject = this.Fgy;
    ba.aBQ();
    ((ProfileMobilePhoneView)localObject).ETH = ((Boolean)c.ajl().get(al.a.IsS, Boolean.FALSE)).booleanValue();
    this.Fgz = ((ProfileDescribeView)paramView.findViewById(2131299003));
    this.FgA = ((ProfileLabelView)paramView.findViewById(2131301284));
    this.FgB = ((TextView)paramView.findViewById(2131304604));
    this.Fgz.setOnClickListener(this.FgC);
    this.FgA.setOnClickListener(this.FgC);
    this.FgB.setOnClickListener(this.FgC);
    if ((u.za(this.contact.field_username)) || ((!bt.isNullOrNil(this.contact.field_username)) && (w.Ag(this.contact.field_username))))
    {
      this.FgB.setVisibility(8);
      this.Fgy.setVisibility(8);
      this.Fgz.setVisibility(8);
      this.FgA.setVisibility(8);
      this.Dke = ((TextView)paramView.findViewById(2131298618));
      this.Fgk = ((Button)paramView.findViewById(2131298612));
      this.Fgl = ((FMessageListView)paramView.findViewById(2131298613));
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.yPa;
      ((a.a)localObject).txJ = this.txJ;
      ((a.a)localObject).FfL = this.contact.ePK;
      ((a.a)localObject).type = 0;
      if (this.yPa != 18) {
        break label877;
      }
      ((a.a)localObject).type = 1;
      label424:
      this.Fgl.setFMessageArgs((a.a)localObject);
      this.Fgb = paramView.findViewById(2131304845);
      this.Fgj = ((LinearLayout)paramView.findViewById(2131300699));
      this.wPJ = ((ImageView)paramView.findViewById(2131298597));
      this.yOG = ((ImageView)paramView.findViewById(2131298642));
      this.Fgf = ((ImageView)paramView.findViewById(2131298669));
      this.Fgg = ((CheckBox)paramView.findViewById(2131298646));
      this.Fgh = ((ImageView)paramView.findViewById(2131298644));
      this.Fgi = ((ImageView)paramView.findViewById(2131298643));
      this.Fgn = ((ImageView)paramView.findViewById(2131298659));
      this.Fgm = ((RelativeLayout)paramView.findViewById(2131298660));
      this.qhs = true;
      initView();
      if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {
        break label896;
      }
      ad.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.Fgl.setVisibility(8);
      if ((this.Fgl.getVisibility() == 8) && (this.FgB.getVisibility() == 8) && (this.FgA.getVisibility() == 8) && (this.Fgz.getVisibility() == 8) && (this.Dke.getVisibility() == 8)) {
        this.Fgb.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(31872);
      return;
      this.Fgy.pMt = this.contact;
      this.Fgy.lt(this.ETv, this.ETw);
      if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {
        this.Fgy.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.Fgz.aa(this.contact);
        boolean bool2 = this.FgA.aa(this.contact);
        if ((!bool1) && (!bool2)) {
          break label798;
        }
        this.FgB.setVisibility(8);
        break;
        this.Fgy.setVisibility(0);
      }
      label798:
      if ((this.Fgv) || (this.Fgt)) {
        this.FgB.setVisibility(8);
      }
      for (;;)
      {
        if ((this.FgD == null) || ((!this.FgD.equals("ContactWidgetBottleContact")) && (!this.FgD.equals("ContactWidgetQContact")))) {
          break label875;
        }
        this.FgB.setVisibility(8);
        break;
        this.FgB.setVisibility(0);
      }
      label875:
      break;
      label877:
      if (!bj.ox(this.yPa)) {
        break label424;
      }
      ((a.a)localObject).type = 2;
      break label424;
      label896:
      if ((this.txJ != null) && (this.txJ.length() != 0)) {
        break label1033;
      }
      ad.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.yPa + ", verifyTicket = " + this.txJ);
      this.Fgl.setVisibility(8);
      if ((this.Fgl.getVisibility() == 8) && (this.FgB.getVisibility() == 8) && (this.FgA.getVisibility() == 8) && (this.Fgz.getVisibility() == 8) && (this.Dke.getVisibility() == 8)) {
        this.Fgb.setVisibility(8);
      }
    }
    label1033:
    ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.yPa);
    if (this.yPa == 18)
    {
      ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.bk.d.aMp().aTY(this.contact.field_username);
      localObject = b.a(this.fLP, (dv[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1290;
      }
      ad.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.Fgl.setVisibility(8);
      if ((this.Fgl.getVisibility() != 8) || (this.FgB.getVisibility() != 8) || (this.FgA.getVisibility() != 8) || (this.Fgz.getVisibility() != 8) || (this.Dke.getVisibility() != 8)) {
        break;
      }
      this.Fgb.setVisibility(8);
      break;
      if (bj.ox(this.yPa))
      {
        ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.bk.d.aMq().aUx(this.contact.field_username);
        localObject = b.a(this.fLP, (cd[])localObject);
      }
      else
      {
        ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.bk.d.aMn().aTV(this.contact.field_username);
        localObject = b.a(this.fLP, (bh[])localObject);
      }
    }
    label1290:
    ad.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + localObject.length);
    int j = localObject.length;
    int i = 0;
    b localb;
    while (i < j)
    {
      localb = localObject[i];
      if (localb != null) {
        ad.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.hDo + ", addScene = " + localb.yPa);
      }
      i += 1;
    }
    if (am.aSQ(this.contact.field_username))
    {
      this.Fgl.setVisibility(8);
      this.Fgl.setHide(true);
    }
    for (;;)
    {
      if ((this.Fgl.getVisibility() == 0) || (this.FgB.getVisibility() == 0) || (this.FgA.getVisibility() == 0) || (this.Fgz.getVisibility() == 0) || (this.Dke.getVisibility() == 0)) {
        this.Fgb.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.Fgl.a(localb);
        i += 1;
      }
      break;
      this.Fgl.setVisibility(0);
      this.Fgl.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31871);
    if (this.Fgl != null) {
      this.Fgl.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(31871);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(31883);
    if (this.Fgl != null) {
      this.Fgl.detach();
    }
    if (this.Fgw) {
      com.tencent.mm.bk.d.aMo().aTT(this.contact.field_username);
    }
    this.fLP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.Fgt);
    this.fLP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.Fgu);
    ba.aBQ();
    c.azp().b(this);
    p.aEk().e(this);
    ba.aBQ();
    c.azq().b(this);
    AppMethodBeat.o(31883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */