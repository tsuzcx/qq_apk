package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egj
  extends esc
{
  public int YME;
  public String YMF;
  public String Zbg;
  public int aatP;
  public LinkedList<aou> ablJ;
  public LinkedList<be> ablK;
  public int ablL;
  
  public egj()
  {
    AppMethodBeat.i(91628);
    this.ablJ = new LinkedList();
    this.ablK = new LinkedList();
    AppMethodBeat.o(91628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91629);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aatP);
      paramVarArgs.e(3, 8, this.ablJ);
      if (this.Zbg != null) {
        paramVarArgs.g(4, this.Zbg);
      }
      paramVarArgs.bS(5, this.YME);
      if (this.YMF != null) {
        paramVarArgs.g(6, this.YMF);
      }
      paramVarArgs.e(7, 8, this.ablK);
      paramVarArgs.bS(8, this.ablL);
      AppMethodBeat.o(91629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aatP) + i.a.a.a.c(3, 8, this.ablJ);
      paramInt = i;
      if (this.Zbg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zbg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YME);
      paramInt = i;
      if (this.YMF != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YMF);
      }
      i = i.a.a.a.c(7, 8, this.ablK);
      int j = i.a.a.b.b.a.cJ(8, this.ablL);
      AppMethodBeat.o(91629);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ablJ.clear();
        this.ablK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        egj localegj = (egj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91629);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localegj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 2: 
          localegj.aatP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91629);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aou();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aou)localObject2).parseFrom((byte[])localObject1);
            }
            localegj.ablJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 4: 
          localegj.Zbg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 5: 
          localegj.YME = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91629);
          return 0;
        case 6: 
          localegj.YMF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new be();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((be)localObject2).parseFrom((byte[])localObject1);
            }
            localegj.ablK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        }
        localegj.ablL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91629);
        return 0;
      }
      AppMethodBeat.o(91629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egj
 * JD-Core Version:    0.7.0.1
 */