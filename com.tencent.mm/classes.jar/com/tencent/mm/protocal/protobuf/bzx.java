package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzx
  extends cvc
{
  public LinkedList<bzz> FCD;
  public int FuW;
  public int GUO;
  public LinkedList<bzw> GUP;
  public int GUQ;
  public String GUR;
  public int Scene;
  
  public bzx()
  {
    AppMethodBeat.i(127498);
    this.GUP = new LinkedList();
    this.FCD = new LinkedList();
    AppMethodBeat.o(127498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FuW);
      paramVarArgs.aS(3, this.GUO);
      paramVarArgs.e(4, 8, this.GUP);
      paramVarArgs.aS(5, this.GUQ);
      paramVarArgs.e(6, 8, this.FCD);
      if (this.GUR != null) {
        paramVarArgs.d(7, this.GUR);
      }
      paramVarArgs.aS(8, this.Scene);
      AppMethodBeat.o(127499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FuW) + f.a.a.b.b.a.bz(3, this.GUO) + f.a.a.a.c(4, 8, this.GUP) + f.a.a.b.b.a.bz(5, this.GUQ) + f.a.a.a.c(6, 8, this.FCD);
      paramInt = i;
      if (this.GUR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GUR);
      }
      i = f.a.a.b.b.a.bz(8, this.Scene);
      AppMethodBeat.o(127499);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GUP.clear();
        this.FCD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzx localbzx = (bzx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127499);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 2: 
          localbzx.FuW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127499);
          return 0;
        case 3: 
          localbzx.GUO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127499);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzx.GUP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 5: 
          localbzx.GUQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127499);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzx.FCD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 7: 
          localbzx.GUR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127499);
          return 0;
        }
        localbzx.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127499);
        return 0;
      }
      AppMethodBeat.o(127499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzx
 * JD-Core Version:    0.7.0.1
 */