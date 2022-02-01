package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.v;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/conversation/ConvExposeHelper;", "", "()V", "TAG", "", "isMainTabShow", "", "()Z", "setMainTabShow", "(Z)V", "sFirstVisibleItem", "", "sLastVisibleItem", "checkOfficialAccountShow", "", "conversationLV", "Landroid/widget/ListView;", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "visible", "scroll", "app_release"})
public final class d
{
  private static int XzV;
  private static boolean XzW;
  public static final d XzX;
  private static int sCk;
  
  static
  {
    AppMethodBeat.i(285795);
    XzX = new d();
    sCk = -1;
    XzV = -1;
    XzW = true;
    AppMethodBeat.o(285795);
  }
  
  public static void GS(boolean paramBoolean)
  {
    XzW = paramBoolean;
  }
  
  public static void a(ListView paramListView, j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(285794);
    Object localObject = v.Vdz;
    if (!v.hwo())
    {
      AppMethodBeat.o(285794);
      return;
    }
    if ((paramj == null) || (paramListView == null))
    {
      AppMethodBeat.o(285794);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((paramBoolean2) && (i == sCk) && (XzV == j))
    {
      AppMethodBeat.o(285794);
      return;
    }
    Log.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + i + ", lastPos=" + j + ", visible=" + paramBoolean1 + ", scroll=" + paramBoolean2);
    if (!paramBoolean1)
    {
      paramListView = v.Vdz;
      v.bvp("");
      AppMethodBeat.o(285794);
      return;
    }
    sCk = i;
    XzV = j;
    if (i > k)
    {
      i = i - k + 1;
      if (j < k) {
        break label381;
      }
    }
    label356:
    label381:
    for (j = j - k - 1;; j = 0)
    {
      String str = "";
      localObject = null;
      if (i <= j) {
        paramListView = null;
      }
      for (;;)
      {
        try
        {
          localObject = (az)paramj.asW(i);
          if (localObject == null) {
            break label356;
          }
          paramListView = (ListView)localObject;
          if (!ab.QL(((az)localObject).getUsername())) {
            break label356;
          }
          paramListView = ((az)localObject).getDigest();
          k = 1;
          j = i;
          i = k;
          if (i != 0) {
            if (paramBoolean2)
            {
              paramj = v.Vdz;
              if (v.hwl()) {}
            }
            else
            {
              paramj = v.Vdz;
              v.a(paramListView, j, (az)localObject);
              AppMethodBeat.o(285794);
              return;
            }
          }
        }
        catch (Exception paramListView)
        {
          Log.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
          AppMethodBeat.o(285794);
          return;
        }
        paramListView = v.Vdz;
        v.bvp("");
        AppMethodBeat.o(285794);
        return;
        do
        {
          i = 0;
          j = 0;
          paramListView = str;
          break;
          localObject = paramListView;
        } while (i == j);
        i += 1;
      }
      i = 0;
      break;
    }
  }
  
  public static boolean hVV()
  {
    return XzW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */