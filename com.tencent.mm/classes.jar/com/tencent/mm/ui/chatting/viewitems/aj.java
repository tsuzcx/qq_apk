package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMNeatTextView.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.HashMap;
import java.util.Map;

public final class aj
{
  private static final class c
    implements MMNeatTextView.b
  {
    public final void a(Exception paramException, String paramString1, String paramString2)
    {
      if (!d.spb)
      {
        HashMap localHashMap = new HashMap(2);
        localHashMap.put("Content", paramString1);
        localHashMap.put("Exception", paramException.toString());
        localHashMap.put("Stack", paramException.getStackTrace());
        h.nFQ.d("NeatTextView", paramString2, localHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj
 * JD-Core Version:    0.7.0.1
 */