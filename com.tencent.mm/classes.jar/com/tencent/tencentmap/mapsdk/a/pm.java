package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class pm
  implements JNICallback.e, iq
{
  py a = null;
  private WeakReference<ma> b;
  private ah.f c = null;
  private Handler d = new Handler();
  private boolean e = false;
  
  public pm(ma paramma)
  {
    this.b = new WeakReference(paramma);
    if ((paramma != null) && (paramma.getMap() != null))
    {
      paramma = paramma.getMap();
      paramma.a(this);
      paramma.a(this);
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    if ((this.b == null) || (this.b.get() == null) || (((ma)this.b.get()).getMap() == null)) {}
    label212:
    label244:
    do
    {
      do
      {
        for (;;)
        {
          return;
          Object localObject = ((ma)this.b.get()).getMap();
          int i = ((f)localObject).c();
          if ((paramString1 == null) || (paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramInt < 0) || (i < 16)) {
            break label244;
          }
          if ((this.c != null) && (!this.e))
          {
            this.e = true;
            this.c.a();
          }
          ((f)localObject).f(22);
          if (this.c != null)
          {
            localObject = new ArrayList();
            int j = paramArrayOfString.length;
            i = 0;
            while (i < j)
            {
              ((List)localObject).add(new qa(paramArrayOfString[i]));
              i += 1;
            }
          }
          try
          {
            if ((this.a != null) && (this.a.a().equals(paramString1)))
            {
              i = this.a.d();
              if (i == paramInt) {
                continue;
              }
            }
          }
          catch (Exception paramArrayOfString)
          {
            break label212;
          }
        }
        this.a = new py(paramString1, paramString2, (List)localObject, paramInt);
        this.c.a(this.a);
        return;
        b();
      } while (!this.e);
      this.e = false;
      this.a = null;
    } while (this.c == null);
    this.c.d();
  }
  
  private void b()
  {
    if ((this.b == null) || (this.b.get() == null) || (((ma)this.b.get()).getMap() == null) || (this.e)) {}
    f localf;
    int i;
    do
    {
      return;
      localf = ((ma)this.b.get()).getMap();
      i = Math.min(19, localf.c());
    } while (localf.j() >= i);
    localf.f(i);
  }
  
  public void B()
  {
    if ((this.b == null) || (this.b.get() == null) || (((ma)this.b.get()).getMap() == null)) {}
    kc localkc;
    do
    {
      return;
      localkc = ((ma)this.b.get()).getMap().A();
    } while (localkc == null);
    String str1 = localkc.a;
    String str2 = localkc.b;
    String[] arrayOfString = localkc.d;
    int i = localkc.c;
    this.d.post(new pm.1(this, str1, str2, arrayOfString, i));
  }
  
  public void a(ah.f paramf)
  {
    this.c = paramf;
  }
  
  public void a(jo.c paramc)
  {
    if ((this.b == null) || (this.b.get() == null) || (((ma)this.b.get()).getMap() == null) || (((ma)this.b.get()).getIndoorFloorControlManager() == null)) {
      return;
    }
    b();
    paramc = (ma)this.b.get();
    if ((paramc.getMap().h() >= 18) && (this.e))
    {
      paramc.getIndoorFloorControlManager().b(true);
      return;
    }
    paramc.getIndoorFloorControlManager().b(false);
  }
  
  public boolean a()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.pm
 * JD-Core Version:    0.7.0.1
 */