package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import java.util.ArrayList;

final class ChatFooter$46
  implements i.a
{
  ChatFooter$46(ChatFooter paramChatFooter, Context paramContext) {}
  
  public final void ams(String paramString)
  {
    AppMethodBeat.i(27821);
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    if (ChatFooter.d(this.vXU) != null) {
      localIntent.putExtra("GalleryUI_FromUser", ChatFooter.d(this.vXU));
    }
    if (ChatFooter.e(this.vXU) != null) {
      localIntent.putExtra("GalleryUI_ToUser", ChatFooter.e(this.vXU));
    }
    localIntent.putExtra("query_source_type", 3);
    localIntent.putExtra("preview_image", true);
    localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
    localIntent.putExtra("max_select_count", 1);
    localIntent.addFlags(67108864);
    if (ChatFooter.f(this.vXU) != null)
    {
      d.a(ChatFooter.f(this.vXU), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
      AppMethodBeat.o(27821);
      return;
    }
    d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
    AppMethodBeat.o(27821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.46
 * JD-Core Version:    0.7.0.1
 */