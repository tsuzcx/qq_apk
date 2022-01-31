package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.b;
import com.tencent.xweb.WebView.b;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends a
{
  com.tencent.mm.ui.widget.b.d hzQ;
  String igX;
  h iha;
  WebView.b ihb;
  WebView.b ihc;
  private h.c ihh;
  String vcA;
  int vcx;
  int vcy;
  String vcz;
  
  public i(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(7633);
    this.ihh = new h.c()
    {
      public final void Dd(String paramAnonymousString)
      {
        AppMethodBeat.i(7626);
        if (i.this.dds())
        {
          AppMethodBeat.o(7626);
          return;
        }
        try
        {
          if (i.this.ddt().igU != null)
          {
            i.this.ddt().igU.a(paramAnonymousString, null, i.this.ddt().jUm, i.this.ddt().jUn);
            AppMethodBeat.o(7626);
            return;
          }
        }
        catch (RemoteException paramAnonymousString)
        {
          ab.e("MicroMsg.WebViewLongClickHelper", "recog failed");
          AppMethodBeat.o(7626);
          return;
        }
        ab.i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
        AppMethodBeat.o(7626);
      }
    };
    if (ddt().pOd != null) {
      ddt().pOd.setOnLongClickListener(new i.3(this));
    }
    AppMethodBeat.o(7633);
  }
  
  private boolean aik(String paramString)
  {
    AppMethodBeat.i(153209);
    if (dds())
    {
      AppMethodBeat.o(153209);
      return false;
    }
    if (!ddJ())
    {
      AppMethodBeat.o(153209);
      return true;
    }
    if (this.hzQ == null) {
      this.hzQ = new com.tencent.mm.ui.widget.b.d(ddt(), 1, false);
    }
    this.hzQ.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(153199);
        i locali = i.this;
        boolean bool1 = locali.ddK();
        boolean bool2 = locali.ddt().igV.ddW().dqy();
        boolean bool3 = locali.ddt().igV.ddW().dqz();
        ab.i("MicroMsg.WebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        ArrayList localArrayList = new ArrayList();
        if ((bool1) && (bool2)) {
          localArrayList.add(new i.a(1, locali.ddt().getString(2131302282)));
        }
        localArrayList.add(new i.a(2, locali.ddt().getString(2131302871)));
        if ((bool1) && (bool3)) {
          localArrayList.add(new i.a(3, locali.ddt().getString(2131302102)));
        }
        Object localObject1;
        if (locali.igX != null)
        {
          if (com.tencent.mm.plugin.scanner.a.CB(locali.vcx)) {
            break label475;
          }
          if (!com.tencent.mm.plugin.scanner.a.ba(locali.vcx, locali.igX)) {
            break label449;
          }
          localObject1 = locali.ddt().getString(2131302341);
          if (!bo.isNullOrNil((String)localObject1)) {
            localArrayList.add(new i.a(4, (String)localObject1));
          }
        }
        locali.hzQ.setFooterView(null);
        paramAnonymousl.clear();
        int i = 0;
        label276:
        if (i < localArrayList.size())
        {
          localObject1 = (i.a)localArrayList.get(i);
          i.7 local7;
          Object localObject2;
          if (((i.a)localObject1).id == 4)
          {
            com.tencent.mm.ui.widget.b.d locald = locali.hzQ;
            localObject1 = ((i.a)localObject1).title;
            local7 = new i.7(locali);
            if (com.tencent.mm.plugin.scanner.a.ba(locali.vcx, locali.igX))
            {
              localObject2 = new b(locali.ddt());
              if (bo.isNullOrNil(locali.vcz))
              {
                label375:
                ((b)localObject2).setTitle((String)localObject1);
                ((b)localObject2).setSubtitle(locali.ddt().getString(2131302340));
                if (!bo.isNullOrNil(locali.vcA)) {
                  com.tencent.mm.at.a.a.ahM().a(locali.vcA, ((b)localObject2).getIcon());
                }
                ((b)localObject2).setOnClickListener(local7);
                localObject1 = localObject2;
                label435:
                locald.setFooterView((View)localObject1);
              }
            }
          }
          for (;;)
          {
            i += 1;
            break label276;
            label449:
            if (com.tencent.mm.plugin.scanner.a.CA(locali.vcx))
            {
              localObject1 = locali.ddt().getString(2131302335);
              break;
            }
            label475:
            localObject1 = locali.ddt().getString(2131302336);
            break;
            localObject1 = locali.vcz;
            break label375;
            localObject2 = new com.tencent.mm.ui.widget.a.a(locali.ddt());
            ((com.tencent.mm.ui.widget.a.a)localObject2).setTitle((String)localObject1);
            ((com.tencent.mm.ui.widget.a.a)localObject2).setOnClickListener(local7);
            localObject1 = localObject2;
            break label435;
            paramAnonymousl.e(((i.a)localObject1).id, ((i.a)localObject1).title);
          }
        }
        AppMethodBeat.o(153199);
      }
    };
    this.hzQ.sap = new i.5(this, paramString);
    this.hzQ.AGQ = new i.6(this);
    if (!ddt().isFinishing()) {
      this.hzQ.crd();
    }
    boolean bool = this.hzQ.isShowing();
    AppMethodBeat.o(153209);
    return bool;
  }
  
  private boolean dbn()
  {
    boolean bool1 = false;
    AppMethodBeat.i(7635);
    int i = ddt().aio(bo.nullAsNil(ddt().vfr));
    if ((i == 53) || (i == 52))
    {
      ab.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(7635);
      return false;
    }
    try
    {
      if (ddt().igU == null)
      {
        ab.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(7635);
        return false;
      }
      boolean bool2 = ddt().igU.ddm();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(7635);
    return bool1;
  }
  
  final boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(153207);
    boolean bool = aik(paramb.mExtra);
    if ((bo.isNullOrNil(this.igX)) && (ddt().igV.ddW().dqw()) && (dbn()))
    {
      this.ihc = paramb;
      this.iha = new h();
      this.iha.a(ddt().pOd, this.ihh);
    }
    AppMethodBeat.o(153207);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(153208);
    boolean bool = aik(paramb.mExtra);
    if ((bo.isNullOrNil(this.igX)) && (ddt().igV.ddW().dqw()) && (dbn()))
    {
      this.ihb = paramb;
      this.iha = new h();
      this.iha.a(ddt().pOd, this.ihh);
    }
    AppMethodBeat.o(153208);
    return bool;
  }
  
  final void ddI()
  {
    AppMethodBeat.i(153205);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153197);
        if (i.this.ihb != null)
        {
          i.this.b(i.this.ihb);
          AppMethodBeat.o(153197);
          return;
        }
        if (i.this.ihc != null) {
          i.this.a(i.this.ihc);
        }
        AppMethodBeat.o(153197);
      }
    });
    AppMethodBeat.o(153205);
  }
  
  final boolean ddJ()
  {
    AppMethodBeat.i(153210);
    boolean bool1 = false;
    try
    {
      boolean bool2 = ddt().igU.isSDCardAvailable();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + localException.getMessage());
      }
    }
    AppMethodBeat.o(153210);
    return bool1;
  }
  
  final boolean ddK()
  {
    boolean bool1 = false;
    AppMethodBeat.i(153211);
    try
    {
      boolean bool2 = ddt().igU.ddb();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(153211);
    return bool1;
  }
  
  final boolean ev(View paramView)
  {
    AppMethodBeat.i(153206);
    if (dds())
    {
      AppMethodBeat.o(153206);
      return false;
    }
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = ddt().pOd.getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(153206);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          b(paramView);
        }
      }
      catch (Exception paramView)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
        continue;
      }
      AppMethodBeat.o(153206);
      return false;
      if ((paramView instanceof MMWebView))
      {
        paramView = ((MMWebView)paramView).getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(153206);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          a(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */