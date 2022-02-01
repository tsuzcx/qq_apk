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
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.dart.DartExecutor;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private FlutterView BCI;
  private j ZZo;
  private View ZZp;
  private String ZZq;
  private final FlutterView.a ZZr;
  private final Runnable ZZs;
  private final io.flutter.embedding.engine.renderer.b aaoE;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  
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
    this.ZZr = new FlutterView.a()
    {
      public final void ivI()
      {
        AppMethodBeat.i(10025);
        FlutterSplashView.a(FlutterSplashView.this).b(this);
        FlutterSplashView.this.a(FlutterSplashView.a(FlutterSplashView.this), FlutterSplashView.b(FlutterSplashView.this));
        AppMethodBeat.o(10025);
      }
    };
    this.aaoE = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(255510);
        if (FlutterSplashView.b(FlutterSplashView.this) != null) {
          FlutterSplashView.c(FlutterSplashView.this);
        }
        AppMethodBeat.o(255510);
      }
      
      public final void epY() {}
    };
    this.ZZs = new Runnable()
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
  
  private boolean ivF()
  {
    AppMethodBeat.i(10064);
    if ((this.BCI != null) && (this.BCI.iAE()) && (!this.BCI.aapl) && (!ivH()))
    {
      AppMethodBeat.o(10064);
      return true;
    }
    AppMethodBeat.o(10064);
    return false;
  }
  
  private boolean ivG()
  {
    AppMethodBeat.i(254916);
    if (this.BCI != null) {
      this.BCI.iAE();
    }
    AppMethodBeat.o(254916);
    return false;
  }
  
  private boolean ivH()
  {
    AppMethodBeat.i(10065);
    IllegalStateException localIllegalStateException;
    if (this.BCI == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if (!this.BCI.iAE())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if ((this.BCI.getAttachedFlutterEngine().aapU.aaqH != null) && (this.BCI.getAttachedFlutterEngine().aapU.aaqH.equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(10065);
      return true;
    }
    AppMethodBeat.o(10065);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, j paramj)
  {
    AppMethodBeat.i(10063);
    if (this.BCI != null)
    {
      this.BCI.b(this.aaoE);
      removeView(this.BCI);
    }
    if (this.ZZp != null) {
      removeView(this.ZZp);
    }
    this.BCI = paramFlutterView;
    addView(paramFlutterView);
    this.ZZo = paramj;
    if (paramj != null)
    {
      if (ivF())
      {
        io.flutter.b.iAd();
        this.ZZp = paramj.mJ(getContext());
        addView(this.ZZp);
        paramFlutterView.a(this.aaoE);
        AppMethodBeat.o(10063);
        return;
      }
      ivG();
      if (!paramFlutterView.iAE())
      {
        io.flutter.b.iAd();
        paramFlutterView.a(this.ZZr);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */