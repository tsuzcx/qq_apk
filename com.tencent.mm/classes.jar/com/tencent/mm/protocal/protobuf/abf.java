package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abf
  extends erp
{
  public String IcT;
  public String UserName;
  public int YFx;
  public String YNW;
  public bi Zbi;
  public String ZiL;
  public String ZjI;
  public String ZjJ;
  public String ZjK;
  public String ZjL;
  public int ZjM;
  public String ZjN;
  public int ZjO;
  public String ZjP;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91416);
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
      if (this.ZjI != null) {
        paramVarArgs.g(3, this.ZjI);
      }
      if (this.YNW != null) {
        paramVarArgs.g(4, this.YNW);
      }
      if (this.ZjJ != null) {
        paramVarArgs.g(5, this.ZjJ);
      }
      if (this.ZjK != null) {
        paramVarArgs.g(6, this.ZjK);
      }
      if (this.ZjL != null) {
        paramVarArgs.g(7, this.ZjL);
      }
      if (this.ZiL != null) {
        paramVarArgs.g(8, this.ZiL);
      }
      paramVarArgs.bS(9, this.ZjM);
      if (this.Zbi != null)
      {
        paramVarArgs.qD(10, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      if (this.ZjN != null) {
        paramVarArgs.g(11, this.ZjN);
      }
      if (this.UserName != null) {
        paramVarArgs.g(12, this.UserName);
      }
      if (this.IcT != null) {
        paramVarArgs.g(13, this.IcT);
      }
      paramVarArgs.bS(14, this.YFx);
      paramVarArgs.bS(15, this.ZjO);
      if (this.ZjP != null) {
        paramVarArgs.g(16, this.ZjP);
      }
      AppMethodBeat.o(91416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1230;
      }
    }
    label1230:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.ZjI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZjI);
      }
      paramInt = i;
      if (this.YNW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNW);
      }
      i = paramInt;
      if (this.ZjJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjJ);
      }
      paramInt = i;
      if (this.ZjK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZjK);
      }
      i = paramInt;
      if (this.ZjL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZjL);
      }
      paramInt = i;
      if (this.ZiL != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZiL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.ZjM);
      paramInt = i;
      if (this.Zbi != null) {
        paramInt = i + i.a.a.a.qC(10, this.Zbi.computeSize());
      }
      i = paramInt;
      if (this.ZjN != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZjN);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.UserName);
      }
      i = paramInt;
      if (this.IcT != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.IcT);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.YFx) + i.a.a.b.b.a.cJ(15, this.ZjO);
      paramInt = i;
      if (this.ZjP != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.ZjP);
      }
      AppMethodBeat.o(91416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        abf localabf = (abf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91416);
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
            localabf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 2: 
          localabf.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 3: 
          localabf.ZjI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 4: 
          localabf.YNW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 5: 
          localabf.ZjJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 6: 
          localabf.ZjK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 7: 
          localabf.ZjL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 8: 
          localabf.ZiL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 9: 
          localabf.ZjM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91416);
          return 0;
        case 10: 
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
            localabf.Zbi = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 11: 
          localabf.ZjN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 12: 
          localabf.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 13: 
          localabf.IcT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 14: 
          localabf.YFx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91416);
          return 0;
        case 15: 
          localabf.ZjO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91416);
          return 0;
        }
        localabf.ZjP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91416);
        return 0;
      }
      AppMethodBeat.o(91416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abf
 * JD-Core Version:    0.7.0.1
 */