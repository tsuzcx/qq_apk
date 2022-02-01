package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.v;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/ConvExposeHelper;", "", "()V", "TAG", "", "isMainTabShow", "", "()Z", "setMainTabShow", "(Z)V", "sFirstVisibleItem", "", "sLastVisibleItem", "checkOfficialAccountShow", "", "conversationLV", "Landroid/widget/ListView;", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "visible", "scroll", "checkOfficialAccountShowFromGetView", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e afmD;
  private static int afmE;
  private static boolean afmF;
  private static int vIc;
  
  static
  {
    AppMethodBeat.i(256841);
    afmD = new e();
    vIc = -1;
    afmE = -1;
    afmF = true;
    AppMethodBeat.o(256841);
  }
  
  public static void MG(boolean paramBoolean)
  {
    afmF = paramBoolean;
  }
  
  public static void a(ListView paramListView, k paramk)
  {
    AppMethodBeat.i(256828);
    Object localObject = v.acEJ;
    if (!v.iXS())
    {
      AppMethodBeat.o(256828);
      return;
    }
    if ((paramListView == null) || (vIc < 0) || (afmE < 0))
    {
      AppMethodBeat.o(256828);
      return;
    }
    int k = paramListView.getHeaderViewsCount();
    int i;
    int j;
    label84:
    String str;
    if (vIc > k)
    {
      i = vIc - k + 1;
      if (afmE < k) {
        break label211;
      }
      j = afmE - k - 1;
      Log.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + vIc + ", lastPos=" + afmE);
      str = "";
      paramListView = null;
      if (i > j) {
        break label263;
      }
    }
    for (;;)
    {
      try
      {
        localObject = (bb)paramk.azn(i);
        if (localObject != null)
        {
          paramListView = (ListView)localObject;
          if (au.bwp(((bd)localObject).field_username))
          {
            paramk = ((bd)localObject).field_digest;
            k = 1;
            j = i;
            i = k;
            paramListView = (ListView)localObject;
            if (i == 0) {
              continue;
            }
            localObject = v.acEJ;
            v.a(paramk, j, paramListView);
            AppMethodBeat.o(256828);
            return;
            i = 0;
            break;
            label211:
            j = 0;
            break label84;
          }
        }
        if (i == j)
        {
          i = 0;
          j = 0;
          paramk = str;
          continue;
        }
        i += 1;
      }
      catch (Exception paramListView)
      {
        Log.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
        AppMethodBeat.o(256828);
        return;
      }
      continue;
      label263:
      paramListView = null;
      i = 0;
      j = 0;
      paramk = str;
    }
  }
  
  public static void a(ListView paramListView, k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(256837);
    Object localObject = v.acEJ;
    if (!v.iXS())
    {
      AppMethodBeat.o(256837);
      return;
    }
    if ((paramk == null) || (paramListView == null))
    {
      AppMethodBeat.o(256837);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((paramBoolean2) && (i == vIc) && (afmE == j))
    {
      AppMethodBeat.o(256837);
      return;
    }
    Log.v("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow headerCount=" + k + ", firstPos=" + i + ", lastPos=" + j + ", visible=" + paramBoolean1 + ", scroll=" + paramBoolean2);
    if (!paramBoolean1)
    {
      paramListView = v.acEJ;
      v.bvy("");
      AppMethodBeat.o(256837);
      return;
    }
    vIc = i;
    afmE = j;
    label201:
    String str;
    if (i > k)
    {
      i = i - k + 1;
      if (j < k) {
        break label335;
      }
      j = j - k - 1;
      str = "";
      paramListView = null;
      if (i > j) {
        break label348;
      }
      paramListView = null;
    }
    for (;;)
    {
      try
      {
        localObject = (bb)paramk.azn(i);
        if (localObject == null) {
          break label341;
        }
        paramListView = (ListView)localObject;
        if (!au.bwp(((bd)localObject).field_username)) {
          break label341;
        }
        paramk = ((bd)localObject).field_digest;
        k = 1;
        j = i;
        i = k;
        paramListView = (ListView)localObject;
        if (i == 0) {
          break label360;
        }
        if (paramBoolean2)
        {
          localObject = v.acEJ;
          if (v.iXQ()) {}
        }
        else
        {
          localObject = v.acEJ;
          v.a(paramk, j, paramListView);
          AppMethodBeat.o(256837);
          return;
        }
      }
      catch (Exception paramListView)
      {
        Log.e("MicroMsg.ConvExposeHelper", "checkOfficialAccountShow ex %s", new Object[] { paramListView.getMessage() });
        AppMethodBeat.o(256837);
        return;
      }
      i = 0;
      break;
      label335:
      j = 0;
      break label201;
      label341:
      if (i == j)
      {
        label348:
        i = 0;
        j = 0;
        paramk = str;
        continue;
        label360:
        paramListView = v.acEJ;
        v.bvy("");
        AppMethodBeat.o(256837);
      }
      else
      {
        i += 1;
      }
    }
  }
  
  public static boolean jzS()
  {
    return afmF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */