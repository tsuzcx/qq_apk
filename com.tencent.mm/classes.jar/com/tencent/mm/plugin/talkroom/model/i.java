package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.bf.d;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  List<d> dhm = new LinkedList();
  ah handler = new ah(Looper.getMainLooper());
  
  public final void RM()
  {
    i.1 local1 = new i.1(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      return;
    }
    this.handler.post(local1);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString)
  {
    paramString = new i.9(this, paramInt1, paramInt2, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      return;
    }
    this.handler.post(paramString);
  }
  
  public final void i(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new i.5(this, paramString, paramInt1, paramInt2);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      return;
    }
    this.handler.post(paramString);
  }
  
  public final void jp(int paramInt)
  {
    i.7 local7 = new i.7(this, paramInt);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local7.run();
      return;
    }
    this.handler.post(local7);
  }
  
  public final void ny(String paramString)
  {
    paramString = new i.8(this, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      return;
    }
    this.handler.post(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i
 * JD-Core Version:    0.7.0.1
 */