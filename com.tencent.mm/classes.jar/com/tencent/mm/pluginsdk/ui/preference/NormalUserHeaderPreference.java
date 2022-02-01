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
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference
  extends Preference
  implements e.a, n.a, n.b
{
  private TextView DBI;
  private String FlQ;
  private String FlR;
  private Button FyA;
  private Button FyB;
  private TextView FyC;
  private ImageView FyD;
  private CheckBox FyE;
  private ImageView FyF;
  private ImageView FyG;
  private LinearLayout FyH;
  private Button FyI;
  private FMessageListView FyJ;
  private RelativeLayout FyK;
  private ImageView FyL;
  private int FyM;
  private boolean FyN;
  private boolean FyO;
  private boolean FyP;
  private boolean FyQ;
  private boolean FyR;
  private boolean FyS;
  private boolean FyT;
  private boolean FyU;
  private String FyV;
  private ProfileMobilePhoneView FyW;
  private ProfileDescribeView FyX;
  private ProfileLabelView FyY;
  private TextView FyZ;
  private TextView Fyx;
  private TextView Fyy;
  private View Fyz;
  public View.OnClickListener Fza;
  public String Fzb;
  an contact;
  MMActivity fNT;
  private String fRo;
  private boolean qnX;
  private String tIA;
  private TextView uAJ;
  private TextView uRZ;
  private ClipboardManager wAF;
  private ImageView xfA;
  private boolean xhM;
  private boolean xhS;
  private boolean xjB;
  private ImageView zeQ;
  int zfk;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31868);
    this.qnX = false;
    this.FyM = 0;
    this.FyN = false;
    this.FyO = false;
    this.FyP = false;
    this.FyQ = false;
    this.FyR = false;
    this.FyS = false;
    this.FyT = false;
    this.xjB = false;
    this.FyU = false;
    this.xhS = false;
    this.fRo = "";
    this.Fzb = null;
    this.fNT = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31868);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31869);
    this.qnX = false;
    this.FyM = 0;
    this.FyN = false;
    this.FyO = false;
    this.FyP = false;
    this.FyQ = false;
    this.FyR = false;
    this.FyS = false;
    this.FyT = false;
    this.xjB = false;
    this.FyU = false;
    this.xhS = false;
    this.fRo = "";
    this.Fzb = null;
    this.fNT = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31869);
  }
  
  private static boolean awb(String paramString)
  {
    AppMethodBeat.i(31873);
    if (com.tencent.mm.plugin.sns.b.o.zsy != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.b.o.zsy.awb(paramString);
      AppMethodBeat.o(31873);
      return bool;
    }
    AppMethodBeat.o(31873);
    return false;
  }
  
  private boolean dDJ()
  {
    return (this.qnX) && (this.contact != null);
  }
  
  private void dMP()
  {
    AppMethodBeat.i(31874);
    a.b.c(this.xfA, this.contact.field_username);
    int i;
    if (this.xfA != null)
    {
      i = com.tencent.mm.cb.a.ax(this.mContext, 2131165188);
      int j = com.tencent.mm.cb.a.fromDPToPix(this.fNT, 88);
      if (i <= j) {
        break label95;
      }
      i = j;
    }
    label95:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.ay(this.mContext, 2131165483), 0);
      this.xfA.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(31874);
      return;
    }
  }
  
  private void fiA()
  {
    AppMethodBeat.i(31886);
    if ((v.zK(this.contact.field_username)) || (bu.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.Fyy.setVisibility(8);
      this.uAJ.setText(k.b(this.fNT, bu.nullAsNil(this.contact.adF()) + " ", this.uAJ.getTextSize()));
      if (this.FyT)
      {
        this.FyA.setVisibility(0);
        this.FyZ.setVisibility(8);
        if (an.aUq(this.contact.field_username))
        {
          this.FyZ.setText(2131757927);
          fiB();
        }
        if ((!this.xjB) || (com.tencent.mm.contact.c.lO(this.contact.field_type))) {
          break label560;
        }
        this.FyB.setVisibility(0);
      }
    }
    for (;;)
    {
      if (an.Ac(this.contact.field_username)) {
        this.uAJ.setText("");
      }
      if ((this.zfk == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.uAJ.setText(k.b(this.fNT, bu.nullAsNil(this.contact.field_nickname) + " ", this.uAJ.getTextSize()));
      }
      if ((this.FyB.getVisibility() == 0) && (this.Fyy.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Fyy.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165568);
        this.Fyy.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(31886);
      return;
      if (this.FyR)
      {
        this.FyA.setVisibility(0);
        this.FyZ.setVisibility(8);
        break;
      }
      if (com.tencent.mm.contact.c.lO(this.contact.field_type)) {
        this.FyA.setVisibility(8);
      }
      boolean bool1 = this.FyX.ah(this.contact);
      boolean bool2 = this.FyY.ah(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.FyZ.setVisibility(8);
      break;
      this.uAJ.setText(k.b(this.fNT, bu.nullAsNil(this.contact.field_conRemark) + " ", this.uAJ.getTextSize()));
      this.Fyy.setVisibility(0);
      this.Fyy.setText(k.b(this.fNT, this.mContext.getString(2131757742) + this.contact.adF(), this.Fyy.getTextSize()));
      this.FyA.setVisibility(8);
      break;
      label560:
      if (this.FyS)
      {
        this.FyB.setVisibility(0);
        if (com.tencent.mm.cb.a.ir(this.fNT))
        {
          this.FyB.setTextSize(0, this.fNT.getResources().getDimensionPixelSize(2131165466));
          this.FyA.setTextSize(0, this.fNT.getResources().getDimensionPixelSize(2131165466));
        }
      }
      else
      {
        this.FyB.setVisibility(8);
      }
    }
  }
  
  private void fiB()
  {
    AppMethodBeat.i(31887);
    if (this.FyH == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    View localView = this.FyH.findViewById(2131301430);
    if (localView == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(31887);
  }
  
  private void fiC()
  {
    AppMethodBeat.i(31888);
    this.FyE.setClickable(false);
    if (((x.zS(this.contact.field_username)) || (an.aUq(this.contact.field_username))) && (com.tencent.mm.contact.c.lO(this.contact.field_type)) && (!v.zK(this.contact.field_username)))
    {
      this.FyE.setVisibility(0);
      if (this.contact.adx())
      {
        this.FyE.setChecked(true);
        this.FyQ = true;
        AppMethodBeat.o(31888);
        return;
      }
      this.FyE.setChecked(false);
      this.FyE.setVisibility(8);
      this.FyQ = false;
      AppMethodBeat.o(31888);
      return;
    }
    this.FyQ = false;
    this.FyE.setVisibility(8);
    AppMethodBeat.o(31888);
  }
  
  private void fiD()
  {
    AppMethodBeat.i(31892);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      this.FyK.setVisibility(8);
      AppMethodBeat.o(31892);
      return;
    }
    com.tencent.mm.plugin.story.api.e locale = (com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.FyK.setVisibility(0);
      this.FyL.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.FyH.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.fNT, 166);
      this.FyH.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.fRo);
      AppMethodBeat.o(31892);
      return;
      this.FyK.setVisibility(8);
      this.FyL.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.FyH.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.FyH.setLayoutParams(localLayoutParams);
    }
  }
  
  private void fiv()
  {
    AppMethodBeat.i(31875);
    this.FyC.setVisibility(0);
    this.uAJ.setText(k.b(this.fNT, bu.nullAsNil(this.contact.adF()) + " ", this.uAJ.getTextSize()));
    dMP();
    this.FyI.setVisibility(8);
    this.uRZ.setVisibility(8);
    this.FyJ.setVisibility(8);
    if ((this.FyJ.getVisibility() == 8) && (this.FyZ.getVisibility() == 8) && (this.FyY.getVisibility() == 8) && (this.FyX.getVisibility() == 8) && (this.DBI.getVisibility() == 8)) {
      this.Fyz.setVisibility(8);
    }
    this.FyA.setVisibility(8);
    this.FyB.setVisibility(8);
    this.FyE.setVisibility(8);
    if (this.FyY != null) {
      this.FyY.setVisibility(8);
    }
    if (this.FyW != null) {
      this.FyW.setVisibility(8);
    }
    if (this.FyX != null) {
      this.FyX.setVisibility(8);
    }
    if (this.FyZ != null) {
      this.FyZ.setVisibility(8);
    }
    if (this.Fyy != null) {
      this.Fyy.setVisibility(8);
    }
    AppMethodBeat.o(31875);
  }
  
  private void fix()
  {
    AppMethodBeat.i(31878);
    int i = 0;
    if (this.FyP) {
      i = com.tencent.mm.cb.a.fromDPToPix(this.fNT, 17) + 0;
    }
    int j = i + this.FyM;
    i = j;
    if (this.FyN) {
      i = j + com.tencent.mm.cb.a.fromDPToPix(this.fNT, 27);
    }
    j = i;
    if (this.FyO) {
      j = i + com.tencent.mm.cb.a.fromDPToPix(this.fNT, 27);
    }
    i = j;
    if (this.FyQ) {
      i = j + com.tencent.mm.cb.a.fromDPToPix(this.fNT, 30);
    }
    if (com.tencent.mm.cb.a.ir(this.mContext)) {
      i += com.tencent.mm.cb.a.fromDPToPix(this.fNT, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cb.a.fromDPToPix(this.fNT, 60);
      DisplayMetrics localDisplayMetrics = this.fNT.getResources().getDisplayMetrics();
      this.uAJ.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(31878);
      return;
      i += com.tencent.mm.cb.a.fromDPToPix(this.fNT, 64);
    }
  }
  
  private void fiy()
  {
    int j = 0;
    AppMethodBeat.i(31884);
    ImageView localImageView;
    if ((this.FyF != null) && (x.zS(this.contact.field_username)))
    {
      this.FyO = this.contact.ady();
      localImageView = this.FyF;
      if (this.FyO)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.FyG != null) && (x.zS(this.contact.field_username)))
    {
      this.FyN = awb(this.contact.field_username);
      localImageView = this.FyG;
      if (!this.FyN) {
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
  
  private void fiz()
  {
    AppMethodBeat.i(31885);
    if (bu.isNullOrNil(this.FyV))
    {
      this.Fyx.setVisibility(8);
      AppMethodBeat.o(31885);
      return;
    }
    if ((!v.zK(this.contact.field_username)) && (bu.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.uRZ.setVisibility(8);
    }
    this.Fyx.setVisibility(0);
    this.Fyx.setText(k.b(this.fNT, this.fNT.getString(2131757629) + this.FyV, this.Fyx.getTextSize()));
    AppMethodBeat.o(31885);
  }
  
  private void init()
  {
    AppMethodBeat.i(31870);
    this.qnX = false;
    this.wAF = ((ClipboardManager)ak.getContext().getSystemService("clipboard"));
    AppMethodBeat.o(31870);
  }
  
  private void initView()
  {
    AppMethodBeat.i(31876);
    if (!dDJ())
    {
      ae.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.qnX + "contact = " + this.contact);
      AppMethodBeat.o(31876);
      return;
    }
    if (this.xhS)
    {
      fiv();
      AppMethodBeat.o(31876);
      return;
    }
    boolean bool = an.Ac(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.uAJ.setText("");
      if (an.aUA(v.aAC()).equals(this.contact.field_username)) {
        this.FyI.setVisibility(8);
      }
      this.zeQ.setVisibility(0);
      this.FyP = true;
      if (this.contact.eQV != 1) {
        break label495;
      }
      this.zeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.fNT, 2131690323));
      this.zeQ.setContentDescription(this.mContext.getString(2131762052));
      if (this.contact.field_verifyFlag != 0)
      {
        this.FyD.setVisibility(0);
        if (au.a.hII == null) {
          break label570;
        }
        localBitmap = BackwardSupportUtil.b.p(au.a.hII.ou(this.contact.field_verifyFlag), 2.0F);
        this.FyD.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label575;
        }
        i = 0;
        label245:
        this.FyM = i;
      }
      dMP();
      fiD();
      this.xfA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31858);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username;
          paramAnonymousView = (View)localObject;
          if (an.Ac((String)localObject)) {
            paramAnonymousView = an.aUA((String)localObject);
          }
          localObject = new Intent(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", paramAnonymousView);
          paramAnonymousView = NormalUserHeaderPreference.b(NormalUserHeaderPreference.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31858);
        }
      });
      this.FyL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31859);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.story.api.o.bk(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31859);
        }
      });
      if (!an.aUp(this.contact.field_username)) {
        break label583;
      }
      this.uRZ.setText(this.mContext.getString(2131755753) + this.contact.adH());
      label341:
      if (!x.AQ(this.contact.field_username)) {
        break label896;
      }
      this.DBI.setVisibility(0);
    }
    for (;;)
    {
      fiA();
      fiy();
      fiC();
      fiz();
      this.FyA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31860);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          NormalUserHeaderPreference.c(NormalUserHeaderPreference.this);
          paramAnonymousView = NormalUserHeaderPreference.this;
          bc.aCg();
          localObject = com.tencent.mm.model.c.azF().BH(paramAnonymousView.contact.field_username);
          if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).ght != 0) && (((aw)localObject).field_username.equals(paramAnonymousView.contact.field_username))) {
            paramAnonymousView.contact = ((an)localObject);
          }
          if (!com.tencent.mm.contact.c.lO(paramAnonymousView.contact.field_type))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.zfk);
            ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
            ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.contact.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousView.contact.field_conRemark);
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31860);
            return;
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.zfk);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_RoomNickname", paramAnonymousView.fNT.getIntent().getStringExtra("Contact_RoomNickname"));
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      });
      this.FyB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31861);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 3);
          com.tencent.mm.br.d.b(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31861);
        }
      });
      fix();
      this.uRZ.setLongClickable(true);
      this.uRZ.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31865);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
            ((com.tencent.mm.ui.widget.b.a)localObject).LwG = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(31862);
                paramAnonymous2ContextMenu.add(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755701));
                AppMethodBeat.o(31862);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).LfT = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(31863);
                if (paramAnonymous2Int == 0)
                {
                  NormalUserHeaderPreference.e(NormalUserHeaderPreference.this).setText(paramAnonymousView);
                  h.cl(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755702));
                }
                AppMethodBeat.o(31863);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).LhV = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(31864);
                NormalUserHeaderPreference.this.fiw();
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
      this.uAJ.setText(k.b(this.fNT, bu.nullAsNil(this.contact.field_nickname) + " ", this.uAJ.getTextSize()));
      break;
      label495:
      if (this.contact.eQV == 2)
      {
        this.zeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.fNT, 2131690322));
        this.zeQ.setContentDescription(this.mContext.getString(2131762051));
        break label187;
      }
      if (this.contact.eQV != 0) {
        break label187;
      }
      this.zeQ.setVisibility(8);
      this.FyP = false;
      break label187;
      label570:
      localBitmap = null;
      break label231;
      label575:
      i = localBitmap.getWidth();
      break label245;
      label583:
      if (an.aUn(this.contact.field_username))
      {
        this.uRZ.setText(this.mContext.getString(2131755766) + this.contact.adH());
        break label341;
      }
      if (this.xhM)
      {
        if (com.tencent.mm.contact.c.lO(this.contact.field_type))
        {
          fiw();
          break label341;
        }
        if ((this.contact.eRh == null) || (this.contact.eRh.equals("")))
        {
          this.uRZ.setText(2131755726);
          break label341;
        }
        this.uRZ.setText(this.contact.eRh);
        break label341;
      }
      if (bool)
      {
        this.uRZ.setText((bu.nullAsNil(w.zR(this.contact.getProvince())) + " " + bu.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!an.aUo(this.contact.field_username)) && (this.fNT.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((bu.isNullOrNil(this.contact.VI())) && ((an.aUy(this.contact.field_username)) || (x.Am(this.contact.field_username))))
        {
          this.uRZ.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.contact.c.lO(this.contact.field_type))
        {
          fiw();
          break label341;
        }
      }
      this.uRZ.setVisibility(8);
      break label341;
      label896:
      this.DBI.setVisibility(8);
    }
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(31889);
    if (!dDJ())
    {
      ae.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.qnX + "contact = " + this.contact);
      AppMethodBeat.o(31889);
      return;
    }
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      ae.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(paramString)));
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
    ae.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(31890);
      return;
    }
    paramn = (String)paramObject;
    ae.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + paramn + ", contact = " + this.contact);
    if (!dDJ())
    {
      ae.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.qnX + "contact = " + this.contact);
      AppMethodBeat.o(31890);
      return;
    }
    if (bu.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(31890);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      bc.aCg();
      this.contact = com.tencent.mm.model.c.azF().BH(paramn);
      ar.f(new Runnable()
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
            if (com.tencent.mm.contact.c.lO(NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_type)) {
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
  
  public final void a(an paraman, int paramInt, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31882);
    onDetach();
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this);
    bc.aCg();
    com.tencent.mm.model.c.azG().a(this);
    p.aEA().d(this);
    this.contact = paraman;
    this.zfk = paramInt;
    this.tIA = paramString;
    this.xhM = this.fNT.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
    this.FyU = this.fNT.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
    this.FyR = this.fNT.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
    this.FyS = this.fNT.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
    this.FyT = this.fNT.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
    this.xjB = this.fNT.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
    this.FyV = this.fNT.getIntent().getStringExtra("Contact_RoomNickname");
    if (paraman.field_deleteFlag == 1)
    {
      bool1 = true;
      this.xhS = bool1;
      this.fRo = this.fNT.getIntent().getStringExtra("room_name");
      if (bu.nullAsNil(paraman.field_username).length() <= 0) {
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
  
  public final void a(an paraman, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31881);
    this.FlQ = paramString2;
    this.FlR = paramString3;
    a(paraman, paramInt, paramString1);
    AppMethodBeat.o(31881);
  }
  
  public final void a(final cg paramcg)
  {
    AppMethodBeat.i(31891);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31867);
        if ((NormalUserHeaderPreference.a(NormalUserHeaderPreference.this) != null) && (paramcg != null) && (NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username.equals(paramcg.field_encryptUsername)))
        {
          NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).tm(paramcg.field_conRemark);
          if (!NormalUserHeaderPreference.j(NormalUserHeaderPreference.this))
          {
            ae.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.k(NormalUserHeaderPreference.this) + "contact = " + NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
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
  
  public final void cH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31879);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.FyR = paramBoolean;
    }
    AppMethodBeat.o(31879);
  }
  
  public final void cI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31880);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.FyS = paramBoolean;
    }
    AppMethodBeat.o(31880);
  }
  
  public final void fiw()
  {
    AppMethodBeat.i(31877);
    this.uRZ.setVisibility(0);
    if (!bu.isNullOrNil(this.contact.VI()))
    {
      this.uRZ.setText(this.mContext.getString(2131755760) + this.contact.VI());
      AppMethodBeat.o(31877);
      return;
    }
    if ((!an.aUy(this.contact.field_username)) && (!x.Am(this.contact.field_username)))
    {
      String str = bu.nullAsNil(this.contact.adH());
      this.uRZ.setText(this.mContext.getString(2131755760) + str);
      AppMethodBeat.o(31877);
      return;
    }
    this.uRZ.setVisibility(8);
    AppMethodBeat.o(31877);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31872);
    ae.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.uAJ = ((TextView)paramView.findViewById(2131298631));
    this.uRZ = ((TextView)paramView.findViewById(2131298662));
    this.FyC = ((TextView)paramView.findViewById(2131298595));
    this.Fyx = ((TextView)paramView.findViewById(2131298607));
    this.Fyy = ((TextView)paramView.findViewById(2131298632));
    this.FyA = ((Button)paramView.findViewById(2131298637));
    this.FyB = ((Button)paramView.findViewById(2131298645));
    this.FyW = ((ProfileMobilePhoneView)paramView.findViewById(2131302365));
    Object localObject = this.FyW;
    bc.aCg();
    ((ProfileMobilePhoneView)localObject).Fmc = ((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INo, Boolean.FALSE)).booleanValue();
    this.FyX = ((ProfileDescribeView)paramView.findViewById(2131299003));
    this.FyY = ((ProfileLabelView)paramView.findViewById(2131301284));
    this.FyZ = ((TextView)paramView.findViewById(2131304604));
    this.FyX.setOnClickListener(this.Fza);
    this.FyY.setOnClickListener(this.Fza);
    this.FyZ.setOnClickListener(this.Fza);
    if ((v.zK(this.contact.field_username)) || ((!bu.isNullOrNil(this.contact.field_username)) && (x.AQ(this.contact.field_username))))
    {
      this.FyZ.setVisibility(8);
      this.FyW.setVisibility(8);
      this.FyX.setVisibility(8);
      this.FyY.setVisibility(8);
      this.DBI = ((TextView)paramView.findViewById(2131298618));
      this.FyI = ((Button)paramView.findViewById(2131298612));
      this.FyJ = ((FMessageListView)paramView.findViewById(2131298613));
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.zfk;
      ((a.a)localObject).tIA = this.tIA;
      ((a.a)localObject).Fyj = this.contact.eRv;
      ((a.a)localObject).type = 0;
      if (this.zfk != 18) {
        break label877;
      }
      ((a.a)localObject).type = 1;
      label424:
      this.FyJ.setFMessageArgs((a.a)localObject);
      this.Fyz = paramView.findViewById(2131304845);
      this.FyH = ((LinearLayout)paramView.findViewById(2131300699));
      this.xfA = ((ImageView)paramView.findViewById(2131298597));
      this.zeQ = ((ImageView)paramView.findViewById(2131298642));
      this.FyD = ((ImageView)paramView.findViewById(2131298669));
      this.FyE = ((CheckBox)paramView.findViewById(2131298646));
      this.FyF = ((ImageView)paramView.findViewById(2131298644));
      this.FyG = ((ImageView)paramView.findViewById(2131298643));
      this.FyL = ((ImageView)paramView.findViewById(2131298659));
      this.FyK = ((RelativeLayout)paramView.findViewById(2131298660));
      this.qnX = true;
      initView();
      if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
        break label896;
      }
      ae.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.FyJ.setVisibility(8);
      if ((this.FyJ.getVisibility() == 8) && (this.FyZ.getVisibility() == 8) && (this.FyY.getVisibility() == 8) && (this.FyX.getVisibility() == 8) && (this.DBI.getVisibility() == 8)) {
        this.Fyz.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(31872);
      return;
      this.FyW.pSY = this.contact;
      this.FyW.lA(this.FlQ, this.FlR);
      if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
        this.FyW.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.FyX.ah(this.contact);
        boolean bool2 = this.FyY.ah(this.contact);
        if ((!bool1) && (!bool2)) {
          break label798;
        }
        this.FyZ.setVisibility(8);
        break;
        this.FyW.setVisibility(0);
      }
      label798:
      if ((this.FyT) || (this.FyR)) {
        this.FyZ.setVisibility(8);
      }
      for (;;)
      {
        if ((this.Fzb == null) || ((!this.Fzb.equals("ContactWidgetBottleContact")) && (!this.Fzb.equals("ContactWidgetQContact")))) {
          break label875;
        }
        this.FyZ.setVisibility(8);
        break;
        this.FyZ.setVisibility(0);
      }
      label875:
      break;
      label877:
      if (!bl.oA(this.zfk)) {
        break label424;
      }
      ((a.a)localObject).type = 2;
      break label424;
      label896:
      if ((this.tIA != null) && (this.tIA.length() != 0)) {
        break label1033;
      }
      ae.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.zfk + ", verifyTicket = " + this.tIA);
      this.FyJ.setVisibility(8);
      if ((this.FyJ.getVisibility() == 8) && (this.FyZ.getVisibility() == 8) && (this.FyY.getVisibility() == 8) && (this.FyX.getVisibility() == 8) && (this.DBI.getVisibility() == 8)) {
        this.Fyz.setVisibility(8);
      }
    }
    label1033:
    ae.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.zfk);
    if (this.zfk == 18)
    {
      ae.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.bj.d.aMN().aVz(this.contact.field_username);
      localObject = b.a(this.fNT, (dv[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1290;
      }
      ae.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.FyJ.setVisibility(8);
      if ((this.FyJ.getVisibility() != 8) || (this.FyZ.getVisibility() != 8) || (this.FyY.getVisibility() != 8) || (this.FyX.getVisibility() != 8) || (this.DBI.getVisibility() != 8)) {
        break;
      }
      this.Fyz.setVisibility(8);
      break;
      if (bl.oA(this.zfk))
      {
        ae.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.bj.d.aMO().aVY(this.contact.field_username);
        localObject = b.a(this.fNT, (ce[])localObject);
      }
      else
      {
        ae.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.bj.d.aML().aVw(this.contact.field_username);
        localObject = b.a(this.fNT, (bi[])localObject);
      }
    }
    label1290:
    ae.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + localObject.length);
    int j = localObject.length;
    int i = 0;
    b localb;
    while (i < j)
    {
      localb = localObject[i];
      if (localb != null) {
        ae.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.hGg + ", addScene = " + localb.zfk);
      }
      i += 1;
    }
    if (an.aUq(this.contact.field_username))
    {
      this.FyJ.setVisibility(8);
      this.FyJ.setHide(true);
    }
    for (;;)
    {
      if ((this.FyJ.getVisibility() == 0) || (this.FyZ.getVisibility() == 0) || (this.FyY.getVisibility() == 0) || (this.FyX.getVisibility() == 0) || (this.DBI.getVisibility() == 0)) {
        this.Fyz.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.FyJ.a(localb);
        i += 1;
      }
      break;
      this.FyJ.setVisibility(0);
      this.FyJ.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31871);
    if (this.FyJ != null) {
      this.FyJ.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(31871);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(31883);
    if (this.FyJ != null) {
      this.FyJ.detach();
    }
    if (this.FyU) {
      com.tencent.mm.bj.d.aMM().aVu(this.contact.field_username);
    }
    this.fNT.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.FyR);
    this.fNT.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.FyS);
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this);
    p.aEA().e(this);
    bc.aCg();
    com.tencent.mm.model.c.azG().b(this);
    AppMethodBeat.o(31883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */