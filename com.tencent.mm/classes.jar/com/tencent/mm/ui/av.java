package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class av<T>
{
  private Field dEn;
  private String lYr;
  private boolean lYs;
  private String lYt;
  private Object obj;
  
  public av(Object paramObject, String paramString)
  {
    AppMethodBeat.i(159106);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(159106);
      throw paramObject;
    }
    this.obj = paramObject;
    this.lYr = paramString;
    this.lYt = null;
    AppMethodBeat.o(159106);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(159107);
    if (this.lYs)
    {
      AppMethodBeat.o(159107);
      return;
    }
    this.lYs = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.lYr);
        localField1.setAccessible(true);
        this.dEn = localField1;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if ((this.lYt != null) && (!this.lYt.equals("")))
            {
              Field[] arrayOfField = localClass.getDeclaredFields();
              int j = arrayOfField.length;
              i = 0;
              if (i < j)
              {
                Field localField2 = arrayOfField[i];
                if (!localField2.getType().getName().equals(this.lYt)) {
                  continue;
                }
                localField2.setAccessible(true);
                this.dEn = localField2;
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
    if (this.dEn == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(159108);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.dEn.get(this.obj);
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
    if (this.dEn == null)
    {
      paramT = new NoSuchFieldException();
      AppMethodBeat.o(159109);
      throw paramT;
    }
    this.dEn.set(this.obj, paramT);
    AppMethodBeat.o(159109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.av
 * JD-Core Version:    0.7.0.1
 */