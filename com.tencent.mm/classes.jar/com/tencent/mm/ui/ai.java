package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class ai<T>
{
  private Field bCy;
  private String classname;
  private boolean fJw;
  private String fieldName;
  private Object obj;
  
  public ai(Object paramObject, String paramString)
  {
    AppMethodBeat.i(159106);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(159106);
      throw paramObject;
    }
    this.obj = paramObject;
    this.fieldName = paramString;
    this.classname = null;
    AppMethodBeat.o(159106);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(159107);
    if (this.fJw)
    {
      AppMethodBeat.o(159107);
      return;
    }
    this.fJw = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.fieldName);
        localField1.setAccessible(true);
        this.bCy = localField1;
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
                this.bCy = localField2;
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
    if (this.bCy == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(159108);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.bCy.get(this.obj);
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
    if (this.bCy == null)
    {
      paramT = new NoSuchFieldException();
      AppMethodBeat.o(159109);
      throw paramT;
    }
    this.bCy.set(this.obj, paramT);
    AppMethodBeat.o(159109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ai
 * JD-Core Version:    0.7.0.1
 */