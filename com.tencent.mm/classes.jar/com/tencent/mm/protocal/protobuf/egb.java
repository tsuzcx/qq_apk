package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egb
  extends cwj
{
  public String GWB;
  public int GeT;
  public int IjN;
  public csf IjO;
  public csd IjP;
  public int IjQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.IjN);
      paramVarArgs.aS(3, this.GeT);
      if (this.GWB != null) {
        paramVarArgs.d(4, this.GWB);
      }
      if (this.IjO != null)
      {
        paramVarArgs.lJ(5, this.IjO.computeSize());
        this.IjO.writeFields(paramVarArgs);
      }
      if (this.IjP != null)
      {
        paramVarArgs.lJ(6, this.IjP.computeSize());
        this.IjP.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.IjQ);
      AppMethodBeat.o(117949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.IjN) + f.a.a.b.b.a.bz(3, this.GeT);
      paramInt = i;
      if (this.GWB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GWB);
      }
      i = paramInt;
      if (this.IjO != null) {
        i = paramInt + f.a.a.a.lI(5, this.IjO.computeSize());
      }
      paramInt = i;
      if (this.IjP != null) {
        paramInt = i + f.a.a.a.lI(6, this.IjP.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.IjQ);
      AppMethodBeat.o(117949);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        egb localegb = (egb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117949);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localegb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 2: 
          localegb.IjN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117949);
          return 0;
        case 3: 
          localegb.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117949);
          return 0;
        case 4: 
          localegb.GWB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117949);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localegb.IjO = ((csf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localegb.IjP = ((csd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        }
        localegb.IjQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117949);
        return 0;
      }
      AppMethodBeat.o(117949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egb
 * JD-Core Version:    0.7.0.1
 */