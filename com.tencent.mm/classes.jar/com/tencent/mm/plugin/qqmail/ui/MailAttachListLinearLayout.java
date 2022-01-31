package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout
  extends LinearLayout
{
  Context context;
  List<String> pNL;
  
  public MailAttachListLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68378);
    this.pNL = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(68378);
  }
  
  static String fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68379);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(68379);
      return null;
    }
    int k = paramString1.indexOf(paramString2);
    if (k == -1)
    {
      AppMethodBeat.o(68379);
      return null;
    }
    int j = paramString1.indexOf("&", k);
    int i = j;
    if (j == -1) {
      i = paramString1.length();
    }
    paramString1 = paramString1.substring(k + paramString2.length() + 1, i);
    AppMethodBeat.o(68379);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout
 * JD-Core Version:    0.7.0.1
 */