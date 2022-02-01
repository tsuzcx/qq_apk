package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.u;
import java.lang.ref.WeakReference;

public final class f
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String Jya;
  String Kyl;
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    AppMethodBeat.i(38778);
    this.Jya = null;
    this.Kyl = null;
    this.Jya = paramString1;
    this.Kyl = paramString2;
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = new Intent((Context)f.this.EXg.get(), SelectContactUI.class);
          ((Intent)localObject).putExtra("list_attr", u.jU(u.Knw, 256));
          ((Intent)localObject).putExtra("list_type", 10);
          ((Intent)localObject).putExtra("received_card_name", f.this.Jya);
          ((Intent)localObject).putExtra("recommend_friends", true);
          ((Intent)localObject).putExtra("titile", ((Context)f.this.EXg.get()).getString(2131755234));
          paramAnonymousView = (Context)f.this.EXg.get();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ba.aBQ().azO().BL(f.this.Jya);
          ba.aBQ().azO().BL(f.this.Kyl);
          g.yhR.f(11003, new Object[] { f.this.Jya, Integer.valueOf(2), Integer.valueOf(0) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38777);
        }
      });
      paramContext.setImageBitmap(com.tencent.mm.ak.c.a(this.Jya, true, -1, null));
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