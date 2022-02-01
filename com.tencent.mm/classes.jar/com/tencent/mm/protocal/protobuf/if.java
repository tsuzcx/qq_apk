package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class if
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KMo;
  public ccb KMp;
  public int KMq;
  public SKBuiltinBuffer_t KMr;
  public String KMs;
  public int xMB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133152);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.KMr == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.xMB);
      if (this.KMo != null)
      {
        paramVarArgs.ni(2, this.KMo.computeSize());
        this.KMo.writeFields(paramVarArgs);
      }
      if (this.KMp != null)
      {
        paramVarArgs.ni(3, this.KMp.computeSize());
        this.KMp.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KMq);
      if (this.KMr != null)
      {
        paramVarArgs.ni(5, this.KMr.computeSize());
        this.KMr.writeFields(paramVarArgs);
      }
      if (this.KMs != null) {
        paramVarArgs.e(6, this.KMs);
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.xMB) + 0;
      paramInt = i;
      if (this.KMo != null) {
        paramInt = i + g.a.a.a.nh(2, this.KMo.computeSize());
      }
      i = paramInt;
      if (this.KMp != null) {
        i = paramInt + g.a.a.a.nh(3, this.KMp.computeSize());
      }
      i += g.a.a.b.b.a.bu(4, this.KMq);
      paramInt = i;
      if (this.KMr != null) {
        paramInt = i + g.a.a.a.nh(5, this.KMr.computeSize());
      }
      i = paramInt;
      if (this.KMs != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KMs);
      }
      AppMethodBeat.o(133152);
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
      if (this.KMo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.KMr == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      if localif = (if)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133152);
        return -1;
      case 1: 
        localif.xMB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133152);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localif.KMo = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localif.KMp = ((ccb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 4: 
        localif.KMq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133152);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localif.KMr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      }
      localif.KMs = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(133152);
      return 0;
    }
    AppMethodBeat.o(133152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.if
 * JD-Core Version:    0.7.0.1
 */