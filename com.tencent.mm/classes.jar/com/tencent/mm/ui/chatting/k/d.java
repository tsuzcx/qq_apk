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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
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
  int JVP = 0;
  int fVc = -1;
  
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
    a locala = (a)adg(paramInt);
    if (bt.isNullOrNil(locala.desc)) {
      parama.iCV.setVisibility(8);
    }
    for (;;)
    {
      parama.lZa.setImageResource(locala.iconRes);
      AppMethodBeat.o(36491);
      return;
      parama.iCV.setVisibility(0);
      parama.iCV.setText(bt.bI(locala.desc, ""));
    }
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(36487);
    String str = this.mContext.getString(2131755255);
    AppMethodBeat.o(36487);
    return str;
  }
  
  public final void fFE()
  {
    AppMethodBeat.i(36486);
    ad.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.JVH.fFI();
    g.ajD();
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36479);
        LinkedList localLinkedList = new LinkedList();
        ba.aBQ();
        Cursor localCursor = c.azs().ee(d.this.fTa, d.this.fVc);
        if (localCursor == null)
        {
          ad.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36479);
          return;
        }
        if (w.vF(d.this.fTa)) {
          ba.aBQ();
        }
        Object localObject2;
        for (ab localab = c.azz().AN(d.this.fTa);; localObject2 = null)
        {
          long l1 = 0L;
          try
          {
            while (localCursor.moveToNext())
            {
              bu localbu = new bu();
              localbu.convertFrom(localCursor);
              Object localObject3 = localbu.field_content;
              if (localObject3 != null)
              {
                k.b localb = k.b.yr((String)localObject3);
                if (localb != null)
                {
                  if (6 == localb.type) {}
                  for (int i = 1; i != 0; i = 0)
                  {
                    localObject3 = new Date(localbu.field_createTime);
                    long l2 = a.fJG().b((Date)localObject3);
                    if (l1 != l2)
                    {
                      localLinkedList.add(new c.c(localbu.field_createTime));
                      localObject3 = d.this;
                      ((d)localObject3).JVP += 1;
                    }
                    String str = d.b(localbu, w.vF(d.this.fTa));
                    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str);
                    localObject3 = "";
                    if (localab != null) {
                      localObject3 = localab.zf(str);
                    }
                    i = e.agG(localb.hzP);
                    localObject3 = new d.a(d.this, localbu.field_createTime, localb.type, localb.title, localbu.field_msgId, localam.field_username, localam.adu(), localam.field_conRemark, (String)localObject3);
                    ((d.a)localObject3).iconRes = i;
                    ((d.a)localObject3).desc = bt.sy(localb.hzO);
                    localLinkedList.add(localObject3);
                    l1 = l2;
                    break;
                  }
                }
              }
            }
            localCursor.close();
            d.this.mDataList.addAll(localLinkedList);
            d.this.JVJ = d.this.mDataList;
            localLinkedList.clear();
            ad.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(d.this.mDataList.size()) });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36478);
                if (d.this.JVH != null) {
                  d.this.JVH.B(d.1.this.oSY, d.this.mDataList.size());
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
  
  public final c.e fFF()
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
        new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36480);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            if ((!am.aSQ(paramAnonymousb.username)) && (!w.zl(paramAnonymousb.username))) {
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
            ba.aBQ();
            bu localbu = c.azs().xY(paramAnonymousb.msgId);
            d.this.d(paramAnonymous2MenuItem.getItemId(), localbu);
            AppMethodBeat.o(36481);
          }
        });
        AppMethodBeat.o(36483);
      }
    };
    AppMethodBeat.o(36489);
    return local2;
  }
  
  public final String fFH()
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
    
    public final boolean aVX(String paramString)
    {
      AppMethodBeat.i(36484);
      if (paramString != null)
      {
        boolean bool = super.aVX(paramString.toLowerCase());
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
    TextView iCV;
    ImageView lZa;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36485);
      this.lZa = ((ImageView)paramView.findViewById(2131299794));
      this.iVq.setSingleLine(false);
      this.iVq.setMaxLines(2);
      this.iCV = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.d
 * JD-Core Version:    0.7.0.1
 */