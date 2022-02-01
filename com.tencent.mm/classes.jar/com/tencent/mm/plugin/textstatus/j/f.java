package com.tencent.mm.plugin.textstatus.j;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.d;
import com.tencent.mm.ui.widget.b;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/WeAppStatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-textstatus_release"})
public final class f
  implements m
{
  public static final a MIX;
  
  static
  {
    AppMethodBeat.i(236979);
    MIX = new a((byte)0);
    AppMethodBeat.o(236979);
  }
  
  public final b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, d paramd)
  {
    AppMethodBeat.i(236973);
    p.k(paramFrameLayout, "container");
    p.k(paramd, "pullDownParam");
    AppMethodBeat.o(236973);
    return null;
  }
  
  public final i dDF()
  {
    AppMethodBeat.i(236976);
    i locali = (i)new b();
    AppMethodBeat.o(236976);
    return locali;
  }
  
  public final void release() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/WeAppStatusService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/third/WeAppStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "jumpInfosJo", "Lorg/json/JSONObject;", "getJumpInfosJo", "()Lorg/json/JSONObject;", "setJumpInfosJo", "(Lorg/json/JSONObject;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "isHasCustomPullDown", "onAttach", "", "textStatusID", "", "", "onDetach", "setCustomSourceView", "container", "Landroid/widget/FrameLayout;", "plugin-textstatus_release"})
  public static final class b
    extends i
  {
    private JSONObject MIY;
    private List<? extends TextStatusJumpInfo> yNX;
    
    public final boolean dDH()
    {
      return false;
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(232274);
      p.k(paramFrameLayout, "container");
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("WeAppStatusService");
      if (localImageView == null) {
        localImageView = new ImageView(paramFrameLayout.getContext());
      }
      for (;;)
      {
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        paramFrameLayout = com.tencent.mm.plugin.textstatus.k.n.MOY;
        com.tencent.mm.plugin.textstatus.k.n.hb((View)localImageView);
        paramFrameLayout = this.MIY;
        if (paramFrameLayout != null)
        {
          paramFrameLayout = paramFrameLayout.optString("headImageURL");
          CharSequence localCharSequence = (CharSequence)paramFrameLayout;
          if ((localCharSequence != null) && (!kotlin.n.n.ba(localCharSequence))) {
            break label128;
          }
        }
        label128:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            q.bml().loadImage(paramFrameLayout, localImageView);
          }
          AppMethodBeat.o(232274);
          return true;
          paramFrameLayout = null;
          break;
        }
      }
    }
    
    public final boolean fz(Context paramContext)
    {
      AppMethodBeat.i(232272);
      Object localObject1 = this.yNX;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextStatusJumpInfo)((Iterator)localObject1).next();
          if (p.h(((TextStatusJumpInfo)localObject2).jumpType, "7"))
          {
            Object localObject3 = new JSONObject(((TextStatusJumpInfo)localObject2).busiBuf);
            localObject1 = ((JSONObject)localObject3).optString("username");
            localObject2 = ((JSONObject)localObject3).optString("path");
            int i = ((JSONObject)localObject3).optInt("version");
            int j = ((JSONObject)localObject3).optInt("versionType", 0);
            localObject3 = (r)h.ae(r.class);
            if (localObject3 != null)
            {
              g localg = new g();
              localg.username = ((String)localObject1);
              localg.nBq = ((String)localObject2);
              localg.version = i;
              localg.cBU = j;
              localg.scene = 1196;
              localg.fvd = ((String)localObject1);
              ((r)localObject3).a(paramContext, localg);
            }
            AppMethodBeat.o(232272);
            return true;
          }
        }
      }
      AppMethodBeat.o(232272);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void s(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(232270);
      this.yNX = paramList;
      if (paramList != null)
      {
        paramString = ((Iterable)paramList).iterator();
        while (paramString.hasNext())
        {
          paramList = (TextStatusJumpInfo)paramString.next();
          if (p.h(paramList.jumpType, "7"))
          {
            this.MIY = new JSONObject(paramList.busiBuf);
            AppMethodBeat.o(232270);
            return;
          }
        }
        AppMethodBeat.o(232270);
        return;
      }
      AppMethodBeat.o(232270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.f
 * JD-Core Version:    0.7.0.1
 */