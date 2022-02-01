package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class brw
  extends dop
{
  public double KUt;
  public double KUu;
  public String LPT;
  public SKBuiltinBuffer_t LXm;
  public int LXo;
  public double LYZ;
  public double LZa;
  public int OpCode;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56249);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LXm == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56249);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Scene);
      paramVarArgs.aM(3, this.OpCode);
      if (this.LPT != null) {
        paramVarArgs.e(4, this.LPT);
      }
      if (this.LXm != null)
      {
        paramVarArgs.ni(5, this.LXm.computeSize());
        this.LXm.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, this.KUt);
      paramVarArgs.e(7, this.KUu);
      paramVarArgs.e(8, this.LYZ);
      paramVarArgs.e(9, this.LZa);
      paramVarArgs.aM(10, this.LXo);
      AppMethodBeat.o(56249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Scene) + g.a.a.b.b.a.bu(3, this.OpCode);
      paramInt = i;
      if (this.LPT != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LPT);
      }
      i = paramInt;
      if (this.LXm != null) {
        i = paramInt + g.a.a.a.nh(5, this.LXm.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(6);
      int j = g.a.a.b.b.a.fS(7);
      int k = g.a.a.b.b.a.fS(8);
      int m = g.a.a.b.b.a.fS(9);
      int n = g.a.a.b.b.a.bu(10, this.LXo);
      AppMethodBeat.o(56249);
      return i + (paramInt + 8) + (j + 8) + (k + 8) + (m + 8) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LXm == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56249);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        brw localbrw = (brw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56249);
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
            localbrw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 2: 
          localbrw.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56249);
          return 0;
        case 3: 
          localbrw.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56249);
          return 0;
        case 4: 
          localbrw.LPT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56249);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbrw.LXm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 6: 
          localbrw.KUt = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(56249);
          return 0;
        case 7: 
          localbrw.KUu = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(56249);
          return 0;
        case 8: 
          localbrw.LYZ = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(56249);
          return 0;
        case 9: 
          localbrw.LZa = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(56249);
          return 0;
        }
        localbrw.LXo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(56249);
        return 0;
      }
      AppMethodBeat.o(56249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brw
 * JD-Core Version:    0.7.0.1
 */