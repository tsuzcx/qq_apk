package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

final class MMChattingListView$1
  extends ListView
{
  MMChattingListView$1(MMChattingListView paramMMChattingListView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onDrawForeground(Canvas paramCanvas)
  {
    super.onDrawForeground(paramCanvas);
    if (!MMChattingListView.a(this.vAx).isEmpty())
    {
      Rect localRect1 = new Rect();
      MMChattingListView.b(this.vAx).getLocalVisibleRect(localRect1);
      Rect localRect2 = new Rect(localRect1);
      Rect localRect3 = new Rect(localRect1);
      localRect2.bottom = MMChattingListView.a(this.vAx).top;
      localRect3.top = MMChattingListView.a(this.vAx).bottom;
      paramCanvas.drawRect(localRect2, MMChattingListView.c(this.vAx));
      paramCanvas.drawRect(localRect3, MMChattingListView.c(this.vAx));
      y.d("MicroMsg.MMChattingListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s", new Object[] { localRect1, MMChattingListView.a(this.vAx) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView.1
 * JD-Core Version:    0.7.0.1
 */