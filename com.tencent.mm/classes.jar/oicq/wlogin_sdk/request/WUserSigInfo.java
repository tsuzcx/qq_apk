package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(96425);
    byte[] arrayOfByte;
    if (paramWloginSigInfo._userStSig == null)
    {
      arrayOfByte = new byte[0];
      this._userStSig = arrayOfByte;
      if (paramWloginSigInfo._userSt_Key != null) {
        break label329;
      }
      arrayOfByte = new byte[0];
      label32:
      this._userSt_Key = arrayOfByte;
      if (paramWloginSigInfo._userStWebSig != null) {
        break label343;
      }
      arrayOfByte = new byte[0];
      label48:
      this._userStWebSig = arrayOfByte;
      if (paramWloginSigInfo._en_A1 != null) {
        break label357;
      }
      arrayOfByte = new byte[0];
      label64:
      this._userPasswdSig = arrayOfByte;
      if (paramWloginSigInfo._userA5 != null) {
        break label371;
      }
      arrayOfByte = new byte[0];
      label80:
      this._userA5 = arrayOfByte;
      if (paramWloginSigInfo._userA8 != null) {
        break label385;
      }
      arrayOfByte = new byte[0];
      label96:
      this._userA8 = arrayOfByte;
      if (paramWloginSigInfo._lsKey != null) {
        break label399;
      }
      arrayOfByte = new byte[0];
      label112:
      this._lsKey = arrayOfByte;
      if (paramWloginSigInfo._sKey != null) {
        break label413;
      }
      arrayOfByte = new byte[0];
      label128:
      this._sKey = arrayOfByte;
      if (paramWloginSigInfo._userSig64 != null) {
        break label427;
      }
      arrayOfByte = new byte[0];
      label144:
      this._userSig64 = arrayOfByte;
      if (paramWloginSigInfo._openid != null) {
        break label441;
      }
      arrayOfByte = new byte[0];
      label160:
      this._openid = arrayOfByte;
      if (paramWloginSigInfo._openkey != null) {
        break label455;
      }
      arrayOfByte = new byte[0];
      label176:
      this._openkey = arrayOfByte;
      if (paramWloginSigInfo._vkey != null) {
        break label469;
      }
      arrayOfByte = new byte[0];
      label192:
      this._vkey = arrayOfByte;
      if (paramWloginSigInfo._TGT != null) {
        break label483;
      }
      arrayOfByte = new byte[0];
      label208:
      this._A2 = arrayOfByte;
      if (paramWloginSigInfo._TGTKey != null) {
        break label497;
      }
      arrayOfByte = new byte[0];
      label224:
      this._A2_Key = arrayOfByte;
      if (paramWloginSigInfo._access_token != null) {
        break label511;
      }
      arrayOfByte = new byte[0];
      label240:
      this._access_token = arrayOfByte;
      if (paramWloginSigInfo._D2 != null) {
        break label525;
      }
      arrayOfByte = new byte[0];
      label256:
      this._D2 = arrayOfByte;
      if (paramWloginSigInfo._D2Key != null) {
        break label539;
      }
      arrayOfByte = new byte[0];
      label272:
      this._D2_Key = arrayOfByte;
      if (paramWloginSigInfo._sid != null) {
        break label553;
      }
      arrayOfByte = new byte[0];
      label288:
      this._sid = arrayOfByte;
      if (paramWloginSigInfo._noPicSig != null) {
        break label567;
      }
    }
    label385:
    label399:
    label413:
    label427:
    label567:
    for (paramWloginSigInfo = new byte[0];; paramWloginSigInfo = (byte[])paramWloginSigInfo._noPicSig.clone())
    {
      this._noPicSig = paramWloginSigInfo;
      AppMethodBeat.o(96425);
      return;
      arrayOfByte = (byte[])paramWloginSigInfo._userStSig.clone();
      break;
      label329:
      arrayOfByte = (byte[])paramWloginSigInfo._userSt_Key.clone();
      break label32;
      label343:
      arrayOfByte = (byte[])paramWloginSigInfo._userStWebSig.clone();
      break label48;
      label357:
      arrayOfByte = (byte[])paramWloginSigInfo._en_A1.clone();
      break label64;
      label371:
      arrayOfByte = (byte[])paramWloginSigInfo._userA5.clone();
      break label80;
      arrayOfByte = (byte[])paramWloginSigInfo._userA8.clone();
      break label96;
      arrayOfByte = (byte[])paramWloginSigInfo._lsKey.clone();
      break label112;
      arrayOfByte = (byte[])paramWloginSigInfo._sKey.clone();
      break label128;
      arrayOfByte = (byte[])paramWloginSigInfo._userSig64.clone();
      break label144;
      label441:
      arrayOfByte = (byte[])paramWloginSigInfo._openid.clone();
      break label160;
      label455:
      arrayOfByte = (byte[])paramWloginSigInfo._openkey.clone();
      break label176;
      label469:
      arrayOfByte = (byte[])paramWloginSigInfo._vkey.clone();
      break label192;
      label483:
      arrayOfByte = (byte[])paramWloginSigInfo._TGT.clone();
      break label208;
      label497:
      arrayOfByte = (byte[])paramWloginSigInfo._TGTKey.clone();
      break label224;
      label511:
      arrayOfByte = (byte[])paramWloginSigInfo._access_token.clone();
      break label240;
      arrayOfByte = (byte[])paramWloginSigInfo._D2.clone();
      break label256;
      arrayOfByte = (byte[])paramWloginSigInfo._D2Key.clone();
      break label272;
      arrayOfByte = (byte[])paramWloginSigInfo._sid.clone();
      break label288;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WUserSigInfo
 * JD-Core Version:    0.7.0.1
 */