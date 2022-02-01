package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class euo
  extends com.tencent.mm.bx.a
{
  public b abxo;
  public b abxp;
  public b abxq;
  public b abxr;
  public eup abxs;
  public int rGS;
  public int rGT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.rGS);
      if (this.abxo != null) {
        paramVarArgs.d(2, this.abxo);
      }
      if (this.abxp != null) {
        paramVarArgs.d(3, this.abxp);
      }
      if (this.abxq != null) {
        paramVarArgs.d(4, this.abxq);
      }
      if (this.abxr != null) {
        paramVarArgs.d(5, this.abxr);
      }
      if (this.abxs != null)
      {
        paramVarArgs.qD(6, this.abxs.computeSize());
        this.abxs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.rGT);
      AppMethodBeat.o(257493);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.rGS) + 0;
      paramInt = i;
      if (this.abxo != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.abxo);
      }
      i = paramInt;
      if (this.abxp != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.abxp);
      }
      paramInt = i;
      if (this.abxq != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.abxq);
      }
      i = paramInt;
      if (this.abxr != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.abxr);
      }
      paramInt = i;
      if (this.abxs != null) {
        paramInt = i + i.a.a.a.qC(6, this.abxs.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.rGT);
      AppMethodBeat.o(257493);
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
      AppMethodBeat.o(257493);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      euo localeuo = (euo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257493);
        return -1;
      case 1: 
        localeuo.rGS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257493);
        return 0;
      case 2: 
        localeuo.abxo = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257493);
        return 0;
      case 3: 
        localeuo.abxp = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257493);
        return 0;
      case 4: 
        localeuo.abxq = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257493);
        return 0;
      case 5: 
        localeuo.abxr = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257493);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eup localeup = new eup();
          if ((localObject != null) && (localObject.length > 0)) {
            localeup.parseFrom((byte[])localObject);
          }
          localeuo.abxs = localeup;
          paramInt += 1;
        }
        AppMethodBeat.o(257493);
        return 0;
      }
      localeuo.rGT = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(257493);
      return 0;
    }
    AppMethodBeat.o(257493);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euo
 * JD-Core Version:    0.7.0.1
 */