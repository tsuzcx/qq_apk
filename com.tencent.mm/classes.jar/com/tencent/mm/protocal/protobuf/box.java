package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class box
  extends com.tencent.mm.bw.a
{
  public String id;
  public String oED;
  public long timestamp;
  public String ykU;
  public String ykV;
  public int ykW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.ykU != null) {
        paramVarArgs.d(2, this.ykU);
      }
      if (this.ykV != null) {
        paramVarArgs.d(3, this.ykV);
      }
      if (this.oED != null) {
        paramVarArgs.d(4, this.oED);
      }
      paramVarArgs.aZ(6, this.timestamp);
      paramVarArgs.aS(5, this.ykW);
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
      if (this.ykU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ykU);
      }
      i = paramInt;
      if (this.ykV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ykV);
      }
      paramInt = i;
      if (this.oED != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oED);
      }
      i = f.a.a.b.b.a.p(6, this.timestamp);
      int j = f.a.a.b.b.a.bz(5, this.ykW);
      AppMethodBeat.o(72499);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72499);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        box localbox = (box)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72499);
          return -1;
        case 1: 
          localbox.id = locala.OmT.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 2: 
          localbox.ykU = locala.OmT.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 3: 
          localbox.ykV = locala.OmT.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 4: 
          localbox.oED = locala.OmT.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 6: 
          localbox.timestamp = locala.OmT.zd();
          AppMethodBeat.o(72499);
          return 0;
        }
        localbox.ykW = locala.OmT.zc();
        AppMethodBeat.o(72499);
        return 0;
      }
      AppMethodBeat.o(72499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.box
 * JD-Core Version:    0.7.0.1
 */