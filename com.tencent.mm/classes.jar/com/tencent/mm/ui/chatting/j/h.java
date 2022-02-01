package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
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
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.tools.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  int IfC;
  HashSet<Integer> IfX;
  int fBP;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36588);
    this.IfX = new HashSet();
    this.fBP = -1;
    this.IfC = 0;
    AppMethodBeat.o(36588);
  }
  
  private boolean a(bo parambo, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(36596);
    if ((!parambo.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(36596);
      return false;
    }
    ac.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
    parambo = new Intent("android.intent.action.MAIN", null);
    parambo.addCategory("android.intent.category.LAUNCHER");
    parambo.addFlags(268435456);
    parambo.setClassName("com.tencent.mobileqq", aX(this.mContext, "com.tencent.mobileqq"));
    parambo.putExtra("platformId", "wechat");
    az.ayM();
    paramg = com.tencent.mm.model.c.agA().get(9, null);
    int i;
    if ((paramg != null) && ((paramg instanceof Integer))) {
      i = ((Integer)paramg).intValue();
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramg = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int k = arrayOfByte.length;
        int j = 0;
        i = 0;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if (i >= paramg.length) {
            break;
          }
          paramg[i] = ((byte)(m ^ paramg[i]));
          j += 1;
          i += 1;
        }
        parambo.putExtra("tencent_gif", paramg);
        label304:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.mContext;
            parambo = new com.tencent.mm.hellhoundlib.b.a().ba(parambo);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, parambo.aeD(), "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)parambo.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(36596);
            return true;
            paramg = paramg;
            ac.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambo)
        {
          break label304;
        }
      }
    }
  }
  
  private static String aX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(36597);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label101;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(36597);
    return paramContext;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(36598);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(36598);
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
      AppMethodBeat.o(36598);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ac.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36598);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(36595);
    c localc = (c)parama;
    a locala = (a)aaU(paramInt);
    boolean bool;
    if ((bs.isNullOrNil(locala.desc)) || (!bs.isNullOrNil(locala.source)))
    {
      localc.ijE.setVisibility(8);
      Object localObject = o.aFx().a(locala.imagePath, com.tencent.mm.cc.a.getDensity(this.mContext), false);
      if (localObject != null)
      {
        parama = (com.tencent.mm.ui.chatting.a.c.a)localObject;
        if (!((Bitmap)localObject).isRecycled()) {
          break label367;
        }
      }
      parama = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
      if ((locala.Igb == null) || (!locala.Igb.Igc)) {
        break label361;
      }
      bool = true;
      label132:
      localObject = com.tencent.mm.api.b.a(locala.imagePath, 4, bool);
      ac.v("MicroMsg.UrlHistoryListPresenter", "alvinluo fillDetail coverUrl: %s, isBizNativeVideo: %b", new Object[] { localObject, Boolean.valueOf(bool) });
      if ((parama != null) && (!parama.isRecycled())) {
        break label367;
      }
      paramInt = i;
      if (bool) {
        paramInt = 4;
      }
      parama = new com.tencent.mm.av.a.a.c.a();
      parama.hKI = 2131100141;
      parama.hKw = true;
      parama.gKe = r.aGc((String)localObject);
      com.tencent.mm.av.a.a.c.a locala1 = parama.de(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50));
      locala1.hKm = new n(paramInt);
      locala1.hKU = new com.tencent.mm.pluginsdk.ui.applet.e(paramInt);
      locala1.hKv = true;
      o.aFB().a((String)localObject, localc.lzC, parama.aFT());
    }
    for (;;)
    {
      localc.qTn.setText(bs.bG(locala.source, ""));
      c.d(localc.qTn, this.Ifv.HSb);
      AppMethodBeat.o(36595);
      return;
      localc.ijE.setVisibility(0);
      localc.ijE.setText(bs.bG(locala.desc, ""));
      break;
      label361:
      bool = false;
      break label132;
      label367:
      localc.lzC.setImageBitmap(parama);
    }
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(36591);
    String str = this.mContext.getString(2131755257);
    AppMethodBeat.o(36591);
    return str;
  }
  
  public final void foZ()
  {
    AppMethodBeat.i(36590);
    this.Ifu.fpd();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36581);
        LinkedList localLinkedList = new LinkedList();
        az.ayM();
        Cursor localCursor = com.tencent.mm.model.c.awD().dN(h.this.fzK, h.this.fBP);
        if (localCursor == null)
        {
          ac.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36581);
          return;
        }
        x localx;
        long l1;
        if (w.sQ(h.this.fzK))
        {
          az.ayM();
          localx = com.tencent.mm.model.c.awK().xN(h.this.fzK);
          l1 = 0L;
        }
        label810:
        label816:
        for (;;)
        {
          try
          {
            if (!localCursor.moveToNext()) {
              break label748;
            }
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
            localObject1 = h.this;
            int i = localb.type;
            ((h)localObject1).getType();
            if (!((h)localObject1).IfX.contains(Integer.valueOf(i))) {
              continue;
            }
            localObject1 = new Date(localbo.field_createTime);
            long l2 = com.tencent.mm.ui.gridviewheaders.a.fsS().b((Date)localObject1);
            if (l1 != l2)
            {
              localLinkedList.add(new c.c(localbo.field_createTime));
              localObject1 = h.this;
              ((h)localObject1).IfC += 1;
            }
            localObject1 = h.b(localbo, w.sQ(h.this.fzK));
            Object localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt((String)localObject1);
            Object localObject3 = "";
            if (localx != null) {
              localObject3 = localx.wk((String)localObject1);
            }
            i = com.tencent.mm.plugin.fav.ui.e.acR(localb.hhG);
            localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(h.this.mContext, localb.dvl);
            az.ayM();
            Object localObject5 = com.tencent.mm.model.c.awB().aNt(localb.dvl);
            if ((localObject5 == null) || (!((av)localObject5).field_username.equals(localb.dvl)))
            {
              ar.a.hnw.a(localb.dvl, "", null);
              localObject3 = new h.a(h.this, localbo.field_createTime, localb.type, localb.title, localbo.field_msgId, ((av)localObject4).field_username, ((com.tencent.mm.storage.ai)localObject4).aaR(), ((av)localObject4).field_conRemark, (String)localObject3);
              if (localb.type == 5)
              {
                ac.i("MicroMsg.UrlHistoryListPresenter", "alvinluo loadData type: %d", new Object[] { Integer.valueOf(localb.type) });
                localObject4 = new h.b(h.this);
                localObject5 = (com.tencent.mm.ah.e)localb.ao(com.tencent.mm.ah.e.class);
                if ((localObject5 == null) || (((com.tencent.mm.ah.e)localObject5).hha != 1) || (((com.tencent.mm.ah.e)localObject5).hgY != 5)) {
                  break label810;
                }
                bool = true;
                ((h.b)localObject4).Igc = bool;
                ((h.a)localObject3).Igb = ((h.b)localObject4);
              }
              if (!bs.isNullOrNil((String)localObject1)) {
                break label816;
              }
              localObject1 = localb.description;
              ((h.a)localObject3).source = ((String)localObject1);
              ((h.a)localObject3).appId = localb.appId;
              if (bs.isNullOrNil(localbo.field_imgPath))
              {
                ((h.a)localObject3).imagePath = localb.thumburl;
                ((h.a)localObject3).iconRes = i;
                if (localb.type == 51)
                {
                  localObject1 = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
                  ((h.a)localObject3).title = h.this.mContext.getString(2131759701, new Object[] { ((com.tencent.mm.plugin.i.a.b)localObject1).hTI.nickname });
                  if (((com.tencent.mm.plugin.i.a.b)localObject1).hTI.mediaList.size() <= 0) {
                    break label738;
                  }
                  ((h.a)localObject3).imagePath = ((anw)((com.tencent.mm.plugin.i.a.b)localObject1).hTI.mediaList.getFirst()).thumbUrl;
                }
                localLinkedList.add(localObject3);
                l1 = l2;
              }
            }
            else
            {
              localObject1 = ((com.tencent.mm.storage.ai)localObject5).aaS();
              continue;
            }
            ((h.a)localObject3).imagePath = localbo.field_imgPath;
            continue;
            ((h.a)localObject3).imagePath = "";
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(36581);
          }
          label738:
          continue;
          label748:
          localCursor.close();
          h.this.ijj.addAll(localLinkedList);
          h.this.Ifw = h.this.ijj;
          localLinkedList.clear();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36580);
              if (h.this.Ifu != null) {
                h.this.Ifu.B(h.1.this.opD, h.this.ijj.size());
              }
              AppMethodBeat.o(36580);
            }
          });
          AppMethodBeat.o(36581);
          return;
          localx = null;
          break;
          boolean bool = false;
        }
      }
    });
    AppMethodBeat.o(36590);
  }
  
  public final c.e fpa()
  {
    AppMethodBeat.i(36593);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36584);
        ac.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousb == null)
        {
          ac.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(36584);
          return;
        }
        paramAnonymousb = (h.a)paramAnonymousb;
        if (paramAnonymousb.getType() == 5)
        {
          h.a(h.this, paramAnonymousView, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 7)
        {
          h.a(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 15)
        {
          h.b(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 26)
        {
          h.c(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 27)
        {
          h.d(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 51)
        {
          h.e(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        ac.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[] { Integer.valueOf(paramAnonymousb.getType()) });
        AppMethodBeat.o(36584);
      }
      
      public final void b(View paramAnonymousView, final int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36585);
        ac.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36582);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(2131757157));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(2131757221));
            AppMethodBeat.o(36582);
          }
        }, new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36583);
            if (paramAnonymousb == null)
            {
              ac.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
              AppMethodBeat.o(36583);
              return;
            }
            az.ayM();
            paramAnonymous2MenuItem = com.tencent.mm.model.c.awD().vP(paramAnonymousb.msgId);
            h.this.d(paramAnonymous2Int, paramAnonymous2MenuItem);
            AppMethodBeat.o(36583);
          }
        });
        AppMethodBeat.o(36585);
      }
    };
    AppMethodBeat.o(36593);
    return local2;
  }
  
  public final String fpc()
  {
    AppMethodBeat.i(36592);
    String str = this.mContext.getString(2131755257);
    AppMethodBeat.o(36592);
    return str;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(36589);
    this.IfX.add(Integer.valueOf(5));
    this.IfX.add(Integer.valueOf(7));
    this.IfX.add(Integer.valueOf(27));
    this.IfX.add(Integer.valueOf(26));
    this.IfX.add(Integer.valueOf(15));
    this.IfX.add(Integer.valueOf(51));
    AppMethodBeat.o(36589);
    return -1;
  }
  
  public final RecyclerView.w z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36594);
    paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495821, paramViewGroup, false));
    AppMethodBeat.o(36594);
    return paramViewGroup;
  }
  
  final class a
    extends c.b
  {
    public h.b Igb = null;
    public String appId;
    public String desc;
    public int iconRes;
    public String imagePath;
    public String source;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean aQg(String paramString)
    {
      AppMethodBeat.i(36586);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aQh(paramString))
        {
          if ((!bs.isNullOrNil(this.source)) && (lN(paramString, this.source.toLowerCase())))
          {
            AppMethodBeat.o(36586);
            return true;
          }
        }
        else if ((!bs.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36586);
          return true;
        }
        boolean bool = super.aQg(paramString);
        AppMethodBeat.o(36586);
        return bool;
      }
      AppMethodBeat.o(36586);
      return false;
    }
  }
  
  final class b
  {
    public boolean Igc = false;
    
    b() {}
  }
  
  final class c
    extends com.tencent.mm.ui.chatting.a.c.a
  {
    TextView ijE;
    ImageView lzC;
    TextView qTn;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(36587);
      this.lzC = ((ImageView)paramView.findViewById(2131299794));
      this.ijE = ((TextView)paramView.findViewById(2131299778));
      this.qTn = ((TextView)paramView.findViewById(2131299825));
      this.qTn.setVisibility(0);
      AppMethodBeat.o(36587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.h
 * JD-Core Version:    0.7.0.1
 */