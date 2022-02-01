package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;

public final class a
{
  public p JQm = null;
  public SparseArray<p> JQn;
  public String JRo = "";
  public String JRp = "";
  public SparseArray<cvt> JRr;
  public String JVl = "";
  public String JVp = "";
  public cvt JVq;
  public boolean Kct = false;
  public boolean Kcu = false;
  public int Kcv = 0;
  public bp Kcw;
  public float Kcx = 0.0F;
  public String fLp;
  public String md5 = "";
  public String mediaId = "";
  public int mediaType = 0;
  public int size;
  public String url = "";
  
  public a(String paramString)
  {
    this.mediaId = paramString;
  }
  
  public a(String paramString, SparseArray<cvt> paramSparseArray, SparseArray<p> paramSparseArray1, int paramInt)
  {
    this.fLp = paramString;
    this.JRr = paramSparseArray;
    this.JQn = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String fPO()
  {
    AppMethodBeat.i(96064);
    if (this.Kcv == 4)
    {
      if ((!Util.isNullOrNil(this.mediaId)) && (this.mediaId.contains("SlideFullCardAd_")))
      {
        Log.i("ParamsToLocalId", "preload, mediaId = " + this.mediaId);
        str = t.p(this.JVq);
        AppMethodBeat.o(96064);
        return str;
      }
      str = t.o(this.JVq);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.Kcv == 6)
    {
      str = t.q(this.JVq);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.Kct)
    {
      str = t.m(this.JVq);
      AppMethodBeat.o(96064);
      return str;
    }
    String str = t.l(this.JVq);
    AppMethodBeat.o(96064);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(96065);
    if (!Util.isNullOrNil(this.JRo))
    {
      str = this.JRo;
      AppMethodBeat.o(96065);
      return str;
    }
    if (Util.isNullOrNil(this.JVl)) {
      init();
    }
    String str = this.JVl;
    AppMethodBeat.o(96065);
    return str;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(96063);
    this.JVl = aq.kD(aj.getAccSnsPath(), this.mediaId);
    AppMethodBeat.o(96063);
    return true;
  }
  
  public final a kJ(String paramString1, String paramString2)
  {
    this.JRo = paramString1;
    this.JRp = paramString2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */