package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class bu$13
  implements View.OnClickListener
{
  bu$13(bu parambu) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245242);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    Log.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
    if (!(paramView.getTag() instanceof TimeLineObject))
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245242);
      return;
    }
    paramView = (TimeLineObject)paramView.getTag();
    if (paramView.weappInfo == null)
    {
      Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
      a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245242);
      return;
    }
    localObject = paramView.weappInfo.username;
    xw localxw = new xw();
    Log.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(localObject)));
    localxw.fWN.userName = ((String)localObject);
    localxw.fWN.scene = 1009;
    localxw.fWN.fvd = (paramView.Id + ":" + paramView.UserName);
    EventCenter.instance.publish(localxw);
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bu.13
 * JD-Core Version:    0.7.0.1
 */