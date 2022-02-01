package com.tencent.tmassistantsdk.channel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class TMAssistantSDKChannelDataItem
{
  public static final int DATEITEM_VERSION = 1;
  private static final String ENCRYPT_KEY = "&-*)Wb5_U,[^!9'+";
  public static final int IPCDATA_MIN_VERSION = 1;
  private static final String TAG = "MicroMsg.TMAssistantSDKChannelDataItem";
  public int mDBIdentity;
  public String mDataItemAction;
  public long mDataItemEndTime;
  public long mDataItemStartTime;
  public int mDataItemType;
  public int mDataItemVersion;
  public String mHostPackageName;
  public String mHostUserIdentity;
  public int mHostVersion;
  public byte[] mIPCData;
  
  public TMAssistantSDKChannelDataItem(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101864);
    this.mDBIdentity = -1;
    this.mHostPackageName = "";
    this.mHostVersion = 0;
    this.mHostUserIdentity = "";
    this.mDataItemType = 0;
    this.mDataItemAction = "";
    this.mDataItemStartTime = 0L;
    this.mDataItemEndTime = 0L;
    this.mDataItemVersion = 0;
    this.mIPCData = null;
    this.mHostPackageName = paramString1;
    if (this.mHostPackageName == null) {
      this.mHostPackageName = "";
    }
    this.mHostVersion = paramInt1;
    this.mHostUserIdentity = paramString2;
    if (this.mHostUserIdentity == null) {
      this.mHostUserIdentity = "";
    }
    this.mDataItemType = paramInt2;
    this.mDataItemAction = paramString3;
    if (this.mDataItemAction == null) {
      this.mDataItemAction = "";
    }
    this.mDataItemStartTime = paramLong1;
    this.mDataItemEndTime = paramLong2;
    this.mDataItemVersion = paramInt3;
    this.mIPCData = paramArrayOfByte;
    AppMethodBeat.o(101864);
  }
  
  public static TMAssistantSDKChannelDataItem getDataItemFromByte(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101865);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(101865);
      return null;
    }
    paramArrayOfByte = new Cryptor().decrypt(paramArrayOfByte, "&-*)Wb5_U,[^!9'+".getBytes());
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      str1 = paramArrayOfByte.getString("mHostPackageName");
      i = paramArrayOfByte.getInt("mHostVersion");
      str2 = paramArrayOfByte.getString("mHostUserIdentity");
      j = paramArrayOfByte.getInt("mDataItemType");
      str3 = paramArrayOfByte.getString("mDataItemAction");
      l1 = paramArrayOfByte.getLong("mDataItemStartTime");
      l2 = paramArrayOfByte.getLong("mDataItemEndTime");
      k = paramArrayOfByte.getInt("mDataItemVersion");
      if (k <= 0) {
        break label207;
      }
      paramArrayOfByte = paramArrayOfByte.getString("mIPCData");
      if (paramArrayOfByte == null) {
        break label207;
      }
      paramArrayOfByte = Base64.decode(paramArrayOfByte, 0);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      String str1;
      int i;
      String str2;
      int j;
      String str3;
      long l1;
      long l2;
      int k;
      ad.printErrStackTrace("MicroMsg.TMAssistantSDKChannelDataItem", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(101865);
      return null;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TMAssistantSDKChannelDataItem", paramArrayOfByte, "", new Object[0]);
        continue;
        paramArrayOfByte = null;
      }
    }
    paramArrayOfByte = new TMAssistantSDKChannelDataItem(str1, i, str2, j, str3, l1, l2, k, paramArrayOfByte);
    AppMethodBeat.o(101865);
    return paramArrayOfByte;
  }
  
  public byte[] getBuffer()
  {
    AppMethodBeat.i(101866);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("mHostPackageName", this.mHostPackageName);
      ((JSONObject)localObject).put("mHostVersion", this.mHostVersion);
      ((JSONObject)localObject).put("mHostUserIdentity", this.mHostUserIdentity);
      ((JSONObject)localObject).put("mDataItemType", this.mDataItemType);
      ((JSONObject)localObject).put("mDataItemAction", this.mDataItemAction);
      ((JSONObject)localObject).put("mDataItemStartTime", this.mDataItemStartTime);
      ((JSONObject)localObject).put("mDataItemEndTime", this.mDataItemEndTime);
      ((JSONObject)localObject).put("mDataItemVersion", this.mDataItemVersion);
      if ((this.mDataItemVersion > 0) && (this.mIPCData != null))
      {
        String str = Base64.encodeToString(this.mIPCData, 0);
        if (str != null) {
          ((JSONObject)localObject).put("mIPCData", str);
        }
      }
      localObject = ((JSONObject)localObject).toString();
      if (localObject != null)
      {
        localObject = ((String)localObject).getBytes("UTF-8");
        if (localObject != null)
        {
          localObject = new Cryptor().encrypt((byte[])localObject, "&-*)Wb5_U,[^!9'+".getBytes());
          AppMethodBeat.o(101866);
          return localObject;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.TMAssistantSDKChannelDataItem", localJSONException, "", new Object[0]);
      AppMethodBeat.o(101866);
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TMAssistantSDKChannelDataItem", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem
 * JD-Core Version:    0.7.0.1
 */