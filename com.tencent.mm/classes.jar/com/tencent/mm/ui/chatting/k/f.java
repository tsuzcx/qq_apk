package com.tencent.mm.ui.chatting.k;

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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o.g;
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
  int PEu = 0;
  int gCo = -1;
  private int tkX = 0;
  
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
      AppMethodBeat.o(36565);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36565);
    }
    return null;
  }
  
  public final RecyclerView.v N(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36562);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496784, paramViewGroup, false));
    AppMethodBeat.o(36562);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36563);
    b localb = (b)parama;
    a locala = (a)amy(paramInt);
    localb.timeTV.setText(m.h(this.mContext, locala.timestamp));
    Bitmap localBitmap = com.tencent.mm.av.q.bcR().a(locala.imagePath, com.tencent.mm.cb.a.getDensity(this.mContext), false);
    if (localBitmap != null)
    {
      parama = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = h.c(locala.appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localb.nnL.setImageResource(2131689587);
      }
    }
    for (;;)
    {
      localb.tln.setText(Util.nullAs(locala.source, ""));
      b.g(localb.tln, this.PEn.Pmg);
      AppMethodBeat.o(36563);
      return;
      localb.nnL.setImageBitmap(parama);
    }
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong1, long paramLong2, ca paramca)
  {
    AppMethodBeat.i(36564);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
      AppMethodBeat.o(36564);
      return;
    }
    String str;
    if (NetStatusUtil.isMobile(this.mContext))
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
      paramString1.putExtra("geta8key_username", this.gAn);
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString2 = b(paramca, ab.Eq(this.gAn));
      paramString1.putExtra("pre_username", paramString2);
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (paramca != null) {
        paramString1.putExtra("preUsername", paramString2);
      }
      paramString1.putExtra("preChatName", this.gAn);
      paramString1.putExtra("preChatTYPE", ac.aJ(paramString2, this.gAn));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.br.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramString1);
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
  
  public final String bmB()
  {
    AppMethodBeat.i(36559);
    String str = this.mContext.getString(2131755291);
    AppMethodBeat.o(36559);
    return str;
  }
  
  public final void gRY()
  {
    AppMethodBeat.i(36558);
    this.PEm.gSc();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36551);
        LinkedList localLinkedList = new LinkedList();
        bg.aVF();
        Cursor localCursor = com.tencent.mm.model.c.aSQ().ez(f.this.gAn, f.this.gCo);
        if (localCursor == null)
        {
          Log.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36551);
          return;
        }
        ah localah;
        long l1;
        if (ab.Eq(f.this.gAn))
        {
          bg.aVF();
          localah = com.tencent.mm.model.c.aSX().Kd(f.this.gAn);
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
              k.b localb = k.b.HD((String)localObject1);
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
              localObject1 = new Date(localca.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b((Date)localObject1);
              if (l1 != l2)
              {
                localLinkedList.add(new c.c(localca.field_createTime));
                localObject1 = f.this;
                ((f)localObject1).PEu += 1;
              }
              localObject1 = f.b(localca, ab.Eq(f.this.gAn));
              as localas1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject1);
              Object localObject3 = "";
              if (localah != null) {
                localObject3 = localah.getDisplayName((String)localObject1);
              }
              i = e.asl(localb.iwJ);
              localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, localb.eag);
              bg.aVF();
              as localas2 = com.tencent.mm.model.c.aSN().Kn(localb.eag);
              if ((localas2 == null) || (!localas2.field_username.equals(localb.eag)))
              {
                ay.a.iDq.a(localb.eag, "", null);
                localObject3 = new f.a(f.this, localca.field_createTime, localb.type, localb.title, localca.field_msgId, localas1.field_username, localas1.arI(), localas1.field_conRemark, (String)localObject3);
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
                localObject1 = localas2.arJ();
                continue;
              }
              continue;
            }
            localCursor.close();
            f.this.mDataList.addAll(localLinkedList);
            f.this.PEo = f.this.mDataList;
            localLinkedList.clear();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36550);
                if (f.this.PEm != null) {
                  f.this.PEm.D(f.1.this.qoy, f.this.mDataList.size());
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
          label571:
          int i = 0;
        }
      }
    });
    AppMethodBeat.o(36558);
  }
  
  public final c.e gRZ()
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
        bg.aVF();
        paramAnonymousb = com.tencent.mm.model.c.aSQ().Hb(paramAnonymousb.msgId);
        k.b localb = k.b.HD(paramAnonymousb.field_content);
        String str1 = com.tencent.mm.pluginsdk.model.app.q.R(localb.url, "message");
        String str2 = com.tencent.mm.pluginsdk.model.app.q.R(localb.iwH, "message");
        PackageInfo localPackageInfo = f.getPackageInfo(f.this.mContext, localb.appId);
        f localf = f.this;
        if (localPackageInfo == null)
        {
          paramAnonymousView = null;
          if (localPackageInfo != null) {
            break label151;
          }
        }
        label151:
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
        Log.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext()).b(paramAnonymousView, new f.2.1(this), new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36553);
            bg.aVF();
            ca localca = com.tencent.mm.model.c.aSQ().Hb(paramAnonymousb.msgId);
            f.this.d(paramAnonymous2MenuItem.getItemId(), localca);
            AppMethodBeat.o(36553);
          }
        });
        AppMethodBeat.o(36555);
      }
    };
    AppMethodBeat.o(36561);
    return local2;
  }
  
  public final String gSb()
  {
    AppMethodBeat.i(36560);
    String str = this.mContext.getString(2131755291);
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
    
    public final boolean bmC(String paramString)
    {
      AppMethodBeat.i(36556);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bmD(paramString))
        {
          if ((!Util.isNullOrNil(this.source)) && (ng(paramString, this.source.toLowerCase())))
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
        boolean bool = super.bmC(paramString);
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
    TextView jBR;
    ImageView nnL;
    TextView tln;
    ImageView tlu;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36557);
      this.nnL = ((ImageView)paramView.findViewById(2131300468));
      this.jBR = ((TextView)paramView.findViewById(2131300451));
      this.jBR.setVisibility(8);
      this.tln = ((TextView)paramView.findViewById(2131300503));
      this.tlu = ((ImageView)paramView.findViewById(2131300473));
      this.tlu.setImageResource(2131234185);
      this.tlu.setVisibility(0);
      AppMethodBeat.o(36557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.f
 * JD-Core Version:    0.7.0.1
 */