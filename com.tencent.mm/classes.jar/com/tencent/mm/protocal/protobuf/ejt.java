package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejt
  extends esc
{
  public long Zqa;
  public esq aaFC;
  public long aaFI;
  public fnr aaqT;
  public String icon;
  public String nQV;
  public int tNW;
  public String wtN;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72558);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72558);
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
      if (this.nQV != null) {
        paramVarArgs.g(4, this.nQV);
      }
      paramVarArgs.bv(5, this.aaFI);
      paramVarArgs.bv(6, this.Zqa);
      if (this.aaFC != null)
      {
        paramVarArgs.qD(7, this.aaFC.computeSize());
        this.aaFC.writeFields(paramVarArgs);
      }
      if (this.aaqT != null)
      {
        paramVarArgs.qD(8, this.aaqT.computeSize());
        this.aaqT.writeFields(paramVarArgs);
      }
      if (this.wtN != null) {
        paramVarArgs.g(9, this.wtN);
      }
      paramVarArgs.bS(10, this.tNW);
      if (this.icon != null) {
        paramVarArgs.g(11, this.icon);
      }
      AppMethodBeat.o(72558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1024;
      }
    }
    label1024:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.nQV != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.nQV);
      }
      i = i + i.a.a.b.b.a.q(5, this.aaFI) + i.a.a.b.b.a.q(6, this.Zqa);
      paramInt = i;
      if (this.aaFC != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaFC.computeSize());
      }
      i = paramInt;
      if (this.aaqT != null) {
        i = paramInt + i.a.a.a.qC(8, this.aaqT.computeSize());
      }
      paramInt = i;
      if (this.wtN != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.wtN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.tNW);
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.icon);
      }
      AppMethodBeat.o(72558);
      return paramInt;
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
          AppMethodBeat.o(72558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejt localejt = (ejt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72558);
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
            localejt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 2: 
          localejt.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72558);
          return 0;
        case 3: 
          localejt.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 4: 
          localejt.nQV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 5: 
          localejt.aaFI = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(72558);
          return 0;
        case 6: 
          localejt.Zqa = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(72558);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esq)localObject2).parseFrom((byte[])localObject1);
            }
            localejt.aaFC = ((esq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnr)localObject2).parseFrom((byte[])localObject1);
            }
            localejt.aaqT = ((fnr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 9: 
          localejt.wtN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 10: 
          localejt.tNW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72558);
          return 0;
        }
        localejt.icon = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72558);
        return 0;
      }
      AppMethodBeat.o(72558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejt
 * JD-Core Version:    0.7.0.1
 */