package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;

public final class a
{
  public n DDH = null;
  public SparseArray<n> DDI;
  public String DEt = "";
  public String DEu = "";
  public SparseArray<cnb> DEw;
  public String DIl = "";
  public String DIp = "";
  public cnb DIq;
  public boolean DPm = false;
  public boolean DPn = false;
  public int DPo = 0;
  public bp DPp;
  public float DPq = 0.0F;
  public String dRS;
  public String md5 = "";
  public String mediaId = "";
  public int mediaType = 0;
  public int size;
  public String url = "";
  
  public a(String paramString)
  {
    this.mediaId = paramString;
  }
  
  public a(String paramString, SparseArray<cnb> paramSparseArray, SparseArray<n> paramSparseArray1, int paramInt)
  {
    this.dRS = paramString;
    this.DEw = paramSparseArray;
    this.DDI = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String fbV()
  {
    AppMethodBeat.i(96064);
    if (this.DPo == 4)
    {
      str = r.p(this.DIq);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.DPo == 6)
    {
      str = r.q(this.DIq);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.DPm)
    {
      str = r.n(this.DIq);
      AppMethodBeat.o(96064);
      return str;
    }
    String str = r.m(this.DIq);
    AppMethodBeat.o(96064);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(96065);
    if (!Util.isNullOrNil(this.DEt))
    {
      str = this.DEt;
      AppMethodBeat.o(96065);
      return str;
    }
    if (Util.isNullOrNil(this.DIl)) {
      init();
    }
    String str = this.DIl;
    AppMethodBeat.o(96065);
    return str;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(96063);
    this.DIl = ar.ki(aj.getAccSnsPath(), this.mediaId);
    AppMethodBeat.o(96063);
    return true;
  }
  
  public final a ko(String paramString1, String paramString2)
  {
    this.DEt = paramString1;
    this.DEu = paramString2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */