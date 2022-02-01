package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blb
  extends com.tencent.mm.bw.a
{
  public String FaE;
  public String FaI;
  public String FaJ;
  public String FaK;
  public cck FaL;
  public int dqL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FaE == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.dqL);
      if (this.FaE != null) {
        paramVarArgs.d(2, this.FaE);
      }
      if (this.FaI != null) {
        paramVarArgs.d(3, this.FaI);
      }
      if (this.FaJ != null) {
        paramVarArgs.d(4, this.FaJ);
      }
      if (this.FaK != null) {
        paramVarArgs.d(5, this.FaK);
      }
      if (this.FaL != null)
      {
        paramVarArgs.ln(6, this.FaL.computeSize());
        this.FaL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.dqL) + 0;
      paramInt = i;
      if (this.FaE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FaE);
      }
      i = paramInt;
      if (this.FaI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FaI);
      }
      paramInt = i;
      if (this.FaJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FaJ);
      }
      i = paramInt;
      if (this.FaK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FaK);
      }
      paramInt = i;
      if (this.FaL != null) {
        paramInt = i + f.a.a.a.lm(6, this.FaL.computeSize());
      }
      AppMethodBeat.o(72508);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FaE == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      blb localblb = (blb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72508);
        return -1;
      case 1: 
        localblb.dqL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72508);
        return 0;
      case 2: 
        localblb.FaE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 3: 
        localblb.FaI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 4: 
        localblb.FaJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 5: 
        localblb.FaK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72508);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cck();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cck)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localblb.FaL = ((cck)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    AppMethodBeat.o(72508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blb
 * JD-Core Version:    0.7.0.1
 */