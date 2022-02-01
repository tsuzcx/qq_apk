package com.tencent.mm.plugin.sns.storage.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.vending.c.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/cover/cgi/SnsCgi;", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "TAG", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CgiException", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<Response extends esc>
  extends com.tencent.mm.am.b<Response>
{
  private final String TAG = "MicroMsg.SnsCgi";
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/cover/cgi/SnsCgi$CgiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorType", "", "errorCode", "message", "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorType", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends Exception
  {
    public final int errorCode;
    private final int hDx;
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super();
      AppMethodBeat.i(306695);
      this.hDx = paramInt1;
      this.errorCode = paramInt2;
      AppMethodBeat.o(306695);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    public b(f<ah> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c<_Ret, _Var>
    implements a
  {
    public c(b<Response> paramb, p<? super Response> paramp) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a.a.b
 * JD-Core Version:    0.7.0.1
 */