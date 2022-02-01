package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class WloginLoginInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WloginLoginInfo> CREATOR;
  public static int TYPE_LOACL = 0;
  public static int TYPE_REMOTE = 0;
  private static final long serialVersionUID = 5551948389726789420L;
  public String mAccount;
  public long mAppid;
  public long mCreateTime;
  public int mType;
  public long mUin;
  
  static
  {
    AppMethodBeat.i(88097);
    TYPE_LOACL = 1;
    TYPE_REMOTE = 2;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(88097);
  }
  
  private WloginLoginInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(88098);
    readFromParcel(paramParcel);
    AppMethodBeat.o(88098);
  }
  
  public WloginLoginInfo(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    this.mAccount = paramString;
    this.mUin = paramLong1;
    this.mAppid = paramLong2;
    this.mCreateTime = paramLong3;
    this.mType = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(88100);
    this.mAccount = paramParcel.readString();
    this.mUin = paramParcel.readLong();
    this.mAppid = paramParcel.readLong();
    this.mCreateTime = paramParcel.readLong();
    this.mType = paramParcel.readInt();
    AppMethodBeat.o(88100);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88099);
    paramParcel.writeString(this.mAccount);
    paramParcel.writeLong(this.mUin);
    paramParcel.writeLong(this.mAppid);
    paramParcel.writeLong(this.mCreateTime);
    paramParcel.writeInt(this.mType);
    AppMethodBeat.o(88099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginLoginInfo
 * JD-Core Version:    0.7.0.1
 */