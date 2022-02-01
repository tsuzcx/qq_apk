package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bby
  extends ckq
{
  public LinkedList<cmf> Cxc;
  public int DsF;
  public int Scene;
  public String fVC;
  
  public bby()
  {
    AppMethodBeat.i(32274);
    this.Cxc = new LinkedList();
    AppMethodBeat.o(32274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32275);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fVC != null) {
        paramVarArgs.d(2, this.fVC);
      }
      paramVarArgs.aR(3, this.DsF);
      paramVarArgs.e(4, 8, this.Cxc);
      paramVarArgs.aR(5, this.Scene);
      AppMethodBeat.o(32275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fVC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fVC);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DsF);
      int j = f.a.a.a.c(4, 8, this.Cxc);
      int k = f.a.a.b.b.a.bA(5, this.Scene);
      AppMethodBeat.o(32275);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32275);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bby localbby = (bby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32275);
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
            localbby.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        case 2: 
          localbby.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32275);
          return 0;
        case 3: 
          localbby.DsF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32275);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbby.Cxc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        }
        localbby.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32275);
        return 0;
      }
      AppMethodBeat.o(32275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bby
 * JD-Core Version:    0.7.0.1
 */