package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;

public final class s
{
  com.tencent.mm.pluginsdk.ui.e adKd;
  ListView aflX;
  k afnq;
  m afrX;
  boolean afrY;
  private MMHandler afrZ;
  private Runnable afsa;
  int afsb;
  
  public s()
  {
    AppMethodBeat.i(38706);
    this.afrY = false;
    this.afsb = -1;
    this.adKd = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(256618);
        paramAnonymousAbsListView = e.afmD;
        e.a(s.this.aflX, s.this.afnq, true, true);
        m localm;
        ConversationListView localConversationListView;
        if (s.this.afrX != null)
        {
          localm = s.this.afrX;
          localConversationListView = localm.afpp;
          if (localConversationListView != null)
          {
            paramAnonymousInt3 = localConversationListView.getChildCount();
            if (paramAnonymousInt3 <= 0) {}
          }
        }
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousInt2)
        {
          paramAnonymousInt2 = paramAnonymousInt1 + 1;
          View localView = localConversationListView.getChildAt(paramAnonymousInt1);
          if (localView == null) {
            paramAnonymousAbsListView = null;
          }
          while ((paramAnonymousAbsListView != null) && ((paramAnonymousAbsListView.getTag() instanceof k.f)))
          {
            paramAnonymousAbsListView = paramAnonymousAbsListView.getTag();
            if (paramAnonymousAbsListView == null)
            {
              paramAnonymousAbsListView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.conversation.ConversationWithCacheAdapter.ViewHolder");
              AppMethodBeat.o(256618);
              throw paramAnonymousAbsListView;
              paramAnonymousAbsListView = localView.findViewById(R.h.fDD);
            }
            else
            {
              paramAnonymousAbsListView = (k.f)paramAnonymousAbsListView;
              if ((au.bwB(paramAnonymousAbsListView.username)) && (!localm.jAy()))
              {
                if (localView.getBottom() <= localm.afpv)
                {
                  m.a(localm, 8);
                  AppMethodBeat.o(256618);
                  return;
                }
                localm.cQ(0, false);
                AppMethodBeat.o(256618);
                return;
              }
              if (!paramAnonymousAbsListView.aebg)
              {
                if (localView.getTop() <= localm.afpv)
                {
                  m.a(localm, 8);
                  AppMethodBeat.o(256618);
                }
              }
              else
              {
                if ((paramAnonymousAbsListView.adis != 0) && (localView.getBottom() >= localm.afpv))
                {
                  localm.cQ(0, false);
                  AppMethodBeat.o(256618);
                  return;
                }
                m.a(localm, 8);
              }
            }
          }
          if (paramAnonymousInt2 >= paramAnonymousInt3)
          {
            AppMethodBeat.o(256618);
            return;
          }
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(38703);
        if (paramAnonymousInt == 0)
        {
          if (s.this.aflX == null)
          {
            AppMethodBeat.o(38703);
            return;
          }
          s.a(s.this, -1);
          AppMethodBeat.o(38703);
          return;
        }
        s.this.jBb();
        AppMethodBeat.o(38703);
      }
    });
    AppMethodBeat.o(38706);
  }
  
  final void jBb()
  {
    AppMethodBeat.i(38707);
    if (!this.afrY)
    {
      Log.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.afrY = true;
    }
    if ((this.afrZ != null) && (this.afsa != null)) {
      this.afrZ.removeCallbacks(this.afsa);
    }
    if (this.afrZ != null)
    {
      this.afrZ.quit();
      this.afrZ = null;
    }
    AppMethodBeat.o(38707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.s
 * JD-Core Version:    0.7.0.1
 */