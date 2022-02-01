package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.viewitems.ae;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  int WZh = 0;
  int jmu = -1;
  private int wRv = 0;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final RecyclerView.v V(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(219880);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.elG, paramViewGroup, false));
    AppMethodBeat.o(219880);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36563);
    b localb = (b)parama;
    a locala = (a)avy(paramInt);
    localb.timeTV.setText(com.tencent.mm.plugin.fav.ui.m.h(this.mContext, locala.timestamp));
    Bitmap localBitmap = q.bmh().a(locala.imagePath, com.tencent.mm.ci.a.getDensity(this.mContext), false);
    if (localBitmap != null)
    {
      parama = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.ci.a.getDensity(this.mContext));
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localb.qps.setImageResource(R.k.app_attach_file_icon_webpage);
      }
    }
    for (;;)
    {
      localb.wRL.setText(Util.nullAs(locala.source, ""));
      b.h(localb.wRL, this.WZa.WFR);
      AppMethodBeat.o(36563);
      return;
      localb.qps.setImageBitmap(parama);
    }
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(36559);
    String str = this.mContext.getString(R.l.eoj);
    AppMethodBeat.o(36559);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void hRu()
  {
    AppMethodBeat.i(36558);
    this.WYZ.hRy();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36551);
        LinkedList localLinkedList = new LinkedList();
        bh.beI();
        Cursor localCursor = com.tencent.mm.model.c.bbO().fa(f.this.jkq, f.this.jmu);
        if (localCursor == null)
        {
          Log.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36551);
          return;
        }
        ah localah;
        long l1;
        if (ab.Lj(f.this.jkq))
        {
          bh.beI();
          localah = com.tencent.mm.model.c.bbV().Rw(f.this.jkq);
          l1 = 0L;
        }
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              ca localca = new ca();
              localca.convertFrom(localCursor);
              Object localObject1 = localca.field_content;
              if (localObject1 == null) {
                continue;
              }
              k.b localb = k.b.OQ((String)localObject1);
              if (localb == null) {
                continue;
              }
              i = localb.type;
              if (3 == i) {
                break label580;
              }
              if (i != 76) {
                break label585;
              }
              break label580;
              if (i == 0) {
                continue;
              }
              localObject1 = new Date(localca.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.hWZ().b((Date)localObject1);
              if (l1 != l2)
              {
                localLinkedList.add(new c.c(localca.field_createTime));
                localObject1 = f.this;
                ((f)localObject1).WZh += 1;
              }
              localObject1 = f.b(localca, ab.Lj(f.this.jkq));
              as localas1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject1);
              Object localObject3 = "";
              if (localah != null) {
                localObject3 = localah.PJ((String)localObject1);
              }
              i = e.aAm(localb.llY);
              localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, localb.fUd);
              bh.beI();
              as localas2 = com.tencent.mm.model.c.bbL().RG(localb.fUd);
              if ((localas2 == null) || (!localas2.field_username.equals(localb.fUd)))
              {
                az.a.ltq.a(localb.fUd, "", null);
                localObject3 = new f.a(f.this, localca.field_createTime, localb.type, localb.title, localca.field_msgId, localas1.field_username, localas1.ayr(), localas1.field_conRemark, (String)localObject3);
                if (Util.isNullOrNil((String)localObject1))
                {
                  localObject1 = localb.description;
                  ((f.a)localObject3).source = ((String)localObject1);
                  ((f.a)localObject3).appId = localb.appId;
                  ((f.a)localObject3).imagePath = localca.field_imgPath;
                  ((f.a)localObject3).iconRes = i;
                  localLinkedList.add(localObject3);
                  l1 = l2;
                }
              }
              else
              {
                localObject1 = localas2.ays();
                continue;
              }
              continue;
            }
            localCursor.close();
            f.this.mDataList.addAll(localLinkedList);
            f.this.WZb = f.this.mDataList;
            localLinkedList.clear();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36550);
                if (f.this.WYZ != null) {
                  f.this.WYZ.H(f.1.this.tNh, f.this.mDataList.size());
                }
                AppMethodBeat.o(36550);
              }
            });
            AppMethodBeat.o(36551);
            return;
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(36551);
          }
          localah = null;
          break;
          label580:
          int i = 1;
          continue;
          label585:
          i = 0;
        }
      }
    });
    AppMethodBeat.o(36558);
  }
  
  public final c.e hRv()
  {
    AppMethodBeat.i(36561);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36554);
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext()))
        {
          AppMethodBeat.o(36554);
          return;
        }
        bh.beI();
        paramAnonymousView = com.tencent.mm.model.c.bbO().Oq(paramAnonymousb.msgId);
        ae.a(k.b.OQ(paramAnonymousView.field_content), f.this.mContext, "", paramAnonymousView);
        AppMethodBeat.o(36554);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36555);
        Log.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new com.tencent.mm.ui.tools.m(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new q.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36552);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(R.l.retransmits));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(R.l.chatting_fav));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(R.l.evO));
            AppMethodBeat.o(36552);
          }
        }, new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36553);
            bh.beI();
            ca localca = com.tencent.mm.model.c.bbO().Oq(paramAnonymousb.msgId);
            f.this.e(paramAnonymous2MenuItem.getItemId(), localca);
            AppMethodBeat.o(36553);
          }
        });
        AppMethodBeat.o(36555);
      }
    };
    AppMethodBeat.o(36561);
    return local2;
  }
  
  public final String hRx()
  {
    AppMethodBeat.i(36560);
    String str = this.mContext.getString(R.l.eoj);
    AppMethodBeat.o(36560);
    return str;
  }
  
  final class a
    extends c.b
  {
    public String appId;
    public int iconRes;
    public String imagePath;
    public String source;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean bzd(String paramString)
    {
      AppMethodBeat.i(36556);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bze(paramString))
        {
          if ((!Util.isNullOrNil(this.source)) && (nZ(paramString, this.source.toLowerCase())))
          {
            AppMethodBeat.o(36556);
            return true;
          }
        }
        else if ((!Util.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36556);
          return true;
        }
        boolean bool = super.bzd(paramString);
        AppMethodBeat.o(36556);
        return bool;
      }
      AppMethodBeat.o(36556);
      return false;
    }
    
    public final int getType()
    {
      return 3;
    }
  }
  
  final class b
    extends c.a
  {
    TextView mrM;
    ImageView qps;
    TextView wRL;
    ImageView wRS;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36557);
      this.qps = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.mrM = ((TextView)paramView.findViewById(R.h.fav_desc));
      this.mrM.setVisibility(8);
      this.wRL = ((TextView)paramView.findViewById(R.h.fav_source));
      this.wRS = ((ImageView)paramView.findViewById(R.h.fav_icon_mask));
      this.wRS.setImageResource(R.g.music_playicon);
      this.wRS.setVisibility(0);
      AppMethodBeat.o(36557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.f
 * JD-Core Version:    0.7.0.1
 */