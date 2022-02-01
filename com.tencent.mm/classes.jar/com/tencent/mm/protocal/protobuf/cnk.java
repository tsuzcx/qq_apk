package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnk
  extends com.tencent.mm.bw.a
{
  public String AWx;
  public String FAG;
  public String djj;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.FAG != null) {
        paramVarArgs.d(3, this.FAG);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      if (this.AWx != null) {
        paramVarArgs.d(5, this.AWx);
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.FAG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FAG);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = paramInt;
      if (this.AWx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.AWx);
      }
      AppMethodBeat.o(91668);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cnk localcnk = (cnk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91668);
        return -1;
      case 1: 
        localcnk.type = locala.LVo.xF();
        AppMethodBeat.o(91668);
        return 0;
      case 2: 
        localcnk.djj = locala.LVo.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 3: 
        localcnk.FAG = locala.LVo.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 4: 
        localcnk.path = locala.LVo.readString();
        AppMethodBeat.o(91668);
        return 0;
      }
      localcnk.AWx = locala.LVo.readString();
      AppMethodBeat.o(91668);
      return 0;
    }
    AppMethodBeat.o(91668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnk
 * JD-Core Version:    0.7.0.1
 */