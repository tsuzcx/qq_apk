package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ceg
  extends cqk
{
  public cej FsR;
  public cdv FsS;
  public LinkedList<cdu> FsT;
  public int FsU;
  public int pAG;
  public String pAH;
  
  public ceg()
  {
    AppMethodBeat.i(91591);
    this.FsT = new LinkedList();
    AppMethodBeat.o(91591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(3, this.pAH);
      }
      if (this.FsR != null)
      {
        paramVarArgs.ln(4, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      if (this.FsS != null)
      {
        paramVarArgs.ln(5, this.FsS.computeSize());
        this.FsS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.FsT);
      paramVarArgs.aR(7, this.FsU);
      AppMethodBeat.o(91592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pAH);
      }
      i = paramInt;
      if (this.FsR != null) {
        i = paramInt + f.a.a.a.lm(4, this.FsR.computeSize());
      }
      paramInt = i;
      if (this.FsS != null) {
        paramInt = i + f.a.a.a.lm(5, this.FsS.computeSize());
      }
      i = f.a.a.a.c(6, 8, this.FsT);
      int j = f.a.a.b.b.a.bx(7, this.FsU);
      AppMethodBeat.o(91592);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FsT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ceg localceg = (ceg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91592);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 2: 
          localceg.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91592);
          return 0;
        case 3: 
          localceg.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91592);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cej();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceg.FsR = ((cej)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceg.FsS = ((cdv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceg.FsT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        }
        localceg.FsU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91592);
        return 0;
      }
      AppMethodBeat.o(91592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceg
 * JD-Core Version:    0.7.0.1
 */