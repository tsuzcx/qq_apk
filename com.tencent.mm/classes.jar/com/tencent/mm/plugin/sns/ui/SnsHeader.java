package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.nq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.bs;
import com.tencent.mm.plugin.findersdk.a.bs.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.cover.preview.SnsCoverContainerLayout;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.sns.ui.widget.h.c;
import com.tencent.mm.plugin.sns.ui.widget.h.d;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMOverScrollView;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.ah;

public class SnsHeader
  extends LinearLayout
{
  private View PVa;
  private String QEN;
  private q QlO;
  Animation ReN;
  c Rrg;
  private a Rrh;
  private b Rri;
  private long Rrj;
  private boolean Rrk;
  boolean Rrl;
  private boolean Rrm;
  private Map<Integer, View> Rrn;
  private String Rro;
  Bitmap Rrp;
  boolean Rrq;
  com.tencent.mm.plugin.sns.ui.widget.h Rrr;
  private ListView Rrs;
  Boolean Rrt;
  Context context;
  boolean hHq;
  String ltf;
  boolean maT;
  private String sessionId;
  private int type;
  String userName;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98715);
    this.Rrj = 0L;
    this.Rrk = false;
    this.hHq = false;
    this.Rrl = false;
    this.maT = false;
    this.Rrm = true;
    this.Rrn = new HashMap();
    this.Rro = "";
    this.Rrp = null;
    this.ReN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.Rrq = false;
    this.Rrt = Boolean.FALSE;
    init(paramContext);
    AppMethodBeat.o(98715);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98716);
    this.Rrj = 0L;
    this.Rrk = false;
    this.hHq = false;
    this.Rrl = false;
    this.maT = false;
    this.Rrm = true;
    this.Rrn = new HashMap();
    this.Rro = "";
    this.Rrp = null;
    this.ReN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.Rrq = false;
    this.Rrt = Boolean.FALSE;
    init(paramContext);
    AppMethodBeat.o(98716);
  }
  
  private static boolean hoC()
  {
    boolean bool3 = true;
    AppMethodBeat.i(307587);
    boolean bool1;
    boolean bool2;
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLF, 1) == 1)
    {
      bool1 = true;
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        bool1 = true;
      }
      if (!bool1) {
        break label173;
      }
      if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE())) {
        break label163;
      }
      bool2 = true;
      label92:
      boolean bool4 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
      if ((!bool4) || (bool2)) {
        break label168;
      }
      bool1 = bool3;
      label117:
      Log.i("MicroMsg.SnsHeader", "timeline_live_list_show " + bool2 + "," + bool4);
    }
    label163:
    label168:
    label173:
    for (;;)
    {
      AppMethodBeat.o(307587);
      return bool1;
      bool1 = false;
      break;
      bool2 = false;
      break label92;
      bool1 = false;
      break label117;
    }
  }
  
  private void hoD()
  {
    AppMethodBeat.i(307592);
    Log.i("MicroMsg.SnsHeader", "updateLikeInfo: ");
    if ((this.QlO != null) && (this.QlO.field_isLike))
    {
      this.Rrg.RrJ.setImageResource(b.i.icons_filled_like);
      this.Rrg.RrJ.setIconColor(this.context.getResources().getColor(b.c.Red));
      AppMethodBeat.o(307592);
      return;
    }
    this.Rrg.RrJ.setImageResource(b.i.icons_outlined_like);
    this.Rrg.RrJ.setIconColor(this.context.getResources().getColor(b.c.White));
    AppMethodBeat.o(307592);
  }
  
  private boolean hoE()
  {
    AppMethodBeat.i(307594);
    if ((!this.Rrl) && (!this.Rrm) && (this.QlO.field_type != 5) && (ab.IR(this.userName)))
    {
      AppMethodBeat.o(307594);
      return true;
    }
    AppMethodBeat.o(307594);
    return false;
  }
  
  private void hoF()
  {
    AppMethodBeat.i(307596);
    if (this.PVa != null) {
      this.PVa.animate().translationY(0.0F).start();
    }
    AppMethodBeat.o(307596);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(98721);
    this.context = paramContext;
    com.tencent.mm.kernel.h.baF();
    this.Rrq = ((e)com.tencent.mm.kernel.h.az(e.class)).getStoryNewFeatureConfig().huS();
    Object localObject = af.mU(paramContext).inflate(b.g.sns_header_item2, this, true);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject).findViewById(b.f.sns_story_header_container);
    this.Rrg = new c();
    this.Rrg.vgb = ((TextView)((View)localObject).findViewById(b.f.nickname_tv));
    this.Rrg.lKK = ((ImageView)((View)localObject).findViewById(b.f.avatar_iv));
    this.Rrg.pJK = ((TextView)((View)localObject).findViewById(b.f.openim_desc_tv));
    this.Rrg.RaR = ((TextView)((View)localObject).findViewById(b.f.sign_tv));
    this.Rrg.Rrx = ((LinearLayout)((View)localObject).findViewById(b.f.setting_bg));
    this.Rrg.Rry = ((LinearLayout)((View)localObject).findViewById(b.f.sns_error_list));
    this.Rrg.RrB = ((RelativeLayout)((View)localObject).findViewById(b.f.sns_header_group));
    this.Rrg.RrC = ((LinearLayout)((View)localObject).findViewById(b.f.sns_header_loading_group));
    this.Rrg.RrD = ((ImageView)((View)localObject).findViewById(b.f.sns_header_next_progress));
    this.Rrg.RrF = ((ViewGroup)((View)localObject).findViewById(b.f.sns_finder_live_list_container));
    this.Rrg.RrG = ((SnsCoverContainerLayout)((View)localObject).findViewById(b.f.sns_back_rl));
    this.Rrg.RrH = ((ViewGroup)((View)localObject).findViewById(b.f.sns_change_cover_ll));
    ((View)localObject).findViewById(b.f.sns_change_cover_ll).setContentDescription(paramContext.getString(b.j.sns_change_cover));
    ((View)localObject).findViewById(b.f.sns_change_cover_ll).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307965);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SnsHeader.this.hoH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(307965);
      }
    });
    this.Rrg.RrG.setCoverClickListener(new kotlin.g.a.a() {});
    this.Rrg.RrG.setOnViewSizeChanged(new kotlin.g.a.m() {});
    this.Rrg.RrI = ((ViewGroup)((View)localObject).findViewById(b.f.sns_cover_like_layout));
    this.Rrg.RrJ = ((WeImageView)((View)localObject).findViewById(b.f.sns_cover_like_icon));
    this.Rrg.RrI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307593);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsHeader$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((SnsHeader.g(SnsHeader.this) != null) && (SnsHeader.h(SnsHeader.this) != null))
        {
          if (!SnsHeader.g(SnsHeader.this).field_isLike) {
            break label157;
          }
          com.tencent.mm.plugin.sns.statistics.j.QFS.akY(5);
          paramAnonymousView = SnsHeader.g(SnsHeader.this);
          if (SnsHeader.g(SnsHeader.this).field_isLike) {
            break label167;
          }
        }
        label157:
        label167:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.field_isLike = bool;
          SnsHeader.h(SnsHeader.this).W(SnsHeader.i(SnsHeader.this), SnsHeader.g(SnsHeader.this).field_isLike);
          SnsHeader.j(SnsHeader.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307593);
          return;
          com.tencent.mm.plugin.sns.statistics.j.QFS.akY(3);
          break;
        }
      }
    });
    this.ReN.setDuration(1000L);
    this.ReN.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.ReN.setInterpolator((Interpolator)localObject);
    if (!ac.hFS())
    {
      localObject = this.Rrg;
      com.tencent.mm.kernel.h.baF();
      ((c)localObject).Rrz = ((e)com.tencent.mm.kernel.h.az(e.class)).getStoryUIFactory().jZ(paramContext);
      this.Rrg.RrA = new SnsStoryHeaderView(paramContext);
      if (!this.Rrq) {
        break label591;
      }
      localFrameLayout.addView(this.Rrg.Rrz);
      this.Rrg.Rrz.onCreateView();
    }
    for (;;)
    {
      this.Rrg.lKK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(307589);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsHeader$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = al.hgp().JE(SnsHeader.k(SnsHeader.this));
          int i;
          if ((paramAnonymousView != null) && ((com.tencent.mm.contact.d.rs(paramAnonymousView.field_type)) || (SnsHeader.l(SnsHeader.this))))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.k(SnsHeader.this));
            if ((SnsHeader.k(SnsHeader.this) != null) && (SnsHeader.k(SnsHeader.this).length() > 0))
            {
              if (SnsHeader.m(SnsHeader.this) != 1) {
                break label172;
              }
              i = 6;
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", i);
              com.tencent.mm.plugin.sns.d.a.pFn.c(paramAnonymousView, paramContext);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(307589);
            return;
            label172:
            i = 1;
            break;
            paramAnonymousView = ((Activity)paramContext).getIntent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.k(SnsHeader.this));
            com.tencent.mm.plugin.sns.d.a.pFn.c(paramAnonymousView, paramContext);
          }
        }
      });
      if (((Activity)paramContext).getIntent().getBooleanExtra("sns_timeline_NeedShowChangeAlbumDialog", false)) {
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(308264);
            Log.i("MicroMsg.SnsHeader", "needShowChangeAlbumDialog = true");
            if (SnsHeader.e(SnsHeader.this) != null) {
              SnsHeader.f(SnsHeader.this);
            }
            AppMethodBeat.o(308264);
          }
        }, 150L);
      }
      getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(308258);
          SnsHeader.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          if (SnsHeader.a(SnsHeader.this).RrG.getHeight() > SnsHeader.a(SnsHeader.this).RrG.getWidth())
          {
            ViewGroup.LayoutParams localLayoutParams = SnsHeader.a(SnsHeader.this).RrG.getLayoutParams();
            localLayoutParams.height = SnsHeader.a(SnsHeader.this).RrG.getWidth();
            SnsHeader.a(SnsHeader.this).RrG.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(308258);
        }
      });
      AppMethodBeat.o(98721);
      return;
      label591:
      localFrameLayout.addView(this.Rrg.RrA);
      this.Rrg.RrA.setSessionId(this.sessionId);
      this.Rrg.RrA.setEnterObjectId(this.QEN);
    }
  }
  
  public final void a(int paramInt, final SnsUIAction paramSnsUIAction)
  {
    AppMethodBeat.i(307630);
    this.Rrr = paramSnsUIAction.RCE;
    this.Rrs = paramSnsUIAction.list;
    Object localObject = (ViewGroup.MarginLayoutParams)((ViewGroup)paramSnsUIAction.RCD.getParent()).getLayoutParams();
    if (localObject != null) {
      this.Rrg.RrG.setExternalMargin(((ViewGroup.MarginLayoutParams)localObject).topMargin);
    }
    paramSnsUIAction.RCF.a(new h.d()
    {
      public final void bO(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        int i = 1;
        int j = 0;
        AppMethodBeat.i(307979);
        Log.i("MicroMsg.SnsHeader", "onOpenStateChange: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(307979);
          return;
          SnsHeader.a(SnsHeader.this).RrG.onPostClose();
          SnsHeader.a(SnsHeader.this, 0.0F);
          AppMethodBeat.o(307979);
          return;
          Object localObject1 = SnsHeader.a(SnsHeader.this).RrG;
          Log.i("MicroMsg.SnsCoverContainerLayout", "[" + ((SnsCoverContainerLayout)localObject1).hashCode() + "] onPostOpen");
          ((SnsCoverContainerLayout)localObject1).QlH.evb = false;
          localObject1 = ((SnsCoverContainerLayout)localObject1).QlE;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).etO();
          }
          SnsHeader.a(SnsHeader.this, 1.0F);
          AppMethodBeat.o(307979);
          return;
          localObject1 = SnsHeader.a(SnsHeader.this).RrG;
          Log.i("MicroMsg.SnsCoverContainerLayout", "[" + ((SnsCoverContainerLayout)localObject1).hashCode() + "] onPreOpen");
          ((SnsCoverContainerLayout)localObject1).QlG.setVisibility(4);
          Object localObject2 = ((SnsCoverContainerLayout)localObject1).QlE;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.sns.cover.a.a)localObject2).etL();
          }
          localObject1 = ((SnsCoverContainerLayout)localObject1).QlQ;
          localObject2 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
          if (localObject2 == null)
          {
            paramAnonymousInt = j;
            if (paramAnonymousInt > 0) {
              break label328;
            }
            localObject1 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
            if (localObject1 != null) {
              ((nq)localObject1).jfG = 1;
            }
          }
          label328:
          do
          {
            if (paramAnonymousBoolean) {
              SnsHeader.b(SnsHeader.this);
            }
            SnsHeader.c(SnsHeader.this);
            AppMethodBeat.o(307979);
            return;
            paramAnonymousInt = ((nq)localObject2).jfG;
            break;
            localObject2 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
          } while (localObject2 == null);
          localObject1 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
          if (localObject1 == null) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = ((nq)localObject1).jfG)
          {
            ((nq)localObject2).jfG = paramAnonymousInt;
            break;
          }
          SnsHeader.a(SnsHeader.this).RrG.etM();
          SnsHeader.d(SnsHeader.this);
        }
      }
      
      public final void v(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(307982);
        if (paramAnonymousBoolean)
        {
          AppMethodBeat.o(307982);
          return;
        }
        float f2 = -paramAnonymousInt2 * 1.0F / SnsHeader.e(SnsHeader.this).RVA;
        if (f2 > 1.0F) {}
        for (;;)
        {
          SnsHeader.a(SnsHeader.this).RrG.dj(f1);
          SnsHeader.a(SnsHeader.this, f1);
          AppMethodBeat.o(307982);
          return;
          if (f2 < 0.0F) {
            f1 = 0.0F;
          } else {
            f1 = f2;
          }
        }
      }
    });
    localObject = this.Rrg.RrG;
    int i;
    if (!this.Rrr.RXw)
    {
      i = 1;
      if (i == 0) {
        ((SnsCoverContainerLayout)localObject).removeView(((SnsCoverContainerLayout)localObject).QlG);
      }
      this.type = paramInt;
      if ((paramInt == 1) && (this.Rrg.RaR != null)) {
        this.Rrg.RaR.setVisibility(8);
      }
      if (this.Rrg != null)
      {
        if ((this.Rrg.Rrz != null) && (this.Rrq)) {
          this.Rrg.Rrz.setSnsType(paramInt);
        }
        if ((this.Rrg.RrA != null) && (!this.Rrq)) {
          this.Rrg.RrA.setSnsType(paramInt);
        }
      }
      if (paramInt != 1)
      {
        if ((this.Rrg.Rrz != null) && (this.Rrg.Rrz.getParent() != null) && ((this.Rrg.Rrz.getParent() instanceof ViewGroup))) {
          ((ViewGroup)this.Rrg.Rrz.getParent()).removeView(this.Rrg.Rrz);
        }
        if ((this.Rrg.RrA != null) && (this.Rrg.RrA.getParent() != null) && ((this.Rrg.RrA.getParent() instanceof ViewGroup))) {
          ((ViewGroup)this.Rrg.RrA.getParent()).removeView(this.Rrg.RrA);
        }
      }
      if (paramInt != 1) {
        break label537;
      }
      this.Rrg.RrC.setPadding(0, bf.fs(this.context) + bf.bk(this.context) - getResources().getDimensionPixelSize(b.d.sns_timeline_top_margin), 0, bd.fromDPToPix(this.context, 10));
    }
    for (;;)
    {
      if ((paramInt == 1) && (this.Rrg != null) && (this.Rrg.RrF != null))
      {
        if (hoC())
        {
          this.Rrg.RrE = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().aP((Activity)this.context);
          localObject = this.Rrg.RrE.flh();
          this.Rrg.RrF.addView((View)localObject, new FrameLayout.LayoutParams(-1, -2));
          this.Rrg.RrE.a(new bs.a()
          {
            public final void onVisibilityChanged(int paramAnonymousInt)
            {
              AppMethodBeat.i(307948);
              if (SnsHeader.a(SnsHeader.this).RrA != null)
              {
                if (paramAnonymousInt == 0)
                {
                  SnsHeader.a(SnsHeader.this).RrA.setTopLineVisibility(8);
                  AppMethodBeat.o(307948);
                  return;
                }
                SnsHeader.a(SnsHeader.this).RrA.setTopLineVisibility(0);
              }
              AppMethodBeat.o(307948);
            }
            
            public final void vt(boolean paramAnonymousBoolean)
            {
              if (paramSnsUIAction.RCD != null) {
                paramSnsUIAction.RCD.adSi = paramAnonymousBoolean;
              }
            }
          });
          if (this.Rrg.RrA != null) {
            this.Rrg.RrA.setTopLineVisibility(0);
          }
          AppMethodBeat.o(307630);
          return;
          i = 0;
          break;
          label537:
          if (paramInt != 2) {
            continue;
          }
          this.Rrg.RrC.setPadding(0, bf.fs(this.context) + bf.bk(this.context) + bd.fromDPToPix(getContext(), 90) + bd.fromDPToPix(getContext(), 48), 0, 0);
          continue;
        }
        this.Rrg.RrF.setPadding(0, (int)this.context.getResources().getDimension(b.d.Edge_4A), 0, 0);
        if (this.Rrg.RrA != null) {
          this.Rrg.RrA.setTopLineVisibility(0);
        }
        Log.i("MicroMsg.SnsHeader", "disable finderSnsHeader");
      }
    }
    AppMethodBeat.o(307630);
  }
  
  public final void a(q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(307647);
    com.tencent.mm.plugin.sns.ui.widget.h.a(this.Rrr);
    this.QlO = paramq;
    this.Rrj = paramq.field_snsBgId;
    boolean bool1;
    if (this.QlO == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.Rrm = bool1;
      if (this.Rrm) {
        this.Rrr.RXw = false;
      }
      hoD();
      this.Rrg.RrG.onPostClose();
      this.Rrg.RrG.a(paramq);
      AppMethodBeat.o(307647);
      return;
      if (this.maT)
      {
        bool1 = bool2;
        if (!Util.isNullOrNil(this.QlO.QYH))
        {
          bool1 = bool2;
          if (!Util.isEqual(this.QlO.QYH, "0")) {
            bool1 = false;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (this.QlO.field_snsBgId != 0L) {
          bool1 = false;
        }
      }
    }
  }
  
  public View getFinderSnsRecyclerView()
  {
    AppMethodBeat.i(307632);
    if ((this.Rrg != null) && (this.Rrg.RrE != null))
    {
      View localView = this.Rrg.RrE.fli();
      AppMethodBeat.o(307632);
      return localView;
    }
    AppMethodBeat.o(307632);
    return null;
  }
  
  public int getLoadingGroupHeight()
  {
    AppMethodBeat.i(307666);
    int j = 0;
    int i = j;
    if (this.Rrg != null)
    {
      i = j;
      if (this.Rrg.RrC != null) {
        i = this.Rrg.RrC.getHeight() + bd.fromDPToPix(getContext(), 32);
      }
    }
    AppMethodBeat.o(307666);
    return i;
  }
  
  public c getViewHeader()
  {
    return this.Rrg;
  }
  
  public final boolean hoG()
  {
    AppMethodBeat.i(98724);
    if (this.Rrg.Rry == null)
    {
      AppMethodBeat.o(98724);
      return false;
    }
    Object localObject = ap.hhc();
    LinkedList localLinkedList = new LinkedList();
    final int i = 0;
    SnsInfo localSnsInfo1;
    boolean bool;
    for (;;)
    {
      if (i >= ((List)localObject).size()) {
        break label114;
      }
      localSnsInfo1 = (SnsInfo)((List)localObject).get(i);
      try
      {
        bool = ((dna)new dna().parseFrom(localSnsInfo1.field_postBuf)).aaTX;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localLinkedList.add(localSnsInfo1);
        }
      }
      i += 1;
    }
    label114:
    localObject = "";
    i = 0;
    for (;;)
    {
      if (i >= localLinkedList.size()) {
        break label224;
      }
      localSnsInfo1 = (SnsInfo)localLinkedList.get(i);
      try
      {
        bool = ((dna)new dna().parseFrom(localSnsInfo1.field_postBuf)).aaTX;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject = (String)localObject + ((SnsInfo)localLinkedList.get(i)).getLocalid() + " ";
        }
      }
      i += 1;
    }
    label224:
    Log.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.Rro });
    if (((String)localObject).equals(this.Rro))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(98724);
        return true;
      }
      AppMethodBeat.o(98724);
      return false;
    }
    this.Rro = ((String)localObject);
    this.Rrg.Rry.removeAllViews();
    localObject = this.Rrg.Rry;
    label358:
    int j;
    final int k;
    label442:
    SnsInfo localSnsInfo2;
    TextView localTextView;
    if (localLinkedList.size() > 0)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      Collections.sort(localLinkedList, new d());
      i = 0;
      if (i >= localLinkedList.size()) {
        break label691;
      }
      j = ((SnsInfo)localLinkedList.get(i)).localid;
      k = localLinkedList.size();
      if ((!this.Rrn.containsKey(Integer.valueOf(j))) || (this.Rrn.get(Integer.valueOf(j)) == null)) {
        break label541;
      }
      localObject = (View)this.Rrn.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((SnsInfo)localLinkedList.get(i)).getLocalid());
      localSnsInfo2 = (SnsInfo)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(b.f.sns_notify_tips2);
      if (localSnsInfo2.getTypeFlag() != 15) {
        break label598;
      }
      localTextView.setText(b.j.sns_post_sight_error);
    }
    for (;;)
    {
      this.Rrg.Rry.addView((View)localObject);
      i += 1;
      break label358;
      i = 8;
      break;
      label541:
      localObject = (LinearLayout)af.mU(this.context).inflate(b.g.header_error_list, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(307975);
          Object localObject1 = new b();
          ((b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsHeader$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            Log.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = al.hgB().aZL((String)localObject2);
            if ((SnsHeader.n(SnsHeader.this) != null) && (paramAnonymousView != null))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).setClass(SnsHeader.n(SnsHeader.this), SnsCommentDetailUI.class);
              if ((paramAnonymousView == null) || (paramAnonymousView.getUserName() == null) || (paramAnonymousView.getUserName().equals("")))
              {
                Log.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(307975);
                return;
              }
              ((Intent)localObject1).putExtra("INTENT_TALKER", paramAnonymousView.getUserName());
              ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
              ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
              localObject2 = l.wO(726);
              ((l)localObject2).wR(k).wR(i).wR(paramAnonymousView.getCreateTime());
              ((l)localObject2).bMH();
              localObject2 = SnsHeader.n(SnsHeader.this);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/sns/ui/SnsHeader$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/SnsHeader$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          try
          {
            localObject1 = (dna)new dna().parseFrom(paramAnonymousView.field_postBuf);
            if ((((dna)localObject1).aaTP == 201) || (((dna)localObject1).aaTP == 210) || (((dna)localObject1).aaTP != 211))
            {
              ((dna)localObject1).aaTX = true;
              paramAnonymousView.setPostBuf(((dna)localObject1).toByteArray());
              al.hgB().f(paramAnonymousView.localid, paramAnonymousView);
            }
          }
          catch (Exception paramAnonymousView)
          {
            label361:
            break label361;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307975);
        }
      });
      this.Rrn.put(Integer.valueOf(j), localObject);
      break label442;
      label598:
      if (localSnsInfo2.getTypeFlag() == 2) {
        localTextView.setText(b.j.sns_post_text_error);
      } else if (localSnsInfo2.getTypeFlag() == 1) {
        localTextView.setText(b.j.sns_post_error);
      } else if (localSnsInfo2.getTypeFlag() == 26) {
        localTextView.setText(b.j.sns_post_note_error);
      } else if (localSnsInfo2.getTypeFlag() == 28) {
        localTextView.setText(b.j.sns_post_finder_media_error);
      } else {
        localTextView.setText(b.j.sns_post_link_error);
      }
    }
    label691:
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(98724);
      return true;
    }
    AppMethodBeat.o(98724);
    return false;
  }
  
  public final void hoH()
  {
    AppMethodBeat.i(307663);
    if (!this.hHq)
    {
      AppMethodBeat.o(307663);
      return;
    }
    if (this.Rrh != null) {
      this.Rrh.hoI();
    }
    AppMethodBeat.o(307663);
  }
  
  public final boolean jI(View paramView)
  {
    AppMethodBeat.i(307637);
    View localView = getFinderSnsRecyclerView();
    if (localView == null)
    {
      AppMethodBeat.o(307637);
      return false;
    }
    Rect localRect;
    if (localView.getVisibility() == 0)
    {
      i = 1;
      if (i == 0) {
        break label131;
      }
      localRect = new Rect();
      if (!paramView.getGlobalVisibleRect(localRect)) {
        break label139;
      }
    }
    label131:
    label139:
    for (int i = localRect.bottom;; i = 0)
    {
      paramView = new Rect();
      boolean bool = localView.getGlobalVisibleRect(paramView);
      int j = (int)(paramView.bottom - this.context.getResources().getDimension(b.d.Edge_2A));
      if ((bool) && (j > i))
      {
        AppMethodBeat.o(307637);
        return true;
        i = 0;
        break;
      }
      AppMethodBeat.o(307637);
      return false;
      AppMethodBeat.o(307637);
      return false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(307650);
    if (!this.Rrg.RrG.getStatus().evb)
    {
      this.Rrg.RrG.etM();
      hoF();
      this.Rrg.RrG.onPostClose();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(307650);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(98725);
    if ((this.Rrg != null) && (this.Rrg.Rrz != null) && (this.Rrq)) {
      this.Rrg.Rrz.huF();
    }
    Object localObject;
    if ((this.Rrg != null) && (this.Rrg.RrA != null) && (!this.Rrq))
    {
      localObject = this.Rrg.RrA;
      Log.i("MicroMsg.SnsStoryHeaderView", "resume: ");
      ((SnsStoryHeaderView)localObject).hJi = false;
      ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().hva();
      ((SnsStoryHeaderView)localObject).post(new SnsStoryHeaderView.2((SnsStoryHeaderView)localObject));
    }
    if ((this.Rrg != null) && (this.Rrg.RrG != null))
    {
      localObject = this.Rrg.RrG;
      Log.i("MicroMsg.SnsCoverContainerLayout", "[" + ((SnsCoverContainerLayout)localObject).hashCode() + "] onResume");
      localObject = ((SnsCoverContainerLayout)localObject).QlE;
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.cover.a.a)localObject).onResume();
      }
    }
    if ((this.type == 1) && (this.Rrg != null) && (this.Rrg.RrF != null) && (this.Rrg.RrE != null))
    {
      if (!hoC())
      {
        this.Rrg.RrF.removeAllViews();
        this.Rrg.RrF.setPadding(0, (int)this.context.getResources().getDimension(b.d.Edge_4A), 0, 0);
        if (this.Rrg.RrA != null) {
          this.Rrg.RrA.setTopLineVisibility(0);
        }
        Log.i("MicroMsg.SnsHeader", "disable2 finderSnsHeader");
        AppMethodBeat.o(98725);
        return;
      }
      this.Rrg.RrE.flj();
    }
    AppMethodBeat.o(98725);
  }
  
  public void setActionBarView(View paramView)
  {
    this.PVa = paramView;
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98722);
    if ((this.Rrg != null) && (this.Rrg.lKK != null)) {
      this.Rrg.lKK.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98722);
  }
  
  public void setBackClickListener(a parama)
  {
    this.Rrh = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(98720);
    this.QEN = paramString;
    if ((this.Rrg != null) && (this.Rrg.RrA != null) && (!this.Rrq)) {
      this.Rrg.RrA.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(98720);
  }
  
  public void setHeadBgListener(b paramb)
  {
    this.Rri = paramb;
  }
  
  public void setIsCoverPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(307669);
    this.Rrt = Boolean.valueOf(paramBoolean);
    this.Rrg.RrG.setPreview(paramBoolean);
    AppMethodBeat.o(307669);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(98719);
    this.sessionId = paramString;
    if ((this.Rrg != null) && (this.Rrg.RrA != null) && (!this.Rrq)) {
      this.Rrg.RrA.setSessionId(paramString);
    }
    AppMethodBeat.o(98719);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(98718);
    if ((this.Rrg != null) && (this.Rrg.RrA != null) && (!this.Rrq)) {
      this.Rrg.RrA.setStoryAction(parama);
    }
    AppMethodBeat.o(98718);
  }
  
  public static abstract interface a
  {
    public abstract boolean W(long paramLong, boolean paramBoolean);
    
    public abstract void hoI();
  }
  
  public static abstract interface b {}
  
  class c
  {
    TextView RaR;
    SnsStoryHeaderView RrA;
    RelativeLayout RrB;
    LinearLayout RrC;
    ImageView RrD;
    bs RrE;
    ViewGroup RrF;
    SnsCoverContainerLayout RrG;
    ViewGroup RrH;
    ViewGroup RrI;
    WeImageView RrJ;
    LinearLayout Rrx;
    LinearLayout Rry;
    AbsStoryHeaderTipView Rrz;
    ImageView lKK;
    TextView pJK;
    TextView vgb;
    
    c() {}
  }
  
  final class d
    implements Comparator<SnsInfo>
  {
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader
 * JD-Core Version:    0.7.0.1
 */