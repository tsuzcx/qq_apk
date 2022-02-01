package com.tencent.mm.ui.widget.a;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class k
{
  public static v a(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3, final View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251786);
    View localView = View.inflate(paramActivity, a.g.tipsbar_style_two, null);
    ((LinearLayout)localView.findViewById(a.f.bar_ll)).setBackgroundResource(a.e.tipsbar_red_bg);
    Object localObject = (TextView)localView.findViewById(a.f.tipsbar_text);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    paramString = (WeImageView)localView.findViewById(a.f.tipsbar_left_icon);
    if (paramInt1 == 0)
    {
      paramString.setVisibility(8);
      paramInt1 = bd.fromDPToPix(paramActivity, 16);
      ((TextView)localObject).setPadding(paramInt1, 0, paramInt1, 0);
      paramString = new v(localView);
      paramString.setWidth(-1);
      paramString.setHeight(-2);
      localObject = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt2 = ((Rect)localObject).top;
      int i = bf.fs(paramActivity);
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = bf.be(paramActivity);
      }
      paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, paramInt1 + i);
      paramActivity = (ImageView)localView.findViewById(a.f.tipsbar_right_icon);
      if (paramInt3 != 0) {
        break label235;
      }
      paramActivity.setVisibility(8);
    }
    for (;;)
    {
      paramActivity.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251759);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          k.this.dismiss();
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(paramAnonymousView);
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251759);
        }
      });
      AppMethodBeat.o(251786);
      return paramString;
      paramString.setImageResource(paramInt1);
      paramString.setIconColor(paramInt2);
      break;
      label235:
      paramActivity.setImageResource(paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.k
 * JD-Core Version:    0.7.0.1
 */