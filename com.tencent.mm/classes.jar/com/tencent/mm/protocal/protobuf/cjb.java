package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjb
  extends ckq
{
  public int CGZ;
  public LinkedList<mu> Eer;
  public int Ees;
  public int Eet;
  
  public cjb()
  {
    AppMethodBeat.i(6424);
    this.Eer = new LinkedList();
    AppMethodBeat.o(6424);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Eer);
      paramVarArgs.aR(3, this.Ees);
      paramVarArgs.aR(4, this.Eet);
      paramVarArgs.aR(5, this.CGZ);
      AppMethodBeat.o(6425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label601;
      }
    }
    label601:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Eer);
      int j = f.a.a.b.b.a.bA(3, this.Ees);
      int k = f.a.a.b.b.a.bA(4, this.Eet);
      int m = f.a.a.b.b.a.bA(5, this.CGZ);
      AppMethodBeat.o(6425);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eer.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjb localcjb = (cjb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6425);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjb.Eer.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 3: 
          localcjb.Ees = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6425);
          return 0;
        case 4: 
          localcjb.Eet = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6425);
          return 0;
        }
        localcjb.CGZ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(6425);
        return 0;
      }
      AppMethodBeat.o(6425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjb
 * JD-Core Version:    0.7.0.1
 */