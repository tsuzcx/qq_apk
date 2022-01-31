package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  public volatile Map<String, m.a> oUC;
  
  public m()
  {
    AppMethodBeat.i(54073);
    this.oUC = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(54073);
  }
  
  public final boolean a(MultiTalkVideoView paramMultiTalkVideoView, boolean paramBoolean)
  {
    AppMethodBeat.i(54075);
    m.a locala;
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if (this.oUC.containsKey(paramMultiTalkVideoView.getUsername()))
    {
      locala = (m.a)this.oUC.get(paramMultiTalkVideoView.getUsername());
      if (locala.gHT == null) {
        break label183;
      }
      if (paramBoolean)
      {
        localBitmap2 = a.b.dmT().b(paramMultiTalkVideoView.getUsername(), paramMultiTalkVideoView.getMeasuredWidth(), paramMultiTalkVideoView.getMeasuredHeight(), 1);
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
    for (locala.gHT = localBitmap1;; locala.gHT = localBitmap1)
    {
      if (locala.gHT == null) {
        break label260;
      }
      paramMultiTalkVideoView.d(locala.gHT, 0, 0);
      AppMethodBeat.o(54075);
      return true;
      locala = new m.a(this, (byte)0);
      locala.username = paramMultiTalkVideoView.getUsername();
      this.oUC.put(paramMultiTalkVideoView.getUsername(), locala);
      break;
      label183:
      localBitmap2 = a.b.dmT().b(paramMultiTalkVideoView.getUsername(), paramMultiTalkVideoView.getMeasuredWidth(), paramMultiTalkVideoView.getMeasuredHeight(), 1);
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
    if (locala.oUD == null) {
      locala.oUD = BitmapFactory.decodeResource(paramMultiTalkVideoView.getResources(), 2130839738);
    }
    paramMultiTalkVideoView.d(locala.oUD, 0, 0);
    AppMethodBeat.o(54075);
    return true;
  }
  
  public final boolean a(MultiTalkVideoView paramMultiTalkVideoView, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54074);
        if (paramArrayOfInt == null)
        {
          ab.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
          AppMethodBeat.o(54074);
          return bool;
        }
        if (paramArrayOfInt.length < paramInt1 * paramInt2)
        {
          ab.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", new Object[] { Integer.valueOf(paramArrayOfInt.length), Integer.valueOf(paramInt1 * paramInt2) });
          AppMethodBeat.o(54074);
          continue;
        }
        if (paramInt1 == paramInt2) {
          break;
        }
      }
      finally {}
      ab.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
      AppMethodBeat.o(54074);
    }
    m.a locala = (m.a)this.oUC.get(paramMultiTalkVideoView.getUsername());
    if (locala == null)
    {
      locala = new m.a(this, (byte)0);
      this.oUC.put(paramMultiTalkVideoView.getUsername(), locala);
    }
    for (;;)
    {
      locala.oUn = 0;
      locala.angle = paramInt3;
      if ((locala.oUE == null) || (locala.oUE.getWidth() != paramInt2)) {
        locala.oUE = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
      }
      locala.oUE.setPixels(paramArrayOfInt, 0, paramInt2, 0, 0, paramInt2, paramInt2);
      paramMultiTalkVideoView.d(locala.oUE, locala.angle, locala.oUn);
      AppMethodBeat.o(54074);
      bool = true;
      break;
    }
  }
  
  public final void bTz()
  {
    AppMethodBeat.i(54076);
    this.oUC.clear();
    AppMethodBeat.o(54076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m
 * JD-Core Version:    0.7.0.1
 */