package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class a
{
  protected int JQg;
  protected QbarNative JQh;
  
  public a()
  {
    AppMethodBeat.i(88393);
    this.JQg = -1;
    this.JQh = new QbarNative();
    AppMethodBeat.o(88393);
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(88402);
    paramInt1 = QbarNative.Encode(paramArrayOfByte, paramArrayOfInt, paramString1, paramInt1, paramInt2, paramString2, -1);
    AppMethodBeat.o(88402);
    return paramInt1;
  }
  
  public static String getVersion()
  {
    AppMethodBeat.i(88394);
    String str = QbarNative.GetVersion();
    AppMethodBeat.o(88394);
    return str;
  }
  
  public int F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88397);
    try
    {
      if (this.JQg < 0) {
        return -1;
      }
      paramInt1 = this.JQh.ScanImage(paramArrayOfByte, paramInt1, paramInt2, this.JQg);
      return paramInt1;
    }
    finally
    {
      AppMethodBeat.o(88397);
    }
  }
  
  public final int I(List<QbarNative.QBarCodeDetectInfo> paramList, List<QbarNative.QBarPoint> paramList1)
  {
    int k = 0;
    AppMethodBeat.i(88401);
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (this.JQg < 0) {
          return 0;
        }
        QbarNative.QBarCodeDetectInfo[] arrayOfQBarCodeDetectInfo = new QbarNative.QBarCodeDetectInfo[3];
        QbarNative.QBarPoint[] arrayOfQBarPoint = new QbarNative.QBarPoint[3];
        i = 0;
        if (i < 3)
        {
          arrayOfQBarCodeDetectInfo[i] = new QbarNative.QBarCodeDetectInfo();
          arrayOfQBarPoint[i] = new QbarNative.QBarPoint();
          i += 1;
          continue;
        }
        paramList.clear();
        paramList1.clear();
        this.JQh.GetCodeDetectInfo(arrayOfQBarCodeDetectInfo, arrayOfQBarPoint, this.JQg);
        i = 0;
        j = k;
        if (i < 3)
        {
          QbarNative.QBarCodeDetectInfo localQBarCodeDetectInfo = arrayOfQBarCodeDetectInfo[i];
          if (localQBarCodeDetectInfo.readerId > 0) {
            paramList.add(localQBarCodeDetectInfo);
          }
        }
        else
        {
          if (j < 3)
          {
            arrayOfQBarCodeDetectInfo = arrayOfQBarPoint[j];
            if (arrayOfQBarCodeDetectInfo.point_cnt == 0) {
              break label205;
            }
            paramList1.add(arrayOfQBarCodeDetectInfo);
            break label205;
          }
          i = paramList.size();
          return i;
        }
      }
      finally
      {
        AppMethodBeat.o(88401);
      }
      i += 1;
      continue;
      label205:
      j += 1;
    }
  }
  
  public final int a(int paramInt, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    AppMethodBeat.i(88395);
    try
    {
      if (this.JQg < 0) {
        this.JQg = this.JQh.Init(1, paramInt, paramString1, paramString2, paramQbarAiModelParam);
      }
      System.out.println("qbarId:" + this.JQg);
      if (this.JQg < 0) {
        return -1;
      }
      return 0;
    }
    finally
    {
      AppMethodBeat.o(88395);
    }
  }
  
  public final List<a> fCb()
  {
    int j = 0;
    AppMethodBeat.i(88399);
    for (;;)
    {
      int i;
      try
      {
        if (this.JQg < 0) {
          return null;
        }
        QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[3];
        i = 0;
        if (i < 3)
        {
          arrayOfQBarResultJNI[i] = new QbarNative.QBarResultJNI();
          arrayOfQBarResultJNI[i].charset = new String();
          arrayOfQBarResultJNI[i].data = new byte[1024];
          arrayOfQBarResultJNI[i].typeName = new String();
          i += 1;
          continue;
        }
        this.JQh.GetResults(arrayOfQBarResultJNI, this.JQg);
        ArrayList localArrayList = new ArrayList();
        i = j;
        if (i < 3)
        {
          QbarNative.QBarResultJNI localQBarResultJNI = arrayOfQBarResultJNI[i];
          try
          {
            if ((localQBarResultJNI.typeName == null) || (localQBarResultJNI.typeName.isEmpty())) {
              break label289;
            }
            a locala = new a();
            locala.charset = localQBarResultJNI.charset;
            locala.typeID = localQBarResultJNI.typeID;
            locala.typeName = localQBarResultJNI.typeName;
            locala.rawData = localQBarResultJNI.data;
            if (locala.charset.equals("ANY"))
            {
              locala.data = new String(localQBarResultJNI.data, "UTF-8");
              localArrayList.add(locala);
              break label289;
            }
            locala.data = new String(localQBarResultJNI.data, locala.charset);
            continue;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        }
        else
        {
          AppMethodBeat.o(88399);
          return localArrayList;
        }
      }
      finally
      {
        AppMethodBeat.o(88399);
      }
      label289:
      i += 1;
    }
  }
  
  public final QbarNative.QBarZoomInfo fCc()
  {
    AppMethodBeat.i(88400);
    try
    {
      if (this.JQg < 0) {
        return null;
      }
      QbarNative.QBarZoomInfo localQBarZoomInfo = new QbarNative.QBarZoomInfo();
      this.JQh.GetZoomInfo(localQBarZoomInfo, this.JQg);
      return localQBarZoomInfo;
    }
    finally
    {
      AppMethodBeat.o(88400);
    }
  }
  
  public final int l(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(88396);
    try
    {
      if (this.JQg < 0) {
        return -1;
      }
      paramInt = this.JQh.SetReaders(paramArrayOfInt, paramInt, this.JQg);
      return paramInt;
    }
    finally
    {
      AppMethodBeat.o(88396);
    }
  }
  
  public final int release()
  {
    AppMethodBeat.i(88398);
    try
    {
      if (this.JQg < 0) {
        return 0;
      }
      int i = this.JQh.Release(this.JQg);
      this.JQg = -1;
      return i;
    }
    finally
    {
      AppMethodBeat.o(88398);
    }
  }
  
  public static class a
  {
    public String charset;
    public String data;
    public int priorityLevel;
    public byte[] rawData;
    public int typeID;
    public String typeName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.a
 * JD-Core Version:    0.7.0.1
 */