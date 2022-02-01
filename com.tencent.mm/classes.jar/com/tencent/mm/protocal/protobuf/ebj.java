package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebj
  extends com.tencent.mm.bx.a
{
  public String DDP;
  public long KHU;
  public long KHV;
  public String KHW;
  public LinkedList<Long> LAi;
  public int aFj;
  public int dvJ;
  public String pZX;
  public String sessionId;
  public long xBr;
  
  public ebj()
  {
    AppMethodBeat.i(205459);
    this.aFj = 0;
    this.xBr = 0L;
    this.KHU = 0L;
    this.KHV = 0L;
    this.dvJ = 0;
    this.LAi = new LinkedList();
    AppMethodBeat.o(205459);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.DDP != null) {
        paramVarArgs.d(2, this.DDP);
      }
      paramVarArgs.aR(3, this.aFj);
      paramVarArgs.aG(4, this.xBr);
      paramVarArgs.aG(5, this.KHU);
      paramVarArgs.aG(6, this.KHV);
      if (this.KHW != null) {
        paramVarArgs.d(7, this.KHW);
      }
      if (this.pZX != null) {
        paramVarArgs.d(8, this.pZX);
      }
      paramVarArgs.aR(9, this.dvJ);
      paramVarArgs.e(10, 3, this.LAi);
      AppMethodBeat.o(205460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label681;
      }
    }
    label681:
    for (paramInt = f.a.a.b.b.a.e(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DDP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DDP);
      }
      i = i + f.a.a.b.b.a.bA(3, this.aFj) + f.a.a.b.b.a.q(4, this.xBr) + f.a.a.b.b.a.q(5, this.KHU) + f.a.a.b.b.a.q(6, this.KHV);
      paramInt = i;
      if (this.KHW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.KHW);
      }
      i = paramInt;
      if (this.pZX != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.pZX);
      }
      paramInt = f.a.a.b.b.a.bA(9, this.dvJ);
      int j = f.a.a.a.c(10, 3, this.LAi);
      AppMethodBeat.o(205460);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LAi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(205460);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebj localebj = (ebj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205460);
          return -1;
        case 1: 
          localebj.sessionId = locala.KhF.readString();
          AppMethodBeat.o(205460);
          return 0;
        case 2: 
          localebj.DDP = locala.KhF.readString();
          AppMethodBeat.o(205460);
          return 0;
        case 3: 
          localebj.aFj = locala.KhF.xS();
          AppMethodBeat.o(205460);
          return 0;
        case 4: 
          localebj.xBr = locala.KhF.xT();
          AppMethodBeat.o(205460);
          return 0;
        case 5: 
          localebj.KHU = locala.KhF.xT();
          AppMethodBeat.o(205460);
          return 0;
        case 6: 
          localebj.KHV = locala.KhF.xT();
          AppMethodBeat.o(205460);
          return 0;
        case 7: 
          localebj.KHW = locala.KhF.readString();
          AppMethodBeat.o(205460);
          return 0;
        case 8: 
          localebj.pZX = locala.KhF.readString();
          AppMethodBeat.o(205460);
          return 0;
        case 9: 
          localebj.dvJ = locala.KhF.xS();
          AppMethodBeat.o(205460);
          return 0;
        }
        localebj.LAi.add(Long.valueOf(locala.KhF.xT()));
        AppMethodBeat.o(205460);
        return 0;
      }
      AppMethodBeat.o(205460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebj
 * JD-Core Version:    0.7.0.1
 */