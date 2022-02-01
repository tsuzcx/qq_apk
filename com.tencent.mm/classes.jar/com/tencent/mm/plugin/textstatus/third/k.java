package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.plugin.textstatus.a.z;
import com.tencent.mm.plugin.textstatus.proto.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/TextStatusActionService;", "", "()V", "INVALID_TASK", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusActionTask;", "getINVALID_TASK", "()Lcom/tencent/mm/plugin/textstatus/api/ITextStatusActionTask;", "TAG", "", "getTAG", "()Ljava/lang/String;", "executeTextStatusAction", "context", "Landroid/content/Context;", "param", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionParam;", "_callback", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionCallback;", "hasValidSignature", "", "isValid", "Lcom/tencent/mm/plugin/textstatus/proto/PaySignature;", "print", "Lcom/tencent/mm/plugin/textstatus/proto/ResultSetTextStatus;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusActionResultInfo;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static final String TAG;
  public static final k TuZ;
  private static final com.tencent.mm.plugin.textstatus.a.q Tva;
  
  static
  {
    AppMethodBeat.i(290162);
    TuZ = new k();
    TAG = "MicroMsg.TextStatus.TextStatusActionService";
    Tva = (com.tencent.mm.plugin.textstatus.a.q)new a();
    AppMethodBeat.o(290162);
  }
  
  private static final void a(y paramy, int paramInt, String paramString, com.tencent.mm.plugin.textstatus.proto.q paramq)
  {
    Object localObject = null;
    StringBuilder localStringBuilder1 = null;
    AppMethodBeat.i(290154);
    String str = TAG;
    StringBuilder localStringBuilder2 = new StringBuilder("onFinishAction result:").append(paramInt).append(", errMsg:").append(paramString).append(", resultInfo:");
    if (paramq == null)
    {
      localObject = localStringBuilder1;
      Log.i(str, localObject);
      if (paramy != null) {
        paramy.onFinishAction(paramInt, paramString, paramq);
      }
      AppMethodBeat.o(290154);
      return;
    }
    s.u(paramq, "<this>");
    localStringBuilder1 = new StringBuilder("resultInfo: action:").append(paramq.action).append(" ResultSetTextStatus:");
    m localm = paramq.Tpn;
    if (localm == null) {}
    for (;;)
    {
      localObject = localObject;
      break;
      s.u(localm, "<this>");
      localObject = "iconId:" + localm.ToR + " iconDesc:" + localm.Okz;
    }
  }
  
  public static com.tencent.mm.plugin.textstatus.a.q b(Context paramContext, z paramz, y paramy)
  {
    int k = 0;
    AppMethodBeat.i(290144);
    Log.i(TAG, "executeTextStatusAction() called with: context = " + paramContext + ", param = " + paramz + ", _callback = " + paramy);
    paramy = new k..ExternalSyntheticLambda0(paramy);
    if ((paramContext == null) || (paramz == null))
    {
      paramy.onFinishAction(1, "param null", null);
      paramContext = Tva;
      AppMethodBeat.o(290144);
      return paramContext;
    }
    s.u(paramz, "<this>");
    s.u(paramz, "<this>");
    Object localObject = (CharSequence)paramz.Tov;
    label167:
    label195:
    label201:
    int j;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label286;
      }
      localObject = paramz.Tow;
      if ((localObject == null) || (TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.textstatus.proto.k)localObject).Oks)) || (TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.textstatus.proto.k)localObject).ToN))) {
        break label276;
      }
      i = 1;
      if (i != 0) {
        break label286;
      }
      localObject = (CharSequence)paramz.ToC;
      if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
        break label281;
      }
      i = 1;
      if (i == 0) {
        break label286;
      }
      i = 0;
      localObject = (CharSequence)paramz.Tox;
      if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
        break label291;
      }
      j = 1;
      label226:
      if (j != 0) {
        break label297;
      }
      j = 1;
      label234:
      if ((i != 0) || (j != 0)) {
        break label303;
      }
    }
    label276:
    label281:
    label286:
    label291:
    label297:
    label303:
    for (int i = k;; i = 1)
    {
      if (i != 0) {
        break label308;
      }
      paramy.onFinishAction(1, "param invalid", null);
      paramContext = Tva;
      AppMethodBeat.o(290144);
      return paramContext;
      i = 0;
      break;
      i = 0;
      break label167;
      i = 0;
      break label195;
      i = 1;
      break label201;
      j = 0;
      break label226;
      j = 0;
      break label234;
    }
    label308:
    paramContext = new l(paramContext, paramz, paramy);
    paramContext.hIe();
    paramContext = (com.tencent.mm.plugin.textstatus.a.q)paramContext;
    AppMethodBeat.o(290144);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/TextStatusActionService$INVALID_TASK$1", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusActionTask;", "cancel", "", "doTask", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.textstatus.a.q
  {
    public final void cancel() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.k
 * JD-Core Version:    0.7.0.1
 */