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
  private h Mlh;
  private View Mli;
  private String Mlj;
  private final FlutterView.a Mlk;
  private final Runnable Mll;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  private FlutterView tiF;
  private final b tiy;
  
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
    AppMethodBeat.i(217565);
    this.Mlk = new FlutterView.a()
    {
      public final void fZe()
      {
        AppMethodBeat.i(217558);
        WxaFlutterSplashView.a(WxaFlutterSplashView.this).b(this);
        WxaFlutterSplashView.this.a(WxaFlutterSplashView.a(WxaFlutterSplashView.this), WxaFlutterSplashView.b(WxaFlutterSplashView.this));
        AppMethodBeat.o(217558);
      }
    };
    this.tiy = new b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(217559);
        if (WxaFlutterSplashView.b(WxaFlutterSplashView.this) != null) {
          WxaFlutterSplashView.c(WxaFlutterSplashView.this);
        }
        AppMethodBeat.o(217559);
      }
      
      public final void cQn() {}
    };
    this.Mll = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217560);
        WxaFlutterSplashView.this.removeView(WxaFlutterSplashView.d(WxaFlutterSplashView.this));
        WxaFlutterSplashView.a(WxaFlutterSplashView.this, WxaFlutterSplashView.e(WxaFlutterSplashView.this));
        AppMethodBeat.o(217560);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(217565);
  }
  
  private boolean fZb()
  {
    AppMethodBeat.i(217569);
    if ((this.tiF != null) && (this.tiF.gey()) && (!this.tiF.MBM) && (!fZd()))
    {
      AppMethodBeat.o(217569);
      return true;
    }
    AppMethodBeat.o(217569);
    return false;
  }
  
  private boolean fZc()
  {
    AppMethodBeat.i(217570);
    if (this.tiF != null) {
      this.tiF.gey();
    }
    AppMethodBeat.o(217570);
    return false;
  }
  
  private boolean fZd()
  {
    AppMethodBeat.i(217571);
    IllegalStateException localIllegalStateException;
    if (this.tiF == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(217571);
      throw localIllegalStateException;
    }
    if (!this.tiF.gey())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(217571);
      throw localIllegalStateException;
    }
    if ((this.tiF.getAttachedFlutterEngine().MCh.MCT != null) && (this.tiF.getAttachedFlutterEngine().MCh.MCT.equals(this.previousCompletedSplashIsolate)))
    {
      AppMethodBeat.o(217571);
      return true;
    }
    AppMethodBeat.o(217571);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, h paramh)
  {
    AppMethodBeat.i(217568);
    if (this.tiF != null)
    {
      this.tiF.b(this.tiy);
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
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterSplashView", "Showing splash screen UI.", new Object[0]);
        this.Mli = paramh.lH(getContext());
        addView(this.Mli);
        paramFlutterView.a(this.tiy);
        AppMethodBeat.o(217568);
        return;
      }
      fZc();
      if (!paramFlutterView.gey())
      {
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterSplashView", "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.", new Object[0]);
        paramFlutterView.a(this.Mlk);
      }
    }
    AppMethodBeat.o(217568);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(217567);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = SavedState.b(paramParcelable);
    this.splashScreenState = SavedState.c(paramParcelable);
    AppMethodBeat.o(217567);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(217566);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.a(localSavedState, this.previousCompletedSplashIsolate);
    SavedState.a(localSavedState);
    AppMethodBeat.o(217566);
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
      AppMethodBeat.i(217564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(217564);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(217562);
      this.previousCompletedSplashIsolate = paramParcel.readString();
      this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
      AppMethodBeat.o(217562);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(217563);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.previousCompletedSplashIsolate);
      paramParcel.writeBundle(this.splashScreenState);
      AppMethodBeat.o(217563);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.ui.WxaFlutterSplashView
 * JD-Core Version:    0.7.0.1
 */