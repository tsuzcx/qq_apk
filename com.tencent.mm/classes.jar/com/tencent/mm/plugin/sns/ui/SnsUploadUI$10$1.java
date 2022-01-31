package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

final class SnsUploadUI$10$1
  implements View.OnDragListener
{
  SnsUploadUI$10$1(SnsUploadUI.10 param10) {}
  
  public final boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    int i = paramDragEvent.getAction();
    boolean bool;
    switch (i)
    {
    default: 
      y.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
      bool = false;
    }
    for (;;)
    {
      return bool;
      y.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
      bool = true;
      continue;
      y.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
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
            y.e("MicroMsg.SnsUploadUI", "item == null");
          }
          for (;;)
          {
            i += 1;
            break;
            if (((ClipData.Item)localObject).getIntent() != null)
            {
              this.pjs.pjp.startActivity(((ClipData.Item)localObject).getIntent());
            }
            else if (((ClipData.Item)localObject).getUri() != null)
            {
              localObject = new m(this.pjs.pjp.mController.uMN, ((ClipData.Item)localObject).getUri());
              if ((((m)localObject).fileType != 0) && (((m)localObject).filePath != null)) {}
              switch (((m)localObject).fileType)
              {
              default: 
                break;
              case 3: 
                paramDragEvent.add(((m)localObject).filePath);
                continue;
                y.e("MicroMsg.SnsUploadUI", "get file path failed");
              }
            }
          }
        }
        if (paramDragEvent.size() < 0)
        {
          y.e("MicroMsg.SnsUploadUI", "no image file available");
          return true;
        }
        ((ag)SnsUploadUI.d(this.pjs.pjp)).d(paramDragEvent, 0, false);
        bool = true;
      }
      else
      {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.10.1
 * JD-Core Version:    0.7.0.1
 */