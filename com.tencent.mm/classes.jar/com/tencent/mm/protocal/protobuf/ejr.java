package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejr
  extends esc
{
  public String MDt;
  public String abok;
  public String abol;
  public vb abom;
  public String abon;
  public String aboo;
  public fou abop;
  public String hAk;
  public String nQG;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72556);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72556);
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
      if (this.abok != null) {
        paramVarArgs.g(4, this.abok);
      }
      if (this.nQG != null) {
        paramVarArgs.g(5, this.nQG);
      }
      if (this.abol != null) {
        paramVarArgs.g(6, this.abol);
      }
      if (this.abom != null)
      {
        paramVarArgs.qD(7, this.abom.computeSize());
        this.abom.writeFields(paramVarArgs);
      }
      if (this.abon != null) {
        paramVarArgs.g(8, this.abon);
      }
      if (this.MDt != null) {
        paramVarArgs.g(9, this.MDt);
      }
      if (this.hAk != null) {
        paramVarArgs.g(10, this.hAk);
      }
      if (this.aboo != null) {
        paramVarArgs.g(11, this.aboo);
      }
      if (this.abop != null)
      {
        paramVarArgs.qD(12, this.abop.computeSize());
        this.abop.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1136;
      }
    }
    label1136:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abok != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abok);
      }
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nQG);
      }
      i = paramInt;
      if (this.abol != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abol);
      }
      paramInt = i;
      if (this.abom != null) {
        paramInt = i + i.a.a.a.qC(7, this.abom.computeSize());
      }
      i = paramInt;
      if (this.abon != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abon);
      }
      paramInt = i;
      if (this.MDt != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.MDt);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.hAk);
      }
      paramInt = i;
      if (this.aboo != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aboo);
      }
      i = paramInt;
      if (this.abop != null) {
        i = paramInt + i.a.a.a.qC(12, this.abop.computeSize());
      }
      AppMethodBeat.o(72556);
      return i;
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
          AppMethodBeat.o(72556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejr localejr = (ejr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72556);
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
            localejr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 2: 
          localejr.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72556);
          return 0;
        case 3: 
          localejr.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 4: 
          localejr.abok = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 5: 
          localejr.nQG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 6: 
          localejr.abol = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vb)localObject2).parseFrom((byte[])localObject1);
            }
            localejr.abom = ((vb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 8: 
          localejr.abon = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 9: 
          localejr.MDt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 10: 
          localejr.hAk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 11: 
          localejr.aboo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72556);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fou();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fou)localObject2).parseFrom((byte[])localObject1);
          }
          localejr.abop = ((fou)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      AppMethodBeat.o(72556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejr
 * JD-Core Version:    0.7.0.1
 */