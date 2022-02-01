package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.b.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.c;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;
import org.xwalk.core.Log;

public abstract class a
  implements b.a
{
  long JWC;
  long JWD;
  public d JWP;
  int JWQ;
  int JWR;
  long JWS;
  long JWT;
  int JWU = 3;
  protected com.tencent.mm.ui.chatting.e.a cWM;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, d paramd)
  {
    this.cWM = parama;
    this.JWP = paramd;
  }
  
  protected abstract e a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(final d.a parama, boolean paramBoolean, final Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.cWM.getTalkerUserName());
    if (bt.isNullOrNil(this.cWM.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    f.Oj(13);
    ((k)this.cWM.bh(k.class)).fCp();
    this.JWP.a(parama, paramBoolean, new d.c()
    {
      public final e b(d.d<bu> paramAnonymousd)
      {
        AppMethodBeat.i(36654);
        paramAnonymousd.JVk = paramBundle;
        paramAnonymousd = a.this.a(parama, paramBundle, paramAnonymousd);
        AppMethodBeat.o(36654);
        return paramAnonymousd;
      }
      
      public final void c(d.d<bu> paramAnonymousd)
      {
        AppMethodBeat.i(36655);
        a.this.JWQ = paramAnonymousd.fTM;
        a.this.JWR = paramAnonymousd.JVn;
        if (paramAnonymousd.JVm.size() > 0)
        {
          bu localbu = (bu)paramAnonymousd.JVm.get(0);
          if (localbu != null)
          {
            a.this.JWC = localbu.field_createTime;
            a.this.JWT = localbu.field_msgSeq;
          }
          paramAnonymousd = (bu)paramAnonymousd.JVm.get(paramAnonymousd.JVm.size() - 1);
          if (paramAnonymousd != null)
          {
            a.this.JWD = paramAnonymousd.field_createTime;
            a.this.JWS = paramAnonymousd.field_msgSeq;
          }
        }
        AppMethodBeat.o(36655);
      }
    });
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<bu> paramd)
  {
    f.Ok(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((k)this.cWM.bh(k.class)).fCq();
    if (paramd.JVl == d.a.JVf) {
      this.cWM.JOR.dCa();
    }
  }
  
  protected final void aee(final int paramInt)
  {
    this.JWU = 3;
    if (!this.cWM.JOV) {
      this.cWM.acU(paramInt);
    }
    for (;;)
    {
      this.cWM.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36656);
          if ((a.this.fep().getFirstVisiblePosition() > paramInt) || (paramInt > a.this.fep().getLastVisiblePosition()))
          {
            Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt + " reTryCount:" + a.this.JWU);
            if (!a.this.cWM.JOV) {
              a.this.fep().jR(paramInt, 0);
            }
            for (;;)
            {
              a locala = a.this;
              locala.JWU -= 1;
              if (a.this.JWU < 0) {
                break;
              }
              a.this.fep().getListView().postDelayed(this, 20L);
              AppMethodBeat.o(36656);
              return;
              a.this.fep().jR(paramInt, com.tencent.mm.cc.a.fromDPToPix(a.this.cWM.JOR.getContext(), 80));
            }
          }
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + paramInt);
          AppMethodBeat.o(36656);
        }
      }, 200L);
      return;
      com.tencent.mm.ui.chatting.e.a locala = this.cWM;
      locala.jR(paramInt, com.tencent.mm.cc.a.fromDPToPix(locala.JOR.getContext(), 80));
    }
  }
  
  public final com.tencent.mm.ui.chatting.e.a fep()
  {
    return this.cWM;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.a
 * JD-Core Version:    0.7.0.1
 */