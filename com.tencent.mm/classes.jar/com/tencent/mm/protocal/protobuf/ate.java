package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ate
  extends cqk
{
  public LinkedList<String> Bor;
  public String EMj;
  public int dae;
  public String oxf;
  
  public ate()
  {
    AppMethodBeat.i(91484);
    this.Bor = new LinkedList();
    AppMethodBeat.o(91484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Bor);
      paramVarArgs.aR(3, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(4, this.oxf);
      }
      if (this.EMj != null) {
        paramVarArgs.d(5, this.EMj);
      }
      AppMethodBeat.o(91485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.Bor) + f.a.a.b.b.a.bx(3, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oxf);
      }
      i = paramInt;
      if (this.EMj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EMj);
      }
      AppMethodBeat.o(91485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Bor.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ate localate = (ate)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91485);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localate.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91485);
          return 0;
        case 2: 
          localate.Bor.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91485);
          return 0;
        case 3: 
          localate.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91485);
          return 0;
        case 4: 
          localate.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91485);
          return 0;
        }
        localate.EMj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91485);
        return 0;
      }
      AppMethodBeat.o(91485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ate
 * JD-Core Version:    0.7.0.1
 */