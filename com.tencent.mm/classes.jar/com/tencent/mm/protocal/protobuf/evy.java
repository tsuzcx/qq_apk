package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class evy
  extends com.tencent.mm.bw.a
{
  public String KDQ;
  public String NtJ;
  public euy Nty;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147812);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nty == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147812);
        throw paramVarArgs;
      }
      if (this.Nty != null)
      {
        paramVarArgs.ni(1, this.Nty.computeSize());
        this.Nty.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.KDQ != null) {
        paramVarArgs.e(3, this.KDQ);
      }
      if (this.NtJ != null) {
        paramVarArgs.e(4, this.NtJ);
      }
      AppMethodBeat.o(147812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nty == null) {
        break label538;
      }
    }
    label538:
    for (int i = g.a.a.a.nh(1, this.Nty.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.KDQ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KDQ);
      }
      paramInt = i;
      if (this.NtJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NtJ);
      }
      AppMethodBeat.o(147812);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nty == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        evy localevy = (evy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147812);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((euy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localevy.Nty = ((euy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147812);
          return 0;
        case 2: 
          localevy.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147812);
          return 0;
        case 3: 
          localevy.KDQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147812);
          return 0;
        }
        localevy.NtJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(147812);
        return 0;
      }
      AppMethodBeat.o(147812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evy
 * JD-Core Version:    0.7.0.1
 */