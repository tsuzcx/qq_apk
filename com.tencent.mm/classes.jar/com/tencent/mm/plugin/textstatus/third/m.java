package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.ui.widget.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/TopicSquareStatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "goTopicMiniApp", "", "textStatusModelInfoStr", "clickTagName", "context", "Landroid/content/Context;", "preloadMiniProgram", "release", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements o
{
  public static final m.a Tve;
  private static long xDp;
  
  static
  {
    AppMethodBeat.i(290152);
    Tve = new m.a((byte)0);
    AppMethodBeat.o(290152);
  }
  
  private static final String nk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(290128);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("textStateModelInfo", paramString1);
    paramString1 = (CharSequence)paramString2;
    if ((paramString1 == null) || (n.bp(paramString1))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localJSONObject.put("clickTagName", paramString2);
      }
      localJSONObject.put("clickTagTime", cn.bDv());
      paramString1 = localJSONObject.toString();
      s.s(paramString1, "jsonObj.toString()");
      AppMethodBeat.o(290128);
      return paramString1;
    }
  }
  
  public final b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    AppMethodBeat.i(290170);
    s.u(paramFrameLayout, "container");
    s.u(paraml, "pullDownParam");
    AppMethodBeat.o(290170);
    return null;
  }
  
  public final k axF(final String paramString)
  {
    AppMethodBeat.i(290178);
    paramString = (k)new b(this, paramString);
    AppMethodBeat.o(290178);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/TopicSquareStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "extParam", "Landroid/os/Bundle;", "isHasCustomPullDown", "onAttach", "", "textStatusID", "", "", "onDetach", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k
  {
    private List<? extends TextStatusJumpInfo> DHi;
    
    b(m paramm, String paramString)
    {
      super();
    }
    
    public final boolean etQ()
    {
      return false;
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(290111);
      Object localObject = this.DHi;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (s.p(((TextStatusJumpInfo)((Iterator)localObject).next()).jumpType, "12"))
          {
            if (paramBundle == null)
            {
              localObject = "";
              if (paramBundle != null) {
                break label100;
              }
              paramBundle = "";
            }
            for (;;)
            {
              m.b((String)localObject, paramBundle, paramContext);
              AppMethodBeat.o(290111);
              return true;
              localObject = paramBundle.getString("textStatusModelInfoStr");
              if (localObject == null)
              {
                localObject = "";
                break;
              }
              break;
              label100:
              String str = paramBundle.getString("clickTagName");
              paramBundle = str;
              if (str == null) {
                paramBundle = "";
              }
            }
          }
        }
      }
      AppMethodBeat.o(290111);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(290095);
      this.DHi = paramList;
      m.hIf();
      AppMethodBeat.o(290095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.m
 * JD-Core Version:    0.7.0.1
 */