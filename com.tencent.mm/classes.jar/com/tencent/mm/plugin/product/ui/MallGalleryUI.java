package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import java.util.List;

@a(3)
public class MallGalleryUI
  extends MallBaseUI
{
  private final String TAG = "MicroMsg.MallGalleryUI";
  private ViewPager mTt;
  private g mTu;
  private List<String> mTv;
  private int mTw = 0;
  private boolean mTx;
  
  final String bsk()
  {
    if ((this.mTv == null) || (this.mTv.size() < this.mTw + 1)) {
      y.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
    }
    for (String str = null; bk.bl(str); str = (String)this.mTv.get(this.mTw))
    {
      y.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
      return null;
    }
    return c.KR(str);
  }
  
  protected final int getLayoutId()
  {
    return a.g.product_gallery_ui;
  }
  
  protected final void initView()
  {
    this.mTt = ((ViewPager)findViewById(a.f.mall_gallery));
    this.mTt.setOnPageChangeListener(new MallGalleryUI.1(this));
    this.mTu = new g(this);
    this.mTu.mTT = new MallGalleryUI.2(this);
    this.mTt.setAdapter(this.mTu);
    setBackBtn(new MallGalleryUI.3(this));
    addIconOptionMenu(0, a.e.mm_title_btn_menu, new MallGalleryUI.4(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mTv = getIntent().getStringArrayListExtra("keys_img_urls");
    this.mController.hideTitleView();
    this.mTx = false;
    initView();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mTu.setData(this.mTv);
    this.mTu.notifyDataSetChanged();
    if (this.mTv != null) {
      this.mTv.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI
 * JD-Core Version:    0.7.0.1
 */