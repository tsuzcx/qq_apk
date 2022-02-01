package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class WloginAllSigInfo
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  public TreeMap<Long, WloginSigInfo> _tk_map;
  public long _uin;
  public WloginSimpleInfo _useInfo;
  
  public WloginAllSigInfo()
  {
    AppMethodBeat.i(88078);
    this._useInfo = new WloginSimpleInfo();
    this._tk_map = new TreeMap();
    this._uin = 0L;
    AppMethodBeat.o(88078);
  }
  
  public WloginAllSigInfo get_clone()
  {
    AppMethodBeat.i(88079);
    try
    {
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)clone();
      AppMethodBeat.o(88079);
      return localWloginAllSigInfo;
    }
    catch (Exception localException)
    {
      util.LOGD(localException.toString());
      AppMethodBeat.o(88079);
    }
    return null;
  }
  
  public int put_siginfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte)
  {
    AppMethodBeat.i(88077);
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(new Long(paramLong1));
    if (localWloginSigInfo != null) {
      this._tk_map.put(new Long(paramLong1), localWloginSigInfo.Set(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte));
    }
    for (;;)
    {
      AppMethodBeat.o(88077);
      return 0;
      this._tk_map.put(new Long(paramLong1), new WloginSigInfo(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WloginAllSigInfo
 * JD-Core Version:    0.7.0.1
 */