package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azo
  extends ckq
{
  public int DxX;
  public int DxY;
  public ru DxZ;
  public wq Dya;
  public int Dyb;
  public long bTj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50089);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DxX);
      paramVarArgs.aR(3, this.DxY);
      if (this.DxZ != null)
      {
        paramVarArgs.kX(4, this.DxZ.computeSize());
        this.DxZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(5, this.bTj);
      if (this.Dya != null)
      {
        paramVarArgs.kX(6, this.Dya.computeSize());
        this.Dya.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Dyb);
      AppMethodBeat.o(50089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DxX) + f.a.a.b.b.a.bA(3, this.DxY);
      paramInt = i;
      if (this.DxZ != null) {
        paramInt = i + f.a.a.a.kW(4, this.DxZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.bTj);
      paramInt = i;
      if (this.Dya != null) {
        paramInt = i + f.a.a.a.kW(6, this.Dya.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.Dyb);
      AppMethodBeat.o(50089);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azo localazo = (azo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50089);
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
            localazo.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 2: 
          localazo.DxX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(50089);
          return 0;
        case 3: 
          localazo.DxY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(50089);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazo.DxZ = ((ru)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 5: 
          localazo.bTj = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(50089);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazo.Dya = ((wq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        }
        localazo.Dyb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(50089);
        return 0;
      }
      AppMethodBeat.o(50089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azo
 * JD-Core Version:    0.7.0.1
 */