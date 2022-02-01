package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apr
  extends com.tencent.mm.bw.a
{
  public String GGT;
  public long GGU;
  public LinkedList<String> GGV;
  
  public apr()
  {
    AppMethodBeat.i(189372);
    this.GGV = new LinkedList();
    AppMethodBeat.o(189372);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189373);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GGT != null) {
        paramVarArgs.d(1, this.GGT);
      }
      paramVarArgs.aZ(2, this.GGU);
      paramVarArgs.e(3, 1, this.GGV);
      AppMethodBeat.o(189373);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GGT == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.GGT) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.GGU);
      int j = f.a.a.a.c(3, 1, this.GGV);
      AppMethodBeat.o(189373);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GGV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189373);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apr localapr = (apr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(189373);
          return -1;
        case 1: 
          localapr.GGT = locala.OmT.readString();
          AppMethodBeat.o(189373);
          return 0;
        case 2: 
          localapr.GGU = locala.OmT.zd();
          AppMethodBeat.o(189373);
          return 0;
        }
        localapr.GGV.add(locala.OmT.readString());
        AppMethodBeat.o(189373);
        return 0;
      }
      AppMethodBeat.o(189373);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apr
 * JD-Core Version:    0.7.0.1
 */