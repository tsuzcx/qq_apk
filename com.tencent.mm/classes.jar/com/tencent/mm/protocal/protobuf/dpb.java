package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpb
  extends com.tencent.mm.bw.a
{
  public long HWC;
  public long HWD;
  public long HWo;
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
      paramVarArgs.aZ(2, this.HWC);
      paramVarArgs.aZ(3, this.HWD);
      paramVarArgs.aZ(4, this.HWo);
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
      int i = f.a.a.b.b.a.p(2, this.HWC);
      int j = f.a.a.b.b.a.p(3, this.HWD);
      int k = f.a.a.b.b.a.p(4, this.HWo);
      AppMethodBeat.o(153014);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153014);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpb localdpb = (dpb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153014);
          return -1;
        case 1: 
          localdpb.mediaId = locala.OmT.readString();
          AppMethodBeat.o(153014);
          return 0;
        case 2: 
          localdpb.HWC = locala.OmT.zd();
          AppMethodBeat.o(153014);
          return 0;
        case 3: 
          localdpb.HWD = locala.OmT.zd();
          AppMethodBeat.o(153014);
          return 0;
        }
        localdpb.HWo = locala.OmT.zd();
        AppMethodBeat.o(153014);
        return 0;
      }
      AppMethodBeat.o(153014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpb
 * JD-Core Version:    0.7.0.1
 */