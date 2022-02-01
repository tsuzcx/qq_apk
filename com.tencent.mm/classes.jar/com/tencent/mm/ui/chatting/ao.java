package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;
import com.tencent.xweb.j.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "filePath", "", "fileExt", "scene", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "getFileExt", "()Ljava/lang/String;", "setFileExt", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "isShowChangeOrientationTip", "", "pluginControlLayout", "Landroid/widget/RelativeLayout;", "getPluginControlLayout", "()Landroid/widget/RelativeLayout;", "setPluginControlLayout", "(Landroid/widget/RelativeLayout;)V", "profilePluginUi", "Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "getProfilePluginUi", "()Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "setProfilePluginUi", "(Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;)V", "readerContentLayout", "getReaderContentLayout", "setReaderContentLayout", "applyPluginLayout", "", "applyReaderLayout", "checkRatioIsLand", "w", "h", "inputFileInfo", "refreshLayout", "release", "showProfileUi", "showRotateScreenInfo", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends FrameLayout
{
  public static final ao.a aelx;
  an aelA;
  private boolean aelB;
  private RelativeLayout aely;
  private RelativeLayout aelz;
  private String filePath;
  private String lPJ;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(253773);
    aelx = new ao.a((byte)0);
    AppMethodBeat.o(253773);
  }
  
  public ao(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(253755);
    this.filePath = paramString1;
    this.lPJ = paramString2;
    this.scene = paramInt;
    LayoutInflater.from(paramContext).inflate(R.i.screen_profile_ready_main, (ViewGroup)this);
    this.aely = ((RelativeLayout)findViewById(R.h.screen_profile_content_ui));
    this.aelz = ((RelativeLayout)findViewById(R.h.screen_profile_plugin_ui));
    this.aelA = new an(paramContext, this.filePath, this.scene, (byte)0);
    jqe();
    jqd();
    AppMethodBeat.o(253755);
  }
  
  private static final void a(ao paramao, Integer paramInteger)
  {
    AppMethodBeat.i(253770);
    s.u(paramao, "this$0");
    if (paramInteger == null)
    {
      if (paramInteger != null) {
        break label66;
      }
      label19:
      aa.dc(paramao.getContext(), paramao.getContext().getString(a.h.screen_projector_open_file_errcode));
    }
    for (;;)
    {
      if (paramao.scene == 3) {
        ac.ggS().gfc();
      }
      do
      {
        AppMethodBeat.o(253770);
        return;
      } while (paramInteger.intValue() == 0);
      break;
      label66:
      if (-17 != paramInteger.intValue()) {
        break label19;
      }
      aa.dc(paramao.getContext(), paramao.getContext().getString(R.l.gHL));
    }
  }
  
  public static boolean os(int paramInt1, int paramInt2)
  {
    return paramInt1 / paramInt2 >= 1.333333F;
  }
  
  private final void pW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253765);
    Object localObject1 = new File(paramString1);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile()))
    {
      AppMethodBeat.o(253765);
      return;
    }
    switch (this.scene)
    {
    default: 
      localObject1 = j.c.aieR;
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
      localObject2 = k.Lvg;
      localObject2 = y.bub(paramString1);
      s.s(localObject2, "getFileMD5String(filePath)");
      k.a.aND((String)localObject2);
      l1 = hashCode();
      l2 = System.currentTimeMillis();
      localObject2 = getContext();
      if (localObject2 != null) {
        break;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(253765);
      throw paramString1;
      localObject1 = j.c.aieR;
      continue;
      localObject1 = j.c.aieQ;
    }
    Object localObject2 = (Activity)localObject2;
    RelativeLayout localRelativeLayout = this.aely;
    if (localRelativeLayout == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(253765);
      throw paramString1;
    }
    j.a(paramString1, paramString2, String.valueOf(l1 + l2), true, localHashMap, (j.c)localObject1, (Activity)localObject2, (ViewGroup)localRelativeLayout, (j.a)new b(this), new ao..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(253765);
  }
  
  public final String getFileExt()
  {
    return this.lPJ;
  }
  
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final RelativeLayout getPluginControlLayout()
  {
    return this.aelz;
  }
  
  public final an getProfilePluginUi()
  {
    return this.aelA;
  }
  
  public final RelativeLayout getReaderContentLayout()
  {
    return this.aely;
  }
  
  public final void jqd()
  {
    AppMethodBeat.i(253809);
    Object localObject1 = this.aely;
    if (localObject1 != null)
    {
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 != null)
      {
        Object localObject2 = k.Lvg;
        localObject2 = getContext();
        s.s(localObject2, "context");
        if (k.a.iY((Context)localObject2) != 90)
        {
          localObject2 = k.Lvg;
          localObject2 = getContext();
          s.s(localObject2, "context");
          if (k.a.iY((Context)localObject2) != 270) {}
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(f.Lus);
          AppMethodBeat.o(253809);
          return;
        }
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = f.Lus;
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
      }
    }
    AppMethodBeat.o(253809);
  }
  
  public final void jqe()
  {
    AppMethodBeat.i(253812);
    RelativeLayout localRelativeLayout = this.aelz;
    if (localRelativeLayout != null)
    {
      Object localObject = getPluginControlLayout();
      if (localObject != null) {
        ((RelativeLayout)localObject).removeAllViews();
      }
      localObject = k.Lvg;
      localObject = getContext();
      s.s(localObject, "context");
      if (k.a.iY((Context)localObject) != 90)
      {
        localObject = k.Lvg;
        localObject = getContext();
        s.s(localObject, "context");
        if (k.a.iY((Context)localObject) != 270) {}
      }
      else
      {
        localObject = getProfilePluginUi();
        if (localObject == null) {
          break label120;
        }
        ((an)localObject).ac((ViewGroup)localRelativeLayout);
        AppMethodBeat.o(253812);
        return;
      }
      localObject = getProfilePluginUi();
      if (localObject != null) {
        ((an)localObject).ab((ViewGroup)localRelativeLayout);
      }
    }
    label120:
    AppMethodBeat.o(253812);
  }
  
  public final void jqf()
  {
    AppMethodBeat.i(253817);
    pW(this.filePath, this.lPJ);
    AppMethodBeat.o(253817);
  }
  
  public final void release()
  {
    AppMethodBeat.i(253805);
    an localan = this.aelA;
    if (localan != null) {
      localan.release();
    }
    AppMethodBeat.o(253805);
  }
  
  public final void setFileExt(String paramString)
  {
    AppMethodBeat.i(253788);
    s.u(paramString, "<set-?>");
    this.lPJ = paramString;
    AppMethodBeat.o(253788);
  }
  
  public final void setFilePath(String paramString)
  {
    AppMethodBeat.i(253782);
    s.u(paramString, "<set-?>");
    this.filePath = paramString;
    AppMethodBeat.o(253782);
  }
  
  public final void setPluginControlLayout(RelativeLayout paramRelativeLayout)
  {
    this.aelz = paramRelativeLayout;
  }
  
  public final void setProfilePluginUi(an paraman)
  {
    this.aelA = paraman;
  }
  
  public final void setReaderContentLayout(RelativeLayout paramRelativeLayout)
  {
    this.aely = paramRelativeLayout;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/ScreenProfileReadyUI$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j.a
  {
    b(ao paramao) {}
    
    public final void Pc(int paramInt)
    {
      AppMethodBeat.i(254050);
      Log.i("MicroMsg.ScreenProfileReadyUI", s.X("xfile onPageCountUpdate ", Integer.valueOf(paramInt)));
      an localan = this.aelC.getProfilePluginUi();
      if (localan != null) {
        localan.lyL = paramInt;
      }
      localan = this.aelC.getProfilePluginUi();
      if (localan != null) {
        localan.jkH();
      }
      AppMethodBeat.o(254050);
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
    
    public final void ay(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(254054);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
      Object localObject = this.aelC.getProfilePluginUi();
      if (localObject != null) {
        ((an)localObject).xYG = paramInt1;
      }
      localObject = this.aelC.getProfilePluginUi();
      if (localObject != null) {
        ((an)localObject).jkH();
      }
      if ((!ao.a(this.aelC)) && (ao.os(paramInt2, paramInt3)))
      {
        localObject = FileSelectorUI.YrG;
        localObject = this.aelC.getContext();
        s.s(localObject, "context");
        if (FileSelectorUI.b.iY((Context)localObject) != 0)
        {
          localObject = FileSelectorUI.YrG;
          localObject = this.aelC.getContext();
          s.s(localObject, "context");
          if (FileSelectorUI.b.iY((Context)localObject) != 180) {}
        }
        else
        {
          ao.b(this.aelC);
          localObject = this.aelC.aelA;
          if (localObject != null) {
            ((an)localObject).adJC = aa.k(((an)localObject).context, (CharSequence)((an)localObject).context.getResources().getString(R.l.multitalk_rotate_to_horizontal_urs), R.g.multitalk_rotate_screen_v2h);
          }
        }
      }
      AppMethodBeat.o(254054);
    }
    
    public final void bSt()
    {
      AppMethodBeat.i(254052);
      Log.i("MicroMsg.ScreenProfileReadyUI", "xfile on user cancel finish");
      AppMethodBeat.o(254052);
    }
    
    public final void c(int paramInt, Bitmap paramBitmap)
    {
      AppMethodBeat.i(254061);
      s.u(paramBitmap, "thumbnail");
      Log.i("MicroMsg.ScreenProfileReadyUI", s.X("xfile onThumbnailLoad ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(254061);
    }
    
    public final void erQ() {}
    
    public final void erR() {}
    
    public final void erS() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao
 * JD-Core Version:    0.7.0.1
 */