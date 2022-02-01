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

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private final b KKx;
  private g Kvg;
  private View Kvh;
  private Bundle Kvi;
  private String Kvj;
  private String Kvk;
  private final FlutterView.a Kvl;
  private final Runnable Kvm;
  private FlutterView smb;
  
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
    this.Kvl = new FlutterView.a()
    {
      public final void fHN()
      {
        AppMethodBeat.i(10025);
        FlutterSplashView.a(FlutterSplashView.this).b(this);
        FlutterSplashView.this.a(FlutterSplashView.a(FlutterSplashView.this), FlutterSplashView.b(FlutterSplashView.this));
        AppMethodBeat.o(10025);
      }
    };
    this.KKx = new b()
    {
      public final void cHX()
      {
        AppMethodBeat.i(192896);
        if (FlutterSplashView.b(FlutterSplashView.this) != null) {
          FlutterSplashView.c(FlutterSplashView.this);
        }
        AppMethodBeat.o(192896);
      }
      
      public final void cHY() {}
    };
    this.Kvm = new Runnable()
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
  
  private boolean fHK()
  {
    AppMethodBeat.i(10064);
    if ((this.smb != null) && (this.smb.fMY()) && (!this.smb.KKU) && (!fHM()))
    {
      AppMethodBeat.o(10064);
      return true;
    }
    AppMethodBeat.o(10064);
    return false;
  }
  
  private boolean fHL()
  {
    AppMethodBeat.i(192850);
    if (this.smb != null) {
      this.smb.fMY();
    }
    AppMethodBeat.o(192850);
    return false;
  }
  
  private boolean fHM()
  {
    AppMethodBeat.i(10065);
    IllegalStateException localIllegalStateException;
    if (this.smb == null)
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if (!this.smb.fMY())
    {
      localIllegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
      AppMethodBeat.o(10065);
      throw localIllegalStateException;
    }
    if ((this.smb.getAttachedFlutterEngine().KLk.KLW != null) && (this.smb.getAttachedFlutterEngine().KLk.KLW.equals(this.Kvk)))
    {
      AppMethodBeat.o(10065);
      return true;
    }
    AppMethodBeat.o(10065);
    return false;
  }
  
  public final void a(FlutterView paramFlutterView, g paramg)
  {
    AppMethodBeat.i(10063);
    if (this.smb != null)
    {
      this.smb.b(this.KKx);
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
        io.flutter.a.fMD();
        this.Kvh = paramg.lv(getContext());
        addView(this.Kvh);
        paramFlutterView.a(this.KKx);
        AppMethodBeat.o(10063);
        return;
      }
      fHL();
      if (!paramFlutterView.fMY())
      {
        io.flutter.a.fMD();
        paramFlutterView.a(this.Kvl);
      }
    }
    AppMethodBeat.o(10063);
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(10062);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Kvk = SavedState.b(paramParcelable);
    this.Kvi = SavedState.c(paramParcelable);
    AppMethodBeat.o(10062);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(10061);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.a(localSavedState, this.Kvk);
    SavedState.a(localSavedState);
    AppMethodBeat.o(10061);
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
      AppMethodBeat.i(9966);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(9966);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(9964);
      this.Kvk = paramParcel.readString();
      this.Kvi = paramParcel.readBundle(getClass().getClassLoader());
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
      paramParcel.writeString(this.Kvk);
      paramParcel.writeBundle(this.Kvi);
      AppMethodBeat.o(9965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */