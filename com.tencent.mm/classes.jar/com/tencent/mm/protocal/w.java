package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;

public final class w
  extends k
{
  private final int funcId;
  private final String uri;
  private final w.a wiQ;
  private final w.b wiR;
  
  public w(int paramInt1, String paramString, int paramInt2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154526);
    this.wiQ = new w.a();
    this.wiR = new w.b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.wiQ.funcId = paramInt1;
    this.wiQ.wiT = paramArrayOfByte;
    this.wiQ.wiS.wsK = paramInt2;
    this.wiQ.wiS.wsL = paramSKBuiltinBuffer_t;
    AppMethodBeat.o(154526);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.wiQ;
  }
  
  public final l.e getRespObj()
  {
    return this.wiR;
  }
  
  public final int getType()
  {
    return this.funcId;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.w
 * JD-Core Version:    0.7.0.1
 */