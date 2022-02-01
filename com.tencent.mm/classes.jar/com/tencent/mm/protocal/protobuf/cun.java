package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cun
  extends dop
{
  public String Id;
  public bf Lcc;
  public int MzP;
  public String kdF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91556);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MzP);
      if (this.Id != null) {
        paramVarArgs.e(3, this.Id);
      }
      if (this.kdF != null) {
        paramVarArgs.e(4, this.kdF);
      }
      if (this.Lcc != null)
      {
        paramVarArgs.ni(5, this.Lcc.computeSize());
        this.Lcc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MzP);
      paramInt = i;
      if (this.Id != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Id);
      }
      i = paramInt;
      if (this.kdF != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.kdF);
      }
      paramInt = i;
      if (this.Lcc != null) {
        paramInt = i + g.a.a.a.nh(5, this.Lcc.computeSize());
      }
      AppMethodBeat.o(91556);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cun localcun = (cun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91556);
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
            localcun.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91556);
          return 0;
        case 2: 
          localcun.MzP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91556);
          return 0;
        case 3: 
          localcun.Id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91556);
          return 0;
        case 4: 
          localcun.kdF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91556);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcun.Lcc = ((bf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      AppMethodBeat.o(91556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cun
 * JD-Core Version:    0.7.0.1
 */