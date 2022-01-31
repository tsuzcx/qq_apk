package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PreviewImageView
  extends LinearLayout
  implements v
{
  private final Context context;
  private List<String> list;
  private TableLayout rKk;
  private final Map<Integer, View> rKl;
  private final Map<Integer, TableRow> rKm;
  private final int rKn;
  private HashMap<String, Bitmap> rKo;
  private v.a rKp;
  private boolean rKq;
  private boolean rKr;
  
  public PreviewImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38516);
    this.list = new ArrayList();
    this.rKl = new HashMap();
    this.rKm = new HashMap();
    this.rKo = new HashMap();
    this.rKn = 4;
    this.rKq = true;
    this.rKr = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(38516);
  }
  
  public PreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38515);
    this.list = new ArrayList();
    this.rKl = new HashMap();
    this.rKm = new HashMap();
    this.rKo = new HashMap();
    this.rKn = 4;
    this.rKq = true;
    this.rKr = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(38515);
  }
  
  private void init()
  {
    AppMethodBeat.i(38517);
    this.rKk = ((TableLayout)LayoutInflater.from(this.context).inflate(2130970856, this, true).findViewById(2131820946));
    AppMethodBeat.o(38517);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(38519);
    this.rKr = true;
    Iterator localIterator = this.rKo.values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (i.A(localBitmap)) {
        localBitmap.recycle();
      }
    }
    AppMethodBeat.o(38519);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(38518);
    int i = this.rKl.size();
    AppMethodBeat.o(38518);
    return i;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setImageClick(v.a parama)
  {
    this.rKp = parama;
  }
  
  public void setIsShowAddImage(boolean paramBoolean)
  {
    this.rKq = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(38520);
    long l = System.currentTimeMillis();
    if (paramList == null)
    {
      AppMethodBeat.o(38520);
      return;
    }
    this.list = paramList;
    int i = 0;
    this.rKk.removeAllViews();
    int m = paramList.size() + 1;
    int j = 0;
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.rKm.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label533;
      }
      localTableRow = new TableRow(this.context);
      this.rKm.put(Integer.valueOf(j), localTableRow);
    }
    label398:
    label533:
    for (;;)
    {
      localTableRow.removeAllViews();
      int k = 0;
      if ((k < 4) && (i < m)) {
        if (i >= 9) {
          i += 1;
        }
      }
      for (;;)
      {
        if (localTableRow.getChildCount() > 0) {
          this.rKk.addView(localTableRow);
        }
        ab.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - l));
        j += 1;
        break;
        Object localObject2 = (View)this.rKl.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, 2130970857, null);
          this.rKl.put(Integer.valueOf(i), localObject1);
        }
        label251:
        ImageView localImageView;
        if (i == m - 1)
        {
          localObject2 = "";
          localImageView = (ImageView)((View)localObject1).findViewById(2131822812);
          if (i != m - 1) {
            break label398;
          }
          if (this.rKq)
          {
            localImageView.setBackgroundResource(2130840378);
            localImageView.setContentDescription(getContext().getString(2131303770));
            localImageView.setImageDrawable(null);
            label305:
            if (this.rKp != null)
            {
              if (i != m - 1) {
                break label494;
              }
              ((View)localObject1).setTag(Integer.valueOf(-1));
              ((View)localObject1).setOnClickListener(this.rKp.rHw);
              ((View)localObject1).setClickable(true);
            }
          }
        }
        for (;;)
        {
          ((View)localObject1).setLayoutParams(new TableRow.LayoutParams(-2, -2));
          localTableRow.addView((View)localObject1);
          i += 1;
          k += 1;
          break;
          localObject2 = (String)paramList.get(i);
          break label251;
          localImageView.setBackgroundDrawable(null);
          localImageView.setTag(localObject2);
          localImageView.setContentDescription(getContext().getString(2131303840));
          Bitmap localBitmap = (Bitmap)this.rKo.get(localObject2);
          if (!i.A(localBitmap))
          {
            ab.d("MicroMsg.PreviewImageView", "bm is null");
            new PreviewImageView.a(this, localImageView, (String)localObject2).v(new String[] { "" });
            break label305;
          }
          localImageView.setImageBitmap(localBitmap);
          break label305;
          label494:
          ((View)localObject1).setTag(Integer.valueOf(i));
          ((View)localObject1).setOnClickListener(this.rKp.rHw);
          ((View)localObject1).setClickable(true);
        }
        AppMethodBeat.o(38520);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView
 * JD-Core Version:    0.7.0.1
 */