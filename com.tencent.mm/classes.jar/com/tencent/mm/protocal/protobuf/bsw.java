package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsw
  extends com.tencent.mm.bw.a
{
  public int DUM;
  public int FhS;
  public bpa FhT;
  public long FhU;
  public int Scene;
  public String pAD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Scene);
      paramVarArgs.aR(2, this.FhS);
      if (this.FhT != null)
      {
        paramVarArgs.ln(3, this.FhT.computeSize());
        this.FhT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.DUM);
      if (this.pAD != null) {
        paramVarArgs.d(5, this.pAD);
      }
      paramVarArgs.aO(6, this.FhU);
      AppMethodBeat.o(117878);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Scene) + 0 + f.a.a.b.b.a.bx(2, this.FhS);
      paramInt = i;
      if (this.FhT != null) {
        paramInt = i + f.a.a.a.lm(3, this.FhT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.DUM);
      paramInt = i;
      if (this.pAD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pAD);
      }
      i = f.a.a.b.b.a.p(6, this.FhU);
      AppMethodBeat.o(117878);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bsw localbsw = (bsw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117878);
        return -1;
      case 1: 
        localbsw.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117878);
        return 0;
      case 2: 
        localbsw.FhS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117878);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsw.FhT = ((bpa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117878);
        return 0;
      case 4: 
        localbsw.DUM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117878);
        return 0;
      case 5: 
        localbsw.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117878);
        return 0;
      }
      localbsw.FhU = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(117878);
      return 0;
    }
    AppMethodBeat.o(117878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsw
 * JD-Core Version:    0.7.0.1
 */