package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nm
  extends com.tencent.mm.bw.a
{
  public int FQb;
  public String FQc;
  public int FYW;
  public int FYX;
  public int FZM;
  public int FZN;
  public int FZO;
  public aan FZP;
  public int FZQ;
  public int FZR;
  public int FZS = 0;
  public int FZT;
  public String content;
  public String hCp;
  public String pqp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FZM);
      paramVarArgs.aS(2, this.FQb);
      if (this.FQc != null) {
        paramVarArgs.d(3, this.FQc);
      }
      if (this.pqp != null) {
        paramVarArgs.d(4, this.pqp);
      }
      if (this.hCp != null) {
        paramVarArgs.d(5, this.hCp);
      }
      if (this.content != null) {
        paramVarArgs.d(6, this.content);
      }
      paramVarArgs.aS(7, this.FZN);
      paramVarArgs.aS(8, this.FZO);
      paramVarArgs.aS(9, this.FYW);
      paramVarArgs.aS(10, this.FYX);
      if (this.FZP != null)
      {
        paramVarArgs.lJ(11, this.FZP.computeSize());
        this.FZP.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.FZQ);
      paramVarArgs.aS(13, this.FZR);
      paramVarArgs.aS(14, this.FZS);
      paramVarArgs.aS(15, this.FZT);
      AppMethodBeat.o(103203);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FZM) + 0 + f.a.a.b.b.a.bz(2, this.FQb);
      paramInt = i;
      if (this.FQc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FQc);
      }
      i = paramInt;
      if (this.pqp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pqp);
      }
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hCp);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.content);
      }
      i = i + f.a.a.b.b.a.bz(7, this.FZN) + f.a.a.b.b.a.bz(8, this.FZO) + f.a.a.b.b.a.bz(9, this.FYW) + f.a.a.b.b.a.bz(10, this.FYX);
      paramInt = i;
      if (this.FZP != null) {
        paramInt = i + f.a.a.a.lI(11, this.FZP.computeSize());
      }
      i = f.a.a.b.b.a.bz(12, this.FZQ);
      int j = f.a.a.b.b.a.bz(13, this.FZR);
      int k = f.a.a.b.b.a.bz(14, this.FZS);
      int m = f.a.a.b.b.a.bz(15, this.FZT);
      AppMethodBeat.o(103203);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(103203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      nm localnm = (nm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103203);
        return -1;
      case 1: 
        localnm.FZM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 2: 
        localnm.FQb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 3: 
        localnm.FQc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 4: 
        localnm.pqp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 5: 
        localnm.hCp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 6: 
        localnm.content = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 7: 
        localnm.FZN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 8: 
        localnm.FZO = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 9: 
        localnm.FYW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 10: 
        localnm.FYX = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aan();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aan)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnm.FZP = ((aan)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(103203);
        return 0;
      case 12: 
        localnm.FZQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 13: 
        localnm.FZR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 14: 
        localnm.FZS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103203);
        return 0;
      }
      localnm.FZT = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(103203);
      return 0;
    }
    AppMethodBeat.o(103203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nm
 * JD-Core Version:    0.7.0.1
 */