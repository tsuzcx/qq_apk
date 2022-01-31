package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.d;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.e.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import org.xwalk.core.Log;

public abstract class a
  implements b.a
{
  com.tencent.mm.ui.chatting.c.a byx;
  public d vzL;
  int vzM;
  int vzN;
  long vzO;
  long vzP;
  int vzQ = 3;
  long vzx;
  long vzy;
  
  public a(com.tencent.mm.ui.chatting.c.a parama, d paramd)
  {
    this.byx = parama;
    this.vzL = paramd;
  }
  
  protected final void HH(int paramInt)
  {
    this.vzQ = 3;
    this.byx.GT(paramInt);
    this.byx.getListView().postDelayed(new a.2(this, paramInt), 200L);
  }
  
  protected abstract com.tencent.mm.ui.chatting.k.e a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(d.a parama, boolean paramBoolean, Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.byx.getTalkerUserName());
    if (bk.bl(this.byx.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    com.tencent.mm.plugin.report.service.g.wI(13);
    ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDp();
    this.vzL.a(parama, paramBoolean, new a.1(this, paramBundle, parama));
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    com.tencent.mm.plugin.report.service.g.wJ(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDq();
    if (paramd.vyj == d.a.vyd) {
      this.byx.vtz.btn();
    }
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a
 * JD-Core Version:    0.7.0.1
 */