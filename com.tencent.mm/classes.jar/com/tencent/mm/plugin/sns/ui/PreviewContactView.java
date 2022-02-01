package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviewContactView
  extends LinearLayout
{
  private TableLayout Rik;
  private final Map<Integer, View> Ril;
  private final Map<Integer, TableRow> Rim;
  private int Rin;
  private boolean Rio;
  private final Context context;
  private List<String> list;
  
  public PreviewContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98190);
    this.list = new ArrayList();
    this.Ril = new HashMap();
    this.Rim = new HashMap();
    this.Rin = 5;
    this.Rio = false;
    this.context = paramContext;
    this.Rik = ((TableLayout)LayoutInflater.from(this.context).inflate(b.g.sns_preview_view, this, true).findViewById(b.f.content));
    AppMethodBeat.o(98190);
  }
  
  private TextView getEllipsizeTV()
  {
    AppMethodBeat.i(308431);
    TextView localTextView1 = new TextView(this.context);
    TextView localTextView2 = (TextView)getRootView().findViewById(b.f.at_contact_tips);
    if (localTextView2 != null) {
      localTextView1.setTextSize(0, localTextView2.getTextSize());
    }
    localTextView1.setText("...");
    localTextView1.setTextColor(getResources().getColor(b.c.green_text_color));
    AppMethodBeat.o(308431);
    return localTextView1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(308434);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.Rio)
    {
      setList(this.list);
      this.Rio = true;
    }
    AppMethodBeat.o(308434);
  }
  
  public void setImageClick(a parama) {}
  
  public void setLineNum(int paramInt)
  {
    AppMethodBeat.i(98191);
    this.Rin = paramInt;
    setList(this.list);
    AppMethodBeat.o(98191);
  }
  
  public void setList(List<String> paramList)
  {
    AppMethodBeat.i(98192);
    if (paramList == null)
    {
      AppMethodBeat.o(98192);
      return;
    }
    this.list = paramList;
    if (this.Rik.getChildCount() > 0) {
      this.Rik.removeAllViews();
    }
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(98192);
      return;
    }
    int i1 = paramList.size();
    int k = 0;
    int i = -1;
    int j = 0;
    TableRow localTableRow;
    if (j < i1)
    {
      localTableRow = (TableRow)this.Rim.get(Integer.valueOf(k));
      if (localTableRow != null) {
        break label448;
      }
      localTableRow = new TableRow(this.context);
      this.Rim.put(Integer.valueOf(k), localTableRow);
    }
    label282:
    label412:
    label448:
    for (;;)
    {
      localTableRow.removeAllViews();
      int m = 0;
      if ((m < this.Rin) && (j < i1))
      {
        Object localObject2 = (View)this.Ril.get(Integer.valueOf(j));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, b.g.sns_preview_contact_view, null);
          this.Ril.put(Integer.valueOf(j), localObject1);
        }
        localObject2 = (String)paramList.get(j);
        Object localObject3 = (ImageView)((View)localObject1).findViewById(b.f.iv);
        ((ImageView)localObject3).setBackgroundDrawable(null);
        a.b.g((ImageView)localObject3, (String)localObject2);
        ((View)localObject1).setTag(Integer.valueOf(0));
        ((View)localObject1).setClickable(false);
        int n = i;
        if (i == -1)
        {
          if ((localObject1 == null) || (((View)localObject1).getWidth() == 0))
          {
            i = -1;
            n = i;
          }
        }
        else
        {
          if (m != n) {
            break label412;
          }
          localTableRow.addView(getEllipsizeTV());
        }
        for (i = i1;; i = j)
        {
          j = i + 1;
          m += 1;
          i = n;
          break;
          this.Rio = true;
          localObject2 = getEllipsizeTV();
          localObject3 = new Rect();
          ((TextView)localObject2).getPaint().getTextBounds("...", 0, 3, (Rect)localObject3);
          int i2 = ((Rect)localObject3).width();
          n = getWidth() / ((View)localObject1).getWidth();
          i = n;
          if (n == 5) {
            break label282;
          }
          i = n;
          if (getWidth() - ((View)localObject1).getWidth() * n - i2 >= 0) {
            break label282;
          }
          i = n - 1;
          break label282;
          localTableRow.addView((View)localObject1);
        }
      }
      this.Rik.addView(localTableRow);
      k += 1;
      break;
      AppMethodBeat.o(98192);
      return;
    }
  }
  
  static abstract class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewContactView
 * JD-Core Version:    0.7.0.1
 */