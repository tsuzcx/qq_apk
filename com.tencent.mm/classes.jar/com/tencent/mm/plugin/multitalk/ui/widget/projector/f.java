package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.h;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.b;
import com.tencent.xweb.h.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.a.m;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "mCurrentIndex", "setMCurrentIndex", "(I)V", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "mCurrentViewStatus", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFileExt", "", "mFilePath", "setMFilePath", "(Ljava/lang/String;)V", "mMaxCount", "setMMaxCount", "mReaderLayout", "Landroid/widget/RelativeLayout;", "getMReaderLayout", "()Landroid/widget/RelativeLayout;", "setMReaderLayout", "(Landroid/widget/RelativeLayout;)V", "mThumbnailHasBeenRequest", "", "mToken", "setMToken", "thumbUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "getThumbUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "setThumbUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;)V", "thumbnailRoot", "Landroid/widget/FrameLayout;", "getThumbnailRoot", "()Landroid/widget/FrameLayout;", "setThumbnailRoot", "(Landroid/widget/FrameLayout;)V", "applyReaderUI", "", "applyThumbnailUI", "closeReaderRenderer", "dismissProjectScreen", "getBackgroundView", "Landroid/view/View;", "getCurrentFileMd5", "getLayoutId", "initView", "inputFileInfo", "params", "Landroid/os/Bundle;", "inputScreenProjectInfo", "pageIndex", "refreshView", "responeScreenClick", "showReaderContent", "show", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Companion", "plugin-multitalk_release"})
public final class f
  extends l
{
  public static final f.a FBW;
  private FrameLayout FBS;
  private RelativeLayout FBT;
  private o FBU;
  private boolean FBV;
  private h.b FBw;
  private String mFilePath;
  private int mMaxCount;
  private String mToken;
  private String qia;
  private int uPV;
  
  static
  {
    AppMethodBeat.i(198924);
    FBW = new f.a((byte)0);
    AppMethodBeat.o(198924);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198922);
    this.mMaxCount = -1;
    this.uPV = -1;
    if (com.tencent.mm.plugin.multitalk.d.e.eZR())
    {
      paramContext = new e.a();
      Object localObject1 = new int[1];
      localObject1[0] = 1;
      kotlin.g.b.p.k(localObject1, "funcs");
      int i = 0;
      while (i <= 0)
      {
        int j = localObject1[0];
        paramContext.FBN.add(Integer.valueOf(j));
        i += 1;
      }
      localObject1 = new e.c[1];
      Object localObject2 = getContext();
      kotlin.g.b.p.j(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources().getString(a.h.screen_projector_clear_screen);
      kotlin.g.b.p.j(localObject2, "context.resources.getStr…n_projector_clear_screen)");
      localObject1[0] = new e.c((String)localObject2);
      kotlin.g.b.p.k(localObject1, "funcs");
      i = 0;
      while (i <= 0)
      {
        localObject2 = localObject1[0];
        paramContext.FBO.add(localObject2);
        i += 1;
      }
      paramContext = paramContext.E(new int[] { 9, 10 });
      paramContext.type = 2;
      setScreenFuncConfig(paramContext.eZe());
    }
    for (;;)
    {
      LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup)this);
      this.FBT = ((RelativeLayout)findViewById(a.e.screen_projector_reader_layout));
      setMReadyLayout((FrameLayout)findViewById(a.e.screen_project_ready_stroke));
      setMEditLayout((FrameLayout)findViewById(a.e.screen_projector_edit_layout));
      setBottomRoot((FrameLayout)findViewById(a.e.screen_project_bottom_ui));
      setTopRoot((FrameLayout)findViewById(a.e.screen_project_top_ui));
      setAvatarRoot((FrameLayout)findViewById(a.e.screen_projector_avatar_layout));
      this.FBS = ((FrameLayout)findViewById(a.e.screen_projector_reader_thumb_layout));
      paramContext = this.FBT;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = getMEditLayout();
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = getContext();
      kotlin.g.b.p.j(paramContext, "context");
      setMultiTalkStrokeContext(new b(paramContext, (a)this, getScreenFuncConfig()));
      paramContext = getMultiTalkStrokeContext();
      if (paramContext != null) {
        paramContext.FBz = ((kotlin.g.a.b)new b(this));
      }
      paramContext = getContext();
      kotlin.g.b.p.j(paramContext, "context");
      setTopUiLayout(new p(paramContext, (a)this));
      paramContext = getContext();
      kotlin.g.b.p.j(paramContext, "context");
      setAvatarLayout(new j(paramContext, (a)this));
      paramContext = getContext();
      kotlin.g.b.p.j(paramContext, "context");
      setBottomUiLayout(new k(paramContext, (a)this, getScreenFuncConfig()));
      paramContext = getContext();
      kotlin.g.b.p.j(paramContext, "context");
      this.FBU = new o(paramContext, (a)this);
      paramContext = getContext();
      kotlin.g.b.p.j(paramContext, "context");
      setReadyUI(new r(paramContext, (a)this, getScreenFuncConfig()));
      setMScreenReportData(new s());
      refreshView();
      AppMethodBeat.o(198922);
      return;
      paramContext = new e.a().E(new int[] { 9, 10 });
      paramContext.type = 2;
      setScreenFuncConfig(paramContext.eZe());
    }
  }
  
  private void al(Bundle paramBundle)
  {
    AppMethodBeat.i(198865);
    kotlin.g.b.p.k(paramBundle, "params");
    setVisibility(0);
    if (this.mToken == null) {
      setMToken(String.valueOf(hashCode()) + String.valueOf(System.currentTimeMillis()));
    }
    setMFilePath(paramBundle.getString("file_path"));
    this.qia = paramBundle.getString("file_ext");
    if ((this.mFilePath != null) && (this.qia != null))
    {
      paramBundle = this.mFilePath;
      if (paramBundle == null) {
        kotlin.g.b.p.iCn();
      }
      paramBundle = new com.tencent.mm.vfs.q(paramBundle);
      if ((!paramBundle.ifE()) || (!paramBundle.ifH())) {
        AppMethodBeat.o(198865);
      }
    }
    else
    {
      AppMethodBeat.o(198865);
      return;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.jmx = this.qia;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.fileName = this.mFilePath;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.fileSize = u.bBQ(this.mFilePath);
    }
    paramBundle = new HashMap();
    ((Map)paramBundle).put("extra_param_disable_scale", "false");
    ((Map)paramBundle).put("extra_param_enable_receive_view_status_change", "true");
    ((Map)paramBundle).put("extra_param_bg_color", String.valueOf(getResources().getColor(com.tencent.mm.plugin.multitalk.a.b.Dark_2)));
    ((Map)paramBundle).put("extra_param_disable_finish_activity", "true");
    ((Map)paramBundle).put("extra_param_disable_password", "true");
    ((Map)paramBundle).put("extra_param_set_max_scale", "3");
    String str1 = this.mFilePath;
    String str2 = this.qia;
    String str3 = this.mToken;
    h.c localc = h.c.aaai;
    Context localContext = getContext();
    if (localContext == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(198865);
      throw paramBundle;
    }
    h.a(str1, str2, str3, true, paramBundle, localc, (Activity)localContext, (ViewGroup)this.FBT, (h.a)new c(this), (ValueCallback)new d(this));
    AppMethodBeat.o(198865);
  }
  
  private final void setMCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(198842);
    this.uPV = paramInt;
    Object localObject = getMultiTalkStrokeContext();
    if (localObject != null)
    {
      ((b)localObject).FBx = paramInt;
      localObject = ((b)localObject).FBz;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
      }
    }
    localObject = this.FBU;
    if (localObject != null)
    {
      n localn = ((o)localObject).FDw;
      if (localn != null) {
        localn.uPV = paramInt;
      }
      ((o)localObject).uPV = paramInt;
      AppMethodBeat.o(198842);
      return;
    }
    AppMethodBeat.o(198842);
  }
  
  private final void setMFilePath(String paramString)
  {
    AppMethodBeat.i(198834);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.mFilePath = paramString;
    }
    this.mFilePath = paramString;
    AppMethodBeat.o(198834);
  }
  
  private final void setMMaxCount(int paramInt)
  {
    AppMethodBeat.i(198826);
    this.mMaxCount = paramInt;
    Object localObject1 = getMultiTalkStrokeContext();
    if (localObject1 != null) {
      ((b)localObject1).zXe = paramInt;
    }
    localObject1 = this.FBU;
    if (localObject1 != null)
    {
      Object localObject2 = ((o)localObject1).FDw;
      if (localObject2 != null) {
        ((n)localObject2).mMaxCount = paramInt;
      }
      localObject2 = ((o)localObject1).FDt;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).mMaxCount = paramInt;
      }
      ((o)localObject1).FDC = (paramInt / o.FDD + 1);
      ((o)localObject1).mMaxCount = paramInt;
      AppMethodBeat.o(198826);
      return;
    }
    AppMethodBeat.o(198826);
  }
  
  private final void setMToken(String paramString)
  {
    AppMethodBeat.i(198831);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.mToken = paramString;
    }
    this.mToken = paramString;
    AppMethodBeat.o(198831);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(198911);
    kotlin.g.b.p.k(paramc, "status");
    super.a(paramc, paramBundle);
    switch (g.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(198911);
          return;
          paramc = this.FBU;
          if (paramc != null)
          {
            paramc.hide();
            AppMethodBeat.o(198911);
            return;
          }
          AppMethodBeat.o(198911);
          return;
          paramc = this.FBU;
          if (paramc != null)
          {
            paramc.show();
            AppMethodBeat.o(198911);
            return;
          }
          AppMethodBeat.o(198911);
          return;
          if (paramBundle != null)
          {
            i = paramBundle.getInt("thumb_flip_target_position");
            eZa();
            h.aH(this.mToken, this.mFilePath, i);
            AppMethodBeat.o(198911);
            return;
          }
          AppMethodBeat.o(198911);
          return;
        } while (eZp());
        i = this.uPV + 1;
        j = this.mMaxCount;
        if (i < 0) {}
        while (j <= i)
        {
          w.cP(getContext(), "没有更多内容");
          AppMethodBeat.o(198911);
          return;
        }
        eZa();
        paramc = this.FBU;
        if (paramc != null)
        {
          paramc.XR(i);
          AppMethodBeat.o(198911);
          return;
        }
        AppMethodBeat.o(198911);
        return;
      } while (eZp());
      i = this.uPV - 1;
      j = this.mMaxCount;
      if (i < 0) {}
      while (j <= i)
      {
        w.cP(getContext(), "没有更多内容");
        AppMethodBeat.o(198911);
        return;
      }
      eZa();
      paramc = this.FBU;
      if (paramc != null)
      {
        paramc.XR(i);
        AppMethodBeat.o(198911);
        return;
      }
      AppMethodBeat.o(198911);
      return;
    } while (paramBundle == null);
    int i = paramBundle.getInt("thumb_current_page");
    paramc = o.FDE;
    int j = o.eZu() * i;
    paramc = o.FDE;
    if ((i + 1) * o.eZu() < this.mMaxCount) {
      paramc = o.FDE;
    }
    for (i = (i + 1) * o.eZu(); j <= i; i = this.mMaxCount) {
      for (;;)
      {
        h.aI(this.mToken, this.mFilePath, j);
        if (j == i) {
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(198911);
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(198848);
    if (paramBundle != null)
    {
      setVisibility(0);
      al(paramBundle);
      vf(true);
    }
    AppMethodBeat.o(198848);
  }
  
  public final void eZf()
  {
    AppMethodBeat.i(198869);
    setMToken(null);
    super.eZf();
    AppMethodBeat.o(198869);
  }
  
  public final void eZg()
  {
    AppMethodBeat.i(198871);
    h.oV(this.mToken, this.mFilePath);
    setMToken(null);
    setMFilePath(null);
    AppMethodBeat.o(198871);
  }
  
  public final int eZh()
  {
    AppMethodBeat.i(198873);
    int i = super.eZh();
    FrameLayout localFrameLayout = this.FBS;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(i);
    }
    AppMethodBeat.o(198873);
    return i;
  }
  
  public final void eZi()
  {
    AppMethodBeat.i(198899);
    Object localObject3 = this.FBS;
    if (localObject3 != null)
    {
      ((FrameLayout)localObject3).removeAllViews();
      Object localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
      localObject1 = getContext();
      kotlin.g.b.p.j(localObject1, "context");
      Object localObject2;
      if (k.a.hB((Context)localObject1) != 90)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
        localObject1 = getContext();
        kotlin.g.b.p.j(localObject1, "context");
        if (k.a.hB((Context)localObject1) != 270) {}
      }
      else
      {
        localObject1 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.Fyc, -1);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(17);
        localObject2 = getTopRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(17, ((FrameLayout)localObject2).getId());
        localObject2 = getBottomRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(16, ((FrameLayout)localObject2).getId());
        ((FrameLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = this.FBU;
        if (localObject2 == null) {
          break label881;
        }
        localObject1 = getContext();
        kotlin.g.b.p.j(localObject1, "context");
        kotlin.g.b.p.k(localObject1, "context");
        kotlin.g.b.p.k(localObject3, "viewGroup");
        ((o)localObject2).FDq = LayoutInflater.from((Context)localObject1).inflate(a.f.multitalk_screen_project_thumbnail, (ViewGroup)localObject3);
        ((o)localObject2).FDw = new n(((o)localObject2).Fwg);
        localObject1 = ((o)localObject2).FDq;
        if (localObject1 == null) {
          break label847;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.e.screen_projector_reader_thumb_layout);
        label246:
        ((o)localObject2).FDv = ((FrameLayout)localObject1);
        localObject1 = ((o)localObject2).FDq;
        if (localObject1 == null) {
          break label852;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.e.screen_thumb_index_layout_root);
        label271:
        ((o)localObject2).FDx = ((FrameLayout)localObject1);
        localObject1 = ((o)localObject2).FDq;
        if (localObject1 == null) {
          break label857;
        }
        localObject1 = ((View)localObject1).findViewById(a.e.multitalk_shadow_bg);
        label293:
        ((o)localObject2).FDy = ((View)localObject1);
        localObject1 = ((o)localObject2).FDx;
        if (localObject1 != null)
        {
          ((FrameLayout)localObject1).removeAllViews();
          localObject3 = ((o)localObject2).FDw;
          if (localObject3 != null) {
            ((n)localObject3).c(((o)localObject2).context, (FrameLayout)localObject1);
          }
          localObject1 = ((o)localObject2).FDn;
          if (localObject1 != null)
          {
            localObject3 = ((o)localObject2).FDw;
            if (localObject3 != null) {
              ((n)localObject3).aQS((String)localObject1);
            }
          }
          localObject1 = ((o)localObject2).FDw;
          if (localObject1 != null) {
            ((n)localObject1).uPV = ((o)localObject2).uPV;
          }
          localObject1 = ((o)localObject2).FDw;
          if (localObject1 != null) {
            ((n)localObject1).mMaxCount = ((o)localObject2).mMaxCount;
          }
        }
        localObject1 = ((o)localObject2).FDq;
        if (localObject1 == null) {
          break label862;
        }
        localObject1 = (RecyclerView)((View)localObject1).findViewById(a.e.screen_thumb_layout);
        label407:
        ((o)localObject2).FDu = ((RecyclerView)localObject1);
        ((o)localObject2).FDs = new com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e(((o)localObject2).context);
        ((o)localObject2).FDt = new com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b(((o)localObject2).FDu, ((o)localObject2).context);
        ((o)localObject2).FDr = new ScreenThumbLayoutManager(((o)localObject2).FDu, ((o)localObject2).context);
        localObject1 = ((o)localObject2).FDu;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setOnScrollListener((RecyclerView.l)new o.b((o)localObject2, (LinearLayoutManager)((o)localObject2).FDr));
        }
        localObject1 = ((o)localObject2).FDt;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject1).FEr = ((m)new o.c((o)localObject2));
        }
        localObject1 = ((o)localObject2).FDu;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)((o)localObject2).FDr);
        }
        localObject1 = ((o)localObject2).FDu;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setAdapter((RecyclerView.a)((o)localObject2).FDt);
        }
        localObject1 = ((o)localObject2).FDu;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setItemAnimator(null);
        }
        localObject1 = ((o)localObject2).FDs;
        if (localObject1 != null)
        {
          localObject3 = ((o)localObject2).FDu;
          if (localObject3 != null) {
            ((RecyclerView)localObject3).c((RecyclerView.h)localObject1);
          }
          localObject3 = ((o)localObject2).FDu;
          if (localObject3 != null) {
            ((RecyclerView)localObject3).b((RecyclerView.h)localObject1);
          }
        }
        if (((o)localObject2).uPV != -1)
        {
          localObject1 = ((o)localObject2).FDu;
          if (localObject1 != null)
          {
            localObject3 = c.a(((o)localObject2).uPV, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aFh(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyClickEvent", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyClickEvent", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
        }
        if (!((o)localObject2).Fwg.eYW()) {
          break label867;
        }
        ((o)localObject2).hide();
      }
      for (;;)
      {
        localObject1 = ((o)localObject2).FDw;
        if (localObject1 != null) {
          ((n)localObject1).dGn();
        }
        localObject1 = ((o)localObject2).FDx;
        if (localObject1 == null) {
          break label874;
        }
        ((FrameLayout)localObject1).setVisibility(4);
        AppMethodBeat.o(198899);
        return;
        localObject1 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.Fyc);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(17);
        localObject2 = getBottomRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, ((FrameLayout)localObject2).getId());
        localObject2 = getTopRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((FrameLayout)localObject2).getId());
        break;
        label847:
        localObject1 = null;
        break label246;
        label852:
        localObject1 = null;
        break label271;
        label857:
        localObject1 = null;
        break label293;
        label862:
        localObject1 = null;
        break label407;
        label867:
        ((o)localObject2).show();
      }
      label874:
      AppMethodBeat.o(198899);
      return;
      label881:
      AppMethodBeat.o(198899);
      return;
    }
    AppMethodBeat.o(198899);
  }
  
  protected final void eZj()
  {
    AppMethodBeat.i(198905);
    RelativeLayout localRelativeLayout = this.FBT;
    if (localRelativeLayout != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
      localObject = getContext();
      kotlin.g.b.p.j(localObject, "context");
      if (k.a.hB((Context)localObject) != 90)
      {
        localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
        localObject = getContext();
        kotlin.g.b.p.j(localObject, "context");
        if (k.a.hB((Context)localObject) != 270) {}
      }
      else
      {
        localLayoutParams.removeRule(16);
        localLayoutParams.removeRule(3);
        localLayoutParams.removeRule(17);
        localLayoutParams.removeRule(2);
        localObject = getTopRoot();
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localLayoutParams.addRule(17, ((FrameLayout)localObject).getId());
        localObject = getBottomRoot();
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localLayoutParams.addRule(16, ((FrameLayout)localObject).getId());
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        AppMethodBeat.o(198905);
        return;
        localLayoutParams.removeRule(16);
        localLayoutParams.removeRule(3);
        localLayoutParams.removeRule(17);
        localLayoutParams.removeRule(2);
        localObject = getTopRoot();
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localLayoutParams.addRule(3, ((FrameLayout)localObject).getId());
        localObject = getBottomRoot();
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localLayoutParams.addRule(2, ((FrameLayout)localObject).getId());
      }
    }
    AppMethodBeat.o(198905);
  }
  
  public final View getBackgroundView()
  {
    return (View)this.FBT;
  }
  
  public final String getCurrentFileMd5()
  {
    AppMethodBeat.i(198914);
    String str = u.buc(this.mFilePath);
    AppMethodBeat.o(198914);
    return str;
  }
  
  public final int getLayoutId()
  {
    return a.f.multitalk_screen_project_main;
  }
  
  protected final h.b getMCurrentViewStatus()
  {
    return this.FBw;
  }
  
  protected final RelativeLayout getMReaderLayout()
  {
    return this.FBT;
  }
  
  protected final o getThumbUiLayout()
  {
    return this.FBU;
  }
  
  protected final FrameLayout getThumbnailRoot()
  {
    return this.FBS;
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(198907);
    this.FBV = false;
    super.refreshView();
    o localo = this.FBU;
    if (localo != null)
    {
      localo.eZs();
      AppMethodBeat.o(198907);
      return;
    }
    AppMethodBeat.o(198907);
  }
  
  protected final void setMCurrentViewStatus(h.b paramb)
  {
    AppMethodBeat.i(198821);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.FBw = paramb;
    }
    this.FBw = paramb;
    AppMethodBeat.o(198821);
  }
  
  protected final void setMReaderLayout(RelativeLayout paramRelativeLayout)
  {
    this.FBT = paramRelativeLayout;
  }
  
  protected final void setThumbUiLayout(o paramo)
  {
    this.FBU = paramo;
  }
  
  protected final void setThumbnailRoot(FrameLayout paramFrameLayout)
  {
    this.FBS = paramFrameLayout;
  }
  
  public final void vf(boolean paramBoolean)
  {
    AppMethodBeat.i(198845);
    super.vf(paramBoolean);
    RelativeLayout localRelativeLayout = this.FBT;
    if (localRelativeLayout != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localRelativeLayout.setVisibility(i);
        AppMethodBeat.o(198845);
        return;
      }
    }
    AppMethodBeat.o(198845);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pageIndex", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "plugin-multitalk_release"})
  public static final class c
    implements h.a
  {
    public final void NB(int paramInt)
    {
      AppMethodBeat.i(201259);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onPageCountUpdate ".concat(String.valueOf(paramInt)));
      f.a(this.FBX, paramInt);
      Object localObject = this.FBX.getMScreenReportData();
      if (localObject != null) {
        ((s)localObject).FDR = f.a(this.FBX);
      }
      localObject = this.FBX.getThumbUiLayout();
      if (localObject != null)
      {
        ((o)localObject).aQS(f.b(this.FBX) + 1 + '/' + paramInt);
        AppMethodBeat.o(201259);
        return;
      }
      AppMethodBeat.o(201259);
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(201305);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onViewStatusChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3 + " and scale " + paramFloat + " and transX " + paramInt4 + " and " + paramInt5);
      Object localObject = this.FBX.getMultiTalkStrokeContext();
      if (localObject != null)
      {
        localObject = ((b)localObject).FBy;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).Fwf;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).FvR;
            if (localObject != null)
            {
              localObject = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject).getBaseBoardView();
              if (localObject != null)
              {
                ((com.tencent.mm.view.b.b)localObject).h(paramFloat, paramInt4, paramInt5);
                AppMethodBeat.o(201305);
                return;
              }
            }
            AppMethodBeat.o(201305);
            return;
          }
          AppMethodBeat.o(201305);
          return;
        }
        AppMethodBeat.o(201305);
        return;
      }
      AppMethodBeat.o(201305);
    }
    
    public final void a(int paramInt, Bitmap paramBitmap)
    {
      AppMethodBeat.i(201317);
      kotlin.g.b.p.k(paramBitmap, "thumbnail");
      Log.i("MicroMsg.ScreenFileProjector", "xfile onThumbnailLoad ".concat(String.valueOf(paramInt)));
      Object localObject1 = this.FBX.getThumbUiLayout();
      if (localObject1 != null)
      {
        kotlin.g.b.p.k(paramBitmap, "thumbnail");
        Object localObject2;
        int i;
        if (((o)localObject1).FDp.size() <= paramInt)
        {
          ((o)localObject1).FDp.add(paramBitmap);
          localObject2 = ((o)localObject1).FDt;
          if (localObject2 != null)
          {
            kotlin.g.b.p.k(paramBitmap, "bitmap");
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEm = paramBitmap.getWidth();
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEn = paramBitmap.getHeight();
          }
          paramBitmap = ((o)localObject1).FDs;
          if (paramBitmap != null)
          {
            localObject2 = ((o)localObject1).FDt;
            if (localObject2 == null) {
              break label351;
            }
            i = (int)((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEo;
            label132:
            localObject2 = ((o)localObject1).FDv;
            if (localObject2 == null) {
              break label356;
            }
            j = ((FrameLayout)localObject2).getMeasuredWidth();
            label151:
            paramBitmap.contentWidth = j;
            paramBitmap.tHY = i;
          }
          paramBitmap = ((o)localObject1).FDr;
          if (paramBitmap != null)
          {
            localObject2 = ((o)localObject1).FDt;
            if (localObject2 == null) {
              break label362;
            }
            i = (int)((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEo;
            label191:
            localObject2 = ((o)localObject1).FDv;
            if (localObject2 == null) {
              break label367;
            }
          }
        }
        label351:
        label356:
        label362:
        label367:
        for (int j = ((FrameLayout)localObject2).getMeasuredWidth();; j = 0)
        {
          paramBitmap.contentWidth = j;
          paramBitmap.tHY = i;
          if ((paramInt != (((o)localObject1).FDB + 1) * o.FDD) && (paramInt != ((o)localObject1).mMaxCount - 1)) {
            break label487;
          }
          ((o)localObject1).isLoading = false;
          paramBitmap = ((o)localObject1).FDt;
          if (paramBitmap == null) {
            break label383;
          }
          Object localObject3 = (List)((o)localObject1).FDp;
          kotlin.g.b.p.k(localObject3, "bitmapList");
          localObject2 = new CopyOnWriteArrayList();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Bitmap localBitmap = (Bitmap)((Iterator)localObject3).next();
            if (localBitmap != null) {
              ((CopyOnWriteArrayList)localObject2).add(localBitmap);
            }
          }
          ((o)localObject1).FDp.set(paramInt, paramBitmap);
          break;
          i = 0;
          break label132;
          j = 0;
          break label151;
          i = 0;
          break label191;
        }
        paramBitmap.FDp = ((CopyOnWriteArrayList)localObject2);
        paramBitmap.notifyDataSetChanged();
        label383:
        if (((o)localObject1).FDB != ((o)localObject1).FDC - 1)
        {
          paramBitmap = ((o)localObject1).FDt;
          if (paramBitmap != null)
          {
            paramBitmap.FEq = true;
            localObject1 = BitmapUtil.createBitmap((int)paramBitmap.FEo, (int)paramBitmap.FEp, Bitmap.Config.ARGB_8888);
            kotlin.g.b.p.j(localObject1, "BitmapUtil.createBitmap(…,Bitmap.Config.ARGB_8888)");
            kotlin.g.b.p.k(localObject1, "bitmap");
            paramBitmap.FDp.add(localObject1);
            paramBitmap.cM(paramBitmap.FDp.size() - 1);
            AppMethodBeat.o(201317);
            return;
          }
          AppMethodBeat.o(201317);
          return;
        }
        ((o)localObject1).mMk = true;
        label487:
        AppMethodBeat.o(201317);
        return;
      }
      AppMethodBeat.o(201317);
    }
    
    public final void ag(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(201297);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
      Object localObject1;
      Object localObject2;
      float f2;
      float f3;
      if ((paramInt1 > f.b(this.FBX)) && (f.b(this.FBX) != -1))
      {
        this.FBX.eZa();
        localObject1 = com.tencent.mm.plugin.multitalk.d.f.FEQ;
        com.tencent.mm.plugin.multitalk.d.f.fak();
        a.b.a(this.FBX, a.c.FBg);
        if (!f.c(this.FBX))
        {
          f.d(this.FBX);
          localObject1 = this.FBX.getThumbUiLayout();
          if (localObject1 != null) {
            ((o)localObject1).eZs();
          }
        }
        f.b(this.FBX, paramInt1);
        this.FBX.setMCurrentScale(1.0F);
        this.FBX.setMCurrentPageWidth(paramInt2);
        this.FBX.setMCurrentPageHeight(paramInt3);
        localObject1 = this.FBX.getThumbUiLayout();
        if (localObject1 != null)
        {
          i = this.FBX.getMCurrentPageWidth();
          j = this.FBX.getMCurrentPageHeight();
          ((o)localObject1).FDz = i;
          ((o)localObject1).FDA = j;
          localObject2 = ((o)localObject1).FDt;
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).uPV = paramInt1;
            float f1 = i / j;
            f2 = i / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEt;
            f2 = j / f2;
            if (f2 <= com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEu) {
              break label1187;
            }
            f3 = j / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEu;
            f3 = i / f3;
            if (f3 <= com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEt) {
              break label1142;
            }
            f3 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEv;
            f2 = f3 / f1;
            f1 = f2;
            if (f2 > com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEu) {
              f1 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEu;
            }
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEp = f1;
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEo = f3;
            label330:
            if ((((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEm != -1) && (((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEn != -1)) {
              ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).cL(paramInt1);
            }
          }
          localObject1 = ((o)localObject1).FDu;
          if (localObject1 != null)
          {
            localObject2 = c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
        }
        this.FBX.setMCurrentViewStatus(h.oW(f.e(this.FBX), f.f(this.FBX)));
        if ((paramInt2 <= 0) || (paramInt3 <= 0) || (this.FBX.getMCurrentViewStatus() == null)) {
          break label1368;
        }
        localObject1 = this.FBX.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).FBv = this.FBX.getMCurrentPageHeight();
        }
        localObject1 = this.FBX.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).FBu = this.FBX.getMCurrentPageWidth();
        }
        localObject1 = this.FBX.getMultiTalkStrokeContext();
        if (localObject1 != null)
        {
          if (this.FBX.getMCurrentViewStatus() == null) {
            kotlin.g.b.p.iCn();
          }
          if (this.FBX.getMCurrentViewStatus() == null) {
            kotlin.g.b.p.iCn();
          }
          ((b)localObject1).FBt = 1.0F;
        }
        localObject1 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
        localObject2 = this.FBX.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        paramInt1 = ((h.b)localObject2).aaaf;
        localObject2 = this.FBX.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        paramInt2 = ((h.b)localObject2).aaag;
        paramInt3 = this.FBX.getMCurrentPageWidth();
        localObject2 = this.FBX.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        int i = ((h.b)localObject2).aaaf;
        int j = this.FBX.getMCurrentPageHeight();
        localObject2 = this.FBX.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject2 = new Rect(paramInt1, paramInt2, paramInt3 + i, j + ((h.b)localObject2).aaag);
        kotlin.g.b.p.k(localObject2, "<set-?>");
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).byG = ((Rect)localObject2);
        Object localObject3 = this.FBX.getMultiTalkStrokeContext();
        if (localObject3 != null)
        {
          localObject2 = (kotlin.g.a.a)new a(this);
          kotlin.g.b.p.k(localObject1, "config");
          com.tencent.mm.plugin.multitalk.ui.a.b localb = ((b)localObject3).FBy;
          if (localb != null)
          {
            kotlin.g.b.p.k(localObject1, "config");
            localObject3 = localb.Fwf;
            localb.Fwg.eYV();
            kotlin.g.b.p.k(localObject1, "config");
            if (((com.tencent.mm.plugin.multitalk.ui.a.a)localObject3).FvV) {
              break label1205;
            }
            ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject3).b((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1);
            localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject3).FvR;
            if (localObject1 != null)
            {
              localObject1 = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject1).getBaseBoardView();
              if (localObject1 != null)
              {
                ((com.tencent.mm.view.b.b)localObject1).ihD();
                ((com.tencent.mm.view.b.b)localObject1).invalidate();
                ((com.tencent.mm.view.b.b)localObject1).zoa = ((kotlin.g.a.a)localObject2);
                ((com.tencent.mm.view.b.b)localObject1).YPh = true;
              }
            }
          }
        }
        localObject1 = this.FBX;
        localObject2 = ((l)localObject1).FCK;
        if (localObject2 != null)
        {
          localObject2 = ((b)localObject2).FBs;
          if (localObject2 != null) {
            ((FrameLayout)localObject2).setVisibility(0);
          }
        }
        if ((!((l)localObject1).FCR) && (!((l)localObject1).FCU))
        {
          a.b.a((a)localObject1, a.c.FAV);
          localObject1 = ((l)localObject1).FCO;
          if (localObject1 != null)
          {
            if (((p)localObject1).FDJ == null) {
              break label1251;
            }
            localObject2 = ((p)localObject1).FDJ;
            if (localObject2 != null) {
              ((ImageView)localObject2).setBackground(au.o(((p)localObject1).context, a.g.icons_filled_stop, Color.parseColor("#FA5151")));
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = ((p)localObject1).ubm;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = this.FBX.getThumbUiLayout();
        if (localObject1 == null) {
          break label1368;
        }
        ((o)localObject1).aQS(f.b(this.FBX) + 1 + '/' + f.a(this.FBX));
        AppMethodBeat.o(201297);
        return;
        if ((paramInt1 >= f.b(this.FBX)) || (f.b(this.FBX) == -1)) {
          break;
        }
        this.FBX.eZa();
        localObject1 = com.tencent.mm.plugin.multitalk.d.f.FEQ;
        com.tencent.mm.plugin.multitalk.d.f.fak();
        a.b.a(this.FBX, a.c.FBh);
        break;
        label1142:
        if (f3 < com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEv)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEp = f2;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEo = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEv;
          break label330;
        }
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEp = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEu;
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEo = f3;
        break label330;
        label1187:
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEp = f2;
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).FEo = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.FEt;
        break label330;
        label1205:
        localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).byG;
        if (localObject1 != null) {}
        for (localObject1 = ((Rect)localObject1).toShortString();; localObject1 = null)
        {
          Log.printInfoStack("MicroMsg.MultiTalkEditPhotoContainerPlugin", "config is %s", new Object[] { localObject1 });
          break;
        }
        label1251:
        localObject2 = ((p)localObject1).FDH;
        if (localObject2 != null) {
          ((View)localObject2).setBackground(au.o(((p)localObject1).context, a.d.green_rect_link, Color.parseColor("#FA5151")));
        }
        localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
        if (k.a.hB(((p)localObject1).context) != 90)
        {
          localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
          if (k.a.hB(((p)localObject1).context) != 270) {}
        }
        else
        {
          localObject2 = ((p)localObject1).FDI;
          if (localObject2 == null) {
            continue;
          }
          ((TextView)localObject2).setText(a.h.screen_projector_pause_btn);
          continue;
        }
        localObject2 = ((p)localObject1).FDI;
        if (localObject2 != null) {
          ((TextView)localObject2).setText(a.h.screen_project_pause);
        }
      }
      label1368:
      AppMethodBeat.o(201297);
    }
    
    public final void bQm()
    {
      AppMethodBeat.i(201260);
      Log.i("MicroMsg.ScreenFileProjector", "xfile on user cancel finish");
      ad.eYc().eWl();
      AppMethodBeat.o(201260);
    }
    
    public final void dCv()
    {
      AppMethodBeat.i(201318);
      a.b.a(this.FBX, a.c.FBf);
      AppMethodBeat.o(201318);
    }
    
    public final void dCw() {}
    
    public final void dCx() {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(f.c paramc)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"})
  static final class d<T>
    implements ValueCallback<Integer>
  {
    d(f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.f
 * JD-Core Version:    0.7.0.1
 */