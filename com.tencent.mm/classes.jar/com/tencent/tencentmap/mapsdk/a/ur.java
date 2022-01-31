package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.concurrent.Callable;

public final class ur
  implements Callable<Bitmap>
{
  private ur.a a;
  private Bitmap b = null;
  private uf c;
  private boolean d = false;
  private uh e = null;
  
  public ur(ur.a parama, uf paramuf)
  {
    this.a = parama;
    this.c = paramuf;
  }
  
  private Bitmap d()
  {
    if (this.a != null) {
      this.a.b(this);
    }
    try
    {
      this.b = f();
      Bitmap localBitmap = this.b;
      return localBitmap;
    }
    finally
    {
      e();
    }
  }
  
  private void e()
  {
    if (this.a != null) {
      this.a.a(this);
    }
    this.a = null;
    if ((this.b != null) && (!this.b.isRecycled())) {
      this.b.recycle();
    }
    this.b = null;
  }
  
  private Bitmap f()
  {
    int i = 0;
    Object localObject2 = null;
    if (i < 4) {
      localObject5 = localObject2;
    }
    label436:
    do
    {
      do
      {
        for (;;)
        {
          Object localObject1;
          for (;;)
          {
            Object localObject6;
            int j;
            try
            {
              localObject6 = this.c;
              localObject5 = localObject2;
              boolean bool = this.d;
              localObject5 = localObject2;
              if (this.e != null)
              {
                localObject5 = localObject2;
                localObject1 = this.e.a();
                localObject5 = localObject2;
                localObject6 = ((uf)localObject6).a(bool, (String)localObject1);
                localObject1 = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                localObject5 = localObject2;
                if ((localObject6.length != 1) || (localObject6[0] != -1)) {
                  continue;
                }
                localObject5 = localObject2;
                if (!this.d) {
                  continue;
                }
                localObject5 = localObject2;
                ug.a().a(this.c, null, true);
                localObject5 = localObject2;
                if (this.e != null)
                {
                  localObject5 = localObject2;
                  if (this.e.b() != null)
                  {
                    localObject5 = localObject2;
                    tn.e += 1;
                    localObject5 = localObject2;
                    tn.a += 1;
                    localObject5 = localObject2;
                    localObject1 = this.e.b();
                    localObject5 = localObject1;
                    return localObject5;
                  }
                }
              }
              else
              {
                localObject1 = null;
                continue;
              }
              return null;
            }
            catch (Exception localException1) {}
            try
            {
              localObject1 = BitmapFactory.decodeByteArray((byte[])localObject6, 0, localObject6.length);
              if (localObject1 == null) {}
            }
            catch (Exception localException5)
            {
              Exception localException2 = localException4;
              Object localObject4 = localException5;
              continue;
              continue;
            }
            try
            {
              for (;;)
              {
                if (this.d)
                {
                  tn.f += 1;
                  tn.c += 1;
                }
                j = localObject6.length;
                if (j >= 2097152) {
                  break label436;
                }
                try
                {
                  localObject2 = new uh((byte[])localObject6, this.c.l());
                  ug.a().a((uh)localObject2, this.c);
                  localObject5 = localObject1;
                  if (localObject1 != null) {
                    break;
                  }
                  if (i != 0) {
                    break label539;
                  }
                  localObject5 = localObject1;
                  Thread.sleep(300L);
                  localObject5 = localObject1;
                  new StringBuilder().append(this.c.l()).append(",重试次数：2");
                  localObject2 = localObject1;
                  i += 1;
                }
                catch (Throwable localThrowable)
                {
                  if (vb.n() == null) {
                    break label748;
                  }
                }
              }
              vb.n().a("TileNetFetcher downLoad function occured exception when call CacheManager Put,the downloaded data length-" + localObject6.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d() + "exceptionInfo:" + localThrowable.toString());
              break label748;
              if (vb.n() != null) {
                vb.n().a("TileNetFetcher downLoad function,the downloaded data length-" + localObject6.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d());
              }
              continue;
              try
              {
                new StringBuilder("decoder bitmap error:").append(localException3.getMessage());
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  Object localObject3;
                  localObject5 = localException1;
                  localException2 = localException4;
                }
              }
            }
            catch (Exception localException3) {}
          }
          if (i == 1)
          {
            localObject5 = localObject1;
            Thread.sleep(500L);
            localObject5 = localObject1;
            new StringBuilder().append(this.c.l()).append(",重试次数3");
            localObject3 = localObject1;
            continue;
            new StringBuilder("Error occured:").append(localException1.getMessage());
            localObject3 = localObject5;
          }
          else
          {
            localObject3 = localException1;
            if (i == 2)
            {
              localObject5 = localException1;
              Thread.sleep(700L);
              localObject5 = localException1;
              new StringBuilder().append(this.c.l()).append(",重试次数4");
              localObject3 = localException1;
            }
          }
        }
        localObject5 = localObject3;
      } while (this.c.e().getClass() != uo.class);
      localObject5 = localObject3;
    } while (localObject3 != null);
    label539:
    new StringBuilder().append(this.c.l()).append(",重试4次，仍然失败");
    return localObject3;
  }
  
  public final Bitmap a()
  {
    return this.b;
  }
  
  public final void a(uh paramuh)
  {
    this.e = paramuh;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final String b()
  {
    if (this.c != null) {
      return this.c.toString();
    }
    return "";
  }
  
  public final void c()
  {
    if (this.b != null) {
      this.b.recycle();
    }
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ur
 * JD-Core Version:    0.7.0.1
 */