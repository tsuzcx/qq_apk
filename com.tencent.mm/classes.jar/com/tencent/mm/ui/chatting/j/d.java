package com.tencent.mm.ui.chatting.j;

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
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
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
  int IfC = 0;
  int fBP = -1;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36491);
    parama = (b)parama;
    a locala = (a)aaU(paramInt);
    if (bs.isNullOrNil(locala.desc)) {
      parama.ijE.setVisibility(8);
    }
    for (;;)
    {
      parama.lzC.setImageResource(locala.iconRes);
      AppMethodBeat.o(36491);
      return;
      parama.ijE.setVisibility(0);
      parama.ijE.setText(bs.bG(locala.desc, ""));
    }
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(36487);
    String str = this.mContext.getString(2131755255);
    AppMethodBeat.o(36487);
    return str;
  }
  
  public final void foZ()
  {
    AppMethodBeat.i(36486);
    ac.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.Ifu.fpd();
    g.agS();
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36479);
        LinkedList localLinkedList = new LinkedList();
        az.ayM();
        Cursor localCursor = c.awD().dN(d.this.fzK, d.this.fBP);
        if (localCursor == null)
        {
          ac.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36479);
          return;
        }
        if (w.sQ(d.this.fzK)) {
          az.ayM();
        }
        Object localObject2;
        for (x localx = c.awK().xN(d.this.fzK);; localObject2 = null)
        {
          long l1 = 0L;
          try
          {
            while (localCursor.moveToNext())
            {
              bo localbo = new bo();
              localbo.convertFrom(localCursor);
              Object localObject3 = localbo.field_content;
              if (localObject3 != null)
              {
                k.b localb = k.b.vA((String)localObject3);
                if (localb != null)
                {
                  if (6 == localb.type) {}
                  for (int i = 1; i != 0; i = 0)
                  {
                    localObject3 = new Date(localbo.field_createTime);
                    long l2 = a.fsS().b((Date)localObject3);
                    if (l1 != l2)
                    {
                      localLinkedList.add(new c.c(localbo.field_createTime));
                      localObject3 = d.this;
                      ((d)localObject3).IfC += 1;
                    }
                    String str = d.b(localbo, w.sQ(d.this.fzK));
                    ai localai = ((k)g.ab(k.class)).awB().aNt(str);
                    localObject3 = "";
                    if (localx != null) {
                      localObject3 = localx.wk(str);
                    }
                    i = e.acR(localb.hhG);
                    localObject3 = new d.a(d.this, localbo.field_createTime, localb.type, localb.title, localbo.field_msgId, localai.field_username, localai.aaR(), localai.field_conRemark, (String)localObject3);
                    ((d.a)localObject3).iconRes = i;
                    ((d.a)localObject3).desc = bs.qz(localb.hhF);
                    localLinkedList.add(localObject3);
                    l1 = l2;
                    break;
                  }
                }
              }
            }
            localCursor.close();
            d.this.ijj.addAll(localLinkedList);
            d.this.Ifw = d.this.ijj;
            localLinkedList.clear();
            ac.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(d.this.ijj.size()) });
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36478);
                if (d.this.Ifu != null) {
                  d.this.Ifu.B(d.1.this.opD, d.this.ijj.size());
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
  
  public final c.e fpa()
  {
    AppMethodBeat.i(36489);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36482);
        ac.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        d.a(d.this, paramAnonymousb);
        AppMethodBeat.o(36482);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36483);
        ac.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36480);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            if ((!ai.aNc(paramAnonymousb.username)) && (!w.wq(paramAnonymousb.username))) {
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
            az.ayM();
            bo localbo = c.awD().vP(paramAnonymousb.msgId);
            d.this.d(paramAnonymous2MenuItem.getItemId(), localbo);
            AppMethodBeat.o(36481);
          }
        });
        AppMethodBeat.o(36483);
      }
    };
    AppMethodBeat.o(36489);
    return local2;
  }
  
  public final String fpc()
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
  
  public final RecyclerView.w z(ViewGroup paramViewGroup)
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
    
    public final boolean aQg(String paramString)
    {
      AppMethodBeat.i(36484);
      if (paramString != null)
      {
        boolean bool = super.aQg(paramString.toLowerCase());
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
    TextView ijE;
    ImageView lzC;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36485);
      this.lzC = ((ImageView)paramView.findViewById(2131299794));
      this.iCg.setSingleLine(false);
      this.iCg.setMaxLines(2);
      this.ijE = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.d
 * JD-Core Version:    0.7.0.1
 */