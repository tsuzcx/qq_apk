package com.tencent.shadow.a.a.a;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private int a = -1;
  private HashMap<String, Long> b = new HashMap();
  private long c = 0L;
  
  public a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init TimeMonitor id：");
    localStringBuilder.append(paramInt);
    Log.e("TimeMonitorData", localStringBuilder.toString());
    this.a = paramInt;
  }
  
  private void c()
  {
    if (this.b.size() <= 0) {
      Log.e("TimeMonitorData", "mTimeTag is empty");
    }
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("：");
      localStringBuilder.append(this.b.get(str));
      Log.e("TimeMonitorData", localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    if (this.b.size() > 0) {
      this.b.clear();
    }
    this.c = System.currentTimeMillis();
  }
  
  public void a(String paramString)
  {
    if (this.b.get(paramString) != null) {
      this.b.remove(paramString);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    this.b.put(paramString, Long.valueOf(l1 - l2));
    b();
  }
  
  public void b()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */