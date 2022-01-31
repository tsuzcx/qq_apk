package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class l
{
  private final boolean bHB;
  private final int bHv;
  private final int bHw;
  private final boolean bHx;
  private final int brC;
  final String filePath;
  final String rVT;
  private final String rVW;
  private final int rVX;
  private final byte[] rVY;
  private final String rVZ;
  final boolean rWA;
  private final long rWb;
  private final String rWc;
  private final int rWd;
  private final int rWe;
  final boolean rWz;
  volatile String rXb = null;
  volatile String rXc = null;
  volatile int state = -1;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    this.rVT = i.eW(paramInt1, paramInt2);
    this.bHv = paramInt1;
    this.brC = paramInt2;
    this.filePath = paramString1;
    this.rWA = paramBoolean1;
    this.rWz = paramBoolean2;
    this.rVW = paramString2;
    this.rVX = paramInt3;
    this.rVY = paramArrayOfByte;
    this.rVZ = paramString3;
    this.bHB = paramBoolean3;
    this.bHx = paramBoolean4;
    this.rWc = paramString4;
    this.rWb = paramLong;
    this.url = paramString5;
    this.rWd = paramInt4;
    this.rWe = paramInt5;
    this.bHw = paramInt6;
  }
  
  final l clA()
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.rVT, clD(), this.rXb, this.rXc, Boolean.valueOf(bk.bl(this.rVW)) });
    if (1 != this.state) {
      return this;
    }
    if (bk.bl(this.rVW))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.rVT });
      this.rXb = null;
      this.state = 8;
      j.s(this.rWb, 54L);
      j.s(this.rWb, 45L);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.rXb;
        str = this.rXc;
        localObject1 = this.rVW;
        localFile = new File((String)localObject2);
        if ((!localFile.exists()) || (!localFile.isFile()))
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject2 });
          bool1 = false;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        String str;
        Object localObject1;
        File localFile;
        boolean bool2;
        boolean bool1 = false;
      }
      try
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.rVT, Boolean.valueOf(bool1) });
        y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.rVT, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.rXb = null;
        this.state = 8;
        return this;
      }
      catch (Exception localException2)
      {
        break label454;
      }
      localFile = new File(str);
      localFile.getParentFile().mkdirs();
      localFile.delete();
      localObject2 = a.Wo((String)localObject2);
      if (bk.bE((byte[])localObject2))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.s(this.rWb, 56L);
        j.s(this.rWb, 45L);
        j.s(this.rWb, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (bk.bE((byte[])localObject1))
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.s(this.rWb, 55L);
          j.s(this.rWb, 45L);
          j.s(this.rWb, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.v(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.s(this.rWb, 57L);
            j.s(this.rWb, 45L);
            j.s(this.rWb, 18L);
            bool1 = bool2;
            continue;
            label454:
            y.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.rVT, localException1 });
            j.s(this.rWb, 45L);
            j.s(this.rWb, 18L);
          }
        }
      }
    }
    j.s(this.rWb, 17L);
    this.rXb = this.rXc;
    if (this.rWz)
    {
      this.rXc = (this.filePath + ".decompressed");
      this.state = 2;
      return this;
    }
    this.state = 4;
    return this;
  }
  
  final l clB()
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.rVT, clD(), this.rXb, this.rXc });
    if (2 != this.state) {
      if ((8 == this.state) && (this.rWA)) {
        j.a(this.bHv, this.brC, this.rVX, this.bHB, false, false, false, this.rWc);
      }
    }
    label292:
    do
    {
      return this;
      for (;;)
      {
        try
        {
          localObject = this.rXb;
          str = this.rXc;
          File localFile = new File((String)localObject);
          if ((!localFile.exists()) || (!localFile.isFile()))
          {
            y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject });
            bool = false;
          }
        }
        catch (Exception localException1)
        {
          String str;
          boolean bool = false;
        }
        try
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.rVT, Boolean.valueOf(bool) });
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.rVT, Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          this.rXb = this.rXc;
          this.state = 4;
          j.s(this.rWb, 19L);
          return this;
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          int k;
          j.a locala;
          break label292;
        }
        new File(str).delete();
        localObject = q.r(a.Wo((String)localObject));
        if (bk.bE((byte[])localObject))
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
          bool = false;
        }
        else
        {
          bool = a.v(str, (byte[])localObject);
          continue;
          y.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.rVT, localException1 });
        }
      }
      this.rXb = null;
      this.state = 8;
      j.s(this.rWb, 20L);
      j.s(this.rWb, 46L);
      if (this.rWA)
      {
        j.a(this.bHv, this.brC, this.rVX, this.bHB, true, false, false, this.rWc);
        return this;
      }
    } while ((!this.rWz) || (!this.bHx));
    i = this.bHv;
    j = this.brC;
    Object localObject = this.url;
    k = this.bHw;
    if (this.rWd > this.rWe) {}
    for (locala = j.a.rWT;; locala = j.a.rWR)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.bHB, false, this.rWc);
      return this;
    }
  }
  
  final String clC()
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + clD(), new Object[] { this.rVT });
    if (16 == this.state) {
      localObject = this.rXb;
    }
    String str1;
    label113:
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject;
            if ((4 != this.state) && (32 != this.state)) {
              return null;
            }
            if (!bk.bl(this.rXb))
            {
              localObject = this.rVT;
              str2 = clD();
              String str3 = this.rVZ;
              if (this.rVY == null)
              {
                str1 = "null";
                y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { localObject, str2, str3, str1 });
                if ((bk.bl(this.rVZ)) || (!bk.pm(g.bQ(this.rXb)).equals(this.rVZ))) {
                  break label353;
                }
                y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.rVT, clD() });
                if (this.state == 4) {
                  j.s(this.rWb, 23L);
                }
                str1 = this.rXb;
              }
            }
            for (;;)
            {
              y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.rVT, str1 });
              localObject = str1;
              if (this.state != 4) {
                break;
              }
              if ((bk.bl(str1)) && (!this.rWz))
              {
                j.s(this.rWb, 58L);
                j.s(this.rWb, 45L);
              }
              if (!bk.bl(str1)) {
                break label568;
              }
              if (!this.rWA) {
                break label478;
              }
              j.a(this.bHv, this.brC, this.rVX, this.bHB, true, true, false, this.rWc);
              return str1;
              str1 = String.valueOf(this.rVY.length);
              break label113;
              if (this.state == 4) {
                j.s(this.rWb, 24L);
              }
              if ((!bk.bE(this.rVY)) && (UtilsJni.doEcdsaSHAVerify(i.rWC, a.Wo(this.rXb), this.rVY) > 0))
              {
                y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.rVT, clD() });
                if (this.state == 4) {
                  j.s(this.rWb, 25L);
                }
                str1 = this.rXb;
              }
              else
              {
                if (this.state == 4) {
                  j.s(this.rWb, 26L);
                }
                str1 = null;
              }
            }
            localObject = str1;
          } while (!this.rWz);
          localObject = str1;
        } while (!this.bHx);
        i = this.bHv;
        j = this.brC;
        str2 = this.url;
        k = this.bHw;
        if (this.rWd > this.rWe) {}
        for (localObject = j.a.rWT;; localObject = j.a.rWR)
        {
          j.a(i, j, str2, k, (j.a)localObject, false, this.bHB, true, this.rWc);
          return str1;
        }
        if (this.rWA)
        {
          j.a(this.bHv, this.brC, this.rVX, this.bHB, true, true, true, this.rWc);
          return str1;
        }
        localObject = str1;
      } while (!this.rWz);
      localObject = str1;
    } while (!this.bHx);
    label353:
    int i = this.bHv;
    label478:
    int j = this.brC;
    label568:
    String str2 = this.url;
    int k = this.bHw;
    if (this.rWd > this.rWe) {}
    for (Object localObject = j.a.rWT;; localObject = j.a.rWR)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.bHB, true, this.rWc);
      return str1;
    }
  }
  
  final String clD()
  {
    switch (this.state)
    {
    default: 
      return this.state;
    case 1: 
      return "state_decrypt";
    case 2: 
      return "state_decompress";
    case 4: 
      return "state_check_sum";
    case 8: 
      return "state_file_invalid";
    case 16: 
      return "state_file_valid";
    }
    return "state_pre_verify_check_sum";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.l
 * JD-Core Version:    0.7.0.1
 */