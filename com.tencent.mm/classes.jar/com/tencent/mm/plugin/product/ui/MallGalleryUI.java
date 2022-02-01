package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private final String TAG = "MicroMsg.MallGalleryUI";
  private ViewPager vGc;
  private g vGd;
  private List<String> vGe;
  private int vGf = 0;
  private boolean vGg;
  
  final String dpn()
  {
    AppMethodBeat.i(66950);
    if ((this.vGe == null) || (this.vGe.size() < this.vGf + 1)) {
      ac.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; bs.isNullOrNil(str); str = (String)this.vGe.get(this.vGf))
    {
      ac.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(66950);
      return null;
    }
    str = c.apw(str);
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
    this.vGc = ((ViewPager)findViewById(2131302011));
    this.vGc.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(66942);
        ac.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        MallGalleryUI.a(MallGalleryUI.this, paramAnonymousInt);
        if (MallGalleryUI.a(MallGalleryUI.this))
        {
          MallGalleryUI.this.hideTitleView();
          MallGalleryUI.b(MallGalleryUI.this);
        }
        AppMethodBeat.o(66942);
      }
    });
    this.vGd = new g(this);
    this.vGd.vGA = new g.a()
    {
      public final void dpo()
      {
        AppMethodBeat.i(66943);
        MallGalleryUI.c(MallGalleryUI.this);
        AppMethodBeat.o(66943);
      }
    };
    this.vGc.setAdapter(this.vGd);
    setBackBtn(new MallGalleryUI.3(this));
    addIconOptionMenu(0, 2131690603, new MallGalleryUI.4(this));
    AppMethodBeat.o(66949);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66947);
    super.onCreate(paramBundle);
    this.vGe = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.vGg = false;
    initView();
    AppMethodBeat.o(66947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66948);
    super.onResume();
    this.vGd.setData(this.vGe);
    this.vGd.notifyDataSetChanged();
    if (this.vGe != null) {
      this.vGe.size();
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