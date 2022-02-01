package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.b;

public class ActivityTestMultilineEllipse
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97665);
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
    ((QTextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97664);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ActivityTestMultilineEllipse$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (this.QZP.getIsExpanded())
        {
          paramAnonymousView = this.QZP;
          paramAnonymousView.vYR = false;
          paramAnonymousView.requestLayout();
          paramAnonymousView.invalidate();
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/ActivityTestMultilineEllipse$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97664);
          return;
          paramAnonymousView = this.QZP;
          paramAnonymousView.vYR = true;
          paramAnonymousView.requestLayout();
          paramAnonymousView.invalidate();
        }
      }
    });
    paramBundle.addView((View)localObject);
    AppMethodBeat.o(97665);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ActivityTestMultilineEllipse
 * JD-Core Version:    0.7.0.1
 */