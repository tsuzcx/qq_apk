package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class WloginSimpleInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WloginSimpleInfo> CREATOR;
  private static final long serialVersionUID = 1L;
  public byte[] _age;
  public byte[] _face;
  public byte[] _gender;
  public byte[] _nick;
  public long _uin;
  
  static
  {
    AppMethodBeat.i(96449);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(96449);
  }
  
  public WloginSimpleInfo()
  {
    AppMethodBeat.i(96451);
    this._uin = 0L;
    this._face = new byte[0];
    this._age = new byte[0];
    this._gender = new byte[0];
    this._nick = new byte[0];
    AppMethodBeat.o(96451);
  }
  
  public WloginSimpleInfo(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    AppMethodBeat.i(96450);
    this._uin = paramLong;
    this._face = ((byte[])paramArrayOfByte1.clone());
    this._age = ((byte[])paramArrayOfByte2.clone());
    this._gender = ((byte[])paramArrayOfByte3.clone());
    this._nick = ((byte[])paramArrayOfByte4.clone());
    AppMethodBeat.o(96450);
  }
  
  private WloginSimpleInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(96454);
    readFromParcel(paramParcel);
    AppMethodBeat.o(96454);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public WloginSimpleInfo get_clone()
  {
    AppMethodBeat.i(96453);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    localWloginSimpleInfo._uin = this._uin;
    localWloginSimpleInfo._face = ((byte[])this._face.clone());
    localWloginSimpleInfo._age = ((byte[])this._age.clone());
    localWloginSimpleInfo._gender = ((byte[])this._gender.clone());
    localWloginSimpleInfo._nick = ((byte[])this._nick.clone());
    AppMethodBeat.o(96453);
    return localWloginSimpleInfo;
  }
  
  public void get_clone(WloginSimpleInfo paramWloginSimpleInfo)
  {
    AppMethodBeat.i(96452);
    this._uin = paramWloginSimpleInfo._uin;
    this._face = ((byte[])paramWloginSimpleInfo._face.clone());
    this._age = ((byte[])paramWloginSimpleInfo._age.clone());
    this._gender = ((byte[])paramWloginSimpleInfo._gender.clone());
    this._nick = ((byte[])paramWloginSimpleInfo._nick.clone());
    AppMethodBeat.o(96452);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96456);
    this._uin = paramParcel.readLong();
    this._face = paramParcel.createByteArray();
    this._age = paramParcel.createByteArray();
    this._gender = paramParcel.createByteArray();
    this._nick = paramParcel.createByteArray();
    AppMethodBeat.o(96456);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96455);
    paramParcel.writeLong(this._uin);
    paramParcel.writeByteArray(this._face);
    paramParcel.writeByteArray(this._age);
    paramParcel.writeByteArray(this._gender);
    paramParcel.writeByteArray(this._nick);
    AppMethodBeat.o(96455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginSimpleInfo
 * JD-Core Version:    0.7.0.1
 */