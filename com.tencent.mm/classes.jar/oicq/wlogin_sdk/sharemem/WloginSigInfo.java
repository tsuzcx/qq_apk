package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class WloginSigInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WloginSigInfo> CREATOR = new Parcelable.Creator() {};
  private static final long serialVersionUID = 1L;
  public long _A2_expire_time = 0L;
  public byte[] _D2;
  public byte[] _D2Key;
  public byte[] _TGT;
  public byte[] _TGTKey;
  public byte[] _access_token;
  public long _app_pri = 0L;
  public long _create_time = 0L;
  public byte[] _en_A1;
  public long _expire_time = 0L;
  public byte[] _lsKey;
  public byte[] _noPicSig;
  public byte[] _openid;
  public byte[] _openkey;
  public long _ret_appid = 0L;
  public byte[] _sKey;
  public byte[] _sid;
  public byte[] _userA5;
  public byte[] _userA8;
  public byte[] _userPasswdSig;
  public byte[] _userSig64;
  public byte[] _userStSig;
  public byte[] _userStWebSig;
  public byte[] _userSt_Key;
  public byte[] _vkey;
  
  public WloginSigInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte)
  {
    this._app_pri = paramLong1;
    this._create_time = paramLong2;
    this._expire_time = paramLong3;
    this._A2_expire_time = paramLong4;
    this._TGT = ((byte[])paramArrayOfByte1.clone());
    this._TGTKey = ((byte[])paramArrayOfByte2.clone());
    this._userStSig = ((byte[])paramArrayOfByte3.clone());
    this._userSt_Key = ((byte[])paramArrayOfByte4.clone());
    if (paramArrayOfByte5 != null)
    {
      this._userStWebSig = ((byte[])paramArrayOfByte5.clone());
      this._userPasswdSig = new byte[0];
      if (paramArrayOfByte6 == null) {
        break label365;
      }
      this._userA5 = ((byte[])paramArrayOfByte6.clone());
      label140:
      if (paramArrayOfByte7 == null) {
        break label375;
      }
      this._userA8 = ((byte[])paramArrayOfByte7.clone());
      label157:
      if (paramArrayOfByte8 == null) {
        break label385;
      }
      this._lsKey = ((byte[])paramArrayOfByte8.clone());
      label174:
      if (paramArrayOfByte9 == null) {
        break label395;
      }
      this._sKey = ((byte[])paramArrayOfByte9.clone());
      label191:
      if (paramArrayOfByte10 == null) {
        break label405;
      }
      this._userSig64 = ((byte[])paramArrayOfByte10.clone());
      label208:
      if (paramArrayOfByte11 == null) {
        break label415;
      }
      this._openid = ((byte[])paramArrayOfByte11.clone());
      label225:
      if (paramArrayOfByte12 == null) {
        break label425;
      }
    }
    label385:
    label395:
    label405:
    label415:
    label425:
    for (this._openkey = ((byte[])paramArrayOfByte12.clone());; this._openkey = new byte[0])
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 7)) {
        break label435;
      }
      this._vkey = ((byte[])paramArrayOfByte[0].clone());
      this._en_A1 = ((byte[])paramArrayOfByte[1].clone());
      this._access_token = ((byte[])paramArrayOfByte[2].clone());
      this._D2 = ((byte[])paramArrayOfByte[3].clone());
      this._D2Key = ((byte[])paramArrayOfByte[4].clone());
      this._sid = ((byte[])paramArrayOfByte[5].clone());
      this._noPicSig = ((byte[])paramArrayOfByte[6].clone());
      return;
      this._userStWebSig = new byte[0];
      break;
      label365:
      this._userA5 = new byte[0];
      break label140;
      label375:
      this._userA8 = new byte[0];
      break label157;
      this._lsKey = new byte[0];
      break label174;
      this._sKey = new byte[0];
      break label191;
      this._userSig64 = new byte[0];
      break label208;
      this._openid = new byte[0];
      break label225;
    }
    label435:
    this._vkey = new byte[0];
    this._en_A1 = new byte[0];
    this._access_token = new byte[0];
    this._D2 = new byte[0];
    this._D2Key = new byte[0];
    this._sid = new byte[0];
    this._noPicSig = new byte[0];
  }
  
  private WloginSigInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public WloginSigInfo Set(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte)
  {
    this._app_pri = paramLong1;
    this._create_time = paramLong2;
    this._expire_time = paramLong3;
    this._A2_expire_time = paramLong4;
    this._TGT = ((byte[])paramArrayOfByte1.clone());
    this._TGTKey = ((byte[])paramArrayOfByte2.clone());
    this._userStSig = ((byte[])paramArrayOfByte3.clone());
    this._userSt_Key = ((byte[])paramArrayOfByte4.clone());
    if (paramArrayOfByte5 != null)
    {
      this._userStWebSig = ((byte[])paramArrayOfByte5.clone());
      this._userPasswdSig = new byte[0];
      if (paramArrayOfByte6 == null) {
        break label378;
      }
      this._userA5 = ((byte[])paramArrayOfByte6.clone());
      label111:
      if (paramArrayOfByte7 == null) {
        break label388;
      }
      this._userA8 = ((byte[])paramArrayOfByte7.clone());
      label128:
      if (paramArrayOfByte8 == null) {
        break label398;
      }
      this._lsKey = ((byte[])paramArrayOfByte8.clone());
      label145:
      if (paramArrayOfByte9 == null) {
        break label408;
      }
      this._sKey = ((byte[])paramArrayOfByte9.clone());
      label162:
      if (paramArrayOfByte10 == null) {
        break label418;
      }
      this._userSig64 = ((byte[])paramArrayOfByte10.clone());
      label179:
      if (paramArrayOfByte11 == null) {
        break label428;
      }
      this._openid = ((byte[])paramArrayOfByte11.clone());
      label196:
      if (paramArrayOfByte12 == null) {
        break label438;
      }
      this._openkey = ((byte[])paramArrayOfByte12.clone());
      label213:
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 7)) {
        break label458;
      }
      this._vkey = ((byte[])paramArrayOfByte[0].clone());
      if ((paramArrayOfByte[1].clone() != null) && (((byte[])paramArrayOfByte[1].clone()).length > 0))
      {
        this._en_A1 = ((byte[])paramArrayOfByte[1].clone());
        if ((paramArrayOfByte[6] == null) || (paramArrayOfByte[6].length <= 0)) {
          break label448;
        }
      }
    }
    label388:
    label398:
    label408:
    label418:
    label428:
    label438:
    label448:
    for (this._noPicSig = ((byte[])paramArrayOfByte[6].clone());; this._noPicSig = new byte[0])
    {
      this._access_token = ((byte[])paramArrayOfByte[2].clone());
      this._D2 = ((byte[])paramArrayOfByte[3].clone());
      this._D2Key = ((byte[])paramArrayOfByte[4].clone());
      this._sid = ((byte[])paramArrayOfByte[5].clone());
      return this;
      this._userStWebSig = new byte[0];
      break;
      label378:
      this._userA5 = new byte[0];
      break label111;
      this._userA8 = new byte[0];
      break label128;
      this._lsKey = new byte[0];
      break label145;
      this._sKey = new byte[0];
      break label162;
      this._userSig64 = new byte[0];
      break label179;
      this._openid = new byte[0];
      break label196;
      this._openkey = new byte[0];
      break label213;
    }
    label458:
    this._vkey = new byte[0];
    this._access_token = new byte[0];
    this._D2 = new byte[0];
    this._D2Key = new byte[0];
    this._sid = new byte[0];
    this._noPicSig = new byte[0];
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._TGT = paramParcel.createByteArray();
    this._TGTKey = paramParcel.createByteArray();
    this._userStSig = paramParcel.createByteArray();
    this._userSt_Key = paramParcel.createByteArray();
    this._userStWebSig = paramParcel.createByteArray();
    this._userPasswdSig = paramParcel.createByteArray();
    this._userA5 = paramParcel.createByteArray();
    this._userA8 = paramParcel.createByteArray();
    this._lsKey = paramParcel.createByteArray();
    this._sKey = paramParcel.createByteArray();
    this._userSig64 = paramParcel.createByteArray();
    this._openid = paramParcel.createByteArray();
    this._openkey = paramParcel.createByteArray();
    this._vkey = paramParcel.createByteArray();
    this._en_A1 = paramParcel.createByteArray();
    this._access_token = paramParcel.createByteArray();
    this._D2 = paramParcel.createByteArray();
    this._D2Key = paramParcel.createByteArray();
    this._sid = paramParcel.createByteArray();
    this._noPicSig = paramParcel.createByteArray();
    this._expire_time = paramParcel.readLong();
    this._A2_expire_time = paramParcel.readLong();
    this._create_time = paramParcel.readLong();
    this._app_pri = paramParcel.readLong();
    this._ret_appid = paramParcel.readLong();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this._TGT);
    paramParcel.writeByteArray(this._TGTKey);
    paramParcel.writeByteArray(this._userStSig);
    paramParcel.writeByteArray(this._userSt_Key);
    paramParcel.writeByteArray(this._userStWebSig);
    paramParcel.writeByteArray(this._userPasswdSig);
    paramParcel.writeByteArray(this._userA5);
    paramParcel.writeByteArray(this._userA8);
    paramParcel.writeByteArray(this._lsKey);
    paramParcel.writeByteArray(this._sKey);
    paramParcel.writeByteArray(this._userSig64);
    paramParcel.writeByteArray(this._openid);
    paramParcel.writeByteArray(this._openkey);
    paramParcel.writeByteArray(this._vkey);
    paramParcel.writeByteArray(this._en_A1);
    paramParcel.writeByteArray(this._access_token);
    paramParcel.writeByteArray(this._D2);
    paramParcel.writeByteArray(this._D2Key);
    paramParcel.writeByteArray(this._sid);
    paramParcel.writeByteArray(this._noPicSig);
    paramParcel.writeLong(this._expire_time);
    paramParcel.writeLong(this._A2_expire_time);
    paramParcel.writeLong(this._create_time);
    paramParcel.writeLong(this._app_pri);
    paramParcel.writeLong(this._ret_appid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginSigInfo
 * JD-Core Version:    0.7.0.1
 */