package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.base.u;
import com.tencent.xweb.h.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "filePath", "", "fileExt", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "setFileExt", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "isShowChangeOrientationTip", "", "pluginControlLayout", "Landroid/widget/RelativeLayout;", "getPluginControlLayout", "()Landroid/widget/RelativeLayout;", "setPluginControlLayout", "(Landroid/widget/RelativeLayout;)V", "profilePluginUi", "Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "getProfilePluginUi", "()Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "setProfilePluginUi", "(Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;)V", "readerContentLayout", "getReaderContentLayout", "setReaderContentLayout", "applyPluginLayout", "", "applyReaderLayout", "checkRatioIsLand", "w", "", "h", "inputFileInfo", "refreshLayout", "showProfileUi", "showRotateScreenInfo", "Companion", "app_release"})
public final class am
  extends FrameLayout
{
  public static final am.a Pks;
  public RelativeLayout Pko;
  private RelativeLayout Pkp;
  private ag Pkq;
  private boolean Pkr;
  public String filePath;
  public String gCr;
  
  static
  {
    AppMethodBeat.i(231186);
    Pks = new am.a((byte)0);
    AppMethodBeat.o(231186);
  }
  
  public am(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    AppMethodBeat.i(231185);
    this.filePath = paramString1;
    this.gCr = paramString2;
    LayoutInflater.from(paramContext).inflate(2131496164, (ViewGroup)this);
    this.Pko = ((RelativeLayout)findViewById(2131307306));
    this.Pkp = ((RelativeLayout)findViewById(2131307309));
    this.Pkq = new ag(this.filePath, (byte)0);
    gOo();
    gOn();
    AppMethodBeat.o(231185);
  }
  
  public static boolean lg(int paramInt1, int paramInt2)
  {
    return paramInt1 / paramInt2 >= 1.333333F;
  }
  
  public final void gOn()
  {
    AppMethodBeat.i(231181);
    Object localObject1 = this.Pko;
    if (localObject1 != null)
    {
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(231181);
          throw ((Throwable)localObject1);
        }
        Object localObject2 = k.zTz;
        localObject2 = getContext();
        p.g(localObject2, "context");
        if (k.a.gE((Context)localObject2) != 90)
        {
          localObject2 = k.zTz;
          localObject2 = getContext();
          p.g(localObject2, "context");
          if (k.a.gE((Context)localObject2) != 270) {}
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(f.zSE);
          AppMethodBeat.o(231181);
          return;
        }
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = f.zSE;
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
        AppMethodBeat.o(231181);
        return;
      }
    }
    AppMethodBeat.o(231181);
  }
  
  public final void gOo()
  {
    AppMethodBeat.i(231182);
    RelativeLayout localRelativeLayout = this.Pkp;
    if (localRelativeLayout != null)
    {
      Object localObject = this.Pkp;
      if (localObject != null) {
        ((RelativeLayout)localObject).removeAllViews();
      }
      localObject = k.zTz;
      localObject = getContext();
      p.g(localObject, "context");
      Context localContext;
      if (k.a.gE((Context)localObject) != 90)
      {
        localObject = k.zTz;
        localObject = getContext();
        p.g(localObject, "context");
        if (k.a.gE((Context)localObject) != 270) {}
      }
      else
      {
        localObject = this.Pkq;
        if (localObject != null)
        {
          localContext = getContext();
          p.g(localContext, "context");
          ((ag)localObject).g(localContext, (ViewGroup)localRelativeLayout);
          AppMethodBeat.o(231182);
          return;
        }
        AppMethodBeat.o(231182);
        return;
      }
      localObject = this.Pkq;
      if (localObject != null)
      {
        localContext = getContext();
        p.g(localContext, "context");
        ((ag)localObject).f(localContext, (ViewGroup)localRelativeLayout);
        AppMethodBeat.o(231182);
        return;
      }
      AppMethodBeat.o(231182);
      return;
    }
    AppMethodBeat.o(231182);
  }
  
  public final String getFileExt()
  {
    return this.gCr;
  }
  
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final RelativeLayout getPluginControlLayout()
  {
    return this.Pkp;
  }
  
  public final ag getProfilePluginUi()
  {
    return this.Pkq;
  }
  
  public final RelativeLayout getReaderContentLayout()
  {
    return this.Pko;
  }
  
  public final void setFileExt(String paramString)
  {
    AppMethodBeat.i(231184);
    p.h(paramString, "<set-?>");
    this.gCr = paramString;
    AppMethodBeat.o(231184);
  }
  
  public final void setFilePath(String paramString)
  {
    AppMethodBeat.i(231183);
    p.h(paramString, "<set-?>");
    this.filePath = paramString;
    AppMethodBeat.o(231183);
  }
  
  public final void setPluginControlLayout(RelativeLayout paramRelativeLayout)
  {
    this.Pkp = paramRelativeLayout;
  }
  
  public final void setProfilePluginUi(ag paramag)
  {
    this.Pkq = paramag;
  }
  
  public final void setReaderContentLayout(RelativeLayout paramRelativeLayout)
  {
    this.Pko = paramRelativeLayout;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/ScreenProfileReadyUI$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "app_release"})
  public static final class b
    implements h.a
  {
    public final void Rz(int paramInt)
    {
      AppMethodBeat.i(231176);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onPageCountUpdate ".concat(String.valueOf(paramInt)));
      ag localag = this.Pkt.getProfilePluginUi();
      if (localag != null) {
        localag.maxCount = paramInt;
      }
      localag = this.Pkt.getProfilePluginUi();
      if (localag != null)
      {
        localag.gJA();
        AppMethodBeat.o(231176);
        return;
      }
      AppMethodBeat.o(231176);
    }
    
    public final void ar(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(231178);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
      Object localObject1 = this.Pkt.getProfilePluginUi();
      if (localObject1 != null) {
        ((ag)localObject1).rmJ = paramInt1;
      }
      localObject1 = this.Pkt.getProfilePluginUi();
      if (localObject1 != null) {
        ((ag)localObject1).gJA();
      }
      if ((!am.a(this.Pkt)) && (am.lg(paramInt2, paramInt3)))
      {
        localObject1 = FileSelectorUI.Kuo;
        localObject1 = this.Pkt.getContext();
        p.g(localObject1, "context");
        if (FileSelectorUI.b.gE((Context)localObject1) != 0)
        {
          localObject1 = FileSelectorUI.Kuo;
          localObject1 = this.Pkt.getContext();
          p.g(localObject1, "context");
          if (FileSelectorUI.b.gE((Context)localObject1) != 180) {}
        }
        else
        {
          am.b(this.Pkt);
          Object localObject2 = this.Pkt;
          localObject1 = ((am)localObject2).getContext();
          localObject2 = ((am)localObject2).getContext();
          p.g(localObject2, "context");
          u.u((Context)localObject1, ((Context)localObject2).getResources().getString(2131763293), 2131234081);
        }
      }
      AppMethodBeat.o(231178);
    }
    
    public final void b(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
    
    public final void c(int paramInt, Bitmap paramBitmap)
    {
      AppMethodBeat.i(231179);
      p.h(paramBitmap, "thumbnail");
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onThumbnailLoad ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(231179);
    }
    
    public final void cTA()
    {
      AppMethodBeat.i(231177);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile on user cancel finish");
      AppMethodBeat.o(231177);
    }
    
    public final void epu() {}
    
    public final void epv() {}
    
    public final void epw() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"})
  public static final class c<T>
    implements ValueCallback<Integer>
  {
    public c(am paramam) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */