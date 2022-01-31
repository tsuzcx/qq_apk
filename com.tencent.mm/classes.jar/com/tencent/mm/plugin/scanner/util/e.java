package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
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

public final class e
  extends b
{
  private Object ceY;
  private QbarNative hJj;
  private boolean hJk;
  private byte[] hJl;
  private byte[] hJm;
  public volatile boolean isDecoding;
  public boolean oIC;
  public int qCn;
  public boolean qyz;
  public Set<Integer> qzV;
  
  public e(b.a parama, int paramInt, boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(81381);
    this.hJk = false;
    this.isDecoding = false;
    this.oIC = true;
    this.qyz = false;
    this.ceY = new Object();
    this.hJj = new QbarNative();
    this.qCn = paramInt;
    this.oIC = paramBoolean;
    AppMethodBeat.o(81381);
  }
  
  private static Set<Integer> CN(int paramInt)
  {
    AppMethodBeat.i(81387);
    HashSet localHashSet = new HashSet();
    if (paramInt == 1)
    {
      localHashSet.add(Integer.valueOf(2));
      localHashSet.add(Integer.valueOf(4));
      localHashSet.add(Integer.valueOf(5));
      localHashSet.add(Integer.valueOf(3));
    }
    for (;;)
    {
      AppMethodBeat.o(81387);
      return localHashSet;
      if (paramInt == 2)
      {
        localHashSet.add(Integer.valueOf(1));
        localHashSet.add(Integer.valueOf(4));
        localHashSet.add(Integer.valueOf(5));
      }
      else if (paramInt == 0)
      {
        localHashSet.add(Integer.valueOf(2));
        localHashSet.add(Integer.valueOf(1));
        localHashSet.add(Integer.valueOf(4));
        localHashSet.add(Integer.valueOf(5));
        localHashSet.add(Integer.valueOf(3));
      }
      else if (paramInt == 3)
      {
        localHashSet.add(Integer.valueOf(2));
        localHashSet.add(Integer.valueOf(3));
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte, Point paramPoint1, Rect paramRect, Point paramPoint2)
  {
    for (;;)
    {
      long l;
      Object localObject;
      try
      {
        AppMethodBeat.i(81382);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
        {
          ab.w("MicroMsg.scanner.QBarDecoder", "prepareGrayData , data is null");
          paramArrayOfByte = null;
          AppMethodBeat.o(81382);
          return paramArrayOfByte;
        }
        ab.i("MicroMsg.scanner.QBarDecoder", "resolution %s, coverage %s", new Object[] { paramPoint1, paramRect });
        l = System.currentTimeMillis();
        localObject = new Rect();
        if ((com.tencent.mm.compatible.e.d.Ll()) || (!this.oIC))
        {
          i = paramRect.width();
          j = paramRect.height();
          ((Rect)localObject).left = paramRect.left;
          ((Rect)localObject).right = (paramRect.right - i % 4);
          ((Rect)localObject).top = paramRect.top;
          ((Rect)localObject).bottom = (paramRect.bottom - j % 4);
          if ((((Rect)localObject).right > ((Rect)localObject).left) && (((Rect)localObject).bottom > ((Rect)localObject).top)) {
            break label419;
          }
          paramArrayOfByte = null;
          AppMethodBeat.o(81382);
          continue;
        }
        ((Rect)localObject).left = (paramPoint1.x / 2 - paramRect.height() / 2);
      }
      finally {}
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
      int i = ((Rect)localObject).width() % 4;
      int j = ((Rect)localObject).height() % 4;
      if (i != 0) {
        ((Rect)localObject).right -= i;
      }
      if (j != 0) {
        ((Rect)localObject).bottom -= j;
      }
      if ((((Rect)localObject).right <= ((Rect)localObject).left) || (((Rect)localObject).bottom <= ((Rect)localObject).top))
      {
        paramArrayOfByte = null;
        AppMethodBeat.o(81382);
      }
      else
      {
        label419:
        ab.i("MicroMsg.scanner.QBarDecoder", "targetRect %s", new Object[] { localObject });
        paramRect = new d(paramArrayOfByte, paramPoint1.x, paramPoint1.y, (Rect)localObject);
        paramPoint2.x = paramRect.width;
        paramPoint2.y = paramRect.height;
        i = 0;
        if (!com.tencent.mm.compatible.e.d.Ll())
        {
          i = 90;
          paramPoint2.x = paramRect.height;
          paramPoint2.y = paramRect.width;
        }
        ab.d("MicroMsg.scanner.QBarDecoder", "rotate angle: ".concat(String.valueOf(i)));
        if (this.hJl == null)
        {
          this.hJl = new byte[paramRect.width * paramRect.height * 3 / 2];
          this.hJm = new byte[paramRect.width * paramRect.height];
          ab.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[] { Integer.valueOf(paramRect.width * paramRect.height * 3 / 2) });
        }
        for (;;)
        {
          localObject = this.hJl;
          j = paramPoint2.x;
          int k = paramPoint2.y;
          int m = paramPoint1.x;
          int n = paramPoint1.y;
          int i1 = paramRect.left;
          int i2 = paramRect.top;
          int i3 = paramRect.width;
          int i4 = paramRect.height;
          i = QbarNative.a((byte[])localObject, new int[] { j, k }, paramArrayOfByte, m, n, i1, i2, i3, i4, i);
          if (i == 0) {
            break label812;
          }
          ab.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", new Object[] { Integer.valueOf(i) });
          paramArrayOfByte = null;
          AppMethodBeat.o(81382);
          break;
          if (this.hJl.length != paramRect.width * paramRect.height * 3 / 2)
          {
            this.hJl = null;
            this.hJl = new byte[paramRect.width * paramRect.height * 3 / 2];
            this.hJm = null;
            this.hJm = new byte[paramRect.width * paramRect.height];
            ab.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[] { Integer.valueOf(paramRect.width * paramRect.height * 3 / 2) });
          }
        }
        label812:
        System.arraycopy(this.hJl, 0, this.hJm, 0, this.hJm.length);
        ab.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        paramArrayOfByte = this.hJm;
        AppMethodBeat.o(81382);
      }
    }
  }
  
  private boolean b(byte[] paramArrayOfByte, Point paramPoint)
  {
    AppMethodBeat.i(81386);
    long l1 = System.currentTimeMillis();
    ab.i("MicroMsg.scanner.QBarDecoder", "decode() start");
    if (this.isDecoding)
    {
      ab.e("MicroMsg.scanner.QBarDecoder", "is decoding, return false");
      AppMethodBeat.o(81386);
      return false;
    }
    if (this.qyz)
    {
      ab.w("MicroMsg.scanner.QBarDecoder", "isReleasing, return false 1");
      AppMethodBeat.o(81386);
      return false;
    }
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.scanner.QBarDecoder", "wrong args");
      AppMethodBeat.o(81386);
      return false;
    }
    for (;;)
    {
      synchronized (this.ceY)
      {
        this.isDecoding = true;
        this.qCa = null;
        this.cpF = 0;
        this.cpE = 0;
        n.qux.cih();
        try
        {
          i = this.qCn;
          if (!this.hJk)
          {
            localObject2 = CN(i);
            if ((!this.hJk) && (!((Set)localObject2).isEmpty()))
            {
              i = this.hJj.a(0, "ANY", "UTF-8", a.iQ(ah.getContext()));
              a.a(this.hJj);
              n.qux.quN = ((Set)localObject2).contains(Integer.valueOf(3));
              int j = g((Set)localObject2);
              ab.i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), QbarNative.getVersion() });
              if ((i == 0) && (j == 0)) {
                this.hJk = true;
              }
            }
            else
            {
              bool = this.hJk;
              if (bool) {
                continue;
              }
              pJ();
              this.isDecoding = false;
              AppMethodBeat.o(81386);
              return false;
            }
            ab.e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
            bool = false;
            continue;
          }
          else
          {
            bool = this.hJk;
            continue;
          }
          long l2 = System.currentTimeMillis();
          ab.i("MicroMsg.scanner.QBarDecoder", "data len %d, image size %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), paramPoint });
          i = this.hJj.A(paramArrayOfByte, paramPoint.x, paramPoint.y);
          l2 = System.currentTimeMillis() - l2;
          Object localObject2 = this.hJj;
          paramArrayOfByte = new QbarNative.QBarZoomInfo();
          ((QbarNative)localObject2).GetZoomInfo(paramArrayOfByte, ((QbarNative)localObject2).BhG);
          ab.i("MicroMsg.scanner.QBarDecoder", "after scanImage, result:%d, isZoom %b, zoomFactor %f", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramArrayOfByte.isZoom), Float.valueOf(paramArrayOfByte.zoomFactor) });
          if ((i < 0) && (paramArrayOfByte.isZoom) && (this.qBY != null))
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("zoom_action", 6);
            ((Bundle)localObject2).putInt("zoom_type", 1);
            ((Bundle)localObject2).putInt("zoom_scale", (int)(paramArrayOfByte.zoomFactor * 100.0F));
            this.qBY.T((Bundle)localObject2);
          }
          n.qux.fn(paramPoint.x, paramPoint.y);
          n.qux.cii();
          long l3 = System.currentTimeMillis();
          n.qux.lc(l2);
          ab.d("MicroMsg.scanner.QBarDecoder", "decode ScanImage %s, cost:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l3 - l1) });
          if (i != 0)
          {
            paramArrayOfByte = n.qux;
            paramPoint = new ArrayList();
            localObject2 = new ArrayList();
            this.hJj.x(paramPoint, (List)localObject2);
            paramArrayOfByte.quO = paramPoint;
            this.isDecoding = false;
            AppMethodBeat.o(81386);
            return false;
          }
          n.qux.cig();
          n.qux.ld(l2);
          paramPoint = new LinkedList();
          localObject2 = new LinkedList();
          this.hJj.w(paramPoint, (List)localObject2);
          if (paramPoint.size() != 0)
          {
            localQBarResult = (QbarNative.QBarResult)paramPoint.get(0);
            ab.i("MicroMsg.scanner.QBarDecoder", "decode size %d, type:%s, sCharset: %s, data:%s", new Object[] { Integer.valueOf(paramPoint.size()), localQBarResult.typeName, localQBarResult.charset, localQBarResult.data });
            paramArrayOfByte = null;
            if (!bo.es((List)localObject2)) {
              paramArrayOfByte = (QbarNative.QBarReportMsg)((List)localObject2).get(0);
            }
            if (localQBarResult != null)
            {
              if (!bo.isNullOrNil(localQBarResult.data))
              {
                str = localQBarResult.typeName;
                if ((!str.equals("QR_CODE")) && (!str.equals("WX_CODE"))) {
                  continue;
                }
                this.qCa = localQBarResult.data;
                quq = 1;
              }
              this.cpE = t.YP(localQBarResult.typeName);
              if (paramArrayOfByte == null) {
                break label1010;
              }
              i = paramArrayOfByte.qrcodeVersion;
              this.cpF = i;
              this.typeName = localQBarResult.typeName;
              this.rawData = localQBarResult.rawData;
              n.qux.a(localQBarResult.typeName, this.qCa, localQBarResult.charset, paramArrayOfByte, paramPoint.size(), (List)localObject2);
            }
          }
        }
        catch (Exception paramArrayOfByte)
        {
          QbarNative.QBarResult localQBarResult;
          String str;
          ab.printErrStackTrace("MicroMsg.scanner.QBarDecoder", paramArrayOfByte, "decodeInternal error", new Object[0]);
          continue;
        }
        this.isDecoding = false;
        this.qCb = (System.currentTimeMillis() - l1);
        ab.i("MicroMsg.scanner.QBarDecoder", "decode() finish, resultText = [%s], cost:%d", new Object[] { this.qCa, Long.valueOf(this.qCb) });
        if (bo.isNullOrNil(this.qCa)) {
          break label1015;
        }
        bool = true;
        AppMethodBeat.o(81386);
        return bool;
        this.qCa = (str + "," + localQBarResult.data);
        quq = 2;
      }
      label1010:
      int i = 0;
      continue;
      label1015:
      boolean bool = false;
    }
  }
  
  private int g(Set<Integer> arg1)
  {
    AppMethodBeat.i(81389);
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
      ab.i("MicroMsg.scanner.QBarDecoder", "QBarNative.SetReaders, readers:%s", new Object[] { Arrays.toString(arrayOfInt) });
      synchronized (this.ceY)
      {
        if (this.hJj != null)
        {
          i = this.hJj.i(arrayOfInt, arrayOfInt.length);
          AppMethodBeat.o(81389);
          return i;
        }
        AppMethodBeat.o(81389);
        return 0;
      }
    }
    AppMethodBeat.o(81389);
    return 0;
  }
  
  public final void a(byte[] paramArrayOfByte, Point paramPoint)
  {
    AppMethodBeat.i(81385);
    com.tencent.mm.sdk.g.d.f(new e.1(this, paramArrayOfByte, paramPoint), "scan_decode");
    AppMethodBeat.o(81385);
  }
  
  public final boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect)
  {
    AppMethodBeat.i(81383);
    Point localPoint = new Point();
    paramArrayOfByte = a(paramArrayOfByte, paramPoint, paramRect, localPoint);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      boolean bool = b(paramArrayOfByte, localPoint);
      AppMethodBeat.o(81383);
      return bool;
    }
    AppMethodBeat.o(81383);
    return false;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, Point paramPoint1, int paramInt, Rect paramRect, Point paramPoint2)
  {
    try
    {
      AppMethodBeat.i(81384);
      byte[] arrayOfByte1 = paramArrayOfByte;
      if (270 == paramInt)
      {
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.length];
        QbarNative.a(arrayOfByte2, paramArrayOfByte, paramPoint1.x, paramPoint1.y);
        arrayOfByte1 = new byte[paramArrayOfByte.length];
        QbarNative.a(arrayOfByte1, arrayOfByte2, paramPoint1.y, paramPoint1.x);
        QbarNative.nativeRelease();
      }
      paramArrayOfByte = a(arrayOfByte1, paramPoint1, paramRect, paramPoint2);
      AppMethodBeat.o(81384);
      return paramArrayOfByte;
    }
    finally {}
  }
  
  public final void cjs()
  {
    AppMethodBeat.i(81388);
    if (this.hJk)
    {
      Set localSet2 = this.qzV;
      Set localSet1;
      if (localSet2 != null)
      {
        localSet1 = localSet2;
        if (!localSet2.isEmpty()) {}
      }
      else
      {
        localSet1 = CN(this.qCn);
      }
      g(localSet1);
    }
    AppMethodBeat.o(81388);
  }
  
  public final void pJ()
  {
    AppMethodBeat.i(81390);
    ab.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", new Object[] { Boolean.valueOf(this.hJk) });
    this.qyz = true;
    synchronized (this.ceY)
    {
      if (this.hJk)
      {
        int i = this.hJj.release();
        this.hJj = null;
        this.hJk = false;
        ab.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", new Object[] { Integer.valueOf(i) });
      }
      d.cjp();
      AppMethodBeat.o(81390);
      return;
    }
  }
  
  public final void restartDecoder()
  {
    AppMethodBeat.i(81391);
    if (this.hJk)
    {
      pJ();
      this.hJk = false;
    }
    this.qyz = false;
    this.isDecoding = false;
    this.hJj = new QbarNative();
    AppMethodBeat.o(81391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e
 * JD-Core Version:    0.7.0.1
 */