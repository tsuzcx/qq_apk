package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqw
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t GNA;
  public int HXP;
  public String HXS;
  public int HXT;
  public String HpR;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HXP);
      if (this.HXS != null) {
        paramVarArgs.d(2, this.HXS);
      }
      paramVarArgs.aS(3, this.Ret);
      if (this.HpR != null) {
        paramVarArgs.d(4, this.HpR);
      }
      if (this.GNA != null)
      {
        paramVarArgs.lJ(5, this.GNA.computeSize());
        this.GNA.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HXT);
      AppMethodBeat.o(152716);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HXP) + 0;
      paramInt = i;
      if (this.HXS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HXS);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Ret);
      paramInt = i;
      if (this.HpR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HpR);
      }
      i = paramInt;
      if (this.GNA != null) {
        i = paramInt + f.a.a.a.lI(5, this.GNA.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.HXT);
      AppMethodBeat.o(152716);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152716);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dqw localdqw = (dqw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152716);
        return -1;
      case 1: 
        localdqw.HXP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152716);
        return 0;
      case 2: 
        localdqw.HXS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 3: 
        localdqw.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152716);
        return 0;
      case 4: 
        localdqw.HpR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqw.GNA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152716);
        return 0;
      }
      localdqw.HXT = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(152716);
      return 0;
    }
    AppMethodBeat.o(152716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqw
 * JD-Core Version:    0.7.0.1
 */