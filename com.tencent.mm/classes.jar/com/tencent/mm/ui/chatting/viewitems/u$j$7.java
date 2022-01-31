package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class u$j$7
  implements View.OnClickListener
{
  u$j$7(u.j paramj, int paramInt, long paramLong1, long paramLong2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33085);
    int i = u.j.a(this.zUT).zJz.getIntExtra("KOpenArticleSceneFromScene", 10000);
    paramView = paramView.findViewById(2131821438);
    Bundle localBundle = new Bundle();
    localBundle.putInt("biz_video_scene", 0);
    localBundle.putInt("biz_video_subscene", i);
    localBundle.putInt("geta8key_scene", 7);
    e.a(u.j.a(this.zUT).zJz.getContext(), this.cap, this.fEP, this.val$index, paramView, localBundle);
    AppMethodBeat.o(33085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.j.7
 * JD-Core Version:    0.7.0.1
 */