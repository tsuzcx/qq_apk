package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqv
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t GNA;
  public int HXP;
  public String HXQ;
  public String HXR;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HXP);
      if (this.HXQ != null) {
        paramVarArgs.d(2, this.HXQ);
      }
      if (this.HXR != null) {
        paramVarArgs.d(3, this.HXR);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.GNA != null)
      {
        paramVarArgs.lJ(5, this.GNA.computeSize());
        this.GNA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HXP) + 0;
      paramInt = i;
      if (this.HXQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HXQ);
      }
      i = paramInt;
      if (this.HXR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HXR);
      }
      i += f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.GNA != null) {
        paramInt = i + f.a.a.a.lI(5, this.GNA.computeSize());
      }
      AppMethodBeat.o(152715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dqv localdqv = (dqv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152715);
        return -1;
      case 1: 
        localdqv.HXP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152715);
        return 0;
      case 2: 
        localdqv.HXQ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 3: 
        localdqv.HXR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 4: 
        localdqv.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152715);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdqv.GNA = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    AppMethodBeat.o(152715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqv
 * JD-Core Version:    0.7.0.1
 */