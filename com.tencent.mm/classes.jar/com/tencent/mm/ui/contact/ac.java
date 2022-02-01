package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class ac
  extends LinearLayout
{
  private String afgU;
  private Context context;
  
  public ac(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37933);
    this.context = paramContext;
    this.afgU = paramString;
    paramContext = View.inflate(getContext(), R.i.gmQ, this);
    paramString = findViewById(R.h.fGJ);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37931);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37931);
          return;
        }
        paramAnonymousView = paramAnonymousView.getContext();
        localObject = new Intent(paramAnonymousView, OpenIMAddressUI.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("key_openim_acctype_id", ac.a(ac.this));
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37931);
      }
    });
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37932);
        if ((ac.b(ac.this) instanceof MMActivity)) {
          ((MMActivity)ac.b(ac.this)).hideVKB();
        }
        AppMethodBeat.o(37932);
        return false;
      }
    });
    paramContext = (MaskLayout)paramString.findViewById(R.h.ftx);
    ((e)h.ax(e.class)).b(this.afgU, "openim_acct_type_icon", e.a.prc);
    if (this.afgU.equals("cloudim")) {
      ((ImageView)paramContext.getContentView()).setImageResource(R.k.avatar_wechat_frame);
    }
    paramContext = ((e)h.ax(e.class)).b(this.afgU, "openim_acct_type_title", e.a.prb);
    ((TextView)findViewById(R.h.fGK)).setText(paramContext);
    AppMethodBeat.o(37933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ac
 * JD-Core Version:    0.7.0.1
 */