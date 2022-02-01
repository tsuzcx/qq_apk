package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.x.a;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/OpenImKefuConversationAdapter;", "Lcom/tencent/mm/ui/conversation/ConversationAdapter;", "username", "", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/ui/MListAdapter$CallBack;", "(Ljava/lang/String;Landroid/content/Context;Lcom/tencent/mm/ui/MListAdapter$CallBack;)V", "usernameList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "dealWithCovertViewForHook", "", "holder", "Lcom/tencent/mm/ui/conversation/ConversationAdapter$ViewHolder;", "detach", "getUsernameList", "resetCursor", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends g
{
  public static final r.a afrE;
  private HashSet<String> afrF;
  private final String username;
  
  static
  {
    AppMethodBeat.i(256813);
    afrE = new r.a((byte)0);
    AppMethodBeat.o(256813);
  }
  
  public r(String paramString, Context paramContext, x.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(256805);
    this.username = paramString;
    this.afrF = new HashSet();
    bh.bCz();
    c.bzG().add((MStorageEx.IOnStorageChange)this);
    AppMethodBeat.o(256805);
  }
  
  protected final void a(String paramString, g.g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(256821);
    super.a(paramString, paramg);
    Object localObject1;
    if (paramg == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setDescendantFocusability(393216);
      }
      if (paramg != null) {
        break label95;
      }
      localObject1 = null;
      label36:
      if (localObject1 != null) {
        ((ImageView)localObject1).setClickable(false);
      }
      if (paramg != null) {
        break label103;
      }
    }
    label95:
    label103:
    for (paramg = localObject2;; paramg = paramg.lBC)
    {
      if (paramg != null) {
        paramg.setLongClickable(false);
      }
      if (!this.afrF.contains(paramString)) {
        this.afrF.add(paramString);
      }
      AppMethodBeat.o(256821);
      return;
      localObject1 = paramg.TJN;
      break;
      localObject1 = paramg.lBC;
      break label36;
    }
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(256817);
    bh.bCz();
    w(c.bzG().a(6, this.lMF, this.username));
    Object localObject = Fv();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((Cursor)localObject).getCount()))
    {
      Log.i("MicroMsg.OpenImKefuConversationAdapter", "alvinluo resetCursor count: %s", new Object[] { localObject });
      if (this.adDx != null) {
        this.adDx.bWC();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(256817);
      return;
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(256818);
    super.detach();
    bh.bCz();
    c.bzG().remove((MStorageEx.IOnStorageChange)this);
    AppMethodBeat.o(256818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.r
 * JD-Core Version:    0.7.0.1
 */