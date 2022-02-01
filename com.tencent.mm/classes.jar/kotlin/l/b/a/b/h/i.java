package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class i
  extends a
  implements Serializable
{
  protected i() {}
  
  protected i(byte paramByte) {}
  
  public static <ContainingType extends r, Type> e<ContainingType, Type> a(ContainingType paramContainingType, Type paramType, r paramr, int paramInt, aa.a parama, Class paramClass)
  {
    return new e(paramContainingType, paramType, paramr, new d(paramInt, parama, false), paramClass);
  }
  
  public static <ContainingType extends r, Type> e<ContainingType, Type> a(ContainingType paramContainingType, r paramr, int paramInt, aa.a parama, Class paramClass)
  {
    return new e(paramContainingType, Collections.emptyList(), paramr, new d(paramInt, parama, true), paramClass);
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
  
  static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs)
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
  
  protected void makeExtensionsImmutable() {}
  
  public static abstract class a<MessageType extends i, BuilderType extends a>
    extends a.a<BuilderType>
  {
    public d aiXZ = d.ajeU;
    
    public abstract BuilderType a(MessageType paramMessageType);
    
    public abstract MessageType ktp();
    
    public BuilderType ktq()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends i.a<MessageType, BuilderType>
    implements j<MessageType>
  {
    private h<i.d> ajfd = h.kyi();
    private boolean ajfe;
    
    protected final void a(MessageType paramMessageType)
    {
      if (!this.ajfe)
      {
        this.ajfd = this.ajfd.kyj();
        this.ajfe = true;
      }
      h localh = this.ajfd;
      paramMessageType = i.c.b(paramMessageType);
      int i = 0;
      while (i < paramMessageType.ajfb.ajq())
      {
        localh.g(paramMessageType.ajfb.lt(i));
        i += 1;
      }
      paramMessageType = paramMessageType.ajfb.ajr().iterator();
      while (paramMessageType.hasNext()) {
        localh.g((Map.Entry)paramMessageType.next());
      }
    }
    
    protected final boolean aic()
    {
      return this.ajfd.isInitialized();
    }
    
    public BuilderType kuf()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements j<MessageType>
  {
    private final h<i.d> ajfd;
    
    protected c()
    {
      this.ajfd = h.kyh();
    }
    
    protected c(i.b<MessageType, ?> paramb)
    {
      this.ajfd = i.b.a(paramb);
    }
    
    private void b(i.e<MessageType, ?> parame)
    {
      if (parame.ajfk != ktj()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> Type a(i.e<MessageType, List<Type>> parame, int paramInt)
    {
      b(parame);
      return parame.ic(this.ajfd.a(parame.ajfm, paramInt));
    }
    
    protected final boolean a(e parame, f paramf, g paramg, int paramInt)
    {
      return i.a(this.ajfd, ktj(), parame, paramf, paramg, paramInt);
    }
    
    protected final boolean aic()
    {
      return this.ajfd.isInitialized();
    }
    
    protected final int aie()
    {
      Object localObject = this.ajfd;
      int j = 0;
      int i = 0;
      Map.Entry localEntry;
      while (j < ((h)localObject).ajfb.ajq())
      {
        localEntry = ((h)localObject).ajfb.lt(j);
        i += h.c((h.a)localEntry.getKey(), localEntry.getValue());
        j += 1;
      }
      localObject = ((h)localObject).ajfb.ajr().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        i += h.c((h.a)localEntry.getKey(), localEntry.getValue());
      }
      return i;
    }
    
    public final <Type> boolean c(i.e<MessageType, Type> parame)
    {
      b(parame);
      return this.ajfd.a(parame.ajfm);
    }
    
    public final <Type> int d(i.e<MessageType, List<Type>> parame)
    {
      b(parame);
      return this.ajfd.c(parame.ajfm);
    }
    
    public final <Type> Type e(i.e<MessageType, Type> parame)
    {
      b(parame);
      Object localObject = this.ajfd.b(parame.ajfm);
      if (localObject == null) {
        return parame.dOI;
      }
      return parame.ib(localObject);
    }
    
    protected final c<MessageType>.a kym()
    {
      return new a((byte)0);
    }
    
    protected final void makeExtensionsImmutable()
    {
      this.ajfd.ZP();
    }
    
    public final class a
    {
      private Map.Entry<i.d, Object> ats;
      private final Iterator<Map.Entry<i.d, Object>> dRZ;
      private final boolean dSa;
      
      private a()
      {
        AppMethodBeat.i(59472);
        this$1 = i.c.b(i.c.this);
        if (i.c.this.dQo) {}
        for (this$1 = new m.b(i.c.this.ajfb.entrySet().iterator());; this$1 = i.c.this.ajfb.entrySet().iterator())
        {
          this.dRZ = i.c.this;
          if (this.dRZ.hasNext()) {
            this.ats = ((Map.Entry)this.dRZ.next());
          }
          this.dSa = false;
          AppMethodBeat.o(59472);
          return;
        }
      }
      
      public final void b(int paramInt, f paramf)
      {
        AppMethodBeat.i(59473);
        while ((this.ats != null) && (((i.d)this.ats.getKey()).number < paramInt))
        {
          i.d locald = (i.d)this.ats.getKey();
          if ((this.dSa) && (locald.ajfh.ajfX == aa.b.ajgh) && (!locald.ajfi)) {
            paramf.b(locald.number, (r)this.ats.getValue());
          }
          for (;;)
          {
            if (!this.dRZ.hasNext()) {
              break label139;
            }
            this.ats = ((Map.Entry)this.dRZ.next());
            break;
            h.a(locald, this.ats.getValue(), paramf);
          }
          label139:
          this.ats = null;
        }
        AppMethodBeat.o(59473);
      }
    }
  }
  
  static final class d
    implements h.a<d>
  {
    final k.b<?> ajfg = null;
    final aa.a ajfh;
    final boolean ajfi;
    final boolean ajfj;
    final int number;
    
    d(int paramInt, aa.a parama, boolean paramBoolean)
    {
      this.number = paramInt;
      this.ajfh = parama;
      this.ajfi = paramBoolean;
      this.ajfj = false;
    }
    
    public final r.a a(r.a parama, r paramr)
    {
      AppMethodBeat.i(59474);
      parama = ((i.a)parama).a((i)paramr);
      AppMethodBeat.o(59474);
      return parama;
    }
    
    public final boolean ahl()
    {
      return this.ajfi;
    }
    
    public final boolean ahm()
    {
      return this.ajfj;
    }
    
    public final int getNumber()
    {
      return this.number;
    }
    
    public final aa.a kyk()
    {
      return this.ajfh;
    }
    
    public final aa.b kyl()
    {
      return this.ajfh.ajfX;
    }
  }
  
  public static final class e<ContainingType extends r, Type>
  {
    final ContainingType ajfk;
    final r ajfl;
    final i.d ajfm;
    final Class ajfn;
    final Method ajfo;
    final Type dOI;
    
    e(ContainingType paramContainingType, Type paramType, r paramr, i.d paramd, Class paramClass)
    {
      AppMethodBeat.i(59475);
      if (paramContainingType == null)
      {
        paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      if ((paramd.ajfh == aa.a.ajfP) && (paramr == null))
      {
        paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      this.ajfk = paramContainingType;
      this.dOI = paramType;
      this.ajfl = paramr;
      this.ajfm = paramd;
      this.ajfn = paramClass;
      if (k.a.class.isAssignableFrom(paramClass))
      {
        this.ajfo = i.getMethodOrDie(paramClass, "valueOf", new Class[] { Integer.TYPE });
        AppMethodBeat.o(59475);
        return;
      }
      this.ajfo = null;
      AppMethodBeat.o(59475);
    }
    
    final Object ib(Object paramObject)
    {
      AppMethodBeat.i(191744);
      if (this.ajfm.ajfi)
      {
        if (this.ajfm.ajfh.ajfX == aa.b.ajgg)
        {
          ArrayList localArrayList = new ArrayList();
          paramObject = ((List)paramObject).iterator();
          while (paramObject.hasNext()) {
            localArrayList.add(ic(paramObject.next()));
          }
          AppMethodBeat.o(191744);
          return localArrayList;
        }
        AppMethodBeat.o(191744);
        return paramObject;
      }
      paramObject = ic(paramObject);
      AppMethodBeat.o(191744);
      return paramObject;
    }
    
    final Object ic(Object paramObject)
    {
      AppMethodBeat.i(59476);
      if (this.ajfm.ajfh.ajfX == aa.b.ajgg)
      {
        paramObject = i.c(this.ajfo, new Object[] { (Integer)paramObject });
        AppMethodBeat.o(59476);
        return paramObject;
      }
      AppMethodBeat.o(59476);
      return paramObject;
    }
    
    final Object id(Object paramObject)
    {
      AppMethodBeat.i(59477);
      if (this.ajfm.ajfh.ajfX == aa.b.ajgg)
      {
        int i = ((k.a)paramObject).getNumber();
        AppMethodBeat.o(59477);
        return Integer.valueOf(i);
      }
      AppMethodBeat.o(59477);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.i
 * JD-Core Version:    0.7.0.1
 */