package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;

public class HtmlTextView2
  extends MMWebView
{
  private ac wMX;
  
  public HtmlTextView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(aj.getContext(), paramAttributeSet);
    AppMethodBeat.i(66930);
    this.wMX = new ac()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(66928);
        ad.d("test", paramAnonymousString);
        AppMethodBeat.o(66928);
        return true;
      }
    };
    initView();
    AppMethodBeat.o(66930);
  }
  
  public HtmlTextView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aj.getContext(), paramAttributeSet, paramInt);
    AppMethodBeat.i(66929);
    this.wMX = new ac()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(66928);
        ad.d("test", paramAnonymousString);
        AppMethodBeat.o(66928);
        return true;
      }
    };
    initView();
    AppMethodBeat.o(66929);
  }
  
  private void initView()
  {
    AppMethodBeat.i(66931);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(66927);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/product/ui/HtmlTextView2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 2) {}
        for (boolean bool = true;; bool = false)
        {
          a.a(bool, this, "com/tencent/mm/plugin/product/ui/HtmlTextView2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(66927);
          return bool;
        }
      }
    });
    setVerticalScrollBarEnabled(false);
    getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    getSettings().setDefaultTextEncodingName("utf-8");
    AppMethodBeat.o(66931);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(66932);
    setWebViewClient(null);
    loadData(paramString, "text/html", "utf-8");
    setWebViewClient(this.wMX);
    AppMethodBeat.o(66932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView2
 * JD-Core Version:    0.7.0.1
 */