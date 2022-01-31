package com.tencent.tencentmap.mapsdk.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class fl
{
  public String a;
  private boolean b;
  private boolean c;
  private int d;
  private URL e;
  private String f;
  private int g;
  
  public fl(URL paramURL, String paramString)
  {
    if (ey.a.a("direct_access_use_schedule", 0, 1, 1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.b = bool1;
      bool1 = bool2;
      if (ey.a.a("direct_https_use_sche", 0, 1, 1) == 1) {
        bool1 = true;
      }
      this.c = bool1;
      this.d = ey.a.a("direct_access_domain_try_times", 1, 8, 2);
      this.a = "";
      this.e = paramURL;
      this.f = paramString;
      return;
    }
  }
  
  public final String a(en paramen)
  {
    Object localObject;
    if (paramen.e())
    {
      localObject = this.f;
      return localObject;
    }
    label61:
    String str;
    if (!this.e.getProtocol().startsWith("https"))
    {
      localObject = "http://" + paramen.a() + ":" + paramen.c();
      str = this.e.getFile();
      paramen = (en)localObject;
      if (!TextUtils.isEmpty(str)) {
        if (!str.startsWith("/")) {
          break label217;
        }
      }
    }
    label217:
    for (paramen = (String)localObject + str;; paramen = (String)localObject + "/" + str)
    {
      str = this.e.getRef();
      localObject = paramen;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      return paramen + "#" + str;
      if (this.g != 0)
      {
        localObject = "https://" + paramen.a() + ":" + this.g;
        break label61;
      }
      localObject = "https://" + paramen.a() + ":443";
      break label61;
    }
  }
  
  public final List<en> a(fj paramfj, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 3;
    int j = 0;
    paramfj = new en(this.e.getHost(), -1);
    paramfj.a((byte)3);
    for (;;)
    {
      try
      {
        Object localObject = new ArrayList();
        if (!paramBoolean1)
        {
          ((List)localObject).add(paramfj);
          paramfj.a = 1;
          return localObject;
        }
        if ((!ey.i()) && (this.b)) {
          if ((paramBoolean2) && (!this.c))
          {
            break label288;
            if (i < this.d)
            {
              ((List)localObject).add(paramfj);
              i += 1;
              continue;
            }
            if (ey.i())
            {
              i = 2;
              paramfj.a = i;
              return localObject;
            }
            i = k;
            if (!this.b) {
              continue;
            }
            i = 4;
            continue;
          }
          else
          {
            if ((paramBoolean2) && (Build.VERSION.SDK_INT <= 18))
            {
              i = 0;
              if (i < this.d)
              {
                ((List)localObject).add(paramfj);
                i += 1;
                continue;
              }
              paramfj.a = 10;
              return localObject;
            }
            localObject = fj.a(this.e.getHost());
            List localList = ((ew)localObject).c;
            this.g = ((ew)localObject).d;
            this.a = ((ew)localObject).b;
            return localList;
          }
        }
      }
      catch (Exception localException)
      {
        ArrayList localArrayList = new ArrayList();
        i = j;
        if (i < this.d)
        {
          localArrayList.add(paramfj);
          i += 1;
          continue;
        }
        paramfj.a = 8;
        return localArrayList;
      }
      label288:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fl
 * JD-Core Version:    0.7.0.1
 */