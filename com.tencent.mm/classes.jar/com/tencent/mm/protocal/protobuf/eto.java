package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eto
  extends com.tencent.mm.bw.a
{
  public int Cya;
  public SKBuiltinBuffer_t KMS;
  public int Lms;
  public int rBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115873);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Lms);
      paramVarArgs.aM(2, this.rBx);
      paramVarArgs.aM(3, this.Cya);
      if (this.KMS != null)
      {
        paramVarArgs.ni(4, this.KMS.computeSize());
        this.KMS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Lms) + 0 + g.a.a.b.b.a.bu(2, this.rBx) + g.a.a.b.b.a.bu(3, this.Cya);
      paramInt = i;
      if (this.KMS != null) {
        paramInt = i + g.a.a.a.nh(4, this.KMS.computeSize());
      }
      AppMethodBeat.o(115873);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KMS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eto localeto = (eto)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115873);
        return -1;
      case 1: 
        localeto.Lms = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115873);
        return 0;
      case 2: 
        localeto.rBx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115873);
        return 0;
      case 3: 
        localeto.Cya = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115873);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeto.KMS = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    AppMethodBeat.o(115873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eto
 * JD-Core Version:    0.7.0.1
 */