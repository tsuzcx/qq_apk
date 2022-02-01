package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.h.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;

final class l
{
  final String BRL;
  private final String BRO;
  private final int BRP;
  private final byte[] BRQ;
  private final long BRS;
  private final String BRT;
  private final int BRU;
  private final int BRV;
  volatile String BSU;
  final boolean BSs;
  final boolean BSt;
  private final int ddH;
  private final int ddI;
  private final boolean ddJ;
  private final String ddK;
  private final boolean ddN;
  final String filePath;
  volatile String rDF;
  volatile int state;
  private final int subType;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(151994);
    this.state = -1;
    this.BSU = null;
    this.rDF = null;
    this.BRL = i.iO(paramInt1, paramInt2);
    this.ddH = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.BSt = paramBoolean1;
    this.BSs = paramBoolean2;
    this.BRO = paramString2;
    this.BRP = paramInt3;
    this.BRQ = paramArrayOfByte;
    this.ddK = paramString3;
    this.ddN = paramBoolean3;
    this.ddJ = paramBoolean4;
    this.BRT = paramString4;
    this.BRS = paramLong;
    this.url = paramString5;
    this.BRU = paramInt4;
    this.BRV = paramInt5;
    this.ddI = paramInt6;
    AppMethodBeat.o(151994);
  }
  
  private String ewB()
  {
    AppMethodBeat.i(151998);
    if (bt.isNullOrNil(this.BSU))
    {
      AppMethodBeat.o(151998);
      return null;
    }
    String str2 = this.BRL;
    String str3 = ewC();
    String str4 = this.ddK;
    if (this.BRQ == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.BRQ.length))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((bt.isNullOrNil(this.ddK)) || (!bt.nullAsNil(com.tencent.mm.vfs.i.aEN(this.BSU)).equals(this.ddK))) {
        break;
      }
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.BRL, ewC() });
      if (this.state == 4) {
        j.D(this.BRS, 23L);
      }
      str1 = this.BSU;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.D(this.BRS, 24L);
    }
    if ((!bt.cw(this.BRQ)) && (UtilsJni.doEcdsaSHAVerify(i.BSv, a.aBs(this.BSU), this.BRQ) > 0))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.BRL, ewC() });
      if (this.state == 4) {
        j.D(this.BRS, 25L);
      }
      str1 = this.BSU;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.D(this.BRS, 26L);
    }
    AppMethodBeat.o(151998);
    return null;
  }
  
  final String ewA()
  {
    AppMethodBeat.i(151997);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + ewC(), new Object[] { this.BRL });
    if (16 == this.state)
    {
      localObject = this.BSU;
      AppMethodBeat.o(151997);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(151997);
      return null;
    }
    String str1 = ewB();
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.BRL, str1 });
    if (this.state == 4)
    {
      if ((bt.isNullOrNil(str1)) && (!this.BSs))
      {
        j.D(this.BRS, 58L);
        j.D(this.BRS, 45L);
      }
      if (!bt.isNullOrNil(str1)) {
        break label290;
      }
      if (!this.BSt) {
        break label208;
      }
      j.a(this.ddH, this.subType, this.BRP, this.ddN, true, true, false, this.BRT);
    }
    label208:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(151997);
        return str1;
        if ((this.BSs) && (this.ddJ))
        {
          i = this.ddH;
          j = this.subType;
          str2 = this.url;
          k = this.ddI;
          if (this.BRU > this.BRV) {}
          for (localObject = j.a.BSM;; localObject = j.a.BSK)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.ddN, true, this.BRT);
            break;
          }
          if (!this.BSt) {
            break;
          }
          j.a(this.ddH, this.subType, this.BRP, this.ddN, true, true, true, this.BRT);
        }
      }
    } while ((!this.BSs) || (!this.ddJ));
    label290:
    int i = this.ddH;
    int j = this.subType;
    String str2 = this.url;
    int k = this.ddI;
    if (this.BRU > this.BRV) {}
    for (Object localObject = j.a.BSM;; localObject = j.a.BSK)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.ddN, true, this.BRT);
      break;
    }
  }
  
  final String ewC()
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
  
  final l ewy()
  {
    AppMethodBeat.i(151995);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.BRL, ewC(), this.BSU, this.rDF, Boolean.valueOf(bt.isNullOrNil(this.BRO)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(151995);
      return this;
    }
    if (bt.isNullOrNil(this.BRO))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.BRL });
      this.BSU = null;
      this.state = 8;
      j.D(this.BRS, 54L);
      j.D(this.BRS, 45L);
      AppMethodBeat.o(151995);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.BSU;
        str = this.rDF;
        localObject1 = this.BRO;
        locale = new e((String)localObject2);
        if ((!locale.exists()) || (!locale.isFile()))
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject2 });
          bool1 = false;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        String str;
        Object localObject1;
        e locale;
        boolean bool2;
        boolean bool1 = false;
      }
      try
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.BRL, Boolean.valueOf(bool1) });
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.BRL, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.BSU = null;
        this.state = 8;
        AppMethodBeat.o(151995);
        return this;
      }
      catch (Exception localException2)
      {
        break label480;
      }
      locale = new e(str);
      locale.fhT().mkdirs();
      locale.delete();
      localObject2 = a.aBs((String)localObject2);
      if (bt.cw((byte[])localObject2))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.D(this.BRS, 56L);
        j.D(this.BRS, 45L);
        j.D(this.BRS, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (bt.cw((byte[])localObject1))
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.D(this.BRS, 55L);
          j.D(this.BRS, 45L);
          j.D(this.BRS, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.x(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.D(this.BRS, 57L);
            j.D(this.BRS, 45L);
            j.D(this.BRS, 18L);
            bool1 = bool2;
            continue;
            label480:
            ad.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.BRL, localException1 });
            j.D(this.BRS, 45L);
            j.D(this.BRS, 18L);
          }
        }
      }
    }
    j.D(this.BRS, 17L);
    this.BSU = this.rDF;
    if (this.BSs)
    {
      this.rDF = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(151995);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(151995);
    return this;
  }
  
  final l ewz()
  {
    AppMethodBeat.i(151996);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.BRL, ewC(), this.BSU, this.rDF });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.BSt)) {
        j.a(this.ddH, this.subType, this.BRP, this.ddN, false, false, false, this.BRT);
      }
      AppMethodBeat.o(151996);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.BSU;
        str = this.rDF;
        e locale = new e((String)localObject);
        if ((!locale.exists()) || (!locale.isFile()))
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject });
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
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.BRL, Boolean.valueOf(bool) });
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.BRL, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.BSU = this.rDF;
        this.state = 4;
        j.D(this.BRS, 19L);
        AppMethodBeat.o(151996);
        return this;
      }
      catch (Exception localException2)
      {
        int i;
        int j;
        int k;
        j.a locala;
        break label315;
      }
      new e(str).delete();
      localObject = s.H(a.aBs((String)localObject));
      if (bt.cw((byte[])localObject))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.x(str, (byte[])localObject);
        continue;
        label315:
        ad.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.BRL, localException1 });
      }
    }
    this.BSU = null;
    this.state = 8;
    j.D(this.BRS, 20L);
    j.D(this.BRS, 46L);
    if (this.BSt) {
      j.a(this.ddH, this.subType, this.BRP, this.ddN, true, false, false, this.BRT);
    }
    while ((!this.BSs) || (!this.ddJ))
    {
      AppMethodBeat.o(151996);
      return this;
    }
    i = this.ddH;
    j = this.subType;
    Object localObject = this.url;
    k = this.ddI;
    if (this.BRU > this.BRV) {}
    for (locala = j.a.BSM;; locala = j.a.BSK)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.ddN, false, this.BRT);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.l
 * JD-Core Version:    0.7.0.1
 */