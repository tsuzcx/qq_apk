package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beb
  extends ckq
{
  public int DBG;
  public int DBH;
  public int DBI;
  public int bvJ;
  public int condition;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123598);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.bvJ);
      paramVarArgs.aR(3, this.condition);
      paramVarArgs.aR(4, this.DBG);
      paramVarArgs.aR(5, this.DBH);
      paramVarArgs.aR(6, this.DBI);
      AppMethodBeat.o(123598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.bvJ);
      int j = f.a.a.b.b.a.bA(3, this.condition);
      int k = f.a.a.b.b.a.bA(4, this.DBG);
      int m = f.a.a.b.b.a.bA(5, this.DBH);
      int n = f.a.a.b.b.a.bA(6, this.DBI);
      AppMethodBeat.o(123598);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        beb localbeb = (beb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123598);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123598);
          return 0;
        case 2: 
          localbeb.bvJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123598);
          return 0;
        case 3: 
          localbeb.condition = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123598);
          return 0;
        case 4: 
          localbeb.DBG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123598);
          return 0;
        case 5: 
          localbeb.DBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123598);
          return 0;
        }
        localbeb.DBI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123598);
        return 0;
      }
      AppMethodBeat.o(123598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beb
 * JD-Core Version:    0.7.0.1
 */