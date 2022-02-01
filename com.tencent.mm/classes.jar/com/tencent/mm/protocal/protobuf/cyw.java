package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cyw
  extends dop
{
  public String MDU;
  public cyy MDV;
  public int MDW;
  public b MDX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223889);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MDU != null) {
        paramVarArgs.e(2, this.MDU);
      }
      if (this.MDV != null)
      {
        paramVarArgs.ni(3, this.MDV.computeSize());
        this.MDV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.MDW);
      if (this.MDX != null) {
        paramVarArgs.c(5, this.MDX);
      }
      AppMethodBeat.o(223889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MDU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MDU);
      }
      i = paramInt;
      if (this.MDV != null) {
        i = paramInt + g.a.a.a.nh(3, this.MDV.computeSize());
      }
      i += g.a.a.b.b.a.bu(4, this.MDW);
      paramInt = i;
      if (this.MDX != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.MDX);
      }
      AppMethodBeat.o(223889);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(223889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyw localcyw = (cyw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(223889);
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
            localcyw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(223889);
          return 0;
        case 2: 
          localcyw.MDU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223889);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcyw.MDV = ((cyy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(223889);
          return 0;
        case 4: 
          localcyw.MDW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(223889);
          return 0;
        }
        localcyw.MDX = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(223889);
        return 0;
      }
      AppMethodBeat.o(223889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyw
 * JD-Core Version:    0.7.0.1
 */