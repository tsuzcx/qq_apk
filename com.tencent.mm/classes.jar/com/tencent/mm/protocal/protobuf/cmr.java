package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmr
  extends cwj
{
  public int FUL;
  public String FUM;
  public int GSP;
  public String Ghx;
  public LinkedList<ahu> HyE;
  public LinkedList<az> HyF;
  public int HyG;
  
  public cmr()
  {
    AppMethodBeat.i(91628);
    this.HyE = new LinkedList();
    this.HyF = new LinkedList();
    AppMethodBeat.o(91628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91629);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GSP);
      paramVarArgs.e(3, 8, this.HyE);
      if (this.Ghx != null) {
        paramVarArgs.d(4, this.Ghx);
      }
      paramVarArgs.aS(5, this.FUL);
      if (this.FUM != null) {
        paramVarArgs.d(6, this.FUM);
      }
      paramVarArgs.e(7, 8, this.HyF);
      paramVarArgs.aS(8, this.HyG);
      AppMethodBeat.o(91629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GSP) + f.a.a.a.c(3, 8, this.HyE);
      paramInt = i;
      if (this.Ghx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ghx);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FUL);
      paramInt = i;
      if (this.FUM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FUM);
      }
      i = f.a.a.a.c(7, 8, this.HyF);
      int j = f.a.a.b.b.a.bz(8, this.HyG);
      AppMethodBeat.o(91629);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HyE.clear();
        this.HyF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmr localcmr = (cmr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91629);
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
            localcmr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 2: 
          localcmr.GSP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91629);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmr.HyE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 4: 
          localcmr.Ghx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 5: 
          localcmr.FUL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91629);
          return 0;
        case 6: 
          localcmr.FUM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmr.HyF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        }
        localcmr.HyG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91629);
        return 0;
      }
      AppMethodBeat.o(91629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmr
 * JD-Core Version:    0.7.0.1
 */