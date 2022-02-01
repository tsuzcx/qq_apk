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
  private h MIe;
  private View MIf;
  private String MIg;
  private final FlutterView.a MIh;
  private final Runnable MIi;
  private final b MYq;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  private FlutterView ttx;
  
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
    this.MIh = new FlutterView.a()
    {
      public final void gdF()
      {
        AppMethodBeat.i(10025);
        FlutterSplashView.a(FlutterSplashView.this).b(this);
        FlutterSplashView.this.a(FlutterSplashView.a(FlutterSplashView.this), FlutterSplashView.b(FlutterSplashView.this));
        AppMethodBeat.o(10025);
      }
    };
    this.MYq = new b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197943);
        if (FlutterSplashView.b(FlutterSplashView.this) != null) {
          FlutterSplashView.c(FlutterSplashView.this);
        }
        AppMethodBeat.o(197943);
      }
      
      public final void cSS() {}
    };
    this.MIi = new Runnable()
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
  
  private boolean gdC()
  {
    AppMethodBeat.i(10064);
    if ((this.ttx != null) && (this.ttx.gja()) && (!this.ttx.MYR) && (!gdE()))
    {
      AppMethodBeat.o(10064);
      return true;
    }
    AppMethodBeat.o(10064);
    return false;
  }
  
  private boolean gdD()
  {
    AppMethodBeat.i(197881);
    if (this.ttx != null) {
      this.ttx.gja();
    }
    AppMethodBeat.o(197881);
    return false;
  }
  
  private boolean gdE()
  {
    AppMethodBeat.i(10065);
    IllegalStateException localIllegalStateException;
    if (this.ttx == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if (!this.ttx.gja())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if ((this.ttx.getAttachedFlutterEngine().MZm.MZY != null) && (this.ttx.getAttachedFlutterEngine().MZm.MZY.equals(this.previousCompletedSplashIsolate)))
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
    if (this.ttx != null)
    {
      this.ttx.b(this.MYq);
      removeView(this.ttx);
    }
    if (this.MIf != null) {
      removeView(this.MIf);
    }
    this.ttx = paramFlutterView;
    addView(paramFlutterView);
    this.MIe = paramh;
    if (paramh != null)
    {
      if (gdC())
      {
        io.flutter.a.giD();
        this.MIf = paramh.lN(getContext());
        addView(this.MIf);
        paramFlutterView.a(this.MYq);
        AppMethodBeat.o(10063);
        return;
      }
      gdD();
      if (!paramFlutterView.gja())
      {
        io.flutter.a.giD();
        paramFlutterView.a(this.MIh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */