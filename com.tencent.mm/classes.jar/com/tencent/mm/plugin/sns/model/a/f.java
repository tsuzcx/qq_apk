package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class f
  extends c
{
  protected boolean DPU = false;
  protected boolean DPV = false;
  protected boolean DPW = false;
  protected boolean DPX = false;
  protected boolean DPY = false;
  
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
  
  public final String aPI(String paramString)
  {
    int n = 2;
    int i1 = 0;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = h.aqJ().getValue("SnsCloseDownloadWebp");
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
      if (!n.aot())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.aot())
        {
          k = 0;
          localObject1 = paramString;
          if (n.aot()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.jPt))
          {
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.jPu)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.jPt)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.jPt);
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
          if (ae.gKE.gHI == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.jPu)) {
            break label959;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!aj.fbg())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (Util.isNullOrNil(ac.jPu)) {
          break label954;
        }
        j = 0;
        continue;
      }
      localObject1 = paramString;
      if (!aj.fbd())
      {
        k = 0;
      }
      else
      {
        localObject1 = paramString;
        if (!Util.isNullOrNil(ac.jPu))
        {
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (!aj.fbe()) {
            continue;
          }
          m = i1;
          localObject1 = paramString;
          if (!Util.isNullOrNil(ac.jPu)) {
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
          if (!Util.isNullOrNil(ac.jPu))
          {
            localObject1 = localObject3;
            localObject2 = m((String)localObject3, new String[] { "tp=" + ac.jPu });
            localObject1 = localObject2;
            Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.DPt != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.DPt.DIq.MsK != 0)
            {
              localObject1 = localObject2;
              paramString = m((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.DPt.DIq.MsL + " " + this.DPt.DIq.MsK + " " + paramString);
              localObject1 = paramString;
              b.pl(136);
              localObject1 = paramString;
              this.DPY = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.DPt != null)
            {
              localObject2 = paramString;
              if (this.DPt.DIq != null)
              {
                localObject2 = this.DPt.DIq;
                if (!this.DPt.DPm) {
                  break label924;
                }
                localObject1 = ((cnb)localObject2).MsP;
                if (!this.DPt.DPm) {
                  break label934;
                }
                i = ((cnb)localObject2).MsQ;
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
            this.DPt.DIq.mediaType = 4;
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
          localObject1 = str.viB;
          continue;
          label934:
          i = str.MsN;
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
  
  public final String b(String paramString, cnb paramcnb)
  {
    int n = 2;
    int i1 = 0;
    if (paramcnb == null)
    {
      Log.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
      paramcnb = aPI(paramString);
      return paramcnb;
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
          localObject2 = h.aqJ().getValue("SnsCloseDownloadWebp");
          localObject1 = paramString;
          if (Util.isNullOrNil((String)localObject2)) {
            break label900;
          }
          localObject1 = paramString;
          i = Util.safeParseInt((String)localObject2);
        }
        catch (Exception paramcnb)
        {
          int m;
          Object localObject3;
          paramString = (String)localObject1;
          Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + paramcnb.getMessage());
          return paramString;
        }
        localObject1 = paramString;
        if (!n.aot())
        {
          j = 0;
          localObject1 = paramString;
          if (!n.aot())
          {
            k = 0;
            localObject1 = paramString;
            if (n.aot()) {
              continue;
            }
            m = i1;
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.jPt))
            {
              localObject1 = paramString;
              if (Util.isNullOrNil(ac.jPu)) {
                continue;
              }
            }
            localObject3 = paramString;
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.jPt)) {
              continue;
            }
            localObject1 = paramString;
            localObject2 = paramString.split("(//?)");
            localObject1 = paramString;
            localObject3 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ac.jPt);
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
            if (ae.gKE.gHI == 2)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.jPu)) {
              break label895;
            }
            i = 0;
          }
        }
        else
        {
          localObject1 = paramString;
          if (!aj.fbg())
          {
            j = 0;
            continue;
          }
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.jPu)) {
            break label889;
          }
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (!aj.fbd())
        {
          k = 0;
        }
        else
        {
          localObject1 = paramString;
          if (Util.isNullOrNil(ac.jPu)) {
            break label883;
          }
          k = 0;
          continue;
          m = i1;
          localObject1 = paramString;
          if (aj.fbe())
          {
            m = i1;
            localObject1 = paramString;
            if (Util.isNullOrNil(ac.jPu))
            {
              m = 1;
              continue;
              localObject1 = paramString;
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject1 = localObject3;
              Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!Util.isNullOrNil(ac.jPu))
              {
                localObject1 = localObject3;
                localObject2 = m((String)localObject3, new String[] { "tp=" + ac.jPu });
                localObject1 = localObject2;
                Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
              }
              paramString = (String)localObject2;
              localObject1 = localObject2;
              if (paramcnb.MsK != 0)
              {
                localObject1 = localObject2;
                paramString = m((String)localObject2, new String[] { "enc=1" });
                localObject1 = paramString;
                Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + paramcnb.MsL + " " + paramcnb.MsK + " " + paramString);
                localObject1 = paramString;
                b.pl(136);
                localObject1 = paramString;
                this.DPY = true;
              }
            }
          }
        }
        label862:
        label871:
        try
        {
          if (!this.DPt.DPm) {
            break label862;
          }
          localObject1 = paramcnb.MsP;
          if (!this.DPt.DPm) {
            break label871;
          }
          i = paramcnb.MsQ;
          paramcnb = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          paramcnb = m(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
          return paramcnb;
        }
        catch (Exception paramcnb) {}
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
          localObject1 = paramcnb.viB;
          continue;
          i = paramcnb.MsN;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.f
 * JD-Core Version:    0.7.0.1
 */