package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpr
  extends com.tencent.mm.bx.a
{
  public String IKH;
  public String OzQ;
  public String aaWt;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127501);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IKH != null) {
        paramVarArgs.g(1, this.IKH);
      }
      if (this.aaWt != null) {
        paramVarArgs.g(2, this.aaWt);
      }
      if (this.OzQ != null) {
        paramVarArgs.g(3, this.OzQ);
      }
      paramVarArgs.bS(4, this.vhJ);
      AppMethodBeat.o(127501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IKH == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.IKH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaWt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaWt);
      }
      i = paramInt;
      if (this.OzQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.OzQ);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.vhJ);
      AppMethodBeat.o(127501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127501);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dpr localdpr = (dpr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127501);
          return -1;
        case 1: 
          localdpr.IKH = locala.ajGk.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 2: 
          localdpr.aaWt = locala.ajGk.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 3: 
          localdpr.OzQ = locala.ajGk.readString();
          AppMethodBeat.o(127501);
          return 0;
        }
        localdpr.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(127501);
        return 0;
      }
      AppMethodBeat.o(127501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpr
 * JD-Core Version:    0.7.0.1
 */