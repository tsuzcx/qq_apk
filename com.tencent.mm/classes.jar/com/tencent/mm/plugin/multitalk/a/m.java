package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  public volatile Map<String, m.a> muN = Collections.synchronizedMap(new HashMap());
  
  public final boolean a(MultiTalkVideoView paramMultiTalkVideoView, boolean paramBoolean)
  {
    if (paramMultiTalkVideoView == null)
    {
      y.e("MicroMsg.MT.MultiTalkViewManager", "drawAvatar view is null");
      return false;
    }
    m.a locala;
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if (this.muN.containsKey(paramMultiTalkVideoView.getUsername()))
    {
      locala = (m.a)this.muN.get(paramMultiTalkVideoView.getUsername());
      if (locala.muO == null) {
        break label186;
      }
      if (paramBoolean)
      {
        localBitmap2 = a.b.cmd().b(paramMultiTalkVideoView.getUsername(), paramMultiTalkVideoView.getMeasuredWidth(), paramMultiTalkVideoView.getMeasuredHeight(), 1);
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (localBitmap2.getHeight() < localBitmap2.getWidth()) {
            localBitmap1 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getHeight(), localBitmap2.getHeight());
          }
        }
      }
    }
    for (locala.muO = localBitmap1;; locala.muO = localBitmap1)
    {
      if (locala.muO == null) {
        break label263;
      }
      paramMultiTalkVideoView.c(locala.muO, 0, 0);
      return true;
      locala = new m.a(this, (byte)0);
      locala.username = paramMultiTalkVideoView.getUsername();
      this.muN.put(paramMultiTalkVideoView.getUsername(), locala);
      break;
      label186:
      localBitmap2 = a.b.cmd().b(paramMultiTalkVideoView.getUsername(), paramMultiTalkVideoView.getMeasuredWidth(), paramMultiTalkVideoView.getMeasuredHeight(), 1);
      localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (localBitmap2.getHeight() < localBitmap2.getWidth()) {
          localBitmap1 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getHeight(), localBitmap2.getHeight());
        }
      }
    }
    label263:
    if (locala.muP == null) {
      locala.muP = BitmapFactory.decodeResource(paramMultiTalkVideoView.getResources(), a.c.multitalk_default_avatar);
    }
    paramMultiTalkVideoView.c(locala.muP, 0, 0);
    return true;
  }
  
  public final boolean a(MultiTalkVideoView paramMultiTalkVideoView, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramMultiTalkVideoView == null) {}
    for (;;)
    {
      try
      {
        y.e("MicroMsg.MT.MultiTalkViewManager", "drawVideo view is null");
        return bool;
      }
      finally {}
      if (paramArrayOfInt == null)
      {
        y.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
      }
      else if (paramArrayOfInt.length < paramInt1 * paramInt2)
      {
        y.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", new Object[] { Integer.valueOf(paramArrayOfInt.length), Integer.valueOf(paramInt1 * paramInt2) });
      }
      else
      {
        if (paramInt1 == paramInt2) {
          break;
        }
        y.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
      }
    }
    m.a locala = (m.a)this.muN.get(paramMultiTalkVideoView.getUsername());
    if (locala == null)
    {
      locala = new m.a(this, (byte)0);
      this.muN.put(paramMultiTalkVideoView.getUsername(), locala);
    }
    for (;;)
    {
      locala.muy = 0;
      locala.angle = paramInt3;
      if ((locala.muQ == null) || (locala.muQ.getWidth() != paramInt2)) {
        locala.muQ = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
      }
      locala.muQ.setPixels(paramArrayOfInt, 0, paramInt2, 0, 0, paramInt2, paramInt2);
      paramMultiTalkVideoView.c(locala.muQ, locala.angle, locala.muy);
      bool = true;
      break;
    }
  }
  
  public final void blz()
  {
    this.muN.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.m
 * JD-Core Version:    0.7.0.1
 */