package com.tencent.tmassistantsdk.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class IPCPackageTools
{
  protected static final String CHILD_NAME = ".jce.";
  static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
  private static final String TAG = "IPCPackageTools";
  protected static int mReqId = 0;
  
  public static IPCRequest buildIpcRequest(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(75972);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(75972);
      return null;
    }
    IPCRequest localIPCRequest = new IPCRequest();
    IPCHead localIPCHead = new IPCHead();
    int i = mReqId;
    mReqId = i + 1;
    localIPCHead.requestId = i;
    localIPCHead.cmdId = getCmdId(paramJceStruct);
    localIPCHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    localIPCHead.hostVersionCode = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
    localIPCRequest.head = localIPCHead;
    localIPCRequest.body = jceStruct2ByteArray(paramJceStruct);
    AppMethodBeat.o(75972);
    return localIPCRequest;
  }
  
  public static byte[] buildPostData(IPCRequest paramIPCRequest)
  {
    AppMethodBeat.i(75973);
    if (paramIPCRequest == null)
    {
      AppMethodBeat.o(75973);
      return null;
    }
    paramIPCRequest.body = ProtocolPackage.encrypt(paramIPCRequest.body, "ji*9^&43U0X-~./(".getBytes());
    paramIPCRequest = jceStruct2ByteArray(paramIPCRequest);
    AppMethodBeat.o(75973);
    return paramIPCRequest;
  }
  
  private static JceStruct createFromRequest(String paramString)
  {
    AppMethodBeat.i(75976);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(75976);
      return null;
    }
    paramString = IPCPackageTools.class.getPackage().getName() + ".jce." + paramString;
    paramString = paramString + "Response";
    try
    {
      paramString = (JceStruct)Class.forName(paramString).newInstance();
      AppMethodBeat.o(75976);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("IPCPackageTools", paramString, "", new Object[0]);
        paramString = null;
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("IPCPackageTools", paramString, "", new Object[0]);
        paramString = null;
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("IPCPackageTools", paramString, "", new Object[0]);
        paramString = null;
      }
    }
  }
  
  public static int getCmdId(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(75971);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(75971);
      return -1;
    }
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    int i = IPCCmd.convert(paramJceStruct.substring(0, paramJceStruct.length() - 7)).value();
    AppMethodBeat.o(75971);
    return i;
  }
  
  public static byte[] jceStruct2ByteArray(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(75977);
    paramJceStruct = ProtocolPackage.jceStructToUTF8Byte(paramJceStruct);
    AppMethodBeat.o(75977);
    return paramJceStruct;
  }
  
  public static JceStruct unpackBodyStruct(IPCResponse paramIPCResponse)
  {
    AppMethodBeat.i(75975);
    JceStruct localJceStruct = createFromRequest(IPCCmd.convert(paramIPCResponse.head.cmdId).toString());
    if ((localJceStruct != null) && (paramIPCResponse.body.length > 0)) {
      try
      {
        paramIPCResponse = new JceInputStream(paramIPCResponse.body);
        paramIPCResponse.setServerEncoding("utf-8");
        localJceStruct.readFrom(paramIPCResponse);
        AppMethodBeat.o(75975);
        return localJceStruct;
      }
      catch (Exception paramIPCResponse)
      {
        ab.printErrStackTrace("IPCPackageTools", paramIPCResponse, "", new Object[0]);
        AppMethodBeat.o(75975);
        return null;
      }
    }
    AppMethodBeat.o(75975);
    return null;
  }
  
  public static IPCResponse unpackPackage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75974);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4))
    {
      AppMethodBeat.o(75974);
      return null;
    }
    IPCResponse localIPCResponse = new IPCResponse();
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      localIPCResponse.readFrom(paramArrayOfByte);
      if (!TextUtils.isEmpty(localIPCResponse.head.hostPackageName)) {
        localIPCResponse.body = ProtocolPackage.decrypt(localIPCResponse.body, "ji*9^&43U0X-~./(".getBytes());
      }
      AppMethodBeat.o(75974);
      return localIPCResponse;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.printErrStackTrace("IPCPackageTools", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(75974);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.IPCPackageTools
 * JD-Core Version:    0.7.0.1
 */