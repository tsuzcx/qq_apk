package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ActivityTestMultilineEllipse
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new LinearLayout(this);
    paramBundle.setOrientation(1);
    paramBundle.setBackgroundColor(-1);
    addContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    Object localObject = new ScrollView(this);
    ((ScrollView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramBundle.addView((View)localObject);
    paramBundle = new LinearLayout(this);
    paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramBundle.setOrientation(1);
    paramBundle.setBackgroundColor(-1);
    ((ScrollView)localObject).addView(paramBundle);
    localObject = new QTextView(this);
    ((QTextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((QTextView)localObject).setEllipsis("...");
    ((QTextView)localObject).setEllipsisMore(" Read More!");
    ((QTextView)localObject).setText("This is some short text. It won't need to be ellipsized.");
    ((QTextView)localObject).setMaxLines(3);
    ((QTextView)localObject).setPadding(10, 10, 10, 10);
    ((QTextView)localObject).setBackgroundColor(-1786127);
    paramBundle.addView((View)localObject);
    localObject = new QTextView(this);
    ((QTextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((QTextView)localObject).setEllipsis("...");
    ((QTextView)localObject).setEllipsisMore(" Read More!");
    ((QTextView)localObject).setMaxLines(3);
    ((QTextView)localObject).setText("This is some longer text. It should wrap and then eventually be ellipsized once it gets way too long for the horizontal width of the current application screen. We should be fixed to max [N] lines height.");
    ((QTextView)localObject).setPadding(10, 10, 10, 10);
    ((QTextView)localObject).setBackgroundColor(-204878);
    ((QTextView)localObject).setOnClickListener(new ActivityTestMultilineEllipse.1(this, (QTextView)localObject));
    paramBundle.addView((View)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ActivityTestMultilineEllipse
 * JD-Core Version:    0.7.0.1
 */