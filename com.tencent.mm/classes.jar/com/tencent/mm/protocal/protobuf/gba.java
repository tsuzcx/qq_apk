package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class gba
  extends com.tencent.mm.bx.a
{
  public int Uze;
  public epf abYF;
  public akm abYG;
  public int abYH;
  public LinkedList<Integer> abYI;
  public int abYJ;
  public LinkedList<Integer> abYK;
  public epf abYL;
  
  public gba()
  {
    AppMethodBeat.i(115897);
    this.abYI = new LinkedList();
    this.abYK = new LinkedList();
    AppMethodBeat.o(115897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115898);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abYF != null)
      {
        paramVarArgs.qD(1, this.abYF.computeSize());
        this.abYF.writeFields(paramVarArgs);
      }
      if (this.abYG != null)
      {
        paramVarArgs.qD(2, this.abYG.computeSize());
        this.abYG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abYH);
      paramVarArgs.f(4, 2, this.abYI);
      paramVarArgs.bS(5, this.abYJ);
      paramVarArgs.f(6, 2, this.abYK);
      paramVarArgs.bS(7, this.Uze);
      if (this.abYL != null)
      {
        paramVarArgs.qD(8, this.abYL.computeSize());
        this.abYL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abYF == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = i.a.a.a.qC(1, this.abYF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abYG != null) {
        i = paramInt + i.a.a.a.qC(2, this.abYG.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.abYH) + i.a.a.a.d(4, 2, this.abYI) + i.a.a.b.b.a.cJ(5, this.abYJ) + i.a.a.a.d(6, 2, this.abYK) + i.a.a.b.b.a.cJ(7, this.Uze);
      paramInt = i;
      if (this.abYL != null) {
        paramInt = i + i.a.a.a.qC(8, this.abYL.computeSize());
      }
      AppMethodBeat.o(115898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abYI.clear();
        this.abYK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gba localgba = (gba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115898);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epf)localObject2).parseFrom((byte[])localObject1);
            }
            localgba.abYF = ((epf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akm)localObject2).parseFrom((byte[])localObject1);
            }
            localgba.abYG = ((akm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 3: 
          localgba.abYH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115898);
          return 0;
        case 4: 
          localgba.abYI = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(115898);
          return 0;
        case 5: 
          localgba.abYJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115898);
          return 0;
        case 6: 
          localgba.abYK = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(115898);
          return 0;
        case 7: 
          localgba.Uze = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115898);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epf)localObject2).parseFrom((byte[])localObject1);
          }
          localgba.abYL = ((epf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      AppMethodBeat.o(115898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gba
 * JD-Core Version:    0.7.0.1
 */