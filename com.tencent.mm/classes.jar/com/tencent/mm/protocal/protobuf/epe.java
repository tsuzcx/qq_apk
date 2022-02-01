package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class epe
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int ID;
  public SKBuiltinBuffer_t Nna;
  public SKBuiltinBuffer_t Nnb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nna == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.Nnb == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.ID);
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.Nna != null)
      {
        paramVarArgs.ni(3, this.Nna.computeSize());
        this.Nna.writeFields(paramVarArgs);
      }
      if (this.Nnb != null)
      {
        paramVarArgs.ni(4, this.Nnb.computeSize());
        this.Nnb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.ID) + 0;
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.Nna != null) {
        i = paramInt + g.a.a.a.nh(3, this.Nna.computeSize());
      }
      paramInt = i;
      if (this.Nnb != null) {
        paramInt = i + g.a.a.a.nh(4, this.Nnb.computeSize());
      }
      AppMethodBeat.o(32492);
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
      if (this.Nna == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.Nnb == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      epe localepe = (epe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32492);
        return -1;
      case 1: 
        localepe.ID = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32492);
        return 0;
      case 2: 
        localepe.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32492);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localepe.Nna = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32492);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localepe.Nnb = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    AppMethodBeat.o(32492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epe
 * JD-Core Version:    0.7.0.1
 */