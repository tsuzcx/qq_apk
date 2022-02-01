package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.u;
import java.lang.ref.WeakReference;

public final class f
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String JSQ;
  String KUF;
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    AppMethodBeat.i(38778);
    this.JSQ = null;
    this.KUF = null;
    this.JSQ = paramString1;
    this.KUF = paramString2;
    if (this.view != null)
    {
      paramContext = (ImageView)this.view.findViewById(2131298064);
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38777);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = new Intent((Context)f.this.FpA.get(), SelectContactUI.class);
          ((Intent)localObject).putExtra("list_attr", u.kb(u.KJQ, 256));
          ((Intent)localObject).putExtra("list_type", 10);
          ((Intent)localObject).putExtra("received_card_name", f.this.JSQ);
          ((Intent)localObject).putExtra("recommend_friends", true);
          ((Intent)localObject).putExtra("titile", ((Context)f.this.FpA.get()).getString(2131755234));
          paramAnonymousView = (Context)f.this.FpA.get();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bc.aCg().aAe().Cn(f.this.JSQ);
          bc.aCg().aAe().Cn(f.this.KUF);
          g.yxI.f(11003, new Object[] { f.this.JSQ, Integer.valueOf(2), Integer.valueOf(0) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38777);
        }
      });
      paramContext.setImageBitmap(com.tencent.mm.aj.c.a(this.JSQ, true, -1, null));
    }
    AppMethodBeat.o(38778);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493517;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.f
 * JD-Core Version:    0.7.0.1
 */