package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.u;
import java.lang.ref.WeakReference;

public final class f
  extends b
{
  String HKj;
  String IHf;
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    AppMethodBeat.i(38778);
    this.HKj = null;
    this.IHf = null;
    this.HKj = paramString1;
    this.IHf = paramString2;
    if (this.view != null)
    {
      paramContext = (ImageView)this.view.findViewById(2131298064);
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38777);
          Object localObject = new Intent((Context)f.this.Dsc.get(), SelectContactUI.class);
          ((Intent)localObject).putExtra("list_attr", u.jI(u.IwO, 256));
          ((Intent)localObject).putExtra("list_type", 10);
          ((Intent)localObject).putExtra("received_card_name", f.this.HKj);
          ((Intent)localObject).putExtra("recommend_friends", true);
          ((Intent)localObject).putExtra("titile", ((Context)f.this.Dsc.get()).getString(2131755234));
          paramAnonymousView = (Context)f.this.Dsc.get();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          az.ayM().awZ().yM(f.this.HKj);
          az.ayM().awZ().yM(f.this.IHf);
          h.wUl.f(11003, new Object[] { f.this.HKj, Integer.valueOf(2), Integer.valueOf(0) });
          AppMethodBeat.o(38777);
        }
      });
      paramContext.setImageBitmap(com.tencent.mm.aj.c.a(this.HKj, true, -1, null));
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