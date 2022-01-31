package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NotInterestMenu$1
  implements AdapterView.OnItemClickListener
{
  NotInterestMenu$1(NotInterestMenu paramNotInterestMenu) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35663);
    if (NotInterestMenu.a(this.qXN) != null) {
      NotInterestMenu.a(this.qXN).cnz();
    }
    if (NotInterestMenu.b(this.qXN) != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35663);
      return;
      NotInterestMenu.b(this.qXN).c(NotInterestMenu.c(this.qXN));
      AppMethodBeat.o(35663);
      return;
      NotInterestMenu.b(this.qXN).d(NotInterestMenu.c(this.qXN));
      AppMethodBeat.o(35663);
      return;
      NotInterestMenu.b(this.qXN).e(NotInterestMenu.c(this.qXN));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu.1
 * JD-Core Version:    0.7.0.1
 */