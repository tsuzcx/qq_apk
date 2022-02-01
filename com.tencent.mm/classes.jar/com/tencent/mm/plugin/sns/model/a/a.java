package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;

public final class a
{
  public String dzb;
  public String md5 = "";
  public String mediaId = "";
  public int mediaType = 0;
  public int size;
  public String url = "";
  public m zcG = null;
  public SparseArray<m> zcH;
  public String zdt = "";
  public String zdu = "";
  public SparseArray<byn> zdw;
  public String zhn = "";
  public String zhr = "";
  public byn zhs;
  public boolean znX = false;
  public boolean znY = false;
  public int znZ = 0;
  public bj zoa;
  public float zob = 0.0F;
  
  public a(String paramString)
  {
    this.mediaId = paramString;
  }
  
  public a(String paramString, SparseArray<byn> paramSparseArray, SparseArray<m> paramSparseArray1, int paramInt)
  {
    this.dzb = paramString;
    this.zdw = paramSparseArray;
    this.zcH = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String dVg()
  {
    AppMethodBeat.i(96064);
    if (this.znZ == 4)
    {
      str = q.o(this.zhs);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.znZ == 6)
    {
      str = q.p(this.zhs);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.znX)
    {
      str = q.m(this.zhs);
      AppMethodBeat.o(96064);
      return str;
    }
    String str = q.l(this.zhs);
    AppMethodBeat.o(96064);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(96065);
    if (!bt.isNullOrNil(this.zdt))
    {
      str = this.zdt;
      AppMethodBeat.o(96065);
      return str;
    }
    if (bt.isNullOrNil(this.zhn)) {
      init();
    }
    String str = this.zhn;
    AppMethodBeat.o(96065);
    return str;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(96063);
    this.zhn = ao.jo(ag.getAccSnsPath(), this.mediaId);
    AppMethodBeat.o(96063);
    return true;
  }
  
  public final a ju(String paramString1, String paramString2)
  {
    this.zdt = paramString1;
    this.zdu = paramString2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */