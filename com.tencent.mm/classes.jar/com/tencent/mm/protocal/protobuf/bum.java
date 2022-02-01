package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bum
  extends cld
{
  public bmv DRF;
  public String DRG;
  public afu DRH;
  public int ntx;
  public String nty;
  public String zEM;
  public String zEN;
  public String zEO;
  public int zEP;
  public String zEQ;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91559);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.DRF != null)
      {
        paramVarArgs.kX(4, this.DRF.computeSize());
        this.DRF.writeFields(paramVarArgs);
      }
      if (this.zEM != null) {
        paramVarArgs.d(5, this.zEM);
      }
      if (this.zEN != null) {
        paramVarArgs.d(6, this.zEN);
      }
      if (this.zEO != null) {
        paramVarArgs.d(7, this.zEO);
      }
      paramVarArgs.aR(8, this.zEP);
      if (this.zEQ != null) {
        paramVarArgs.d(9, this.zEQ);
      }
      if (this.DRG != null) {
        paramVarArgs.d(10, this.DRG);
      }
      if (this.DRH != null)
      {
        paramVarArgs.kX(11, this.DRH.computeSize());
        this.DRH.writeFields(paramVarArgs);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.DRF != null) {
        i = paramInt + f.a.a.a.kW(4, this.DRF.computeSize());
      }
      paramInt = i;
      if (this.zEM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zEM);
      }
      i = paramInt;
      if (this.zEN != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.zEN);
      }
      paramInt = i;
      if (this.zEO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.zEO);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.zEP);
      paramInt = i;
      if (this.zEQ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.zEQ);
      }
      i = paramInt;
      if (this.DRG != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DRG);
      }
      paramInt = i;
      if (this.DRH != null) {
        paramInt = i + f.a.a.a.kW(11, this.DRH.computeSize());
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91559);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bum localbum = (bum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91559);
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
            localbum.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 2: 
          localbum.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91559);
          return 0;
        case 3: 
          localbum.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbum.DRF = ((bmv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 5: 
          localbum.zEM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 6: 
          localbum.zEN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 7: 
          localbum.zEO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 8: 
          localbum.zEP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91559);
          return 0;
        case 9: 
          localbum.zEQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 10: 
          localbum.DRG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbum.DRH = ((afu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        }
        localbum.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91559);
        return 0;
      }
      AppMethodBeat.o(91559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bum
 * JD-Core Version:    0.7.0.1
 */