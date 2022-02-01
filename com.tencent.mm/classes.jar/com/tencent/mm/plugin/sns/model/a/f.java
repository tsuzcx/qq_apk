package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class f
  extends c
{
  protected boolean Kdb = false;
  protected boolean Kdc = false;
  protected boolean Kdd = false;
  protected boolean Kde = false;
  protected boolean Kdf = false;
  
  public f(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private static String l(String paramString, String... paramVarArgs)
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
  
  public final String b(String paramString, cvt paramcvt)
  {
    int n = 2;
    int i1 = 0;
    if (paramcvt == null)
    {
      Log.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
      paramcvt = baE(paramString);
      return paramcvt;
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
          localObject2 = h.axc().getValue("SnsCloseDownloadWebp");
          localObject1 = paramString;
          if (Util.isNullOrNil((String)localObject2)) {
            break label900;
          }
          localObject1 = paramString;
          i = Util.safeParseInt((String)localObject2);
        }
        catch (Exception paramcvt)
        {
          int m;
          Object localObject3;
          paramString = (String)localObject1;
          Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + paramcvt.getMessage());
          return paramString;
        }
        localObject1 = paramString;
        if (!n.auy())
        {
          j = 0;
          localObject1 = paramString;
          if (!n.auy())
          {
            k = 0;
            localObject1 = paramString;
            if (n.auy()) {
              continue;
            }
            m = i1;
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.mGD))
            {
              localObject1 = paramString;
              if (Util.isNullOrNil(ac.mGE)) {
                continue;
              }
            }
            localObject3 = paramString;
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.mGD)) {
              continue;
            }
            localObject1 = paramString;
            localObject2 = paramString.split("(//?)");
            localObject1 = paramString;
            localObject3 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.mGD);
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
            if (af.juS.jrZ == 2)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.mGE)) {
              break label895;
            }
            i = 0;
          }
        }
        else
        {
          localObject1 = paramString;
          if (!aj.fPa())
          {
            j = 0;
            continue;
          }
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.mGE)) {
            break label889;
          }
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (!aj.fOX())
        {
          k = 0;
        }
        else
        {
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.mGE)) {
            break label883;
          }
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (aj.fOY())
          {
            m = i1;
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.mGE))
            {
              m = 1;
              continue;
              localObject1 = paramString;
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject1 = localObject3;
              Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!Util.isNullOrNil(ac.mGE))
              {
                localObject1 = localObject3;
                localObject2 = l((String)localObject3, new String[] { "tp=" + ac.mGE });
                localObject1 = localObject2;
                Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
              }
              paramString = (String)localObject2;
              localObject1 = localObject2;
              if (paramcvt.TDQ != 0)
              {
                localObject1 = localObject2;
                paramString = l((String)localObject2, new String[] { "enc=1" });
                localObject1 = paramString;
                Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + paramcvt.TDR + " " + paramcvt.TDQ + " " + paramString);
                localObject1 = paramString;
                b.rE(136);
                localObject1 = paramString;
                this.Kdf = true;
              }
            }
          }
        }
        label862:
        label871:
        try
        {
          if (!this.KcA.Kct) {
            break label862;
          }
          localObject1 = paramcvt.TDV;
          if (!this.KcA.Kct) {
            break label871;
          }
          i = paramcvt.TDW;
          paramcvt = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          paramcvt = l(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
          return paramcvt;
        }
        catch (Exception paramcvt) {}
      }
      if (m != 0)
      {
        localObject1 = paramString;
        localObject2 = l(paramString, new String[] { "tp=wxpic" });
        localObject1 = localObject2;
        Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (j != 0)
      {
        localObject1 = paramString;
        localObject2 = l(paramString, new String[] { "tp=wxpc" });
        localObject1 = localObject2;
        Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (k != 0)
      {
        localObject1 = paramString;
        localObject2 = l(paramString, new String[] { "tp=hevc" });
        localObject1 = localObject2;
        Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else
      {
        localObject2 = paramString;
        if (i != 0)
        {
          localObject1 = paramString;
          localObject2 = l(paramString, new String[] { "tp=webp" });
          localObject1 = localObject2;
          Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
          continue;
          localObject1 = paramcvt.zZu;
          continue;
          i = paramcvt.TDT;
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
  
  public final String baE(String paramString)
  {
    int n = 2;
    int i1 = 0;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = h.axc().getValue("SnsCloseDownloadWebp");
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
      if (!n.auy())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.auy())
        {
          k = 0;
          localObject1 = paramString;
          if (n.auy()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.mGD))
          {
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.mGE)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.mGD)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.mGD);
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
          if (af.juS.jrZ == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.mGE)) {
            break label959;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!aj.fPa())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (Util.isNullOrNil(ac.mGE)) {
          break label954;
        }
        j = 0;
        continue;
      }
      localObject1 = paramString;
      if (!aj.fOX())
      {
        k = 0;
      }
      else
      {
        localObject1 = paramString;
        if (!Util.isNullOrNil(ac.mGE))
        {
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (!aj.fOY()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (!Util.isNullOrNil(ac.mGE)) {
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
          if (!Util.isNullOrNil(ac.mGE))
          {
            localObject1 = localObject3;
            localObject2 = l((String)localObject3, new String[] { "tp=" + ac.mGE });
            localObject1 = localObject2;
            Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.KcA != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.KcA.JVq.TDQ != 0)
            {
              localObject1 = localObject2;
              paramString = l((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.KcA.JVq.TDR + " " + this.KcA.JVq.TDQ + " " + paramString);
              localObject1 = paramString;
              b.rE(136);
              localObject1 = paramString;
              this.Kdf = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.KcA != null)
            {
              localObject2 = paramString;
              if (this.KcA.JVq != null)
              {
                localObject2 = this.KcA.JVq;
                if (!this.KcA.Kct) {
                  break label924;
                }
                localObject1 = ((cvt)localObject2).TDV;
                if (!this.KcA.Kct) {
                  break label934;
                }
                i = ((cvt)localObject2).TDW;
                localObject2 = paramString;
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  localObject2 = l(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
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
            this.KcA.JVq.mediaType = 4;
            localObject1 = paramString;
            localObject2 = l(paramString, new String[] { "tp=wxpic" });
            localObject1 = localObject2;
            Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
            continue;
          }
          if (j != 0)
          {
            localObject1 = paramString;
            str = l(paramString, new String[] { "tp=wxpc" });
            localObject1 = str;
            Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          if (k != 0)
          {
            localObject1 = paramString;
            str = l(paramString, new String[] { "tp=hevc" });
            localObject1 = str;
            Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            continue;
          }
          str = paramString;
          if (i == 0) {
            continue;
          }
          localObject1 = paramString;
          str = l(paramString, new String[] { "tp=webp" });
          localObject1 = str;
          Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
          continue;
          label924:
          localObject1 = str.zZu;
          continue;
          label934:
          i = str.TDT;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.f
 * JD-Core Version:    0.7.0.1
 */