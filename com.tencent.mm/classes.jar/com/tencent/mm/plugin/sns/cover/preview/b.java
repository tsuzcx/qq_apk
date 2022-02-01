package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverDefaultView;", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "changeCoverTxt", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getChangeCoverTxt", "()Landroid/widget/TextView;", "changeCoverTxt$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "getType", "loadCover", "", "info", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverInfo;", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.sns.cover.a.a
{
  private final j QlR;
  private final String TAG;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(307420);
    this.TAG = "MicroMsg.SnsCoverDefaultView";
    this.QlR = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(307420);
  }
  
  private final TextView getChangeCoverTxt()
  {
    AppMethodBeat.i(307426);
    TextView localTextView = (TextView)this.QlR.getValue();
    AppMethodBeat.o(307426);
    return localTextView;
  }
  
  public final void a(com.tencent.mm.plugin.sns.cover.a.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(307433);
    Object localObject2 = h.baE().ban().d(2, null);
    if (paramb == null) {}
    for (paramb = localObject1;; paramb = paramb.getUserName())
    {
      if (!s.p(localObject2, paramb)) {
        getChangeCoverTxt().setVisibility(8);
      }
      AppMethodBeat.o(307433);
      return;
    }
  }
  
  public final void etL()
  {
    AppMethodBeat.i(307447);
    Log.i(this.TAG, "[onPreOpen]");
    AppMethodBeat.o(307447);
  }
  
  public final void etM() {}
  
  public final void etO() {}
  
  public final int getLayoutId()
  {
    return b.g.sns_cover_default_view;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final void onDestroy() {}
  
  public final void onPause() {}
  
  public final void onPostClose()
  {
    AppMethodBeat.i(307457);
    Log.i(this.TAG, "[onPreClose]");
    AppMethodBeat.o(307457);
  }
  
  public final void onResume() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.b
 * JD-Core Version:    0.7.0.1
 */