package com.tencent.mm.pluginsdk.ui.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/span/MMLinkSpanLogic;", "", "()V", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final a Yod;
  
  static
  {
    AppMethodBeat.i(245179);
    Yod = new a((byte)0);
    AppMethodBeat.o(245179);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/span/MMLinkSpanLogic$Companion;", "", "()V", "TAG", "", "setLinkText", "", "T", "textView", "Landroid/widget/TextView;", "content", "objList", "", "Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanObj;", "setSpanTouch", "text", "Landroid/text/Spannable;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T> void a(TextView paramTextView, String paramString, List<i<T>> paramList)
    {
      AppMethodBeat.i(245172);
      s.u(paramTextView, "textView");
      s.u(paramString, "content");
      s.u(paramList, "objList");
      paramString = new SpannableString((CharSequence)paramString);
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (i < 0) {
          p.kkW();
        }
        localObject = (i)localObject;
        paramString.setSpan(new j(i, (i)localObject), ((i)localObject).start, ((i)localObject).end, 17);
        i += 1;
      }
      paramTextView.setText((CharSequence)paramString);
      paramTextView.setOnTouchListener(new k.a..ExternalSyntheticLambda0((Spannable)paramString, paramTextView));
      AppMethodBeat.o(245172);
    }
    
    private static final boolean b(Spannable paramSpannable, TextView paramTextView, View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(245176);
      s.u(paramSpannable, "$text");
      s.u(paramTextView, "$textView");
      int j = paramMotionEvent.getAction();
      if (paramView == null)
      {
        paramSpannable = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(245176);
        throw paramSpannable;
      }
      paramView = (TextView)paramView;
      switch (j)
      {
      case 2: 
      default: 
        switch (j)
        {
        }
        break;
      }
      for (;;)
      {
        boolean bool = false;
        Log.i("MicroMSg.MMLinkSpanTextView", "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
        AppMethodBeat.o(245176);
        return bool;
        Object localObject1 = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
        if (localObject1 == null) {
          break;
        }
        int k = localObject1.length;
        int i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2 instanceof t))
          {
            ((t)localObject2).setIsPressed(false);
            paramTextView.invalidate();
          }
          i += 1;
        }
        i = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        int m = paramView.getPaddingLeft();
        int n = paramView.getPaddingTop();
        int i1 = paramView.getScrollX();
        int i2 = paramView.getScrollY();
        localObject1 = paramView.getLayout();
        i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
        localObject1 = (ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class);
        if (localObject1.length != 0)
        {
          localObject1 = localObject1[0];
          switch (j)
          {
          }
          for (;;)
          {
            bool = true;
            break;
            ((ClickableSpan)localObject1).onClick((View)paramView);
            continue;
            if ((localObject1 instanceof t))
            {
              ((t)localObject1).setIsPressed(true);
              paramTextView.invalidate();
            }
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject1), paramSpannable.getSpanEnd(localObject1));
          }
        }
        Selection.removeSelection(paramSpannable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.k
 * JD-Core Version:    0.7.0.1
 */