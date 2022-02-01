package com.tencent.mm.ui.chatting.presenter;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.viewitems.ac;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  private int AnY = 0;
  int aeIH = 0;
  int lPs = -1;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36563);
    b localb = (b)parama;
    a locala = (a)aCa(paramInt);
    localb.timeTV.setText(m.h(this.mContext, locala.timestamp));
    Bitmap localBitmap = r.bKa().a(locala.imagePath, com.tencent.mm.cd.a.getDensity(this.mContext), false);
    if (localBitmap != null)
    {
      parama = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localb.ttT.setImageResource(R.k.app_attach_file_icon_webpage);
      }
    }
    for (;;)
    {
      localb.Aoo.setText(Util.nullAs(locala.source, ""));
      b.i(localb.Aoo, this.aeIA.aenu);
      AppMethodBeat.o(36563);
      return;
      localb.ttT.setImageBitmap(parama);
    }
  }
  
  public final RecyclerView.v af(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254332);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.goK, paramViewGroup, false));
    AppMethodBeat.o(254332);
    return paramViewGroup;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(36559);
    String str = this.mContext.getString(R.l.grh);
    AppMethodBeat.o(36559);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void juR()
  {
    AppMethodBeat.i(36558);
    this.aeIz.juV();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36551);
        LinkedList localLinkedList = new LinkedList();
        bh.bCz();
        Cursor localCursor = com.tencent.mm.model.c.bzD().fT(f.this.lMU, f.this.lPs);
        if (localCursor == null)
        {
          Log.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36551);
          return;
        }
        aj localaj;
        long l1;
        if (au.bwE(f.this.lMU))
        {
          bh.bCz();
          localaj = com.tencent.mm.model.c.bzK().Ju(f.this.lMU);
          l1 = 0L;
        }
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              cc localcc = new cc();
              localcc.convertFrom(localCursor);
              Object localObject1 = localcc.field_content;
              if (localObject1 == null) {
                continue;
              }
              k.b localb = k.b.Hf((String)localObject1);
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
              localObject1 = new Date(localcc.getCreateTime());
              long l2 = com.tencent.mm.ui.gridviewheaders.a.jBw().b((Date)localObject1);
              if (l1 != l2)
              {
                localLinkedList.add(new c.c(localcc.getCreateTime()));
                localObject1 = f.this;
                ((f)localObject1).aeIH += 1;
              }
              localObject1 = f.b(localcc, au.bwE(f.this.lMU));
              au localau1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject1);
              Object localObject3 = "";
              if (localaj != null) {
                localObject3 = localaj.getDisplayName((String)localObject1);
              }
              i = e.aut(localb.nRe);
              localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, localb.iaa);
              bh.bCz();
              au localau2 = com.tencent.mm.model.c.bzA().JE(localb.iaa);
              if ((localau2 == null) || (!localau2.field_username.equals(localb.iaa)))
              {
                az.a.okP.a(localb.iaa, "", null);
                localObject3 = new f.a(f.this, localcc.getCreateTime(), localb.type, localb.title, localcc.field_msgId, localau1.field_username, localau1.aSU(), localau1.field_conRemark, (String)localObject3);
                if (Util.isNullOrNil((String)localObject1))
                {
                  localObject1 = localb.description;
                  ((f.a)localObject3).source = ((String)localObject1);
                  ((f.a)localObject3).appId = localb.appId;
                  ((f.a)localObject3).imagePath = localcc.field_imgPath;
                  ((f.a)localObject3).iconRes = i;
                  localLinkedList.add(localObject3);
                  l1 = l2;
                }
              }
              else
              {
                localObject1 = localau2.aSV();
                continue;
              }
              continue;
            }
            localCursor.close();
            f.this.mDataList.addAll(localLinkedList);
            f.this.aeIB = f.this.mDataList;
            localLinkedList.clear();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36550);
                if (f.this.aeIz != null) {
                  f.this.aeIz.F(f.1.this.wQx, f.this.mDataList.size());
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
          localaj = null;
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
  
  public final c.e juS()
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
        bh.bCz();
        paramAnonymousView = com.tencent.mm.model.c.bzD().sl(paramAnonymousb.msgId);
        ac.a(k.b.Hf(paramAnonymousView.field_content), f.this.mContext, "", paramAnonymousView);
        AppMethodBeat.o(36554);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36555);
        Log.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new u.i
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36552);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(R.l.retransmits));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(R.l.chatting_fav));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(R.l.gyo));
            AppMethodBeat.o(36552);
          }
        }, new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36553);
            bh.bCz();
            cc localcc = com.tencent.mm.model.c.bzD().sl(paramAnonymousb.msgId);
            f.this.f(paramAnonymous2MenuItem.getItemId(), localcc);
            AppMethodBeat.o(36553);
          }
        });
        AppMethodBeat.o(36555);
      }
    };
    AppMethodBeat.o(36561);
    return local2;
  }
  
  public final String juU()
  {
    AppMethodBeat.i(36560);
    String str = this.mContext.getString(R.l.grh);
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
    
    public final boolean bAH(String paramString)
    {
      AppMethodBeat.i(36556);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bAI(paramString))
        {
          if ((!Util.isNullOrNil(this.source)) && (pY(paramString, this.source.toLowerCase())))
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
        boolean bool = super.bAH(paramString);
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
    TextView Aoo;
    ImageView Aov;
    TextView plr;
    ImageView ttT;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36557);
      this.ttT = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.plr = ((TextView)paramView.findViewById(R.h.fav_desc));
      this.plr.setVisibility(8);
      this.Aoo = ((TextView)paramView.findViewById(R.h.fav_source));
      this.Aov = ((ImageView)paramView.findViewById(R.h.fav_icon_mask));
      this.Aov.setImageResource(R.g.music_playicon);
      this.Aov.setVisibility(0);
      AppMethodBeat.o(36557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.f
 * JD-Core Version:    0.7.0.1
 */