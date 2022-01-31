package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

final class g$1
  implements MMActivity.a
{
  g$1(g paramg, a.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool;
    HashMap localHashMap;
    if (paramInt1 == (this.rdx.hashCode() & 0xFFFF))
    {
      if (paramIntent != null) {
        break label128;
      }
      bool = false;
      y.i("MicroMsg.JsApiChooseImage", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      localHashMap = new HashMap();
      if (bool) {
        localHashMap.put("memoryWarning", Boolean.valueOf(true));
      }
      switch (paramInt2)
      {
      default: 
        this.kNj.c("fail", localHashMap);
      }
    }
    for (;;)
    {
      label107:
      ((MMActivity)((com.tencent.mm.plugin.webview.luggage.e)this.kNj.big).mContext).gJb = null;
      return;
      label128:
      bool = paramIntent.getBooleanExtra("key_pick_local_media_show_memory_warning", false);
      break;
      if (paramIntent != null) {}
      for (String str = paramIntent.getStringExtra("key_pick_local_pic_callback_local_ids"); !bk.bl(str); str = null)
      {
        y.i("MicroMsg.JsApiChooseImage", "localIds = %s", new Object[] { str });
        localHashMap.put("localIds", str);
        paramIntent = paramIntent.getStringExtra("key_pick_local_pic_source_type");
        if (paramIntent != null) {
          localHashMap.put("sourceType", paramIntent);
        }
        this.kNj.c("", localHashMap);
        break label107;
      }
      this.kNj.c("cancel", localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.g.1
 * JD-Core Version:    0.7.0.1
 */