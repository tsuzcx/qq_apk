package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.List;

final class fs$d
  extends fs.a
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d = false;
  public List<gc.a> e;
  private int f;
  private int g;
  
  public fs$d(fs paramfs, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramfs, (byte)0);
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.f = 0;
  }
  
  public final void run()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int k = 0;
    this.a = false;
    fs.a(ey.a.a("report_max_report_count", 10, 100, 20));
    if (this.b)
    {
      int m = fs.f(this.h).size();
      if (m == 0) {}
      for (;;)
      {
        this.e = ((List)localObject1);
        if ((this.e != null) && (this.e.size() != 0)) {
          break;
        }
        fs.b(this.h, false);
        return;
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        i = 0;
        int j = 0;
        while ((i < m) && (j < fs.c()))
        {
          String str = (String)fs.f(this.h).get(i);
          ((List)localObject1).add(new gc.a(0L, str));
          ((List)localObject2).add(str);
          j += 1;
          i += 1;
        }
        i = 0;
        while (i < ((List)localObject2).size())
        {
          fs.f(this.h).remove(((List)localObject2).get(i));
          i += 1;
        }
        if (fs.f(this.h).size() == 0) {
          this.a = true;
        }
      }
    }
    int i = ey.a.a("report_clear_db_num", 1, 10000, 1000);
    if (gc.a(this.h.b()).a(i)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.e = ((List)localObject1);
      break;
      localObject1 = gc.a(this.h.b()).b(fs.c() + 1);
      if (((List)localObject1).size() <= fs.c())
      {
        this.a = true;
        fs.a(this.h, true);
      }
      else
      {
        ((List)localObject1).remove(((List)localObject1).size() - 1);
      }
    }
    localObject1 = new StringBuilder();
    i = k;
    while (i < this.e.size())
    {
      ((StringBuilder)localObject1).append(((gc.a)this.e.get(i)).b).append("\n");
      i += 1;
    }
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (this.b)
    {
      localObject1 = localObject2;
      if (((String)localObject2).contains("client_report_time")) {
        localObject1 = ((String)localObject2).replace("client_report_time", hq.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
      }
    }
    localObject1 = ((String)localObject1).getBytes();
    i = localObject1.length;
    this.g = i;
    localObject1 = ey.a.a((byte[])localObject1);
    fs.a(this.h, localObject1.length);
    fs.i(this.h).a((byte[])localObject1, i, this.b, this, fs.h(this.h), this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fs.d
 * JD-Core Version:    0.7.0.1
 */