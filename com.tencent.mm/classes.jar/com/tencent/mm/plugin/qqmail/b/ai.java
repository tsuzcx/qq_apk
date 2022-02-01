package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqk;
import f.a.a.b;
import java.util.LinkedList;

public final class ai
  extends cqk
{
  public String hkN;
  public int vTH;
  public int vTI;
  public String vTP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTI);
      if (this.vTP != null) {
        paramVarArgs.d(3, this.vTP);
      }
      paramVarArgs.aR(4, this.vTH);
      if (this.hkN != null) {
        paramVarArgs.d(5, this.hkN);
      }
      AppMethodBeat.o(122800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTI);
      paramInt = i;
      if (this.vTP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vTP);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.vTH);
      paramInt = i;
      if (this.hkN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hkN);
      }
      AppMethodBeat.o(122800);
      return paramInt;
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
          AppMethodBeat.o(122800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122800);
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
            localai.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122800);
          return 0;
        case 2: 
          localai.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122800);
          return 0;
        case 3: 
          localai.vTP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122800);
          return 0;
        case 4: 
          localai.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122800);
          return 0;
        }
        localai.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122800);
        return 0;
      }
      AppMethodBeat.o(122800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ai
 * JD-Core Version:    0.7.0.1
 */