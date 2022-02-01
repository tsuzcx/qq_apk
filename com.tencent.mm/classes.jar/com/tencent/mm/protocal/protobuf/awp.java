package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awp
  extends cqk
{
  public int EOA;
  public int EOy;
  public String EOz;
  public int ncL;
  public LinkedList<aed> ncM;
  
  public awp()
  {
    AppMethodBeat.i(104792);
    this.ncM = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ncL);
      paramVarArgs.e(3, 8, this.ncM);
      paramVarArgs.aR(4, this.EOy);
      if (this.EOz != null) {
        paramVarArgs.d(5, this.EOz);
      }
      paramVarArgs.aR(6, this.EOA);
      AppMethodBeat.o(104793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ncL) + f.a.a.a.c(3, 8, this.ncM) + f.a.a.b.b.a.bx(4, this.EOy);
      paramInt = i;
      if (this.EOz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EOz);
      }
      i = f.a.a.b.b.a.bx(6, this.EOA);
      AppMethodBeat.o(104793);
      return paramInt + i;
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
          AppMethodBeat.o(104793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awp localawp = (awp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104793);
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
            localawp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 2: 
          localawp.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104793);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aed();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aed)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawp.ncM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 4: 
          localawp.EOy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104793);
          return 0;
        case 5: 
          localawp.EOz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104793);
          return 0;
        }
        localawp.EOA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104793);
        return 0;
      }
      AppMethodBeat.o(104793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awp
 * JD-Core Version:    0.7.0.1
 */