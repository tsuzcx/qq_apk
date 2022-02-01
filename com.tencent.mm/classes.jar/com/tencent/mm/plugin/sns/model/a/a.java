package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;

public final class a
{
  public String dnn;
  public String md5 = "";
  public String mediaId = "";
  public int mediaType = 0;
  public int size;
  public String url = "";
  public m xMO = null;
  public SparseArray<m> xMP;
  public String xNA = "";
  public SparseArray<btz> xNC;
  public String xNz = "";
  public String xRt = "";
  public String xRx = "";
  public btz xRy;
  public boolean xXY = false;
  public boolean xXZ = false;
  public int xYa = 0;
  public bf xYb;
  public float xYc = 0.0F;
  
  public a(String paramString)
  {
    this.mediaId = paramString;
  }
  
  public a(String paramString, SparseArray<btz> paramSparseArray, SparseArray<m> paramSparseArray1, int paramInt)
  {
    this.dnn = paramString;
    this.xNC = paramSparseArray;
    this.xMP = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String dIT()
  {
    AppMethodBeat.i(96064);
    if (this.xYa == 4)
    {
      str = q.o(this.xRy);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.xYa == 6)
    {
      str = q.p(this.xRy);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.xXY)
    {
      str = q.m(this.xRy);
      AppMethodBeat.o(96064);
      return str;
    }
    String str = q.l(this.xRy);
    AppMethodBeat.o(96064);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(96065);
    if (!bs.isNullOrNil(this.xNz))
    {
      str = this.xNz;
      AppMethodBeat.o(96065);
      return str;
    }
    if (bs.isNullOrNil(this.xRt)) {
      init();
    }
    String str = this.xRt;
    AppMethodBeat.o(96065);
    return str;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(96063);
    this.xRt = an.jc(af.getAccSnsPath(), this.mediaId);
    AppMethodBeat.o(96063);
    return true;
  }
  
  public final a ji(String paramString1, String paramString2)
  {
    this.xNz = paramString1;
    this.xNA = paramString2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */