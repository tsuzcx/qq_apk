package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpp
  extends cvp
{
  public String FpY;
  public String FvI;
  public String HDA;
  public String HDC;
  public int HDD;
  public int HDE;
  public ctf HDF;
  public yn HDG;
  public ctg HDH;
  public String HDI;
  public ctf HDh;
  public String HDl;
  public String dve;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aS(4, this.HDD);
      if (this.HDh != null)
      {
        paramVarArgs.lC(5, this.HDh.computeSize());
        this.HDh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HDE);
      if (this.HDF != null)
      {
        paramVarArgs.lC(7, this.HDF.computeSize());
        this.HDF.writeFields(paramVarArgs);
      }
      if (this.HDG != null)
      {
        paramVarArgs.lC(8, this.HDG.computeSize());
        this.HDG.writeFields(paramVarArgs);
      }
      if (this.HDH != null)
      {
        paramVarArgs.lC(9, this.HDH.computeSize());
        this.HDH.writeFields(paramVarArgs);
      }
      if (this.dve != null) {
        paramVarArgs.d(10, this.dve);
      }
      if (this.FpY != null) {
        paramVarArgs.d(11, this.FpY);
      }
      if (this.FvI != null) {
        paramVarArgs.d(12, this.FvI);
      }
      if (this.HDA != null) {
        paramVarArgs.d(13, this.HDA);
      }
      if (this.HDI != null) {
        paramVarArgs.d(14, this.HDI);
      }
      if (this.HDC != null) {
        paramVarArgs.d(15, this.HDC);
      }
      if (this.HDl != null) {
        paramVarArgs.d(16, this.HDl);
      }
      AppMethodBeat.o(72608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1562;
      }
    }
    label1562:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HDD);
      paramInt = i;
      if (this.HDh != null) {
        paramInt = i + f.a.a.a.lB(5, this.HDh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HDE);
      paramInt = i;
      if (this.HDF != null) {
        paramInt = i + f.a.a.a.lB(7, this.HDF.computeSize());
      }
      i = paramInt;
      if (this.HDG != null) {
        i = paramInt + f.a.a.a.lB(8, this.HDG.computeSize());
      }
      paramInt = i;
      if (this.HDH != null) {
        paramInt = i + f.a.a.a.lB(9, this.HDH.computeSize());
      }
      i = paramInt;
      if (this.dve != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dve);
      }
      paramInt = i;
      if (this.FpY != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FpY);
      }
      i = paramInt;
      if (this.FvI != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FvI);
      }
      paramInt = i;
      if (this.HDA != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HDA);
      }
      i = paramInt;
      if (this.HDI != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HDI);
      }
      paramInt = i;
      if (this.HDC != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.HDC);
      }
      i = paramInt;
      if (this.HDl != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.HDl);
      }
      AppMethodBeat.o(72608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpp localdpp = (dpp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72608);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 2: 
          localdpp.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72608);
          return 0;
        case 3: 
          localdpp.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 4: 
          localdpp.HDD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72608);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpp.HDh = ((ctf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 6: 
          localdpp.HDE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72608);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpp.HDF = ((ctf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpp.HDG = ((yn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpp.HDH = ((ctg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 10: 
          localdpp.dve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 11: 
          localdpp.FpY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 12: 
          localdpp.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 13: 
          localdpp.HDA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 14: 
          localdpp.HDI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 15: 
          localdpp.HDC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72608);
          return 0;
        }
        localdpp.HDl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72608);
        return 0;
      }
      AppMethodBeat.o(72608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpp
 * JD-Core Version:    0.7.0.1
 */