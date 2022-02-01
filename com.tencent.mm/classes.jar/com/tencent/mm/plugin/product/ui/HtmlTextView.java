package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import java.net.URL;

public class HtmlTextView
  extends TextView
{
  Html.ImageGetter MRJ;
  Html.TagHandler MRK;
  
  public HtmlTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66922);
    this.MRJ = new Html.ImageGetter()
    {
      public final Drawable getDrawable(String paramAnonymousString)
      {
        AppMethodBeat.i(66918);
        try
        {
          paramAnonymousString = Drawable.createFromStream(new URL(paramAnonymousString).openStream(), "");
          if (paramAnonymousString != null) {
            paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
          }
          AppMethodBeat.o(66918);
          return paramAnonymousString;
        }
        catch (Exception paramAnonymousString)
        {
          AppMethodBeat.o(66918);
        }
        return null;
      }
    };
    this.MRK = new HtmlTextView.3(this);
    AppMethodBeat.o(66922);
  }
  
  public HtmlTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66921);
    this.MRJ = new Html.ImageGetter()
    {
      public final Drawable getDrawable(String paramAnonymousString)
      {
        AppMethodBeat.i(66918);
        try
        {
          paramAnonymousString = Drawable.createFromStream(new URL(paramAnonymousString).openStream(), "");
          if (paramAnonymousString != null) {
            paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
          }
          AppMethodBeat.o(66918);
          return paramAnonymousString;
        }
        catch (Exception paramAnonymousString)
        {
          AppMethodBeat.o(66918);
        }
        return null;
      }
    };
    this.MRK = new HtmlTextView.3(this);
    AppMethodBeat.o(66921);
  }
  
  public void setText(final String paramString)
  {
    AppMethodBeat.i(66923);
    h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      private volatile Spanned MRL;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(66915);
        this.MRL = HtmlTextView.a(HtmlTextView.this, paramString);
        AppMethodBeat.o(66915);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(66916);
        HtmlTextView.a(HtmlTextView.this, this.MRL, TextView.BufferType.SPANNABLE);
        HtmlTextView.this.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(66916);
        return true;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(66917);
        String str = super.toString() + "|setText";
        AppMethodBeat.o(66917);
        return str;
      }
    });
    AppMethodBeat.o(66923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView
 * JD-Core Version:    0.7.0.1
 */