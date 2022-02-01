package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgf
  extends com.tencent.mm.bx.a
{
  public String id;
  public String nrG;
  public long timestamp;
  public String vxp;
  public String vxq;
  public int vxr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.vxp != null) {
        paramVarArgs.d(2, this.vxp);
      }
      if (this.vxq != null) {
        paramVarArgs.d(3, this.vxq);
      }
      if (this.nrG != null) {
        paramVarArgs.d(4, this.nrG);
      }
      paramVarArgs.aG(6, this.timestamp);
      paramVarArgs.aR(5, this.vxr);
      AppMethodBeat.o(72499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vxp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vxp);
      }
      i = paramInt;
      if (this.vxq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vxq);
      }
      paramInt = i;
      if (this.nrG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nrG);
      }
      i = f.a.a.b.b.a.q(6, this.timestamp);
      int j = f.a.a.b.b.a.bA(5, this.vxr);
      AppMethodBeat.o(72499);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72499);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgf localbgf = (bgf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72499);
          return -1;
        case 1: 
          localbgf.id = locala.KhF.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 2: 
          localbgf.vxp = locala.KhF.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 3: 
          localbgf.vxq = locala.KhF.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 4: 
          localbgf.nrG = locala.KhF.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 6: 
          localbgf.timestamp = locala.KhF.xT();
          AppMethodBeat.o(72499);
          return 0;
        }
        localbgf.vxr = locala.KhF.xS();
        AppMethodBeat.o(72499);
        return 0;
      }
      AppMethodBeat.o(72499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgf
 * JD-Core Version:    0.7.0.1
 */