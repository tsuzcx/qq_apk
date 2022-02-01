package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbi
  extends com.tencent.mm.cd.a
{
  public cla Sni;
  public long UBm;
  public double UBn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110916);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.UBm);
      paramVarArgs.e(2, this.UBn);
      if (this.Sni != null)
      {
        paramVarArgs.oE(3, this.Sni.computeSize());
        this.Sni.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.UBm) + 0 + (g.a.a.b.b.a.gL(2) + 8);
      paramInt = i;
      if (this.Sni != null) {
        paramInt = i + g.a.a.a.oD(3, this.Sni.computeSize());
      }
      AppMethodBeat.o(110916);
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
      AppMethodBeat.o(110916);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fbi localfbi = (fbi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110916);
        return -1;
      case 1: 
        localfbi.UBm = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110916);
        return 0;
      case 2: 
        localfbi.UBn = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(110916);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cla localcla = new cla();
        if ((localObject != null) && (localObject.length > 0)) {
          localcla.parseFrom((byte[])localObject);
        }
        localfbi.Sni = localcla;
        paramInt += 1;
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    AppMethodBeat.o(110916);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbi
 * JD-Core Version:    0.7.0.1
 */