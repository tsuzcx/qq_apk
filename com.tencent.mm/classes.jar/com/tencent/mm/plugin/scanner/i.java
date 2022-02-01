package com.tencent.mm.plugin.scanner;

import android.content.Context;
import android.graphics.PointF;
import android.os.Vibrator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ImageCodeManager;", "", "()V", "TAG", "", "animateScanCodeSuccessView", "", "context", "Landroid/content/Context;", "successView", "Landroid/view/View;", "transX", "", "transY", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "getGreenPointOnCurrentView", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "Lkotlin/collections/ArrayList;", "Landroid/graphics/PointF;", "currentView", "dataList", "wvOffset", "", "handleCode", "handleListener", "Lcom/tencent/mm/plugin/scanner/ImageCodeHandleListener;", "needShowScanCodeSuccessView", "", "point", "viewWidth", "viewHeight", "successViewSize", "vibrate", "plugin-comm_release"})
public final class i
{
  public static final i IAF;
  
  static
  {
    AppMethodBeat.i(199350);
    IAF = new i();
    AppMethodBeat.o(199350);
  }
  
  public static final o<ArrayList<ImageQBarDataBean>, ArrayList<PointF>> a(Context paramContext, View paramView, ArrayList<ImageQBarDataBean> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(199347);
    p.k(paramContext, "context");
    p.k(paramArrayList, "dataList");
    int i = aw.aZ(paramContext, c.c.multi_code_green_dot_size);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramView != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      while (localIterator.hasNext())
      {
        ImageQBarDataBean localImageQBarDataBean = (ImageQBarDataBean)localIterator.next();
        if (localImageQBarDataBean != null)
        {
          PointF localPointF = new PointF(localImageQBarDataBean.IAI, localImageQBarDataBean.IAJ);
          label149:
          int j;
          int k;
          boolean bool;
          if ((paramView instanceof g))
          {
            paramArrayList = ((g)paramView).a(localPointF, localImageQBarDataBean.fRr, localImageQBarDataBean.fRs);
            p.j(paramArrayList, "(currentView as IZoomabl…aBean.decodedImageHeight)");
            j = paramView.getMeasuredWidth();
            k = paramView.getMeasuredHeight();
            p.k(paramContext, "context");
            if (paramArrayList != null) {
              break label285;
            }
            bool = false;
          }
          for (;;)
          {
            Log.i("MicroMsg.ScanCodeViewHelper", "getGreenPointOnCurrentView  sourcePoint:" + localPointF + "  dstPoint:" + paramArrayList + "  " + bool);
            if (!bool) {
              break;
            }
            localArrayList1.add(localImageQBarDataBean);
            localArrayList2.add(paramArrayList);
            localHashSet.add(localImageQBarDataBean.IAH);
            break;
            paramArrayList = new PointF(localImageQBarDataBean.IAI * paramView.getMeasuredWidth(), localImageQBarDataBean.IAJ * paramView.getMeasuredHeight() + paramInt);
            break label149;
            label285:
            int m = aw.fromDPToPix(paramContext, 16);
            if ((paramArrayList.x < 0.0F) || (paramArrayList.x > j) || (paramArrayList.y < 0.0F) || (paramArrayList.y > k + paramInt - i / 2 - m)) {
              bool = false;
            } else {
              bool = true;
            }
          }
        }
      }
      if ((localArrayList1.size() > 1) && (localHashSet.size() == 1))
      {
        Log.i("MicroMsg.ScanCodeViewHelper", "getGreenPointOnCurrentView, all the point is the same url:" + localArrayList1.size());
        paramContext = localArrayList1.get(0);
        p.j(paramContext, "codePointInfoList[0]");
        paramContext = (ImageQBarDataBean)paramContext;
        paramView = localArrayList2.get(0);
        p.j(paramView, "dstPointList[0]");
        paramView = (PointF)paramView;
        localArrayList1.clear();
        localArrayList1.add(paramContext);
        localArrayList2.clear();
        localArrayList2.add(paramView);
      }
    }
    paramContext = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(199347);
    return paramContext;
  }
  
  public static final void a(Context paramContext, View paramView, ArrayList<ImageQBarDataBean> paramArrayList, int paramInt, h paramh)
  {
    AppMethodBeat.i(199341);
    p.k(paramContext, "context");
    p.k(paramArrayList, "dataList");
    ArrayList localArrayList1;
    if (paramView != null)
    {
      if (((Collection)paramArrayList).isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        localArrayList1 = new ArrayList();
        localArrayList1.addAll((Collection)paramArrayList);
        paramView = a(paramContext, paramView, localArrayList1, paramInt);
        ArrayList localArrayList2 = (ArrayList)paramView.Mx;
        ArrayList localArrayList3 = (ArrayList)paramView.My;
        Log.i("MicroMsg.ScanCodeViewHelper", "handleCode  dataList:" + paramArrayList.size() + "  dstPointListOnCurrentDisplay:" + localArrayList3.size() + ' ');
        p.k(paramContext, "context");
        try
        {
          paramView = paramContext.getSystemService("vibrator");
          paramContext = paramView;
          if (!(paramView instanceof Vibrator)) {
            paramContext = null;
          }
          paramContext = (Vibrator)paramContext;
          if (paramContext != null) {
            paramContext.vibrate(10L);
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ScanCodeViewHelper", (Throwable)paramContext, "", new Object[0]);
          }
          if (paramArrayList.size() <= 0) {
            break;
          }
          paramContext = paramArrayList.get(0);
          p.j(paramContext, "dataList[0]");
          paramContext = (ImageQBarDataBean)paramContext;
          if (paramContext == null) {
            break;
          }
          paramh.a(paramContext, localArrayList1);
          AppMethodBeat.o(199341);
          return;
        }
        switch (localArrayList2.size())
        {
        default: 
          paramh.a(localArrayList3, localArrayList2, localArrayList1);
          AppMethodBeat.o(199341);
          return;
        }
      }
    }
    AppMethodBeat.o(199341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.i
 * JD-Core Version:    0.7.0.1
 */