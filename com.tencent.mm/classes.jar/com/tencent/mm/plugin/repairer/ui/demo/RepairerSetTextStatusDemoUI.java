package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerSetTextStatusDemoUI
  extends BaseRepairerUI
{
  private static final void a(RepairerSetTextStatusDemoUI paramRepairerSetTextStatusDemoUI, String paramString, View paramView)
  {
    AppMethodBeat.i(278253);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerSetTextStatusDemoUI);
    localb.cH(paramString);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRepairerSetTextStatusDemoUI, "this$0");
    kotlin.g.b.s.u(paramString, "$thumbUrl");
    paramView = (n)h.ax(n.class);
    paramRepairerSetTextStatusDemoUI = (Activity)paramRepairerSetTextStatusDemoUI.getContext();
    localObject = new w.a();
    ((w.a)localObject).bdt(paramString);
    ((w.a)localObject).aol(2);
    paramString = ah.aiuX;
    paramView.a(paramRepairerSetTextStatusDemoUI, 3, ((w.a)localObject).ThS);
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278253);
  }
  
  private static final void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(278240);
    Log.i("MicroMsg.UrlImageCacheService", "trydownload imgback end:" + paramString1 + " bitmap:" + paramBitmap + " exist:" + y.ZC(paramString2) + " len:" + y.bEl(paramString2));
    if ((paramBitmap == null) || (!y.ZC(paramString2)))
    {
      AppMethodBeat.o(278240);
      return;
    }
    AppMethodBeat.o(278240);
  }
  
  private static final boolean a(RepairerSetTextStatusDemoUI paramRepairerSetTextStatusDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278230);
    kotlin.g.b.s.u(paramRepairerSetTextStatusDemoUI, "this$0");
    paramRepairerSetTextStatusDemoUI.finish();
    AppMethodBeat.o(278230);
    return true;
  }
  
  private static final void b(EditText paramEditText, View paramView)
  {
    AppMethodBeat.i(278247);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramEditText);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramEditText, "$edtUrlDownload");
    paramEditText = paramEditText.getText();
    if (paramEditText == null) {
      paramEditText = "";
    }
    for (;;)
    {
      paramView = RepairerSetTextStatusDemoUI..ExternalSyntheticLambda3.INSTANCE;
      Log.i("MicroMsg.UrlImageCacheService", kotlin.g.b.s.X("trydownload imgback start:", paramEditText));
      r.bKd().a(paramEditText, paramView);
      a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerSetTextStatusDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278247);
      return;
      paramView = paramEditText.toString();
      paramEditText = paramView;
      if (paramView == null) {
        paramEditText = "";
      }
    }
  }
  
  public final int getLayoutId()
  {
    return b.d.OvS;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(278294);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(278294);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278290);
    super.onCreate(paramBundle);
    setMMTitle("第三方设置状态Demo");
    setBackBtn(new RepairerSetTextStatusDemoUI..ExternalSyntheticLambda0(this));
    findViewById(b.c.Ott).setOnClickListener(new RepairerSetTextStatusDemoUI..ExternalSyntheticLambda1((EditText)findViewById(b.c.OtV)));
    findViewById(b.c.OtB).setOnClickListener(new RepairerSetTextStatusDemoUI..ExternalSyntheticLambda2(this, "/storage/emulated/0/Android/data/com.tencent.mm/MicroMsg/2c691549c7f50ee66ebd332e8f270d6b/video/vsg_output_1622096801814"));
    AppMethodBeat.o(278290);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerSetTextStatusDemoUI
 * JD-Core Version:    0.7.0.1
 */