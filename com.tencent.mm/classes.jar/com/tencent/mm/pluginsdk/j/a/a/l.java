package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;

final class l
{
  private final long DAq;
  final boolean EPK;
  final boolean EPL;
  final String EPe;
  private final String EPh;
  private final int EPi;
  private final byte[] EPj;
  private final String EPl;
  private final int EPm;
  private final int EPn;
  volatile String EQm;
  private final String dmA;
  private final boolean dmD;
  private final int dmx;
  private final int dmy;
  private final boolean dmz;
  final String filePath;
  volatile int state;
  private final int subType;
  volatile String tJf;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(151994);
    this.state = -1;
    this.EQm = null;
    this.tJf = null;
    this.EPe = i.jn(paramInt1, paramInt2);
    this.dmx = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.EPL = paramBoolean1;
    this.EPK = paramBoolean2;
    this.EPh = paramString2;
    this.EPi = paramInt3;
    this.EPj = paramArrayOfByte;
    this.dmA = paramString3;
    this.dmD = paramBoolean3;
    this.dmz = paramBoolean4;
    this.EPl = paramString4;
    this.DAq = paramLong;
    this.url = paramString5;
    this.EPm = paramInt4;
    this.EPn = paramInt5;
    this.dmy = paramInt6;
    AppMethodBeat.o(151994);
  }
  
  private String faS()
  {
    AppMethodBeat.i(151998);
    if (bt.isNullOrNil(this.EQm))
    {
      AppMethodBeat.o(151998);
      return null;
    }
    String str2 = this.EPe;
    String str3 = faT();
    String str4 = this.dmA;
    if (this.EPj == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.EPj.length))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((bt.isNullOrNil(this.dmA)) || (!bt.nullAsNil(com.tencent.mm.vfs.i.aPK(this.EQm)).equals(this.dmA))) {
        break;
      }
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.EPe, faT() });
      if (this.state == 4) {
        j.A(this.DAq, 23L);
      }
      str1 = this.EQm;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.A(this.DAq, 24L);
    }
    if ((!bt.cC(this.EPj)) && (UtilsJni.doEcdsaSHAVerify(i.EPN, a.aMk(this.EQm), this.EPj) > 0))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.EPe, faT() });
      if (this.state == 4) {
        j.A(this.DAq, 25L);
      }
      str1 = this.EQm;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.A(this.DAq, 26L);
    }
    AppMethodBeat.o(151998);
    return null;
  }
  
  final l faP()
  {
    AppMethodBeat.i(151995);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.EPe, faT(), this.EQm, this.tJf, Boolean.valueOf(bt.isNullOrNil(this.EPh)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(151995);
      return this;
    }
    if (bt.isNullOrNil(this.EPh))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.EPe });
      this.EQm = null;
      this.state = 8;
      j.A(this.DAq, 54L);
      j.A(this.DAq, 45L);
      AppMethodBeat.o(151995);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.EQm;
        str = this.tJf;
        localObject1 = this.EPh;
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
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.EPe, Boolean.valueOf(bool1) });
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.EPe, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.EQm = null;
        this.state = 8;
        AppMethodBeat.o(151995);
        return this;
      }
      catch (Exception localException2)
      {
        break label474;
      }
      locale = new e(str);
      locale.fOJ().mkdirs();
      locale.delete();
      localObject2 = a.aMk((String)localObject2);
      if (bt.cC((byte[])localObject2))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.A(this.DAq, 56L);
        j.A(this.DAq, 45L);
        j.A(this.DAq, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (bt.cC((byte[])localObject1))
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.A(this.DAq, 55L);
          j.A(this.DAq, 45L);
          j.A(this.DAq, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.y(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.A(this.DAq, 57L);
            j.A(this.DAq, 45L);
            j.A(this.DAq, 18L);
            bool1 = bool2;
            continue;
            label474:
            ad.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.EPe, localException1 });
            j.A(this.DAq, 45L);
            j.A(this.DAq, 18L);
          }
        }
      }
    }
    j.A(this.DAq, 17L);
    this.EQm = this.tJf;
    if (this.EPK)
    {
      this.tJf = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(151995);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(151995);
    return this;
  }
  
  final l faQ()
  {
    AppMethodBeat.i(151996);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.EPe, faT(), this.EQm, this.tJf });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.EPL)) {
        j.a(this.dmx, this.subType, this.EPi, this.dmD, false, false, false, this.EPl);
      }
      AppMethodBeat.o(151996);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.EQm;
        str = this.tJf;
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
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.EPe, Boolean.valueOf(bool) });
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.EPe, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.EQm = this.tJf;
        this.state = 4;
        j.A(this.DAq, 19L);
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
      new e(str).delete();
      localObject = s.F(a.aMk((String)localObject));
      if (bt.cC((byte[])localObject))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.y(str, (byte[])localObject);
        continue;
        label314:
        ad.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.EPe, localException1 });
      }
    }
    this.EQm = null;
    this.state = 8;
    j.A(this.DAq, 20L);
    j.A(this.DAq, 46L);
    if (this.EPL) {
      j.a(this.dmx, this.subType, this.EPi, this.dmD, true, false, false, this.EPl);
    }
    while ((!this.EPK) || (!this.dmz))
    {
      AppMethodBeat.o(151996);
      return this;
    }
    i = this.dmx;
    j = this.subType;
    Object localObject = this.url;
    k = this.dmy;
    if (this.EPm > this.EPn) {}
    for (locala = j.a.EQe;; locala = j.a.EQc)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.dmD, false, this.EPl);
      break;
    }
  }
  
  final String faR()
  {
    AppMethodBeat.i(151997);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + faT(), new Object[] { this.EPe });
    if (16 == this.state)
    {
      localObject = this.EQm;
      AppMethodBeat.o(151997);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(151997);
      return null;
    }
    String str1 = faS();
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.EPe, str1 });
    if (this.state == 4)
    {
      if ((bt.isNullOrNil(str1)) && (!this.EPK))
      {
        j.A(this.DAq, 58L);
        j.A(this.DAq, 45L);
      }
      if (!bt.isNullOrNil(str1)) {
        break label296;
      }
      if (!this.EPL) {
        break label214;
      }
      j.a(this.dmx, this.subType, this.EPi, this.dmD, true, true, false, this.EPl);
    }
    label214:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(151997);
        return str1;
        if ((this.EPK) && (this.dmz))
        {
          i = this.dmx;
          j = this.subType;
          str2 = this.url;
          k = this.dmy;
          if (this.EPm > this.EPn) {}
          for (localObject = j.a.EQe;; localObject = j.a.EQc)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.dmD, true, this.EPl);
            break;
          }
          if (!this.EPL) {
            break;
          }
          j.a(this.dmx, this.subType, this.EPi, this.dmD, true, true, true, this.EPl);
        }
      }
    } while ((!this.EPK) || (!this.dmz));
    label296:
    int i = this.dmx;
    int j = this.subType;
    String str2 = this.url;
    int k = this.dmy;
    if (this.EPm > this.EPn) {}
    for (Object localObject = j.a.EQe;; localObject = j.a.EQc)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.dmD, true, this.EPl);
      break;
    }
  }
  
  final String faT()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.l
 * JD-Core Version:    0.7.0.1
 */