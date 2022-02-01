package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baw
  extends com.tencent.mm.bw.a
{
  public cvv GQP;
  public bwg GQQ;
  public int GQR;
  public boolean GQS;
  public boolean GQT;
  public int GQU;
  public int Gdm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GQP != null)
      {
        paramVarArgs.lJ(1, this.GQP.computeSize());
        this.GQP.writeFields(paramVarArgs);
      }
      if (this.GQQ != null)
      {
        paramVarArgs.lJ(2, this.GQQ.computeSize());
        this.GQQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GQR);
      paramVarArgs.aS(4, this.Gdm);
      paramVarArgs.bC(5, this.GQS);
      paramVarArgs.bC(6, this.GQT);
      paramVarArgs.aS(7, this.GQU);
      AppMethodBeat.o(175244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GQP == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lI(1, this.GQP.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GQQ != null) {
        i = paramInt + f.a.a.a.lI(2, this.GQQ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GQR);
      int j = f.a.a.b.b.a.bz(4, this.Gdm);
      int k = f.a.a.b.b.a.amF(5);
      int m = f.a.a.b.b.a.amF(6);
      int n = f.a.a.b.b.a.bz(7, this.GQU);
      AppMethodBeat.o(175244);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(175244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baw localbaw = (baw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175244);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaw.GQP = ((cvv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaw.GQQ = ((bwg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 3: 
          localbaw.GQR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(175244);
          return 0;
        case 4: 
          localbaw.Gdm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(175244);
          return 0;
        case 5: 
          localbaw.GQS = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(175244);
          return 0;
        case 6: 
          localbaw.GQT = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(175244);
          return 0;
        }
        localbaw.GQU = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(175244);
        return 0;
      }
      AppMethodBeat.o(175244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baw
 * JD-Core Version:    0.7.0.1
 */