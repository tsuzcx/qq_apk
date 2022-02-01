package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.k.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

final class l
{
  volatile String BXC;
  private final long PvW;
  final String QYU;
  private final String QYX;
  private final int QYY;
  private final byte[] QYZ;
  final boolean QZB;
  final boolean QZC;
  private final String QZb;
  private final int QZc;
  private final int QZd;
  volatile String Rae;
  final String filePath;
  private final int fxC;
  private final int fxD;
  private final boolean fxE;
  private final String fxF;
  private final boolean fxI;
  volatile int state;
  private final int subType;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(151994);
    this.state = -1;
    this.Rae = null;
    this.BXC = null;
    this.QYU = i.lW(paramInt1, paramInt2);
    this.fxC = paramInt1;
    this.subType = paramInt2;
    this.filePath = paramString1;
    this.QZC = paramBoolean1;
    this.QZB = paramBoolean2;
    this.QYX = paramString2;
    this.QYY = paramInt3;
    this.QYZ = paramArrayOfByte;
    this.fxF = paramString3;
    this.fxI = paramBoolean3;
    this.fxE = paramBoolean4;
    this.QZb = paramString4;
    this.PvW = paramLong;
    this.url = paramString5;
    this.QZc = paramInt4;
    this.QZd = paramInt5;
    this.fxD = paramInt6;
    AppMethodBeat.o(151994);
  }
  
  private String hix()
  {
    AppMethodBeat.i(151998);
    if (Util.isNullOrNil(this.Rae))
    {
      AppMethodBeat.o(151998);
      return null;
    }
    String str2 = this.QYU;
    String str3 = hiy();
    String str4 = this.fxF;
    if (this.QYZ == null) {}
    for (String str1 = "null";; str1 = String.valueOf(this.QYZ.length))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
      if ((Util.isNullOrNil(this.fxF)) || (!Util.nullAsNil(u.buc(this.Rae)).equals(this.fxF))) {
        break;
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.QYU, hiy() });
      if (this.state == 4) {
        j.F(this.PvW, 23L);
      }
      str1 = this.Rae;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.F(this.PvW, 24L);
    }
    if ((!Util.isNullOrNil(this.QYZ)) && (UtilsJni.doEcdsaSHAVerify(i.QZE, a.bqE(this.Rae), this.QYZ) > 0))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.QYU, hiy() });
      if (this.state == 4) {
        j.F(this.PvW, 25L);
      }
      str1 = this.Rae;
      AppMethodBeat.o(151998);
      return str1;
    }
    if (this.state == 4) {
      j.F(this.PvW, 26L);
    }
    AppMethodBeat.o(151998);
    return null;
  }
  
  final l hiu()
  {
    AppMethodBeat.i(151995);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.QYU, hiy(), this.Rae, this.BXC, Boolean.valueOf(Util.isNullOrNil(this.QYX)) });
    if (1 != this.state)
    {
      AppMethodBeat.o(151995);
      return this;
    }
    if (Util.isNullOrNil(this.QYX))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.QYU });
      this.Rae = null;
      this.state = 8;
      j.F(this.PvW, 54L);
      j.F(this.PvW, 45L);
      AppMethodBeat.o(151995);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.Rae;
        str = this.BXC;
        localObject1 = this.QYX;
        localq = new q((String)localObject2);
        if ((!localq.ifE()) || (!localq.ifH()))
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
        q localq;
        boolean bool2;
        boolean bool1 = false;
      }
      try
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.QYU, Boolean.valueOf(bool1) });
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.QYU, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.Rae = null;
        this.state = 8;
        AppMethodBeat.o(151995);
        return this;
      }
      catch (Exception localException2)
      {
        break label474;
      }
      localq = new q(str);
      localq.ifB().ifL();
      localq.cFq();
      localObject2 = a.bqE((String)localObject2);
      if (Util.isNullOrNil((byte[])localObject2))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.F(this.PvW, 56L);
        j.F(this.PvW, 45L);
        j.F(this.PvW, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (Util.isNullOrNil((byte[])localObject1))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.F(this.PvW, 55L);
          j.F(this.PvW, 45L);
          j.F(this.PvW, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.D(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.F(this.PvW, 57L);
            j.F(this.PvW, 45L);
            j.F(this.PvW, 18L);
            bool1 = bool2;
            continue;
            label474:
            Log.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.QYU, localException1 });
            j.F(this.PvW, 45L);
            j.F(this.PvW, 18L);
          }
        }
      }
    }
    j.F(this.PvW, 17L);
    this.Rae = this.BXC;
    if (this.QZB)
    {
      this.BXC = (this.filePath + ".decompressed");
      this.state = 2;
      AppMethodBeat.o(151995);
      return this;
    }
    this.state = 4;
    AppMethodBeat.o(151995);
    return this;
  }
  
  final l hiv()
  {
    AppMethodBeat.i(151996);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.QYU, hiy(), this.Rae, this.BXC });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.QZC)) {
        j.a(this.fxC, this.subType, this.QYY, this.fxI, false, false, false, this.QZb);
      }
      AppMethodBeat.o(151996);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.Rae;
        str = this.BXC;
        q localq = new q((String)localObject);
        if ((!localq.ifE()) || (!localq.ifH()))
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
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.QYU, Boolean.valueOf(bool) });
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.QYU, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.Rae = this.BXC;
        this.state = 4;
        j.F(this.PvW, 19L);
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
      new q(str).cFq();
      localObject = s.aa(a.bqE((String)localObject));
      if (Util.isNullOrNil((byte[])localObject))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.D(str, (byte[])localObject);
        continue;
        label314:
        Log.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.QYU, localException1 });
      }
    }
    this.Rae = null;
    this.state = 8;
    j.F(this.PvW, 20L);
    j.F(this.PvW, 46L);
    if (this.QZC) {
      j.a(this.fxC, this.subType, this.QYY, this.fxI, true, false, false, this.QZb);
    }
    while ((!this.QZB) || (!this.fxE))
    {
      AppMethodBeat.o(151996);
      return this;
    }
    i = this.fxC;
    j = this.subType;
    Object localObject = this.url;
    k = this.fxD;
    if (this.QZc > this.QZd) {}
    for (locala = j.a.QZW;; locala = j.a.QZU)
    {
      j.a(i, j, (String)localObject, k, locala, false, this.fxI, false, this.QZb);
      break;
    }
  }
  
  final String hiw()
  {
    AppMethodBeat.i(151997);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + hiy(), new Object[] { this.QYU });
    if (16 == this.state)
    {
      localObject = this.Rae;
      AppMethodBeat.o(151997);
      return localObject;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      AppMethodBeat.o(151997);
      return null;
    }
    String str1 = hix();
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.QYU, str1 });
    if (this.state == 4)
    {
      if ((Util.isNullOrNil(str1)) && (!this.QZB))
      {
        j.F(this.PvW, 58L);
        j.F(this.PvW, 45L);
      }
      if (!Util.isNullOrNil(str1)) {
        break label296;
      }
      if (!this.QZC) {
        break label214;
      }
      j.a(this.fxC, this.subType, this.QYY, this.fxI, true, true, false, this.QZb);
    }
    label214:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(151997);
        return str1;
        if ((this.QZB) && (this.fxE))
        {
          i = this.fxC;
          j = this.subType;
          str2 = this.url;
          k = this.fxD;
          if (this.QZc > this.QZd) {}
          for (localObject = j.a.QZW;; localObject = j.a.QZU)
          {
            j.a(i, j, str2, k, (j.a)localObject, false, this.fxI, true, this.QZb);
            break;
          }
          if (!this.QZC) {
            break;
          }
          j.a(this.fxC, this.subType, this.QYY, this.fxI, true, true, true, this.QZb);
        }
      }
    } while ((!this.QZB) || (!this.fxE));
    label296:
    int i = this.fxC;
    int j = this.subType;
    String str2 = this.url;
    int k = this.fxD;
    if (this.QZc > this.QZd) {}
    for (Object localObject = j.a.QZW;; localObject = j.a.QZU)
    {
      j.a(i, j, str2, k, (j.a)localObject, true, this.fxI, true, this.QZb);
      break;
    }
  }
  
  final String hiy()
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
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.l
 * JD-Core Version:    0.7.0.1
 */