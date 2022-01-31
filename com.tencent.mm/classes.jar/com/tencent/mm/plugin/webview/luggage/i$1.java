package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.webview.modeltools.h.c;

final class i$1
  implements h.c
{
  i$1(i parami) {}
  
  public final void uL(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 1);
    localBundle.putString("img_path", paramString);
    f.a("com.tencent.mm", localBundle, i.c.class, new i.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.1
 * JD-Core Version:    0.7.0.1
 */