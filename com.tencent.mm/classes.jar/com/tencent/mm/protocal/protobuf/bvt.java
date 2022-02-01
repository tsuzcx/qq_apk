package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvt
  extends com.tencent.mm.bw.a
{
  public int fZz;
  public String wTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43109);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fZz);
      if (this.wTM != null) {
        paramVarArgs.d(2, this.wTM);
      }
      AppMethodBeat.o(43109);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.fZz) + 0;
      paramInt = i;
      if (this.wTM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wTM);
      }
      AppMethodBeat.o(43109);
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
      AppMethodBeat.o(43109);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvt localbvt = (bvt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43109);
        return -1;
      case 1: 
        localbvt.fZz = locala.LVo.xF();
        AppMethodBeat.o(43109);
        return 0;
      }
      localbvt.wTM = locala.LVo.readString();
      AppMethodBeat.o(43109);
      return 0;
    }
    AppMethodBeat.o(43109);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvt
 * JD-Core Version:    0.7.0.1
 */