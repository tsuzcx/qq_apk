package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxt
  extends com.tencent.mm.bx.a
{
  public String DDP = "";
  public boolean DUj = false;
  public String DUk;
  public boolean DUl;
  public String DUm = "";
  public String DnR = "";
  public int doZ = -1;
  public String dpw = "";
  public long endTime = 0L;
  public long seq = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dpw != null) {
        paramVarArgs.d(1, this.dpw);
      }
      paramVarArgs.bg(2, this.DUj);
      paramVarArgs.aG(3, this.seq);
      paramVarArgs.aG(4, this.startTime);
      paramVarArgs.aG(5, this.endTime);
      paramVarArgs.aR(6, this.doZ);
      if (this.DDP != null) {
        paramVarArgs.d(7, this.DDP);
      }
      if (this.DnR != null) {
        paramVarArgs.d(8, this.DnR);
      }
      if (this.DUk != null) {
        paramVarArgs.d(9, this.DUk);
      }
      paramVarArgs.bg(10, this.DUl);
      if (this.DUm != null) {
        paramVarArgs.d(11, this.DUm);
      }
      AppMethodBeat.o(122521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dpw == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = f.a.a.b.b.a.e(1, this.dpw) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 1) + f.a.a.b.b.a.q(3, this.seq) + f.a.a.b.b.a.q(4, this.startTime) + f.a.a.b.b.a.q(5, this.endTime) + f.a.a.b.b.a.bA(6, this.doZ);
      paramInt = i;
      if (this.DDP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DDP);
      }
      i = paramInt;
      if (this.DnR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DnR);
      }
      paramInt = i;
      if (this.DUk != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DUk);
      }
      i = paramInt + (f.a.a.b.b.a.fY(10) + 1);
      paramInt = i;
      if (this.DUm != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DUm);
      }
      AppMethodBeat.o(122521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxt localbxt = (bxt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122521);
          return -1;
        case 1: 
          localbxt.dpw = locala.KhF.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 2: 
          localbxt.DUj = locala.KhF.fHu();
          AppMethodBeat.o(122521);
          return 0;
        case 3: 
          localbxt.seq = locala.KhF.xT();
          AppMethodBeat.o(122521);
          return 0;
        case 4: 
          localbxt.startTime = locala.KhF.xT();
          AppMethodBeat.o(122521);
          return 0;
        case 5: 
          localbxt.endTime = locala.KhF.xT();
          AppMethodBeat.o(122521);
          return 0;
        case 6: 
          localbxt.doZ = locala.KhF.xS();
          AppMethodBeat.o(122521);
          return 0;
        case 7: 
          localbxt.DDP = locala.KhF.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 8: 
          localbxt.DnR = locala.KhF.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 9: 
          localbxt.DUk = locala.KhF.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 10: 
          localbxt.DUl = locala.KhF.fHu();
          AppMethodBeat.o(122521);
          return 0;
        }
        localbxt.DUm = locala.KhF.readString();
        AppMethodBeat.o(122521);
        return 0;
      }
      AppMethodBeat.o(122521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxt
 * JD-Core Version:    0.7.0.1
 */