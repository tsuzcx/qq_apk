package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddc
  extends com.tencent.mm.bx.a
{
  public long EuU;
  public long Evi;
  public long Evj;
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
      paramVarArgs.aG(2, this.Evi);
      paramVarArgs.aG(3, this.Evj);
      paramVarArgs.aG(4, this.EuU);
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
      int i = f.a.a.b.b.a.q(2, this.Evi);
      int j = f.a.a.b.b.a.q(3, this.Evj);
      int k = f.a.a.b.b.a.q(4, this.EuU);
      AppMethodBeat.o(153014);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153014);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddc localddc = (ddc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153014);
          return -1;
        case 1: 
          localddc.mediaId = locala.KhF.readString();
          AppMethodBeat.o(153014);
          return 0;
        case 2: 
          localddc.Evi = locala.KhF.xT();
          AppMethodBeat.o(153014);
          return 0;
        case 3: 
          localddc.Evj = locala.KhF.xT();
          AppMethodBeat.o(153014);
          return 0;
        }
        localddc.EuU = locala.KhF.xT();
        AppMethodBeat.o(153014);
        return 0;
      }
      AppMethodBeat.o(153014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddc
 * JD-Core Version:    0.7.0.1
 */