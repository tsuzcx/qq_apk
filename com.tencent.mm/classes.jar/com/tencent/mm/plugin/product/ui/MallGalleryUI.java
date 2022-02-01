package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private final String TAG = "MicroMsg.MallGalleryUI";
  private ViewPager wNi;
  private g wNj;
  private List<String> wNk;
  private int wNl = 0;
  private boolean wNm;
  
  final String dzP()
  {
    AppMethodBeat.i(66950);
    if ((this.wNk == null) || (this.wNk.size() < this.wNl + 1)) {
      ad.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; bt.isNullOrNil(str); str = (String)this.wNk.get(this.wNl))
    {
      ad.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(66950);
      return null;
    }
    str = c.auC(str);
    AppMethodBeat.o(66950);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131495115;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66949);
    this.wNi = ((ViewPager)findViewById(2131302011));
    this.wNi.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(66942);
        ad.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        MallGalleryUI.a(MallGalleryUI.this, paramAnonymousInt);
        if (MallGalleryUI.a(MallGalleryUI.this))
        {
          MallGalleryUI.this.hideTitleView();
          MallGalleryUI.b(MallGalleryUI.this);
        }
        AppMethodBeat.o(66942);
      }
    });
    this.wNj = new g(this);
    this.wNj.wNH = new g.a()
    {
      public final void dzQ()
      {
        AppMethodBeat.i(66943);
        MallGalleryUI.c(MallGalleryUI.this);
        AppMethodBeat.o(66943);
      }
    };
    this.wNi.setAdapter(this.wNj);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66944);
        MallGalleryUI.this.finish();
        AppMethodBeat.o(66944);
        return false;
      }
    });
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66946);
        if (d.aIu("favorite")) {}
        for (paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(2130903065);; paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(2130903066))
        {
          h.b(MallGalleryUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
          {
            public final void lf(int paramAnonymous2Int)
            {
              AppMethodBeat.i(66945);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(66945);
                return;
                MallGalleryUI localMallGalleryUI = MallGalleryUI.this;
                Object localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Retr_Msg_content", "");
                ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
                if (!bt.isNullOrNil(localMallGalleryUI.dzP()))
                {
                  ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.dzP());
                  ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
                  ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
                  d.f(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
                  AppMethodBeat.o(66945);
                  return;
                }
                ad.e("MicroMsg.MallGalleryUI", "url is null or nil");
                AppMethodBeat.o(66945);
                return;
                localMallGalleryUI = MallGalleryUI.this;
                localObject1 = localMallGalleryUI.dzP();
                if (!bt.isNullOrNil((String)localObject1))
                {
                  ad.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
                  q.j((String)localObject1, localMallGalleryUI);
                  AppMethodBeat.o(66945);
                  return;
                }
                ad.w("MicroMsg.MallGalleryUI", "save error.");
                AppMethodBeat.o(66945);
                return;
                localMallGalleryUI = MallGalleryUI.this;
                localObject1 = localMallGalleryUI.dzP();
                if (!bt.isNullOrNil((String)localObject1))
                {
                  ad.d("MicroMsg.MallGalleryUI", "file path valid");
                  cv localcv = new cv();
                  if (bt.isNullOrNil((String)localObject1))
                  {
                    ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    localcv.dnG.dnL = 2131758885;
                  }
                  for (;;)
                  {
                    localcv.dnG.dnM = 4;
                    localcv.dnG.activity = localMallGalleryUI;
                    com.tencent.mm.sdk.b.a.IbL.l(localcv);
                    AppMethodBeat.o(66945);
                    return;
                    ad.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
                    akd localakd = new akd();
                    akj localakj = new akj();
                    ajn localajn = new ajn();
                    localajn.ZI(2);
                    localajn.aOt((String)localObject1);
                    localajn.aOs(com.tencent.mm.b.g.getMessageDigest((localajn.toString() + 2 + System.currentTimeMillis()).getBytes()));
                    Object localObject2 = new gw();
                    ((gw)localObject2).dsV.type = 27;
                    ((gw)localObject2).dsV.dsX = localajn;
                    com.tencent.mm.sdk.b.a.IbL.l((b)localObject2);
                    localObject2 = ((gw)localObject2).dsW.thumbPath;
                    com.tencent.mm.sdk.platformtools.g.c((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
                    localajn.aOu((String)localObject2);
                    localakj.aPf(u.aAm());
                    localakj.aPg(u.aAm());
                    localakj.ZR(9);
                    localakj.CM(bt.flT());
                    localakd.a(localakj);
                    localakd.nZa.add(localajn);
                    localcv.dnG.title = localajn.title;
                    localcv.dnG.dnI = localakd;
                    localcv.dnG.type = 2;
                  }
                }
                ad.w("MicroMsg.MallGalleryUI", "file path invalid");
              }
            }
          });
          AppMethodBeat.o(66946);
          return true;
        }
      }
    });
    AppMethodBeat.o(66949);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66947);
    super.onCreate(paramBundle);
    this.wNk = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.wNm = false;
    initView();
    AppMethodBeat.o(66947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66948);
    super.onResume();
    this.wNj.setData(this.wNk);
    this.wNj.notifyDataSetChanged();
    if (this.wNk != null) {
      this.wNk.size();
    }
    AppMethodBeat.o(66948);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI
 * JD-Core Version:    0.7.0.1
 */