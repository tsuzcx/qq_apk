package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.e;

final class VoipVideoFragment$2
  implements View.OnClickListener
{
  VoipVideoFragment$2(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4871);
    paramView = this.tEo;
    if (!VoipVideoFragment.i(this.tEo)) {}
    for (boolean bool = true;; bool = false)
    {
      VoipVideoFragment.a(paramView, bool);
      if (!VoipVideoFragment.i(this.tEo)) {
        VoipVideoFragment.j(this.tEo).setVisibility(8);
      }
      Toast.makeText(this.tEo.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(VoipVideoFragment.i(this.tEo)) }), 0).show();
      AppMethodBeat.o(4871);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */