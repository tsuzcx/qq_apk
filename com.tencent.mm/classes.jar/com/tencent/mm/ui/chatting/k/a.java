package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Looper;
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
import com.tencent.mm.aw.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.z.e;
import com.tencent.mm.plugin.appbrand.z.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends b
{
  com.tencent.mm.aw.a.a.c JVA;
  private int fVc;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36457);
    this.fVc = -1;
    paramContext = new com.tencent.mm.aw.a.a.c.a();
    paramContext.idD = 2131689599;
    paramContext.dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50)).idp = true;
    this.JVA = paramContext.aJc();
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
      paramString = h.m(paramString, true, false);
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
  
  public final RecyclerView.w D(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36462);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493096, paramViewGroup, false));
    AppMethodBeat.o(36462);
    return paramViewGroup;
  }
  
  public final void a(final com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(36463);
    parama = (b)parama;
    final a locala = (a)adg(paramInt);
    com.tencent.mm.ai.a locala1 = (com.tencent.mm.ai.a)locala.dEu.ao(com.tencent.mm.ai.a.class);
    if ((locala1 != null) && (locala1.hyk == 1))
    {
      parama.rDg.setVisibility(0);
      if (!bt.isNullOrNil(locala.desc)) {
        break label113;
      }
      parama.iCV.setVisibility(8);
    }
    label113:
    do
    {
      q.aIJ().a(locala.imagePath, parama.lZa, this.JVA);
      AppMethodBeat.o(36463);
      return;
      parama.rDg.setVisibility(8);
      break;
      parama.iCV.setVisibility(0);
      parama.iCV.setText(parama.iVq.getText());
      parama.iVq.setText(locala.desc);
      b.d(parama.iCV, this.JVI.JFT);
    } while (bt.isNullOrNil(locala.mOn));
    com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
    {
      public final String BM()
      {
        AppMethodBeat.i(36454);
        String str = "SEARCH#" + n.cG(this);
        AppMethodBeat.o(36454);
        return str;
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(36452);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          parama.lZa.setImageBitmap(paramAnonymousBitmap);
          AppMethodBeat.o(36452);
          return;
        }
        q.aIJ().a(locala.imagePath, parama.lZa, a.this.JVA);
        AppMethodBeat.o(36452);
      }
      
      public final void aEd() {}
      
      public final void ox()
      {
        AppMethodBeat.i(36453);
        q.aIJ().a(locala.imagePath, parama.lZa, a.this.JVA);
        AppMethodBeat.o(36453);
      }
    }, locala.mOn, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).de(45, 45));
    AppMethodBeat.o(36463);
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(36459);
    String str = this.mContext.getString(2131762906);
    AppMethodBeat.o(36459);
    return str;
  }
  
  public final void fFE()
  {
    AppMethodBeat.i(36458);
    ad.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.JVH.fFI();
    com.tencent.mm.plugin.appbrand.z.c.reset();
    com.tencent.mm.plugin.appbrand.z.c.a(this.fTa, new com.tencent.mm.plugin.appbrand.z.c.a()
    {
      public final void A(final LinkedList<e> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(36448);
        paramAnonymousLinkedList = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36447);
            if (!bt.hj(paramAnonymousLinkedList))
            {
              Iterator localIterator = paramAnonymousLinkedList.iterator();
              while (localIterator.hasNext())
              {
                Object localObject = (e)localIterator.next();
                if (localObject != null)
                {
                  localObject = new a.a(a.this, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).msgId, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).bVG, ((e)localObject).mOm, ((e)localObject).hCo, ((e)localObject).dEu, ((e)localObject).dAY, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).mOn);
                  a.this.mDataList.add(localObject);
                }
              }
            }
            a.this.JVJ = a.this.mDataList;
            if (a.this.JVH != null) {
              a.this.JVH.B(a.1.this.oSY, a.this.mDataList.size());
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
  
  public final c.e fFF()
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
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo) {}
        }, new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36449);
            ba.aBQ();
            bu localbu = com.tencent.mm.model.c.azs().xY(paramAnonymousb.msgId);
            a.this.d(paramAnonymous2MenuItem.getItemId(), localbu);
            AppMethodBeat.o(36449);
          }
        });
        AppMethodBeat.o(36451);
      }
    };
    AppMethodBeat.o(36461);
    return local2;
  }
  
  public final String fFH()
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
  
  final class a
    extends c.b
  {
    public long dAY;
    public k.b dEu;
    public String desc;
    public String hCo;
    public String imagePath;
    public String mOn;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, k.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
      this.hCo = paramString6;
      this.dEu = paramb;
      this.dAY = paramLong3;
      this.desc = paramString7;
      this.imagePath = paramString8;
      this.mOn = paramString9;
    }
    
    public final boolean aVX(String paramString)
    {
      AppMethodBeat.i(36455);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aVY(paramString))
        {
          if ((!bt.isNullOrNil(this.desc)) && (ml(paramString, this.desc.toLowerCase())))
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
        boolean bool = super.aVX(paramString);
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
    TextView iCV;
    ImageView lZa;
    ImageView rDg;
    TextView rDq;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36456);
      this.lZa = ((ImageView)paramView.findViewById(2131299794));
      this.rDg = ((ImageView)paramView.findViewById(2131299798));
      this.iCV = ((TextView)paramView.findViewById(2131299778));
      this.rDq = ((TextView)paramView.findViewById(2131299825));
      this.rDq.setVisibility(8);
      this.rDg.setVisibility(8);
      AppMethodBeat.o(36456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a
 * JD-Core Version:    0.7.0.1
 */