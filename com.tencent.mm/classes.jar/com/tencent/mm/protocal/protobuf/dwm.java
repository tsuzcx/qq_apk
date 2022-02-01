package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwm
  extends dop
{
  public String Bri;
  public SKBuiltinBuffer_t KKZ;
  public int MWL;
  public String rBz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rBz != null) {
        paramVarArgs.e(2, this.rBz);
      }
      if (this.Bri != null) {
        paramVarArgs.e(3, this.Bri);
      }
      if (this.KKZ != null)
      {
        paramVarArgs.ni(4, this.KKZ.computeSize());
        this.KKZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MWL);
      AppMethodBeat.o(134257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rBz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.rBz);
      }
      i = paramInt;
      if (this.Bri != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Bri);
      }
      paramInt = i;
      if (this.KKZ != null) {
        paramInt = i + g.a.a.a.nh(4, this.KKZ.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.MWL);
      AppMethodBeat.o(134257);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(134257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dwm localdwm = (dwm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134257);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwm.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        case 2: 
          localdwm.rBz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 3: 
          localdwm.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwm.KKZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        }
        localdwm.MWL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(134257);
        return 0;
      }
      AppMethodBeat.o(134257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwm
 * JD-Core Version:    0.7.0.1
 */