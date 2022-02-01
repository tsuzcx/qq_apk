package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fdj
  extends com.tencent.mm.bx.a
{
  public int IcB;
  public etl abCM;
  public etl abCO;
  public int abCP;
  public int abCQ;
  public LinkedList<Integer> abCR;
  
  public fdj()
  {
    AppMethodBeat.i(258783);
    this.abCR = new LinkedList();
    AppMethodBeat.o(258783);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125764);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCM != null)
      {
        paramVarArgs.qD(1, this.abCM.computeSize());
        this.abCM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IcB);
      if (this.abCO != null)
      {
        paramVarArgs.qD(3, this.abCO.computeSize());
        this.abCO.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.abCP);
      paramVarArgs.bS(5, this.abCQ);
      paramVarArgs.f(6, 2, this.abCR);
      AppMethodBeat.o(125764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abCM == null) {
        break label629;
      }
    }
    label629:
    for (paramInt = i.a.a.a.qC(1, this.abCM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IcB);
      paramInt = i;
      if (this.abCO != null) {
        paramInt = i + i.a.a.a.qC(3, this.abCO.computeSize());
      }
      i = i.a.a.b.b.a.cJ(4, this.abCP);
      int j = i.a.a.b.b.a.cJ(5, this.abCQ);
      int k = i.a.a.a.d(6, 2, this.abCR);
      AppMethodBeat.o(125764);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abCR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fdj localfdj = (fdj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        etl localetl;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125764);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localfdj.abCM = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 2: 
          localfdj.IcB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125764);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localfdj.abCO = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 4: 
          localfdj.abCP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125764);
          return 0;
        case 5: 
          localfdj.abCQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125764);
          return 0;
        }
        localfdj.abCR = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
        AppMethodBeat.o(125764);
        return 0;
      }
      AppMethodBeat.o(125764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdj
 * JD-Core Version:    0.7.0.1
 */