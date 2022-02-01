package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.cc;
import com.tencent.mm.view.e.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/ConvItemExposureHelper;", "", "()V", "talkerToListener", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "Lkotlin/collections/HashMap;", "registeredExposureListener", "", "talker", "itemView", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f afmG;
  static final HashMap<String, e.b> afmH;
  
  static
  {
    AppMethodBeat.i(256825);
    afmG = new f();
    HashMap localHashMap = new HashMap();
    afmH = localHashMap;
    ((Map)localHashMap).put("notifymessage", new e.b()
    {
      private static final void lV(View paramAnonymousView)
      {
        AppMethodBeat.i(256547);
        s.u(paramAnonymousView, "$view");
        cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG("notifymessage");
        Object localObject = paramAnonymousView.getTag(R.h.fDx);
        if (localObject == null)
        {
          paramAnonymousView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.storage.Conversation");
          AppMethodBeat.o(256547);
          throw paramAnonymousView;
        }
        localObject = (bb)localObject;
        paramAnonymousView = paramAnonymousView.getTag(R.h.fDz);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(256547);
          throw paramAnonymousView;
        }
        int j = ((Integer)paramAnonymousView).intValue();
        int k = (int)(localcc.getCreateTime() / 1000L);
        paramAnonymousView = ((bd)localObject).field_digest;
        if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acOa, true)) {}
        for (int i = 0;; i = 1)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(22611, new Object[] { Integer.valueOf(1), Integer.valueOf(k), paramAnonymousView, Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(256547);
          return;
        }
      }
      
      public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(256556);
        s.u(paramAnonymousView, "view");
        Log.i("MicroMsg.ConversationWithCacheAdapter", s.X("notifymessage item explosure,isExposed = ", Boolean.valueOf(paramAnonymousBoolean)));
        if (paramAnonymousBoolean) {
          com.tencent.threadpool.h.ahAA.bo(new f.1..ExternalSyntheticLambda0(paramAnonymousView));
        }
        AppMethodBeat.o(256556);
      }
    });
    AppMethodBeat.o(256825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */