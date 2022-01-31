package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.xweb.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.R.id;
import org.xwalk.core.R.layout;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class e
{
  private static ClassLoader mClassLoader;
  
  public static b a(Activity paramActivity, WebView paramWebView, View paramView, String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (XWalkCoreWrapper.getInstance() != null)
    {
      Log.i("VideoNativeInterface", "createXWebNativeInterface get class by xwalk");
      localObject2 = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
      localObject1 = null;
    }
    while (localObject2 != null)
    {
      try
      {
        Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal");
        localObject2 = new e.a(((Class)localObject2).newInstance());
        XWalkContextWrapper localXWalkContextWrapper = new XWalkContextWrapper(paramWebView.getContext(), XWalkEnvironment.getAvailableVersion());
        if (localObject1 != null) {
          localXWalkContextWrapper.setClassLoader((ClassLoader)localObject1);
        }
        ((e.a)localObject2).xiS.invoke(new Object[] { paramActivity, paramWebView, paramView, localXWalkContextWrapper, paramString });
        return localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label186:
          Log.e("VideoNativeInterface", "XWebNativeInterfaceInternal found but error:" + localException.getMessage());
          continue;
          Object localObject3 = null;
        }
      }
      Log.i("VideoNativeInterface", "createXWebNativeInterface get class by sys");
      localObject1 = Boolean.valueOf(XWalkEnvironment.getXWebInitArgs("isgpversion", false));
      if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
      {
        if (!((Boolean)localObject1).booleanValue())
        {
          try
          {
            localObject1 = cSE();
            if (localObject1 == null) {
              break label809;
            }
          }
          catch (ClassNotFoundException localClassNotFoundException1)
          {
            try
            {
              localObject2 = ((ClassLoader)localObject1).loadClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
            }
            catch (ClassNotFoundException localClassNotFoundException2)
            {
              d locald;
              break label186;
            }
            localClassNotFoundException1 = localClassNotFoundException1;
            locald = null;
          }
          localObject2 = null;
        }
        else
        {
          Log.e("VideoNativeInterface", "createXWebNativeInterface current is gpversion not load dex");
          locald = null;
          localObject2 = null;
        }
      }
      else
      {
        Log.e("VideoNativeInterface", "createXWebNativeInterface no gpversion value");
        locald = null;
        localObject2 = null;
      }
    }
    Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal but bot found");
    Log.i("VideoNativeInterface", "createXWebNativeInterface using local class:XWebNativeInterface");
    locald = new d();
    paramView.getContext();
    locald.mActivity = paramActivity;
    locald.vWc = ((WebView)paramWebView);
    locald.xit = paramString;
    locald.rbC = new FrameLayout(locald.vWc.getContext());
    locald.rbC.setBackgroundColor(-16777216);
    if (locald.vWc.isXWalkKernel())
    {
      locald.xhP = new SurfaceView(locald.vWc.getContext());
      locald.xhP.getHolder().setFormat(-3);
      locald.xhP.getHolder().addCallback(new d.1(locald));
      locald.xhP.setZOrderOnTop(false);
      locald.xhP.setZOrderMediaOverlay(false);
      locald.rbC.addView(locald.xhP);
    }
    locald.Fh = new GestureDetector(locald.vWc.getContext(), locald);
    locald.xid = new ScaleGestureDetector(locald.vWc.getContext(), locald);
    locald.Fh.setIsLongpressEnabled(false);
    locald.xhR = ((ViewGroup)LayoutInflater.from(locald.vWc.getContext()).inflate(R.layout.video_control, null));
    locald.xhR.setVisibility(8);
    locald.xib = new c((FrameLayout)locald.xhR.findViewById(R.id.player_progress_root), new d.12(locald));
    locald.xhT = ((ProgressBar)locald.xhR.findViewById(R.id.progressLoading));
    locald.xhU = ((TextView)locald.xhR.findViewById(R.id.tv_current_time));
    locald.xhV = ((TextView)locald.xhR.findViewById(R.id.tv_total_time));
    locald.xhY = ((ImageView)locald.xhR.findViewById(R.id.imageFrame));
    locald.xhS = ((VideoStatusLayout)locald.xhR.findViewById(R.id.layoutStatus));
    locald.xhW = ((ClickableFrameLayout)locald.xhR.findViewById(R.id.layoutBlank));
    locald.xhW.setGestureDetector(locald.Fh);
    locald.xhW.setOnTouchListener(new d.14(locald));
    locald.xhZ = ((ImageView)locald.xhR.findViewById(R.id.imageExit));
    locald.xhZ.setOnClickListener(new d.15(locald));
    locald.xhX = ((LinearLayout)locald.xhR.findViewById(R.id.layoutVideoControl));
    locald.xhX.setVisibility(4);
    locald.xia = ((ImageView)locald.xhR.findViewById(R.id.imagePlay));
    locald.xia.setOnClickListener(new d.16(locald));
    return locald;
  }
  
  private static ClassLoader cSE()
  {
    ClassLoader localClassLoader = null;
    if (mClassLoader != null) {
      localClassLoader = mClassLoader;
    }
    int i;
    String str1;
    String str2;
    do
    {
      return localClassLoader;
      try
      {
        i = XWalkEnvironment.getAvailableVersion();
        if (i == -1)
        {
          Log.i("VideoNativeInterface", "getXWalkClassLoader version = -1");
          return null;
        }
      }
      catch (Exception localException)
      {
        Log.e("VideoNativeInterface", "getXWalkClassLoader error:" + localException.getMessage());
        return null;
      }
      str1 = XWalkEnvironment.getExtractedCoreDir(i);
      str2 = XWalkEnvironment.getClassDexFilePath(i);
    } while (!new File(str2).exists());
    mClassLoader = new DexClassLoader(str2, XWalkEnvironment.getOptimizedDexDir(i), str1, ClassLoader.getSystemClassLoader());
    return mClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e
 * JD-Core Version:    0.7.0.1
 */