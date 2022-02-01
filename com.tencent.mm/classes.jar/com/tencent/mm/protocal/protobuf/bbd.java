package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbd
  extends cwj
{
  public int GRc;
  public String GRd;
  public int GRe;
  public int nID;
  public LinkedList<agw> nIE;
  
  public bbd()
  {
    AppMethodBeat.i(104792);
    this.nIE = new LinkedList();
    AppMethodBeat.o(104792);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104793);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104793);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nID);
      paramVarArgs.e(3, 8, this.nIE);
      paramVarArgs.aS(4, this.GRc);
      if (this.GRd != null) {
        paramVarArgs.d(5, this.GRd);
      }
      paramVarArgs.aS(6, this.GRe);
      AppMethodBeat.o(104793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nID) + f.a.a.a.c(3, 8, this.nIE) + f.a.a.b.b.a.bz(4, this.GRc);
      paramInt = i;
      if (this.GRd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GRd);
      }
      i = f.a.a.b.b.a.bz(6, this.GRe);
      AppMethodBeat.o(104793);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nIE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbd localbbd = (bbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104793);
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
            localbbd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 2: 
          localbbd.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104793);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbd.nIE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 4: 
          localbbd.GRc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104793);
          return 0;
        case 5: 
          localbbd.GRd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104793);
          return 0;
        }
        localbbd.GRe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104793);
        return 0;
      }
      AppMethodBeat.o(104793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbd
 * JD-Core Version:    0.7.0.1
 */