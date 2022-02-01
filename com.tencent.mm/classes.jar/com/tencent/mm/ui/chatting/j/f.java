package com.tencent.mm.ui.chatting.j;

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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  int IfC = 0;
  int fBP = -1;
  private int qSX = 0;
  
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
      AppMethodBeat.o(36565);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ac.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36565);
    }
    return null;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36563);
    b localb = (b)parama;
    a locala = (a)aaU(paramInt);
    localb.fAz.setText(m.h(this.mContext, locala.timestamp));
    Bitmap localBitmap = o.aFx().a(locala.imagePath, com.tencent.mm.cc.a.getDensity(this.mContext), false);
    if (localBitmap != null)
    {
      parama = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localb.lzC.setImageResource(2131689584);
      }
    }
    for (;;)
    {
      localb.qTn.setText(bs.bG(locala.source, ""));
      b.d(localb.qTn, this.Ifv.HSb);
      AppMethodBeat.o(36563);
      return;
      localb.lzC.setImageBitmap(parama);
    }
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong1, long paramLong2, bo parambo)
  {
    AppMethodBeat.i(36564);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ac.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
      AppMethodBeat.o(36564);
      return;
    }
    String str;
    if (ax.isMobile(this.mContext))
    {
      str = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.length() > 0) {
          break label301;
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
      paramString1.putExtra("geta8key_username", this.fzK);
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString2 = b(parambo, w.sQ(this.fzK));
      paramString1.putExtra("pre_username", paramString2);
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambo != null) {
        paramString1.putExtra("preUsername", paramString2);
      }
      paramString1.putExtra("preChatName", this.fzK);
      paramString1.putExtra("preChatTYPE", com.tencent.mm.model.x.aE(paramString2, this.fzK));
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
        label301:
        str = paramString2;
      }
    }
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(36559);
    String str = this.mContext.getString(2131755256);
    AppMethodBeat.o(36559);
    return str;
  }
  
  public final void foZ()
  {
    AppMethodBeat.i(36558);
    this.Ifu.fpd();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36551);
        LinkedList localLinkedList = new LinkedList();
        az.ayM();
        Cursor localCursor = com.tencent.mm.model.c.awD().dN(f.this.fzK, f.this.fBP);
        if (localCursor == null)
        {
          ac.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36551);
          return;
        }
        com.tencent.mm.storage.x localx;
        long l1;
        if (w.sQ(f.this.fzK))
        {
          az.ayM();
          localx = com.tencent.mm.model.c.awK().xN(f.this.fzK);
          l1 = 0L;
        }
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              bo localbo = new bo();
              localbo.convertFrom(localCursor);
              Object localObject1 = localbo.field_content;
              if (localObject1 == null) {
                continue;
              }
              k.b localb = k.b.vA((String)localObject1);
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
              localObject1 = new Date(localbo.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.fsS().b((Date)localObject1);
              if (l1 != l2)
              {
                localLinkedList.add(new c.c(localbo.field_createTime));
                localObject1 = f.this;
                ((f)localObject1).IfC += 1;
              }
              localObject1 = f.b(localbo, w.sQ(f.this.fzK));
              ai localai1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt((String)localObject1);
              Object localObject3 = "";
              if (localx != null) {
                localObject3 = localx.wk((String)localObject1);
              }
              i = e.acR(localb.hhG);
              localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, localb.dvl);
              az.ayM();
              ai localai2 = com.tencent.mm.model.c.awB().aNt(localb.dvl);
              if ((localai2 == null) || (!localai2.field_username.equals(localb.dvl)))
              {
                ar.a.hnw.a(localb.dvl, "", null);
                localObject3 = new f.a(f.this, localbo.field_createTime, localb.type, localb.title, localbo.field_msgId, localai1.field_username, localai1.aaR(), localai1.field_conRemark, (String)localObject3);
                if (bs.isNullOrNil((String)localObject1))
                {
                  localObject1 = localb.description;
                  ((f.a)localObject3).source = ((String)localObject1);
                  ((f.a)localObject3).appId = localb.appId;
                  ((f.a)localObject3).imagePath = localbo.field_imgPath;
                  ((f.a)localObject3).iconRes = i;
                  localLinkedList.add(localObject3);
                  l1 = l2;
                }
              }
              else
              {
                localObject1 = localai2.aaS();
                continue;
              }
              continue;
            }
            localCursor.close();
            f.this.ijj.addAll(localLinkedList);
            f.this.Ifw = f.this.ijj;
            localLinkedList.clear();
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36550);
                if (f.this.Ifu != null) {
                  f.this.Ifu.B(f.1.this.opD, f.this.ijj.size());
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
          localx = null;
          break;
          label571:
          int i = 0;
        }
      }
    });
    AppMethodBeat.o(36558);
  }
  
  public final c.e fpa()
  {
    AppMethodBeat.i(36561);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36554);
        az.ayM();
        paramAnonymousb = com.tencent.mm.model.c.awD().vP(paramAnonymousb.msgId);
        k.b localb = k.b.vA(paramAnonymousb.field_content);
        String str1 = q.P(localb.url, "message");
        String str2 = q.P(localb.hhE, "message");
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
        ac.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36552);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(2131757157));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(2131757221));
            AppMethodBeat.o(36552);
          }
        }, new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36553);
            az.ayM();
            bo localbo = com.tencent.mm.model.c.awD().vP(paramAnonymousb.msgId);
            f.this.d(paramAnonymous2MenuItem.getItemId(), localbo);
            AppMethodBeat.o(36553);
          }
        });
        AppMethodBeat.o(36555);
      }
    };
    AppMethodBeat.o(36561);
    return local2;
  }
  
  public final String fpc()
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
  
  public final RecyclerView.w z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36562);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495821, paramViewGroup, false));
    AppMethodBeat.o(36562);
    return paramViewGroup;
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
    
    public final boolean aQg(String paramString)
    {
      AppMethodBeat.i(36556);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aQh(paramString))
        {
          if ((!bs.isNullOrNil(this.source)) && (lN(paramString, this.source.toLowerCase())))
          {
            AppMethodBeat.o(36556);
            return true;
          }
        }
        else if ((!bs.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36556);
          return true;
        }
        boolean bool = super.aQg(paramString);
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
    TextView ijE;
    ImageView lzC;
    TextView qTn;
    ImageView qTu;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36557);
      this.lzC = ((ImageView)paramView.findViewById(2131299794));
      this.ijE = ((TextView)paramView.findViewById(2131299778));
      this.ijE.setVisibility(8);
      this.qTn = ((TextView)paramView.findViewById(2131299825));
      this.qTu = ((ImageView)paramView.findViewById(2131299798));
      this.qTu.setImageResource(2131233395);
      this.qTu.setVisibility(0);
      AppMethodBeat.o(36557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.f
 * JD-Core Version:    0.7.0.1
 */