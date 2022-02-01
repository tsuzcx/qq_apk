package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ebp
  extends com.tencent.mm.bw.a
{
  public b EuB;
  public String djj;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.EuB != null) {
        paramVarArgs.c(2, this.EuB);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.EuB != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.EuB);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      AppMethodBeat.o(50124);
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
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ebp localebp = (ebp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50124);
        return -1;
      case 1: 
        localebp.type = locala.LVo.xF();
        AppMethodBeat.o(50124);
        return 0;
      case 2: 
        localebp.EuB = locala.LVo.gfk();
        AppMethodBeat.o(50124);
        return 0;
      }
      localebp.djj = locala.LVo.readString();
      AppMethodBeat.o(50124);
      return 0;
    }
    AppMethodBeat.o(50124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebp
 * JD-Core Version:    0.7.0.1
 */