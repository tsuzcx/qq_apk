package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private final String TAG = "MicroMsg.MallGalleryUI";
  private g pvA;
  private List<String> pvB;
  private int pvC = 0;
  private boolean pvD;
  private ViewPager pvz;
  
  final String cbq()
  {
    AppMethodBeat.i(44043);
    if ((this.pvB == null) || (this.pvB.size() < this.pvC + 1)) {
      ab.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; bo.isNullOrNil(str); str = (String)this.pvB.get(this.pvC))
    {
      ab.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      AppMethodBeat.o(44043);
      return null;
    }
    str = c.WX(str);
    AppMethodBeat.o(44043);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2130970442;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44042);
    this.pvz = ((ViewPager)findViewById(2131826774));
    this.pvz.setOnPageChangeListener(new MallGalleryUI.1(this));
    this.pvA = new g(this);
    this.pvA.pvZ = new MallGalleryUI.2(this);
    this.pvz.setAdapter(this.pvA);
    setBackBtn(new MallGalleryUI.3(this));
    addIconOptionMenu(0, 2130839668, new MallGalleryUI.4(this));
    AppMethodBeat.o(44042);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44040);
    super.onCreate(paramBundle);
    this.pvB = getIntent().getStringArrayListExtra("keys_img_urls");
    hideTitleView();
    this.pvD = false;
    initView();
    AppMethodBeat.o(44040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44041);
    super.onResume();
    this.pvA.setData(this.pvB);
    this.pvA.notifyDataSetChanged();
    if (this.pvB != null) {
      this.pvB.size();
    }
    AppMethodBeat.o(44041);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI
 * JD-Core Version:    0.7.0.1
 */