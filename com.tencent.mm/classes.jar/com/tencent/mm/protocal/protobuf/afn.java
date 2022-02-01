package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afn
  extends com.tencent.mm.bx.a
{
  public String YzM;
  public long ZnE;
  public int ZoC;
  public LinkedList<afm> ZoD;
  
  public afn()
  {
    AppMethodBeat.i(259846);
    this.ZoD = new LinkedList();
    AppMethodBeat.o(259846);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259850);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZnE);
      if (this.YzM != null) {
        paramVarArgs.g(2, this.YzM);
      }
      paramVarArgs.bS(3, this.ZoC);
      paramVarArgs.e(4, 8, this.ZoD);
      AppMethodBeat.o(259850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ZnE) + 0;
      paramInt = i;
      if (this.YzM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YzM);
      }
      i = i.a.a.b.b.a.cJ(3, this.ZoC);
      int j = i.a.a.a.c(4, 8, this.ZoD);
      AppMethodBeat.o(259850);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZoD.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      afn localafn = (afn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259850);
        return -1;
      case 1: 
        localafn.ZnE = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259850);
        return 0;
      case 2: 
        localafn.YzM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259850);
        return 0;
      case 3: 
        localafn.ZoC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259850);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        afm localafm = new afm();
        if ((localObject != null) && (localObject.length > 0)) {
          localafm.parseFrom((byte[])localObject);
        }
        localafn.ZoD.add(localafm);
        paramInt += 1;
      }
      AppMethodBeat.o(259850);
      return 0;
    }
    AppMethodBeat.o(259850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afn
 * JD-Core Version:    0.7.0.1
 */