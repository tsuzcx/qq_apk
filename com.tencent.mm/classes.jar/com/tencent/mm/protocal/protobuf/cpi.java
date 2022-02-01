package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpi
  extends cpx
{
  public xc ETw;
  public LinkedList<afa> FBU;
  public int FBV;
  public int FBW;
  public LinkedList<wy> FBX;
  public int FBY;
  public long bQR;
  
  public cpi()
  {
    AppMethodBeat.i(50105);
    this.FBU = new LinkedList();
    this.FBX = new LinkedList();
    AppMethodBeat.o(50105);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.bQR);
      paramVarArgs.e(3, 8, this.FBU);
      paramVarArgs.aR(5, this.FBV);
      paramVarArgs.aR(6, this.FBW);
      if (this.ETw != null)
      {
        paramVarArgs.ln(7, this.ETw.computeSize());
        this.ETw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.FBX);
      paramVarArgs.aR(9, this.FBY);
      AppMethodBeat.o(50106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.bQR) + f.a.a.a.c(3, 8, this.FBU) + f.a.a.b.b.a.bx(5, this.FBV) + f.a.a.b.b.a.bx(6, this.FBW);
      paramInt = i;
      if (this.ETw != null) {
        paramInt = i + f.a.a.a.lm(7, this.ETw.computeSize());
      }
      i = f.a.a.a.c(8, 8, this.FBX);
      int j = f.a.a.b.b.a.bx(9, this.FBY);
      AppMethodBeat.o(50106);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FBU.clear();
        this.FBX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpi localcpi = (cpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(50106);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 2: 
          localcpi.bQR = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(50106);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpi.FBU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 5: 
          localcpi.FBV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(50106);
          return 0;
        case 6: 
          localcpi.FBW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(50106);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpi.ETw = ((xc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpi.FBX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        }
        localcpi.FBY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(50106);
        return 0;
      }
      AppMethodBeat.o(50106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpi
 * JD-Core Version:    0.7.0.1
 */