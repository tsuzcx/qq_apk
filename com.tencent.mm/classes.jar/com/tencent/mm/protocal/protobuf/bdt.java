package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class bdt
  extends com.tencent.mm.bx.a
{
  public String ZOj;
  public int ZOk;
  public b ZOn;
  public String ZOx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258984);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOx != null) {
        paramVarArgs.g(1, this.ZOx);
      }
      if (this.ZOn != null) {
        paramVarArgs.d(51, this.ZOn);
      }
      if (this.ZOj != null) {
        paramVarArgs.g(101, this.ZOj);
      }
      paramVarArgs.bS(102, this.ZOk);
      AppMethodBeat.o(258984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOx == null) {
        break label394;
      }
    }
    label394:
    for (int i = i.a.a.b.b.a.h(1, this.ZOx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZOn != null) {
        paramInt = i + i.a.a.b.b.a.c(51, this.ZOn);
      }
      i = paramInt;
      if (this.ZOj != null) {
        i = paramInt + i.a.a.b.b.a.h(101, this.ZOj);
      }
      paramInt = i.a.a.b.b.a.cJ(102, this.ZOk);
      AppMethodBeat.o(258984);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258984);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bdt localbdt = (bdt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258984);
          return -1;
        case 1: 
          localbdt.ZOx = locala.ajGk.readString();
          AppMethodBeat.o(258984);
          return 0;
        case 51: 
          localbdt.ZOn = locala.ajGk.kFX();
          AppMethodBeat.o(258984);
          return 0;
        case 101: 
          localbdt.ZOj = locala.ajGk.readString();
          AppMethodBeat.o(258984);
          return 0;
        }
        localbdt.ZOk = locala.ajGk.aar();
        AppMethodBeat.o(258984);
        return 0;
      }
      AppMethodBeat.o(258984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdt
 * JD-Core Version:    0.7.0.1
 */