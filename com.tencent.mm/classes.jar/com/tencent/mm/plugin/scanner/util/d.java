package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import com.tencent.qbar.QbarNative.QBarResult;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import com.tencent.qbar.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class d
  extends b
{
  private Object bjn = new Object();
  private QbarNative gpf = new QbarNative();
  public boolean gpg = false;
  private byte[] gph;
  private byte[] gpi;
  public volatile boolean isDecoding = false;
  public boolean miw = true;
  public boolean nKU = false;
  public Set<Integer> nMo;
  public int nOx;
  private int nOy = 0;
  
  public d(b.a parama, int paramInt, boolean paramBoolean)
  {
    super(parama);
    this.nOx = paramInt;
    this.miw = paramBoolean;
    this.nOy = 0;
  }
  
  private boolean a(byte[] paramArrayOfByte, Point paramPoint)
  {
    long l1 = System.currentTimeMillis();
    y.i("MicroMsg.scanner.QBarDecoder", "decode() start");
    if (this.isDecoding)
    {
      y.e("MicroMsg.scanner.QBarDecoder", "is decoding, return false");
      return false;
    }
    if (this.nKU)
    {
      y.w("MicroMsg.scanner.QBarDecoder", "isReleasing, return false 1");
      return false;
    }
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.scanner.QBarDecoder", "wrong args");
      return false;
    }
    synchronized (this.bjn)
    {
      this.isDecoding = true;
      this.nOp = null;
      this.bIk = 0;
      this.bIj = 0;
      m.nHb.bxj();
    }
    try
    {
      int i = this.nOx;
      if (!this.gpg)
      {
        localObject2 = wT(i);
        if ((!this.gpg) && (!((Set)localObject2).isEmpty()))
        {
          i = this.gpf.a(0, "ANY", "UTF-8", a.hp(ae.getContext()));
          m.nHb.nHr = ((Set)localObject2).contains(Integer.valueOf(3));
          int j = g((Set)localObject2);
          y.i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), QbarNative.getVersion() });
          if ((i == 0) && (j == 0)) {
            this.gpg = true;
          }
        }
        else
        {
          bool = this.gpg;
        }
      }
      while (!bool)
      {
        nm();
        this.isDecoding = false;
        return false;
        paramArrayOfByte = finally;
        throw paramArrayOfByte;
        y.e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
        bool = false;
        continue;
        bool = this.gpg;
      }
      long l2 = System.currentTimeMillis();
      y.i("MicroMsg.scanner.QBarDecoder", "data len %d, image size %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), paramPoint });
      i = this.gpf.w(paramArrayOfByte, paramPoint.x, paramPoint.y);
      l2 = System.currentTimeMillis() - l2;
      Object localObject2 = this.gpf;
      paramArrayOfByte = new QbarNative.QBarZoomInfo();
      ((QbarNative)localObject2).GetZoomInfo(paramArrayOfByte, ((QbarNative)localObject2).wKg);
      y.i("MicroMsg.scanner.QBarDecoder", "after scanImage, result:%d, isZoom %b, zoomFactor %f", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramArrayOfByte.isZoom), Float.valueOf(paramArrayOfByte.zoomFactor) });
      if ((i < 0) && (paramArrayOfByte.isZoom) && (this.nOn != null))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("zoom_action", 6);
        ((Bundle)localObject2).putInt("zoom_type", 1);
        ((Bundle)localObject2).putInt("zoom_scale", (int)(paramArrayOfByte.zoomFactor * 100.0F));
        this.nOn.C((Bundle)localObject2);
      }
      m.nHb.dF(paramPoint.x, paramPoint.y);
      m.nHb.bxk();
      long l3 = System.currentTimeMillis();
      m.nHb.fz(l2);
      y.d("MicroMsg.scanner.QBarDecoder", "decode ScanImage %s, cost:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l3 - l1) });
      if (i != 0)
      {
        m.nHb.nHs = byl();
        this.isDecoding = false;
        return false;
      }
      m.nHb.bxi();
      m.nHb.fA(l2);
      byk();
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.scanner.QBarDecoder", paramArrayOfByte, "decodeInternal error", new Object[0]);
        continue;
        boolean bool = false;
      }
    }
    this.isDecoding = false;
    this.nOr = (System.currentTimeMillis() - l1);
    y.i("MicroMsg.scanner.QBarDecoder", "decode() finish, resultText = [%s], cost:%d", new Object[] { this.nOp, Long.valueOf(this.nOr) });
    if (!bk.bl(this.nOp))
    {
      bool = true;
      return bool;
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte, Point paramPoint1, Rect paramRect, Point paramPoint2)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      long l;
      try
      {
        if (paramArrayOfByte.length <= 0)
        {
          y.w("MicroMsg.scanner.QBarDecoder", "prepareGrayData , data is null");
          paramArrayOfByte = null;
          return paramArrayOfByte;
        }
        y.i("MicroMsg.scanner.QBarDecoder", "resolution %s, coverage %s", new Object[] { paramPoint1, paramRect });
        l = System.currentTimeMillis();
        Object localObject = new Rect();
        int j;
        if ((com.tencent.mm.compatible.e.d.yN()) || (!this.miw))
        {
          i = paramRect.width();
          j = paramRect.height();
          ((Rect)localObject).left = paramRect.left;
          ((Rect)localObject).right = (paramRect.right - i % 4);
          ((Rect)localObject).top = paramRect.top;
          ((Rect)localObject).bottom = (paramRect.bottom - j % 4);
          if (((Rect)localObject).right <= ((Rect)localObject).left) {
            break label847;
          }
          if (((Rect)localObject).bottom <= ((Rect)localObject).top) {
            break label847;
          }
        }
        else
        {
          ((Rect)localObject).left = (paramPoint1.x / 2 - paramRect.height() / 2);
          ((Rect)localObject).right = (paramPoint1.x / 2 + paramRect.height() / 2);
          ((Rect)localObject).top = (paramPoint1.y / 2 - paramRect.width() / 2);
          ((Rect)localObject).bottom = (paramPoint1.y / 2 + paramRect.width() / 2);
          if (((Rect)localObject).left < 0) {
            ((Rect)localObject).left = 0;
          }
          if (((Rect)localObject).right > paramPoint1.x - 1) {
            ((Rect)localObject).right = (paramPoint1.x - 1);
          }
          if (((Rect)localObject).top < 0) {
            ((Rect)localObject).top = 0;
          }
          if (((Rect)localObject).bottom > paramPoint1.y - 1) {
            ((Rect)localObject).bottom = (paramPoint1.y - 1);
          }
          i = ((Rect)localObject).width() % 4;
          j = ((Rect)localObject).height() % 4;
          if (i != 0) {
            ((Rect)localObject).right -= i;
          }
          if (j != 0) {
            ((Rect)localObject).bottom -= j;
          }
          if ((((Rect)localObject).right <= ((Rect)localObject).left) || (((Rect)localObject).bottom <= ((Rect)localObject).top)) {
            break label852;
          }
        }
        y.i("MicroMsg.scanner.QBarDecoder", "targetRect %s", new Object[] { localObject });
        paramRect = new c(paramArrayOfByte, paramPoint1.x, paramPoint1.y, (Rect)localObject);
        paramPoint2.x = paramRect.width;
        paramPoint2.y = paramRect.height;
        int i = 0;
        if (!com.tencent.mm.compatible.e.d.yN())
        {
          i = 90;
          paramPoint2.x = paramRect.height;
          paramPoint2.y = paramRect.width;
        }
        y.d("MicroMsg.scanner.QBarDecoder", "rotate angle: " + i);
        if (this.gph == null)
        {
          this.gph = new byte[paramRect.width * paramRect.height * 3 / 2];
          this.gpi = new byte[paramRect.width * paramRect.height];
          y.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[] { Integer.valueOf(paramRect.width * paramRect.height * 3 / 2) });
          localObject = this.gph;
          j = paramPoint2.x;
          int k = paramPoint2.y;
          int m = paramPoint1.x;
          int n = paramPoint1.y;
          int i1 = paramRect.left;
          int i2 = paramRect.top;
          int i3 = paramRect.width;
          int i4 = paramRect.height;
          i = QbarNative.a((byte[])localObject, new int[] { j, k }, paramArrayOfByte, m, n, i1, i2, i3, i4, i);
          if (i != 0)
          {
            y.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", new Object[] { Integer.valueOf(i) });
            paramArrayOfByte = null;
          }
        }
        else
        {
          if (this.gph.length == paramRect.width * paramRect.height * 3 / 2) {
            continue;
          }
          this.gph = null;
          this.gph = new byte[paramRect.width * paramRect.height * 3 / 2];
          this.gpi = null;
          this.gpi = new byte[paramRect.width * paramRect.height];
          y.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[] { Integer.valueOf(paramRect.width * paramRect.height * 3 / 2) });
          continue;
        }
        System.arraycopy(this.gph, 0, this.gpi, 0, this.gpi.length);
      }
      finally {}
      y.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramArrayOfByte = this.gpi;
      continue;
      label847:
      paramArrayOfByte = null;
      continue;
      label852:
      paramArrayOfByte = null;
    }
  }
  
  private void byk()
  {
    QbarNative.QBarReportMsg localQBarReportMsg = null;
    int m = 0;
    byl();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    this.gpf.m(localLinkedList1, localLinkedList2);
    if (localLinkedList1.size() == 0) {
      return;
    }
    y.i("MicroMsg.scanner.QBarDecoder", "GetResults size %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    Object localObject2 = localLinkedList1.iterator();
    int j = 0;
    label88:
    Object localObject1;
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (QbarNative.QBarResult)((Iterator)localObject2).next();
      y.i("MicroMsg.scanner.QBarDecoder", "GetResults type:%s, sCharset: %s, data:%s", new Object[] { ((QbarNative.QBarResult)localObject1).typeName, ((QbarNative.QBarResult)localObject1).charset, ((QbarNative.QBarResult)localObject1).data });
      if (a.afx(((QbarNative.QBarResult)localObject1).data))
      {
        if (j <= 0) {
          break label529;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label189:
      label236:
      int k;
      if ((localObject1 == null) && (localLinkedList1.size() > 0))
      {
        Iterator localIterator = localLinkedList1.iterator();
        j = 0;
        if (localIterator.hasNext())
        {
          localObject2 = (QbarNative.QBarResult)localIterator.next();
          if (!a.afy(((QbarNative.QBarResult)localObject2).data))
          {
            localObject1 = localObject2;
            if (j > 0)
            {
              i = 2;
              localObject1 = localObject2;
            }
            if (localObject1 != null) {
              break label516;
            }
            localObject1 = (QbarNative.QBarResult)localLinkedList1.get(0);
            k = 1;
            j = 0;
          }
        }
      }
      for (;;)
      {
        if ((k != 0) && (this.nOy < 6))
        {
          this.nOy += 1;
          y.i("MicroMsg.scanner.QBarDecoder", "GetResults badCodeTryTimes %d", new Object[] { Integer.valueOf(this.nOy) });
          return;
          j += 1;
          break label88;
          j += 1;
          break label189;
        }
        this.nOy = 0;
        if (j < localLinkedList2.size()) {
          localQBarReportMsg = (QbarNative.QBarReportMsg)localLinkedList2.get(j);
        }
        if (localObject1 == null) {
          break;
        }
        if (!bk.bl(((QbarNative.QBarResult)localObject1).data))
        {
          localObject2 = ((QbarNative.QBarResult)localObject1).typeName;
          if ((!((String)localObject2).equals("QR_CODE")) && (!((String)localObject2).equals("WX_CODE"))) {
            break label476;
          }
          this.nOp = ((QbarNative.QBarResult)localObject1).data;
        }
        for (nOq = 1;; nOq = 2)
        {
          this.bIj = r.Mi(((QbarNative.QBarResult)localObject1).typeName);
          j = m;
          if (localQBarReportMsg != null) {
            j = localQBarReportMsg.qrcodeVersion;
          }
          this.bIk = j;
          this.rawData = ((QbarNative.QBarResult)localObject1).rawData;
          m.nHb.a(((QbarNative.QBarResult)localObject1).typeName, this.nOp, ((QbarNative.QBarResult)localObject1).charset, localQBarReportMsg, localLinkedList1.size(), i);
          return;
          label476:
          this.nOp = ((String)localObject2 + "," + ((QbarNative.QBarResult)localObject1).data);
        }
        label516:
        k = 0;
        continue;
        break label236;
        k = 0;
      }
      label529:
      i = 0;
      continue;
      i = 0;
      localObject1 = null;
    }
  }
  
  private List<QbarNative.QBarCodeDetectInfo> byl()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    this.gpf.n(localArrayList1, localArrayList2);
    return localArrayList1;
  }
  
  public static Set<Integer> wT(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    if (paramInt == 1)
    {
      localHashSet.add(Integer.valueOf(2));
      localHashSet.add(Integer.valueOf(4));
      localHashSet.add(Integer.valueOf(5));
      localHashSet.add(Integer.valueOf(3));
    }
    do
    {
      return localHashSet;
      if (paramInt == 2)
      {
        localHashSet.add(Integer.valueOf(1));
        localHashSet.add(Integer.valueOf(4));
        localHashSet.add(Integer.valueOf(5));
        return localHashSet;
      }
      if (paramInt == 0)
      {
        localHashSet.add(Integer.valueOf(2));
        localHashSet.add(Integer.valueOf(1));
        localHashSet.add(Integer.valueOf(4));
        localHashSet.add(Integer.valueOf(5));
        localHashSet.add(Integer.valueOf(3));
        return localHashSet;
      }
    } while (paramInt != 3);
    localHashSet.add(Integer.valueOf(2));
    localHashSet.add(Integer.valueOf(3));
    return localHashSet;
  }
  
  public final boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect)
  {
    Point localPoint = new Point();
    paramArrayOfByte = a(paramArrayOfByte, paramPoint, paramRect, localPoint);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      return a(paramArrayOfByte, localPoint);
    }
    return false;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, Point paramPoint1, int paramInt, Rect paramRect, Point paramPoint2)
  {
    byte[] arrayOfByte1 = paramArrayOfByte;
    if (270 == paramInt) {}
    try
    {
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length];
      QbarNative.a(arrayOfByte2, paramArrayOfByte, paramPoint1.x, paramPoint1.y);
      arrayOfByte1 = new byte[paramArrayOfByte.length];
      QbarNative.a(arrayOfByte1, arrayOfByte2, paramPoint1.y, paramPoint1.x);
      QbarNative.nativeRelease();
      paramArrayOfByte = a(arrayOfByte1, paramPoint1, paramRect, paramPoint2);
      return paramArrayOfByte;
    }
    finally {}
  }
  
  public final void byg()
  {
    if (this.gpg)
    {
      nm();
      this.gpg = false;
    }
    this.nKU = false;
    this.isDecoding = false;
    this.gpf = new QbarNative();
  }
  
  public final int g(Set<Integer> arg1)
  {
    if ((??? != null) && (!???.isEmpty()))
    {
      int[] arrayOfInt = new int[???.size()];
      ??? = ???.iterator();
      int i = 0;
      while (???.hasNext())
      {
        Integer localInteger = (Integer)???.next();
        if (localInteger != null)
        {
          arrayOfInt[i] = localInteger.intValue();
          i += 1;
        }
      }
      y.i("MicroMsg.scanner.QBarDecoder", "QBarNative.SetReaders, readers:%s", new Object[] { Arrays.toString(arrayOfInt) });
      synchronized (this.bjn)
      {
        if (this.gpf != null)
        {
          i = this.gpf.h(arrayOfInt, arrayOfInt.length);
          return i;
        }
        return 0;
      }
    }
    return 0;
  }
  
  public final void nm()
  {
    y.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", new Object[] { Boolean.valueOf(this.gpg) });
    this.nKU = true;
    synchronized (this.bjn)
    {
      if (this.gpg)
      {
        int i = this.gpf.release();
        this.gpf = null;
        this.gpg = false;
        y.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", new Object[] { Integer.valueOf(i) });
      }
      c.byh();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.d
 * JD-Core Version:    0.7.0.1
 */