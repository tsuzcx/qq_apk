package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.repairer.ui.b.a;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerSetTextStatusDemoUI
  extends MMSecDataActivity
{
  public final int getLayoutId()
  {
    return b.b.IwN;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(226733);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(226733);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226732);
    super.onCreate(paramBundle);
    setMMTitle("第三方设置状态Demo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(b.a.IvN).setOnClickListener((View.OnClickListener)new b((EditText)findViewById(b.a.Iwe)));
    findViewById(b.a.IvV).setOnClickListener((View.OnClickListener)new c(this, "/storage/emulated/0/Android/data/com.tencent.mm/MicroMsg/2c691549c7f50ee66ebd332e8f270d6b/video/vsg_output_1622096801814"));
    AppMethodBeat.o(226732);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(RepairerSetTextStatusDemoUI paramRepairerSetTextStatusDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226723);
      this.Iya.finish();
      AppMethodBeat.o(226723);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(EditText paramEditText) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226821);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.Iyb;
      p.j(paramView, "edtUrlDownload");
      paramView = paramView.getText();
      if (paramView != null)
      {
        paramView = paramView.toString();
        if (paramView != null) {}
      }
      else
      {
        paramView = "";
      }
      for (;;)
      {
        localObject = (r.a)a.Iyc;
        Log.i("MicroMsg.UrlImageCacheService", "trydownload imgback start:".concat(String.valueOf(paramView)));
        q.bmk().a(paramView, (r.a)localObject);
        a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226821);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
    static final class a
      implements r.a
    {
      public static final a Iyc;
      
      static
      {
        AppMethodBeat.i(226569);
        Iyc = new a();
        AppMethodBeat.o(226569);
      }
      
      public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
      {
        AppMethodBeat.i(226568);
        Log.i("MicroMsg.UrlImageCacheService", "trydownload imgback end:" + paramString1 + " bitmap:" + paramBitmap + " exist:" + u.agG(paramString2) + " len:" + u.bBQ(paramString2));
        if ((paramBitmap == null) || (!u.agG(paramString2)))
        {
          AppMethodBeat.o(226568);
          return;
        }
        AppMethodBeat.o(226568);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RepairerSetTextStatusDemoUI paramRepairerSetTextStatusDemoUI, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227367);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = (com.tencent.mm.plugin.textstatus.a.l)h.ae(com.tencent.mm.plugin.textstatus.a.l.class);
      localObject = (Activity)this.Iya.getContext();
      q.a locala = new q.a();
      locala.bee(this.zoN);
      locala.gkL();
      paramView.a((Activity)localObject, 3, locala.gkO());
      a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerSetTextStatusDemoUI
 * JD-Core Version:    0.7.0.1
 */