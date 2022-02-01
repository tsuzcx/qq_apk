package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
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
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.n.a;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference
  extends Preference
  implements e.a, n.a, MStorageEx.IOnStorageChange
{
  private ImageView Bdg;
  private boolean BfG;
  private boolean BfM;
  private boolean Bhy;
  private ImageView DjI;
  int Dkc;
  private TextView IkU;
  private String KcI;
  private String KcJ;
  private Button KpA;
  private TextView KpB;
  private ImageView KpC;
  private CheckBox KpD;
  private ImageView KpE;
  private ImageView KpF;
  private LinearLayout KpG;
  private Button KpH;
  private FMessageListView KpI;
  private RelativeLayout KpJ;
  private ImageView KpK;
  private int KpL;
  private boolean KpM;
  private boolean KpN;
  private boolean KpO;
  private boolean KpP;
  private boolean KpQ;
  private boolean KpR;
  private boolean KpS;
  private boolean KpT;
  private String KpU;
  private ProfileMobilePhoneView KpV;
  private ProfileDescribeView KpW;
  private ProfileLabelView KpX;
  private TextView KpY;
  public View.OnClickListener KpZ;
  private TextView Kpw;
  private TextView Kpx;
  private View Kpy;
  private Button Kpz;
  public String Kqa;
  as contact;
  MMActivity gte;
  private String gwx;
  private boolean rFe;
  private TextView rMV;
  private String wZz;
  private TextView ykC;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31868);
    this.rFe = false;
    this.KpL = 0;
    this.KpM = false;
    this.KpN = false;
    this.KpO = false;
    this.KpP = false;
    this.KpQ = false;
    this.KpR = false;
    this.KpS = false;
    this.Bhy = false;
    this.KpT = false;
    this.BfM = false;
    this.gwx = "";
    this.Kqa = null;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(31868);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31869);
    this.rFe = false;
    this.KpL = 0;
    this.KpM = false;
    this.KpN = false;
    this.KpO = false;
    this.KpP = false;
    this.KpQ = false;
    this.KpR = false;
    this.KpS = false;
    this.Bhy = false;
    this.KpT = false;
    this.BfM = false;
    this.gwx = "";
    this.Kqa = null;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(31869);
  }
  
  private static boolean aKt(String paramString)
  {
    AppMethodBeat.i(31873);
    if (com.tencent.mm.plugin.sns.b.o.DCP != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.b.o.DCP.aKt(paramString);
      AppMethodBeat.o(31873);
      return bool;
    }
    AppMethodBeat.o(31873);
    return false;
  }
  
  private boolean eEa()
  {
    return (this.rFe) && (this.contact != null);
  }
  
  private void eNP()
  {
    AppMethodBeat.i(31874);
    a.b.c(this.Bdg, this.contact.field_username);
    int i;
    if (this.Bdg != null)
    {
      i = com.tencent.mm.cb.a.aG(this.mContext, 2131165191);
      int j = com.tencent.mm.cb.a.fromDPToPix(this.gte, 88);
      if (i <= j) {
        break label95;
      }
      i = j;
    }
    label95:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.aH(this.mContext, 2131165501), 0);
      this.Bdg.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(31874);
      return;
    }
  }
  
  private void grI()
  {
    AppMethodBeat.i(31875);
    this.KpB.setVisibility(0);
    this.rMV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, Util.nullAsNil(this.contact.arI()) + " ", this.rMV.getTextSize()));
    eNP();
    this.KpH.setVisibility(8);
    this.ykC.setVisibility(8);
    this.KpI.setVisibility(8);
    if ((this.KpI.getVisibility() == 8) && (this.KpY.getVisibility() == 8) && (this.KpX.getVisibility() == 8) && (this.KpW.getVisibility() == 8) && (this.IkU.getVisibility() == 8)) {
      this.Kpy.setVisibility(8);
    }
    this.Kpz.setVisibility(8);
    this.KpA.setVisibility(8);
    this.KpD.setVisibility(8);
    if (this.KpX != null) {
      this.KpX.setVisibility(8);
    }
    if (this.KpV != null) {
      this.KpV.setVisibility(8);
    }
    if (this.KpW != null) {
      this.KpW.setVisibility(8);
    }
    if (this.KpY != null) {
      this.KpY.setVisibility(8);
    }
    if (this.Kpx != null) {
      this.Kpx.setVisibility(8);
    }
    AppMethodBeat.o(31875);
  }
  
  private void grK()
  {
    AppMethodBeat.i(31878);
    int i = 0;
    if (this.KpO) {
      i = com.tencent.mm.cb.a.fromDPToPix(this.gte, 17) + 0;
    }
    int j = i + this.KpL;
    i = j;
    if (this.KpM) {
      i = j + com.tencent.mm.cb.a.fromDPToPix(this.gte, 27);
    }
    j = i;
    if (this.KpN) {
      j = i + com.tencent.mm.cb.a.fromDPToPix(this.gte, 27);
    }
    i = j;
    if (this.KpP) {
      i = j + com.tencent.mm.cb.a.fromDPToPix(this.gte, 30);
    }
    if (com.tencent.mm.cb.a.jk(this.mContext)) {
      i += com.tencent.mm.cb.a.fromDPToPix(this.gte, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cb.a.fromDPToPix(this.gte, 60);
      DisplayMetrics localDisplayMetrics = this.gte.getResources().getDisplayMetrics();
      this.rMV.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(31878);
      return;
      i += com.tencent.mm.cb.a.fromDPToPix(this.gte, 64);
    }
  }
  
  private void grL()
  {
    int j = 0;
    AppMethodBeat.i(31884);
    ImageView localImageView;
    if ((this.KpE != null) && (ab.Iu(this.contact.field_username)))
    {
      this.KpN = this.contact.arB();
      localImageView = this.KpE;
      if (this.KpN)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.KpF != null) && (ab.Iu(this.contact.field_username)))
    {
      this.KpM = aKt(this.contact.field_username);
      localImageView = this.KpF;
      if (!this.KpM) {
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
  
  private void grM()
  {
    AppMethodBeat.i(31885);
    if (Util.isNullOrNil(this.KpU))
    {
      this.Kpw.setVisibility(8);
      AppMethodBeat.o(31885);
      return;
    }
    if ((!z.Im(this.contact.field_username)) && (Util.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.ykC.setVisibility(8);
    }
    this.Kpw.setVisibility(0);
    this.Kpw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, this.gte.getString(2131757857) + this.KpU, this.Kpw.getTextSize()));
    AppMethodBeat.o(31885);
  }
  
  private void grN()
  {
    AppMethodBeat.i(31886);
    if ((z.Im(this.contact.field_username)) || (Util.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.Kpx.setVisibility(8);
      this.rMV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, Util.nullAsNil(this.contact.arI()) + " ", this.rMV.getTextSize()));
      if (this.KpS)
      {
        this.Kpz.setVisibility(0);
        this.KpY.setVisibility(8);
        if (as.bjp(this.contact.field_username))
        {
          this.KpY.setText(2131758167);
          grO();
        }
        if ((!this.Bhy) || (com.tencent.mm.contact.c.oR(this.contact.field_type))) {
          break label560;
        }
        this.KpA.setVisibility(0);
      }
    }
    for (;;)
    {
      if (as.IG(this.contact.field_username)) {
        this.rMV.setText("");
      }
      if ((this.Dkc == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.rMV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, Util.nullAsNil(this.contact.field_nickname) + " ", this.rMV.getTextSize()));
      }
      if ((this.KpA.getVisibility() == 0) && (this.Kpx.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Kpx.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165586);
        this.Kpx.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(31886);
      return;
      if (this.KpQ)
      {
        this.Kpz.setVisibility(0);
        this.KpY.setVisibility(8);
        break;
      }
      if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
        this.Kpz.setVisibility(8);
      }
      boolean bool1 = this.KpW.aj(this.contact);
      boolean bool2 = this.KpX.aj(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.KpY.setVisibility(8);
      break;
      this.rMV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, Util.nullAsNil(this.contact.field_conRemark) + " ", this.rMV.getTextSize()));
      this.Kpx.setVisibility(0);
      this.Kpx.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, this.mContext.getString(2131757979) + this.contact.arI(), this.Kpx.getTextSize()));
      this.Kpz.setVisibility(8);
      break;
      label560:
      if (this.KpR)
      {
        this.KpA.setVisibility(0);
        if (com.tencent.mm.cb.a.jk(this.gte))
        {
          this.KpA.setTextSize(0, this.gte.getResources().getDimensionPixelSize(2131165482));
          this.Kpz.setTextSize(0, this.gte.getResources().getDimensionPixelSize(2131165482));
        }
      }
      else
      {
        this.KpA.setVisibility(8);
      }
    }
  }
  
  private void grO()
  {
    AppMethodBeat.i(31887);
    if (this.KpG == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    View localView = this.KpG.findViewById(2131303206);
    if (localView == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(31887);
  }
  
  private void grP()
  {
    AppMethodBeat.i(31888);
    this.KpD.setClickable(false);
    if (((ab.Iu(this.contact.field_username)) || (as.bjp(this.contact.field_username))) && (com.tencent.mm.contact.c.oR(this.contact.field_type)) && (!z.Im(this.contact.field_username)))
    {
      this.KpD.setVisibility(0);
      if (this.contact.arA())
      {
        this.KpD.setChecked(true);
        this.KpP = true;
        AppMethodBeat.o(31888);
        return;
      }
      this.KpD.setChecked(false);
      this.KpD.setVisibility(8);
      this.KpP = false;
      AppMethodBeat.o(31888);
      return;
    }
    this.KpP = false;
    this.KpD.setVisibility(8);
    AppMethodBeat.o(31888);
  }
  
  private void grQ()
  {
    AppMethodBeat.i(31892);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      this.KpJ.setVisibility(8);
      AppMethodBeat.o(31892);
      return;
    }
    com.tencent.mm.plugin.story.api.e locale = (com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.KpJ.setVisibility(0);
      this.KpK.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.KpG.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.gte, 166);
      this.KpG.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.gwx);
      AppMethodBeat.o(31892);
      return;
      this.KpJ.setVisibility(8);
      this.KpK.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.KpG.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.KpG.setLayoutParams(localLayoutParams);
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(31876);
    if (!eEa())
    {
      Log.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.rFe + "contact = " + this.contact);
      AppMethodBeat.o(31876);
      return;
    }
    if (this.BfM)
    {
      grI();
      AppMethodBeat.o(31876);
      return;
    }
    boolean bool = as.IG(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.rMV.setText("");
      if (as.bjz(z.aTY()).equals(this.contact.field_username)) {
        this.KpH.setVisibility(8);
      }
      this.DjI.setVisibility(0);
      this.KpO = true;
      if (this.contact.fuA != 1) {
        break label495;
      }
      this.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131690428));
      this.DjI.setContentDescription(this.mContext.getString(2131764070));
      if (this.contact.field_verifyFlag != 0)
      {
        this.KpC.setVisibility(0);
        if (ay.a.iDs == null) {
          break label570;
        }
        localBitmap = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(this.contact.field_verifyFlag), 2.0F);
        this.KpC.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label575;
        }
        i = 0;
        label245:
        this.KpL = i;
      }
      eNP();
      grQ();
      this.Bdg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31858);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username;
          paramAnonymousView = (View)localObject;
          if (as.IG((String)localObject)) {
            paramAnonymousView = as.bjz((String)localObject);
          }
          localObject = new Intent(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", paramAnonymousView);
          paramAnonymousView = NormalUserHeaderPreference.b(NormalUserHeaderPreference.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31858);
        }
      });
      this.KpK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31859);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.story.api.o.bB(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31859);
        }
      });
      if (!as.bjo(this.contact.field_username)) {
        break label583;
      }
      this.ykC.setText(this.mContext.getString(2131755828) + this.contact.arK());
      label341:
      if (!ab.Jv(this.contact.field_username)) {
        break label896;
      }
      this.IkU.setVisibility(0);
    }
    for (;;)
    {
      grN();
      grL();
      grP();
      grM();
      this.Kpz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31860);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          NormalUserHeaderPreference.c(NormalUserHeaderPreference.this);
          paramAnonymousView = NormalUserHeaderPreference.this;
          bg.aVF();
          localObject = com.tencent.mm.model.c.aSN().Kn(paramAnonymousView.contact.field_username);
          if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0) && (((ax)localObject).field_username.equals(paramAnonymousView.contact.field_username))) {
            paramAnonymousView.contact = ((as)localObject);
          }
          if (!com.tencent.mm.contact.c.oR(paramAnonymousView.contact.field_type))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.Dkc);
            ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
            ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.contact.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousView.contact.field_conRemark);
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31860);
            return;
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.Dkc);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_RoomNickname", paramAnonymousView.gte.getIntent().getStringExtra("Contact_RoomNickname"));
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      });
      this.KpA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31861);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 3);
          com.tencent.mm.br.c.b(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31861);
        }
      });
      grK();
      this.ykC.setLongClickable(true);
      this.ykC.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31865);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText() != null)
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
            ((SpannableString)localObject).setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getResources().getColor(2131100677)), i + 1, NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText().length(), 33);
            NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).setText((CharSequence)localObject);
            localObject = new com.tencent.mm.ui.widget.b.a(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.d(NormalUserHeaderPreference.this));
            ((com.tencent.mm.ui.widget.b.a)localObject).QSs = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(31862);
                paramAnonymous2ContextMenu.add(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755772));
                AppMethodBeat.o(31862);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(31863);
                if (paramAnonymous2Int == 0)
                {
                  ClipboardHelper.setText(paramAnonymousView);
                  h.cC(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755773));
                }
                AppMethodBeat.o(31863);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).QwU = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(31864);
                NormalUserHeaderPreference.this.grJ();
                AppMethodBeat.o(31864);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).ez(0, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(31865);
          return true;
        }
      });
      AppMethodBeat.o(31876);
      return;
      this.rMV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, Util.nullAsNil(this.contact.field_nickname) + " ", this.rMV.getTextSize()));
      break;
      label495:
      if (this.contact.fuA == 2)
      {
        this.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131690427));
        this.DjI.setContentDescription(this.mContext.getString(2131764069));
        break label187;
      }
      if (this.contact.fuA != 0) {
        break label187;
      }
      this.DjI.setVisibility(8);
      this.KpO = false;
      break label187;
      label570:
      localBitmap = null;
      break label231;
      label575:
      i = localBitmap.getWidth();
      break label245;
      label583:
      if (as.bjm(this.contact.field_username))
      {
        this.ykC.setText(this.mContext.getString(2131755844) + this.contact.arK());
        break label341;
      }
      if (this.BfG)
      {
        if (com.tencent.mm.contact.c.oR(this.contact.field_type))
        {
          grJ();
          break label341;
        }
        if ((this.contact.fuL == null) || (this.contact.fuL.equals("")))
        {
          this.ykC.setText(2131755797);
          break label341;
        }
        this.ykC.setText(this.contact.fuL);
        break label341;
      }
      if (bool)
      {
        this.ykC.setText((Util.nullAsNil(aa.It(this.contact.getProvince())) + " " + Util.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!as.bjn(this.contact.field_username)) && (this.gte.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((Util.isNullOrNil(this.contact.ajx())) && ((as.bjx(this.contact.field_username)) || (ab.IR(this.contact.field_username))))
        {
          this.ykC.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.contact.c.oR(this.contact.field_type))
        {
          grJ();
          break label341;
        }
      }
      this.ykC.setVisibility(8);
      break label341;
      label896:
      this.IkU.setVisibility(8);
    }
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(31889);
    if (!eEa())
    {
      Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.rFe + "contact = " + this.contact);
      AppMethodBeat.o(31889);
      return;
    }
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      Log.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(31889);
      return;
    }
    if (paramString.equals(this.contact.field_username)) {
      initView();
    }
    AppMethodBeat.o(31889);
  }
  
  public final void a(as paramas, int paramInt, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31882);
    onDetach();
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this);
    bg.aVF();
    com.tencent.mm.model.c.aSO().a(this);
    p.aYn().d(this);
    this.contact = paramas;
    this.Dkc = paramInt;
    this.wZz = paramString;
    this.BfG = this.gte.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
    this.KpT = this.gte.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
    this.KpQ = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
    this.KpR = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
    this.KpS = this.gte.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
    this.Bhy = this.gte.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
    this.KpU = this.gte.getIntent().getStringExtra("Contact_RoomNickname");
    if (paramas.field_deleteFlag == 1)
    {
      bool1 = true;
      this.BfM = bool1;
      this.gwx = this.gte.getIntent().getStringExtra("room_name");
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
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
  
  public final void a(as paramas, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31881);
    this.KcI = paramString2;
    this.KcJ = paramString3;
    a(paramas, paramInt, paramString1);
    AppMethodBeat.o(31881);
  }
  
  public final void a(final cn paramcn)
  {
    AppMethodBeat.i(31891);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31867);
        if ((NormalUserHeaderPreference.a(NormalUserHeaderPreference.this) != null) && (paramcn != null) && (NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username.equals(paramcn.field_encryptUsername)))
        {
          NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).BD(paramcn.field_conRemark);
          if (!NormalUserHeaderPreference.i(NormalUserHeaderPreference.this))
          {
            Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.j(NormalUserHeaderPreference.this) + "contact = " + NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
            AppMethodBeat.o(31867);
            return;
          }
          NormalUserHeaderPreference.e(NormalUserHeaderPreference.this);
        }
        AppMethodBeat.o(31867);
      }
    });
    AppMethodBeat.o(31891);
  }
  
  public final void dc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31879);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.KpQ = paramBoolean;
    }
    AppMethodBeat.o(31879);
  }
  
  public final void dd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31880);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.KpR = paramBoolean;
    }
    AppMethodBeat.o(31880);
  }
  
  public final void grJ()
  {
    AppMethodBeat.i(31877);
    this.ykC.setVisibility(0);
    if (!Util.isNullOrNil(this.contact.ajx()))
    {
      this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, this.contact.ajx()));
      AppMethodBeat.o(31877);
      return;
    }
    if ((!as.bjx(this.contact.field_username)) && (!ab.IR(this.contact.field_username)))
    {
      String str = Util.nullAsNil(this.contact.arK());
      this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, str));
      AppMethodBeat.o(31877);
      return;
    }
    this.ykC.setVisibility(8);
    AppMethodBeat.o(31877);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31872);
    Log.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.rMV = ((TextView)paramView.findViewById(2131299068));
    this.ykC = ((TextView)paramView.findViewById(2131299099));
    this.KpB = ((TextView)paramView.findViewById(2131299032));
    this.Kpw = ((TextView)paramView.findViewById(2131299044));
    this.Kpx = ((TextView)paramView.findViewById(2131299069));
    this.Kpz = ((Button)paramView.findViewById(2131299074));
    this.KpA = ((Button)paramView.findViewById(2131299082));
    this.KpV = ((ProfileMobilePhoneView)paramView.findViewById(2131304762));
    Object localObject = this.KpV;
    bg.aVF();
    ((ProfileMobilePhoneView)localObject).KcU = ((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVr, Boolean.FALSE)).booleanValue();
    this.KpW = ((ProfileDescribeView)paramView.findViewById(2131299505));
    this.KpX = ((ProfileLabelView)paramView.findViewById(2131302981));
    this.KpY = ((TextView)paramView.findViewById(2131307653));
    this.KpW.setOnClickListener(this.KpZ);
    this.KpX.setOnClickListener(this.KpZ);
    this.KpY.setOnClickListener(this.KpZ);
    if ((z.Im(this.contact.field_username)) || ((!Util.isNullOrNil(this.contact.field_username)) && (ab.Jv(this.contact.field_username))))
    {
      this.KpY.setVisibility(8);
      this.KpV.setVisibility(8);
      this.KpW.setVisibility(8);
      this.KpX.setVisibility(8);
      this.IkU = ((TextView)paramView.findViewById(2131299055));
      this.KpH = ((Button)paramView.findViewById(2131299049));
      this.KpI = ((FMessageListView)paramView.findViewById(2131299050));
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.Dkc;
      ((a.a)localObject).wZz = this.wZz;
      ((a.a)localObject).Kpf = this.contact.fuY;
      ((a.a)localObject).type = 0;
      if (this.Dkc != 18) {
        break label877;
      }
      ((a.a)localObject).type = 1;
      label424:
      this.KpI.setFMessageArgs((a.a)localObject);
      this.Kpy = paramView.findViewById(2131307931);
      this.KpG = ((LinearLayout)paramView.findViewById(2131302270));
      this.Bdg = ((ImageView)paramView.findViewById(2131299034));
      this.DjI = ((ImageView)paramView.findViewById(2131299079));
      this.KpC = ((ImageView)paramView.findViewById(2131299106));
      this.KpD = ((CheckBox)paramView.findViewById(2131299083));
      this.KpE = ((ImageView)paramView.findViewById(2131299081));
      this.KpF = ((ImageView)paramView.findViewById(2131299080));
      this.KpK = ((ImageView)paramView.findViewById(2131299096));
      this.KpJ = ((RelativeLayout)paramView.findViewById(2131299097));
      this.rFe = true;
      initView();
      if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
        break label896;
      }
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.KpI.setVisibility(8);
      if ((this.KpI.getVisibility() == 8) && (this.KpY.getVisibility() == 8) && (this.KpX.getVisibility() == 8) && (this.KpW.getVisibility() == 8) && (this.IkU.getVisibility() == 8)) {
        this.Kpy.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(31872);
      return;
      this.KpV.rjX = this.contact;
      this.KpV.my(this.KcI, this.KcJ);
      if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
        this.KpV.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.KpW.aj(this.contact);
        boolean bool2 = this.KpX.aj(this.contact);
        if ((!bool1) && (!bool2)) {
          break label798;
        }
        this.KpY.setVisibility(8);
        break;
        this.KpV.setVisibility(0);
      }
      label798:
      if ((this.KpS) || (this.KpQ)) {
        this.KpY.setVisibility(8);
      }
      for (;;)
      {
        if ((this.Kqa == null) || ((!this.Kqa.equals("ContactWidgetBottleContact")) && (!this.Kqa.equals("ContactWidgetQContact")))) {
          break label875;
        }
        this.KpY.setVisibility(8);
        break;
        this.KpY.setVisibility(0);
      }
      label875:
      break;
      label877:
      if (!bp.sb(this.Dkc)) {
        break label424;
      }
      ((a.a)localObject).type = 2;
      break label424;
      label896:
      if ((this.wZz != null) && (this.wZz.length() != 0)) {
        break label1033;
      }
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.Dkc + ", verifyTicket = " + this.wZz);
      this.KpI.setVisibility(8);
      if ((this.KpI.getVisibility() == 8) && (this.KpY.getVisibility() == 8) && (this.KpX.getVisibility() == 8) && (this.KpW.getVisibility() == 8) && (this.IkU.getVisibility() == 8)) {
        this.Kpy.setVisibility(8);
      }
    }
    label1033:
    Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.Dkc);
    if (this.Dkc == 18)
    {
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = d.bgO().bkx(this.contact.field_username);
      localObject = b.a(this.gte, (eb[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1290;
      }
      Log.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.KpI.setVisibility(8);
      if ((this.KpI.getVisibility() != 8) || (this.KpY.getVisibility() != 8) || (this.KpX.getVisibility() != 8) || (this.KpW.getVisibility() != 8) || (this.IkU.getVisibility() != 8)) {
        break;
      }
      this.Kpy.setVisibility(8);
      break;
      if (bp.sb(this.Dkc))
      {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = d.bgP().bkW(this.contact.field_username);
        localObject = b.a(this.gte, (cl[])localObject);
      }
      else
      {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = d.bgM().bku(this.contact.field_username);
        localObject = b.a(this.gte, (bn[])localObject);
      }
    }
    label1290:
    Log.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + localObject.length);
    int j = localObject.length;
    int i = 0;
    b localb;
    while (i < j)
    {
      localb = localObject[i];
      if (localb != null) {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.iAq + ", addScene = " + localb.Dkc);
      }
      i += 1;
    }
    if (as.bjp(this.contact.field_username))
    {
      this.KpI.setVisibility(8);
      this.KpI.setHide(true);
    }
    for (;;)
    {
      if ((this.KpI.getVisibility() == 0) || (this.KpY.getVisibility() == 0) || (this.KpX.getVisibility() == 0) || (this.KpW.getVisibility() == 0) || (this.IkU.getVisibility() == 0)) {
        this.Kpy.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.KpI.a(localb);
        i += 1;
      }
      break;
      this.KpI.setVisibility(0);
      this.KpI.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31871);
    if (this.KpI != null) {
      this.KpI.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(31871);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(31883);
    if (this.KpI != null) {
      this.KpI.detach();
    }
    if (this.KpT) {
      d.bgN().bks(this.contact.field_username);
    }
    this.gte.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.KpQ);
    this.gte.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.KpR);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this);
    p.aYn().e(this);
    bg.aVF();
    com.tencent.mm.model.c.aSO().b(this);
    AppMethodBeat.o(31883);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(31890);
    Log.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(31890);
      return;
    }
    paramMStorageEx = (String)paramObject;
    Log.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + paramMStorageEx + ", contact = " + this.contact);
    if (!eEa())
    {
      Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.rFe + "contact = " + this.contact);
      AppMethodBeat.o(31890);
      return;
    }
    if (Util.nullAsNil(paramMStorageEx).length() <= 0)
    {
      AppMethodBeat.o(31890);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramMStorageEx)))
    {
      bg.aVF();
      this.contact = com.tencent.mm.model.c.aSN().Kn(paramMStorageEx);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(31866);
          NormalUserHeaderPreference.e(NormalUserHeaderPreference.this);
          NormalUserHeaderPreference.f(NormalUserHeaderPreference.this);
          NormalUserHeaderPreference.g(NormalUserHeaderPreference.this);
          FMessageListView localFMessageListView;
          if (NormalUserHeaderPreference.h(NormalUserHeaderPreference.this) != null)
          {
            localFMessageListView = NormalUserHeaderPreference.h(NormalUserHeaderPreference.this);
            if (com.tencent.mm.contact.c.oR(NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_type)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */