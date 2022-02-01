package com.tencent.mm.plugin.sns.ui.item.a.a;

import android.app.Activity;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.listener.c;

public abstract interface d
{
  public abstract void a(int paramInt, SnsInfo paramSnsInfo, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void a(Activity paramActivity, l paraml, c paramc, a.b paramb, a parama);
  
  public abstract void hqY();
  
  public abstract void hqZ();
  
  public abstract void onUIDestroy();
  
  public abstract void onVideoPause();
  
  public abstract void vA(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.d
 * JD-Core Version:    0.7.0.1
 */