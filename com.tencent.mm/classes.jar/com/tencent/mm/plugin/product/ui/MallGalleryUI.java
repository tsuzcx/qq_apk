package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private boolean GUA;
  private ViewPager GUw;
  private g GUx;
  private List<String> GUy;
  private int GUz = 0;
  private final String TAG = "MicroMsg.MallGalleryUI";
  
  final String fpr()
  {
    AppMethodBeat.i(66950);
    if ((this.GUy == null) || (this.GUy.size() < this.GUz + 1)) {
      Log.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; Util.isNullOrNil(str); str = (String)this.GUy.get(this.GUz))
    {
      Log.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(66950);
      return null;
    }
    str = c.aUH(str);
    AppMethodBeat.o(66950);
    return str;
  }
  
  public int getLayoutId()
  {
    return a.g.product_gallery_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66949);
    this.GUw = ((ViewPager)findViewById(a.f.mall_gallery));
    this.GUw.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(66942);
        Log.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        MallGalleryUI.a(MallGalleryUI.this, paramAnonymousInt);
        if (MallGalleryUI.a(MallGalleryUI.this))
        {
          MallGalleryUI.this.hideTitleView();
          MallGalleryUI.b(MallGalleryUI.this);
        }
        AppMethodBeat.o(66942);
      }
    });
    this.GUx = new g(this);
    this.GUx.GUV = new g.a()
    {
      public final void fps()
      {
        AppMethodBeat.i(66943);
        MallGalleryUI.c(MallGalleryUI.this);
        AppMethodBeat.o(66943);
      }
    };
    this.GUw.setAdapter(this.GUx);
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
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66946);
        if (com.tencent.mm.by.c.blP("favorite")) {}
        for (paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(a.b.mall_product_gallery_ui_opt_list_with_fav);; paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(a.b.mall_product_gallery_ui_opt_list_without_fav))
        {
          h.b(MallGalleryUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.d()
          {
            public final void qy(int paramAnonymous2Int)
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
                if (!Util.isNullOrNil(localMallGalleryUI.fpr()))
                {
                  ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.fpr());
                  ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
                  ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
                  com.tencent.mm.by.c.f(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
                  AppMethodBeat.o(66945);
                  return;
                }
                Log.e("MicroMsg.MallGalleryUI", "url is null or nil");
                AppMethodBeat.o(66945);
                return;
                localMallGalleryUI = MallGalleryUI.this;
                localObject1 = localMallGalleryUI.fpr();
                if (!Util.isNullOrNil((String)localObject1))
                {
                  Log.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
                  u.n((String)localObject1, localMallGalleryUI);
                  AppMethodBeat.o(66945);
                  return;
                }
                Log.w("MicroMsg.MallGalleryUI", "save error.");
                AppMethodBeat.o(66945);
                return;
                localMallGalleryUI = MallGalleryUI.this;
                localObject1 = localMallGalleryUI.fpr();
                if (!Util.isNullOrNil((String)localObject1))
                {
                  Log.d("MicroMsg.MallGalleryUI", "file path valid");
                  dd localdd = new dd();
                  if (Util.isNullOrNil((String)localObject1))
                  {
                    Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    localdd.fyI.fyO = a.i.favorite_fail_argument_error;
                  }
                  for (;;)
                  {
                    localdd.fyI.fyP = 4;
                    localdd.fyI.activity = localMallGalleryUI;
                    EventCenter.instance.publish(localdd);
                    AppMethodBeat.o(66945);
                    return;
                    Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
                    aoc localaoc = new aoc();
                    aoi localaoi = new aoi();
                    anm localanm = new anm();
                    localanm.arq(2);
                    localanm.bsL((String)localObject1);
                    localanm.bsK(com.tencent.mm.b.g.getMessageDigest((localanm.toString() + 2 + System.currentTimeMillis()).getBytes()));
                    Object localObject2 = new hi();
                    ((hi)localObject2).fEb.type = 27;
                    ((hi)localObject2).fEb.fEd = localanm;
                    EventCenter.instance.publish((IEvent)localObject2);
                    localObject2 = ((hi)localObject2).fEc.thumbPath;
                    BitmapUtil.createThumbNail((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2, true);
                    localanm.bsM((String)localObject2);
                    localaoi.btx(z.bcZ());
                    localaoi.bty(z.bcZ());
                    localaoi.arz(9);
                    localaoi.Ue(Util.nowMilliSecond());
                    localaoc.a(localaoi);
                    localaoc.syG.add(localanm);
                    localdd.fyI.title = localanm.title;
                    localdd.fyI.fyK = localaoc;
                    localdd.fyI.type = 2;
                  }
                }
                Log.w("MicroMsg.MallGalleryUI", "file path invalid");
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
    this.GUy = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.GUA = false;
    initView();
    AppMethodBeat.o(66947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66948);
    super.onResume();
    this.GUx.setData(this.GUy);
    this.GUx.notifyDataSetChanged();
    if (this.GUy != null) {
      this.GUy.size();
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