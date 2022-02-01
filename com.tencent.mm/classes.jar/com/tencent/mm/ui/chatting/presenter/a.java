package com.tencent.mm.ui.chatting.presenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Looper;
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
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.af.e;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.u.i;
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
  com.tencent.mm.modelimage.loader.a.c aeIs;
  private int lPs;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36457);
    this.lPs = -1;
    paramContext = new com.tencent.mm.modelimage.loader.a.c.a();
    paramContext.oKB = R.k.app_brand_app_default_icon_for_tail;
    paramContext.eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50)).oKn = true;
    this.aeIs = paramContext.bKx();
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
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
      Log.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36464);
    }
    return null;
  }
  
  public final void a(final com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(36463);
    parama = (b)parama;
    final a locala = (a)aCa(paramInt);
    com.tencent.mm.message.a locala1 = (com.tencent.mm.message.a)locala.hWV.aK(com.tencent.mm.message.a.class);
    if ((locala1 != null) && (locala1.nPa == 1))
    {
      parama.Aoe.setVisibility(0);
      if (!Util.isNullOrNil(locala.desc)) {
        break label113;
      }
      parama.plr.setVisibility(8);
    }
    label113:
    do
    {
      r.bKe().a(locala.imagePath, parama.ttT, this.aeIs);
      AppMethodBeat.o(36463);
      return;
      parama.Aoe.setVisibility(8);
      break;
      parama.plr.setVisibility(0);
      parama.plr.setText(parama.pJJ.getText());
      parama.pJJ.setText(locala.desc);
      b.i(parama.plr, this.aeIA.aenu);
    } while (Util.isNullOrNil(locala.uqc));
    com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
    {
      public final void bFg() {}
      
      public final void bFh()
      {
        AppMethodBeat.i(36453);
        r.bKe().a(locala.imagePath, parama.ttT, a.this.aeIs);
        AppMethodBeat.o(36453);
      }
      
      public final String key()
      {
        AppMethodBeat.i(36454);
        String str = "SEARCH#" + p.el(this);
        AppMethodBeat.o(36454);
        return str;
      }
      
      public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(36452);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          parama.ttT.setImageBitmap(paramAnonymousBitmap);
          AppMethodBeat.o(36452);
          return;
        }
        r.bKe().a(locala.imagePath, parama.ttT, a.this.aeIs);
        AppMethodBeat.o(36452);
      }
    }, locala.uqc, null, ((k)com.tencent.mm.kernel.h.ax(k.class)).eE(45, 45));
    AppMethodBeat.o(36463);
  }
  
  public final RecyclerView.v af(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254371);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gem, paramViewGroup, false));
    AppMethodBeat.o(254371);
    return paramViewGroup;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(36459);
    String str = this.mContext.getString(R.l.search_chatroom_appbrand);
    AppMethodBeat.o(36459);
    return str;
  }
  
  public final int getType()
  {
    return 33;
  }
  
  public final void juR()
  {
    AppMethodBeat.i(36458);
    Log.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    if (this.aeIz != null) {
      this.aeIz.juV();
    }
    com.tencent.mm.plugin.appbrand.af.c.reset();
    com.tencent.mm.plugin.appbrand.af.c.a(this.lMU, new com.tencent.mm.plugin.appbrand.af.c.a()
    {
      public final void E(final LinkedList<e> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(36448);
        paramAnonymousLinkedList = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36447);
            if (!Util.isNullOrNil(paramAnonymousLinkedList))
            {
              Iterator localIterator = paramAnonymousLinkedList.iterator();
              while (localIterator.hasNext())
              {
                Object localObject = (e)localIterator.next();
                if (localObject != null)
                {
                  localObject = new a.a(a.this, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).msgId, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).dYO, ((e)localObject).uqb, ((e)localObject).nTE, ((e)localObject).hWV, ((e)localObject).hTh, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).uqc);
                  a.this.mDataList.add(localObject);
                }
              }
            }
            a.this.aeIB = a.this.mDataList;
            if (a.this.aeIz != null) {
              a.this.aeIz.F(a.1.this.wQx, a.this.mDataList.size());
            }
            AppMethodBeat.o(36447);
          }
        };
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
        {
          MMHandlerThread.postToMainThread(paramAnonymousLinkedList);
          AppMethodBeat.o(36448);
          return;
        }
        paramAnonymousLinkedList.run();
        AppMethodBeat.o(36448);
      }
    });
    AppMethodBeat.o(36458);
  }
  
  public final c.e juS()
  {
    AppMethodBeat.i(36461);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36450);
        Log.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        a.a(a.this, (a.a)paramAnonymousb);
        AppMethodBeat.o(36450);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36451);
        Log.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new u.i
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo) {}
        }, new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36449);
            bh.bCz();
            cc localcc = com.tencent.mm.model.c.bzD().sl(paramAnonymousb.msgId);
            a.this.f(paramAnonymous2MenuItem.getItemId(), localcc);
            AppMethodBeat.o(36449);
          }
        });
        AppMethodBeat.o(36451);
      }
    };
    AppMethodBeat.o(36461);
    return local2;
  }
  
  public final String juU()
  {
    AppMethodBeat.i(36460);
    String str = this.mContext.getString(R.l.search_chatroom_appbrand);
    AppMethodBeat.o(36460);
    return str;
  }
  
  final class a
    extends c.b
  {
    public String desc;
    public long hTh;
    public k.b hWV;
    public String imagePath;
    public String nTE;
    public String uqc;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, k.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
      this.nTE = paramString6;
      this.hWV = paramb;
      this.hTh = paramLong3;
      this.desc = paramString7;
      this.imagePath = paramString8;
      this.uqc = paramString9;
    }
    
    public final boolean bAH(String paramString)
    {
      AppMethodBeat.i(36455);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bAI(paramString))
        {
          if ((!Util.isNullOrNil(this.desc)) && (pY(paramString, this.desc.toLowerCase())))
          {
            AppMethodBeat.o(36455);
            return true;
          }
        }
        else if ((!Util.isNullOrNil(this.desc)) && (this.desc.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36455);
          return true;
        }
        boolean bool = super.bAH(paramString);
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
    ImageView Aoe;
    TextView Aoo;
    TextView plr;
    ImageView ttT;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36456);
      this.ttT = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.Aoe = ((ImageView)paramView.findViewById(R.h.fav_icon_mask));
      this.plr = ((TextView)paramView.findViewById(R.h.fav_desc));
      this.Aoo = ((TextView)paramView.findViewById(R.h.fav_source));
      this.Aoo.setVisibility(8);
      this.Aoe.setVisibility(8);
      AppMethodBeat.o(36456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.a
 * JD-Core Version:    0.7.0.1
 */