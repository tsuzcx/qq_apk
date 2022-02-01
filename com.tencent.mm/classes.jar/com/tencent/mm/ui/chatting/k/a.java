package com.tencent.mm.ui.chatting.k;

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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ac.e;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o.g;
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
  com.tencent.mm.av.a.a.c PEf;
  private int gCo;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36457);
    this.gCo = -1;
    paramContext = new com.tencent.mm.av.a.a.c.a();
    paramContext.jbq = 2131689602;
    paramContext.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).jbd = true;
    this.PEf = paramContext.bdv();
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
      paramString = h.o(paramString, true, false);
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
  
  public final RecyclerView.v N(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36462);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493138, paramViewGroup, false));
    AppMethodBeat.o(36462);
    return paramViewGroup;
  }
  
  public final void a(final com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(36463);
    parama = (b)parama;
    final a locala = (a)amy(paramInt);
    com.tencent.mm.ag.a locala1 = (com.tencent.mm.ag.a)locala.dXm.as(com.tencent.mm.ag.a.class);
    if ((locala1 != null) && (locala1.ivf == 1))
    {
      parama.tld.setVisibility(0);
      if (!Util.isNullOrNil(locala.desc)) {
        break label113;
      }
      parama.jBR.setVisibility(8);
    }
    label113:
    do
    {
      q.bcV().a(locala.imagePath, parama.nnL, this.PEf);
      AppMethodBeat.o(36463);
      return;
      parama.tld.setVisibility(8);
      break;
      parama.jBR.setVisibility(0);
      parama.jBR.setText(parama.jVO.getText());
      parama.jVO.setText(locala.desc);
      b.g(parama.jBR, this.PEn.Pmg);
    } while (Util.isNullOrNil(locala.ogu));
    com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
    {
      public final void I(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(36452);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          parama.nnL.setImageBitmap(paramAnonymousBitmap);
          AppMethodBeat.o(36452);
          return;
        }
        q.bcV().a(locala.imagePath, parama.nnL, a.this.PEf);
        AppMethodBeat.o(36452);
      }
      
      public final String Lb()
      {
        AppMethodBeat.i(36454);
        String str = "SEARCH#" + n.cO(this);
        AppMethodBeat.o(36454);
        return str;
      }
      
      public final void aYg() {}
      
      public final void oD()
      {
        AppMethodBeat.i(36453);
        q.bcV().a(locala.imagePath, parama.nnL, a.this.PEf);
        AppMethodBeat.o(36453);
      }
    }, locala.ogu, null, ((k)com.tencent.mm.kernel.g.af(k.class)).jdMethod_do(45, 45));
    AppMethodBeat.o(36463);
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(36459);
    String str = this.mContext.getString(2131765042);
    AppMethodBeat.o(36459);
    return str;
  }
  
  public final void gRY()
  {
    AppMethodBeat.i(36458);
    Log.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.PEm.gSc();
    com.tencent.mm.plugin.appbrand.ac.c.reset();
    com.tencent.mm.plugin.appbrand.ac.c.a(this.gAn, new com.tencent.mm.plugin.appbrand.ac.c.a()
    {
      public final void A(final LinkedList<e> paramAnonymousLinkedList)
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
                  localObject = new a.a(a.this, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).msgId, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).cgo, ((e)localObject).ogt, ((e)localObject).izj, ((e)localObject).dXm, ((e)localObject).dTS, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).ogu);
                  a.this.mDataList.add(localObject);
                }
              }
            }
            a.this.PEo = a.this.mDataList;
            if (a.this.PEm != null) {
              a.this.PEm.D(a.1.this.qoy, a.this.mDataList.size());
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
  
  public final c.e gRZ()
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
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new o.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo) {}
        }, new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36449);
            bg.aVF();
            ca localca = com.tencent.mm.model.c.aSQ().Hb(paramAnonymousb.msgId);
            a.this.d(paramAnonymous2MenuItem.getItemId(), localca);
            AppMethodBeat.o(36449);
          }
        });
        AppMethodBeat.o(36451);
      }
    };
    AppMethodBeat.o(36461);
    return local2;
  }
  
  public final String gSb()
  {
    AppMethodBeat.i(36460);
    String str = this.mContext.getString(2131765042);
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
    public long dTS;
    public k.b dXm;
    public String desc;
    public String imagePath;
    public String izj;
    public String ogu;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, k.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
      this.izj = paramString6;
      this.dXm = paramb;
      this.dTS = paramLong3;
      this.desc = paramString7;
      this.imagePath = paramString8;
      this.ogu = paramString9;
    }
    
    public final boolean bmC(String paramString)
    {
      AppMethodBeat.i(36455);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bmD(paramString))
        {
          if ((!Util.isNullOrNil(this.desc)) && (ng(paramString, this.desc.toLowerCase())))
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
        boolean bool = super.bmC(paramString);
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
    TextView jBR;
    ImageView nnL;
    ImageView tld;
    TextView tln;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36456);
      this.nnL = ((ImageView)paramView.findViewById(2131300468));
      this.tld = ((ImageView)paramView.findViewById(2131300473));
      this.jBR = ((TextView)paramView.findViewById(2131300451));
      this.tln = ((TextView)paramView.findViewById(2131300503));
      this.tln.setVisibility(8);
      this.tld.setVisibility(8);
      AppMethodBeat.o(36456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a
 * JD-Core Version:    0.7.0.1
 */