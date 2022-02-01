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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.n.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u.i;

public class NormalUserHeaderPreference
  extends Preference
  implements AvatarStorage.a, n.a, MStorageEx.IOnStorageChange
{
  private TextView JBA;
  private ImageView MVc;
  public boolean MZb;
  public boolean MZv;
  public int PCB;
  private ImageView PCh;
  private TextView VTT;
  private String XZt;
  private String XZu;
  private TextView YmC;
  private TextView YmD;
  private View YmE;
  private Button YmF;
  private Button YmG;
  private TextView YmH;
  private ImageView YmI;
  private CheckBox YmJ;
  private ImageView YmK;
  private ImageView YmL;
  private LinearLayout YmM;
  private Button YmN;
  private FMessageListView YmO;
  private RelativeLayout YmP;
  private ImageView YmQ;
  public boolean YmR;
  private int YmS;
  private boolean YmT;
  private boolean YmU;
  private boolean YmV;
  private boolean YmW;
  public boolean YmX;
  public boolean YmY;
  public boolean YmZ;
  public boolean Yna;
  public String Ynb;
  private ProfileMobilePhoneView Ync;
  private ProfileDescribeView Ynd;
  private ProfileLabelView Yne;
  private TextView Ynf;
  public View.OnClickListener Yng;
  public String Ynh;
  public au contact;
  public String lyn;
  public MMActivity lzt;
  public String pPi;
  private TextView yEQ;
  private boolean yxr;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31868);
    this.yxr = false;
    this.YmS = 0;
    this.YmT = false;
    this.YmU = false;
    this.YmV = false;
    this.YmW = false;
    this.YmX = false;
    this.YmY = false;
    this.YmZ = false;
    this.MZv = false;
    this.Yna = false;
    this.MZb = false;
    this.lyn = "";
    this.Ynh = null;
    this.lzt = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(31868);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31869);
    this.yxr = false;
    this.YmS = 0;
    this.YmT = false;
    this.YmU = false;
    this.YmV = false;
    this.YmW = false;
    this.YmX = false;
    this.YmY = false;
    this.YmZ = false;
    this.MZv = false;
    this.Yna = false;
    this.MZb = false;
    this.lyn = "";
    this.Ynh = null;
    this.lzt = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(31869);
  }
  
  private static boolean aRZ(String paramString)
  {
    AppMethodBeat.i(31873);
    if (com.tencent.mm.plugin.sns.c.q.Qkl != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.c.q.Qkl.aRZ(paramString);
      AppMethodBeat.o(31873);
      return bool;
    }
    AppMethodBeat.o(31873);
    return false;
  }
  
  private void awS(int paramInt)
  {
    AppMethodBeat.i(245149);
    if (this.YmM == null)
    {
      AppMethodBeat.o(245149);
      return;
    }
    View localView = this.YmM.findViewById(paramInt);
    if (localView == null)
    {
      AppMethodBeat.o(245149);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(245149);
  }
  
  private boolean gBh()
  {
    return (this.yxr) && (this.contact != null);
  }
  
  private void gzL()
  {
    AppMethodBeat.i(31874);
    a.b.g(this.MVc, this.contact.field_username);
    int i;
    if (this.MVc != null)
    {
      i = com.tencent.mm.cd.a.br(this.mContext, R.f.BigAvatarSize);
      int j = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 88);
      if (i <= j) {
        break label97;
      }
      i = j;
    }
    label97:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cd.a.bs(this.mContext, R.f.LargerPadding), 0);
      this.MVc.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(31874);
      return;
    }
  }
  
  private void iNB()
  {
    AppMethodBeat.i(31878);
    int i = 0;
    if (this.YmV) {
      i = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 17) + 0;
    }
    int j = i + this.YmS;
    i = j;
    if (this.YmT) {
      i = j + com.tencent.mm.cd.a.fromDPToPix(this.lzt, 27);
    }
    j = i;
    if (this.YmU) {
      j = i + com.tencent.mm.cd.a.fromDPToPix(this.lzt, 27);
    }
    i = j;
    if (this.YmW) {
      i = j + com.tencent.mm.cd.a.fromDPToPix(this.lzt, 30);
    }
    if (com.tencent.mm.cd.a.mp(this.mContext)) {
      i += com.tencent.mm.cd.a.fromDPToPix(this.lzt, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 60);
      DisplayMetrics localDisplayMetrics = this.lzt.getResources().getDisplayMetrics();
      this.yEQ.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(31878);
      return;
      i += com.tencent.mm.cd.a.fromDPToPix(this.lzt, 64);
    }
  }
  
  private void iNC()
  {
    int j = 0;
    AppMethodBeat.i(31884);
    ImageView localImageView;
    if ((this.YmK != null) && (au.bwH(this.contact.field_username)))
    {
      this.YmU = this.contact.aSL();
      localImageView = this.YmK;
      if (this.YmU)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.YmL != null) && (au.bwH(this.contact.field_username)))
    {
      this.YmT = aRZ(this.contact.field_username);
      localImageView = this.YmL;
      if (!this.YmT) {
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
  
  private void iND()
  {
    AppMethodBeat.i(31885);
    if (Util.isNullOrNil(this.Ynb))
    {
      this.YmC.setVisibility(8);
      AppMethodBeat.o(31885);
      return;
    }
    if ((!z.Iy(this.contact.field_username)) && (Util.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.JBA.setVisibility(8);
    }
    this.YmC.setVisibility(0);
    this.YmC.setText(p.b(this.lzt, this.lzt.getString(R.l.gBf) + this.Ynb, this.YmC.getTextSize()));
    AppMethodBeat.o(31885);
  }
  
  private void iNE()
  {
    AppMethodBeat.i(31886);
    if ((z.Iy(this.contact.field_username)) || (Util.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.YmD.setVisibility(8);
      this.yEQ.setText(p.b(this.lzt, Util.nullAsNil(this.contact.aSU()) + " ", this.yEQ.getTextSize()));
      if (this.YmZ)
      {
        this.YmF.setVisibility(0);
        this.Ynf.setVisibility(8);
        if (au.bwO(this.contact.field_username))
        {
          this.Ynf.setText(R.l.gDi);
          awS(R.h.fMQ);
        }
        if ((!this.MZv) || (com.tencent.mm.contact.d.rs(this.contact.field_type))) {
          break label563;
        }
        this.YmG.setVisibility(0);
      }
    }
    for (;;)
    {
      if (au.bwS(this.contact.field_username)) {
        this.yEQ.setText("");
      }
      if ((this.PCB == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.yEQ.setText(p.b(this.lzt, Util.nullAsNil(this.contact.field_nickname) + " ", this.yEQ.getTextSize()));
      }
      if ((this.YmG.getVisibility() == 0) && (this.YmD.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.YmD.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
        this.YmD.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(31886);
      return;
      if (this.YmX)
      {
        this.YmF.setVisibility(0);
        this.Ynf.setVisibility(8);
        break;
      }
      if (com.tencent.mm.contact.d.rs(this.contact.field_type)) {
        this.YmF.setVisibility(8);
      }
      boolean bool1 = this.Ynd.av(this.contact);
      boolean bool2 = this.Yne.av(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.Ynf.setVisibility(8);
      break;
      this.yEQ.setText(p.b(this.lzt, Util.nullAsNil(this.contact.field_conRemark) + " ", this.yEQ.getTextSize()));
      this.YmD.setVisibility(0);
      this.YmD.setText(p.b(this.lzt, this.mContext.getString(R.l.gBH) + this.contact.aSU(), this.YmD.getTextSize()));
      this.YmF.setVisibility(8);
      break;
      label563:
      if (this.YmY)
      {
        this.YmG.setVisibility(0);
        if (com.tencent.mm.cd.a.mp(this.lzt))
        {
          this.YmG.setTextSize(0, this.lzt.getResources().getDimensionPixelSize(R.f.HintTextSize));
          this.YmF.setTextSize(0, this.lzt.getResources().getDimensionPixelSize(R.f.HintTextSize));
        }
      }
      else
      {
        this.YmG.setVisibility(8);
      }
    }
  }
  
  private void iNF()
  {
    AppMethodBeat.i(31888);
    this.YmJ.setClickable(false);
    if (((au.bwH(this.contact.field_username)) || (au.bwO(this.contact.field_username))) && (com.tencent.mm.contact.d.rs(this.contact.field_type)) && (!z.Iy(this.contact.field_username)))
    {
      this.YmJ.setVisibility(0);
      if (this.contact.aSK())
      {
        this.YmJ.setChecked(true);
        this.YmW = true;
        AppMethodBeat.o(31888);
        return;
      }
      this.YmJ.setChecked(false);
      this.YmJ.setVisibility(8);
      this.YmW = false;
      AppMethodBeat.o(31888);
      return;
    }
    this.YmW = false;
    this.YmJ.setVisibility(8);
    AppMethodBeat.o(31888);
  }
  
  private void iNG()
  {
    AppMethodBeat.i(31892);
    if (!o.isShowStoryCheck())
    {
      this.YmP.setVisibility(8);
      AppMethodBeat.o(31892);
      return;
    }
    e locale = (e)h.az(e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.YmP.setVisibility(0);
      this.YmQ.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.YmM.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 166);
      this.YmM.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.lyn);
      AppMethodBeat.o(31892);
      return;
      this.YmP.setVisibility(8);
      this.YmQ.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.YmM.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.YmM.setLayoutParams(localLayoutParams);
    }
  }
  
  private void iNz()
  {
    AppMethodBeat.i(31875);
    this.YmH.setVisibility(0);
    this.yEQ.setText(p.b(this.lzt, Util.nullAsNil(this.contact.aSU()) + " ", this.yEQ.getTextSize()));
    gzL();
    this.YmN.setVisibility(8);
    this.JBA.setVisibility(8);
    this.YmO.setVisibility(8);
    if ((this.YmO.getVisibility() == 8) && (this.Ynf.getVisibility() == 8) && (this.Yne.getVisibility() == 8) && (this.Ynd.getVisibility() == 8) && (this.VTT.getVisibility() == 8)) {
      this.YmE.setVisibility(8);
    }
    this.YmF.setVisibility(8);
    this.YmG.setVisibility(8);
    this.YmJ.setVisibility(8);
    if (this.Yne != null) {
      this.Yne.setVisibility(8);
    }
    if (this.Ync != null) {
      this.Ync.setVisibility(8);
    }
    if (this.Ynd != null) {
      this.Ynd.setVisibility(8);
    }
    if (this.Ynf != null) {
      this.Ynf.setVisibility(8);
    }
    if (this.YmD != null) {
      this.YmD.setVisibility(8);
    }
    AppMethodBeat.o(31875);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(31889);
    if (!gBh())
    {
      Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.yxr + "contact = " + this.contact);
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
  
  public final void a(final cr paramcr)
  {
    AppMethodBeat.i(31891);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31867);
        if ((NormalUserHeaderPreference.a(NormalUserHeaderPreference.this) != null) && (paramcr != null) && (NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username.equals(paramcr.field_encryptUsername)))
        {
          NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).AW(paramcr.field_conRemark);
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
  
  public final void iNA()
  {
    AppMethodBeat.i(31877);
    this.JBA.setVisibility(0);
    if (!Util.isNullOrNil(this.contact.aJs()))
    {
      this.JBA.setText(com.tencent.mm.plugin.profile.c.bG(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.la(this.contact.field_username, this.contact.aJs()));
      AppMethodBeat.o(31877);
      return;
    }
    if ((!au.bxb(this.contact.field_username)) && (!au.bxa(this.contact.field_username)))
    {
      String str = Util.nullAsNil(this.contact.aSW());
      this.JBA.setText(com.tencent.mm.plugin.profile.c.bG(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.la(this.contact.field_username, str));
      AppMethodBeat.o(31877);
      return;
    }
    this.JBA.setVisibility(8);
    AppMethodBeat.o(31877);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(31876);
    if (!gBh())
    {
      Log.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.yxr + "contact = " + this.contact);
      AppMethodBeat.o(31876);
      return;
    }
    if (this.MZb)
    {
      iNz();
      AppMethodBeat.o(31876);
      return;
    }
    boolean bool = au.bwS(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.yEQ.setText("");
      if (au.bxd(z.bAM()).equals(this.contact.field_username)) {
        this.YmN.setVisibility(8);
      }
      this.PCh.setVisibility(0);
      this.YmV = true;
      if (this.contact.sex != 1) {
        break label495;
      }
      this.PCh.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, R.k.ic_sex_male));
      this.PCh.setContentDescription(this.mContext.getString(R.l.profile_sex_male_desc));
      if (this.contact.field_verifyFlag != 0)
      {
        this.YmI.setVisibility(0);
        if (az.a.okR == null) {
          break label570;
        }
        localBitmap = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(this.contact.field_verifyFlag), 2.0F);
        this.YmI.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label575;
        }
        i = 0;
        label245:
        this.YmS = i;
      }
      gzL();
      iNG();
      this.MVc.setOnClickListener(new NormalUserHeaderPreference.1(this));
      this.YmQ.setOnClickListener(new NormalUserHeaderPreference.2(this));
      if (!au.bwN(this.contact.field_username)) {
        break label583;
      }
      this.JBA.setText(this.mContext.getString(R.l.app_field_qquin) + this.contact.aSW());
      label341:
      if (!au.bws(this.contact.field_username)) {
        break label896;
      }
      this.VTT.setVisibility(0);
    }
    for (;;)
    {
      iNE();
      iNC();
      iNF();
      iND();
      this.YmF.setOnClickListener(new NormalUserHeaderPreference.3(this));
      this.YmG.setOnClickListener(new NormalUserHeaderPreference.4(this));
      iNB();
      this.JBA.setLongClickable(true);
      this.JBA.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31865);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
            ((com.tencent.mm.ui.widget.b.a)localObject).agjt = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(31862);
                paramAnonymous2ContextMenu.add(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(R.l.app_copy));
                AppMethodBeat.o(31862);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(31863);
                if (paramAnonymous2Int == 0)
                {
                  ClipboardHelper.setText(paramAnonymousView);
                  k.cY(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(R.l.app_copy_ok));
                }
                AppMethodBeat.o(31863);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).afLp = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(31864);
                NormalUserHeaderPreference.this.iNA();
                AppMethodBeat.o(31864);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).cMz();
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(31865);
          return true;
        }
      });
      AppMethodBeat.o(31876);
      return;
      this.yEQ.setText(p.b(this.lzt, Util.nullAsNil(this.contact.field_nickname) + " ", this.yEQ.getTextSize()));
      break;
      label495:
      if (this.contact.sex == 2)
      {
        this.PCh.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, R.k.ic_sex_female));
        this.PCh.setContentDescription(this.mContext.getString(R.l.profile_sex_female_desc));
        break label187;
      }
      if (this.contact.sex != 0) {
        break label187;
      }
      this.PCh.setVisibility(8);
      this.YmV = false;
      break label187;
      label570:
      localBitmap = null;
      break label231;
      label575:
      i = localBitmap.getWidth();
      break label245;
      label583:
      if (au.bwL(this.contact.field_username))
      {
        this.JBA.setText(this.mContext.getString(R.l.app_field_weibo) + this.contact.aSW());
        break label341;
      }
      if (this.YmR)
      {
        if (com.tencent.mm.contact.d.rs(this.contact.field_type))
        {
          iNA();
          break label341;
        }
        if ((this.contact.kah == null) || (this.contact.kah.equals("")))
        {
          this.JBA.setText(R.l.app_empty_string);
          break label341;
        }
        this.JBA.setText(this.contact.kah);
        break label341;
      }
      if (bool)
      {
        this.JBA.setText((Util.nullAsNil(aa.IF(this.contact.getProvince())) + " " + Util.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!au.bwM(this.contact.field_username)) && (this.lzt.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((Util.isNullOrNil(this.contact.aJs())) && ((au.bxb(this.contact.field_username)) || (au.bxa(this.contact.field_username))))
        {
          this.JBA.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.contact.d.rs(this.contact.field_type))
        {
          iNA();
          break label341;
        }
      }
      this.JBA.setVisibility(8);
      break label341;
      label896:
      this.VTT.setVisibility(8);
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31872);
    Log.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.yEQ = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.JBA = ((TextView)paramView.findViewById(R.h.fCU));
    this.YmH = ((TextView)paramView.findViewById(R.h.fBJ));
    this.YmC = ((TextView)paramView.findViewById(R.h.fCi));
    this.YmD = ((TextView)paramView.findViewById(R.h.fCB));
    this.YmF = ((Button)paramView.findViewById(R.h.fCI));
    this.YmG = ((Button)paramView.findViewById(R.h.fCQ));
    this.Ync = ((ProfileMobilePhoneView)paramView.findViewById(R.h.fOl));
    Object localObject = this.Ync;
    bh.bCz();
    ((ProfileMobilePhoneView)localObject).XZG = ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKL, Boolean.FALSE)).booleanValue();
    this.Ynd = ((ProfileDescribeView)paramView.findViewById(R.h.fEY));
    this.Yne = ((ProfileLabelView)paramView.findViewById(R.h.fLY));
    this.Ynf = ((TextView)paramView.findViewById(R.h.fVY));
    this.Ynd.setOnClickListener(this.Yng);
    this.Yne.setOnClickListener(this.Yng);
    this.Ynf.setOnClickListener(this.Yng);
    if ((z.Iy(this.contact.field_username)) || ((!Util.isNullOrNil(this.contact.field_username)) && (au.bws(this.contact.field_username))))
    {
      this.Ynf.setVisibility(8);
      this.Ync.setVisibility(8);
      this.Ynd.setVisibility(8);
      this.Yne.setVisibility(8);
      this.VTT = ((TextView)paramView.findViewById(R.h.fCo));
      this.YmN = ((Button)paramView.findViewById(R.h.fCl));
      this.YmO = ((FMessageListView)paramView.findViewById(R.h.fCm));
      if (this.lzt != null) {
        this.YmO.setForceHideReply(this.lzt.getIntent().getBooleanExtra("Contact_Conversation_IsForceHideReplyBtn", false));
      }
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.PCB;
      ((a.a)localObject).pPi = this.pPi;
      ((a.a)localObject).Ymm = this.contact.kas;
      ((a.a)localObject).type = 0;
      if (this.PCB != 18) {
        break label905;
      }
      ((a.a)localObject).type = 1;
      label452:
      this.YmO.setFMessageArgs((a.a)localObject);
      this.YmE = paramView.findViewById(R.h.fXM);
      this.YmM = ((LinearLayout)paramView.findViewById(R.h.head_root));
      this.MVc = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
      this.PCh = ((ImageView)paramView.findViewById(R.h.fCN));
      this.YmI = ((ImageView)paramView.findViewById(R.h.fCZ));
      this.YmJ = ((CheckBox)paramView.findViewById(R.h.fCR));
      this.YmK = ((ImageView)paramView.findViewById(R.h.fCP));
      this.YmL = ((ImageView)paramView.findViewById(R.h.fCO));
      this.YmQ = ((ImageView)paramView.findViewById(R.h.fCS));
      this.YmP = ((RelativeLayout)paramView.findViewById(R.h.fCT));
      this.yxr = true;
      initView();
      if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {
        break label924;
      }
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.YmO.setVisibility(8);
      if ((this.YmO.getVisibility() == 8) && (this.Ynf.getVisibility() == 8) && (this.Yne.getVisibility() == 8) && (this.Ynd.getVisibility() == 8) && (this.VTT.getVisibility() == 8)) {
        this.YmE.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(31872);
      return;
      this.Ync.xVS = this.contact;
      this.Ync.pj(this.XZt, this.XZu);
      if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {
        this.Ync.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.Ynd.av(this.contact);
        boolean bool2 = this.Yne.av(this.contact);
        if ((!bool1) && (!bool2)) {
          break label826;
        }
        this.Ynf.setVisibility(8);
        break;
        this.Ync.setVisibility(0);
      }
      label826:
      if ((this.YmZ) || (this.YmX)) {
        this.Ynf.setVisibility(8);
      }
      for (;;)
      {
        if ((this.Ynh == null) || ((!this.Ynh.equals("ContactWidgetBottleContact")) && (!this.Ynh.equals("ContactWidgetQContact")))) {
          break label903;
        }
        this.Ynf.setVisibility(8);
        break;
        this.Ynf.setVisibility(0);
      }
      label903:
      break;
      label905:
      if (!br.vj(this.PCB)) {
        break label452;
      }
      ((a.a)localObject).type = 2;
      break label452;
      label924:
      if ((this.pPi != null) && (this.pPi.length() != 0)) {
        break label1061;
      }
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.PCB + ", verifyTicket = " + this.pPi);
      this.YmO.setVisibility(8);
      if ((this.YmO.getVisibility() == 8) && (this.Ynf.getVisibility() == 8) && (this.Yne.getVisibility() == 8) && (this.Ynd.getVisibility() == 8) && (this.VTT.getVisibility() == 8)) {
        this.YmE.setVisibility(8);
      }
    }
    label1061:
    Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.PCB);
    if (this.PCB == 18)
    {
      Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.modelverify.d.bNJ().byp(this.contact.field_username);
      localObject = b.a(this.lzt, (et[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1318;
      }
      Log.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.YmO.setVisibility(8);
      if ((this.YmO.getVisibility() != 8) || (this.Ynf.getVisibility() != 8) || (this.Yne.getVisibility() != 8) || (this.Ynd.getVisibility() != 8) || (this.VTT.getVisibility() != 8)) {
        break;
      }
      this.YmE.setVisibility(8);
      break;
      if (br.vj(this.PCB))
      {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.modelverify.d.bNK().byO(this.contact.field_username);
        localObject = b.a(this.lzt, (cp[])localObject);
      }
      else
      {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.modelverify.d.bNH().bym(this.contact.field_username);
        localObject = b.a(this.lzt, (bp[])localObject);
      }
    }
    label1318:
    Log.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + localObject.length);
    int j = localObject.length;
    int i = 0;
    b localb;
    while (i < j)
    {
      localb = localObject[i];
      if (localb != null) {
        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.nUO + ", addScene = " + localb.PCB);
      }
      i += 1;
    }
    if (au.bwO(this.contact.field_username))
    {
      this.YmO.setVisibility(8);
      this.YmO.setHide(true);
    }
    for (;;)
    {
      if ((this.YmO.getVisibility() == 0) || (this.Ynf.getVisibility() == 0) || (this.Yne.getVisibility() == 0) || (this.Ynd.getVisibility() == 0) || (this.VTT.getVisibility() == 0)) {
        this.YmE.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.YmO.a(localb);
        i += 1;
      }
      break;
      this.YmO.setVisibility(0);
      this.YmO.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31871);
    if (this.YmO != null) {
      this.YmO.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(31871);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(31883);
    if (this.YmO != null) {
      this.YmO.detach();
    }
    if (this.Yna) {
      com.tencent.mm.modelverify.d.bNI().byk(this.contact.field_username);
    }
    this.lzt.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.YmX);
    this.lzt.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.YmY);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this);
    com.tencent.mm.modelavatar.q.bFp().e(this);
    bh.bCz();
    com.tencent.mm.model.c.bzB().b(this);
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
    if (!gBh())
    {
      Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.yxr + "contact = " + this.contact);
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
      bh.bCz();
      this.contact = com.tencent.mm.model.c.bzA().JE(paramMStorageEx);
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
            if (com.tencent.mm.contact.d.rs(NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_type)) {
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