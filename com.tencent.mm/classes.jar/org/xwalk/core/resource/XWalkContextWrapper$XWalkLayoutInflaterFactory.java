package org.xwalk.core.resource;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import org.xwalk.core.Log;

final class XWalkContextWrapper$XWalkLayoutInflaterFactory
  implements LayoutInflater.Factory
{
  LayoutInflater layoutInflater;
  
  private View createView(String paramString1, String paramString2, AttributeSet paramAttributeSet)
  {
    try
    {
      paramString1 = this.layoutInflater.createView(paramString1, paramString2, paramAttributeSet);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      return null;
    }
    catch (InflateException paramString1) {}
    return null;
  }
  
  public final View inflateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = null;
    if (paramString.indexOf(".") == -1)
    {
      if (paramString.equals("WebView")) {
        localObject = createView(paramString, "android.webkit.", paramAttributeSet);
      }
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = createView(paramString, "android.widget.", paramAttributeSet);
      }
      localObject = paramContext;
      if (paramContext == null) {
        localObject = createView(paramString, "android.view.", paramAttributeSet);
      }
      return localObject;
    }
    return this.layoutInflater.createView(paramString, null, paramAttributeSet);
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Context localContext2 = null;
    Context localContext1 = null;
    try
    {
      paramContext = inflateView(paramString, paramContext, paramAttributeSet);
      localContext1 = paramContext;
      localContext2 = paramContext;
      if ((paramContext instanceof ViewStub))
      {
        localContext1 = paramContext;
        localContext2 = paramContext;
        if (Build.VERSION.SDK_INT >= 21)
        {
          localContext1 = paramContext;
          localContext2 = paramContext;
          ((ViewStub)paramContext).setLayoutInflater(this.layoutInflater);
        }
      }
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.w("XWalkLib", String.format("[XWalkContextWrapper] class not found. name:%s. Use default Inflate.", new Object[] { paramString }));
      return localContext1;
    }
    catch (InflateException paramContext)
    {
      Log.w("XWalkLib", String.format("[XWalkContextWrapper] Inflate failed. name:%s. Use default Inflate.", new Object[] { paramString }));
    }
    return localContext2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkContextWrapper.XWalkLayoutInflaterFactory
 * JD-Core Version:    0.7.0.1
 */