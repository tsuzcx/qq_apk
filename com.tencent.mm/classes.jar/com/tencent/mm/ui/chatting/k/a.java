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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
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
  com.tencent.mm.av.a.a.c KrS;
  private int fXi;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36457);
    this.fXi = -1;
    paramContext = new com.tencent.mm.av.a.a.c.a();
    paramContext.igv = 2131689599;
    paramContext.dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50)).igi = true;
    this.KrS = paramContext.aJu();
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
      ae.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", paramContext, "", new Object[0]);
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
    final a locala = (a)adN(paramInt);
    com.tencent.mm.ah.a locala1 = (com.tencent.mm.ah.a)locala.dFz.ao(com.tencent.mm.ah.a.class);
    if ((locala1 != null) && (locala1.hAY == 1))
    {
      parama.rLr.setVisibility(0);
      if (!bu.isNullOrNil(locala.desc)) {
        break label113;
      }
      parama.iFO.setVisibility(8);
    }
    label113:
    do
    {
      q.aJb().a(locala.imagePath, parama.mdt, this.KrS);
      AppMethodBeat.o(36463);
      return;
      parama.rLr.setVisibility(8);
      break;
      parama.iFO.setVisibility(0);
      parama.iFO.setText(parama.iYj.getText());
      parama.iYj.setText(locala.desc);
      b.e(parama.iFO, this.Ksa.KaK);
    } while (bu.isNullOrNil(locala.mTr));
    com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
    {
      public final String BN()
      {
        AppMethodBeat.i(36454);
        String str = "SEARCH#" + n.cH(this);
        AppMethodBeat.o(36454);
        return str;
      }
      
      public final void F(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(36452);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          parama.mdt.setImageBitmap(paramAnonymousBitmap);
          AppMethodBeat.o(36452);
          return;
        }
        q.aJb().a(locala.imagePath, parama.mdt, a.this.KrS);
        AppMethodBeat.o(36452);
      }
      
      public final void aEt() {}
      
      public final void ox()
      {
        AppMethodBeat.i(36453);
        q.aJb().a(locala.imagePath, parama.mdt, a.this.KrS);
        AppMethodBeat.o(36453);
      }
    }, locala.mTr, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).de(45, 45));
    AppMethodBeat.o(36463);
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(36459);
    String str = this.mContext.getString(2131762906);
    AppMethodBeat.o(36459);
    return str;
  }
  
  public final void fJL()
  {
    AppMethodBeat.i(36458);
    ae.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.KrZ.fJP();
    com.tencent.mm.plugin.appbrand.y.c.reset();
    com.tencent.mm.plugin.appbrand.y.c.a(this.fVg, new com.tencent.mm.plugin.appbrand.y.c.a()
    {
      public final void A(final LinkedList<e> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(36448);
        paramAnonymousLinkedList = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36447);
            if (!bu.ht(paramAnonymousLinkedList))
            {
              Iterator localIterator = paramAnonymousLinkedList.iterator();
              while (localIterator.hasNext())
              {
                Object localObject = (e)localIterator.next();
                if (localObject != null)
                {
                  localObject = new a.a(a.this, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).msgId, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).bVG, ((e)localObject).mTq, ((e)localObject).hFd, ((e)localObject).dFz, ((e)localObject).dCd, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).mTr);
                  a.this.mDataList.add(localObject);
                }
              }
            }
            a.this.Ksb = a.this.mDataList;
            if (a.this.KrZ != null) {
              a.this.KrZ.C(a.1.this.oZA, a.this.mDataList.size());
            }
            AppMethodBeat.o(36447);
          }
        };
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
        {
          ar.f(paramAnonymousLinkedList);
          AppMethodBeat.o(36448);
          return;
        }
        paramAnonymousLinkedList.run();
        AppMethodBeat.o(36448);
      }
    });
    AppMethodBeat.o(36458);
  }
  
  public final c.e fJM()
  {
    AppMethodBeat.i(36461);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36450);
        ae.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        a.a(a.this, (a.a)paramAnonymousb);
        AppMethodBeat.o(36450);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36451);
        ae.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo) {}
        }, new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36449);
            bc.aCg();
            bv localbv = com.tencent.mm.model.c.azI().ys(paramAnonymousb.msgId);
            a.this.d(paramAnonymous2MenuItem.getItemId(), localbv);
            AppMethodBeat.o(36449);
          }
        });
        AppMethodBeat.o(36451);
      }
    };
    AppMethodBeat.o(36461);
    return local2;
  }
  
  public final String fJO()
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
    public long dCd;
    public k.b dFz;
    public String desc;
    public String hFd;
    public String imagePath;
    public String mTr;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, k.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
      this.hFd = paramString6;
      this.dFz = paramb;
      this.dCd = paramLong3;
      this.desc = paramString7;
      this.imagePath = paramString8;
      this.mTr = paramString9;
    }
    
    public final boolean aXy(String paramString)
    {
      AppMethodBeat.i(36455);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aXz(paramString))
        {
          if ((!bu.isNullOrNil(this.desc)) && (ms(paramString, this.desc.toLowerCase())))
          {
            AppMethodBeat.o(36455);
            return true;
          }
        }
        else if ((!bu.isNullOrNil(this.desc)) && (this.desc.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36455);
          return true;
        }
        boolean bool = super.aXy(paramString);
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
    TextView iFO;
    ImageView mdt;
    TextView rLB;
    ImageView rLr;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36456);
      this.mdt = ((ImageView)paramView.findViewById(2131299794));
      this.rLr = ((ImageView)paramView.findViewById(2131299798));
      this.iFO = ((TextView)paramView.findViewById(2131299778));
      this.rLB = ((TextView)paramView.findViewById(2131299825));
      this.rLB.setVisibility(8);
      this.rLr.setVisibility(8);
      AppMethodBeat.o(36456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a
 * JD-Core Version:    0.7.0.1
 */