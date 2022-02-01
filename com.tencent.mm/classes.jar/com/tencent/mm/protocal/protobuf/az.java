package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class az
  extends com.tencent.mm.bx.a
{
  public String YBP;
  public String YBQ;
  public String YBR;
  public int YBS;
  public String YBT;
  public int wuj;
  public String xmo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260259);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YBP != null) {
        paramVarArgs.g(1, this.YBP);
      }
      if (this.YBQ != null) {
        paramVarArgs.g(2, this.YBQ);
      }
      if (this.YBR != null) {
        paramVarArgs.g(3, this.YBR);
      }
      paramVarArgs.bS(4, this.wuj);
      if (this.xmo != null) {
        paramVarArgs.g(5, this.xmo);
      }
      paramVarArgs.bS(6, this.YBS);
      if (this.YBT != null) {
        paramVarArgs.g(7, this.YBT);
      }
      AppMethodBeat.o(260259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YBP == null) {
        break label542;
      }
    }
    label542:
    for (int i = i.a.a.b.b.a.h(1, this.YBP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YBQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YBQ);
      }
      i = paramInt;
      if (this.YBR != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YBR);
      }
      i += i.a.a.b.b.a.cJ(4, this.wuj);
      paramInt = i;
      if (this.xmo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.xmo);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.YBS);
      paramInt = i;
      if (this.YBT != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YBT);
      }
      AppMethodBeat.o(260259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260259);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260259);
          return -1;
        case 1: 
          localaz.YBP = locala.ajGk.readString();
          AppMethodBeat.o(260259);
          return 0;
        case 2: 
          localaz.YBQ = locala.ajGk.readString();
          AppMethodBeat.o(260259);
          return 0;
        case 3: 
          localaz.YBR = locala.ajGk.readString();
          AppMethodBeat.o(260259);
          return 0;
        case 4: 
          localaz.wuj = locala.ajGk.aar();
          AppMethodBeat.o(260259);
          return 0;
        case 5: 
          localaz.xmo = locala.ajGk.readString();
          AppMethodBeat.o(260259);
          return 0;
        case 6: 
          localaz.YBS = locala.ajGk.aar();
          AppMethodBeat.o(260259);
          return 0;
        }
        localaz.YBT = locala.ajGk.readString();
        AppMethodBeat.o(260259);
        return 0;
      }
      AppMethodBeat.o(260259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.az
 * JD-Core Version:    0.7.0.1
 */