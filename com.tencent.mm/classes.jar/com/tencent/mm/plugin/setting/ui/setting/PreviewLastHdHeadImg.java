package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;

public class PreviewLastHdHeadImg
  extends MMActivity
  implements View.OnClickListener
{
  private ImageView cuM;
  private String imgPath;
  private Bitmap qGr;
  private TextView qGs;
  private String username;
  
  private static boolean e(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(127011);
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        AppMethodBeat.o(127011);
        return true;
      }
      catch (Exception paramBitmap)
      {
        ab.printErrStackTrace("MicroMsg.PreviewLastHdHeadImg", paramBitmap, "", new Object[0]);
        ab.e("MicroMsg.PreviewLastHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    AppMethodBeat.o(127011);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130969839;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127010);
    setMMTitle(2131303287);
    setActionbarColor(getResources().getColor(2131690605));
    setNavigationbarColor(getResources().getColor(2131689481));
    this.username = r.Zn();
    this.imgPath = getIntent().getStringExtra("last_avatar_path");
    this.cuM = ((ImageView)findViewById(2131824800));
    this.qGr = d.aoV(this.imgPath);
    this.qGs = ((TextView)findViewById(2131824801));
    this.cuM.setImageBitmap(this.qGr);
    this.qGs.setOnClickListener(this);
    addIconOptionMenu(0, 2130839668, new PreviewLastHdHeadImg.1(this));
    setBackBtn(new PreviewLastHdHeadImg.2(this));
    AppMethodBeat.o(127010);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(127012);
    paramView = getIntent().getStringExtra("CropImage_OutputPath");
    if ((paramView != null) && (e(this.qGr, paramView)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImage_OutputPath", paramView);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(127012);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(127012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127009);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(127009);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg
 * JD-Core Version:    0.7.0.1
 */