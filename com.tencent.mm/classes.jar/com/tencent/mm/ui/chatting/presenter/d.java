package com.tencent.mm.ui.chatting.presenter;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.a.c.g;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.gridviewheaders.a;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class d
  extends b
{
  int aeIH = 0;
  int lPs = -1;
  private int wRr = -1;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36491);
    parama = (b)parama;
    a locala = (a)aCa(paramInt);
    if (Util.isNullOrNil(locala.desc)) {
      parama.plr.setVisibility(8);
    }
    for (;;)
    {
      parama.ttT.setImageResource(locala.iconRes);
      AppMethodBeat.o(36491);
      return;
      parama.plr.setVisibility(0);
      parama.plr.setText(Util.nullAs(locala.desc, ""));
    }
  }
  
  public final RecyclerView.v af(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254331);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gjT, paramViewGroup, false));
    AppMethodBeat.o(254331);
    return paramViewGroup;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(36487);
    String str = this.mContext.getString(R.l.grg);
    AppMethodBeat.o(36487);
    return str;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void juR()
  {
    AppMethodBeat.i(36486);
    Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.aeIz.juV();
    h.baF();
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36479);
        LinkedList localLinkedList = new LinkedList();
        bh.bCz();
        Cursor localCursor = c.bzD().fT(d.this.lMU, d.this.lPs);
        if (localCursor == null)
        {
          Log.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36479);
          return;
        }
        if (au.bwE(d.this.lMU)) {
          bh.bCz();
        }
        Object localObject2;
        for (aj localaj = c.bzK().Ju(d.this.lMU);; localObject2 = null)
        {
          long l1 = 0L;
          try
          {
            while (localCursor.moveToNext())
            {
              cc localcc = new cc();
              localcc.convertFrom(localCursor);
              Object localObject3 = localcc.field_content;
              if (localObject3 != null)
              {
                k.b localb = k.b.Hf((String)localObject3);
                if (localb != null)
                {
                  if (6 == localb.type) {}
                  for (int i = 1; i != 0; i = 0)
                  {
                    localObject3 = new Date(localcc.getCreateTime());
                    long l2 = a.jBw().b((Date)localObject3);
                    if (l1 != l2)
                    {
                      localLinkedList.add(new c.c(localcc.getCreateTime()));
                      localObject3 = d.this;
                      ((d)localObject3).aeIH += 1;
                    }
                    String str = d.b(localcc, au.bwE(d.this.lMU));
                    au localau = ((n)h.ax(n.class)).bzA().JE(str);
                    localObject3 = "";
                    if (localaj != null) {
                      localObject3 = localaj.getDisplayName(str);
                    }
                    i = e.aut(localb.nRe);
                    localObject3 = new d.a(d.this, localcc.getCreateTime(), localb.type, localb.title, localcc.field_msgId, localau.field_username, localau.aSU(), localau.field_conRemark, (String)localObject3);
                    ((d.a)localObject3).iconRes = i;
                    ((d.a)localObject3).desc = Util.getSizeKB(localb.nRd);
                    localLinkedList.add(localObject3);
                    if (localLinkedList.size() % 20 == 0)
                    {
                      if ((d.this.mDataList.size() > 0) && (((c.b)d.this.mDataList.get(d.this.mDataList.size() - 1)).getType() == 2147483646)) {
                        d.this.mDataList.remove(d.this.mDataList.size() - 1);
                      }
                      d.this.mDataList.addAll(localLinkedList);
                      d.this.mDataList.add(new c.g());
                      d.this.aeIB = d.this.mDataList;
                      localLinkedList.clear();
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(36478);
                          if (d.this.aeIz != null) {
                            d.this.aeIz.F(d.1.this.wQx, d.this.mDataList.size());
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
            d.this.aeIB = d.this.mDataList;
            localLinkedList.clear();
            Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(d.this.mDataList.size()) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(254334);
                if (d.this.aeIz != null) {
                  d.this.aeIz.F(d.1.this.wQx, d.this.mDataList.size());
                }
                AppMethodBeat.o(254334);
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
  
  public final c.e juS()
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
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new u.i
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36480);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(R.l.retransmits));
            if ((!au.bwO(paramAnonymousb.username)) && (!au.bwF(paramAnonymousb.username))) {
              paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(R.l.chatting_fav));
            }
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(R.l.gyo));
            AppMethodBeat.o(36480);
          }
        }, new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36481);
            bh.bCz();
            cc localcc = c.bzD().sl(paramAnonymousb.msgId);
            d.this.f(paramAnonymous2MenuItem.getItemId(), localcc);
            AppMethodBeat.o(36481);
          }
        });
        AppMethodBeat.o(36483);
      }
    };
    AppMethodBeat.o(36489);
    return local2;
  }
  
  public final String juU()
  {
    AppMethodBeat.i(36488);
    String str = this.mContext.getString(R.l.grg);
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
    
    public final boolean bAH(String paramString)
    {
      AppMethodBeat.i(36484);
      if (paramString != null)
      {
        boolean bool = super.bAH(paramString.toLowerCase());
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
    TextView plr;
    ImageView ttT;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36485);
      this.ttT = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.pJJ.setSingleLine(false);
      this.pJJ.setMaxLines(2);
      this.plr = ((TextView)paramView.findViewById(R.h.fav_detail));
      AppMethodBeat.o(36485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.d
 * JD-Core Version:    0.7.0.1
 */