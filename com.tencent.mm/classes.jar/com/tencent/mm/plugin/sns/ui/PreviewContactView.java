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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class PreviewContactView
  extends LinearLayout
{
  private TableLayout KIK;
  private final Map<Integer, View> KIL;
  @SuppressLint({"UseSparseArrays"})
  private final Map<Integer, TableRow> KIM;
  private int KIN;
  private final Context context;
  private List<String> list;
  
  public PreviewContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98190);
    this.list = new ArrayList();
    this.KIL = new HashMap();
    this.KIM = new HashMap();
    this.KIN = 5;
    this.context = paramContext;
    this.KIK = ((TableLayout)LayoutInflater.from(this.context).inflate(i.g.sns_preview_view, this, true).findViewById(i.f.content));
    AppMethodBeat.o(98190);
  }
  
  public void setImageClick(a parama) {}
  
  public void setLineNum(int paramInt)
  {
    AppMethodBeat.i(98191);
    this.KIN = paramInt;
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
    this.KIK.removeAllViews();
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(98192);
      return;
    }
    int m = paramList.size();
    int j = 0;
    int i = 0;
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.KIM.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label286;
      }
      localTableRow = new TableRow(this.context);
      this.KIM.put(Integer.valueOf(j), localTableRow);
    }
    label286:
    for (;;)
    {
      localTableRow.removeAllViews();
      int k = 0;
      while ((k < this.KIN) && (i < m))
      {
        Object localObject2 = (View)this.KIL.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, i.g.sns_preview_contact_view, null);
          this.KIL.put(Integer.valueOf(i), localObject1);
        }
        localObject2 = (String)paramList.get(i);
        ImageView localImageView = (ImageView)((View)localObject1).findViewById(i.f.iv);
        localImageView.setBackgroundDrawable(null);
        a.b.c(localImageView, (String)localObject2);
        ((View)localObject1).setTag(Integer.valueOf(0));
        ((View)localObject1).setClickable(false);
        localTableRow.addView((View)localObject1);
        k += 1;
        i += 1;
      }
      this.KIK.addView(localTableRow);
      j += 1;
      break;
      AppMethodBeat.o(98192);
      return;
    }
  }
  
  static abstract class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewContactView
 * JD-Core Version:    0.7.0.1
 */