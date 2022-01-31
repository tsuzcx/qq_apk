package com.tencent.mm.ui.chatting.b;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.ac;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.b.b.z;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.x;

final class n$1$1
  implements View.OnDragListener
{
  n$1$1(n.1 param1) {}
  
  public final boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramDragEvent.getAction())
    {
    default: 
      y.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
      bool1 = false;
    }
    int k;
    int i;
    do
    {
      do
      {
        return bool1;
        y.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
        return true;
        y.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
        return true;
        y.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
        return true;
        y.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
        return true;
        y.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
        paramView = paramDragEvent.getClipData();
        bool1 = bool2;
      } while (paramView == null);
      k = paramView.getItemCount();
      i = 0;
      bool1 = bool2;
    } while (i >= k);
    paramDragEvent = paramView.getItemAt(i);
    if (paramDragEvent == null) {
      y.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
    }
    for (;;)
    {
      i += 1;
      break;
      if (paramDragEvent.getIntent() != null)
      {
        this.vpX.vpW.byx.vtz.startActivity(paramDragEvent.getIntent());
      }
      else if (paramDragEvent.getUri() != null)
      {
        Object localObject = new m(this.vpX.vpW.byx.vtz.getContext(), paramDragEvent.getUri());
        if ((((m)localObject).fileType != 0) && (((m)localObject).filePath != null)) {}
        switch (((m)localObject).fileType)
        {
        default: 
          ((com.tencent.mm.ui.chatting.b.b.a)this.vpX.vpW.byx.ac(com.tencent.mm.ui.chatting.b.b.a.class)).a((m)localObject);
          break;
        case 3: 
          paramDragEvent = ((m)localObject).filePath;
          bool1 = q.g(paramDragEvent, this.vpX.vpW.byx.getTalkerUserName(), true);
          localObject = (z)this.vpX.vpW.byx.ac(z.class);
          if (bool1) {}
          for (int j = 1;; j = 0)
          {
            ((z)localObject).x(j, 0, paramDragEvent);
            break;
          }
        case 4: 
          localObject = new Intent();
          ((Intent)localObject).setData(paramDragEvent.getUri());
          ((ah)this.vpX.vpW.byx.ac(ah.class)).O((Intent)localObject);
          continue;
          y.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
          break;
        }
      }
      else if ((paramDragEvent.getText() != null) && (paramDragEvent.getText().length() > 0))
      {
        ((ac)this.vpX.vpW.byx.ac(ac.class)).adw(paramDragEvent.getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.n.1.1
 * JD-Core Version:    0.7.0.1
 */