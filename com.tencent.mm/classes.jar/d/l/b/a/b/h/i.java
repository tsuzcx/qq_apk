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
  
  public s<? extends q> fCl()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected void fHL() {}
  
  public static abstract class a<MessageType extends i, BuilderType extends a>
    extends a.a<BuilderType>
  {
    public d JFI = d.JMs;
    
    public abstract BuilderType a(MessageType paramMessageType);
    
    public abstract MessageType fCw();
    
    public BuilderType fCx()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends i.a<MessageType, BuilderType>
    implements i.d<MessageType>
  {
    protected h<i.e> JMK = h.fHE();
    private boolean JML;
    
    protected final void a(MessageType paramMessageType)
    {
      if (!this.JML)
      {
        this.JMK = this.JMK.fHG();
        this.JML = true;
      }
      h localh = this.JMK;
      paramMessageType = i.c.b(paramMessageType);
      int i = 0;
      while (i < paramMessageType.JME.fIc())
      {
        localh.f(paramMessageType.JME.afM(i));
        i += 1;
      }
      paramMessageType = paramMessageType.JME.fId().iterator();
      while (paramMessageType.hasNext()) {
        localh.f((Map.Entry)paramMessageType.next());
      }
    }
    
    public BuilderType fDm()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements i.d<MessageType>
  {
    protected final h<i.e> JMK;
    
    protected c()
    {
      this.JMK = h.fHD();
    }
    
    protected c(i.b<MessageType, ?> paramb)
    {
      this.JMK = i.b.a(paramb);
    }
    
    private void b(i.f<MessageType, ?> paramf)
    {
      if (paramf.JMU != fCr()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> Type a(i.f<MessageType, List<Type>> paramf, int paramInt)
    {
      b(paramf);
      Object localObject = this.JMK;
      i.e locale = paramf.JMW;
      if (!locale.fHJ()) {
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      }
      localObject = ((h)localObject).a(locale);
      if (localObject == null) {
        throw new IndexOutOfBoundsException();
      }
      return paramf.fk(((List)localObject).get(paramInt));
    }
    
    protected final boolean a(e parame, f paramf, g paramg, int paramInt)
    {
      h localh = this.JMK;
      Object localObject = fCr();
      int i = z.gb(paramInt);
      int j = z.gc(paramInt);
      i.f localf = (i.f)paramg.JMC.get(new g.a(localObject, j));
      if (localf != null) {
        if (i == h.a(localf.JMW.JMR, false))
        {
          i = 0;
          j = 0;
        }
      }
      while (j != 0)
      {
        return parame.a(paramInt, paramf);
        if ((localf.JMW.JMS) && (localf.JMW.JMR.fIk()) && (i == h.a(localf.JMW.JMR, true)))
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
        paramInt = parame.fR(parame.xS());
        if (localf.JMW.JMR == z.a.JOf) {
          while (parame.xV() > 0)
          {
            i = parame.xS();
            paramf = localf.JMW.JMQ.aed(i);
            if (paramf == null) {
              break label273;
            }
            localh.b(localf.JMW, localf.fl(paramf));
          }
        }
        while (parame.xV() > 0)
        {
          paramf = h.a(parame, localf.JMW.JMR);
          localh.b(localf.JMW, paramf);
        }
        parame.fS(paramInt);
      }
      for (;;)
      {
        label273:
        return true;
        switch (i.1.JMI[localf.JMW.JMR.JOk.ordinal()])
        {
        default: 
          parame = h.a(parame, localf.JMW.JMR);
          label329:
          if (!localf.JMW.JMS) {
            break label620;
          }
          localh.b(localf.JMW, localf.fl(parame));
        }
      }
      if (!localf.JMW.JMS)
      {
        paramf = (q)localh.a(localf.JMW);
        if (paramf == null) {}
      }
      for (paramf = paramf.fCp();; paramf = null)
      {
        localObject = paramf;
        if (paramf == null) {
          localObject = localf.JMV.fCq();
        }
        if (localf.JMW.JMR == z.a.JOb)
        {
          paramInt = localf.JMW.number;
          if (parame.bIO >= parame.bIP) {
            throw k.fHT();
          }
          parame.bIO += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fP(z.bD(paramInt, 4));
          parame.bIO -= 1;
        }
        for (;;)
        {
          parame = ((q.a)localObject).fCz();
          break;
          paramInt = parame.xS();
          if (parame.bIO >= parame.bIP) {
            throw k.fHT();
          }
          paramInt = parame.fR(paramInt);
          parame.bIO += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.fP(0);
          parame.bIO -= 1;
          parame.fS(paramInt);
        }
        i = parame.xS();
        paramg = localf.JMW.JMQ.aed(i);
        parame = paramg;
        if (paramg != null) {
          break label329;
        }
        paramf.fZ(paramInt);
        paramf.fZ(i);
        break;
        label620:
        localh.a(localf.JMW, localf.fl(parame));
        break;
      }
    }
    
    public final <Type> boolean c(i.f<MessageType, Type> paramf)
    {
      b(paramf);
      h localh = this.JMK;
      paramf = paramf.JMW;
      if (paramf.fHJ()) {
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      }
      return localh.JME.get(paramf) != null;
    }
    
    public final <Type> int d(i.f<MessageType, List<Type>> paramf)
    {
      b(paramf);
      h localh = this.JMK;
      paramf = paramf.JMW;
      if (!paramf.fHJ()) {
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
      Object localObject2 = this.JMK.a(paramf.JMW);
      if (localObject2 == null) {
        localObject1 = paramf.aCy;
      }
      do
      {
        return localObject1;
        if (!paramf.JMW.JMS) {
          break;
        }
        localObject1 = localObject2;
      } while (paramf.JMW.JMR.JOk != z.b.JOu);
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(paramf.fk(((Iterator)localObject2).next()));
      }
      return localObject1;
      return paramf.fk(localObject2);
    }
    
    protected final void fHL()
    {
      this.JMK.fHF();
    }
    
    protected final c<MessageType>.a fHM()
    {
      return new a((byte)0);
    }
    
    public final class a
    {
      private final Iterator<Map.Entry<i.e, Object>> JMM;
      private Map.Entry<i.e, Object> JMN;
      private final boolean JMO;
      
      private a()
      {
        AppMethodBeat.i(59472);
        this$1 = i.c.b(i.c.this);
        if (i.c.this.JMG) {}
        for (this$1 = new l.b(i.c.this.JME.entrySet().iterator());; this$1 = i.c.this.JME.entrySet().iterator())
        {
          this.JMM = i.c.this;
          if (this.JMM.hasNext()) {
            this.JMN = ((Map.Entry)this.JMM.next());
          }
          this.JMO = false;
          AppMethodBeat.o(59472);
          return;
        }
      }
      
      public final void b(int paramInt, f paramf)
      {
        AppMethodBeat.i(59473);
        while ((this.JMN != null) && (((i.e)this.JMN.getKey()).number < paramInt))
        {
          i.e locale = (i.e)this.JMN.getKey();
          if ((this.JMO) && (locale.JMR.JOk == z.b.JOv) && (!locale.JMS)) {
            paramf.b(locale.number, (q)this.JMN.getValue());
          }
          for (;;)
          {
            if (!this.JMM.hasNext()) {
              break label139;
            }
            this.JMN = ((Map.Entry)this.JMM.next());
            break;
            h.a(locale, this.JMN.getValue(), paramf);
          }
          label139:
          this.JMN = null;
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
    final j.b<?> JMQ = null;
    final z.a JMR;
    final boolean JMS;
    final boolean JMT;
    final int number;
    
    e(int paramInt, z.a parama, boolean paramBoolean)
    {
      this.number = paramInt;
      this.JMR = parama;
      this.JMS = paramBoolean;
      this.JMT = false;
    }
    
    public final q.a a(q.a parama, q paramq)
    {
      AppMethodBeat.i(59474);
      parama = ((i.a)parama).a((i)paramq);
      AppMethodBeat.o(59474);
      return parama;
    }
    
    public final z.a fHH()
    {
      return this.JMR;
    }
    
    public final z.b fHI()
    {
      return this.JMR.JOk;
    }
    
    public final boolean fHJ()
    {
      return this.JMS;
    }
    
    public final boolean fHK()
    {
      return this.JMT;
    }
    
    public final int getNumber()
    {
      return this.number;
    }
  }
  
  public static final class f<ContainingType extends q, Type>
  {
    final ContainingType JMU;
    final q JMV;
    final i.e JMW;
    final Class JMX;
    final Method JMY;
    final Type aCy;
    
    f(ContainingType paramContainingType, Type paramType, q paramq, i.e parame, Class paramClass)
    {
      AppMethodBeat.i(59475);
      if (paramContainingType == null)
      {
        paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      if ((parame.JMR == z.a.JOc) && (paramq == null))
      {
        paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      this.JMU = paramContainingType;
      this.aCy = paramType;
      this.JMV = paramq;
      this.JMW = parame;
      this.JMX = paramClass;
      if (j.a.class.isAssignableFrom(paramClass))
      {
        this.JMY = i.d(paramClass, "valueOf", new Class[] { Integer.TYPE });
        AppMethodBeat.o(59475);
        return;
      }
      this.JMY = null;
      AppMethodBeat.o(59475);
    }
    
    final Object fk(Object paramObject)
    {
      AppMethodBeat.i(59476);
      if (this.JMW.JMR.JOk == z.b.JOu)
      {
        paramObject = i.c(this.JMY, new Object[] { (Integer)paramObject });
        AppMethodBeat.o(59476);
        return paramObject;
      }
      AppMethodBeat.o(59476);
      return paramObject;
    }
    
    final Object fl(Object paramObject)
    {
      AppMethodBeat.i(59477);
      if (this.JMW.JMR.JOk == z.b.JOu)
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