package kotlin.l.b.a.b.h;

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
  
  public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType paramContainingType, Type paramType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new f(paramContainingType, paramType, paramq, new e(paramInt, parama, false), paramClass);
  }
  
  public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType paramContainingType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new f(paramContainingType, Collections.emptyList(), paramq, new e(paramInt, parama, true), paramClass);
  }
  
  static Method b(Class paramClass, String paramString, Class... paramVarArgs)
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
  
  protected void Gw() {}
  
  protected boolean a(e parame, f paramf, g paramg, int paramInt)
  {
    return parame.a(paramInt, paramf);
  }
  
  public s<? extends q> hEs()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public static abstract class b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends i.a<MessageType, BuilderType>
    implements i.d<MessageType>
  {
    protected h<i.e> TDA = h.hJy();
    private boolean TDB;
    
    protected final void a(MessageType paramMessageType)
    {
      if (!this.TDB)
      {
        this.TDA = this.TDA.hJz();
        this.TDB = true;
      }
      h localh = this.TDA;
      paramMessageType = i.c.b(paramMessageType);
      int i = 0;
      while (i < paramMessageType.TDy.Hx())
      {
        localh.b(paramMessageType.TDy.gM(i));
        i += 1;
      }
      paramMessageType = paramMessageType.TDy.Hy().iterator();
      while (paramMessageType.hasNext()) {
        localh.b((Map.Entry)paramMessageType.next());
      }
    }
    
    public BuilderType hFq()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements i.d<MessageType>
  {
    protected final h<i.e> TDA;
    
    protected c()
    {
      this.TDA = h.hJx();
    }
    
    protected c(i.b<MessageType, ?> paramb)
    {
      this.TDA = i.b.a(paramb);
    }
    
    private void b(i.f<MessageType, ?> paramf)
    {
      if (paramf.TDF != hEy()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    protected final void Gw()
    {
      this.TDA.yK();
    }
    
    public final <Type> Type a(i.f<MessageType, List<Type>> paramf, int paramInt)
    {
      b(paramf);
      Object localObject = this.TDA;
      i.e locale = paramf.TDH;
      if (!locale.FJ()) {
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      }
      localObject = ((h)localObject).a(locale);
      if (localObject == null) {
        throw new IndexOutOfBoundsException();
      }
      return paramf.fw(((List)localObject).get(paramInt));
    }
    
    protected final boolean a(e parame, f paramf, g paramg, int paramInt)
    {
      h localh = this.TDA;
      Object localObject = hEy();
      int i = z.gX(paramInt);
      int j = z.gY(paramInt);
      i.f localf = (i.f)paramg.bUk.get(new g.a(localObject, j));
      if (localf != null) {
        if (i == h.a(localf.TDH.TDE, false))
        {
          i = 0;
          j = 0;
        }
      }
      while (j != 0)
      {
        return parame.a(paramInt, paramf);
        if ((localf.TDH.bWf) && (localf.TDH.TDE.FL()) && (i == h.a(localf.TDH.TDE, true)))
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
        paramInt = parame.fH(parame.zi());
        if (localf.TDH.TDE == z.a.TEB) {
          while (parame.zk() > 0)
          {
            i = parame.zi();
            paramf = localf.TDH.TDD.aua(i);
            if (paramf == null) {
              break label273;
            }
            localh.b(localf.TDH, localf.fx(paramf));
          }
        }
        while (parame.zk() > 0)
        {
          paramf = h.a(parame, localf.TDH.TDE);
          localh.b(localf.TDH, paramf);
        }
        parame.fI(paramInt);
      }
      for (;;)
      {
        label273:
        return true;
        switch (i.1.bUF[localf.TDH.TDE.TEG.ordinal()])
        {
        default: 
          parame = h.a(parame, localf.TDH.TDE);
          label329:
          if (!localf.TDH.bWf) {
            break label620;
          }
          localh.b(localf.TDH, localf.fx(parame));
        }
      }
      if (!localf.TDH.bWf)
      {
        paramf = (q)localh.a(localf.TDH);
        if (paramf == null) {}
      }
      for (paramf = paramf.hEw();; paramf = null)
      {
        localObject = paramf;
        if (paramf == null) {
          localObject = localf.TDG.hEx();
        }
        if (localf.TDH.TDE == z.a.TEx)
        {
          paramInt = localf.TDH.number;
          if (parame.bNo >= parame.bNp) {
            throw k.hJJ();
          }
          parame.bNo += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fF(z.bA(paramInt, 4));
          parame.bNo -= 1;
        }
        for (;;)
        {
          parame = ((q.a)localObject).hEG();
          break;
          paramInt = parame.zi();
          if (parame.bNo >= parame.bNp) {
            throw k.hJJ();
          }
          paramInt = parame.fH(paramInt);
          parame.bNo += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fF(0);
          parame.bNo -= 1;
          parame.fI(paramInt);
        }
        i = parame.zi();
        paramg = localf.TDH.TDD.aua(i);
        parame = paramg;
        if (paramg != null) {
          break label329;
        }
        paramf.hc(paramInt);
        paramf.hc(i);
        break;
        label620:
        localh.a(localf.TDH, localf.fx(parame));
        break;
      }
    }
    
    public final <Type> boolean c(i.f<MessageType, Type> paramf)
    {
      b(paramf);
      h localh = this.TDA;
      paramf = paramf.TDH;
      if (paramf.FJ()) {
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      }
      return localh.TDy.get(paramf) != null;
    }
    
    public final <Type> int d(i.f<MessageType, List<Type>> paramf)
    {
      b(paramf);
      h localh = this.TDA;
      paramf = paramf.TDH;
      if (!paramf.FJ()) {
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
      Object localObject2 = this.TDA.a(paramf.TDH);
      if (localObject2 == null) {
        localObject1 = paramf.aEX;
      }
      do
      {
        return localObject1;
        if (!paramf.TDH.bWf) {
          break;
        }
        localObject1 = localObject2;
      } while (paramf.TDH.TDE.TEG != z.b.TEP);
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(paramf.fw(((Iterator)localObject2).next()));
      }
      return localObject1;
      return paramf.fw(localObject2);
    }
    
    protected final c<MessageType>.a hJC()
    {
      return new a((byte)0);
    }
    
    public final class a
    {
      private final Iterator<Map.Entry<i.e, Object>> bWx;
      private Map.Entry<i.e, Object> bWy;
      private final boolean bWz;
      
      private a()
      {
        AppMethodBeat.i(59472);
        this$1 = i.c.b(i.c.this);
        if (i.c.this.bUD) {}
        for (this$1 = new l.b(i.c.this.TDy.entrySet().iterator());; this$1 = i.c.this.TDy.entrySet().iterator())
        {
          this.bWx = i.c.this;
          if (this.bWx.hasNext()) {
            this.bWy = ((Map.Entry)this.bWx.next());
          }
          this.bWz = false;
          AppMethodBeat.o(59472);
          return;
        }
      }
      
      public final void b(int paramInt, f paramf)
      {
        AppMethodBeat.i(59473);
        while ((this.bWy != null) && (((i.e)this.bWy.getKey()).number < paramInt))
        {
          i.e locale = (i.e)this.bWy.getKey();
          if ((this.bWz) && (locale.TDE.TEG == z.b.TEQ) && (!locale.bWf)) {
            paramf.b(locale.number, (q)this.bWy.getValue());
          }
          for (;;)
          {
            if (!this.bWx.hasNext()) {
              break label139;
            }
            this.bWy = ((Map.Entry)this.bWx.next());
            break;
            h.a(locale, this.bWy.getValue(), paramf);
          }
          label139:
          this.bWy = null;
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
    final j.b<?> TDD = null;
    final z.a TDE;
    final boolean bWf;
    final boolean bWg;
    final int number;
    
    e(int paramInt, z.a parama, boolean paramBoolean)
    {
      this.number = paramInt;
      this.TDE = parama;
      this.bWf = paramBoolean;
      this.bWg = false;
    }
    
    public final boolean FJ()
    {
      return this.bWf;
    }
    
    public final boolean FK()
    {
      return this.bWg;
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
    
    public final z.a hJA()
    {
      return this.TDE;
    }
    
    public final z.b hJB()
    {
      return this.TDE.TEG;
    }
  }
  
  public static final class f<ContainingType extends q, Type>
  {
    final ContainingType TDF;
    final q TDG;
    final i.e TDH;
    final Class TDI;
    final Method TDJ;
    final Type aEX;
    
    f(ContainingType paramContainingType, Type paramType, q paramq, i.e parame, Class paramClass)
    {
      AppMethodBeat.i(59475);
      if (paramContainingType == null)
      {
        paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      if ((parame.TDE == z.a.TEy) && (paramq == null))
      {
        paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      this.TDF = paramContainingType;
      this.aEX = paramType;
      this.TDG = paramq;
      this.TDH = parame;
      this.TDI = paramClass;
      if (j.a.class.isAssignableFrom(paramClass))
      {
        this.TDJ = i.b(paramClass, "valueOf", new Class[] { Integer.TYPE });
        AppMethodBeat.o(59475);
        return;
      }
      this.TDJ = null;
      AppMethodBeat.o(59475);
    }
    
    final Object fw(Object paramObject)
    {
      AppMethodBeat.i(59476);
      if (this.TDH.TDE.TEG == z.b.TEP)
      {
        paramObject = i.c(this.TDJ, new Object[] { (Integer)paramObject });
        AppMethodBeat.o(59476);
        return paramObject;
      }
      AppMethodBeat.o(59476);
      return paramObject;
    }
    
    final Object fx(Object paramObject)
    {
      AppMethodBeat.i(59477);
      if (this.TDH.TDE.TEG == z.b.TEP)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.i
 * JD-Core Version:    0.7.0.1
 */