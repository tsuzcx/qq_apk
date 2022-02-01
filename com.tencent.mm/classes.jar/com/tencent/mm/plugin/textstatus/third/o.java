package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.az;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/WebSearchStatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements com.tencent.mm.plugin.textstatus.a.o
{
  public static final a Tvi;
  
  static
  {
    AppMethodBeat.i(290119);
    Tvi = new a((byte)0);
    AppMethodBeat.o(290119);
  }
  
  public final b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    AppMethodBeat.i(290125);
    s.u(paramFrameLayout, "container");
    s.u(paraml, "pullDownParam");
    AppMethodBeat.o(290125);
    return null;
  }
  
  public final k axF(String paramString)
  {
    AppMethodBeat.i(290131);
    paramString = (k)new b(paramString);
    AppMethodBeat.o(290131);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/WebSearchStatusService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/WebSearchStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "extParam", "Landroid/os/Bundle;", "isHasCustomPullDown", "onAttach", "", "textStatusID", "", "", "onDetach", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k
  {
    private List<? extends TextStatusJumpInfo> DHi;
    
    b(String paramString)
    {
      super();
    }
    
    public final boolean etQ()
    {
      return false;
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(290115);
      paramBundle = this.DHi;
      if (paramBundle != null)
      {
        paramBundle = ((Iterable)paramBundle).iterator();
        for (;;)
        {
          if (paramBundle.hasNext())
          {
            Object localObject = (TextStatusJumpInfo)paramBundle.next();
            if (s.p(((TextStatusJumpInfo)localObject).jumpType, "9"))
            {
              paramBundle = new ah();
              paramBundle.context = paramContext;
              paramBundle.scene = 92;
              try
              {
                paramContext = Base64.decode(((TextStatusJumpInfo)localObject).keyBusiBuf, 0);
                localObject = new az();
                ((az)localObject).parseFrom(paramContext);
                paramBundle.query = ((az)localObject).query;
                paramBundle.sessionId = d.We(paramBundle.scene);
                paramBundle.WoH = true;
                ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(paramBundle);
                AppMethodBeat.o(290115);
                return true;
              }
              finally
              {
                for (;;)
                {
                  Log.printErrStackTrace("WebSearchStatusService", paramContext, "doJumpSource err", new Object[0]);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(290115);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      this.DHi = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.o
 * JD-Core Version:    0.7.0.1
 */