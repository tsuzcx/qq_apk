package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpj
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public dpi aaWj;
  public int aaWk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257859);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      if (this.aaWj != null)
      {
        paramVarArgs.qD(2, this.aaWj.computeSize());
        this.aaWj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aaWk);
      AppMethodBeat.o(257859);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.aaWj != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaWj.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.aaWk);
      AppMethodBeat.o(257859);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257859);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dpj localdpj = (dpj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257859);
        return -1;
      case 1: 
        localdpj.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257859);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dpi localdpi = new dpi();
          if ((localObject != null) && (localObject.length > 0)) {
            localdpi.parseFrom((byte[])localObject);
          }
          localdpj.aaWj = localdpi;
          paramInt += 1;
        }
        AppMethodBeat.o(257859);
        return 0;
      }
      localdpj.aaWk = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(257859);
      return 0;
    }
    AppMethodBeat.o(257859);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpj
 * JD-Core Version:    0.7.0.1
 */