package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cec
  extends cqk
{
  public int FsG;
  public int pAG;
  public String pAH;
  public String thh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91586);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91586);
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
      if (this.thh != null) {
        paramVarArgs.d(4, this.thh);
      }
      paramVarArgs.aR(5, this.FsG);
      AppMethodBeat.o(91586);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pAH);
      }
      i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.thh);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.FsG);
      AppMethodBeat.o(91586);
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
          AppMethodBeat.o(91586);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cec localcec = (cec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91586);
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
            localcec.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91586);
          return 0;
        case 2: 
          localcec.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91586);
          return 0;
        case 3: 
          localcec.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91586);
          return 0;
        case 4: 
          localcec.thh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91586);
          return 0;
        }
        localcec.FsG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91586);
        return 0;
      }
      AppMethodBeat.o(91586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cec
 * JD-Core Version:    0.7.0.1
 */