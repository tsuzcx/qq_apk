package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;

public final class a
{
  public String dAg;
  public String md5 = "";
  public String mediaId = "";
  public int mediaType = 0;
  public int size;
  public String url = "";
  public boolean zFm = false;
  public boolean zFn = false;
  public int zFo = 0;
  public bk zFp;
  public float zFq = 0.0F;
  public n ztw = null;
  public SparseArray<n> ztx;
  public String zuj = "";
  public String zuk = "";
  public SparseArray<bzh> zum;
  public String zyc = "";
  public String zyg = "";
  public bzh zyh;
  
  public a(String paramString)
  {
    this.mediaId = paramString;
  }
  
  public a(String paramString, SparseArray<bzh> paramSparseArray, SparseArray<n> paramSparseArray1, int paramInt)
  {
    this.dAg = paramString;
    this.zum = paramSparseArray;
    this.ztx = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String dYH()
  {
    AppMethodBeat.i(96064);
    if (this.zFo == 4)
    {
      str = r.o(this.zyh);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.zFo == 6)
    {
      str = r.p(this.zyh);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.zFm)
    {
      str = r.m(this.zyh);
      AppMethodBeat.o(96064);
      return str;
    }
    String str = r.l(this.zyh);
    AppMethodBeat.o(96064);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(96065);
    if (!bu.isNullOrNil(this.zuj))
    {
      str = this.zuj;
      AppMethodBeat.o(96065);
      return str;
    }
    if (bu.isNullOrNil(this.zyc)) {
      init();
    }
    String str = this.zyc;
    AppMethodBeat.o(96065);
    return str;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(96063);
    this.zyc = ap.jv(ah.getAccSnsPath(), this.mediaId);
    AppMethodBeat.o(96063);
    return true;
  }
  
  public final a jB(String paramString1, String paramString2)
  {
    this.zuj = paramString1;
    this.zuk = paramString2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */