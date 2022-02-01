package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/conversation/ConvExposeHelper;", "", "()V", "TAG", "", "isMainTabShow", "", "()Z", "setMainTabShow", "(Z)V", "sFirstVisibleItem", "", "sLastVisibleItem", "checkOfficialAccountShow", "", "conversationLV", "Landroid/widget/ListView;", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "visible", "scroll", "app_release"})
public final class d
{
  private static int Ksn;
  private static boolean Kso;
  public static final d Ksp;
  private static int obI;
  
  static
  {
    AppMethodBeat.i(194917);
    Ksp = new d();
    obI = -1;
    Ksn = -1;
    Kso = true;
    AppMethodBeat.o(194917);
  }
  
  public static void a(ListView paramListView, i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(194916);
    Object localObject = t.Ioj;
    if (!t.foW())
    {
      AppMethodBeat.o(194916);
      return;
    }
    if ((parami == null) || (paramListView == null))
    {
      AppMethodBeat.o(194916);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((paramBoolean2) && (i == obI) && (Ksn == j))
    {
      AppMethodBeat.o(194916);
      return;
    }
    ad.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + i + ", lastPos=" + j + ", visible=" + paramBoolean1 + ", scroll=" + paramBoolean2);
    if (!paramBoolean1)
    {
      paramListView = t.Ioj;
      t.aSB("");
      AppMethodBeat.o(194916);
      return;
    }
    obI = i;
    Ksn = j;
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
          localObject = (at)parami.abj(i);
          if ((localObject == null) || (!w.Ad(((at)localObject).getUsername()))) {
            break label340;
          }
          paramListView = ((at)localObject).getDigest();
          j = ((at)localObject).VK();
          int m = 1;
          k = i;
          i = m;
          if (i != 0) {
            if (!paramBoolean2)
            {
              parami = t.Ioj;
              t.aP(paramListView, k, j);
              AppMethodBeat.o(194916);
              return;
            }
          }
        }
        catch (Exception paramListView)
        {
          ad.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
          AppMethodBeat.o(194916);
          return;
        }
        paramListView = t.Ioj;
        t.aSB("");
        AppMethodBeat.o(194916);
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
  
  public static boolean fIC()
  {
    return Kso;
  }
  
  public static void yr(boolean paramBoolean)
  {
    Kso = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */