package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.v;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/conversation/ConvExposeHelper;", "", "()V", "TAG", "", "isMainTabShow", "", "()Z", "setMainTabShow", "(Z)V", "sFirstVisibleItem", "", "sLastVisibleItem", "checkOfficialAccountShow", "", "conversationLV", "Landroid/widget/ListView;", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "visible", "scroll", "app_release"})
public final class d
{
  private static int QbI;
  private static boolean QbJ;
  public static final d QbK;
  private static int psU;
  
  static
  {
    AppMethodBeat.i(231372);
    QbK = new d();
    psU = -1;
    QbI = -1;
    QbJ = true;
    AppMethodBeat.o(231372);
  }
  
  public static void Cu(boolean paramBoolean)
  {
    QbJ = paramBoolean;
  }
  
  public static void a(ListView paramListView, i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(231371);
    Object localObject = v.NPH;
    if (!v.gAi())
    {
      AppMethodBeat.o(231371);
      return;
    }
    if ((parami == null) || (paramListView == null))
    {
      AppMethodBeat.o(231371);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((paramBoolean2) && (i == psU) && (QbI == j))
    {
      AppMethodBeat.o(231371);
      return;
    }
    Log.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + i + ", lastPos=" + j + ", visible=" + paramBoolean1 + ", scroll=" + paramBoolean2);
    if (!paramBoolean1)
    {
      paramListView = v.NPH;
      v.biU("");
      AppMethodBeat.o(231371);
      return;
    }
    psU = i;
    QbI = j;
    if (i > k)
    {
      i = i - k + 1;
      if (j < k) {
        break label376;
      }
    }
    label354:
    label376:
    for (j = j - k - 1;; j = 0)
    {
      paramListView = "";
      if (i <= j) {}
      for (;;)
      {
        try
        {
          localObject = (az)parami.akz(i);
          if ((localObject == null) || (!ab.Js(((az)localObject).getUsername()))) {
            break label354;
          }
          paramListView = ((az)localObject).getDigest();
          j = ((az)localObject).ajG();
          int m = 1;
          k = i;
          i = m;
          if (i != 0) {
            if (paramBoolean2)
            {
              parami = v.NPH;
              if (v.gAg()) {}
            }
            else
            {
              parami = v.NPH;
              v.aO(paramListView, k, j);
              AppMethodBeat.o(231371);
              return;
            }
          }
        }
        catch (Exception paramListView)
        {
          Log.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
          AppMethodBeat.o(231371);
          return;
        }
        paramListView = v.NPH;
        v.biU("");
        AppMethodBeat.o(231371);
        return;
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
    }
  }
  
  public static boolean gVo()
  {
    return QbJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */