package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ble
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DPX;
  public crm FaM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152612);
        throw paramVarArgs;
      }
      if (this.FaM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(152612);
        throw paramVarArgs;
      }
      if (this.DPX != null)
      {
        paramVarArgs.ln(1, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      if (this.FaM != null)
      {
        paramVarArgs.ln(2, this.FaM.computeSize());
        this.FaM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPX == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.DPX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FaM != null) {
        i = paramInt + f.a.a.a.lm(2, this.FaM.computeSize());
      }
      AppMethodBeat.o(152612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152612);
          throw paramVarArgs;
        }
        if (this.FaM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(152612);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ble localble = (ble)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152612);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localble.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152612);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localble.FaM = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152612);
        return 0;
      }
      AppMethodBeat.o(152612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ble
 * JD-Core Version:    0.7.0.1
 */