package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnv
  extends com.tencent.mm.bx.a
{
  public String GIo;
  public String GIp;
  public String GIq;
  public String GIr;
  public String GIs;
  public String GIt;
  public String GIu;
  public String hkP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GIo != null) {
        paramVarArgs.d(1, this.GIo);
      }
      if (this.GIp != null) {
        paramVarArgs.d(2, this.GIp);
      }
      if (this.hkP != null) {
        paramVarArgs.d(3, this.hkP);
      }
      if (this.GIq != null) {
        paramVarArgs.d(4, this.GIq);
      }
      if (this.GIr != null) {
        paramVarArgs.d(5, this.GIr);
      }
      if (this.GIs != null) {
        paramVarArgs.d(6, this.GIs);
      }
      if (this.GIt != null) {
        paramVarArgs.d(7, this.GIt);
      }
      if (this.GIu != null) {
        paramVarArgs.d(8, this.GIu);
      }
      AppMethodBeat.o(91521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GIo == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.GIo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GIp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GIp);
      }
      i = paramInt;
      if (this.hkP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkP);
      }
      paramInt = i;
      if (this.GIq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GIq);
      }
      i = paramInt;
      if (this.GIr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GIr);
      }
      paramInt = i;
      if (this.GIs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GIs);
      }
      i = paramInt;
      if (this.GIt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GIt);
      }
      paramInt = i;
      if (this.GIu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GIu);
      }
      AppMethodBeat.o(91521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnv localbnv = (bnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91521);
          return -1;
        case 1: 
          localbnv.GIo = locala.NPN.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 2: 
          localbnv.GIp = locala.NPN.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 3: 
          localbnv.hkP = locala.NPN.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 4: 
          localbnv.GIq = locala.NPN.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 5: 
          localbnv.GIr = locala.NPN.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 6: 
          localbnv.GIs = locala.NPN.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 7: 
          localbnv.GIt = locala.NPN.readString();
          AppMethodBeat.o(91521);
          return 0;
        }
        localbnv.GIu = locala.NPN.readString();
        AppMethodBeat.o(91521);
        return 0;
      }
      AppMethodBeat.o(91521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnv
 * JD-Core Version:    0.7.0.1
 */