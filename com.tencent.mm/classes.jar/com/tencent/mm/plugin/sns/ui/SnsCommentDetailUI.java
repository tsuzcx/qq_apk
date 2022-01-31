package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class SnsCommentDetailUI
  extends MMActivity
  implements com.tencent.mm.ai.f, h.a, b.b
{
  public static int rOR = 34;
  private String cAd;
  private String czw;
  private String dZZ;
  private com.tencent.mm.sdk.b.c hCe;
  private boolean hQE;
  private int jKp;
  private View.OnClickListener jVW;
  private com.tencent.mm.ui.widget.c.a jVd;
  private int kwo;
  private ClipboardManager mAZ;
  private int mScreenHeight;
  private int mScreenWidth;
  private View.OnClickListener nyO;
  private com.tencent.mm.sdk.b.c rFB;
  private boolean rFm;
  private SnsCommentFooter rFo;
  private an rFq;
  private b rFw;
  private com.tencent.mm.plugin.sns.g.b rFx;
  private com.tencent.mm.ui.base.p rFz;
  private View.OnTouchListener rGO;
  LinearLayout rOA;
  LinearLayout rOB;
  private LinkedList<cds> rOC;
  private int rOD;
  private boolean rOE;
  private aq rOF;
  private String rOG;
  private com.tencent.mm.storage.bd rOH;
  private int rOI;
  private ImageView rOJ;
  private j rOK;
  private boolean rOL;
  private long rOM;
  private bd rON;
  private boolean rOO;
  private int rOP;
  private int rOQ;
  public int rOS;
  private com.tencent.mm.plugin.sns.ui.c.a.a rOT;
  private com.tencent.mm.plugin.sns.a.b.g rOU;
  private com.tencent.mm.plugin.sns.ui.d.b rOV;
  private SnsTranslateResultView rOW;
  private boolean rOX;
  private Dialog rOY;
  private boolean rOZ;
  private long rOo;
  private long rOp;
  private View rOq;
  private TextView rOr;
  private LinearLayout rOs;
  private SnsDetailLuckyHeader rOt;
  private ListView rOu;
  private View rOv;
  private View rOw;
  private SnsCommentDetailUI.b rOx;
  private ScaleAnimation rOy;
  private ScaleAnimation rOz;
  private boolean rPa;
  private String rPb;
  private boolean rPc;
  private int rPd;
  private ah rPe;
  private com.tencent.mm.sdk.b.c rPf;
  private com.tencent.mm.sdk.b.c rPg;
  private com.tencent.mm.sdk.b.c rPh;
  private com.tencent.mm.sdk.b.c rPi;
  private SnsCommentDetailUI.c rPj;
  private View.OnClickListener rPk;
  private com.tencent.mm.sdk.b.c rPl;
  private com.tencent.mm.sdk.b.c rPm;
  boolean rPn;
  private LinearLayout rPo;
  private boolean rPp;
  PhotosContent rPq;
  int rPr;
  public ao.b.a rPs;
  private bc rPt;
  private LinearLayout rcD;
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(38834);
    this.rOo = 0L;
    this.rOp = 0L;
    this.rOD = -1;
    this.rOE = false;
    this.rGO = bo.dtW();
    this.rFz = null;
    this.jKp = 0;
    this.rOI = 0;
    this.hQE = false;
    this.cAd = "";
    this.rOL = false;
    this.rOM = 0L;
    this.rOO = false;
    this.rOQ = 103;
    this.rOS = 210;
    this.rOX = false;
    this.rOY = null;
    this.rOZ = false;
    this.rPa = false;
    this.rPb = "";
    this.rPc = true;
    this.rPe = new ah();
    this.rPf = new SnsCommentDetailUI.1(this);
    this.rPg = new SnsCommentDetailUI.12(this);
    this.rPh = new SnsCommentDetailUI.23(this);
    this.rPi = new SnsCommentDetailUI.34(this);
    this.rFB = new SnsCommentDetailUI.36(this);
    this.rPj = new SnsCommentDetailUI.c(this);
    this.jVW = new SnsCommentDetailUI.37(this);
    this.rPk = new SnsCommentDetailUI.38(this);
    this.nyO = new SnsCommentDetailUI.2(this);
    this.rPl = new SnsCommentDetailUI.6(this);
    this.hCe = new SnsCommentDetailUI.7(this);
    this.rPm = new SnsCommentDetailUI.8(this);
    this.rPn = false;
    this.rPo = null;
    this.rPp = false;
    this.rPq = null;
    this.rPr = 0;
    this.rPs = new SnsCommentDetailUI.19(this);
    this.rPt = null;
    AppMethodBeat.o(38834);
  }
  
  private LinearLayout EM(int paramInt)
  {
    AppMethodBeat.i(38845);
    if (this.rPo == null)
    {
      this.rPo = ((LinearLayout)w.hM(this).inflate(paramInt, null));
      localLinearLayout = this.rPo;
      AppMethodBeat.o(38845);
      return localLinearLayout;
    }
    this.rPn = true;
    LinearLayout localLinearLayout = this.rPo;
    AppMethodBeat.o(38845);
    return localLinearLayout;
  }
  
  private int cuU()
  {
    AppMethodBeat.i(38844);
    if ((this.rOu != null) && (this.rOu.getChildCount() > 1))
    {
      View localView = this.rOu.getChildAt(0);
      if (localView != null)
      {
        int i = localView.getHeight();
        AppMethodBeat.o(38844);
        return i;
      }
    }
    AppMethodBeat.o(38844);
    return 0;
  }
  
  private static boolean cuV()
  {
    AppMethodBeat.i(38846);
    if ((an.a.cpE() & 0x1) <= 0)
    {
      AppMethodBeat.o(38846);
      return true;
    }
    AppMethodBeat.o(38846);
    return false;
  }
  
  private void cuX()
  {
    AppMethodBeat.i(38848);
    if ((this.rOv == null) || (this.rOv.getVisibility() == 8))
    {
      AppMethodBeat.o(38848);
      return;
    }
    this.rOv.startAnimation(this.rOz);
    this.rOz.setAnimationListener(new SnsCommentDetailUI.33(this));
    AppMethodBeat.o(38848);
  }
  
  private void cuY()
  {
    AppMethodBeat.i(38849);
    if ((keyboardState() == 1) || (this.rFo.cvd()))
    {
      this.rPj.run();
      AppMethodBeat.o(38849);
      return;
    }
    this.rFm = true;
    AppMethodBeat.o(38849);
  }
  
  private void cuZ()
  {
    AppMethodBeat.i(38850);
    if (this.rOJ == null)
    {
      AppMethodBeat.o(38850);
      return;
    }
    this.rOJ.setPressed(false);
    if (bd.YC(this.cAd))
    {
      this.rOJ.setImageResource(2130839751);
      AppMethodBeat.o(38850);
      return;
    }
    this.rOJ.setImageResource(2130839753);
    AppMethodBeat.o(38850);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(n paramn)
  {
    AppMethodBeat.i(38838);
    if (paramn != null)
    {
      if (getSource() == 2)
      {
        paramn = paramn.cse();
        AppMethodBeat.o(38838);
        return paramn;
      }
      paramn = paramn.csd();
      AppMethodBeat.o(38838);
      return paramn;
    }
    AppMethodBeat.o(38838);
    return null;
  }
  
  private static boolean f(LinkedList<cds> paramLinkedList1, LinkedList<cds> paramLinkedList2)
  {
    AppMethodBeat.i(38835);
    if ((paramLinkedList1 == null) || (paramLinkedList2 == null))
    {
      AppMethodBeat.o(38835);
      return false;
    }
    if (paramLinkedList1.size() != paramLinkedList2.size())
    {
      AppMethodBeat.o(38835);
      return false;
    }
    int j = paramLinkedList1.size();
    int i = 0;
    while (i < j)
    {
      if (!((cds)paramLinkedList1.get(i)).Username.equals(((cds)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(38835);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(38835);
    return true;
  }
  
  private boolean g(List<cds> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(38851);
    int k = BackwardSupportUtil.b.b(this, 32.0F);
    int m = BackwardSupportUtil.b.b(this, 6.0F);
    int i = BackwardSupportUtil.b.b(this, 10.0F);
    int j = BackwardSupportUtil.b.b(this, 17.0F);
    if (this.rOs == null)
    {
      AppMethodBeat.o(38851);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(2131427808);
    ab.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.rOs.getParent() != null) {
        this.rOs.setVisibility(8);
      }
      this.rOs.removeAllViews();
      this.rOs.setVisibility(8);
      this.rcD.setVisibility(8);
      AppMethodBeat.o(38851);
      return false;
    }
    this.rOs.getParent();
    this.rOs.removeAllViews();
    this.rOs.setVisibility(0);
    Object localObject1;
    if (this.kwo == 10) {
      if (!this.rOX)
      {
        this.rOs.setBackgroundResource(2130838908);
        this.rOs.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        if (this.kwo != 10) {
          break label692;
        }
        ((ImageView)localObject1).setImageResource(2131231366);
      }
    }
    for (;;)
    {
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.rOs.addView((View)localObject1);
      n = com.tencent.mm.cb.a.fromDPToPix(getContext(), rOR);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      ab.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setClipChildren(false);
      ((h)localObject1).setClipToPadding(false);
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = (cds)paramList.get(i);
        StoryTouchImageView localStoryTouchImageView = new StoryTouchImageView(getContext());
        localStoryTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localStoryTouchImageView.setImageResource(2130838917);
        Object localObject3 = ((cds)localObject2).Username;
        localStoryTouchImageView.sci.dw((String)localObject3, 1);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, m, m, 0);
        localStoryTouchImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localStoryTouchImageView.setTag(((cds)localObject2).Username);
        a.b.u(localStoryTouchImageView, ((cds)localObject2).Username);
        localStoryTouchImageView.setOnClickListener(this.jVW);
        ((h)localObject1).addView(localStoryTouchImageView);
        i += 1;
      }
      localObject1 = lB(false);
      if (localObject1 != null)
      {
        if (this.dZZ.equals(((n)localObject1).field_userName))
        {
          this.rOs.setBackgroundResource(2130838909);
          break;
        }
        this.rOs.setBackgroundResource(2130838908);
        break;
      }
      this.rOs.setBackgroundResource(2130838908);
      break;
      this.rOs.setBackgroundResource(2130838906);
      break;
      label692:
      ((ImageView)localObject1).setImageResource(2131231365);
    }
    this.rOs.addView((View)localObject1);
    paramList = this.rcD;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(38851);
      return true;
    }
  }
  
  private int getSource()
  {
    if (this.rPd == 16) {
      return 2;
    }
    return 1;
  }
  
  private void lA(boolean paramBoolean)
  {
    AppMethodBeat.i(38836);
    this.rOE = false;
    if (this.rFo.cvc())
    {
      this.rFo.rQa = 0;
      this.rFo.cvf();
      this.rFo.setCommentHint(getString(2131304029));
    }
    this.rFo.lC(false);
    if (paramBoolean) {
      BackwardSupportUtil.c.a(this.rOu);
    }
    AppMethodBeat.o(38836);
  }
  
  private n lB(boolean paramBoolean)
  {
    AppMethodBeat.i(38837);
    n localn;
    if (!bo.isNullOrNil(this.rOG))
    {
      localn = com.tencent.mm.plugin.sns.storage.h.abv(this.rOG);
      if (localn == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, 2131303904, 0).show();
        }
        finish();
        AppMethodBeat.o(38837);
        return null;
      }
      this.czw = localn.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(38837);
      return localn;
      localn = com.tencent.mm.plugin.sns.storage.h.abu(this.czw);
      if (localn == null)
      {
        finish();
        AppMethodBeat.o(38837);
        return null;
      }
      this.rOG = localn.csH();
    }
  }
  
  public final void ZU(String paramString) {}
  
  public final void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong, String paramString2) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong, String paramString2) {}
  
  public final void bp(String paramString, boolean paramBoolean) {}
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
  
  final boolean cuW()
  {
    AppMethodBeat.i(38847);
    n localn = lB(true);
    if (localn == null)
    {
      AppMethodBeat.o(38847);
      return false;
    }
    ab.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.rOq.toString());
    this.rOP = ag.cpn();
    Object localObject5 = localn.csh();
    this.kwo = av.b(localn, false);
    Object localObject1 = (SnsAvatarImageView)this.rOq.findViewById(2131827936);
    Object localObject2;
    boolean bool;
    if ((localObject1 == null) || (localn == null))
    {
      localObject2 = new StringBuilder("unknow error ? ");
      if (localObject1 == null)
      {
        bool = true;
        localObject1 = ((StringBuilder)localObject2).append(bool).append(" ");
        if (localn != null) {
          break label177;
        }
      }
      label177:
      for (bool = true;; bool = false)
      {
        ab.e("MicroMsg.SnsCommentDetailUI", bool);
        AppMethodBeat.o(38847);
        return false;
        bool = false;
        break;
      }
    }
    ((SnsAvatarImageView)localObject1).setWeakContext(this);
    ((MaskImageButton)localObject1).eQq = localn.csH();
    ((SnsAvatarImageView)localObject1).setTag(localn.getUserName());
    Object localObject6;
    label456:
    Object localObject3;
    if ((localn.csb() != null) && (localn.csb().rqL))
    {
      if (!bo.isNullOrNil(localn.csb().rqN))
      {
        ((SnsAvatarImageView)localObject1).setTag(2131820667, localn.csb().rqN);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localn.csb().rqN, new SnsCommentDetailUI.20(this, (SnsAvatarImageView)localObject1));
      }
      ((SnsAvatarImageView)localObject1).setOnClickListener(this.rOV.sjs);
      localObject2 = (TextView)this.rOq.findViewById(2131823254);
      com.tencent.mm.kernel.g.RM();
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(localn.getUserName());
      ab.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localn.getUserName() + " " + localn.getSnsId() + " " + localn.csA());
      if ((localObject6 != null) && (((ad)localObject6).Od() == 0))
      {
        ab.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localn.getUserName() });
        ao.a.aaj().a(localn.getUserName(), "", this.rPs);
      }
      if (localObject6 != null) {
        break label1211;
      }
      localObject1 = localn.getUserName();
      localObject3 = bo.bf((String)localObject1, "");
      if (!localn.pi()) {
        break label8908;
      }
      localObject1 = localn.csb();
      if (localObject1 == null) {
        break label8908;
      }
      if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).rqL) {
        break label1221;
      }
      localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqM;
    }
    label518:
    label827:
    label1221:
    label8391:
    label8905:
    label8908:
    for (;;)
    {
      label500:
      ((String)localObject3).length();
      label731:
      int k;
      if (this.kwo == 10)
      {
        i = 3;
        localObject1 = new k(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject3));
        ((k)localObject1).a(new o(new com.tencent.mm.plugin.sns.data.a(localn.pi(), ((ad)localObject6).getUsername(), localn.csH(), 2), this.rOK, i), (CharSequence)localObject3);
        ((TextView)localObject2).setOnTouchListener(new aa());
        ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        ((TextView)this.rOq.findViewById(2131827939)).setText("");
        this.rPt = new bc(this.rOq);
        if (!localn.pi()) {
          break label1256;
        }
        this.rPt.w(Long.valueOf(localn.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.rPt, 0, this.rOG, localn.field_snsId, f(localn).hpq));
        this.rPt.a(localn.csb(), f(localn));
        this.rPt.a(this.rOV.sjC, this.rOV.sjQ);
        this.rPt.setVisibility(0);
        localObject1 = ((TimeLineObject)localObject5).xTP;
        this.rOr = ((TextView)this.rOq.findViewById(2131821007));
        localObject2 = new as(this.czw, localn.csH(), true, false, 2);
        this.rOr.setTag(localObject2);
        this.jVd.c(this.rOr, this.rOV.sju, this.rOV.sjr);
        if (!bo.isNullOrNil((String)localObject1)) {
          break label1268;
        }
        this.rOr.setVisibility(8);
        localObject1 = (ViewStub)this.rOq.findViewById(2131827945);
        if (!this.rPp) {
          ((ViewStub)localObject1).setLayoutResource(-1);
        }
        switch (this.kwo)
        {
        case 6: 
        case 7: 
        case 8: 
        case 12: 
        default: 
          ((ViewStub)localObject1).setVisibility(8);
          if (((ViewStub)localObject1).getLayoutResource() != -1)
          {
            localObject2 = ((ViewStub)localObject1).inflate();
            if (this.rOT != null) {
              this.rOT.g((View)localObject2, this.rOw);
            }
            this.rPp = true;
            label976:
            k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
            if (this.kwo == 6) {
              break label1951;
            }
            if ((this.kwo != 2) && (this.kwo != 3) && (this.kwo != 4) && (this.kwo != 5)) {
              break label3481;
            }
            this.rPq = ((PhotosContent)findViewById(2131828130));
            if (this.rPq == null) {
              break label3438;
            }
            this.rPq.cuo();
            if (this.kwo != 2) {
              break label1524;
            }
          }
          break;
        }
      }
      int j;
      label1256:
      label1268:
      label1524:
      for (int i = 1;; i = aq.rTg[this.kwo])
      {
        j = 0;
        while (j < i)
        {
          localObject1 = (TagImageView)this.rPq.findViewById(aq.rTk[j]);
          this.rPq.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.rOV.rHw);
          this.jVd.c((View)localObject1, this.rOV.sjF, this.rOV.sjr);
          j += 1;
        }
        if (localn.getUserName().endsWith("@ad")) {
          break;
        }
        a.b.u((ImageView)localObject1, localn.getUserName());
        ((SnsAvatarImageView)localObject1).dw(localn.getUserName(), 2);
        bo.isEqual(this.dZZ, localn.getUserName());
        break;
        localObject1 = ((ad)localObject6).Of();
        break label456;
        if ((!bo.isNullOrNil((String)localObject3)) || (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject1).nickname))) {
          break label8908;
        }
        localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).nickname;
        break label500;
        i = 2;
        break label518;
        this.rPt.setVisibility(8);
        break label731;
        this.rOr.setText((String)localObject1 + " ");
        com.tencent.mm.pluginsdk.ui.d.j.k(this.rOr, 2);
        this.rOr.setVisibility(0);
        break label827;
        ((ViewStub)localObject1).setLayoutResource(2130970885);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970882);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970883);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970884);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970842);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970827);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970772);
        this.rOT = new com.tencent.mm.plugin.sns.ui.c.a.b((TimeLineObject)localObject5, localn, this.rOV, this.rOU);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970888);
        this.rOT = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject5, localn, this.rOV, this.rOU);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970877);
        this.rOT = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject5, localn, this.rOV, this.rOU);
        break label935;
        ((ViewStub)localObject1).setLayoutResource(2130970878);
        this.rOT = new d((TimeLineObject)localObject5, localn, this.rOV);
        break label935;
        ((ViewStub)localObject1).setVisibility(8);
        break label976;
      }
      this.rPq.setImageViewWidth(this.rOP);
      localObject1 = new LinkedList();
      float f2;
      float f1;
      float f3;
      Object localObject4;
      Object localObject7;
      if ((localn.pi()) && (this.kwo == 2))
      {
        localObject2 = localn.csb();
        this.rPq.EJ(0).setScaleType(QImageView.a.AED);
        if ((localObject2 != null) && (!((com.tencent.mm.plugin.sns.storage.b)localObject2).cqp()) && (((com.tencent.mm.plugin.sns.storage.b)localObject2).rqr > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject2).rqs > 0.0F))
        {
          f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).rqr, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqu);
          f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).rqs, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqu);
          if (((com.tencent.mm.plugin.sns.storage.b)localObject2).rqq != 0) {
            break label3152;
          }
          f3 = f1;
          f1 = f2;
          if (f2 >= k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808))
          {
            f1 = k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808);
            f3 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject2).rqs * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqr);
          }
          localObject4 = new bcu();
          ((bcu)localObject4).xsH = f1;
          ((bcu)localObject4).xsI = f3;
          ((bcu)localObject4).xsJ = (((bcu)localObject4).xsH * ((bcu)localObject4).xsI);
          ((LinkedList)localObject1).add(localObject4);
        }
        if (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject2).rqw))
        {
          localObject4 = this.rPq;
          localObject7 = this.rPq.EJ(0);
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqw, false, 41, new SnsCommentDetailUI.21(this, (PhotosContent)localObject4, (com.tencent.mm.plugin.sns.storage.b)localObject2, (TagImageView)localObject7));
        }
      }
      this.rOq.addOnAttachStateChangeListener(new SnsCommentDetailUI.22(this, (TimeLineObject)localObject5, localn, (LinkedList)localObject1));
      this.rOF.a(this.rPq, (TimeLineObject)localObject5, localn.csH(), hashCode(), this.kwo, -1, localn.Ex(32), false, az.yNT, (List)localObject1, localn.getSnsId());
      for (;;)
      {
        localObject4 = (TextView)this.rOq.findViewById(2131827946);
        if (!localn.pi()) {
          break label7697;
        }
        localObject2 = f(localn);
        if (localObject2 == null) {
          break label7687;
        }
        localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject2).rpn;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject2).rpo;
        ((TextView)localObject4).setTag(localn.csH());
        if (bo.isNullOrNil((String)localObject1)) {
          break label7687;
        }
        if (!bo.isNullOrNil((String)localObject2)) {
          break label7649;
        }
        ((TextView)localObject4).setVisibility(0);
        label2033:
        ((TextView)localObject4).setText((CharSequence)localObject1);
        ((TextView)localObject4).setClickable(false);
        ((TextView)localObject4).setTextColor(-9211021);
        this.rOq.post(new SnsCommentDetailUI.26(this));
        ((TextView)localObject4).setOnClickListener(this.rOV.sjN);
        ((TextView)this.rOq.findViewById(2131827948)).setText(ax.m(getContext(), localn.csA() * 1000L));
        localObject4 = (AsyncTextView)this.rOq.findViewById(2131827949);
        ((TextView)localObject4).setOnClickListener(this.rOV.sjR);
        ((TextView)localObject4).setVisibility(8);
        localObject7 = (AsyncTextView)this.rOq.findViewById(2131827950);
        ((TextView)localObject7).setOnClickListener(new SnsCommentDetailUI.27(this, localn, (ad)localObject6));
        ((TextView)localObject7).setVisibility(8);
        if (localn.pi())
        {
          localObject6 = f(localn);
          ((TextView)localObject4).setTag(localn.csH());
          if (((com.tencent.mm.plugin.sns.storage.a)localObject6).rpp != com.tencent.mm.plugin.sns.storage.a.rpb) {
            break label7905;
          }
          if (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject6).rpq)) {
            break label7895;
          }
          ((TextView)localObject4).setText(((com.tencent.mm.plugin.sns.storage.a)localObject6).rpq);
          ((TextView)localObject4).setVisibility(0);
          label2264:
          break label8192;
          label2265:
          if ((((TextView)localObject4).getVisibility() != 8) && (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject6).rpr)))
          {
            ((TextView)localObject4).setTextColor(getResources().getColor(2131690516));
            ((TextView)localObject4).setOnClickListener(null);
          }
          if ((localn.csh().xTS.wOb & 0x4) == 0) {
            break label8361;
          }
          ((TextView)localObject7).setTag(localn.csH());
          ((TextView)localObject7).setVisibility(0);
          ((TextView)localObject7).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(2131303742), localObject3, getContext().getResources().getString(2131303743) }));
        }
        label2391:
        localObject2 = (TextView)this.rOq.findViewById(2131827952);
        ((TextView)localObject2).setOnTouchListener(new aa());
        localObject1 = com.tencent.mm.plugin.sns.c.a.gmP.t(this, ((TimeLineObject)localObject5).xTR.Id);
        if (((TimeLineObject)localObject5).xTS.wNZ == 26) {
          localObject1 = getString(2131299680);
        }
        av.a((TimeLineObject)localObject5, this);
        if (!com.tencent.mm.plugin.sns.c.a.gmP.dF((String)localObject1)) {
          break label8371;
        }
        ((TextView)localObject2).setVisibility(0);
        localObject1 = new SpannableString(getString(2131303788) + (String)localObject1);
        ((SpannableString)localObject1).setSpan(new SnsCommentDetailUI.a(this), 0, ((SpannableString)localObject1).length(), 33);
        ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((((TimeLineObject)localObject5).xTR == null) || (!com.tencent.mm.pluginsdk.model.app.g.alp(((TimeLineObject)localObject5).xTR.Id)))
        {
          ((TextView)localObject2).setTextColor(getResources().getColor(2131690516));
          ((TextView)localObject2).setOnTouchListener(null);
        }
        ((TextView)localObject2).setTag(localObject5);
        localObject1 = (TextView)this.rOq.findViewById(2131827954);
        if (!localn.getUserName().equals(this.dZZ)) {
          break label8381;
        }
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setTag(localn.csH() + ";" + localn.getSnsId());
        ((TextView)localObject1).setOnClickListener(new SnsCommentDetailUI.28(this));
        label2686:
        localObject3 = (TextView)this.rOq.findViewById(2131827947);
        localObject4 = com.tencent.mm.plugin.sns.model.ak.p(localn);
        if (localObject4 != null) {
          break label8391;
        }
        ((TextView)localObject3).setVisibility(8);
        this.rOy = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
        this.rOy.setDuration(150L);
        this.rOz = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
        this.rOz.setDuration(150L);
        if (this.rOv == null)
        {
          this.rOv = this.rOq.findViewById(2131821045);
          this.rOv.setVisibility(8);
        }
        this.rOA = ((LinearLayout)this.rOq.findViewById(2131827955));
        this.rOA.setOnClickListener(new SnsCommentDetailUI.30(this, localn));
        this.rOA.setOnTouchListener(this.rGO);
        this.rOB = ((LinearLayout)this.rOq.findViewById(2131827922));
        this.rOB.setOnClickListener(new SnsCommentDetailUI.31(this, localn));
        this.rOB.setOnTouchListener(this.rGO);
        localObject1 = (ImageButton)this.rOq.findViewById(2131827937);
        localObject2 = lB(true);
        if ((localObject2 != null) && ((((n)localObject2).csC() & 0x1) != 0)) {
          ((ImageButton)localObject1).setVisibility(8);
        }
        if ((localObject2 != null) && (!((n)localObject2).csG())) {
          ((ImageButton)localObject1).setVisibility(8);
        }
        localObject2 = (ImageView)this.rOB.findViewById(2131827923);
        localObject3 = (ImageView)this.rOA.findViewById(2131827926);
        localObject4 = (TextView)this.rOB.findViewById(2131827924);
        localObject5 = (TextView)this.rOA.findViewById(2131827925);
        if (this.kwo == 10)
        {
          this.rOq.findViewById(2131821045).setBackgroundResource(2130838910);
          ((ImageButton)localObject1).setImageResource(2130839331);
          ((ImageView)localObject2).setImageResource(2130839332);
          ((ImageView)localObject3).setImageResource(2130839333);
          ((TextView)localObject4).setTextColor(getResources().getColor(2131690495));
          ((TextView)localObject5).setTextColor(getResources().getColor(2131690495));
          this.rOB.setBackgroundResource(2130839541);
          this.rOA.setBackgroundResource(2130839542);
        }
        ((ImageButton)localObject1).setOnClickListener(new SnsCommentDetailUI.32(this, localn, (TextView)localObject4, (TextView)localObject5, (ImageView)localObject2, (ImageView)localObject3));
        AppMethodBeat.o(38847);
        return true;
        label3152:
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).rqq == 1)
        {
          i = k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808);
          j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqr);
          localObject4 = new bcu();
          if (i > 0) {
            f2 = i;
          }
          ((bcu)localObject4).xsH = f2;
          if (j > 0) {
            f1 = j;
          }
          ((bcu)localObject4).xsI = f1;
          ((bcu)localObject4).xsJ = (((bcu)localObject4).xsH * ((bcu)localObject4).xsI);
          ((LinkedList)localObject1).add(localObject4);
          break;
        }
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).rqq != 2) {
          break;
        }
        i = k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqr);
        localObject4 = new bcu();
        if (i > 0) {
          f2 = i;
        }
        ((bcu)localObject4).xsH = f2;
        if (j > 0) {
          f1 = j;
        }
        ((bcu)localObject4).xsI = f1;
        ((bcu)localObject4).xsJ = (((bcu)localObject4).xsH * ((bcu)localObject4).xsI);
        ((LinkedList)localObject1).add(localObject4);
        break;
        label3438:
        ab.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.kwo + ",stub is " + ((ViewStub)localObject1).toString());
        continue;
        if (this.kwo != 10) {
          break label3938;
        }
        this.rPq = ((PhotosContent)findViewById(2131827993));
        this.rPq.cuo();
        localObject1 = (TagImageView)this.rPq.findViewById(2131827994);
        this.rPq.a((TagImageView)localObject1);
        ((TagImageView)localObject1).setOnClickListener(this.rOV.rHw);
        localObject2 = localn.csH();
        localObject4 = new ArrayList();
        ((List)localObject4).add(localObject1);
        localObject7 = new ao();
        ((ao)localObject7).ctV = ((String)localObject2);
        ((ao)localObject7).index = 0;
        ((ao)localObject7).rQS = ((List)localObject4);
        ((ao)localObject7).rNW = true;
        if (localObject1 != null) {
          ((TagImageView)localObject1).setTag(localObject7);
        }
        localObject1 = (TextView)this.rOq.findViewById(2131827953);
        if (!r.Zn().equals(((TimeLineObject)localObject5).jJA))
        {
          localObject2 = com.tencent.mm.plugin.sns.model.ak.q(localn);
          if ((((SnsObject)localObject2).SnsRedEnvelops != null) && (((SnsObject)localObject2).SnsRedEnvelops.xPd != 0))
          {
            ((TextView)localObject1).setText(getString(2131301341, new Object[] { Integer.valueOf(((SnsObject)localObject2).SnsRedEnvelops.xPd) }));
            ((TextView)localObject1).setVisibility(0);
          }
        }
        for (;;)
        {
          localObject1 = localn.csz();
          if (localObject1 == null) {
            break label3908;
          }
          if (!r.Zn().equals(((TimeLineObject)localObject5).jJA)) {
            break label3792;
          }
          this.rOF.a(this.rPq, (TimeLineObject)localObject5, localn.csH(), hashCode(), this.kwo, -1, false, az.yNT, true);
          break;
          ((TextView)localObject1).setVisibility(8);
          continue;
          ((TextView)localObject1).setVisibility(8);
        }
        label3792:
        if (com.tencent.mm.plugin.sns.lucky.a.m.k(localn))
        {
          this.rOF.a(this.rPq, (TimeLineObject)localObject5, localn.csH(), hashCode(), this.kwo, -1, false, az.yNT, false);
        }
        else if (((bct)localObject1).cMQ == 0)
        {
          this.rOF.a(this.rPq, (TimeLineObject)localObject5, localn.csH(), hashCode(), this.kwo, -1, false, az.yNT, true);
        }
        else
        {
          ab.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((bct)localObject1).cMQ);
          continue;
          ab.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localn.csH());
        }
      }
      label3938:
      Object localObject8;
      label4174:
      Object localObject9;
      if (this.kwo == 9)
      {
        this.rOZ = true;
        localObject2 = new aj();
        localObject8 = this.rOq;
        localObject4 = ((View)localObject8).findViewById(2131822580);
        localObject7 = (com.tencent.mm.plugin.sight.decode.a.a)((View)localObject8).findViewById(2131820629);
        ((aj)localObject2).rLD = ((View)localObject8);
        ((aj)localObject2).rLE = ((View)localObject4);
        ((aj)localObject2).rwJ = ((ImageView)((View)localObject8).findViewById(2131820996));
        ((aj)localObject2).rLF = ((MMPinProgressBtn)((View)localObject8).findViewById(2131821404));
        ((aj)localObject2).rwK = ((TextView)((View)localObject8).findViewById(2131827796));
        ((aj)localObject2).rLG = ((TextView)((View)localObject8).findViewById(2131827795));
        ((aj)localObject2).qVe = ((com.tencent.mm.plugin.sight.decode.a.a)localObject7);
        ((aj)localObject2).a((TimeLineObject)localObject5, 0, localn.csH(), localn.pi());
        ((aj)localObject2).rwK.setVisibility(8);
        ((aj)localObject2).qVe.setTagObject(localObject2);
        ((aj)localObject2).rLH = 5;
        ((View)localObject4).setTag(localObject2);
        ((aj)localObject2).rLE.setOnClickListener(this.rOV.sjO);
        if (!localn.cqp())
        {
          this.jVd.c((View)localObject4, this.rOV.sjH, this.rOV.sjr);
          localObject1 = com.tencent.mm.modelsns.e.a((TimeLineObject)localObject5, ((aj)localObject2).qVe.getUIContext(), localn.pi());
          if (!localn.pi()) {
            break label8905;
          }
          localObject9 = localn.csb();
          if ((localObject9 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject9).cqp()) || (((com.tencent.mm.plugin.sns.storage.b)localObject9).rqr <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject9).rqs <= 0.0F)) {
            break label8905;
          }
          f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject9).rqr, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqu);
          f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject9).rqs, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqu);
          if (((com.tencent.mm.plugin.sns.storage.b)localObject9).rqq != 0) {
            break label4899;
          }
          f1 = f3;
          if (f3 >= k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808))
          {
            f1 = k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808);
            f2 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject9).rqs * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqr);
          }
          localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if ((((aj)localObject2).qVe instanceof SightPlayImageView))
          {
            if (!localn.pi())
            {
              ((SightPlayImageView)((aj)localObject2).qVe).setScaleMode(1);
              ((SightPlayImageView)((aj)localObject2).qVe).setScaleType(QImageView.a.AED);
            }
          }
          else
          {
            label4465:
            ((com.tencent.mm.plugin.sight.decode.a.a)localObject7).ft(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
            localObject9 = ((aj)localObject2).rLG.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject9).width = ((Integer)((Pair)localObject1).first).intValue();
            ((ViewGroup.LayoutParams)localObject9).height = ((Integer)((Pair)localObject1).second).intValue();
            ((aj)localObject2).rLG.setLayoutParams((ViewGroup.LayoutParams)localObject9);
            localObject8 = (FrameLayout)((View)localObject8).findViewById(2131828027);
            localObject9 = (FrameLayout.LayoutParams)((FrameLayout)localObject8).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject9).width = ((Integer)((Pair)localObject1).first).intValue();
            ((FrameLayout.LayoutParams)localObject9).height = ((Integer)((Pair)localObject1).second).intValue();
            ((FrameLayout)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
          }
        }
        else
        {
          if ((((TimeLineObject)localObject5).xTS == null) || (((TimeLineObject)localObject5).xTS.wOa.size() <= 0)) {
            break label5110;
          }
          localObject1 = (bcs)((TimeLineObject)localObject5).xTS.wOa.get(0);
          if (localn.pi())
          {
            ((aj)localObject2).qVe.setOnCompletionListener(new SnsCommentDetailUI.24(this, localn));
            if (!this.rOU.lj(localn.field_snsId)) {
              ((aj)localObject2).qVe.setOnDecodeDurationListener(new SnsCommentDetailUI.25(this, localn, (aj)localObject2));
            }
          }
          if ((((TimeLineObject)localObject5).xTS == null) || (((TimeLineObject)localObject5).xTS.wOa.size() <= 0)) {
            break;
          }
          ag.cpc();
          if (com.tencent.mm.plugin.sns.model.g.t((bcs)localObject1)) {
            break label5219;
          }
          if (!ag.cpc().w((bcs)localObject1)) {
            break label5116;
          }
          ((aj)localObject2).rwJ.setVisibility(8);
          ((aj)localObject2).rLF.setVisibility(0);
          ((aj)localObject2).rLF.dOF();
          ((com.tencent.mm.plugin.sight.decode.a.a)localObject7).setTagObject(localObject2);
          ag.cpc().a(localn, (bcs)localObject1, (com.tencent.mm.plugin.sight.decode.a.a)localObject7, hashCode(), 0, az.yNT, localn.pi());
          ((View)localObject4).setTag(localObject2);
          if (this.rOU == null) {
            break;
          }
          if (!localn.pi()) {
            break label5505;
          }
          if (ag.cpc().o(localn) != 5) {
            break label5499;
          }
          bool = true;
        }
        for (;;)
        {
          this.rOU.x(localn.field_snsId, bool);
          break;
          this.jVd.c((View)localObject4, this.rOV.sjJ, this.rOV.sjr);
          break label4174;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject9).rqq == 1)
          {
            i = k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808);
            localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqr)));
            break label4415;
          }
          if (((com.tencent.mm.plugin.sns.storage.b)localObject9).rqq != 2) {
            break label8905;
          }
          i = k - com.tencent.mm.cb.a.ao(this, 2131428700) - com.tencent.mm.cb.a.ao(this, 2131427861) - getResources().getDimensionPixelSize(2131427808) - getResources().getDimensionPixelSize(2131427808);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject9).rqr)));
          break label4415;
          ((SightPlayImageView)((aj)localObject2).qVe).setScaleMode(0);
          ((SightPlayImageView)((aj)localObject2).qVe).setScaleType(QImageView.a.AEy);
          break label4465;
          label5110:
          localObject1 = null;
          break label4647;
          label5116:
          if ((localn.pi()) && (ag.cpc().o(localn) == 5))
          {
            ag.cpc().A((bcs)localObject1);
            ((aj)localObject2).rwJ.setVisibility(8);
            ((aj)localObject2).rLF.setVisibility(0);
            ((aj)localObject2).rLF.dOF();
            break label4784;
          }
          ag.cpc().y((bcs)localObject1);
          ((aj)localObject2).rwJ.setVisibility(0);
          ((aj)localObject2).rLF.setVisibility(8);
          ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this, 2131231980));
          break label4784;
          label5219:
          if (ag.cpc().u((bcs)localObject1))
          {
            ((aj)localObject2).rwJ.setVisibility(0);
            ((aj)localObject2).rLF.setVisibility(8);
            ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this, 2131231980));
          }
          for (;;)
          {
            if (!((aj)localObject2).qVe.cmy()) {
              break label5497;
            }
            ab.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((bcs)localObject1).Id + " " + ((bcs)localObject1).Url + " " + ((bcs)localObject1).xrS);
            ag.cpc().y((bcs)localObject1);
            ((aj)localObject2).rwJ.setVisibility(0);
            ((aj)localObject2).rLF.setVisibility(8);
            ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this, 2131231980));
            break;
            if (ag.cpc().v((bcs)localObject1))
            {
              ((aj)localObject2).rwJ.setVisibility(8);
              ((aj)localObject2).rLF.setVisibility(8);
            }
            else if ((localn.pi()) && (ag.cpc().o(localn) <= 5))
            {
              ((aj)localObject2).rwJ.setVisibility(8);
              ((aj)localObject2).rLF.setVisibility(8);
            }
            else
            {
              ag.cpc().y((bcs)localObject1);
              ((aj)localObject2).rwJ.setVisibility(0);
              ((aj)localObject2).rLF.setVisibility(8);
              ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this, 2131231980));
            }
          }
          label5497:
          break label4784;
          label5499:
          bool = false;
          continue;
          if (ag.cpc().n(localn) == 5) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (this.kwo == 0)
        {
          localObject1 = (LinearLayout)this.rOq.findViewById(2131827938);
          localObject2 = EM(2130970843);
          if (!this.rPn)
          {
            ((LinearLayout)localObject1).removeView(this.rPq);
            ((LinearLayout)localObject1).addView((View)localObject2, 3);
            if (((LinearLayout)localObject2).getLayoutParams() == null) {
              break label5921;
            }
          }
          for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject2).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
          {
            ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
            ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            if (((TimeLineObject)localObject5).xTS.wOa.isEmpty()) {
              break label5936;
            }
            localObject4 = (bcs)((TimeLineObject)localObject5).xTS.wOa.get(0);
            localObject1 = (MMImageView)((LinearLayout)localObject2).findViewById(2131825855);
            ag.cpc().a((bcs)localObject4, (View)localObject1, 2131230809, hashCode(), az.yNT);
            this.rOJ = ((ImageView)((LinearLayout)localObject2).findViewById(2131824765));
            this.rOJ.setOnTouchListener(this.rGO);
            this.cAd = ((TimeLineObject)localObject5).Id;
            cuZ();
            bool = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
            ((MMImageView)localObject1).setTag(new q((TimeLineObject)localObject5, this.rOG, bool));
            ((MMImageView)localObject1).setOnClickListener(this.rON.scE);
            localObject7 = ((bcs)localObject4).Desc;
            if (!bo.isNullOrNil((String)localObject7)) {
              ((TextView)((LinearLayout)localObject2).findViewById(2131825858)).setText((CharSequence)localObject7);
            }
            localObject4 = ((bcs)localObject4).Title;
            if (!bo.isNullOrNil((String)localObject4)) {
              ((TextView)((LinearLayout)localObject2).findViewById(2131825857)).setText(new SpannableString((CharSequence)localObject4), TextView.BufferType.SPANNABLE);
            }
            ((LinearLayout)localObject2).setTag(new q((TimeLineObject)localObject5, this.rOG));
            this.jVd.c((View)localObject2, this.rOV.sjG, this.rOV.sjr);
            ((LinearLayout)localObject2).setOnClickListener(this.rON.rUE);
            com.tencent.mm.plugin.sns.data.i.b((View)localObject1, this);
            break;
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break;
        }
        if (this.kwo == 13)
        {
          this.rOr.setVisibility(8);
          this.rOw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          break;
        }
        if ((this.kwo == 11) || (this.kwo == 14) || (this.kwo == 15)) {
          break;
        }
        localObject1 = (LinearLayout)this.rOq.findViewById(2131827938);
        localObject7 = EM(2130970841);
        localObject8 = (MMImageView)((LinearLayout)localObject7).findViewById(2131825855);
        if (!this.rPn)
        {
          ((LinearLayout)localObject1).removeView(this.rPq);
          ((LinearLayout)localObject1).addView((View)localObject7, 3);
          if (((LinearLayout)localObject7).getLayoutParams() != null)
          {
            localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject7).getLayoutParams());
            label6094:
            ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
            ((LinearLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
        else
        {
          i = 0;
          if (!localn.pi()) {
            break label6531;
          }
          if (localn.csb().cqo())
          {
            i = 1;
            ((LinearLayout)localObject7).setTag(localn);
            ((LinearLayout)localObject7).setTag(2131820637, localObject8);
            ((LinearLayout)localObject7).setOnClickListener(this.rOV.skc);
          }
          j = 0;
        }
        for (;;)
        {
          if (i != 0)
          {
            this.jVd.c((View)localObject7, this.rOV.sjK, this.rOV.sjr);
            if (!cuV()) {
              break label7252;
            }
            localObject1 = av.acj(((TimeLineObject)localObject5).xTS.Url);
            label6231:
            localObject2 = ((TimeLineObject)localObject5).xTS.Title;
            if (i == 0) {
              break label8893;
            }
            localObject1 = ((TimeLineObject)localObject5).xTS.Desc;
          }
          for (;;)
          {
            ((LinearLayout)localObject7).findViewById(2131824765).setVisibility(8);
            if (!((TimeLineObject)localObject5).xTS.wOa.isEmpty())
            {
              ((MMImageView)localObject8).setVisibility(0);
              localObject4 = (bcs)((TimeLineObject)localObject5).xTS.wOa.get(0);
              if (((TimeLineObject)localObject5).xTS.wNZ == 15)
              {
                ((ImageView)((LinearLayout)localObject7).findViewById(2131824765)).setImageResource(2130839753);
                ((ImageView)((LinearLayout)localObject7).findViewById(2131824765)).setVisibility(0);
                ag.cpc().a((bcs)localObject4, (View)localObject8, 2131230826, hashCode(), az.dxB().Nv(((TimeLineObject)localObject5).CreateTime));
                localObject4 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                label6391:
                com.tencent.mm.plugin.sns.data.i.b((View)localObject8, this);
                if (((TimeLineObject)localObject5).xTS.wNZ != 15) {
                  break label8890;
                }
                localObject1 = getString(2131303817);
                localObject2 = "";
              }
            }
            for (;;)
            {
              localObject4 = (TextView)((LinearLayout)localObject7).findViewById(2131825857);
              if (!bo.isNullOrNil((String)localObject2))
              {
                ((LinearLayout)localObject7).findViewById(2131825858).setVisibility(0);
                ((TextView)((LinearLayout)localObject7).findViewById(2131825858)).setText((CharSequence)localObject2);
                ((TextView)localObject4).setMaxLines(1);
              }
              for (;;)
              {
                if (!bo.isNullOrNil((String)localObject1))
                {
                  ((TextView)localObject4).setVisibility(0);
                  if (j != 0)
                  {
                    ((TextView)localObject4).setText(com.tencent.mm.plugin.sns.data.i.a((String)localObject1, getContext(), (TextView)localObject4));
                    break;
                    localObject1 = new LinearLayout.LayoutParams(-1, -2);
                    break label6094;
                    if (((TimeLineObject)localObject5).xTS.wNZ == 9)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scy);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 10)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scA);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 17)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scB);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 22)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scC);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 23)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scD);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 14)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scz);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 12)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scH);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 13)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scI);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 15)
                    {
                      if (((TimeLineObject)localObject5).xTS.wOa.size() <= 0) {
                        break label8896;
                      }
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rOV.sjP);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 26)
                    {
                      ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                      ((LinearLayout)localObject7).setOnClickListener(this.rON.scJ);
                      i = 0;
                      j = 0;
                      break label6184;
                    }
                    ((LinearLayout)localObject7).setTag(new q((TimeLineObject)localObject5, this.rOG));
                    ((LinearLayout)localObject7).setOnClickListener(this.rON.rUE);
                    if ((((TimeLineObject)localObject5).fgB & 0x1) <= 0) {
                      break label8896;
                    }
                    i = 0;
                    j = 1;
                    break label6184;
                    this.jVd.c((View)localObject7, this.rOV.sjG, this.rOV.sjr);
                    break label6212;
                    label7252:
                    localObject1 = "";
                    break label6231;
                    if (((TimeLineObject)localObject5).xTS.wNZ == 5)
                    {
                      localObject2 = av.acj(((bcs)localObject4).Url);
                      localObject1 = ((bcs)localObject4).Title;
                      ((LinearLayout)localObject7).findViewById(2131824765).setVisibility(0);
                      ag.cpc().a((bcs)localObject4, (View)localObject8, 2131230826, hashCode(), az.yNT);
                      break label6391;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 18)
                    {
                      ((LinearLayout)localObject7).findViewById(2131824765).setVisibility(0);
                      ((ImageView)((LinearLayout)localObject7).findViewById(2131824765)).setImageResource(2130840664);
                      ((MMImageView)localObject8).setVisibility(0);
                      ag.cpc().a((bcs)localObject4, (View)localObject8, 2131230826, hashCode(), az.yNT);
                      localObject4 = localObject1;
                      localObject1 = localObject2;
                      localObject2 = localObject4;
                      break label6391;
                    }
                    ag.cpc().b((bcs)localObject4, (View)localObject8, hashCode(), az.yNT);
                    localObject4 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject4;
                    break label6391;
                    if (((TimeLineObject)localObject5).xTS.wNZ == 18)
                    {
                      ((ImageView)((LinearLayout)localObject7).findViewById(2131824765)).setVisibility(0);
                      ((ImageView)((LinearLayout)localObject7).findViewById(2131824765)).setImageResource(2130840664);
                      ((MMImageView)localObject8).setVisibility(0);
                      ag.cpc().a((View)localObject8, -1, 2131230826, hashCode());
                      localObject4 = localObject1;
                      localObject1 = localObject2;
                      localObject2 = localObject4;
                      break label6391;
                    }
                    if (((TimeLineObject)localObject5).xTS.wNZ == 26)
                    {
                      ((MMImageView)localObject8).setVisibility(0);
                      ag.cpc().a((View)localObject8, -1, 2131231779, hashCode());
                      localObject4 = localObject1;
                      localObject1 = localObject2;
                      localObject2 = localObject4;
                      break label6391;
                    }
                    ((MMImageView)localObject8).setVisibility(0);
                    ag.cpc().a((View)localObject8, -1, 2131230829, hashCode());
                    localObject4 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject4;
                    break label6391;
                    ((LinearLayout)localObject7).findViewById(2131825858).setVisibility(8);
                    ((TextView)localObject4).setMaxLines(2);
                    continue;
                  }
                  ((TextView)localObject4).setText((CharSequence)localObject1);
                  break;
                }
              }
              ((TextView)localObject4).setVisibility(8);
              break;
              label7649:
              ((TextView)localObject4).setVisibility(0);
              if (bo.isNullOrNil((String)localObject1)) {
                break label2033;
              }
              ((TextView)localObject4).setTextColor(-11048043);
              ((TextView)localObject4).setClickable(true);
              ((TextView)localObject4).setText((CharSequence)localObject1);
              break label2054;
              ((TextView)localObject4).setVisibility(8);
              break label2054;
              if (((TimeLineObject)localObject5).xTQ == null)
              {
                localObject1 = null;
                if (((TimeLineObject)localObject5).xTQ != null) {
                  break label7768;
                }
              }
              label7768:
              for (localObject2 = null;; localObject2 = ((TimeLineObject)localObject5).xTQ.eSM)
              {
                ((TextView)localObject4).setTag(localn.csH());
                if ((!bo.isNullOrNil((String)localObject1)) || (!bo.isNullOrNil((String)localObject2))) {
                  break label7781;
                }
                ((TextView)localObject4).setVisibility(8);
                break;
                localObject1 = ((TimeLineObject)localObject5).xTQ.gwR;
                break label7708;
              }
              label7781:
              ((TextView)localObject4).setVisibility(0);
              if (!bo.isNullOrNil((String)localObject2))
              {
                ((TextView)localObject4).setTextColor(-11048043);
                ((TextView)localObject4).setClickable(true);
                if ((localn.field_snsId == 0L) && (!bo.isNullOrNil((String)localObject1)))
                {
                  ((TextView)localObject4).setText((String)localObject1 + "·" + (String)localObject2);
                  break label2070;
                }
                ((TextView)localObject4).setText((CharSequence)localObject2);
                break label2070;
              }
              ((TextView)localObject4).setText((CharSequence)localObject1);
              ((TextView)localObject4).setClickable(false);
              ((TextView)localObject4).setTextColor(-9211021);
              break label2070;
              label7895:
              ((TextView)localObject4).setVisibility(8);
              break label2265;
              label7905:
              if (((com.tencent.mm.plugin.sns.storage.a)localObject6).rpp != com.tencent.mm.plugin.sns.storage.a.rpc) {
                break label2265;
              }
              if (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject6).rpq))
              {
                localObject1 = "";
                localObject8 = ((com.tencent.mm.plugin.sns.storage.a)localObject6).rps.iterator();
                if (((Iterator)localObject8).hasNext())
                {
                  localObject9 = (String)((Iterator)localObject8).next();
                  localObject2 = this.rOH.arv((String)localObject9);
                  if (localObject2 != null)
                  {
                    localObject2 = ((com.tencent.mm.n.a)localObject2).Of();
                    if (!bo.isNullOrNil((String)localObject2)) {
                      localObject2 = (String)localObject1 + (String)localObject2;
                    }
                  }
                  for (;;)
                  {
                    localObject1 = localObject2;
                    if (((com.tencent.mm.plugin.sns.storage.a)localObject6).rps.getLast() == localObject9) {
                      break;
                    }
                    localObject1 = (String)localObject2 + ",";
                    break;
                    localObject2 = (String)localObject1 + (String)localObject9;
                    continue;
                    localObject2 = (String)localObject1 + (String)localObject9;
                  }
                }
                localObject2 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject6).rpq, new Object[] { localObject1 });
                ((TextView)localObject4).getTextSize();
                localObject8 = new k(com.tencent.mm.pluginsdk.ui.d.j.c(this, (CharSequence)localObject2, 1));
                ((k)localObject8).a(null, (CharSequence)localObject2);
                localObject2 = ((TextView)localObject4).getPaint();
                if (com.tencent.mm.cb.a.ar(this, (int)Layout.getDesiredWidth((CharSequence)localObject8, 0, ((k)localObject8).length(), (TextPaint)localObject2)) > this.rOS)
                {
                  if (((String)localObject1).length() <= 1) {
                    break label2265;
                  }
                  localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                  localObject8 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject6).rpq, new Object[] { (String)localObject1 + "..." });
                  ((TextView)localObject4).getTextSize();
                  localObject9 = new k(com.tencent.mm.pluginsdk.ui.d.j.c(this, (CharSequence)localObject8, 1));
                  ((k)localObject9).a(null, (CharSequence)localObject8);
                  i = com.tencent.mm.cb.a.ar(this, (int)Layout.getDesiredWidth((CharSequence)localObject9, 0, ((k)localObject9).length(), (TextPaint)localObject2));
                  ((TextView)localObject4).setText((CharSequence)localObject9, TextView.BufferType.SPANNABLE);
                  ((TextView)localObject4).setVisibility(0);
                  if (i > this.rOS) {
                    break label2264;
                  }
                  break label2265;
                }
                ((TextView)localObject4).setText((CharSequence)localObject8, TextView.BufferType.SPANNABLE);
                ((TextView)localObject4).setVisibility(0);
                break label2265;
              }
              ((TextView)localObject4).setVisibility(8);
              break label2265;
              ((TextView)localObject7).setVisibility(8);
              break label2391;
              ((TextView)localObject2).setVisibility(8);
              break label2600;
              ((TextView)localObject1).setVisibility(8);
              break label2686;
              label8408:
              if (((SnsObject)localObject4).WithUserList.size() <= 0) {
                ((TextView)localObject3).setVisibility(8);
              }
              for (;;)
              {
                if ((localObject4 == null) || (this.dZZ == null) || (!this.dZZ.equals(((SnsObject)localObject4).Username)) || (((((SnsObject)localObject4).ExtFlag != 3) || (((SnsObject)localObject4).BlackList == null)) && ((((SnsObject)localObject4).ExtFlag != 5) || (((SnsObject)localObject4).GroupUser == null)))) {
                  break label8872;
                }
                this.rOq.findViewById(2131827951).setVisibility(0);
                this.rOq.findViewById(2131827951).setTag(Integer.valueOf(localn.rCV));
                this.rOq.findViewById(2131827951).setOnClickListener(new SnsCommentDetailUI.29(this));
                break;
                if (this.dZZ.equals(((SnsObject)localObject4).Username))
                {
                  ((TextView)localObject3).setVisibility(0);
                  i = 0;
                  localObject5 = ((SnsObject)localObject4).WithUserList.iterator();
                  localObject1 = "";
                  if (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (cds)((Iterator)localObject5).next();
                    if (i == 0)
                    {
                      i = 1;
                      localObject1 = (String)localObject1 + "  ";
                      if (((cds)localObject6).Nickname == null) {
                        break label8690;
                      }
                      localObject2 = new StringBuilder().append((String)localObject1);
                      localObject1 = ((cds)localObject6).Nickname;
                    }
                    for (;;)
                    {
                      localObject1 = (String)localObject1;
                      break;
                      localObject1 = (String)localObject1 + ",  ";
                      break label8620;
                      label8690:
                      localObject7 = this.rOH.arw(((cds)localObject6).Username);
                      localObject2 = new StringBuilder().append((String)localObject1);
                      if (localObject7 == null) {
                        localObject1 = ((cds)localObject6).Username;
                      } else {
                        localObject1 = ((com.tencent.mm.n.a)localObject7).Of();
                      }
                    }
                  }
                  ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, getString(2131304022, new Object[] { localObject1 }), ((TextView)localObject3).getTextSize()));
                }
                else
                {
                  ((TextView)localObject3).setVisibility(8);
                  localObject1 = ((SnsObject)localObject4).WithUserList.iterator();
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (cds)((Iterator)localObject1).next();
                    if (!this.dZZ.equals(((cds)localObject2).Username)) {
                      break label8408;
                    }
                    ((TextView)localObject3).setVisibility(0);
                    localObject1 = getString(2131304023);
                    ((TextView)localObject3).setVisibility(0);
                    ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, ((TextView)localObject3).getTextSize()));
                  }
                }
              }
              this.rOq.findViewById(2131827951).setVisibility(8);
              break label2720;
            }
          }
          i = 0;
          j = 0;
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130970816;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38843);
    setMMTitle(2131303791);
    setToTop(new SnsCommentDetailUI.17(this));
    setBackBtn(new SnsCommentDetailUI.18(this));
    this.dZZ = r.Zn();
    if (ag.coN()) {
      finish();
    }
    n localn = lB(true);
    if (localn == null)
    {
      ab.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.czw);
      finish();
      AppMethodBeat.o(38843);
      return;
    }
    ab.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.czw + "localId " + this.rOG + "  username:" + localn.field_userName);
    Object localObject1 = (TextView)findViewById(2131827931);
    label297:
    int i;
    if (this.rPa)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.rPb);
      if ((v.abQ(this.czw)) || (!localn.csJ())) {
        break label637;
      }
      localObject1 = localn.csz();
      findViewById(2131827932).setVisibility(0);
      localObject2 = (TextView)findViewById(2131827933);
      switch (((bct)localObject1).xsx)
      {
      default: 
        if (!bo.isNullOrNil(((bct)localObject1).xsE))
        {
          ((TextView)localObject2).setText(((bct)localObject1).xsE);
          findViewById(2131827934).setVisibility(0);
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      if (i != 0) {
        findViewById(2131827932).setOnClickListener(new SnsCommentDetailUI.9(this, localn));
      }
      this.rOu = ((ListView)findViewById(2131827935));
      this.rOu.post(new SnsCommentDetailUI.10(this));
      this.rOu.setOnScrollListener(new SnsCommentDetailUI.11(this));
      this.rOq = w.hM(getContext()).inflate(2130970817, null);
      this.rOw = this.rOq.findViewById(2131827944);
      this.rOq.setOnClickListener(this.rPk);
      this.rOu.addHeaderView(this.rOq);
      boolean bool = cuW();
      if (bool) {
        break label654;
      }
      ab.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(38843);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!bo.isNullOrNil(((bct)localObject1).xsE)) {
        ((TextView)localObject2).setText(((bct)localObject1).xsE);
      }
      for (;;)
      {
        findViewById(2131827934).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131303929);
      }
      if (!bo.isNullOrNil(((bct)localObject1).xsE)) {
        ((TextView)localObject2).setText(((bct)localObject1).xsE);
      }
      for (;;)
      {
        findViewById(2131827934).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131303931);
      }
      if (!bo.isNullOrNil(((bct)localObject1).xsE)) {
        ((TextView)localObject2).setText(((bct)localObject1).xsE);
      }
      for (;;)
      {
        findViewById(2131827934).setVisibility(8);
        i = 1;
        break;
        ((TextView)localObject2).setText(2131303930);
      }
      ((TextView)localObject2).setText(2131303932);
      break label297;
      label637:
      findViewById(2131827932).setVisibility(8);
      i = 0;
    }
    label654:
    localObject1 = lB(false);
    if (localObject1 != null) {
      this.kwo = av.b((n)localObject1, false);
    }
    if ((this.kwo == 10) && (r.Zn().equals(localn.field_userName)))
    {
      this.rOt = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.rOt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.rOt.setOnClickListener(this.rPk);
    }
    this.rOs = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.rOs.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.rOs.setOnClickListener(this.rPk);
    BackwardSupportUtil.b.b(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(2130840395);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.rcD = ((LinearLayout)localObject2);
    if ((localn.field_localPrivate & 0x1) != 0)
    {
      findViewById(2131822831).setVisibility(8);
      localObject1 = new TextView(this);
      ((TextView)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((TextView)localObject1).setText(getString(2131303798));
      ((TextView)localObject1).setTextColor(getResources().getColor(2131689763));
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setPadding(0, BackwardSupportUtil.b.b(this, 7.0F), 0, 0);
      this.rOu.addFooterView((View)localObject1);
    }
    if (this.rOt != null)
    {
      this.rOX = true;
      this.rOu.addHeaderView(this.rOt);
    }
    localObject2 = com.tencent.mm.plugin.sns.model.ak.p(localn);
    label1212:
    cds localcds;
    long l;
    if (localObject2 == null)
    {
      this.rOs.setVisibility(8);
      this.rOx = new SnsCommentDetailUI.b(this, new LinkedList(), new LinkedList(), this, localn.csH());
      this.rOu.addHeaderView(this.rOs);
      this.rOu.setAdapter(this.rOx);
      this.rFo = ((SnsCommentFooter)findViewById(2131822831));
      this.rFo.setOnEditTouchListener(new SnsCommentDetailUI.13(this, localn));
      this.rFo.setOnSmileyShowListener(new SnsCommentDetailUI.14(this));
      localObject1 = lB(true);
      if ((localObject1 != null) && (!((n)localObject1).csG())) {
        this.rFo.setVisibility(8);
      }
      this.rFo.setAfterEditAction(this.rPj);
      this.rFo.cve();
      this.rFo.setOnCommentSendImp(new SnsCommentDetailUI.15(this, localn));
      this.rOL = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.rOL)
      {
        this.rOM = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.rOM != 0L) && (this.rOx.rPQ != null))
        {
          i = 0;
          if (i < this.rOx.rPQ.size())
          {
            localcds = (cds)this.rOx.rPQ.get(i);
            if (localcds.xNY == 0) {
              break label1695;
            }
            l = localcds.xNY;
            label1258:
            if (l != this.rOM) {
              break label1733;
            }
            this.rOu.setSelection(i);
            localObject1 = this.rOH.arw(localcds.Username);
            if (localObject1 == null) {
              break label1705;
            }
            localObject1 = ((com.tencent.mm.n.a)localObject1).Of();
            label1304:
            this.rFo.rQa = 0;
            this.rFo.cvf();
            this.rFo.setCommentHint(getString(2131303938) + (String)localObject1);
            this.rFo.setCommentInfo(localcds);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label1772;
            }
            int j = i + 1;
            i = j;
            if (j > this.rOx.getCount()) {
              i = this.rOx.getCount() - 1;
            }
          }
        }
      }
    }
    label1695:
    label1705:
    label1733:
    label1772:
    for (;;)
    {
      this.rPj.KY = i;
      if (this.rOL) {
        new com.tencent.mm.sdk.platformtools.ak().postDelayed(new SnsCommentDetailUI.16(this), 100L);
      }
      this.rOW = ((SnsTranslateResultView)this.rOq.findViewById(2131827943));
      this.rOW.setResultTextSize(((TextView)this.rOq.findViewById(2131821007)).getTextSize());
      this.rOW.getResultTextView().setBackgroundResource(2130840380);
      localObject1 = new as(this.czw, localn.csH(), false, true, 2);
      this.rOW.getResultTextView().setTag(localObject1);
      this.jVd.c(this.rOW.getResultTextView(), this.rOV.sju, this.rOV.sjr);
      if (com.tencent.mm.plugin.sns.model.aq.dn(this.czw, 4))
      {
        localObject1 = com.tencent.mm.plugin.sns.model.aq.aaD(this.czw);
        if ((localObject1 != null) && (((aq.b)localObject1).fon))
        {
          this.rOW.setVisibility(0);
          this.rOW.a(null, 1, ((aq.b)localObject1).result, ((aq.b)localObject1).fwM, false);
          AppMethodBeat.o(38843);
          return;
          this.rOC = ((SnsObject)localObject2).LikeUserList;
          g(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.rOt != null) {
            this.rOt.a(localn, this.rOV);
          }
          this.rOx = new SnsCommentDetailUI.b(this, ((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localn.csH());
          break;
          l = localcds.xOa;
          break label1258;
          if (localcds.Nickname != null)
          {
            localObject1 = localcds.Nickname;
            break label1304;
          }
          localObject1 = localcds.Username;
          break label1304;
          i += 1;
          break label1212;
        }
        this.rOW.setVisibility(8);
        AppMethodBeat.o(38843);
        return;
      }
      this.rOW.setVisibility(8);
      AppMethodBeat.o(38843);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38853);
    ab.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt1 == 15)
    {
      if ((this.rOV != null) && (this.rOV.sjr != null)) {
        this.rOV.sjr.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(38853);
      return;
    }
    if (paramInt1 == 16)
    {
      ab.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new gs();
      paramIntent.cvG.scene = 1;
      com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
      AppMethodBeat.o(38853);
      return;
    }
    if (paramInt1 == 2333)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!bo.isNullOrNil(paramIntent))
        {
          paramIntent = paramIntent.split(",");
          if (paramIntent.length > 0)
          {
            this.rFo.cmc.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramIntent[0]);
            if (!bo.isNullOrNil(str))
            {
              this.rFo.cvf();
              this.rFo.setText("@" + str + " ");
              this.rFo.setCommentAtPrefix("@" + str + " ");
              this.rFo.setCommentInfo(new cds());
              this.rFo.getCommentInfo().Username = paramIntent[0];
              this.rFo.setCommentFlag(8);
            }
          }
        }
      }
      AppMethodBeat.o(38853);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38853);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38853);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = managedQuery(paramIntent.getData(), null, null, null, null);
        if (paramIntent.moveToFirst()) {
          startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id")))))));
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38852);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.h.abu(this.czw);
    SnsObject localSnsObject = com.tencent.mm.plugin.sns.model.ak.p(paramConfiguration);
    g(localSnsObject.LikeUserList, localSnsObject.CommentUserList.isEmpty());
    if (this.rOt != null) {
      this.rOt.a(paramConfiguration, this.rOV);
    }
    if (this.rPq != null)
    {
      this.rOP = ag.cpn();
      this.rPq.setImageViewWidth(this.rOP);
    }
    AppMethodBeat.o(38852);
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc_w 2520
    //   6: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 2525	com/tencent/mm/pluginsdk/f:m	(Lcom/tencent/mm/ui/MMActivity;)V
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 2527	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   18: aload_0
    //   19: iconst_1
    //   20: invokestatic 2532	com/tencent/mm/ui/b:c	(Landroid/app/Activity;Z)V
    //   23: invokestatic 2536	com/tencent/mm/plugin/sns/model/ag:coV	()Lcom/tencent/mm/plugin/sns/model/an$a;
    //   26: iconst_5
    //   27: ldc_w 2538
    //   30: aload_0
    //   31: invokevirtual 2541	com/tencent/mm/plugin/sns/model/an$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/b/h$a;)V
    //   34: aload_0
    //   35: aload_0
    //   36: invokevirtual 2544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getApplicationContext	()Landroid/content/Context;
    //   39: ldc_w 2546
    //   42: invokevirtual 2549	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   45: checkcast 2551	android/text/ClipboardManager
    //   48: putfield 1020	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mAZ	Landroid/text/ClipboardManager;
    //   51: aload_0
    //   52: invokestatic 2557	com/tencent/mm/ui/af:hQ	(Landroid/content/Context;)Landroid/graphics/Point;
    //   55: astore_1
    //   56: aload_0
    //   57: aload_1
    //   58: getfield 2561	android/graphics/Point:x	I
    //   61: putfield 2563	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   64: aload_0
    //   65: aload_1
    //   66: getfield 2565	android/graphics/Point:y	I
    //   69: putfield 2567	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   72: aload_0
    //   73: invokestatic 2573	java/lang/System:currentTimeMillis	()J
    //   76: putfield 152	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOo	J
    //   79: aload_0
    //   80: new 1315	com/tencent/mm/ui/widget/c/a
    //   83: dup
    //   84: aload_0
    //   85: invokespecial 2574	com/tencent/mm/ui/widget/c/a:<init>	(Landroid/content/Context;)V
    //   88: putfield 428	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:jVd	Lcom/tencent/mm/ui/widget/c/a;
    //   91: aload_0
    //   92: aload_0
    //   93: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   96: ldc_w 2576
    //   99: iconst_0
    //   100: invokevirtual 2580	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   103: putfield 981	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPd	I
    //   106: aload_0
    //   107: aload_0
    //   108: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   111: ldc_w 2582
    //   114: invokevirtual 2441	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   117: ldc 176
    //   119: invokestatic 1205	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   122: putfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   125: aload_0
    //   126: getfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   129: invokestatic 667	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   132: ifeq +24 -> 156
    //   135: aload_0
    //   136: ldc_w 2584
    //   139: aload_0
    //   140: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   143: ldc_w 2582
    //   146: lconst_0
    //   147: invokevirtual 2360	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   150: invokestatic 2588	com/tencent/mm/plugin/sns/storage/v:aE	(Ljava/lang/String;J)Ljava/lang/String;
    //   153: putfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   156: aload_0
    //   157: aload_0
    //   158: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   161: ldc_w 2590
    //   164: invokevirtual 2441	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   167: ldc 176
    //   169: invokestatic 1205	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: putfield 630	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOG	Ljava/lang/String;
    //   175: aload_0
    //   176: getfield 630	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOG	Ljava/lang/String;
    //   179: invokestatic 667	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   182: ifeq +32 -> 214
    //   185: aload_0
    //   186: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   189: ldc_w 2590
    //   192: iconst_m1
    //   193: invokevirtual 2580	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   196: istore_2
    //   197: iload_2
    //   198: iconst_m1
    //   199: if_icmpeq +15 -> 214
    //   202: aload_0
    //   203: ldc_w 2584
    //   206: iload_2
    //   207: i2l
    //   208: invokestatic 2588	com/tencent/mm/plugin/sns/storage/v:aE	(Ljava/lang/String;J)Ljava/lang/String;
    //   211: putfield 630	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOG	Ljava/lang/String;
    //   214: aload_0
    //   215: new 2592	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$3
    //   218: dup
    //   219: aload_0
    //   220: aload_0
    //   221: invokespecial 360	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   224: aload_0
    //   225: aload_0
    //   226: getfield 205	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPe	Lcom/tencent/mm/plugin/sns/model/ah;
    //   229: invokespecial 2595	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/af;)V
    //   232: putfield 296	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOV	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   235: aload_0
    //   236: ldc_w 2596
    //   239: invokevirtual 1341	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   242: checkcast 1847	android/widget/FrameLayout
    //   245: astore_1
    //   246: aload_0
    //   247: new 2598	com/tencent/mm/plugin/sns/g/b
    //   250: dup
    //   251: aload_0
    //   252: aload_0
    //   253: getfield 296	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOV	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   256: aload_1
    //   257: invokespecial 2601	com/tencent/mm/plugin/sns/g/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   260: putfield 2603	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rFx	Lcom/tencent/mm/plugin/sns/g/b;
    //   263: aload_0
    //   264: new 2605	com/tencent/mm/plugin/sns/ui/b
    //   267: dup
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 296	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOV	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   273: aload_1
    //   274: aload_0
    //   275: getfield 2603	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rFx	Lcom/tencent/mm/plugin/sns/g/b;
    //   278: invokespecial 2608	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/g/b;)V
    //   281: putfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rFw	Lcom/tencent/mm/plugin/sns/ui/b;
    //   284: aload_0
    //   285: getfield 296	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOV	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   288: invokevirtual 2611	com/tencent/mm/plugin/sns/ui/d/b:bKw	()V
    //   291: aload_0
    //   292: aload_0
    //   293: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   296: ldc_w 2613
    //   299: iconst_0
    //   300: invokevirtual 1986	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   303: putfield 196	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPa	Z
    //   306: aload_0
    //   307: aload_0
    //   308: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   311: ldc_w 2615
    //   314: invokevirtual 2441	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   317: putfield 198	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPb	Ljava/lang/String;
    //   320: aload_0
    //   321: new 767	com/tencent/mm/plugin/sns/ui/bd
    //   324: dup
    //   325: aload_0
    //   326: new 2617	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 2618	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   334: aload_0
    //   335: invokespecial 360	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   338: aload_0
    //   339: getfield 205	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPe	Lcom/tencent/mm/plugin/sns/model/ah;
    //   342: invokespecial 2621	com/tencent/mm/plugin/sns/ui/bd:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bd$a;ILcom/tencent/mm/plugin/sns/model/af;)V
    //   345: putfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rON	Lcom/tencent/mm/plugin/sns/ui/bd;
    //   348: invokestatic 2573	java/lang/System:currentTimeMillis	()J
    //   351: lstore 5
    //   353: aload_0
    //   354: invokevirtual 1978	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   357: ldc_w 2623
    //   360: invokevirtual 2627	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   363: astore_1
    //   364: aload_1
    //   365: ifnull +185 -> 550
    //   368: new 451	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   371: dup
    //   372: invokespecial 2628	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   375: astore 7
    //   377: aload 7
    //   379: aload_1
    //   380: invokevirtual 2632	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   383: pop
    //   384: invokestatic 2636	com/tencent/mm/plugin/sns/model/ag:cpf	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   387: new 2638	java/math/BigInteger
    //   390: dup
    //   391: aload 7
    //   393: getfield 1974	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   396: invokespecial 2639	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   399: invokevirtual 2642	java/math/BigInteger:longValue	()J
    //   402: invokevirtual 2648	com/tencent/mm/plugin/sns/storage/o:lZ	(J)Lcom/tencent/mm/plugin/sns/storage/n;
    //   405: ifnonnull +668 -> 1073
    //   408: ldc_w 846
    //   411: ldc_w 2650
    //   414: invokestatic 1082	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: new 342	com/tencent/mm/plugin/sns/storage/n
    //   420: dup
    //   421: invokespecial 2651	com/tencent/mm/plugin/sns/storage/n:<init>	()V
    //   424: astore_1
    //   425: aload_1
    //   426: new 2638	java/math/BigInteger
    //   429: dup
    //   430: aload 7
    //   432: getfield 1974	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   435: invokespecial 2639	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   438: invokevirtual 2642	java/math/BigInteger:longValue	()J
    //   441: putfield 1268	com/tencent/mm/plugin/sns/storage/n:field_snsId	J
    //   444: aload_1
    //   445: aload 7
    //   447: invokevirtual 2655	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   450: putfield 2659	com/tencent/mm/plugin/sns/storage/n:field_content	[B
    //   453: aload_1
    //   454: aload 7
    //   456: getfield 2050	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   459: putfield 2662	com/tencent/mm/plugin/sns/storage/n:field_createTime	I
    //   462: aload_1
    //   463: aload 7
    //   465: getfield 1713	com/tencent/mm/protocal/protobuf/TimeLineObject:jJA	Ljava/lang/String;
    //   468: putfield 975	com/tencent/mm/plugin/sns/storage/n:field_userName	Ljava/lang/String;
    //   471: aload_1
    //   472: aload 7
    //   474: getfield 455	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   477: getfield 460	com/tencent/mm/protocal/protobuf/vi:wNZ	I
    //   480: putfield 2665	com/tencent/mm/plugin/sns/storage/n:field_type	I
    //   483: aload_1
    //   484: invokevirtual 2668	com/tencent/mm/plugin/sns/storage/n:csE	()V
    //   487: new 385	com/tencent/mm/protocal/protobuf/SnsObject
    //   490: dup
    //   491: invokespecial 2669	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   494: astore 7
    //   496: aload 7
    //   498: new 2671	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   501: dup
    //   502: invokespecial 2672	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   505: putfield 2676	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   508: aload_1
    //   509: aload 7
    //   511: invokevirtual 2677	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   514: putfield 2680	com/tencent/mm/plugin/sns/storage/n:field_attrBuf	[B
    //   517: invokestatic 2636	com/tencent/mm/plugin/sns/model/ag:cpf	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   520: aload_1
    //   521: invokevirtual 2684	com/tencent/mm/plugin/sns/storage/o:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   524: pop
    //   525: ldc_w 2686
    //   528: ldc_w 2688
    //   531: iconst_1
    //   532: anewarray 850	java/lang/Object
    //   535: dup
    //   536: iconst_0
    //   537: invokestatic 2573	java/lang/System:currentTimeMillis	()J
    //   540: lload 5
    //   542: lsub
    //   543: invokestatic 1273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   546: aastore
    //   547: invokestatic 1190	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: aload_0
    //   551: iconst_1
    //   552: invokespecial 445	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:lB	(Z)Lcom/tencent/mm/plugin/sns/storage/n;
    //   555: astore_1
    //   556: ldc_w 846
    //   559: new 599	java/lang/StringBuilder
    //   562: dup
    //   563: ldc_w 2690
    //   566: invokespecial 1078	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   569: aload_0
    //   570: getfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   573: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 2692
    //   579: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload_0
    //   583: getfield 630	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOG	Ljava/lang/String;
    //   586: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 1082	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload_1
    //   596: ifnull +28 -> 624
    //   599: ldc_w 846
    //   602: ldc_w 2694
    //   605: iconst_1
    //   606: anewarray 850	java/lang/Object
    //   609: dup
    //   610: iconst_0
    //   611: aload_1
    //   612: getfield 975	com/tencent/mm/plugin/sns/storage/n:field_userName	Ljava/lang/String;
    //   615: ldc 176
    //   617: invokestatic 1205	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   620: aastore
    //   621: invokestatic 1190	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   624: aload_0
    //   625: getfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   628: invokestatic 334	com/tencent/mm/plugin/sns/storage/v:abQ	(Ljava/lang/String;)Z
    //   631: ifeq +56 -> 687
    //   634: aload_0
    //   635: getfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   638: invokestatic 2697	com/tencent/mm/plugin/sns/storage/v:Zq	(Ljava/lang/String;)Z
    //   641: ifeq +476 -> 1117
    //   644: aload_1
    //   645: ifnull +440 -> 1085
    //   648: aload_1
    //   649: getfield 975	com/tencent/mm/plugin/sns/storage/n:field_userName	Ljava/lang/String;
    //   652: invokestatic 2702	com/tencent/mm/model/t:nS	(Ljava/lang/String;)Z
    //   655: ifne +32 -> 687
    //   658: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   661: pop
    //   662: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   665: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   668: new 2714	com/tencent/mm/plugin/sns/model/q
    //   671: dup
    //   672: aload_0
    //   673: getfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   676: invokestatic 2718	com/tencent/mm/plugin/sns/storage/v:abO	(Ljava/lang/String;)J
    //   679: invokespecial 2720	com/tencent/mm/plugin/sns/model/q:<init>	(J)V
    //   682: iconst_0
    //   683: invokevirtual 2725	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;I)Z
    //   686: pop
    //   687: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   690: pop
    //   691: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   694: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   697: sipush 210
    //   700: aload_0
    //   701: invokevirtual 2728	com/tencent/mm/ai/p:a	(ILcom/tencent/mm/ai/f;)V
    //   704: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   707: pop
    //   708: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   711: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   714: sipush 218
    //   717: aload_0
    //   718: invokevirtual 2728	com/tencent/mm/ai/p:a	(ILcom/tencent/mm/ai/f;)V
    //   721: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   724: pop
    //   725: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   728: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   731: sipush 213
    //   734: aload_0
    //   735: invokevirtual 2728	com/tencent/mm/ai/p:a	(ILcom/tencent/mm/ai/f;)V
    //   738: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   741: pop
    //   742: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   745: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   748: sipush 682
    //   751: aload_0
    //   752: invokevirtual 2728	com/tencent/mm/ai/p:a	(ILcom/tencent/mm/ai/f;)V
    //   755: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   758: pop
    //   759: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   762: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   765: sipush 214
    //   768: aload_0
    //   769: invokevirtual 2728	com/tencent/mm/ai/p:a	(ILcom/tencent/mm/ai/f;)V
    //   772: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   775: pop
    //   776: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   779: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   782: sipush 683
    //   785: aload_0
    //   786: invokevirtual 2728	com/tencent/mm/ai/p:a	(ILcom/tencent/mm/ai/f;)V
    //   789: aload_0
    //   790: invokestatic 2731	com/tencent/mm/plugin/sns/model/ag:coT	()Lcom/tencent/mm/storage/bd;
    //   793: putfield 2138	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOH	Lcom/tencent/mm/storage/bd;
    //   796: aload_0
    //   797: new 2733	com/tencent/mm/plugin/sns/ui/an
    //   800: dup
    //   801: aload_0
    //   802: invokespecial 2736	com/tencent/mm/plugin/sns/ui/an:<init>	(Landroid/app/Activity;)V
    //   805: putfield 1023	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rFq	Lcom/tencent/mm/plugin/sns/ui/an;
    //   808: aload_0
    //   809: new 468	com/tencent/mm/plugin/sns/ui/aq
    //   812: dup
    //   813: aload_0
    //   814: invokevirtual 553	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   817: invokespecial 2737	com/tencent/mm/plugin/sns/ui/aq:<init>	(Landroid/content/Context;)V
    //   820: putfield 303	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOF	Lcom/tencent/mm/plugin/sns/ui/aq;
    //   823: aload_0
    //   824: new 2739	com/tencent/mm/plugin/sns/ui/j
    //   827: dup
    //   828: aload_0
    //   829: aload_0
    //   830: invokespecial 360	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   833: aload_0
    //   834: getfield 205	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPe	Lcom/tencent/mm/plugin/sns/model/ah;
    //   837: invokespecial 2742	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/af;)V
    //   840: putfield 424	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOK	Lcom/tencent/mm/plugin/sns/ui/j;
    //   843: aload_1
    //   844: ifnull +12 -> 856
    //   847: aload_0
    //   848: aload_1
    //   849: iconst_0
    //   850: invokestatic 1094	com/tencent/mm/plugin/sns/ui/av:b	(Lcom/tencent/mm/plugin/sns/storage/n;Z)I
    //   853: putfield 299	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:kwo	I
    //   856: aload_1
    //   857: ifnull +58 -> 915
    //   860: aload_1
    //   861: bipush 32
    //   863: invokevirtual 357	com/tencent/mm/plugin/sns/storage/n:Ex	(I)Z
    //   866: ifeq +49 -> 915
    //   869: aload_0
    //   870: getfield 981	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPd	I
    //   873: bipush 16
    //   875: if_icmpne +283 -> 1158
    //   878: aload_0
    //   879: new 1864	com/tencent/mm/plugin/sns/a/b/g
    //   882: dup
    //   883: iconst_2
    //   884: invokespecial 2744	com/tencent/mm/plugin/sns/a/b/g:<init>	(I)V
    //   887: putfield 1048	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOU	Lcom/tencent/mm/plugin/sns/a/b/g;
    //   890: aload_0
    //   891: getfield 1048	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOU	Lcom/tencent/mm/plugin/sns/a/b/g;
    //   894: aload_0
    //   895: getfield 2567	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   898: aload_0
    //   899: invokevirtual 2748	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   902: invokevirtual 2753	android/support/v7/app/ActionBar:getCustomView	()Landroid/view/View;
    //   905: aload_0
    //   906: invokevirtual 2756	com/tencent/mm/plugin/sns/a/b/g:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   909: aload_1
    //   910: iconst_0
    //   911: invokestatic 1094	com/tencent/mm/plugin/sns/ui/av:b	(Lcom/tencent/mm/plugin/sns/storage/n;Z)I
    //   914: pop
    //   915: aload_0
    //   916: invokevirtual 2758	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   919: aload_1
    //   920: ifnull +49 -> 969
    //   923: aload_1
    //   924: bipush 32
    //   926: invokevirtual 357	com/tencent/mm/plugin/sns/storage/n:Ex	(I)Z
    //   929: ifeq +40 -> 969
    //   932: aload_1
    //   933: invokestatic 383	com/tencent/mm/plugin/sns/model/ak:p	(Lcom/tencent/mm/plugin/sns/storage/n;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   936: astore 7
    //   938: aload_0
    //   939: getfield 1048	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOU	Lcom/tencent/mm/plugin/sns/a/b/g;
    //   942: iconst_0
    //   943: aload_1
    //   944: invokevirtual 679	com/tencent/mm/plugin/sns/storage/n:csH	()Ljava/lang/String;
    //   947: aload_1
    //   948: invokevirtual 2761	com/tencent/mm/plugin/sns/storage/n:csD	()Z
    //   951: aload_0
    //   952: getfield 1036	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOq	Landroid/view/View;
    //   955: aload_1
    //   956: getfield 1268	com/tencent/mm/plugin/sns/storage/n:field_snsId	J
    //   959: aload 7
    //   961: aload_0
    //   962: getfield 299	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:kwo	I
    //   965: iconst_2
    //   966: invokevirtual 2764	com/tencent/mm/plugin/sns/a/b/g:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   969: aload_0
    //   970: getfield 1036	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOq	Landroid/view/View;
    //   973: ifnull +86 -> 1059
    //   976: aload_1
    //   977: ifnull +82 -> 1059
    //   980: aload_0
    //   981: getfield 1036	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOq	Landroid/view/View;
    //   984: ldc_w 1752
    //   987: invokevirtual 1096	android/view/View:findViewById	(I)Landroid/view/View;
    //   990: checkcast 1754	com/tencent/mm/plugin/sight/decode/a/a
    //   993: astore 7
    //   995: iload 4
    //   997: istore_3
    //   998: aload_1
    //   999: invokevirtual 449	com/tencent/mm/plugin/sns/storage/n:csh	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1002: getfield 455	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   1005: ifnull +44 -> 1049
    //   1008: iload 4
    //   1010: istore_3
    //   1011: aload_1
    //   1012: invokevirtual 449	com/tencent/mm/plugin/sns/storage/n:csh	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1015: getfield 455	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   1018: getfield 460	com/tencent/mm/protocal/protobuf/vi:wNZ	I
    //   1021: bipush 15
    //   1023: if_icmpne +26 -> 1049
    //   1026: iload 4
    //   1028: istore_3
    //   1029: aload 7
    //   1031: instanceof 1818
    //   1034: ifeq +15 -> 1049
    //   1037: aload 7
    //   1039: checkcast 1818	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1042: getfield 2768	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:qTR	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1045: invokevirtual 2773	com/tencent/mm/plugin/sight/decode/a/b:cmA	()Z
    //   1048: istore_3
    //   1049: aload_1
    //   1050: iconst_1
    //   1051: iload_3
    //   1052: aload_0
    //   1053: invokespecial 360	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1056: invokestatic 2778	com/tencent/mm/plugin/sns/a/b/k:a	(Lcom/tencent/mm/plugin/sns/storage/n;ZZI)V
    //   1059: aload_0
    //   1060: getfield 438	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOu	Landroid/widget/ListView;
    //   1063: ifnonnull +110 -> 1173
    //   1066: ldc_w 2520
    //   1069: invokestatic 285	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1072: return
    //   1073: ldc_w 846
    //   1076: ldc_w 2780
    //   1079: invokestatic 1082	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1082: goto -532 -> 550
    //   1085: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   1088: pop
    //   1089: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   1092: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   1095: new 2714	com/tencent/mm/plugin/sns/model/q
    //   1098: dup
    //   1099: aload_0
    //   1100: getfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   1103: invokestatic 2718	com/tencent/mm/plugin/sns/storage/v:abO	(Ljava/lang/String;)J
    //   1106: invokespecial 2720	com/tencent/mm/plugin/sns/model/q:<init>	(J)V
    //   1109: iconst_0
    //   1110: invokevirtual 2725	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;I)Z
    //   1113: pop
    //   1114: goto -427 -> 687
    //   1117: invokestatic 1158	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   1120: pop
    //   1121: invokestatic 2706	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   1124: getfield 2712	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   1127: new 2782	com/tencent/mm/plugin/sns/model/m
    //   1130: dup
    //   1131: aload_0
    //   1132: getfield 328	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:czw	Ljava/lang/String;
    //   1135: invokestatic 2718	com/tencent/mm/plugin/sns/storage/v:abO	(Ljava/lang/String;)J
    //   1138: iconst_0
    //   1139: aload_0
    //   1140: aload_1
    //   1141: invokespecial 1277	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:f	(Lcom/tencent/mm/plugin/sns/storage/n;)Lcom/tencent/mm/plugin/sns/storage/a;
    //   1144: getfield 2785	com/tencent/mm/plugin/sns/storage/a:rpE	Ljava/lang/String;
    //   1147: invokespecial 2788	com/tencent/mm/plugin/sns/model/m:<init>	(JILjava/lang/String;)V
    //   1150: iconst_0
    //   1151: invokevirtual 2725	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;I)Z
    //   1154: pop
    //   1155: goto -468 -> 687
    //   1158: aload_0
    //   1159: new 1864	com/tencent/mm/plugin/sns/a/b/g
    //   1162: dup
    //   1163: iconst_1
    //   1164: invokespecial 2744	com/tencent/mm/plugin/sns/a/b/g:<init>	(I)V
    //   1167: putfield 1048	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOU	Lcom/tencent/mm/plugin/sns/a/b/g;
    //   1170: goto -280 -> 890
    //   1173: aload_0
    //   1174: getfield 438	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rOu	Landroid/widget/ListView;
    //   1177: new 2790	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5
    //   1180: dup
    //   1181: aload_0
    //   1182: invokespecial 2791	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1185: invokevirtual 2792	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1188: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1191: aload_0
    //   1192: getfield 260	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hCe	Lcom/tencent/mm/sdk/b/c;
    //   1195: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1198: pop
    //   1199: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1202: aload_0
    //   1203: getfield 212	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPf	Lcom/tencent/mm/sdk/b/c;
    //   1206: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1209: pop
    //   1210: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1213: aload_0
    //   1214: getfield 217	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPg	Lcom/tencent/mm/sdk/b/c;
    //   1217: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1220: pop
    //   1221: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1224: aload_0
    //   1225: getfield 222	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPh	Lcom/tencent/mm/sdk/b/c;
    //   1228: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1231: pop
    //   1232: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1235: aload_0
    //   1236: getfield 227	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPi	Lcom/tencent/mm/sdk/b/c;
    //   1239: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1242: pop
    //   1243: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1246: aload_0
    //   1247: getfield 255	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPl	Lcom/tencent/mm/sdk/b/c;
    //   1250: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1253: pop
    //   1254: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1257: aload_0
    //   1258: getfield 265	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rPm	Lcom/tencent/mm/sdk/b/c;
    //   1261: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1264: pop
    //   1265: getstatic 2433	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   1268: aload_0
    //   1269: getfield 232	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rFB	Lcom/tencent/mm/sdk/b/c;
    //   1272: invokevirtual 2795	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1275: pop
    //   1276: aload_0
    //   1277: invokestatic 2797	com/tencent/mm/pluginsdk/f:n	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1280: ldc_w 2520
    //   1283: invokestatic 285	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1286: return
    //   1287: astore_1
    //   1288: goto -738 -> 550
    //   1291: astore 7
    //   1293: goto -776 -> 517
    //   1296: astore 8
    //   1298: goto -845 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1301	0	this	SnsCommentDetailUI
    //   0	1301	1	paramBundle	android.os.Bundle
    //   196	11	2	i	int
    //   997	55	3	bool1	boolean
    //   1	1026	4	bool2	boolean
    //   351	190	5	l	long
    //   375	663	7	localObject	Object
    //   1291	1	7	localIOException	java.io.IOException
    //   1296	1	8	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   377	384	1287	java/io/IOException
    //   508	517	1291	java/io/IOException
    //   444	453	1296	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38840);
    ag.coV().a(this, 5);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(210, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(218, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(213, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(214, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(683, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(682, this);
    ag.cpc().ah(this);
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    if (this.rOK != null) {
      this.rOK.activity = null;
    }
    aa.ctL();
    if (this.rFo != null) {
      this.rFo.bOo();
    }
    n localn = lB(false);
    Object localObject;
    if ((localn != null) && (localn.Ex(32)))
    {
      if (this.rOU != null) {
        this.rOU.k(0, localn.csH(), 2);
      }
      localObject = f(localn);
      if (localObject != null) {
        break label448;
      }
      localObject = "";
      if (!localn.cqx()) {
        break label456;
      }
      ag.coZ().e(14652, new Object[] { com.tencent.mm.plugin.sns.a.b.f.a(localn.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId), localObject, Long.valueOf(this.rOo), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      com.tencent.mm.modelsns.b localb = com.tencent.mm.modelsns.b.lW(732);
      localb.uv(com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId)).uv((String)localObject).uv(this.rOo).uv(System.currentTimeMillis());
      localb.ake();
      this.rOV.removeListener();
      com.tencent.mm.sdk.b.a.ymk.d(this.rPf);
      com.tencent.mm.sdk.b.a.ymk.d(this.rPg);
      com.tencent.mm.sdk.b.a.ymk.d(this.rPh);
      com.tencent.mm.sdk.b.a.ymk.d(this.rPi);
      com.tencent.mm.sdk.b.a.ymk.d(this.rPl);
      com.tencent.mm.sdk.b.a.ymk.d(this.rPm);
      com.tencent.mm.sdk.b.a.ymk.d(this.rFB);
      super.onDestroy();
      AppMethodBeat.o(38840);
      return;
      label448:
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).cFe;
      break;
      label456:
      ag.coZ().e(12012, new Object[] { com.tencent.mm.plugin.sns.a.b.f.a(localn.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId), localObject, Long.valueOf(this.rOo), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(38855);
    if (keyboardState() == 2)
    {
      ab.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.rOE = false;
      AppMethodBeat.o(38855);
      return;
    }
    if (keyboardState() == 1)
    {
      ab.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      cuX();
      this.rFm = false;
      this.rPj.run();
      if (this.rFw != null) {
        this.rFw.cpX();
      }
    }
    AppMethodBeat.o(38855);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38842);
    ag.cpa().b(this);
    super.onPause();
    SnsCommentFooter localSnsCommentFooter = this.rFo;
    if (localSnsCommentFooter.eys != null) {
      localSnsCommentFooter.eys.onPause();
    }
    new ua().cKz.type = 1;
    if (this.rOU != null) {
      this.rOU.onPause();
    }
    AppMethodBeat.o(38842);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38841);
    ag.cpa().a(this);
    ua localua = new ua();
    localua.cKz.cKA = 0;
    localua.cKz.cKB = 1;
    localua.cKz.cKC = 0;
    localua.cKz.type = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localua);
    if (this.rOU != null) {
      this.rOU.onResume();
    }
    if (this.rOT != null) {
      this.rOT.refreshView();
    }
    super.onResume();
    AppMethodBeat.o(38841);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(38854);
    if ((paramm.getType() == 218) && (this.rFz != null)) {
      this.rFz.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = com.tencent.mm.plugin.sns.storage.h.abu(this.czw);
      if (paramm == null)
      {
        ab.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.czw);
        finish();
        AppMethodBeat.o(38854);
        return;
      }
      ab.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.czw + "  username:" + paramm.field_userName);
      if (this.rOq == null)
      {
        ab.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(38854);
        return;
      }
      cuW();
      paramString = com.tencent.mm.plugin.sns.model.ak.p(paramm);
      ab.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(38854);
        return;
      }
      if (!f(this.rOC, paramString.LikeUserList))
      {
        g(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.rOC = paramString.LikeUserList;
      }
      if (this.rOt != null) {
        this.rOt.a(paramm, this.rOV);
      }
      paramm = this.rOx;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      paramm.rPQ = localLinkedList;
      paramm.rPR = paramString;
      this.rOx.notifyDataSetChanged();
      paramString = this.rOx;
      new com.tencent.mm.sdk.platformtools.ak().postDelayed(new SnsCommentDetailUI.b.1(paramString), 60L);
    }
    AppMethodBeat.o(38854);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */