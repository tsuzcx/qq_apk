package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.h.a.f;
import com.tencent.mm.plugin.story.model.audio.g;
import com.tencent.mm.plugin.story.model.audio.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorAudioView$h
  implements Runnable
{
  EditorAudioView$h(EditorAudioView paramEditorAudioView, String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.story.c.a parama, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(151205);
    Object localObject1 = this.sOy;
    com.tencent.mm.plugin.story.model.audio.a locala;
    int m;
    label114:
    int i;
    if (!bo.isNullOrNil(this.kjS))
    {
      locala = (com.tencent.mm.plugin.story.model.audio.a)new h(this.kjS, this.qdi, this.sOB, this.sOC.srh.ordinal());
      EditorAudioView.a((EditorAudioView)localObject1, locala);
      locala = EditorAudioView.a(this.sOy);
      if (locala != null) {
        locala.evv = ((a.f.a.b)new EditorAudioView.h.1(this));
      }
      locala = EditorAudioView.a(this.sOy);
      if (locala == null) {
        break label546;
      }
      locala.cBr();
      m = 1;
      if ((locala.fgQ > 0) && (locala.fgR > 0)) {
        break label290;
      }
      ab.i(locala.TAG, "get image data fail!");
      i = 0;
    }
    for (;;)
    {
      label142:
      if (i == 0)
      {
        localObject1 = f.sEx;
        f.cDa();
        locala.swl.clear();
        localObject1 = a.f.sGk;
        i = a.f.cED();
        localObject1 = a.f.sGk;
        localObject1 = Bitmap.createBitmap(i, a.f.cED(), Bitmap.Config.ARGB_8888);
        Object localObject2 = a.f.sGk;
        localObject1 = com.tencent.mm.sdk.platformtools.d.e((Bitmap)localObject1, a.f.cEE());
        int k = locala.swm.length;
        int j = 0;
        i = 0;
        for (;;)
        {
          if (j < k)
          {
            localObject2 = new com.tencent.mm.bv.b((byte[])localObject1);
            locala.swl.add(localObject2);
            m = ((com.tencent.mm.bv.b)localObject2).getBytes().length;
            j += 1;
            i += m;
            continue;
            locala = (com.tencent.mm.plugin.story.model.audio.a)new g(this.sOD, this.sOC.srh.ordinal());
            break;
            label290:
            localObject1 = Bitmap.createBitmap(locala.fgR, locala.fgQ, Bitmap.Config.ARGB_8888);
            locala.swl.clear();
            int n = locala.swm.length;
            j = 0;
            i = 0;
            k = 0;
            while (j < n)
            {
              localObject2 = locala.FI(i);
              new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, locala.fgR, locala.fgQ), null);
              localObject2 = a.f.sGk;
              localObject2 = new com.tencent.mm.bv.b(com.tencent.mm.sdk.platformtools.d.e((Bitmap)localObject1, a.f.cEE()));
              locala.swl.add(localObject2);
              k += ((com.tencent.mm.bv.b)localObject2).getBytes().length;
              j += 1;
              i += 1;
            }
            ab.i(locala.TAG, "imageData size:" + k + " thumbWidth:" + locala.fgR + " thumbHeight:" + locala.fgQ);
            locala.fgR /= 2;
            locala.fgQ /= 2;
            localObject1 = a.f.sGk;
            if (k > a.f.cEF()) {
              break label114;
            }
            i = m;
            break label142;
          }
        }
        ab.i(locala.TAG, "backup imageData size:".concat(String.valueOf(i)));
      }
    }
    locala.cBs();
    label546:
    EditorAudioView.a(this.sOy, this.sOC);
    AppMethodBeat.o(151205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.h
 * JD-Core Version:    0.7.0.1
 */