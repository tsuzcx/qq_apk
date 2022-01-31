package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.r;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

final class l
{
  private final int coJ;
  private final int coK;
  private final boolean coL;
  private final String coM;
  private final boolean coQ;
  final String filePath;
  volatile int state;
  private final int subType;
  private final String url;
  final String vMK;
  private final String vMN;
  private final int vMO;
  private final byte[] vMP;
  private final long vMR;
  private final String vMS;
  private final int vMT;
  private final int vMU;
  volatile String vNT;
  volatile String vNU;
  final boolean vNr;
  final boolean vNs;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(79550);
    this.state = -1;
    this.vNT = null;
    this.vNU = null;
    this.vMK = i.hd(paramInt1, paramInt2);
    this.coJ = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.vNs = paramBoolean1;
    this.vNr = paramBoolean2;
    this.vMN = paramString2;
    this.vMO = paramInt3;
    this.vMP = paramArrayOfByte;
    this.coM = paramString3;
    this.coQ = paramBoolean3;
    this.coL = paramBoolean4;
    this.vMS = paramString4;
    this.vMR = paramLong;
    this.url = paramString5;
    this.vMT = paramInt4;
    this.vMU = paramInt5;
    this.coK = paramInt6;
    AppMethodBeat.o(79550);
  }
  
  private String dmp()
  {
    AppMethodBeat.i(79554);
    if (bo.isNullOrNil(this.vNT))
    {
      AppMethodBeat.o(79554);
      return null;
    }
    String str2 = this.vMK;
    String str3 = dmq();
    String str4 = this.coM;
    if (this.vMP == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.vMP.length))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((bo.isNullOrNil(this.coM)) || (!bo.nullAsNil(g.getMD5(this.vNT)).equals(this.coM))) {
        break;
      }
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.vMK, dmq() });
      if (this.state == 4) {
        j.B(this.vMR, 23L);
      }
      str1 = this.vNT;
      AppMethodBeat.o(79554);
      return str1;
    }
    if (this.state == 4) {
      j.B(this.vMR, 24L);
    }
    if ((!bo.ce(this.vMP)) && (UtilsJni.doEcdsaSHAVerify(i.vNu, a.alS(this.vNT), this.vMP) > 0))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.vMK, dmq() });
      if (this.state == 4) {
        j.B(this.vMR, 25L);
      }
      str1 = this.vNT;
      AppMethodBeat.o(79554);
      return str1;
    }
    if (this.state == 4) {
      j.B(this.vMR, 26L);
    }
    AppMethodBeat.o(79554);
    return null;
  }
  
  final l dmm()
  {
    AppMethodBeat.i(79551);
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.vMK, dmq(), this.vNT, this.vNU, Boolean.valueOf(bo.isNullOrNil(this.vMN)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(79551);
      return this;
    }
    if (bo.isNullOrNil(this.vMN))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.vMK });
      this.vNT = null;
      this.state = 8;
      j.B(this.vMR, 54L);
      j.B(this.vMR, 45L);
      AppMethodBeat.o(79551);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.vNT;
        str = this.vNU;
        localObject1 = this.vMN;
        localFile = new File((String)localObject2);
        if ((!localFile.exists()) || (!localFile.isFile()))
        {
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject2 });
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
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.vMK, Boolean.valueOf(bool1) });
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.vMK, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.vNT = null;
        this.state = 8;
        AppMethodBeat.o(79551);
        return this;
      }
      catch (Exception localException2)
      {
        break label474;
      }
      localFile = new File(str);
      localFile.getParentFile().mkdirs();
      localFile.delete();
      localObject2 = a.alS((String)localObject2);
      if (bo.ce((byte[])localObject2))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.B(this.vMR, 56L);
        j.B(this.vMR, 45L);
        j.B(this.vMR, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (bo.ce((byte[])localObject1))
        {
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.B(this.vMR, 55L);
          j.B(this.vMR, 45L);
          j.B(this.vMR, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.D(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.B(this.vMR, 57L);
            j.B(this.vMR, 45L);
            j.B(this.vMR, 18L);
            bool1 = bool2;
            continue;
            label474:
            ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.vMK, localException1 });
            j.B(this.vMR, 45L);
            j.B(this.vMR, 18L);
          }
        }
      }
    }
    j.B(this.vMR, 17L);
    this.vNT = this.vNU;
    if (this.vNr)
    {
      this.vNU = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(79551);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(79551);
    return this;
  }
  
  final l dmn()
  {
    AppMethodBeat.i(79552);
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.vMK, dmq(), this.vNT, this.vNU });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.vNs)) {
        j.a(this.coJ, this.subType, this.vMO, this.coQ, false, false, false, this.vMS);
      }
      AppMethodBeat.o(79552);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.vNT;
        str = this.vNU;
        File localFile = new File((String)localObject);
        if ((!localFile.exists()) || (!localFile.isFile()))
        {
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject });
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
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.vMK, Boolean.valueOf(bool) });
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.vMK, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.vNT = this.vNU;
        this.state = 4;
        j.B(this.vMR, 19L);
        AppMethodBeat.o(79552);
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
      new File(str).delete();
      localObject = r.A(a.alS((String)localObject));
      if (bo.ce((byte[])localObject))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.D(str, (byte[])localObject);
        continue;
        label314:
        ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.vMK, localException1 });
      }
    }
    this.vNT = null;
    this.state = 8;
    j.B(this.vMR, 20L);
    j.B(this.vMR, 46L);
    if (this.vNs) {
      j.a(this.coJ, this.subType, this.vMO, this.coQ, true, false, false, this.vMS);
    }
    while ((!this.vNr) || (!this.coL))
    {
      AppMethodBeat.o(79552);
      return this;
    }
    i = this.coJ;
    j = this.subType;
    Object localObject = this.url;
    k = this.coK;
    if (this.vMT > this.vMU) {}
    for (locala = j.a.vNL;; locala = j.a.vNJ)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.coQ, false, this.vMS);
      break;
    }
  }
  
  final String dmo()
  {
    AppMethodBeat.i(79553);
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + dmq(), new Object[] { this.vMK });
    if (16 == this.state)
    {
      localObject = this.vNT;
      AppMethodBeat.o(79553);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(79553);
      return null;
    }
    String str1 = dmp();
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.vMK, str1 });
    if (this.state == 4)
    {
      if ((bo.isNullOrNil(str1)) && (!this.vNr))
      {
        j.B(this.vMR, 58L);
        j.B(this.vMR, 45L);
      }
      if (!bo.isNullOrNil(str1)) {
        break label296;
      }
      if (!this.vNs) {
        break label214;
      }
      j.a(this.coJ, this.subType, this.vMO, this.coQ, true, true, false, this.vMS);
    }
    label214:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(79553);
        return str1;
        if ((this.vNr) && (this.coL))
        {
          i = this.coJ;
          j = this.subType;
          str2 = this.url;
          k = this.coK;
          if (this.vMT > this.vMU) {}
          for (localObject = j.a.vNL;; localObject = j.a.vNJ)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.coQ, true, this.vMS);
            break;
          }
          if (!this.vNs) {
            break;
          }
          j.a(this.coJ, this.subType, this.vMO, this.coQ, true, true, true, this.vMS);
        }
      }
    } while ((!this.vNr) || (!this.coL));
    label296:
    int i = this.coJ;
    int j = this.subType;
    String str2 = this.url;
    int k = this.coK;
    if (this.vMT > this.vMU) {}
    for (Object localObject = j.a.vNL;; localObject = j.a.vNJ)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.coQ, true, this.vMS);
      break;
    }
  }
  
  final String dmq()
  {
    AppMethodBeat.i(79555);
    switch (this.state)
    {
    default: 
      String str = this.state;
      AppMethodBeat.o(79555);
      return str;
    case 1: 
      AppMethodBeat.o(79555);
      return "state_decrypt";
    case 2: 
      AppMethodBeat.o(79555);
      return "state_decompress";
    case 4: 
      AppMethodBeat.o(79555);
      return "state_check_sum";
    case 8: 
      AppMethodBeat.o(79555);
      return "state_file_invalid";
    case 16: 
      AppMethodBeat.o(79555);
      return "state_file_valid";
    }
    AppMethodBeat.o(79555);
    return "state_pre_verify_check_sum";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.l
 * JD-Core Version:    0.7.0.1
 */