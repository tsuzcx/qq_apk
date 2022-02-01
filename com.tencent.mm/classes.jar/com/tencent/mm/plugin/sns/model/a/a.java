package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;

public final class a
{
  public p QmT = null;
  public SparseArray<p> QmU;
  public String QnZ = "";
  public String Qoa = "";
  public SparseArray<dmz> Qoc;
  public String Qsm = "";
  public String Qsq = "";
  public dmz Qsr;
  public boolean QzL = false;
  public boolean QzM = false;
  public int QzN = 0;
  public br QzO;
  public float QzP = 0.0F;
  public String aesKey;
  public String authKey;
  public String hQX;
  public String md5 = "";
  public String mediaId = "";
  public int mediaType = 0;
  public int size;
  public String url = "";
  
  public a(String paramString)
  {
    this.mediaId = paramString;
  }
  
  public a(String paramString, SparseArray<dmz> paramSparseArray, SparseArray<p> paramSparseArray1, int paramInt)
  {
    this.hQX = paramString;
    this.Qoc = paramSparseArray;
    this.QmU = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(96065);
    if (!Util.isNullOrNil(this.QnZ))
    {
      str = this.QnZ;
      AppMethodBeat.o(96065);
      return str;
    }
    if (Util.isNullOrNil(this.Qsm)) {
      init();
    }
    String str = this.Qsm;
    AppMethodBeat.o(96065);
    return str;
  }
  
  public final String hhG()
  {
    AppMethodBeat.i(96064);
    if (this.QzN == 4)
    {
      if ((!Util.isNullOrNil(this.mediaId)) && (this.mediaId.contains("SlideFullCardAd_")))
      {
        Log.i("ParamsToLocalId", "preload, mediaId = " + this.mediaId);
        str = t.p(this.Qsr);
        AppMethodBeat.o(96064);
        return str;
      }
      str = t.o(this.Qsr);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.QzN == 6)
    {
      str = t.q(this.Qsr);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.QzL)
    {
      str = t.m(this.Qsr);
      AppMethodBeat.o(96064);
      return str;
    }
    String str = t.l(this.Qsr);
    AppMethodBeat.o(96064);
    return str;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(96063);
    this.Qsm = as.mg(al.getAccSnsPath(), this.mediaId);
    AppMethodBeat.o(96063);
    return true;
  }
  
  public final a mp(String paramString1, String paramString2)
  {
    this.QnZ = paramString1;
    this.Qoa = paramString2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */