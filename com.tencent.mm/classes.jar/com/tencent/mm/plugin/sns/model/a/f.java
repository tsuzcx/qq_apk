package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class f
  extends c
{
  protected boolean zoF = false;
  protected boolean zoG = false;
  protected boolean zoH = false;
  protected boolean zoI = false;
  protected boolean zoJ = false;
  
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
  
  public final String azv(String paramString)
  {
    int n = 2;
    int i1 = 0;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = g.acA().getValue("SnsCloseDownloadWebp");
        localObject1 = paramString;
        if (bt.isNullOrNil((String)localObject2)) {
          break label964;
        }
        localObject1 = paramString;
        i = bt.aRe((String)localObject2);
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
      if (!n.aal())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.aal())
        {
          k = 0;
          localObject1 = paramString;
          if (n.aal()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (bt.isNullOrNil(ac.iPF))
          {
            localObject1 = paramString;
            if (bt.isNullOrNil(ac.iPG)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (bt.isNullOrNil(ac.iPF)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.iPF);
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
          if (ae.gcP.gab == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (bt.isNullOrNil(ac.iPG)) {
            break label959;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!ag.dUu())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (bt.isNullOrNil(ac.iPG)) {
          break label954;
        }
        j = 0;
        continue;
      }
      localObject1 = paramString;
      if (!ag.dUr())
      {
        k = 0;
      }
      else
      {
        localObject1 = paramString;
        if (!bt.isNullOrNil(ac.iPG))
        {
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (!ag.dUs()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (!bt.isNullOrNil(ac.iPG)) {
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
          if (!bt.isNullOrNil(ac.iPG))
          {
            localObject1 = localObject3;
            localObject2 = m((String)localObject3, new String[] { "tp=" + ac.iPG });
            localObject1 = localObject2;
            ad.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.zoe != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.zoe.zhs.GSU != 0)
            {
              localObject1 = localObject2;
              paramString = m((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              ad.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.zoe.zhs.GSV + " " + this.zoe.zhs.GSU + " " + paramString);
              localObject1 = paramString;
              b.ma(136);
              localObject1 = paramString;
              this.zoJ = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.zoe != null)
            {
              localObject2 = paramString;
              if (this.zoe.zhs != null)
              {
                localObject2 = this.zoe.zhs;
                if (!this.zoe.znX) {
                  break label924;
                }
                localObject1 = ((byn)localObject2).GTa;
                if (!this.zoe.znX) {
                  break label934;
                }
                i = ((byn)localObject2).GTb;
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
            this.zoe.zhs.mediaType = 4;
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
          localObject1 = str.GSX;
          continue;
          label934:
          i = str.GSY;
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
  
  public final String b(String paramString, byn parambyn)
  {
    int n = 2;
    int i1 = 0;
    if (parambyn == null)
    {
      ad.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
      parambyn = azv(paramString);
      return parambyn;
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
          localObject2 = g.acA().getValue("SnsCloseDownloadWebp");
          localObject1 = paramString;
          if (bt.isNullOrNil((String)localObject2)) {
            break label900;
          }
          localObject1 = paramString;
          i = bt.aRe((String)localObject2);
        }
        catch (Exception parambyn)
        {
          int m;
          Object localObject3;
          paramString = (String)localObject1;
          ad.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + parambyn.getMessage());
          return paramString;
        }
        localObject1 = paramString;
        if (!n.aal())
        {
          j = 0;
          localObject1 = paramString;
          if (!n.aal())
          {
            k = 0;
            localObject1 = paramString;
            if (n.aal()) {
              continue;
            }
            m = i1;
            localObject1 = paramString;
            if (bt.isNullOrNil(ac.iPF))
            {
              localObject1 = paramString;
              if (bt.isNullOrNil(ac.iPG)) {
                continue;
              }
            }
            localObject3 = paramString;
            localObject1 = paramString;
            if (bt.isNullOrNil(ac.iPF)) {
              continue;
            }
            localObject1 = paramString;
            localObject2 = paramString.split("(//?)");
            localObject1 = paramString;
            localObject3 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.iPF);
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
            if (ae.gcP.gab == 2)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (bt.isNullOrNil(ac.iPG)) {
              break label895;
            }
            i = 0;
          }
        }
        else
        {
          localObject1 = paramString;
          if (!ag.dUu())
          {
            j = 0;
            continue;
          }
          localObject1 = paramString;
          if (bt.isNullOrNil(ac.iPG)) {
            break label889;
          }
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (!ag.dUr())
        {
          k = 0;
        }
        else
        {
          localObject1 = paramString;
          if (bt.isNullOrNil(ac.iPG)) {
            break label883;
          }
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (ag.dUs())
          {
            m = i1;
            localObject1 = paramString;
            if (bt.isNullOrNil(ac.iPG))
            {
              m = 1;
              continue;
              localObject1 = paramString;
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject1 = localObject3;
              ad.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!bt.isNullOrNil(ac.iPG))
              {
                localObject1 = localObject3;
                localObject2 = m((String)localObject3, new String[] { "tp=" + ac.iPG });
                localObject1 = localObject2;
                ad.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
              }
              paramString = (String)localObject2;
              localObject1 = localObject2;
              if (parambyn.GSU != 0)
              {
                localObject1 = localObject2;
                paramString = m((String)localObject2, new String[] { "enc=1" });
                localObject1 = paramString;
                ad.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + parambyn.GSV + " " + parambyn.GSU + " " + paramString);
                localObject1 = paramString;
                b.ma(136);
                localObject1 = paramString;
                this.zoJ = true;
              }
            }
          }
        }
        label862:
        label871:
        try
        {
          if (!this.zoe.znX) {
            break label862;
          }
          localObject1 = parambyn.GTa;
          if (!this.zoe.znX) {
            break label871;
          }
          i = parambyn.GTb;
          parambyn = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          parambyn = m(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
          return parambyn;
        }
        catch (Exception parambyn) {}
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
          localObject1 = parambyn.GSX;
          continue;
          i = parambyn.GSY;
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