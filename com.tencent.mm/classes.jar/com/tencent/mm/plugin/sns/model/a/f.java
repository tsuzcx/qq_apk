package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class f
  extends c
{
  protected boolean rki = false;
  protected boolean rkj = false;
  protected boolean rkk = false;
  protected boolean rkl = false;
  
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
  
  public final String aaW(String paramString)
  {
    int m = 2;
    int n = 0;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = g.Nq().getValue("SnsCloseDownloadWebp");
        localObject1 = paramString;
        if (bo.isNullOrNil((String)localObject2)) {
          break label854;
        }
        localObject1 = paramString;
        i = bo.apV((String)localObject2);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject3;
        paramString = (String)localObject1;
        ab.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + localException1.getMessage());
        return paramString;
      }
      localObject1 = paramString;
      int j;
      if (!n.Lv())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.Lv())
        {
          k = n;
          localObject1 = paramString;
          if (bo.isNullOrNil(ae.glw))
          {
            localObject1 = paramString;
            if (bo.isNullOrNil(ae.glx)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (bo.isNullOrNil(ae.glw)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ae.glw);
          i = m;
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
          if (ac.erF.epF == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (bo.isNullOrNil(ae.glx)) {
            break label849;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!ag.cpq())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (bo.isNullOrNil(ae.glx)) {
          break label844;
        }
        j = 0;
        continue;
      }
      int k = n;
      localObject1 = paramString;
      if (ag.cpp())
      {
        k = n;
        localObject1 = paramString;
        if (bo.isNullOrNil(ae.glx))
        {
          k = 1;
          continue;
          localObject1 = paramString;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = localObject3;
          ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (!bo.isNullOrNil(ae.glx))
          {
            localObject1 = localObject3;
            localObject2 = l((String)localObject3, new String[] { "tp=" + ae.glx });
            localObject1 = localObject2;
            ab.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.rjH != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.rjH.reH.xse != 0)
            {
              localObject1 = localObject2;
              paramString = l((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              ab.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.rjH.reH.xsf + " " + this.rjH.reH.xse + " " + paramString);
              localObject1 = paramString;
              b.kS(136);
              localObject1 = paramString;
              this.rkl = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.rjH != null)
            {
              localObject2 = paramString;
              if (this.rjH.reH != null)
              {
                localObject2 = this.rjH.reH;
                if (!this.rjH.rjA) {
                  break label820;
                }
                localObject1 = ((bcs)localObject2).xsk;
                if (!this.rjH.rjA) {
                  break label830;
                }
                i = ((bcs)localObject2).xsl;
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
            label820:
            label830:
            continue;
          }
          if (j != 0)
          {
            localObject1 = paramString;
            localObject2 = l(paramString, new String[] { "tp=wxpc" });
            localObject1 = localObject2;
            ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
          }
          else if (k != 0)
          {
            localObject1 = paramString;
            str = l(paramString, new String[] { "tp=hevc" });
            localObject1 = str;
            ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
          }
          else
          {
            str = paramString;
            if (i != 0)
            {
              localObject1 = paramString;
              str = l(paramString, new String[] { "tp=webp" });
              localObject1 = str;
              ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
              continue;
              localObject1 = str.xsh;
              continue;
              i = str.xsi;
              continue;
              label844:
              j = 1;
              continue;
              label849:
              i = 1;
              continue;
              label854:
              i = 0;
              if (i != 0) {
                i = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public final String b(String paramString, bcs parambcs)
  {
    int m = 2;
    int n = 0;
    if (parambcs == null)
    {
      ab.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
      parambcs = aaW(paramString);
      return parambcs;
    }
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      int j;
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = g.Nq().getValue("SnsCloseDownloadWebp");
          localObject1 = paramString;
          if (bo.isNullOrNil((String)localObject2)) {
            break label804;
          }
          localObject1 = paramString;
          i = bo.apV((String)localObject2);
        }
        catch (Exception parambcs)
        {
          Object localObject3;
          paramString = (String)localObject1;
          ab.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + parambcs.getMessage());
          return paramString;
        }
        localObject1 = paramString;
        if (!n.Lv())
        {
          j = 0;
          localObject1 = paramString;
          if (!n.Lv())
          {
            k = n;
            localObject1 = paramString;
            if (bo.isNullOrNil(ae.glw))
            {
              localObject1 = paramString;
              if (bo.isNullOrNil(ae.glx)) {
                continue;
              }
            }
            localObject3 = paramString;
            localObject1 = paramString;
            if (bo.isNullOrNil(ae.glw)) {
              continue;
            }
            localObject1 = paramString;
            localObject2 = paramString.split("(//?)");
            localObject1 = paramString;
            localObject3 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ae.glw);
            i = m;
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
            if (ac.erF.epF == 2)
            {
              i = 0;
              continue;
            }
            localObject1 = paramString;
            if (bo.isNullOrNil(ae.glx)) {
              break label799;
            }
            i = 0;
          }
        }
        else
        {
          localObject1 = paramString;
          if (!ag.cpq())
          {
            j = 0;
            continue;
          }
          localObject1 = paramString;
          if (bo.isNullOrNil(ae.glx)) {
            break label793;
          }
          j = 0;
          continue;
        }
        int k = n;
        localObject1 = paramString;
        if (ag.cpp())
        {
          k = n;
          localObject1 = paramString;
          if (bo.isNullOrNil(ae.glx))
          {
            k = 1;
            continue;
            localObject1 = paramString;
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject1 = localObject3;
            ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject3)));
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (!bo.isNullOrNil(ae.glx))
            {
              localObject1 = localObject3;
              localObject2 = l((String)localObject3, new String[] { "tp=" + ae.glx });
              localObject1 = localObject2;
              ab.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(localObject2)));
            }
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (parambcs.xse != 0)
            {
              localObject1 = localObject2;
              paramString = l((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              ab.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + parambcs.xsf + " " + parambcs.xse + " " + paramString);
              localObject1 = paramString;
              b.kS(136);
              localObject1 = paramString;
              this.rkl = true;
            }
          }
        }
        label772:
        label781:
        try
        {
          if (!this.rjH.rjA) {
            break label772;
          }
          localObject1 = parambcs.xsk;
          if (!this.rjH.rjA) {
            break label781;
          }
          i = parambcs.xsl;
          parambcs = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          parambcs = l(paramString, new String[] { "token=".concat(String.valueOf(localObject1)), "idx=".concat(String.valueOf(i)) });
          return parambcs;
        }
        catch (Exception parambcs) {}
      }
      if (j != 0)
      {
        localObject1 = paramString;
        localObject2 = l(paramString, new String[] { "tp=wxpc" });
        localObject1 = localObject2;
        ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else if (k != 0)
      {
        localObject1 = paramString;
        localObject2 = l(paramString, new String[] { "tp=hevc" });
        localObject1 = localObject2;
        ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
      }
      else
      {
        localObject2 = paramString;
        if (i != 0)
        {
          localObject1 = paramString;
          localObject2 = l(paramString, new String[] { "tp=webp" });
          localObject1 = localObject2;
          ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(localObject2)));
          continue;
          localObject1 = parambcs.xsh;
          continue;
          i = parambcs.xsi;
          continue;
          label793:
          j = 1;
          continue;
          label799:
          i = 1;
          continue;
          label804:
          i = 0;
          if (i != 0) {
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.f
 * JD-Core Version:    0.7.0.1
 */