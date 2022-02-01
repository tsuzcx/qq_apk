package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class axm
  extends dop
{
  public aov LAI;
  public b LDx;
  public long LGk;
  public String LGs;
  public int dYx;
  public String fQY;
  public String finderUsername;
  public long hFK;
  public long liveId;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209566);
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
      paramVarArgs.bb(3, this.hFK);
      paramVarArgs.bb(4, this.liveId);
      paramVarArgs.bb(5, this.seq);
      paramVarArgs.aM(6, this.dYx);
      if (this.LDx != null) {
        paramVarArgs.c(7, this.LDx);
      }
      if (this.fQY != null) {
        paramVarArgs.e(8, this.fQY);
      }
      paramVarArgs.bb(9, this.LGk);
      if (this.finderUsername != null) {
        paramVarArgs.e(10, this.finderUsername);
      }
      if (this.LGs != null) {
        paramVarArgs.e(11, this.LGs);
      }
      AppMethodBeat.o(209566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAI != null) {
        i = paramInt + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.hFK) + g.a.a.b.b.a.r(4, this.liveId) + g.a.a.b.b.a.r(5, this.seq) + g.a.a.b.b.a.bu(6, this.dYx);
      paramInt = i;
      if (this.LDx != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.LDx);
      }
      i = paramInt;
      if (this.fQY != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.fQY);
      }
      i += g.a.a.b.b.a.r(9, this.LGk);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.finderUsername);
      }
      i = paramInt;
      if (this.LGs != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LGs);
      }
      AppMethodBeat.o(209566);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        axm localaxm = (axm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209566);
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
            localaxm.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209566);
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
            localaxm.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209566);
          return 0;
        case 3: 
          localaxm.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209566);
          return 0;
        case 4: 
          localaxm.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209566);
          return 0;
        case 5: 
          localaxm.seq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209566);
          return 0;
        case 6: 
          localaxm.dYx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209566);
          return 0;
        case 7: 
          localaxm.LDx = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209566);
          return 0;
        case 8: 
          localaxm.fQY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209566);
          return 0;
        case 9: 
          localaxm.LGk = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209566);
          return 0;
        case 10: 
          localaxm.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209566);
          return 0;
        }
        localaxm.LGs = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209566);
        return 0;
      }
      AppMethodBeat.o(209566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axm
 * JD-Core Version:    0.7.0.1
 */