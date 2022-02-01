package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkh
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t EKY;
  public int FTo;
  public String FTp;
  public String FTq;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FTo);
      if (this.FTp != null) {
        paramVarArgs.d(2, this.FTp);
      }
      if (this.FTq != null) {
        paramVarArgs.d(3, this.FTq);
      }
      paramVarArgs.aR(4, this.Scene);
      if (this.EKY != null)
      {
        paramVarArgs.ln(5, this.EKY.computeSize());
        this.EKY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FTo) + 0;
      paramInt = i;
      if (this.FTp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FTp);
      }
      i = paramInt;
      if (this.FTq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FTq);
      }
      i += f.a.a.b.b.a.bx(4, this.Scene);
      paramInt = i;
      if (this.EKY != null) {
        paramInt = i + f.a.a.a.lm(5, this.EKY.computeSize());
      }
      AppMethodBeat.o(152715);
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
      AppMethodBeat.o(152715);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkh localdkh = (dkh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152715);
        return -1;
      case 1: 
        localdkh.FTo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152715);
        return 0;
      case 2: 
        localdkh.FTp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 3: 
        localdkh.FTq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 4: 
        localdkh.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152715);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdkh.EKY = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    AppMethodBeat.o(152715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkh
 * JD-Core Version:    0.7.0.1
 */