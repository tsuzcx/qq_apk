package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/conversation/ConvExposeHelper;", "", "()V", "TAG", "", "isMainTabShow", "", "()Z", "setMainTabShow", "(Z)V", "sFirstVisibleItem", "", "sLastVisibleItem", "checkOfficialAccountShow", "", "conversationLV", "Landroid/widget/ListView;", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "visible", "scroll", "app_release"})
public final class d
{
  private static int KOH;
  private static boolean KOI;
  public static final d KOJ;
  private static int ohw;
  
  static
  {
    AppMethodBeat.i(188371);
    KOJ = new d();
    ohw = -1;
    KOH = -1;
    KOI = true;
    AppMethodBeat.o(188371);
  }
  
  public static void a(ListView paramListView, i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188370);
    Object localObject = t.IIz;
    if (!t.fsT())
    {
      AppMethodBeat.o(188370);
      return;
    }
    if ((parami == null) || (paramListView == null))
    {
      AppMethodBeat.o(188370);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((paramBoolean2) && (i == ohw) && (KOH == j))
    {
      AppMethodBeat.o(188370);
      return;
    }
    ae.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + i + ", lastPos=" + j + ", visible=" + paramBoolean1 + ", scroll=" + paramBoolean2);
    if (!paramBoolean1)
    {
      paramListView = t.IIz;
      t.aTY("");
      AppMethodBeat.o(188370);
      return;
    }
    ohw = i;
    KOH = j;
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
          localObject = (au)parami.abR(i);
          if ((localObject == null) || (!x.AN(((au)localObject).getUsername()))) {
            break label340;
          }
          paramListView = ((au)localObject).getDigest();
          j = ((au)localObject).VS();
          int m = 1;
          k = i;
          i = m;
          if (i != 0) {
            if (!paramBoolean2)
            {
              parami = t.IIz;
              t.aS(paramListView, k, j);
              AppMethodBeat.o(188370);
              return;
            }
          }
        }
        catch (Exception paramListView)
        {
          ae.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
          AppMethodBeat.o(188370);
          return;
        }
        paramListView = t.IIz;
        t.aTY("");
        AppMethodBeat.o(188370);
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
  
  public static boolean fMU()
  {
    return KOI;
  }
  
  public static void yE(boolean paramBoolean)
  {
    KOI = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */