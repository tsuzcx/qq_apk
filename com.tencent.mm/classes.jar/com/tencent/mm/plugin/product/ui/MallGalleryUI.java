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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private final String TAG = "MicroMsg.MallGalleryUI";
  private ViewPager xcW;
  private g xcX;
  private List<String> xcY;
  private int xcZ = 0;
  private boolean xda;
  
  final String dDg()
  {
    AppMethodBeat.i(66950);
    if ((this.xcY == null) || (this.xcY.size() < this.xcZ + 1)) {
      ae.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; bu.isNullOrNil(str); str = (String)this.xcY.get(this.xcZ))
    {
      ae.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(66950);
      return null;
    }
    str = c.avR(str);
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
    this.xcW = ((ViewPager)findViewById(2131302011));
    this.xcW.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(66942);
        ae.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        MallGalleryUI.a(MallGalleryUI.this, paramAnonymousInt);
        if (MallGalleryUI.a(MallGalleryUI.this))
        {
          MallGalleryUI.this.hideTitleView();
          MallGalleryUI.b(MallGalleryUI.this);
        }
        AppMethodBeat.o(66942);
      }
    });
    this.xcX = new g(this);
    this.xcX.xdv = new g.a()
    {
      public final void dDh()
      {
        AppMethodBeat.i(66943);
        MallGalleryUI.c(MallGalleryUI.this);
        AppMethodBeat.o(66943);
      }
    };
    this.xcW.setAdapter(this.xcX);
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
        if (d.aJN("favorite")) {}
        for (paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(2130903065);; paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(2130903066))
        {
          com.tencent.mm.ui.base.h.b(MallGalleryUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
          {
            public final void lh(int paramAnonymous2Int)
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
                if (!bu.isNullOrNil(localMallGalleryUI.dDg()))
                {
                  ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.dDg());
                  ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
                  ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
                  d.f(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
                  AppMethodBeat.o(66945);
                  return;
                }
                ae.e("MicroMsg.MallGalleryUI", "url is null or nil");
                AppMethodBeat.o(66945);
                return;
                localMallGalleryUI = MallGalleryUI.this;
                localObject1 = localMallGalleryUI.dDg();
                if (!bu.isNullOrNil((String)localObject1))
                {
                  ae.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
                  q.j((String)localObject1, localMallGalleryUI);
                  AppMethodBeat.o(66945);
                  return;
                }
                ae.w("MicroMsg.MallGalleryUI", "save error.");
                AppMethodBeat.o(66945);
                return;
                localMallGalleryUI = MallGalleryUI.this;
                localObject1 = localMallGalleryUI.dDg();
                if (!bu.isNullOrNil((String)localObject1))
                {
                  ae.d("MicroMsg.MallGalleryUI", "file path valid");
                  cw localcw = new cw();
                  if (bu.isNullOrNil((String)localObject1))
                  {
                    ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    localcw.doL.doQ = 2131758885;
                  }
                  for (;;)
                  {
                    localcw.doL.doR = 4;
                    localcw.doL.activity = localMallGalleryUI;
                    com.tencent.mm.sdk.b.a.IvT.l(localcw);
                    AppMethodBeat.o(66945);
                    return;
                    ae.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
                    akn localakn = new akn();
                    akt localakt = new akt();
                    ajx localajx = new ajx();
                    localajx.aao(2);
                    localajx.aPQ((String)localObject1);
                    localajx.aPP(com.tencent.mm.b.g.getMessageDigest((localajx.toString() + 2 + System.currentTimeMillis()).getBytes()));
                    Object localObject2 = new gx();
                    ((gx)localObject2).dub.type = 27;
                    ((gx)localObject2).dub.dud = localajx;
                    com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
                    localObject2 = ((gx)localObject2).duc.thumbPath;
                    com.tencent.mm.sdk.platformtools.h.c((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
                    localajx.aPR((String)localObject2);
                    localakt.aQC(v.aAC());
                    localakt.aQD(v.aAC());
                    localakt.aax(9);
                    localakt.Dk(bu.fpO());
                    localakn.a(localakt);
                    localakn.oeJ.add(localajx);
                    localcw.doL.title = localajx.title;
                    localcw.doL.doN = localakn;
                    localcw.doL.type = 2;
                  }
                }
                ae.w("MicroMsg.MallGalleryUI", "file path invalid");
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
    this.xcY = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.xda = false;
    initView();
    AppMethodBeat.o(66947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66948);
    super.onResume();
    this.xcX.setData(this.xcY);
    this.xcX.notifyDataSetChanged();
    if (this.xcY != null) {
      this.xcY.size();
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