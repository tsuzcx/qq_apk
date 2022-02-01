package kotlin.l.b.a.b.k.a;

import java.util.Collection;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.a.l;
import kotlin.l.b.a.b.e.b.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.k.a.b.g;
import kotlin.l.b.a.b.l.m;

public abstract class p
  extends o
{
  private final kotlin.l.b.a.b.e.b.a ajlN;
  private final g ajmm;
  private final d ajmp;
  final x ajmq;
  private a.l ajmr;
  private h ajms;
  
  public p(kotlin.l.b.a.b.f.c paramc, m paramm, ae paramae, a.l paraml, kotlin.l.b.a.b.e.b.a parama)
  {
    super(paramc, paramm, paramae);
    this.ajlN = parama;
    this.ajmm = null;
    paramc = paraml.ajah;
    s.s(paramc, "proto.strings");
    paramm = paraml.ajai;
    s.s(paramm, "proto.qualifiedNames");
    this.ajmp = new d(paramc, paramm);
    this.ajmq = new x(paraml, (kotlin.l.b.a.b.e.b.c)this.ajmp, this.ajlN, (kotlin.g.a.b)new a(this));
    this.ajmr = paraml;
  }
  
  public final void b(j paramj)
  {
    s.u(paramj, "components");
    Object localObject = this.ajmr;
    if (localObject == null) {
      throw ((Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString()));
    }
    this.ajmr = null;
    ah localah = (ah)this;
    localObject = ((a.l)localObject).ajaj;
    s.s(localObject, "proto.`package`");
    this.ajms = ((h)new kotlin.l.b.a.b.k.a.b.j(localah, (a.k)localObject, (kotlin.l.b.a.b.e.b.c)this.ajmp, this.ajlN, this.ajmm, paramj, s.X("scope of ", this), (kotlin.g.a.a)new b(this)));
  }
  
  public final h knP()
  {
    h localh2 = this.ajms;
    h localh1 = localh2;
    if (localh2 == null)
    {
      s.bIx("_memberScope");
      localh1 = null;
    }
    return localh1;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.b, av>
  {
    a(p paramp)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<Collection<? extends f>>
  {
    b(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.p
 * JD-Core Version:    0.7.0.1
 */