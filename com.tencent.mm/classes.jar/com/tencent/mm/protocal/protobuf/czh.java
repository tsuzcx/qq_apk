package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class czh
  extends com.tencent.mm.bw.a
{
  public String MEA;
  public int MEB;
  public int MEC;
  public long createTime;
  public String dRL;
  public String iBd;
  public long oNJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225979);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dRL != null) {
        paramVarArgs.e(1, this.dRL);
      }
      if (this.MEA != null) {
        paramVarArgs.e(2, this.MEA);
      }
      if (this.iBd != null) {
        paramVarArgs.e(3, this.iBd);
      }
      paramVarArgs.bb(4, this.createTime);
      paramVarArgs.aM(5, this.MEB);
      paramVarArgs.bb(6, this.oNJ);
      paramVarArgs.aM(7, this.MEC);
      AppMethodBeat.o(225979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dRL == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.b.b.a.f(1, this.dRL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MEA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MEA);
      }
      i = paramInt;
      if (this.iBd != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iBd);
      }
      paramInt = g.a.a.b.b.a.r(4, this.createTime);
      int j = g.a.a.b.b.a.bu(5, this.MEB);
      int k = g.a.a.b.b.a.r(6, this.oNJ);
      int m = g.a.a.b.b.a.bu(7, this.MEC);
      AppMethodBeat.o(225979);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(225979);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        czh localczh = (czh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(225979);
          return -1;
        case 1: 
          localczh.dRL = locala.UbS.readString();
          AppMethodBeat.o(225979);
          return 0;
        case 2: 
          localczh.MEA = locala.UbS.readString();
          AppMethodBeat.o(225979);
          return 0;
        case 3: 
          localczh.iBd = locala.UbS.readString();
          AppMethodBeat.o(225979);
          return 0;
        case 4: 
          localczh.createTime = locala.UbS.zl();
          AppMethodBeat.o(225979);
          return 0;
        case 5: 
          localczh.MEB = locala.UbS.zi();
          AppMethodBeat.o(225979);
          return 0;
        case 6: 
          localczh.oNJ = locala.UbS.zl();
          AppMethodBeat.o(225979);
          return 0;
        }
        localczh.MEC = locala.UbS.zi();
        AppMethodBeat.o(225979);
        return 0;
      }
      AppMethodBeat.o(225979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czh
 * JD-Core Version:    0.7.0.1
 */