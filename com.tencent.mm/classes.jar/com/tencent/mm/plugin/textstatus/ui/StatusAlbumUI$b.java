package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.textstatus.proto.ag;
import com.tencent.mm.plugin.textstatus.proto.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
final class StatusAlbumUI$b
{
  boolean ABD;
  private final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> ALE;
  private final RefreshLoadMoreLayout TwH;
  private b TwI;
  final com.tencent.mm.am.h maV;
  
  public StatusAlbumUI$b(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(291540);
    this.ALE = paramWxRecyclerAdapter;
    this.TwH = paramRefreshLoadMoreLayout;
    this.maV = new StatusAlbumUI.b..ExternalSyntheticLambda0(this);
    com.tencent.mm.kernel.h.aZW().a(4245, this.maV);
    AppMethodBeat.o(291540);
  }
  
  private static final void a(b paramb, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(291547);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramp, "netSceneBase");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.textstatus.h.h)paramp).TmP;
      if (paramString != null)
      {
        paramb.TwI = paramString.TpC;
        paramb.ABD = paramString.TpE;
        paramString = paramString.TpD;
        if (paramString != null)
        {
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext())
          {
            paramp = (an)paramString.next();
            if (paramp != null)
            {
              List localList = (List)paramb.ALE.data;
              kotlin.g.b.s.s(paramp, "it");
              localList.add(new com.tencent.mm.plugin.textstatus.h.a.a(paramp));
            }
          }
        }
        Log.i("MicroMsg.TextStatus.StatusAlbumUI", "data size = " + ((List)paramb.ALE.data).size() + ", continueFlag: " + paramb.ABD);
      }
    }
    paramb.TwH.aFW(0);
    AppMethodBeat.o(291547);
  }
  
  public final void gir()
  {
    AppMethodBeat.i(291559);
    com.tencent.mm.plugin.textstatus.h.h localh = new com.tencent.mm.plugin.textstatus.h.h(this.TwI);
    com.tencent.mm.kernel.h.aZW().a((p)localh, 0);
    AppMethodBeat.o(291559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI.b
 * JD-Core Version:    0.7.0.1
 */