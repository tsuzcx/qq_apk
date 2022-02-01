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
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class PreviewImageView
  extends LinearLayout
  implements z
{
  private TableLayout EuT;
  private final Map<Integer, View> EuU;
  private final Map<Integer, TableRow> EuV;
  private final int EuW;
  private HashMap<String, Bitmap> EuX;
  private z.a EuY;
  private boolean EuZ;
  private boolean Eva;
  private final Context context;
  private List<String> list;
  
  public PreviewImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98198);
    this.list = new ArrayList();
    this.EuU = new HashMap();
    this.EuV = new HashMap();
    this.EuX = new HashMap();
    this.EuW = 4;
    this.EuZ = true;
    this.Eva = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98198);
  }
  
  public PreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98197);
    this.list = new ArrayList();
    this.EuU = new HashMap();
    this.EuV = new HashMap();
    this.EuX = new HashMap();
    this.EuW = 4;
    this.EuZ = true;
    this.Eva = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98197);
  }
  
  private void fgJ()
  {
    AppMethodBeat.i(98200);
    if ((this.context instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      Point localPoint = new Point();
      localPoint.x = localDisplayMetrics.widthPixels;
      localPoint.y = localDisplayMetrics.heightPixels;
      aj.k(localPoint);
    }
    AppMethodBeat.o(98200);
  }
  
  private void init()
  {
    AppMethodBeat.i(98199);
    this.EuT = ((TableLayout)LayoutInflater.from(this.context).inflate(2131496477, this, true).findViewById(2131299180));
    fgJ();
    AppMethodBeat.o(98199);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(98202);
    this.Eva = true;
    Iterator localIterator = this.EuX.values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (r.M(localBitmap)) {
        localBitmap.recycle();
      }
    }
    AppMethodBeat.o(98202);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98201);
    int i = this.EuU.size();
    AppMethodBeat.o(98201);
    return i;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setImageClick(z.a parama)
  {
    this.EuY = parama;
  }
  
  public void setIsShowAddImage(boolean paramBoolean)
  {
    this.EuZ = paramBoolean;
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
    this.EuT.removeAllViews();
    int m = paramList.size() + 1;
    int j = 0;
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.EuV.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label539;
      }
      localTableRow = new TableRow(this.context);
      this.EuV.put(Integer.valueOf(j), localTableRow);
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
          this.EuT.addView(localTableRow);
        }
        Log.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - l));
        j += 1;
        break;
        Object localObject2 = (View)this.EuU.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, 2131496478, null);
          this.EuU.put(Integer.valueOf(i), localObject1);
        }
        label253:
        ImageView localImageView;
        if (i == m - 1)
        {
          localObject2 = "";
          localImageView = (ImageView)((View)localObject1).findViewById(2131302874);
          if (i != m - 1) {
            break label403;
          }
          if (this.EuZ)
          {
            localImageView.setBackgroundResource(2131234957);
            localImageView.setContentDescription(getContext().getString(2131765995));
            localImageView.setImageDrawable(null);
            label310:
            if (this.EuY != null)
            {
              if (i != m - 1) {
                break label500;
              }
              ((View)localObject1).setTag(Integer.valueOf(-1));
              ((View)localObject1).setOnClickListener(this.EuY.Erh);
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
          localImageView.setContentDescription(getContext().getString(2131766075));
          Bitmap localBitmap = (Bitmap)this.EuX.get(localObject2);
          if (!r.M(localBitmap))
          {
            Log.d("MicroMsg.PreviewImageView", "bm is null");
            new a(localImageView, (String)localObject2).y(new String[] { "" });
            break label310;
          }
          localImageView.setImageBitmap(localBitmap);
          break label310;
          label500:
          ((View)localObject1).setTag(Integer.valueOf(i));
          ((View)localObject1).setOnClickListener(this.EuY.Erh);
          ((View)localObject1).setClickable(true);
        }
        AppMethodBeat.o(98203);
        return;
      }
    }
  }
  
  final class a
    extends h<String, Integer, Boolean>
  {
    private ImageView dPk;
    private Bitmap iKs;
    private String path;
    
    public a(ImageView paramImageView, String paramString)
    {
      this.dPk = paramImageView;
      this.path = paramString;
    }
    
    public final ExecutorService eGk()
    {
      AppMethodBeat.i(179158);
      ExecutorService localExecutorService = aj.fay();
      AppMethodBeat.o(179158);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView
 * JD-Core Version:    0.7.0.1
 */