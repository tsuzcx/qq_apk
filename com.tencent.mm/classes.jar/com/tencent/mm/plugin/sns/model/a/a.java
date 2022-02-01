package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;

public final class a
{
  public String dpC;
  public String md5 = "";
  public String mediaId = "";
  public int mediaType = 0;
  public int size;
  public String url = "";
  public m wAv = null;
  public SparseArray<m> wAw;
  public String wBe = "";
  public String wBf = "";
  public SparseArray<bpi> wBh;
  public String wEY = "";
  public String wFc = "";
  public bpi wFd;
  public boolean wLs = false;
  public boolean wLt = false;
  public int wLu = 0;
  public bc wLv;
  public float wLw = 0.0F;
  
  public a(String paramString)
  {
    this.mediaId = paramString;
  }
  
  public a(String paramString, SparseArray<bpi> paramSparseArray, SparseArray<m> paramSparseArray1, int paramInt)
  {
    this.dpC = paramString;
    this.wBh = paramSparseArray;
    this.wAw = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String dut()
  {
    AppMethodBeat.i(96064);
    if (this.wLu == 4)
    {
      str = q.o(this.wFd);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.wLu == 6)
    {
      str = q.p(this.wFd);
      AppMethodBeat.o(96064);
      return str;
    }
    if (this.wLs)
    {
      str = q.m(this.wFd);
      AppMethodBeat.o(96064);
      return str;
    }
    String str = q.l(this.wFd);
    AppMethodBeat.o(96064);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(96065);
    if (!bt.isNullOrNil(this.wBe))
    {
      str = this.wBe;
      AppMethodBeat.o(96065);
      return str;
    }
    if (bt.isNullOrNil(this.wEY)) {
      init();
    }
    String str = this.wEY;
    AppMethodBeat.o(96065);
    return str;
  }
  
  public final a iL(String paramString1, String paramString2)
  {
    this.wBe = paramString1;
    this.wBf = paramString2;
    return this;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(96063);
    this.wEY = an.iF(af.getAccSnsPath(), this.mediaId);
    AppMethodBeat.o(96063);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */