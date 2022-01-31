package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class fs$c
  extends fs.a
{
  private fs.d a;
  
  public fs$c(fs paramfs, fs.d paramd)
  {
    super(paramfs, (byte)0);
    this.a = paramd;
  }
  
  public final void run()
  {
    int i = 0;
    fs.b(this.b, false);
    fs.a(this.b, SystemClock.elapsedRealtime());
    int j;
    if (this.a.d)
    {
      if (fs.j(this.b) > 0) {
        fs.b(this.b, 10);
      }
      this.b.a.addAndGet(fs.d.a(this.a));
      if (!this.a.b)
      {
        j = this.a.e.size();
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < j)
        {
          localArrayList.add(Long.valueOf(((gc.a)this.a.e.get(i)).a));
          i += 1;
        }
        gc.a(this.b.b()).a(localArrayList);
        if (fs.k(this.b))
        {
          fs.c(this.b, false);
          fs.b(this.b, true, this.a.c);
        }
      }
    }
    label368:
    label378:
    for (;;)
    {
      return;
      if (!this.a.a)
      {
        SystemClock.sleep(200L);
        fs.b(this.b, this.a.b, this.a.c);
        return;
      }
      fs.a(this.b, true);
      return;
      if (ey.h())
      {
        if (fs.j(this.b) <= 0) {
          break label368;
        }
        j = ey.a.a("report_interval_forbid_limit", 30, 1440, 60);
        if (fs.j(this.b) < j) {
          fs.c(this.b, 2);
        }
      }
      for (;;)
      {
        if ((!this.a.c) || (!this.a.b)) {
          break label378;
        }
        j = this.a.e.size();
        while (i < j)
        {
          gc.a(this.b.b()).b(((gc.a)this.a.e.get(i)).b);
          i += 1;
        }
        break;
        fs.d(this.b, 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fs.c
 * JD-Core Version:    0.7.0.1
 */