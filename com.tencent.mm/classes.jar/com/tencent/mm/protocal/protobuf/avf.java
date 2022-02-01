package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avf
  extends cqk
{
  public int ENp;
  public int ENq;
  public int ENr;
  public int ENs;
  public String ENt;
  public int ENu;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101813);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101813);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndj);
      paramVarArgs.aR(3, this.ENp);
      paramVarArgs.aR(4, this.ENq);
      paramVarArgs.aR(5, this.ENr);
      paramVarArgs.aR(6, this.ENs);
      if (this.ENt != null) {
        paramVarArgs.d(7, this.ENt);
      }
      paramVarArgs.aR(8, this.ENu);
      AppMethodBeat.o(101813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndj) + f.a.a.b.b.a.bx(3, this.ENp) + f.a.a.b.b.a.bx(4, this.ENq) + f.a.a.b.b.a.bx(5, this.ENr) + f.a.a.b.b.a.bx(6, this.ENs);
      paramInt = i;
      if (this.ENt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ENt);
      }
      i = f.a.a.b.b.a.bx(8, this.ENu);
      AppMethodBeat.o(101813);
      return paramInt + i;
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
          AppMethodBeat.o(101813);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101813);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avf localavf = (avf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101813);
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
            localavf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101813);
          return 0;
        case 2: 
          localavf.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101813);
          return 0;
        case 3: 
          localavf.ENp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101813);
          return 0;
        case 4: 
          localavf.ENq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101813);
          return 0;
        case 5: 
          localavf.ENr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101813);
          return 0;
        case 6: 
          localavf.ENs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101813);
          return 0;
        case 7: 
          localavf.ENt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101813);
          return 0;
        }
        localavf.ENu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(101813);
        return 0;
      }
      AppMethodBeat.o(101813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avf
 * JD-Core Version:    0.7.0.1
 */