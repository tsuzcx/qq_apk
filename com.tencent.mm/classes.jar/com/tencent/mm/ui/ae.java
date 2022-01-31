package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class ae<T>
{
  private String classname;
  private Field erN;
  private String fieldName;
  private boolean inited;
  private Object obj;
  
  public ae(Object paramObject, String paramString)
  {
    AppMethodBeat.i(112464);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(112464);
      throw paramObject;
    }
    this.obj = paramObject;
    this.fieldName = paramString;
    this.classname = null;
    AppMethodBeat.o(112464);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(112465);
    if (this.inited)
    {
      AppMethodBeat.o(112465);
      return;
    }
    this.inited = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.fieldName);
        localField1.setAccessible(true);
        this.erN = localField1;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if ((this.classname != null) && (!this.classname.equals("")))
            {
              Field[] arrayOfField = localClass.getDeclaredFields();
              int j = arrayOfField.length;
              i = 0;
              if (i < j)
              {
                Field localField2 = arrayOfField[i];
                if (!localField2.getType().getName().equals(this.classname)) {
                  continue;
                }
                localField2.setAccessible(true);
                this.erN = localField2;
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
        AppMethodBeat.o(112465);
      }
    }
    AppMethodBeat.o(112465);
  }
  
  public final T get()
  {
    AppMethodBeat.i(112466);
    prepare();
    Object localObject;
    if (this.erN == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(112466);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.erN.get(this.obj);
      AppMethodBeat.o(112466);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(112466);
      throw localIllegalArgumentException;
    }
  }
  
  public final void set(T paramT)
  {
    AppMethodBeat.i(112467);
    prepare();
    if (this.erN == null)
    {
      paramT = new NoSuchFieldException();
      AppMethodBeat.o(112467);
      throw paramT;
    }
    this.erN.set(this.obj, paramT);
    AppMethodBeat.o(112467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ae
 * JD-Core Version:    0.7.0.1
 */