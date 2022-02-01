package com.tencent.mm.plugin.musicchat;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.ui.TransparentCachedFlutterActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode;
import io.flutter.embedding.android.PatchedFlutterActivity.CachedEngineIntentBuilder;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class PluginMusicChat$b
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  PluginMusicChat$b(Context paramContext, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(261400);
    paramd = new b(this.$context, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(261400);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(261391);
    Object localObject2 = kotlin.d.a.a.aiwj;
    Object localObject1;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(261391);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (aq)this.L$0;
      localObject1 = com.tencent.mm.plugin.flutter.b.b.Hke;
      d locald = (d)this;
      this.L$0 = paramObject;
      this.label = 1;
      localObject1 = com.tencent.mm.plugin.flutter.b.b.a((com.tencent.mm.plugin.flutter.b.b)localObject1, "music_chat", locald);
      if (localObject1 == localObject2)
      {
        AppMethodBeat.o(261391);
        return localObject2;
      }
      break;
    case 1: 
      localObject2 = (aq)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject2;
    }
    for (;;)
    {
      localObject2 = (r)localObject1;
      localObject1 = (String)((r)localObject2).bsC;
      localObject2 = ((FlutterEngine)((r)localObject2).bsD).getPlugins();
      ((PluginRegistry)localObject2).add((FlutterPlugin)new com.tencent.mm.plugin.musicchat.model.a());
      ((PluginRegistry)localObject2).add((FlutterPlugin)new com.tencent.mm.plugin.musicchat.model.b());
      if (!ar.a(paramObject))
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(261391);
        return paramObject;
      }
      paramObject = TransparentCachedFlutterActivity.Hlt;
      s.u(localObject1, "cachedEngineId");
      paramObject = new PatchedFlutterActivity.CachedEngineIntentBuilder(TransparentCachedFlutterActivity.class, (String)localObject1).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent);
      s.s(paramObject, "CachedEngineIntentBuilde…ckgroundMode.transparent)");
      localObject1 = paramObject.backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(true).build(this.$context);
      s.s(localObject1, "TransparentCachedFlutter…          .build(context)");
      paramObject = this.$context;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(paramObject, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/musicchat/PluginMusicChat$startSendMusic$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramObject, "com/tencent/mm/plugin/musicchat/PluginMusicChat$startSendMusic$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramObject = ah.aiuX;
      AppMethodBeat.o(261391);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.musicchat.PluginMusicChat.b
 * JD-Core Version:    0.7.0.1
 */