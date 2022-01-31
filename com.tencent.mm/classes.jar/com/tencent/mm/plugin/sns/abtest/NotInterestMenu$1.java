package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class NotInterestMenu$1
  implements AdapterView.OnItemClickListener
{
  NotInterestMenu$1(NotInterestMenu paramNotInterestMenu) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (NotInterestMenu.a(this.ojC) != null) {
      NotInterestMenu.a(this.ojC).bBY();
    }
    if (NotInterestMenu.b(this.ojC) != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      NotInterestMenu.b(this.ojC).c(NotInterestMenu.c(this.ojC));
      return;
    case 1: 
      NotInterestMenu.b(this.ojC).d(NotInterestMenu.c(this.ojC));
      return;
    }
    NotInterestMenu.b(this.ojC).e(NotInterestMenu.c(this.ojC));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu.1
 * JD-Core Version:    0.7.0.1
 */