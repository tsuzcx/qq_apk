package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cij
  extends com.tencent.mm.bw.a
{
  public boolean EQH;
  public int Fwu;
  public String dlt;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.EQH);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aR(4, this.version);
      paramVarArgs.aR(5, this.Fwu);
      if (this.dlt != null) {
        paramVarArgs.d(6, this.dlt);
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bx(4, this.version) + f.a.a.b.b.a.bx(5, this.Fwu);
      paramInt = i;
      if (this.dlt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dlt);
      }
      AppMethodBeat.o(123639);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cij localcij = (cij)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123639);
        return -1;
      case 1: 
        localcij.EQH = locala.LVo.fZX();
        AppMethodBeat.o(123639);
        return 0;
      case 2: 
        localcij.url = locala.LVo.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 3: 
        localcij.md5 = locala.LVo.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 4: 
        localcij.version = locala.LVo.xF();
        AppMethodBeat.o(123639);
        return 0;
      case 5: 
        localcij.Fwu = locala.LVo.xF();
        AppMethodBeat.o(123639);
        return 0;
      }
      localcij.dlt = locala.LVo.readString();
      AppMethodBeat.o(123639);
      return 0;
    }
    AppMethodBeat.o(123639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cij
 * JD-Core Version:    0.7.0.1
 */