package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.q;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class ChattingItemFooter
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int[] zVW = { 2130838265, 2130838265, 2130838271, 2130838268 };
  private static final int[] zVX = { 2130840097, 2130840101, 2130840106, 2130840103 };
  private String ikj;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public ChattingItemFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33207);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(33207);
  }
  
  private TextView a(int paramInt1, int paramInt2, LinearLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(33209);
    if (paramInt1 < paramInt2)
    {
      paramLayoutParams = (TextView)getChildAt(paramInt1);
      AppMethodBeat.o(33209);
      return paramLayoutParams;
    }
    TextView localTextView = (TextView)this.mInflater.inflate(2130969062, null);
    localTextView.setLongClickable(false);
    localTextView.setOnClickListener(this);
    localTextView.setLayoutParams(paramLayoutParams);
    addView(localTextView);
    AppMethodBeat.o(33209);
    return localTextView;
  }
  
  private void d(j paramj)
  {
    AppMethodBeat.i(33210);
    paramj = new q(this.ikj, paramj.getInfo());
    aw.Rc().a(paramj, 0);
    AppMethodBeat.o(33210);
  }
  
  public final boolean m(List<j> paramList, String paramString)
  {
    AppMethodBeat.i(33208);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ab.d("ChattingItemFooter", "no menulist!");
      setVisibility(8);
      AppMethodBeat.o(33208);
      return false;
    }
    this.ikj = paramString;
    int i = getChildCount();
    paramString = zVW;
    Object localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    int j = paramList.size();
    switch (j)
    {
    }
    for (;;)
    {
      if ((i > j) && (i - 1 > 0)) {
        removeViews(j, i - 1);
      }
      setLongClickable(true);
      setVisibility(0);
      AppMethodBeat.o(33208);
      return true;
      paramList = (j)paramList.get(0);
      localObject = a(0, i, (LinearLayout.LayoutParams)localObject);
      ((TextView)localObject).setText(paramList.name);
      ((TextView)localObject).setTag(paramList);
      ((TextView)localObject).setBackgroundResource(paramString[3]);
      continue;
      j localj = (j)paramList.get(1);
      TextView localTextView = a(1, i, (LinearLayout.LayoutParams)localObject);
      localTextView.setText(localj.name);
      localTextView.setTag(localj);
      localTextView.setBackgroundResource(paramString[1]);
      localj = (j)paramList.get(0);
      localTextView = a(0, i, (LinearLayout.LayoutParams)localObject);
      localTextView.setText(localj.name);
      localTextView.setTag(localj);
      localTextView.setBackgroundResource(paramString[0]);
      paramList = (j)paramList.get(j - 1);
      localObject = a(j - 1, i, (LinearLayout.LayoutParams)localObject);
      ((TextView)localObject).setText(paramList.name);
      ((TextView)localObject).setTag(paramList);
      ((TextView)localObject).setBackgroundResource(paramString[2]);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(33211);
    paramView = paramView.getTag();
    if (!(paramView instanceof j))
    {
      AppMethodBeat.o(33211);
      return;
    }
    paramView = (j)paramView;
    switch (paramView.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33211);
      return;
      ab.d("ChattingItemFooter", "get latest message");
      paramView.state = j.fwo;
      d(paramView);
      AppMethodBeat.o(33211);
      return;
      ab.d("ChattingItemFooter", "start webview url");
      paramView.state = j.fwo;
      d(paramView);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView.value);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("geta8key_username", this.ikj);
      d.b(this.mContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemFooter
 * JD-Core Version:    0.7.0.1
 */