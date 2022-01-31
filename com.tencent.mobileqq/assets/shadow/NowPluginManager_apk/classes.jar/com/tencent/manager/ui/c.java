package com.tencent.manager.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class c
  extends LayoutInflater
{
  private static final String[] a = { "android.widget.", "android.webkit.", "android.app." };
  
  protected c(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
  }
  
  public static c a(LayoutInflater paramLayoutInflater, Context paramContext, String paramString)
  {
    paramLayoutInflater = new c(paramLayoutInflater, paramContext);
    paramLayoutInflater.setFactory2(new b(paramString, paramLayoutInflater));
    return paramLayoutInflater;
  }
  
  public LayoutInflater cloneInContext(Context paramContext)
  {
    return null;
  }
  
  protected View onCreateView(String paramString, AttributeSet paramAttributeSet)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      try
      {
        localObject = createView(paramString, (String)localObject, paramAttributeSet);
        if (localObject != null) {
          return localObject;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        i += 1;
      }
    }
    return super.onCreateView(paramString, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.ui.c
 * JD-Core Version:    0.7.0.1
 */