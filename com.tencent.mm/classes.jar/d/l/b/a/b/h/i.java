package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class i
  extends a
  implements Serializable
{
  protected i() {}
  
  protected i(byte paramByte) {}
  
  public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType paramContainingType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new f(paramContainingType, Collections.emptyList(), paramq, new e(paramInt, parama, true), paramClass);
  }
  
  public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType paramContainingType, Type paramType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new f(paramContainingType, paramType, paramq, new e(paramInt, parama, false), paramClass);
  }
  
  static Object c(Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(null, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  static Method d(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      paramClass = String.valueOf(String.valueOf(paramClass.getName()));
      paramString = String.valueOf(String.valueOf(paramString));
      throw new RuntimeException(paramClass.length() + 45 + paramString.length() + "Generated message class \"" + paramClass + "\" missing method \"" + paramString + "\".", paramVarArgs);
    }
  }
  
  protected boolean a(e parame, f paramf, g paramg, int paramInt)
  {
    return parame.a(paramInt, paramf);
  }
  
  public s<? extends q> gmo()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected void grN() {}
  
  public static abstract class a<MessageType extends i, BuilderType extends a>
    extends a.a<BuilderType>
  {
    public d NjY = d.NqI;
    
    public abstract BuilderType a(MessageType paramMessageType);
    
    public BuilderType gmA()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public abstract MessageType gmz();
  }
  
  public static abstract class b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends i.a<MessageType, BuilderType>
    implements i.d<MessageType>
  {
    protected h<i.e> Nra = h.grG();
    private boolean Nrb;
    
    protected final void a(MessageType paramMessageType)
    {
      if (!this.Nrb)
      {
        this.Nra = this.Nra.grI();
        this.Nrb = true;
      }
      h localh = this.Nra;
      paramMessageType = i.c.b(paramMessageType);
      int i = 0;
      while (i < paramMessageType.NqU.gse())
      {
        localh.f(paramMessageType.NqU.alj(i));
        i += 1;
      }
      paramMessageType = paramMessageType.NqU.gsf().iterator();
      while (paramMessageType.hasNext()) {
        localh.f((Map.Entry)paramMessageType.next());
      }
    }
    
    public BuilderType gnp()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements i.d<MessageType>
  {
    protected final h<i.e> Nra;
    
    protected c()
    {
      this.Nra = h.grF();
    }
    
    protected c(i.b<MessageType, ?> paramb)
    {
      this.Nra = i.b.a(paramb);
    }
    
    private void b(i.f<MessageType, ?> paramf)
    {
      if (paramf.Nrk != gmu()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> Type a(i.f<MessageType, List<Type>> paramf, int paramInt)
    {
      b(paramf);
      Object localObject = this.Nra;
      i.e locale = paramf.Nrm;
      if (!locale.grL()) {
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      }
      localObject = ((h)localObject).a(locale);
      if (localObject == null) {
        throw new IndexOutOfBoundsException();
      }
      return paramf.fp(((List)localObject).get(paramInt));
    }
    
    protected final boolean a(e parame, f paramf, g paramg, int paramInt)
    {
      h localh = this.Nra;
      Object localObject = gmu();
      int i = z.fQ(paramInt);
      int j = z.fR(paramInt);
      i.f localf = (i.f)paramg.NqS.get(new g.a(localObject, j));
      if (localf != null) {
        if (i == h.a(localf.Nrm.Nrh, false))
        {
          i = 0;
          j = 0;
        }
      }
      while (j != 0)
      {
        return parame.a(paramInt, paramf);
        if ((localf.Nrm.Nri) && (localf.Nrm.Nrh.gsm()) && (i == h.a(localf.Nrm.Nrh, true)))
        {
          i = 1;
          j = 0;
        }
        else
        {
          i = 0;
          j = 1;
        }
      }
      if (i != 0)
      {
        paramInt = parame.fG(parame.zc());
        if (localf.Nrm.Nrh == z.a.Nsv) {
          while (parame.zf() > 0)
          {
            i = parame.zc();
            paramf = localf.Nrm.Nrg.ajA(i);
            if (paramf == null) {
              break label273;
            }
            localh.b(localf.Nrm, localf.fq(paramf));
          }
        }
        while (parame.zf() > 0)
        {
          paramf = h.a(parame, localf.Nrm.Nrh);
          localh.b(localf.Nrm, paramf);
        }
        parame.fH(paramInt);
      }
      for (;;)
      {
        label273:
        return true;
        switch (i.1.NqY[localf.Nrm.Nrh.NsA.ordinal()])
        {
        default: 
          parame = h.a(parame, localf.Nrm.Nrh);
          label329:
          if (!localf.Nrm.Nri) {
            break label620;
          }
          localh.b(localf.Nrm, localf.fq(parame));
        }
      }
      if (!localf.Nrm.Nri)
      {
        paramf = (q)localh.a(localf.Nrm);
        if (paramf == null) {}
      }
      for (paramf = paramf.gms();; paramf = null)
      {
        localObject = paramf;
        if (paramf == null) {
          localObject = localf.Nrl.gmt();
        }
        if (localf.Nrm.Nrh == z.a.Nsr)
        {
          paramInt = localf.Nrm.number;
          if (parame.bQK >= parame.bQL) {
            throw k.grV();
          }
          parame.bQK += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fE(z.bC(paramInt, 4));
          parame.bQK -= 1;
        }
        for (;;)
        {
          parame = ((q.a)localObject).gmC();
          break;
          paramInt = parame.zc();
          if (parame.bQK >= parame.bQL) {
            throw k.grV();
          }
          paramInt = parame.fG(paramInt);
          parame.bQK += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fE(0);
          parame.bQK -= 1;
          parame.fH(paramInt);
        }
        i = parame.zc();
        paramg = localf.Nrm.Nrg.ajA(i);
        parame = paramg;
        if (paramg != null) {
          break label329;
        }
        paramf.fO(paramInt);
        paramf.fO(i);
        break;
        label620:
        localh.a(localf.Nrm, localf.fq(parame));
        break;
      }
    }
    
    public final <Type> boolean c(i.f<MessageType, Type> paramf)
    {
      b(paramf);
      h localh = this.Nra;
      paramf = paramf.Nrm;
      if (paramf.grL()) {
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      }
      return localh.NqU.get(paramf) != null;
    }
    
    public final <Type> int d(i.f<MessageType, List<Type>> paramf)
    {
      b(paramf);
      h localh = this.Nra;
      paramf = paramf.Nrm;
      if (!paramf.grL()) {
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      }
      paramf = localh.a(paramf);
      if (paramf == null) {
        return 0;
      }
      return ((List)paramf).size();
    }
    
    public final <Type> Type e(i.f<MessageType, Type> paramf)
    {
      b(paramf);
      Object localObject2 = this.Nra.a(paramf.Nrm);
      if (localObject2 == null) {
        localObject1 = paramf.aFh;
      }
      do
      {
        return localObject1;
        if (!paramf.Nrm.Nri) {
          break;
        }
        localObject1 = localObject2;
      } while (paramf.Nrm.Nrh.NsA != z.b.NsK);
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(paramf.fp(((Iterator)localObject2).next()));
      }
      return localObject1;
      return paramf.fp(localObject2);
    }
    
    protected final void grN()
    {
      this.Nra.grH();
    }
    
    protected final c<MessageType>.a grO()
    {
      return new a((byte)0);
    }
    
    public final class a
    {
      private final Iterator<Map.Entry<i.e, Object>> Nrc;
      private Map.Entry<i.e, Object> Nrd;
      private final boolean Nre;
      
      private a()
      {
        AppMethodBeat.i(59472);
        this$1 = i.c.b(i.c.this);
        if (i.c.this.NqW) {}
        for (this$1 = new l.b(i.c.this.NqU.entrySet().iterator());; this$1 = i.c.this.NqU.entrySet().iterator())
        {
          this.Nrc = i.c.this;
          if (this.Nrc.hasNext()) {
            this.Nrd = ((Map.Entry)this.Nrc.next());
          }
          this.Nre = false;
          AppMethodBeat.o(59472);
          return;
        }
      }
      
      public final void b(int paramInt, f paramf)
      {
        AppMethodBeat.i(59473);
        while ((this.Nrd != null) && (((i.e)this.Nrd.getKey()).number < paramInt))
        {
          i.e locale = (i.e)this.Nrd.getKey();
          if ((this.Nre) && (locale.Nrh.NsA == z.b.NsL) && (!locale.Nri)) {
            paramf.b(locale.number, (q)this.Nrd.getValue());
          }
          for (;;)
          {
            if (!this.Nrc.hasNext()) {
              break label139;
            }
            this.Nrd = ((Map.Entry)this.Nrc.next());
            break;
            h.a(locale, this.Nrd.getValue(), paramf);
          }
          label139:
          this.Nrd = null;
        }
        AppMethodBeat.o(59473);
      }
    }
  }
  
  public static abstract interface d
    extends r
  {}
  
  static final class e
    implements h.a<e>
  {
    final j.b<?> Nrg = null;
    final z.a Nrh;
    final boolean Nri;
    final boolean Nrj;
    final int number;
    
    e(int paramInt, z.a parama, boolean paramBoolean)
    {
      this.number = paramInt;
      this.Nrh = parama;
      this.Nri = paramBoolean;
      this.Nrj = false;
    }
    
    public final q.a a(q.a parama, q paramq)
    {
      AppMethodBeat.i(59474);
      parama = ((i.a)parama).a((i)paramq);
      AppMethodBeat.o(59474);
      return parama;
    }
    
    public final int getNumber()
    {
      return this.number;
    }
    
    public final z.a grJ()
    {
      return this.Nrh;
    }
    
    public final z.b grK()
    {
      return this.Nrh.NsA;
    }
    
    public final boolean grL()
    {
      return this.Nri;
    }
    
    public final boolean grM()
    {
      return this.Nrj;
    }
  }
  
  public static final class f<ContainingType extends q, Type>
  {
    final ContainingType Nrk;
    final q Nrl;
    final i.e Nrm;
    final Class Nrn;
    final Method Nro;
    final Type aFh;
    
    f(ContainingType paramContainingType, Type paramType, q paramq, i.e parame, Class paramClass)
    {
      AppMethodBeat.i(59475);
      if (paramContainingType == null)
      {
        paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      if ((parame.Nrh == z.a.Nss) && (paramq == null))
      {
        paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      this.Nrk = paramContainingType;
      this.aFh = paramType;
      this.Nrl = paramq;
      this.Nrm = parame;
      this.Nrn = paramClass;
      if (j.a.class.isAssignableFrom(paramClass))
      {
        this.Nro = i.d(paramClass, "valueOf", new Class[] { Integer.TYPE });
        AppMethodBeat.o(59475);
        return;
      }
      this.Nro = null;
      AppMethodBeat.o(59475);
    }
    
    final Object fp(Object paramObject)
    {
      AppMethodBeat.i(59476);
      if (this.Nrm.Nrh.NsA == z.b.NsK)
      {
        paramObject = i.c(this.Nro, new Object[] { (Integer)paramObject });
        AppMethodBeat.o(59476);
        return paramObject;
      }
      AppMethodBeat.o(59476);
      return paramObject;
    }
    
    final Object fq(Object paramObject)
    {
      AppMethodBeat.i(59477);
      if (this.Nrm.Nrh.NsA == z.b.NsK)
      {
        int i = ((j.a)paramObject).getNumber();
        AppMethodBeat.o(59477);
        return Integer.valueOf(i);
      }
      AppMethodBeat.o(59477);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.i
 * JD-Core Version:    0.7.0.1
 */