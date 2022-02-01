package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.storage.br;

public final class q
{
  public String QnZ;
  public String Qoa;
  public br Qob;
  public SparseArray<dmz> Qoc;
  public String aesKey;
  public String authKey;
  public String hQX;
  public dmz ibT;
  public String key;
  public int requestType;
  public int size;
  
  public q()
  {
    AppMethodBeat.i(95089);
    this.Qoc = new SparseArray();
    AppMethodBeat.o(95089);
  }
  
  private q(dmz paramdmz, int paramInt, String paramString1, br parambr, String paramString2, String paramString3)
  {
    this.ibT = paramdmz;
    this.requestType = paramInt;
    this.Qob = parambr;
    this.key = paramString1;
    this.QnZ = paramString2;
    this.Qoa = paramString3;
  }
  
  public q(dmz paramdmz, int paramInt, String paramString1, br parambr, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramdmz, paramInt, paramString1, parambr, paramString2, paramString3);
    this.aesKey = paramString4;
    this.authKey = paramString5;
  }
  
  public q(String paramString1, SparseArray<dmz> paramSparseArray, String paramString2, br parambr, int paramInt)
  {
    this.hQX = paramString1;
    this.Qoc = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.Qob = parambr;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.q
 * JD-Core Version:    0.7.0.1
 */