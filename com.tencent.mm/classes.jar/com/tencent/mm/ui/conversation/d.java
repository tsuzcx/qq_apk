package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.r;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/conversation/ConvExposeHelper;", "", "()V", "TAG", "", "sFirstVisibleItem", "", "sLastVisibleItem", "checkOfficialAccountShow", "", "conversationLV", "Landroid/widget/ListView;", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "visible", "", "scroll", "app_release"})
public final class d
{
  private static int HaP;
  public static final d HaQ;
  private static int mYc;
  
  static
  {
    AppMethodBeat.i(191887);
    HaQ = new d();
    mYc = -1;
    HaP = -1;
    AppMethodBeat.o(191887);
  }
  
  public static void a(ListView paramListView, i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(191886);
    Object localObject = r.Fem;
    if (!r.eJF())
    {
      AppMethodBeat.o(191886);
      return;
    }
    if ((parami == null) || (paramListView == null))
    {
      AppMethodBeat.o(191886);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((paramBoolean2) && (i == mYc) && (HaP == j))
    {
      AppMethodBeat.o(191886);
      return;
    }
    ad.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + i + ", lastPos=" + j + ", visible=" + paramBoolean1 + ", scroll=" + paramBoolean2);
    if (!paramBoolean1)
    {
      paramListView = r.Fem;
      r.aHv("");
      AppMethodBeat.o(191886);
      return;
    }
    mYc = i;
    HaP = j;
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
          localObject = (am)parami.WQ(i);
          if ((localObject == null) || (!w.td(((am)localObject).getUsername()))) {
            break label340;
          }
          paramListView = ((am)localObject).getDigest();
          j = ((am)localObject).SB();
          int m = 1;
          k = i;
          i = m;
          if (i != 0) {
            if (!paramBoolean2)
            {
              parami = r.Fem;
              r.aI(paramListView, k, j);
              AppMethodBeat.o(191886);
              return;
            }
          }
        }
        catch (Exception paramListView)
        {
          ad.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
          AppMethodBeat.o(191886);
          return;
        }
        paramListView = r.Fem;
        r.aHv("");
        AppMethodBeat.o(191886);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */