package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dwy
  extends dop
{
  public SKBuiltinBuffer_t BsI;
  public int KIy;
  public int LZS;
  public int LZT;
  public float LbD;
  public int Llx;
  public int MWV;
  public float MWW;
  public float MWX;
  public int jeU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32444);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32444);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.BsI != null)
      {
        paramVarArgs.ni(2, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MWV);
      paramVarArgs.aM(4, this.jeU);
      paramVarArgs.E(5, this.MWW);
      paramVarArgs.aM(6, this.Llx);
      paramVarArgs.aM(7, this.KIy);
      paramVarArgs.E(8, this.MWX);
      paramVarArgs.E(9, this.LbD);
      paramVarArgs.aM(10, this.LZS);
      paramVarArgs.aM(11, this.LZT);
      AppMethodBeat.o(32444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label960;
      }
    }
    label960:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BsI != null) {
        i = paramInt + g.a.a.a.nh(2, this.BsI.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MWV);
      int j = g.a.a.b.b.a.bu(4, this.jeU);
      int k = g.a.a.b.b.a.fS(5);
      int m = g.a.a.b.b.a.bu(6, this.Llx);
      int n = g.a.a.b.b.a.bu(7, this.KIy);
      int i1 = g.a.a.b.b.a.fS(8);
      int i2 = g.a.a.b.b.a.fS(9);
      int i3 = g.a.a.b.b.a.bu(10, this.LZS);
      int i4 = g.a.a.b.b.a.bu(11, this.LZT);
      AppMethodBeat.o(32444);
      return i + paramInt + j + (k + 4) + m + n + (i1 + 4) + (i2 + 4) + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32444);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dwy localdwy = (dwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32444);
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
            localdwy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwy.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 3: 
          localdwy.MWV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32444);
          return 0;
        case 4: 
          localdwy.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32444);
          return 0;
        case 5: 
          localdwy.MWW = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(32444);
          return 0;
        case 6: 
          localdwy.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32444);
          return 0;
        case 7: 
          localdwy.KIy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32444);
          return 0;
        case 8: 
          localdwy.MWX = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(32444);
          return 0;
        case 9: 
          localdwy.LbD = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(32444);
          return 0;
        case 10: 
          localdwy.LZS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32444);
          return 0;
        }
        localdwy.LZT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32444);
        return 0;
      }
      AppMethodBeat.o(32444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwy
 * JD-Core Version:    0.7.0.1
 */