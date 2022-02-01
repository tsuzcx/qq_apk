package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class PreviewImageView
  extends LinearLayout
  implements x
{
  private final Context context;
  private List<String> list;
  private TableLayout yDE;
  private final Map<Integer, View> yDF;
  private final Map<Integer, TableRow> yDG;
  private final int yDH;
  private HashMap<String, Bitmap> yDI;
  private x.a yDJ;
  private boolean yDK;
  private boolean yDL;
  
  public PreviewImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98198);
    this.list = new ArrayList();
    this.yDF = new HashMap();
    this.yDG = new HashMap();
    this.yDI = new HashMap();
    this.yDH = 4;
    this.yDK = true;
    this.yDL = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98198);
  }
  
  public PreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98197);
    this.list = new ArrayList();
    this.yDF = new HashMap();
    this.yDG = new HashMap();
    this.yDI = new HashMap();
    this.yDH = 4;
    this.yDK = true;
    this.yDL = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98197);
  }
  
  private void dOy()
  {
    AppMethodBeat.i(98200);
    if ((this.context instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      Point localPoint = new Point();
      localPoint.x = localDisplayMetrics.widthPixels;
      localPoint.y = localDisplayMetrics.heightPixels;
      af.h(localPoint);
    }
    AppMethodBeat.o(98200);
  }
  
  private void init()
  {
    AppMethodBeat.i(98199);
    this.yDE = ((TableLayout)LayoutInflater.from(this.context).inflate(2131495580, this, true).findViewById(2131298739));
    dOy();
    AppMethodBeat.o(98199);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(98202);
    this.yDL = true;
    Iterator localIterator = this.yDI.values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (q.I(localBitmap)) {
        localBitmap.recycle();
      }
    }
    AppMethodBeat.o(98202);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98201);
    int i = this.yDF.size();
    AppMethodBeat.o(98201);
    return i;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setImageClick(x.a parama)
  {
    this.yDJ = parama;
  }
  
  public void setIsShowAddImage(boolean paramBoolean)
  {
    this.yDK = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(98203);
    long l = System.currentTimeMillis();
    if (paramList == null)
    {
      AppMethodBeat.o(98203);
      return;
    }
    this.list = paramList;
    int i = 0;
    this.yDE.removeAllViews();
    int m = paramList.size() + 1;
    int j = 0;
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.yDG.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label539;
      }
      localTableRow = new TableRow(this.context);
      this.yDG.put(Integer.valueOf(j), localTableRow);
    }
    label403:
    label539:
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
          this.yDE.addView(localTableRow);
        }
        ac.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - l));
        j += 1;
        break;
        Object localObject2 = (View)this.yDF.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, 2131495581, null);
          this.yDF.put(Integer.valueOf(i), localObject1);
        }
        label253:
        ImageView localImageView;
        if (i == m - 1)
        {
          localObject2 = "";
          localImageView = (ImageView)((View)localObject1).findViewById(2131301202);
          if (i != m - 1) {
            break label403;
          }
          if (this.yDK)
          {
            localImageView.setBackgroundResource(2131234098);
            localImageView.setContentDescription(getContext().getString(2131763773));
            localImageView.setImageDrawable(null);
            label310:
            if (this.yDJ != null)
            {
              if (i != m - 1) {
                break label500;
              }
              ((View)localObject1).setTag(Integer.valueOf(-1));
              ((View)localObject1).setOnClickListener(this.yDJ.yAf);
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
          break label253;
          localImageView.setBackgroundDrawable(null);
          localImageView.setTag(localObject2);
          localImageView.setContentDescription(getContext().getString(2131763849));
          Bitmap localBitmap = (Bitmap)this.yDI.get(localObject2);
          if (!q.I(localBitmap))
          {
            ac.d("MicroMsg.PreviewImageView", "bm is null");
            new a(localImageView, (String)localObject2).x(new String[] { "" });
            break label310;
          }
          localImageView.setImageBitmap(localBitmap);
          break label310;
          label500:
          ((View)localObject1).setTag(Integer.valueOf(i));
          ((View)localObject1).setOnClickListener(this.yDJ.yAf);
          ((View)localObject1).setClickable(true);
        }
        AppMethodBeat.o(98203);
        return;
      }
    }
  }
  
  final class a
    extends g<String, Integer, Boolean>
  {
    private ImageView dkL;
    private Bitmap hua;
    private String path;
    
    public a(ImageView paramImageView, String paramString)
    {
      this.dkL = paramImageView;
      this.path = paramString;
    }
    
    public final ExecutorService dBu()
    {
      AppMethodBeat.i(179158);
      ExecutorService localExecutorService = af.dHB();
      AppMethodBeat.o(179158);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView
 * JD-Core Version:    0.7.0.1
 */