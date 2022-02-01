package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpx
  extends ckq
{
  public int DOp;
  public int Ejh;
  public LinkedList<doy> Eji;
  public int Ejj;
  
  public cpx()
  {
    AppMethodBeat.i(32431);
    this.Eji = new LinkedList();
    AppMethodBeat.o(32431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DOp);
      paramVarArgs.aR(3, this.Ejh);
      paramVarArgs.e(4, 8, this.Eji);
      paramVarArgs.aR(5, this.Ejj);
      AppMethodBeat.o(32432);
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
      int i = f.a.a.b.b.a.bA(2, this.DOp);
      int j = f.a.a.b.b.a.bA(3, this.Ejh);
      int k = f.a.a.a.c(4, 8, this.Eji);
      int m = f.a.a.b.b.a.bA(5, this.Ejj);
      AppMethodBeat.o(32432);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eji.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpx localcpx = (cpx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32432);
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
            localcpx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32432);
          return 0;
        case 2: 
          localcpx.DOp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32432);
          return 0;
        case 3: 
          localcpx.Ejh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32432);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((doy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpx.Eji.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32432);
          return 0;
        }
        localcpx.Ejj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32432);
        return 0;
      }
      AppMethodBeat.o(32432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpx
 * JD-Core Version:    0.7.0.1
 */