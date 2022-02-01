package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bcd
  extends dop
{
  public aov LAI;
  public b LGq;
  public String finderUsername;
  public long hFK;
  public long liveId;
  public int liveStatus;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209671);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(3, this.liveId);
      if (this.LGq != null) {
        paramVarArgs.c(4, this.LGq);
      }
      paramVarArgs.bb(5, this.hFK);
      if (this.finderUsername != null) {
        paramVarArgs.e(6, this.finderUsername);
      }
      paramVarArgs.aM(7, this.liveStatus);
      AppMethodBeat.o(209671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAI != null) {
        i = paramInt + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i += g.a.a.b.b.a.r(3, this.liveId);
      paramInt = i;
      if (this.LGq != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LGq);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.hFK);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.finderUsername);
      }
      i = g.a.a.b.b.a.bu(7, this.liveStatus);
      AppMethodBeat.o(209671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcd localbcd = (bcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209671);
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
            localbcd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209671);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcd.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209671);
          return 0;
        case 3: 
          localbcd.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209671);
          return 0;
        case 4: 
          localbcd.LGq = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209671);
          return 0;
        case 5: 
          localbcd.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209671);
          return 0;
        case 6: 
          localbcd.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209671);
          return 0;
        }
        localbcd.liveStatus = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209671);
        return 0;
      }
      AppMethodBeat.o(209671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcd
 * JD-Core Version:    0.7.0.1
 */