package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

final class c
{
  final WeakReference<Object> Xc = new WeakReference(new Object());
  WeakReference<Activity> Xd;
  Class<?> Xe;
  Field Xf;
  Throwable Xg;
  int Xh;
  
  c(Activity paramActivity, Field paramField, Throwable paramThrowable)
  {
    this.Xd = new WeakReference(paramActivity);
    this.Xe = paramActivity.getClass();
    this.Xf = paramField;
    this.Xg = paramThrowable;
    this.Xh = 0;
  }
  
  private String ll()
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      q.b(localPrintWriter);
    }
    finally
    {
      try
      {
        this.Xg.printStackTrace(localPrintWriter);
        q.b(localPrintWriter);
        return localStringWriter.toString();
      }
      finally {}
      localObject1 = finally;
      localPrintWriter = null;
    }
    throw localObject1;
  }
  
  private String lm()
  {
    if (this.Xf == null) {
      return "#null#";
    }
    Object localObject = this.Xf.getDeclaringClass();
    if (!((Class)localObject).isAnonymousClass()) {
      return "field " + this.Xf.getName() + " defined in " + ((Class)localObject).getName();
    }
    Type localType = ((Class)localObject).getGenericSuperclass();
    if (Object.class.equals(localType)) {
      localObject = localObject.getGenericInterfaces()[0];
    }
    for (;;)
    {
      return "field " + this.Xf.getName() + " define in anonymous class of " + localObject.toString().replace('<', '#').replace('>', '#');
      if (localType != null) {
        localObject = localType;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject == null) || (!(paramObject instanceof c))) {
      return false;
    }
    paramObject = (c)paramObject;
    Object localObject1 = this.Xd.get();
    Object localObject2 = paramObject.Xd.get();
    boolean bool1;
    if ((localObject1 == null) && (localObject2 == null))
    {
      bool1 = true;
      label50:
      if (!bool1) {
        break label130;
      }
      localObject1 = this.Xf;
      localObject2 = paramObject.Xf;
      if ((localObject1 != null) || (localObject2 != null)) {
        break label132;
      }
      bool1 = true;
      label78:
      if (!bool1) {
        break label156;
      }
      localObject1 = this.Xg;
      paramObject = paramObject.Xg;
      if ((localObject1 != null) || (paramObject != null)) {
        break label158;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((localObject1 != null) && (localObject2 != null))
      {
        bool1 = localObject1.equals(localObject2);
        break label50;
      }
      bool1 = false;
      break label50;
      label130:
      break;
      label132:
      if ((localObject1 != null) && (localObject2 != null))
      {
        bool1 = ((Field)localObject1).equals(localObject2);
        break label78;
      }
      bool1 = false;
      break label78;
      label156:
      break;
      label158:
      if ((localObject1 != null) && (paramObject != null)) {
        bool1 = localObject1.equals(paramObject);
      } else {
        bool1 = false;
      }
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    Object localObject = this.Xd.get();
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      if (this.Xf == null) {
        break label63;
      }
    }
    label63:
    for (int j = this.Xf.hashCode();; j = 0)
    {
      if (this.Xg != null) {
        k = this.Xg.hashCode();
      }
      return i + j + k;
      i = 0;
      break;
    }
  }
  
  public final String lk()
  {
    if (this.Xd.get() == null)
    {
      if (this.Xf != null) {
        return "ui of class [" + this.Xe.getName() + "] held by\n [" + lm() + "] is recycled";
      }
      return "ui of class [" + this.Xe.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
    }
    if (this.Xf != null) {
      return "ui of class [" + this.Xe.getName() + "] held by\n [" + lm() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
    }
    return "ui of class [" + this.Xe.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
  }
  
  public final String toString()
  {
    return lm() + "@" + ll().replace('\n', '|');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.c
 * JD-Core Version:    0.7.0.1
 */