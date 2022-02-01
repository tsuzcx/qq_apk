package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.l.f;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/Festival2021Widget;", "Lcom/tencent/mm/plugin/sns/ui/FinderLiveWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "snsType", "", "getSnsType", "()I", "onPrepareCommitPack", "", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "safeGet", "", "Landroid/content/Intent;", "key", "block", "Lkotlin/Function1;", "Lkotlin/reflect/KFunction1;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends u
{
  private final int RcH;
  
  public t(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(308031);
    this.RcH = 43;
    AppMethodBeat.o(308031);
  }
  
  private static String a(Intent paramIntent, String paramString, b<? super String, ah> paramb)
  {
    AppMethodBeat.i(308036);
    paramIntent = paramIntent.getStringExtra(paramString);
    if (paramIntent == null)
    {
      AppMethodBeat.o(308036);
      return null;
    }
    int i;
    if (!n.bp((CharSequence)paramIntent))
    {
      i = 1;
      if (i == 0) {
        break label54;
      }
    }
    for (;;)
    {
      if (paramIntent != null) {
        break label59;
      }
      AppMethodBeat.o(308036);
      return null;
      i = 0;
      break;
      label54:
      paramIntent = null;
    }
    label59:
    paramb.invoke(paramIntent);
    AppMethodBeat.o(308036);
    return paramIntent;
  }
  
  private static String a(Intent paramIntent, String paramString, f<? extends bg> paramf)
  {
    AppMethodBeat.i(308040);
    paramIntent = a(paramIntent, paramString, (b)new t.d(paramf));
    AppMethodBeat.o(308040);
    return paramIntent;
  }
  
  protected final void a(MMActivity paramMMActivity, bg parambg)
  {
    AppMethodBeat.i(308046);
    s.u(paramMMActivity, "context");
    s.u(parambg, "packHelper");
    Intent localIntent = paramMMActivity.getIntent();
    s.s(localIntent, "");
    a(localIntent, "Ksnsupload_title", (f)new a(parambg));
    a(localIntent, "Ksnsupload_link", (f)new b(parambg));
    a(localIntent, "Ksnsupload_imgurl", (b)new c(parambg));
    super.a(paramMMActivity, parambg);
    AppMethodBeat.o(308046);
  }
  
  protected final int hlU()
  {
    return this.RcH;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "imgUrl", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements b<String, ah>
  {
    c(bg parambg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.t
 * JD-Core Version:    0.7.0.1
 */