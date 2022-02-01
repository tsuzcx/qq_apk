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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.j.a;
import com.tencent.xweb.j.b;
import com.tencent.xweb.j.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "mCurrentIndex", "setMCurrentIndex", "(I)V", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "mCurrentViewStatus", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFileExt", "", "mFilePath", "setMFilePath", "(Ljava/lang/String;)V", "mMaxCount", "setMMaxCount", "mReaderLayout", "Landroid/widget/RelativeLayout;", "getMReaderLayout", "()Landroid/widget/RelativeLayout;", "setMReaderLayout", "(Landroid/widget/RelativeLayout;)V", "mThumbnailHasBeenRequest", "", "mToken", "setMToken", "thumbUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "getThumbUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "setThumbUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;)V", "thumbnailRoot", "Landroid/widget/FrameLayout;", "getThumbnailRoot", "()Landroid/widget/FrameLayout;", "setThumbnailRoot", "(Landroid/widget/FrameLayout;)V", "applyReaderUI", "", "applyThumbnailUI", "closeReaderRenderer", "dismissProjectScreen", "getBackgroundView", "Landroid/view/View;", "getCurrentFileMd5", "getLayoutId", "initView", "inputFileInfo", "params", "Landroid/os/Bundle;", "inputScreenProjectInfo", "pageIndex", "refreshView", "responeScreenClick", "showReaderContent", "show", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends k
{
  public static final f.a LxS;
  private j.b LxA;
  private FrameLayout LxT;
  private RelativeLayout LxU;
  private m LxV;
  private boolean LxW;
  private String mFilePath;
  private String mToken;
  private int sfk;
  private String tmM;
  private int xYG;
  
  static
  {
    AppMethodBeat.i(285846);
    LxS = new f.a((byte)0);
    AppMethodBeat.o(285846);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(285741);
    this.sfk = -1;
    this.xYG = -1;
    if (com.tencent.mm.plugin.multitalk.e.f.giW())
    {
      paramContext = new e.a();
      Object localObject = new int[1];
      localObject[0] = 1;
      s.u(localObject, "funcs");
      int i = 0;
      while (i <= 0)
      {
        int j = localObject[0];
        i += 1;
        paramContext.LxO.add(Integer.valueOf(j));
      }
      localObject = new e.c[1];
      String str = getContext().getResources().getString(a.h.screen_projector_clear_screen);
      s.s(str, "context.resources.getStr…n_projector_clear_screen)");
      localObject[0] = new e.c(str);
      s.u(localObject, "funcs");
      i = 0;
      while (i <= 0)
      {
        str = localObject[0];
        i += 1;
        paramContext.LxP.add(str);
      }
      paramContext = paramContext.I(new int[] { 9, 10 });
      paramContext.type = 2;
      setScreenFuncConfig(paramContext.gid());
    }
    for (;;)
    {
      LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup)this);
      this.LxU = ((RelativeLayout)findViewById(a.e.screen_projector_reader_layout));
      setMReadyLayout((FrameLayout)findViewById(a.e.screen_project_ready_stroke));
      setMEditLayout((FrameLayout)findViewById(a.e.screen_projector_edit_layout));
      setBottomRoot((FrameLayout)findViewById(a.e.screen_project_bottom_ui));
      setTopRoot((FrameLayout)findViewById(a.e.screen_project_top_ui));
      setAvatarRoot((FrameLayout)findViewById(a.e.screen_projector_avatar_layout));
      this.LxT = ((FrameLayout)findViewById(a.e.screen_projector_reader_thumb_layout));
      paramContext = this.LxU;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = getMEditLayout();
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = getContext();
      s.s(paramContext, "context");
      setMultiTalkStrokeContext(new b(paramContext, (a)this, getScreenFuncConfig()));
      paramContext = getMultiTalkStrokeContext();
      if (paramContext != null) {
        paramContext.LxC = ((kotlin.g.a.b)new c(this));
      }
      paramContext = getContext();
      s.s(paramContext, "context");
      setTopUiLayout(new n(paramContext, (a)this));
      paramContext = getContext();
      s.s(paramContext, "context");
      setAvatarLayout(new i(paramContext, (a)this));
      paramContext = getContext();
      s.s(paramContext, "context");
      setBottomUiLayout(new j(paramContext, (a)this, getScreenFuncConfig()));
      paramContext = getContext();
      s.s(paramContext, "context");
      this.LxV = new m(paramContext, (a)this);
      paramContext = getContext();
      s.s(paramContext, "context");
      setReadyUI(new p(paramContext, (a)this, getScreenFuncConfig()));
      setMScreenReportData(new q());
      refreshView();
      AppMethodBeat.o(285741);
      return;
      paramContext = new e.a().I(new int[] { 9, 10 });
      paramContext.type = 2;
      setScreenFuncConfig(paramContext.gid());
    }
  }
  
  private static final void a(f paramf, Integer paramInteger)
  {
    AppMethodBeat.i(285795);
    s.u(paramf, "this$0");
    if (paramInteger == null)
    {
      if (paramInteger != null) {
        break label85;
      }
      label21:
      aa.dc(paramf.getContext(), paramf.getContext().getString(a.h.screen_projector_open_file_errcode));
    }
    for (;;)
    {
      paramf = paramf.getMScreenReportData();
      if (paramf != null)
      {
        s.s(paramInteger, "value");
        paramf.errorCode = paramInteger.intValue();
      }
      ac.ggS().gfc();
      do
      {
        AppMethodBeat.o(285795);
        return;
      } while (paramInteger.intValue() == 0);
      break;
      label85:
      if (-17 != paramInteger.intValue()) {
        break label21;
      }
      aa.dc(paramf.getContext(), paramf.getContext().getString(a.h.file_security_err_tip_1));
    }
  }
  
  private void aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(285789);
    s.u(paramBundle, "params");
    setVisibility(0);
    if (this.mToken == null) {
      setMToken(hashCode() + System.currentTimeMillis());
    }
    setMFilePath(paramBundle.getString("file_path"));
    this.tmM = paramBundle.getString("file_ext");
    if ((this.mFilePath != null) && (this.tmM != null))
    {
      paramBundle = this.mFilePath;
      s.checkNotNull(paramBundle);
      paramBundle = new com.tencent.mm.vfs.u(paramBundle);
      if ((!paramBundle.jKS()) || (!paramBundle.jKV())) {
        AppMethodBeat.o(285789);
      }
    }
    else
    {
      AppMethodBeat.o(285789);
      return;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.lPJ = this.tmM;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.fileName = this.mFilePath;
    }
    paramBundle = getMScreenReportData();
    if (paramBundle != null) {
      paramBundle.fileSize = y.bEl(this.mFilePath);
    }
    paramBundle = new HashMap();
    ((Map)paramBundle).put("extra_param_disable_scale", "false");
    ((Map)paramBundle).put("extra_param_enable_receive_view_status_change", "true");
    ((Map)paramBundle).put("extra_param_bg_color", String.valueOf(getResources().getColor(com.tencent.mm.plugin.multitalk.a.b.Dark_2)));
    ((Map)paramBundle).put("extra_param_disable_finish_activity", "true");
    ((Map)paramBundle).put("extra_param_disable_password", "true");
    ((Map)paramBundle).put("extra_param_set_max_scale", "3");
    String str1 = this.mFilePath;
    String str2 = this.tmM;
    String str3 = this.mToken;
    j.c localc = j.c.aieR;
    Context localContext = getContext();
    if (localContext == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(285789);
      throw paramBundle;
    }
    com.tencent.xweb.j.a(str1, str2, str3, true, paramBundle, localc, (Activity)localContext, (ViewGroup)this.LxU, (j.a)new d(this), new f..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(285789);
  }
  
  private final void setMCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(285775);
    this.xYG = paramInt;
    Object localObject = getMultiTalkStrokeContext();
    if (localObject != null)
    {
      ((b)localObject).yag = paramInt;
      localObject = ((b)localObject).LxC;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
      }
    }
    localObject = this.LxV;
    if (localObject != null)
    {
      l locall = ((m)localObject).Lzm;
      if (locall != null) {
        locall.xYG = paramInt;
      }
      ((m)localObject).xYG = paramInt;
    }
    AppMethodBeat.o(285775);
  }
  
  private final void setMFilePath(String paramString)
  {
    AppMethodBeat.i(285769);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.mFilePath = paramString;
    }
    this.mFilePath = paramString;
    AppMethodBeat.o(285769);
  }
  
  private final void setMMaxCount(int paramInt)
  {
    AppMethodBeat.i(285750);
    this.sfk = paramInt;
    Object localObject1 = getMultiTalkStrokeContext();
    if (localObject1 != null) {
      ((b)localObject1).FsK = paramInt;
    }
    localObject1 = this.LxV;
    if (localObject1 != null)
    {
      Object localObject2 = ((m)localObject1).Lzm;
      if (localObject2 != null) {
        ((l)localObject2).sfk = paramInt;
      }
      localObject2 = ((m)localObject1).Lzj;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).sfk = paramInt;
      }
      ((m)localObject1).Lzs = (paramInt / m.Lzt + 1);
      ((m)localObject1).sfk = paramInt;
    }
    AppMethodBeat.o(285750);
  }
  
  private final void setMToken(String paramString)
  {
    AppMethodBeat.i(285760);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.mToken = paramString;
    }
    this.mToken = paramString;
    AppMethodBeat.o(285760);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(285971);
    s.u(paramc, "status");
    super.a(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label419:
    for (;;)
    {
      AppMethodBeat.o(285971);
      return;
      paramc = this.LxV;
      if (paramc != null)
      {
        paramc.hide();
        AppMethodBeat.o(285971);
        return;
        paramc = this.LxV;
        if (paramc != null)
        {
          paramc.show();
          AppMethodBeat.o(285971);
          return;
          if (paramBundle != null)
          {
            i = paramBundle.getInt("thumb_flip_target_position");
            ghZ();
            com.tencent.xweb.j.aV(this.mToken, this.mFilePath, i);
            AppMethodBeat.o(285971);
            return;
            if (!gio())
            {
              int k = this.xYG + 1;
              i = j;
              if (k >= 0)
              {
                i = j;
                if (k < this.sfk) {
                  i = 1;
                }
              }
              if (i != 0)
              {
                ghZ();
                paramc = this.LxV;
                if (paramc != null)
                {
                  paramc.acb(k);
                  AppMethodBeat.o(285971);
                }
              }
              else
              {
                aa.showTextToast(getContext(), "没有更多内容");
                AppMethodBeat.o(285971);
                return;
                if (!gio())
                {
                  j = this.xYG - 1;
                  if (j >= 0) {
                    if (j >= this.sfk) {}
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      break label308;
                    }
                    ghZ();
                    paramc = this.LxV;
                    if (paramc == null) {
                      break;
                    }
                    paramc.acb(j);
                    AppMethodBeat.o(285971);
                    return;
                    i = 0;
                    continue;
                    i = 0;
                  }
                  label308:
                  aa.showTextToast(getContext(), "没有更多内容");
                  AppMethodBeat.o(285971);
                  return;
                  if (paramBundle != null)
                  {
                    i = paramBundle.getInt("thumb_current_page");
                    paramc = m.Lze;
                    j = m.git() * i;
                    paramc = m.Lze;
                    if ((i + 1) * m.git() < this.sfk) {
                      paramc = m.Lze;
                    }
                    for (i = (i + 1) * m.git();; i = this.sfk)
                    {
                      if (j > i) {
                        break label419;
                      }
                      for (;;)
                      {
                        com.tencent.xweb.j.aW(this.mToken, this.mFilePath, j);
                        if (j == i) {
                          break;
                        }
                        j += 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(285909);
    if (paramBundle != null)
    {
      setVisibility(0);
      aJ(paramBundle);
      zt(true);
    }
    AppMethodBeat.o(285909);
  }
  
  public final View getBackgroundView()
  {
    return (View)this.LxU;
  }
  
  public final String getCurrentFileMd5()
  {
    AppMethodBeat.i(285977);
    String str = y.bub(this.mFilePath);
    AppMethodBeat.o(285977);
    return str;
  }
  
  public final int getLayoutId()
  {
    return a.f.multitalk_screen_project_main;
  }
  
  protected final j.b getMCurrentViewStatus()
  {
    return this.LxA;
  }
  
  protected final RelativeLayout getMReaderLayout()
  {
    return this.LxU;
  }
  
  protected final m getThumbUiLayout()
  {
    return this.LxV;
  }
  
  protected final FrameLayout getThumbnailRoot()
  {
    return this.LxT;
  }
  
  public final void gie()
  {
    AppMethodBeat.i(285925);
    setMToken(null);
    super.gie();
    AppMethodBeat.o(285925);
  }
  
  public final void gif()
  {
    AppMethodBeat.i(285933);
    super.gif();
    com.tencent.xweb.j.qS(this.mToken, this.mFilePath);
    setMToken(null);
    setMFilePath(null);
    AppMethodBeat.o(285933);
  }
  
  public final int gig()
  {
    AppMethodBeat.i(285937);
    int i = super.gig();
    FrameLayout localFrameLayout = this.LxT;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(i);
    }
    AppMethodBeat.o(285937);
    return i;
  }
  
  public final void gih()
  {
    AppMethodBeat.i(285952);
    Object localObject3 = this.LxT;
    Object localObject1;
    Object localObject2;
    if (localObject3 != null)
    {
      ((FrameLayout)localObject3).removeAllViews();
      localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
      localObject1 = getContext();
      s.s(localObject1, "context");
      if (k.a.iY((Context)localObject1) != 90)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        localObject1 = getContext();
        s.s(localObject1, "context");
        if (k.a.iY((Context)localObject1) != 270) {
          break label720;
        }
      }
      localObject1 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.Luo, -1);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(17);
      localObject2 = getTopRoot();
      s.checkNotNull(localObject2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(17, ((FrameLayout)localObject2).getId());
      localObject2 = getBottomRoot();
      s.checkNotNull(localObject2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(16, ((FrameLayout)localObject2).getId());
      ((FrameLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject2 = getThumbUiLayout();
      if (localObject2 != null)
      {
        localObject1 = getContext();
        s.s(localObject1, "context");
        s.u(localObject1, "context");
        s.u(localObject3, "viewGroup");
        ((m)localObject2).Lzg = LayoutInflater.from((Context)localObject1).inflate(a.f.multitalk_screen_project_thumbnail, (ViewGroup)localObject3);
        ((m)localObject2).Lzm = new l(((m)localObject2).Lsq);
        localObject1 = ((m)localObject2).Lzg;
        if (localObject1 != null) {
          break label799;
        }
        localObject1 = null;
        label231:
        ((m)localObject2).Lzl = ((FrameLayout)localObject1);
        localObject1 = ((m)localObject2).Lzg;
        if (localObject1 != null) {
          break label813;
        }
        localObject1 = null;
        label247:
        ((m)localObject2).Lzn = ((FrameLayout)localObject1);
        localObject1 = ((m)localObject2).Lzg;
        if (localObject1 != null) {
          break label827;
        }
        localObject1 = null;
        label263:
        ((m)localObject2).Lzo = ((View)localObject1);
        localObject1 = ((m)localObject2).Lzn;
        if (localObject1 != null)
        {
          ((FrameLayout)localObject1).removeAllViews();
          localObject3 = ((m)localObject2).Lzm;
          if (localObject3 != null) {
            ((l)localObject3).f(((m)localObject2).context, (FrameLayout)localObject1);
          }
          localObject1 = ((m)localObject2).Lzd;
          if (localObject1 != null)
          {
            localObject3 = ((m)localObject2).Lzm;
            if (localObject3 != null) {
              ((l)localObject3).aNJ((String)localObject1);
            }
          }
          localObject1 = ((m)localObject2).Lzm;
          if (localObject1 != null) {
            ((l)localObject1).xYG = ((m)localObject2).xYG;
          }
          localObject1 = ((m)localObject2).Lzm;
          if (localObject1 != null) {
            ((l)localObject1).sfk = ((m)localObject2).sfk;
          }
        }
        localObject1 = ((m)localObject2).Lzg;
        if (localObject1 != null) {
          break label838;
        }
        localObject1 = null;
        label368:
        ((m)localObject2).Lzk = ((RecyclerView)localObject1);
        ((m)localObject2).Lzi = new e(((m)localObject2).context);
        ((m)localObject2).Lzj = new com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b(((m)localObject2).Lzk, ((m)localObject2).context);
        ((m)localObject2).Lzh = new ScreenThumbLayoutManager(((m)localObject2).Lzk, ((m)localObject2).context);
        localObject1 = ((m)localObject2).Lzk;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setOnScrollListener((RecyclerView.l)new m.b((m)localObject2, ((m)localObject2).Lzh));
        }
        localObject1 = ((m)localObject2).Lzj;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject1).LAb = ((kotlin.g.a.m)new m.c((m)localObject2));
        }
        localObject1 = ((m)localObject2).Lzk;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)((m)localObject2).Lzh);
        }
        localObject1 = ((m)localObject2).Lzk;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setAdapter((RecyclerView.a)((m)localObject2).Lzj);
        }
        localObject1 = ((m)localObject2).Lzk;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setItemAnimator(null);
        }
        localObject1 = ((m)localObject2).Lzi;
        if (localObject1 != null)
        {
          localObject3 = ((m)localObject2).Lzk;
          if (localObject3 != null) {
            ((RecyclerView)localObject3).b((RecyclerView.h)localObject1);
          }
          localObject3 = ((m)localObject2).Lzk;
          if (localObject3 != null) {
            ((RecyclerView)localObject3).a((RecyclerView.h)localObject1);
          }
        }
        if (((m)localObject2).xYG != -1)
        {
          localObject1 = ((m)localObject2).Lzk;
          if (localObject1 != null)
          {
            localObject3 = c.a(((m)localObject2).xYG, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyClickEvent", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyClickEvent", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
        }
        if (!((m)localObject2).Lsq.ghV()) {
          break label852;
        }
        ((m)localObject2).hide();
      }
    }
    for (;;)
    {
      localObject1 = ((m)localObject2).Lzm;
      if (localObject1 != null) {
        ((l)localObject1).exz();
      }
      localObject1 = ((m)localObject2).Lzn;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(4);
      }
      AppMethodBeat.o(285952);
      return;
      label720:
      localObject1 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.Luo);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(17);
      localObject2 = getBottomRoot();
      s.checkNotNull(localObject2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(2, ((FrameLayout)localObject2).getId());
      localObject2 = getTopRoot();
      s.checkNotNull(localObject2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((FrameLayout)localObject2).getId());
      break;
      label799:
      localObject1 = (FrameLayout)((View)localObject1).findViewById(a.e.screen_projector_reader_thumb_layout);
      break label231;
      label813:
      localObject1 = (FrameLayout)((View)localObject1).findViewById(a.e.screen_thumb_index_layout_root);
      break label247;
      label827:
      localObject1 = ((View)localObject1).findViewById(a.e.multitalk_shadow_bg);
      break label263;
      label838:
      localObject1 = (RecyclerView)((View)localObject1).findViewById(a.e.screen_thumb_layout);
      break label368;
      label852:
      ((m)localObject2).show();
    }
  }
  
  protected final void gii()
  {
    AppMethodBeat.i(285957);
    RelativeLayout localRelativeLayout = this.LxU;
    RelativeLayout.LayoutParams localLayoutParams;
    Object localObject;
    if (localRelativeLayout != null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
      localObject = getContext();
      s.s(localObject, "context");
      if (k.a.iY((Context)localObject) != 90)
      {
        localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        localObject = getContext();
        s.s(localObject, "context");
        if (k.a.iY((Context)localObject) != 270) {
          break label149;
        }
      }
      localLayoutParams.removeRule(16);
      localLayoutParams.removeRule(3);
      localLayoutParams.removeRule(17);
      localLayoutParams.removeRule(2);
      localObject = getTopRoot();
      s.checkNotNull(localObject);
      localLayoutParams.addRule(17, ((FrameLayout)localObject).getId());
      localObject = getBottomRoot();
      s.checkNotNull(localObject);
      localLayoutParams.addRule(16, ((FrameLayout)localObject).getId());
    }
    for (;;)
    {
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(285957);
      return;
      label149:
      localLayoutParams.removeRule(16);
      localLayoutParams.removeRule(3);
      localLayoutParams.removeRule(17);
      localLayoutParams.removeRule(2);
      localObject = getTopRoot();
      s.checkNotNull(localObject);
      localLayoutParams.addRule(3, ((FrameLayout)localObject).getId());
      localObject = getBottomRoot();
      s.checkNotNull(localObject);
      localLayoutParams.addRule(2, ((FrameLayout)localObject).getId());
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(285961);
    this.LxW = false;
    super.refreshView();
    m localm = this.LxV;
    if (localm != null) {
      localm.gir();
    }
    AppMethodBeat.o(285961);
  }
  
  protected final void setMCurrentViewStatus(j.b paramb)
  {
    AppMethodBeat.i(285891);
    b localb = getMultiTalkStrokeContext();
    if (localb != null) {
      localb.LxA = paramb;
    }
    this.LxA = paramb;
    AppMethodBeat.o(285891);
  }
  
  protected final void setMReaderLayout(RelativeLayout paramRelativeLayout)
  {
    this.LxU = paramRelativeLayout;
  }
  
  protected final void setThumbUiLayout(m paramm)
  {
    this.LxV = paramm;
  }
  
  protected final void setThumbnailRoot(FrameLayout paramFrameLayout)
  {
    this.LxT = paramFrameLayout;
  }
  
  public final void zt(boolean paramBoolean)
  {
    AppMethodBeat.i(285905);
    super.zt(paramBoolean);
    RelativeLayout localRelativeLayout = this.LxU;
    if (localRelativeLayout != null) {
      if (!paramBoolean) {
        break label38;
      }
    }
    label38:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      AppMethodBeat.o(285905);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pageIndex", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements j.a
  {
    d(f paramf) {}
    
    public final void Pc(int paramInt)
    {
      AppMethodBeat.i(285860);
      Log.i("MicroMsg.ScreenFileProjector", s.X("xfile onPageCountUpdate ", Integer.valueOf(paramInt)));
      f.a(this.LxX, paramInt);
      Object localObject = this.LxX.getMScreenReportData();
      if (localObject != null) {
        ((q)localObject).LzB = f.a(this.LxX);
      }
      localObject = this.LxX.getThumbUiLayout();
      if (localObject != null) {
        ((m)localObject).aNJ(f.b(this.LxX) + 1 + '/' + paramInt);
      }
      AppMethodBeat.o(285860);
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(285898);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onViewStatusChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3 + " and scale " + paramFloat + " and transX " + paramInt4 + " and " + paramInt5);
      Object localObject = this.LxX.getMultiTalkStrokeContext();
      if (localObject != null)
      {
        localObject = ((b)localObject).LxB;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).Lss;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).Lsf;
            if (localObject != null)
            {
              localObject = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject).getBaseBoardView();
              if (localObject != null) {
                ((com.tencent.mm.view.b.b)localObject).i(paramFloat, paramInt4, paramInt5);
              }
            }
          }
        }
      }
      AppMethodBeat.o(285898);
    }
    
    public final void ay(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(285890);
      Log.i("MicroMsg.ScreenFileProjector", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
      Object localObject1;
      Object localObject2;
      float f2;
      float f3;
      if ((paramInt1 > f.b(this.LxX)) && (f.b(this.LxX) != -1))
      {
        this.LxX.ghZ();
        localObject1 = g.LAS;
        g.gjp();
        a.b.a((a)this.LxX, a.c.Lxi);
        if (!f.c(this.LxX))
        {
          f.d(this.LxX);
          localObject1 = this.LxX.getThumbUiLayout();
          if (localObject1 != null) {
            ((m)localObject1).gir();
          }
        }
        f.b(this.LxX, paramInt1);
        this.LxX.setMCurrentScale(1.0F);
        this.LxX.setMCurrentPageWidth(paramInt2);
        this.LxX.setMCurrentPageHeight(paramInt3);
        localObject1 = this.LxX.getThumbUiLayout();
        int i;
        int j;
        if (localObject1 != null)
        {
          i = this.LxX.getMCurrentPageWidth();
          j = this.LxX.getMCurrentPageHeight();
          ((m)localObject1).Lzp = i;
          ((m)localObject1).Lzq = j;
          localObject2 = ((m)localObject1).Lzj;
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).xYG = paramInt1;
            float f1 = i / j;
            f2 = i / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAd;
            f2 = j / f2;
            if (f2 <= com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAe) {
              break label1114;
            }
            f3 = j / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAe;
            f3 = i / f3;
            if (f3 <= com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAd) {
              break label1069;
            }
            f3 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAf;
            f2 = f3 / f1;
            f1 = f2;
            if (f2 > com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAe) {
              f1 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAe;
            }
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzZ = f1;
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzY = f3;
            label331:
            if ((((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzW != -1) && (((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzX != -1)) {
              ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).fV(paramInt1);
            }
          }
          localObject1 = ((m)localObject1).Lzk;
          if (localObject1 != null)
          {
            localObject2 = c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
        }
        this.LxX.setMCurrentViewStatus(com.tencent.xweb.j.qT(f.e(this.LxX), f.f(this.LxX)));
        if ((paramInt2 > 0) && (paramInt3 > 0) && (this.LxX.getMCurrentViewStatus() != null))
        {
          localObject1 = this.LxX.getMultiTalkStrokeContext();
          if (localObject1 != null) {
            ((b)localObject1).Lxz = this.LxX.getMCurrentPageHeight();
          }
          localObject1 = this.LxX.getMultiTalkStrokeContext();
          if (localObject1 != null) {
            ((b)localObject1).Lxy = this.LxX.getMCurrentPageWidth();
          }
          localObject1 = this.LxX.getMultiTalkStrokeContext();
          if (localObject1 != null)
          {
            s.checkNotNull(this.LxX.getMCurrentViewStatus());
            s.checkNotNull(this.LxX.getMCurrentViewStatus());
            ((b)localObject1).Lxx = 1.0F;
          }
          localObject1 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
          localObject2 = this.LxX.getMCurrentViewStatus();
          s.checkNotNull(localObject2);
          paramInt1 = ((j.b)localObject2).aieO;
          localObject2 = this.LxX.getMCurrentViewStatus();
          s.checkNotNull(localObject2);
          paramInt2 = ((j.b)localObject2).aieP;
          paramInt3 = this.LxX.getMCurrentPageWidth();
          localObject2 = this.LxX.getMCurrentViewStatus();
          s.checkNotNull(localObject2);
          i = ((j.b)localObject2).aieO;
          j = this.LxX.getMCurrentPageHeight();
          localObject2 = this.LxX.getMCurrentViewStatus();
          s.checkNotNull(localObject2);
          localObject2 = new Rect(paramInt1, paramInt2, paramInt3 + i, j + ((j.b)localObject2).aieP);
          s.u(localObject2, "<set-?>");
          ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).rect = ((Rect)localObject2);
          Object localObject3 = this.LxX.getMultiTalkStrokeContext();
          if (localObject3 != null)
          {
            localObject2 = (kotlin.g.a.a)new f.d.a(this.LxX);
            s.u(localObject1, "config");
            localObject3 = ((b)localObject3).LxB;
            if (localObject3 != null)
            {
              s.u(localObject1, "config");
              com.tencent.mm.plugin.multitalk.ui.a.a locala = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject3).Lss;
              ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject3).Lsq.ghU();
              locala.a((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, (kotlin.g.a.a)localObject2);
            }
          }
          localObject1 = this.LxX;
          localObject2 = ((k)localObject1).LyG;
          if (localObject2 != null)
          {
            localObject2 = ((b)localObject2).Lxw;
            if (localObject2 != null) {
              ((FrameLayout)localObject2).setVisibility(0);
            }
          }
          if ((!((k)localObject1).LyN) && (!((k)localObject1).LyQ))
          {
            a.b.a((a)localObject1, a.c.LwX);
            localObject1 = ((k)localObject1).LyK;
            if (localObject1 != null)
            {
              if (((n)localObject1).Lzy == null) {
                break label1132;
              }
              localObject2 = ((n)localObject1).Lzy;
              if (localObject2 != null) {
                ((ImageView)localObject2).setBackground(bb.m(((n)localObject1).context, a.g.icons_filled_stop, Color.parseColor("#FA5151")));
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = ((n)localObject1).xeE;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = this.LxX.getThumbUiLayout();
        if (localObject1 != null) {
          ((m)localObject1).aNJ(f.b(this.LxX) + 1 + '/' + f.a(this.LxX));
        }
        AppMethodBeat.o(285890);
        return;
        if ((paramInt1 >= f.b(this.LxX)) || (f.b(this.LxX) == -1)) {
          break;
        }
        this.LxX.ghZ();
        localObject1 = g.LAS;
        g.gjp();
        a.b.a((a)this.LxX, a.c.Lxj);
        break;
        label1069:
        if (f3 < com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAf)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzZ = f2;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzY = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAf;
          break label331;
        }
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzZ = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAe;
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzY = f3;
        break label331;
        label1114:
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzZ = f2;
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzY = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.LAd;
        break label331;
        label1132:
        localObject2 = ((n)localObject1).Lzw;
        if (localObject2 != null) {
          ((View)localObject2).setBackground(bb.m(((n)localObject1).context, a.d.green_rect_link, Color.parseColor("#FA5151")));
        }
        localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        if (k.a.iY(((n)localObject1).context) != 90)
        {
          localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
          if (k.a.iY(((n)localObject1).context) != 270) {}
        }
        else
        {
          localObject2 = ((n)localObject1).Lzx;
          if (localObject2 == null) {
            continue;
          }
          ((TextView)localObject2).setText(a.h.screen_projector_pause_btn);
          continue;
        }
        localObject2 = ((n)localObject1).Lzx;
        if (localObject2 != null) {
          ((TextView)localObject2).setText(a.h.screen_project_pause);
        }
      }
    }
    
    public final void bSt()
    {
      AppMethodBeat.i(285864);
      Log.i("MicroMsg.ScreenFileProjector", "xfile on user cancel finish");
      ac.ggS().gfc();
      AppMethodBeat.o(285864);
    }
    
    public final void c(int paramInt, Bitmap paramBitmap)
    {
      AppMethodBeat.i(285912);
      s.u(paramBitmap, "thumbnail");
      Log.i("MicroMsg.ScreenFileProjector", s.X("xfile onThumbnailLoad ", Integer.valueOf(paramInt)));
      Object localObject1 = this.LxX.getThumbUiLayout();
      if (localObject1 != null)
      {
        s.u(paramBitmap, "thumbnail");
        Object localObject2;
        int i;
        if (((m)localObject1).Lzf.size() <= paramInt)
        {
          ((m)localObject1).Lzf.add(paramBitmap);
          localObject2 = ((m)localObject1).Lzj;
          if (localObject2 != null)
          {
            s.u(paramBitmap, "bitmap");
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzW = paramBitmap.getWidth();
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzX = paramBitmap.getHeight();
          }
          paramBitmap = ((m)localObject1).Lzi;
          if (paramBitmap != null)
          {
            localObject2 = ((m)localObject1).Lzj;
            if (localObject2 != null) {
              break label338;
            }
            i = 0;
            label132:
            localObject2 = ((m)localObject1).Lzl;
            if (localObject2 != null) {
              break label348;
            }
            j = 0;
            label147:
            paramBitmap.contentWidth = j;
            paramBitmap.wLI = i;
          }
          paramBitmap = ((m)localObject1).Lzh;
          if (paramBitmap != null)
          {
            localObject2 = ((m)localObject1).Lzj;
            if (localObject2 != null) {
              break label358;
            }
            i = 0;
            label182:
            localObject2 = ((m)localObject1).Lzl;
            if (localObject2 != null) {
              break label368;
            }
          }
        }
        label338:
        label348:
        label358:
        label368:
        for (int j = 0;; j = ((FrameLayout)localObject2).getMeasuredWidth())
        {
          paramBitmap.contentWidth = j;
          paramBitmap.wLI = i;
          if ((paramInt != (((m)localObject1).Lzr + 1) * m.Lzt) && (paramInt != ((m)localObject1).sfk - 1)) {
            break label491;
          }
          ((m)localObject1).isLoading = false;
          paramBitmap = ((m)localObject1).Lzj;
          if (paramBitmap == null) {
            break label391;
          }
          Object localObject3 = (List)((m)localObject1).Lzf;
          s.u(localObject3, "bitmapList");
          localObject2 = new CopyOnWriteArrayList();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Bitmap localBitmap = (Bitmap)((Iterator)localObject3).next();
            if (localBitmap != null) {
              ((CopyOnWriteArrayList)localObject2).add(localBitmap);
            }
          }
          ((m)localObject1).Lzf.set(paramInt, paramBitmap);
          break;
          i = (int)((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzY;
          break label132;
          j = ((FrameLayout)localObject2).getMeasuredWidth();
          break label147;
          i = (int)((com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b)localObject2).LzY;
          break label182;
        }
        paramBitmap.Lzf = ((CopyOnWriteArrayList)localObject2);
        paramBitmap.bZE.notifyChanged();
        label391:
        if (((m)localObject1).Lzr != ((m)localObject1).Lzs - 1)
        {
          paramBitmap = ((m)localObject1).Lzj;
          if (paramBitmap != null)
          {
            paramBitmap.LAa = true;
            localObject1 = BitmapUtil.createBitmap((int)paramBitmap.LzY, (int)paramBitmap.LzZ, Bitmap.Config.ARGB_8888);
            s.s(localObject1, "createBitmap(mCurrentWid…,Bitmap.Config.ARGB_8888)");
            s.u(localObject1, "bitmap");
            paramBitmap.Lzf.add(localObject1);
            paramBitmap.fW(paramBitmap.Lzf.size() - 1);
            AppMethodBeat.o(285912);
          }
        }
        else
        {
          ((m)localObject1).pIS = true;
        }
      }
      label491:
      AppMethodBeat.o(285912);
    }
    
    public final void erQ()
    {
      AppMethodBeat.i(285921);
      a.b.a((a)this.LxX, a.c.Lxh);
      AppMethodBeat.o(285921);
    }
    
    public final void erR() {}
    
    public final void erS() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.f
 * JD-Core Version:    0.7.0.1
 */