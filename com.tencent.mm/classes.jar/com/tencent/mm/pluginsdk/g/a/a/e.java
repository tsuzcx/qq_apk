package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean d(int paramInt, String paramString, Map<String, String> paramMap)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null)) {
      bool1 = true;
    }
    int i;
    Object localObject;
    int j;
    int k;
    String str;
    int m;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  if (!i.b.DS(paramInt)) {
                    break;
                  }
                  y.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
                  paramInt = bk.getInt((String)paramMap.get(paramString + ".resType"), -1);
                  i = bk.getInt((String)paramMap.get(paramString + ".subType"), -1);
                  bool1 = bool2;
                } while (-1 == paramInt);
                bool1 = bool2;
              } while (-1 == i);
              localObject = new blr();
              ((blr)localObject).tAu = i;
              ((blr)localObject).tFh = new blu();
              ((blr)localObject).tFh.tFr = bk.getInt((String)paramMap.get(paramString + ".resVer"), 0);
              ((blr)localObject).tFk = ((String)paramMap.get(paramString + ".sampleID"));
              ((blr)localObject).tFj = bk.getInt((String)paramMap.get(paramString + ".reportID"), 0);
              ((blr)localObject).tea = i.b.rWM.bcw;
              b.c.clv().a(paramInt, (blr)localObject, true);
              j.s(((blr)localObject).tFj, 40L);
              return true;
              if (!i.b.DQ(paramInt)) {
                break;
              }
              y.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
              localObject = (String)paramMap.get(paramString + ".CDNUrl");
              j = bk.getInt((String)paramMap.get(paramString + ".subType"), -1);
              k = bk.getInt((String)paramMap.get(paramString + ".resType"), -1);
              str = (String)paramMap.get(paramString + ".md5");
              m = bk.getInt((String)paramMap.get(paramString + ".priority"), 0);
              bool1 = bool2;
            } while (bk.bl((String)localObject));
            bool1 = bool2;
          } while (bk.bl(str));
          bool1 = bool2;
        } while (-1 == j);
        bool1 = bool2;
      } while (-1 == k);
      bool1 = bool2;
    } while (m < 0);
    blr localblr = new blr();
    localblr.tFh = new blu();
    if (bk.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (paramInt = i.a.cly();; paramInt = 0)
    {
      i = paramInt;
      if (bk.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        i = i.a.DO(paramInt);
      }
      localblr.tAu = j;
      localblr.tFm = bk.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localblr.sGq = bk.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localblr.tFh.kSC = ((String)localObject);
      localblr.tFh.tFr = bk.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localblr.tFh.sRE = str;
      localblr.tFh.tFu = ((String)paramMap.get(paramString + ".originalmd5"));
      localblr.tFh.tFs = i;
      localblr.tFh.tFt = null;
      localblr.tFh.sRj = null;
      localblr.tly = m;
      localblr.tea = i.b.rWK.bcw;
      localblr.tFj = bk.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localblr.tFk = ((String)paramMap.get(paramString + ".sampleID"));
      localblr.tFl = bk.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localblr.tFn = bk.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localblr.rWB = 0;
      b.c.clv().b(k, localblr, true);
      j.s(localblr.tFj, 34L);
      return true;
      bool1 = bool2;
      if (!i.b.DR(paramInt)) {
        break;
      }
      y.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
      paramInt = bk.getInt((String)paramMap.get(paramString + ".resType"), -1);
      i = bk.getInt((String)paramMap.get(paramString + ".subType"), -1);
      bool1 = bool2;
      if (-1 == paramInt) {
        break;
      }
      bool1 = bool2;
      if (-1 == i) {
        break;
      }
      localObject = new blr();
      ((blr)localObject).tFi = new blt();
      ((blr)localObject).tAu = i;
      ((blr)localObject).tFi.tFq = ((String)paramMap.get(paramString + ".resKey"));
      ((blr)localObject).tFi.tFp = bk.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
      ((blr)localObject).tFk = ((String)paramMap.get(paramString + ".sampleID"));
      ((blr)localObject).tFj = bk.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      ((blr)localObject).tea = i.b.rWL.bcw;
      ((blr)localObject).tFh = new blu();
      ((blr)localObject).tFh.tFu = ((String)paramMap.get(paramString + ".originalmd5"));
      b.c.clv().a(paramInt, (blr)localObject, true, false);
      j.s(((blr)localObject).tFj, 37L);
      return true;
    }
  }
  
  static void j(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (x(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap)) {}
    boolean bool;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            bool = k(paramString1, paramString2, paramMap) | false;
            i = 0;
            for (;;)
            {
              i += 1;
              if (x(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
                break;
              }
              bool |= k(paramString1, paramString2, paramMap);
            }
            i = i.b.Wi(paramString2);
            if (!i.b.DQ(i)) {
              break;
            }
            j.s(0L, 32L);
          } while (bool);
          j.s(0L, 33L);
          return;
          if (!i.b.DR(i)) {
            break;
          }
          j.s(0L, 35L);
        } while (bool);
        j.s(0L, 36L);
        return;
      } while (!i.b.DS(i));
      j.s(0L, 38L);
    } while (bool);
    j.s(0L, 39L);
  }
  
  private static boolean k(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.Wi(paramString2);
    boolean bool2;
    if (x(str, paramMap))
    {
      bool2 = true;
      return bool2;
    }
    boolean bool1 = d(j, str, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format(Locale.US, "%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      bool2 = bool1;
      if (x(str, paramMap)) {
        break;
      }
      bool1 |= d(j, str, paramMap);
    }
  }
  
  private static boolean x(String paramString, Map<String, String> paramMap)
  {
    return (paramMap.get(paramString) == null) && (paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.e
 * JD-Core Version:    0.7.0.1
 */