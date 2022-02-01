package io.flutter.embedding.android;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.view.View.BaseSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class FlutterSplashView$SavedState
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
  
  FlutterSplashView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(9964);
    this.previousCompletedSplashIsolate = paramParcel.readString();
    this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(9964);
  }
  
  FlutterSplashView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView.SavedState
 * JD-Core Version:    0.7.0.1
 */