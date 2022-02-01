package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

final class l
{
  private final long DRK;
  private final String FhC;
  private final int FhD;
  private final byte[] FhE;
  private final String FhG;
  private final int FhH;
  private final int FhI;
  final String Fhz;
  volatile String FiH;
  final boolean Fif;
  final boolean Fig;
  private final int dnA;
  private final boolean dnB;
  private final String dnC;
  private final boolean dnF;
  private final int dnz;
  final String filePath;
  volatile int state;
  private final int subType;
  volatile String tTW;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(151994);
    this.state = -1;
    this.FiH = null;
    this.tTW = null;
    this.Fhz = i.jr(paramInt1, paramInt2);
    this.dnz = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.Fig = paramBoolean1;
    this.Fif = paramBoolean2;
    this.FhC = paramString2;
    this.FhD = paramInt3;
    this.FhE = paramArrayOfByte;
    this.dnC = paramString3;
    this.dnF = paramBoolean3;
    this.dnB = paramBoolean4;
    this.FhG = paramString4;
    this.DRK = paramLong;
    this.url = paramString5;
    this.FhH = paramInt4;
    this.FhI = paramInt5;
    this.dnA = paramInt6;
    AppMethodBeat.o(151994);
  }
  
  private String feG()
  {
    AppMethodBeat.i(151998);
    if (bu.isNullOrNil(this.FiH))
    {
      AppMethodBeat.o(151998);
      return null;
    }
    String str2 = this.Fhz;
    String str3 = feH();
    String str4 = this.dnC;
    if (this.FhE == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.FhE.length))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((bu.isNullOrNil(this.dnC)) || (!bu.nullAsNil(o.aRh(this.FiH)).equals(this.dnC))) {
        break;
      }
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.Fhz, feH() });
      if (this.state == 4) {
        j.A(this.DRK, 23L);
      }
      str1 = this.FiH;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.A(this.DRK, 24L);
    }
    if ((!bu.cF(this.FhE)) && (UtilsJni.doEcdsaSHAVerify(i.Fii, a.aNG(this.FiH), this.FhE) > 0))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.Fhz, feH() });
      if (this.state == 4) {
        j.A(this.DRK, 25L);
      }
      str1 = this.FiH;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.A(this.DRK, 26L);
    }
    AppMethodBeat.o(151998);
    return null;
  }
  
  final l feD()
  {
    AppMethodBeat.i(151995);
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.Fhz, feH(), this.FiH, this.tTW, Boolean.valueOf(bu.isNullOrNil(this.FhC)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(151995);
      return this;
    }
    if (bu.isNullOrNil(this.FhC))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.Fhz });
      this.FiH = null;
      this.state = 8;
      j.A(this.DRK, 54L);
      j.A(this.DRK, 45L);
      AppMethodBeat.o(151995);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.FiH;
        str = this.tTW;
        localObject1 = this.FhC;
        localk = new k((String)localObject2);
        if ((!localk.exists()) || (!localk.isFile()))
        {
          ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject2 });
          bool1 = false;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        String str;
        Object localObject1;
        k localk;
        boolean bool2;
        boolean bool1 = false;
      }
      try
      {
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.Fhz, Boolean.valueOf(bool1) });
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.Fhz, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.FiH = null;
        this.state = 8;
        AppMethodBeat.o(151995);
        return this;
      }
      catch (Exception localException2)
      {
        break label474;
      }
      localk = new k(str);
      localk.fTg().mkdirs();
      localk.delete();
      localObject2 = a.aNG((String)localObject2);
      if (bu.cF((byte[])localObject2))
      {
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.A(this.DRK, 56L);
        j.A(this.DRK, 45L);
        j.A(this.DRK, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (bu.cF((byte[])localObject1))
        {
          ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.A(this.DRK, 55L);
          j.A(this.DRK, 45L);
          j.A(this.DRK, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.y(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.A(this.DRK, 57L);
            j.A(this.DRK, 45L);
            j.A(this.DRK, 18L);
            bool1 = bool2;
            continue;
            label474:
            ae.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.Fhz, localException1 });
            j.A(this.DRK, 45L);
            j.A(this.DRK, 18L);
          }
        }
      }
    }
    j.A(this.DRK, 17L);
    this.FiH = this.tTW;
    if (this.Fif)
    {
      this.tTW = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(151995);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(151995);
    return this;
  }
  
  final l feE()
  {
    AppMethodBeat.i(151996);
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.Fhz, feH(), this.FiH, this.tTW });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.Fig)) {
        j.a(this.dnz, this.subType, this.FhD, this.dnF, false, false, false, this.FhG);
      }
      AppMethodBeat.o(151996);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.FiH;
        str = this.tTW;
        k localk = new k((String)localObject);
        if ((!localk.exists()) || (!localk.isFile()))
        {
          ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject });
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
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.Fhz, Boolean.valueOf(bool) });
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.Fhz, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.FiH = this.tTW;
        this.state = 4;
        j.A(this.DRK, 19L);
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
      new k(str).delete();
      localObject = s.F(a.aNG((String)localObject));
      if (bu.cF((byte[])localObject))
      {
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.y(str, (byte[])localObject);
        continue;
        label314:
        ae.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.Fhz, localException1 });
      }
    }
    this.FiH = null;
    this.state = 8;
    j.A(this.DRK, 20L);
    j.A(this.DRK, 46L);
    if (this.Fig) {
      j.a(this.dnz, this.subType, this.FhD, this.dnF, true, false, false, this.FhG);
    }
    while ((!this.Fif) || (!this.dnB))
    {
      AppMethodBeat.o(151996);
      return this;
    }
    i = this.dnz;
    j = this.subType;
    Object localObject = this.url;
    k = this.dnA;
    if (this.FhH > this.FhI) {}
    for (locala = j.a.Fiz;; locala = j.a.Fix)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.dnF, false, this.FhG);
      break;
    }
  }
  
  final String feF()
  {
    AppMethodBeat.i(151997);
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + feH(), new Object[] { this.Fhz });
    if (16 == this.state)
    {
      localObject = this.FiH;
      AppMethodBeat.o(151997);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(151997);
      return null;
    }
    String str1 = feG();
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.Fhz, str1 });
    if (this.state == 4)
    {
      if ((bu.isNullOrNil(str1)) && (!this.Fif))
      {
        j.A(this.DRK, 58L);
        j.A(this.DRK, 45L);
      }
      if (!bu.isNullOrNil(str1)) {
        break label296;
      }
      if (!this.Fig) {
        break label214;
      }
      j.a(this.dnz, this.subType, this.FhD, this.dnF, true, true, false, this.FhG);
    }
    label214:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(151997);
        return str1;
        if ((this.Fif) && (this.dnB))
        {
          i = this.dnz;
          j = this.subType;
          str2 = this.url;
          k = this.dnA;
          if (this.FhH > this.FhI) {}
          for (localObject = j.a.Fiz;; localObject = j.a.Fix)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.dnF, true, this.FhG);
            break;
          }
          if (!this.Fig) {
            break;
          }
          j.a(this.dnz, this.subType, this.FhD, this.dnF, true, true, true, this.FhG);
        }
      }
    } while ((!this.Fif) || (!this.dnB));
    label296:
    int i = this.dnz;
    int j = this.subType;
    String str2 = this.url;
    int k = this.dnA;
    if (this.FhH > this.FhI) {}
    for (Object localObject = j.a.Fiz;; localObject = j.a.Fix)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.dnF, true, this.FhG);
      break;
    }
  }
  
  final String feH()
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
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.l
 * JD-Core Version:    0.7.0.1
 */