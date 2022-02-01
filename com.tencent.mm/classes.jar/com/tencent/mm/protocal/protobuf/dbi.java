package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dbi
  extends cqk
{
  public String FKw;
  public int OpCode;
  public int ncL;
  public LinkedList<dbg> ncM;
  public int xSh;
  
  public dbi()
  {
    AppMethodBeat.i(125819);
    this.ncM = new LinkedList();
    AppMethodBeat.o(125819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125820);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      if (this.FKw != null) {
        paramVarArgs.d(3, this.FKw);
      }
      paramVarArgs.aR(4, this.ncL);
      paramVarArgs.e(5, 8, this.ncM);
      paramVarArgs.aR(6, this.xSh);
      AppMethodBeat.o(125820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.OpCode);
      paramInt = i;
      if (this.FKw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FKw);
      }
      i = f.a.a.b.b.a.bx(4, this.ncL);
      int j = f.a.a.a.c(5, 8, this.ncM);
      int k = f.a.a.b.b.a.bx(6, this.xSh);
      AppMethodBeat.o(125820);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ncM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbi localdbi = (dbi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125820);
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
            localdbi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        case 2: 
          localdbi.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125820);
          return 0;
        case 3: 
          localdbi.FKw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125820);
          return 0;
        case 4: 
          localdbi.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125820);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbi.ncM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        }
        localdbi.xSh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125820);
        return 0;
      }
      AppMethodBeat.o(125820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbi
 * JD-Core Version:    0.7.0.1
 */