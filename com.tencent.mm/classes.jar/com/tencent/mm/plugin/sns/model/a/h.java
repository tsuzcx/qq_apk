package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class h
  extends c
{
  protected boolean QAu = false;
  protected boolean QAv = false;
  protected boolean QAw = false;
  protected boolean QAx = false;
  protected boolean QAy = false;
  
  public h(c.a parama, a parama1)
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
  
  public final String aYY(String paramString)
  {
    int n = 2;
    int i1 = 0;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = i.aRC().getValue("SnsCloseDownloadWebp");
        localObject1 = paramString;
        if (Util.isNullOrNil((String)localObject2)) {
          break label964;
        }
        localObject1 = paramString;
        i = Util.safeParseInt((String)localObject2);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        int m;
        Object localObject3;
        paramString = (String)localObject1;
        Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + localException1.getMessage());
        return paramString;
      }
      localObject1 = paramString;
      int j;
      int k;
      if (!n.aOR())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.aOR())
        {
          k = 0;
          localObject1 = paramString;
          if (n.aOR()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (Util.isNullOrNil(z.pDd))
          {
            localObject1 = paramString;
            if (Util.isNullOrNil(z.pDe)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (Util.isNullOrNil(z.pDd)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(z.pDd);
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
          if (af.lYj.lVp == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (Util.isNullOrNil(z.pDe)) {
            break label959;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!al.hgU())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (Util.isNullOrNil(z.pDe)) {
          break label954;
        }
        j = 0;
        continue;
      }
      localObject1 = paramString;
      if (!al.hgR())
      {
        k = 0;
      }
      else
      {
        localObject1 = paramString;
        if (!Util.isNullOrNil(z.pDe))
        {
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (!al.hgS()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (!Util.isNullOrNil(z.pDe)) {
            continue;
          }
          m = 1;
          continue;
          localObject1 = paramString;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = localObject3;
          Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (!Util.isNullOrNil(z.pDe))
          {
            localObject1 = localObject3;
            localObject2 = m((String)localObject3, new String[] { "tp=" + z.pDe });
            localObject1 = localObject2;
            Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.QzS != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.QzS.Qsr.aaTw != 0)
            {
              localObject1 = localObject2;
              paramString = m((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.QzS.Qsr.aaTx + " " + this.QzS.Qsr.aaTw + " " + paramString);
              localObject1 = paramString;
              b.rG(136);
              localObject1 = paramString;
              this.QAy = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.QzS != null)
            {
              localObject2 = paramString;
              if (this.QzS.Qsr != null)
              {
                localObject2 = this.QzS.Qsr;
                if (!this.QzS.QzL) {
                  break label924;
                }
                localObject1 = ((dmz)localObject2).aaTB;
                if (!this.QzS.QzL) {
                  break label934;
                }
                i = ((dmz)localObject2).aaTC;
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
            this.QzS.Qsr.mediaType = 4;
            localObject1 = paramString;
            localObject2 = m(paramString, new String[] { "tp=wxpic" });
            localObject1 = localObject2;
            Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
            continue;
          }
          if (j != 0)
          {
            localObject1 = paramString;
            str = m(paramString, new String[] { "tp=wxpc" });
            localObject1 = str;
            Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          if (k != 0)
          {
            localObject1 = paramString;
            str = m(paramString, new String[] { "tp=hevc" });
            localObject1 = str;
            Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          str = paramString;
          if (i == 0) {
            continue;
          }
          localObject1 = paramString;
          str = m(paramString, new String[] { "tp=webp" });
          localObject1 = str;
          Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
          continue;
          label924:
          localObject1 = str.msf;
          continue;
          label934:
          i = str.aaTz;
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
  
  public final String b(String paramString, dmz paramdmz)
  {
    int n = 2;
    int i1 = 0;
    if (paramdmz == null)
    {
      Log.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
      paramdmz = aYY(paramString);
      return paramdmz;
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
          localObject2 = i.aRC().getValue("SnsCloseDownloadWebp");
          localObject1 = paramString;
          if (Util.isNullOrNil((String)localObject2)) {
            break label900;
          }
          localObject1 = paramString;
          i = Util.safeParseInt((String)localObject2);
        }
        catch (Exception paramdmz)
        {
          int m;
          Object localObject3;
          paramString = (String)localObject1;
          Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + paramdmz.getMessage());
          return paramString;
        }
        localObject1 = paramString;
        if (!n.aOR())
        {
          j = 0;
          localObject1 = paramString;
          if (!n.aOR())
          {
            k = 0;
            localObject1 = paramString;
            if (n.aOR()) {
              continue;
            }
            m = i1;
            localObject1 = paramString;
            if (Util.isNullOrNil(z.pDd))
            {
              localObject1 = paramString;
              if (Util.isNullOrNil(z.pDe)) {
                continue;
              }
            }
            localObject3 = paramString;
            localObject1 = paramString;
            if (Util.isNullOrNil(z.pDd)) {
              continue;
            }
            localObject1 = paramString;
            localObject2 = paramString.split("(//?)");
            localObject1 = paramString;
            localObject3 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(z.pDd);
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
            if (af.lYj.lVp == 2)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (Util.isNullOrNil(z.pDe)) {
              break label895;
            }
            i = 0;
          }
        }
        else
        {
          localObject1 = paramString;
          if (!al.hgU())
          {
            j = 0;
            continue;
          }
          localObject1 = paramString;
          if (Util.isNullOrNil(z.pDe)) {
            break label889;
          }
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (!al.hgR())
        {
          k = 0;
        }
        else
        {
          localObject1 = paramString;
          if (Util.isNullOrNil(z.pDe)) {
            break label883;
          }
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (al.hgS())
          {
            m = i1;
            localObject1 = paramString;
            if (Util.isNullOrNil(z.pDe))
            {
              m = 1;
              continue;
              localObject1 = paramString;
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject1 = localObject3;
              Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!Util.isNullOrNil(z.pDe))
              {
                localObject1 = localObject3;
                localObject2 = m((String)localObject3, new String[] { "tp=" + z.pDe });
                localObject1 = localObject2;
                Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
              }
              paramString = (String)localObject2;
              localObject1 = localObject2;
              if (paramdmz.aaTw != 0)
              {
                localObject1 = localObject2;
                paramString = m((String)localObject2, new String[] { "enc=1" });
                localObject1 = paramString;
                Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + paramdmz.aaTx + " " + paramdmz.aaTw + " " + paramString);
                localObject1 = paramString;
                b.rG(136);
                localObject1 = paramString;
                this.QAy = true;
              }
            }
          }
        }
        label862:
        label871:
        try
        {
          if (!this.QzS.QzL) {
            break label862;
          }
          localObject1 = paramdmz.aaTB;
          if (!this.QzS.QzL) {
            break label871;
          }
          i = paramdmz.aaTC;
          paramdmz = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          paramdmz = m(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
          return paramdmz;
        }
        catch (Exception paramdmz) {}
      }
      if (m != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=wxpic" });
        localObject1 = localObject2;
        Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (j != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=wxpc" });
        localObject1 = localObject2;
        Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (k != 0)
      {
        localObject1 = paramString;
        localObject2 = m(paramString, new String[] { "tp=hevc" });
        localObject1 = localObject2;
        Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else
      {
        localObject2 = paramString;
        if (i != 0)
        {
          localObject1 = paramString;
          localObject2 = m(paramString, new String[] { "tp=webp" });
          localObject1 = localObject2;
          Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
          continue;
          localObject1 = paramdmz.msf;
          continue;
          i = paramdmz.aaTz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.h
 * JD-Core Version:    0.7.0.1
 */