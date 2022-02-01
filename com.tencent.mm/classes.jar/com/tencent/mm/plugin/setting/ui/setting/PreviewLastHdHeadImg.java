package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.i;

public class PreviewLastHdHeadImg
  extends MMActivity
  implements View.OnClickListener
{
  private ImageView dsD;
  private String dyy;
  private String username;
  private Bitmap yEB;
  private TextView yEC;
  
  private static boolean e(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(73943);
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        AppMethodBeat.o(73943);
        return true;
      }
      catch (Exception paramBitmap)
      {
        ad.printErrStackTrace("MicroMsg.PreviewLastHdHeadImg", paramBitmap, "", new Object[0]);
        ad.e("MicroMsg.PreviewLastHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    AppMethodBeat.o(73943);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131494410;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73942);
    setMMTitle(2131763256);
    setActionbarColor(getResources().getColor(2131101053));
    setNavigationbarColor(getResources().getColor(2131099654));
    this.username = u.aAm();
    this.dyy = getIntent().getStringExtra("last_avatar_path");
    this.dsD = ((ImageView)findViewById(2131300697));
    this.yEB = com.tencent.mm.sdk.platformtools.g.aQf(this.dyy);
    this.yEC = ((TextView)findViewById(2131306229));
    this.dsD.setImageBitmap(this.yEB);
    this.yEC.setOnClickListener(this);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73939);
        paramAnonymousMenuItem = new e(PreviewLastHdHeadImg.this, 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(73937);
            if (PreviewLastHdHeadImg.a(PreviewLastHdHeadImg.this) != null) {
              paramAnonymous2l.jI(0, 2131760065);
            }
            AppMethodBeat.o(73937);
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(73938);
            PreviewLastHdHeadImg.b(PreviewLastHdHeadImg.this);
            AppMethodBeat.o(73938);
          }
        };
        paramAnonymousMenuItem.cMW();
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
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    paramView = getIntent().getStringExtra("CropImage_OutputPath");
    if ((paramView != null) && (e(this.yEB, paramView)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg
 * JD-Core Version:    0.7.0.1
 */