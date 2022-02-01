package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awb
  extends com.tencent.mm.bw.a
{
  public int GNQ;
  public LinkedList<ahq> GNR;
  public int GNS;
  public int dEu;
  
  public awb()
  {
    AppMethodBeat.i(153145);
    this.GNR = new LinkedList();
    AppMethodBeat.o(153145);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GNQ);
      paramVarArgs.e(2, 8, this.GNR);
      paramVarArgs.aS(3, this.GNS);
      paramVarArgs.aS(4, this.dEu);
      AppMethodBeat.o(153146);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GNQ);
      i = f.a.a.a.c(2, 8, this.GNR);
      int j = f.a.a.b.b.a.bz(3, this.GNS);
      int k = f.a.a.b.b.a.bz(4, this.dEu);
      AppMethodBeat.o(153146);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GNR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153146);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      awb localawb = (awb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153146);
        return -1;
      case 1: 
        localawb.GNQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153146);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawb.GNR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153146);
        return 0;
      case 3: 
        localawb.GNS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153146);
        return 0;
      }
      localawb.dEu = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(153146);
      return 0;
    }
    AppMethodBeat.o(153146);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awb
 * JD-Core Version:    0.7.0.1
 */