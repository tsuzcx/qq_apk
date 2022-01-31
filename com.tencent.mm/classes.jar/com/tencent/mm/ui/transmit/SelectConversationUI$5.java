package com.tencent.mm.ui.transmit;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.al;

final class SelectConversationUI$5
  implements b.i
{
  SelectConversationUI$5(SelectConversationUI paramSelectConversationUI, ImageView paramImageView, String paramString) {}
  
  public final void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(35129);
    ab.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { this.hZk });
    AppMethodBeat.o(35129);
  }
  
  public final String tX()
  {
    return "SelectConversationUI#WEISHITHUMB";
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(35128);
    if ((!this.AAp.isFinishing()) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.AAr != null))
    {
      paramBitmap = ai.d(SelectConversationUI.a(this.AAp, paramBitmap, this.AAr, paramBitmap.getWidth(), paramBitmap.getHeight()), al.fromDPToPix(this.AAp, 3));
      this.AAr.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(35128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.5
 * JD-Core Version:    0.7.0.1
 */