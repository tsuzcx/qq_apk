package com.tencent.mm.plugin.textstatus.j;

import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.d;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/H5StatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-textstatus_release"})
public final class b
  implements m
{
  public static final a MIQ;
  
  static
  {
    AppMethodBeat.i(233757);
    MIQ = new a((byte)0);
    AppMethodBeat.o(233757);
  }
  
  public final com.tencent.mm.ui.widget.b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, d paramd)
  {
    AppMethodBeat.i(233754);
    p.k(paramFrameLayout, "container");
    p.k(paramd, "pullDownParam");
    AppMethodBeat.o(233754);
    return null;
  }
  
  public final i dDF()
  {
    AppMethodBeat.i(233755);
    i locali = (i)new b();
    AppMethodBeat.o(233755);
    return locali;
  }
  
  public final void release() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/H5StatusService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/third/H5StatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "isHasCustomPullDown", "onAttach", "", "textStatusID", "", "", "onDetach", "plugin-textstatus_release"})
  public static final class b
    extends i
  {
    private List<? extends TextStatusJumpInfo> yNX;
    
    public final boolean dDH()
    {
      return false;
    }
    
    public final boolean fz(Context paramContext)
    {
      AppMethodBeat.i(238466);
      Object localObject1 = this.yNX;
      if (localObject1 != null)
      {
        Object localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (TextStatusJumpInfo)((Iterator)localObject2).next();
          if (p.h(((TextStatusJumpInfo)localObject1).jumpType, "3"))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("rawUrl", ((TextStatusJumpInfo)localObject1).busiBuf);
            c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
            AppMethodBeat.o(238466);
            return true;
          }
        }
      }
      AppMethodBeat.o(238466);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void s(String paramString, List<TextStatusJumpInfo> paramList)
    {
      this.yNX = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.b
 * JD-Core Version:    0.7.0.1
 */