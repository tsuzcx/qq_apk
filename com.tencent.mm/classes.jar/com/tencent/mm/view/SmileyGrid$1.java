package com.tencent.mm.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.view.a.f;
import com.tencent.mm.view.f.a;

final class SmileyGrid$1
  implements AdapterView.OnItemClickListener
{
  SmileyGrid$1(SmileyGrid paramSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(62898);
    switch (SmileyGrid.a(this.AQO))
    {
    }
    label190:
    label345:
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(62898);
        return;
        if ((SmileyGrid.a(this.AQO) == 25) && (paramInt == 0) && (this.AQO.jpR == 0) && (a.RS(SmileyGrid.b(this.AQO))))
        {
          SmileyGrid.c(this.AQO);
          AppMethodBeat.o(62898);
          return;
        }
        paramAdapterView = (EmojiInfo)this.AQO.xw.getItem(paramInt);
        if (paramAdapterView != null)
        {
          SmileyGrid.a(this.AQO, paramAdapterView);
          if (SmileyGrid.a(this.AQO) != 25) {
            break label190;
          }
        }
        for (;;)
        {
          com.tencent.mm.emoji.c.c.Pb().a(bool1, paramInt, paramAdapterView.field_md5, paramAdapterView.field_groupId, paramAdapterView.field_designerID, paramAdapterView.field_activityid);
          AppMethodBeat.o(62898);
          return;
          bool1 = false;
        }
        if ((paramInt != 0) || (this.AQO.jpR != 0) || (!a.RR(SmileyGrid.b(this.AQO)))) {
          break;
        }
      } while (!((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OR());
      com.tencent.mm.plugin.emojicapture.api.c.h(this.AQO.getContext(), null, a.RQ(SmileyGrid.b(this.AQO)));
      AppMethodBeat.o(62898);
      return;
      paramAdapterView = (EmojiInfo)this.AQO.xw.getItem(paramInt);
      if (paramAdapterView != null) {
        if (SmileyGrid.a(this.AQO) != 25) {
          break label345;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.emoji.c.c.Pb().a(bool1, paramInt, paramAdapterView.field_md5, "", paramAdapterView.field_designerID, paramAdapterView.field_activityid);
        SmileyGrid.b(this.AQO, paramAdapterView);
        AppMethodBeat.o(62898);
        return;
      }
      if (((paramAdapterView.getAdapter() instanceof f)) && (((f)paramAdapterView.getAdapter()).RJ(paramInt)))
      {
        if (SmileyGrid.d(this.AQO) != null) {
          SmileyGrid.d(this.AQO).aRo();
        }
        AppMethodBeat.o(62898);
        return;
      }
      if (paramInt == this.AQO.xw.getCount() - 1)
      {
        if (SmileyGrid.d(this.AQO) != null) {
          SmileyGrid.d(this.AQO).aRo();
        }
        AppMethodBeat.o(62898);
        return;
      }
      if (this.AQO.jpR * (this.AQO.AQJ - 1) + paramInt >= SmileyGrid.e(this.AQO))
      {
        AppMethodBeat.o(62898);
        return;
      }
      i = this.AQO.jpR * (this.AQO.AQJ - 1) + paramInt;
      paramAdapterView = com.tencent.mm.cd.e.dve().qC(i);
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().cb(paramAdapterView, i);
    } while (SmileyGrid.d(this.AQO) == null);
    if (SmileyGrid.f(this.AQO)) {}
    for (paramAdapterView = com.tencent.mm.cd.e.dve().qB(i);; paramAdapterView = com.tencent.mm.cd.e.dve().getText(i))
    {
      SmileyGrid.d(this.AQO).append(paramAdapterView);
      b.Pa().a(paramAdapterView.replaceAll(",", " "), false, paramInt);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid.1
 * JD-Core Version:    0.7.0.1
 */