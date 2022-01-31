package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class SnsUploadUI$12$1
  implements View.OnDragListener
{
  SnsUploadUI$12$1(SnsUploadUI.12 param12) {}
  
  public final boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    AppMethodBeat.i(39748);
    int i = paramDragEvent.getAction();
    boolean bool;
    switch (i)
    {
    default: 
      ab.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(39748);
      return bool;
      ab.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
      bool = true;
      continue;
      ab.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
      paramView = paramDragEvent.getClipData();
      if (paramView != null)
      {
        int j = paramView.getItemCount();
        paramDragEvent = new ArrayList();
        i = 0;
        if (i < j)
        {
          Object localObject = paramView.getItemAt(i);
          if (localObject == null) {
            ab.e("MicroMsg.SnsUploadUI", "item == null");
          }
          for (;;)
          {
            i += 1;
            break;
            if (((ClipData.Item)localObject).getIntent() != null)
            {
              this.sbU.sbR.startActivity(((ClipData.Item)localObject).getIntent());
            }
            else if (((ClipData.Item)localObject).getUri() != null)
            {
              localObject = new o(this.sbU.sbR.getContext(), ((ClipData.Item)localObject).getUri());
              if ((((o)localObject).fileType != 0) && (((o)localObject).filePath != null)) {}
              switch (((o)localObject).fileType)
              {
              default: 
                break;
              case 3: 
                paramDragEvent.add(((o)localObject).filePath);
                continue;
                ab.e("MicroMsg.SnsUploadUI", "get file path failed");
              }
            }
          }
        }
        if (paramDragEvent.size() < 0)
        {
          ab.e("MicroMsg.SnsUploadUI", "no image file available");
          AppMethodBeat.o(39748);
          return true;
        }
        ((ag)SnsUploadUI.d(this.sbU.sbR)).d(paramDragEvent, 0, false);
        bool = true;
      }
      else
      {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.12.1
 * JD-Core Version:    0.7.0.1
 */