package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.y;

public class PreviewLastHdHeadImg
  extends MMActivity
  implements View.OnClickListener
{
  private Bitmap Ppu;
  private TextView Ppv;
  private ImageView hIz;
  private String hQn;
  private String username;
  
  private static boolean h(Bitmap paramBitmap, String paramString)
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
    this.username = z.bAM();
    this.hQn = getIntent().getStringExtra("last_avatar_path");
    this.hIz = ((ImageView)findViewById(b.f.head_img));
    this.Ppu = BitmapUtil.getBitmapNative(this.hQn);
    this.Ppv = ((TextView)findViewById(b.f.use_this_head_img_tv));
    this.hIz.setImageBitmap(this.Ppu);
    this.Ppv.setOnClickListener(this);
    addIconOptionMenu(0, b.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73939);
        paramAnonymousMenuItem = new f(PreviewLastHdHeadImg.this, 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(73937);
            if (PreviewLastHdHeadImg.a(PreviewLastHdHeadImg.this) != null) {
              paramAnonymous2s.oh(0, b.i.get_hd_head_img_save_alert);
            }
            AppMethodBeat.o(73937);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(73938);
            PreviewLastHdHeadImg.b(PreviewLastHdHeadImg.this);
            AppMethodBeat.o(73938);
          }
        };
        paramAnonymousMenuItem.dDn();
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
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = getIntent().getStringExtra("CropImage_OutputPath");
    if ((paramView != null) && (h(this.Ppu, paramView)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg
 * JD-Core Version:    0.7.0.1
 */