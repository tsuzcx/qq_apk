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
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.bz;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference
  extends Preference
  implements e.a, m.a, n.b
{
  private TextView BJM;
  private TextView DAS;
  private TextView DAT;
  private View DAU;
  private Button DAV;
  private Button DAW;
  private TextView DAX;
  private ImageView DAY;
  private CheckBox DAZ;
  private ImageView DBa;
  private ImageView DBb;
  private LinearLayout DBc;
  private Button DBd;
  private FMessageListView DBe;
  private RelativeLayout DBf;
  private ImageView DBg;
  private int DBh;
  private boolean DBi;
  private boolean DBj;
  private boolean DBk;
  private boolean DBl;
  private boolean DBm;
  private boolean DBn;
  private boolean DBo;
  private boolean DBp;
  private String DBq;
  private ProfileMobilePhoneView DBr;
  private ProfileDescribeView DBs;
  private ProfileLabelView DBt;
  private TextView DBu;
  public View.OnClickListener DBv;
  public String DBw;
  private String Dop;
  private String Doq;
  com.tencent.mm.storage.ai contact;
  private String fvZ;
  MMActivity iMV;
  private boolean pDN;
  private String sBi;
  private TextView tDD;
  private TextView tqQ;
  private ImageView vIC;
  private boolean vKM;
  private boolean vKS;
  private boolean vMB;
  private ClipboardManager vfB;
  int xAq;
  private ImageView xzW;
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31868);
    this.pDN = false;
    this.DBh = 0;
    this.DBi = false;
    this.DBj = false;
    this.DBk = false;
    this.DBl = false;
    this.DBm = false;
    this.DBn = false;
    this.DBo = false;
    this.vMB = false;
    this.DBp = false;
    this.vKS = false;
    this.fvZ = "";
    this.DBw = null;
    this.iMV = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31868);
  }
  
  public NormalUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31869);
    this.pDN = false;
    this.DBh = 0;
    this.DBi = false;
    this.DBj = false;
    this.DBk = false;
    this.DBl = false;
    this.DBm = false;
    this.DBn = false;
    this.DBo = false;
    this.vMB = false;
    this.DBp = false;
    this.vKS = false;
    this.fvZ = "";
    this.DBw = null;
    this.iMV = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(31869);
  }
  
  private static boolean apG(String paramString)
  {
    AppMethodBeat.i(31873);
    if (com.tencent.mm.plugin.sns.b.o.xMd != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.b.o.xMd.apG(paramString);
      AppMethodBeat.o(31873);
      return bool;
    }
    AppMethodBeat.o(31873);
    return false;
  }
  
  private boolean dpP()
  {
    return (this.pDN) && (this.contact != null);
  }
  
  private void dyf()
  {
    AppMethodBeat.i(31874);
    a.b.c(this.vIC, this.contact.field_username);
    int i;
    if (this.vIC != null)
    {
      i = com.tencent.mm.cc.a.au(this.mContext, 2131165188);
      int j = com.tencent.mm.cc.a.fromDPToPix(this.iMV, 88);
      if (i <= j) {
        break label95;
      }
      i = j;
    }
    label95:
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cc.a.av(this.mContext, 2131165483), 0);
      this.vIC.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(31874);
      return;
    }
  }
  
  private void ePD()
  {
    AppMethodBeat.i(31875);
    this.DAX.setVisibility(0);
    this.tqQ.setText(k.b(this.iMV, bs.nullAsNil(this.contact.aaR()) + " ", this.tqQ.getTextSize()));
    dyf();
    this.DBd.setVisibility(8);
    this.tDD.setVisibility(8);
    this.DBe.setVisibility(8);
    if ((this.DBe.getVisibility() == 8) && (this.DBu.getVisibility() == 8) && (this.DBt.getVisibility() == 8) && (this.DBs.getVisibility() == 8) && (this.BJM.getVisibility() == 8)) {
      this.DAU.setVisibility(8);
    }
    this.DAV.setVisibility(8);
    this.DAW.setVisibility(8);
    this.DAZ.setVisibility(8);
    if (this.DBt != null) {
      this.DBt.setVisibility(8);
    }
    if (this.DBr != null) {
      this.DBr.setVisibility(8);
    }
    if (this.DBs != null) {
      this.DBs.setVisibility(8);
    }
    if (this.DBu != null) {
      this.DBu.setVisibility(8);
    }
    if (this.DAT != null) {
      this.DAT.setVisibility(8);
    }
    AppMethodBeat.o(31875);
  }
  
  private void ePF()
  {
    AppMethodBeat.i(31878);
    int i = 0;
    if (this.DBk) {
      i = com.tencent.mm.cc.a.fromDPToPix(this.iMV, 17) + 0;
    }
    int j = i + this.DBh;
    i = j;
    if (this.DBi) {
      i = j + com.tencent.mm.cc.a.fromDPToPix(this.iMV, 27);
    }
    j = i;
    if (this.DBj) {
      j = i + com.tencent.mm.cc.a.fromDPToPix(this.iMV, 27);
    }
    i = j;
    if (this.DBl) {
      i = j + com.tencent.mm.cc.a.fromDPToPix(this.iMV, 30);
    }
    if (com.tencent.mm.cc.a.id(this.mContext)) {
      i += com.tencent.mm.cc.a.fromDPToPix(this.iMV, 88);
    }
    for (;;)
    {
      j = com.tencent.mm.cc.a.fromDPToPix(this.iMV, 60);
      DisplayMetrics localDisplayMetrics = this.iMV.getResources().getDisplayMetrics();
      this.tqQ.setMaxWidth(localDisplayMetrics.widthPixels - (i + j));
      AppMethodBeat.o(31878);
      return;
      i += com.tencent.mm.cc.a.fromDPToPix(this.iMV, 64);
    }
  }
  
  private void ePG()
  {
    int j = 0;
    AppMethodBeat.i(31884);
    ImageView localImageView;
    if ((this.DBa != null) && (w.wn(this.contact.field_username)))
    {
      this.DBj = this.contact.aaK();
      localImageView = this.DBa;
      if (this.DBj)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if ((this.DBb != null) && (w.wn(this.contact.field_username)))
    {
      this.DBi = apG(this.contact.field_username);
      localImageView = this.DBb;
      if (!this.DBi) {
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
  
  private void ePH()
  {
    AppMethodBeat.i(31885);
    if (bs.isNullOrNil(this.DBq))
    {
      this.DAS.setVisibility(8);
      AppMethodBeat.o(31885);
      return;
    }
    if ((!u.wh(this.contact.field_username)) && (bs.nullAsNil(this.contact.field_conRemark).length() > 0)) {
      this.tDD.setVisibility(8);
    }
    this.DAS.setVisibility(0);
    this.DAS.setText(k.b(this.iMV, this.iMV.getString(2131757629) + this.DBq, this.DAS.getTextSize()));
    AppMethodBeat.o(31885);
  }
  
  private void ePI()
  {
    AppMethodBeat.i(31886);
    if ((u.wh(this.contact.field_username)) || (bs.nullAsNil(this.contact.field_conRemark).length() <= 0))
    {
      this.DAT.setVisibility(8);
      this.tqQ.setText(k.b(this.iMV, bs.nullAsNil(this.contact.aaR()) + " ", this.tqQ.getTextSize()));
      if (this.DBo)
      {
        this.DAV.setVisibility(0);
        this.DBu.setVisibility(8);
        if (com.tencent.mm.storage.ai.aNc(this.contact.field_username))
        {
          this.DBu.setText(2131757927);
          ePJ();
        }
        if ((!this.vMB) || (com.tencent.mm.n.b.ln(this.contact.field_type))) {
          break label560;
        }
        this.DAW.setVisibility(0);
      }
    }
    for (;;)
    {
      if (com.tencent.mm.storage.ai.ww(this.contact.field_username)) {
        this.tqQ.setText("");
      }
      if ((this.xAq == 76) && (this.contact.field_username != null) && (this.contact.field_username.endsWith("@stranger"))) {
        this.tqQ.setText(k.b(this.iMV, bs.nullAsNil(this.contact.field_nickname) + " ", this.tqQ.getTextSize()));
      }
      if ((this.DAW.getVisibility() == 0) && (this.DAT.getVisibility() == 0))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.DAT.getLayoutParams();
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165568);
        this.DAT.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(31886);
      return;
      if (this.DBm)
      {
        this.DAV.setVisibility(0);
        this.DBu.setVisibility(8);
        break;
      }
      if (com.tencent.mm.n.b.ln(this.contact.field_type)) {
        this.DAV.setVisibility(8);
      }
      boolean bool1 = this.DBs.aa(this.contact);
      boolean bool2 = this.DBt.aa(this.contact);
      if ((!bool1) && (!bool2)) {
        break;
      }
      this.DBu.setVisibility(8);
      break;
      this.tqQ.setText(k.b(this.iMV, bs.nullAsNil(this.contact.field_conRemark) + " ", this.tqQ.getTextSize()));
      this.DAT.setVisibility(0);
      this.DAT.setText(k.b(this.iMV, this.mContext.getString(2131757742) + this.contact.aaR(), this.DAT.getTextSize()));
      this.DAV.setVisibility(8);
      break;
      label560:
      if (this.DBn)
      {
        this.DAW.setVisibility(0);
        if (com.tencent.mm.cc.a.id(this.iMV))
        {
          this.DAW.setTextSize(0, this.iMV.getResources().getDimensionPixelSize(2131165466));
          this.DAV.setTextSize(0, this.iMV.getResources().getDimensionPixelSize(2131165466));
        }
      }
      else
      {
        this.DAW.setVisibility(8);
      }
    }
  }
  
  private void ePJ()
  {
    AppMethodBeat.i(31887);
    if (this.DBc == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    View localView = this.DBc.findViewById(2131301430);
    if (localView == null)
    {
      AppMethodBeat.o(31887);
      return;
    }
    localView.setVisibility(8);
    AppMethodBeat.o(31887);
  }
  
  private void ePK()
  {
    AppMethodBeat.i(31888);
    this.DAZ.setClickable(false);
    if (((w.wn(this.contact.field_username)) || (com.tencent.mm.storage.ai.aNc(this.contact.field_username))) && (com.tencent.mm.n.b.ln(this.contact.field_type)) && (!u.wh(this.contact.field_username)))
    {
      this.DAZ.setVisibility(0);
      if (this.contact.aaJ())
      {
        this.DAZ.setChecked(true);
        this.DBl = true;
        AppMethodBeat.o(31888);
        return;
      }
      this.DAZ.setChecked(false);
      this.DAZ.setVisibility(8);
      this.DBl = false;
      AppMethodBeat.o(31888);
      return;
    }
    this.DBl = false;
    this.DAZ.setVisibility(8);
    AppMethodBeat.o(31888);
  }
  
  private void ePL()
  {
    AppMethodBeat.i(31892);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      this.DBf.setVisibility(8);
      AppMethodBeat.o(31892);
      return;
    }
    com.tencent.mm.plugin.story.api.e locale = (com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class);
    RelativeLayout.LayoutParams localLayoutParams;
    if (locale.isStoryExist(this.contact.field_username))
    {
      this.DBf.setVisibility(0);
      this.DBg.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.DBc.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(this.iMV, 166);
      this.DBc.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      locale.loadStory(this.contact.field_username, this.fvZ);
      AppMethodBeat.o(31892);
      return;
      this.DBf.setVisibility(8);
      this.DBg.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.DBc.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.DBc.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(31870);
    this.pDN = false;
    this.vfB = ((ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard"));
    AppMethodBeat.o(31870);
  }
  
  private void initView()
  {
    AppMethodBeat.i(31876);
    if (!dpP())
    {
      ac.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.pDN + "contact = " + this.contact);
      AppMethodBeat.o(31876);
      return;
    }
    if (this.vKS)
    {
      ePD();
      AppMethodBeat.o(31876);
      return;
    }
    boolean bool = com.tencent.mm.storage.ai.ww(this.contact.field_username);
    label187:
    Bitmap localBitmap;
    label231:
    int i;
    if (bool)
    {
      this.tqQ.setText("");
      if (com.tencent.mm.storage.ai.aNh(u.axw()).equals(this.contact.field_username)) {
        this.DBd.setVisibility(8);
      }
      this.xzW.setVisibility(0);
      this.DBk = true;
      if (this.contact.exL != 1) {
        break label495;
      }
      this.xzW.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131690323));
      this.xzW.setContentDescription(this.mContext.getString(2131762052));
      if (this.contact.field_verifyFlag != 0)
      {
        this.DAY.setVisibility(0);
        if (ar.a.hny == null) {
          break label570;
        }
        localBitmap = BackwardSupportUtil.b.n(ar.a.hny.nR(this.contact.field_verifyFlag), 2.0F);
        this.DAY.setImageBitmap(localBitmap);
        if (localBitmap != null) {
          break label575;
        }
        i = 0;
        label245:
        this.DBh = i;
      }
      dyf();
      ePL();
      this.vIC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31858);
          Object localObject = NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username;
          paramAnonymousView = (View)localObject;
          if (com.tencent.mm.storage.ai.ww((String)localObject)) {
            paramAnonymousView = com.tencent.mm.storage.ai.aNh((String)localObject);
          }
          localObject = new Intent(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", paramAnonymousView);
          paramAnonymousView = NormalUserHeaderPreference.b(NormalUserHeaderPreference.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(31858);
        }
      });
      this.DBg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31859);
          com.tencent.mm.plugin.story.api.o.bf(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          AppMethodBeat.o(31859);
        }
      });
      if (!com.tencent.mm.storage.ai.aNb(this.contact.field_username)) {
        break label583;
      }
      this.tDD.setText(this.mContext.getString(2131755753) + this.contact.aaT());
      label341:
      if (!w.xj(this.contact.field_username)) {
        break label896;
      }
      this.BJM.setVisibility(0);
    }
    for (;;)
    {
      ePI();
      ePG();
      ePK();
      ePH();
      this.DAV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31860);
          NormalUserHeaderPreference.c(NormalUserHeaderPreference.this);
          paramAnonymousView = NormalUserHeaderPreference.this;
          az.ayM();
          Object localObject = c.awB().aNt(paramAnonymousView.contact.field_username);
          if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fLJ != 0) && (((av)localObject).field_username.equals(paramAnonymousView.contact.field_username))) {
            paramAnonymousView.contact = ((com.tencent.mm.storage.ai)localObject);
          }
          if (!com.tencent.mm.n.b.ln(paramAnonymousView.contact.field_type))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.xAq);
            ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
            ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.contact.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousView.contact.field_conRemark);
            paramAnonymousView = (Activity)paramAnonymousView.mContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(31860);
            return;
          }
          localObject = new Intent();
          ((Intent)localObject).setClassName(paramAnonymousView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
          ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.xAq);
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.contact.field_username);
          ((Intent)localObject).putExtra("Contact_RoomNickname", paramAnonymousView.iMV.getIntent().getStringExtra("Contact_RoomNickname"));
          paramAnonymousView = (Activity)paramAnonymousView.mContext;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(31860);
        }
      });
      this.DAW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31861);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 3);
          com.tencent.mm.br.d.b(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          AppMethodBeat.o(31861);
        }
      });
      ePF();
      this.tDD.setLongClickable(true);
      this.tDD.setOnLongClickListener(new View.OnLongClickListener()
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
            ((com.tencent.mm.ui.widget.b.a)localObject).JiR = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(31862);
                paramAnonymous2ContextMenu.add(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755701));
                AppMethodBeat.o(31862);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).ISv = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(31863);
                if (paramAnonymous2Int == 0)
                {
                  NormalUserHeaderPreference.e(NormalUserHeaderPreference.this).setText(paramAnonymousView);
                  h.cf(NormalUserHeaderPreference.b(NormalUserHeaderPreference.this), NormalUserHeaderPreference.b(NormalUserHeaderPreference.this).getString(2131755702));
                }
                AppMethodBeat.o(31863);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).IUx = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(31864);
                NormalUserHeaderPreference.this.ePE();
                AppMethodBeat.o(31864);
              }
            };
            ((com.tencent.mm.ui.widget.b.a)localObject).ej(0, 0);
          }
          AppMethodBeat.o(31865);
          return true;
        }
      });
      AppMethodBeat.o(31876);
      return;
      this.tqQ.setText(k.b(this.iMV, bs.nullAsNil(this.contact.field_nickname) + " ", this.tqQ.getTextSize()));
      break;
      label495:
      if (this.contact.exL == 2)
      {
        this.xzW.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131690322));
        this.xzW.setContentDescription(this.mContext.getString(2131762051));
        break label187;
      }
      if (this.contact.exL != 0) {
        break label187;
      }
      this.xzW.setVisibility(8);
      this.DBk = false;
      break label187;
      label570:
      localBitmap = null;
      break label231;
      label575:
      i = localBitmap.getWidth();
      break label245;
      label583:
      if (com.tencent.mm.storage.ai.aMZ(this.contact.field_username))
      {
        this.tDD.setText(this.mContext.getString(2131755766) + this.contact.aaT());
        break label341;
      }
      if (this.vKM)
      {
        if (com.tencent.mm.n.b.ln(this.contact.field_type))
        {
          ePE();
          break label341;
        }
        if ((this.contact.exX == null) || (this.contact.exX.equals("")))
        {
          this.tDD.setText(2131755726);
          break label341;
        }
        this.tDD.setText(this.contact.exX);
        break label341;
      }
      if (bool)
      {
        this.tDD.setText((bs.nullAsNil(v.wm(this.contact.getProvince())) + " " + bs.nullAsNil(this.contact.getCity())).trim());
        break label341;
      }
      if ((!com.tencent.mm.storage.ai.aNa(this.contact.field_username)) && (this.iMV.getIntent().getBooleanExtra("Contact_ShowUserName", true)))
      {
        if ((bs.isNullOrNil(this.contact.Tl())) && ((com.tencent.mm.storage.ai.aNf(this.contact.field_username)) || (w.wF(this.contact.field_username))))
        {
          this.tDD.setVisibility(8);
          break label341;
        }
        if (com.tencent.mm.n.b.ln(this.contact.field_type))
        {
          ePE();
          break label341;
        }
      }
      this.tDD.setVisibility(8);
      break label341;
      label896:
      this.BJM.setVisibility(8);
    }
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(31889);
    if (!dpP())
    {
      ac.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.pDN + "contact = " + this.contact);
      AppMethodBeat.o(31889);
      return;
    }
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      ac.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(31889);
      return;
    }
    if (paramString.equals(this.contact.field_username)) {
      initView();
    }
    AppMethodBeat.o(31889);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(31890);
    ac.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(31890);
      return;
    }
    paramn = (String)paramObject;
    ac.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + paramn + ", contact = " + this.contact);
    if (!dpP())
    {
      ac.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.pDN + "contact = " + this.contact);
      AppMethodBeat.o(31890);
      return;
    }
    if (bs.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(31890);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      az.ayM();
      this.contact = c.awB().aNt(paramn);
      ap.f(new Runnable()
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
            if (com.tencent.mm.n.b.ln(NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_type)) {
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
  
  public final void a(com.tencent.mm.storage.ai paramai, int paramInt, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31882);
    onDetach();
    az.ayM();
    c.awB().a(this);
    az.ayM();
    c.awC().a(this);
    p.aBh().d(this);
    this.contact = paramai;
    this.xAq = paramInt;
    this.sBi = paramString;
    this.vKM = this.iMV.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
    this.DBp = this.iMV.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
    this.DBm = this.iMV.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
    this.DBn = this.iMV.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
    this.DBo = this.iMV.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
    this.vMB = this.iMV.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
    this.DBq = this.iMV.getIntent().getStringExtra("Contact_RoomNickname");
    if (paramai.field_deleteFlag == 1)
    {
      bool1 = true;
      this.vKS = bool1;
      this.fvZ = this.iMV.getIntent().getStringExtra("room_name");
      if (bs.nullAsNil(paramai.field_username).length() <= 0) {
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
  
  public final void a(com.tencent.mm.storage.ai paramai, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31881);
    this.Dop = paramString2;
    this.Doq = paramString3;
    a(paramai, paramInt, paramString1);
    AppMethodBeat.o(31881);
  }
  
  public final void a(final bz parambz)
  {
    AppMethodBeat.i(31891);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31867);
        if ((NormalUserHeaderPreference.a(NormalUserHeaderPreference.this) != null) && (parambz != null) && (NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username.equals(parambz.field_encryptUsername)))
        {
          NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).qh(parambz.field_conRemark);
          if (!NormalUserHeaderPreference.j(NormalUserHeaderPreference.this))
          {
            ac.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.k(NormalUserHeaderPreference.this) + "contact = " + NormalUserHeaderPreference.a(NormalUserHeaderPreference.this).field_username);
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
  
  public final void cy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31879);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.DBm = paramBoolean;
    }
    AppMethodBeat.o(31879);
  }
  
  public final void cz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31880);
    if ((paramString != null) && (paramString.equals(this.contact.field_username))) {
      this.DBn = paramBoolean;
    }
    AppMethodBeat.o(31880);
  }
  
  public final void ePE()
  {
    AppMethodBeat.i(31877);
    this.tDD.setVisibility(0);
    if (!bs.isNullOrNil(this.contact.Tl()))
    {
      this.tDD.setText(this.mContext.getString(2131755760) + this.contact.Tl());
      AppMethodBeat.o(31877);
      return;
    }
    if ((!com.tencent.mm.storage.ai.aNf(this.contact.field_username)) && (!w.wF(this.contact.field_username)))
    {
      String str = bs.nullAsNil(this.contact.aaT());
      this.tDD.setText(this.mContext.getString(2131755760) + str);
      AppMethodBeat.o(31877);
      return;
    }
    this.tDD.setVisibility(8);
    AppMethodBeat.o(31877);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31872);
    ac.d("MicroMsg.ContactInfoHeader", "onBindView");
    this.tqQ = ((TextView)paramView.findViewById(2131298631));
    this.tDD = ((TextView)paramView.findViewById(2131298662));
    this.DAX = ((TextView)paramView.findViewById(2131298595));
    this.DAS = ((TextView)paramView.findViewById(2131298607));
    this.DAT = ((TextView)paramView.findViewById(2131298632));
    this.DAV = ((Button)paramView.findViewById(2131298637));
    this.DAW = ((Button)paramView.findViewById(2131298645));
    this.DBr = ((ProfileMobilePhoneView)paramView.findViewById(2131302365));
    Object localObject = this.DBr;
    az.ayM();
    ((ProfileMobilePhoneView)localObject).DoB = ((Boolean)c.agA().get(ah.a.GGA, Boolean.FALSE)).booleanValue();
    this.DBs = ((ProfileDescribeView)paramView.findViewById(2131299003));
    this.DBt = ((ProfileLabelView)paramView.findViewById(2131301284));
    this.DBu = ((TextView)paramView.findViewById(2131304604));
    this.DBs.setOnClickListener(this.DBv);
    this.DBt.setOnClickListener(this.DBv);
    this.DBu.setOnClickListener(this.DBv);
    if ((u.wh(this.contact.field_username)) || ((!bs.isNullOrNil(this.contact.field_username)) && (w.xj(this.contact.field_username))))
    {
      this.DBu.setVisibility(8);
      this.DBr.setVisibility(8);
      this.DBs.setVisibility(8);
      this.DBt.setVisibility(8);
      this.BJM = ((TextView)paramView.findViewById(2131298618));
      this.DBd = ((Button)paramView.findViewById(2131298612));
      this.DBe = ((FMessageListView)paramView.findViewById(2131298613));
      localObject = new a.a();
      ((a.a)localObject).talker = this.contact.field_username;
      ((a.a)localObject).scene = this.xAq;
      ((a.a)localObject).sBi = this.sBi;
      ((a.a)localObject).DAE = this.contact.eym;
      ((a.a)localObject).type = 0;
      if (this.xAq != 18) {
        break label877;
      }
      ((a.a)localObject).type = 1;
      label424:
      this.DBe.setFMessageArgs((a.a)localObject);
      this.DAU = paramView.findViewById(2131304845);
      this.DBc = ((LinearLayout)paramView.findViewById(2131300699));
      this.vIC = ((ImageView)paramView.findViewById(2131298597));
      this.xzW = ((ImageView)paramView.findViewById(2131298642));
      this.DAY = ((ImageView)paramView.findViewById(2131298669));
      this.DAZ = ((CheckBox)paramView.findViewById(2131298646));
      this.DBa = ((ImageView)paramView.findViewById(2131298644));
      this.DBb = ((ImageView)paramView.findViewById(2131298643));
      this.DBg = ((ImageView)paramView.findViewById(2131298659));
      this.DBf = ((RelativeLayout)paramView.findViewById(2131298660));
      this.pDN = true;
      initView();
      if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {
        break label896;
      }
      ac.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
      this.DBe.setVisibility(8);
      if ((this.DBe.getVisibility() == 8) && (this.DBu.getVisibility() == 8) && (this.DBt.getVisibility() == 8) && (this.DBs.getVisibility() == 8) && (this.BJM.getVisibility() == 8)) {
        this.DAU.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(31872);
      return;
      this.DBr.piT = this.contact;
      this.DBr.kW(this.Dop, this.Doq);
      if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {
        this.DBr.setVisibility(8);
      }
      for (;;)
      {
        boolean bool1 = this.DBs.aa(this.contact);
        boolean bool2 = this.DBt.aa(this.contact);
        if ((!bool1) && (!bool2)) {
          break label798;
        }
        this.DBu.setVisibility(8);
        break;
        this.DBr.setVisibility(0);
      }
      label798:
      if ((this.DBo) || (this.DBm)) {
        this.DBu.setVisibility(8);
      }
      for (;;)
      {
        if ((this.DBw == null) || ((!this.DBw.equals("ContactWidgetBottleContact")) && (!this.DBw.equals("ContactWidgetQContact")))) {
          break label875;
        }
        this.DBu.setVisibility(8);
        break;
        this.DBu.setVisibility(0);
      }
      label875:
      break;
      label877:
      if (!bi.nX(this.xAq)) {
        break label424;
      }
      ((a.a)localObject).type = 2;
      break label424;
      label896:
      if ((this.sBi != null) && (this.sBi.length() != 0)) {
        break label1033;
      }
      ac.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.xAq + ", verifyTicket = " + this.sBi);
      this.DBe.setVisibility(8);
      if ((this.DBe.getVisibility() == 8) && (this.DBu.getVisibility() == 8) && (this.DBt.getVisibility() == 8) && (this.DBs.getVisibility() == 8) && (this.BJM.getVisibility() == 8)) {
        this.DAU.setVisibility(8);
      }
    }
    label1033:
    ac.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.xAq);
    if (this.xAq == 18)
    {
      ac.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
      localObject = com.tencent.mm.bj.d.aJf().aOh(this.contact.field_username);
      localObject = b.a(this.iMV, (dl[])localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.length != 0)) {
        break label1290;
      }
      ac.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
      this.DBe.setVisibility(8);
      if ((this.DBe.getVisibility() != 8) || (this.DBu.getVisibility() != 8) || (this.DBt.getVisibility() != 8) || (this.DBs.getVisibility() != 8) || (this.BJM.getVisibility() != 8)) {
        break;
      }
      this.DAU.setVisibility(8);
      break;
      if (bi.nX(this.xAq))
      {
        ac.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
        localObject = com.tencent.mm.bj.d.aJg().aOG(this.contact.field_username);
        localObject = b.a(this.iMV, (bx[])localObject);
      }
      else
      {
        ac.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
        localObject = com.tencent.mm.bj.d.aJd().aOe(this.contact.field_username);
        localObject = b.a(this.iMV, (bd[])localObject);
      }
    }
    label1290:
    ac.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + localObject.length);
    int j = localObject.length;
    int i = 0;
    b localb;
    while (i < j)
    {
      localb = localObject[i];
      if (localb != null) {
        ac.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + localb.username + ", nickname = " + localb.nickname + ", digest = " + localb.hlf + ", addScene = " + localb.xAq);
      }
      i += 1;
    }
    if (com.tencent.mm.storage.ai.aNc(this.contact.field_username))
    {
      this.DBe.setVisibility(8);
      this.DBe.setHide(true);
    }
    for (;;)
    {
      if ((this.DBe.getVisibility() == 0) || (this.DBu.getVisibility() == 0) || (this.DBt.getVisibility() == 0) || (this.DBs.getVisibility() == 0) || (this.BJM.getVisibility() == 0)) {
        this.DAU.setVisibility(0);
      }
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localb = localObject[i];
        this.DBe.a(localb);
        i += 1;
      }
      break;
      this.DBe.setVisibility(0);
      this.DBe.setHide(false);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31871);
    if (this.DBe != null) {
      this.DBe.detach();
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(31871);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(31883);
    if (this.DBe != null) {
      this.DBe.detach();
    }
    if (this.DBp) {
      com.tencent.mm.bj.d.aJe().aOc(this.contact.field_username);
    }
    this.iMV.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.DBm);
    this.iMV.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.DBn);
    az.ayM();
    c.awB().b(this);
    p.aBh().e(this);
    az.ayM();
    c.awC().b(this);
    AppMethodBeat.o(31883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */