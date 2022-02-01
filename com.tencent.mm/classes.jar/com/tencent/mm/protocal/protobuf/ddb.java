package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddb
  extends com.tencent.mm.bw.a
{
  public String HFD;
  public String LZw;
  public String MIh;
  public int MeU;
  public String yUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LZw != null) {
        paramVarArgs.e(1, this.LZw);
      }
      if (this.MIh != null) {
        paramVarArgs.e(2, this.MIh);
      }
      if (this.HFD != null) {
        paramVarArgs.e(3, this.HFD);
      }
      if (this.yUB != null) {
        paramVarArgs.e(4, this.yUB);
      }
      paramVarArgs.aM(5, this.MeU);
      AppMethodBeat.o(72549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LZw == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.f(1, this.LZw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MIh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MIh);
      }
      i = paramInt;
      if (this.HFD != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HFD);
      }
      paramInt = i;
      if (this.yUB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.yUB);
      }
      i = g.a.a.b.b.a.bu(5, this.MeU);
      AppMethodBeat.o(72549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72549);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ddb localddb = (ddb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72549);
          return -1;
        case 1: 
          localddb.LZw = locala.UbS.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 2: 
          localddb.MIh = locala.UbS.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 3: 
          localddb.HFD = locala.UbS.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 4: 
          localddb.yUB = locala.UbS.readString();
          AppMethodBeat.o(72549);
          return 0;
        }
        localddb.MeU = locala.UbS.zi();
        AppMethodBeat.o(72549);
        return 0;
      }
      AppMethodBeat.o(72549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddb
 * JD-Core Version:    0.7.0.1
 */