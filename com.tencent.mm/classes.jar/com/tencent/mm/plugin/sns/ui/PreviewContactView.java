package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class PreviewContactView
  extends LinearLayout
{
  private final Context context;
  private List<String> list;
  private TableLayout rKk;
  private final Map<Integer, View> rKl;
  @SuppressLint({"UseSparseArrays"})
  private final Map<Integer, TableRow> rKm;
  private int rKn;
  
  public PreviewContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38509);
    this.list = new ArrayList();
    this.rKl = new HashMap();
    this.rKm = new HashMap();
    this.rKn = 5;
    this.context = paramContext;
    this.rKk = ((TableLayout)LayoutInflater.from(this.context).inflate(2130970856, this, true).findViewById(2131820946));
    AppMethodBeat.o(38509);
  }
  
  public void setImageClick(a parama) {}
  
  public void setLineNum(int paramInt)
  {
    AppMethodBeat.i(38510);
    this.rKn = paramInt;
    setList(this.list);
    AppMethodBeat.o(38510);
  }
  
  public void setList(List<String> paramList)
  {
    AppMethodBeat.i(38511);
    if (paramList == null)
    {
      AppMethodBeat.o(38511);
      return;
    }
    this.list = paramList;
    this.rKk.removeAllViews();
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(38511);
      return;
    }
    int m = paramList.size();
    int j = 0;
    int i = 0;
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.rKm.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label284;
      }
      localTableRow = new TableRow(this.context);
      this.rKm.put(Integer.valueOf(j), localTableRow);
    }
    label284:
    for (;;)
    {
      localTableRow.removeAllViews();
      int k = 0;
      while ((k < this.rKn) && (i < m))
      {
        Object localObject2 = (View)this.rKl.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, 2130970855, null);
          this.rKl.put(Integer.valueOf(i), localObject1);
        }
        localObject2 = (String)paramList.get(i);
        ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131822812);
        localImageView.setBackgroundDrawable(null);
        a.b.c(localImageView, (String)localObject2);
        ((View)localObject1).setTag(Integer.valueOf(0));
        ((View)localObject1).setClickable(false);
        localTableRow.addView((View)localObject1);
        k += 1;
        i += 1;
      }
      this.rKk.addView(localTableRow);
      j += 1;
      break;
      AppMethodBeat.o(38511);
      return;
    }
  }
  
  static abstract class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewContactView
 * JD-Core Version:    0.7.0.1
 */