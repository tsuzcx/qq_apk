package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.h;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "filePath", "", "fileExt", "scene", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "getFileExt", "()Ljava/lang/String;", "setFileExt", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "isShowChangeOrientationTip", "", "pluginControlLayout", "Landroid/widget/RelativeLayout;", "getPluginControlLayout", "()Landroid/widget/RelativeLayout;", "setPluginControlLayout", "(Landroid/widget/RelativeLayout;)V", "profilePluginUi", "Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "getProfilePluginUi", "()Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "setProfilePluginUi", "(Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;)V", "readerContentLayout", "getReaderContentLayout", "setReaderContentLayout", "applyPluginLayout", "", "applyReaderLayout", "checkRatioIsLand", "w", "h", "inputFileInfo", "refreshLayout", "release", "showProfileUi", "showRotateScreenInfo", "Companion", "app_release"})
public final class am
  extends FrameLayout
{
  public static final am.a WEb;
  private RelativeLayout WDX;
  private RelativeLayout WDY;
  aj WDZ;
  private boolean WEa;
  private String filePath;
  private String jmx;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(285653);
    WEb = new am.a((byte)0);
    AppMethodBeat.o(285653);
  }
  
  public am(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(285652);
    this.filePath = paramString1;
    this.jmx = paramString2;
    this.scene = paramInt;
    LayoutInflater.from(paramContext).inflate(R.i.screen_profile_ready_main, (ViewGroup)this);
    this.WDX = ((RelativeLayout)findViewById(R.h.screen_profile_content_ui));
    this.WDY = ((RelativeLayout)findViewById(R.h.screen_profile_plugin_ui));
    this.WDZ = new aj(paramContext, this.filePath, this.scene, (byte)0);
    hNy();
    hNx();
    AppMethodBeat.o(285652);
  }
  
  public static boolean mz(int paramInt1, int paramInt2)
  {
    return paramInt1 / paramInt2 >= 1.333333F;
  }
  
  private final void nX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(285649);
    Object localObject1 = new File(paramString1);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile()))
    {
      AppMethodBeat.o(285649);
      return;
    }
    switch (this.scene)
    {
    default: 
      localObject1 = h.c.aaai;
    }
    HashMap localHashMap;
    long l1;
    long l2;
    for (;;)
    {
      localHashMap = new HashMap();
      ((Map)localHashMap).put("extra_param_disable_scale", "false");
      ((Map)localHashMap).put("extra_param_bg_color", String.valueOf(Color.parseColor("#ededed")));
      ((Map)localHashMap).put("extra_param_disable_finish_activity", "true");
      ((Map)localHashMap).put("extra_param_set_max_scale", "3");
      ((Map)localHashMap).put("extra_param_disable_password", "true");
      ((Map)localHashMap).put("extra_param_download_text_color", "-16777216");
      localObject2 = k.Fzb;
      localObject2 = u.buc(paramString1);
      p.j(localObject2, "VFSFileOp.getFileMD5String(filePath)");
      k.a.aQK((String)localObject2);
      l1 = hashCode();
      l2 = System.currentTimeMillis();
      localObject2 = getContext();
      if (localObject2 != null) {
        break;
      }
      paramString1 = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(285649);
      throw paramString1;
      localObject1 = h.c.aaai;
      continue;
      localObject1 = h.c.aaah;
    }
    Object localObject2 = (Activity)localObject2;
    RelativeLayout localRelativeLayout = this.WDX;
    if (localRelativeLayout == null)
    {
      paramString1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(285649);
      throw paramString1;
    }
    h.a(paramString1, paramString2, String.valueOf(l1 + l2), true, localHashMap, (h.c)localObject1, (Activity)localObject2, (ViewGroup)localRelativeLayout, (h.a)new b(this), (ValueCallback)new c(this));
    AppMethodBeat.o(285649);
  }
  
  public final String getFileExt()
  {
    return this.jmx;
  }
  
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final RelativeLayout getPluginControlLayout()
  {
    return this.WDY;
  }
  
  public final aj getProfilePluginUi()
  {
    return this.WDZ;
  }
  
  public final RelativeLayout getReaderContentLayout()
  {
    return this.WDX;
  }
  
  public final void hNx()
  {
    AppMethodBeat.i(285645);
    Object localObject1 = this.WDX;
    if (localObject1 != null)
    {
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(285645);
          throw ((Throwable)localObject1);
        }
        Object localObject2 = k.Fzb;
        localObject2 = getContext();
        p.j(localObject2, "context");
        if (k.a.hB((Context)localObject2) != 90)
        {
          localObject2 = k.Fzb;
          localObject2 = getContext();
          p.j(localObject2, "context");
          if (k.a.hB((Context)localObject2) != 270) {}
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(f.Fyg);
          AppMethodBeat.o(285645);
          return;
        }
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = f.Fyg;
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
        AppMethodBeat.o(285645);
        return;
      }
    }
    AppMethodBeat.o(285645);
  }
  
  public final void hNy()
  {
    AppMethodBeat.i(285646);
    RelativeLayout localRelativeLayout = this.WDY;
    if (localRelativeLayout != null)
    {
      Object localObject = this.WDY;
      if (localObject != null) {
        ((RelativeLayout)localObject).removeAllViews();
      }
      localObject = k.Fzb;
      localObject = getContext();
      p.j(localObject, "context");
      if (k.a.hB((Context)localObject) != 90)
      {
        localObject = k.Fzb;
        localObject = getContext();
        p.j(localObject, "context");
        if (k.a.hB((Context)localObject) != 270) {}
      }
      else
      {
        localObject = this.WDZ;
        if (localObject != null)
        {
          ((aj)localObject).S((ViewGroup)localRelativeLayout);
          AppMethodBeat.o(285646);
          return;
        }
        AppMethodBeat.o(285646);
        return;
      }
      localObject = this.WDZ;
      if (localObject != null)
      {
        ((aj)localObject).R((ViewGroup)localRelativeLayout);
        AppMethodBeat.o(285646);
        return;
      }
      AppMethodBeat.o(285646);
      return;
    }
    AppMethodBeat.o(285646);
  }
  
  public final void hNz()
  {
    AppMethodBeat.i(285647);
    nX(this.filePath, this.jmx);
    AppMethodBeat.o(285647);
  }
  
  public final void release()
  {
    AppMethodBeat.i(285644);
    aj localaj = this.WDZ;
    if (localaj != null)
    {
      localaj.release();
      AppMethodBeat.o(285644);
      return;
    }
    AppMethodBeat.o(285644);
  }
  
  public final void setFileExt(String paramString)
  {
    AppMethodBeat.i(285651);
    p.k(paramString, "<set-?>");
    this.jmx = paramString;
    AppMethodBeat.o(285651);
  }
  
  public final void setFilePath(String paramString)
  {
    AppMethodBeat.i(285650);
    p.k(paramString, "<set-?>");
    this.filePath = paramString;
    AppMethodBeat.o(285650);
  }
  
  public final void setPluginControlLayout(RelativeLayout paramRelativeLayout)
  {
    this.WDY = paramRelativeLayout;
  }
  
  public final void setProfilePluginUi(aj paramaj)
  {
    this.WDZ = paramaj;
  }
  
  public final void setReaderContentLayout(RelativeLayout paramRelativeLayout)
  {
    this.WDX = paramRelativeLayout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/ScreenProfileReadyUI$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "app_release"})
  public static final class b
    implements h.a
  {
    public final void NB(int paramInt)
    {
      AppMethodBeat.i(278274);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onPageCountUpdate ".concat(String.valueOf(paramInt)));
      aj localaj = this.WEc.getProfilePluginUi();
      if (localaj != null) {
        localaj.iWH = paramInt;
      }
      localaj = this.WEc.getProfilePluginUi();
      if (localaj != null)
      {
        localaj.hIx();
        AppMethodBeat.o(278274);
        return;
      }
      AppMethodBeat.o(278274);
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
    
    public final void a(int paramInt, Bitmap paramBitmap)
    {
      AppMethodBeat.i(278277);
      p.k(paramBitmap, "thumbnail");
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onThumbnailLoad ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(278277);
    }
    
    public final void ag(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(278276);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
      Object localObject = this.WEc.getProfilePluginUi();
      if (localObject != null) {
        ((aj)localObject).uPV = paramInt1;
      }
      localObject = this.WEc.getProfilePluginUi();
      if (localObject != null) {
        ((aj)localObject).hIx();
      }
      if ((!am.a(this.WEc)) && (am.mz(paramInt2, paramInt3)))
      {
        localObject = FileSelectorUI.Rvv;
        localObject = this.WEc.getContext();
        p.j(localObject, "context");
        if (FileSelectorUI.b.hB((Context)localObject) != 0)
        {
          localObject = FileSelectorUI.Rvv;
          localObject = this.WEc.getContext();
          p.j(localObject, "context");
          if (FileSelectorUI.b.hB((Context)localObject) != 180) {}
        }
        else
        {
          am.b(this.WEc);
          localObject = this.WEc.WDZ;
          if (localObject != null)
          {
            ((aj)localObject).WdX = w.l(((aj)localObject).context, (CharSequence)((aj)localObject).context.getResources().getString(R.l.multitalk_rotate_to_horizontal_urs), R.g.multitalk_rotate_screen_v2h);
            AppMethodBeat.o(278276);
            return;
          }
        }
      }
      AppMethodBeat.o(278276);
    }
    
    public final void bQm()
    {
      AppMethodBeat.i(278275);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile on user cancel finish");
      AppMethodBeat.o(278275);
    }
    
    public final void dCv() {}
    
    public final void dCw() {}
    
    public final void dCx() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"})
  static final class c<T>
    implements ValueCallback<Integer>
  {
    c(am paramam) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */