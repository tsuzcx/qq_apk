package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alj
  extends cqk
{
  public aop EFc;
  public int EFd;
  public cfx EFe;
  public int continueFlag;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> object;
  public long rfD;
  public cnx rmj;
  
  public alj()
  {
    AppMethodBeat.i(168991);
    this.object = new LinkedList();
    AppMethodBeat.o(168991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168992);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168992);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aR(4, this.continueFlag);
      paramVarArgs.aO(5, this.rfD);
      if (this.EFc != null)
      {
        paramVarArgs.ln(6, this.EFc.computeSize());
        this.EFc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.EFd);
      if (this.rmj != null)
      {
        paramVarArgs.ln(8, this.rmj.computeSize());
        this.rmj.writeFields(paramVarArgs);
      }
      if (this.EFe != null)
      {
        paramVarArgs.ln(9, this.EFe.computeSize());
        this.EFe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1158;
      }
    }
    label1158:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.continueFlag) + f.a.a.b.b.a.p(5, this.rfD);
      paramInt = i;
      if (this.EFc != null) {
        paramInt = i + f.a.a.a.lm(6, this.EFc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.EFd);
      paramInt = i;
      if (this.rmj != null) {
        paramInt = i + f.a.a.a.lm(8, this.rmj.computeSize());
      }
      i = paramInt;
      if (this.EFe != null) {
        i = paramInt + f.a.a.a.lm(9, this.EFe.computeSize());
      }
      AppMethodBeat.o(168992);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alj localalj = (alj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168992);
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
            localalj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 3: 
          localalj.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168992);
          return 0;
        case 4: 
          localalj.continueFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168992);
          return 0;
        case 5: 
          localalj.rfD = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168992);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aop();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aop)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.EFc = ((aop)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 7: 
          localalj.EFd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168992);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.rmj = ((cnx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalj.EFe = ((cfx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      AppMethodBeat.o(168992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alj
 * JD-Core Version:    0.7.0.1
 */