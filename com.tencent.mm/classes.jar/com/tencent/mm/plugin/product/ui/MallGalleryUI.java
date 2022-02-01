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
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private final String TAG = "MicroMsg.MallGalleryUI";
  private ViewPager uxj;
  private g uxk;
  private List<String> uxl;
  private int uxm = 0;
  private boolean uxn;
  
  final String dbF()
  {
    AppMethodBeat.i(66950);
    if ((this.uxl == null) || (this.uxl.size() < this.uxm + 1)) {
      ad.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; bt.isNullOrNil(str); str = (String)this.uxl.get(this.uxm))
    {
      ad.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(66950);
      return null;
    }
    str = c.akx(str);
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
    this.uxj = ((ViewPager)findViewById(2131302011));
    this.uxj.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    this.uxk = new g(this);
    this.uxk.uxH = new g.a()
    {
      public final void dbG()
      {
        AppMethodBeat.i(66943);
        MallGalleryUI.c(MallGalleryUI.this);
        AppMethodBeat.o(66943);
      }
    };
    this.uxj.setAdapter(this.uxk);
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
        if (d.axB("favorite")) {}
        for (paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(2130903065);; paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(2130903066))
        {
          h.b(MallGalleryUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
          {
            public final void kM(int paramAnonymous2Int)
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
                if (!bt.isNullOrNil(localMallGalleryUI.dbF()))
                {
                  ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.dbF());
                  ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
                  ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
                  d.e(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
                  AppMethodBeat.o(66945);
                  return;
                }
                ad.e("MicroMsg.MallGalleryUI", "url is null or nil");
                AppMethodBeat.o(66945);
                return;
                localMallGalleryUI = MallGalleryUI.this;
                localObject1 = localMallGalleryUI.dbF();
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
                localObject1 = localMallGalleryUI.dbF();
                if (!bt.isNullOrNil((String)localObject1))
                {
                  ad.d("MicroMsg.MallGalleryUI", "file path valid");
                  cs localcs = new cs();
                  if (bt.isNullOrNil((String)localObject1))
                  {
                    ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    localcs.deQ.deV = 2131758885;
                  }
                  for (;;)
                  {
                    localcs.deQ.deW = 4;
                    localcs.deQ.activity = localMallGalleryUI;
                    com.tencent.mm.sdk.b.a.ESL.l(localcs);
                    AppMethodBeat.o(66945);
                    return;
                    ad.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
                    ago localago = new ago();
                    agu localagu = new agu();
                    afy localafy = new afy();
                    localafy.VD(2);
                    localafy.aDz((String)localObject1);
                    localafy.aDy(com.tencent.mm.b.g.getMessageDigest((localafy.toString() + 2 + System.currentTimeMillis()).getBytes()));
                    Object localObject2 = new gs();
                    ((gs)localObject2).dkc.type = 27;
                    ((gs)localObject2).dkc.dke = localafy;
                    com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
                    localObject2 = ((gs)localObject2).dkd.thumbPath;
                    f.c((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
                    localafy.aDA((String)localObject2);
                    localagu.aEl(u.aqG());
                    localagu.aEm(u.aqG());
                    localagu.VM(9);
                    localagu.vv(bt.eGO());
                    localago.a(localagu);
                    localago.mVb.add(localafy);
                    localcs.deQ.title = localafy.title;
                    localcs.deQ.deS = localago;
                    localcs.deQ.type = 2;
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
    this.uxl = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.uxn = false;
    initView();
    AppMethodBeat.o(66947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66948);
    super.onResume();
    this.uxk.setData(this.uxl);
    this.uxk.notifyDataSetChanged();
    if (this.uxl != null) {
      this.uxl.size();
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