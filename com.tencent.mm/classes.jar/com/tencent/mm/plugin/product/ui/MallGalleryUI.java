package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import java.util.List;

@a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private ViewPager MRY;
  private g MRZ;
  private List<String> MSa;
  private int MSb = 0;
  private boolean MSc;
  private final String TAG = "MicroMsg.MallGalleryUI";
  
  final String gAv()
  {
    AppMethodBeat.i(66950);
    if ((this.MSa == null) || (this.MSa.size() < this.MSb + 1)) {
      Log.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; Util.isNullOrNil(str); str = (String)this.MSa.get(this.MSb))
    {
      Log.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(66950);
      return null;
    }
    str = c.aRP(str);
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
    this.MRY = ((ViewPager)findViewById(a.f.mall_gallery));
    this.MRY.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    this.MRZ = new g(this);
    this.MRZ.MSx = new g.a()
    {
      public final void gAw()
      {
        AppMethodBeat.i(66943);
        MallGalleryUI.c(MallGalleryUI.this);
        AppMethodBeat.o(66943);
      }
    };
    this.MRY.setAdapter(this.MRZ);
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
        if (com.tencent.mm.br.c.blq("favorite")) {}
        for (paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(a.b.mall_product_gallery_ui_opt_list_with_fav);; paramAnonymousMenuItem = MallGalleryUI.this.getResources().getStringArray(a.b.mall_product_gallery_ui_opt_list_without_fav))
        {
          k.b(MallGalleryUI.this.getContext(), null, paramAnonymousMenuItem, null, new MallGalleryUI.4.1(this));
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
    this.MSa = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.MSc = false;
    initView();
    AppMethodBeat.o(66947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66948);
    super.onResume();
    this.MRZ.setData(this.MSa);
    this.MRZ.notifyDataSetChanged();
    if (this.MSa != null) {
      this.MSa.size();
    }
    AppMethodBeat.o(66948);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI
 * JD-Core Version:    0.7.0.1
 */