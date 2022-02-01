package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.media.AudioAttributes.Builder;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.vo;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.k.a;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ui.base.a(1)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingMessageRingtoneUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;", "()V", "cancelFuture", "Ljava/util/concurrent/Future;", "curIndex", "", "Ljava/lang/Integer;", "lastPathId", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mChooseMessageRingtone", "Lcom/tencent/mm/config/MessageRingtone;", "mClickSoundPool", "Landroid/media/SoundPool;", "mSystemRingtone", "Landroid/media/Ringtone;", "messageRingtoneList", "Ljava/util/ArrayList;", "getMessageRingtoneList", "()Ljava/util/ArrayList;", "oriIndex", "ringtoneResUpdateListener", "com/tencent/mm/plugin/setting/ui/setting/SettingMessageRingtoneUI$ringtoneResUpdateListener$1", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingMessageRingtoneUI$ringtoneResUpdateListener$1;", "ringtoneRv", "Landroidx/recyclerview/widget/RecyclerView;", "getRingtoneRv", "()Landroidx/recyclerview/widget/RecyclerView;", "ringtoneRv$delegate", "Lkotlin/Lazy;", "backConfirm", "", "confirm", "getLayoutId", "initView", "isSelect", "", "composition", "notifyDataSetChanged", "onBackPressed", "onChoose", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "playSound", "path", "", "Companion", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public class SettingMessageRingtoneUI
  extends MMActivity
  implements c.a
{
  public static final SettingMessageRingtoneUI.a Pqc;
  private SoundPool JyD;
  private Future<?> Pqd;
  private final ArrayList<g> Pqe;
  private final j Pqf;
  private Integer Pqg;
  private Integer Pqh;
  private Integer Pqi;
  private final ringtoneResUpdateListener.1 Pqj;
  private Ringtone Pqk;
  private g Pql;
  private w xEL;
  
  static
  {
    AppMethodBeat.i(298895);
    Pqc = new SettingMessageRingtoneUI.a((byte)0);
    AppMethodBeat.o(298895);
  }
  
  public SettingMessageRingtoneUI()
  {
    AppMethodBeat.i(298853);
    this.Pqe = new ArrayList();
    this.Pqf = k.cm((kotlin.g.a.a)new b(this));
    this.Pqj = new IListener(f.hfK)
    {
      private static final void d(SettingMessageRingtoneUI paramAnonymousSettingMessageRingtoneUI)
      {
        AppMethodBeat.i(299000);
        s.u(paramAnonymousSettingMessageRingtoneUI, "this$0");
        Future localFuture = SettingMessageRingtoneUI.b(paramAnonymousSettingMessageRingtoneUI);
        if (localFuture != null) {
          localFuture.cancel(true);
        }
        paramAnonymousSettingMessageRingtoneUI = SettingMessageRingtoneUI.c(paramAnonymousSettingMessageRingtoneUI);
        if (paramAnonymousSettingMessageRingtoneUI != null) {
          paramAnonymousSettingMessageRingtoneUI.hide();
        }
        AppMethodBeat.o(299000);
      }
    };
    AppMethodBeat.o(298853);
  }
  
  private static final void a(SettingMessageRingtoneUI paramSettingMessageRingtoneUI)
  {
    AppMethodBeat.i(298886);
    s.u(paramSettingMessageRingtoneUI, "this$0");
    w localw = paramSettingMessageRingtoneUI.xEL;
    if (localw != null) {
      localw.cancel();
    }
    aa.dc(MMApplicationContext.getContext(), paramSettingMessageRingtoneUI.getString(b.i.new_msg_notification_ringtone_error));
    AppMethodBeat.o(298886);
  }
  
  private static final void a(SettingMessageRingtoneUI paramSettingMessageRingtoneUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(298881);
    s.u(paramSettingMessageRingtoneUI, "this$0");
    paramSettingMessageRingtoneUI.finish();
    AppMethodBeat.o(298881);
  }
  
  private static final void a(SettingMessageRingtoneUI paramSettingMessageRingtoneUI, String paramString, SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(298892);
    s.u(paramSettingMessageRingtoneUI, "this$0");
    s.u(paramString, "$path");
    if (paramInt2 == 0)
    {
      paramSettingMessageRingtoneUI.Pqg = Integer.valueOf(paramInt1);
      paramSettingMessageRingtoneUI = paramSettingMessageRingtoneUI.JyD;
      if (paramSettingMessageRingtoneUI != null)
      {
        paramSettingMessageRingtoneUI.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
        AppMethodBeat.o(298892);
      }
    }
    else
    {
      Log.e("MicroMsg.SettingMessageRingtoneUI", "SoundPool load error pathId " + paramString + " status " + paramInt2);
    }
    AppMethodBeat.o(298892);
  }
  
  private static final void a(SettingMessageRingtoneUI paramSettingMessageRingtoneUI, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(298870);
    s.u(paramSettingMessageRingtoneUI, "this$0");
    if (paramBoolean)
    {
      paramSettingMessageRingtoneUI.confirm();
      AppMethodBeat.o(298870);
      return;
    }
    paramSettingMessageRingtoneUI.finish();
    AppMethodBeat.o(298870);
  }
  
  private static final boolean a(SettingMessageRingtoneUI paramSettingMessageRingtoneUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(298874);
    s.u(paramSettingMessageRingtoneUI, "this$0");
    paramSettingMessageRingtoneUI.gVk();
    AppMethodBeat.o(298874);
    return true;
  }
  
  private static final boolean b(SettingMessageRingtoneUI paramSettingMessageRingtoneUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(298877);
    s.u(paramSettingMessageRingtoneUI, "this$0");
    paramSettingMessageRingtoneUI.confirm();
    AppMethodBeat.o(298877);
    return true;
  }
  
  private final void confirm()
  {
    AppMethodBeat.i(298865);
    Object localObject = this.Pql;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((g)localObject).index))
    {
      Log.i("MicroMsg.SettingMessageRingtoneUI", s.X("finish ", localObject));
      localObject = this.Pql;
      if (localObject != null)
      {
        com.tencent.mm.k.b.rf(((g)localObject).index);
        com.tencent.mm.plugin.notification.b.aQu(com.tencent.mm.k.b.rg(((g)localObject).index));
      }
      finish();
      AppMethodBeat.o(298865);
      return;
    }
  }
  
  private RecyclerView gVj()
  {
    AppMethodBeat.i(298857);
    Object localObject = this.Pqf.getValue();
    s.s(localObject, "<get-ringtoneRv>(...)");
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(298857);
    return localObject;
  }
  
  private void gVk()
  {
    AppMethodBeat.i(298862);
    if (!s.p(this.Pqi, this.Pqh))
    {
      g.a locala = new g.a((Context)getContext());
      locala.bDE(getString(b.i.setting_ringtone_modify_tips)).bDI(getString(b.i.app_keep)).bDJ(getString(b.i.app_cancel));
      locala.c(new SettingMessageRingtoneUI..ExternalSyntheticLambda4(this)).show();
      AppMethodBeat.o(298862);
      return;
    }
    finish();
    AppMethodBeat.o(298862);
  }
  
  private static final void gVl()
  {
    AppMethodBeat.i(298888);
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    String str = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(96, 1);
    boolean bool2 = y.ZC(str);
    boolean bool1 = false;
    if (bool2) {
      bool1 = PluginNotification.handleRingtoneResUpdate(str);
    }
    Log.i("MicroMsg.SettingMessageRingtoneUI", "handle cachefile, cacheExist:" + bool2 + ", result:" + bool1);
    AppMethodBeat.o(298888);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(298948);
    s.u(paramg, "composition");
    Object localObject1 = this.Pqh;
    int i = paramg.index;
    if (localObject1 == null) {}
    for (;;)
    {
      enableOptionMenu(0, true);
      do
      {
        localObject1 = com.tencent.mm.k.b.rg(paramg.index);
        this.Pql = paramg;
        this.Pqi = Integer.valueOf(paramg.index);
        Object localObject2 = this.Pqk;
        if (localObject2 != null) {
          ((Ringtone)localObject2).stop();
        }
        localObject2 = this.Pqg;
        if (localObject2 != null)
        {
          i = ((Number)localObject2).intValue();
          localObject2 = this.JyD;
          if (localObject2 != null) {
            ((SoundPool)localObject2).stop(i);
          }
        }
        if (paramg.index == 0) {
          break;
        }
        s.s(localObject1, "path");
        if (this.JyD == null) {
          this.JyD = new SoundPool.Builder().setMaxStreams(10).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(5).build()).build();
        }
        paramg = this.JyD;
        if (paramg != null) {
          paramg.load(y.n((String)localObject1, true), 1);
        }
        paramg = this.JyD;
        if (paramg != null) {
          paramg.setOnLoadCompleteListener(new SettingMessageRingtoneUI..ExternalSyntheticLambda1(this, (String)localObject1));
        }
        AppMethodBeat.o(298948);
        return;
      } while (((Integer)localObject1).intValue() == i);
    }
    this.Pqk = RingtoneManager.getRingtone((Context)getContext(), RingtoneManager.getDefaultUri(2));
    paramg = this.Pqk;
    if (paramg != null) {
      paramg.play();
    }
    AppMethodBeat.o(298948);
  }
  
  public final boolean b(g paramg)
  {
    AppMethodBeat.i(298963);
    s.u(paramg, "composition");
    Integer localInteger = this.Pqi;
    int i = paramg.index;
    if (localInteger == null) {}
    while (localInteger.intValue() != i)
    {
      AppMethodBeat.o(298963);
      return false;
    }
    AppMethodBeat.o(298963);
    return true;
  }
  
  public int getLayoutId()
  {
    return b.g.settings_message_ringtone_picker;
  }
  
  public void initView()
  {
    AppMethodBeat.i(298936);
    setMMTitle(b.i.settings_notification_ringtone_title);
    setBackBtn(new SettingMessageRingtoneUI..ExternalSyntheticLambda3(this));
    addTextOptionMenu(0, getContext().getString(b.i.app_finish), new SettingMessageRingtoneUI..ExternalSyntheticLambda2(this), null, y.b.adEJ);
    enableOptionMenu(0, false);
    hideActionbarLine();
    gVj().setAdapter((RecyclerView.a)new b(this.Pqe, (c.a)this));
    Object localObject1 = new WxLinearLayoutManager((Context)getContext());
    ((WxLinearLayoutManager)localObject1).setOrientation(1);
    gVj().setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = gVj();
    Object localObject2 = getContext();
    s.s(localObject2, "context");
    localObject2 = new k.a((Context)localObject2).a(e.agNS).aGi(b.c.line_color).aGj(b.c.transparent).aGh(b.d.DividerHeight);
    int i = b.d.Edge_2A;
    ((k.a)localObject2).agOo = ((k.a)localObject2).mResources.getDimensionPixelSize(i);
    ((k.a)localObject2).agOn = ((k.a)localObject2).mResources.getDimensionPixelSize(i);
    ((RecyclerView)localObject1).a((RecyclerView.h)((k.a)localObject2).jNn());
    Log.i("MicroMsg.SettingMessageRingtoneUI", s.X("current ringtone:", Integer.valueOf(com.tencent.mm.k.b.aQQ())));
    if (!y.ZC(com.tencent.mm.k.b.rg(1)))
    {
      Log.e("MicroMsg.SettingMessageRingtoneUI", "file no exits");
      this.Pqj.alive();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(96);
      this.xEL = w.a((Context)getContext(), (CharSequence)getContext().getString(b.i.loading_tips_1), true, 3, new SettingMessageRingtoneUI..ExternalSyntheticLambda0(this));
      this.Pqd = ((Future)h.ahAA.o(new SettingMessageRingtoneUI..ExternalSyntheticLambda5(this), 15000L));
      h.ahAA.bm(SettingMessageRingtoneUI..ExternalSyntheticLambda6.INSTANCE);
    }
    AppMethodBeat.o(298936);
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(298957);
    RecyclerView.a locala = gVj().getAdapter();
    if (locala != null) {
      locala.bZE.notifyChanged();
    }
    AppMethodBeat.o(298957);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(298926);
    gVk();
    AppMethodBeat.o(298926);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298922);
    super.onCreate(paramBundle);
    this.Pqe.addAll((Collection)com.tencent.mm.k.b.dk((Context)this));
    this.Pqh = Integer.valueOf(com.tencent.mm.k.b.aQQ());
    paramBundle = this.Pqh;
    if (paramBundle == null) {}
    for (;;)
    {
      this.Pqi = this.Pqh;
      initView();
      AppMethodBeat.o(298922);
      return;
      if (paramBundle.intValue() == -1) {
        this.Pqh = Integer.valueOf(0);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(298942);
    Object localObject = this.Pqk;
    if (localObject != null) {
      ((Ringtone)localObject).stop();
    }
    localObject = this.JyD;
    if (localObject != null) {
      ((SoundPool)localObject).release();
    }
    super.onDestroy();
    this.Pqj.dead();
    AppMethodBeat.o(298942);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    b(SettingMessageRingtoneUI paramSettingMessageRingtoneUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingMessageRingtoneUI
 * JD-Core Version:    0.7.0.1
 */