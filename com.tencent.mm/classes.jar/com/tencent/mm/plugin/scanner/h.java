package com.tencent.mm.plugin.scanner;

import android.graphics.PointF;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ImageCodeHandleListener;", "", "handleOutsideCode", "", "data", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "srcDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showMultiCodeView", "dstPointList", "Landroid/graphics/PointF;", "point", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
{
  public abstract void a(ImageQBarDataBean paramImageQBarDataBean, ArrayList<ImageQBarDataBean> paramArrayList);
  
  public abstract void a(ArrayList<PointF> paramArrayList, ArrayList<ImageQBarDataBean> paramArrayList1, ArrayList<ImageQBarDataBean> paramArrayList2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h
 * JD-Core Version:    0.7.0.1
 */