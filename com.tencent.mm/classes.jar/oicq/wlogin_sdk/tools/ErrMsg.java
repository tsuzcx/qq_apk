package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ErrMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ErrMsg> CREATOR = new Parcelable.Creator() {};
  public String message;
  public String title;
  private int type;
  public String xrQ;
  
  public ErrMsg()
  {
    this.type = 0;
    this.title = "";
    this.message = "";
    this.xrQ = "";
  }
  
  private ErrMsg(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.message = paramParcel.readString();
    this.xrQ = paramParcel.readString();
  }
  
  public final void cUJ()
  {
    this.type = 0;
    this.title = "";
    this.message = "";
    this.xrQ = "";
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.message);
    paramParcel.writeString(this.xrQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.ErrMsg
 * JD-Core Version:    0.7.0.1
 */