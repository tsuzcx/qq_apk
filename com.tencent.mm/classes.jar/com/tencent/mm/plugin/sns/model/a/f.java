package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class f
  extends c
{
  protected boolean ovn = false;
  protected boolean ovo = false;
  protected boolean ovp = false;
  protected boolean ovq = false;
  
  public f(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private boolean cLj()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    bool1 = bool3;
    float f1;
    float f2;
    float f3;
    if (this.ouO != null)
    {
      bool1 = bool3;
      if (this.ouO.oqa != null)
      {
        bool1 = bool3;
        if (this.ouO.oqa.trS != null)
        {
          bool1 = bool3;
          if (this.ouO.ouH)
          {
            f1 = this.ouO.oqa.trS.tsF;
            f2 = this.ouO.oqa.trS.tsG;
            bool1 = bool3;
            if (f1 != f2)
            {
              if (f1 >= f2) {
                break label202;
              }
              f3 = f1;
              if (f1 <= f2) {
                break label207;
              }
            }
          }
        }
      }
    }
    label202:
    label207:
    for (float f4 = f1;; f4 = f2)
    {
      float f5 = f4 / f3;
      f3 = f4 / (f3 / 300.0F);
      try
      {
        y.d("MicroMsg.SnsDownloadImageBase", "%s width[%s] height[%s] factor[%s] longEdgeScaled[%s]", new Object[] { this.ouO.bUi, Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f5), Float.valueOf(f3) });
        if ((f5 <= 2.0F) || (f3 <= 2000.0F)) {
          break label255;
        }
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (localException.getMessage() == null) {}
          for (String str = "unknown";; str = str.getMessage())
          {
            y.w("MicroMsg.SnsDownloadImageBase", "isNeedTransToWebp exception: %s", new Object[] { str });
            return false;
          }
          bool1 = false;
        }
      }
      return bool1;
      f3 = f2;
      break;
    }
  }
  
  private static String j(String paramString, String... paramVarArgs)
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
  
  public final String Oc(String paramString)
  {
    int m = 2;
    int n = 1;
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        localObject2 = g.AA().getValue("SnsCloseDownloadWebp");
        localObject1 = paramString;
        if (bk.bl((String)localObject2)) {
          break label927;
        }
        localObject1 = paramString;
        i = bk.ZR((String)localObject2);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject3;
        paramString = (String)localObject1;
        y.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + localException1.getMessage());
        return paramString;
      }
      localObject1 = paramString;
      int j;
      int k;
      if (!n.yY())
      {
        j = 0;
        localObject1 = paramString;
        if (!n.yY())
        {
          k = 0;
          localObject1 = paramString;
          if (!cLj()) {
            break label908;
          }
          k = 0;
          j = 0;
          i = n;
          localObject1 = paramString;
          if (bk.bl(ae.eTB))
          {
            localObject1 = paramString;
            if (bk.bl(ae.eTC)) {
              continue;
            }
          }
          localObject3 = paramString;
          localObject1 = paramString;
          if (bk.bl(ae.eTB)) {
            continue;
          }
          localObject1 = paramString;
          localObject2 = paramString.split("(//?)");
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(localObject2[0]).append("//").append(ae.eTB);
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
          if (q.dyn.dxH == 2)
          {
            i = 0;
            continue;
          }
          localObject1 = paramString;
          if (bk.bl(ae.eTC)) {
            break label922;
          }
          i = 0;
        }
      }
      else
      {
        localObject1 = paramString;
        if (!af.bDQ())
        {
          j = 0;
          continue;
        }
        localObject1 = paramString;
        if (bk.bl(ae.eTC)) {
          break label917;
        }
        j = 0;
        continue;
      }
      localObject1 = paramString;
      if (!af.bDP())
      {
        k = 0;
      }
      else
      {
        localObject1 = paramString;
        if (!bk.bl(ae.eTC))
        {
          k = 0;
          continue;
          localObject1 = paramString;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = localObject3;
          y.i("MicroMsg.SnsDownloadImageBase", "new url  " + (String)localObject3);
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (!bk.bl(ae.eTC))
          {
            localObject1 = localObject3;
            localObject2 = j((String)localObject3, new String[] { "tp=" + ae.eTC });
            localObject1 = localObject2;
            y.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  " + (String)localObject2);
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (this.ouO != null)
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (this.ouO.oqa.tsb != 0)
            {
              localObject1 = localObject2;
              paramString = j((String)localObject2, new String[] { "enc=1" });
              localObject1 = paramString;
              y.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.ouO.oqa.tsc + " " + this.ouO.oqa.tsb + " " + paramString);
              localObject1 = paramString;
              b.jdMethod_if(136);
              localObject1 = paramString;
              this.ovq = true;
            }
          }
          localObject2 = paramString;
          try
          {
            if (this.ouO != null)
            {
              localObject2 = paramString;
              if (this.ouO.oqa != null)
              {
                localObject2 = this.ouO.oqa;
                if (!this.ouO.ouH) {
                  break label884;
                }
                localObject1 = ((awd)localObject2).tsh;
                if (!this.ouO.ouH) {
                  break label894;
                }
                i = ((awd)localObject2).tsi;
                localObject2 = paramString;
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  localObject2 = j(paramString, new String[] { "token=" + (String)localObject1, "idx=" + i });
                }
              }
            }
            return localObject2;
          }
          catch (Exception localException2)
          {
            String str;
            label884:
            label894:
            continue;
          }
          if (j != 0)
          {
            localObject1 = paramString;
            localObject2 = j(paramString, new String[] { "tp=wxpc" });
            localObject1 = localObject2;
            y.i("MicroMsg.SnsDownloadImageBase", "new url  " + (String)localObject2);
          }
          else if (k != 0)
          {
            localObject1 = paramString;
            str = j(paramString, new String[] { "tp=hevc" });
            localObject1 = str;
            y.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
          }
          else
          {
            str = paramString;
            label908:
            if (i != 0)
            {
              localObject1 = paramString;
              str = j(paramString, new String[] { "tp=webp" });
              localObject1 = str;
              y.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
              continue;
              localObject1 = str.tse;
              continue;
              i = str.tsf;
              continue;
            }
          }
        }
        else
        {
          k = 1;
          continue;
          label917:
          j = 1;
          continue;
          label922:
          i = 1;
          continue;
          label927:
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