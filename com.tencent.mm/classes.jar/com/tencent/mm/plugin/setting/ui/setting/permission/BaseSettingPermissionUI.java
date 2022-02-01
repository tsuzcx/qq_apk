package com.tencent.mm.plugin.setting.ui.setting.permission;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qi;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/permission/BaseSettingPermissionUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "mActionBarContainer", "Landroid/view/View;", "mStatusBarHeightCallback", "Lcom/tencent/mm/ui/statusbar/StatusBarHeightWatcher$OnStatusBarHeightChangeCallback;", "fixActionBarStuff", "", "getContentLayoutId", "", "getLayoutId", "getPermissionDesc", "getTitleId", "initContentView", "initDesc", "initScrollView", "initTitleView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setWindowStyle", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseSettingPermissionUI
  extends MMActivity
{
  private final String TAG = "BaseSettingPermissionUI";
  
  private static final void a(int paramInt1, TextView paramTextView, View paramView, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramTextView.setAlpha(paramInt3 / paramInt1);
  }
  
  private static final void a(BaseSettingPermissionUI paramBaseSettingPermissionUI, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseSettingPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/permission/BaseSettingPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseSettingPermissionUI, "this$0");
    paramBaseSettingPermissionUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/permission/BaseSettingPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public abstract int dTn();
  
  public abstract int gWA();
  
  public abstract int gWz();
  
  public int getLayoutId()
  {
    return b.g.setting_permission_base_view_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      getContext().getWindow().getDecorView().setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      getContext().getWindow().setStatusBarColor(getResources().getColor(b.c.BG_2));
      getContext().getWindow().setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    setMMTitle("");
    paramBundle = findViewById(b.f.back);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new BaseSettingPermissionUI..ExternalSyntheticLambda0(this));
    }
    paramBundle = (TextView)findViewById(b.f.title);
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)getString(gWA()));
    }
    aw.a((Paint)((TextView)findViewById(b.f.title)).getPaint(), 0.8F);
    ((FrameLayout)findViewById(b.f.title_container)).setPadding(0, bf.getStatusBarHeight((Context)getContext()), 0, 0);
    paramBundle = af.mU((Context)this).inflate(dTn(), null);
    ((ScrollView)findViewById(b.f.scrollview)).addView(paramBundle);
    supportLightStatusBar();
    paramBundle = (TextView)findViewById(b.f.setting_permission_desc);
    String str1;
    if (paramBundle != null)
    {
      paramBundle.setGravity(17);
      str1 = getString(gWz());
      s.s(str1, "getString(getPermissionDesc())");
      String str2 = getString(b.i.setting_permission_overlay_desc_default_suffix);
      s.s(str2, "getString(R.string.setti…rlay_desc_default_suffix)");
      Object localObject = getString(b.i.setting_permission_overlay_desc_default_suffix_replace);
      s.s(localObject, "getString(R.string.setti…c_default_suffix_replace)");
      str1 = s.X(str1, str2);
      int i = n.a((CharSequence)str1, (String)localObject, 0, false, 6);
      int j = i + ((String)localObject).length();
      if ((i <= 0) || (j >= str1.length())) {
        break label507;
      }
      localObject = new SpannableString((CharSequence)str1);
      ((SpannableString)localObject).setSpan(new a(this), i, j, 33);
      paramBundle.setText((CharSequence)localObject);
      paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramBundle = (ScrollView)findViewById(b.f.scrollview);
        if (paramBundle != null) {
          paramBundle.setOnScrollChangeListener(new BaseSettingPermissionUI..ExternalSyntheticLambda1(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 64), (TextView)findViewById(b.f.title)));
        }
      }
      return;
      label507:
      paramBundle.setText((CharSequence)str1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/permission/BaseSettingPermissionUI$initDesc$1$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ClickableSpan
  {
    a(BaseSettingPermissionUI paramBaseSettingPermissionUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(299331);
      s.u(paramView, "widget");
      paramView = new qi();
      paramView.ikE = 101L;
      paramView.bMH();
      com.tencent.mm.pluginsdk.permission.b.lx((Context)this.PxU);
      AppMethodBeat.o(299331);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(299336);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(this.PxU.getContext().getResources().getColor(b.c.Link));
      AppMethodBeat.o(299336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.permission.BaseSettingPermissionUI
 * JD-Core Version:    0.7.0.1
 */