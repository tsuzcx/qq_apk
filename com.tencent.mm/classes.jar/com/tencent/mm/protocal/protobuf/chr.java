package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chr
  extends dop
{
  public float LbC;
  public float LbD;
  public int LuT;
  public String LuU;
  public String LuV;
  public int LuW;
  public int Mnb;
  public int Mnc;
  public int OpCode;
  public String jfM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89929);
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
      if (this.jfM != null) {
        paramVarArgs.e(9, this.jfM);
      }
      paramVarArgs.aM(10, this.Mnb);
      paramVarArgs.aM(11, this.Mnc);
      AppMethodBeat.o(89929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label808;
      }
    }
    label808:
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
      i += g.a.a.b.b.a.bu(8, this.LuW);
      paramInt = i;
      if (this.jfM != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.jfM);
      }
      i = g.a.a.b.b.a.bu(10, this.Mnb);
      int j = g.a.a.b.b.a.bu(11, this.Mnc);
      AppMethodBeat.o(89929);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(89929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chr localchr = (chr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89929);
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
            localchr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89929);
          return 0;
        case 2: 
          localchr.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89929);
          return 0;
        case 3: 
          localchr.LbC = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(89929);
          return 0;
        case 4: 
          localchr.LbD = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(89929);
          return 0;
        case 5: 
          localchr.LuT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89929);
          return 0;
        case 6: 
          localchr.LuU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 7: 
          localchr.LuV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 8: 
          localchr.LuW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89929);
          return 0;
        case 9: 
          localchr.jfM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 10: 
          localchr.Mnb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89929);
          return 0;
        }
        localchr.Mnc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(89929);
        return 0;
      }
      AppMethodBeat.o(89929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chr
 * JD-Core Version:    0.7.0.1
 */