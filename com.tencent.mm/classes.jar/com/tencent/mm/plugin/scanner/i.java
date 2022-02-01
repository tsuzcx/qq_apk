package com.tencent.mm.plugin.scanner;

import android.content.Context;
import android.graphics.PointF;
import android.os.Vibrator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ImageCodeManager;", "", "()V", "TAG", "", "animateScanCodeSuccessView", "", "context", "Landroid/content/Context;", "successView", "Landroid/view/View;", "transX", "", "transY", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "getGreenPointOnCurrentView", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "Lkotlin/collections/ArrayList;", "Landroid/graphics/PointF;", "currentView", "dataList", "wvOffset", "", "handleCode", "handleListener", "Lcom/tencent/mm/plugin/scanner/ImageCodeHandleListener;", "needShowScanCodeSuccessView", "", "point", "viewWidth", "viewHeight", "successViewSize", "vibrate", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i OGO;
  
  static
  {
    AppMethodBeat.i(313354);
    OGO = new i();
    AppMethodBeat.o(313354);
  }
  
  public static final r<ArrayList<ImageQBarDataBean>, ArrayList<PointF>> a(Context paramContext, View paramView, ArrayList<ImageQBarDataBean> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(313350);
    s.u(paramContext, "context");
    s.u(paramArrayList, "dataList");
    int i = bd.bs(paramContext, c.c.multi_code_green_dot_size);
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
          PointF localPointF = new PointF(localImageQBarDataBean.OGR, localImageQBarDataBean.OGS);
          label149:
          int j;
          int k;
          boolean bool;
          if ((paramView instanceof com.tencent.mm.ui.base.i))
          {
            paramArrayList = ((com.tencent.mm.ui.base.i)paramView).a(localPointF, localImageQBarDataBean.hXo, localImageQBarDataBean.hXp);
            s.s(paramArrayList, "{\n                      …ht)\n                    }");
            j = paramView.getMeasuredWidth();
            k = paramView.getMeasuredHeight();
            s.u(paramContext, "context");
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
            localHashSet.add(localImageQBarDataBean.OGQ);
            break;
            paramArrayList = new PointF(localImageQBarDataBean.OGR * paramView.getMeasuredWidth(), localImageQBarDataBean.OGS * paramView.getMeasuredHeight() + paramInt);
            break label149;
            label285:
            int m = bd.fromDPToPix(paramContext, 16);
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
        Log.i("MicroMsg.ScanCodeViewHelper", s.X("getGreenPointOnCurrentView, all the point is the same url:", Integer.valueOf(localArrayList1.size())));
        paramContext = localArrayList1.get(0);
        s.s(paramContext, "codePointInfoList[0]");
        paramContext = (ImageQBarDataBean)paramContext;
        paramView = localArrayList2.get(0);
        s.s(paramView, "dstPointList[0]");
        paramView = (PointF)paramView;
        localArrayList1.clear();
        localArrayList1.add(paramContext);
        localArrayList2.clear();
        localArrayList2.add(paramView);
      }
    }
    paramContext = new r(localArrayList1, localArrayList2);
    AppMethodBeat.o(313350);
    return paramContext;
  }
  
  public static final void a(Context paramContext, View paramView, ArrayList<ImageQBarDataBean> paramArrayList, int paramInt, h paramh)
  {
    AppMethodBeat.i(313339);
    s.u(paramContext, "context");
    s.u(paramArrayList, "dataList");
    ArrayList localArrayList;
    Object localObject;
    if (paramView != null)
    {
      int i;
      if (((Collection)paramArrayList).isEmpty())
      {
        i = 1;
        if (i == 0)
        {
          localArrayList = new ArrayList();
          localArrayList.addAll((Collection)paramArrayList);
          localObject = a(paramContext, paramView, localArrayList, paramInt);
          paramView = (ArrayList)((r)localObject).bsC;
          localObject = (ArrayList)((r)localObject).bsD;
          Log.i("MicroMsg.ScanCodeViewHelper", "handleCode  dataList:" + paramArrayList.size() + "  dstPointListOnCurrentDisplay:" + ((ArrayList)localObject).size() + ' ');
          s.u(paramContext, "context");
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            paramContext = paramContext.getSystemService("vibrator");
            if (!(paramContext instanceof Vibrator)) {
              continue;
            }
            paramContext = (Vibrator)paramContext;
            if (paramContext != null) {
              paramContext.vibrate(10L);
            }
          }
          catch (Exception paramContext)
          {
            Log.printErrStackTrace("MicroMsg.ScanCodeViewHelper", (Throwable)paramContext, "", new Object[0]);
            continue;
            paramh.a((ArrayList)localObject, paramView, localArrayList);
          }
          if (paramView.size() != 0) {
            continue;
          }
          if (paramArrayList.size() <= 0) {
            break label259;
          }
          paramContext = paramArrayList.get(0);
          s.s(paramContext, "dataList[0]");
          paramh.a((ImageQBarDataBean)paramContext, localArrayList);
          AppMethodBeat.o(313339);
          return;
          i = 0;
          break;
          paramContext = null;
        }
      }
    }
    label259:
    AppMethodBeat.o(313339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.i
 * JD-Core Version:    0.7.0.1
 */