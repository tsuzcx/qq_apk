package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.j.d;
import com.tencent.luggage.j.d.a;
import com.tencent.mm.plugin.webview.modeltools.a;
import java.util.Set;

final class g$1
  implements d.a
{
  g$1(g paramg, com.tencent.mm.plugin.webview.luggage.e parame, Context paramContext) {}
  
  public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.kNu.bil.ql().bjH.remove(this);
    return a.c((Activity)this.val$context, paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.g.1
 * JD-Core Version:    0.7.0.1
 */