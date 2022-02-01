package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlb
  extends com.tencent.mm.bx.a
{
  public String CLB;
  public int EAL;
  public SKBuiltinBuffer_t ExG;
  public int hno;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ExG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(148667);
        throw paramVarArgs;
      }
      if (this.ExG != null)
      {
        paramVarArgs.kX(1, this.ExG.computeSize());
        this.ExG.writeFields(paramVarArgs);
      }
      if (this.CLB != null) {
        paramVarArgs.d(2, this.CLB);
      }
      paramVarArgs.aR(3, this.hno);
      paramVarArgs.aR(4, this.EAL);
      AppMethodBeat.o(148667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ExG == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.kW(1, this.ExG.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CLB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CLB);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.hno);
      int j = f.a.a.b.b.a.bA(4, this.EAL);
      AppMethodBeat.o(148667);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ExG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(148667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148667);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlb localdlb = (dlb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148667);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlb.ExG = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148667);
          return 0;
        case 2: 
          localdlb.CLB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148667);
          return 0;
        case 3: 
          localdlb.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148667);
          return 0;
        }
        localdlb.EAL = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148667);
        return 0;
      }
      AppMethodBeat.o(148667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlb
 * JD-Core Version:    0.7.0.1
 */