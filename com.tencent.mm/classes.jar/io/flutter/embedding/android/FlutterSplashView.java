package io.flutter.embedding.android;

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
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
  private final FlutterUiDisplayListener flutterUiDisplayListener;
  private FlutterView flutterView;
  private final Runnable onTransitionComplete;
  private String previousCompletedSplashIsolate;
  private SplashScreen splashScreen;
  private Bundle splashScreenState;
  private View splashScreenView;
  private String transitioningIsolateId;
  
  public FlutterSplashView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FlutterSplashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlutterSplashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(10060);
    this.flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener()
    {
      public void onFlutterEngineAttachedToFlutterView(FlutterEngine paramAnonymousFlutterEngine)
      {
        AppMethodBeat.i(190410);
        FlutterSplashView.this.flutterView.removeFlutterEngineAttachmentListener(this);
        FlutterSplashView.this.displayFlutterViewWithSplash(FlutterSplashView.this.flutterView, FlutterSplashView.this.splashScreen);
        AppMethodBeat.o(190410);
      }
      
      public void onFlutterEngineDetachedFromFlutterView() {}
    };
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190398);
        if (FlutterSplashView.this.splashScreen != null) {
          FlutterSplashView.access$200(FlutterSplashView.this);
        }
        AppMethodBeat.o(190398);
      }
      
      public void onFlutterUiNoLongerDisplayed() {}
    };
    this.onTransitionComplete = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(10113);
        FlutterSplashView.this.removeView(FlutterSplashView.this.splashScreenView);
        FlutterSplashView.access$402(FlutterSplashView.this, FlutterSplashView.this.transitioningIsolateId);
        AppMethodBeat.o(10113);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(10060);
  }
  
  private boolean hasSplashCompleted()
  {
    AppMethodBeat.i(10065);
    IllegalStateException localIllegalStateException;
    if (this.flutterView == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if (!this.flutterView.isAttachedToFlutterEngine())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if ((this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null) && (this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(10065);
      return true;
    }
    AppMethodBeat.o(10065);
    return false;
  }
  
  private boolean isSplashScreenNeededNow()
  {
    AppMethodBeat.i(10064);
    if ((this.flutterView != null) && (this.flutterView.isAttachedToFlutterEngine()) && (!this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted()))
    {
      AppMethodBeat.o(10064);
      return true;
    }
    AppMethodBeat.o(10064);
    return false;
  }
  
  private boolean isSplashScreenTransitionNeededNow()
  {
    AppMethodBeat.i(190409);
    if ((this.flutterView != null) && (this.flutterView.isAttachedToFlutterEngine()) && (this.splashScreen != null) && (this.splashScreen.doesSplashViewRememberItsTransition()) && (wasPreviousSplashTransitionInterrupted()))
    {
      AppMethodBeat.o(190409);
      return true;
    }
    AppMethodBeat.o(190409);
    return false;
  }
  
  private void transitionToFlutter()
  {
    AppMethodBeat.i(190435);
    this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
    Log.v(TAG, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
    this.splashScreen.transitionToFlutter(this.onTransitionComplete);
    AppMethodBeat.o(190435);
  }
  
  private boolean wasPreviousSplashTransitionInterrupted()
  {
    AppMethodBeat.i(190417);
    IllegalStateException localIllegalStateException;
    if (this.flutterView == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
      AppMethodBeat.o(190417);
      throw localIllegalStateException;
    }
    if (!this.flutterView.isAttachedToFlutterEngine())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(190417);
      throw localIllegalStateException;
    }
    if ((this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted()))
    {
      AppMethodBeat.o(190417);
      return true;
    }
    AppMethodBeat.o(190417);
    return false;
  }
  
  public final void displayFlutterViewWithSplash(FlutterView paramFlutterView, SplashScreen paramSplashScreen)
  {
    AppMethodBeat.i(10063);
    if (this.flutterView != null)
    {
      this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
      removeView(this.flutterView);
    }
    if (this.splashScreenView != null) {
      removeView(this.splashScreenView);
    }
    this.flutterView = paramFlutterView;
    addView(paramFlutterView);
    this.splashScreen = paramSplashScreen;
    if (paramSplashScreen != null)
    {
      if (isSplashScreenNeededNow())
      {
        Log.v(TAG, "Showing splash screen UI.");
        this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
        addView(this.splashScreenView);
        paramFlutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        AppMethodBeat.o(10063);
        return;
      }
      if (isSplashScreenTransitionNeededNow())
      {
        Log.v(TAG, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
        this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
        addView(this.splashScreenView);
        transitionToFlutter();
        AppMethodBeat.o(10063);
        return;
      }
      if (!paramFlutterView.isAttachedToFlutterEngine())
      {
        Log.v(TAG, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
        paramFlutterView.addFlutterEngineAttachmentListener(this.flutterEngineAttachmentListener);
      }
    }
    AppMethodBeat.o(10063);
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(10062);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = paramParcelable.previousCompletedSplashIsolate;
    this.splashScreenState = paramParcelable.splashScreenState;
    AppMethodBeat.o(10062);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(10061);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.access$602(localSavedState, this.previousCompletedSplashIsolate);
    if (this.splashScreen != null) {}
    for (Bundle localBundle = this.splashScreen.saveSplashScreenState();; localBundle = null)
    {
      SavedState.access$702(localSavedState, localBundle);
      AppMethodBeat.o(10061);
      return localSavedState;
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator<SavedState> CREATOR;
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    
    static
    {
      AppMethodBeat.i(9966);
      CREATOR = new Parcelable.Creator()
      {
        public final FlutterSplashView.SavedState createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(190463);
          paramAnonymousParcel = new FlutterSplashView.SavedState(paramAnonymousParcel);
          AppMethodBeat.o(190463);
          return paramAnonymousParcel;
        }
        
        public final FlutterSplashView.SavedState[] newArray(int paramAnonymousInt)
        {
          return new FlutterSplashView.SavedState[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(9966);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(9964);
      this.previousCompletedSplashIsolate = paramParcel.readString();
      this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
      AppMethodBeat.o(9964);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(9965);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.previousCompletedSplashIsolate);
      paramParcel.writeBundle(this.splashScreenState);
      AppMethodBeat.o(9965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */