package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csm
  extends com.tencent.mm.bx.a
{
  public String CtT;
  public String CtU;
  public int CtV;
  public String CzS;
  public String dyc;
  public String dyd;
  public String nrr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114073);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc != null) {
        paramVarArgs.d(1, this.dyc);
      }
      if (this.nrr != null) {
        paramVarArgs.d(2, this.nrr);
      }
      if (this.dyd != null) {
        paramVarArgs.d(3, this.dyd);
      }
      if (this.CtT != null) {
        paramVarArgs.d(4, this.CtT);
      }
      if (this.CtU != null) {
        paramVarArgs.d(5, this.CtU);
      }
      paramVarArgs.aR(6, this.CtV);
      if (this.CzS != null) {
        paramVarArgs.d(7, this.CzS);
      }
      AppMethodBeat.o(114073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyc == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.dyc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nrr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nrr);
      }
      i = paramInt;
      if (this.dyd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dyd);
      }
      paramInt = i;
      if (this.CtT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CtT);
      }
      i = paramInt;
      if (this.CtU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CtU);
      }
      i += f.a.a.b.b.a.bA(6, this.CtV);
      paramInt = i;
      if (this.CzS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CzS);
      }
      AppMethodBeat.o(114073);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114073);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csm localcsm = (csm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114073);
          return -1;
        case 1: 
          localcsm.dyc = locala.KhF.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 2: 
          localcsm.nrr = locala.KhF.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 3: 
          localcsm.dyd = locala.KhF.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 4: 
          localcsm.CtT = locala.KhF.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 5: 
          localcsm.CtU = locala.KhF.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 6: 
          localcsm.CtV = locala.KhF.xS();
          AppMethodBeat.o(114073);
          return 0;
        }
        localcsm.CzS = locala.KhF.readString();
        AppMethodBeat.o(114073);
        return 0;
      }
      AppMethodBeat.o(114073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csm
 * JD-Core Version:    0.7.0.1
 */