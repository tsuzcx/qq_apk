package com.tencent.wxa.ui;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaFlutterSplashView$SavedState
  extends View.BaseSavedState
{
  public static Parcelable.Creator CREATOR;
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  
  static
  {
    AppMethodBeat.i(206391);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(206391);
  }
  
  WxaFlutterSplashView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(206389);
    this.previousCompletedSplashIsolate = paramParcel.readString();
    this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(206389);
  }
  
  WxaFlutterSplashView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(206390);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.previousCompletedSplashIsolate);
    paramParcel.writeBundle(this.splashScreenState);
    AppMethodBeat.o(206390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wxa.ui.WxaFlutterSplashView.SavedState
 * JD-Core Version:    0.7.0.1
 */