package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwq
  extends com.tencent.mm.bx.a
{
  public boolean aafD;
  public LinkedList<bwp> aafE;
  public String aafF;
  public long aafG;
  public int icon;
  
  public bwq()
  {
    AppMethodBeat.i(258549);
    this.aafE = new LinkedList();
    AppMethodBeat.o(258549);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258551);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aafE);
      if (this.aafF != null) {
        paramVarArgs.g(2, this.aafF);
      }
      paramVarArgs.bv(3, this.aafG);
      paramVarArgs.di(4, this.aafD);
      paramVarArgs.bS(5, this.icon);
      AppMethodBeat.o(258551);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.aafE) + 0;
      paramInt = i;
      if (this.aafF != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aafF);
      }
      i = i.a.a.b.b.a.q(3, this.aafG);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.cJ(5, this.icon);
      AppMethodBeat.o(258551);
      return paramInt + i + (j + 1) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aafE.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258551);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bwq localbwq = (bwq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258551);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bwp localbwp = new bwp();
          if ((localObject != null) && (localObject.length > 0)) {
            localbwp.parseFrom((byte[])localObject);
          }
          localbwq.aafE.add(localbwp);
          paramInt += 1;
        }
        AppMethodBeat.o(258551);
        return 0;
      case 2: 
        localbwq.aafF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258551);
        return 0;
      case 3: 
        localbwq.aafG = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258551);
        return 0;
      case 4: 
        localbwq.aafD = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258551);
        return 0;
      }
      localbwq.icon = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258551);
      return 0;
    }
    AppMethodBeat.o(258551);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwq
 * JD-Core Version:    0.7.0.1
 */