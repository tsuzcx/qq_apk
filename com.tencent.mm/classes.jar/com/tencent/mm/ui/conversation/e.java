package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.view.e.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/conversation/ConvItemExposureHelper;", "", "()V", "talkerToListener", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "Lkotlin/collections/HashMap;", "registeredExposureListener", "", "talker", "itemView", "Landroid/view/View;", "app_release"})
public final class e
{
  static final HashMap<String, e.b> XzY;
  public static final e XzZ;
  
  static
  {
    AppMethodBeat.i(288258);
    XzZ = new e();
    HashMap localHashMap = new HashMap();
    XzY = localHashMap;
    ((Map)localHashMap).put("notifymessage", new e.b()
    {
      public final void p(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(269559);
        p.k(paramAnonymousView, "view");
        Log.i("MicroMsg.ConversationWithCacheAdapter", "notifymessage item explosure,isExposed = ".concat(String.valueOf(paramAnonymousBoolean)));
        if (paramAnonymousBoolean) {
          com.tencent.e.h.ZvG.bg((Runnable)new a(paramAnonymousView));
        }
        AppMethodBeat.o(269559);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(View paramView) {}
        
        public final void run()
        {
          AppMethodBeat.i(290931);
          Object localObject1 = com.tencent.mm.kernel.h.ae(n.class);
          p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          localObject1 = ((n)localObject1).eSe().aOH("notifymessage");
          Object localObject2 = this.kqJ.getTag(R.h.dCI);
          if (localObject2 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.storage.Conversation");
            AppMethodBeat.o(290931);
            throw ((Throwable)localObject1);
          }
          localObject2 = (az)localObject2;
          Object localObject3 = this.kqJ.getTag(R.h.dCJ);
          if (localObject3 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(290931);
            throw ((Throwable)localObject1);
          }
          int j = ((Integer)localObject3).intValue();
          p.j(localObject1, "msg");
          int k = (int)(((ca)localObject1).getCreateTime() / 1000L);
          localObject1 = ((az)localObject2).getDigest();
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          if (((f)localObject2).aHp().getBoolean(ar.a.VmF, true)) {}
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(22611, new Object[] { Integer.valueOf(1), Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(290931);
            return;
          }
        }
      }
    });
    AppMethodBeat.o(288258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */