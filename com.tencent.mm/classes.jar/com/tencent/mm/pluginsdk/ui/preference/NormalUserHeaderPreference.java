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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.ef;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.n.a;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
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
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.g;

public class NormalUserHeaderPreference
  extends Preference
  implements f.a, n.a, MStorageEx.IOnStorageChange
{
  public String BLy;
  private TextView DKE;
  private ImageView GXf;
  public boolean HaU;
  public boolean Hbo;
  public int JpE;
  private ImageView Jpk;
  private TextView Pdm;
  private String Rdn;
  private String Rdo;
  public boolean RqA;
  private int RqB;
  private boolean RqC;
  private boolean RqD;
  private boolean RqE;
  private boolean RqF;
  public boolean RqG;
  public boolean RqH;
  public boolean RqI;
  public boolean RqJ;
  public String RqK;
  private ProfileMobilePhoneView RqL;
  private ProfileDescribeView RqM;
  private ProfileLabelView RqN;
  private TextView RqO;
  public View.OnClickListener RqP;
  public String RqQ;
  private TextView Rql;
  private TextView Rqm;
  private View Rqn;
  private Button Rqo;
  private Button Rqp;
  private TextView Rqq;
  private ImageView Rqr;
  private CheckBox Rqs;
  private ImageView Rqt;
  private ImageView Rqu;
  private LinearLayout Rqv;
  private Button Rqw;
  private FMessageListView Rqx;
  private RelativeLayout Rqy;
  private ImageView Rqz;
  public as contact;
  public MMActivity iXq;
  public String jaK;
  private boolean vkO;
  private TextView vsF;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31868);
    this.vkO = false;
    this.RqB = 0;
    this.RqC = false;
    this.RqD = false;
    this.RqE = false;
    this.RqF = false;
    this.RqG = false;
    this.RqH = false;
    this.RqI = false;
    this.Hbo = false;
    this.RqJ = false;
    this.HaU = false;
    this.jaK = "";
    this.RqQ = null;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(31868);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31869);
    this.vkO = false;
    this.RqB = 0;
    this.RqC = false;
    this.RqD = false;
    this.RqE = false;
    this.RqF = false;
    this.RqG = false;
    this.RqH = false;
    this.RqI = false;
    this.Hbo = false;
    this.RqJ = false;
    this.HaU = false;
    this.jaK = "";
    this.RqQ = null;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(31869);
  }
  
  private static boolean aUR(String paramString)
  {
    AppMethodBeat.i(31873);
    if (p.JPf != null)
    {
      boolean bool = p.JPf.aUR(paramString);
      AppMethodBeat.o(31873);
      return bool;
    }
    AppMethodBeat.o(31873);
    return false;
  }
  
  private void aqM(int paramInt)
  {
    AppMethodBeat.i(283917);
    if (this.Rqv == null)
    {
      AppMethodBeat.o(283917);
      return;
    }
    View localView = this.Rqv.findViewById(paramInt);
    if (localView == null)
    {
      AppMethodBeat.o(283917);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(283917);
  }
  
  private void foI()
  {
    AppMethodBeat.i(31874);
    a.b.c(this.GXf, this.contact.field_username);
    int i;
    if (this.GXf != null)
    {
      i = com.tencent.mm.ci.a.aY(this.mContext, R.f.BigAvatarSize);
      int j = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 88);
      if (i <= j) {
        break label97;
      }
      i = j;
    }
    label97:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.ci.a.aZ(this.mContext, R.f.LargerPadding), 0);
      this.GXf.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(31874);
      return;
    }
  }
  
  private boolean fpT()
  {
    return (this.vkO) && (this.contact != null);
  }
  
  private void hmJ()
  {
    AppMethodBeat.i(31875);
    this.Rqq.setVisibility(0);
    this.vsF.setText(l.b(this.iXq, Util.nullAsNil(this.contact.ayr()) + " ", this.vsF.getTextSize()));
    foI();
    this.Rqw.setVisibility(8);
    this.DKE.setVisibility(8);
    this.Rqx.setVisibility(8);
    if ((this.Rqx.getVisibility() == 8) && (this.RqO.getVisibility() == 8) && (this.RqN.getVisibility() == 8) && (this.RqM.getVisibility() == 8) && (this.Pdm.getVisibility() == 8)) {
      this.Rqn.setVisibility(8);
    }
    this.Rqo.setVisibility(8);
    this.Rqp.setVisibility(8);
    this.Rqs.setVisibility(8);
    if (this.RqN != null) {
      this.RqN.setVisibility(8);
    }
    if (this.RqL != null) {
      this.RqL.setVisibility(8);
    }
    if (this.RqM != null) {
      this.RqM.setVisibility(8);
    }
    if (this.RqO != null) {
      this.RqO.setVisibility(8);
    }
    if (this.Rqm != null) {
      this.Rqm.setVisibility(8);
    }
    AppMethodBeat.o(31875);
  }
  
  private void hmL()
  {
    AppMethodBeat.i(31878);
    int i = 0;
    if (this.RqE) {
      i = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 17) + 0;
    }
    int j = i + this.RqB;
    i = j;
    if (this.RqC) {
      i = j + com.tencent.mm.ci.a.fromDPToPix(this.iXq, 27);
    }
    j = i;
    if (this.RqD) {
      j = i + com.tencent.mm.ci.a.fromDPToPix(this.iXq, 27);
    }
    i = j;
    if (this.RqF) {
      i = j + com.tencent.mm.ci.a.fromDPToPix(this.iXq, 30);
    }
    if (com.tencent.mm.ci.a.ko(this.mContext)) {
      i += com.tencent.mm.ci.a.fromDPToPix(this.iXq, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 60);
      DisplayMetrics localDisplayMetrics = this.iXq.getResources().getDisplayMetrics();
      this.vsF.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(31878);
      return;
      i += com.tencent.mm.ci.a.fromDPToPix(this.iXq, 64);
    }
  }
  
  private void hmM()
  {
    int j = 0;
    AppMethodBeat.i(31884);
    ImageView localImageView;
    if ((this.Rqt != null) && (ab.PM(this.contact.field_username)))
    {
      this.RqD = this.contact.ayi();
      localImageView = this.Rqt;
      if (this.RqD)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.Rqu != null) && (ab.PM(this.contact.field_username)))
    {
      this.RqC = aUR(this.contact.field_username);
      localImageView = this.Rqu;
      if (!this.RqC) {
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
  
  private void hmN()
  {
    AppMethodBeat.i(31885);
    if (Util.isNullOrNil(this.RqK))
    {
      this.Rql.setVisibility(8);
      AppMethodBeat.o(31885);
      return;
    }
    if ((!z.PD(this.contact.field_username)) && (Util.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.DKE.setVisibility(8);
    }
    this.Rql.setVisibility(0);
    this.Rql.setText(l.b(this.iXq, this.iXq.getString(R.l.eyn) + this.RqK, this.Rql.getTextSize()));
    AppMethodBeat.o(31885);
  }
  
  private void hmO()
  {
    AppMethodBeat.i(31886);
    if ((z.PD(this.contact.field_username)) || (Util.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.Rqm.setVisibility(8);
      this.vsF.setText(l.b(this.iXq, Util.nullAsNil(this.contact.ayr()) + " ", this.vsF.getTextSize()));
      if (this.RqI)
      {
        this.Rqo.setVisibility(0);
        this.RqO.setVisibility(8);
        if (as.bvK(this.contact.field_username))
        {
          this.RqO.setText(R.l.eAq);
          aqM(R.h.dLl);
        }
        if ((!this.Hbo) || (com.tencent.mm.contact.d.rk(this.contact.field_type))) {
          break label563;
        }
        this.Rqp.setVisibility(0);
      }
    }
    for (;;)
    {
      if (as.PY(this.contact.field_username)) {
        this.vsF.setText("");
      }
      if ((this.JpE == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.vsF.setText(l.b(this.iXq, Util.nullAsNil(this.contact.field_nickname) + " ", this.vsF.getTextSize()));
      }
      if ((this.Rqp.getVisibility() == 0) && (this.Rqm.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Rqm.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
        this.Rqm.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(31886);
      return;
      if (this.RqG)
      {
        this.Rqo.setVisibility(0);
        this.RqO.setVisibility(8);
        break;
      }
      if (com.tencent.mm.contact.d.rk(this.contact.field_type)) {
        this.Rqo.setVisibility(8);
      }
      boolean bool1 = this.RqM.ap(this.contact);
      boolean bool2 = this.RqN.ap(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.RqO.setVisibility(8);
      break;
      this.vsF.setText(l.b(this.iXq, Util.nullAsNil(this.contact.field_conRemark) + " ", this.vsF.getTextSize()));
      this.Rqm.setVisibility(0);
      this.Rqm.setText(l.b(this.iXq, this.mContext.getString(R.l.eyP) + this.contact.ayr(), this.Rqm.getTextSize()));
      this.Rqo.setVisibility(8);
      break;
      label563:
      if (this.RqH)
      {
        this.Rqp.setVisibility(0);
        if (com.tencent.mm.ci.a.ko(this.iXq))
        {
          this.Rqp.setTextSize(0, this.iXq.getResources().getDimensionPixelSize(R.f.HintTextSize));
          this.Rqo.setTextSize(0, this.iXq.getResources().getDimensionPixelSize(R.f.HintTextSize));
        }
      }
      else
      {
        this.Rqp.setVisibility(8);
      }
    }
  }
  
  private void hmP()
  {
    AppMethodBeat.i(31888);
    this.Rqs.setClickable(false);
    if (((ab.PM(this.contact.field_username)) || (as.bvK(this.contact.field_username))) && (com.tencent.mm.contact.d.rk(this.contact.field_type)) && (!z.PD(this.contact.field_username)))
    {
      this.Rqs.setVisibility(0);
      if (this.contact.ayh())
      {
        this.Rqs.setChecked(true);
        this.RqF = true;
        AppMethodBeat.o(31888);
        return;
      }
      this.Rqs.setChecked(false);
      this.Rqs.setVisibility(8);
      this.RqF = false;
      AppMethodBeat.o(31888);
      return;
    }
    this.RqF = false;
    this.Rqs.setVisibility(8);
    AppMethodBeat.o(31888);
  }
  
  private void hmQ()
  {
    AppMethodBeat.i(31892);
    if (!o.isShowStoryCheck())
    {
      this.Rqy.setVisibility(8);
      AppMethodBeat.o(31892);
      return;
    }
    e locale = (e)com.tencent.mm.kernel.h.ag(e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.Rqy.setVisibility(0);
      this.Rqz.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.Rqv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 166);
      this.Rqv.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.jaK);
      AppMethodBeat.o(31892);
      return;
      this.Rqy.setVisibility(8);
      this.Rqz.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.Rqv.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.Rqv.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(31889);
    if (!fpT())
    {
      Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.vkO + "contact = " + this.contact);
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
  
  public final void a(final co paramco)
  {
    AppMethodBeat.i(31891);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31867);
        if ((NormalUserHeaderPreference.a(NormalUserHeaderPreference.this) != null) && (paramco != null) && (NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username.equals(paramco.field_encryptUsername)))
        {
          NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).Ir(paramco.field_conRemark);
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
  
  public final void hmK()
  {
    AppMethodBeat.i(31877);
    this.DKE.setVisibility(0);
    if (!Util.isNullOrNil(this.contact.apf()))
    {
      this.DKE.setText(com.tencent.mm.plugin.profile.c.bE(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.jG(this.contact.field_username, this.contact.apf()));
      AppMethodBeat.o(31877);
      return;
    }
    if ((!as.bvU(this.contact.field_username)) && (!ab.Qk(this.contact.field_username)))
    {
      String str = Util.nullAsNil(this.contact.ayt());
      this.DKE.setText(com.tencent.mm.plugin.profile.c.bE(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.jG(this.contact.field_username, str));
      AppMethodBeat.o(31877);
      return;
    }
    this.DKE.setVisibility(8);
    AppMethodBeat.o(31877);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(31876);
    if (!fpT())
    {
      Log.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.vkO + "contact = " + this.contact);
      AppMethodBeat.o(31876);
      return;
    }
    if (this.HaU)
    {
      hmJ();
      AppMethodBeat.o(31876);
      return;
    }
    boolean bool = as.PY(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.vsF.setText("");
      if (as.bvW(z.bcZ()).equals(this.contact.field_username)) {
        this.Rqw.setVisibility(8);
      }
      this.Jpk.setVisibility(0);
      this.RqE = true;
      if (this.contact.sex != 1) {
        break label495;
      }
      this.Jpk.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, R.k.ic_sex_male));
      this.Jpk.setContentDescription(this.mContext.getString(R.l.profile_sex_male_desc));
      if (this.contact.field_verifyFlag != 0)
      {
        this.Rqr.setVisibility(0);
        if (az.a.ltt == null) {
          break label570;
        }
        localBitmap = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(this.contact.field_verifyFlag), 2.0F);
        this.Rqr.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label575;
        }
        i = 0;
        label245:
        this.RqB = i;
      }
      foI();
      hmQ();
      this.GXf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31858);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username;
          paramAnonymousView = (View)localObject;
          if (as.PY((String)localObject)) {
            paramAnonymousView = as.bvW((String)localObject);
          }
          localObject = new Intent(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", paramAnonymousView);
          paramAnonymousView = NormalUserHeaderPreference.b(NormalUserHeaderPreference.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31858);
        }
      });
      this.Rqz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31859);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          o.bP(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31859);
        }
      });
      if (!as.bvJ(this.contact.field_username)) {
        break label583;
      }
      this.DKE.setText(this.mContext.getString(R.l.app_field_qquin) + this.contact.ayt());
      label341:
      if (!ab.QO(this.contact.field_username)) {
        break label896;
      }
      this.Pdm.setVisibility(0);
    }
    for (;;)
    {
      hmO();
      hmM();
      hmP();
      hmN();
      this.Rqo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31860);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          NormalUserHeaderPreference.c(NormalUserHeaderPreference.this);
          paramAnonymousView = NormalUserHeaderPreference.this;
          bh.beI();
          localObject = com.tencent.mm.model.c.bbL().RG(paramAnonymousView.contact.field_username);
          if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) && (((ax)localObject).field_username.equals(paramAnonymousView.contact.field_username))) {
            paramAnonymousView.contact = ((as)localObject);
          }
          if (!com.tencent.mm.contact.d.rk(paramAnonymousView.contact.field_type))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.JpE);
            ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
            ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.contact.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousView.contact.field_conRemark);
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31860);
            return;
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.JpE);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_RoomNickname", paramAnonymousView.iXq.getIntent().getStringExtra("Contact_RoomNickname"));
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      });
      this.Rqp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31861);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 3);
          com.tencent.mm.by.c.b(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31861);
        }
      });
      hmL();
      this.DKE.setLongClickable(true);
      this.DKE.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31865);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
            ((SpannableString)localObject).setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getResources().getColor(R.e.light_blue_bg_color)), i + 1, NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).getText().length(), 33);
            NormalUserHeaderPreference.d(NormalUserHeaderPreference.this).setText((CharSequence)localObject);
            localObject = new com.tencent.mm.ui.widget.b.a(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.d(NormalUserHeaderPreference.this));
            ((com.tencent.mm.ui.widget.b.a)localObject).Yrf = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(31862);
                paramAnonymous2ContextMenu.add(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(R.l.app_copy));
                AppMethodBeat.o(31862);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(31863);
                if (paramAnonymous2Int == 0)
                {
                  ClipboardHelper.setText(paramAnonymousView);
                  com.tencent.mm.ui.base.h.cN(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(R.l.app_copy_ok));
                }
                AppMethodBeat.o(31863);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).XVa = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(31864);
                NormalUserHeaderPreference.this.hmK();
                AppMethodBeat.o(31864);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).eY(0, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(31865);
          return true;
        }
      });
      AppMethodBeat.o(31876);
      return;
      this.vsF.setText(l.b(this.iXq, Util.nullAsNil(this.contact.field_nickname) + " ", this.vsF.getTextSize()));
      break;
      label495:
      if (this.contact.sex == 2)
      {
        this.Jpk.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, R.k.ic_sex_female));
        this.Jpk.setContentDescription(this.mContext.getString(R.l.profile_sex_female_desc));
        break label187;
      }
      if (this.contact.sex != 0) {
        break label187;
      }
      this.Jpk.setVisibility(8);
      this.RqE = false;
      break label187;
      label570:
      localBitmap = null;
      break label231;
      label575:
      i = localBitmap.getWidth();
      break label245;
      label583:
      if (as.bvH(this.contact.field_username))
      {
        this.DKE.setText(this.mContext.getString(R.l.app_field_weibo) + this.contact.ayt());
        break label341;
      }
      if (this.RqA)
      {
        if (com.tencent.mm.contact.d.rk(this.contact.field_type))
        {
          hmK();
          break label341;
        }
        if ((this.contact.hDl == null) || (this.contact.hDl.equals("")))
        {
          this.DKE.setText(R.l.app_empty_string);
          break label341;
        }
        this.DKE.setText(this.contact.hDl);
        break label341;
      }
      if (bool)
      {
        this.DKE.setText((Util.nullAsNil(aa.PL(this.contact.getProvince())) + " " + Util.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!as.bvI(this.contact.field_username)) && (this.iXq.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((Util.isNullOrNil(this.contact.apf())) && ((as.bvU(this.contact.field_username)) || (ab.Qk(this.contact.field_username))))
        {
          this.DKE.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.contact.d.rk(this.contact.field_type))
        {
          hmK();
          break label341;
        }
      }
      this.DKE.setVisibility(8);
      break label341;
      label896:
      this.Pdm.setVisibility(8);
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31872);
    Log.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.vsF = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.DKE = ((TextView)paramView.findViewById(R.h.dBG));
    this.Rqq = ((TextView)paramView.findViewById(R.h.dAJ));
    this.Rql = ((TextView)paramView.findViewById(R.h.dAU));
    this.Rqm = ((TextView)paramView.findViewById(R.h.dBn));
    this.Rqo = ((Button)paramView.findViewById(R.h.dBu));
    this.Rqp = ((Button)paramView.findViewById(R.h.dBC));
    this.RqL = ((ProfileMobilePhoneView)paramView.findViewById(R.h.dMB));
    Object localObject = this.RqL;
    bh.beI();
    ((ProfileMobilePhoneView)localObject).RdA = ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vjr, Boolean.FALSE)).booleanValue();
    this.RqM = ((ProfileDescribeView)paramView.findViewById(R.h.dEf));
    this.RqN = ((ProfileLabelView)paramView.findViewById(R.h.dKz));
    this.RqO = ((TextView)paramView.findViewById(R.h.dTQ));
    this.RqM.setOnClickListener(this.RqP);
    this.RqN.setOnClickListener(this.RqP);
    this.RqO.setOnClickListener(this.RqP);
    if ((z.PD(this.contact.field_username)) || ((!Util.isNullOrNil(this.contact.field_username)) && (ab.QO(this.contact.field_username))))
    {
      this.RqO.setVisibility(8);
      this.RqL.setVisibility(8);
      this.RqM.setVisibility(8);
      this.RqN.setVisibility(8);
      this.Pdm = ((TextView)paramView.findViewById(R.h.dBb));
      this.Rqw = ((Button)paramView.findViewById(R.h.dAX));
      this.Rqx = ((FMessageListView)paramView.findViewById(R.h.dAY));
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.JpE;
      ((a.a)localObject).BLy = this.BLy;
      ((a.a)localObject).RpW = this.contact.hDx;
      ((a.a)localObject).type = 0;
      if (this.JpE != 18) {
        break label877;
      }
      ((a.a)localObject).type = 1;
      label424:
      this.Rqx.setFMessageArgs((a.a)localObject);
      this.Rqn = paramView.findViewById(R.h.dVr);
      this.Rqv = ((LinearLayout)paramView.findViewById(R.h.head_root));
      this.GXf = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
      this.Jpk = ((ImageView)paramView.findViewById(R.h.dBz));
      this.Rqr = ((ImageView)paramView.findViewById(R.h.dBL));
      this.Rqs = ((CheckBox)paramView.findViewById(R.h.dBD));
      this.Rqt = ((ImageView)paramView.findViewById(R.h.dBB));
      this.Rqu = ((ImageView)paramView.findViewById(R.h.dBA));
      this.Rqz = ((ImageView)paramView.findViewById(R.h.dBE));
      this.Rqy = ((RelativeLayout)paramView.findViewById(R.h.dBF));
      this.vkO = true;
      initView();
      if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {
        break label896;
      }
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.Rqx.setVisibility(8);
      if ((this.Rqx.getVisibility() == 8) && (this.RqO.getVisibility() == 8) && (this.RqN.getVisibility() == 8) && (this.RqM.getVisibility() == 8) && (this.Pdm.getVisibility() == 8)) {
        this.Rqn.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(31872);
      return;
      this.RqL.uNk = this.contact;
      this.RqL.no(this.Rdn, this.Rdo);
      if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {
        this.RqL.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.RqM.ap(this.contact);
        boolean bool2 = this.RqN.ap(this.contact);
        if ((!bool1) && (!bool2)) {
          break label798;
        }
        this.RqO.setVisibility(8);
        break;
        this.RqL.setVisibility(0);
      }
      label798:
      if ((this.RqI) || (this.RqG)) {
        this.RqO.setVisibility(8);
      }
      for (;;)
      {
        if ((this.RqQ == null) || ((!this.RqQ.equals("ContactWidgetBottleContact")) && (!this.RqQ.equals("ContactWidgetQContact")))) {
          break label875;
        }
        this.RqO.setVisibility(8);
        break;
        this.RqO.setVisibility(0);
      }
      label875:
      break;
      label877:
      if (!bq.uY(this.JpE)) {
        break label424;
      }
      ((a.a)localObject).type = 2;
      break label424;
      label896:
      if ((this.BLy != null) && (this.BLy.length() != 0)) {
        break label1033;
      }
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.JpE + ", verifyTicket = " + this.BLy);
      this.Rqx.setVisibility(8);
      if ((this.Rqx.getVisibility() == 8) && (this.RqO.getVisibility() == 8) && (this.RqN.getVisibility() == 8) && (this.RqM.getVisibility() == 8) && (this.Pdm.getVisibility() == 8)) {
        this.Rqn.setVisibility(8);
      }
    }
    label1033:
    Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.JpE);
    if (this.JpE == 18)
    {
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.bl.d.bqd().bwW(this.contact.field_username);
      localObject = b.a(this.iXq, (ef[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1290;
      }
      Log.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.Rqx.setVisibility(8);
      if ((this.Rqx.getVisibility() != 8) || (this.RqO.getVisibility() != 8) || (this.RqN.getVisibility() != 8) || (this.RqM.getVisibility() != 8) || (this.Pdm.getVisibility() != 8)) {
        break;
      }
      this.Rqn.setVisibility(8);
      break;
      if (bq.uY(this.JpE))
      {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.bl.d.bqe().bxw(this.contact.field_username);
        localObject = b.a(this.iXq, (cm[])localObject);
      }
      else
      {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.bl.d.bqb().bwT(this.contact.field_username);
        localObject = b.a(this.iXq, (bn[])localObject);
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
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.lpM + ", addScene = " + localb.JpE);
      }
      i += 1;
    }
    if (as.bvK(this.contact.field_username))
    {
      this.Rqx.setVisibility(8);
      this.Rqx.setHide(true);
    }
    for (;;)
    {
      if ((this.Rqx.getVisibility() == 0) || (this.RqO.getVisibility() == 0) || (this.RqN.getVisibility() == 0) || (this.RqM.getVisibility() == 0) || (this.Pdm.getVisibility() == 0)) {
        this.Rqn.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.Rqx.a(localb);
        i += 1;
      }
      break;
      this.Rqx.setVisibility(0);
      this.Rqx.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31871);
    if (this.Rqx != null) {
      this.Rqx.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(31871);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(31883);
    if (this.Rqx != null) {
      this.Rqx.detach();
    }
    if (this.RqJ) {
      com.tencent.mm.bl.d.bqc().bwR(this.contact.field_username);
    }
    this.iXq.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.RqG);
    this.iXq.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.RqH);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this);
    q.bhz().e(this);
    bh.beI();
    com.tencent.mm.model.c.bbM().b(this);
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
    if (!fpT())
    {
      Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.vkO + "contact = " + this.contact);
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
      bh.beI();
      this.contact = com.tencent.mm.model.c.bbL().RG(paramMStorageEx);
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
            if (com.tencent.mm.contact.d.rk(NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_type)) {
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