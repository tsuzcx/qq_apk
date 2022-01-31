package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;

final class av$7
  implements View.OnClickListener
{
  av$7(av paramav) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39409);
    if ((paramView.getParent() == null) || (!(paramView.getParent() instanceof SnsCommentCollapseLayout)))
    {
      AppMethodBeat.o(39409);
      return;
    }
    if ((((SnsCommentCollapseLayout)paramView.getParent()).getTag() == null) || (!(((SnsCommentCollapseLayout)paramView.getParent()).getTag() instanceof l)))
    {
      AppMethodBeat.o(39409);
      return;
    }
    paramView = (l)((SnsCommentCollapseLayout)paramView.getParent()).getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(39409);
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_text_show", paramView.ntu);
      localIntent.putExtra("sns_local_id", paramView.rFX);
      localIntent.putExtra("sns_comment_buf", paramView.reJ.toByteArray());
      localIntent.setClass(this.rXd.cmc, SnsSingleTextViewUI.class);
      this.rXd.cmc.startActivity(localIntent);
      AppMethodBeat.o(39409);
      return;
    }
    catch (IOException paramView)
    {
      ab.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", paramView, "commentCollapse click exception.", new Object[0]);
      AppMethodBeat.o(39409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av.7
 * JD-Core Version:    0.7.0.1
 */