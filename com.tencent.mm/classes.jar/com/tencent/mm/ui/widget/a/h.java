package com.tencent.mm.ui.widget.a;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class h
{
  public static o c(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(195238);
    Object localObject = View.inflate(paramActivity, 2131495760, null);
    ((View)localObject).findViewById(2131305898);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131305901);
    localTextView.setText(paramString);
    paramString = (WeImageView)((View)localObject).findViewById(2131305899);
    if (paramInt1 == 0)
    {
      paramString.setVisibility(8);
      paramInt1 = ao.fromDPToPix(paramActivity, 16);
      localTextView.setPadding(paramInt1, 0, paramInt1, 0);
    }
    for (;;)
    {
      paramString = new o((View)localObject);
      paramString.setWidth(-1);
      paramString.setHeight(-2);
      localObject = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt2 = ((Rect)localObject).top;
      int i = ap.dL(paramActivity);
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = ap.jA(paramActivity);
      }
      paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, paramInt1 + i);
      new Handler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(195236);
          this.GaG.dismiss();
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(195236);
        }
      }.sendEmptyMessageDelayed(0, 2000L);
      AppMethodBeat.o(195238);
      return paramString;
      paramString.setImageResource(paramInt1);
      paramString.setIconColor(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.h
 * JD-Core Version:    0.7.0.1
 */