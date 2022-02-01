package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class etm
  extends com.tencent.mm.bw.a
{
  public int Lms;
  public SKBuiltinBuffer_t Lmt;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115870);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lmt == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(115870);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Lms);
      if (this.Lmt != null)
      {
        paramVarArgs.ni(2, this.Lmt.computeSize());
        this.Lmt.writeFields(paramVarArgs);
      }
      if (this.xNH != null) {
        paramVarArgs.e(3, this.xNH);
      }
      AppMethodBeat.o(115870);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Lms) + 0;
      paramInt = i;
      if (this.Lmt != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lmt.computeSize());
      }
      i = paramInt;
      if (this.xNH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNH);
      }
      AppMethodBeat.o(115870);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Lmt == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(115870);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115870);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      etm localetm = (etm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115870);
        return -1;
      case 1: 
        localetm.Lms = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115870);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localetm.Lmt = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115870);
        return 0;
      }
      localetm.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(115870);
      return 0;
    }
    AppMethodBeat.o(115870);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etm
 * JD-Core Version:    0.7.0.1
 */