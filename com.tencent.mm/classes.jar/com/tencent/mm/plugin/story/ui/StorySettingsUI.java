package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StorySettingsUI
  extends MMActivity
{
  public static final d StY;
  private static final String TAG;
  private a StZ;
  private StoryCaptureProxy Sua;
  private w Sub;
  private final LinkedList<e> nlG;
  private ListView nlI;
  private com.tencent.mm.remoteservice.d pfZ;
  
  static
  {
    AppMethodBeat.i(119711);
    StY = new d((byte)0);
    TAG = "MicroMsg.StorySettingUI";
    AppMethodBeat.o(119711);
  }
  
  public StorySettingsUI()
  {
    AppMethodBeat.i(119710);
    this.pfZ = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.nlG = new LinkedList();
    AppMethodBeat.o(119710);
  }
  
  private static final void a(StorySettingsUI paramStorySettingsUI)
  {
    AppMethodBeat.i(367222);
    s.u(paramStorySettingsUI, "this$0");
    Log.i(TAG, "has connect");
    paramStorySettingsUI.nlG.add(new c("TestUI", "点我", (View.OnClickListener)new f(paramStorySettingsUI)));
    paramStorySettingsUI.nlG.add(new b("支付Kinda开关", at.a.acYX, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    paramStorySettingsUI.nlG.add(new b("朋友圈入口", at.a.acYM, new String[] { "方案一", "方案二", "关闭", "使用后台动态配置" }, new int[] { 1, 2, 10000, 0 }));
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acYN, 0L);
    if (l <= 0L) {
      l = System.currentTimeMillis();
    }
    for (;;)
    {
      paramStorySettingsUI.nlG.add(new b("朋友圈入口新动态时间重设", at.a.acYN, new String[] { "1个小时前", "2个小时前", "4个小时前", "24个小时前" }, new long[] { l - 3600000L, l - 7200000L, l - 14400000L, l - 86400000L }));
      paramStorySettingsUI.nlG.add(new b("vlog开关", at.a.acWc, new String[] { "关", "开" }, new int[] { 0, 1 }));
      paramStorySettingsUI.nlG.add(new b("vlog新旧逻辑", at.a.acWd, new String[] { "新", "旧" }, new int[] { 0, 1 }));
      Object localObject1 = paramStorySettingsUI.nlG;
      Object localObject2 = at.a.acVW;
      int i = g.a.Sjh.value;
      int j = g.a.Sji.value;
      ((LinkedList)localObject1).add(new b("合成方案", (at.a)localObject2, new String[] { "前台合成", "后台合成" }, new int[] { i, j }));
      paramStorySettingsUI.nlG.add(new b("裁剪方案", at.a.acVX, new String[] { "GPU裁剪", "CPU裁剪" }, new int[] { 2, 1 }));
      paramStorySettingsUI.nlG.add(new b("CameraApi方案", at.a.acZB, new String[] { "Camera1", "Camera2" }, new int[] { 1, 2 }));
      paramStorySettingsUI.nlG.add(new b("编码方案", at.a.acVY, new String[] { "MediaCodec", "x264" }, new int[] { 2, 1 }));
      paramStorySettingsUI.nlG.add(new c("一天九张?", "点我", (View.OnClickListener)new p()));
      paramStorySettingsUI.nlG.add(new c("新手指引", "点我", (View.OnClickListener)new t()));
      paramStorySettingsUI.nlG.add(new b("视频动态足迹开关", at.a.adfG, new String[] { "关", "开" }, new int[] { 0, 1 }));
      paramStorySettingsUI.nlG.add(new c("清空表", "嗯", (View.OnClickListener)new u()));
      localObject2 = paramStorySettingsUI.nlG;
      localObject1 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      if (com.tencent.mm.plugin.recordvideo.c.f.gHq())
      {
        localObject1 = "图片视频不自动合成";
        ((LinkedList)localObject2).add(new c((String)localObject1, "嗯", (View.OnClickListener)new v()));
        localObject2 = paramStorySettingsUI.nlG;
        localObject1 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        if (!com.tencent.mm.plugin.recordvideo.c.f.gHr()) {
          break label1553;
        }
        localObject1 = "视频不重新合成";
        label815:
        ((LinkedList)localObject2).add(new c((String)localObject1, "嗯", (View.OnClickListener)new w()));
        localObject2 = paramStorySettingsUI.nlG;
        if (com.tencent.mm.plugin.story.c.c.NHr) {
          break label1561;
        }
      }
      label1553:
      label1561:
      for (localObject1 = "强制使用软编码";; localObject1 = "不强制使用软编码")
      {
        ((LinkedList)localObject2).add(new c((String)localObject1, "嗯", (View.OnClickListener)new x()));
        paramStorySettingsUI.nlG.add(new c("软编码超时次数+1", "嗯", (View.OnClickListener)new y()));
        paramStorySettingsUI.nlG.add(new c("软编码失败次数+1", "嗯", (View.OnClickListener)new z()));
        paramStorySettingsUI.nlG.add(new c("软编码超时次数-1", "嗯", (View.OnClickListener)new g()));
        paramStorySettingsUI.nlG.add(new c("不删除ext, 删除info/room/file", "嗯", (View.OnClickListener)new StorySettingsUI.h()));
        paramStorySettingsUI.nlG.add(new c("拉取数据", "嗯", (View.OnClickListener)new i()));
        paramStorySettingsUI.nlG.add(new c("所有未读", "嗯", (View.OnClickListener)new j()));
        paramStorySettingsUI.nlG.add(new c("查看Story缓存大小", "嗯", (View.OnClickListener)new k(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("清除Story缓存", "嗯", (View.OnClickListener)new l(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("同步cache到Sdcard", "嗯", (View.OnClickListener)new m(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("点我发送后台失败", "嗯 Test", (View.OnClickListener)new n(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("点我发送超时失败", "嗯 Test", (View.OnClickListener)new o(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("群视频上拉提示", "再看一下", new StorySettingsUI..ExternalSyntheticLambda4(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("冒个泡提示", "再看一次", StorySettingsUI..ExternalSyntheticLambda6.INSTANCE));
        paramStorySettingsUI.nlG.add(new c("首次拍摄", "", StorySettingsUI..ExternalSyntheticLambda7.INSTANCE));
        paramStorySettingsUI.nlG.add(new c("轻触查看", "再来一次", StorySettingsUI..ExternalSyntheticLambda5.INSTANCE));
        paramStorySettingsUI.nlG.add(new c("视频动态过期时长测试", "过期时长设置为1分钟", new StorySettingsUI..ExternalSyntheticLambda3(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("重置大嘴巴显示头像时间", "点我", (View.OnClickListener)new q()));
        paramStorySettingsUI.nlG.add(new c("删除相册缩略图缓存", "删除", new StorySettingsUI..ExternalSyntheticLambda2(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("编辑器", "跳转", new StorySettingsUI..ExternalSyntheticLambda1(paramStorySettingsUI)));
        paramStorySettingsUI.nlG.add(new c("重置视频号朋友圈入口", "点我", (View.OnClickListener)new r()));
        paramStorySettingsUI.nlG.add(new c("支付测试ID", "点我", (View.OnClickListener)new s(paramStorySettingsUI)));
        localObject1 = paramStorySettingsUI.findViewById(a.d.SfY);
        if (localObject1 != null) {
          break label1569;
        }
        paramStorySettingsUI = new NullPointerException("null cannot be cast to non-null type android.widget.ListView");
        AppMethodBeat.o(367222);
        throw paramStorySettingsUI;
        localObject1 = "图片视频自动合成";
        break;
        localObject1 = "视频重新合成";
        break label815;
      }
      label1569:
      paramStorySettingsUI.nlI = ((ListView)localObject1);
      paramStorySettingsUI.StZ = new a();
      localObject2 = paramStorySettingsUI.nlI;
      s.checkNotNull(localObject2);
      localObject1 = paramStorySettingsUI.StZ;
      paramStorySettingsUI = (StorySettingsUI)localObject1;
      if (localObject1 == null)
      {
        s.bIx("adapter");
        paramStorySettingsUI = null;
      }
      ((ListView)localObject2).setAdapter((ListAdapter)paramStorySettingsUI);
      AppMethodBeat.o(367222);
      return;
    }
  }
  
  private static final void a(StorySettingsUI paramStorySettingsUI, View paramView)
  {
    AppMethodBeat.i(367229);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStorySettingsUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStorySettingsUI, "this$0");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acYw, Boolean.FALSE);
    com.tencent.mm.ui.base.k.c((Context)paramStorySettingsUI.getContext(), "在群视频，不要上滑，静候5秒", "", true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367229);
  }
  
  private static final boolean a(StorySettingsUI paramStorySettingsUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(367226);
    s.u(paramStorySettingsUI, "this$0");
    paramStorySettingsUI.finish();
    AppMethodBeat.o(367226);
    return false;
  }
  
  private static final void b(StorySettingsUI paramStorySettingsUI, View paramView)
  {
    AppMethodBeat.i(367241);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStorySettingsUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStorySettingsUI, "this$0");
    paramView = i.SjL;
    i.hvA();
    com.tencent.mm.ui.base.k.c((Context)paramStorySettingsUI.getContext(), "ok！", "", true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367241);
  }
  
  private static final void c(StorySettingsUI paramStorySettingsUI, View paramView)
  {
    AppMethodBeat.i(367244);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStorySettingsUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStorySettingsUI, "this$0");
    try
    {
      y.ew(paramStorySettingsUI.getContext().getExternalCacheDir() + "/imgcache", true);
      label89:
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367244);
      return;
    }
    catch (Exception paramStorySettingsUI)
    {
      break label89;
    }
  }
  
  private static final void d(StorySettingsUI paramStorySettingsUI, View paramView)
  {
    AppMethodBeat.i(367248);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStorySettingsUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStorySettingsUI, "this$0");
    paramView = new Intent();
    paramView.putExtra("KEY_EDITABLE", true);
    paramView.putExtra("KEY_CONTENT_XML", paramStorySettingsUI.getSharedPreferences("test_plugin", 0).getString("content", ""));
    com.tencent.mm.br.c.b((Context)paramStorySettingsUI.getContext(), "editor", ".EditorUI", paramView, 4096);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367248);
  }
  
  private static final void kf(View paramView)
  {
    AppMethodBeat.i(367233);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acYv, Integer.valueOf(0));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367233);
  }
  
  private static final void kg(View paramView)
  {
    AppMethodBeat.i(367236);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acYx, Boolean.FALSE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367236);
  }
  
  private static final void kh(View paramView)
  {
    AppMethodBeat.i(367239);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acYz, Boolean.FALSE);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acYA, Boolean.FALSE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367239);
  }
  
  public final int getLayoutId()
  {
    return a.e.Sha;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(178052);
    if ((4096 == paramInt1) && (-1 == paramInt2)) {
      if (paramIntent != null) {
        break label65;
      }
    }
    label65:
    for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("KEY_CONTENT_XML"))
    {
      if (!Util.isNullOrNil(paramIntent)) {
        getSharedPreferences("test_plugin", 0).edit().putString("content", paramIntent).apply();
      }
      AppMethodBeat.o(178052);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119706);
    super.onCreate(paramBundle);
    this.Sua = new StoryCaptureProxy(this.pfZ);
    this.pfZ.connect(new StorySettingsUI..ExternalSyntheticLambda8(this));
    setBackBtn(new StorySettingsUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(119706);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119707);
    super.onDestroy();
    this.pfZ.release();
    AppMethodBeat.o(119707);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119709);
    super.onPause();
    AppMethodBeat.o(119709);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119708);
    super.onResume();
    AppMethodBeat.o(119708);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends BaseAdapter
  {
    public a()
    {
      AppMethodBeat.i(367243);
      AppMethodBeat.o(367243);
    }
    
    private static final void a(StorySettingsUI.e parame, TextView paramTextView, View paramView)
    {
      AppMethodBeat.i(367245);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parame);
      localb.cH(paramTextView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parame, "$item");
      s.u(paramTextView, "$textView");
      parame.di((View)paramTextView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367245);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(119659);
      int i = StorySettingsUI.e(this.Suc).size();
      AppMethodBeat.o(119659);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119660);
      Object localObject = StorySettingsUI.e(this.Suc).get(paramInt);
      s.s(localObject, "selectsList[position]");
      AppMethodBeat.o(119660);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(119661);
      s.u(paramViewGroup, "parent");
      paramView = new TextView((Context)this.Suc);
      paramViewGroup = (StorySettingsUI.e)getItem(paramInt);
      paramView.setText((CharSequence)(paramViewGroup.aUa() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new StorySettingsUI.a..ExternalSyntheticLambda0(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(119661);
      return paramView;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements StorySettingsUI.e
  {
    private String nlK;
    private at.a nlL;
    private String[] nlM;
    private Object nlN;
    
    public b(at.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(119666);
      this.nlK = parama;
      this.nlL = paramArrayOfString;
      this.nlM = paramObject;
      this.nlN = localObject;
      AppMethodBeat.o(119666);
    }
    
    private static final void a(b paramb, StorySettingsUI paramStorySettingsUI, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(367249);
      s.u(paramb, "this$0");
      s.u(paramStorySettingsUI, "this$1");
      try
      {
        Object localObject = paramb.nlN;
        if ((localObject instanceof long[]))
        {
          localObject = StorySettingsUI.c(paramStorySettingsUI);
          s.checkNotNull(localObject);
          ((StoryCaptureProxy)localObject).set(paramb.nlL, Long.valueOf(((long[])paramb.nlN)[paramInt1]));
        }
        for (;;)
        {
          paramStorySettingsUI = StorySettingsUI.d(paramStorySettingsUI);
          paramb = paramStorySettingsUI;
          if (paramStorySettingsUI == null)
          {
            s.bIx("adapter");
            paramb = null;
          }
          paramb.notifyDataSetChanged();
          AppMethodBeat.o(367249);
          return;
          if ((localObject instanceof int[]))
          {
            localObject = StorySettingsUI.c(paramStorySettingsUI);
            s.checkNotNull(localObject);
            ((StoryCaptureProxy)localObject).set(paramb.nlL, Integer.valueOf(((int[])paramb.nlN)[paramInt1]));
          }
        }
        return;
      }
      catch (Exception paramb)
      {
        paramStorySettingsUI = StorySettingsUI.StY;
        Log.printErrStackTrace(StorySettingsUI.access$getTAG$cp(), (Throwable)paramb, "", new Object[0]);
        AppMethodBeat.o(367249);
      }
    }
    
    private final String gw(Object paramObject)
    {
      AppMethodBeat.i(119665);
      Object localObject = this.nlN;
      long l;
      int k;
      if ((localObject instanceof long[]))
      {
        l = ((Long)paramObject).longValue();
        k = ((long[])this.nlN).length - 1;
        if (k < 0) {}
      }
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if ((l == ((long[])this.nlN)[i]) && (i < this.nlM.length))
        {
          paramObject = this.nlM[i];
          AppMethodBeat.o(119665);
          return paramObject;
        }
        if (j > k)
        {
          paramObject = this.nlM[0];
          AppMethodBeat.o(119665);
          return paramObject;
          int m;
          if ((localObject instanceof int[]))
          {
            k = ((Integer)paramObject).intValue();
            m = ((int[])this.nlN).length - 1;
            if (m < 0) {}
          }
          for (i = 0;; i = j)
          {
            j = i + 1;
            if ((k == ((int[])this.nlN)[i]) && (i < this.nlM.length))
            {
              paramObject = this.nlM[i];
              AppMethodBeat.o(119665);
              return paramObject;
            }
            if (j > m)
            {
              paramObject = this.nlM[0];
              AppMethodBeat.o(119665);
              return paramObject;
              AppMethodBeat.o(119665);
              return "";
            }
          }
        }
      }
    }
    
    public final String aUa()
    {
      return this.nlK;
    }
    
    public final void di(View paramView)
    {
      AppMethodBeat.i(119664);
      s.u(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int k = this.nlM.length - 1;
      if (k >= 0) {}
      for (;;)
      {
        int j = i + 1;
        paramView.add(this.nlM[i]);
        localLinkedList.add(Integer.valueOf(i));
        if (j > k)
        {
          com.tencent.mm.ui.base.k.a((Context)StorySettingsUI.this, "", (List)paramView, (List)localLinkedList, "", new StorySettingsUI.b..ExternalSyntheticLambda0(this, StorySettingsUI.this));
          AppMethodBeat.o(119664);
          return;
        }
        i = j;
      }
    }
    
    public final String value()
    {
      AppMethodBeat.i(119663);
      if ((this.nlN instanceof long[]))
      {
        localObject = StorySettingsUI.c(StorySettingsUI.this);
        s.checkNotNull(localObject);
        localObject = gw(((StoryCaptureProxy)localObject).get(this.nlL, Long.valueOf(0L)));
        AppMethodBeat.o(119663);
        return localObject;
      }
      Object localObject = StorySettingsUI.c(StorySettingsUI.this);
      s.checkNotNull(localObject);
      localObject = gw(((StoryCaptureProxy)localObject).get(this.nlL, Integer.valueOf(0)));
      AppMethodBeat.o(119663);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements StorySettingsUI.e
  {
    private final View.OnClickListener Rxj;
    private final String title;
    private final String value;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(119668);
      this.title = paramString1;
      this.value = paramString2;
      this.Rxj = paramOnClickListener;
      AppMethodBeat.o(119668);
    }
    
    public final String aUa()
    {
      return this.title;
    }
    
    public final void di(View paramView)
    {
      AppMethodBeat.i(119667);
      s.u(paramView, "view");
      this.Rxj.onClick(paramView);
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)"ClickItem Done", 1).show();
      AppMethodBeat.o(119667);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e
  {
    public abstract String aUa();
    
    public abstract void di(View paramView);
    
    public abstract String value();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements View.OnClickListener
  {
    f(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119669);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      localObject = new Intent((Context)this.Suc, Class.forName("com.tencent.mm.plugin.ui.SampleListUI"));
      paramView = this.Suc;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119669);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119670);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      com.tencent.mm.plugin.story.c.c.vK(10000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119670);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119674);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = com.tencent.mm.plugin.story.model.sync.a.SmO;
      com.tencent.mm.plugin.story.model.sync.a.hwQ();
      com.tencent.mm.ae.d.a(5000L, (kotlin.g.a.a)a.Sud);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119674);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      public static final a Sud;
      
      static
      {
        AppMethodBeat.i(119673);
        Sud = new a();
        AppMethodBeat.o(119673);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119675);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = StoryCore.SjP;
      StoryCore.vM(0L);
      new com.tencent.mm.plugin.story.model.h();
      com.tencent.mm.plugin.story.model.h.hvx();
      com.tencent.mm.plugin.story.model.sync.a.SmO.init();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119675);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements View.OnClickListener
  {
    k(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119676);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = com.tencent.mm.plugin.story.model.k.Skq;
      paramView = com.tencent.mm.plugin.story.model.k.hwh();
      com.tencent.mm.ui.base.k.c((Context)this.Suc.getContext(), paramView, "嗯", true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119676);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements View.OnClickListener
  {
    l(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119677);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = StoryCore.SjP;
      y.ew(StoryCore.b.getAccStoryCachePath(), true);
      com.tencent.mm.ui.base.k.c((Context)this.Suc.getContext(), "ok", "嗯", true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119677);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements View.OnClickListener
  {
    m(StorySettingsUI paramStorySettingsUI) {}
    
    private static final void a(StorySettingsUI paramStorySettingsUI, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(367221);
      s.u(paramStorySettingsUI, "this$0");
      paramStorySettingsUI.finish();
      AppMethodBeat.o(367221);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119681);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      paramView = this.Suc;
      localObject = (Context)this.Suc.getContext();
      this.Suc.getString(a.g.app_tip);
      StorySettingsUI.a(paramView, com.tencent.mm.ui.base.k.a((Context)localObject, this.Suc.getString(a.g.app_waiting), true, new StorySettingsUI.m..ExternalSyntheticLambda0(this.Suc)));
      com.tencent.mm.ae.d.d("cpfiles", (kotlin.g.a.a)new a(this.Suc));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119681);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(StorySettingsUI paramStorySettingsUI)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements View.OnClickListener
  {
    n(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119682);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (!z.pDs) {}
      for (boolean bool = true;; bool = false)
      {
        z.pDs = bool;
        com.tencent.mm.ui.base.k.c((Context)this.Suc.getContext(), s.X("ok value Test Fail:", Boolean.valueOf(z.pDs)), "嗯", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119682);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements View.OnClickListener
  {
    o(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119683);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (!z.pDt) {}
      for (boolean bool = true;; bool = false)
      {
        z.pDt = bool;
        com.tencent.mm.ui.base.k.c((Context)this.Suc.getContext(), s.X("ok value Test Fail:", Boolean.valueOf(z.pDt)), "嗯", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119683);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119685);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      new com.tencent.mm.plugin.story.model.h();
      com.tencent.mm.plugin.story.model.h.hvy();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119685);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119693);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYP, Long.valueOf(0L));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119693);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119696);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgt, Integer.valueOf(0));
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119696);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements View.OnClickListener
  {
    s(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178049);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      com.tencent.mm.plugin.ae.a.c.gxP().jm((Context)this.Suc.getContext());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178049);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119697);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYG, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYI, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYH, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYw, Boolean.FALSE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYv, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYx, Boolean.FALSE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYy, Boolean.FALSE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYz, Boolean.FALSE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYA, Boolean.FALSE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYJ, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYK, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYU, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYB, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYC, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfF, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfH, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfN, "");
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119697);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119698);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      new com.tencent.mm.plugin.story.model.h();
      com.tencent.mm.plugin.story.model.h.hvw();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119698);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class v
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119699);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      paramView = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      if (!com.tencent.mm.plugin.recordvideo.c.f.gHq()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.c.f.AV(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119699);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class w
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119700);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      paramView = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      if (!com.tencent.mm.plugin.recordvideo.c.f.gHr()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.c.f.AW(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119700);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class x
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119701);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (!com.tencent.mm.plugin.story.c.c.NHr) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.story.c.c.NHr = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119701);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class y
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119702);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      com.tencent.mm.plugin.story.c.c.vK(100000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119702);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class z
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119703);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      com.tencent.mm.plugin.story.c.c.hvd();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI
 * JD-Core Version:    0.7.0.1
 */