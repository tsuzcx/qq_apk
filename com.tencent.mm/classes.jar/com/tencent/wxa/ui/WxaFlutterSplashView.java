package com.tencent.wxa.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.a;
import io.flutter.embedding.android.j;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;

public class WxaFlutterSplashView
  extends FrameLayout
{
  private j Syh;
  private View Syi;
  private String Syj;
  private final FlutterView.a Syk;
  private final Runnable Syl;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  private final b wJo;
  private FlutterView wKM;
  
  public WxaFlutterSplashView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public WxaFlutterSplashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WxaFlutterSplashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206392);
    this.Syk = new FlutterView.a()
    {
      public final void hrW()
      {
        AppMethodBeat.i(206385);
        WxaFlutterSplashView.a(WxaFlutterSplashView.this).b(this);
        WxaFlutterSplashView.this.a(WxaFlutterSplashView.a(WxaFlutterSplashView.this), WxaFlutterSplashView.b(WxaFlutterSplashView.this));
        AppMethodBeat.o(206385);
      }
    };
    this.wJo = new b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(206386);
        if (WxaFlutterSplashView.b(WxaFlutterSplashView.this) != null) {
          WxaFlutterSplashView.c(WxaFlutterSplashView.this);
        }
        AppMethodBeat.o(206386);
      }
      
      public final void dLu() {}
    };
    this.Syl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206387);
        WxaFlutterSplashView.this.removeView(WxaFlutterSplashView.d(WxaFlutterSplashView.this));
        WxaFlutterSplashView.a(WxaFlutterSplashView.this, WxaFlutterSplashView.e(WxaFlutterSplashView.this));
        AppMethodBeat.o(206387);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(206392);
  }
  
  private boolean hrT()
  {
    AppMethodBeat.i(206396);
    if ((this.wKM != null) && (this.wKM.hwA()) && (!this.wKM.SNn) && (!hrV()))
    {
      AppMethodBeat.o(206396);
      return true;
    }
    AppMethodBeat.o(206396);
    return false;
  }
  
  private boolean hrU()
  {
    AppMethodBeat.i(206397);
    if (this.wKM != null) {
      this.wKM.hwA();
    }
    AppMethodBeat.o(206397);
    return false;
  }
  
  private boolean hrV()
  {
    AppMethodBeat.i(206398);
    IllegalStateException localIllegalStateException;
    if (this.wKM == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(206398);
      throw localIllegalStateException;
    }
    if (!this.wKM.hwA())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(206398);
      throw localIllegalStateException;
    }
    if ((this.wKM.getAttachedFlutterEngine().SNW.SOJ != null) && (this.wKM.getAttachedFlutterEngine().SNW.SOJ.equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(206398);
      return true;
    }
    AppMethodBeat.o(206398);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, j paramj)
  {
    AppMethodBeat.i(206395);
    if (this.wKM != null)
    {
      this.wKM.b(this.wJo);
      removeView(this.wKM);
    }
    if (this.Syi != null) {
      removeView(this.Syi);
    }
    this.wKM = paramFlutterView;
    addView(paramFlutterView);
    this.Syh = paramj;
    if (paramj != null)
    {
      if (hrT())
      {
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterSplashView", "Showing splash screen UI.", new Object[0]);
        this.Syi = paramj.lM(getContext());
        addView(this.Syi);
        paramFlutterView.a(this.wJo);
        AppMethodBeat.o(206395);
        return;
      }
      hrU();
      if (!paramFlutterView.hwA())
      {
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterSplashView", "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.", new Object[0]);
        paramFlutterView.a(this.Syk);
      }
    }
    AppMethodBeat.o(206395);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(206394);
    paramParcelable = (WxaFlutterSplashView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = WxaFlutterSplashView.SavedState.b(paramParcelable);
    this.splashScreenState = WxaFlutterSplashView.SavedState.c(paramParcelable);
    AppMethodBeat.o(206394);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(206393);
    WxaFlutterSplashView.SavedState localSavedState = new WxaFlutterSplashView.SavedState(super.onSaveInstanceState());
    WxaFlutterSplashView.SavedState.a(localSavedState, this.previousCompletedSplashIsolate);
    WxaFlutterSplashView.SavedState.a(localSavedState);
    AppMethodBeat.o(206393);
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.ui.WxaFlutterSplashView
 * JD-Core Version:    0.7.0.1
 */