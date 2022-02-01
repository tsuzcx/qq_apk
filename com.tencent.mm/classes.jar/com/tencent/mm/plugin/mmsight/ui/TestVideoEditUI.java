package com.tencent.mm.plugin.mmsight.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.a.a;
import com.tencent.mm.api.y.b;
import com.tencent.mm.api.y.c;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;

public class TestVideoEditUI
  extends MMActivity
  implements i
{
  private y uUi;
  
  public int getLayoutId()
  {
    return 2131495752;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94749);
    if (!this.uUi.Iu()) {
      finish();
    }
    AppMethodBeat.o(94749);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94747);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    paramBundle = (FrameLayout)findViewById(2131298739);
    this.uUi = y.cGI.Ix();
    Object localObject = this.uUi;
    y.a.a locala = new y.a.a();
    locala.cGK = false;
    locala.cGN = true;
    locala.cGO = new Rect(0, 0, 1080, 1080);
    locala.cGJ = y.c.cGP;
    ((y)localObject).a(locala.JO());
    localObject = this.uUi.bg(getContext());
    ((e)localObject).setActionBarCallback(this);
    paramBundle.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    ((e)localObject).setSelectedFeatureListener(new w()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(94743);
        ac.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
        AppMethodBeat.o(94743);
      }
      
      public final void a(g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169420);
        ac.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg.name(), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(169420);
      }
      
      public final void bW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94745);
        if (paramAnonymousBoolean)
        {
          TestVideoEditUI.this.showVKB();
          AppMethodBeat.o(94745);
          return;
        }
        TestVideoEditUI.this.hideVKB(TestVideoEditUI.a(TestVideoEditUI.this));
        AppMethodBeat.o(94745);
      }
    });
    AppMethodBeat.o(94747);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94748);
    super.onDestroy();
    this.uUi.onDestroy();
    AppMethodBeat.o(94748);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(94752);
    finish();
    AppMethodBeat.o(94752);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(94751);
    this.uUi.a(new s()
    {
      public final void a(Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94746);
        ac.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramAnonymousBitmap.getWidth()), Integer.valueOf(paramAnonymousBitmap.getHeight()) });
        String str = b.app() + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png" });
        try
        {
          f.a(paramAnonymousBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
          AppMethodBeat.o(94746);
          return;
        }
        catch (IOException paramAnonymousBitmap)
        {
          AppMethodBeat.o(94746);
        }
      }
      
      public final void onError(Exception paramAnonymousException) {}
    });
    AppMethodBeat.o(94751);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(94750);
    super.onSwipeBack();
    AppMethodBeat.o(94750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI
 * JD-Core Version:    0.7.0.1
 */