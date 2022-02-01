package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class f
  extends c
{
  protected boolean zFU = false;
  protected boolean zFV = false;
  protected boolean zFW = false;
  protected boolean zFX = false;
  protected boolean zFY = false;
  
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
  
  public final String aAM(String paramString)
  {
    int n = 2;
    int i1 = 0;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = g.acL().getValue("SnsCloseDownloadWebp");
        localObject1 = paramString;
        if (bu.isNullOrNil((String)localObject2)) {
          break label964;
        }
        localObject1 = paramString;
        i = bu.aSB((String)localObject2);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        int m;
        Object localObject3;
        paramString = (String)localObject1;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + localException1.getMessage());
        return paramString;
      }
      localObject1 = paramString;
      int j;
      int k;
      if (!n.aau())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.aau())
        {
          k = 0;
          localObject1 = paramString;
          if (n.aau()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (bu.isNullOrNil(ac.iSy))
          {
            localObject1 = paramString;
            if (bu.isNullOrNil(ac.iSz)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (bu.isNullOrNil(ac.iSy)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.iSy);
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
          if (com.tencent.mm.compatible.deviceinfo.ae.geX.gck == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (bu.isNullOrNil(ac.iSz)) {
            break label959;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!ah.dXU())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (bu.isNullOrNil(ac.iSz)) {
          break label954;
        }
        j = 0;
        continue;
      }
      localObject1 = paramString;
      if (!ah.dXR())
      {
        k = 0;
      }
      else
      {
        localObject1 = paramString;
        if (!bu.isNullOrNil(ac.iSz))
        {
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (!ah.dXS()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (!bu.isNullOrNil(ac.iSz)) {
            continue;
          }
          m = 1;
          continue;
          localObject1 = paramString;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = localObject3;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (!bu.isNullOrNil(ac.iSz))
          {
            localObject1 = localObject3;
            localObject2 = m((String)localObject3, new String[] { "tp=" + ac.iSz });
            localObject1 = localObject2;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.zFt != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.zFt.zyh.Hmv != 0)
            {
              localObject1 = localObject2;
              paramString = m((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.zFt.zyh.Hmw + " " + this.zFt.zyh.Hmv + " " + paramString);
              localObject1 = paramString;
              b.md(136);
              localObject1 = paramString;
              this.zFY = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.zFt != null)
            {
              localObject2 = paramString;
              if (this.zFt.zyh != null)
              {
                localObject2 = this.zFt.zyh;
                if (!this.zFt.zFm) {
                  break label924;
                }
                localObject1 = ((bzh)localObject2).HmB;
                if (!this.zFt.zFm) {
                  break label934;
                }
                i = ((bzh)localObject2).HmC;
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
            this.zFt.zyh.mediaType = 4;
            localObject1 = paramString;
            localObject2 = m(paramString, new String[] { "tp=wxpic" });
            localObject1 = localObject2;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
            continue;
          }
          if (j != 0)
          {
            localObject1 = paramString;
            str = m(paramString, new String[] { "tp=wxpc" });
            localObject1 = str;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          if (k != 0)
          {
            localObject1 = paramString;
            str = m(paramString, new String[] { "tp=hevc" });
            localObject1 = str;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          str = paramString;
          if (i == 0) {
            continue;
          }
          localObject1 = paramString;
          str = m(paramString, new String[] { "tp=webp" });
          localObject1 = str;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
          continue;
          label924:
          localObject1 = str.Hmy;
          continue;
          label934:
          i = str.Hmz;
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
  
  public final String b(String paramString, bzh parambzh)
  {
    int n = 2;
    int i1 = 0;
    if (parambzh == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
      parambzh = aAM(paramString);
      return parambzh;
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
          localObject2 = g.acL().getValue("SnsCloseDownloadWebp");
          localObject1 = paramString;
          if (bu.isNullOrNil((String)localObject2)) {
            break label900;
          }
          localObject1 = paramString;
          i = bu.aSB((String)localObject2);
        }
        catch (Exception parambzh)
        {
          int m;
          Object localObject3;
          paramString = (String)localObject1;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + parambzh.getMessage());
          return paramString;
        }
        localObject1 = paramString;
        if (!n.aau())
        {
          j = 0;
          localObject1 = paramString;
          if (!n.aau())
          {
            k = 0;
            localObject1 = paramString;
            if (n.aau()) {
              continue;
            }
            m = i1;
            localObject1 = paramString;
            if (bu.isNullOrNil(ac.iSy))
            {
              localObject1 = paramString;
              if (bu.isNullOrNil(ac.iSz)) {
                continue;
              }
            }
            localObject3 = paramString;
            localObject1 = paramString;
            if (bu.isNullOrNil(ac.iSy)) {
              continue;
            }
            localObject1 = paramString;
            localObject2 = paramString.split("(//?)");
            localObject1 = paramString;
            localObject3 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.iSy);
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
            if (com.tencent.mm.compatible.deviceinfo.ae.geX.gck == 2)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (bu.isNullOrNil(ac.iSz)) {
              break label895;
            }
            i = 0;
          }
        }
        else
        {
          localObject1 = paramString;
          if (!ah.dXU())
          {
            j = 0;
            continue;
          }
          localObject1 = paramString;
          if (bu.isNullOrNil(ac.iSz)) {
            break label889;
          }
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (!ah.dXR())
        {
          k = 0;
        }
        else
        {
          localObject1 = paramString;
          if (bu.isNullOrNil(ac.iSz)) {
            break label883;
          }
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (ah.dXS())
          {
            m = i1;
            localObject1 = paramString;
            if (bu.isNullOrNil(ac.iSz))
            {
              m = 1;
              continue;
              localObject1 = paramString;
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject1 = localObject3;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!bu.isNullOrNil(ac.iSz))
              {
                localObject1 = localObject3;
                localObject2 = m((String)localObject3, new String[] { "tp=" + ac.iSz });
                localObject1 = localObject2;
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
              }
              paramString = (String)localObject2;
              localObject1 = localObject2;
              if (parambzh.Hmv != 0)
              {
                localObject1 = localObject2;
                paramString = m((String)localObject2, new String[] { "enc=1" });
                localObject1 = paramString;
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + parambzh.Hmw + " " + parambzh.Hmv + " " + paramString);
                localObject1 = paramString;
                b.md(136);
                localObject1 = paramString;
                this.zFY = true;
              }
            }
          }
        }
        label862:
        label871:
        try
        {
          if (!this.zFt.zFm) {
            break label862;
          }
          localObject1 = parambzh.HmB;
          if (!this.zFt.zFm) {
            break label871;
          }
          i = parambzh.HmC;
          parambzh = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          parambzh = m(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
          return parambzh;
        }
        catch (Exception parambzh) {}
      }
      if (m != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=wxpic" });
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (j != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=wxpc" });
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (k != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=hevc" });
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else
      {
        localObject2 = paramString;
        if (i != 0)
        {
          localObject1 = paramString;
          localObject2 = m(paramString, new String[] { "tp=webp" });
          localObject1 = localObject2;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
          continue;
          localObject1 = parambzh.Hmy;
          continue;
          i = parambzh.Hmz;
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