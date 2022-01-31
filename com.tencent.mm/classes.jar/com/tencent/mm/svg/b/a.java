package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<T>
{
  private String classname;
  public Field erN;
  private String fieldName;
  private boolean inited;
  public Object obj;
  
  public a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(70119);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(70119);
      throw paramObject;
    }
    this.obj = paramObject;
    this.fieldName = paramString;
    this.classname = null;
    AppMethodBeat.o(70119);
  }
  
  public final boolean Mb()
  {
    AppMethodBeat.i(70122);
    prepare();
    if (this.erN != null)
    {
      AppMethodBeat.o(70122);
      return true;
    }
    AppMethodBeat.o(70122);
    return false;
  }
  
  public final T get()
  {
    AppMethodBeat.i(70121);
    prepare();
    Object localObject;
    if (this.erN == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(70121);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.erN.get(this.obj);
      AppMethodBeat.o(70121);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(70121);
      throw localIllegalArgumentException;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(70120);
    if (this.inited)
    {
      AppMethodBeat.o(70120);
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
        AppMethodBeat.o(70120);
      }
    }
    AppMethodBeat.o(70120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b.a
 * JD-Core Version:    0.7.0.1
 */