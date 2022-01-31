package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.pb.common.c.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  List<g.a> dhm = new LinkedList();
  Handler handler = new Handler(Looper.getMainLooper());
  
  public final void a(int paramInt, MultiTalkGroup paramMultiTalkGroup)
  {
    paramMultiTalkGroup = new g.21(this, paramInt, paramMultiTalkGroup);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMultiTalkGroup.run();
      return;
    }
    this.handler.post(paramMultiTalkGroup);
  }
  
  public final void dY(String paramString, int paramInt)
  {
    h.ak(new g.13(this, paramString, paramInt));
  }
  
  public final void eD(List<MultiTalkGroup> paramList)
  {
    paramList = new g.19(this, paramList);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramList.run();
      return;
    }
    this.handler.post(paramList);
  }
  
  public final void g(MultiTalkGroup paramMultiTalkGroup)
  {
    paramMultiTalkGroup = new g.5(this, paramMultiTalkGroup);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMultiTalkGroup.run();
      return;
    }
    this.handler.post(paramMultiTalkGroup);
  }
  
  public final void i(int paramInt, Object paramObject)
  {
    paramObject = new g.4(this, paramInt, paramObject);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramObject.run();
      return;
    }
    this.handler.post(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */