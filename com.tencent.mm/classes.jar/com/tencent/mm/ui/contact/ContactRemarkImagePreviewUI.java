package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.o;

public class ContactRemarkImagePreviewUI
  extends MMActivity
{
  private boolean PUA;
  private boolean PUB;
  private a PUC;
  private View PUy;
  private String PUz;
  private MMGestureGallery jUy;
  private String username;
  
  private void mD(boolean paramBoolean)
  {
    AppMethodBeat.i(37745);
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("response_delete", true);
      setResult(-1, localIntent);
    }
    finish();
    AppMethodBeat.o(37745);
  }
  
  public int getLayoutId()
  {
    return 2131493784;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37744);
    this.PUy = findViewById(2131299179);
    this.jUy = ((MMGestureGallery)findViewById(2131301853));
    setMMTitle(2131763139);
    this.jUy.setVerticalFadingEdgeEnabled(false);
    this.jUy.setHorizontalFadingEdgeEnabled(false);
    ForceGpuUtil.setLayerType(this.jUy);
    this.PUC = new a();
    this.PUC.imagePath = this.PUz;
    this.jUy.setAdapter(this.PUC);
    this.jUy.setOnItemClickListener(new ContactRemarkImagePreviewUI.3(this));
    addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37737);
        paramAnonymousMenuItem = new e(ContactRemarkImagePreviewUI.this, 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(37735);
            paramAnonymous2m.d(0, ContactRemarkImagePreviewUI.this.getString(2131764870));
            if (c.aZU("favorite")) {
              paramAnonymous2m.d(1, ContactRemarkImagePreviewUI.this.getString(2131763947));
            }
            if (!ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this)) {
              paramAnonymous2m.d(2, ContactRemarkImagePreviewUI.this.getString(2131755778));
            }
            AppMethodBeat.o(37735);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(37736);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(37736);
              return;
              if (!ContactRemarkImagePreviewUI.b(ContactRemarkImagePreviewUI.this))
              {
                ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
                AppMethodBeat.o(37736);
                return;
              }
              new o(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.this)).delete();
              ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
              AppMethodBeat.o(37736);
              return;
              s.l(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.this), ContactRemarkImagePreviewUI.this);
              AppMethodBeat.o(37736);
              return;
              ContactRemarkImagePreviewUI.d(ContactRemarkImagePreviewUI.this);
            }
          }
        };
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(37737);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37738);
        ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, false);
        AppMethodBeat.o(37738);
        return false;
      }
    });
    AppMethodBeat.o(37744);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37741);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("Contact_User");
    this.PUz = getIntent().getStringExtra("remark_image_path");
    this.PUA = getIntent().getBooleanExtra("view_temp_remark_image", false);
    this.PUB = getIntent().getBooleanExtra("view_only", false);
    if (Util.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37741);
      return;
    }
    initView();
    AppMethodBeat.o(37741);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37743);
    super.onDestroy();
    AppMethodBeat.o(37743);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(37746);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      mD(false);
      AppMethodBeat.o(37746);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(37746);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37742);
    super.onPause();
    AppMethodBeat.o(37742);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    String imagePath;
    
    a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return this.imagePath;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(37740);
      paramView = View.inflate(ContactRemarkImagePreviewUI.this, 2131493785, null);
      paramViewGroup = (MultiTouchImageView)paramView.findViewById(2131302526);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeFile(this.imagePath, a.getDensity(ContactRemarkImagePreviewUI.this));
      int i;
      Matrix localMatrix;
      if (localBitmap != null)
      {
        paramInt = ContactRemarkImagePreviewUI.e(ContactRemarkImagePreviewUI.this).getWidth();
        i = ContactRemarkImagePreviewUI.e(ContactRemarkImagePreviewUI.this).getHeight();
        localMatrix = new Matrix();
        localMatrix.reset();
        f1 = localBitmap.getWidth() / localBitmap.getHeight();
        f2 = localBitmap.getHeight() / localBitmap.getWidth();
        Log.v("MicroMsg.ImagePreviewUI", "whDiv is " + f1 + " hwDiv is " + f2);
        if ((f2 < 2.0F) || (localBitmap.getHeight() < 480)) {
          break label318;
        }
        f1 = localBitmap.getWidth() / paramInt;
        f2 = paramInt / localBitmap.getWidth();
        if (f1 <= 1.0D) {
          break label290;
        }
        localMatrix.postScale(f2, f2);
        localBitmap.getHeight();
        localMatrix.postTranslate((paramInt - f2 * localBitmap.getWidth()) / 2.0F, 0.0F);
      }
      for (;;)
      {
        paramViewGroup.setImageMatrix(localMatrix);
        paramViewGroup.cN(localBitmap.getWidth(), localBitmap.getHeight());
        paramViewGroup.setImageBitmap(localBitmap);
        AppMethodBeat.o(37740);
        return paramView;
        label290:
        localMatrix.postScale(1.0F, 1.0F);
        localMatrix.postTranslate((paramInt - localBitmap.getWidth()) / 2, 0.0F);
        continue;
        label318:
        if ((f1 < 2.0F) || (localBitmap.getWidth() < 480)) {
          break;
        }
        f1 = localBitmap.getHeight() / 480.0F;
        f2 = 480.0F / localBitmap.getHeight();
        if (f1 > 1.0D)
        {
          localMatrix.postScale(f1, f2);
          localMatrix.postTranslate(0.0F, (i - 480) / 2);
        }
        else
        {
          localMatrix.postScale(1.0F, 1.0F);
          f1 = (i - localBitmap.getHeight()) / 2;
          Log.d("MicroMsg.ImagePreviewUI", " offsety ".concat(String.valueOf(f1)));
          localMatrix.postTranslate(0.0F, f1);
        }
      }
      float f1 = paramInt / localBitmap.getWidth();
      float f2 = i / localBitmap.getHeight();
      label474:
      float f3;
      if (f1 < f2)
      {
        f2 = localBitmap.getWidth() / paramInt;
        f3 = localBitmap.getHeight() / i;
        if (f2 <= f3) {
          break label568;
        }
        label505:
        if (f2 <= 1.0D) {
          break label575;
        }
        localMatrix.postScale(f1, f1);
      }
      for (;;)
      {
        localMatrix.postTranslate((paramInt - localBitmap.getWidth() * f1) / 2.0F, (i - f1 * localBitmap.getHeight()) / 2.0F);
        break;
        f1 = f2;
        break label474;
        label568:
        f2 = f3;
        break label505;
        label575:
        f1 = 1.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */