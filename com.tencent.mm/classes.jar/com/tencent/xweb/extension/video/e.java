package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class e
{
  private static ClassLoader mClassLoader;
  
  public static b a(Context paramContext, WebView paramWebView, View paramView, String paramString)
  {
    AppMethodBeat.i(154233);
    Activity localActivity = XWalkEnvironment.activityFromContext(paramContext);
    Log.i("VideoNativeInterface", "createXWebNativeInterface:activity:".concat(String.valueOf(localActivity)));
    Object localObject4;
    Object localObject1;
    if (XWalkCoreWrapper.getInstance() != null)
    {
      Log.i("VideoNativeInterface", "createXWebNativeInterface get class by xwalk");
      localObject4 = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject4 != null) {}
      try
      {
        Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal");
        localObject4 = new e.a(((Class)localObject4).newInstance());
        if (!(paramContext instanceof XWalkContextWrapper))
        {
          paramContext = new XWalkContextWrapper(paramWebView.getContext(), XWalkEnvironment.getAvailableVersion());
          if (localObject1 != null) {
            ((XWalkContextWrapper)paramContext).setClassLoader((ClassLoader)localObject1);
          }
          ((e.a)localObject4).BGe.invoke(new Object[] { localActivity, paramWebView, paramView, paramContext, paramString });
          AppMethodBeat.o(154233);
          return localObject4;
          Log.i("VideoNativeInterface", "createXWebNativeInterface get class by sys");
          localObject1 = Boolean.valueOf(XWalkEnvironment.getXWebInitArgs("isgpversion", false));
          if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
          {
            if (!((Boolean)localObject1).booleanValue())
            {
              try
              {
                localObject4 = dYL();
                if (localObject4 == null) {
                  break label812;
                }
              }
              catch (ClassNotFoundException localClassNotFoundException1)
              {
                try
                {
                  localObject1 = ((ClassLoader)localObject4).loadClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
                  Object localObject5 = localObject1;
                  localObject1 = localObject4;
                  localObject4 = localObject5;
                }
                catch (ClassNotFoundException localClassNotFoundException2)
                {
                  for (;;)
                  {
                    Object localObject2;
                    localObject3 = localObject4;
                  }
                }
                localClassNotFoundException1 = localClassNotFoundException1;
                localObject2 = null;
              }
              localObject4 = null;
              continue;
            }
            Log.e("VideoNativeInterface", "createXWebNativeInterface current is gpversion not load dex");
            localObject2 = null;
            localObject4 = null;
            continue;
          }
          Log.e("VideoNativeInterface", "createXWebNativeInterface no gpversion value");
          localObject2 = null;
          localObject4 = null;
          continue;
          Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal but bot found");
          Log.i("VideoNativeInterface", "createXWebNativeInterface using local class:XWebNativeInterface");
          paramContext = new d();
          paramView.getContext();
          paramContext.mActivity = localActivity;
          paramContext.uNH = ((WebView)paramWebView);
          paramContext.BFF = paramString;
          paramContext.osU = new FrameLayout(paramContext.uNH.getContext());
          paramContext.osU.setBackgroundColor(-16777216);
          if (paramContext.uNH.isXWalkKernel())
          {
            paramContext.BFc = new SurfaceView(paramContext.uNH.getContext());
            paramContext.BFc.getHolder().setFormat(-3);
            paramContext.BFc.getHolder().addCallback(new d.1(paramContext));
            paramContext.BFc.setZOrderOnTop(false);
            paramContext.BFc.setZOrderMediaOverlay(false);
            paramContext.osU.addView(paramContext.BFc);
          }
          paramContext.FQ = new GestureDetector(paramContext.uNH.getContext(), paramContext);
          paramContext.BFq = new ScaleGestureDetector(paramContext.uNH.getContext(), paramContext);
          paramContext.FQ.setIsLongpressEnabled(false);
          paramContext.BFe = ((ViewGroup)LayoutInflater.from(paramContext.uNH.getContext()).inflate(2130971060, null));
          paramContext.BFe.setVisibility(8);
          paramContext.BFo = new c((FrameLayout)paramContext.BFe.findViewById(2131821460), new d.12(paramContext));
          paramContext.BFg = ((ProgressBar)paramContext.BFe.findViewById(2131828684));
          paramContext.BFh = ((TextView)paramContext.BFe.findViewById(2131828688));
          paramContext.BFi = ((TextView)paramContext.BFe.findViewById(2131828689));
          paramContext.BFl = ((ImageView)paramContext.BFe.findViewById(2131828685));
          paramContext.BFf = ((VideoStatusLayout)paramContext.BFe.findViewById(2131828683));
          paramContext.BFj = ((ClickableFrameLayout)paramContext.BFe.findViewById(2131828682));
          paramContext.BFj.setGestureDetector(paramContext.FQ);
          paramContext.BFj.setOnTouchListener(new d.14(paramContext));
          paramContext.BFm = ((ImageView)paramContext.BFe.findViewById(2131828690));
          paramContext.BFm.setOnClickListener(new d.15(paramContext));
          paramContext.BFk = ((LinearLayout)paramContext.BFe.findViewById(2131828686));
          paramContext.BFk.setVisibility(4);
          paramContext.BFn = ((ImageView)paramContext.BFe.findViewById(2131828687));
          paramContext.BFn.setOnClickListener(new d.16(paramContext));
          AppMethodBeat.o(154233);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Log.e("VideoNativeInterface", "XWebNativeInterfaceInternal found but error:" + paramContext.getMessage());
          continue;
          continue;
          label812:
          Object localObject3 = null;
        }
      }
    }
  }
  
  private static ClassLoader dYL()
  {
    AppMethodBeat.i(84638);
    Object localObject;
    if (mClassLoader != null)
    {
      localObject = mClassLoader;
      AppMethodBeat.o(84638);
      return localObject;
    }
    try
    {
      int i = XWalkEnvironment.getAvailableVersion();
      if (i == -1)
      {
        Log.i("VideoNativeInterface", "getXWalkClassLoader version = -1");
        AppMethodBeat.o(84638);
        return null;
      }
      localObject = XWalkEnvironment.getExtractedCoreDir(i);
      String str = XWalkEnvironment.getClassDexFilePath(i);
      boolean bool = new File(str).exists();
      if (!bool)
      {
        AppMethodBeat.o(84638);
        return null;
      }
      mClassLoader = new DexClassLoader(str, XWalkEnvironment.getOptimizedDexDir(i), (String)localObject, ClassLoader.getSystemClassLoader());
      localObject = mClassLoader;
      AppMethodBeat.o(84638);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("VideoNativeInterface", "getXWalkClassLoader error:" + localException.getMessage());
      AppMethodBeat.o(84638);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e
 * JD-Core Version:    0.7.0.1
 */