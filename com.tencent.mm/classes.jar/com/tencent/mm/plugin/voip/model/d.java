package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.protocal.c.aoo;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class d
{
  private static int pOG = 100;
  public static int pOI = 0;
  public static int pOL = 18;
  public static int pOM = 19;
  public static short[] pOV = { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
  private static final String[] pOW = { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK" };
  public static int pOZ = 25;
  private static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
  public String ENCODING = "hevc";
  protected MediaFormat eIG;
  private int gOs = 12000;
  private boolean mMuxerStarted;
  private int mTrackIndex;
  j pNq = null;
  int pOA;
  int pOB = 8;
  int pOC = 1;
  int pOD;
  int pOE;
  private byte[] pOF = null;
  public long pOH = 0L;
  private MediaMuxer pOJ;
  private BufferedOutputStream pOK;
  public LinkedList<aoo> pON = new LinkedList();
  public LinkedList<Integer> pOO = new LinkedList();
  f pOP = null;
  public int pOQ = 0;
  public int pOR = 8;
  public int pOS = 0;
  public int pOT = 0;
  d.a pOU;
  public boolean pOX = false;
  public int pOY = 0;
  private BufferedOutputStream pOa;
  public byte[] pOf = null;
  public int pOv = 0;
  MediaCodec pOw;
  int pOx;
  int pOy;
  int pOz;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    this.pOx = paramInt1;
    this.pOy = paramInt2;
    this.pOD = paramInt1;
    this.pOE = paramInt2;
    this.ENCODING = paramString;
    this.pOz = paramInt3;
    this.pOA = paramInt4;
    this.pOC = paramInt5;
    pOI = 0;
    this.pOH = 0L;
    this.pOU = new d.a(this);
    this.pOw = null;
    this.pOR = 8;
    this.pOQ = 0;
    this.pOS = 0;
    this.pOv = 0;
    paramString = new aoo();
    paramString.tkl = 1L;
    paramString.tkm = 24;
    paramString.tkn = 1L;
    paramString.tko = 24;
    paramString.tkp = 0L;
    paramString.tkq = 0;
    this.pON.add(paramString);
    this.pOO.add(Integer.valueOf(0));
    this.pOF = null;
    this.pOT = 0;
  }
  
  private void a(MediaCodecInfo paramMediaCodecInfo, int paramInt)
  {
    if (com.tencent.mm.compatible.util.d.gF(23)) {}
    for (;;)
    {
      int i;
      try
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(this.ENCODING);
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
        int m;
        int n;
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.profileLevels;
          if (paramMediaCodecInfo != null)
          {
            localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
            localCodecProfileLevel.level = 0;
            localCodecProfileLevel.profile = 0;
            int k = paramMediaCodecInfo.length;
            i = 0;
            if (i < k)
            {
              Object localObject = paramMediaCodecInfo[i];
              m = localObject.profile;
              n = localObject.level;
              if (m <= paramInt) {
                y.i("MeidaCodec[HWEnc]", "profile: " + m + ", level: " + n);
              }
            }
          }
        }
        switch (m)
        {
        default: 
          if ((j == 0) || (m < localCodecProfileLevel.profile) || (n < localCodecProfileLevel.level)) {
            break label319;
          }
          localCodecProfileLevel.profile = m;
          localCodecProfileLevel.level = n;
          break label319;
          y.i("MeidaCodec[HWEnc]", "best profile: " + localCodecProfileLevel.profile + ", best level: " + localCodecProfileLevel.level);
          if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
          {
            this.eIG.setInteger("profile", localCodecProfileLevel.profile);
            this.eIG.setInteger("level", 256);
          }
          return;
        }
      }
      catch (Exception paramMediaCodecInfo)
      {
        y.e("MeidaCodec[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
        return;
      }
      int j = 0;
      continue;
      label319:
      i += 1;
      continue;
      j = 1;
    }
  }
  
  private static String aO(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0" + str3;
      }
      str1 = str1 + str2;
      i += 1;
    }
    return str1;
  }
  
  private static ArrayList<Integer> aQ(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = aO(paramArrayOfByte);
    String str = aO(new byte[] { 0, 0, 0, 1 });
    y.d("MeidaCodec[HWEnc]", "parent: " + paramArrayOfByte + ", child:" + str);
    for (;;)
    {
      int j = paramArrayOfByte.indexOf(str, i);
      if (j == -1) {
        break;
      }
      y.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + j);
      i = str.length() + j;
      localArrayList.add(Integer.valueOf(j / 2));
    }
    return localArrayList;
  }
  
  private static boolean b(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool2 = false;
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    String[] arrayOfString = pOW;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramMediaCodecInfo.startsWith(arrayOfString[i]))
        {
          bool1 = true;
          y.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :" + paramMediaCodecInfo);
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  private static boolean b(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      String str = paramMediaCodecInfo.getName();
      String[] arrayOfString = pOW;
      int k = arrayOfString.length;
      int i = 0;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i >= k) {
          break;
        }
        bool2 = bool1;
        if (str.startsWith(arrayOfString[i]))
        {
          bool2 = bool1;
          try
          {
            MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramMediaCodecInfo.getCapabilitiesForType(paramString).profileLevels;
            bool2 = bool1;
            int m = arrayOfCodecProfileLevel.length;
            int j = 0;
            for (;;)
            {
              bool2 = bool1;
              if (j >= m) {
                break;
              }
              MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[j];
              boolean bool3 = bool1;
              bool2 = bool1;
              if (localCodecProfileLevel.profile == 8) {
                bool3 = true;
              }
              bool2 = bool3;
              y.d("MeidaCodec[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", MIME:" + paramString);
              j += 1;
              bool1 = bool3;
            }
            i += 1;
          }
          catch (Exception localException) {}
        }
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  @SuppressLint({"NewApi"})
  private int bPK()
  {
    int k = 0;
    if (this.pOw != null) {
      bPL();
    }
    String str = this.ENCODING;
    int m = MediaCodecList.getCodecCount();
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    int j;
    if (i < m)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        label55:
        if (j < arrayOfString.length) {
          if (arrayOfString[j].equalsIgnoreCase(str))
          {
            str = localMediaCodecInfo.getName();
            y.d("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:" + str);
          }
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label167;
      }
      y.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.pOv = 2001;
      return -this.pOv;
      j += 1;
      break label55;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label167:
    y.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.eIG = MediaFormat.createVideoFormat(this.ENCODING, this.pOx, this.pOy);
    this.eIG.setInteger("color-format", 21);
    this.eIG.setInteger("bitrate", this.pOA * 1000);
    this.eIG.setInteger("frame-rate", this.pOz);
    this.eIG.setInteger("i-frame-interval", 4);
    str = this.eIG.getString("mime");
    this.pOQ = 1;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (b(localMediaCodecInfo)) && (com.tencent.mm.compatible.util.d.gF(23)))
    {
      if ((this.pOC <= 0) || ((this.pOC & 0x1) == 0)) {
        break label504;
      }
      i = 1;
      j = k;
      if (this.pOC > 0)
      {
        j = k;
        if ((this.pOC & 0x4) != 0) {
          j = 1;
        }
      }
      boolean bool = b(localMediaCodecInfo, str);
      if ((j == 0) || (!bool)) {
        break label509;
      }
      this.eIG.setInteger("profile", 8);
      this.eIG.setInteger("level", 256);
    }
    for (;;)
    {
      this.pOQ = this.eIG.getInteger("profile");
      this.eIG.setInteger("bitrate-mode", 2);
      try
      {
        this.pOw = MediaCodec.createEncoderByType(str);
        y.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.eIG + ", actProfile: " + this.pOQ);
        this.pOw.configure(this.eIG, null, null, 1);
        this.pOw.start();
        this.pOP = new f();
        return 2000;
      }
      catch (Exception localException)
      {
        label504:
        label509:
        y.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
        this.pOv = 2002;
      }
      i = 0;
      break;
      if (i != 0)
      {
        this.eIG.setInteger("profile", 1);
        this.eIG.setInteger("level", 256);
      }
      else if (localMediaCodecInfo != null)
      {
        a(localMediaCodecInfo, this.pOR);
      }
    }
    return -this.pOv;
  }
  
  @SuppressLint({"NewApi"})
  private void bPL()
  {
    try
    {
      if (this.pOw != null)
      {
        this.pOw.stop();
        this.pOw.release();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
    }
  }
  
  private void u(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (this.pNq.pQe != null))
    {
      int i = pOL;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = pOM;
      }
      i = this.pNq.pQe.videoEncodeToSend(paramArrayOfByte, paramInt2, this.pOx, paramInt1, i);
      if (i > 0) {
        y.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
      }
    }
  }
  
  public final void bPJ()
  {
    this.pOX = false;
    try
    {
      bPL();
      if (this.pOa != null)
      {
        this.pOa.flush();
        this.pOa.close();
      }
      if (this.pOK != null)
      {
        this.pOK.flush();
        this.pOK.close();
      }
      if (this.pOJ != null)
      {
        this.pOJ.stop();
        this.pOJ.release();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
    }
  }
  
  public final int e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if ((paramInt1 != this.pOD) || (paramInt2 != this.pOE))
    {
      this.pOD = paramInt1;
      this.pOE = paramInt2;
    }
    if (this.pOF == null) {
      this.pOF = new byte[this.pOD * this.pOE * 3 / 2];
    }
    y.d("MeidaCodec[HWEnc]", "steve: m_framerate: " + this.pOz + ", m_br_kbps:" + this.pOA);
    if (this.pOU.pPl == 0)
    {
      this.pNq.pQe.videoHWProcess(paramArrayOfByte, paramArrayOfByte.length, this.pOD, this.pOE, paramInt3, this.pOF);
      paramArrayOfByte = this.pOF;
      if ((this.pOx != this.pNq.pQe.field_HWEncW) || (this.pOy != this.pNq.pQe.field_HWEncH))
      {
        y.d("MeidaCodec[HWEnc]", "restart encoder! clipWH:" + this.pNq.pQe.field_HWEncW + "x" + this.pNq.pQe.field_HWEncH + ", wh:" + this.pOx + "x" + this.pOy);
        this.pOx = this.pNq.pQe.field_HWEncW;
        this.pOy = this.pNq.pQe.field_HWEncH;
        this.pOY = (this.pOx * this.pOy * 3 >> 1);
        try
        {
          paramInt1 = bPK();
          paramInt2 = paramInt1;
          if (paramInt1 >= 0) {
            break label376;
          }
          y.e("MeidaCodec[HWEnc]", "mediacodec init failed, stop HW encoding! ret: " + paramInt1);
          bPJ();
          return paramInt1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            y.e("MeidaCodec[HWEnc]", "mediacodec init error: " + localException1.getMessage());
            this.pOv = 2003;
            paramInt1 = -this.pOv;
          }
        }
      }
      else
      {
        paramInt2 = 0;
      }
      label376:
      if ((pOI > 100) || (this.pOK == null)) {}
    }
    for (;;)
    {
      try
      {
        this.pOK.write(this.pOF, 0, this.pOY);
        paramInt1 = paramInt2;
        if ((paramArrayOfByte == null) || (this.pOw == null)) {
          break label1811;
        }
        ByteBuffer[] arrayOfByteBuffer;
        paramInt1 = paramInt2;
      }
      catch (Exception localException2)
      {
        try
        {
          this.pOT = 0;
          l = System.currentTimeMillis();
          y.d("MeidaCodec[HWEnc]", "steve: put YUV into encoder, size:" + this.pOY + ", idx:" + pOI + ", time:" + l);
          localObject1 = this.pOw.getInputBuffers();
          arrayOfByteBuffer = this.pOw.getOutputBuffers();
          paramInt2 = this.pOw.dequeueInputBuffer(-1L);
          if (paramInt2 >= 0)
          {
            l = this.pOH * 1000000L / 15L;
            localObject1 = localObject1[paramInt2];
            ((ByteBuffer)localObject1).clear();
            ((ByteBuffer)localObject1).put(paramArrayOfByte, 0, this.pOY);
            this.pOw.queueInputBuffer(paramInt2, 0, this.pOY, l + 132L, 0);
            this.pOH += 1L;
          }
          paramArrayOfByte = new MediaCodec.BufferInfo();
          k = this.pOw.dequeueOutputBuffer(paramArrayOfByte, this.gOs);
          if (k != -2) {
            break label1848;
          }
          localObject1 = this.pOw.getOutputFormat();
          y.i("MeidaCodec[HWEnc]", "steve: encoder output format changed: " + localObject1);
          if ((!((MediaFormat)localObject1).containsKey("bitrate")) || (((MediaFormat)localObject1).getInteger("bitrate") <= this.pOA * 1000 * 1.5D)) {
            break label1848;
          }
          y.e("MeidaCodec[HWEnc]", "steve: bitrate NOT match!! real:" + ((MediaFormat)localObject1).getInteger("bitrate") + ", target:" + this.pOA);
          this.pOv = 2007;
          paramInt1 = this.pOv;
          return -paramInt1;
        }
        catch (Exception paramArrayOfByte)
        {
          long l;
          Object localObject1;
          int k;
          Object localObject3;
          byte[] arrayOfByte;
          int j;
          y.e("MeidaCodec[HWEnc]", " error:" + paramArrayOfByte.toString());
          this.pOv = 2004;
          return -this.pOv;
        }
        localException2 = localException2;
        y.e("MeidaCodec[HWEnc]", " error:" + localException2.toString());
      }
      continue;
      ((aon)localObject3).tkh = 4;
      ((aon)localObject3).tki = b.v(arrayOfByte, j, i);
      ((aon)localObject3).tkj = b.v(arrayOfByte, paramInt3, paramInt2);
      paramInt1 = ((aon)localObject3).toByteArray().length;
      u(((aon)localObject3).toByteArray(), paramArrayOfByte.flags, paramInt1);
      label822:
      if ((this.mMuxerStarted) && (localObject1 != null)) {
        this.pOJ.writeSampleData(this.mTrackIndex, (ByteBuffer)localObject1, paramArrayOfByte);
      }
      paramInt1 = paramArrayOfByte.flags;
      pOI += 1;
      this.pOw.releaseOutputBuffer(k, false);
      k = this.pOw.dequeueOutputBuffer(paramArrayOfByte, this.gOs);
      label1811:
      label1848:
      for (;;)
      {
        if (k < 0) {
          break label1849;
        }
        localObject1 = localException2[k];
        arrayOfByte = new byte[paramArrayOfByte.size];
        ((ByteBuffer)localObject1).get(arrayOfByte);
        if (this.pOa != null) {
          this.pOa.write(arrayOfByte, 0, arrayOfByte.length);
        }
        Object localObject2;
        int m;
        if (paramArrayOfByte.flags == 2)
        {
          localObject2 = aQ(arrayOfByte);
          localObject3 = new aon();
          m = 0;
          j = 0;
          i = 0;
          paramInt3 = 0;
          paramInt2 = 0;
          if ((((ArrayList)localObject2).size() == 3) && (this.ENCODING.equalsIgnoreCase("video/hevc")))
          {
            paramInt1 = ((Integer)((ArrayList)localObject2).get(0)).intValue() + 4;
            j = ((Integer)((ArrayList)localObject2).get(1)).intValue() + 4;
            paramInt3 = ((Integer)((ArrayList)localObject2).get(2)).intValue() + 4;
            m = j - paramInt1 - 4;
            i = paramInt3 - j - 4;
            paramInt2 = paramArrayOfByte.size - paramInt3;
            ((aon)localObject3).tkk = b.v(arrayOfByte, paramInt1, m);
          }
        }
        for (;;)
        {
          y.d("MeidaCodec[HWEnc]", "sps start: " + j + ", len:" + i + ", pps start:" + paramInt3 + ", len:" + paramInt2 + ", vps start: " + paramInt1 + ", len:" + m);
          if ((this.pOQ == 1) || (!this.pOP.C(new ByteArrayInputStream(arrayOfByte)))) {
            break;
          }
          this.pOS = this.pOP.pPq;
          this.pOR = 1;
          y.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.pOR + ", checkCodeForBSlice:" + this.pOS);
          try
          {
            paramInt1 = bPK();
            return paramInt1;
          }
          catch (Exception paramArrayOfByte)
          {
            y.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + paramArrayOfByte.getMessage());
            this.pOv = 2005;
            return -this.pOv;
          }
          if (((ArrayList)localObject2).size() == 2)
          {
            j = ((Integer)((ArrayList)localObject2).get(0)).intValue() + 4;
            paramInt3 = ((Integer)((ArrayList)localObject2).get(1)).intValue() + 4;
            i = paramInt3 - j - 4;
            paramInt2 = paramArrayOfByte.size - paramInt3;
            paramInt1 = 0;
            continue;
            if (this.pOQ != 1)
            {
              localObject2 = this.pOP;
              localObject3 = new i(new ByteArrayInputStream(arrayOfByte));
              ((i)localObject3).zS(8);
              ((i)localObject3).zS(8);
              ((i)localObject3).zS(8);
              ((i)localObject3).zS(8);
              ((i)localObject3).zS(8);
              ((i)localObject3).bPP();
              paramInt1 = ((i)localObject3).bPO();
              y.d("TAG", "steve:slice_type:" + paramInt1);
              if ((paramInt1 == 1) || (paramInt1 == 6)) {
                ((f)localObject2).pPq |= 0x8;
              }
              for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
              {
                this.pOS = this.pOP.pPq;
                this.pOR = 1;
                y.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.pOR + ", checkCodeForBSlice:" + this.pOS);
                try
                {
                  paramInt1 = bPK();
                  return paramInt1;
                }
                catch (Exception paramArrayOfByte)
                {
                  y.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + paramArrayOfByte.getMessage());
                  this.pOv = 2005;
                  return -this.pOv;
                }
              }
            }
            localObject2 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject2).putInt(paramArrayOfByte.size - 4);
            System.arraycopy(((ByteBuffer)localObject2).order(ByteOrder.BIG_ENDIAN).array(), 0, arrayOfByte, 0, 4);
            l = System.currentTimeMillis();
            y.d("MeidaCodec[HWEnc]", " type:" + paramArrayOfByte.flags + ", size:" + paramArrayOfByte.size + ", idx:" + pOI + ", time:" + l);
            localObject2 = new aom();
            ((aom)localObject2).tkd = b.v(arrayOfByte, 0, paramArrayOfByte.size);
            ((aom)localObject2).tke = 1;
            ((aom)localObject2).tkf = this.pON;
            this.pOO.set(0, Integer.valueOf(paramArrayOfByte.size));
            ((aom)localObject2).tkg = this.pOO;
            paramInt1 = ((aom)localObject2).toByteArray().length;
            u(((aom)localObject2).toByteArray(), paramArrayOfByte.flags, paramInt1);
            break label822;
            paramInt2 = this.pOT;
            this.pOT = (paramInt2 + 1);
            if (paramInt2 > 5)
            {
              this.pOv = 2006;
              return -this.pOv;
            }
            return paramInt1;
          }
          paramInt1 = 0;
        }
      }
      label1849:
      break;
      paramArrayOfByte = null;
      paramInt1 = i;
    }
  }
  
  @SuppressLint({"NewApi"})
  public final boolean zP(int paramInt)
  {
    try
    {
      if (this.pOw != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        y.v("MeidaCodec[HWEnc]", "steve: setRates: " + paramInt);
        localBundle.putInt("video-bitrate", paramInt);
        this.pOw.setParameters(localBundle);
        return true;
      }
    }
    catch (Exception localException)
    {
      y.e("MeidaCodec[HWEnc]", "steve: setRates failed:" + localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.d
 * JD-Core Version:    0.7.0.1
 */