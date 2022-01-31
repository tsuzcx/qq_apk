package com.tencent.mm.ui.chatting.c;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ad;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.b;
import com.tencent.mm.ui.chatting.d.a;

final class n$1$1
  implements View.OnDragListener
{
  n$1$1(n.1 param1) {}
  
  public final boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31386);
    boolean bool1;
    switch (paramDragEvent.getAction())
    {
    default: 
      ab.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
      bool1 = false;
    }
    int k;
    int i;
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(31386);
          return bool1;
          ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
          bool1 = bool2;
          continue;
          ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
          bool1 = bool2;
          continue;
          ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
          bool1 = bool2;
          continue;
          ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
          bool1 = bool2;
        }
        ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
        paramView = paramDragEvent.getClipData();
        bool1 = bool2;
      } while (paramView == null);
      k = paramView.getItemCount();
      i = 0;
      bool1 = bool2;
    } while (i >= k);
    paramDragEvent = paramView.getItemAt(i);
    if (paramDragEvent == null) {
      ab.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
    }
    for (;;)
    {
      i += 1;
      break;
      if (paramDragEvent.getIntent() != null)
      {
        this.zFD.zFC.caz.zJz.startActivity(paramDragEvent.getIntent());
      }
      else if (paramDragEvent.getUri() != null)
      {
        Object localObject = new o(this.zFD.zFC.caz.zJz.getContext(), paramDragEvent.getUri());
        if ((((o)localObject).fileType != 0) && (((o)localObject).filePath != null)) {}
        switch (((o)localObject).fileType)
        {
        default: 
          ((b)this.zFD.zFC.caz.ay(b.class)).a((o)localObject);
          break;
        case 3: 
          paramDragEvent = ((o)localObject).filePath;
          bool1 = r.g(paramDragEvent, this.zFD.zFC.caz.getTalkerUserName(), true);
          localObject = (aa)this.zFD.zFC.caz.ay(aa.class);
          if (bool1) {}
          for (int j = 1;; j = 0)
          {
            ((aa)localObject).E(j, 0, paramDragEvent);
            break;
          }
        case 4: 
          localObject = new Intent();
          ((Intent)localObject).setData(paramDragEvent.getUri());
          ((ai)this.zFD.zFC.caz.ay(ai.class)).ah((Intent)localObject);
          continue;
          ab.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
          break;
        }
      }
      else if ((paramDragEvent.getText() != null) && (paramDragEvent.getText().length() > 0))
      {
        ((ad)this.zFD.zFC.caz.ay(ad.class)).atY(paramDragEvent.getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.n.1.1
 * JD-Core Version:    0.7.0.1
 */