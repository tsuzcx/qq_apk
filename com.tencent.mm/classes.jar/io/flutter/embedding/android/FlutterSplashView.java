package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private final b MBl;
  private h Mlh;
  private View Mli;
  private String Mlj;
  private final FlutterView.a Mlk;
  private final Runnable Mll;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  private FlutterView tiF;
  
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
    this.Mlk = new FlutterView.a()
    {
      public final void fZe()
      {
        AppMethodBeat.i(10025);
        FlutterSplashView.a(FlutterSplashView.this).b(this);
        FlutterSplashView.this.a(FlutterSplashView.a(FlutterSplashView.this), FlutterSplashView.b(FlutterSplashView.this));
        AppMethodBeat.o(10025);
      }
    };
    this.MBl = new b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213361);
        if (FlutterSplashView.b(FlutterSplashView.this) != null) {
          FlutterSplashView.c(FlutterSplashView.this);
        }
        AppMethodBeat.o(213361);
      }
      
      public final void cQn() {}
    };
    this.Mll = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(10113);
        FlutterSplashView.this.removeView(FlutterSplashView.d(FlutterSplashView.this));
        FlutterSplashView.a(FlutterSplashView.this, FlutterSplashView.e(FlutterSplashView.this));
        AppMethodBeat.o(10113);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(10060);
  }
  
  private boolean fZb()
  {
    AppMethodBeat.i(10064);
    if ((this.tiF != null) && (this.tiF.gey()) && (!this.tiF.MBM) && (!fZd()))
    {
      AppMethodBeat.o(10064);
      return true;
    }
    AppMethodBeat.o(10064);
    return false;
  }
  
  private boolean fZc()
  {
    AppMethodBeat.i(213299);
    if (this.tiF != null) {
      this.tiF.gey();
    }
    AppMethodBeat.o(213299);
    return false;
  }
  
  private boolean fZd()
  {
    AppMethodBeat.i(10065);
    IllegalStateException localIllegalStateException;
    if (this.tiF == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if (!this.tiF.gey())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if ((this.tiF.getAttachedFlutterEngine().MCh.MCT != null) && (this.tiF.getAttachedFlutterEngine().MCh.MCT.equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(10065);
      return true;
    }
    AppMethodBeat.o(10065);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, h paramh)
  {
    AppMethodBeat.i(10063);
    if (this.tiF != null)
    {
      this.tiF.b(this.MBl);
      removeView(this.tiF);
    }
    if (this.Mli != null) {
      removeView(this.Mli);
    }
    this.tiF = paramFlutterView;
    addView(paramFlutterView);
    this.Mlh = paramh;
    if (paramh != null)
    {
      if (fZb())
      {
        io.flutter.a.gea();
        this.Mli = paramh.lH(getContext());
        addView(this.Mli);
        paramFlutterView.a(this.MBl);
        AppMethodBeat.o(10063);
        return;
      }
      fZc();
      if (!paramFlutterView.gey())
      {
        io.flutter.a.gea();
        paramFlutterView.a(this.Mlk);
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
    SavedState.access$702(localSavedState, null);
    AppMethodBeat.o(10061);
    return localSavedState;
  }
  
  @Keep
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator<SavedState> CREATOR;
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    
    static
    {
      AppMethodBeat.i(9966);
      CREATOR = new Parcelable.Creator() {};
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */