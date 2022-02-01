package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bao
  extends dop
{
  public aov LAI;
  public b LDx;
  public String fQY;
  public long hFK;
  public long liveId;
  public awq uke;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209637);
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
      if (this.LDx != null) {
        paramVarArgs.c(3, this.LDx);
      }
      if (this.uke != null)
      {
        paramVarArgs.ni(4, this.uke.computeSize());
        this.uke.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(5, this.liveId);
      if (this.fQY != null) {
        paramVarArgs.e(6, this.fQY);
      }
      paramVarArgs.bb(7, this.hFK);
      AppMethodBeat.o(209637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAI != null) {
        paramInt = i + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = paramInt;
      if (this.LDx != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LDx);
      }
      paramInt = i;
      if (this.uke != null) {
        paramInt = i + g.a.a.a.nh(4, this.uke.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.liveId);
      paramInt = i;
      if (this.fQY != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.fQY);
      }
      i = g.a.a.b.b.a.r(7, this.hFK);
      AppMethodBeat.o(209637);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209637);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bao localbao = (bao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209637);
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
            localbao.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209637);
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
            localbao.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209637);
          return 0;
        case 3: 
          localbao.LDx = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209637);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbao.uke = ((awq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209637);
          return 0;
        case 5: 
          localbao.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209637);
          return 0;
        case 6: 
          localbao.fQY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209637);
          return 0;
        }
        localbao.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209637);
        return 0;
      }
      AppMethodBeat.o(209637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bao
 * JD-Core Version:    0.7.0.1
 */