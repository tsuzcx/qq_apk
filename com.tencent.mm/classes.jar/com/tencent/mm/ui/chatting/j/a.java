package com.tencent.mm.ui.chatting.j;

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
import com.tencent.mm.av.o;
import com.tencent.mm.model.az;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.z.e;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
  com.tencent.mm.av.a.a.c Ifn;
  private int fBP;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36457);
    this.fBP = -1;
    paramContext = new com.tencent.mm.av.a.a.c.a();
    paramContext.hKI = 2131689599;
    paramContext.de(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 50)).hKv = true;
    this.Ifn = paramContext.aFT();
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.k(paramString, true, false);
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
      ac.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36464);
    }
    return null;
  }
  
  public final void a(final com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(36463);
    parama = (b)parama;
    final a locala = (a)aaU(paramInt);
    com.tencent.mm.ah.a locala1 = (com.tencent.mm.ah.a)locala.dsB.ao(com.tencent.mm.ah.a.class);
    if ((locala1 != null) && (locala1.hgc == 1))
    {
      parama.qTd.setVisibility(0);
      if (!bs.isNullOrNil(locala.desc)) {
        break label113;
      }
      parama.ijE.setVisibility(8);
    }
    label113:
    do
    {
      o.aFB().a(locala.imagePath, parama.lzC, this.Ifn);
      AppMethodBeat.o(36463);
      return;
      parama.qTd.setVisibility(8);
      break;
      parama.ijE.setVisibility(0);
      parama.ijE.setText(parama.iCg.getText());
      parama.iCg.setText(locala.desc);
      b.d(parama.ijE, this.Ifv.HSb);
    } while (bs.isNullOrNil(locala.mnL));
    com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
    {
      public final String Ap()
      {
        AppMethodBeat.i(36454);
        String str = "SEARCH#" + m.cE(this);
        AppMethodBeat.o(36454);
        return str;
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(36452);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          parama.lzC.setImageBitmap(paramAnonymousBitmap);
          AppMethodBeat.o(36452);
          return;
        }
        o.aFB().a(locala.imagePath, parama.lzC, a.this.Ifn);
        AppMethodBeat.o(36452);
      }
      
      public final void aBa() {}
      
      public final void of()
      {
        AppMethodBeat.i(36453);
        o.aFB().a(locala.imagePath, parama.lzC, a.this.Ifn);
        AppMethodBeat.o(36453);
      }
    }, locala.mnL, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).dc(45, 45));
    AppMethodBeat.o(36463);
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(36459);
    String str = this.mContext.getString(2131762906);
    AppMethodBeat.o(36459);
    return str;
  }
  
  public final void foZ()
  {
    AppMethodBeat.i(36458);
    ac.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.Ifu.fpd();
    com.tencent.mm.plugin.appbrand.z.c.reset();
    com.tencent.mm.plugin.appbrand.z.c.a(this.fzK, new com.tencent.mm.plugin.appbrand.z.c.a()
    {
      public final void A(final LinkedList<e> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(36448);
        paramAnonymousLinkedList = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36447);
            if (!bs.gY(paramAnonymousLinkedList))
            {
              Iterator localIterator = paramAnonymousLinkedList.iterator();
              while (localIterator.hasNext())
              {
                Object localObject = (e)localIterator.next();
                if (localObject != null)
                {
                  localObject = new a.a(a.this, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).msgId, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).bLt, ((e)localObject).mnK, ((e)localObject).hkf, ((e)localObject).dsB, ((e)localObject).dpl, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).mnL);
                  a.this.ijj.add(localObject);
                }
              }
            }
            a.this.Ifw = a.this.ijj;
            if (a.this.Ifu != null) {
              a.this.Ifu.B(a.1.this.opD, a.this.ijj.size());
            }
            AppMethodBeat.o(36447);
          }
        };
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
        {
          ap.f(paramAnonymousLinkedList);
          AppMethodBeat.o(36448);
          return;
        }
        paramAnonymousLinkedList.run();
        AppMethodBeat.o(36448);
      }
    });
    AppMethodBeat.o(36458);
  }
  
  public final c.e fpa()
  {
    AppMethodBeat.i(36461);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36450);
        ac.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        a.a(a.this, (a.a)paramAnonymousb);
        AppMethodBeat.o(36450);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36451);
        ac.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo) {}
        }, new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36449);
            az.ayM();
            bo localbo = com.tencent.mm.model.c.awD().vP(paramAnonymousb.msgId);
            a.this.d(paramAnonymous2MenuItem.getItemId(), localbo);
            AppMethodBeat.o(36449);
          }
        });
        AppMethodBeat.o(36451);
      }
    };
    AppMethodBeat.o(36461);
    return local2;
  }
  
  public final String fpc()
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
  
  public final RecyclerView.w z(ViewGroup paramViewGroup)
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
    public long dpl;
    public k.b dsB;
    public String hkf;
    public String imagePath;
    public String mnL;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, k.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
      this.hkf = paramString6;
      this.dsB = paramb;
      this.dpl = paramLong3;
      this.desc = paramString7;
      this.imagePath = paramString8;
      this.mnL = paramString9;
    }
    
    public final boolean aQg(String paramString)
    {
      AppMethodBeat.i(36455);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aQh(paramString))
        {
          if ((!bs.isNullOrNil(this.desc)) && (lN(paramString, this.desc.toLowerCase())))
          {
            AppMethodBeat.o(36455);
            return true;
          }
        }
        else if ((!bs.isNullOrNil(this.desc)) && (this.desc.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36455);
          return true;
        }
        boolean bool = super.aQg(paramString);
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
    TextView ijE;
    ImageView lzC;
    ImageView qTd;
    TextView qTn;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36456);
      this.lzC = ((ImageView)paramView.findViewById(2131299794));
      this.qTd = ((ImageView)paramView.findViewById(2131299798));
      this.ijE = ((TextView)paramView.findViewById(2131299778));
      this.qTn = ((TextView)paramView.findViewById(2131299825));
      this.qTn.setVisibility(8);
      this.qTd.setVisibility(8);
      AppMethodBeat.o(36456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a
 * JD-Core Version:    0.7.0.1
 */