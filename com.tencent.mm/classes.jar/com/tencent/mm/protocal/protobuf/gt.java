package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gt
  extends com.tencent.mm.bw.a
{
  public int BIr;
  public boolean DTX;
  public String DTY;
  public String djs;
  public String djt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.DTX);
      paramVarArgs.aR(2, this.BIr);
      if (this.djs != null) {
        paramVarArgs.d(3, this.djs);
      }
      if (this.djt != null) {
        paramVarArgs.d(4, this.djt);
      }
      if (this.DTY != null) {
        paramVarArgs.d(5, this.DTY);
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0 + f.a.a.b.b.a.bx(2, this.BIr);
      paramInt = i;
      if (this.djs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.djs);
      }
      i = paramInt;
      if (this.djt != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.djt);
      }
      paramInt = i;
      if (this.DTY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DTY);
      }
      AppMethodBeat.o(19404);
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
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      gt localgt = (gt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19404);
        return -1;
      case 1: 
        localgt.DTX = locala.LVo.fZX();
        AppMethodBeat.o(19404);
        return 0;
      case 2: 
        localgt.BIr = locala.LVo.xF();
        AppMethodBeat.o(19404);
        return 0;
      case 3: 
        localgt.djs = locala.LVo.readString();
        AppMethodBeat.o(19404);
        return 0;
      case 4: 
        localgt.djt = locala.LVo.readString();
        AppMethodBeat.o(19404);
        return 0;
      }
      localgt.DTY = locala.LVo.readString();
      AppMethodBeat.o(19404);
      return 0;
    }
    AppMethodBeat.o(19404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gt
 * JD-Core Version:    0.7.0.1
 */