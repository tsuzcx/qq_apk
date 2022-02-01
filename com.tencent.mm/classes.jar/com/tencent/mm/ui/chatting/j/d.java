package com.tencent.mm.ui.chatting.j;

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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.gridviewheaders.a;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class d
  extends b
{
  int GFG = 0;
  int fyi = -1;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36491);
    parama = (b)parama;
    a locala = (a)YJ(paramInt);
    if (bt.isNullOrNil(locala.desc)) {
      parama.hJe.setVisibility(8);
    }
    for (;;)
    {
      parama.kXS.setImageResource(locala.iconRes);
      AppMethodBeat.o(36491);
      return;
      parama.hJe.setVisibility(0);
      parama.hJe.setText(bt.by(locala.desc, ""));
    }
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(36487);
    String str = this.mContext.getString(2131755255);
    AppMethodBeat.o(36487);
    return str;
  }
  
  public final void eZk()
  {
    AppMethodBeat.i(36486);
    ad.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.GFy.eZo();
    g.afC();
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36479);
        LinkedList localLinkedList = new LinkedList();
        az.arV();
        Cursor localCursor = c.apO().dG(d.this.fwd, d.this.fyi);
        if (localCursor == null)
        {
          ad.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36479);
          return;
        }
        if (com.tencent.mm.model.w.pF(d.this.fwd)) {
          az.arV();
        }
        Object localObject2;
        for (com.tencent.mm.storage.w localw = c.apV().tH(d.this.fwd);; localObject2 = null)
        {
          long l1 = 0L;
          try
          {
            while (localCursor.moveToNext())
            {
              bl localbl = new bl();
              localbl.convertFrom(localCursor);
              Object localObject3 = localbl.field_content;
              if (localObject3 != null)
              {
                k.b localb = k.b.rx((String)localObject3);
                if (localb != null)
                {
                  if (6 == localb.type) {}
                  for (int i = 1; i != 0; i = 0)
                  {
                    localObject3 = new Date(localbl.field_createTime);
                    long l2 = a.fcX().b((Date)localObject3);
                    if (l1 != l2)
                    {
                      localLinkedList.add(new c.c(localbl.field_createTime));
                      localObject3 = d.this;
                      ((d)localObject3).GFG += 1;
                    }
                    String str = d.b(localbl, com.tencent.mm.model.w.pF(d.this.fwd));
                    af localaf = ((k)g.ab(k.class)).apM().aHY(str);
                    localObject3 = "";
                    if (localw != null) {
                      localObject3 = localw.sh(str);
                    }
                    i = e.Yv(localb.gHf);
                    localObject3 = new d.a(d.this, localbl.field_createTime, localb.type, localb.title, localbl.field_msgId, localaf.field_username, localaf.ZW(), localaf.field_conRemark, (String)localObject3);
                    ((d.a)localObject3).iconRes = i;
                    ((d.a)localObject3).desc = bt.mK(localb.gHe);
                    localLinkedList.add(localObject3);
                    l1 = l2;
                    break;
                  }
                }
              }
            }
            localCursor.close();
            d.this.hIH.addAll(localLinkedList);
            d.this.GFA = d.this.hIH;
            localLinkedList.clear();
            ad.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(d.this.hIH.size()) });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36478);
                if (d.this.GFy != null) {
                  d.this.GFy.A(d.1.this.nMD, d.this.hIH.size());
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
  
  public final c.e eZl()
  {
    AppMethodBeat.i(36489);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36482);
        ad.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        d.a(d.this, paramAnonymousb);
        AppMethodBeat.o(36482);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36483);
        ad.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36480);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            if ((!af.aHH(paramAnonymousb.username)) && (!com.tencent.mm.model.w.sn(paramAnonymousb.username))) {
              paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(2131757157));
            }
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(2131757221));
            AppMethodBeat.o(36480);
          }
        }, new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36481);
            az.arV();
            bl localbl = c.apO().rm(paramAnonymousb.msgId);
            d.this.d(paramAnonymous2MenuItem.getItemId(), localbl);
            AppMethodBeat.o(36481);
          }
        });
        AppMethodBeat.o(36483);
      }
    };
    AppMethodBeat.o(36489);
    return local2;
  }
  
  public final String eZn()
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
  
  public final RecyclerView.v y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36490);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494003, paramViewGroup, false));
    AppMethodBeat.o(36490);
    return paramViewGroup;
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
    
    public final boolean aKD(String paramString)
    {
      AppMethodBeat.i(36484);
      if (paramString != null)
      {
        boolean bool = super.aKD(paramString.toLowerCase());
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
    TextView hJe;
    ImageView kXS;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36485);
      this.kXS = ((ImageView)paramView.findViewById(2131299794));
      this.ica.setSingleLine(false);
      this.ica.setMaxLines(2);
      this.hJe = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.d
 * JD-Core Version:    0.7.0.1
 */