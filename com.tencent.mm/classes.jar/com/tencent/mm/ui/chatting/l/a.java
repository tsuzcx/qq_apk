package com.tencent.mm.ui.chatting.l;

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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ac.e;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.tools.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends b
{
  com.tencent.mm.ay.a.a.c WYS;
  private int jmu;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36457);
    this.jmu = -1;
    paramContext = new com.tencent.mm.ay.a.a.c.a();
    paramContext.lRP = R.k.app_brand_app_default_icon_for_tail;
    paramContext.dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50)).lRB = true;
    this.WYS = paramContext.bmL();
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.o(paramString, true, false);
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
  
  public final RecyclerView.v V(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(291591);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ebE, paramViewGroup, false));
    AppMethodBeat.o(291591);
    return paramViewGroup;
  }
  
  public final void a(final com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(36463);
    parama = (b)parama;
    final a locala = (a)avy(paramInt);
    com.tencent.mm.aj.a locala1 = (com.tencent.mm.aj.a)locala.fQY.ar(com.tencent.mm.aj.a.class);
    if ((locala1 != null) && (locala1.lko == 1))
    {
      parama.wRB.setVisibility(0);
      if (!Util.isNullOrNil(locala.desc)) {
        break label113;
      }
      parama.mrM.setVisibility(8);
    }
    label113:
    do
    {
      q.bml().a(locala.imagePath, parama.qps, this.WYS);
      AppMethodBeat.o(36463);
      return;
      parama.wRB.setVisibility(8);
      break;
      parama.mrM.setVisibility(0);
      parama.mrM.setText(parama.mNb.getText());
      parama.mNb.setText(locala.desc);
      b.h(parama.mrM, this.WZa.WFR);
    } while (Util.isNullOrNil(locala.rig));
    com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
    {
      public final void G(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(36452);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          parama.qps.setImageBitmap(paramAnonymousBitmap);
          AppMethodBeat.o(36452);
          return;
        }
        q.bml().a(locala.imagePath, parama.qps, a.this.WYS);
        AppMethodBeat.o(36452);
      }
      
      public final void bhq() {}
      
      public final void bhr()
      {
        AppMethodBeat.i(36453);
        q.bml().a(locala.imagePath, parama.qps, a.this.WYS);
        AppMethodBeat.o(36453);
      }
      
      public final String key()
      {
        AppMethodBeat.i(36454);
        String str = "SEARCH#" + n.cP(this);
        AppMethodBeat.o(36454);
        return str;
      }
    }, locala.rig, null, ((k)com.tencent.mm.kernel.h.ae(k.class)).dK(45, 45));
    AppMethodBeat.o(36463);
  }
  
  public final String bwJ()
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
  
  public final void hRu()
  {
    AppMethodBeat.i(36458);
    Log.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    if (this.WYZ != null) {
      this.WYZ.hRy();
    }
    com.tencent.mm.plugin.appbrand.ac.c.reset();
    com.tencent.mm.plugin.appbrand.ac.c.a(this.jkq, new com.tencent.mm.plugin.appbrand.ac.c.a()
    {
      public final void B(final LinkedList<e> paramAnonymousLinkedList)
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
                  localObject = new a.a(a.this, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).msgId, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).cip, ((e)localObject).rif, ((e)localObject).loB, ((e)localObject).fQY, ((e)localObject).fNu, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).rig);
                  a.this.mDataList.add(localObject);
                }
              }
            }
            a.this.WZb = a.this.mDataList;
            if (a.this.WYZ != null) {
              a.this.WYZ.H(a.1.this.tNh, a.this.mDataList.size());
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
  
  public final c.e hRv()
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
        new m(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new q.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo) {}
        }, new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36449);
            bh.beI();
            ca localca = com.tencent.mm.model.c.bbO().Oq(paramAnonymousb.msgId);
            a.this.e(paramAnonymous2MenuItem.getItemId(), localca);
            AppMethodBeat.o(36449);
          }
        });
        AppMethodBeat.o(36451);
      }
    };
    AppMethodBeat.o(36461);
    return local2;
  }
  
  public final String hRx()
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
    public long fNu;
    public k.b fQY;
    public String imagePath;
    public String loB;
    public String rig;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, k.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
      this.loB = paramString6;
      this.fQY = paramb;
      this.fNu = paramLong3;
      this.desc = paramString7;
      this.imagePath = paramString8;
      this.rig = paramString9;
    }
    
    public final boolean bzd(String paramString)
    {
      AppMethodBeat.i(36455);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bze(paramString))
        {
          if ((!Util.isNullOrNil(this.desc)) && (nZ(paramString, this.desc.toLowerCase())))
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
        boolean bool = super.bzd(paramString);
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
    TextView mrM;
    ImageView qps;
    ImageView wRB;
    TextView wRL;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36456);
      this.qps = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.wRB = ((ImageView)paramView.findViewById(R.h.fav_icon_mask));
      this.mrM = ((TextView)paramView.findViewById(R.h.fav_desc));
      this.wRL = ((TextView)paramView.findViewById(R.h.fav_source));
      this.wRL.setVisibility(8);
      this.wRB.setVisibility(8);
      AppMethodBeat.o(36456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a
 * JD-Core Version:    0.7.0.1
 */