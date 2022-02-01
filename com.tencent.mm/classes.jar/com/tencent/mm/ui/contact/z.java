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
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class z
  extends LinearLayout
{
  private String GXN;
  private Context context;
  
  public z(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37933);
    this.context = paramContext;
    this.GXN = paramString;
    paramContext = View.inflate(getContext(), 2131495058, this);
    paramString = findViewById(2131299501);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37931);
        paramAnonymousView = paramAnonymousView.getContext();
        Object localObject = new Intent(paramAnonymousView, OpenIMAddressUI.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("key_openim_acctype_id", z.a(z.this));
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37931);
      }
    });
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37932);
        if ((z.b(z.this) instanceof MMActivity)) {
          ((MMActivity)z.b(z.this)).hideVKB();
        }
        AppMethodBeat.o(37932);
        return false;
      }
    });
    paramContext = (MaskLayout)paramString.findViewById(2131297283);
    ((b)g.ab(b.class)).b(this.GXN, "openim_acct_type_icon", b.a.hNB);
    if (this.GXN.equals("cloudim")) {
      ((ImageView)paramContext.getContentView()).setImageResource(2131689725);
    }
    paramContext = ((b)g.ab(b.class)).b(this.GXN, "openim_acct_type_title", b.a.hNA);
    ((TextView)findViewById(2131299502)).setText(paramContext);
    AppMethodBeat.o(37933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.z
 * JD-Core Version:    0.7.0.1
 */