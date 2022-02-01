package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class iq
  extends com.tencent.mm.bw.a
{
  public String ID;
  public SKBuiltinBuffer_t KMI;
  public String KMJ;
  public int KMK;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32135);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMI == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Ret);
      if (this.KMI != null)
      {
        paramVarArgs.ni(2, this.KMI.computeSize());
        this.KMI.writeFields(paramVarArgs);
      }
      if (this.KMJ != null) {
        paramVarArgs.e(3, this.KMJ);
      }
      paramVarArgs.aM(4, this.KMK);
      if (this.ID != null) {
        paramVarArgs.e(5, this.ID);
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.KMI != null) {
        paramInt = i + g.a.a.a.nh(2, this.KMI.computeSize());
      }
      i = paramInt;
      if (this.KMJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KMJ);
      }
      i += g.a.a.b.b.a.bu(4, this.KMK);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ID);
      }
      AppMethodBeat.o(32135);
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
      if (this.KMI == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      iq localiq = (iq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32135);
        return -1;
      case 1: 
        localiq.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32135);
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
          localiq.KMI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32135);
        return 0;
      case 3: 
        localiq.KMJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32135);
        return 0;
      case 4: 
        localiq.KMK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32135);
        return 0;
      }
      localiq.ID = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(32135);
      return 0;
    }
    AppMethodBeat.o(32135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iq
 * JD-Core Version:    0.7.0.1
 */