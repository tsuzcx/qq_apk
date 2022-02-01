package com.tencent.mm.sdk.kt;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.l.c;

@Metadata(d1={""}, d2={"getParameterizedTypeClass", "Ljava/lang/Class;", "clazz", "Lkotlin/reflect/KClass;", "multiLet", "R", "T1", "", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "uiThread", "", "Lkotlin/Function0;", "wechat-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class CommonKt
{
  public static final Class<?> getParameterizedTypeClass(c<?> paramc)
  {
    AppMethodBeat.i(243146);
    kotlin.g.b.s.u(paramc, "clazz");
    Type localType = kotlin.g.a.b(paramc).getGenericSuperclass();
    kotlin.g.b.s.s(localType, "clazz.java.genericSuperclass");
    while (!(localType instanceof ParameterizedType))
    {
      localType = kotlin.g.a.b(paramc).getSuperclass().getGenericSuperclass();
      kotlin.g.b.s.s(localType, "clazz.java.superclass.genericSuperclass");
    }
    paramc = ((ParameterizedType)localType).getActualTypeArguments()[0];
    if ((paramc instanceof Class))
    {
      paramc = (Class)paramc;
      AppMethodBeat.o(243146);
      return paramc;
    }
    AppMethodBeat.o(243146);
    return null;
  }
  
  public static final <T1, T2, T3, T4, T5, R> R multiLet(T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5, kotlin.g.a.s<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> params)
  {
    AppMethodBeat.i(243142);
    kotlin.g.b.s.u(params, "block");
    if ((paramT1 != null) && (paramT2 != null) && (paramT3 != null) && (paramT4 != null) && (paramT5 != null))
    {
      paramT1 = params.a(paramT1, paramT2, paramT3, paramT4, paramT5);
      AppMethodBeat.o(243142);
      return paramT1;
    }
    AppMethodBeat.o(243142);
    return null;
  }
  
  public static final <T1, T2, T3, T4, R> R multiLet(T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramr)
  {
    AppMethodBeat.i(243140);
    kotlin.g.b.s.u(paramr, "block");
    if ((paramT1 != null) && (paramT2 != null) && (paramT3 != null) && (paramT4 != null))
    {
      paramT1 = paramr.a(paramT1, paramT2, paramT3, paramT4);
      AppMethodBeat.o(243140);
      return paramT1;
    }
    AppMethodBeat.o(243140);
    return null;
  }
  
  public static final <T1, T2, T3, R> R multiLet(T1 paramT1, T2 paramT2, T3 paramT3, q<? super T1, ? super T2, ? super T3, ? extends R> paramq)
  {
    AppMethodBeat.i(243136);
    kotlin.g.b.s.u(paramq, "block");
    if ((paramT1 != null) && (paramT2 != null) && (paramT3 != null))
    {
      paramT1 = paramq.invoke(paramT1, paramT2, paramT3);
      AppMethodBeat.o(243136);
      return paramT1;
    }
    AppMethodBeat.o(243136);
    return null;
  }
  
  public static final <T1, T2, R> R multiLet(T1 paramT1, T2 paramT2, m<? super T1, ? super T2, ? extends R> paramm)
  {
    AppMethodBeat.i(243133);
    kotlin.g.b.s.u(paramm, "block");
    if ((paramT1 != null) && (paramT2 != null))
    {
      paramT1 = paramm.invoke(paramT1, paramT2);
      AppMethodBeat.o(243133);
      return paramT1;
    }
    AppMethodBeat.o(243133);
    return null;
  }
  
  public static final void uiThread(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(243130);
    kotlin.g.b.s.u(parama, "block");
    if (kotlin.g.b.s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(243130);
      return;
    }
    h.ahAA.bk((Runnable)new CommonKt.uiThread.1(parama));
    AppMethodBeat.o(243130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.kt.CommonKt
 * JD-Core Version:    0.7.0.1
 */