package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dki
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t EKY;
  public int FTo;
  public String FTr;
  public int FTs;
  public String FmI;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FTo);
      if (this.FTr != null) {
        paramVarArgs.d(2, this.FTr);
      }
      paramVarArgs.aR(3, this.Ret);
      if (this.FmI != null) {
        paramVarArgs.d(4, this.FmI);
      }
      if (this.EKY != null)
      {
        paramVarArgs.ln(5, this.EKY.computeSize());
        this.EKY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.FTs);
      AppMethodBeat.o(152716);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FTo) + 0;
      paramInt = i;
      if (this.FTr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FTr);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.Ret);
      paramInt = i;
      if (this.FmI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FmI);
      }
      i = paramInt;
      if (this.EKY != null) {
        i = paramInt + f.a.a.a.lm(5, this.EKY.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(6, this.FTs);
      AppMethodBeat.o(152716);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152716);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dki localdki = (dki)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152716);
        return -1;
      case 1: 
        localdki.FTo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152716);
        return 0;
      case 2: 
        localdki.FTr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 3: 
        localdki.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152716);
        return 0;
      case 4: 
        localdki.FmI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdki.EKY = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152716);
        return 0;
      }
      localdki.FTs = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(152716);
      return 0;
    }
    AppMethodBeat.o(152716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dki
 * JD-Core Version:    0.7.0.1
 */