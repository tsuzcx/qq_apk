package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class fu
  extends com.tencent.mm.bw.a
{
  public int DSP;
  public int DSQ;
  public fz DSR;
  public ft DSS;
  public int OpCode;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.OpCode);
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      paramVarArgs.aR(3, this.DSP);
      paramVarArgs.aR(4, this.DSQ);
      if (this.DSR != null)
      {
        paramVarArgs.ln(5, this.DSR.computeSize());
        this.DSR.writeFields(paramVarArgs);
      }
      if (this.DSS != null)
      {
        paramVarArgs.ln(6, this.DSS.computeSize());
        this.DSS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.OpCode) + 0;
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.DSP) + f.a.a.b.b.a.bx(4, this.DSQ);
      paramInt = i;
      if (this.DSR != null) {
        paramInt = i + f.a.a.a.lm(5, this.DSR.computeSize());
      }
      i = paramInt;
      if (this.DSS != null) {
        i = paramInt + f.a.a.a.lm(6, this.DSS.computeSize());
      }
      AppMethodBeat.o(32118);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.hOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      fu localfu = (fu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32118);
        return -1;
      case 1: 
        localfu.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32118);
        return 0;
      case 2: 
        localfu.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32118);
        return 0;
      case 3: 
        localfu.DSP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32118);
        return 0;
      case 4: 
        localfu.DSQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32118);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localfu.DSR = ((fz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32118);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ft();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ft)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localfu.DSS = ((ft)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    AppMethodBeat.o(32118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */