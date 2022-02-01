package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class i
  extends a
  implements Serializable
{
  protected i() {}
  
  protected i(byte paramByte) {}
  
  public static <ContainingType extends r, Type> i.e<ContainingType, Type> a(ContainingType paramContainingType, Type paramType, r paramr, int paramInt, aa.a parama, Class paramClass)
  {
    return new i.e(paramContainingType, paramType, paramr, new i.d(paramInt, parama, false), paramClass);
  }
  
  public static <ContainingType extends r, Type> i.e<ContainingType, Type> a(ContainingType paramContainingType, r paramr, int paramInt, aa.a parama, Class paramClass)
  {
    return new i.e(paramContainingType, Collections.emptyList(), paramr, new i.d(paramInt, parama, true), paramClass);
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
  
  protected void HZ() {}
  
  protected boolean a(e parame, f paramf, g paramg, int paramInt)
  {
    return parame.a(paramInt, paramf);
  }
  
  public static abstract class a<MessageType extends i, BuilderType extends a>
    extends a.a<BuilderType>
  {
    public d aaZB = d.abgb;
    
    public abstract BuilderType a(MessageType paramMessageType);
    
    public abstract MessageType iIX();
    
    public BuilderType iIY()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends i.a<MessageType, BuilderType>
    implements j<MessageType>
  {
    private h<i.d> abgm = h.iNQ();
    private boolean abgn;
    
    protected final boolean Ig()
    {
      return this.abgm.isInitialized();
    }
    
    protected final void a(MessageType paramMessageType)
    {
      if (!this.abgn)
      {
        this.abgm = this.abgm.iNR();
        this.abgn = true;
      }
      h localh = this.abgm;
      paramMessageType = i.c.b(paramMessageType);
      int i = 0;
      while (i < paramMessageType.abgk.IX())
      {
        localh.c(paramMessageType.abgk.hD(i));
        i += 1;
      }
      paramMessageType = paramMessageType.abgk.IY().iterator();
      while (paramMessageType.hasNext()) {
        localh.c((Map.Entry)paramMessageType.next());
      }
    }
    
    public BuilderType iJK()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements j<MessageType>
  {
    public final h<i.d> abgm;
    
    protected c()
    {
      this.abgm = h.iNP();
    }
    
    protected c(i.b<MessageType, ?> paramb)
    {
      this.abgm = i.b.a(paramb);
    }
    
    protected final void HZ()
    {
      this.abgm.Al();
    }
    
    protected final boolean Ig()
    {
      return this.abgm.isInitialized();
    }
    
    protected final int Ii()
    {
      Object localObject = this.abgm;
      int j = 0;
      int i = 0;
      Map.Entry localEntry;
      while (j < ((h)localObject).abgk.IX())
      {
        localEntry = ((h)localObject).abgk.hD(j);
        i += h.c((h.a)localEntry.getKey(), localEntry.getValue());
        j += 1;
      }
      localObject = ((h)localObject).abgk.IY().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        i += h.c((h.a)localEntry.getKey(), localEntry.getValue());
      }
      return i;
    }
    
    protected final boolean a(e parame, f paramf, g paramg, int paramInt)
    {
      return i.a(this.abgm, iIR(), parame, paramf, paramg, paramInt);
    }
    
    public void b(i.e<MessageType, ?> parame)
    {
      if (parame.abgt != iIR()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> boolean c(i.e<MessageType, Type> parame)
    {
      b(parame);
      return this.abgm.a(parame.abgv);
    }
    
    public final <Type> Type d(i.e<MessageType, Type> parame)
    {
      b(parame);
      Object localObject = this.abgm.b(parame.abgv);
      if (localObject == null) {
        return parame.bUV;
      }
      return parame.fB(localObject);
    }
    
    protected final c<MessageType>.a iNU()
    {
      return new a((byte)0);
    }
    
    public final class a
    {
      private final Iterator<Map.Entry<i.d, Object>> bYp;
      private Map.Entry<i.d, Object> bYq;
      private final boolean bYr;
      
      private a()
      {
        AppMethodBeat.i(59472);
        this$1 = i.c.b(i.c.this);
        if (i.c.this.bWB) {}
        for (this$1 = new m.b(i.c.this.abgk.entrySet().iterator());; this$1 = i.c.this.abgk.entrySet().iterator())
        {
          this.bYp = i.c.this;
          if (this.bYp.hasNext()) {
            this.bYq = ((Map.Entry)this.bYp.next());
          }
          this.bYr = false;
          AppMethodBeat.o(59472);
          return;
        }
      }
      
      public final void b(int paramInt, f paramf)
      {
        AppMethodBeat.i(59473);
        while ((this.bYq != null) && (((i.d)this.bYq.getKey()).number < paramInt))
        {
          i.d locald = (i.d)this.bYq.getKey();
          if ((this.bYr) && (locald.abgq.abhk == aa.b.abhu) && (!locald.abgr)) {
            paramf.b(locald.number, (r)this.bYq.getValue());
          }
          for (;;)
          {
            if (!this.bYp.hasNext()) {
              break label139;
            }
            this.bYq = ((Map.Entry)this.bYp.next());
            break;
            h.a(locald, this.bYq.getValue(), paramf);
          }
          label139:
          this.bYq = null;
        }
        AppMethodBeat.o(59473);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.h.i
 * JD-Core Version:    0.7.0.1
 */