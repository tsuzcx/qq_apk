package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebk
  extends erp
{
  public String IKJ;
  public String IcK;
  public bi Zbi;
  public String ZjI;
  public String ZjJ;
  public String ZjK;
  public String ZjL;
  public String aalO;
  public String abgX;
  public String abgY;
  public String abgZ;
  public String abha;
  public String abhb;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91571);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.abgX != null) {
        paramVarArgs.g(3, this.abgX);
      }
      if (this.aalO != null) {
        paramVarArgs.g(4, this.aalO);
      }
      if (this.ZjI != null) {
        paramVarArgs.g(5, this.ZjI);
      }
      if (this.abgY != null) {
        paramVarArgs.g(6, this.abgY);
      }
      if (this.ZjJ != null) {
        paramVarArgs.g(7, this.ZjJ);
      }
      if (this.ZjK != null) {
        paramVarArgs.g(8, this.ZjK);
      }
      if (this.ZjL != null) {
        paramVarArgs.g(9, this.ZjL);
      }
      if (this.abgZ != null) {
        paramVarArgs.g(10, this.abgZ);
      }
      if (this.Zbi != null)
      {
        paramVarArgs.qD(11, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      if (this.abha != null) {
        paramVarArgs.g(12, this.abha);
      }
      if (this.IcK != null) {
        paramVarArgs.g(13, this.IcK);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(14, this.IKJ);
      }
      if (this.abhb != null) {
        paramVarArgs.g(15, this.abhb);
      }
      AppMethodBeat.o(91571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1218;
      }
    }
    label1218:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.abgX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abgX);
      }
      paramInt = i;
      if (this.aalO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aalO);
      }
      i = paramInt;
      if (this.ZjI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjI);
      }
      paramInt = i;
      if (this.abgY != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abgY);
      }
      i = paramInt;
      if (this.ZjJ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZjJ);
      }
      paramInt = i;
      if (this.ZjK != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZjK);
      }
      i = paramInt;
      if (this.ZjL != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZjL);
      }
      paramInt = i;
      if (this.abgZ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abgZ);
      }
      i = paramInt;
      if (this.Zbi != null) {
        i = paramInt + i.a.a.a.qC(11, this.Zbi.computeSize());
      }
      paramInt = i;
      if (this.abha != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abha);
      }
      i = paramInt;
      if (this.IcK != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.IcK);
      }
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.IKJ);
      }
      i = paramInt;
      if (this.abhb != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.abhb);
      }
      AppMethodBeat.o(91571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ebk localebk = (ebk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91571);
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
            localebk.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 2: 
          localebk.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 3: 
          localebk.abgX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 4: 
          localebk.aalO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 5: 
          localebk.ZjI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 6: 
          localebk.abgY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 7: 
          localebk.ZjJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 8: 
          localebk.ZjK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 9: 
          localebk.ZjL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 10: 
          localebk.abgZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bi)localObject2).parseFrom((byte[])localObject1);
            }
            localebk.Zbi = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 12: 
          localebk.abha = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 13: 
          localebk.IcK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 14: 
          localebk.IKJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91571);
          return 0;
        }
        localebk.abhb = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91571);
        return 0;
      }
      AppMethodBeat.o(91571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebk
 * JD-Core Version:    0.7.0.1
 */