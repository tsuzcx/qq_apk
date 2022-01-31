package org.xwalk.core.extension;

import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class MessageInfo
{
  private String TAG = "MessageInfo";
  private JSONArray mArgs;
  private ByteBuffer mBinaryArgs;
  private String mCallbackId;
  private String mCmd;
  private XWalkExternalExtension mExtension;
  private int mInstanceId;
  private String mJsName;
  private String mObjectId;
  
  public MessageInfo(MessageInfo paramMessageInfo)
  {
    this.mExtension = paramMessageInfo.mExtension;
    this.mInstanceId = paramMessageInfo.mInstanceId;
    this.mJsName = paramMessageInfo.mJsName;
    this.mCallbackId = paramMessageInfo.mCallbackId;
    this.mObjectId = paramMessageInfo.mObjectId;
    this.mArgs = paramMessageInfo.mArgs;
    this.mCmd = paramMessageInfo.mCmd;
  }
  
  public MessageInfo(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, String paramString)
  {
    this.mExtension = paramXWalkExternalExtension;
    this.mInstanceId = paramInt;
    if (paramString.trim().charAt(0) == '[') {}
    for (;;)
    {
      try
      {
        this.mArgs = new JSONArray(paramString);
        this.mCmd = "invokeNative";
        this.mJsName = this.mArgs.getString(0);
        this.mCallbackId = this.mArgs.getString(1);
        this.mObjectId = this.mArgs.getString(2);
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.mArgs.remove(0);
          this.mArgs.remove(0);
          this.mArgs.remove(0);
        }
        return;
      }
      catch (JSONException paramXWalkExternalExtension)
      {
        Log.e(this.TAG, paramXWalkExternalExtension.toString());
        return;
      }
      try
      {
        paramXWalkExternalExtension = new JSONObject(paramString);
        paramString = paramXWalkExternalExtension.getString("cmd");
        paramInt = paramXWalkExternalExtension.getInt("objectId");
        this.mCmd = paramString;
        this.mObjectId = Integer.toString(paramInt);
        this.mCallbackId = Integer.toString(0);
        paramString = paramXWalkExternalExtension.getString("type");
        this.mArgs = new JSONArray();
        if (paramString.equals("postMessageToExtension"))
        {
          this.mArgs = paramXWalkExternalExtension.getJSONArray("args");
          this.mJsName = paramXWalkExternalExtension.getString("name");
          if (!this.mCmd.equals("newInstance")) {
            continue;
          }
          this.mObjectId = this.mArgs.getString(0);
          this.mArgs = this.mArgs.getJSONArray(1);
        }
      }
      catch (JSONException paramXWalkExternalExtension)
      {
        Log.e(this.TAG, paramXWalkExternalExtension.toString());
        return;
      }
    }
    this.mJsName = paramString;
    this.mArgs.put(0, paramXWalkExternalExtension.getString("name"));
    this.mArgs.put(1, paramXWalkExternalExtension.getJSONArray("args"));
  }
  
  public MessageInfo(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, byte[] paramArrayOfByte)
  {
    this.mExtension = paramXWalkExternalExtension;
    this.mInstanceId = paramInt;
    this.mCmd = "invokeNative";
    try
    {
      this.mArgs = null;
      paramXWalkExternalExtension = ByteBuffer.wrap(paramArrayOfByte);
      if (paramXWalkExternalExtension.order() != ByteOrder.LITTLE_ENDIAN) {
        paramXWalkExternalExtension.order(ByteOrder.LITTLE_ENDIAN);
      }
      int j = paramXWalkExternalExtension.position();
      paramInt = paramXWalkExternalExtension.getInt(j);
      int i = AlignedWith4Bytes(paramInt);
      j += 4;
      this.mJsName = new String(paramArrayOfByte, j, paramInt);
      paramInt = j + i;
      this.mCallbackId = Integer.toString(paramXWalkExternalExtension.getInt(paramInt));
      j = paramInt + 4;
      paramInt = paramXWalkExternalExtension.getInt(j);
      i = AlignedWith4Bytes(paramInt);
      j += 4;
      this.mObjectId = new String(paramArrayOfByte, j, paramInt);
      paramInt = j + i;
      this.mBinaryArgs = ByteBuffer.wrap(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
      return;
    }
    catch (IndexOutOfBoundsException paramXWalkExternalExtension)
    {
      Log.e(this.TAG, paramXWalkExternalExtension.toString());
      return;
    }
    catch (NullPointerException paramXWalkExternalExtension)
    {
      Log.e(this.TAG, paramXWalkExternalExtension.toString());
    }
  }
  
  private int AlignedWith4Bytes(int paramInt)
  {
    return 4 - paramInt % 4 + paramInt;
  }
  
  public JSONArray getArgs()
  {
    return this.mArgs;
  }
  
  public ByteBuffer getBinaryArgs()
  {
    return this.mBinaryArgs;
  }
  
  public String getCallbackId()
  {
    return this.mCallbackId;
  }
  
  public String getCmd()
  {
    return this.mCmd;
  }
  
  public XWalkExternalExtension getExtension()
  {
    return this.mExtension;
  }
  
  public ExtensionInstanceHelper getInstanceHelper()
  {
    return this.mExtension.getInstanceHelper(this.mInstanceId);
  }
  
  public int getInstanceId()
  {
    return this.mInstanceId;
  }
  
  public String getJsName()
  {
    return this.mJsName;
  }
  
  public String getObjectId()
  {
    return this.mObjectId;
  }
  
  public void postResult(JSONArray paramJSONArray)
  {
    int i = 0;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(0, this.mCallbackId);
      while (i < paramJSONArray.length())
      {
        localJSONArray.put(i + 1, paramJSONArray.get(i));
        i += 1;
      }
      Log.w(this.TAG, "postResult: " + localJSONArray.toString());
      this.mExtension.postMessage(this.mInstanceId, localJSONArray.toString());
      return;
    }
    catch (JSONException paramJSONArray)
    {
      Log.e(this.TAG, paramJSONArray.toString());
    }
  }
  
  public void postResult(byte[] paramArrayOfByte)
  {
    this.mExtension.postBinaryMessage(this.mInstanceId, paramArrayOfByte);
  }
  
  public void setArgs(JSONArray paramJSONArray)
  {
    this.mArgs = paramJSONArray;
  }
  
  public void setBinaryArgs(ByteBuffer paramByteBuffer)
  {
    this.mBinaryArgs = paramByteBuffer;
  }
  
  public void setCallbackId(String paramString)
  {
    this.mCallbackId = paramString;
  }
  
  public void setJsName(String paramString)
  {
    this.mJsName = paramString;
  }
  
  public void setObjectId(String paramString)
  {
    this.mObjectId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.extension.MessageInfo
 * JD-Core Version:    0.7.0.1
 */