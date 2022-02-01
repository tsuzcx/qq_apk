package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vf
  extends cqk
{
  public String Epm;
  public String Epn;
  public int Epu;
  public long Epv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32162);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32162);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Epu);
      if (this.Epm != null) {
        paramVarArgs.d(3, this.Epm);
      }
      if (this.Epn != null) {
        paramVarArgs.d(4, this.Epn);
      }
      paramVarArgs.aO(5, this.Epv);
      AppMethodBeat.o(32162);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label581;
      }
    }
    label581:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Epu);
      paramInt = i;
      if (this.Epm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Epm);
      }
      i = paramInt;
      if (this.Epn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Epn);
      }
      paramInt = f.a.a.b.b.a.p(5, this.Epv);
      AppMethodBeat.o(32162);
      return i + paramInt;
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
          AppMethodBeat.o(32162);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32162);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vf localvf = (vf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32162);
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
            localvf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32162);
          return 0;
        case 2: 
          localvf.Epu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32162);
          return 0;
        case 3: 
          localvf.Epm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32162);
          return 0;
        case 4: 
          localvf.Epn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32162);
          return 0;
        }
        localvf.Epv = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32162);
        return 0;
      }
      AppMethodBeat.o(32162);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vf
 * JD-Core Version:    0.7.0.1
 */