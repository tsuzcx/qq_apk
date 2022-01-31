package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class WloginSimpleInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WloginSimpleInfo> CREATOR = new Parcelable.Creator() {};
  private static final long serialVersionUID = 1L;
  public byte[] _age;
  public byte[] _face;
  public byte[] _gender;
  public byte[] _nick;
  public long _uin;
  
  public WloginSimpleInfo()
  {
    this._uin = 0L;
    this._face = new byte[0];
    this._age = new byte[0];
    this._gender = new byte[0];
    this._nick = new byte[0];
  }
  
  public WloginSimpleInfo(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this._uin = paramLong;
    this._face = ((byte[])paramArrayOfByte1.clone());
    this._age = ((byte[])paramArrayOfByte2.clone());
    this._gender = ((byte[])paramArrayOfByte3.clone());
    this._nick = ((byte[])paramArrayOfByte4.clone());
  }
  
  private WloginSimpleInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public WloginSimpleInfo get_clone()
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    localWloginSimpleInfo._uin = this._uin;
    localWloginSimpleInfo._face = ((byte[])this._face.clone());
    localWloginSimpleInfo._age = ((byte[])this._age.clone());
    localWloginSimpleInfo._gender = ((byte[])this._gender.clone());
    localWloginSimpleInfo._nick = ((byte[])this._nick.clone());
    return localWloginSimpleInfo;
  }
  
  public void get_clone(WloginSimpleInfo paramWloginSimpleInfo)
  {
    this._uin = paramWloginSimpleInfo._uin;
    this._face = ((byte[])paramWloginSimpleInfo._face.clone());
    this._age = ((byte[])paramWloginSimpleInfo._age.clone());
    this._gender = ((byte[])paramWloginSimpleInfo._gender.clone());
    this._nick = ((byte[])paramWloginSimpleInfo._nick.clone());
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._uin = paramParcel.readLong();
    this._face = paramParcel.createByteArray();
    this._age = paramParcel.createByteArray();
    this._gender = paramParcel.createByteArray();
    this._nick = paramParcel.createByteArray();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this._uin);
    paramParcel.writeByteArray(this._face);
    paramParcel.writeByteArray(this._age);
    paramParcel.writeByteArray(this._gender);
    paramParcel.writeByteArray(this._nick);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginSimpleInfo
 * JD-Core Version:    0.7.0.1
 */