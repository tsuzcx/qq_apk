package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.ax;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.plugin.textstatus.proto.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/H5StatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements o
{
  public static final a TuL;
  
  static
  {
    AppMethodBeat.i(290099);
    TuL = new a((byte)0);
    AppMethodBeat.o(290099);
  }
  
  public final b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    AppMethodBeat.i(290106);
    s.u(paramFrameLayout, "container");
    s.u(paraml, "pullDownParam");
    AppMethodBeat.o(290106);
    return null;
  }
  
  public final k axF(String paramString)
  {
    AppMethodBeat.i(290114);
    paramString = (k)new b(paramString);
    AppMethodBeat.o(290114);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/H5StatusService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/H5StatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "extParam", "Landroid/os/Bundle;", "fillInfo", "", "resultSetTextStatus", "Lcom/tencent/mm/plugin/textstatus/proto/ResultSetTextStatus;", "getJumpType", "", "getJumpUrl", "isHasCustomPullDown", "onAttach", "textStatusID", "", "onDetach", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k
  {
    private List<? extends TextStatusJumpInfo> DHi;
    
    b(String paramString)
    {
      super();
    }
    
    private final String getJumpUrl()
    {
      AppMethodBeat.i(290067);
      Object localObject1 = this.DHi;
      Object localObject2;
      Object localObject3;
      boolean bool;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TextStatusJumpInfo)((Iterator)localObject1).next();
          localObject3 = ((TextStatusJumpInfo)localObject2).jumpType;
          if (s.p(localObject3, "3"))
          {
            bool = true;
            label63:
            if (!bool) {
              break label185;
            }
            localObject1 = ((TextStatusJumpInfo)localObject2).busiBuf;
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject3 = (CharSequence)((TextStatusJumpInfo)localObject2).keyBusiBuf;
          if (localObject3 == null) {
            break label223;
          }
          if (!n.bp((CharSequence)localObject3)) {
            continue;
          }
        }
        finally
        {
          label185:
          Log.printErrStackTrace("H5StatusService", localThrowable, "parse jump err", new Object[0]);
          continue;
        }
        if (i == 0)
        {
          localObject2 = Base64.decode(((TextStatusJumpInfo)localObject2).keyBusiBuf, 0);
          localObject3 = new ax();
          ((ax)localObject3).parseFrom((byte[])localObject2);
          localObject2 = ((ax)localObject3).url;
          localObject3 = (CharSequence)localObject2;
          if (localObject3 != null)
          {
            bool = n.bp((CharSequence)localObject3);
            if (!bool) {}
          }
          else
          {
            i = 1;
            if (i != 0) {
              continue;
            }
            localObject1 = localObject2;
            AppMethodBeat.o(290067);
            return localObject1;
            bool = s.p(localObject3, "10");
            break label63;
            break;
            i = 0;
            continue;
          }
          i = 0;
          continue;
        }
        AppMethodBeat.o(290067);
        return "";
        label223:
        int i = 1;
      }
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(290076);
      super.a(paramm);
      if (paramm != null) {
        paramm.ToV = getJumpUrl();
      }
      AppMethodBeat.o(290076);
    }
    
    public final boolean etQ()
    {
      return false;
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(290090);
      paramBundle = getJumpUrl();
      Object localObject = (CharSequence)paramBundle;
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramBundle);
        c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        AppMethodBeat.o(290090);
        return true;
      }
      AppMethodBeat.o(290090);
      return false;
    }
    
    public final String hFu()
    {
      return "3";
    }
    
    public final void onDetach() {}
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      this.DHi = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.d
 * JD-Core Version:    0.7.0.1
 */