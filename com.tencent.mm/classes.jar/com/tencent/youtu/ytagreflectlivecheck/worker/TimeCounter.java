package com.tencent.youtu.ytagreflectlivecheck.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TimeCounter
{
  private static String TAG = "TimeCounter";
  private static HashMap<String, TimeCounter> allMap;
  private float average = 0.0F;
  private long beginTime = 0L;
  private int count = 0;
  private float last = 0.0F;
  private float max = 0.0F;
  private float min = 0.0F;
  private String name;
  private float sum = 0.0F;
  
  TimeCounter(String paramString)
  {
    this.name = paramString;
  }
  
  public static void clearIns()
  {
    AppMethodBeat.i(43420);
    allMap.clear();
    allMap = null;
    AppMethodBeat.o(43420);
  }
  
  private static long getCurrentTime()
  {
    AppMethodBeat.i(43418);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(43418);
    return l * 1000L;
  }
  
  public static TimeCounter ins(String paramString)
  {
    AppMethodBeat.i(43419);
    if (allMap == null) {
      allMap = new HashMap();
    }
    if (allMap.get(paramString) == null) {
      allMap.put(paramString, new TimeCounter(paramString));
    }
    paramString = (TimeCounter)allMap.get(paramString);
    AppMethodBeat.o(43419);
    return paramString;
  }
  
  public static String printAll()
  {
    AppMethodBeat.i(43421);
    Iterator localIterator = allMap.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + "\n" + ((TimeCounter)allMap.get(str2)).print()) {
      str2 = (String)localIterator.next();
    }
    AppMethodBeat.o(43421);
    return str1;
  }
  
  public void begin()
  {
    AppMethodBeat.i(43422);
    this.beginTime = getCurrentTime();
    AppMethodBeat.o(43422);
  }
  
  public void end()
  {
    AppMethodBeat.i(43423);
    end(true);
    AppMethodBeat.o(43423);
  }
  
  public void end(boolean paramBoolean)
  {
    AppMethodBeat.i(43424);
    float f = (float)(getCurrentTime() - this.beginTime) / 1000.0F;
    this.sum += f;
    this.count += 1;
    this.average = (this.sum / this.count);
    if (this.count == 1)
    {
      this.min = f;
      this.max = f;
    }
    for (;;)
    {
      this.last = f;
      if (paramBoolean) {
        print();
      }
      AppMethodBeat.o(43424);
      return;
      if (f < this.min) {
        this.min = f;
      }
      if (f > this.max) {
        this.max = f;
      }
    }
  }
  
  public String print()
  {
    AppMethodBeat.i(43425);
    String str = this.name + " count:" + this.count + " avg:" + this.average + "ms max:" + this.max + "ms min:" + this.min + "ms last:" + this.last + "ms";
    AppMethodBeat.o(43425);
    return str;
  }
  
  public void reset()
  {
    this.sum = 0.0F;
    this.average = 0.0F;
    this.min = 0.0F;
    this.max = 0.0F;
    this.last = 0.0F;
    this.beginTime = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.TimeCounter
 * JD-Core Version:    0.7.0.1
 */