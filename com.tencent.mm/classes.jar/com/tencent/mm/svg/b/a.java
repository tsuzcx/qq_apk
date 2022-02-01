package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<T>
{
  public Field bCy;
  private String classname;
  private boolean fJw;
  private String fieldName;
  public Object obj;
  
  public a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(148753);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(148753);
      throw paramObject;
    }
    this.obj = paramObject;
    this.fieldName = paramString;
    this.classname = null;
    AppMethodBeat.o(148753);
  }
  
  public final boolean Yw()
  {
    AppMethodBeat.i(148756);
    prepare();
    if (this.bCy != null)
    {
      AppMethodBeat.o(148756);
      return true;
    }
    AppMethodBeat.o(148756);
    return false;
  }
  
  public final T get()
  {
    AppMethodBeat.i(148755);
    prepare();
    Object localObject;
    if (this.bCy == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(148755);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.bCy.get(this.obj);
      AppMethodBeat.o(148755);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(148755);
      throw localIllegalArgumentException;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(148754);
    if (this.fJw)
    {
      AppMethodBeat.o(148754);
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
        AppMethodBeat.o(148754);
      }
    }
    AppMethodBeat.o(148754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b.a
 * JD-Core Version:    0.7.0.1
 */