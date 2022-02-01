package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
  implements c<T>
{
  /* Error */
  public final Object a(h<? super T> paramh, kotlin.d.d<? super ah> paramd)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 9
    //   4: ifeq +78 -> 82
    //   7: aload_2
    //   8: checkcast 9	kotlinx/coroutines/b/a$a
    //   11: astore_3
    //   12: aload_3
    //   13: getfield 41	kotlinx/coroutines/b/a$a:label	I
    //   16: ldc 42
    //   18: iand
    //   19: ifeq +63 -> 82
    //   22: aload_3
    //   23: aload_3
    //   24: getfield 41	kotlinx/coroutines/b/a$a:label	I
    //   27: ldc 42
    //   29: iadd
    //   30: putfield 41	kotlinx/coroutines/b/a$a:label	I
    //   33: aload_3
    //   34: astore_2
    //   35: aload_2
    //   36: getfield 46	kotlinx/coroutines/b/a$a:result	Ljava/lang/Object;
    //   39: astore 4
    //   41: getstatic 52	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   44: astore_3
    //   45: aload_2
    //   46: getfield 41	kotlinx/coroutines/b/a$a:label	I
    //   49: tableswitch	default:+23 -> 72, 0:+46->95, 1:+97->146
    //   73: nop
    //   74: istore 89
    //   76: ldc 56
    //   78: invokespecial 59	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: new 9	kotlinx/coroutines/b/a$a
    //   85: dup
    //   86: aload_0
    //   87: aload_2
    //   88: invokespecial 62	kotlinx/coroutines/b/a$a:<init>	(Lkotlinx/coroutines/b/a;Lkotlin/d/d;)V
    //   91: astore_2
    //   92: goto -57 -> 35
    //   95: aload 4
    //   97: invokestatic 68	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   100: new 70	kotlinx/coroutines/b/a/v
    //   103: dup
    //   104: aload_1
    //   105: aload_2
    //   106: invokeinterface 76 1 0
    //   111: invokespecial 79	kotlinx/coroutines/b/a/v:<init>	(Lkotlinx/coroutines/b/h;Lkotlin/d/f;)V
    //   114: astore_1
    //   115: aload_1
    //   116: checkcast 81	kotlinx/coroutines/b/h
    //   119: astore 4
    //   121: aload_2
    //   122: aload_1
    //   123: putfield 84	kotlinx/coroutines/b/a$a:L$0	Ljava/lang/Object;
    //   126: aload_2
    //   127: iconst_1
    //   128: putfield 41	kotlinx/coroutines/b/a$a:label	I
    //   131: aload_0
    //   132: aload 4
    //   134: aload_2
    //   135: invokevirtual 87	kotlinx/coroutines/b/a:b	(Lkotlinx/coroutines/b/h;Lkotlin/d/d;)Ljava/lang/Object;
    //   138: astore_2
    //   139: aload_2
    //   140: aload_3
    //   141: if_acmpne +18 -> 159
    //   144: aload_3
    //   145: areturn
    //   146: aload_2
    //   147: getfield 84	kotlinx/coroutines/b/a$a:L$0	Ljava/lang/Object;
    //   150: checkcast 70	kotlinx/coroutines/b/a/v
    //   153: astore_1
    //   154: aload 4
    //   156: invokestatic 68	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   159: aload_1
    //   160: invokevirtual 90	kotlinx/coroutines/b/a/v:releaseIntercepted	()V
    //   163: getstatic 96	kotlin/ah:aiuX	Lkotlin/ah;
    //   166: areturn
    //   167: astore_2
    //   168: aload_1
    //   169: invokevirtual 90	kotlinx/coroutines/b/a/v:releaseIntercepted	()V
    //   172: aload_2
    //   173: athrow
    //   174: astore_2
    //   175: goto -7 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	a
    //   0	178	1	paramh	h<? super T>
    //   0	178	2	paramd	kotlin.d.d<? super ah>
    //   11	134	3	localObject1	Object
    //   39	116	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   115	139	167	finally
    //   154	159	174	finally
  }
  
  public abstract Object b(h<? super T> paramh, kotlin.d.d<? super ah> paramd);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(a<T> parama, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189010);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ajxQ.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(189010);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a
 * JD-Core Version:    0.7.0.1
 */