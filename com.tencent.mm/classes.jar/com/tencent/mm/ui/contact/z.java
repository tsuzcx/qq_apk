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
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class z
  extends LinearLayout
{
  private String KoJ;
  private Context context;
  
  public z(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37933);
    this.context = paramContext;
    this.KoJ = paramString;
    paramContext = View.inflate(getContext(), 2131495058, this);
    paramString = findViewById(2131299501);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37931);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = paramAnonymousView.getContext();
        localObject = new Intent(paramAnonymousView, OpenIMAddressUI.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("key_openim_acctype_id", z.a(z.this));
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37931);
      }
    });
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37932);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMListViewItem$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((z.b(z.this) instanceof MMActivity)) {
          ((MMActivity)z.b(z.this)).hideVKB();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/OpenIMListViewItem$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37932);
        return false;
      }
    });
    paramContext = (MaskLayout)paramString.findViewById(2131297283);
    ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).b(this.KoJ, "openim_acct_type_icon", b.a.iHu);
    if (this.KoJ.equals("cloudim")) {
      ((ImageView)paramContext.getContentView()).setImageResource(2131689725);
    }
    paramContext = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).b(this.KoJ, "openim_acct_type_title", b.a.iHt);
    ((TextView)findViewById(2131299502)).setText(paramContext);
    AppMethodBeat.o(37933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.z
 * JD-Core Version:    0.7.0.1
 */