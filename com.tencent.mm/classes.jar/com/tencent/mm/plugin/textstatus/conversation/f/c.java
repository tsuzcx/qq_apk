package com.tencent.mm.plugin.textstatus.conversation.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/middler/TextStatusGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "scene", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements af.b
{
  public static final c.a Tjm;
  private final j AFU;
  
  static
  {
    AppMethodBeat.i(291040);
    Tjm = new c.a((byte)0);
    AppMethodBeat.o(291040);
  }
  
  public c()
  {
    AppMethodBeat.i(291033);
    this.AFU = k.cm((kotlin.g.a.a)c.c.Tjn);
    AppMethodBeat.o(291033);
  }
  
  public final boolean aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(291057);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (paramInt = 1; (paramInt == 0) && (au.bwY(paramString)); paramInt = 0)
    {
      AppMethodBeat.o(291057);
      return true;
    }
    AppMethodBeat.o(291057);
    return false;
  }
  
  public final az.b bCe()
  {
    AppMethodBeat.i(291046);
    az.b localb = (az.b)new b();
    AppMethodBeat.o(291046);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/middler/TextStatusGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements az.b
  {
    private static final void b(ah.f paramf, az.b.a parama, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(291007);
      s.u(paramf, "$talker");
      Log.i("MicroMsg.TextStatus.TextStatusGetContactInterceptor", "[getContact] callback! succ=" + paramBoolean + ", username=" + paramString + " talker=" + (String)paramf.aqH);
      if (parama != null) {
        parama.getContactCallBack(paramString, paramBoolean);
      }
      AppMethodBeat.o(291007);
    }
    
    public final void Jq(String paramString) {}
    
    public final void Jr(String paramString) {}
    
    public final void a(String paramString1, String paramString2, final az.b.a parama)
    {
      AppMethodBeat.i(291031);
      final ah.f localf;
      if (paramString1 != null)
      {
        localf = new ah.f();
        localf.aqH = paramString1;
        if (!au.bwY(paramString1)) {
          break label179;
        }
        paramString2 = ((t)h.ax(t.class)).aAw(paramString1);
        s.s(paramString2, "service(ITextStatusSessi…TalkerFromLocal(username)");
        localf.aqH = paramString2;
      }
      label179:
      for (paramString2 = paramString1;; paramString2 = "")
      {
        Log.i("MicroMsg.TextStatus.TextStatusGetContactInterceptor", "[getContact] sessionId=" + paramString2 + " talker=" + (String)localf.aqH);
        if (au.bwY(paramString2))
        {
          com.tencent.mm.plugin.textstatus.conversation.g.a locala = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
          com.tencent.mm.plugin.textstatus.conversation.g.a.bdK(paramString2);
          d.uiThread((kotlin.g.a.a)new a(paramString1, localf, parama));
          AppMethodBeat.o(291031);
          return;
        }
        paramString2 = az.a.okP;
        if ((paramString2 instanceof af)) {
          ((af)paramString2).okv.a(paramString1, "", new c.b..ExternalSyntheticLambda0(localf, parama));
        }
        AppMethodBeat.o(291031);
        return;
      }
    }
    
    public final void aZ(String paramString1, String paramString2) {}
    
    public final void bCc() {}
    
    public final void j(String paramString1, int paramInt, String paramString2) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(String paramString, ah.f<String> paramf, az.b.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.f.c
 * JD-Core Version:    0.7.0.1
 */