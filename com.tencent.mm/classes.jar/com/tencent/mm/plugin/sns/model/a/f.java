package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class f
  extends c
{
  protected boolean wMa = false;
  protected boolean wMb = false;
  protected boolean wMc = false;
  protected boolean wMd = false;
  protected boolean wMe = false;
  
  public f(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private static String m(String paramString, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    int i;
    if (paramString.contains("?"))
    {
      paramString = "&";
      localStringBuilder.append(paramString);
      int j = 1;
      int k = paramVarArgs.length;
      i = 0;
      label37:
      if (i >= k) {
        break label84;
      }
      paramString = paramVarArgs[i];
      if (j == 0) {
        break label73;
      }
      j = 0;
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      i += 1;
      break label37;
      paramString = "?";
      break;
      label73:
      localStringBuilder.append("&");
    }
    label84:
    return localStringBuilder.toString();
  }
  
  public final String apd(String paramString)
  {
    int n = 2;
    int i1 = 0;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = g.Zd().getValue("SnsCloseDownloadWebp");
        localObject1 = paramString;
        if (bt.isNullOrNil((String)localObject2)) {
          break label964;
        }
        localObject1 = paramString;
        i = bt.aGh((String)localObject2);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        int m;
        Object localObject3;
        paramString = (String)localObject1;
        ad.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + localException1.getMessage());
        return paramString;
      }
      localObject1 = paramString;
      int j;
      int k;
      if (!n.WM())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.WM())
        {
          k = 0;
          localObject1 = paramString;
          if (n.WM()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (bt.isNullOrNil(ab.hWt))
          {
            localObject1 = paramString;
            if (bt.isNullOrNil(ab.hWu)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (bt.isNullOrNil(ab.hWt)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ab.hWt);
          i = n;
          localObject1 = paramString;
          if (i >= localObject2.length) {
            continue;
          }
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("/").append(localObject2[i]);
          i += 1;
          continue;
          localObject1 = paramString;
          if (Build.VERSION.SDK_INT < 14)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (ae.fFH.fCV == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (bt.isNullOrNil(ab.hWu)) {
            break label959;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!af.dtJ())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (bt.isNullOrNil(ab.hWu)) {
          break label954;
        }
        j = 0;
        continue;
      }
      localObject1 = paramString;
      if (!af.dtG())
      {
        k = 0;
      }
      else
      {
        localObject1 = paramString;
        if (!bt.isNullOrNil(ab.hWu))
        {
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (!af.dtH()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (!bt.isNullOrNil(ab.hWu)) {
            continue;
          }
          m = 1;
          continue;
          localObject1 = paramString;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = localObject3;
          ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (!bt.isNullOrNil(ab.hWu))
          {
            localObject1 = localObject3;
            localObject2 = m((String)localObject3, new String[] { "tp=" + ab.hWu });
            localObject1 = localObject2;
            ad.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.wLz != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.wLz.wFd.DNc != 0)
            {
              localObject1 = localObject2;
              paramString = m((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              ad.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.wLz.wFd.DNd + " " + this.wLz.wFd.DNc + " " + paramString);
              localObject1 = paramString;
              b.lI(136);
              localObject1 = paramString;
              this.wMe = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.wLz != null)
            {
              localObject2 = paramString;
              if (this.wLz.wFd != null)
              {
                localObject2 = this.wLz.wFd;
                if (!this.wLz.wLs) {
                  break label924;
                }
                localObject1 = ((bpi)localObject2).DNi;
                if (!this.wLz.wLs) {
                  break label934;
                }
                i = ((bpi)localObject2).DNj;
                localObject2 = paramString;
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  localObject2 = m(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
                }
              }
            }
            return localObject2;
          }
          catch (Exception localException2)
          {
            String str;
            continue;
          }
          if (m != 0)
          {
            localObject1 = paramString;
            this.wLz.wFd.mediaType = 4;
            localObject1 = paramString;
            localObject2 = m(paramString, new String[] { "tp=wxpic" });
            localObject1 = localObject2;
            ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
            continue;
          }
          if (j != 0)
          {
            localObject1 = paramString;
            str = m(paramString, new String[] { "tp=wxpc" });
            localObject1 = str;
            ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          if (k != 0)
          {
            localObject1 = paramString;
            str = m(paramString, new String[] { "tp=hevc" });
            localObject1 = str;
            ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          str = paramString;
          if (i == 0) {
            continue;
          }
          localObject1 = paramString;
          str = m(paramString, new String[] { "tp=webp" });
          localObject1 = str;
          ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
          continue;
          label924:
          localObject1 = str.DNf;
          continue;
          label934:
          i = str.DNg;
          continue;
        }
        k = 1;
        continue;
        label954:
        j = 1;
        continue;
        label959:
        i = 1;
        continue;
        label964:
        i = 0;
        if (i != 0) {
          i = 0;
        }
      }
    }
  }
  
  public final String b(String paramString, bpi parambpi)
  {
    int n = 2;
    int i1 = 0;
    if (parambpi == null)
    {
      ad.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
      parambpi = apd(paramString);
      return parambpi;
    }
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      int j;
      int k;
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = g.Zd().getValue("SnsCloseDownloadWebp");
          localObject1 = paramString;
          if (bt.isNullOrNil((String)localObject2)) {
            break label900;
          }
          localObject1 = paramString;
          i = bt.aGh((String)localObject2);
        }
        catch (Exception parambpi)
        {
          int m;
          Object localObject3;
          paramString = (String)localObject1;
          ad.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + parambpi.getMessage());
          return paramString;
        }
        localObject1 = paramString;
        if (!n.WM())
        {
          j = 0;
          localObject1 = paramString;
          if (!n.WM())
          {
            k = 0;
            localObject1 = paramString;
            if (n.WM()) {
              continue;
            }
            m = i1;
            localObject1 = paramString;
            if (bt.isNullOrNil(ab.hWt))
            {
              localObject1 = paramString;
              if (bt.isNullOrNil(ab.hWu)) {
                continue;
              }
            }
            localObject3 = paramString;
            localObject1 = paramString;
            if (bt.isNullOrNil(ab.hWt)) {
              continue;
            }
            localObject1 = paramString;
            localObject2 = paramString.split("(//?)");
            localObject1 = paramString;
            localObject3 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ab.hWt);
            i = n;
            localObject1 = paramString;
            if (i >= localObject2.length) {
              continue;
            }
            localObject1 = paramString;
            ((StringBuilder)localObject3).append("/").append(localObject2[i]);
            i += 1;
            continue;
            localObject1 = paramString;
            if (Build.VERSION.SDK_INT < 14)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (ae.fFH.fCV == 2)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (bt.isNullOrNil(ab.hWu)) {
              break label895;
            }
            i = 0;
          }
        }
        else
        {
          localObject1 = paramString;
          if (!af.dtJ())
          {
            j = 0;
            continue;
          }
          localObject1 = paramString;
          if (bt.isNullOrNil(ab.hWu)) {
            break label889;
          }
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (!af.dtG())
        {
          k = 0;
        }
        else
        {
          localObject1 = paramString;
          if (bt.isNullOrNil(ab.hWu)) {
            break label883;
          }
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (af.dtH())
          {
            m = i1;
            localObject1 = paramString;
            if (bt.isNullOrNil(ab.hWu))
            {
              m = 1;
              continue;
              localObject1 = paramString;
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject1 = localObject3;
              ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!bt.isNullOrNil(ab.hWu))
              {
                localObject1 = localObject3;
                localObject2 = m((String)localObject3, new String[] { "tp=" + ab.hWu });
                localObject1 = localObject2;
                ad.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
              }
              paramString = (String)localObject2;
              localObject1 = localObject2;
              if (parambpi.DNc != 0)
              {
                localObject1 = localObject2;
                paramString = m((String)localObject2, new String[] { "enc=1" });
                localObject1 = paramString;
                ad.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + parambpi.DNd + " " + parambpi.DNc + " " + paramString);
                localObject1 = paramString;
                b.lI(136);
                localObject1 = paramString;
                this.wMe = true;
              }
            }
          }
        }
        label862:
        label871:
        try
        {
          if (!this.wLz.wLs) {
            break label862;
          }
          localObject1 = parambpi.DNi;
          if (!this.wLz.wLs) {
            break label871;
          }
          i = parambpi.DNj;
          parambpi = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          parambpi = m(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
          return parambpi;
        }
        catch (Exception parambpi) {}
      }
      if (m != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=wxpic" });
        localObject1 = localObject2;
        ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (j != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=wxpc" });
        localObject1 = localObject2;
        ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (k != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=hevc" });
        localObject1 = localObject2;
        ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else
      {
        localObject2 = paramString;
        if (i != 0)
        {
          localObject1 = paramString;
          localObject2 = m(paramString, new String[] { "tp=webp" });
          localObject1 = localObject2;
          ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
          continue;
          localObject1 = parambpi.DNf;
          continue;
          i = parambpi.DNg;
          continue;
          label883:
          k = 1;
          continue;
          label889:
          j = 1;
          continue;
          label895:
          i = 1;
          continue;
          label900:
          i = 0;
          if (i != 0) {
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.f
 * JD-Core Version:    0.7.0.1
 */