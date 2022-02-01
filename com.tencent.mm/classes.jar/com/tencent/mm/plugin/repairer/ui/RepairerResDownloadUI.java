package com.tencent.mm.plugin.repairer.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.d.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "onSceneEnd", "com/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI$onSceneEnd$1", "Lcom/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI$onSceneEnd$1;", "outputStringBuffer", "Ljava/lang/StringBuffer;", "resUpdateListener", "com/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI$resUpdateListener$1", "Lcom/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI$resUpdateListener$1;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerResDownloadUI
  extends BaseRepairerUI
{
  private StringBuffer Owt;
  private final resUpdateListener.1 Owu;
  private final a Owv;
  
  public RepairerResDownloadUI()
  {
    AppMethodBeat.i(277867);
    this.Owt = new StringBuffer();
    this.Owu = new IListener(f.hfK)
    {
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(RepairerResDownloadUI paramRepairerResDownloadUI)
        {
          super();
        }
      }
    };
    this.Owv = new a(this);
    AppMethodBeat.o(277867);
  }
  
  private static final void a(RepairerResDownloadUI paramRepairerResDownloadUI, View paramView)
  {
    AppMethodBeat.i(277878);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerResDownloadUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRepairerResDownloadUI, "this$0");
    int i = i.ew(((MMEditText)paramRepairerResDownloadUI.findViewById(b.c.Ovk)).getText().toString());
    if (i != 0)
    {
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(i);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277878);
  }
  
  private static final boolean a(RepairerResDownloadUI paramRepairerResDownloadUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277873);
    kotlin.g.b.s.u(paramRepairerResDownloadUI, "this$0");
    paramRepairerResDownloadUI.finish();
    AppMethodBeat.o(277873);
    return false;
  }
  
  public final int getLayoutId()
  {
    return b.d.OvY;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277911);
    super.onCreate(paramBundle);
    setBackBtn(new RepairerResDownloadUI..ExternalSyntheticLambda0(this));
    paramBundle = findViewById(b.c.ok_btn);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerResDownloadUI..ExternalSyntheticLambda1(this));
    }
    this.Owu.alive();
    h.aZW().a(721, (q)this, (com.tencent.mm.am.b.a)this.Owv);
    AppMethodBeat.o(277911);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277916);
    super.onDestroy();
    this.Owu.dead();
    AppMethodBeat.o(277916);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/RepairerResDownloadUI$onSceneEnd$1", "Lcom/tencent/mm/modelbase/observer/INetSceneObserver;", "onChanged", "", "event", "Lcom/tencent/mm/modelbase/observer/NetSceneEvent;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.am.b.a
  {
    a(RepairerResDownloadUI paramRepairerResDownloadUI) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(RepairerResDownloadUI paramRepairerResDownloadUI)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class resUpdateListener$1$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    resUpdateListener$1$a(RepairerResDownloadUI paramRepairerResDownloadUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerResDownloadUI
 * JD-Core Version:    0.7.0.1
 */