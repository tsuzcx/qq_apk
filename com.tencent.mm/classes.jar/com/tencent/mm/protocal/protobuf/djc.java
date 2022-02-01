package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djc
  extends dop
{
  public float LbC;
  public float LbD;
  public int LuT;
  public String LuU;
  public String LuV;
  public int LuW;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127296);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.OpCode);
      paramVarArgs.E(3, this.LbC);
      paramVarArgs.E(4, this.LbD);
      paramVarArgs.aM(5, this.LuT);
      if (this.LuU != null) {
        paramVarArgs.e(6, this.LuU);
      }
      if (this.LuV != null) {
        paramVarArgs.e(7, this.LuV);
      }
      paramVarArgs.aM(8, this.LuW);
      AppMethodBeat.o(127296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.OpCode) + (g.a.a.b.b.a.fS(3) + 4) + (g.a.a.b.b.a.fS(4) + 4) + g.a.a.b.b.a.bu(5, this.LuT);
      paramInt = i;
      if (this.LuU != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LuU);
      }
      i = paramInt;
      if (this.LuV != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LuV);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.LuW);
      AppMethodBeat.o(127296);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127296);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djc localdjc = (djc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127296);
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
            localdjc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127296);
          return 0;
        case 2: 
          localdjc.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127296);
          return 0;
        case 3: 
          localdjc.LbC = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(127296);
          return 0;
        case 4: 
          localdjc.LbD = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(127296);
          return 0;
        case 5: 
          localdjc.LuT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127296);
          return 0;
        case 6: 
          localdjc.LuU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127296);
          return 0;
        case 7: 
          localdjc.LuV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127296);
          return 0;
        }
        localdjc.LuW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127296);
        return 0;
      }
      AppMethodBeat.o(127296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djc
 * JD-Core Version:    0.7.0.1
 */