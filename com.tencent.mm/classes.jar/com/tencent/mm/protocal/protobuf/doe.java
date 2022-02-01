package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doe
  extends com.tencent.mm.bx.a
{
  public long HCB;
  public long HCP;
  public long HCQ;
  public String mediaId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153014);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mediaId != null) {
        paramVarArgs.d(1, this.mediaId);
      }
      paramVarArgs.aY(2, this.HCP);
      paramVarArgs.aY(3, this.HCQ);
      paramVarArgs.aY(4, this.HCB);
      AppMethodBeat.o(153014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mediaId == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.mediaId) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HCP);
      int j = f.a.a.b.b.a.p(3, this.HCQ);
      int k = f.a.a.b.b.a.p(4, this.HCB);
      AppMethodBeat.o(153014);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153014);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doe localdoe = (doe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153014);
          return -1;
        case 1: 
          localdoe.mediaId = locala.NPN.readString();
          AppMethodBeat.o(153014);
          return 0;
        case 2: 
          localdoe.HCP = locala.NPN.zd();
          AppMethodBeat.o(153014);
          return 0;
        case 3: 
          localdoe.HCQ = locala.NPN.zd();
          AppMethodBeat.o(153014);
          return 0;
        }
        localdoe.HCB = locala.NPN.zd();
        AppMethodBeat.o(153014);
        return 0;
      }
      AppMethodBeat.o(153014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doe
 * JD-Core Version:    0.7.0.1
 */