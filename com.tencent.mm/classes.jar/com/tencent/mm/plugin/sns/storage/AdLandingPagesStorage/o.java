package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public final class o
{
  public a QXr;
  private String TAG;
  
  public o(String paramString)
  {
    AppMethodBeat.i(306769);
    this.TAG = "AdPreloadAnnoProcessor";
    this.TAG = (this.TAG + "." + paramString);
    AppMethodBeat.o(306769);
  }
  
  public final void gs(Object paramObject)
  {
    AppMethodBeat.i(306773);
    o(paramObject, "");
    AppMethodBeat.o(306773);
  }
  
  public final void o(Object paramObject, String paramString)
  {
    AppMethodBeat.i(306780);
    if (paramObject == null)
    {
      Log.e(this.TAG, "checkPreloadRes, infoObj==null, objDesc=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(306780);
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = paramString;
      if ((paramObject instanceof aa)) {
        localObject1 = String.valueOf(((aa)paramObject).QKH);
      }
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramObject.getClass().getSimpleName();
    }
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    int j;
    int i;
    if ((arrayOfField != null) && (arrayOfField.length > 0))
    {
      j = arrayOfField.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject3 = arrayOfField[i];
        if (((Field)localObject3).isAnnotationPresent(p.class))
        {
          paramString = (p)((Field)localObject3).getAnnotation(p.class);
          String str2 = ((Field)localObject3).getName();
          int k = paramString.hkF();
          int m = paramString.hkG();
          String str1 = "";
          if (k == 7) {
            localObject1 = str1;
          }
          try
          {
            ((Field)localObject3).setAccessible(true);
            localObject1 = str1;
            localObject3 = ((Field)localObject3).get(paramObject);
            localObject1 = localObject3;
            paramString = str1;
            if (localObject3 != null) {
              break label287;
            }
          }
          finally
          {
            for (;;)
            {
              boolean bool;
              label287:
              Log.e(this.TAG, "checkPreloadRes, get resValue exp=" + paramString.toString());
              paramString = (String)localObject1;
            }
            if (TextUtils.isEmpty(paramString)) {
              break label521;
            }
          }
          paramString = str1;
          localObject1 = str1;
          if (((Field)localObject3).getType().getName().equals(String.class.getName()))
          {
            localObject1 = str1;
            ((Field)localObject3).setAccessible(true);
            localObject1 = str1;
            paramString = (String)((Field)localObject3).get(paramObject);
          }
          localObject1 = paramString;
          bool = TextUtils.isEmpty(paramString);
          if (!bool)
          {
            localObject1 = null;
            str1 = (String)localObject2 + "_" + str2;
            Log.i(this.TAG, "checkPreloadRes, resType=" + k + ", desc=" + str1 + ", urlStr=" + paramString);
            if ((k == 7) && (localObject1 != null))
            {
              o(localObject1, str1);
            }
            else if (this.QXr != null)
            {
              localObject1 = new b();
              ((b)localObject1).hCh = k;
              ((b)localObject1).url = paramString;
              ((b)localObject1).desc = str1;
              ((b)localObject1).priority = m;
              ((b)localObject1).QXU = paramObject;
              this.QXr.a((b)localObject1);
            }
          }
        }
      }
      else
      {
        long l2 = System.currentTimeMillis();
        Log.d(this.TAG, "checkPreloadRes, cost=" + (l2 - l1));
        AppMethodBeat.o(306780);
        return;
      }
      label521:
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(o.b paramb);
  }
  
  public static final class b
  {
    public Object QXU;
    public String desc;
    public int hCh;
    public int priority;
    public String url;
    
    public final String toString()
    {
      AppMethodBeat.i(306709);
      String str = "ResItem{resType=" + this.hCh + ", url='" + this.url + '\'' + ", desc='" + this.desc + '\'' + '}';
      AppMethodBeat.o(306709);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.o
 * JD-Core Version:    0.7.0.1
 */