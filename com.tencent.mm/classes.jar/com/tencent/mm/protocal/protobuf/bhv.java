package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhv
  extends cpx
{
  public String EXh;
  public int EXi;
  public String dvO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114041);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.EXh == null)
      {
        paramVarArgs = new b("Not all required fields were included: to_username");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dvO != null) {
        paramVarArgs.d(2, this.dvO);
      }
      if (this.EXh != null) {
        paramVarArgs.d(3, this.EXh);
      }
      paramVarArgs.aR(4, this.EXi);
      AppMethodBeat.o(114041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dvO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dvO);
      }
      i = paramInt;
      if (this.EXh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EXh);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EXi);
      AppMethodBeat.o(114041);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.dvO == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        if (this.EXh == null)
        {
          paramVarArgs = new b("Not all required fields were included: to_username");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhv localbhv = (bhv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114041);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114041);
          return 0;
        case 2: 
          localbhv.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114041);
          return 0;
        case 3: 
          localbhv.EXh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114041);
          return 0;
        }
        localbhv.EXi = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(114041);
        return 0;
      }
      AppMethodBeat.o(114041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhv
 * JD-Core Version:    0.7.0.1
 */