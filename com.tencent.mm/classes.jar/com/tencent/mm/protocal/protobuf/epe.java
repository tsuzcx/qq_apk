package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epe
  extends com.tencent.mm.bx.a
{
  public int ZrC;
  public String ZrD;
  public String ZrE;
  public int ZrF;
  public int ZrG;
  public int ZrH;
  public int ZrL;
  public int ZrM;
  public fzo abto;
  public fzo abtp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115848);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZrC);
      if (this.ZrD != null) {
        paramVarArgs.g(2, this.ZrD);
      }
      if (this.ZrE != null) {
        paramVarArgs.g(3, this.ZrE);
      }
      paramVarArgs.bS(4, this.ZrF);
      paramVarArgs.bS(5, this.ZrG);
      paramVarArgs.bS(6, this.ZrH);
      if (this.abto != null)
      {
        paramVarArgs.qD(7, this.abto.computeSize());
        this.abto.writeFields(paramVarArgs);
      }
      if (this.abtp != null)
      {
        paramVarArgs.qD(8, this.abtp.computeSize());
        this.abtp.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.ZrL);
      paramVarArgs.bS(10, this.ZrM);
      AppMethodBeat.o(115848);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZrC) + 0;
      paramInt = i;
      if (this.ZrD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZrD);
      }
      i = paramInt;
      if (this.ZrE != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZrE);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.ZrF) + i.a.a.b.b.a.cJ(5, this.ZrG) + i.a.a.b.b.a.cJ(6, this.ZrH);
      paramInt = i;
      if (this.abto != null) {
        paramInt = i + i.a.a.a.qC(7, this.abto.computeSize());
      }
      i = paramInt;
      if (this.abtp != null) {
        i = paramInt + i.a.a.a.qC(8, this.abtp.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.ZrL);
      int j = i.a.a.b.b.a.cJ(10, this.ZrM);
      AppMethodBeat.o(115848);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115848);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      epe localepe = (epe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fzo localfzo;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115848);
        return -1;
      case 1: 
        localepe.ZrC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115848);
        return 0;
      case 2: 
        localepe.ZrD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 3: 
        localepe.ZrE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 4: 
        localepe.ZrF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115848);
        return 0;
      case 5: 
        localepe.ZrG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115848);
        return 0;
      case 6: 
        localepe.ZrH = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115848);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfzo = new fzo();
          if ((localObject != null) && (localObject.length > 0)) {
            localfzo.parseFrom((byte[])localObject);
          }
          localepe.abto = localfzo;
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfzo = new fzo();
          if ((localObject != null) && (localObject.length > 0)) {
            localfzo.parseFrom((byte[])localObject);
          }
          localepe.abtp = localfzo;
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 9: 
        localepe.ZrL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115848);
        return 0;
      }
      localepe.ZrM = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(115848);
      return 0;
    }
    AppMethodBeat.o(115848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epe
 * JD-Core Version:    0.7.0.1
 */