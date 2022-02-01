package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dop
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public SKBuiltinBuffer_t FWl;
  public SKBuiltinBuffer_t FWm;
  public int ID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.FWm == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.ID);
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.FWl != null)
      {
        paramVarArgs.ln(3, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      if (this.FWm != null)
      {
        paramVarArgs.ln(4, this.FWm.computeSize());
        this.FWm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ID) + 0;
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.FWl != null) {
        i = paramInt + f.a.a.a.lm(3, this.FWl.computeSize());
      }
      paramInt = i;
      if (this.FWm != null) {
        paramInt = i + f.a.a.a.lm(4, this.FWm.computeSize());
      }
      AppMethodBeat.o(32492);
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
      if (this.FWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.FWm == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dop localdop = (dop)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32492);
        return -1;
      case 1: 
        localdop.ID = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32492);
        return 0;
      case 2: 
        localdop.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32492);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdop.FWl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32492);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdop.FWm = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    AppMethodBeat.o(32492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dop
 * JD-Core Version:    0.7.0.1
 */