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
import io.flutter.embedding.android.g;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;

public class WxaFlutterSplashView
  extends FrameLayout
{
  private g Kvg;
  private View Kvh;
  private Bundle Kvi;
  private String Kvj;
  private String Kvk;
  private final FlutterView.a Kvl;
  private final Runnable Kvm;
  private final b slV;
  private FlutterView smb;
  
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
    AppMethodBeat.i(191768);
    this.Kvl = new FlutterView.a()
    {
      public final void fHN()
      {
        AppMethodBeat.i(191761);
        WxaFlutterSplashView.a(WxaFlutterSplashView.this).b(this);
        WxaFlutterSplashView.this.a(WxaFlutterSplashView.a(WxaFlutterSplashView.this), WxaFlutterSplashView.b(WxaFlutterSplashView.this));
        AppMethodBeat.o(191761);
      }
    };
    this.slV = new b()
    {
      public final void cHX()
      {
        AppMethodBeat.i(191762);
        if (WxaFlutterSplashView.b(WxaFlutterSplashView.this) != null) {
          WxaFlutterSplashView.c(WxaFlutterSplashView.this);
        }
        AppMethodBeat.o(191762);
      }
      
      public final void cHY() {}
    };
    this.Kvm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191763);
        WxaFlutterSplashView.this.removeView(WxaFlutterSplashView.d(WxaFlutterSplashView.this));
        WxaFlutterSplashView.a(WxaFlutterSplashView.this, WxaFlutterSplashView.e(WxaFlutterSplashView.this));
        AppMethodBeat.o(191763);
      }
    };
    setSaveEnabled(true);
    AppMethodBeat.o(191768);
  }
  
  private boolean fHK()
  {
    AppMethodBeat.i(191772);
    if ((this.smb != null) && (this.smb.fMY()) && (!this.smb.KKU) && (!fHM()))
    {
      AppMethodBeat.o(191772);
      return true;
    }
    AppMethodBeat.o(191772);
    return false;
  }
  
  private boolean fHL()
  {
    AppMethodBeat.i(191773);
    if (this.smb != null) {
      this.smb.fMY();
    }
    AppMethodBeat.o(191773);
    return false;
  }
  
  private boolean fHM()
  {
    AppMethodBeat.i(191774);
    IllegalStateException localIllegalStateException;
    if (this.smb == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(191774);
      throw localIllegalStateException;
    }
    if (!this.smb.fMY())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(191774);
      throw localIllegalStateException;
    }
    if ((this.smb.getAttachedFlutterEngine().KLk.KLW != null) && (this.smb.getAttachedFlutterEngine().KLk.KLW.equals(this.Kvk)))
    {
      AppMethodBeat.o(191774);
      return true;
    }
    AppMethodBeat.o(191774);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, g paramg)
  {
    AppMethodBeat.i(191771);
    if (this.smb != null)
    {
      this.smb.b(this.slV);
      removeView(this.smb);
    }
    if (this.Kvh != null) {
      removeView(this.Kvh);
    }
    this.smb = paramFlutterView;
    addView(paramFlutterView);
    this.Kvg = paramg;
    if (paramg != null)
    {
      if (fHK())
      {
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterSplashView", "Showing splash screen UI.", new Object[0]);
        this.Kvh = paramg.lv(getContext());
        addView(this.Kvh);
        paramFlutterView.a(this.slV);
        AppMethodBeat.o(191771);
        return;
      }
      fHL();
      if (!paramFlutterView.fMY())
      {
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterSplashView", "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.", new Object[0]);
        paramFlutterView.a(this.Kvl);
      }
    }
    AppMethodBeat.o(191771);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(191770);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Kvk = SavedState.b(paramParcelable);
    this.Kvi = SavedState.c(paramParcelable);
    AppMethodBeat.o(191770);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(191769);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.a(localSavedState, this.Kvk);
    SavedState.a(localSavedState);
    AppMethodBeat.o(191769);
    return localSavedState;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator CREATOR;
    private Bundle Kvi;
    private String Kvk;
    
    static
    {
      AppMethodBeat.i(191767);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(191767);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(191765);
      this.Kvk = paramParcel.readString();
      this.Kvi = paramParcel.readBundle(getClass().getClassLoader());
      AppMethodBeat.o(191765);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(191766);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.Kvk);
      paramParcel.writeBundle(this.Kvi);
      AppMethodBeat.o(191766);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.ui.WxaFlutterSplashView
 * JD-Core Version:    0.7.0.1
 */