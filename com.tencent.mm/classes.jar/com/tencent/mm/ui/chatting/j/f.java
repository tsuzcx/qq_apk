package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
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
  int GFG = 0;
  int fyi = -1;
  private int qkv = 0;
  
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.j(paramString, true, false);
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
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36563);
    b localb = (b)parama;
    a locala = (a)YJ(paramInt);
    localb.fwS.setText(m.h(this.mContext, locala.timestamp));
    Bitmap localBitmap = o.ayF().a(locala.imagePath, com.tencent.mm.cd.a.getDensity(this.mContext), false);
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
        localb.kXS.setImageResource(2131689584);
      }
    }
    for (;;)
    {
      localb.qkL.setText(bt.by(locala.source, ""));
      b.d(localb.qkL, this.GFz.Gsj);
      AppMethodBeat.o(36563);
      return;
      localb.kXS.setImageBitmap(parama);
    }
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong1, long paramLong2, bl parambl)
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
      paramString1.putExtra("geta8key_username", this.fwd);
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString2 = b(parambl, com.tencent.mm.model.w.pF(this.fwd));
      paramString1.putExtra("pre_username", paramString2);
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambl != null) {
        paramString1.putExtra("preUsername", paramString2);
      }
      paramString1.putExtra("preChatName", this.fwd);
      paramString1.putExtra("preChatTYPE", x.aw(paramString2, this.fwd));
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
  
  public final String aHv()
  {
    AppMethodBeat.i(36559);
    String str = this.mContext.getString(2131755256);
    AppMethodBeat.o(36559);
    return str;
  }
  
  public final void eZk()
  {
    AppMethodBeat.i(36558);
    this.GFy.eZo();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36551);
        LinkedList localLinkedList = new LinkedList();
        az.arV();
        Cursor localCursor = com.tencent.mm.model.c.apO().dG(f.this.fwd, f.this.fyi);
        if (localCursor == null)
        {
          ad.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36551);
          return;
        }
        com.tencent.mm.storage.w localw;
        long l1;
        if (com.tencent.mm.model.w.pF(f.this.fwd))
        {
          az.arV();
          localw = com.tencent.mm.model.c.apV().tH(f.this.fwd);
          l1 = 0L;
        }
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              bl localbl = new bl();
              localbl.convertFrom(localCursor);
              Object localObject1 = localbl.field_content;
              if (localObject1 == null) {
                continue;
              }
              k.b localb = k.b.rx((String)localObject1);
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
              localObject1 = new Date(localbl.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.fcX().b((Date)localObject1);
              if (l1 != l2)
              {
                localLinkedList.add(new c.c(localbl.field_createTime));
                localObject1 = f.this;
                ((f)localObject1).GFG += 1;
              }
              localObject1 = f.b(localbl, com.tencent.mm.model.w.pF(f.this.fwd));
              af localaf1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY((String)localObject1);
              Object localObject3 = "";
              if (localw != null) {
                localObject3 = localw.sh((String)localObject1);
              }
              i = e.Yv(localb.gHf);
              localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, localb.dxz);
              az.arV();
              af localaf2 = com.tencent.mm.model.c.apM().aHY(localb.dxz);
              if ((localaf2 == null) || (!localaf2.field_username.equals(localb.dxz)))
              {
                ar.a.gMW.a(localb.dxz, "", null);
                localObject3 = new f.a(f.this, localbl.field_createTime, localb.type, localb.title, localbl.field_msgId, localaf1.field_username, localaf1.ZW(), localaf1.field_conRemark, (String)localObject3);
                if (bt.isNullOrNil((String)localObject1))
                {
                  localObject1 = localb.description;
                  ((f.a)localObject3).source = ((String)localObject1);
                  ((f.a)localObject3).appId = localb.appId;
                  ((f.a)localObject3).imagePath = localbl.field_imgPath;
                  ((f.a)localObject3).iconRes = i;
                  localLinkedList.add(localObject3);
                  l1 = l2;
                }
              }
              else
              {
                localObject1 = localaf2.ZX();
                continue;
              }
              continue;
            }
            localCursor.close();
            f.this.hIH.addAll(localLinkedList);
            f.this.GFA = f.this.hIH;
            localLinkedList.clear();
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36550);
                if (f.this.GFy != null) {
                  f.this.GFy.A(f.1.this.nMD, f.this.hIH.size());
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
          localw = null;
          break;
          label571:
          int i = 0;
        }
      }
    });
    AppMethodBeat.o(36558);
  }
  
  public final c.e eZl()
  {
    AppMethodBeat.i(36561);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36554);
        az.arV();
        paramAnonymousb = com.tencent.mm.model.c.apO().rm(paramAnonymousb.msgId);
        k.b localb = k.b.rx(paramAnonymousb.field_content);
        String str1 = q.O(localb.url, "message");
        String str2 = q.O(localb.gHd, "message");
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
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new f.2.1(this), new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36553);
            az.arV();
            bl localbl = com.tencent.mm.model.c.apO().rm(paramAnonymousb.msgId);
            f.this.d(paramAnonymous2MenuItem.getItemId(), localbl);
            AppMethodBeat.o(36553);
          }
        });
        AppMethodBeat.o(36555);
      }
    };
    AppMethodBeat.o(36561);
    return local2;
  }
  
  public final String eZn()
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
  
  public final RecyclerView.v y(ViewGroup paramViewGroup)
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
    
    public final boolean aKD(String paramString)
    {
      AppMethodBeat.i(36556);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aKE(paramString))
        {
          if ((!bt.isNullOrNil(this.source)) && (lq(paramString, this.source.toLowerCase())))
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
        boolean bool = super.aKD(paramString);
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
    TextView hJe;
    ImageView kXS;
    TextView qkL;
    ImageView qkS;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36557);
      this.kXS = ((ImageView)paramView.findViewById(2131299794));
      this.hJe = ((TextView)paramView.findViewById(2131299778));
      this.hJe.setVisibility(8);
      this.qkL = ((TextView)paramView.findViewById(2131299825));
      this.qkS = ((ImageView)paramView.findViewById(2131299798));
      this.qkS.setImageResource(2131233395);
      this.qkS.setVisibility(0);
      AppMethodBeat.o(36557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.f
 * JD-Core Version:    0.7.0.1
 */