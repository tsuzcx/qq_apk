package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class f
  implements com.tencent.mm.plugin.music.e.d
{
  private g pau;
  private d pav;
  private a paw;
  
  public f()
  {
    AppMethodBeat.i(105021);
    this.pau = new g();
    this.pav = new d();
    this.paw = new a();
    AppMethodBeat.o(105021);
  }
  
  public final void Ag(int paramInt)
  {
    AppMethodBeat.i(105028);
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303))
    {
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(558);
      localIDKey.SetKey(15);
      localIDKey.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      h.qsU.b(localArrayList, true);
    }
    AppMethodBeat.o(105028);
  }
  
  public final void a(com.tencent.mm.aw.e parame, String paramString)
  {
    AppMethodBeat.i(105027);
    Object localObject = this.pav;
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (((d)localObject).pao != null) {
        str = ((d)localObject).getMimeType();
      }
    }
    ab.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", new Object[] { str, Boolean.valueOf(((d)localObject).pam) });
    int i;
    if ((!TextUtils.isEmpty(str)) && (!((d)localObject).pam))
    {
      ab.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType OK");
      ((d)localObject).pam = true;
      paramString = new IDKey();
      paramString.SetID(558);
      if (!"audio/3gpp".equalsIgnoreCase(str)) {
        break label216;
      }
      i = 70;
    }
    for (;;)
    {
      paramString.SetKey(i);
      paramString.SetValue(1L);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      h.qsU.b((ArrayList)localObject, true);
      if (parame != null)
      {
        i = c.VB(str);
        h.qsU.e(14486, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(i), str });
      }
      AppMethodBeat.o(105027);
      return;
      label216:
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
    this.pav.pao = paramb;
  }
  
  public final void b(com.tencent.mm.aw.e parame, int paramInt)
  {
    AppMethodBeat.i(105023);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(558);
    localIDKey1.SetKey(4);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(558);
    int i = parame.fKh;
    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
    IDKey localIDKey3;
    IDKey localIDKey4;
    ArrayList localArrayList;
    int k;
    int m;
    label308:
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
      localIDKey3.SetKey(c.An(paramInt));
      localIDKey3.SetValue(1L);
      localIDKey4 = new IDKey();
      localIDKey4.SetID(558);
      localIDKey4.SetValue(1L);
      localArrayList = new ArrayList();
      k = 0;
      m = 0;
      if (paramInt == 80)
      {
        i = parame.fKh;
        ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
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
          i = com.tencent.mm.plugin.music.cache.g.Vo(parame.playUrl);
          j = com.tencent.mm.plugin.music.cache.g.Vp(parame.playUrl);
          if (com.tencent.mm.plugin.music.cache.g.Vo(parame.playUrl) == 403)
          {
            localIDKey4 = new IDKey();
            localIDKey4.SetID(558);
            localIDKey4.SetValue(1L);
            localIDKey4.SetKey(c.An(700));
            localArrayList.add(localIDKey4);
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      h.qsU.e(14777, new Object[] { Integer.valueOf(1), Integer.valueOf(parame.fKh), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) });
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(localIDKey3);
      h.qsU.b(localArrayList, true);
      AppMethodBeat.o(105023);
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
      break label308;
      i = 168;
      break label308;
      i = 169;
      break label308;
      i = 170;
      break label308;
      i = 171;
      break label308;
      i = 172;
      break label308;
      i = 173;
      break label308;
      i = 174;
      break label308;
      i = 175;
      break label308;
      if ((com.tencent.mm.plugin.music.cache.g.Vl(parame.playUrl) != null) && (com.tencent.mm.plugin.music.cache.g.Vl(parame.playUrl).contains("text/html")))
      {
        i = 701;
        localIDKey4 = new IDKey();
        localIDKey4.SetID(558);
        localIDKey4.SetValue(1L);
        localIDKey4.SetKey(c.An(701));
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
            label758:
            IDKey localIDKey5;
            if (i != 0)
            {
              localIDKey5 = new IDKey();
              localIDKey5.SetID(558);
              localIDKey5.SetValue(1L);
              i = parame.fKh;
              ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
            }
            switch (i)
            {
            case 2: 
            case 3: 
            case 5: 
            default: 
              i = 188;
              label872:
              localIDKey5.SetKey(i);
              localArrayList.add(localIDKey5);
              i = parame.fKh;
              ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
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
          break label758;
          i = 202;
          break label872;
          i = 203;
          break label872;
          i = 204;
          break label872;
          i = 205;
          break label872;
          i = 206;
          break label872;
          i = 207;
          break label872;
          i = 208;
          break label872;
          i = 209;
          break label872;
          i = 210;
          break label872;
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
  
  public final void bVv()
  {
    AppMethodBeat.i(105025);
    d locald = this.pav;
    ab.i("MicroMsg.Music.MusicPlayerReportImpl", "initIdKeyStatDataForMusicPlayer");
    locald.pae = false;
    locald.paf = false;
    locald.pag = false;
    locald.pah = false;
    locald.pai = false;
    locald.paj = false;
    locald.pak = false;
    locald.pal = false;
    locald.pam = false;
    locald.pan = 0;
    AppMethodBeat.o(105025);
  }
  
  public final void c(com.tencent.mm.aw.e parame, int paramInt)
  {
    AppMethodBeat.i(105024);
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
      h.qsU.b(localArrayList, true);
      localObject = com.tencent.mm.plugin.music.cache.g.Vl(parame.playUrl);
      ab.i("MicroMsg.Music.QQMusicPlayerReportImpl", "mineTypeStr:%s", new Object[] { localObject });
      if ((parame == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break;
      }
      paramInt = c.VB((String)localObject);
      h.qsU.e(14486, new Object[] { Integer.valueOf(1), Integer.valueOf(parame.fKh), Integer.valueOf(paramInt), localObject });
      AppMethodBeat.o(105024);
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
    ab.e("MicroMsg.Music.QQMusicPlayerReportImpl", "music is null or mineTypeStr is empty");
    AppMethodBeat.o(105024);
  }
  
  public final void c(com.tencent.mm.aw.e parame, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105026);
    Object localObject1 = this.pav;
    Object localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(558);
    ((IDKey)localObject2).SetKey(3);
    ((IDKey)localObject2).SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(558);
    int i = parame.fKh;
    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
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
            break label1508;
          }
          i = parame.fKh;
          ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
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
          ab.i("MicroMsg.Music.MusicPlayerReportImpl", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", new Object[] { Boolean.valueOf(((d)localObject1).pae), Boolean.valueOf(((d)localObject1).pag), Boolean.valueOf(((d)localObject1).paj), Boolean.valueOf(((d)localObject1).paf), Boolean.valueOf(((d)localObject1).pah) });
          if ((paramInt1 == -1) && (!((d)localObject1).pae))
          {
            ((d)localObject1).pae = true;
            i = 0;
            if (((d)localObject1).pao != null) {
              i = ((d)localObject1).pao.oYF;
            }
            if (i == 403)
            {
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(558);
              ((IDKey)localObject2).SetValue(1L);
              ((IDKey)localObject2).SetKey(c.Ao(700));
              localArrayList.add(localObject2);
            }
            h.qsU.b(localArrayList, true);
            h.qsU.e(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(0) });
          }
          if ((paramInt1 == 6) && (!((d)localObject1).paf))
          {
            ((d)localObject1).paf = true;
            h.qsU.b(localArrayList, true);
            h.qsU.e(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == -2) && (!((d)localObject1).pag))
          {
            ((d)localObject1).pag = true;
            h.qsU.b(localArrayList, true);
            h.qsU.e(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 5) && (!((d)localObject1).pah))
          {
            ((d)localObject1).pah = true;
            h.qsU.b(localArrayList, true);
            i = 0;
            if (((d)localObject1).pao != null) {
              i = ((d)localObject1).pao.cfE;
            }
            h.qsU.e(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(i) });
          }
          if ((paramInt1 == 19) && (!((d)localObject1).pai))
          {
            ((d)localObject1).pai = true;
            h.qsU.b(localArrayList, true);
            h.qsU.e(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 4) && (!((d)localObject1).paj))
          {
            ((d)localObject1).paj = true;
            h.qsU.b(localArrayList, true);
            h.qsU.e(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 20) && (!((d)localObject1).pak))
          {
            ((d)localObject1).pak = true;
            ((d)localObject1).pan = paramInt2;
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localIDKey1);
            h.qsU.b((ArrayList)localObject2, true);
          }
          if ((paramInt1 == 21) && (!((d)localObject1).pal) && (((d)localObject1).pak))
          {
            ((d)localObject1).pal = true;
            if ((((d)localObject1).getMimeType() == null) || (!((d)localObject1).getMimeType().contains("text/html"))) {
              break label1691;
            }
            i = 701;
            localObject1 = new IDKey();
            ((IDKey)localObject1).SetID(558);
            ((IDKey)localObject1).SetValue(1L);
            ((IDKey)localObject1).SetKey(c.Ao(701));
            localArrayList.add(localObject1);
          }
          break;
        }
      }
      break;
    }
    label1508:
    int j;
    label1691:
    label1763:
    do
    {
      h.qsU.b(localArrayList, true);
      h.qsU.e(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(105026);
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
      i = parame.fKh;
      ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
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
      ((IDKey)localObject1).SetKey(c.Ao(paramInt2));
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
    i = parame.fKh;
    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
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
      break label1763;
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
  
  public final void d(com.tencent.mm.aw.e parame, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105029);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(797);
    localIDKey1.SetKey(2);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(797);
    int i = parame.fKh;
    ab.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i)));
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
      parame = new IDKey();
      parame.SetID(797);
      ab.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrTypeIdKey, errType:".concat(String.valueOf(paramInt1)));
      switch (paramInt1)
      {
      default: 
        paramInt1 = 9;
        parame.SetKey(paramInt1);
        parame.SetValue(1L);
        localIDKey3 = new IDKey();
        localIDKey3.SetID(797);
        ab.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt2)));
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
      localArrayList.add(parame);
      localArrayList.add(localIDKey3);
      h.qsU.b(localArrayList, true);
      AppMethodBeat.o(105029);
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
  
  public final void s(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(105022);
    e.a(parame, false);
    AppMethodBeat.o(105022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.f
 * JD-Core Version:    0.7.0.1
 */