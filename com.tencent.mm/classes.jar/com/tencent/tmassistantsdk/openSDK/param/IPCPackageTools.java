package com.tencent.tmassistantsdk.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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
    AppMethodBeat.i(102218);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(102218);
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
    AppMethodBeat.o(102218);
    return localIPCRequest;
  }
  
  public static byte[] buildPostData(IPCRequest paramIPCRequest)
  {
    AppMethodBeat.i(102219);
    if (paramIPCRequest == null)
    {
      AppMethodBeat.o(102219);
      return null;
    }
    paramIPCRequest.body = ProtocolPackage.encrypt(paramIPCRequest.body, "ji*9^&43U0X-~./(".getBytes());
    paramIPCRequest = jceStruct2ByteArray(paramIPCRequest);
    AppMethodBeat.o(102219);
    return paramIPCRequest;
  }
  
  private static JceStruct createFromRequest(String paramString)
  {
    AppMethodBeat.i(102222);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(102222);
      return null;
    }
    paramString = IPCPackageTools.class.getPackage().getName() + ".jce." + paramString;
    paramString = paramString + "Response";
    try
    {
      paramString = (JceStruct)Class.forName(paramString).newInstance();
      AppMethodBeat.o(102222);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("IPCPackageTools", paramString, "", new Object[0]);
        paramString = null;
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("IPCPackageTools", paramString, "", new Object[0]);
        paramString = null;
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("IPCPackageTools", paramString, "", new Object[0]);
        paramString = null;
      }
    }
  }
  
  public static int getCmdId(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(102217);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(102217);
      return -1;
    }
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    int i = IPCCmd.convert(paramJceStruct.substring(0, paramJceStruct.length() - 7)).value();
    AppMethodBeat.o(102217);
    return i;
  }
  
  public static byte[] jceStruct2ByteArray(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(102223);
    paramJceStruct = ProtocolPackage.jceStructToUTF8Byte(paramJceStruct);
    AppMethodBeat.o(102223);
    return paramJceStruct;
  }
  
  public static JceStruct unpackBodyStruct(IPCResponse paramIPCResponse)
  {
    AppMethodBeat.i(102221);
    JceStruct localJceStruct = createFromRequest(IPCCmd.convert(paramIPCResponse.head.cmdId).toString());
    if ((localJceStruct != null) && (paramIPCResponse.body.length > 0)) {
      try
      {
        paramIPCResponse = new JceInputStream(paramIPCResponse.body);
        paramIPCResponse.setServerEncoding("utf-8");
        localJceStruct.readFrom(paramIPCResponse);
        AppMethodBeat.o(102221);
        return localJceStruct;
      }
      catch (Exception paramIPCResponse)
      {
        ac.printErrStackTrace("IPCPackageTools", paramIPCResponse, "", new Object[0]);
        AppMethodBeat.o(102221);
        return null;
      }
    }
    AppMethodBeat.o(102221);
    return null;
  }
  
  public static IPCResponse unpackPackage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102220);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4))
    {
      AppMethodBeat.o(102220);
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
      AppMethodBeat.o(102220);
      return localIPCResponse;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.printErrStackTrace("IPCPackageTools", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(102220);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.IPCPackageTools
 * JD-Core Version:    0.7.0.1
 */