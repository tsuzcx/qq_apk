package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fdz
  extends com.tencent.mm.cd.a
{
  public int IyZ;
  public eae RNM;
  public int SnG;
  public int vhf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115873);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.SnG);
      paramVarArgs.aY(2, this.vhf);
      paramVarArgs.aY(3, this.IyZ);
      if (this.RNM != null)
      {
        paramVarArgs.oE(4, this.RNM.computeSize());
        this.RNM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SnG) + 0 + g.a.a.b.b.a.bM(2, this.vhf) + g.a.a.b.b.a.bM(3, this.IyZ);
      paramInt = i;
      if (this.RNM != null) {
        paramInt = i + g.a.a.a.oD(4, this.RNM.computeSize());
      }
      AppMethodBeat.o(115873);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fdz localfdz = (fdz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115873);
        return -1;
      case 1: 
        localfdz.SnG = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115873);
        return 0;
      case 2: 
        localfdz.vhf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115873);
        return 0;
      case 3: 
        localfdz.IyZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115873);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eae localeae = new eae();
        if ((localObject != null) && (localObject.length > 0)) {
          localeae.dd((byte[])localObject);
        }
        localfdz.RNM = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    AppMethodBeat.o(115873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdz
 * JD-Core Version:    0.7.0.1
 */