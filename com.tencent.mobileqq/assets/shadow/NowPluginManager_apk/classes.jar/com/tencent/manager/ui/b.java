package com.tencent.manager.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.ViewStub;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class b
  implements LayoutInflater.Factory2
{
  static final Class<?>[] b = { Context.class, AttributeSet.class };
  private static final HashMap<String, Constructor<? extends View>> d = new HashMap();
  private static final HashMap<String, String> f = new HashMap();
  private static final ClassLoader g = LayoutInflater.class.getClassLoader();
  final Object[] a = new Object[2];
  private String c;
  private LayoutInflater e;
  
  public b(String paramString, LayoutInflater paramLayoutInflater)
  {
    this.c = paramString;
    this.e = paramLayoutInflater;
  }
  
  private View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    String str = this.c + paramString;
    Object localObject2 = (Constructor)d.get(str);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!a(paramContext, (Constructor)localObject2))
      {
        d.remove(str);
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = paramContext.getClassLoader().loadClass(paramString).asSubclass(View.class).getConstructor(b);
      ((Constructor)localObject2).setAccessible(true);
      d.put(str, localObject2);
      paramString = this.a[0];
      if (this.a[0] == null) {
        this.a[0] = paramContext;
      }
      paramContext = this.a;
      paramContext[1] = paramAttributeSet;
      paramAttributeSet = (View)((Constructor)localObject2).newInstance(paramContext);
      if (((paramAttributeSet instanceof ViewStub)) && (Build.VERSION.SDK_INT >= 16)) {
        ((ViewStub)paramAttributeSet).setLayoutInflater(this.e.cloneInContext((Context)paramContext[0]));
      }
      this.a[0] = paramString;
      return paramAttributeSet;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private final boolean a(Context paramContext, Constructor<? extends View> paramConstructor)
  {
    ClassLoader localClassLoader = paramConstructor.getDeclaringClass().getClassLoader();
    if (localClassLoader == g) {}
    do
    {
      while (localClassLoader == paramContext)
      {
        return true;
        paramContext = paramContext.getClassLoader();
      }
      paramConstructor = paramContext.getParent();
      paramContext = paramConstructor;
    } while (paramConstructor != null);
    return false;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramString.contains(".")) {
      return a(paramString, paramContext, paramAttributeSet);
    }
    if ((paramContext instanceof Activity)) {
      return ((Activity)paramContext).onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return null;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.ui.b
 * JD-Core Version:    0.7.0.1
 */