package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  public volatile Map<String, a> tPX;
  
  public m()
  {
    AppMethodBeat.i(114604);
    this.tPX = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(114604);
  }
  
  public final boolean a(MultiTalkVideoView paramMultiTalkVideoView, boolean paramBoolean)
  {
    AppMethodBeat.i(114606);
    a locala;
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if (this.tPX.containsKey(paramMultiTalkVideoView.getUsername()))
    {
      locala = (a)this.tPX.get(paramMultiTalkVideoView.getUsername());
      if (locala.ivJ == null) {
        break label183;
      }
      if (paramBoolean)
      {
        localBitmap2 = a.b.exg().a(paramMultiTalkVideoView.getUsername(), paramMultiTalkVideoView.getMeasuredWidth(), paramMultiTalkVideoView.getMeasuredHeight(), 1);
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
    for (locala.ivJ = localBitmap1;; locala.ivJ = localBitmap1)
    {
      if (locala.ivJ == null) {
        break label260;
      }
      paramMultiTalkVideoView.e(locala.ivJ, 0, 0);
      AppMethodBeat.o(114606);
      return true;
      locala = new a((byte)0);
      locala.username = paramMultiTalkVideoView.getUsername();
      this.tPX.put(paramMultiTalkVideoView.getUsername(), locala);
      break;
      label183:
      localBitmap2 = a.b.exg().a(paramMultiTalkVideoView.getUsername(), paramMultiTalkVideoView.getMeasuredWidth(), paramMultiTalkVideoView.getMeasuredHeight(), 1);
      localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (localBitmap2.getHeight() < localBitmap2.getWidth()) {
          localBitmap1 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getHeight(), localBitmap2.getHeight());
        }
      }
    }
    label260:
    if (locala.tPY == null) {
      locala.tPY = a.decodeResource(aj.getContext().getResources(), 2131690013);
    }
    paramMultiTalkVideoView.e(locala.tPY, 0, 0);
    AppMethodBeat.o(114606);
    return true;
  }
  
  public final boolean a(MultiTalkVideoView paramMultiTalkVideoView, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114605);
        if (paramArrayOfInt == null)
        {
          ad.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
          AppMethodBeat.o(114605);
          return bool;
        }
        if (paramArrayOfInt.length < paramInt1 * paramInt2)
        {
          ad.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", new Object[] { Integer.valueOf(paramArrayOfInt.length), Integer.valueOf(paramInt1 * paramInt2) });
          AppMethodBeat.o(114605);
          continue;
        }
        if (paramInt1 == paramInt2) {
          break;
        }
      }
      finally {}
      ad.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
      AppMethodBeat.o(114605);
    }
    a locala = (a)this.tPX.get(paramMultiTalkVideoView.getUsername());
    if (locala == null)
    {
      locala = new a((byte)0);
      this.tPX.put(paramMultiTalkVideoView.getUsername(), locala);
    }
    for (;;)
    {
      locala.mirror = 0;
      locala.angle = paramInt3;
      if ((locala.tPZ == null) || (locala.tPZ.getWidth() != paramInt2)) {
        locala.tPZ = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
      }
      locala.tPZ.setPixels(paramArrayOfInt, 0, paramInt2, 0, 0, paramInt2, paramInt2);
      paramMultiTalkVideoView.e(locala.tPZ, locala.angle, locala.mirror);
      AppMethodBeat.o(114605);
      bool = true;
      break;
    }
  }
  
  public final void cSH()
  {
    AppMethodBeat.i(114607);
    this.tPX.clear();
    AppMethodBeat.o(114607);
  }
  
  public final class a
  {
    public int angle;
    Bitmap ivJ;
    public int mirror;
    Bitmap tPY;
    public Bitmap tPZ;
    String username;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m
 * JD-Core Version:    0.7.0.1
 */