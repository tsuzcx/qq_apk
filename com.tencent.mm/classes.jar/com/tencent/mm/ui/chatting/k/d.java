package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.a.c.g;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class d
  extends b
{
  int PEu = 0;
  int gCo = -1;
  private int qpr = -1;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final RecyclerView.v N(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36490);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494178, paramViewGroup, false));
    AppMethodBeat.o(36490);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36491);
    parama = (b)parama;
    a locala = (a)amy(paramInt);
    if (Util.isNullOrNil(locala.desc)) {
      parama.jBR.setVisibility(8);
    }
    for (;;)
    {
      parama.nnL.setImageResource(locala.iconRes);
      AppMethodBeat.o(36491);
      return;
      parama.jBR.setVisibility(0);
      parama.jBR.setText(Util.nullAs(locala.desc, ""));
    }
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(36487);
    String str = this.mContext.getString(2131755290);
    AppMethodBeat.o(36487);
    return str;
  }
  
  public final void gRY()
  {
    AppMethodBeat.i(36486);
    Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.PEm.gSc();
    g.aAi();
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36479);
        LinkedList localLinkedList = new LinkedList();
        bg.aVF();
        Cursor localCursor = c.aSQ().ez(d.this.gAn, d.this.gCo);
        if (localCursor == null)
        {
          Log.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36479);
          return;
        }
        if (ab.Eq(d.this.gAn)) {
          bg.aVF();
        }
        Object localObject2;
        for (ah localah = c.aSX().Kd(d.this.gAn);; localObject2 = null)
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
                k.b localb = k.b.HD((String)localObject3);
                if (localb != null)
                {
                  if (6 == localb.type) {}
                  for (int i = 1; i != 0; i = 0)
                  {
                    localObject3 = new Date(localca.field_createTime);
                    long l2 = a.gWr().b((Date)localObject3);
                    if (l1 != l2)
                    {
                      localLinkedList.add(new c.c(localca.field_createTime));
                      localObject3 = d.this;
                      ((d)localObject3).PEu += 1;
                    }
                    String str = d.b(localca, ab.Eq(d.this.gAn));
                    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                    localObject3 = "";
                    if (localah != null) {
                      localObject3 = localah.getDisplayName(str);
                    }
                    i = e.asl(localb.iwJ);
                    localObject3 = new d.a(d.this, localca.field_createTime, localb.type, localb.title, localca.field_msgId, localas.field_username, localas.arI(), localas.field_conRemark, (String)localObject3);
                    ((d.a)localObject3).iconRes = i;
                    ((d.a)localObject3).desc = Util.getSizeKB(localb.iwI);
                    localLinkedList.add(localObject3);
                    if (localLinkedList.size() % 20 == 0)
                    {
                      if ((d.this.mDataList.size() > 0) && (((c.b)d.this.mDataList.get(d.this.mDataList.size() - 1)).getType() == 2147483646)) {
                        d.this.mDataList.remove(d.this.mDataList.size() - 1);
                      }
                      d.this.mDataList.addAll(localLinkedList);
                      d.this.mDataList.add(new c.g());
                      d.this.PEo = d.this.mDataList;
                      localLinkedList.clear();
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(36478);
                          if (d.this.PEm != null) {
                            d.this.PEm.D(d.1.this.qoy, d.this.mDataList.size());
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
            d.this.PEo = d.this.mDataList;
            localLinkedList.clear();
            Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(d.this.mDataList.size()) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233480);
                if (d.this.PEm != null) {
                  d.this.PEm.D(d.1.this.qoy, d.this.mDataList.size());
                }
                AppMethodBeat.o(233480);
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
  
  public final c.e gRZ()
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
        new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new o.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36480);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131764635));
            if ((!as.bjp(paramAnonymousb.username)) && (!ab.Iy(paramAnonymousb.username))) {
              paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(2131757361));
            }
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(2131757433));
            AppMethodBeat.o(36480);
          }
        }, new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36481);
            bg.aVF();
            ca localca = c.aSQ().Hb(paramAnonymousb.msgId);
            d.this.d(paramAnonymous2MenuItem.getItemId(), localca);
            AppMethodBeat.o(36481);
          }
        });
        AppMethodBeat.o(36483);
      }
    };
    AppMethodBeat.o(36489);
    return local2;
  }
  
  public final String gSb()
  {
    AppMethodBeat.i(36488);
    String str = this.mContext.getString(2131755290);
    AppMethodBeat.o(36488);
    return str;
  }
  
  public final int getType()
  {
    return 6;
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
    
    public final boolean bmC(String paramString)
    {
      AppMethodBeat.i(36484);
      if (paramString != null)
      {
        boolean bool = super.bmC(paramString.toLowerCase());
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
    TextView jBR;
    ImageView nnL;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36485);
      this.nnL = ((ImageView)paramView.findViewById(2131300468));
      this.jVO.setSingleLine(false);
      this.jVO.setMaxLines(2);
      this.jBR = ((TextView)paramView.findViewById(2131300454));
      AppMethodBeat.o(36485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.d
 * JD-Core Version:    0.7.0.1
 */