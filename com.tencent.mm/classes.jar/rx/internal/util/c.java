package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import rx.b.b;
import rx.b.e;
import rx.b.f;
import rx.d;
import rx.d.b;
import rx.internal.a.h;

public enum c
{
  public static final e Oaf;
  public static final c Oag;
  public static final g Oah;
  static final f Oai;
  public static final d Oaj;
  static final b Oak;
  public static final b<Throwable> Oal;
  public static final d.b<Boolean, Object> Oam;
  
  static
  {
    AppMethodBeat.i(90218);
    Oan = new c[0];
    Oaf = new e();
    Oag = new c();
    Oah = new g();
    Oai = new f();
    Oaj = new d();
    Oak = new b();
    Oal = new a();
    Oam = new h(j.a.OaJ);
    AppMethodBeat.o(90218);
  }
  
  static final class a
    implements b<Throwable>
  {}
  
  static final class b
    implements e<rx.c<?>, Throwable>
  {}
  
  public static final class c
    implements f<Object, Object, Boolean>
  {}
  
  public static final class d
    implements f<Integer, Object, Integer>
  {}
  
  public static final class e
    implements f<Long, Object, Long>
  {}
  
  static final class f
    implements e<Object, Void>
  {}
  
  public static final class g
    implements e<List<? extends d<?>>, d<?>[]>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.internal.util.c
 * JD-Core Version:    0.7.0.1
 */