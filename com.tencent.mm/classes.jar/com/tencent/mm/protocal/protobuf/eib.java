package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eib
  extends com.tencent.mm.bx.a
{
  public int JHo;
  public long ZvA;
  public int Zvz;
  public LinkedList<eik> abng;
  
  public eib()
  {
    AppMethodBeat.i(32381);
    this.abng = new LinkedList();
    AppMethodBeat.o(32381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32382);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zvz);
      paramVarArgs.bv(2, this.ZvA);
      paramVarArgs.e(3, 8, this.abng);
      paramVarArgs.bS(4, this.JHo);
      AppMethodBeat.o(32382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Zvz);
      i = i.a.a.b.b.a.q(2, this.ZvA);
      int j = i.a.a.a.c(3, 8, this.abng);
      int k = i.a.a.b.b.a.cJ(4, this.JHo);
      AppMethodBeat.o(32382);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abng.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eib localeib = (eib)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32382);
        return -1;
      case 1: 
        localeib.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32382);
        return 0;
      case 2: 
        localeib.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(32382);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eik localeik = new eik();
          if ((localObject != null) && (localObject.length > 0)) {
            localeik.parseFrom((byte[])localObject);
          }
          localeib.abng.add(localeik);
          paramInt += 1;
        }
        AppMethodBeat.o(32382);
        return 0;
      }
      localeib.JHo = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(32382);
      return 0;
    }
    AppMethodBeat.o(32382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eib
 * JD-Core Version:    0.7.0.1
 */