package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aff
  extends dop
{
  public String KGO;
  public LinkedList<afp> KGQ;
  public int Scene;
  public int gsq;
  
  public aff()
  {
    AppMethodBeat.i(101801);
    this.KGQ = new LinkedList();
    AppMethodBeat.o(101801);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101802);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.gsq);
      paramVarArgs.e(3, 8, this.KGQ);
      if (this.KGO != null) {
        paramVarArgs.e(4, this.KGO);
      }
      paramVarArgs.aM(5, this.Scene);
      AppMethodBeat.o(101802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.gsq) + g.a.a.a.c(3, 8, this.KGQ);
      paramInt = i;
      if (this.KGO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KGO);
      }
      i = g.a.a.b.b.a.bu(5, this.Scene);
      AppMethodBeat.o(101802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(101802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aff localaff = (aff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101802);
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
            localaff.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 2: 
          localaff.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101802);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaff.KGQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 4: 
          localaff.KGO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101802);
          return 0;
        }
        localaff.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(101802);
        return 0;
      }
      AppMethodBeat.o(101802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aff
 * JD-Core Version:    0.7.0.1
 */