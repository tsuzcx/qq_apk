package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dzp
  extends dop
{
  public dzj MYE;
  public dqi MYF;
  public String izX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125780);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MYE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125780);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MYE != null)
      {
        paramVarArgs.ni(2, this.MYE.computeSize());
        this.MYE.writeFields(paramVarArgs);
      }
      if (this.izX != null) {
        paramVarArgs.e(3, this.izX);
      }
      if (this.MYF != null)
      {
        paramVarArgs.ni(4, this.MYF.computeSize());
        this.MYF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MYE != null) {
        paramInt = i + g.a.a.a.nh(2, this.MYE.computeSize());
      }
      i = paramInt;
      if (this.izX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.izX);
      }
      paramInt = i;
      if (this.MYF != null) {
        paramInt = i + g.a.a.a.nh(4, this.MYF.computeSize());
      }
      AppMethodBeat.o(125780);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MYE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Action");
          AppMethodBeat.o(125780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzp localdzp = (dzp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125780);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzp.MYE = ((dzj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 3: 
          localdzp.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125780);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdzp.MYF = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      AppMethodBeat.o(125780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzp
 * JD-Core Version:    0.7.0.1
 */