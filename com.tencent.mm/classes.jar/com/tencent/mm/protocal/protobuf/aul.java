package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aul
  extends erp
{
  public String YIZ;
  public aur ZDQ;
  public b ZEP;
  public b ZEQ;
  public int ZER;
  public atz ZEc;
  public int scene;
  public int tab_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257889);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(3, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.tab_type);
      paramVarArgs.bS(5, this.scene);
      if (this.ZEP != null) {
        paramVarArgs.d(6, this.ZEP);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(7, this.ZEQ);
      }
      paramVarArgs.bS(8, this.ZER);
      if (this.YIZ != null) {
        paramVarArgs.g(9, this.YIZ);
      }
      AppMethodBeat.o(257889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label868;
      }
    }
    label868:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.ZDQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZDQ.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(4, this.tab_type) + i.a.a.b.b.a.cJ(5, this.scene);
      paramInt = i;
      if (this.ZEP != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.ZEP);
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.ZEQ);
      }
      i += i.a.a.b.b.a.cJ(8, this.ZER);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YIZ);
      }
      AppMethodBeat.o(257889);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aul localaul = (aul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257889);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localaul.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257889);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localaul.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257889);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aur)localObject2).parseFrom((byte[])localObject1);
            }
            localaul.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257889);
          return 0;
        case 4: 
          localaul.tab_type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257889);
          return 0;
        case 5: 
          localaul.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257889);
          return 0;
        case 6: 
          localaul.ZEP = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257889);
          return 0;
        case 7: 
          localaul.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257889);
          return 0;
        case 8: 
          localaul.ZER = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257889);
          return 0;
        }
        localaul.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257889);
        return 0;
      }
      AppMethodBeat.o(257889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aul
 * JD-Core Version:    0.7.0.1
 */