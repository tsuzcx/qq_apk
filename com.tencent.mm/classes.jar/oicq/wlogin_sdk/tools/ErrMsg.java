package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ErrMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ErrMsg> CREATOR;
  public String UdY;
  public String message;
  public String title;
  private int type;
  
  static
  {
    AppMethodBeat.i(88192);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(88192);
  }
  
  public ErrMsg()
  {
    this.type = 0;
    this.title = "";
    this.message = "";
    this.UdY = "";
  }
  
  private ErrMsg(Parcel paramParcel)
  {
    AppMethodBeat.i(88194);
    this.type = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.message = paramParcel.readString();
    this.UdY = paramParcel.readString();
    AppMethodBeat.o(88194);
  }
  
  public Object clone()
  {
    AppMethodBeat.i(88193);
    Object localObject = super.clone();
    AppMethodBeat.o(88193);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void hPF()
  {
    this.type = 0;
    this.title = "";
    this.message = "";
    this.UdY = "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88195);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.message);
    paramParcel.writeString(this.UdY);
    AppMethodBeat.o(88195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.ErrMsg
 * JD-Core Version:    0.7.0.1
 */