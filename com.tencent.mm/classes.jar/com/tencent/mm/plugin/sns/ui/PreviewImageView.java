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
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.y;
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
  private List<String> list = new ArrayList();
  private TableLayout oSr;
  private final Map<Integer, View> oSs = new HashMap();
  private final Map<Integer, TableRow> oSt = new HashMap();
  private final int oSu = 4;
  private HashMap<String, Bitmap> oSv = new HashMap();
  private v.a oSw;
  private boolean oSx = true;
  private boolean oSy = false;
  
  public PreviewImageView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    init();
  }
  
  public PreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    this.oSr = ((TableLayout)LayoutInflater.from(this.context).inflate(i.g.sns_preview_view, this, true).findViewById(i.f.content));
  }
  
  public final void clean()
  {
    this.oSy = true;
    Iterator localIterator = this.oSv.values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (i.s(localBitmap)) {
        localBitmap.recycle();
      }
    }
  }
  
  public int getCount()
  {
    return this.oSs.size();
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setImageClick(v.a parama)
  {
    this.oSw = parama;
  }
  
  public void setIsShowAddImage(boolean paramBoolean)
  {
    this.oSx = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    long l = System.currentTimeMillis();
    if (paramList == null) {
      return;
    }
    this.list = paramList;
    int i = 0;
    this.oSr.removeAllViews();
    int m = paramList.size() + 1;
    int j = 0;
    label36:
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.oSt.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label521;
      }
      localTableRow = new TableRow(this.context);
      this.oSt.put(Integer.valueOf(j), localTableRow);
    }
    label392:
    label521:
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
          this.oSr.addView(localTableRow);
        }
        y.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - l));
        j += 1;
        break label36;
        break;
        Object localObject2 = (View)this.oSs.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, i.g.sns_preview_view_item, null);
          this.oSs.put(Integer.valueOf(i), localObject1);
        }
        label242:
        ImageView localImageView;
        if (i == m - 1)
        {
          localObject2 = "";
          localImageView = (ImageView)((View)localObject1).findViewById(i.f.iv);
          if (i != m - 1) {
            break label392;
          }
          if (this.oSx)
          {
            localImageView.setBackgroundResource(i.e.sns_add_item);
            localImageView.setContentDescription(getContext().getString(i.j.sns_add_photo));
            localImageView.setImageDrawable(null);
            label299:
            if (this.oSw != null)
            {
              if (i != m - 1) {
                break label488;
              }
              ((View)localObject1).setTag(Integer.valueOf(-1));
              ((View)localObject1).setOnClickListener(this.oSw.oPK);
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
          break label242;
          localImageView.setBackgroundDrawable(null);
          localImageView.setTag(localObject2);
          localImageView.setContentDescription(getContext().getString(i.j.sns_img));
          Bitmap localBitmap = (Bitmap)this.oSv.get(localObject2);
          if (!i.s(localBitmap))
          {
            y.d("MicroMsg.PreviewImageView", "bm is null");
            new PreviewImageView.a(this, localImageView, (String)localObject2).p(new String[] { "" });
            break label299;
          }
          localImageView.setImageBitmap(localBitmap);
          break label299;
          label488:
          ((View)localObject1).setTag(Integer.valueOf(i));
          ((View)localObject1).setOnClickListener(this.oSw.oPK);
          ((View)localObject1).setClickable(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView
 * JD-Core Version:    0.7.0.1
 */