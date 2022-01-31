package com.tencent.mm.plugin.voip_cs.b.a;

import android.os.Message;
import android.widget.ImageView;
import com.tencent.mm.plugin.voip_cs.a.a;
import com.tencent.mm.sdk.platformtools.ah;

final class b$4
  extends ah
{
  b$4(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (this.qeI.qeH != null)
    {
      b.g(this.qeI).setImageDrawable(this.qeI.qeH);
      return;
    }
    b.g(this.qeI).setImageResource(a.a.default_avatar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.4
 * JD-Core Version:    0.7.0.1
 */