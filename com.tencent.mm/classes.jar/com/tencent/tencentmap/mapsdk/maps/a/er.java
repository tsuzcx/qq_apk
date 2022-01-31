package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class er
{
  public static er a()
  {
    try
    {
      Object localObject1 = Class.forName("sun.misc.Unsafe");
      Object localObject4 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject4).setAccessible(true);
      localObject4 = ((Field)localObject4).get(null);
      localObject1 = new er.1(((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class }), localObject4);
      return localObject1;
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject2 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
        ((Method)localObject2).setAccessible(true);
        localObject2 = new er.2((Method)localObject2);
        return localObject2;
      }
      catch (Exception localException2)
      {
        try
        {
          Object localObject3 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
          ((Method)localObject3).setAccessible(true);
          int i = ((Integer)((Method)localObject3).invoke(null, new Object[] { Object.class })).intValue();
          localObject3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
          ((Method)localObject3).setAccessible(true);
          localObject3 = new er.3((Method)localObject3, i);
          return localObject3;
        }
        catch (Exception localException3) {}
      }
    }
    new er()
    {
      public final <T> T a(Class<T> paramAnonymousClass)
      {
        AppMethodBeat.i(147639);
        paramAnonymousClass = new UnsupportedOperationException("Cannot allocate ".concat(String.valueOf(paramAnonymousClass)));
        AppMethodBeat.o(147639);
        throw paramAnonymousClass;
      }
    };
  }
  
  public abstract <T> T a(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.er
 * JD-Core Version:    0.7.0.1
 */