package com.tencent.mm.ui.chatting.k;

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
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f.b.b;
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
  HashSet<Integer> KsB;
  int Ksh;
  int fXi;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36588);
    this.KsB = new HashSet();
    this.fXi = -1;
    this.Ksh = 0;
    AppMethodBeat.o(36588);
  }
  
  private boolean a(bv parambv, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(36596);
    if ((!parambv.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(36596);
      return false;
    }
    ae.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
    parambv = new Intent("android.intent.action.MAIN", null);
    parambv.addCategory("android.intent.category.LAUNCHER");
    parambv.addFlags(268435456);
    parambv.setClassName("com.tencent.mobileqq", bc(this.mContext, "com.tencent.mobileqq"));
    parambv.putExtra("platformId", "wechat");
    bc.aCg();
    paramg = com.tencent.mm.model.c.ajA().get(9, null);
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
        parambv.putExtra("tencent_gif", paramg);
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
            parambv = new com.tencent.mm.hellhoundlib.b.a().bc(parambv);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, parambv.ahE(), "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)parambv.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(36596);
            return true;
            paramg = paramg;
            ae.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambv)
        {
          break label304;
        }
      }
    }
  }
  
  private static String bc(Context paramContext, String paramString)
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
        ae.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.m(paramString, true, false);
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
      ae.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36598);
    }
    return null;
  }
  
  public final RecyclerView.w D(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36594);
    paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495821, paramViewGroup, false));
    AppMethodBeat.o(36594);
    return paramViewGroup;
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(36595);
    c localc = (c)parama;
    a locala = (a)adN(paramInt);
    boolean bool;
    if ((bu.isNullOrNil(locala.desc)) || (!bu.isNullOrNil(locala.source)))
    {
      localc.iFO.setVisibility(8);
      Object localObject = q.aIX().a(locala.imagePath, com.tencent.mm.cb.a.getDensity(this.mContext), false);
      if (localObject != null)
      {
        parama = (com.tencent.mm.ui.chatting.a.c.a)localObject;
        if (!((Bitmap)localObject).isRecycled()) {
          break label367;
        }
      }
      parama = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      if ((locala.KsF == null) || (!locala.KsF.KsG)) {
        break label361;
      }
      bool = true;
      label132:
      localObject = com.tencent.mm.api.b.a(locala.imagePath, 4, bool);
      ae.v("MicroMsg.UrlHistoryListPresenter", "alvinluo fillDetail coverUrl: %s, isBizNativeVideo: %b", new Object[] { localObject, Boolean.valueOf(bool) });
      if ((parama != null) && (!parama.isRecycled())) {
        break label367;
      }
      paramInt = i;
      if (bool) {
        paramInt = 4;
      }
      parama = new com.tencent.mm.av.a.a.c.a();
      parama.igv = 2131100141;
      parama.igj = true;
      parama.hgD = r.aMY((String)localObject);
      com.tencent.mm.av.a.a.c.a locala1 = parama.dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50));
      locala1.ifZ = new n(paramInt);
      locala1.igH = new com.tencent.mm.pluginsdk.ui.applet.e(paramInt);
      locala1.igi = true;
      q.aJb().a((String)localObject, localc.mdt, parama.aJu());
    }
    for (;;)
    {
      localc.rLB.setText(bu.bI(locala.source, ""));
      c.e(localc.rLB, this.Ksa.KaK);
      AppMethodBeat.o(36595);
      return;
      localc.iFO.setVisibility(0);
      localc.iFO.setText(bu.bI(locala.desc, ""));
      break;
      label361:
      bool = false;
      break label132;
      label367:
      localc.mdt.setImageBitmap(parama);
    }
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(36591);
    String str = this.mContext.getString(2131755257);
    AppMethodBeat.o(36591);
    return str;
  }
  
  public final void fJL()
  {
    AppMethodBeat.i(36590);
    this.KrZ.fJP();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36581);
        LinkedList localLinkedList = new LinkedList();
        bc.aCg();
        Cursor localCursor = com.tencent.mm.model.c.azI().el(h.this.fVg, h.this.fXi);
        if (localCursor == null)
        {
          ae.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36581);
          return;
        }
        ac localac;
        long l1;
        if (x.wb(h.this.fVg))
        {
          bc.aCg();
          localac = com.tencent.mm.model.c.azP().Bx(h.this.fVg);
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
            bv localbv = new bv();
            localbv.convertFrom(localCursor);
            Object localObject1 = localbv.field_content;
            if (localObject1 == null) {
              continue;
            }
            k.b localb = k.b.zb((String)localObject1);
            if (localb == null) {
              continue;
            }
            localObject1 = h.this;
            int i = localb.type;
            ((h)localObject1).getType();
            if (!((h)localObject1).KsB.contains(Integer.valueOf(i))) {
              continue;
            }
            localObject1 = new Date(localbv.field_createTime);
            long l2 = com.tencent.mm.ui.gridviewheaders.a.fNX().b((Date)localObject1);
            if (l1 != l2)
            {
              localLinkedList.add(new c.c(localbv.field_createTime));
              localObject1 = h.this;
              ((h)localObject1).Ksh += 1;
            }
            localObject1 = h.b(localbv, x.wb(h.this.fVg));
            Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH((String)localObject1);
            Object localObject3 = "";
            if (localac != null) {
              localObject3 = localac.zP((String)localObject1);
            }
            i = com.tencent.mm.plugin.fav.ui.e.ahD(localb.hCD);
            localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(h.this.mContext, localb.dIt);
            bc.aCg();
            Object localObject5 = com.tencent.mm.model.c.azF().BH(localb.dIt);
            if ((localObject5 == null) || (!((aw)localObject5).field_username.equals(localb.dIt)))
            {
              au.a.hIG.a(localb.dIt, "", null);
              localObject3 = new h.a(h.this, localbv.field_createTime, localb.type, localb.title, localbv.field_msgId, ((aw)localObject4).field_username, ((an)localObject4).adF(), ((aw)localObject4).field_conRemark, (String)localObject3);
              if (localb.type == 5)
              {
                ae.i("MicroMsg.UrlHistoryListPresenter", "alvinluo loadData type: %d", new Object[] { Integer.valueOf(localb.type) });
                localObject4 = new h.b(h.this);
                localObject5 = (com.tencent.mm.ah.e)localb.ao(com.tencent.mm.ah.e.class);
                if ((localObject5 == null) || (((com.tencent.mm.ah.e)localObject5).hBX != 1) || (((com.tencent.mm.ah.e)localObject5).hBV != 5)) {
                  break label810;
                }
                bool = true;
                ((h.b)localObject4).KsG = bool;
                ((h.a)localObject3).KsF = ((h.b)localObject4);
              }
              if (!bu.isNullOrNil((String)localObject1)) {
                break label816;
              }
              localObject1 = localb.description;
              ((h.a)localObject3).source = ((String)localObject1);
              ((h.a)localObject3).appId = localb.appId;
              if (bu.isNullOrNil(localbv.field_imgPath))
              {
                ((h.a)localObject3).imagePath = localb.thumburl;
                ((h.a)localObject3).iconRes = i;
                if (localb.type == 51)
                {
                  localObject1 = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
                  ((h.a)localObject3).title = h.this.mContext.getString(2131759701, new Object[] { ((com.tencent.mm.plugin.i.a.b)localObject1).ipW.nickname });
                  if (((com.tencent.mm.plugin.i.a.b)localObject1).ipW.mediaList.size() <= 0) {
                    break label738;
                  }
                  ((h.a)localObject3).imagePath = ((arx)((com.tencent.mm.plugin.i.a.b)localObject1).ipW.mediaList.getFirst()).thumbUrl;
                }
                localLinkedList.add(localObject3);
                l1 = l2;
              }
            }
            else
            {
              localObject1 = ((an)localObject5).adG();
              continue;
            }
            ((h.a)localObject3).imagePath = localbv.field_imgPath;
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
          h.this.mDataList.addAll(localLinkedList);
          h.this.Ksb = h.this.mDataList;
          localLinkedList.clear();
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36580);
              if (h.this.KrZ != null) {
                h.this.KrZ.C(h.1.this.oZA, h.this.mDataList.size());
              }
              AppMethodBeat.o(36580);
            }
          });
          AppMethodBeat.o(36581);
          return;
          localac = null;
          break;
          boolean bool = false;
        }
      }
    });
    AppMethodBeat.o(36590);
  }
  
  public final c.e fJM()
  {
    AppMethodBeat.i(36593);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36584);
        ae.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousb == null)
        {
          ae.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
        ae.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[] { Integer.valueOf(paramAnonymousb.getType()) });
        AppMethodBeat.o(36584);
      }
      
      public final void b(View paramAnonymousView, final int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36585);
        ae.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36582);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(2131762566));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(2131757157));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(2131757221));
            AppMethodBeat.o(36582);
          }
        }, new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36583);
            if (paramAnonymousb == null)
            {
              ae.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
              AppMethodBeat.o(36583);
              return;
            }
            bc.aCg();
            paramAnonymous2MenuItem = com.tencent.mm.model.c.azI().ys(paramAnonymousb.msgId);
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
  
  public final String fJO()
  {
    AppMethodBeat.i(36592);
    String str = this.mContext.getString(2131755257);
    AppMethodBeat.o(36592);
    return str;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(36589);
    this.KsB.add(Integer.valueOf(5));
    this.KsB.add(Integer.valueOf(7));
    this.KsB.add(Integer.valueOf(27));
    this.KsB.add(Integer.valueOf(26));
    this.KsB.add(Integer.valueOf(15));
    this.KsB.add(Integer.valueOf(51));
    AppMethodBeat.o(36589);
    return -1;
  }
  
  final class a
    extends c.b
  {
    public h.b KsF = null;
    public String appId;
    public String desc;
    public int iconRes;
    public String imagePath;
    public String source;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean aXy(String paramString)
    {
      AppMethodBeat.i(36586);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!aXz(paramString))
        {
          if ((!bu.isNullOrNil(this.source)) && (ms(paramString, this.source.toLowerCase())))
          {
            AppMethodBeat.o(36586);
            return true;
          }
        }
        else if ((!bu.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36586);
          return true;
        }
        boolean bool = super.aXy(paramString);
        AppMethodBeat.o(36586);
        return bool;
      }
      AppMethodBeat.o(36586);
      return false;
    }
  }
  
  final class b
  {
    public boolean KsG = false;
    
    b() {}
  }
  
  final class c
    extends com.tencent.mm.ui.chatting.a.c.a
  {
    TextView iFO;
    ImageView mdt;
    TextView rLB;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(36587);
      this.mdt = ((ImageView)paramView.findViewById(2131299794));
      this.iFO = ((TextView)paramView.findViewById(2131299778));
      this.rLB = ((TextView)paramView.findViewById(2131299825));
      this.rLB.setVisibility(0);
      AppMethodBeat.o(36587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.h
 * JD-Core Version:    0.7.0.1
 */