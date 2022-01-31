package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ba
{
  public String a;
  private boolean b;
  private boolean c;
  private int d;
  private URL e;
  private String f;
  private int g;
  
  public ba(URL paramURL, String paramString)
  {
    AppMethodBeat.i(147264);
    if (an.a.a("direct_access_use_schedule", 0, 1, 1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.b = bool1;
      bool1 = bool2;
      if (an.a.a("direct_https_use_sche", 0, 1, 1) == 1) {
        bool1 = true;
      }
      this.c = bool1;
      this.d = an.a.a("direct_access_domain_try_times", 1, 8, 2);
      this.a = "";
      this.e = paramURL;
      this.f = paramString;
      AppMethodBeat.o(147264);
      return;
    }
  }
  
  public final String a(ad paramad)
  {
    AppMethodBeat.i(147265);
    if (paramad.e())
    {
      paramad = this.f;
      AppMethodBeat.o(147265);
      return paramad;
    }
    Object localObject;
    String str;
    if (!this.e.getProtocol().startsWith("https"))
    {
      localObject = "http://" + paramad.a() + ":" + paramad.c();
      str = this.e.getFile();
      paramad = (ad)localObject;
      if (!TextUtils.isEmpty(str)) {
        if (!str.startsWith("/")) {
          break label234;
        }
      }
    }
    label234:
    for (paramad = (String)localObject + str;; paramad = (String)localObject + "/" + str)
    {
      str = this.e.getRef();
      localObject = paramad;
      if (!TextUtils.isEmpty(str)) {
        localObject = paramad + "#" + str;
      }
      AppMethodBeat.o(147265);
      return localObject;
      if (this.g != 0)
      {
        localObject = "https://" + paramad.a() + ":" + this.g;
        break;
      }
      localObject = "https://" + paramad.a() + ":443";
      break;
    }
  }
  
  public final List<ad> a(ay paramay, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 3;
    j = 0;
    AppMethodBeat.i(147266);
    localad = new ad(this.e.getHost(), -1);
    localad.a((byte)3);
    for (;;)
    {
      try
      {
        paramay = new ArrayList();
        if (paramBoolean1) {
          continue;
        }
        paramay.add(localad);
        localad.a = 1;
      }
      catch (Exception paramay)
      {
        al localal;
        paramay = new ArrayList();
        int i = j;
        if (i >= this.d) {
          continue;
        }
        paramay.add(localad);
        i += 1;
        continue;
        localad.a = 8;
        continue;
        i = 0;
        continue;
      }
      AppMethodBeat.o(147266);
      return paramay;
      if ((an.i()) || (!this.b)) {
        continue;
      }
      if ((paramBoolean2) && (!this.c))
      {
        continue;
        if (i < this.d)
        {
          paramay.add(localad);
          i += 1;
        }
        else if (an.i())
        {
          i = 2;
          localad.a = i;
        }
        else
        {
          i = k;
          if (this.b) {
            i = 4;
          }
        }
      }
      else if ((paramBoolean2) && (Build.VERSION.SDK_INT <= 18))
      {
        i = 0;
        if (i < this.d)
        {
          paramay.add(localad);
          i += 1;
        }
        else
        {
          localad.a = 10;
        }
      }
      else
      {
        localal = ay.a(this.e.getHost());
        paramay = localal.c;
        this.g = localal.d;
        this.a = localal.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ba
 * JD-Core Version:    0.7.0.1
 */