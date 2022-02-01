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
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
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
  implements ab
{
  private TableLayout KIK;
  private final Map<Integer, View> KIL;
  private final Map<Integer, TableRow> KIM;
  private final int KIN;
  private HashMap<String, Bitmap> KIO;
  private ab.a KIP;
  private boolean KIQ;
  private boolean KIR;
  private final Context context;
  private List<String> list;
  
  public PreviewImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98198);
    this.list = new ArrayList();
    this.KIL = new HashMap();
    this.KIM = new HashMap();
    this.KIO = new HashMap();
    this.KIN = 4;
    this.KIQ = true;
    this.KIR = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98198);
  }
  
  public PreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98197);
    this.list = new ArrayList();
    this.KIL = new HashMap();
    this.KIM = new HashMap();
    this.KIO = new HashMap();
    this.KIN = 4;
    this.KIQ = true;
    this.KIR = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98197);
  }
  
  private void fUQ()
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
    this.KIK = ((TableLayout)LayoutInflater.from(this.context).inflate(i.g.sns_preview_view, this, true).findViewById(i.f.content));
    fUQ();
    AppMethodBeat.o(98199);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(98202);
    this.KIR = true;
    Iterator localIterator = this.KIO.values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (t.K(localBitmap)) {
        localBitmap.recycle();
      }
    }
    AppMethodBeat.o(98202);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98201);
    int i = this.KIL.size();
    AppMethodBeat.o(98201);
    return i;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void hJ(List<String> paramList)
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
    this.KIK.removeAllViews();
    int m = paramList.size() + 1;
    int j = 0;
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.KIM.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label539;
      }
      localTableRow = new TableRow(this.context);
      this.KIM.put(Integer.valueOf(j), localTableRow);
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
          this.KIK.addView(localTableRow);
        }
        Log.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - l));
        j += 1;
        break;
        Object localObject2 = (View)this.KIL.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, i.g.sns_preview_view_item, null);
          this.KIL.put(Integer.valueOf(i), localObject1);
        }
        label253:
        ImageView localImageView;
        if (i == m - 1)
        {
          localObject2 = "";
          localImageView = (ImageView)((View)localObject1).findViewById(i.f.iv);
          if (i != m - 1) {
            break label403;
          }
          if (this.KIQ)
          {
            localImageView.setBackgroundResource(i.e.sns_add_item);
            localImageView.setContentDescription(getContext().getString(i.j.sns_add_photo));
            localImageView.setImageDrawable(null);
            label310:
            if (this.KIP != null)
            {
              if (i != m - 1) {
                break label500;
              }
              ((View)localObject1).setTag(Integer.valueOf(-1));
              ((View)localObject1).setOnClickListener(this.KIP.KEA);
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
          localImageView.setContentDescription(getContext().getString(i.j.sns_img));
          Bitmap localBitmap = (Bitmap)this.KIO.get(localObject2);
          if (!t.K(localBitmap))
          {
            Log.d("MicroMsg.PreviewImageView", "bm is null");
            new a(localImageView, (String)localObject2).y(new String[] { "" });
            break label310;
          }
          localImageView.setImageBitmap(localBitmap);
          break label310;
          label500:
          ((View)localObject1).setTag(Integer.valueOf(i));
          ((View)localObject1).setOnClickListener(this.KIP.KEA);
          ((View)localObject1).setClickable(true);
        }
        AppMethodBeat.o(98203);
        return;
      }
    }
  }
  
  public void setImageClick(ab.a parama)
  {
    this.KIP = parama;
  }
  
  public void setIsShowAddImage(boolean paramBoolean)
  {
    this.KIQ = paramBoolean;
  }
  
  final class a
    extends h<String, Integer, Boolean>
  {
    private ImageView fIv;
    private Bitmap lAx;
    private String path;
    
    public a(ImageView paramImageView, String paramString)
    {
      this.fIv = paramImageView;
      this.path = paramString;
    }
    
    public final ExecutorService fsl()
    {
      AppMethodBeat.i(179158);
      ExecutorService localExecutorService = aj.fOs();
      AppMethodBeat.o(179158);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView
 * JD-Core Version:    0.7.0.1
 */