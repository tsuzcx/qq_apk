package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.database.Cursor;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.a.c.g;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.gridviewheaders.a;
import com.tencent.mm.ui.tools.m;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class d
  extends b
{
  int WZh = 0;
  int jmu = -1;
  private int tOb = -1;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final RecyclerView.v V(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(289633);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.egX, paramViewGroup, false));
    AppMethodBeat.o(289633);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36491);
    parama = (b)parama;
    a locala = (a)avy(paramInt);
    if (Util.isNullOrNil(locala.desc)) {
      parama.mrM.setVisibility(8);
    }
    for (;;)
    {
      parama.qps.setImageResource(locala.iconRes);
      AppMethodBeat.o(36491);
      return;
      parama.mrM.setVisibility(0);
      parama.mrM.setText(Util.nullAs(locala.desc, ""));
    }
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(36487);
    String str = this.mContext.getString(R.l.eoi);
    AppMethodBeat.o(36487);
    return str;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void hRu()
  {
    AppMethodBeat.i(36486);
    Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.WYZ.hRy();
    h.aHH();
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36479);
        LinkedList localLinkedList = new LinkedList();
        bh.beI();
        Cursor localCursor = c.bbO().fa(d.this.jkq, d.this.jmu);
        if (localCursor == null)
        {
          Log.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36479);
          return;
        }
        if (ab.Lj(d.this.jkq)) {
          bh.beI();
        }
        Object localObject2;
        for (ah localah = c.bbV().Rw(d.this.jkq);; localObject2 = null)
        {
          long l1 = 0L;
          try
          {
            while (localCursor.moveToNext())
            {
              ca localca = new ca();
              localca.convertFrom(localCursor);
              Object localObject3 = localca.field_content;
              if (localObject3 != null)
              {
                k.b localb = k.b.OQ((String)localObject3);
                if (localb != null)
                {
                  if (6 == localb.type) {}
                  for (int i = 1; i != 0; i = 0)
                  {
                    localObject3 = new Date(localca.field_createTime);
                    long l2 = a.hWZ().b((Date)localObject3);
                    if (l1 != l2)
                    {
                      localLinkedList.add(new c.c(localca.field_createTime));
                      localObject3 = d.this;
                      ((d)localObject3).WZh += 1;
                    }
                    String str = d.b(localca, ab.Lj(d.this.jkq));
                    as localas = ((n)h.ae(n.class)).bbL().RG(str);
                    localObject3 = "";
                    if (localah != null) {
                      localObject3 = localah.PJ(str);
                    }
                    i = e.aAm(localb.llY);
                    localObject3 = new d.a(d.this, localca.field_createTime, localb.type, localb.title, localca.field_msgId, localas.field_username, localas.ayr(), localas.field_conRemark, (String)localObject3);
                    ((d.a)localObject3).iconRes = i;
                    ((d.a)localObject3).desc = Util.getSizeKB(localb.llX);
                    localLinkedList.add(localObject3);
                    if (localLinkedList.size() % 20 == 0)
                    {
                      if ((d.this.mDataList.size() > 0) && (((c.b)d.this.mDataList.get(d.this.mDataList.size() - 1)).getType() == 2147483646)) {
                        d.this.mDataList.remove(d.this.mDataList.size() - 1);
                      }
                      d.this.mDataList.addAll(localLinkedList);
                      d.this.mDataList.add(new c.g());
                      d.this.WZb = d.this.mDataList;
                      localLinkedList.clear();
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(36478);
                          if (d.this.WYZ != null) {
                            d.this.WYZ.H(d.1.this.tNh, d.this.mDataList.size());
                          }
                          AppMethodBeat.o(36478);
                        }
                      });
                    }
                    l1 = l2;
                    break;
                  }
                }
              }
            }
            localCursor.close();
            if ((d.this.mDataList.size() > 0) && (((c.b)d.this.mDataList.get(d.this.mDataList.size() - 1)).getType() == 2147483646)) {
              d.this.mDataList.remove(d.this.mDataList.size() - 1);
            }
            d.this.mDataList.addAll(localLinkedList);
            d.this.WZb = d.this.mDataList;
            localLinkedList.clear();
            Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(d.this.mDataList.size()) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(201762);
                if (d.this.WYZ != null) {
                  d.this.WYZ.H(d.1.this.tNh, d.this.mDataList.size());
                }
                AppMethodBeat.o(201762);
              }
            });
            AppMethodBeat.o(36479);
            return;
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(36479);
          }
        }
      }
    });
    AppMethodBeat.o(36486);
  }
  
  public final c.e hRv()
  {
    AppMethodBeat.i(36489);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36482);
        Log.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        d.a(d.this, paramAnonymousb);
        AppMethodBeat.o(36482);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36483);
        Log.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new m(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new q.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36480);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(R.l.retransmits));
            if ((!as.bvK(paramAnonymousb.username)) && (!ab.PQ(paramAnonymousb.username))) {
              paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(R.l.chatting_fav));
            }
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(R.l.evO));
            AppMethodBeat.o(36480);
          }
        }, new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36481);
            bh.beI();
            ca localca = c.bbO().Oq(paramAnonymousb.msgId);
            d.this.e(paramAnonymous2MenuItem.getItemId(), localca);
            AppMethodBeat.o(36481);
          }
        });
        AppMethodBeat.o(36483);
      }
    };
    AppMethodBeat.o(36489);
    return local2;
  }
  
  public final String hRx()
  {
    AppMethodBeat.i(36488);
    String str = this.mContext.getString(R.l.eoi);
    AppMethodBeat.o(36488);
    return str;
  }
  
  final class a
    extends c.b
  {
    public String desc;
    public int iconRes;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean bzd(String paramString)
    {
      AppMethodBeat.i(36484);
      if (paramString != null)
      {
        boolean bool = super.bzd(paramString.toLowerCase());
        AppMethodBeat.o(36484);
        return bool;
      }
      AppMethodBeat.o(36484);
      return false;
    }
    
    public final int getType()
    {
      return 6;
    }
  }
  
  final class b
    extends c.a
  {
    TextView mrM;
    ImageView qps;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36485);
      this.qps = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.mNb.setSingleLine(false);
      this.mNb.setMaxLines(2);
      this.mrM = ((TextView)paramView.findViewById(R.h.fav_detail));
      AppMethodBeat.o(36485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.d
 * JD-Core Version:    0.7.0.1
 */