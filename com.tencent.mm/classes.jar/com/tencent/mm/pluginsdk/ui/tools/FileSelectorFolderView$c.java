package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class FileSelectorFolderView$c
{
  TextView titleTv;
  
  FileSelectorFolderView$c(View paramView)
  {
    AppMethodBeat.i(31953);
    this.titleTv = ((TextView)paramView.findViewById(R.h.item_title));
    AppMethodBeat.o(31953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.c
 * JD-Core Version:    0.7.0.1
 */