package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.u;
import java.lang.ref.WeakReference;

public final class f
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String PdV;
  String QhV;
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    AppMethodBeat.i(38778);
    this.PdV = null;
    this.QhV = null;
    this.PdV = paramString1;
    this.QhV = paramString2;
    if (this.view != null)
    {
      paramContext = (ImageView)this.view.findViewById(2131298405);
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38777);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent((Context)f.this.Kgr.get(), SelectContactUI.class);
          ((Intent)localObject).putExtra("list_attr", u.ll(u.PWR, 256));
          ((Intent)localObject).putExtra("list_type", 10);
          ((Intent)localObject).putExtra("received_card_name", f.this.PdV);
          ((Intent)localObject).putExtra("recommend_friends", true);
          ((Intent)localObject).putExtra("titile", ((Context)f.this.Kgr.get()).getString(2131755268));
          paramAnonymousView = (Context)f.this.Kgr.get();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bg.aVF().aTm().KY(f.this.PdV);
          bg.aVF().aTm().KY(f.this.QhV);
          h.CyF.a(11003, new Object[] { f.this.PdV, Integer.valueOf(2), Integer.valueOf(0) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38777);
        }
      });
      paramContext.setImageBitmap(com.tencent.mm.aj.c.a(this.PdV, true, -1, null));
    }
    AppMethodBeat.o(38778);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493629;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.f
 * JD-Core Version:    0.7.0.1
 */