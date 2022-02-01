package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etp
  extends com.tencent.mm.bx.a
{
  public LinkedList<dkb> abwQ;
  public boolean abwR;
  public boolean abwS;
  public boolean abwT;
  public boolean abwU;
  public boolean abwV;
  
  public etp()
  {
    AppMethodBeat.i(155454);
    this.abwQ = new LinkedList();
    AppMethodBeat.o(155454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.abwQ);
      paramVarArgs.di(2, this.abwR);
      paramVarArgs.di(3, this.abwS);
      paramVarArgs.di(4, this.abwT);
      paramVarArgs.di(5, this.abwU);
      paramVarArgs.di(6, this.abwV);
      AppMethodBeat.o(155455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.abwQ);
      i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(155455);
      return paramInt + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abwQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(155455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      etp localetp = (etp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155455);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dkb localdkb = new dkb();
          if ((localObject != null) && (localObject.length > 0)) {
            localdkb.parseFrom((byte[])localObject);
          }
          localetp.abwQ.add(localdkb);
          paramInt += 1;
        }
        AppMethodBeat.o(155455);
        return 0;
      case 2: 
        localetp.abwR = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(155455);
        return 0;
      case 3: 
        localetp.abwS = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(155455);
        return 0;
      case 4: 
        localetp.abwT = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(155455);
        return 0;
      case 5: 
        localetp.abwU = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(155455);
        return 0;
      }
      localetp.abwV = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(155455);
      return 0;
    }
    AppMethodBeat.o(155455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etp
 * JD-Core Version:    0.7.0.1
 */