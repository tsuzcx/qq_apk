package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.music.c.b;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class f
  implements com.tencent.mm.plugin.music.e.d
{
  private g AlB;
  private d AlC;
  private a AlD;
  private com.tencent.mm.ay.d AlE;
  
  public f()
  {
    AppMethodBeat.i(63156);
    this.AlE = null;
    this.AlB = new g();
    this.AlC = new d();
    this.AlD = new a();
    AppMethodBeat.o(63156);
  }
  
  private void ad(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(63167);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dnu();
    ((d.a)localObject).iLO = new dnv();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/reportmusic";
    ((d.a)localObject).funcId = 2718;
    localObject = ((d.a)localObject).aXF();
    dnu localdnu = (dnu)((com.tencent.mm.ak.d)localObject).iLK.iLR;
    localdnu.MQP = new crv();
    if (this.AlE != null)
    {
      localdnu.MQP.MwU = this.AlE.jeR;
      localdnu.MQQ = this.AlE.jeS;
      this.AlE = null;
    }
    localdnu.MQP.MwV = String.valueOf(paramLong2);
    localdnu.MQP.MwW = String.valueOf(paramLong1);
    aa.a((com.tencent.mm.ak.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(63155);
        Log.i("MicroMsg.Music.MusicWechatReportService", "reportMusicInfo callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        AppMethodBeat.o(63155);
        return 0;
      }
    });
    AppMethodBeat.o(63167);
  }
  
  public final void SN(int paramInt)
  {
    AppMethodBeat.i(63163);
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303))
    {
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(558);
      localIDKey.SetKey(15);
      localIDKey.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      h.CyF.b(localArrayList, true);
    }
    AppMethodBeat.o(63163);
  }
  
  public final void a(com.tencent.mm.ay.d paramd)
  {
    AppMethodBeat.i(63166);
    Log.i("MicroMsg.Music.MusicWechatReportService", "reportMusicPlayerTime");
    if (paramd != null) {
      Log.i("MicroMsg.Music.MusicWechatReportService", "MusicReportInfo h5CurrentMusicIDOfReport:%s, h5ReportListIDOfReport:%s", new Object[] { paramd.jeR, paramd.jeS });
    }
    com.tencent.mm.ay.f localf = k.euj().etU();
    if ((k.euj().etW().bec()) && (localf != null) && (localf.jeT == 10))
    {
      this.AlE = paramd;
      Log.i("MicroMsg.Music.MusicWechatReportService", "H5 music is playing, not report first");
      AppMethodBeat.o(63166);
      return;
    }
    this.AlE = paramd;
    Log.i("MicroMsg.Music.MusicWechatReportService", "report music info");
    ad(0L, 0L);
    AppMethodBeat.o(63166);
  }
  
  public final void a(com.tencent.mm.ay.f paramf, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(63165);
    if (paramf != null)
    {
      Log.i("MicroMsg.Music.MusicWechatReportService", "scene:%d, endPosition:%d, totalPlayTime:%d, duration:%d", new Object[] { Integer.valueOf(paramf.jeT), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      if (paramf.jeT == 10) {
        ad(paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(63165);
  }
  
  public final void a(com.tencent.mm.ay.f paramf, String paramString)
  {
    AppMethodBeat.i(63162);
    Object localObject = this.AlC;
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (((d)localObject).Alw != null) {
        str = ((d)localObject).getMimeType();
      }
    }
    Log.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", new Object[] { str, Boolean.valueOf(((d)localObject).Alu) });
    int i;
    if ((!TextUtils.isEmpty(str)) && (!((d)localObject).Alu))
    {
      Log.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType OK");
      ((d)localObject).Alu = true;
      paramString = new IDKey();
      paramString.SetID(558);
      if (!"audio/3gpp".equalsIgnoreCase(str)) {
        break label218;
      }
      i = 70;
    }
    for (;;)
    {
      paramString.SetKey(i);
      paramString.SetValue(1L);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      h.CyF.b((ArrayList)localObject, true);
      if (paramf != null)
      {
        i = c.aHV(str);
        h.CyF.a(14486, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(i), str });
      }
      AppMethodBeat.o(63162);
      return;
      label218:
      if ("audio/amr-wb".equalsIgnoreCase(str)) {
        i = 71;
      } else if (("audio/mpeg".equalsIgnoreCase(str)) || (str.equalsIgnoreCase("audio/mp3"))) {
        i = 72;
      } else if (("audio/mp4a-latm".equalsIgnoreCase(str)) || (str.startsWith("audio/mp4"))) {
        i = 73;
      } else if ("audio/qcelp".equalsIgnoreCase(str)) {
        i = 74;
      } else if ("audio/vorbis".equalsIgnoreCase(str)) {
        i = 75;
      } else if ("audio/opus".equalsIgnoreCase(str)) {
        i = 76;
      } else if ("audio/g711-alaw".equalsIgnoreCase(str)) {
        i = 77;
      } else if ("audio/g711-mlaw".equalsIgnoreCase(str)) {
        i = 78;
      } else if ("audio/raw".equalsIgnoreCase(str)) {
        i = 79;
      } else if ("audio/flac".equalsIgnoreCase(str)) {
        i = 80;
      } else if ("audio/gsm".equalsIgnoreCase(str)) {
        i = 81;
      } else if ("audio/ac3".equalsIgnoreCase(str)) {
        i = 82;
      } else if ("audio/eac3".equalsIgnoreCase(str)) {
        i = 83;
      } else if ("audio/x-ms-wma".equalsIgnoreCase(str)) {
        i = 84;
      } else if ("audio/x-wav".equalsIgnoreCase(str)) {
        i = 85;
      } else if (("audio/x-ape".equalsIgnoreCase(str)) || ("application/x-ape".equalsIgnoreCase(str))) {
        i = 86;
      } else {
        i = 87;
      }
    }
  }
  
  public final void a(b paramb)
  {
    this.AlC.Alw = paramb;
  }
  
  public final void b(com.tencent.mm.ay.f paramf, int paramInt)
  {
    AppMethodBeat.i(63158);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(558);
    localIDKey1.SetKey(4);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(558);
    int i = paramf.jeT;
    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
    IDKey localIDKey3;
    IDKey localIDKey4;
    ArrayList localArrayList;
    int k;
    int m;
    label316:
    int j;
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      i = 9;
      localIDKey2.SetKey(i);
      localIDKey2.SetValue(1L);
      localIDKey3 = new IDKey();
      localIDKey3.SetID(558);
      localIDKey3.SetKey(c.ST(paramInt));
      localIDKey3.SetValue(1L);
      localIDKey4 = new IDKey();
      localIDKey4.SetID(558);
      localIDKey4.SetValue(1L);
      localArrayList = new ArrayList();
      k = 0;
      m = 0;
      if (paramInt == 80)
      {
        i = paramf.jeT;
        Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
        switch (i)
        {
        case 2: 
        case 3: 
        case 5: 
        default: 
          i = 188;
          localIDKey4.SetKey(i);
          localArrayList.add(localIDKey4);
          k = 1;
          i = com.tencent.mm.plugin.music.cache.g.aHE(paramf.playUrl);
          j = com.tencent.mm.plugin.music.cache.g.aHF(paramf.playUrl);
          if (com.tencent.mm.plugin.music.cache.g.aHE(paramf.playUrl) == 403)
          {
            localIDKey4 = new IDKey();
            localIDKey4.SetID(558);
            localIDKey4.SetValue(1L);
            localIDKey4.SetKey(c.ST(700));
            localArrayList.add(localIDKey4);
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      h.CyF.a(14777, new Object[] { Integer.valueOf(1), Integer.valueOf(paramf.jeT), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) });
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(localIDKey3);
      h.CyF.b(localArrayList, true);
      AppMethodBeat.o(63158);
      return;
      i = 49;
      break;
      i = 50;
      break;
      i = 51;
      break;
      i = 52;
      break;
      i = 53;
      break;
      i = 54;
      break;
      i = 55;
      break;
      i = 56;
      break;
      i = 7;
      break;
      i = 8;
      break;
      i = 167;
      break label316;
      i = 168;
      break label316;
      i = 169;
      break label316;
      i = 170;
      break label316;
      i = 171;
      break label316;
      i = 172;
      break label316;
      i = 173;
      break label316;
      i = 174;
      break label316;
      i = 175;
      break label316;
      if ((com.tencent.mm.plugin.music.cache.g.aHA(paramf.playUrl) != null) && (com.tencent.mm.plugin.music.cache.g.aHA(paramf.playUrl).contains("text/html")))
      {
        i = 701;
        localIDKey4 = new IDKey();
        localIDKey4.SetID(558);
        localIDKey4.SetValue(1L);
        localIDKey4.SetKey(c.ST(701));
        localArrayList.add(localIDKey4);
        j = 0;
      }
      else
      {
        if (paramInt != 70) {
          switch (paramInt)
          {
          default: 
            i = 0;
            label766:
            IDKey localIDKey5;
            if (i != 0)
            {
              localIDKey5 = new IDKey();
              localIDKey5.SetID(558);
              localIDKey5.SetValue(1L);
              i = paramf.jeT;
              Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
            }
            switch (i)
            {
            case 2: 
            case 3: 
            case 5: 
            default: 
              i = 188;
              label880:
              localIDKey5.SetKey(i);
              localArrayList.add(localIDKey5);
              i = paramf.jeT;
              Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
              switch (i)
              {
              case 2: 
              case 3: 
              case 5: 
              default: 
                i = 188;
              }
              break;
            }
            break;
          }
        }
        for (;;)
        {
          localIDKey4.SetKey(i);
          localArrayList.add(localIDKey4);
          j = 0;
          i = m;
          break;
          i = 1;
          break label766;
          i = 202;
          break label880;
          i = 203;
          break label880;
          i = 204;
          break label880;
          i = 205;
          break label880;
          i = 206;
          break label880;
          i = 207;
          break label880;
          i = 208;
          break label880;
          i = 209;
          break label880;
          i = 210;
          break label880;
          i = 178;
          continue;
          i = 179;
          continue;
          i = 180;
          continue;
          i = 181;
          continue;
          i = 182;
          continue;
          i = 183;
          continue;
          i = 184;
          continue;
          i = 185;
          continue;
          i = 186;
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.ay.f paramf, int paramInt)
  {
    AppMethodBeat.i(63159);
    Object localObject = new IDKey();
    ((IDKey)localObject).SetID(558);
    if (paramInt == 2) {
      paramInt = 92;
    }
    for (;;)
    {
      ((IDKey)localObject).SetKey(paramInt);
      ((IDKey)localObject).SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      h.CyF.b(localArrayList, true);
      localObject = com.tencent.mm.plugin.music.cache.g.aHA(paramf.playUrl);
      Log.i("MicroMsg.Music.QQMusicPlayerReportImpl", "mineTypeStr:%s", new Object[] { localObject });
      if ((paramf == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break;
      }
      paramInt = c.aHV((String)localObject);
      h.CyF.a(14486, new Object[] { Integer.valueOf(1), Integer.valueOf(paramf.jeT), Integer.valueOf(paramInt), localObject });
      AppMethodBeat.o(63159);
      return;
      if (paramInt == 3) {
        paramInt = 93;
      } else if (paramInt == 4) {
        paramInt = 94;
      } else if (paramInt == 5) {
        paramInt = 95;
      } else if (paramInt == 6) {
        paramInt = 96;
      } else if (paramInt == 7) {
        paramInt = 97;
      } else if (paramInt == 8) {
        paramInt = 98;
      } else if (paramInt == 9) {
        paramInt = 99;
      } else {
        paramInt = 100;
      }
    }
    Log.e("MicroMsg.Music.QQMusicPlayerReportImpl", "music is null or mineTypeStr is empty");
    AppMethodBeat.o(63159);
  }
  
  public final void c(com.tencent.mm.ay.f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63161);
    Object localObject1 = this.AlC;
    Object localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(558);
    ((IDKey)localObject2).SetKey(3);
    ((IDKey)localObject2).SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(558);
    int i = paramf.jeT;
    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
    IDKey localIDKey1;
    label182:
    ArrayList localArrayList;
    IDKey localIDKey3;
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      i = 6;
      localIDKey2.SetKey(i);
      localIDKey2.SetValue(1L);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(558);
      if (paramInt1 == -1)
      {
        localIDKey1.SetKey(12);
        localIDKey1.SetValue(1L);
        localArrayList = new ArrayList();
        localIDKey3 = new IDKey();
        localIDKey3.SetID(558);
        localIDKey3.SetValue(1L);
        if ((paramInt1 != 19) && ((((d)localObject1).getMimeType() == null) || (!((d)localObject1).getMimeType().contains("text/html"))))
        {
          if (paramInt1 != 21) {
            break label1509;
          }
          i = paramf.jeT;
          Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
        }
        switch (i)
        {
        case 2: 
        case 3: 
        case 5: 
        default: 
          i = 188;
          label337:
          localIDKey3.SetKey(i);
          localArrayList.add(localIDKey3);
          label352:
          localArrayList.add(localObject2);
          localArrayList.add(localIDKey2);
          localArrayList.add(localIDKey1);
          Log.i("MicroMsg.Music.MusicPlayerReportImpl", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", new Object[] { Boolean.valueOf(((d)localObject1).Alm), Boolean.valueOf(((d)localObject1).Alo), Boolean.valueOf(((d)localObject1).Alr), Boolean.valueOf(((d)localObject1).Aln), Boolean.valueOf(((d)localObject1).Alp) });
          if ((paramInt1 == -1) && (!((d)localObject1).Alm))
          {
            ((d)localObject1).Alm = true;
            i = 0;
            if (((d)localObject1).Alw != null) {
              i = ((d)localObject1).Alw.Ajd;
            }
            if (i == 403)
            {
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(558);
              ((IDKey)localObject2).SetValue(1L);
              ((IDKey)localObject2).SetKey(c.SU(700));
              localArrayList.add(localObject2);
            }
            h.CyF.b(localArrayList, true);
            h.CyF.a(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(0) });
          }
          if ((paramInt1 == 6) && (!((d)localObject1).Aln))
          {
            ((d)localObject1).Aln = true;
            h.CyF.b(localArrayList, true);
            h.CyF.a(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == -2) && (!((d)localObject1).Alo))
          {
            ((d)localObject1).Alo = true;
            h.CyF.b(localArrayList, true);
            h.CyF.a(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 5) && (!((d)localObject1).Alp))
          {
            ((d)localObject1).Alp = true;
            h.CyF.b(localArrayList, true);
            i = 0;
            if (((d)localObject1).Alw != null) {
              i = ((d)localObject1).Alw.dvm;
            }
            h.CyF.a(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(i) });
          }
          if ((paramInt1 == 19) && (!((d)localObject1).Alq))
          {
            ((d)localObject1).Alq = true;
            h.CyF.b(localArrayList, true);
            h.CyF.a(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 4) && (!((d)localObject1).Alr))
          {
            ((d)localObject1).Alr = true;
            h.CyF.b(localArrayList, true);
            h.CyF.a(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 20) && (!((d)localObject1).Als))
          {
            ((d)localObject1).Als = true;
            ((d)localObject1).Alv = paramInt2;
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localIDKey1);
            h.CyF.b((ArrayList)localObject2, true);
          }
          if ((paramInt1 == 21) && (!((d)localObject1).Alt) && (((d)localObject1).Als))
          {
            ((d)localObject1).Alt = true;
            if ((((d)localObject1).getMimeType() == null) || (!((d)localObject1).getMimeType().contains("text/html"))) {
              break label1695;
            }
            i = 701;
            localObject1 = new IDKey();
            ((IDKey)localObject1).SetID(558);
            ((IDKey)localObject1).SetValue(1L);
            ((IDKey)localObject1).SetKey(c.SU(701));
            localArrayList.add(localObject1);
          }
          break;
        }
      }
      break;
    }
    label1509:
    int j;
    label1695:
    label1767:
    do
    {
      h.CyF.b(localArrayList, true);
      h.CyF.a(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.jeT), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(63161);
      return;
      i = 60;
      break;
      i = 61;
      break;
      i = 62;
      break;
      i = 63;
      break;
      i = 64;
      break;
      i = 5;
      break;
      i = 65;
      break;
      i = 66;
      break;
      if (paramInt1 == 6)
      {
        localIDKey1.SetKey(46);
        break label182;
      }
      if (paramInt1 == -2)
      {
        localIDKey1.SetKey(13);
        break label182;
      }
      if (paramInt1 == 5)
      {
        localIDKey1.SetKey(16);
        break label182;
      }
      if (paramInt1 == 4)
      {
        localIDKey1.SetKey(14);
        break label182;
      }
      if (paramInt1 == 20)
      {
        localIDKey1.SetKey(11);
        break label182;
      }
      if (paramInt1 == 21)
      {
        localIDKey1.SetKey(47);
        break label182;
      }
      if (paramInt1 != 19) {
        break label182;
      }
      localIDKey1.SetKey(190);
      break label182;
      i = 159;
      break label337;
      i = 160;
      break label337;
      i = 161;
      break label337;
      i = 162;
      break label337;
      i = 163;
      break label337;
      i = 164;
      break label337;
      i = 165;
      break label337;
      if ((paramInt1 != -1) && (paramInt1 != 6) && (paramInt1 != -2) && (paramInt1 != 5) && (paramInt1 != 4)) {
        break label352;
      }
      i = paramf.jeT;
      Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
      switch (i)
      {
      case 2: 
      case 3: 
      case 5: 
      default: 
        i = 188;
      }
      for (;;)
      {
        localIDKey3.SetKey(i);
        localArrayList.add(localIDKey3);
        break;
        i = 151;
        continue;
        i = 152;
        continue;
        i = 153;
        continue;
        i = 154;
        continue;
        i = 155;
        continue;
        i = 156;
        continue;
        i = 157;
      }
      localObject1 = new IDKey();
      ((IDKey)localObject1).SetID(558);
      ((IDKey)localObject1).SetValue(1L);
      ((IDKey)localObject1).SetKey(c.SU(paramInt2));
      localArrayList.add(localObject1);
      switch (paramInt2)
      {
      default: 
        j = 0;
        i = paramInt2;
      }
    } while (j == 0);
    localObject1 = new IDKey();
    ((IDKey)localObject1).SetID(558);
    ((IDKey)localObject1).SetValue(1L);
    i = paramf.jeT;
    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
    switch (i)
    {
    case 2: 
    case 3: 
    case 5: 
    default: 
      i = 188;
    }
    for (;;)
    {
      ((IDKey)localObject1).SetKey(i);
      localArrayList.add(localObject1);
      i = paramInt2;
      break;
      j = 1;
      break label1767;
      i = 194;
      continue;
      i = 195;
      continue;
      i = 196;
      continue;
      i = 197;
      continue;
      i = 198;
      continue;
      i = 199;
      continue;
      i = 200;
    }
  }
  
  public final void d(com.tencent.mm.ay.f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63164);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(797);
    localIDKey1.SetKey(2);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(797);
    int i = paramf.jeT;
    Log.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
    label259:
    IDKey localIDKey3;
    switch (i)
    {
    case 2: 
    case 3: 
    case 5: 
    default: 
      i = 71;
      localIDKey2.SetKey(i);
      localIDKey2.SetValue(1L);
      paramf = new IDKey();
      paramf.SetID(797);
      Log.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrTypeIdKey, errType:".concat(String.valueOf(paramInt1)));
      switch (paramInt1)
      {
      default: 
        paramInt1 = 9;
        paramf.SetKey(paramInt1);
        paramf.SetValue(1L);
        localIDKey3 = new IDKey();
        localIDKey3.SetID(797);
        Log.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt2)));
        switch (paramInt2)
        {
        default: 
          paramInt1 = 14;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      localIDKey3.SetKey(paramInt1);
      localIDKey3.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(paramf);
      localArrayList.add(localIDKey3);
      h.CyF.b(localArrayList, true);
      AppMethodBeat.o(63164);
      return;
      i = 62;
      break;
      i = 63;
      break;
      i = 64;
      break;
      i = 65;
      break;
      i = 66;
      break;
      i = 67;
      break;
      i = 68;
      break;
      i = 69;
      break;
      i = 70;
      break;
      paramInt1 = 3;
      break label259;
      paramInt1 = 4;
      break label259;
      paramInt1 = 5;
      break label259;
      paramInt1 = 6;
      break label259;
      paramInt1 = 7;
      break label259;
      paramInt1 = 8;
      break label259;
      paramInt1 = 9;
      break label259;
      paramInt1 = 15;
      continue;
      paramInt1 = 16;
      continue;
      paramInt1 = 17;
      continue;
      paramInt1 = 18;
      continue;
      paramInt1 = 19;
      continue;
      paramInt1 = 20;
      continue;
      paramInt1 = 21;
      continue;
      paramInt1 = 22;
      continue;
      paramInt1 = 23;
      continue;
      paramInt1 = 24;
      continue;
      paramInt1 = 25;
      continue;
      paramInt1 = 14;
    }
  }
  
  public final void etX()
  {
    AppMethodBeat.i(63160);
    d locald = this.AlC;
    Log.i("MicroMsg.Music.MusicPlayerReportImpl", "initIdKeyStatDataForMusicPlayer");
    locald.Alm = false;
    locald.Aln = false;
    locald.Alo = false;
    locald.Alp = false;
    locald.Alq = false;
    locald.Alr = false;
    locald.Als = false;
    locald.Alt = false;
    locald.Alu = false;
    locald.Alv = 0;
    AppMethodBeat.o(63160);
  }
  
  public final void v(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63157);
    e.a(paramf, false);
    AppMethodBeat.o(63157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.f
 * JD-Core Version:    0.7.0.1
 */