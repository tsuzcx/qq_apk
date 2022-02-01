package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpj
  extends esc
{
  public eme Zgn;
  public int abPm;
  public epk abPn;
  public String wording;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72589);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.Zgn != null)
      {
        paramVarArgs.qD(4, this.Zgn.computeSize());
        this.Zgn.writeFields(paramVarArgs);
      }
      if (this.abPn != null)
      {
        paramVarArgs.qD(5, this.abPn.computeSize());
        this.abPn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abPm);
      if (this.wording != null) {
        paramVarArgs.g(7, this.wording);
      }
      AppMethodBeat.o(72589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.Zgn != null) {
        i = paramInt + i.a.a.a.qC(4, this.Zgn.computeSize());
      }
      paramInt = i;
      if (this.abPn != null) {
        paramInt = i + i.a.a.a.qC(5, this.abPn.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abPm);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.wording);
      }
      AppMethodBeat.o(72589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpj localfpj = (fpj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72589);
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
            localfpj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 2: 
          localfpj.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72589);
          return 0;
        case 3: 
          localfpj.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72589);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eme)localObject2).parseFrom((byte[])localObject1);
            }
            localfpj.Zgn = ((eme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epk)localObject2).parseFrom((byte[])localObject1);
            }
            localfpj.abPn = ((epk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 6: 
          localfpj.abPm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72589);
          return 0;
        }
        localfpj.wording = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72589);
        return 0;
      }
      AppMethodBeat.o(72589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpj
 * JD-Core Version:    0.7.0.1
 */