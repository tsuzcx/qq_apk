package com.tencent.wax.ui;

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
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.a;
import io.flutter.embedding.android.h;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;

public class WxaFlutterSplashView
  extends FrameLayout
{
  private h MIe;
  private View MIf;
  private String MIg;
  private final FlutterView.a MIh;
  private final Runnable MIi;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  private final b ttq;
  private FlutterView ttx;
  
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
    AppMethodBeat.i(195579);
    this.MIh = new FlutterView.a()
    {
      public final void gdF()
      {
        AppMethodBeat.i(195572);
        WxaFlutterSplashView.a(WxaFlutterSplashView.this).b(this);
        WxaFlutterSplashView.this.a(WxaFlutterSplashView.a(WxaFlutterSplashView.this), WxaFlutterSplashView.b(WxaFlutterSplashView.this));
        AppMethodBeat.o(195572);
      }
    };
    this.ttq = new b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(195573);
        if (WxaFlutterSplashView.b(WxaFlutterSplashView.this) != null) {
          WxaFlutterSplashView.c(WxaFlutterSplashView.this);
        }
        AppMethodBeat.o(195573);
      }
      
      public final void cSS() {}
    };
    this.MIi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195574);
        WxaFlutterSplashView.this.removeView(WxaFlutterSplashView.d(WxaFlutterSplashView.this));
        WxaFlutterSplashView.a(WxaFlutterSplashView.this, WxaFlutterSplashView.e(WxaFlutterSplashView.this));
        AppMethodBeat.o(195574);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(195579);
  }
  
  private boolean gdC()
  {
    AppMethodBeat.i(195583);
    if ((this.ttx != null) && (this.ttx.gja()) && (!this.ttx.MYR) && (!gdE()))
    {
      AppMethodBeat.o(195583);
      return true;
    }
    AppMethodBeat.o(195583);
    return false;
  }
  
  private boolean gdD()
  {
    AppMethodBeat.i(195584);
    if (this.ttx != null) {
      this.ttx.gja();
    }
    AppMethodBeat.o(195584);
    return false;
  }
  
  private boolean gdE()
  {
    AppMethodBeat.i(195585);
    IllegalStateException localIllegalStateException;
    if (this.ttx == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(195585);
      throw localIllegalStateException;
    }
    if (!this.ttx.gja())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(195585);
      throw localIllegalStateException;
    }
    if ((this.ttx.getAttachedFlutterEngine().MZm.MZY != null) && (this.ttx.getAttachedFlutterEngine().MZm.MZY.equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(195585);
      return true;
    }
    AppMethodBeat.o(195585);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, h paramh)
  {
    AppMethodBeat.i(195582);
    if (this.ttx != null)
    {
      this.ttx.b(this.ttq);
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
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterSplashView", "Showing splash screen UI.", new Object[0]);
        this.MIf = paramh.lN(getContext());
        addView(this.MIf);
        paramFlutterView.a(this.ttq);
        AppMethodBeat.o(195582);
        return;
      }
      gdD();
      if (!paramFlutterView.gja())
      {
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterSplashView", "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.", new Object[0]);
        paramFlutterView.a(this.MIh);
      }
    }
    AppMethodBeat.o(195582);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(195581);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = SavedState.b(paramParcelable);
    this.splashScreenState = SavedState.c(paramParcelable);
    AppMethodBeat.o(195581);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(195580);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.a(localSavedState, this.previousCompletedSplashIsolate);
    SavedState.a(localSavedState);
    AppMethodBeat.o(195580);
    return localSavedState;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator CREATOR;
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    
    static
    {
      AppMethodBeat.i(195578);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195578);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(195576);
      this.previousCompletedSplashIsolate = paramParcel.readString();
      this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
      AppMethodBeat.o(195576);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195577);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.previousCompletedSplashIsolate);
      paramParcel.writeBundle(this.splashScreenState);
      AppMethodBeat.o(195577);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.ui.WxaFlutterSplashView
 * JD-Core Version:    0.7.0.1
 */