package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class buo
  extends cld
{
  public boolean DIo;
  public bmv DRF;
  public String DRG;
  public afu DRH;
  public int DRI;
  public int DRJ;
  public int DRK;
  public LinkedList<aca> DRL;
  public LinkedList<cif> DRM;
  public LinkedList<if> DRN;
  public cba DRO;
  public int ntx;
  public String nty;
  public String zFY;
  
  public buo()
  {
    AppMethodBeat.i(91561);
    this.DRL = new LinkedList();
    this.DRM = new LinkedList();
    this.DRN = new LinkedList();
    AppMethodBeat.o(91561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91562);
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
      paramVarArgs.aR(4, this.DRI);
      paramVarArgs.aR(5, this.DRJ);
      paramVarArgs.aR(6, this.DRK);
      paramVarArgs.e(8, 8, this.DRL);
      if (this.DRF != null)
      {
        paramVarArgs.kX(9, this.DRF.computeSize());
        this.DRF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.DRM);
      paramVarArgs.e(11, 8, this.DRN);
      paramVarArgs.bg(12, this.DIo);
      if (this.DRO != null)
      {
        paramVarArgs.kX(13, this.DRO.computeSize());
        this.DRO.writeFields(paramVarArgs);
      }
      if (this.DRG != null) {
        paramVarArgs.d(14, this.DRG);
      }
      if (this.DRH != null)
      {
        paramVarArgs.kX(15, this.DRH.computeSize());
        this.DRH.writeFields(paramVarArgs);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1702;
      }
    }
    label1702:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DRI) + f.a.a.b.b.a.bA(5, this.DRJ) + f.a.a.b.b.a.bA(6, this.DRK) + f.a.a.a.c(8, 8, this.DRL);
      paramInt = i;
      if (this.DRF != null) {
        paramInt = i + f.a.a.a.kW(9, this.DRF.computeSize());
      }
      i = paramInt + f.a.a.a.c(10, 8, this.DRM) + f.a.a.a.c(11, 8, this.DRN) + (f.a.a.b.b.a.fY(12) + 1);
      paramInt = i;
      if (this.DRO != null) {
        paramInt = i + f.a.a.a.kW(13, this.DRO.computeSize());
      }
      i = paramInt;
      if (this.DRG != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DRG);
      }
      paramInt = i;
      if (this.DRH != null) {
        paramInt = i + f.a.a.a.kW(15, this.DRH.computeSize());
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRL.clear();
        this.DRM.clear();
        this.DRN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buo localbuo = (buo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91562);
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
            localbuo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 2: 
          localbuo.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91562);
          return 0;
        case 3: 
          localbuo.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 4: 
          localbuo.DRI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91562);
          return 0;
        case 5: 
          localbuo.DRJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91562);
          return 0;
        case 6: 
          localbuo.DRK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91562);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuo.DRL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuo.DRF = ((bmv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cif();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cif)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuo.DRM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new if();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((if)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuo.DRN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 12: 
          localbuo.DIo = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91562);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuo.DRO = ((cba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 14: 
          localbuo.DRG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuo.DRH = ((afu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        }
        localbuo.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91562);
        return 0;
      }
      AppMethodBeat.o(91562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buo
 * JD-Core Version:    0.7.0.1
 */