package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.base.s;

final class c$8
  implements View.OnClickListener
{
  c$8(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ah(-1, false);
    if (!f.zF())
    {
      s.gM(this.val$context);
      return;
    }
    paramView = new Intent(this.val$context, FileExplorerUI.class);
    paramView.putExtra("key_title", this.val$context.getString(R.l.favorite_post_title_file));
    ((Activity)this.val$context).startActivityForResult(paramView, 4099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.8
 * JD-Core Version:    0.7.0.1
 */