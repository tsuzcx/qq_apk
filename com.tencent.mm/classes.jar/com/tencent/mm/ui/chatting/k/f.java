package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  int JVP = 0;
  int fVc = -1;
  private int rDa = 0;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(36565);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(36565);
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
      AppMethodBeat.o(36565);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36565);
    }
    return null;
  }
  
  public final RecyclerView.w D(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36562);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495821, paramViewGroup, false));
    AppMethodBeat.o(36562);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36563);
    b localb = (b)parama;
    a locala = (a)adg(paramInt);
    localb.fTP.setText(m.h(this.mContext, locala.timestamp));
    Bitmap localBitmap = com.tencent.mm.aw.q.aIF().a(locala.imagePath, com.tencent.mm.cc.a.getDensity(this.mContext), false);
    if (localBitmap != null)
    {
      parama = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = h.c(locala.appId, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localb.lZa.setImageResource(2131689584);
      }
    }
    for (;;)
    {
      localb.rDq.setText(bt.bI(locala.source, ""));
      b.d(localb.rDq, this.JVI.JFT);
      AppMethodBeat.o(36563);
      return;
      localb.lZa.setImageBitmap(parama);
    }
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong1, long paramLong2, bu parambu)
  {
    AppMethodBeat.i(36564);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ad.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
      AppMethodBeat.o(36564);
      return;
    }
    String str;
    if (ay.isMobile(this.mContext))
    {
      str = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.length() > 0) {
          break label305;
        }
        str = paramString1;
      }
    }
    for (;;)
    {
      paramString1 = new Intent();
      paramString1.putExtra("msg_id", paramLong1);
      paramString1.putExtra("rawUrl", str);
      paramString1.putExtra("version_name", paramString3);
      paramString1.putExtra("version_code", paramInt);
      paramString1.putExtra("usePlugin", true);
      paramString1.putExtra("geta8key_username", this.fTa);
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString2 = b(parambu, w.vF(this.fTa));
      paramString1.putExtra("pre_username", paramString2);
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambu != null) {
        paramString1.putExtra("preUsername", paramString2);
      }
      paramString1.putExtra("preChatName", this.fTa);
      paramString1.putExtra("preChatTYPE", x.aG(paramString2, this.fTa));
      paramString1.putExtra("preMsgIndex", 0);
      d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramString1);
      AppMethodBeat.o(36564);
      return;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 0) {}
      }
      else
      {
        label305:
        str = paramString2;
      }
    }
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(36559);
    String str = this.mContext.getString(2131755256);
    AppMethodBeat.o(36559);
    return str;
  }
  
  public final void fFE()
  {
    AppMethodBeat.i(36558);
    this.JVH.fFI();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36551);
        LinkedList localLinkedList = new LinkedList();
        ba.aBQ();
        Cursor localCursor = com.tencent.mm.model.c.azs().ee(f.this.fTa, f.this.fVc);
        if (localCursor == null)
        {
          ad.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36551);
          return;
        }
        ab localab;
        long l1;
        if (w.vF(f.this.fTa))
        {
          ba.aBQ();
          localab = com.tencent.mm.model.c.azz().AN(f.this.fTa);
          l1 = 0L;
        }
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              bu localbu = new bu();
              localbu.convertFrom(localCursor);
              Object localObject1 = localbu.field_content;
              if (localObject1 == null) {
                continue;
              }
              k.b localb = k.b.yr((String)localObject1);
              if (localb == null) {
                continue;
              }
              if (3 != localb.type) {
                break label571;
              }
              i = 1;
              if (i == 0) {
                continue;
              }
              localObject1 = new Date(localbu.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.fJG().b((Date)localObject1);
              if (l1 != l2)
              {
                localLinkedList.add(new c.c(localbu.field_createTime));
                localObject1 = f.this;
                ((f)localObject1).JVP += 1;
              }
              localObject1 = f.b(localbu, w.vF(f.this.fTa));
              am localam1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf((String)localObject1);
              Object localObject3 = "";
              if (localab != null) {
                localObject3 = localab.zf((String)localObject1);
              }
              i = e.agG(localb.hzP);
              localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, localb.dHo);
              ba.aBQ();
              am localam2 = com.tencent.mm.model.c.azp().Bf(localb.dHo);
              if ((localam2 == null) || (!localam2.field_username.equals(localb.dHo)))
              {
                as.a.hFO.a(localb.dHo, "", null);
                localObject3 = new f.a(f.this, localbu.field_createTime, localb.type, localb.title, localbu.field_msgId, localam1.field_username, localam1.adu(), localam1.field_conRemark, (String)localObject3);
                if (bt.isNullOrNil((String)localObject1))
                {
                  localObject1 = localb.description;
                  ((f.a)localObject3).source = ((String)localObject1);
                  ((f.a)localObject3).appId = localb.appId;
                  ((f.a)localObject3).imagePath = localbu.field_imgPath;
                  ((f.a)localObject3).iconRes = i;
                  localLinkedList.add(localObject3);
                  l1 = l2;
                }
              }
              else
              {
                localObject1 = localam2.adv();
                continue;
              }
              continue;
            }
            localCursor.close();
            f.this.mDataList.addAll(localLinkedList);
            f.this.JVJ = f.this.mDataList;
            localLinkedList.clear();
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36550);
                if (f.this.JVH != null) {
                  f.this.JVH.B(f.1.this.oSY, f.this.mDataList.size());
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
          localab = null;
          break;
          label571:
          int i = 0;
        }
      }
    });
    AppMethodBeat.o(36558);
  }
  
  public final c.e fFF()
  {
    AppMethodBeat.i(36561);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36554);
        ba.aBQ();
        paramAnonymousb = com.tencent.mm.model.c.azs().xY(paramAnonymousb.msgId);
        k.b localb = k.b.yr(paramAnonymousb.field_content);
        String str1 = com.tencent.mm.pluginsdk.model.app.q.Q(localb.url, "message");
        String str2 = com.tencent.mm.pluginsdk.model.app.q.Q(localb.hzN, "message");
        PackageInfo localPackageInfo = f.getPackageInfo(f.this.mContext, localb.appId);
        f localf = f.this;
        if (localPackageInfo == null)
        {
          paramAnonymousView = null;
          if (localPackageInfo != null) {
            break label132;
          }
        }
        label132:
        for (paramAnonymousInt = 0;; paramAnonymousInt = localPackageInfo.versionCode)
        {
          localf.a(str1, str2, paramAnonymousView, paramAnonymousInt, localb.appId, paramAnonymousb.field_msgId, paramAnonymousb.field_msgSvrId, paramAnonymousb);
          AppMethodBeat.o(36554);
          return;
          paramAnonymousView = localPackageInfo.versionName;
          break;
        }
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36555);
        ad.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36552);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(2131757157));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(2131757221));
            AppMethodBeat.o(36552);
          }
        }, new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36553);
            ba.aBQ();
            bu localbu = com.tencent.mm.model.c.azs().xY(paramAnonymousb.msgId);
            f.this.d(paramAnonymous2MenuItem.getItemId(), localbu);
            AppMethodBeat.o(36553);
          }
        });
        AppMethodBeat.o(36555);
      }
    };
    AppMethodBeat.o(36561);
    return local2;
  }
  
  public final String fFH()
  {
    AppMethodBeat.i(36560);
    String str = this.mContext.getString(2131755256);
    AppMethodBeat.o(36560);
    return str;
  }
  
  public final int getType()
  {
    return 3;
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
    
    public final boolean aVX(String paramString)
    {
      AppMethodBeat.i(36556);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aVY(paramString))
        {
          if ((!bt.isNullOrNil(this.source)) && (ml(paramString, this.source.toLowerCase())))
          {
            AppMethodBeat.o(36556);
            return true;
          }
        }
        else if ((!bt.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36556);
          return true;
        }
        boolean bool = super.aVX(paramString);
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
    TextView iCV;
    ImageView lZa;
    TextView rDq;
    ImageView rDx;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36557);
      this.lZa = ((ImageView)paramView.findViewById(2131299794));
      this.iCV = ((TextView)paramView.findViewById(2131299778));
      this.iCV.setVisibility(8);
      this.rDq = ((TextView)paramView.findViewById(2131299825));
      this.rDx = ((ImageView)paramView.findViewById(2131299798));
      this.rDx.setImageResource(2131233395);
      this.rDx.setVisibility(0);
      AppMethodBeat.o(36557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.f
 * JD-Core Version:    0.7.0.1
 */