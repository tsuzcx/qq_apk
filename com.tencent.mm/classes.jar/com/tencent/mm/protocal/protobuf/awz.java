package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awz
  extends cqk
{
  public String EOI;
  public int EOS;
  public String bIO;
  public int gbd;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(108146);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ret);
      if (this.bIO != null) {
        paramVarArgs.d(3, this.bIO);
      }
      if (this.EOI != null) {
        paramVarArgs.d(4, this.EOI);
      }
      paramVarArgs.aR(5, this.EOS);
      paramVarArgs.aR(6, this.gbd);
      AppMethodBeat.o(108146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ret);
      paramInt = i;
      if (this.bIO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.bIO);
      }
      i = paramInt;
      if (this.EOI != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EOI);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.EOS);
      int j = f.a.a.b.b.a.bx(6, this.gbd);
      AppMethodBeat.o(108146);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(108146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(108146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awz localawz = (awz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(108146);
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
            localawz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108146);
          return 0;
        case 2: 
          localawz.ret = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(108146);
          return 0;
        case 3: 
          localawz.bIO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108146);
          return 0;
        case 4: 
          localawz.EOI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108146);
          return 0;
        case 5: 
          localawz.EOS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(108146);
          return 0;
        }
        localawz.gbd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(108146);
        return 0;
      }
      AppMethodBeat.o(108146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awz
 * JD-Core Version:    0.7.0.1
 */