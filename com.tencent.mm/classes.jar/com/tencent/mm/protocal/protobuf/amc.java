package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amc
  extends dop
{
  public long LuJ;
  public String LuK;
  public String LuR;
  public String dNI;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104365);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LuJ);
      if (this.LuR != null) {
        paramVarArgs.e(3, this.LuR);
      }
      if (this.dNI != null) {
        paramVarArgs.e(4, this.dNI);
      }
      if (this.LuK != null) {
        paramVarArgs.e(5, this.LuK);
      }
      paramVarArgs.aM(6, this.source);
      AppMethodBeat.o(104365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LuJ);
      paramInt = i;
      if (this.LuR != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LuR);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.dNI);
      }
      paramInt = i;
      if (this.LuK != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LuK);
      }
      i = g.a.a.b.b.a.bu(6, this.source);
      AppMethodBeat.o(104365);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        amc localamc = (amc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104365);
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
            localamc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104365);
          return 0;
        case 2: 
          localamc.LuJ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(104365);
          return 0;
        case 3: 
          localamc.LuR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 4: 
          localamc.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 5: 
          localamc.LuK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104365);
          return 0;
        }
        localamc.source = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104365);
        return 0;
      }
      AppMethodBeat.o(104365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amc
 * JD-Core Version:    0.7.0.1
 */