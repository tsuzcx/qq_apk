package com.tencent.mm.plugin.mv.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.free.MusicMvFreeMakerPreviewUI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class MusicMvRouterUI$b
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  MusicMvRouterUI$b(MusicMvRouterUI paramMusicMvRouterUI1, MusicMvRouterUI paramMusicMvRouterUI2, kotlin.d.d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(287457);
    paramObject = (kotlin.d.d)new b(this.Max, this.May, paramd);
    AppMethodBeat.o(287457);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(287450);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    Object localObject;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(287450);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.Max;
      localObject = (kotlin.d.d)this;
      this.label = 1;
      localObject = MusicMvRouterUI.a(paramObject, (kotlin.d.d)localObject);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(287450);
        return locala;
      }
    case 1: 
      ResultKt.throwOnFailure(paramObject);
      if (((Boolean)paramObject).booleanValue()) {}
      for (paramObject = new Intent((Context)this.May, MusicMvFreeMakerPreviewUI.class);; paramObject = new Intent((Context)this.May, MusicMvMakerPreviewUI.class))
      {
        localObject = this.Max.getIntent().getByteArrayExtra("key_track_data");
        if (localObject != null) {
          paramObject.putExtra("key_track_data", (byte[])localObject);
        }
        com.tencent.mm.ae.d.a(paramObject, this.Max.getIntent(), "key_mv_music_duration");
        com.tencent.mm.ae.d.a(paramObject, this.Max.getIntent(), "key_mv_from_scene");
        com.tencent.mm.ae.d.a(paramObject, this.Max.getIntent(), "key_mv_enter_maker_ui_from_scene");
        localObject = this.Max;
        paramObject = new com.tencent.mm.hellhoundlib.b.a().cG(paramObject);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramObject.aYi(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$createPreviewMv$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MusicMvRouterUI)localObject).startActivity((Intent)paramObject.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$createPreviewMv$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramObject = (kotlin.d.d)this;
        this.label = 2;
        if (bb.e(500L, paramObject) != locala) {
          break;
        }
        AppMethodBeat.o(287450);
        return locala;
      }
    }
    ResultKt.throwOnFailure(paramObject);
    this.Max.finish();
    paramObject = ah.aiuX;
    AppMethodBeat.o(287450);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvRouterUI.b
 * JD-Core Version:    0.7.0.1
 */