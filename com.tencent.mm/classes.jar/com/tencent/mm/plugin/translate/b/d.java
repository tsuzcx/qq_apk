package com.tencent.mm.plugin.translate.b;

import androidx.lifecycle.af;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.fqj;
import com.tencent.mm.protocal.protobuf.fqk;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.event.MvvmEventCenter.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/translate/model/TranslateInWritingHelper;", "Landroidx/lifecycle/ViewModel;", "()V", "doTranslateInWritingCgi", "", "clientMsgID", "", "targetLan", "", "chatRoomId", "prefixContent", "scene", "textMsg", "doTranslateInWritingCgiChat", "doTranslateInWritingCgiChatRoom", "sendTransResult", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends af
{
  public static final a TSM;
  private static int TSN;
  
  static
  {
    AppMethodBeat.i(260413);
    TSM = new a((byte)0);
    AppMethodBeat.o(260413);
  }
  
  private void a(final int paramInt1, String paramString1, final String paramString2, final String paramString3, final int paramInt2, final String paramString4)
  {
    AppMethodBeat.i(260409);
    s.u(paramString1, "targetLan");
    s.u(paramString2, "chatRoomId");
    s.u(paramString3, "prefixContent");
    s.u(paramString4, "textMsg");
    if (((CharSequence)paramString4).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(260409);
      return;
    }
    Log.i("MicroMsg.Translate.TranslateInWritingHelper", "doTranslateInWritingCgi clientMsgID:" + paramInt1 + " targetLan:" + paramString1 + " chatRoomId:" + paramString2 + " prefixContent:" + paramString3 + " scene:" + paramInt2 + " textMsg:" + paramString4);
    LifecycleScope localLifecycleScope = com.tencent.mm.kernel.h.baC().mBP.mBB;
    if (localLifecycleScope != null) {
      LifecycleScope.launchDefault$default(localLifecycleScope, null, (m)new b(paramString1, paramString2, paramInt1, paramString3, paramInt2, paramString4, this, null), 1, null);
    }
    AppMethodBeat.o(260409);
  }
  
  public final void h(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(260416);
    s.u(paramString1, "targetLan");
    s.u(paramString2, "chatRoomId");
    s.u(paramString3, "prefixContent");
    s.u(paramString4, "textMsg");
    a(paramInt, paramString1, paramString2, paramString3, 29, paramString4);
    AppMethodBeat.o(260416);
  }
  
  public final void i(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(260418);
    s.u(paramString1, "targetLan");
    s.u(paramString2, "chatRoomId");
    s.u(paramString3, "prefixContent");
    s.u(paramString4, "textMsg");
    a(paramInt, paramString1, paramString2, paramString3, 30, paramString4);
    AppMethodBeat.o(260418);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/translate/model/TranslateInWritingHelper$Companion;", "", "()V", "TAG", "", "curId", "", "getCurId", "()I", "setCurId", "(I)V", "allocClientMsgId", "get", "Lcom/tencent/mm/plugin/translate/model/TranslateInWritingHelper;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static d hPv()
    {
      AppMethodBeat.i(260414);
      com.tencent.mm.kernel.h.baC().aZJ();
      Object localObject = new androidx.lifecycle.ah((ak)com.tencent.mm.kernel.h.baC().mBP, (ah.b)new a()).q(d.class);
      s.s(localObject, "ViewModelProvider(\n     …ritingHelper::class.java)");
      localObject = (d)localObject;
      AppMethodBeat.o(260414);
      return localObject;
    }
    
    public static int hPw()
    {
      AppMethodBeat.i(260417);
      int i = d.hPu();
      d.apl(i + 1);
      AppMethodBeat.o(260417);
      return i;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/translate/model/TranslateInWritingHelper$Companion$get$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ah.b
    {
      public final <T extends af> T create(Class<T> paramClass)
      {
        AppMethodBeat.i(260403);
        s.u(paramClass, "modelClass");
        paramClass = (af)paramClass.newInstance();
        AppMethodBeat.o(260403);
        return paramClass;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, d paramd, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(260438);
      paramObject = (kotlin.d.d)new b(this.TSO, paramString2, paramInt1, paramString3, paramInt2, paramString4, jdField_this, paramd);
      AppMethodBeat.o(260438);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260425);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(260425);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new ctv();
      paramObject.vgM = 1;
      paramObject.aazy = this.TSO;
      localObject1 = paramObject.aazx;
      fqj localfqj = new fqj();
      Object localObject2 = paramString2;
      int i = paramInt1;
      String str1 = paramString3;
      int j = paramInt2;
      String str2 = paramString4;
      localfqj.abQo = ((String)localObject2);
      localfqj.abQm = i;
      localfqj.abQp = str1;
      localfqj.IJG = j;
      localfqj.abQn = str2;
      localObject2 = kotlin.ah.aiuX;
      ((LinkedList)localObject1).add(localfqj);
      localObject1 = new c.a();
      ((c.a)localObject1).funcId = 631;
      ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)paramObject);
      ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new ctw());
      paramObject = ((c.a)localObject1).bEF();
      localObject1 = com.tencent.mm.am.a.b.ovw;
      s.s(paramObject, "commReqResp");
      paramObject = b.a.e(paramObject);
      localObject1 = com.tencent.mm.kernel.h.baC().mBP.mBB;
      if (localObject1 != null) {
        LifecycleScope.launchDefault$default((LifecycleScope)localObject1, null, (m)new k(paramObject, jdField_this)
        {
          int label;
          
          public final kotlin.d.d<kotlin.ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(260406);
            paramAnonymousObject = (kotlin.d.d)new 1(this.TSU, this.TST, paramAnonymousd);
            AppMethodBeat.o(260406);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(260402);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(260402);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = this.TSU;
              kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.TST);
              kotlin.d.d locald = (kotlin.d.d)this;
              this.label = 1;
              if (paramAnonymousObject.a(localh, locald) == locala)
              {
                AppMethodBeat.o(260402);
                return locala;
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            paramAnonymousObject = kotlin.ah.aiuX;
            AppMethodBeat.o(260402);
            return paramAnonymousObject;
          }
          
          @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
          public static final class a
            implements kotlinx.coroutines.b.h<com.tencent.mm.am.a.a<ctw>>
          {
            public a(d paramd) {}
            
            public final Object a(com.tencent.mm.am.a.a<ctw> parama, kotlin.d.d<? super kotlin.ah> paramd)
            {
              AppMethodBeat.i(260407);
              parama = (com.tencent.mm.am.a.a)parama;
              if (parama.ovD == com.tencent.mm.am.b.b.ovB)
              {
                Log.i("MicroMsg.Translate.TranslateInWritingHelper", "onTranslateEnd " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
                parama = (ctw)parama.ott;
                if (parama != null) {
                  break label103;
                }
              }
              for (parama = null;; parama = null)
              {
                if (parama == null) {
                  d.du(-1, "");
                }
                parama = kotlin.ah.aiuX;
                AppMethodBeat.o(260407);
                return parama;
                label103:
                parama = parama.aazx;
                if (parama != null) {
                  break;
                }
              }
              int i;
              if (!parama.isEmpty())
              {
                paramd = (CharSequence)((fqk)parama.get(0)).TSI;
                if ((paramd == null) || (paramd.length() == 0))
                {
                  i = 1;
                  label154:
                  if (i == 0) {
                    break label223;
                  }
                }
              }
              else
              {
                Log.i("MicroMsg.Translate.TranslateInWritingHelper", "onTranslateEndSuccess msgList.isEmpty():" + parama.isEmpty() + ' ');
                ((com.tencent.mm.plugin.translate.a.a)MvvmEventCenter.Companion.getEvent(com.tencent.mm.plugin.translate.a.a.class)).publish(new com.tencent.mm.plugin.translate.a.b(-1, ""));
              }
              for (;;)
              {
                parama = kotlin.ah.aiuX;
                break;
                i = 0;
                break label154;
                label223:
                parama = (fqk)parama.get(0);
                Log.i("MicroMsg.Translate.TranslateInWritingHelper", "onTranslateEndSuccess " + parama.abQm + ' ' + parama.TSI);
                i = parama.abQm;
                parama = parama.TSI;
                s.s(parama, "TranslatedText");
                d.du(i, parama);
              }
            }
          }
        }, 1, null);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(260425);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.b.d
 * JD-Core Version:    0.7.0.1
 */