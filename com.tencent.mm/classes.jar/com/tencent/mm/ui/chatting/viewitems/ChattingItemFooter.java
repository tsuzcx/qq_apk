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
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.j;
import com.tencent.mm.ai.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class ChattingItemFooter
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int[] vEI = { R.g.chatfrom_bg_app_buttonleft, R.g.chatfrom_bg_app_buttonleft, R.g.chatfrom_bg_app_buttonright, R.g.chatfrom_bg_app_buttonone };
  private static final int[] vEJ = { R.g.reader_news_multbg_buttonleft, R.g.reader_news_multbg_buttonmid, R.g.reader_news_multbg_buttonright, R.g.reader_news_multbg_buttonone };
  private LayoutInflater Lu;
  private String hcm;
  private Context mContext;
  
  public ChattingItemFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private TextView a(int paramInt1, int paramInt2, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramInt1 < paramInt2) {
      return (TextView)getChildAt(paramInt1);
    }
    TextView localTextView = (TextView)this.Lu.inflate(R.i.chatting_item_footer_item, null);
    localTextView.setLongClickable(false);
    localTextView.setOnClickListener(this);
    localTextView.setLayoutParams(paramLayoutParams);
    addView(localTextView);
    return localTextView;
  }
  
  private void d(j paramj)
  {
    paramj = new q(this.hcm, paramj.getInfo());
    au.Dk().a(paramj, 0);
  }
  
  public final boolean l(List<j> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      y.d("ChattingItemFooter", "no menulist!");
      setVisibility(8);
      return false;
    }
    this.hcm = paramString;
    int i = getChildCount();
    paramString = vEI;
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
    paramView = paramView.getTag();
    if (!(paramView instanceof j)) {
      return;
    }
    paramView = (j)paramView;
    switch (paramView.type)
    {
    default: 
      return;
    case 1: 
      y.d("ChattingItemFooter", "get latest message");
      paramView.state = j.egm;
      d(paramView);
      return;
    }
    y.d("ChattingItemFooter", "start webview url");
    paramView.state = j.egm;
    d(paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView.value);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("geta8key_username", this.hcm);
    d.b(this.mContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemFooter
 * JD-Core Version:    0.7.0.1
 */