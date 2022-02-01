package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Looper;
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
import com.tencent.mm.aw.o;
import com.tencent.mm.model.az;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.aa.e;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends b
{
  com.tencent.mm.aw.a.a.c GFr;
  private int fyi;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36457);
    this.fyi = -1;
    paramContext = new com.tencent.mm.aw.a.a.c.a();
    paramContext.hkf = 2131689599;
    paramContext.de(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50)).hjS = true;
    this.GFr = paramContext.azc();
    AppMethodBeat.o(36457);
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(36464);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(36464);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.j(paramString, true, false);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(36464);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36464);
    }
    return null;
  }
  
  public final void a(final com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(36463);
    parama = (b)parama;
    final a locala = (a)YJ(paramInt);
    com.tencent.mm.ai.a locala1 = (com.tencent.mm.ai.a)locala.duP.ao(com.tencent.mm.ai.a.class);
    if ((locala1 != null) && (locala1.gFB == 1))
    {
      parama.qkB.setVisibility(0);
      if (!bt.isNullOrNil(locala.desc)) {
        break label113;
      }
      parama.hJe.setVisibility(8);
    }
    label113:
    do
    {
      o.ayJ().a(locala.imagePath, parama.kXS, this.GFr);
      AppMethodBeat.o(36463);
      return;
      parama.qkB.setVisibility(8);
      break;
      parama.hJe.setVisibility(0);
      parama.hJe.setText(parama.ica.getText());
      parama.ica.setText(locala.desc);
      b.d(parama.hJe, this.GFz.Gsj);
    } while (bt.isNullOrNil(locala.lLO));
    com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
    {
      public final String AL()
      {
        AppMethodBeat.i(36454);
        String str = "SEARCH#" + m.cF(this);
        AppMethodBeat.o(36454);
        return str;
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(36452);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          parama.kXS.setImageBitmap(paramAnonymousBitmap);
          AppMethodBeat.o(36452);
          return;
        }
        o.ayJ().a(locala.imagePath, parama.kXS, a.this.GFr);
        AppMethodBeat.o(36452);
      }
      
      public final void auj() {}
      
      public final void nV()
      {
        AppMethodBeat.i(36453);
        o.ayJ().a(locala.imagePath, parama.kXS, a.this.GFr);
        AppMethodBeat.o(36453);
      }
    }, locala.lLO, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).dc(45, 45));
    AppMethodBeat.o(36463);
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(36459);
    String str = this.mContext.getString(2131762906);
    AppMethodBeat.o(36459);
    return str;
  }
  
  public final void eZk()
  {
    AppMethodBeat.i(36458);
    ad.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.GFy.eZo();
    com.tencent.mm.plugin.appbrand.aa.c.reset();
    com.tencent.mm.plugin.appbrand.aa.c.a(this.fwd, new com.tencent.mm.plugin.appbrand.aa.c.a()
    {
      public final void A(final LinkedList<e> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(36448);
        paramAnonymousLinkedList = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36447);
            if (!bt.gL(paramAnonymousLinkedList))
            {
              Iterator localIterator = paramAnonymousLinkedList.iterator();
              while (localIterator.hasNext())
              {
                Object localObject = (e)localIterator.next();
                if (localObject != null)
                {
                  localObject = new a.a(a.this, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).msgId, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).bNL, ((e)localObject).lLN, ((e)localObject).gJF, ((e)localObject).duP, ((e)localObject).drA, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).lLO);
                  a.this.hIH.add(localObject);
                }
              }
            }
            a.this.GFA = a.this.hIH;
            if (a.this.GFy != null) {
              a.this.GFy.A(a.1.this.nMD, a.this.hIH.size());
            }
            AppMethodBeat.o(36447);
          }
        };
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
        {
          aq.f(paramAnonymousLinkedList);
          AppMethodBeat.o(36448);
          return;
        }
        paramAnonymousLinkedList.run();
        AppMethodBeat.o(36448);
      }
    });
    AppMethodBeat.o(36458);
  }
  
  public final c.e eZl()
  {
    AppMethodBeat.i(36461);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36450);
        ad.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        a.a(a.this, (a.a)paramAnonymousb);
        AppMethodBeat.o(36450);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36451);
        ad.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo) {}
        }, new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36449);
            az.arV();
            bl localbl = com.tencent.mm.model.c.apO().rm(paramAnonymousb.msgId);
            a.this.d(paramAnonymous2MenuItem.getItemId(), localbl);
            AppMethodBeat.o(36449);
          }
        });
        AppMethodBeat.o(36451);
      }
    };
    AppMethodBeat.o(36461);
    return local2;
  }
  
  public final String eZn()
  {
    AppMethodBeat.i(36460);
    String str = this.mContext.getString(2131762906);
    AppMethodBeat.o(36460);
    return str;
  }
  
  public final int getType()
  {
    return 33;
  }
  
  public final RecyclerView.v y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36462);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493096, paramViewGroup, false));
    AppMethodBeat.o(36462);
    return paramViewGroup;
  }
  
  final class a
    extends c.b
  {
    public String desc;
    public long drA;
    public k.b duP;
    public String gJF;
    public String imagePath;
    public String lLO;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, k.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
      this.gJF = paramString6;
      this.duP = paramb;
      this.drA = paramLong3;
      this.desc = paramString7;
      this.imagePath = paramString8;
      this.lLO = paramString9;
    }
    
    public final boolean aKD(String paramString)
    {
      AppMethodBeat.i(36455);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aKE(paramString))
        {
          if ((!bt.isNullOrNil(this.desc)) && (lq(paramString, this.desc.toLowerCase())))
          {
            AppMethodBeat.o(36455);
            return true;
          }
        }
        else if ((!bt.isNullOrNil(this.desc)) && (this.desc.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36455);
          return true;
        }
        boolean bool = super.aKD(paramString);
        AppMethodBeat.o(36455);
        return bool;
      }
      AppMethodBeat.o(36455);
      return false;
    }
    
    public final int getType()
    {
      return 33;
    }
  }
  
  final class b
    extends com.tencent.mm.ui.chatting.a.c.a
  {
    TextView hJe;
    ImageView kXS;
    ImageView qkB;
    TextView qkL;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36456);
      this.kXS = ((ImageView)paramView.findViewById(2131299794));
      this.qkB = ((ImageView)paramView.findViewById(2131299798));
      this.hJe = ((TextView)paramView.findViewById(2131299778));
      this.qkL = ((TextView)paramView.findViewById(2131299825));
      this.qkL.setVisibility(8);
      this.qkB.setVisibility(8);
      AppMethodBeat.o(36456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a
 * JD-Core Version:    0.7.0.1
 */