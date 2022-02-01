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
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference
  extends Preference
  implements e.a, m.a, n.b
{
  private TextView Ars;
  private String BVY;
  private String BVZ;
  private TextView CiB;
  private TextView CiC;
  private View CiD;
  private Button CiE;
  private Button CiF;
  private TextView CiG;
  private ImageView CiH;
  private CheckBox CiI;
  private ImageView CiJ;
  private ImageView CiK;
  private LinearLayout CiL;
  private Button CiM;
  private FMessageListView CiN;
  private RelativeLayout CiO;
  private ImageView CiP;
  private int CiQ;
  private boolean CiR;
  private boolean CiS;
  private boolean CiT;
  private boolean CiU;
  private boolean CiV;
  private boolean CiW;
  private boolean CiX;
  private boolean CiY;
  private String CiZ;
  private ProfileMobilePhoneView Cja;
  private ProfileDescribeView Cjb;
  private ProfileLabelView Cjc;
  private TextView Cjd;
  public View.OnClickListener Cje;
  public String Cjf;
  af contact;
  private String fss;
  MMActivity imP;
  private boolean paC;
  private String rso;
  private TextView siX;
  private TextView svO;
  private ClipboardManager tWQ;
  private boolean uBT;
  private boolean uBZ;
  private boolean uDK;
  private ImageView uzJ;
  private ImageView woF;
  int woZ;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31868);
    this.paC = false;
    this.CiQ = 0;
    this.CiR = false;
    this.CiS = false;
    this.CiT = false;
    this.CiU = false;
    this.CiV = false;
    this.CiW = false;
    this.CiX = false;
    this.uDK = false;
    this.CiY = false;
    this.uBZ = false;
    this.fss = "";
    this.Cjf = null;
    this.imP = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31868);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31869);
    this.paC = false;
    this.CiQ = 0;
    this.CiR = false;
    this.CiS = false;
    this.CiT = false;
    this.CiU = false;
    this.CiV = false;
    this.CiW = false;
    this.CiX = false;
    this.uDK = false;
    this.CiY = false;
    this.uBZ = false;
    this.fss = "";
    this.Cjf = null;
    this.imP = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31869);
  }
  
  private static boolean akH(String paramString)
  {
    AppMethodBeat.i(31873);
    if (com.tencent.mm.plugin.sns.c.o.wzJ != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.c.o.wzJ.akH(paramString);
      AppMethodBeat.o(31873);
      return bool;
    }
    AppMethodBeat.o(31873);
    return false;
  }
  
  private boolean dch()
  {
    return (this.paC) && (this.contact != null);
  }
  
  private void dkd()
  {
    AppMethodBeat.i(31874);
    a.b.c(this.uzJ, this.contact.field_username);
    int i;
    if (this.uzJ != null)
    {
      i = com.tencent.mm.cd.a.ao(this.mContext, 2131165188);
      int j = com.tencent.mm.cd.a.fromDPToPix(this.imP, 88);
      if (i <= j) {
        break label95;
      }
      i = j;
    }
    label95:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cd.a.ap(this.mContext, 2131165483), 0);
      this.uzJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(31874);
      return;
    }
  }
  
  private void eAj()
  {
    AppMethodBeat.i(31875);
    this.CiG.setVisibility(0);
    this.siX.setText(k.b(this.imP, bt.nullAsNil(this.contact.ZW()) + " ", this.siX.getTextSize()));
    dkd();
    this.CiM.setVisibility(8);
    this.svO.setVisibility(8);
    this.CiN.setVisibility(8);
    if ((this.CiN.getVisibility() == 8) && (this.Cjd.getVisibility() == 8) && (this.Cjc.getVisibility() == 8) && (this.Cjb.getVisibility() == 8) && (this.Ars.getVisibility() == 8)) {
      this.CiD.setVisibility(8);
    }
    this.CiE.setVisibility(8);
    this.CiF.setVisibility(8);
    this.CiI.setVisibility(8);
    if (this.Cjc != null) {
      this.Cjc.setVisibility(8);
    }
    if (this.Cja != null) {
      this.Cja.setVisibility(8);
    }
    if (this.Cjb != null) {
      this.Cjb.setVisibility(8);
    }
    if (this.Cjd != null) {
      this.Cjd.setVisibility(8);
    }
    if (this.CiC != null) {
      this.CiC.setVisibility(8);
    }
    AppMethodBeat.o(31875);
  }
  
  private void eAl()
  {
    AppMethodBeat.i(31878);
    int i = 0;
    if (this.CiT) {
      i = com.tencent.mm.cd.a.fromDPToPix(this.imP, 17) + 0;
    }
    int j = i + this.CiQ;
    i = j;
    if (this.CiR) {
      i = j + com.tencent.mm.cd.a.fromDPToPix(this.imP, 27);
    }
    j = i;
    if (this.CiS) {
      j = i + com.tencent.mm.cd.a.fromDPToPix(this.imP, 27);
    }
    i = j;
    if (this.CiU) {
      i = j + com.tencent.mm.cd.a.fromDPToPix(this.imP, 30);
    }
    if (com.tencent.mm.cd.a.hS(this.mContext)) {
      i += com.tencent.mm.cd.a.fromDPToPix(this.imP, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cd.a.fromDPToPix(this.imP, 60);
      DisplayMetrics localDisplayMetrics = this.imP.getResources().getDisplayMetrics();
      this.siX.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(31878);
      return;
      i += com.tencent.mm.cd.a.fromDPToPix(this.imP, 64);
    }
  }
  
  private void eAm()
  {
    int j = 0;
    AppMethodBeat.i(31884);
    ImageView localImageView;
    if ((this.CiJ != null) && (w.sk(this.contact.field_username)))
    {
      this.CiS = this.contact.ZP();
      localImageView = this.CiJ;
      if (this.CiS)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.CiK != null) && (w.sk(this.contact.field_username)))
    {
      this.CiR = akH(this.contact.field_username);
      localImageView = this.CiK;
      if (!this.CiR) {
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
  
  private void eAn()
  {
    AppMethodBeat.i(31885);
    if (bt.isNullOrNil(this.CiZ))
    {
      this.CiB.setVisibility(8);
      AppMethodBeat.o(31885);
      return;
    }
    if ((!u.se(this.contact.field_username)) && (bt.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.svO.setVisibility(8);
    }
    this.CiB.setVisibility(0);
    this.CiB.setText(k.b(this.imP, this.imP.getString(2131757629) + this.CiZ, this.CiB.getTextSize()));
    AppMethodBeat.o(31885);
  }
  
  private void eAo()
  {
    AppMethodBeat.i(31886);
    if ((u.se(this.contact.field_username)) || (bt.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.CiC.setVisibility(8);
      this.siX.setText(k.b(this.imP, bt.nullAsNil(this.contact.ZW()) + " ", this.siX.getTextSize()));
      if (this.CiX)
      {
        this.CiE.setVisibility(0);
        this.Cjd.setVisibility(8);
        if (af.aHH(this.contact.field_username))
        {
          this.Cjd.setText(2131757927);
          eAp();
        }
        if ((!this.uDK) || (com.tencent.mm.n.b.ls(this.contact.field_type))) {
          break label560;
        }
        this.CiF.setVisibility(0);
      }
    }
    for (;;)
    {
      if (af.st(this.contact.field_username)) {
        this.siX.setText("");
      }
      if ((this.woZ == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.siX.setText(k.b(this.imP, bt.nullAsNil(this.contact.field_nickname) + " ", this.siX.getTextSize()));
      }
      if ((this.CiF.getVisibility() == 0) && (this.CiC.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.CiC.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165568);
        this.CiC.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(31886);
      return;
      if (this.CiV)
      {
        this.CiE.setVisibility(0);
        this.Cjd.setVisibility(8);
        break;
      }
      if (com.tencent.mm.n.b.ls(this.contact.field_type)) {
        this.CiE.setVisibility(8);
      }
      boolean bool1 = this.Cjb.Z(this.contact);
      boolean bool2 = this.Cjc.Z(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.Cjd.setVisibility(8);
      break;
      this.siX.setText(k.b(this.imP, bt.nullAsNil(this.contact.field_conRemark) + " ", this.siX.getTextSize()));
      this.CiC.setVisibility(0);
      this.CiC.setText(k.b(this.imP, this.mContext.getString(2131757742) + this.contact.ZW(), this.CiC.getTextSize()));
      this.CiE.setVisibility(8);
      break;
      label560:
      if (this.CiW)
      {
        this.CiF.setVisibility(0);
        if (com.tencent.mm.cd.a.hS(this.imP))
        {
          this.CiF.setTextSize(0, this.imP.getResources().getDimensionPixelSize(2131165466));
          this.CiE.setTextSize(0, this.imP.getResources().getDimensionPixelSize(2131165466));
        }
      }
      else
      {
        this.CiF.setVisibility(8);
      }
    }
  }
  
  private void eAp()
  {
    AppMethodBeat.i(31887);
    if (this.CiL == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    View localView = this.CiL.findViewById(2131301430);
    if (localView == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(31887);
  }
  
  private void eAq()
  {
    AppMethodBeat.i(31888);
    this.CiI.setClickable(false);
    if (((w.sk(this.contact.field_username)) || (af.aHH(this.contact.field_username))) && (com.tencent.mm.n.b.ls(this.contact.field_type)) && (!u.se(this.contact.field_username)))
    {
      this.CiI.setVisibility(0);
      if (this.contact.ZO())
      {
        this.CiI.setChecked(true);
        this.CiU = true;
        AppMethodBeat.o(31888);
        return;
      }
      this.CiI.setChecked(false);
      this.CiI.setVisibility(8);
      this.CiU = false;
      AppMethodBeat.o(31888);
      return;
    }
    this.CiU = false;
    this.CiI.setVisibility(8);
    AppMethodBeat.o(31888);
  }
  
  private void eAr()
  {
    AppMethodBeat.i(31892);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      this.CiO.setVisibility(8);
      AppMethodBeat.o(31892);
      return;
    }
    com.tencent.mm.plugin.story.api.e locale = (com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.CiO.setVisibility(0);
      this.CiP.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.CiL.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this.imP, 166);
      this.CiL.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.fss);
      AppMethodBeat.o(31892);
      return;
      this.CiO.setVisibility(8);
      this.CiP.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.CiL.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.CiL.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(31870);
    this.paC = false;
    this.tWQ = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    AppMethodBeat.o(31870);
  }
  
  private void initView()
  {
    AppMethodBeat.i(31876);
    if (!dch())
    {
      ad.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.paC + "contact = " + this.contact);
      AppMethodBeat.o(31876);
      return;
    }
    if (this.uBZ)
    {
      eAj();
      AppMethodBeat.o(31876);
      return;
    }
    boolean bool = af.st(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.siX.setText("");
      if (af.aHM(u.aqG()).equals(this.contact.field_username)) {
        this.CiM.setVisibility(8);
      }
      this.woF.setVisibility(0);
      this.CiT = true;
      if (this.contact.evp != 1) {
        break label495;
      }
      this.woF.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131690323));
      this.woF.setContentDescription(this.mContext.getString(2131762052));
      if (this.contact.field_verifyFlag != 0)
      {
        this.CiH.setVisibility(0);
        if (ar.a.gMY == null) {
          break label570;
        }
        localBitmap = BackwardSupportUtil.b.n(ar.a.gMY.nd(this.contact.field_verifyFlag), 2.0F);
        this.CiH.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label575;
        }
        i = 0;
        label245:
        this.CiQ = i;
      }
      dkd();
      eAr();
      this.uzJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31858);
          Object localObject = NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username;
          paramAnonymousView = (View)localObject;
          if (af.st((String)localObject)) {
            paramAnonymousView = af.aHM((String)localObject);
          }
          localObject = new Intent(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", paramAnonymousView);
          paramAnonymousView = NormalUserHeaderPreference.b(NormalUserHeaderPreference.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(31858);
        }
      });
      this.CiP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31859);
          com.tencent.mm.plugin.story.api.o.be(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          AppMethodBeat.o(31859);
        }
      });
      if (!af.aHG(this.contact.field_username)) {
        break label583;
      }
      this.svO.setText(this.mContext.getString(2131755753) + this.contact.ZY());
      label341:
      if (!w.tg(this.contact.field_username)) {
        break label896;
      }
      this.Ars.setVisibility(0);
    }
    for (;;)
    {
      eAo();
      eAm();
      eAq();
      eAn();
      this.CiE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31860);
          NormalUserHeaderPreference.c(NormalUserHeaderPreference.this);
          paramAnonymousView = NormalUserHeaderPreference.this;
          com.tencent.mm.model.az.arV();
          Object localObject = c.apM().aHY(paramAnonymousView.contact.field_username);
          if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fId != 0) && (((au)localObject).field_username.equals(paramAnonymousView.contact.field_username))) {
            paramAnonymousView.contact = ((af)localObject);
          }
          if (!com.tencent.mm.n.b.ls(paramAnonymousView.contact.field_type))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.woZ);
            ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
            ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.contact.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousView.contact.field_conRemark);
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(31860);
            return;
          }
          localObject = new Intent();
          ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
          ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.woZ);
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
          ((Intent)localObject).putExtra("Contact_RoomNickname", paramAnonymousView.imP.getIntent().getStringExtra("Contact_RoomNickname"));
          paramAnonymousView = (Activity)paramAnonymousView.mContext;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(31860);
        }
      });
      this.CiF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31861);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 3);
          com.tencent.mm.bs.d.b(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          AppMethodBeat.o(31861);
        }
      });
      eAl();
      this.svO.setLongClickable(true);
      this.svO.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31865);
          if ((NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText() != null) && (NormalUserHeaderPreference.e(NormalUserHeaderPreference.this) != null))
          {
            Object localObject = NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText().toString();
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
            ((com.tencent.mm.ui.widget.b.a)localObject).HIu = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(31862);
                paramAnonymous2ContextMenu.add(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755701));
                AppMethodBeat.o(31862);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).HrY = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(31863);
                if (paramAnonymous2Int == 0)
                {
                  NormalUserHeaderPreference.e(NormalUserHeaderPreference.this).setText(paramAnonymousView);
                  h.ce(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755702));
                }
                AppMethodBeat.o(31863);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).Hua = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(31864);
                NormalUserHeaderPreference.this.eAk();
                AppMethodBeat.o(31864);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).eh(0, 0);
          }
          AppMethodBeat.o(31865);
          return true;
        }
      });
      AppMethodBeat.o(31876);
      return;
      this.siX.setText(k.b(this.imP, bt.nullAsNil(this.contact.field_nickname) + " ", this.siX.getTextSize()));
      break;
      label495:
      if (this.contact.evp == 2)
      {
        this.woF.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131690322));
        this.woF.setContentDescription(this.mContext.getString(2131762051));
        break label187;
      }
      if (this.contact.evp != 0) {
        break label187;
      }
      this.woF.setVisibility(8);
      this.CiT = false;
      break label187;
      label570:
      localBitmap = null;
      break label231;
      label575:
      i = localBitmap.getWidth();
      break label245;
      label583:
      if (af.aHE(this.contact.field_username))
      {
        this.svO.setText(this.mContext.getString(2131755766) + this.contact.ZY());
        break label341;
      }
      if (this.uBT)
      {
        if (com.tencent.mm.n.b.ls(this.contact.field_type))
        {
          eAk();
          break label341;
        }
        if ((this.contact.evB == null) || (this.contact.evB.equals("")))
        {
          this.svO.setText(2131755726);
          break label341;
        }
        this.svO.setText(this.contact.evB);
        break label341;
      }
      if (bool)
      {
        this.svO.setText((bt.nullAsNil(v.sj(this.contact.getProvince())) + " " + bt.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!af.aHF(this.contact.field_username)) && (this.imP.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((bt.isNullOrNil(this.contact.Ss())) && ((af.aHK(this.contact.field_username)) || (w.sC(this.contact.field_username))))
        {
          this.svO.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.n.b.ls(this.contact.field_type))
        {
          eAk();
          break label341;
        }
      }
      this.svO.setVisibility(8);
      break label341;
      label896:
      this.Ars.setVisibility(8);
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
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
    if (!dch())
    {
      ad.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.paC + "contact = " + this.contact);
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
      com.tencent.mm.model.az.arV();
      this.contact = c.apM().aHY(paramn);
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
            if (com.tencent.mm.n.b.ls(NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_type)) {
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
  
  public final void a(af paramaf, int paramInt, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31882);
    onDetach();
    com.tencent.mm.model.az.arV();
    c.apM().a(this);
    com.tencent.mm.model.az.arV();
    c.apN().a(this);
    p.auq().d(this);
    this.contact = paramaf;
    this.woZ = paramInt;
    this.rso = paramString;
    this.uBT = this.imP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
    this.CiY = this.imP.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
    this.CiV = this.imP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
    this.CiW = this.imP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
    this.CiX = this.imP.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
    this.uDK = this.imP.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
    this.CiZ = this.imP.getIntent().getStringExtra("Contact_RoomNickname");
    if (paramaf.field_deleteFlag == 1)
    {
      bool1 = true;
      this.uBZ = bool1;
      this.fss = this.imP.getIntent().getStringExtra("room_name");
      if (bt.nullAsNil(paramaf.field_username).length() <= 0) {
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
  
  public final void a(af paramaf, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31881);
    this.BVY = paramString2;
    this.BVZ = paramString3;
    a(paramaf, paramInt, paramString1);
    AppMethodBeat.o(31881);
  }
  
  public final void a(final bw parambw)
  {
    AppMethodBeat.i(31891);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31867);
        if ((NormalUserHeaderPreference.a(NormalUserHeaderPreference.this) != null) && (parambw != null) && (NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username.equals(parambw.field_encryptUsername)))
        {
          NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).nb(parambw.field_conRemark);
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
  
  public final void cs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31879);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.CiV = paramBoolean;
    }
    AppMethodBeat.o(31879);
  }
  
  public final void ct(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31880);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.CiW = paramBoolean;
    }
    AppMethodBeat.o(31880);
  }
  
  public final void eAk()
  {
    AppMethodBeat.i(31877);
    this.svO.setVisibility(0);
    if (!bt.isNullOrNil(this.contact.Ss()))
    {
      this.svO.setText(this.mContext.getString(2131755760) + this.contact.Ss());
      AppMethodBeat.o(31877);
      return;
    }
    if ((!af.aHK(this.contact.field_username)) && (!w.sC(this.contact.field_username)))
    {
      String str = bt.nullAsNil(this.contact.ZY());
      this.svO.setText(this.mContext.getString(2131755760) + str);
      AppMethodBeat.o(31877);
      return;
    }
    this.svO.setVisibility(8);
    AppMethodBeat.o(31877);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31872);
    ad.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.siX = ((TextView)paramView.findViewById(2131298631));
    this.svO = ((TextView)paramView.findViewById(2131298662));
    this.CiG = ((TextView)paramView.findViewById(2131298595));
    this.CiB = ((TextView)paramView.findViewById(2131298607));
    this.CiC = ((TextView)paramView.findViewById(2131298632));
    this.CiE = ((Button)paramView.findViewById(2131298637));
    this.CiF = ((Button)paramView.findViewById(2131298645));
    this.Cja = ((ProfileMobilePhoneView)paramView.findViewById(2131302365));
    Object localObject = this.Cja;
    com.tencent.mm.model.az.arV();
    ((ProfileMobilePhoneView)localObject).BWk = ((Boolean)c.afk().get(ae.a.FiL, Boolean.FALSE)).booleanValue();
    this.Cjb = ((ProfileDescribeView)paramView.findViewById(2131299003));
    this.Cjc = ((ProfileLabelView)paramView.findViewById(2131301284));
    this.Cjd = ((TextView)paramView.findViewById(2131304604));
    this.Cjb.setOnClickListener(this.Cje);
    this.Cjc.setOnClickListener(this.Cje);
    this.Cjd.setOnClickListener(this.Cje);
    if ((u.se(this.contact.field_username)) || ((!bt.isNullOrNil(this.contact.field_username)) && (w.tg(this.contact.field_username))))
    {
      this.Cjd.setVisibility(8);
      this.Cja.setVisibility(8);
      this.Cjb.setVisibility(8);
      this.Cjc.setVisibility(8);
      this.Ars = ((TextView)paramView.findViewById(2131298618));
      this.CiM = ((Button)paramView.findViewById(2131298612));
      this.CiN = ((FMessageListView)paramView.findViewById(2131298613));
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.woZ;
      ((a.a)localObject).rso = this.rso;
      ((a.a)localObject).Cin = this.contact.evP;
      ((a.a)localObject).type = 0;
      if (this.woZ != 18) {
        break label877;
      }
      ((a.a)localObject).type = 1;
      label424:
      this.CiN.setFMessageArgs((a.a)localObject);
      this.CiD = paramView.findViewById(2131304845);
      this.CiL = ((LinearLayout)paramView.findViewById(2131300699));
      this.uzJ = ((ImageView)paramView.findViewById(2131298597));
      this.woF = ((ImageView)paramView.findViewById(2131298642));
      this.CiH = ((ImageView)paramView.findViewById(2131298669));
      this.CiI = ((CheckBox)paramView.findViewById(2131298646));
      this.CiJ = ((ImageView)paramView.findViewById(2131298644));
      this.CiK = ((ImageView)paramView.findViewById(2131298643));
      this.CiP = ((ImageView)paramView.findViewById(2131298659));
      this.CiO = ((RelativeLayout)paramView.findViewById(2131298660));
      this.paC = true;
      initView();
      if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {
        break label896;
      }
      ad.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.CiN.setVisibility(8);
      if ((this.CiN.getVisibility() == 8) && (this.Cjd.getVisibility() == 8) && (this.Cjc.getVisibility() == 8) && (this.Cjb.getVisibility() == 8) && (this.Ars.getVisibility() == 8)) {
        this.CiD.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(31872);
      return;
      this.Cja.oFt = this.contact;
      this.Cja.kz(this.BVY, this.BVZ);
      if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {
        this.Cja.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.Cjb.Z(this.contact);
        boolean bool2 = this.Cjc.Z(this.contact);
        if ((!bool1) && (!bool2)) {
          break label798;
        }
        this.Cjd.setVisibility(8);
        break;
        this.Cja.setVisibility(0);
      }
      label798:
      if ((this.CiX) || (this.CiV)) {
        this.Cjd.setVisibility(8);
      }
      for (;;)
      {
        if ((this.Cjf == null) || ((!this.Cjf.equals("ContactWidgetBottleContact")) && (!this.Cjf.equals("ContactWidgetQContact")))) {
          break label875;
        }
        this.Cjd.setVisibility(8);
        break;
        this.Cjd.setVisibility(0);
      }
      label875:
      break;
      label877:
      if (!bi.nj(this.woZ)) {
        break label424;
      }
      ((a.a)localObject).type = 2;
      break label424;
      label896:
      if ((this.rso != null) && (this.rso.length() != 0)) {
        break label1033;
      }
      ad.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.woZ + ", verifyTicket = " + this.rso);
      this.CiN.setVisibility(8);
      if ((this.CiN.getVisibility() == 8) && (this.Cjd.getVisibility() == 8) && (this.Cjc.getVisibility() == 8) && (this.Cjb.getVisibility() == 8) && (this.Ars.getVisibility() == 8)) {
        this.CiD.setVisibility(8);
      }
    }
    label1033:
    ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.woZ);
    if (this.woZ == 18)
    {
      ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.bk.d.aCp().aIL(this.contact.field_username);
      localObject = b.a(this.imP, (dj[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1290;
      }
      ad.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.CiN.setVisibility(8);
      if ((this.CiN.getVisibility() != 8) || (this.Cjd.getVisibility() != 8) || (this.Cjc.getVisibility() != 8) || (this.Cjb.getVisibility() != 8) || (this.Ars.getVisibility() != 8)) {
        break;
      }
      this.CiD.setVisibility(8);
      break;
      if (bi.nj(this.woZ))
      {
        ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.bk.d.aCq().aJk(this.contact.field_username);
        localObject = b.a(this.imP, (bu[])localObject);
      }
      else
      {
        ad.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.bk.d.aCn().aII(this.contact.field_username);
        localObject = b.a(this.imP, (ba[])localObject);
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
        ad.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.gKF + ", addScene = " + localb.woZ);
      }
      i += 1;
    }
    if (af.aHH(this.contact.field_username))
    {
      this.CiN.setVisibility(8);
      this.CiN.setHide(true);
    }
    for (;;)
    {
      if ((this.CiN.getVisibility() == 0) || (this.Cjd.getVisibility() == 0) || (this.Cjc.getVisibility() == 0) || (this.Cjb.getVisibility() == 0) || (this.Ars.getVisibility() == 0)) {
        this.CiD.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.CiN.a(localb);
        i += 1;
      }
      break;
      this.CiN.setVisibility(0);
      this.CiN.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31871);
    if (this.CiN != null) {
      this.CiN.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(31871);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(31883);
    if (this.CiN != null) {
      this.CiN.detach();
    }
    if (this.CiY) {
      com.tencent.mm.bk.d.aCo().aIG(this.contact.field_username);
    }
    this.imP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.CiV);
    this.imP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.CiW);
    com.tencent.mm.model.az.arV();
    c.apM().b(this);
    p.auq().e(this);
    com.tencent.mm.model.az.arV();
    c.apN().b(this);
    AppMethodBeat.o(31883);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(31889);
    if (!dch())
    {
      ad.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.paC + "contact = " + this.contact);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */