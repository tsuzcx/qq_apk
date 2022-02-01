package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private List<String> BaA;
  private int BaB = 0;
  private boolean BaC;
  private ViewPager Bay;
  private g Baz;
  private final String TAG = "MicroMsg.MallGalleryUI";
  
  final String eDy()
  {
    AppMethodBeat.i(66950);
    if ((this.BaA == null) || (this.BaA.size() < this.BaB + 1)) {
      Log.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; Util.isNullOrNil(str); str = (String)this.BaA.get(this.BaB))
    {
      Log.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(66950);
      return null;
    }
    str = c.aKj(str);
    AppMethodBeat.o(66950);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131495958;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66949);
    this.Bay = ((ViewPager)findViewById(2131304350));
    this.Bay.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    this.Baz = new g(this);
    this.Baz.BaX = new g.a()
    {
      public final void eDz()
      {
        AppMethodBeat.i(66943);
        MallGalleryUI.c(MallGalleryUI.this);
        AppMethodBeat.o(66943);
      }
    };
    this.Bay.setAdapter(this.Baz);
    setBackBtn(new MallGalleryUI.3(this));
    addIconOptionMenu(0, 2131690843, new MallGalleryUI.4(this));
    AppMethodBeat.o(66949);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66947);
    super.onCreate(paramBundle);
    this.BaA = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.BaC = false;
    initView();
    AppMethodBeat.o(66947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66948);
    super.onResume();
    this.Baz.setData(this.BaA);
    this.Baz.notifyDataSetChanged();
    if (this.BaA != null) {
      this.BaA.size();
    }
    AppMethodBeat.o(66948);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI
 * JD-Core Version:    0.7.0.1
 */