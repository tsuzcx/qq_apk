package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avo
  extends dop
{
  public aov LAI;
  public long LGk;
  public int LGl;
  public String LGm;
  public awg LGn;
  public int LGo;
  public long hFK;
  public String hwg;
  public long liveId;
  public int opType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209508);
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
      paramVarArgs.bb(4, this.hFK);
      paramVarArgs.bb(5, this.LGk);
      paramVarArgs.aM(6, this.LGl);
      if (this.LGm != null) {
        paramVarArgs.e(7, this.LGm);
      }
      if (this.LGn != null)
      {
        paramVarArgs.ni(8, this.LGn.computeSize());
        this.LGn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.LGo);
      paramVarArgs.aM(10, this.opType);
      if (this.hwg != null) {
        paramVarArgs.e(11, this.hwg);
      }
      AppMethodBeat.o(209508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1006;
      }
    }
    label1006:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAI != null) {
        i = paramInt + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.liveId) + g.a.a.b.b.a.r(4, this.hFK) + g.a.a.b.b.a.r(5, this.LGk) + g.a.a.b.b.a.bu(6, this.LGl);
      paramInt = i;
      if (this.LGm != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LGm);
      }
      i = paramInt;
      if (this.LGn != null) {
        i = paramInt + g.a.a.a.nh(8, this.LGn.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(9, this.LGo) + g.a.a.b.b.a.bu(10, this.opType);
      paramInt = i;
      if (this.hwg != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.hwg);
      }
      AppMethodBeat.o(209508);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avo localavo = (avo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209508);
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
            localavo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209508);
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
            localavo.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209508);
          return 0;
        case 3: 
          localavo.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209508);
          return 0;
        case 4: 
          localavo.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209508);
          return 0;
        case 5: 
          localavo.LGk = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209508);
          return 0;
        case 6: 
          localavo.LGl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209508);
          return 0;
        case 7: 
          localavo.LGm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209508);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavo.LGn = ((awg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209508);
          return 0;
        case 9: 
          localavo.LGo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209508);
          return 0;
        case 10: 
          localavo.opType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209508);
          return 0;
        }
        localavo.hwg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209508);
        return 0;
      }
      AppMethodBeat.o(209508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avo
 * JD-Core Version:    0.7.0.1
 */