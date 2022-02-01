package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bzm
  extends dop
{
  public int Mfg;
  public String eaO;
  public String pPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114041);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.pPz == null)
      {
        paramVarArgs = new b("Not all required fields were included: to_username");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.eaO != null) {
        paramVarArgs.e(2, this.eaO);
      }
      if (this.pPz != null) {
        paramVarArgs.e(3, this.pPz);
      }
      paramVarArgs.aM(4, this.Mfg);
      AppMethodBeat.o(114041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.eaO != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.eaO);
      }
      i = paramInt;
      if (this.pPz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pPz);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Mfg);
      AppMethodBeat.o(114041);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.eaO == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        if (this.pPz == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bzm localbzm = (bzm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114041);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbzm.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114041);
          return 0;
        case 2: 
          localbzm.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114041);
          return 0;
        case 3: 
          localbzm.pPz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114041);
          return 0;
        }
        localbzm.Mfg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114041);
        return 0;
      }
      AppMethodBeat.o(114041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzm
 * JD-Core Version:    0.7.0.1
 */