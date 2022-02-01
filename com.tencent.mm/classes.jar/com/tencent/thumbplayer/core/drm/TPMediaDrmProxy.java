package com.tencent.thumbplayer.core.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.OnEventListener;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

@TargetApi(18)
public class TPMediaDrmProxy
{
  private MediaDrm mMediaDrm;
  private long mNativeContext;
  private UUID mUUID;
  
  private TPMediaDrmProxy(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220568);
    try
    {
      l1 = longFromBytes(paramArrayOfByte, 0, false);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        long l3;
        label32:
        MediaDrm localMediaDrm;
        long l1 = 0L;
      }
    }
    try
    {
      l3 = longFromBytes(paramArrayOfByte, 8, false);
      l2 = l3;
    }
    catch (Exception paramArrayOfByte)
    {
      break label32;
    }
    paramArrayOfByte = new UUID(l1, l2);
    localMediaDrm = new MediaDrm(paramArrayOfByte);
    localMediaDrm.setOnEventListener(new MediaDrm.OnEventListener()
    {
      public void onEvent(MediaDrm paramAnonymousMediaDrm, byte[] paramAnonymousArrayOfByte1, int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte2)
      {
        AppMethodBeat.i(220567);
        if (paramAnonymousMediaDrm == TPMediaDrmProxy.this.mMediaDrm) {
          TPMediaDrmProxy.access$100(TPMediaDrmProxy.this, paramAnonymousArrayOfByte1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte2);
        }
        AppMethodBeat.o(220567);
      }
    });
    this.mMediaDrm = localMediaDrm;
    this.mUUID = paramArrayOfByte;
    AppMethodBeat.o(220568);
  }
  
  public static TPMediaDrmProxy createMediaDrmProxyByUUID(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220569);
    if (Build.VERSION.SDK_INT < 18)
    {
      AppMethodBeat.o(220569);
      return null;
    }
    try
    {
      paramArrayOfByte = new TPMediaDrmProxy(paramArrayOfByte);
      AppMethodBeat.o(220569);
      return paramArrayOfByte;
    }
    catch (UnsupportedSchemeException paramArrayOfByte)
    {
      AppMethodBeat.o(220569);
    }
    return null;
  }
  
  private static boolean isCryptoSchemeSupportedWithMimeType(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(220570);
    long l1;
    long l2;
    boolean bool;
    try
    {
      l1 = longFromBytes(paramArrayOfByte, 0, false);
      l2 = longFromBytes(paramArrayOfByte, 8, false);
      if (Build.VERSION.SDK_INT >= 19)
      {
        bool = MediaDrm.isCryptoSchemeSupported(new UUID(l1, l2), paramString);
        AppMethodBeat.o(220570);
        return bool;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(220570);
      return false;
    }
    if (Build.VERSION.SDK_INT == 18)
    {
      bool = MediaDrm.isCryptoSchemeSupported(new UUID(l1, l2));
      AppMethodBeat.o(220570);
      return bool;
    }
    AppMethodBeat.o(220570);
    return false;
  }
  
  private static long longFromBytes(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l = 0L;
    int i = 0;
    if (i < 8)
    {
      if (paramBoolean) {}
      for (int j = i;; j = 7 - i)
      {
        j <<= 3;
        l |= 255L << j & paramArrayOfByte[(paramInt + i)] << j;
        i += 1;
        break;
      }
    }
    return l;
  }
  
  private native void native_mediaDrmOnEvent(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2);
  
  public void closeSession(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220573);
    this.mMediaDrm.closeSession(paramArrayOfByte);
    AppMethodBeat.o(220573);
  }
  
  public KeyRequest getKeyRequest(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt)
  {
    AppMethodBeat.i(220577);
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = this.mMediaDrm.getKeyRequest(paramArrayOfByte1, paramArrayOfByte2, paramString, paramInt, null);
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramInt = paramArrayOfByte1.getRequestType();
          paramArrayOfByte1 = new KeyRequest(paramInt, paramArrayOfByte1.getData(), 0);
          AppMethodBeat.o(220577);
          return paramArrayOfByte1;
        }
      }
      catch (NotProvisionedException paramArrayOfByte1)
      {
        paramArrayOfByte1 = new KeyRequest(-1, null, -1);
        AppMethodBeat.o(220577);
        return paramArrayOfByte1;
      }
      paramInt = 0;
    }
  }
  
  public MediaCrypto getMediaCrypto(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220572);
    try
    {
      paramArrayOfByte = new MediaCrypto(this.mUUID, paramArrayOfByte);
      AppMethodBeat.o(220572);
      return paramArrayOfByte;
    }
    catch (MediaCryptoException paramArrayOfByte)
    {
      AppMethodBeat.o(220572);
    }
    return null;
  }
  
  public String getPropertyString(String paramString)
  {
    AppMethodBeat.i(220579);
    paramString = this.mMediaDrm.getPropertyString(paramString);
    AppMethodBeat.o(220579);
    return paramString;
  }
  
  public TPMediaDrmProxy.ProvisionRequest getProvisionRequest()
  {
    AppMethodBeat.i(220575);
    Object localObject = this.mMediaDrm.getProvisionRequest();
    localObject = new TPMediaDrmProxy.ProvisionRequest(((MediaDrm.ProvisionRequest)localObject).getDefaultUrl(), ((MediaDrm.ProvisionRequest)localObject).getData());
    AppMethodBeat.o(220575);
    return localObject;
  }
  
  public DrmSessionId openSession()
  {
    AppMethodBeat.i(220571);
    Object localObject = null;
    i = 0;
    try
    {
      byte[] arrayOfByte = this.mMediaDrm.openSession();
      localObject = arrayOfByte;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = -2;
      }
    }
    localObject = new DrmSessionId(i, (byte[])localObject);
    AppMethodBeat.o(220571);
    return localObject;
  }
  
  public int provideKeyResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(220578);
    try
    {
      this.mMediaDrm.provideKeyResponse(paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(220578);
      return 0;
    }
    catch (NotProvisionedException paramArrayOfByte1)
    {
      AppMethodBeat.o(220578);
      return -1;
    }
    catch (DeniedByServerException paramArrayOfByte1)
    {
      AppMethodBeat.o(220578);
    }
    return -2;
  }
  
  public int provideProvisionResponse(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220576);
    try
    {
      this.mMediaDrm.provideProvisionResponse(paramArrayOfByte);
      AppMethodBeat.o(220576);
      return 0;
    }
    catch (DeniedByServerException paramArrayOfByte)
    {
      AppMethodBeat.o(220576);
    }
    return -1;
  }
  
  public void release()
  {
    AppMethodBeat.i(220574);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mMediaDrm.close();
      AppMethodBeat.o(220574);
      return;
    }
    this.mMediaDrm.release();
    AppMethodBeat.o(220574);
  }
  
  public void setPropertyString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220580);
    this.mMediaDrm.setPropertyString(paramString1, paramString2);
    AppMethodBeat.o(220580);
  }
  
  public static final class DrmSessionId
  {
    byte[] mSessionId;
    int mStatus;
    
    DrmSessionId(int paramInt, byte[] paramArrayOfByte)
    {
      this.mStatus = paramInt;
      this.mSessionId = paramArrayOfByte;
    }
  }
  
  public static final class KeyRequest
  {
    byte[] mData;
    int mRequestType;
    int mStatus;
    
    KeyRequest(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    {
      this.mRequestType = paramInt1;
      this.mData = paramArrayOfByte;
      this.mStatus = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPMediaDrmProxy
 * JD-Core Version:    0.7.0.1
 */