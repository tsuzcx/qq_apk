package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.btd;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  public ConcurrentHashMap<String, CharSequence> omT = new ConcurrentHashMap();
  
  public final void a(btd parambtd, CharSequence paramCharSequence)
  {
    this.omT.put(parambtd.tJu + "-" + parambtd.tJx + "-" + parambtd.kVs, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.d
 * JD-Core Version:    0.7.0.1
 */