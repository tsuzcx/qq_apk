package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dww
  extends esc
{
  public String YNJ;
  public eff YNL;
  public String abcG;
  public boolean abcH;
  public boolean abcI;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72529);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72529);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.abcG != null) {
        paramVarArgs.g(4, this.abcG);
      }
      if (this.YNJ != null) {
        paramVarArgs.g(7, this.YNJ);
      }
      if (this.YNL != null)
      {
        paramVarArgs.qD(8, this.YNL.computeSize());
        this.YNL.writeFields(paramVarArgs);
      }
      paramVarArgs.di(9, this.abcH);
      paramVarArgs.di(10, this.abcI);
      AppMethodBeat.o(72529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abcG != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abcG);
      }
      paramInt = i;
      if (this.YNJ != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YNJ);
      }
      i = paramInt;
      if (this.YNL != null) {
        i = paramInt + i.a.a.a.qC(8, this.YNL.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(9);
      int j = i.a.a.b.b.a.ko(10);
      AppMethodBeat.o(72529);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dww localdww = (dww)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(72529);
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
            localdww.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 2: 
          localdww.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72529);
          return 0;
        case 3: 
          localdww.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 4: 
          localdww.abcG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 7: 
          localdww.YNJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eff();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eff)localObject2).parseFrom((byte[])localObject1);
            }
            localdww.YNL = ((eff)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 9: 
          localdww.abcH = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72529);
          return 0;
        }
        localdww.abcI = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(72529);
        return 0;
      }
      AppMethodBeat.o(72529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dww
 * JD-Core Version:    0.7.0.1
 */