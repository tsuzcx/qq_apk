package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends cqk
{
  public int dae = 268513600;
  public int iAs;
  public int iAt;
  public int iAu;
  public long iAv;
  public long iAw;
  public String iAx;
  public String iAy;
  public String oxf = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91325);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91325);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      paramVarArgs.aR(4, this.iAs);
      paramVarArgs.aR(5, this.iAt);
      paramVarArgs.aR(6, this.iAu);
      paramVarArgs.aO(7, this.iAv);
      paramVarArgs.aO(8, this.iAw);
      if (this.iAx != null) {
        paramVarArgs.d(9, this.iAx);
      }
      if (this.iAy != null) {
        paramVarArgs.d(10, this.iAy);
      }
      AppMethodBeat.o(91325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.iAs) + f.a.a.b.b.a.bx(5, this.iAt) + f.a.a.b.b.a.bx(6, this.iAu) + f.a.a.b.b.a.p(7, this.iAv) + f.a.a.b.b.a.p(8, this.iAw);
      paramInt = i;
      if (this.iAx != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iAx);
      }
      i = paramInt;
      if (this.iAy != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iAy);
      }
      AppMethodBeat.o(91325);
      return i;
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
          AppMethodBeat.o(91325);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91325);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91325);
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
            localn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91325);
          return 0;
        case 2: 
          localn.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91325);
          return 0;
        case 3: 
          localn.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 4: 
          localn.iAs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91325);
          return 0;
        case 5: 
          localn.iAt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91325);
          return 0;
        case 6: 
          localn.iAu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91325);
          return 0;
        case 7: 
          localn.iAv = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91325);
          return 0;
        case 8: 
          localn.iAw = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91325);
          return 0;
        case 9: 
          localn.iAx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91325);
          return 0;
        }
        localn.iAy = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91325);
        return 0;
      }
      AppMethodBeat.o(91325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.n
 * JD-Core Version:    0.7.0.1
 */