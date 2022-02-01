package com.tencent.mm.ui.chatting.n.a;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.e;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class g
  extends a
{
  private int PFD;
  private String talker;
  
  public g(com.tencent.mm.ui.chatting.e.a parama, d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(233512);
    this.PFD = 0;
    this.talker = grq().Pwc.getStringExtra("key_notify_message_real_username");
    Log.i("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[ChattingSingleNotifyMsgPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(233512);
  }
  
  private int gTR()
  {
    AppMethodBeat.i(233515);
    int i = ((aa)grq().bh(aa.class)).gQy();
    AppMethodBeat.o(233515);
    return i;
  }
  
  protected final f a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(233513);
    bg.aVF();
    paramBundle = com.tencent.mm.model.c.getNotifyMessageRecordStorage();
    paramd = this.talker;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(paramd)).append("'");
    paramBundle = paramBundle.kOg.rawQuery(localStringBuilder.toString(), null);
    if (paramBundle.moveToLast()) {}
    for (int i = paramBundle.getInt(0);; i = 0)
    {
      paramBundle.close();
      switch (2.PEY[parama.ordinal()])
      {
      default: 
        parama = null;
      }
      for (;;)
      {
        this.PFD = i;
        AppMethodBeat.o(233513);
        return parama;
        parama = new e(this.talker, 16, i);
        continue;
        parama = new e(this.talker, this.PFx + 48, i);
        continue;
        int j = this.PFD;
        parama = this.talker;
        int k = this.PFx;
        parama = new e(parama, Math.max(i - j, 0) + k, i);
      }
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    AppMethodBeat.i(233514);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.PDL;
    final int j = paramd.selection;
    final Bundle localBundle = paramd.PDK;
    switch (2.PEY[locala.ordinal()])
    {
    case 3: 
    default: 
    case 2: 
      do
      {
        AppMethodBeat.o(233514);
        return;
        paramMMChattingListView.Bx(false);
        i = paramMMChattingListView.getCurCount();
        j = paramMMChattingListView.getPreCount();
        p.a(paramMMChattingListView.getListView(), i - j + 1, gTR() + paramMMChattingListView.getTopHeight(), false);
        i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      } while (i <= 0);
      ((k)grq().bh(k.class)).amv(i);
      AppMethodBeat.o(233514);
      return;
    case 5: 
      paramMMChattingListView.By(false);
      p.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - gTR() - paramMMChattingListView.getBottomHeight(), false);
      AppMethodBeat.o(233514);
      return;
    case 1: 
      grq().BN(false);
      AppMethodBeat.o(233514);
      return;
    }
    if (localBundle == null) {}
    for (int i = -1;; i = localBundle.getInt("MSG_POSITION", -1))
    {
      if (i != -1)
      {
        j = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.gAZ - i));
        paramd.selection = j;
      }
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233510);
          Object localObject = (k)g.this.grq().bh(k.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            g.this.grq().Pwf = j;
            g.this.any(j);
            AppMethodBeat.o(233510);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((k)localObject).amu(j);
            localObject = g.this.grq();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(j, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(233510);
        }
      });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.g
 * JD-Core Version:    0.7.0.1
 */