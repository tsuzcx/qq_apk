package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvc
  extends com.tencent.mm.bw.a
{
  public String nWj;
  public String oGN;
  public int type;
  public String vxw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209576);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.vxw != null) {
        paramVarArgs.d(2, this.vxw);
      }
      if (this.oGN != null) {
        paramVarArgs.d(3, this.oGN);
      }
      if (this.nWj != null) {
        paramVarArgs.d(4, this.nWj);
      }
      AppMethodBeat.o(209576);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.vxw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vxw);
      }
      i = paramInt;
      if (this.oGN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGN);
      }
      paramInt = i;
      if (this.nWj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nWj);
      }
      AppMethodBeat.o(209576);
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
      AppMethodBeat.o(209576);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvc localdvc = (dvc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209576);
        return -1;
      case 1: 
        localdvc.type = locala.LVo.xF();
        AppMethodBeat.o(209576);
        return 0;
      case 2: 
        localdvc.vxw = locala.LVo.readString();
        AppMethodBeat.o(209576);
        return 0;
      case 3: 
        localdvc.oGN = locala.LVo.readString();
        AppMethodBeat.o(209576);
        return 0;
      }
      localdvc.nWj = locala.LVo.readString();
      AppMethodBeat.o(209576);
      return 0;
    }
    AppMethodBeat.o(209576);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvc
 * JD-Core Version:    0.7.0.1
 */