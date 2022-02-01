package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ad;

public class HtmlTextView2
  extends MMWebView
{
  private ad GUl;
  
  public HtmlTextView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(MMApplicationContext.getContext(), paramAttributeSet);
    AppMethodBeat.i(66930);
    this.GUl = new ad()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(66928);
        Log.d("test", paramAnonymousString);
        AppMethodBeat.o(66928);
        return true;
      }
    };
    initView();
    AppMethodBeat.o(66930);
  }
  
  public HtmlTextView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MMApplicationContext.getContext(), paramAttributeSet, paramInt);
    AppMethodBeat.i(66929);
    this.GUl = new ad()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(66928);
        Log.d("test", paramAnonymousString);
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
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          AppMethodBeat.o(66927);
          return true;
        }
        AppMethodBeat.o(66927);
        return false;
      }
    });
    setVerticalScrollBarEnabled(false);
    getSettings().a(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    getSettings().setDefaultTextEncodingName("utf-8");
    AppMethodBeat.o(66931);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(66932);
    setWebViewClient(null);
    loadData(paramString, "text/html", "utf-8");
    setWebViewClient(this.GUl);
    AppMethodBeat.o(66932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView2
 * JD-Core Version:    0.7.0.1
 */