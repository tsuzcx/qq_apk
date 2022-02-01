package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.h.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;

final class l
{
  final boolean DkI;
  final boolean DkJ;
  final String Dkb;
  private final String Dke;
  private final int Dkf;
  private final byte[] Dkg;
  private final long Dki;
  private final String Dkj;
  private final int Dkk;
  private final int Dkl;
  volatile String Dlk;
  private final int dbd;
  private final int dbe;
  private final boolean dbf;
  private final String dbg;
  private final boolean dbj;
  final String filePath;
  volatile String sMx;
  volatile int state;
  private final int subType;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(151994);
    this.state = -1;
    this.Dlk = null;
    this.sMx = null;
    this.Dkb = i.jb(paramInt1, paramInt2);
    this.dbd = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.DkJ = paramBoolean1;
    this.DkI = paramBoolean2;
    this.Dke = paramString2;
    this.Dkf = paramInt3;
    this.Dkg = paramArrayOfByte;
    this.dbg = paramString3;
    this.dbj = paramBoolean3;
    this.dbf = paramBoolean4;
    this.Dkj = paramString4;
    this.Dki = paramLong;
    this.url = paramString5;
    this.Dkk = paramInt4;
    this.Dkl = paramInt5;
    this.dbe = paramInt6;
    AppMethodBeat.o(151994);
  }
  
  private String eLV()
  {
    AppMethodBeat.i(151998);
    if (bs.isNullOrNil(this.Dlk))
    {
      AppMethodBeat.o(151998);
      return null;
    }
    String str2 = this.Dkb;
    String str3 = eLW();
    String str4 = this.dbg;
    if (this.Dkg == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.Dkg.length))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((bs.isNullOrNil(this.dbg)) || (!bs.nullAsNil(com.tencent.mm.vfs.i.aKe(this.Dlk)).equals(this.dbg))) {
        break;
      }
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.Dkb, eLW() });
      if (this.state == 4) {
        j.A(this.Dki, 23L);
      }
      str1 = this.Dlk;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.A(this.Dki, 24L);
    }
    if ((!bs.cv(this.Dkg)) && (UtilsJni.doEcdsaSHAVerify(i.DkL, a.aGK(this.Dlk), this.Dkg) > 0))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.Dkb, eLW() });
      if (this.state == 4) {
        j.A(this.Dki, 25L);
      }
      str1 = this.Dlk;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.A(this.Dki, 26L);
    }
    AppMethodBeat.o(151998);
    return null;
  }
  
  final l eLS()
  {
    AppMethodBeat.i(151995);
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.Dkb, eLW(), this.Dlk, this.sMx, Boolean.valueOf(bs.isNullOrNil(this.Dke)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(151995);
      return this;
    }
    if (bs.isNullOrNil(this.Dke))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.Dkb });
      this.Dlk = null;
      this.state = 8;
      j.A(this.Dki, 54L);
      j.A(this.Dki, 45L);
      AppMethodBeat.o(151995);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.Dlk;
        str = this.sMx;
        localObject1 = this.Dke;
        locale = new e((String)localObject2);
        if ((!locale.exists()) || (!locale.isFile()))
        {
          ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject2 });
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
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.Dkb, Boolean.valueOf(bool1) });
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.Dkb, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.Dlk = null;
        this.state = 8;
        AppMethodBeat.o(151995);
        return this;
      }
      catch (Exception localException2)
      {
        break label474;
      }
      locale = new e(str);
      locale.fxU().mkdirs();
      locale.delete();
      localObject2 = a.aGK((String)localObject2);
      if (bs.cv((byte[])localObject2))
      {
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.A(this.Dki, 56L);
        j.A(this.Dki, 45L);
        j.A(this.Dki, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (bs.cv((byte[])localObject1))
        {
          ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.A(this.Dki, 55L);
          j.A(this.Dki, 45L);
          j.A(this.Dki, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.x(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.A(this.Dki, 57L);
            j.A(this.Dki, 45L);
            j.A(this.Dki, 18L);
            bool1 = bool2;
            continue;
            label474:
            ac.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.Dkb, localException1 });
            j.A(this.Dki, 45L);
            j.A(this.Dki, 18L);
          }
        }
      }
    }
    j.A(this.Dki, 17L);
    this.Dlk = this.sMx;
    if (this.DkI)
    {
      this.sMx = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(151995);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(151995);
    return this;
  }
  
  final l eLT()
  {
    AppMethodBeat.i(151996);
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.Dkb, eLW(), this.Dlk, this.sMx });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.DkJ)) {
        j.a(this.dbd, this.subType, this.Dkf, this.dbj, false, false, false, this.Dkj);
      }
      AppMethodBeat.o(151996);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.Dlk;
        str = this.sMx;
        e locale = new e((String)localObject);
        if ((!locale.exists()) || (!locale.isFile()))
        {
          ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject });
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
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.Dkb, Boolean.valueOf(bool) });
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.Dkb, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.Dlk = this.sMx;
        this.state = 4;
        j.A(this.Dki, 19L);
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
      localObject = s.F(a.aGK((String)localObject));
      if (bs.cv((byte[])localObject))
      {
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.x(str, (byte[])localObject);
        continue;
        label314:
        ac.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.Dkb, localException1 });
      }
    }
    this.Dlk = null;
    this.state = 8;
    j.A(this.Dki, 20L);
    j.A(this.Dki, 46L);
    if (this.DkJ) {
      j.a(this.dbd, this.subType, this.Dkf, this.dbj, true, false, false, this.Dkj);
    }
    while ((!this.DkI) || (!this.dbf))
    {
      AppMethodBeat.o(151996);
      return this;
    }
    i = this.dbd;
    j = this.subType;
    Object localObject = this.url;
    k = this.dbe;
    if (this.Dkk > this.Dkl) {}
    for (locala = j.a.Dlc;; locala = j.a.Dla)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.dbj, false, this.Dkj);
      break;
    }
  }
  
  final String eLU()
  {
    AppMethodBeat.i(151997);
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + eLW(), new Object[] { this.Dkb });
    if (16 == this.state)
    {
      localObject = this.Dlk;
      AppMethodBeat.o(151997);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(151997);
      return null;
    }
    String str1 = eLV();
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.Dkb, str1 });
    if (this.state == 4)
    {
      if ((bs.isNullOrNil(str1)) && (!this.DkI))
      {
        j.A(this.Dki, 58L);
        j.A(this.Dki, 45L);
      }
      if (!bs.isNullOrNil(str1)) {
        break label296;
      }
      if (!this.DkJ) {
        break label214;
      }
      j.a(this.dbd, this.subType, this.Dkf, this.dbj, true, true, false, this.Dkj);
    }
    label214:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(151997);
        return str1;
        if ((this.DkI) && (this.dbf))
        {
          i = this.dbd;
          j = this.subType;
          str2 = this.url;
          k = this.dbe;
          if (this.Dkk > this.Dkl) {}
          for (localObject = j.a.Dlc;; localObject = j.a.Dla)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.dbj, true, this.Dkj);
            break;
          }
          if (!this.DkJ) {
            break;
          }
          j.a(this.dbd, this.subType, this.Dkf, this.dbj, true, true, true, this.Dkj);
        }
      }
    } while ((!this.DkI) || (!this.dbf));
    label296:
    int i = this.dbd;
    int j = this.subType;
    String str2 = this.url;
    int k = this.dbe;
    if (this.Dkk > this.Dkl) {}
    for (Object localObject = j.a.Dlc;; localObject = j.a.Dla)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.dbj, true, this.Dkj);
      break;
    }
  }
  
  final String eLW()
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
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.l
 * JD-Core Version:    0.7.0.1
 */