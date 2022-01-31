package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.c.a;

final class b$2
  implements View.OnLongClickListener
{
  b$2(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(40242);
    String str = (String)paramView.getTag();
    ab.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(40242);
      return true;
    }
    if (str.equals(ag.coK()))
    {
      AppMethodBeat.o(40242);
      return true;
    }
    Object localObject;
    n localn;
    if ((((MaskImageButton)paramView).eQq != null) && ((((MaskImageButton)paramView).eQq instanceof String)))
    {
      localObject = (String)((MaskImageButton)paramView).eQq;
      new Intent();
      localn = ag.cpf().abv((String)localObject);
      if ((localn == null) || (!localn.Ex(32))) {
        break label243;
      }
    }
    label243:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        AppMethodBeat.o(40242);
        return false;
        localObject = "";
        break;
      }
      a locala = new a(this.skd.activity, paramView);
      locala.AIG = new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(40240);
          paramAnonymousContextMenu.add(0, 0, 0, b.2.this.skd.activity.getString(2131298685));
          paramAnonymousContextMenu.add(1, 1, 0, b.2.this.skd.activity.getString(2131304005));
          AppMethodBeat.o(40240);
        }
      };
      locala.sap = new b.2.2(this, localn, str, (String)localObject);
      localObject = new int[2];
      if ((paramView.getTag(2131820681) instanceof int[])) {
        localObject = (int[])paramView.getTag(2131820681);
      }
      locala.dq(localObject[0], localObject[1]);
      AppMethodBeat.o(40242);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.2
 * JD-Core Version:    0.7.0.1
 */