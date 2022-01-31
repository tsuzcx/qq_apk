package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout
  extends LinearLayout
{
  Context context;
  List<String> niy = new ArrayList();
  
  public MailAttachListLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  static String es(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.length() == 0)) {}
    int k;
    do
    {
      return null;
      k = paramString1.indexOf(paramString2);
    } while (k == -1);
    int j = paramString1.indexOf("&", k);
    int i = j;
    if (j == -1) {
      i = paramString1.length();
    }
    return paramString1.substring(k + paramString2.length() + 1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout
 * JD-Core Version:    0.7.0.1
 */