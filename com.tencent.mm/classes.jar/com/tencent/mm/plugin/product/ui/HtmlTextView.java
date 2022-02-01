package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import java.net.URL;
import org.xml.sax.XMLReader;

public class HtmlTextView
  extends TextView
{
  Html.ImageGetter wMS;
  Html.TagHandler wMT;
  
  public HtmlTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66922);
    this.wMS = new Html.ImageGetter()
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
    this.wMT = new Html.TagHandler()
    {
      private static Object a(Editable paramAnonymousEditable, Class paramAnonymousClass)
      {
        AppMethodBeat.i(66920);
        paramAnonymousClass = paramAnonymousEditable.getSpans(0, paramAnonymousEditable.length(), paramAnonymousClass);
        if (paramAnonymousClass.length == 0)
        {
          AppMethodBeat.o(66920);
          return null;
        }
        int i = paramAnonymousClass.length;
        while (i > 0)
        {
          if (paramAnonymousEditable.getSpanFlags(paramAnonymousClass[(i - 1)]) == 17)
          {
            paramAnonymousEditable = paramAnonymousClass[(i - 1)];
            AppMethodBeat.o(66920);
            return paramAnonymousEditable;
          }
          i -= 1;
        }
        AppMethodBeat.o(66920);
        return null;
      }
      
      public final void handleTag(boolean paramAnonymousBoolean, String paramAnonymousString, Editable paramAnonymousEditable, XMLReader paramAnonymousXMLReader)
      {
        AppMethodBeat.i(66919);
        if ((paramAnonymousString.equalsIgnoreCase("strike")) || (paramAnonymousString.equals("s")))
        {
          int i = paramAnonymousEditable.length();
          if (paramAnonymousBoolean)
          {
            paramAnonymousEditable.setSpan(new StrikethroughSpan(), i, i, 17);
            AppMethodBeat.o(66919);
            return;
          }
          paramAnonymousString = a(paramAnonymousEditable, StrikethroughSpan.class);
          int j = paramAnonymousEditable.getSpanStart(paramAnonymousString);
          paramAnonymousEditable.removeSpan(paramAnonymousString);
          if (j != i) {
            paramAnonymousEditable.setSpan(new StrikethroughSpan(), j, i, 33);
          }
        }
        AppMethodBeat.o(66919);
      }
    };
    AppMethodBeat.o(66922);
  }
  
  public HtmlTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66921);
    this.wMS = new Html.ImageGetter()
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
    this.wMT = new Html.TagHandler()
    {
      private static Object a(Editable paramAnonymousEditable, Class paramAnonymousClass)
      {
        AppMethodBeat.i(66920);
        paramAnonymousClass = paramAnonymousEditable.getSpans(0, paramAnonymousEditable.length(), paramAnonymousClass);
        if (paramAnonymousClass.length == 0)
        {
          AppMethodBeat.o(66920);
          return null;
        }
        int i = paramAnonymousClass.length;
        while (i > 0)
        {
          if (paramAnonymousEditable.getSpanFlags(paramAnonymousClass[(i - 1)]) == 17)
          {
            paramAnonymousEditable = paramAnonymousClass[(i - 1)];
            AppMethodBeat.o(66920);
            return paramAnonymousEditable;
          }
          i -= 1;
        }
        AppMethodBeat.o(66920);
        return null;
      }
      
      public final void handleTag(boolean paramAnonymousBoolean, String paramAnonymousString, Editable paramAnonymousEditable, XMLReader paramAnonymousXMLReader)
      {
        AppMethodBeat.i(66919);
        if ((paramAnonymousString.equalsIgnoreCase("strike")) || (paramAnonymousString.equals("s")))
        {
          int i = paramAnonymousEditable.length();
          if (paramAnonymousBoolean)
          {
            paramAnonymousEditable.setSpan(new StrikethroughSpan(), i, i, 17);
            AppMethodBeat.o(66919);
            return;
          }
          paramAnonymousString = a(paramAnonymousEditable, StrikethroughSpan.class);
          int j = paramAnonymousEditable.getSpanStart(paramAnonymousString);
          paramAnonymousEditable.removeSpan(paramAnonymousString);
          if (j != i) {
            paramAnonymousEditable.setSpan(new StrikethroughSpan(), j, i, 33);
          }
        }
        AppMethodBeat.o(66919);
      }
    };
    AppMethodBeat.o(66921);
  }
  
  public void setText(final String paramString)
  {
    AppMethodBeat.i(66923);
    g.ajF().a(new aq.a()
    {
      private volatile Spanned wMU;
      
      public final boolean aEm()
      {
        AppMethodBeat.i(66915);
        this.wMU = HtmlTextView.a(HtmlTextView.this, paramString);
        AppMethodBeat.o(66915);
        return true;
      }
      
      public final boolean aEn()
      {
        AppMethodBeat.i(66916);
        HtmlTextView.a(HtmlTextView.this, this.wMU, TextView.BufferType.SPANNABLE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView
 * JD-Core Version:    0.7.0.1
 */