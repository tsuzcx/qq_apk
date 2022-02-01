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
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.a;
import io.flutter.embedding.android.j;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.b;

public class WxaFlutterSplashView
  extends FrameLayout
{
  private final b BCD;
  private FlutterView BCI;
  private j ZZo;
  private View ZZp;
  private String ZZq;
  private final FlutterView.a ZZr;
  private final Runnable ZZs;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  
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
    AppMethodBeat.i(224995);
    this.ZZr = new FlutterView.a()
    {
      public final void ivI()
      {
        AppMethodBeat.i(224980);
        WxaFlutterSplashView.a(WxaFlutterSplashView.this).b(this);
        WxaFlutterSplashView.this.a(WxaFlutterSplashView.a(WxaFlutterSplashView.this), WxaFlutterSplashView.b(WxaFlutterSplashView.this));
        AppMethodBeat.o(224980);
      }
    };
    this.BCD = new b()
    {
      public final void epX()
      {
        AppMethodBeat.i(224984);
        if (WxaFlutterSplashView.b(WxaFlutterSplashView.this) != null) {
          WxaFlutterSplashView.c(WxaFlutterSplashView.this);
        }
        AppMethodBeat.o(224984);
      }
      
      public final void epY() {}
    };
    this.ZZs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224985);
        WxaFlutterSplashView.this.removeView(WxaFlutterSplashView.d(WxaFlutterSplashView.this));
        WxaFlutterSplashView.a(WxaFlutterSplashView.this, WxaFlutterSplashView.e(WxaFlutterSplashView.this));
        AppMethodBeat.o(224985);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(224995);
  }
  
  private boolean ivF()
  {
    AppMethodBeat.i(225001);
    if ((this.BCI != null) && (this.BCI.iAE()) && (!this.BCI.aapl) && (!ivH()))
    {
      AppMethodBeat.o(225001);
      return true;
    }
    AppMethodBeat.o(225001);
    return false;
  }
  
  private boolean ivG()
  {
    AppMethodBeat.i(225002);
    if (this.BCI != null) {
      this.BCI.iAE();
    }
    AppMethodBeat.o(225002);
    return false;
  }
  
  private boolean ivH()
  {
    AppMethodBeat.i(225005);
    IllegalStateException localIllegalStateException;
    if (this.BCI == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(225005);
      throw localIllegalStateException;
    }
    if (!this.BCI.iAE())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(225005);
      throw localIllegalStateException;
    }
    if ((this.BCI.getAttachedFlutterEngine().aapU.aaqH != null) && (this.BCI.getAttachedFlutterEngine().aapU.aaqH.equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(225005);
      return true;
    }
    AppMethodBeat.o(225005);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, j paramj)
  {
    AppMethodBeat.i(225000);
    if (this.BCI != null)
    {
      this.BCI.b(this.BCD);
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
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterSplashView", "Showing splash screen UI.", new Object[0]);
        this.ZZp = paramj.mJ(getContext());
        addView(this.ZZp);
        paramFlutterView.a(this.BCD);
        AppMethodBeat.o(225000);
        return;
      }
      ivG();
      if (!paramFlutterView.iAE())
      {
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterSplashView", "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.", new Object[0]);
        paramFlutterView.a(this.ZZr);
      }
    }
    AppMethodBeat.o(225000);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(224998);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = SavedState.b(paramParcelable);
    this.splashScreenState = SavedState.c(paramParcelable);
    AppMethodBeat.o(224998);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(224997);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.a(localSavedState, this.previousCompletedSplashIsolate);
    SavedState.a(localSavedState);
    AppMethodBeat.o(224997);
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
      AppMethodBeat.i(224992);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(224992);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(224990);
      this.previousCompletedSplashIsolate = paramParcel.readString();
      this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
      AppMethodBeat.o(224990);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(224991);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.previousCompletedSplashIsolate);
      paramParcel.writeBundle(this.splashScreenState);
      AppMethodBeat.o(224991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.ui.WxaFlutterSplashView
 * JD-Core Version:    0.7.0.1
 */