package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;

public class PreviewLastHdHeadImg
  extends MMActivity
  implements View.OnClickListener
{
  private Bitmap JeX;
  private TextView JeY;
  private ImageView fDJ;
  private String fKH;
  private String username;
  
  private static boolean e(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(73943);
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        AppMethodBeat.o(73943);
        return true;
      }
      catch (Exception paramBitmap)
      {
        Log.printErrStackTrace("MicroMsg.PreviewLastHdHeadImg", paramBitmap, "", new Object[0]);
        Log.e("MicroMsg.PreviewLastHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    AppMethodBeat.o(73943);
    return false;
  }
  
  public int getLayoutId()
  {
    return b.g.get_last_hd_head_image_gallery_view;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73942);
    setMMTitle(b.i.settings_last_avatar);
    setActionbarColor(getResources().getColor(b.c.transparent));
    setNavigationbarColor(getResources().getColor(b.c.BW_0));
    this.username = z.bcZ();
    this.fKH = getIntent().getStringExtra("last_avatar_path");
    this.fDJ = ((ImageView)findViewById(b.f.head_img));
    this.JeX = BitmapUtil.getBitmapNative(this.fKH);
    this.JeY = ((TextView)findViewById(b.f.use_this_head_img_tv));
    this.fDJ.setImageBitmap(this.JeX);
    this.JeY.setOnClickListener(this);
    addIconOptionMenu(0, b.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73939);
        paramAnonymousMenuItem = new e(PreviewLastHdHeadImg.this, 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(73937);
            if (PreviewLastHdHeadImg.a(PreviewLastHdHeadImg.this) != null) {
              paramAnonymous2o.mn(0, b.i.get_hd_head_img_save_alert);
            }
            AppMethodBeat.o(73937);
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(73938);
            PreviewLastHdHeadImg.b(PreviewLastHdHeadImg.this);
            AppMethodBeat.o(73938);
          }
        };
        paramAnonymousMenuItem.eik();
        AppMethodBeat.o(73939);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73940);
        PreviewLastHdHeadImg.this.finish();
        AppMethodBeat.o(73940);
        return true;
      }
    });
    AppMethodBeat.o(73942);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(73944);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = getIntent().getStringExtra("CropImage_OutputPath");
    if ((paramView != null) && (e(this.JeX, paramView)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramView);
      setResult(-1, (Intent)localObject);
      finish();
      a.a(this, "com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(73944);
      return;
    }
    setResult(0);
    finish();
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(73944);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73941);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(73941);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg
 * JD-Core Version:    0.7.0.1
 */