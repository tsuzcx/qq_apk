package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bet
  extends cqk
{
  public String EUl;
  public String EUm;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32270);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32270);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndI);
      if (this.EUm != null) {
        paramVarArgs.d(3, this.EUm);
      }
      if (this.EUl != null) {
        paramVarArgs.d(4, this.EUl);
      }
      AppMethodBeat.o(32270);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI);
      paramInt = i;
      if (this.EUm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EUm);
      }
      i = paramInt;
      if (this.EUl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EUl);
      }
      AppMethodBeat.o(32270);
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
          AppMethodBeat.o(32270);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32270);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bet localbet = (bet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32270);
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
            localbet.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32270);
          return 0;
        case 2: 
          localbet.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32270);
          return 0;
        case 3: 
          localbet.EUm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32270);
          return 0;
        }
        localbet.EUl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32270);
        return 0;
      }
      AppMethodBeat.o(32270);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bet
 * JD-Core Version:    0.7.0.1
 */