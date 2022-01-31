package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import java.util.ArrayList;

final class ChatFooter$28
  implements i.a
{
  ChatFooter$28(ChatFooter paramChatFooter, Context paramContext) {}
  
  public final void WL(String paramString)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    if (ChatFooter.e(this.sgd) != null) {
      localIntent.putExtra("GalleryUI_FromUser", ChatFooter.e(this.sgd));
    }
    if (ChatFooter.f(this.sgd) != null) {
      localIntent.putExtra("GalleryUI_ToUser", ChatFooter.f(this.sgd));
    }
    localIntent.putExtra("query_source_type", 3);
    localIntent.putExtra("preview_image", true);
    localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
    localIntent.putExtra("max_select_count", 1);
    localIntent.addFlags(67108864);
    if (ChatFooter.g(this.sgd) != null)
    {
      d.a(ChatFooter.g(this.sgd), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
      return;
    }
    d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.28
 * JD-Core Version:    0.7.0.1
 */