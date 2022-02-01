package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$c
  implements com.tencent.mm.plugin.thumbplayer.view.d
{
  g$c(g paramg, AppCompatActivity paramAppCompatActivity) {}
  
  public final void a(int paramInt, final com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(287652);
    s.u(paramb, "targetMedia");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.Met, paramb, this, this.Awh));
    AppMethodBeat.o(287652);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(g paramg, com.tencent.mm.plugin.thumbplayer.a.b paramb, g.c paramc, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    private static final void a(Object paramObject, g paramg, View paramView)
    {
      AppMethodBeat.i(288129);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramObject);
      localb.cH(paramg);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramg, "this$0");
      paramObject = ((FinderObject)paramObject).contact;
      if (paramObject != null)
      {
        paramObject = paramObject.username;
        if (paramObject != null) {
          paramg.cB(paramObject, false);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.g.c
 * JD-Core Version:    0.7.0.1
 */