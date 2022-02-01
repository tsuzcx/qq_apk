package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aot
  extends dop
{
  public aov LAI;
  public String LAP;
  public boolean enable;
  public long hFK;
  public long liveId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209335);
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
      if (this.LAP != null) {
        paramVarArgs.e(5, this.LAP);
      }
      paramVarArgs.aM(6, this.scene);
      paramVarArgs.cc(7, this.enable);
      AppMethodBeat.o(209335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAI != null) {
        i = paramInt + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.liveId) + g.a.a.b.b.a.r(4, this.hFK);
      paramInt = i;
      if (this.LAP != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LAP);
      }
      i = g.a.a.b.b.a.bu(6, this.scene);
      int j = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(209335);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209335);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aot localaot = (aot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209335);
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
            localaot.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209335);
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
            localaot.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209335);
          return 0;
        case 3: 
          localaot.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209335);
          return 0;
        case 4: 
          localaot.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209335);
          return 0;
        case 5: 
          localaot.LAP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209335);
          return 0;
        case 6: 
          localaot.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209335);
          return 0;
        }
        localaot.enable = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(209335);
        return 0;
      }
      AppMethodBeat.o(209335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aot
 * JD-Core Version:    0.7.0.1
 */