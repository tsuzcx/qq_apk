package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdc
  extends cld
{
  public String DAA;
  public String DAB;
  public String DAC;
  public String DAD;
  public String DAE;
  public int DAe;
  public LinkedList<dpa> DAf;
  public String DAt;
  public String DAu;
  public String DAv;
  public String DAw;
  public String DAx;
  public String DAy;
  public dpg DAz;
  public String Desc;
  public String Title;
  public String sDZ;
  
  public bdc()
  {
    AppMethodBeat.i(32308);
    this.DAf = new LinkedList();
    AppMethodBeat.o(32308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32309);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32309);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DAt != null) {
        paramVarArgs.d(2, this.DAt);
      }
      if (this.sDZ != null) {
        paramVarArgs.d(3, this.sDZ);
      }
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(5, this.Desc);
      }
      if (this.DAu != null) {
        paramVarArgs.d(6, this.DAu);
      }
      if (this.DAv != null) {
        paramVarArgs.d(7, this.DAv);
      }
      if (this.DAw != null) {
        paramVarArgs.d(8, this.DAw);
      }
      if (this.DAx != null) {
        paramVarArgs.d(9, this.DAx);
      }
      if (this.DAy != null) {
        paramVarArgs.d(10, this.DAy);
      }
      if (this.DAz != null)
      {
        paramVarArgs.kX(11, this.DAz.computeSize());
        this.DAz.writeFields(paramVarArgs);
      }
      if (this.DAA != null) {
        paramVarArgs.d(12, this.DAA);
      }
      if (this.DAB != null) {
        paramVarArgs.d(13, this.DAB);
      }
      if (this.DAC != null) {
        paramVarArgs.d(14, this.DAC);
      }
      if (this.DAD != null) {
        paramVarArgs.d(15, this.DAD);
      }
      if (this.DAE != null) {
        paramVarArgs.d(16, this.DAE);
      }
      paramVarArgs.aR(17, this.DAe);
      paramVarArgs.e(18, 8, this.DAf);
      AppMethodBeat.o(32309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1590;
      }
    }
    label1590:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DAt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DAt);
      }
      i = paramInt;
      if (this.sDZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sDZ);
      }
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Desc);
      }
      paramInt = i;
      if (this.DAu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DAu);
      }
      i = paramInt;
      if (this.DAv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DAv);
      }
      paramInt = i;
      if (this.DAw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DAw);
      }
      i = paramInt;
      if (this.DAx != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DAx);
      }
      paramInt = i;
      if (this.DAy != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DAy);
      }
      i = paramInt;
      if (this.DAz != null) {
        i = paramInt + f.a.a.a.kW(11, this.DAz.computeSize());
      }
      paramInt = i;
      if (this.DAA != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DAA);
      }
      i = paramInt;
      if (this.DAB != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DAB);
      }
      paramInt = i;
      if (this.DAC != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DAC);
      }
      i = paramInt;
      if (this.DAD != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DAD);
      }
      paramInt = i;
      if (this.DAE != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DAE);
      }
      i = f.a.a.b.b.a.bA(17, this.DAe);
      int j = f.a.a.a.c(18, 8, this.DAf);
      AppMethodBeat.o(32309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DAf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32309);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdc localbdc = (bdc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32309);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 2: 
          localbdc.DAt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 3: 
          localbdc.sDZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 4: 
          localbdc.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 5: 
          localbdc.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 6: 
          localbdc.DAu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 7: 
          localbdc.DAv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 8: 
          localbdc.DAw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 9: 
          localbdc.DAx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 10: 
          localbdc.DAy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdc.DAz = ((dpg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 12: 
          localbdc.DAA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 13: 
          localbdc.DAB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 14: 
          localbdc.DAC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 15: 
          localbdc.DAD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 16: 
          localbdc.DAE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 17: 
          localbdc.DAe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32309);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbdc.DAf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      AppMethodBeat.o(32309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdc
 * JD-Core Version:    0.7.0.1
 */