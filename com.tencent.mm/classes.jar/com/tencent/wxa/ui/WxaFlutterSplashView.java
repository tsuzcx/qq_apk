package com.tencent.wxa.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

public class WxaFlutterSplashView
  extends FrameLayout
{
  private final FlutterUiDisplayListener Hku;
  private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
  private FlutterView flutterView;
  private final Runnable onTransitionComplete;
  private String previousCompletedSplashIsolate;
  private SplashScreen splashScreen;
  private Bundle splashScreenState;
  private View splashScreenView;
  private String transitioningIsolateId;
  
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
    AppMethodBeat.i(210517);
    this.flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener()
    {
      public final void onFlutterEngineAttachedToFlutterView(FlutterEngine paramAnonymousFlutterEngine)
      {
        AppMethodBeat.i(210502);
        WxaFlutterSplashView.a(WxaFlutterSplashView.this).removeFlutterEngineAttachmentListener(this);
        WxaFlutterSplashView.this.displayFlutterViewWithSplash(WxaFlutterSplashView.a(WxaFlutterSplashView.this), WxaFlutterSplashView.b(WxaFlutterSplashView.this));
        AppMethodBeat.o(210502);
      }
      
      public final void onFlutterEngineDetachedFromFlutterView() {}
    };
    this.Hku = new FlutterUiDisplayListener()
    {
      public final void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(210489);
        if (WxaFlutterSplashView.b(WxaFlutterSplashView.this) != null) {
          WxaFlutterSplashView.c(WxaFlutterSplashView.this);
        }
        AppMethodBeat.o(210489);
      }
      
      public final void onFlutterUiNoLongerDisplayed() {}
    };
    this.onTransitionComplete = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210500);
        WxaFlutterSplashView.this.removeView(WxaFlutterSplashView.d(WxaFlutterSplashView.this));
        WxaFlutterSplashView.a(WxaFlutterSplashView.this, WxaFlutterSplashView.e(WxaFlutterSplashView.this));
        AppMethodBeat.o(210500);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(210517);
  }
  
  private boolean hasSplashCompleted()
  {
    AppMethodBeat.i(210556);
    IllegalStateException localIllegalStateException;
    if (this.flutterView == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(210556);
      throw localIllegalStateException;
    }
    if (!this.flutterView.isAttachedToFlutterEngine())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(210556);
      throw localIllegalStateException;
    }
    if ((this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null) && (this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(210556);
      return true;
    }
    AppMethodBeat.o(210556);
    return false;
  }
  
  private boolean isSplashScreenNeededNow()
  {
    AppMethodBeat.i(210531);
    if ((this.flutterView != null) && (this.flutterView.isAttachedToFlutterEngine()) && (!this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted()))
    {
      AppMethodBeat.o(210531);
      return true;
    }
    AppMethodBeat.o(210531);
    return false;
  }
  
  private boolean isSplashScreenTransitionNeededNow()
  {
    AppMethodBeat.i(210538);
    if ((this.flutterView != null) && (this.flutterView.isAttachedToFlutterEngine()) && (this.splashScreen != null) && (this.splashScreen.doesSplashViewRememberItsTransition()) && (wasPreviousSplashTransitionInterrupted()))
    {
      AppMethodBeat.o(210538);
      return true;
    }
    AppMethodBeat.o(210538);
    return false;
  }
  
  private void transitionToFlutter()
  {
    AppMethodBeat.i(210566);
    this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
    a.v("WxaRouter.WxaFlutterSplashView", "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId, new Object[0]);
    this.splashScreen.transitionToFlutter(this.onTransitionComplete);
    AppMethodBeat.o(210566);
  }
  
  private boolean wasPreviousSplashTransitionInterrupted()
  {
    AppMethodBeat.i(210548);
    IllegalStateException localIllegalStateException;
    if (this.flutterView == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
      AppMethodBeat.o(210548);
      throw localIllegalStateException;
    }
    if (!this.flutterView.isAttachedToFlutterEngine())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(210548);
      throw localIllegalStateException;
    }
    if ((this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted()))
    {
      AppMethodBeat.o(210548);
      return true;
    }
    AppMethodBeat.o(210548);
    return false;
  }
  
  public final void displayFlutterViewWithSplash(FlutterView paramFlutterView, SplashScreen paramSplashScreen)
  {
    AppMethodBeat.i(210634);
    if (this.flutterView != null)
    {
      this.flutterView.removeOnFirstFrameRenderedListener(this.Hku);
      removeView(this.flutterView);
    }
    if (this.splashScreenView != null) {
      removeView(this.splashScreenView);
    }
    this.flutterView = paramFlutterView;
    this.splashScreen = paramSplashScreen;
    if (paramSplashScreen != null)
    {
      if (!isSplashScreenNeededNow()) {
        break label123;
      }
      a.v("WxaRouter.WxaFlutterSplashView", "Showing splash screen UI.", new Object[0]);
      this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
      addView(this.splashScreenView);
      paramFlutterView.addOnFirstFrameRenderedListener(this.Hku);
    }
    for (;;)
    {
      addView(paramFlutterView);
      AppMethodBeat.o(210634);
      return;
      label123:
      if (isSplashScreenTransitionNeededNow())
      {
        a.v("WxaRouter.WxaFlutterSplashView", "Showing an immediate splash transition to Flutter due to previously interrupted transition.", new Object[0]);
        this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
        addView(this.splashScreenView);
        transitionToFlutter();
      }
      else if (!paramFlutterView.isAttachedToFlutterEngine())
      {
        a.v("WxaRouter.WxaFlutterSplashView", "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.", new Object[0]);
        paramFlutterView.addFlutterEngineAttachmentListener(this.flutterEngineAttachmentListener);
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(210627);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = SavedState.a(paramParcelable);
    this.splashScreenState = SavedState.b(paramParcelable);
    AppMethodBeat.o(210627);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(210623);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.a(localSavedState, this.previousCompletedSplashIsolate);
    if (this.splashScreen != null) {}
    for (Bundle localBundle = this.splashScreen.saveSplashScreenState();; localBundle = null)
    {
      SavedState.a(localSavedState, localBundle);
      AppMethodBeat.o(210623);
      return localSavedState;
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator CREATOR;
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    
    static
    {
      AppMethodBeat.i(210552);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(210552);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(210512);
      this.previousCompletedSplashIsolate = paramParcel.readString();
      this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
      AppMethodBeat.o(210512);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(210561);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.previousCompletedSplashIsolate);
      paramParcel.writeBundle(this.splashScreenState);
      AppMethodBeat.o(210561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.ui.WxaFlutterSplashView
 * JD-Core Version:    0.7.0.1
 */