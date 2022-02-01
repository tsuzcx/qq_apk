package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class akv
  extends cpx
{
  public aiu EDL;
  public String EEI;
  public long EEK;
  public b lastBuffer;
  public String qYd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.EEK);
      if (this.EEI != null) {
        paramVarArgs.d(3, this.EEI);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(5, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      if (this.qYd != null) {
        paramVarArgs.d(6, this.qYd);
      }
      AppMethodBeat.o(168985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.EEK);
      paramInt = i;
      if (this.EEI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EEI);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(5, this.EDL.computeSize());
      }
      i = paramInt;
      if (this.qYd != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.qYd);
      }
      AppMethodBeat.o(168985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akv localakv = (akv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168985);
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
            localakv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 2: 
          localakv.EEK = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168985);
          return 0;
        case 3: 
          localakv.EEI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 4: 
          localakv.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168985);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakv.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        }
        localakv.qYd = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(168985);
        return 0;
      }
      AppMethodBeat.o(168985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akv
 * JD-Core Version:    0.7.0.1
 */