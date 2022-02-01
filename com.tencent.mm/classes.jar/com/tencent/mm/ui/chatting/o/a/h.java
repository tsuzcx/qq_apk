package com.tencent.mm.ui.chatting.o.a;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.tools.r;
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
import com.tencent.mm.ui.chatting.o.f;
import com.tencent.mm.ui.chatting.o.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class h
  extends a
{
  private int Xar;
  private String talker;
  
  public h(com.tencent.mm.ui.chatting.e.a parama, d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(281509);
    this.Xar = 0;
    this.talker = hmp().WQv.getStringExtra("key_notify_message_real_username");
    Log.i("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[ChattingSingleNotifyMsgPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(281509);
  }
  
  private int hTB()
  {
    AppMethodBeat.i(281512);
    int i = ((aa)hmp().bC(aa.class)).hPV();
    AppMethodBeat.o(281512);
    return i;
  }
  
  protected final g a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(281510);
    bh.beI();
    paramBundle = com.tencent.mm.model.c.getNotifyMessageRecordStorage();
    paramd = this.talker;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(paramd)).append("'");
    paramBundle = paramBundle.nHd.rawQuery(localStringBuilder.toString(), null);
    if (paramBundle.moveToLast()) {}
    for (int i = paramBundle.getInt(0);; i = 0)
    {
      paramBundle.close();
      switch (2.WZK[parama.ordinal()])
      {
      default: 
        parama = null;
      }
      for (;;)
      {
        this.Xar = i;
        AppMethodBeat.o(281510);
        return parama;
        parama = new f(this.talker, 16, i);
        continue;
        parama = new f(this.talker, hTy() + 48, i);
        continue;
        int j = this.Xar;
        parama = this.talker;
        int k = hTy();
        parama = new f(parama, Math.max(i - j, 0) + k, i);
      }
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    AppMethodBeat.i(281511);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.WYy;
    final int j = paramd.selection;
    final Bundle localBundle = paramd.WYx;
    switch (2.WZK[locala.ordinal()])
    {
    case 3: 
    default: 
    case 2: 
      do
      {
        AppMethodBeat.o(281511);
        return;
        paramMMChattingListView.FP(false);
        i = paramMMChattingListView.getCurCount();
        j = paramMMChattingListView.getPreCount();
        r.a(paramMMChattingListView.getListView(), i - j + 1, hTB() + paramMMChattingListView.getTopHeight(), false);
        i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      } while (i <= 0);
      ((k)hmp().bC(k.class)).avv(i);
      AppMethodBeat.o(281511);
      return;
    case 5: 
      paramMMChattingListView.FQ(false);
      r.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - hTB() - paramMMChattingListView.getBottomHeight(), false);
      AppMethodBeat.o(281511);
      return;
    case 1: 
      hmp().Gi(false);
      AppMethodBeat.o(281511);
      return;
    }
    if (localBundle == null) {}
    for (int i = -1;; i = localBundle.getInt("MSG_POSITION", -1))
    {
      if (i != -1)
      {
        j = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.jlf - i));
        paramd.selection = j;
      }
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(287776);
          Object localObject = (k)h.this.hmp().bC(k.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            h.this.hmp().WQy = j;
            h.this.awC(j);
            AppMethodBeat.o(287776);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((k)localObject).avu(j);
            localObject = h.this.hmp();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(j, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(287776);
        }
      });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.a.h
 * JD-Core Version:    0.7.0.1
 */