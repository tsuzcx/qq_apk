package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;

public class ShowImageUI
  extends MMActivity
{
  private MMGestureGallery itv;
  private boolean weU;
  private a weV;
  private boolean weW;
  
  protected final int getLayoutId()
  {
    return R.i.show_image_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (!bk.bl(paramBundle)) {
      setMMTitle(paramBundle);
    }
    this.weU = getIntent().getBooleanExtra("key_favorite", false);
    this.weW = getIntent().getBooleanExtra("show_menu", true);
    this.itv = ((MMGestureGallery)findViewById(R.h.gallery));
    this.itv.setVerticalFadingEdgeEnabled(false);
    this.itv.setHorizontalFadingEdgeEnabled(false);
    this.weV = new a((byte)0);
    this.weV.imagePath = getIntent().getStringExtra("key_image_path");
    this.itv.setAdapter(this.weV);
    setBackBtn(new ShowImageUI.1(this));
    if (this.weW) {
      addIconOptionMenu(0, R.k.ofm_send_icon, new ShowImageUI.2(this));
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    String imagePath;
    
    private a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (o.Za(this.imagePath))
      {
        localObject = paramViewGroup.getContext();
        paramViewGroup = this.imagePath;
        new f(paramViewGroup);
        if ((paramView == null) || (!(paramView instanceof MMAnimateView))) {}
        for (paramView = new MMAnimateView((Context)localObject);; paramView = (MMAnimateView)paramView)
        {
          paramView.du(paramViewGroup, paramViewGroup);
          paramView.a(paramViewGroup, new ShowImageUI.a.1(this, paramView));
          if ((paramView.getDrawable() != null) && ((paramView.getDrawable() instanceof b))) {
            ((b)paramView.getDrawable()).stop();
          }
          paramView.start();
          return paramView;
        }
      }
      Object localObject = x.pg(this.imagePath);
      if (localObject == null)
      {
        y.w("MicroMsg.ShowImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), R.i.show_image_ui_item, null);
        }
        ((ImageView)((View)localObject).findViewById(R.h.image_iv)).setImageResource(R.k.download_image_icon);
        ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        return localObject;
      }
      paramViewGroup = paramViewGroup.getContext();
      if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
        paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      for (;;)
      {
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap((Bitmap)localObject);
        paramView.setMaxZoomDoubleTab(true);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
        paramView.fs(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI
 * JD-Core Version:    0.7.0.1
 */