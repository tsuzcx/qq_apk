package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.r;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/conversation/ConvExposeHelper;", "", "()V", "TAG", "", "isMainTabShow", "", "()Z", "setMainTabShow", "(Z)V", "sFirstVisibleItem", "", "sLastVisibleItem", "checkOfficialAccountShow", "", "conversationLV", "Landroid/widget/ListView;", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "visible", "scroll", "app_release"})
public final class d
{
  private static int IBh;
  private static boolean IBi;
  public static final d IBj;
  private static int nAB;
  
  static
  {
    AppMethodBeat.i(197009);
    IBj = new d();
    nAB = -1;
    IBh = -1;
    IBi = true;
    AppMethodBeat.o(197009);
  }
  
  public static void a(ListView paramListView, i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197008);
    Object localObject = r.GBV;
    if (!r.eZc())
    {
      AppMethodBeat.o(197008);
      return;
    }
    if ((parami == null) || (paramListView == null))
    {
      AppMethodBeat.o(197008);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((paramBoolean2) && (i == nAB) && (IBh == j))
    {
      AppMethodBeat.o(197008);
      return;
    }
    ac.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + i + ", lastPos=" + j + ", visible=" + paramBoolean1 + ", scroll=" + paramBoolean2);
    if (!paramBoolean1)
    {
      paramListView = r.GBV;
      r.aMP("");
      AppMethodBeat.o(197008);
      return;
    }
    nAB = i;
    IBh = j;
    if (i > k)
    {
      i -= k;
      if (j < k) {
        break label362;
      }
      j -= k;
    }
    for (;;)
    {
      paramListView = "";
      if (i <= j) {}
      for (;;)
      {
        try
        {
          localObject = (ap)parami.Za(i);
          if ((localObject == null) || (!w.xg(((ap)localObject).getUsername()))) {
            break label340;
          }
          paramListView = ((ap)localObject).getDigest();
          j = ((ap)localObject).Tv();
          int m = 1;
          k = i;
          i = m;
          if (i != 0) {
            if (!paramBoolean2)
            {
              parami = r.GBV;
              r.aL(paramListView, k, j);
              AppMethodBeat.o(197008);
              return;
            }
          }
        }
        catch (Exception paramListView)
        {
          ac.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
          AppMethodBeat.o(197008);
          return;
        }
        paramListView = r.GBV;
        r.aMP("");
        AppMethodBeat.o(197008);
        return;
        label340:
        while (i == j)
        {
          i = 0;
          j = 0;
          k = 0;
          break;
        }
        i += 1;
      }
      i = 0;
      break;
      label362:
      j = 0;
    }
  }
  
  public static boolean frN()
  {
    return IBi;
  }
  
  public static void xD(boolean paramBoolean)
  {
    IBi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */