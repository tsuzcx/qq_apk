package oicq.wlogin_sdk.request;

import java.io.Serializable;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;

public class WUserSigInfo
  implements Serializable
{
  static final long serialVersionUID = 0L;
  public byte[] _A2;
  public byte[] _A2_Key;
  public byte[] _D2;
  public byte[] _D2_Key;
  public byte[] _access_token;
  public byte[] _in_ksid;
  public byte[] _lsKey;
  public byte[] _noPicSig;
  public byte[] _openid;
  public byte[] _openkey;
  public byte[] _reserveData;
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
  
  public void get_clone(WloginSigInfo paramWloginSigInfo)
  {
    byte[] arrayOfByte;
    if (paramWloginSigInfo._userStSig == null)
    {
      arrayOfByte = new byte[0];
      this._userStSig = arrayOfByte;
      if (paramWloginSigInfo._userSt_Key != null) {
        break label319;
      }
      arrayOfByte = new byte[0];
      label27:
      this._userSt_Key = arrayOfByte;
      if (paramWloginSigInfo._userStWebSig != null) {
        break label333;
      }
      arrayOfByte = new byte[0];
      label43:
      this._userStWebSig = arrayOfByte;
      if (paramWloginSigInfo._en_A1 != null) {
        break label347;
      }
      arrayOfByte = new byte[0];
      label59:
      this._userPasswdSig = arrayOfByte;
      if (paramWloginSigInfo._userA5 != null) {
        break label361;
      }
      arrayOfByte = new byte[0];
      label75:
      this._userA5 = arrayOfByte;
      if (paramWloginSigInfo._userA8 != null) {
        break label375;
      }
      arrayOfByte = new byte[0];
      label91:
      this._userA8 = arrayOfByte;
      if (paramWloginSigInfo._lsKey != null) {
        break label389;
      }
      arrayOfByte = new byte[0];
      label107:
      this._lsKey = arrayOfByte;
      if (paramWloginSigInfo._sKey != null) {
        break label403;
      }
      arrayOfByte = new byte[0];
      label123:
      this._sKey = arrayOfByte;
      if (paramWloginSigInfo._userSig64 != null) {
        break label417;
      }
      arrayOfByte = new byte[0];
      label139:
      this._userSig64 = arrayOfByte;
      if (paramWloginSigInfo._openid != null) {
        break label431;
      }
      arrayOfByte = new byte[0];
      label155:
      this._openid = arrayOfByte;
      if (paramWloginSigInfo._openkey != null) {
        break label445;
      }
      arrayOfByte = new byte[0];
      label171:
      this._openkey = arrayOfByte;
      if (paramWloginSigInfo._vkey != null) {
        break label459;
      }
      arrayOfByte = new byte[0];
      label187:
      this._vkey = arrayOfByte;
      if (paramWloginSigInfo._TGT != null) {
        break label473;
      }
      arrayOfByte = new byte[0];
      label203:
      this._A2 = arrayOfByte;
      if (paramWloginSigInfo._TGTKey != null) {
        break label487;
      }
      arrayOfByte = new byte[0];
      label219:
      this._A2_Key = arrayOfByte;
      if (paramWloginSigInfo._access_token != null) {
        break label501;
      }
      arrayOfByte = new byte[0];
      label235:
      this._access_token = arrayOfByte;
      if (paramWloginSigInfo._D2 != null) {
        break label515;
      }
      arrayOfByte = new byte[0];
      label251:
      this._D2 = arrayOfByte;
      if (paramWloginSigInfo._D2Key != null) {
        break label529;
      }
      arrayOfByte = new byte[0];
      label267:
      this._D2_Key = arrayOfByte;
      if (paramWloginSigInfo._sid != null) {
        break label543;
      }
      arrayOfByte = new byte[0];
      label283:
      this._sid = arrayOfByte;
      if (paramWloginSigInfo._noPicSig != null) {
        break label557;
      }
    }
    label389:
    label403:
    label417:
    label557:
    for (paramWloginSigInfo = new byte[0];; paramWloginSigInfo = (byte[])paramWloginSigInfo._noPicSig.clone())
    {
      this._noPicSig = paramWloginSigInfo;
      return;
      arrayOfByte = (byte[])paramWloginSigInfo._userStSig.clone();
      break;
      label319:
      arrayOfByte = (byte[])paramWloginSigInfo._userSt_Key.clone();
      break label27;
      label333:
      arrayOfByte = (byte[])paramWloginSigInfo._userStWebSig.clone();
      break label43;
      label347:
      arrayOfByte = (byte[])paramWloginSigInfo._en_A1.clone();
      break label59;
      label361:
      arrayOfByte = (byte[])paramWloginSigInfo._userA5.clone();
      break label75;
      label375:
      arrayOfByte = (byte[])paramWloginSigInfo._userA8.clone();
      break label91;
      arrayOfByte = (byte[])paramWloginSigInfo._lsKey.clone();
      break label107;
      arrayOfByte = (byte[])paramWloginSigInfo._sKey.clone();
      break label123;
      arrayOfByte = (byte[])paramWloginSigInfo._userSig64.clone();
      break label139;
      label431:
      arrayOfByte = (byte[])paramWloginSigInfo._openid.clone();
      break label155;
      label445:
      arrayOfByte = (byte[])paramWloginSigInfo._openkey.clone();
      break label171;
      label459:
      arrayOfByte = (byte[])paramWloginSigInfo._vkey.clone();
      break label187;
      label473:
      arrayOfByte = (byte[])paramWloginSigInfo._TGT.clone();
      break label203;
      label487:
      arrayOfByte = (byte[])paramWloginSigInfo._TGTKey.clone();
      break label219;
      label501:
      arrayOfByte = (byte[])paramWloginSigInfo._access_token.clone();
      break label235;
      arrayOfByte = (byte[])paramWloginSigInfo._D2.clone();
      break label251;
      arrayOfByte = (byte[])paramWloginSigInfo._D2Key.clone();
      break label267;
      arrayOfByte = (byte[])paramWloginSigInfo._sid.clone();
      break label283;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WUserSigInfo
 * JD-Core Version:    0.7.0.1
 */