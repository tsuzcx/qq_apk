package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azp
  extends cwj
{
  public String GPI;
  public int GPJ;
  public cxa GPK;
  public String GPL;
  public cwy GPM;
  public long eRA;
  public int fMQ;
  public String fMR;
  public int fMS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101808);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GPI != null) {
        paramVarArgs.d(2, this.GPI);
      }
      paramVarArgs.aS(3, this.fMQ);
      if (this.fMR != null) {
        paramVarArgs.d(4, this.fMR);
      }
      paramVarArgs.aS(5, this.fMS);
      paramVarArgs.aS(6, this.GPJ);
      paramVarArgs.aZ(7, this.eRA);
      if (this.GPK != null)
      {
        paramVarArgs.lJ(8, this.GPK.computeSize());
        this.GPK.writeFields(paramVarArgs);
      }
      if (this.GPL != null) {
        paramVarArgs.d(9, this.GPL);
      }
      if (this.GPM != null)
      {
        paramVarArgs.lJ(10, this.GPM.computeSize());
        this.GPM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GPI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GPI);
      }
      i += f.a.a.b.b.a.bz(3, this.fMQ);
      paramInt = i;
      if (this.fMR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fMR);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.fMS) + f.a.a.b.b.a.bz(6, this.GPJ) + f.a.a.b.b.a.p(7, this.eRA);
      paramInt = i;
      if (this.GPK != null) {
        paramInt = i + f.a.a.a.lI(8, this.GPK.computeSize());
      }
      i = paramInt;
      if (this.GPL != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GPL);
      }
      paramInt = i;
      if (this.GPM != null) {
        paramInt = i + f.a.a.a.lI(10, this.GPM.computeSize());
      }
      AppMethodBeat.o(101808);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azp localazp = (azp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101808);
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
            localazp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 2: 
          localazp.GPI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 3: 
          localazp.fMQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101808);
          return 0;
        case 4: 
          localazp.fMR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 5: 
          localazp.fMS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101808);
          return 0;
        case 6: 
          localazp.GPJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101808);
          return 0;
        case 7: 
          localazp.eRA = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(101808);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazp.GPK = ((cxa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 9: 
          localazp.GPL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101808);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazp.GPM = ((cwy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      AppMethodBeat.o(101808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azp
 * JD-Core Version:    0.7.0.1
 */