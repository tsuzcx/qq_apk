package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

final class l
{
  private final long IBJ;
  private final int JYA;
  private final int JYB;
  final boolean JYZ;
  final String JYs;
  private final String JYv;
  private final int JYw;
  private final byte[] JYx;
  private final String JYz;
  volatile String JZB;
  final boolean JZa;
  private final int dEO;
  private final int dEP;
  private final boolean dEQ;
  private final String dER;
  private final boolean dEU;
  final String filePath;
  volatile int state;
  private final int subType;
  private final String url;
  volatile String xli;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(151994);
    this.state = -1;
    this.JZB = null;
    this.xli = null;
    this.JYs = i.kD(paramInt1, paramInt2);
    this.dEO = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.JZa = paramBoolean1;
    this.JYZ = paramBoolean2;
    this.JYv = paramString2;
    this.JYw = paramInt3;
    this.JYx = paramArrayOfByte;
    this.dER = paramString3;
    this.dEU = paramBoolean3;
    this.dEQ = paramBoolean4;
    this.JYz = paramString4;
    this.IBJ = paramLong;
    this.url = paramString5;
    this.JYA = paramInt4;
    this.JYB = paramInt5;
    this.dEP = paramInt6;
    AppMethodBeat.o(151994);
  }
  
  private String gnQ()
  {
    AppMethodBeat.i(151998);
    if (Util.isNullOrNil(this.JZB))
    {
      AppMethodBeat.o(151998);
      return null;
    }
    String str2 = this.JYs;
    String str3 = gnR();
    String str4 = this.dER;
    if (this.JYx == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.JYx.length))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((Util.isNullOrNil(this.dER)) || (!Util.nullAsNil(com.tencent.mm.vfs.s.bhK(this.JZB)).equals(this.dER))) {
        break;
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.JYs, gnR() });
      if (this.state == 4) {
        j.F(this.IBJ, 23L);
      }
      str1 = this.JZB;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.F(this.IBJ, 24L);
    }
    if ((!Util.isNullOrNil(this.JYx)) && (UtilsJni.doEcdsaSHAVerify(i.JZc, a.bei(this.JZB), this.JYx) > 0))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.JYs, gnR() });
      if (this.state == 4) {
        j.F(this.IBJ, 25L);
      }
      str1 = this.JZB;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.F(this.IBJ, 26L);
    }
    AppMethodBeat.o(151998);
    return null;
  }
  
  final l gnN()
  {
    AppMethodBeat.i(151995);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.JYs, gnR(), this.JZB, this.xli, Boolean.valueOf(Util.isNullOrNil(this.JYv)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(151995);
      return this;
    }
    if (Util.isNullOrNil(this.JYv))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.JYs });
      this.JZB = null;
      this.state = 8;
      j.F(this.IBJ, 54L);
      j.F(this.IBJ, 45L);
      AppMethodBeat.o(151995);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.JZB;
        str = this.xli;
        localObject1 = this.JYv;
        localo = new o((String)localObject2);
        if ((!localo.exists()) || (!localo.isFile()))
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
        o localo;
        boolean bool2;
        boolean bool1 = false;
      }
      try
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.JYs, Boolean.valueOf(bool1) });
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.JYs, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.JZB = null;
        this.state = 8;
        AppMethodBeat.o(151995);
        return this;
      }
      catch (Exception localException2)
      {
        break label474;
      }
      localo = new o(str);
      localo.heq().mkdirs();
      localo.delete();
      localObject2 = a.bei((String)localObject2);
      if (Util.isNullOrNil((byte[])localObject2))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.F(this.IBJ, 56L);
        j.F(this.IBJ, 45L);
        j.F(this.IBJ, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (Util.isNullOrNil((byte[])localObject1))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.F(this.IBJ, 55L);
          j.F(this.IBJ, 45L);
          j.F(this.IBJ, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.y(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.F(this.IBJ, 57L);
            j.F(this.IBJ, 45L);
            j.F(this.IBJ, 18L);
            bool1 = bool2;
            continue;
            label474:
            Log.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.JYs, localException1 });
            j.F(this.IBJ, 45L);
            j.F(this.IBJ, 18L);
          }
        }
      }
    }
    j.F(this.IBJ, 17L);
    this.JZB = this.xli;
    if (this.JYZ)
    {
      this.xli = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(151995);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(151995);
    return this;
  }
  
  final l gnO()
  {
    AppMethodBeat.i(151996);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.JYs, gnR(), this.JZB, this.xli });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.JZa)) {
        j.a(this.dEO, this.subType, this.JYw, this.dEU, false, false, false, this.JYz);
      }
      AppMethodBeat.o(151996);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.JZB;
        str = this.xli;
        o localo = new o((String)localObject);
        if ((!localo.exists()) || (!localo.isFile()))
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
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.JYs, Boolean.valueOf(bool) });
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.JYs, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.JZB = this.xli;
        this.state = 4;
        j.F(this.IBJ, 19L);
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
      new o(str).delete();
      localObject = com.tencent.mm.b.s.T(a.bei((String)localObject));
      if (Util.isNullOrNil((byte[])localObject))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.y(str, (byte[])localObject);
        continue;
        label314:
        Log.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.JYs, localException1 });
      }
    }
    this.JZB = null;
    this.state = 8;
    j.F(this.IBJ, 20L);
    j.F(this.IBJ, 46L);
    if (this.JZa) {
      j.a(this.dEO, this.subType, this.JYw, this.dEU, true, false, false, this.JYz);
    }
    while ((!this.JYZ) || (!this.dEQ))
    {
      AppMethodBeat.o(151996);
      return this;
    }
    i = this.dEO;
    j = this.subType;
    Object localObject = this.url;
    k = this.dEP;
    if (this.JYA > this.JYB) {}
    for (locala = j.a.JZt;; locala = j.a.JZr)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.dEU, false, this.JYz);
      break;
    }
  }
  
  final String gnP()
  {
    AppMethodBeat.i(151997);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + gnR(), new Object[] { this.JYs });
    if (16 == this.state)
    {
      localObject = this.JZB;
      AppMethodBeat.o(151997);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(151997);
      return null;
    }
    String str1 = gnQ();
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.JYs, str1 });
    if (this.state == 4)
    {
      if ((Util.isNullOrNil(str1)) && (!this.JYZ))
      {
        j.F(this.IBJ, 58L);
        j.F(this.IBJ, 45L);
      }
      if (!Util.isNullOrNil(str1)) {
        break label296;
      }
      if (!this.JZa) {
        break label214;
      }
      j.a(this.dEO, this.subType, this.JYw, this.dEU, true, true, false, this.JYz);
    }
    label214:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(151997);
        return str1;
        if ((this.JYZ) && (this.dEQ))
        {
          i = this.dEO;
          j = this.subType;
          str2 = this.url;
          k = this.dEP;
          if (this.JYA > this.JYB) {}
          for (localObject = j.a.JZt;; localObject = j.a.JZr)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.dEU, true, this.JYz);
            break;
          }
          if (!this.JZa) {
            break;
          }
          j.a(this.dEO, this.subType, this.JYw, this.dEU, true, true, true, this.JYz);
        }
      }
    } while ((!this.JYZ) || (!this.dEQ));
    label296:
    int i = this.dEO;
    int j = this.subType;
    String str2 = this.url;
    int k = this.dEP;
    if (this.JYA > this.JYB) {}
    for (Object localObject = j.a.JZt;; localObject = j.a.JZr)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.dEU, true, this.JYz);
      break;
    }
  }
  
  final String gnR()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.l
 * JD-Core Version:    0.7.0.1
 */