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
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
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
  implements ac
{
  private TableLayout Rik;
  private final Map<Integer, View> Ril;
  private final Map<Integer, TableRow> Rim;
  private final int Rin;
  private HashMap<String, Bitmap> Rip;
  private ac.a Riq;
  private boolean Rir;
  private boolean Ris;
  private final Context context;
  private List<String> list;
  
  public PreviewImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98198);
    this.list = new ArrayList();
    this.Ril = new HashMap();
    this.Rim = new HashMap();
    this.Rip = new HashMap();
    this.Rin = 4;
    this.Rir = true;
    this.Ris = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98198);
  }
  
  public PreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98197);
    this.list = new ArrayList();
    this.Ril = new HashMap();
    this.Rim = new HashMap();
    this.Rip = new HashMap();
    this.Rin = 4;
    this.Rir = true;
    this.Ris = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98197);
  }
  
  private void hng()
  {
    AppMethodBeat.i(98200);
    if ((this.context instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      Point localPoint = new Point();
      localPoint.x = localDisplayMetrics.widthPixels;
      localPoint.y = localDisplayMetrics.heightPixels;
      al.m(localPoint);
    }
    AppMethodBeat.o(98200);
  }
  
  private void init()
  {
    AppMethodBeat.i(98199);
    this.Rik = ((TableLayout)LayoutInflater.from(this.context).inflate(b.g.sns_preview_view, this, true).findViewById(b.f.content));
    hng();
    AppMethodBeat.o(98199);
  }
  
  public final void ah(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(369931);
    long l = System.currentTimeMillis();
    if (paramList == null)
    {
      AppMethodBeat.o(369931);
      return;
    }
    this.list = paramList;
    int i = 0;
    this.Rik.removeAllViews();
    int m = paramList.size() + 1;
    int j = 0;
    TableRow localTableRow;
    if (i < m)
    {
      localTableRow = (TableRow)this.Rim.get(Integer.valueOf(j));
      if (localTableRow != null) {
        break label541;
      }
      localTableRow = new TableRow(this.context);
      this.Rim.put(Integer.valueOf(j), localTableRow);
    }
    label256:
    label406:
    label541:
    for (;;)
    {
      localTableRow.removeAllViews();
      int k = 0;
      if ((k < 4) && (i < m)) {
        if (i >= paramInt) {
          i += 1;
        }
      }
      for (;;)
      {
        if (localTableRow.getChildCount() > 0) {
          this.Rik.addView(localTableRow);
        }
        Log.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - l));
        j += 1;
        break;
        Object localObject2 = (View)this.Ril.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = View.inflate(this.context, b.g.sns_preview_view_item, null);
          this.Ril.put(Integer.valueOf(i), localObject1);
        }
        ImageView localImageView;
        if (i == m - 1)
        {
          localObject2 = "";
          localImageView = (ImageView)((View)localObject1).findViewById(b.f.iv);
          if (i != m - 1) {
            break label406;
          }
          if (this.Rir)
          {
            localImageView.setBackgroundResource(b.e.sns_add_item);
            localImageView.setContentDescription(getContext().getString(b.j.sns_add_photo));
            localImageView.setImageDrawable(null);
            label313:
            if (this.Riq != null)
            {
              if (i != m - 1) {
                break label502;
              }
              ((View)localObject1).setTag(Integer.valueOf(-1));
              ((View)localObject1).setOnClickListener(this.Riq.Rea);
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
          break label256;
          localImageView.setBackgroundDrawable(null);
          localImageView.setTag(localObject2);
          localImageView.setContentDescription(getContext().getString(b.j.sns_img));
          Bitmap localBitmap = (Bitmap)this.Rip.get(localObject2);
          if (!t.S(localBitmap))
          {
            Log.d("MicroMsg.PreviewImageView", "bm is null");
            new a(localImageView, (String)localObject2).A(new String[] { "" });
            break label313;
          }
          localImageView.setImageBitmap(localBitmap);
          break label313;
          label502:
          ((View)localObject1).setTag(Integer.valueOf(i));
          ((View)localObject1).setOnClickListener(this.Riq.Rea);
          ((View)localObject1).setClickable(true);
        }
        AppMethodBeat.o(369931);
        return;
      }
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(98202);
    this.Ris = true;
    Iterator localIterator = this.Rip.values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (t.S(localBitmap)) {
        localBitmap.recycle();
      }
    }
    AppMethodBeat.o(98202);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98201);
    int i = this.Ril.size();
    AppMethodBeat.o(98201);
    return i;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setImageClick(ac.a parama)
  {
    this.Riq = parama;
  }
  
  public void setIsShowAddImage(boolean paramBoolean)
  {
    this.Rir = paramBoolean;
  }
  
  final class a
    extends h<String, Integer, Boolean>
  {
    private ImageView hNV;
    private Bitmap orY;
    private String path;
    
    public a(ImageView paramImageView, String paramString)
    {
      this.hNV = paramImageView;
      this.path = paramString;
    }
    
    public final ExecutorService gDT()
    {
      AppMethodBeat.i(179158);
      ExecutorService localExecutorService = al.hgl();
      AppMethodBeat.o(179158);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView
 * JD-Core Version:    0.7.0.1
 */