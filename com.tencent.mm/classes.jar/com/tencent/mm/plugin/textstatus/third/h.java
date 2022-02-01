package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.widget.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/SportStatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "p0", "p1", "Landroid/widget/FrameLayout;", "p2", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "p3", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "startContactInfo", "", "context", "Landroid/content/Context;", "username", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements o
{
  public static final a TuV;
  
  static
  {
    AppMethodBeat.i(290089);
    TuV = new a((byte)0);
    AppMethodBeat.o(290089);
  }
  
  public final b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    AppMethodBeat.i(290100);
    s.u(paramFrameLayout, "p1");
    s.u(paraml, "p3");
    AppMethodBeat.o(290100);
    return null;
  }
  
  public final k axF(final String paramString)
  {
    AppMethodBeat.i(290093);
    paramString = (k)new b(this, paramString);
    AppMethodBeat.o(290093);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/SportStatusService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/SportStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "extParam", "Landroid/os/Bundle;", "isHasCustomPullDown", "onAttach", "", "textStatusID", "", "", "onDetach", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k
  {
    private List<? extends TextStatusJumpInfo> DHi;
    
    b(h paramh, String paramString)
    {
      super();
    }
    
    public final boolean etQ()
    {
      return false;
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      int j = 0;
      AppMethodBeat.i(290081);
      paramBundle = this.DHi;
      if (paramBundle != null)
      {
        paramBundle = ((Iterable)paramBundle).iterator();
        while (paramBundle.hasNext()) {
          if (s.p(((TextStatusJumpInfo)paramBundle.next()).jumpType, "11"))
          {
            paramBundle = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs("WeRun-WeChat");
            int i = j;
            if (paramBundle != null)
            {
              i = j;
              if (d.rs(paramBundle.field_type) == true) {
                i = 1;
              }
            }
            if (i != 0)
            {
              paramBundle = new Intent();
              paramBundle.putExtra("username", z.bAM());
              paramBundle.putExtra("key_is_latest", true);
              paramBundle.putExtra("rank_id", "#");
              paramBundle.putExtra("key_only_show_latest_rank", true);
              paramBundle.putExtra("app_username", aa.getDisplayName("gh_43f2581f6fd6"));
              paramBundle.putExtra("device_type", 1);
              c.b(paramContext, "exdevice", ".ui.ExdeviceRankInfoUI", paramBundle);
            }
            for (;;)
            {
              AppMethodBeat.o(290081);
              return true;
              if (paramContext != null) {
                h.bZ(paramContext, "gh_43f2581f6fd6");
              }
            }
          }
        }
      }
      AppMethodBeat.o(290081);
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.h
 * JD-Core Version:    0.7.0.1
 */