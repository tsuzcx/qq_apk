package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bph
  extends dop
{
  public b LXB;
  public b LXC;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104807);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.ReqType);
      if (this.LXB != null) {
        paramVarArgs.c(3, this.LXB);
      }
      if (this.LXC != null) {
        paramVarArgs.c(4, this.LXC);
      }
      AppMethodBeat.o(104807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.ReqType);
      paramInt = i;
      if (this.LXB != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LXB);
      }
      i = paramInt;
      if (this.LXC != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.LXC);
      }
      AppMethodBeat.o(104807);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bph localbph = (bph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104807);
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
            localbph.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104807);
          return 0;
        case 2: 
          localbph.ReqType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104807);
          return 0;
        case 3: 
          localbph.LXB = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(104807);
          return 0;
        }
        localbph.LXC = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(104807);
        return 0;
      }
      AppMethodBeat.o(104807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bph
 * JD-Core Version:    0.7.0.1
 */