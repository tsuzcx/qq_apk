package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private final b SMD;
  private j Syh;
  private View Syi;
  private String Syj;
  private final FlutterView.a Syk;
  private final Runnable Syl;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  private FlutterView wKM;
  
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
    this.Syk = new FlutterView.a()
    {
      public final void hrW()
      {
        AppMethodBeat.i(10025);
        FlutterSplashView.a(FlutterSplashView.this).b(this);
        FlutterSplashView.this.a(FlutterSplashView.a(FlutterSplashView.this), FlutterSplashView.b(FlutterSplashView.this));
        AppMethodBeat.o(10025);
      }
    };
    this.SMD = new b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(215094);
        if (FlutterSplashView.b(FlutterSplashView.this) != null) {
          FlutterSplashView.c(FlutterSplashView.this);
        }
        AppMethodBeat.o(215094);
      }
      
      public final void dLu() {}
    };
    this.Syl = new Runnable()
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
  
  private boolean hrT()
  {
    AppMethodBeat.i(10064);
    if ((this.wKM != null) && (this.wKM.hwA()) && (!this.wKM.SNn) && (!hrV()))
    {
      AppMethodBeat.o(10064);
      return true;
    }
    AppMethodBeat.o(10064);
    return false;
  }
  
  private boolean hrU()
  {
    AppMethodBeat.i(215015);
    if (this.wKM != null) {
      this.wKM.hwA();
    }
    AppMethodBeat.o(215015);
    return false;
  }
  
  private boolean hrV()
  {
    AppMethodBeat.i(10065);
    IllegalStateException localIllegalStateException;
    if (this.wKM == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if (!this.wKM.hwA())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if ((this.wKM.getAttachedFlutterEngine().SNW.SOJ != null) && (this.wKM.getAttachedFlutterEngine().SNW.SOJ.equals(this.previousCompletedSplashIsolate)))
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
    if (this.wKM != null)
    {
      this.wKM.b(this.SMD);
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
        io.flutter.a.hwd();
        this.Syi = paramj.lM(getContext());
        addView(this.Syi);
        paramFlutterView.a(this.SMD);
        AppMethodBeat.o(10063);
        return;
      }
      hrU();
      if (!paramFlutterView.hwA())
      {
        io.flutter.a.hwd();
        paramFlutterView.a(this.Syk);
      }
    }
    AppMethodBeat.o(10063);
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(10062);
    paramParcelable = (FlutterSplashView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = FlutterSplashView.SavedState.access$600(paramParcelable);
    this.splashScreenState = FlutterSplashView.SavedState.access$700(paramParcelable);
    AppMethodBeat.o(10062);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(10061);
    FlutterSplashView.SavedState localSavedState = new FlutterSplashView.SavedState(super.onSaveInstanceState());
    FlutterSplashView.SavedState.access$602(localSavedState, this.previousCompletedSplashIsolate);
    FlutterSplashView.SavedState.access$702(localSavedState, null);
    AppMethodBeat.o(10061);
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */