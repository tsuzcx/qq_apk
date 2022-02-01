package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class aq<T>
{
  private Field bKF;
  private String jva;
  private boolean jvb;
  private String jvc;
  private Object obj;
  
  public aq(Object paramObject, String paramString)
  {
    AppMethodBeat.i(159106);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(159106);
      throw paramObject;
    }
    this.obj = paramObject;
    this.jva = paramString;
    this.jvc = null;
    AppMethodBeat.o(159106);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(159107);
    if (this.jvb)
    {
      AppMethodBeat.o(159107);
      return;
    }
    this.jvb = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.jva);
        localField1.setAccessible(true);
        this.bKF = localField1;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if ((this.jvc != null) && (!this.jvc.equals("")))
            {
              Field[] arrayOfField = localClass.getDeclaredFields();
              int j = arrayOfField.length;
              i = 0;
              if (i < j)
              {
                Field localField2 = arrayOfField[i];
                if (!localField2.getType().getName().equals(this.jvc)) {
                  continue;
                }
                localField2.setAccessible(true);
                this.bKF = localField2;
              }
            }
          }
          catch (Exception localException2)
          {
            int i;
            continue;
          }
          localClass = localClass.getSuperclass();
          break;
          i += 1;
        }
      }
      finally
      {
        localClass.getSuperclass();
        AppMethodBeat.o(159107);
      }
    }
    AppMethodBeat.o(159107);
  }
  
  public final T get()
  {
    AppMethodBeat.i(159108);
    prepare();
    Object localObject;
    if (this.bKF == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(159108);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.bKF.get(this.obj);
      AppMethodBeat.o(159108);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(159108);
      throw localIllegalArgumentException;
    }
  }
  
  public final void set(T paramT)
  {
    AppMethodBeat.i(159109);
    prepare();
    if (this.bKF == null)
    {
      paramT = new NoSuchFieldException();
      AppMethodBeat.o(159109);
      throw paramT;
    }
    this.bKF.set(this.obj, paramT);
    AppMethodBeat.o(159109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.aq
 * JD-Core Version:    0.7.0.1
 */