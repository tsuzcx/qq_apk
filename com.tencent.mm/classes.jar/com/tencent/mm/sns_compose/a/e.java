package com.tencent.mm.sns_compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/PageLoadResult;", "T", "", "()V", "Fail", "Success", "Lcom/tencent/mm/sns_compose/api/PageLoadResult$Success;", "Lcom/tencent/mm/sns_compose/api/PageLoadResult$Fail;", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e<T>
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/PageLoadResult$Fail;", "T", "", "Lcom/tencent/mm/sns_compose/api/PageLoadResult;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<T>
    extends e<T>
  {
    private final String msg = null;
    
    private a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/PageLoadResult$Success;", "T", "", "Lcom/tencent/mm/sns_compose/api/PageLoadResult;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b<T>
    extends e<T>
  {
    public final T cpt;
    
    public b(T paramT)
    {
      super();
      AppMethodBeat.i(235468);
      this.cpt = paramT;
      AppMethodBeat.o(235468);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.a.e
 * JD-Core Version:    0.7.0.1
 */