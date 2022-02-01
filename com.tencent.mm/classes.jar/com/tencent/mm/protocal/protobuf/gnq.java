package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gnq
  extends com.tencent.mm.bx.a
{
  public int ZrW;
  public LinkedList<dgo> aciF;
  public int vgN;
  
  public gnq()
  {
    AppMethodBeat.i(259587);
    this.aciF = new LinkedList();
    AppMethodBeat.o(259587);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259592);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZrW);
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.aciF);
      AppMethodBeat.o(259592);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZrW);
      i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.c(3, 8, this.aciF);
      AppMethodBeat.o(259592);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aciF.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259592);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gnq localgnq = (gnq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259592);
        return -1;
      case 1: 
        localgnq.ZrW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259592);
        return 0;
      case 2: 
        localgnq.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259592);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dgo localdgo = new dgo();
        if ((localObject != null) && (localObject.length > 0)) {
          localdgo.parseFrom((byte[])localObject);
        }
        localgnq.aciF.add(localdgo);
        paramInt += 1;
      }
      AppMethodBeat.o(259592);
      return 0;
    }
    AppMethodBeat.o(259592);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnq
 * JD-Core Version:    0.7.0.1
 */