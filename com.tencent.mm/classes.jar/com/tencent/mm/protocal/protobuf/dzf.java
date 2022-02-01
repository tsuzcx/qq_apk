package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dzf
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> aamU;
  public LinkedList<dzc> abdY;
  public int vgN;
  
  public dzf()
  {
    AppMethodBeat.i(43120);
    this.aamU = new LinkedList();
    this.abdY = new LinkedList();
    AppMethodBeat.o(43120);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43121);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vgN);
      paramVarArgs.f(2, 2, this.aamU);
      paramVarArgs.e(3, 8, this.abdY);
      AppMethodBeat.o(43121);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vgN);
      i = i.a.a.a.d(2, 2, this.aamU);
      int j = i.a.a.a.c(3, 8, this.abdY);
      AppMethodBeat.o(43121);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aamU.clear();
      this.abdY.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dzf localdzf = (dzf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43121);
        return -1;
      case 1: 
        localdzf.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43121);
        return 0;
      case 2: 
        localdzf.aamU = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
        AppMethodBeat.o(43121);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dzc localdzc = new dzc();
        if ((localObject != null) && (localObject.length > 0)) {
          localdzc.parseFrom((byte[])localObject);
        }
        localdzf.abdY.add(localdzc);
        paramInt += 1;
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    AppMethodBeat.o(43121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzf
 * JD-Core Version:    0.7.0.1
 */