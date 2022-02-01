package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aeu
  extends com.tencent.mm.bx.a
{
  public String YWL;
  public String ZmO;
  public long ZmP;
  public int ZmQ;
  public int ZmR;
  public LinkedList<aew> ZmS;
  
  public aeu()
  {
    AppMethodBeat.i(260220);
    this.ZmS = new LinkedList();
    AppMethodBeat.o(260220);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260229);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZmO != null) {
        paramVarArgs.g(1, this.ZmO);
      }
      if (this.YWL != null) {
        paramVarArgs.g(2, this.YWL);
      }
      paramVarArgs.bv(3, this.ZmP);
      paramVarArgs.bS(4, this.ZmQ);
      paramVarArgs.bS(5, this.ZmR);
      paramVarArgs.e(6, 8, this.ZmS);
      AppMethodBeat.o(260229);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZmO == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZmO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YWL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YWL);
      }
      paramInt = i.a.a.b.b.a.q(3, this.ZmP);
      int j = i.a.a.b.b.a.cJ(4, this.ZmQ);
      int k = i.a.a.b.b.a.cJ(5, this.ZmR);
      int m = i.a.a.a.c(6, 8, this.ZmS);
      AppMethodBeat.o(260229);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZmS.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260229);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aeu localaeu = (aeu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260229);
          return -1;
        case 1: 
          localaeu.ZmO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260229);
          return 0;
        case 2: 
          localaeu.YWL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260229);
          return 0;
        case 3: 
          localaeu.ZmP = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(260229);
          return 0;
        case 4: 
          localaeu.ZmQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(260229);
          return 0;
        case 5: 
          localaeu.ZmR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(260229);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aew localaew = new aew();
          if ((localObject != null) && (localObject.length > 0)) {
            localaew.parseFrom((byte[])localObject);
          }
          localaeu.ZmS.add(localaew);
          paramInt += 1;
        }
        AppMethodBeat.o(260229);
        return 0;
      }
      AppMethodBeat.o(260229);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeu
 * JD-Core Version:    0.7.0.1
 */