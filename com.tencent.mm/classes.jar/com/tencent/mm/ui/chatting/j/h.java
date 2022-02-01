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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
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
  int GFG;
  HashSet<Integer> GGb;
  int fyi;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36588);
    this.GGb = new HashSet();
    this.fyi = -1;
    this.GFG = 0;
    AppMethodBeat.o(36588);
  }
  
  private boolean a(bl parambl, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(36596);
    if ((!parambl.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(36596);
      return false;
    }
    ad.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
    parambl = new Intent("android.intent.action.MAIN", null);
    parambl.addCategory("android.intent.category.LAUNCHER");
    parambl.addFlags(268435456);
    parambl.setClassName("com.tencent.mobileqq", aW(this.mContext, "com.tencent.mobileqq"));
    parambl.putExtra("platformId", "wechat");
    az.arV();
    paramg = com.tencent.mm.model.c.afk().get(9, null);
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
        parambl.putExtra("tencent_gif", paramg);
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
            parambl = new com.tencent.mm.hellhoundlib.b.a().bd(parambl);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, parambl.adn(), "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)parambl.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(36596);
            return true;
            paramg = paramg;
            ad.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambl)
        {
          break label304;
        }
      }
    }
  }
  
  private static String aW(Context paramContext, String paramString)
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
        ad.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
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
      AppMethodBeat.o(36598);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36598);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(36595);
    c localc = (c)parama;
    a locala = (a)YJ(paramInt);
    boolean bool;
    if ((bt.isNullOrNil(locala.desc)) || (!bt.isNullOrNil(locala.source)))
    {
      localc.hJe.setVisibility(8);
      Object localObject = o.ayF().a(locala.imagePath, com.tencent.mm.cd.a.getDensity(this.mContext), false);
      if (localObject != null)
      {
        parama = (com.tencent.mm.ui.chatting.a.c.a)localObject;
        if (!((Bitmap)localObject).isRecycled()) {
          break label367;
        }
      }
      parama = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
      if ((locala.GGf == null) || (!locala.GGf.GGg)) {
        break label361;
      }
      bool = true;
      label132:
      localObject = com.tencent.mm.api.b.a(locala.imagePath, 4, bool);
      ad.v("MicroMsg.UrlHistoryListPresenter", "alvinluo fillDetail coverUrl: %s, isBizNativeVideo: %b", new Object[] { localObject, Boolean.valueOf(bool) });
      if ((parama != null) && (!parama.isRecycled())) {
        break label367;
      }
      paramInt = i;
      if (bool) {
        paramInt = 4;
      }
      parama = new com.tencent.mm.aw.a.a.c.a();
      parama.hkf = 2131100141;
      parama.hjT = true;
      parama.gjt = r.aAK((String)localObject);
      com.tencent.mm.aw.a.a.c.a locala1 = parama.de(com.tencent.mm.cd.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 50));
      locala1.hjJ = new n(paramInt);
      locala1.hkr = new com.tencent.mm.pluginsdk.ui.applet.e(paramInt);
      locala1.hjS = true;
      o.ayJ().a((String)localObject, localc.kXS, parama.azc());
    }
    for (;;)
    {
      localc.qkL.setText(bt.by(locala.source, ""));
      c.d(localc.qkL, this.GFz.Gsj);
      AppMethodBeat.o(36595);
      return;
      localc.hJe.setVisibility(0);
      localc.hJe.setText(bt.by(locala.desc, ""));
      break;
      label361:
      bool = false;
      break label132;
      label367:
      localc.kXS.setImageBitmap(parama);
    }
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(36591);
    String str = this.mContext.getString(2131755257);
    AppMethodBeat.o(36591);
    return str;
  }
  
  public final void eZk()
  {
    AppMethodBeat.i(36590);
    this.GFy.eZo();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36581);
        LinkedList localLinkedList = new LinkedList();
        az.arV();
        Cursor localCursor = com.tencent.mm.model.c.apO().dG(h.this.fwd, h.this.fyi);
        if (localCursor == null)
        {
          ad.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36581);
          return;
        }
        com.tencent.mm.storage.w localw;
        long l1;
        if (com.tencent.mm.model.w.pF(h.this.fwd))
        {
          az.arV();
          localw = com.tencent.mm.model.c.apV().tH(h.this.fwd);
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
            localObject1 = h.this;
            int i = localb.type;
            ((h)localObject1).getType();
            if (!((h)localObject1).GGb.contains(Integer.valueOf(i))) {
              continue;
            }
            localObject1 = new Date(localbl.field_createTime);
            long l2 = com.tencent.mm.ui.gridviewheaders.a.fcX().b((Date)localObject1);
            if (l1 != l2)
            {
              localLinkedList.add(new c.c(localbl.field_createTime));
              localObject1 = h.this;
              ((h)localObject1).GFG += 1;
            }
            localObject1 = h.b(localbl, com.tencent.mm.model.w.pF(h.this.fwd));
            Object localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY((String)localObject1);
            Object localObject3 = "";
            if (localw != null) {
              localObject3 = localw.sh((String)localObject1);
            }
            i = com.tencent.mm.plugin.fav.ui.e.Yv(localb.gHf);
            localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(h.this.mContext, localb.dxz);
            az.arV();
            Object localObject5 = com.tencent.mm.model.c.apM().aHY(localb.dxz);
            if ((localObject5 == null) || (!((au)localObject5).field_username.equals(localb.dxz)))
            {
              ar.a.gMW.a(localb.dxz, "", null);
              localObject3 = new h.a(h.this, localbl.field_createTime, localb.type, localb.title, localbl.field_msgId, ((au)localObject4).field_username, ((af)localObject4).ZW(), ((au)localObject4).field_conRemark, (String)localObject3);
              if (localb.type == 5)
              {
                ad.i("MicroMsg.UrlHistoryListPresenter", "alvinluo loadData type: %d", new Object[] { Integer.valueOf(localb.type) });
                localObject4 = new h.b(h.this);
                localObject5 = (com.tencent.mm.ai.e)localb.ao(com.tencent.mm.ai.e.class);
                if ((localObject5 == null) || (((com.tencent.mm.ai.e)localObject5).gGz != 1) || (((com.tencent.mm.ai.e)localObject5).gGx != 5)) {
                  break label810;
                }
                bool = true;
                ((h.b)localObject4).GGg = bool;
                ((h.a)localObject3).GGf = ((h.b)localObject4);
              }
              if (!bt.isNullOrNil((String)localObject1)) {
                break label816;
              }
              localObject1 = localb.description;
              ((h.a)localObject3).source = ((String)localObject1);
              ((h.a)localObject3).appId = localb.appId;
              if (bt.isNullOrNil(localbl.field_imgPath))
              {
                ((h.a)localObject3).imagePath = localb.thumburl;
                ((h.a)localObject3).iconRes = i;
                if (localb.type == 51)
                {
                  localObject1 = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
                  ((h.a)localObject3).title = h.this.mContext.getString(2131759701, new Object[] { ((com.tencent.mm.plugin.i.a.b)localObject1).htg.nickname });
                  if (((com.tencent.mm.plugin.i.a.b)localObject1).htg.mediaList.size() <= 0) {
                    break label738;
                  }
                  ((h.a)localObject3).imagePath = ((alc)((com.tencent.mm.plugin.i.a.b)localObject1).htg.mediaList.getFirst()).thumbUrl;
                }
                localLinkedList.add(localObject3);
                l1 = l2;
              }
            }
            else
            {
              localObject1 = ((af)localObject5).ZX();
              continue;
            }
            ((h.a)localObject3).imagePath = localbl.field_imgPath;
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
          h.this.hIH.addAll(localLinkedList);
          h.this.GFA = h.this.hIH;
          localLinkedList.clear();
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36580);
              if (h.this.GFy != null) {
                h.this.GFy.A(h.1.this.nMD, h.this.hIH.size());
              }
              AppMethodBeat.o(36580);
            }
          });
          AppMethodBeat.o(36581);
          return;
          localw = null;
          break;
          boolean bool = false;
        }
      }
    });
    AppMethodBeat.o(36590);
  }
  
  public final c.e eZl()
  {
    AppMethodBeat.i(36593);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36584);
        ad.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousb == null)
        {
          ad.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
        ad.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[] { Integer.valueOf(paramAnonymousb.getType()) });
        AppMethodBeat.o(36584);
      }
      
      public final void b(View paramAnonymousView, final int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36585);
        ad.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              ad.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
              AppMethodBeat.o(36583);
              return;
            }
            az.arV();
            paramAnonymous2MenuItem = com.tencent.mm.model.c.apO().rm(paramAnonymousb.msgId);
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
  
  public final String eZn()
  {
    AppMethodBeat.i(36592);
    String str = this.mContext.getString(2131755257);
    AppMethodBeat.o(36592);
    return str;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(36589);
    this.GGb.add(Integer.valueOf(5));
    this.GGb.add(Integer.valueOf(7));
    this.GGb.add(Integer.valueOf(27));
    this.GGb.add(Integer.valueOf(26));
    this.GGb.add(Integer.valueOf(15));
    this.GGb.add(Integer.valueOf(51));
    AppMethodBeat.o(36589);
    return -1;
  }
  
  public final RecyclerView.v y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36594);
    paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495821, paramViewGroup, false));
    AppMethodBeat.o(36594);
    return paramViewGroup;
  }
  
  final class a
    extends c.b
  {
    public h.b GGf = null;
    public String appId;
    public String desc;
    public int iconRes;
    public String imagePath;
    public String source;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean aKD(String paramString)
    {
      AppMethodBeat.i(36586);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aKE(paramString))
        {
          if ((!bt.isNullOrNil(this.source)) && (lq(paramString, this.source.toLowerCase())))
          {
            AppMethodBeat.o(36586);
            return true;
          }
        }
        else if ((!bt.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36586);
          return true;
        }
        boolean bool = super.aKD(paramString);
        AppMethodBeat.o(36586);
        return bool;
      }
      AppMethodBeat.o(36586);
      return false;
    }
  }
  
  final class b
  {
    public boolean GGg = false;
    
    b() {}
  }
  
  final class c
    extends com.tencent.mm.ui.chatting.a.c.a
  {
    TextView hJe;
    ImageView kXS;
    TextView qkL;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(36587);
      this.kXS = ((ImageView)paramView.findViewById(2131299794));
      this.hJe = ((TextView)paramView.findViewById(2131299778));
      this.qkL = ((TextView)paramView.findViewById(2131299825));
      this.qkL.setVisibility(0);
      AppMethodBeat.o(36587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.h
 * JD-Core Version:    0.7.0.1
 */