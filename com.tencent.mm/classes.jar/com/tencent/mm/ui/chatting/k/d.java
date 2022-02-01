package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class d
  extends b
{
  int Ksh = 0;
  int fXi = -1;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final RecyclerView.w D(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36490);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494003, paramViewGroup, false));
    AppMethodBeat.o(36490);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36491);
    parama = (b)parama;
    a locala = (a)adN(paramInt);
    if (bu.isNullOrNil(locala.desc)) {
      parama.iFO.setVisibility(8);
    }
    for (;;)
    {
      parama.mdt.setImageResource(locala.iconRes);
      AppMethodBeat.o(36491);
      return;
      parama.iFO.setVisibility(0);
      parama.iFO.setText(bu.bI(locala.desc, ""));
    }
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(36487);
    String str = this.mContext.getString(2131755255);
    AppMethodBeat.o(36487);
    return str;
  }
  
  public final void fJL()
  {
    AppMethodBeat.i(36486);
    ae.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.KrZ.fJP();
    g.ajS();
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36479);
        LinkedList localLinkedList = new LinkedList();
        bc.aCg();
        Cursor localCursor = c.azI().el(d.this.fVg, d.this.fXi);
        if (localCursor == null)
        {
          ae.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36479);
          return;
        }
        if (x.wb(d.this.fVg)) {
          bc.aCg();
        }
        Object localObject2;
        for (ac localac = c.azP().Bx(d.this.fVg);; localObject2 = null)
        {
          long l1 = 0L;
          try
          {
            while (localCursor.moveToNext())
            {
              bv localbv = new bv();
              localbv.convertFrom(localCursor);
              Object localObject3 = localbv.field_content;
              if (localObject3 != null)
              {
                k.b localb = k.b.zb((String)localObject3);
                if (localb != null)
                {
                  if (6 == localb.type) {}
                  for (int i = 1; i != 0; i = 0)
                  {
                    localObject3 = new Date(localbv.field_createTime);
                    long l2 = a.fNX().b((Date)localObject3);
                    if (l1 != l2)
                    {
                      localLinkedList.add(new c.c(localbv.field_createTime));
                      localObject3 = d.this;
                      ((d)localObject3).Ksh += 1;
                    }
                    String str = d.b(localbv, x.wb(d.this.fVg));
                    an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
                    localObject3 = "";
                    if (localac != null) {
                      localObject3 = localac.zP(str);
                    }
                    i = e.ahD(localb.hCD);
                    localObject3 = new d.a(d.this, localbv.field_createTime, localb.type, localb.title, localbv.field_msgId, localan.field_username, localan.adF(), localan.field_conRemark, (String)localObject3);
                    ((d.a)localObject3).iconRes = i;
                    ((d.a)localObject3).desc = bu.sL(localb.hCC);
                    localLinkedList.add(localObject3);
                    l1 = l2;
                    break;
                  }
                }
              }
            }
            localCursor.close();
            d.this.mDataList.addAll(localLinkedList);
            d.this.Ksb = d.this.mDataList;
            localLinkedList.clear();
            ae.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(d.this.mDataList.size()) });
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36478);
                if (d.this.KrZ != null) {
                  d.this.KrZ.C(d.1.this.oZA, d.this.mDataList.size());
                }
                AppMethodBeat.o(36478);
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
  
  public final c.e fJM()
  {
    AppMethodBeat.i(36489);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36482);
        ae.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        d.a(d.this, paramAnonymousb);
        AppMethodBeat.o(36482);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36483);
        ae.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36480);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            if ((!an.aUq(paramAnonymousb.username)) && (!x.zV(paramAnonymousb.username))) {
              paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(2131757157));
            }
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(2131757221));
            AppMethodBeat.o(36480);
          }
        }, new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36481);
            bc.aCg();
            bv localbv = c.azI().ys(paramAnonymousb.msgId);
            d.this.d(paramAnonymous2MenuItem.getItemId(), localbv);
            AppMethodBeat.o(36481);
          }
        });
        AppMethodBeat.o(36483);
      }
    };
    AppMethodBeat.o(36489);
    return local2;
  }
  
  public final String fJO()
  {
    AppMethodBeat.i(36488);
    String str = this.mContext.getString(2131755255);
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
    
    public final boolean aXy(String paramString)
    {
      AppMethodBeat.i(36484);
      if (paramString != null)
      {
        boolean bool = super.aXy(paramString.toLowerCase());
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
    TextView iFO;
    ImageView mdt;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36485);
      this.mdt = ((ImageView)paramView.findViewById(2131299794));
      this.iYj.setSingleLine(false);
      this.iYj.setMaxLines(2);
      this.iFO = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.d
 * JD-Core Version:    0.7.0.1
 */