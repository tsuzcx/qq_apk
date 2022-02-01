package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acf
  extends ckq
{
  public int DcM;
  public int DcN;
  public int uKQ;
  public int uKR;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127170);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uKX);
      paramVarArgs.aR(3, this.uKQ);
      paramVarArgs.aR(4, this.uKR);
      paramVarArgs.aR(5, this.DcM);
      paramVarArgs.aR(6, this.DcN);
      paramVarArgs.aG(7, this.uKZ);
      AppMethodBeat.o(127170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.uKX);
      int j = f.a.a.b.b.a.bA(3, this.uKQ);
      int k = f.a.a.b.b.a.bA(4, this.uKR);
      int m = f.a.a.b.b.a.bA(5, this.DcM);
      int n = f.a.a.b.b.a.bA(6, this.DcN);
      int i1 = f.a.a.b.b.a.q(7, this.uKZ);
      AppMethodBeat.o(127170);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127170);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acf localacf = (acf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127170);
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
            localacf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127170);
          return 0;
        case 2: 
          localacf.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127170);
          return 0;
        case 3: 
          localacf.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127170);
          return 0;
        case 4: 
          localacf.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127170);
          return 0;
        case 5: 
          localacf.DcM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127170);
          return 0;
        case 6: 
          localacf.DcN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127170);
          return 0;
        }
        localacf.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(127170);
        return 0;
      }
      AppMethodBeat.o(127170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acf
 * JD-Core Version:    0.7.0.1
 */