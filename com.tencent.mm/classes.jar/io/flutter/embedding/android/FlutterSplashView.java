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
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.Set;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private final FlutterView.a IXA;
  private final Runnable IXB;
  private f IXv;
  private View IXw;
  private Bundle IXx;
  private String IXy;
  private String IXz;
  private final b rdC;
  private FlutterView rdJ;
  
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
    this.IXA = new FlutterView.a()
    {
      public final void fus()
      {
        AppMethodBeat.i(10025);
        FlutterSplashView.a(FlutterSplashView.this).IXP.remove(this);
        FlutterSplashView.this.a(FlutterSplashView.a(FlutterSplashView.this), FlutterSplashView.b(FlutterSplashView.this));
        AppMethodBeat.o(10025);
      }
    };
    this.rdC = new b()
    {
      public final void onFirstFrameRendered()
      {
        AppMethodBeat.i(9963);
        if (FlutterSplashView.b(FlutterSplashView.this) != null) {
          FlutterSplashView.c(FlutterSplashView.this);
        }
        AppMethodBeat.o(9963);
      }
    };
    this.IXB = new Runnable()
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
  
  private boolean fuq()
  {
    AppMethodBeat.i(10064);
    if ((this.rdJ != null) && (this.rdJ.fux()) && (!this.rdJ.IXO) && (!fur()))
    {
      AppMethodBeat.o(10064);
      return true;
    }
    AppMethodBeat.o(10064);
    return false;
  }
  
  private boolean fur()
  {
    AppMethodBeat.i(10065);
    IllegalStateException localIllegalStateException;
    if (this.rdJ == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if (!this.rdJ.fux())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if ((this.rdJ.getAttachedFlutterEngine().IYe.IYR != null) && (this.rdJ.getAttachedFlutterEngine().IYe.IYR.equals(this.IXz)))
    {
      AppMethodBeat.o(10065);
      return true;
    }
    AppMethodBeat.o(10065);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, f paramf)
  {
    AppMethodBeat.i(10063);
    if (this.rdJ != null)
    {
      this.rdJ.removeOnFirstFrameRenderedListener(this.rdC);
      removeView(this.rdJ);
    }
    if (this.IXw != null) {
      removeView(this.IXw);
    }
    this.rdJ = paramFlutterView;
    addView(paramFlutterView);
    this.IXv = paramf;
    if (paramf != null)
    {
      if (fuq())
      {
        io.flutter.a.ftS();
        this.IXw = paramf.lh(getContext());
        addView(this.IXw);
        paramFlutterView.addOnFirstFrameRenderedListener(this.rdC);
        AppMethodBeat.o(10063);
        return;
      }
      if (!paramFlutterView.fux())
      {
        io.flutter.a.ftS();
        paramFlutterView.a(this.IXA);
      }
    }
    AppMethodBeat.o(10063);
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(10062);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.IXz = SavedState.b(paramParcelable);
    this.IXx = SavedState.c(paramParcelable);
    AppMethodBeat.o(10062);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(10061);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.a(localSavedState, this.IXz);
    SavedState.a(localSavedState);
    AppMethodBeat.o(10061);
    return localSavedState;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator CREATOR;
    private Bundle IXx;
    private String IXz;
    
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
      this.IXz = paramParcel.readString();
      this.IXx = paramParcel.readBundle(getClass().getClassLoader());
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
      paramParcel.writeString(this.IXz);
      paramParcel.writeBundle(this.IXx);
      AppMethodBeat.o(9965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */