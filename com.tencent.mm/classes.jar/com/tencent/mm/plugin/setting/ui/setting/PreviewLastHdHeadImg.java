package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class PreviewLastHdHeadImg
  extends MMActivity
  implements View.OnClickListener
{
  private ImageView bNu;
  private String imgPath;
  private Bitmap nSt;
  private TextView nSu;
  private String username;
  
  private static boolean e(Bitmap paramBitmap, String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        return true;
      }
      catch (Exception paramBitmap)
      {
        y.printErrStackTrace("MicroMsg.PreviewLastHdHeadImg", paramBitmap, "", new Object[0]);
        y.e("MicroMsg.PreviewLastHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.get_last_hd_head_image_gallery_view;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_last_avatar);
    ta(getResources().getColor(a.c.transparent));
    this.username = q.Gj();
    this.imgPath = getIntent().getStringExtra("last_avatar_path");
    this.bNu = ((ImageView)findViewById(a.f.head_img));
    this.nSt = c.YW(this.imgPath);
    this.nSu = ((TextView)findViewById(a.f.use_this_head_img_tv));
    this.bNu.setImageBitmap(this.nSt);
    this.nSu.setOnClickListener(this);
    addIconOptionMenu(0, a.e.mm_title_btn_menu, new PreviewLastHdHeadImg.1(this));
    setBackBtn(new PreviewLastHdHeadImg.2(this));
  }
  
  public void onClick(View paramView)
  {
    paramView = getIntent().getStringExtra("CropImage_OutputPath");
    if ((paramView != null) && (e(this.nSt, paramView)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImage_OutputPath", paramView);
      setResult(-1, localIntent);
      finish();
      return;
    }
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg
 * JD-Core Version:    0.7.0.1
 */