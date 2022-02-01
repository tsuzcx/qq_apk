package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.xweb.h;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.b;
import com.tencent.xweb.h.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.a.m;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "mCurrentIndex", "setMCurrentIndex", "(I)V", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "mCurrentViewStatus", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFileExt", "", "mFilePath", "setMFilePath", "(Ljava/lang/String;)V", "mMaxCount", "setMMaxCount", "mReaderLayout", "Landroid/widget/RelativeLayout;", "getMReaderLayout", "()Landroid/widget/RelativeLayout;", "setMReaderLayout", "(Landroid/widget/RelativeLayout;)V", "mThumbnailHasBeenRequest", "", "mToken", "setMToken", "thumbUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "getThumbUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "setThumbUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;)V", "thumbnailRoot", "Landroid/widget/FrameLayout;", "getThumbnailRoot", "()Landroid/widget/FrameLayout;", "setThumbnailRoot", "(Landroid/widget/FrameLayout;)V", "applyReaderUI", "", "applyThumbnailUI", "closeReaderRenderer", "dismissProjectScreen", "getBackgroundView", "Landroid/view/View;", "getLayoutId", "initView", "inputFileInfo", "params", "Landroid/os/Bundle;", "inputScreenProjectInfo", "pageIndex", "refreshView", "responeScreenClick", "showReaderContent", "show", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Companion", "plugin-multitalk_release"})
public final class f
  extends l
{
  public static final f.a zWn;
  private String mFilePath;
  private int mMaxCount;
  private String mToken;
  private String nhr;
  private int rmJ;
  private h.b zVM;
  private FrameLayout zWj;
  private RelativeLayout zWk;
  private o zWl;
  private boolean zWm;
  
  static
  {
    AppMethodBeat.i(239962);
    zWn = new f.a((byte)0);
    AppMethodBeat.o(239962);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(239961);
    this.mMaxCount = -1;
    this.rmJ = -1;
    paramContext = new e.a().E(new int[] { 1 });
    Object localObject = getContext();
    kotlin.g.b.p.g(localObject, "context");
    localObject = ((Context)localObject).getResources().getString(2131765019);
    kotlin.g.b.p.g(localObject, "context.resources.getStr…n_projector_clear_screen)");
    paramContext = paramContext.a(new e.c[] { new e.c((String)localObject, 8) }).F(new int[] { 9, 10 });
    paramContext.type = 2;
    setScreenFuncConfig(paramContext.epo());
    LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup)this);
    this.zWk = ((RelativeLayout)findViewById(2131307319));
    setMReadyLayout((FrameLayout)findViewById(2131307315));
    setMEditLayout((FrameLayout)findViewById(2131307318));
    setBottomRoot((FrameLayout)findViewById(2131307311));
    setTopRoot((FrameLayout)findViewById(2131307316));
    setAvatarRoot((FrameLayout)findViewById(2131307317));
    this.zWj = ((FrameLayout)findViewById(2131307320));
    paramContext = this.zWk;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = getMEditLayout();
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setMultiTalkStrokeContext(new b(paramContext, (a)this, getScreenFuncConfig()));
    paramContext = getMultiTalkStrokeContext();
    if (paramContext != null) {
      paramContext.zVP = ((kotlin.g.a.b)new b(this));
    }
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setTopUiLayout(new p(paramContext, (a)this));
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setAvatarLayout(new j(paramContext, (a)this));
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setBottomUiLayout(new k(paramContext, (a)this, getScreenFuncConfig()));
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    this.zWl = new o(paramContext, (a)this);
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setReadyUI(new r(paramContext, (a)this, getScreenFuncConfig()));
    setMScreenReportData(new s());
    refreshView();
    AppMethodBeat.o(239961);
  }
  
  private void ar(Bundle paramBundle)
  {
    AppMethodBeat.i(239953);
    kotlin.g.b.p.h(paramBundle, "params");
    setVisibility(0);
    if (this.mToken == null) {
      setMToken(String.valueOf(hashCode()) + String.valueOf(System.currentTimeMillis()));
    }
    setMFilePath(paramBundle.getString("file_path"));
    this.nhr = paramBundle.getString("file_ext");
    if ((this.mFilePath != null) && (this.nhr != null))
    {
      paramBundle = this.mFilePath;
      if (paramBundle == null) {
        kotlin.g.b.p.hyc();
      }
      paramBundle = new com.tencent.mm.vfs.o(paramBundle);
      if ((!paramBundle.exists()) || (!paramBundle.isFile())) {
        AppMethodBeat.o(239953);
      }
    }
    else
    {
      AppMethodBeat.o(239953);
      return;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.gCr = this.nhr;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.fileName = this.mFilePath;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.fileSize = com.tencent.mm.vfs.s.boW(this.mFilePath);
    }
    paramBundle = new HashMap();
    ((Map)paramBundle).put("extra_param_disable_scale", "false");
    ((Map)paramBundle).put("extra_param_enable_receive_view_status_change", "true");
    ((Map)paramBundle).put("extra_param_bg_color", String.valueOf(getResources().getColor(2131099742)));
    ((Map)paramBundle).put("extra_param_disable_finish_activity", "true");
    ((Map)paramBundle).put("extra_param_set_max_scale", "3");
    String str1 = this.mFilePath;
    String str2 = this.nhr;
    String str3 = this.mToken;
    h.c localc = h.c.Szr;
    Context localContext = getContext();
    if (localContext == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(239953);
      throw paramBundle;
    }
    h.a(str1, str2, str3, true, paramBundle, localc, (Activity)localContext, (ViewGroup)this.zWk, (h.a)new c(this), (ValueCallback)new d(this));
    AppMethodBeat.o(239953);
  }
  
  private final void setMCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(239950);
    this.rmJ = paramInt;
    Object localObject = getMultiTalkStrokeContext();
    if (localObject != null)
    {
      ((b)localObject).zVN = paramInt;
      localObject = ((b)localObject).zVP;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
      }
    }
    localObject = this.zWl;
    if (localObject != null)
    {
      n localn = ((o)localObject).zXK;
      if (localn != null) {
        localn.rmJ = paramInt;
      }
      ((o)localObject).rmJ = paramInt;
      AppMethodBeat.o(239950);
      return;
    }
    AppMethodBeat.o(239950);
  }
  
  private final void setMFilePath(String paramString)
  {
    AppMethodBeat.i(239949);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.mFilePath = paramString;
    }
    this.mFilePath = paramString;
    AppMethodBeat.o(239949);
  }
  
  private final void setMMaxCount(int paramInt)
  {
    AppMethodBeat.i(239947);
    this.mMaxCount = paramInt;
    Object localObject1 = getMultiTalkStrokeContext();
    if (localObject1 != null) {
      ((b)localObject1).vfW = paramInt;
    }
    localObject1 = this.zWl;
    if (localObject1 != null)
    {
      Object localObject2 = ((o)localObject1).zXK;
      if (localObject2 != null) {
        ((n)localObject2).mMaxCount = paramInt;
      }
      localObject2 = ((o)localObject1).zXH;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).mMaxCount = paramInt;
      }
      ((o)localObject1).zXQ = (paramInt / o.zXR + 1);
      ((o)localObject1).mMaxCount = paramInt;
      AppMethodBeat.o(239947);
      return;
    }
    AppMethodBeat.o(239947);
  }
  
  private final void setMToken(String paramString)
  {
    AppMethodBeat.i(239948);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.mToken = paramString;
    }
    this.mToken = paramString;
    AppMethodBeat.o(239948);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(239960);
    kotlin.g.b.p.h(paramc, "status");
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
          AppMethodBeat.o(239960);
          return;
          paramc = this.zWl;
          if (paramc != null)
          {
            paramc.hide();
            AppMethodBeat.o(239960);
            return;
          }
          AppMethodBeat.o(239960);
          return;
          paramc = this.zWl;
          if (paramc != null)
          {
            paramc.show();
            AppMethodBeat.o(239960);
            return;
          }
          AppMethodBeat.o(239960);
          return;
          if (paramBundle != null)
          {
            i = paramBundle.getInt("thumb_flip_target_position");
            epk();
            h.aw(this.mToken, this.mFilePath, i);
            AppMethodBeat.o(239960);
            return;
          }
          AppMethodBeat.o(239960);
          return;
        } while (this.zXj);
        i = this.rmJ + 1;
        j = this.mMaxCount;
        if (i < 0) {}
        while (j <= i)
        {
          u.cE(getContext(), "没有更多内容");
          AppMethodBeat.o(239960);
          return;
        }
        epk();
        paramc = this.zWl;
        if (paramc != null)
        {
          paramc.RB(i);
          AppMethodBeat.o(239960);
          return;
        }
        AppMethodBeat.o(239960);
        return;
      } while (this.zXj);
      i = this.rmJ - 1;
      j = this.mMaxCount;
      if (i < 0) {}
      while (j <= i)
      {
        u.cE(getContext(), "没有更多内容");
        AppMethodBeat.o(239960);
        return;
      }
      epk();
      paramc = this.zWl;
      if (paramc != null)
      {
        paramc.RB(i);
        AppMethodBeat.o(239960);
        return;
      }
      AppMethodBeat.o(239960);
      return;
    } while (paramBundle == null);
    int i = paramBundle.getInt("thumb_current_page");
    paramc = o.zXS;
    int j = o.epG() * i;
    paramc = o.zXS;
    if ((i + 1) * o.epG() < this.mMaxCount) {
      paramc = o.zXS;
    }
    for (i = (i + 1) * o.epG(); j <= i; i = this.mMaxCount) {
      for (;;)
      {
        h.ax(this.mToken, this.mFilePath, j);
        if (j == i) {
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(239960);
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(239952);
    if (paramBundle != null)
    {
      setVisibility(0);
      ar(paramBundle);
      sd(true);
    }
    AppMethodBeat.o(239952);
  }
  
  public final void epp()
  {
    AppMethodBeat.i(239954);
    setMToken(null);
    super.epp();
    AppMethodBeat.o(239954);
  }
  
  public final void epq()
  {
    AppMethodBeat.i(239955);
    h.nZ(this.mToken, this.mFilePath);
    setMToken(null);
    setMFilePath(null);
    AppMethodBeat.o(239955);
  }
  
  public final int epr()
  {
    AppMethodBeat.i(239956);
    int i = super.epr();
    FrameLayout localFrameLayout = this.zWj;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(i);
    }
    AppMethodBeat.o(239956);
    return i;
  }
  
  public final void eps()
  {
    AppMethodBeat.i(239957);
    Object localObject3 = this.zWj;
    if (localObject3 != null)
    {
      ((FrameLayout)localObject3).removeAllViews();
      Object localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
      localObject1 = getContext();
      kotlin.g.b.p.g(localObject1, "context");
      Object localObject2;
      if (k.a.gE((Context)localObject1) != 90)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
        localObject1 = getContext();
        kotlin.g.b.p.g(localObject1, "context");
        if (k.a.gE((Context)localObject1) != 270) {}
      }
      else
      {
        localObject1 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.zSA, -1);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(17);
        localObject2 = getTopRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(17, ((FrameLayout)localObject2).getId());
        localObject2 = getBottomRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(16, ((FrameLayout)localObject2).getId());
        ((FrameLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = this.zWl;
        if (localObject2 == null) {
          break label880;
        }
        localObject1 = getContext();
        kotlin.g.b.p.g(localObject1, "context");
        kotlin.g.b.p.h(localObject1, "context");
        kotlin.g.b.p.h(localObject3, "viewGroup");
        ((o)localObject2).zXE = LayoutInflater.from((Context)localObject1).inflate(2131495747, (ViewGroup)localObject3);
        ((o)localObject2).zXK = new n(((o)localObject2).zQD);
        localObject1 = ((o)localObject2).zXE;
        if (localObject1 == null) {
          break label846;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(2131307320);
        label245:
        ((o)localObject2).zXJ = ((FrameLayout)localObject1);
        localObject1 = ((o)localObject2).zXE;
        if (localObject1 == null) {
          break label851;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(2131307323);
        label270:
        ((o)localObject2).zXL = ((FrameLayout)localObject1);
        localObject1 = ((o)localObject2).zXE;
        if (localObject1 == null) {
          break label856;
        }
        localObject1 = ((View)localObject1).findViewById(2131305055);
        label292:
        ((o)localObject2).zXM = ((View)localObject1);
        localObject1 = ((o)localObject2).zXL;
        if (localObject1 != null)
        {
          ((FrameLayout)localObject1).removeAllViews();
          localObject3 = ((o)localObject2).zXK;
          if (localObject3 != null) {
            ((n)localObject3).c(((o)localObject2).context, (FrameLayout)localObject1);
          }
          localObject1 = ((o)localObject2).zXB;
          if (localObject1 != null)
          {
            localObject3 = ((o)localObject2).zXK;
            if (localObject3 != null) {
              ((n)localObject3).aGE((String)localObject1);
            }
          }
          localObject1 = ((o)localObject2).zXK;
          if (localObject1 != null) {
            ((n)localObject1).rmJ = ((o)localObject2).rmJ;
          }
          localObject1 = ((o)localObject2).zXK;
          if (localObject1 != null) {
            ((n)localObject1).mMaxCount = ((o)localObject2).mMaxCount;
          }
        }
        localObject1 = ((o)localObject2).zXE;
        if (localObject1 == null) {
          break label861;
        }
        localObject1 = (RecyclerView)((View)localObject1).findViewById(2131307328);
        label406:
        ((o)localObject2).zXI = ((RecyclerView)localObject1);
        ((o)localObject2).zXG = new e(((o)localObject2).context);
        ((o)localObject2).zXH = new com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b(((o)localObject2).zXI, ((o)localObject2).context);
        ((o)localObject2).zXF = new ScreenThumbLayoutManager(((o)localObject2).zXI, ((o)localObject2).context);
        localObject1 = ((o)localObject2).zXI;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setOnScrollListener((RecyclerView.l)new o.b((o)localObject2, (LinearLayoutManager)((o)localObject2).zXF));
        }
        localObject1 = ((o)localObject2).zXH;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject1).zYG = ((m)new o.c((o)localObject2));
        }
        localObject1 = ((o)localObject2).zXI;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)((o)localObject2).zXF);
        }
        localObject1 = ((o)localObject2).zXI;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setAdapter((RecyclerView.a)((o)localObject2).zXH);
        }
        localObject1 = ((o)localObject2).zXI;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setItemAnimator(null);
        }
        localObject1 = ((o)localObject2).zXG;
        if (localObject1 != null)
        {
          localObject3 = ((o)localObject2).zXI;
          if (localObject3 != null) {
            ((RecyclerView)localObject3).c((RecyclerView.h)localObject1);
          }
          localObject3 = ((o)localObject2).zXI;
          if (localObject3 != null) {
            ((RecyclerView)localObject3).b((RecyclerView.h)localObject1);
          }
        }
        if (((o)localObject2).rmJ != -1)
        {
          localObject1 = ((o)localObject2).zXI;
          if (localObject1 != null)
          {
            localObject3 = c.a(((o)localObject2).rmJ, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyClickEvent", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyClickEvent", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
        }
        if (!((o)localObject2).zQD.epg()) {
          break label866;
        }
        ((o)localObject2).hide();
      }
      for (;;)
      {
        localObject1 = ((o)localObject2).zXK;
        if (localObject1 != null) {
          ((n)localObject1).eoD();
        }
        localObject1 = ((o)localObject2).zXL;
        if (localObject1 == null) {
          break label873;
        }
        ((FrameLayout)localObject1).setVisibility(4);
        AppMethodBeat.o(239957);
        return;
        localObject1 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.zSA);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(17);
        localObject2 = getBottomRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, ((FrameLayout)localObject2).getId());
        localObject2 = getTopRoot();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((FrameLayout)localObject2).getId());
        break;
        label846:
        localObject1 = null;
        break label245;
        label851:
        localObject1 = null;
        break label270;
        label856:
        localObject1 = null;
        break label292;
        label861:
        localObject1 = null;
        break label406;
        label866:
        ((o)localObject2).show();
      }
      label873:
      AppMethodBeat.o(239957);
      return;
      label880:
      AppMethodBeat.o(239957);
      return;
    }
    AppMethodBeat.o(239957);
  }
  
  protected final void ept()
  {
    AppMethodBeat.i(239958);
    RelativeLayout localRelativeLayout = this.zWk;
    if (localRelativeLayout != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
      localObject = getContext();
      kotlin.g.b.p.g(localObject, "context");
      if (k.a.gE((Context)localObject) != 90)
      {
        localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
        localObject = getContext();
        kotlin.g.b.p.g(localObject, "context");
        if (k.a.gE((Context)localObject) != 270) {}
      }
      else
      {
        localLayoutParams.removeRule(16);
        localLayoutParams.removeRule(3);
        localLayoutParams.removeRule(17);
        localLayoutParams.removeRule(2);
        localObject = getTopRoot();
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        localLayoutParams.addRule(17, ((FrameLayout)localObject).getId());
        localObject = getBottomRoot();
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        localLayoutParams.addRule(16, ((FrameLayout)localObject).getId());
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        AppMethodBeat.o(239958);
        return;
        localLayoutParams.removeRule(16);
        localLayoutParams.removeRule(3);
        localLayoutParams.removeRule(17);
        localLayoutParams.removeRule(2);
        localObject = getTopRoot();
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        localLayoutParams.addRule(3, ((FrameLayout)localObject).getId());
        localObject = getBottomRoot();
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        localLayoutParams.addRule(2, ((FrameLayout)localObject).getId());
      }
    }
    AppMethodBeat.o(239958);
  }
  
  public final View getBackgroundView()
  {
    return (View)this.zWk;
  }
  
  public final int getLayoutId()
  {
    return 2131495744;
  }
  
  protected final h.b getMCurrentViewStatus()
  {
    return this.zVM;
  }
  
  protected final RelativeLayout getMReaderLayout()
  {
    return this.zWk;
  }
  
  protected final o getThumbUiLayout()
  {
    return this.zWl;
  }
  
  protected final FrameLayout getThumbnailRoot()
  {
    return this.zWj;
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(239959);
    this.zWm = false;
    super.refreshView();
    o localo = this.zWl;
    if (localo != null)
    {
      localo.epE();
      AppMethodBeat.o(239959);
      return;
    }
    AppMethodBeat.o(239959);
  }
  
  public final void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(239951);
    super.sd(paramBoolean);
    RelativeLayout localRelativeLayout = this.zWk;
    if (localRelativeLayout != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localRelativeLayout.setVisibility(i);
        AppMethodBeat.o(239951);
        return;
      }
    }
    AppMethodBeat.o(239951);
  }
  
  protected final void setMCurrentViewStatus(h.b paramb)
  {
    AppMethodBeat.i(239946);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.zVM = paramb;
    }
    this.zVM = paramb;
    AppMethodBeat.o(239946);
  }
  
  protected final void setMReaderLayout(RelativeLayout paramRelativeLayout)
  {
    this.zWk = paramRelativeLayout;
  }
  
  protected final void setThumbUiLayout(o paramo)
  {
    this.zWl = paramo;
  }
  
  protected final void setThumbnailRoot(FrameLayout paramFrameLayout)
  {
    this.zWj = paramFrameLayout;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pageIndex", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "plugin-multitalk_release"})
  public static final class c
    implements h.a
  {
    public final void Rz(int paramInt)
    {
      AppMethodBeat.i(239939);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onPageCountUpdate ".concat(String.valueOf(paramInt)));
      f.a(this.zWo, paramInt);
      Object localObject = this.zWo.getMScreenReportData();
      if (localObject != null) {
        ((s)localObject).zYf = f.a(this.zWo);
      }
      localObject = this.zWo.getThumbUiLayout();
      if (localObject != null)
      {
        ((o)localObject).aGE(f.b(this.zWo) + 1 + '/' + paramInt);
        AppMethodBeat.o(239939);
        return;
      }
      AppMethodBeat.o(239939);
    }
    
    public final void ar(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(239941);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
      Object localObject1;
      int i;
      int j;
      Object localObject2;
      float f2;
      float f3;
      if ((paramInt1 > f.b(this.zWo)) && (f.b(this.zWo) != -1))
      {
        this.zWo.epk();
        localObject1 = com.tencent.mm.plugin.multitalk.d.f.zZd;
        com.tencent.mm.plugin.multitalk.d.f.equ();
        a.b.a(this.zWo, a.c.zVw);
        if (!f.c(this.zWo))
        {
          f.d(this.zWo);
          localObject1 = this.zWo.getThumbUiLayout();
          if (localObject1 != null) {
            ((o)localObject1).epE();
          }
        }
        f.b(this.zWo, paramInt1);
        this.zWo.setMCurrentScale(1.0F);
        this.zWo.setMCurrentPageWidth(paramInt2);
        this.zWo.setMCurrentPageHeight(paramInt3);
        localObject1 = this.zWo.getThumbUiLayout();
        if (localObject1 != null)
        {
          i = this.zWo.getMCurrentPageWidth();
          j = this.zWo.getMCurrentPageHeight();
          ((o)localObject1).zXN = i;
          ((o)localObject1).zXO = j;
          localObject2 = ((o)localObject1).zXH;
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).rmJ = paramInt1;
            float f1 = i / j;
            f2 = i / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYI;
            f2 = j / f2;
            if (f2 <= com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ) {
              break label930;
            }
            f3 = j / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ;
            f3 = i / f3;
            if (f3 <= com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYI) {
              break label885;
            }
            f3 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYK;
            f2 = f3 / f1;
            f1 = f2;
            if (f2 > com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ) {
              f1 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ;
            }
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYE = f1;
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYD = f3;
          }
        }
      }
      label930:
      for (;;)
      {
        if ((((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYB != -1) && (((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYC != -1)) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).ci(paramInt1);
        }
        localObject1 = ((o)localObject1).zXI;
        if (localObject1 != null)
        {
          localObject2 = c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
          ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        this.zWo.setMCurrentViewStatus(h.oa(f.e(this.zWo), f.f(this.zWo)));
        if ((paramInt2 <= 0) || (paramInt3 <= 0) || (this.zWo.getMCurrentViewStatus() == null)) {
          break label948;
        }
        localObject1 = this.zWo.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).zVL = this.zWo.getMCurrentPageHeight();
        }
        localObject1 = this.zWo.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).zVK = this.zWo.getMCurrentPageWidth();
        }
        localObject1 = this.zWo.getMultiTalkStrokeContext();
        if (localObject1 != null)
        {
          if (this.zWo.getMCurrentViewStatus() == null) {
            kotlin.g.b.p.hyc();
          }
          if (this.zWo.getMCurrentViewStatus() == null) {
            kotlin.g.b.p.hyc();
          }
          ((b)localObject1).zVJ = 1.0F;
        }
        localObject1 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
        localObject2 = this.zWo.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        paramInt1 = ((h.b)localObject2).Szo;
        localObject2 = this.zWo.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        paramInt2 = ((h.b)localObject2).Szp;
        paramInt3 = this.zWo.getMCurrentPageWidth();
        localObject2 = this.zWo.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        i = ((h.b)localObject2).Szo;
        j = this.zWo.getMCurrentPageHeight();
        localObject2 = this.zWo.getMCurrentViewStatus();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).setRect(new Rect(paramInt1, paramInt2, paramInt3 + i, j + ((h.b)localObject2).Szp));
        localObject2 = this.zWo.getMultiTalkStrokeContext();
        if (localObject2 != null) {
          ((b)localObject2).a((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, (kotlin.g.a.a)new a(this));
        }
        this.zWo.epB();
        localObject1 = this.zWo.getThumbUiLayout();
        if (localObject1 == null) {
          break label948;
        }
        ((o)localObject1).aGE(f.b(this.zWo) + 1 + '/' + f.a(this.zWo));
        AppMethodBeat.o(239941);
        return;
        if ((paramInt1 >= f.b(this.zWo)) || (f.b(this.zWo) == -1)) {
          break;
        }
        this.zWo.epk();
        localObject1 = com.tencent.mm.plugin.multitalk.d.f.zZd;
        com.tencent.mm.plugin.multitalk.d.f.equ();
        a.b.a(this.zWo, a.c.zVx);
        break;
        label885:
        if (f3 < com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYK)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYE = f2;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYD = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYK;
        }
        else
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYE = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYD = f3;
          continue;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYE = f2;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYD = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYI;
        }
      }
      label948:
      AppMethodBeat.o(239941);
    }
    
    public final void b(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(239942);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onViewStatusChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3 + " and scale " + paramFloat + " and transX " + paramInt4 + " and " + paramInt5);
      Object localObject = this.zWo.getMultiTalkStrokeContext();
      if (localObject != null)
      {
        localObject = ((b)localObject).zVO;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).zQC;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).zQo;
            if (localObject != null)
            {
              localObject = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject).getBaseBoardView();
              if (localObject != null)
              {
                ((com.tencent.mm.view.b.b)localObject).h(paramFloat, paramInt4, paramInt5);
                AppMethodBeat.o(239942);
                return;
              }
            }
            AppMethodBeat.o(239942);
            return;
          }
          AppMethodBeat.o(239942);
          return;
        }
        AppMethodBeat.o(239942);
        return;
      }
      AppMethodBeat.o(239942);
    }
    
    public final void c(int paramInt, Bitmap paramBitmap)
    {
      AppMethodBeat.i(239943);
      kotlin.g.b.p.h(paramBitmap, "thumbnail");
      Log.i("MicroMsg.ScreenFileProjector", "xfile onThumbnailLoad ".concat(String.valueOf(paramInt)));
      Object localObject1 = this.zWo.getThumbUiLayout();
      if (localObject1 != null)
      {
        kotlin.g.b.p.h(paramBitmap, "thumbnail");
        Object localObject2;
        int i;
        if (((o)localObject1).zXD.size() <= paramInt)
        {
          ((o)localObject1).zXD.add(paramBitmap);
          localObject2 = ((o)localObject1).zXH;
          if (localObject2 != null)
          {
            kotlin.g.b.p.h(paramBitmap, "bitmap");
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYB = paramBitmap.getWidth();
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYC = paramBitmap.getHeight();
          }
          paramBitmap = ((o)localObject1).zXG;
          if (paramBitmap != null)
          {
            localObject2 = ((o)localObject1).zXH;
            if (localObject2 == null) {
              break label356;
            }
            i = (int)((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYD;
            label137:
            localObject2 = ((o)localObject1).zXJ;
            if (localObject2 == null) {
              break label361;
            }
            j = ((FrameLayout)localObject2).getMeasuredWidth();
            label156:
            paramBitmap.zYO = j;
            paramBitmap.qmd = i;
          }
          paramBitmap = ((o)localObject1).zXF;
          if (paramBitmap != null)
          {
            localObject2 = ((o)localObject1).zXH;
            if (localObject2 == null) {
              break label367;
            }
            i = (int)((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).zYD;
            label196:
            localObject2 = ((o)localObject1).zXJ;
            if (localObject2 == null) {
              break label372;
            }
          }
        }
        label356:
        label361:
        label367:
        label372:
        for (int j = ((FrameLayout)localObject2).getMeasuredWidth();; j = 0)
        {
          paramBitmap.zYO = j;
          paramBitmap.qmd = i;
          if ((paramInt != (((o)localObject1).zXP + 1) * o.zXR) && (paramInt != ((o)localObject1).mMaxCount - 1)) {
            break label495;
          }
          ((o)localObject1).isLoading = false;
          paramBitmap = ((o)localObject1).zXH;
          if (paramBitmap == null) {
            break label388;
          }
          Object localObject3 = (List)((o)localObject1).zXD;
          kotlin.g.b.p.h(localObject3, "bitmapList");
          localObject2 = new CopyOnWriteArrayList();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Bitmap localBitmap = (Bitmap)((Iterator)localObject3).next();
            if (localBitmap != null) {
              ((CopyOnWriteArrayList)localObject2).add(localBitmap);
            }
          }
          ((o)localObject1).zXD.set(paramInt, paramBitmap);
          break;
          i = 0;
          break label137;
          j = 0;
          break label156;
          i = 0;
          break label196;
        }
        paramBitmap.zXD = ((CopyOnWriteArrayList)localObject2);
        paramBitmap.notifyDataSetChanged();
        label388:
        if (((o)localObject1).zXP != ((o)localObject1).zXQ - 1)
        {
          paramBitmap = ((o)localObject1).zXH;
          if (paramBitmap != null)
          {
            paramBitmap.zYF = true;
            localObject1 = BitmapUtil.createBitmap((int)paramBitmap.zYD, (int)paramBitmap.zYE, Bitmap.Config.ARGB_8888);
            kotlin.g.b.p.g(localObject1, "BitmapUtil.createBitmap(…,Bitmap.Config.ARGB_8888)");
            kotlin.g.b.p.h(localObject1, "bitmap");
            paramBitmap.zXD.add(localObject1);
            paramBitmap.cj(paramBitmap.zXD.size() - 1);
            AppMethodBeat.o(239943);
            return;
          }
          AppMethodBeat.o(239943);
          return;
        }
        ((o)localObject1).jUX = true;
        label495:
        AppMethodBeat.o(239943);
        return;
      }
      AppMethodBeat.o(239943);
    }
    
    public final void cTA()
    {
      AppMethodBeat.i(239940);
      Log.i("MicroMsg.ScreenFileProjector", "xfile on user cancel finish");
      ac.eom().emx();
      AppMethodBeat.o(239940);
    }
    
    public final void epu()
    {
      AppMethodBeat.i(239944);
      a.b.a(this.zWo, a.c.zVv);
      AppMethodBeat.o(239944);
    }
    
    public final void epv() {}
    
    public final void epw() {}
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"})
  static final class d<T>
    implements ValueCallback<Integer>
  {
    d(f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.f
 * JD-Core Version:    0.7.0.1
 */