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
  
  public s<? extends q> fUP()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected void gao() {}
  
  public static abstract class a<MessageType extends i, BuilderType extends a>
    extends a.a<BuilderType>
  {
    public d Ltb = d.LzL;
    
    public abstract BuilderType a(MessageType paramMessageType);
    
    public abstract MessageType fVa();
    
    public BuilderType fVb()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends i.a<MessageType, BuilderType>
    implements i.d<MessageType>
  {
    protected h<i.e> LAd = h.gah();
    private boolean LAe;
    
    protected final void a(MessageType paramMessageType)
    {
      if (!this.LAe)
      {
        this.LAd = this.LAd.gaj();
        this.LAe = true;
      }
      h localh = this.LAd;
      paramMessageType = i.c.b(paramMessageType);
      int i = 0;
      while (i < paramMessageType.LzX.gaF())
      {
        localh.f(paramMessageType.LzX.aiI(i));
        i += 1;
      }
      paramMessageType = paramMessageType.LzX.gaG().iterator();
      while (paramMessageType.hasNext()) {
        localh.f((Map.Entry)paramMessageType.next());
      }
    }
    
    public BuilderType fVQ()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements i.d<MessageType>
  {
    protected final h<i.e> LAd;
    
    protected c()
    {
      this.LAd = h.gag();
    }
    
    protected c(i.b<MessageType, ?> paramb)
    {
      this.LAd = i.b.a(paramb);
    }
    
    private void b(i.f<MessageType, ?> paramf)
    {
      if (paramf.LAn != fUV()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> Type a(i.f<MessageType, List<Type>> paramf, int paramInt)
    {
      b(paramf);
      Object localObject = this.LAd;
      i.e locale = paramf.LAp;
      if (!locale.gam()) {
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      }
      localObject = ((h)localObject).a(locale);
      if (localObject == null) {
        throw new IndexOutOfBoundsException();
      }
      return paramf.fn(((List)localObject).get(paramInt));
    }
    
    protected final boolean a(e parame, f paramf, g paramg, int paramInt)
    {
      h localh = this.LAd;
      Object localObject = fUV();
      int i = z.fN(paramInt);
      int j = z.fO(paramInt);
      i.f localf = (i.f)paramg.LzV.get(new g.a(localObject, j));
      if (localf != null) {
        if (i == h.a(localf.LAp.LAk, false))
        {
          i = 0;
          j = 0;
        }
      }
      while (j != 0)
      {
        return parame.a(paramInt, paramf);
        if ((localf.LAp.LAl) && (localf.LAp.LAk.gaN()) && (i == h.a(localf.LAp.LAk, true)))
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
        paramInt = parame.fD(parame.xF());
        if (localf.LAp.LAk == z.a.LBz) {
          while (parame.xI() > 0)
          {
            i = parame.xF();
            paramf = localf.LAp.LAj.agZ(i);
            if (paramf == null) {
              break label273;
            }
            localh.b(localf.LAp, localf.fo(paramf));
          }
        }
        while (parame.xI() > 0)
        {
          paramf = h.a(parame, localf.LAp.LAk);
          localh.b(localf.LAp, paramf);
        }
        parame.fE(paramInt);
      }
      for (;;)
      {
        label273:
        return true;
        switch (i.1.LAb[localf.LAp.LAk.LBE.ordinal()])
        {
        default: 
          parame = h.a(parame, localf.LAp.LAk);
          label329:
          if (!localf.LAp.LAl) {
            break label620;
          }
          localh.b(localf.LAp, localf.fo(parame));
        }
      }
      if (!localf.LAp.LAl)
      {
        paramf = (q)localh.a(localf.LAp);
        if (paramf == null) {}
      }
      for (paramf = paramf.fUT();; paramf = null)
      {
        localObject = paramf;
        if (paramf == null) {
          localObject = localf.LAo.fUU();
        }
        if (localf.LAp.LAk == z.a.LBv)
        {
          paramInt = localf.LAp.number;
          if (parame.bGw >= parame.bGx) {
            throw k.gaw();
          }
          parame.bGw += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fB(z.bA(paramInt, 4));
          parame.bGw -= 1;
        }
        for (;;)
        {
          parame = ((q.a)localObject).fVd();
          break;
          paramInt = parame.xF();
          if (parame.bGw >= parame.bGx) {
            throw k.gaw();
          }
          paramInt = parame.fD(paramInt);
          parame.bGw += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fB(0);
          parame.bGw -= 1;
          parame.fE(paramInt);
        }
        i = parame.xF();
        paramg = localf.LAp.LAj.agZ(i);
        parame = paramg;
        if (paramg != null) {
          break label329;
        }
        paramf.fL(paramInt);
        paramf.fL(i);
        break;
        label620:
        localh.a(localf.LAp, localf.fo(parame));
        break;
      }
    }
    
    public final <Type> boolean c(i.f<MessageType, Type> paramf)
    {
      b(paramf);
      h localh = this.LAd;
      paramf = paramf.LAp;
      if (paramf.gam()) {
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      }
      return localh.LzX.get(paramf) != null;
    }
    
    public final <Type> int d(i.f<MessageType, List<Type>> paramf)
    {
      b(paramf);
      h localh = this.LAd;
      paramf = paramf.LAp;
      if (!paramf.gam()) {
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
      Object localObject2 = this.LAd.a(paramf.LAp);
      if (localObject2 == null) {
        localObject1 = paramf.aDq;
      }
      do
      {
        return localObject1;
        if (!paramf.LAp.LAl) {
          break;
        }
        localObject1 = localObject2;
      } while (paramf.LAp.LAk.LBE != z.b.LBO);
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(paramf.fn(((Iterator)localObject2).next()));
      }
      return localObject1;
      return paramf.fn(localObject2);
    }
    
    protected final void gao()
    {
      this.LAd.gai();
    }
    
    protected final c<MessageType>.a gap()
    {
      return new a((byte)0);
    }
    
    public final class a
    {
      private final Iterator<Map.Entry<i.e, Object>> LAf;
      private Map.Entry<i.e, Object> LAg;
      private final boolean LAh;
      
      private a()
      {
        AppMethodBeat.i(59472);
        this$1 = i.c.b(i.c.this);
        if (i.c.this.LzZ) {}
        for (this$1 = new l.b(i.c.this.LzX.entrySet().iterator());; this$1 = i.c.this.LzX.entrySet().iterator())
        {
          this.LAf = i.c.this;
          if (this.LAf.hasNext()) {
            this.LAg = ((Map.Entry)this.LAf.next());
          }
          this.LAh = false;
          AppMethodBeat.o(59472);
          return;
        }
      }
      
      public final void b(int paramInt, f paramf)
      {
        AppMethodBeat.i(59473);
        while ((this.LAg != null) && (((i.e)this.LAg.getKey()).number < paramInt))
        {
          i.e locale = (i.e)this.LAg.getKey();
          if ((this.LAh) && (locale.LAk.LBE == z.b.LBP) && (!locale.LAl)) {
            paramf.b(locale.number, (q)this.LAg.getValue());
          }
          for (;;)
          {
            if (!this.LAf.hasNext()) {
              break label139;
            }
            this.LAg = ((Map.Entry)this.LAf.next());
            break;
            h.a(locale, this.LAg.getValue(), paramf);
          }
          label139:
          this.LAg = null;
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
    final j.b<?> LAj = null;
    final z.a LAk;
    final boolean LAl;
    final boolean LAm;
    final int number;
    
    e(int paramInt, z.a parama, boolean paramBoolean)
    {
      this.number = paramInt;
      this.LAk = parama;
      this.LAl = paramBoolean;
      this.LAm = false;
    }
    
    public final q.a a(q.a parama, q paramq)
    {
      AppMethodBeat.i(59474);
      parama = ((i.a)parama).a((i)paramq);
      AppMethodBeat.o(59474);
      return parama;
    }
    
    public final z.a gak()
    {
      return this.LAk;
    }
    
    public final z.b gal()
    {
      return this.LAk.LBE;
    }
    
    public final boolean gam()
    {
      return this.LAl;
    }
    
    public final boolean gan()
    {
      return this.LAm;
    }
    
    public final int getNumber()
    {
      return this.number;
    }
  }
  
  public static final class f<ContainingType extends q, Type>
  {
    final ContainingType LAn;
    final q LAo;
    final i.e LAp;
    final Class LAq;
    final Method LAr;
    final Type aDq;
    
    f(ContainingType paramContainingType, Type paramType, q paramq, i.e parame, Class paramClass)
    {
      AppMethodBeat.i(59475);
      if (paramContainingType == null)
      {
        paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      if ((parame.LAk == z.a.LBw) && (paramq == null))
      {
        paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      this.LAn = paramContainingType;
      this.aDq = paramType;
      this.LAo = paramq;
      this.LAp = parame;
      this.LAq = paramClass;
      if (j.a.class.isAssignableFrom(paramClass))
      {
        this.LAr = i.d(paramClass, "valueOf", new Class[] { Integer.TYPE });
        AppMethodBeat.o(59475);
        return;
      }
      this.LAr = null;
      AppMethodBeat.o(59475);
    }
    
    final Object fn(Object paramObject)
    {
      AppMethodBeat.i(59476);
      if (this.LAp.LAk.LBE == z.b.LBO)
      {
        paramObject = i.c(this.LAr, new Object[] { (Integer)paramObject });
        AppMethodBeat.o(59476);
        return paramObject;
      }
      AppMethodBeat.o(59476);
      return paramObject;
    }
    
    final Object fo(Object paramObject)
    {
      AppMethodBeat.i(59477);
      if (this.LAp.LAk.LBE == z.b.LBO)
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