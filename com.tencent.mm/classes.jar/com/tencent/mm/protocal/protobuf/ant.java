package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ant
  extends cqk
{
  public int continueFlag;
  public String dlj;
  public int offset;
  public LinkedList<FinderObject> qJK;
  public b rmJ;
  public LinkedList<anr> uEi;
  
  public ant()
  {
    AppMethodBeat.i(169049);
    this.uEi = new LinkedList();
    this.qJK = new LinkedList();
    AppMethodBeat.o(169049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169050);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.uEi);
      paramVarArgs.aR(3, this.offset);
      paramVarArgs.aR(4, this.continueFlag);
      paramVarArgs.e(5, 8, this.qJK);
      if (this.rmJ != null) {
        paramVarArgs.c(6, this.rmJ);
      }
      if (this.dlj != null) {
        paramVarArgs.d(7, this.dlj);
      }
      AppMethodBeat.o(169050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.uEi) + f.a.a.b.b.a.bx(3, this.offset) + f.a.a.b.b.a.bx(4, this.continueFlag) + f.a.a.a.c(5, 8, this.qJK);
      paramInt = i;
      if (this.rmJ != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.rmJ);
      }
      i = paramInt;
      if (this.dlj != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dlj);
      }
      AppMethodBeat.o(169050);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uEi.clear();
        this.qJK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ant localant = (ant)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169050);
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
            localant.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localant.uEi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 3: 
          localant.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169050);
          return 0;
        case 4: 
          localant.continueFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169050);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localant.qJK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 6: 
          localant.rmJ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(169050);
          return 0;
        }
        localant.dlj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169050);
        return 0;
      }
      AppMethodBeat.o(169050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ant
 * JD-Core Version:    0.7.0.1
 */