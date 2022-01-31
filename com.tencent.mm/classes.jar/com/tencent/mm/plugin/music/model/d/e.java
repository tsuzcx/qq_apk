package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class e
  implements com.tencent.mm.plugin.music.e.d
{
  private f mAo = new f();
  private c mAp = new c();
  private a mAq = new a();
  
  public final void a(com.tencent.mm.av.e parame, String paramString)
  {
    Object localObject = this.mAp;
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (((c)localObject).mAi != null) {
        str = ((c)localObject).getMimeType();
      }
    }
    y.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", new Object[] { str, Boolean.valueOf(((c)localObject).mAg) });
    int i;
    if ((!TextUtils.isEmpty(str)) && (!((c)localObject).mAg))
    {
      y.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType OK");
      ((c)localObject).mAg = true;
      paramString = new IDKey();
      paramString.SetID(558);
      if (!"audio/3gpp".equalsIgnoreCase(str)) {
        break label206;
      }
      i = 70;
    }
    for (;;)
    {
      paramString.SetKey(i);
      paramString.SetValue(1L);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      h.nFQ.b((ArrayList)localObject, true);
      if (parame != null)
      {
        i = b.JD(str);
        h.nFQ.f(14486, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(i), str });
      }
      return;
      label206:
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
  
  public final void a(com.tencent.mm.plugin.music.c.b paramb)
  {
    this.mAp.mAi = paramb;
  }
  
  public final void b(com.tencent.mm.av.e parame, int paramInt)
  {
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(558);
    localIDKey1.SetKey(4);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(558);
    int i = parame.euv;
    y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKeyByMusicType, musicType:" + i);
    IDKey localIDKey3;
    IDKey localIDKey4;
    ArrayList localArrayList;
    int k;
    int m;
    label320:
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
      localIDKey3.SetKey(b.uP(paramInt));
      localIDKey3.SetValue(1L);
      localIDKey4 = new IDKey();
      localIDKey4.SetID(558);
      localIDKey4.SetValue(1L);
      localArrayList = new ArrayList();
      k = 0;
      m = 0;
      if (paramInt == 80)
      {
        i = parame.euv;
        y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:" + i);
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
          i = g.Js(parame.playUrl);
          j = g.Jt(parame.playUrl);
          if (g.Js(parame.playUrl) == 403)
          {
            localIDKey4 = new IDKey();
            localIDKey4.SetID(558);
            localIDKey4.SetValue(1L);
            localIDKey4.SetKey(b.uP(700));
            localArrayList.add(localIDKey4);
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      h.nFQ.f(14777, new Object[] { Integer.valueOf(1), Integer.valueOf(parame.euv), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) });
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(localIDKey3);
      h.nFQ.b(localArrayList, true);
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
      break label320;
      i = 168;
      break label320;
      i = 169;
      break label320;
      i = 170;
      break label320;
      i = 171;
      break label320;
      i = 172;
      break label320;
      i = 173;
      break label320;
      i = 174;
      break label320;
      i = 175;
      break label320;
      if ((g.Jo(parame.playUrl) != null) && (g.Jo(parame.playUrl).contains("text/html")))
      {
        i = 701;
        localIDKey4 = new IDKey();
        localIDKey4.SetID(558);
        localIDKey4.SetValue(1L);
        localIDKey4.SetKey(b.uP(701));
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
            label762:
            IDKey localIDKey5;
            if (i != 0)
            {
              localIDKey5 = new IDKey();
              localIDKey5.SetID(558);
              localIDKey5.SetValue(1L);
              i = parame.euv;
              y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:" + i);
            }
            switch (i)
            {
            case 2: 
            case 3: 
            case 5: 
            default: 
              i = 188;
              label884:
              localIDKey5.SetKey(i);
              localArrayList.add(localIDKey5);
              i = parame.euv;
              y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:" + i);
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
          break label762;
          i = 202;
          break label884;
          i = 203;
          break label884;
          i = 204;
          break label884;
          i = 205;
          break label884;
          i = 206;
          break label884;
          i = 207;
          break label884;
          i = 208;
          break label884;
          i = 209;
          break label884;
          i = 210;
          break label884;
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
  
  public final void b(com.tencent.mm.av.e parame, int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mAp;
    Object localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(558);
    ((IDKey)localObject2).SetKey(3);
    ((IDKey)localObject2).SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(558);
    int i = parame.euv;
    y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKeyByMusicType, musicType:" + i);
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
        if ((paramInt1 != 19) && ((((c)localObject1).getMimeType() == null) || (!((c)localObject1).getMimeType().contains("text/html"))))
        {
          if (paramInt1 != 21) {
            break label1505;
          }
          i = parame.euv;
          y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:" + i);
        }
        switch (i)
        {
        case 2: 
        case 3: 
        case 5: 
        default: 
          i = 188;
          label341:
          localIDKey3.SetKey(i);
          localArrayList.add(localIDKey3);
          label356:
          localArrayList.add(localObject2);
          localArrayList.add(localIDKey2);
          localArrayList.add(localIDKey1);
          y.i("MicroMsg.Music.MusicPlayerReportImpl", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", new Object[] { Boolean.valueOf(((c)localObject1).mzY), Boolean.valueOf(((c)localObject1).mAa), Boolean.valueOf(((c)localObject1).mAd), Boolean.valueOf(((c)localObject1).mzZ), Boolean.valueOf(((c)localObject1).mAb) });
          if ((paramInt1 == -1) && (!((c)localObject1).mzY))
          {
            ((c)localObject1).mzY = true;
            i = 0;
            if (((c)localObject1).mAi != null) {
              i = ((c)localObject1).mAi.myy;
            }
            if (i == 403)
            {
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(558);
              ((IDKey)localObject2).SetValue(1L);
              ((IDKey)localObject2).SetKey(b.uQ(700));
              localArrayList.add(localObject2);
            }
            h.nFQ.b(localArrayList, true);
            h.nFQ.f(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(0) });
          }
          if ((paramInt1 == 6) && (!((c)localObject1).mzZ))
          {
            ((c)localObject1).mzZ = true;
            h.nFQ.b(localArrayList, true);
            h.nFQ.f(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == -2) && (!((c)localObject1).mAa))
          {
            ((c)localObject1).mAa = true;
            h.nFQ.b(localArrayList, true);
            h.nFQ.f(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 5) && (!((c)localObject1).mAb))
          {
            ((c)localObject1).mAb = true;
            h.nFQ.b(localArrayList, true);
            i = 0;
            if (((c)localObject1).mAi != null) {
              i = ((c)localObject1).mAi.dUg;
            }
            h.nFQ.f(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(i) });
          }
          if ((paramInt1 == 19) && (!((c)localObject1).mAc))
          {
            ((c)localObject1).mAc = true;
            h.nFQ.b(localArrayList, true);
            h.nFQ.f(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 4) && (!((c)localObject1).mAd))
          {
            ((c)localObject1).mAd = true;
            h.nFQ.b(localArrayList, true);
            h.nFQ.f(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if ((paramInt1 == 20) && (!((c)localObject1).mAe))
          {
            ((c)localObject1).mAe = true;
            ((c)localObject1).mAh = paramInt2;
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localIDKey1);
            h.nFQ.b((ArrayList)localObject2, true);
          }
          if ((paramInt1 == 21) && (!((c)localObject1).mAf) && (((c)localObject1).mAe))
          {
            ((c)localObject1).mAf = true;
            if ((((c)localObject1).getMimeType() == null) || (!((c)localObject1).getMimeType().contains("text/html"))) {
              break label1695;
            }
            i = 701;
            localObject1 = new IDKey();
            ((IDKey)localObject1).SetID(558);
            ((IDKey)localObject1).SetValue(1L);
            ((IDKey)localObject1).SetKey(b.uQ(701));
            localArrayList.add(localObject1);
          }
          break;
        }
      }
      break;
    }
    label1505:
    int j;
    label1695:
    label1767:
    do
    {
      h.nFQ.b(localArrayList, true);
      h.nFQ.f(14777, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.euv), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(0) });
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
      break label341;
      i = 160;
      break label341;
      i = 161;
      break label341;
      i = 162;
      break label341;
      i = 163;
      break label341;
      i = 164;
      break label341;
      i = 165;
      break label341;
      if ((paramInt1 != -1) && (paramInt1 != 6) && (paramInt1 != -2) && (paramInt1 != 5) && (paramInt1 != 4)) {
        break label356;
      }
      i = parame.euv;
      y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:" + i);
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
      ((IDKey)localObject1).SetKey(b.uQ(paramInt2));
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
    i = parame.euv;
    y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:" + i);
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
  
  public final void bmZ()
  {
    c localc = this.mAp;
    y.i("MicroMsg.Music.MusicPlayerReportImpl", "initIdKeyStatDataForMusicPlayer");
    localc.mzY = false;
    localc.mzZ = false;
    localc.mAa = false;
    localc.mAb = false;
    localc.mAc = false;
    localc.mAd = false;
    localc.mAe = false;
    localc.mAf = false;
    localc.mAg = false;
    localc.mAh = 0;
  }
  
  public final void c(com.tencent.mm.av.e parame, int paramInt)
  {
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
      h.nFQ.b(localArrayList, true);
      localObject = g.Jo(parame.playUrl);
      y.i("MicroMsg.Music.QQMusicPlayerReportImpl", "mineTypeStr:%s", new Object[] { localObject });
      if ((parame == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break;
      }
      paramInt = b.JD((String)localObject);
      h.nFQ.f(14486, new Object[] { Integer.valueOf(1), Integer.valueOf(parame.euv), Integer.valueOf(paramInt), localObject });
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
    y.e("MicroMsg.Music.QQMusicPlayerReportImpl", "music is null or mineTypeStr is empty");
  }
  
  public final void c(com.tencent.mm.av.e parame, int paramInt1, int paramInt2)
  {
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(797);
    localIDKey1.SetKey(2);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(797);
    int i = parame.euv;
    y.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKeyByMusicType, musicType:" + i);
    label267:
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
      y.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrTypeIdKey, errType:" + paramInt1);
      switch (paramInt1)
      {
      default: 
        paramInt1 = 9;
        parame.SetKey(paramInt1);
        parame.SetValue(1L);
        localIDKey3 = new IDKey();
        localIDKey3.SetID(797);
        y.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKey, errCode:" + paramInt2);
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
      h.nFQ.b(localArrayList, true);
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
      break label267;
      paramInt1 = 4;
      break label267;
      paramInt1 = 5;
      break label267;
      paramInt1 = 6;
      break label267;
      paramInt1 = 7;
      break label267;
      paramInt1 = 8;
      break label267;
      paramInt1 = 9;
      break label267;
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
  
  public final void s(com.tencent.mm.av.e parame)
  {
    d.s(parame);
  }
  
  public final void uK(int paramInt)
  {
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303))
    {
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(558);
      localIDKey.SetKey(15);
      localIDKey.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      h.nFQ.b(localArrayList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.e
 * JD-Core Version:    0.7.0.1
 */