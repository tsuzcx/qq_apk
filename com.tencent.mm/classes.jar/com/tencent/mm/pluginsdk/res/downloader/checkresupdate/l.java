package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.res.downloader.b.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

final class l
{
  volatile String HJP;
  private final long Wmc;
  final String XUX;
  final boolean XVF;
  final boolean XVG;
  private final String XVa;
  private final int XVb;
  private final byte[] XVc;
  private final String XVe;
  private final int XVf;
  private final int XVg;
  volatile String XWi;
  final String filePath;
  private final int hCh;
  private final int hCi;
  private final boolean hCj;
  private final String hCk;
  private final boolean hCn;
  volatile int state;
  private final int subType;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(151994);
    this.state = -1;
    this.XWi = null;
    this.HJP = null;
    this.XUX = i.nL(paramInt1, paramInt2);
    this.hCh = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.XVG = paramBoolean1;
    this.XVF = paramBoolean2;
    this.XVa = paramString2;
    this.XVb = paramInt3;
    this.XVc = paramArrayOfByte;
    this.hCk = paramString3;
    this.hCn = paramBoolean3;
    this.hCj = paramBoolean4;
    this.XVe = paramString4;
    this.Wmc = paramLong;
    this.url = paramString5;
    this.XVf = paramInt4;
    this.XVg = paramInt5;
    this.hCi = paramInt6;
    AppMethodBeat.o(151994);
  }
  
  private String iJw()
  {
    AppMethodBeat.i(151998);
    if (Util.isNullOrNil(this.XWi))
    {
      AppMethodBeat.o(151998);
      return null;
    }
    String str2 = this.XUX;
    String str3 = iJx();
    String str4 = this.hCk;
    if (this.XVc == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.XVc.length))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((Util.isNullOrNil(this.hCk)) || (!Util.nullAsNil(y.bub(this.XWi)).equals(this.hCk))) {
        break;
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.XUX, iJx() });
      if (this.state == 4) {
        j.ac(this.Wmc, 23L);
      }
      str1 = this.XWi;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.ac(this.Wmc, 24L);
    }
    if ((!Util.isNullOrNil(this.XVc)) && (UtilsJni.doEcdsaSHAVerify(i.XVI, a.bqt(this.XWi), this.XVc) > 0))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.XUX, iJx() });
      if (this.state == 4) {
        j.ac(this.Wmc, 25L);
      }
      str1 = this.XWi;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.ac(this.Wmc, 26L);
    }
    AppMethodBeat.o(151998);
    return null;
  }
  
  final l iJt()
  {
    AppMethodBeat.i(151995);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.XUX, iJx(), this.XWi, this.HJP, Boolean.valueOf(Util.isNullOrNil(this.XVa)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(151995);
      return this;
    }
    if (Util.isNullOrNil(this.XVa))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.XUX });
      this.XWi = null;
      this.state = 8;
      j.ac(this.Wmc, 54L);
      j.ac(this.Wmc, 45L);
      AppMethodBeat.o(151995);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.XWi;
        str = this.HJP;
        localObject1 = this.XVa;
        localu = new u((String)localObject2);
        if ((!localu.jKS()) || (!localu.jKV()))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject2 });
          bool1 = false;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        String str;
        Object localObject1;
        u localu;
        boolean bool2;
        boolean bool1 = false;
      }
      try
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.XUX, Boolean.valueOf(bool1) });
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.XUX, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.XWi = null;
        this.state = 8;
        AppMethodBeat.o(151995);
        return this;
      }
      catch (Exception localException2)
      {
        break label474;
      }
      localu = new u(str);
      localu.jKP().jKY();
      localu.diJ();
      localObject2 = a.bqt((String)localObject2);
      if (Util.isNullOrNil((byte[])localObject2))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.ac(this.Wmc, 56L);
        j.ac(this.Wmc, 45L);
        j.ac(this.Wmc, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (Util.isNullOrNil((byte[])localObject1))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.ac(this.Wmc, 55L);
          j.ac(this.Wmc, 45L);
          j.ac(this.Wmc, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.H(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.ac(this.Wmc, 57L);
            j.ac(this.Wmc, 45L);
            j.ac(this.Wmc, 18L);
            bool1 = bool2;
            continue;
            label474:
            Log.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.XUX, localException1 });
            j.ac(this.Wmc, 45L);
            j.ac(this.Wmc, 18L);
          }
        }
      }
    }
    j.ac(this.Wmc, 17L);
    this.XWi = this.HJP;
    if (this.XVF)
    {
      this.HJP = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(151995);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(151995);
    return this;
  }
  
  final l iJu()
  {
    AppMethodBeat.i(151996);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.XUX, iJx(), this.XWi, this.HJP });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.XVG)) {
        j.a(this.hCh, this.subType, this.XVb, this.hCn, false, false, false, this.XVe);
      }
      AppMethodBeat.o(151996);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.XWi;
        str = this.HJP;
        u localu = new u((String)localObject);
        if ((!localu.jKS()) || (!localu.jKV()))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject });
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
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.XUX, Boolean.valueOf(bool) });
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.XUX, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.XWi = this.HJP;
        this.state = 4;
        j.ac(this.Wmc, 19L);
        AppMethodBeat.o(151996);
        return this;
      }
      catch (Exception localException2)
      {
        int i;
        int j;
        int k;
        j.a locala;
        break label314;
      }
      new u(str).diJ();
      localObject = s.aa(a.bqt((String)localObject));
      if (Util.isNullOrNil((byte[])localObject))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.H(str, (byte[])localObject);
        continue;
        label314:
        Log.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.XUX, localException1 });
      }
    }
    this.XWi = null;
    this.state = 8;
    j.ac(this.Wmc, 20L);
    j.ac(this.Wmc, 46L);
    if (this.XVG) {
      j.a(this.hCh, this.subType, this.XVb, this.hCn, true, false, false, this.XVe);
    }
    while ((!this.XVF) || (!this.hCj))
    {
      AppMethodBeat.o(151996);
      return this;
    }
    i = this.hCh;
    j = this.subType;
    Object localObject = this.url;
    k = this.hCi;
    if (this.XVf > this.XVg) {}
    for (locala = j.a.XWa;; locala = j.a.XVY)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.hCn, false, this.XVe);
      break;
    }
  }
  
  final String iJv()
  {
    AppMethodBeat.i(151997);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + iJx(), new Object[] { this.XUX });
    if (16 == this.state)
    {
      localObject = this.XWi;
      AppMethodBeat.o(151997);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(151997);
      return null;
    }
    String str1 = iJw();
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.XUX, str1 });
    if (this.state == 4)
    {
      if ((Util.isNullOrNil(str1)) && (!this.XVF))
      {
        j.ac(this.Wmc, 58L);
        j.ac(this.Wmc, 45L);
      }
      if (!Util.isNullOrNil(str1)) {
        break label296;
      }
      if (!this.XVG) {
        break label214;
      }
      j.a(this.hCh, this.subType, this.XVb, this.hCn, true, true, false, this.XVe);
    }
    label214:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(151997);
        return str1;
        if ((this.XVF) && (this.hCj))
        {
          i = this.hCh;
          j = this.subType;
          str2 = this.url;
          k = this.hCi;
          if (this.XVf > this.XVg) {}
          for (localObject = j.a.XWa;; localObject = j.a.XVY)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.hCn, true, this.XVe);
            break;
          }
          if (!this.XVG) {
            break;
          }
          j.a(this.hCh, this.subType, this.XVb, this.hCn, true, true, true, this.XVe);
        }
      }
    } while ((!this.XVF) || (!this.hCj));
    label296:
    int i = this.hCh;
    int j = this.subType;
    String str2 = this.url;
    int k = this.hCi;
    if (this.XVf > this.XVg) {}
    for (Object localObject = j.a.XWa;; localObject = j.a.XVY)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.hCn, true, this.XVe);
      break;
    }
  }
  
  final String iJx()
  {
    AppMethodBeat.i(151999);
    switch (this.state)
    {
    default: 
      String str = this.state;
      AppMethodBeat.o(151999);
      return str;
    case 1: 
      AppMethodBeat.o(151999);
      return "state_decrypt";
    case 2: 
      AppMethodBeat.o(151999);
      return "state_decompress";
    case 4: 
      AppMethodBeat.o(151999);
      return "state_check_sum";
    case 8: 
      AppMethodBeat.o(151999);
      return "state_file_invalid";
    case 16: 
      AppMethodBeat.o(151999);
      return "state_file_valid";
    }
    AppMethodBeat.o(151999);
    return "state_pre_verify_check_sum";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.l
 * JD-Core Version:    0.7.0.1
 */