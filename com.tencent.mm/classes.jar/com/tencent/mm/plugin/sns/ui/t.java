package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.e;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/Festival2021Widget;", "Lcom/tencent/mm/plugin/sns/ui/FinderLiveWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "snsType", "", "getSnsType", "()I", "onPrepareCommitPack", "", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "safeGet", "", "Landroid/content/Intent;", "key", "block", "Lkotlin/Function1;", "Lkotlin/reflect/KFunction1;", "plugin-sns_release"})
public final class t
  extends u
{
  private final int KCZ;
  
  public t(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(198013);
    this.KCZ = 43;
    AppMethodBeat.o(198013);
  }
  
  private static String a(Intent paramIntent, String paramString, b<? super String, x> paramb)
  {
    AppMethodBeat.i(198004);
    paramIntent = paramIntent.getStringExtra(paramString);
    if (paramIntent != null)
    {
      int i;
      if (!n.ba((CharSequence)paramIntent))
      {
        i = 1;
        if (i == 0) {
          break label55;
        }
      }
      for (;;)
      {
        if (paramIntent == null) {
          break label60;
        }
        paramb.invoke(paramIntent);
        AppMethodBeat.o(198004);
        return paramIntent;
        i = 0;
        break;
        label55:
        paramIntent = null;
      }
    }
    label60:
    AppMethodBeat.o(198004);
    return null;
  }
  
  private static String a(Intent paramIntent, String paramString, e<? extends be> parame)
  {
    AppMethodBeat.i(198005);
    paramIntent = a(paramIntent, paramString, (b)new t.d(parame));
    AppMethodBeat.o(198005);
    return paramIntent;
  }
  
  protected final void a(MMActivity paramMMActivity, final be parambe)
  {
    AppMethodBeat.i(198009);
    p.k(paramMMActivity, "context");
    p.k(parambe, "packHelper");
    Intent localIntent = paramMMActivity.getIntent();
    a(localIntent, "Ksnsupload_title", new t.b(parambe));
    a(localIntent, "Ksnsupload_link", new t.c(parambe));
    a(localIntent, "Ksnsupload_imgurl", (b)new a(this, parambe));
    super.a(paramMMActivity, parambe);
    AppMethodBeat.o(198009);
  }
  
  protected final int fTB()
  {
    return this.KCZ;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "imgUrl", "", "invoke", "com/tencent/mm/plugin/sns/ui/Festival2021Widget$onPrepareCommitPack$1$3"})
  static final class a
    extends q
    implements b<String, x>
  {
    a(t paramt, be parambe)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.t
 * JD-Core Version:    0.7.0.1
 */