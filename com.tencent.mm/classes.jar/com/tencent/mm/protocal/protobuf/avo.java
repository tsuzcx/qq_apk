package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avo
  extends cld
{
  public boolean DuT;
  public boolean DuU;
  public String DuV;
  public String DuW;
  public int DuX;
  public String DuY;
  public int DuZ;
  public String dyd;
  public String gGR;
  public String gHT;
  public String nrr;
  public String nrs;
  public String nrt;
  public int nrv;
  public String nsK;
  public String title;
  public int wmr;
  public String wms;
  public String wmt;
  public String wmu;
  public String wmw;
  public boolean wmx;
  public String zRV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32248);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32248);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.DuT);
      paramVarArgs.bg(3, this.DuU);
      if (this.DuV != null) {
        paramVarArgs.d(4, this.DuV);
      }
      if (this.DuW != null) {
        paramVarArgs.d(5, this.DuW);
      }
      paramVarArgs.aR(6, this.DuX);
      if (this.DuY != null) {
        paramVarArgs.d(7, this.DuY);
      }
      paramVarArgs.aR(8, this.DuZ);
      if (this.nrr != null) {
        paramVarArgs.d(9, this.nrr);
      }
      if (this.dyd != null) {
        paramVarArgs.d(10, this.dyd);
      }
      if (this.title != null) {
        paramVarArgs.d(11, this.title);
      }
      if (this.nrs != null) {
        paramVarArgs.d(12, this.nrs);
      }
      if (this.nrt != null) {
        paramVarArgs.d(13, this.nrt);
      }
      if (this.nsK != null) {
        paramVarArgs.d(14, this.nsK);
      }
      if (this.gGR != null) {
        paramVarArgs.d(15, this.gGR);
      }
      if (this.gHT != null) {
        paramVarArgs.d(16, this.gHT);
      }
      paramVarArgs.aR(17, this.wmr);
      if (this.wms != null) {
        paramVarArgs.d(18, this.wms);
      }
      if (this.wmt != null) {
        paramVarArgs.d(19, this.wmt);
      }
      if (this.wmu != null) {
        paramVarArgs.d(20, this.wmu);
      }
      paramVarArgs.aR(21, this.nrv);
      if (this.wmw != null) {
        paramVarArgs.d(22, this.wmw);
      }
      if (this.zRV != null) {
        paramVarArgs.d(23, this.zRV);
      }
      paramVarArgs.bg(24, this.wmx);
      AppMethodBeat.o(32248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1688;
      }
    }
    label1688:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 1) + (f.a.a.b.b.a.fY(3) + 1);
      paramInt = i;
      if (this.DuV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DuV);
      }
      i = paramInt;
      if (this.DuW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DuW);
      }
      i += f.a.a.b.b.a.bA(6, this.DuX);
      paramInt = i;
      if (this.DuY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DuY);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.DuZ);
      paramInt = i;
      if (this.nrr != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nrr);
      }
      i = paramInt;
      if (this.dyd != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dyd);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.title);
      }
      i = paramInt;
      if (this.nrs != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.nrs);
      }
      paramInt = i;
      if (this.nrt != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.nrt);
      }
      i = paramInt;
      if (this.nsK != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.nsK);
      }
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.gGR);
      }
      i = paramInt;
      if (this.gHT != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.gHT);
      }
      i += f.a.a.b.b.a.bA(17, this.wmr);
      paramInt = i;
      if (this.wms != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.wms);
      }
      i = paramInt;
      if (this.wmt != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.wmt);
      }
      paramInt = i;
      if (this.wmu != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.wmu);
      }
      i = paramInt + f.a.a.b.b.a.bA(21, this.nrv);
      paramInt = i;
      if (this.wmw != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.wmw);
      }
      i = paramInt;
      if (this.zRV != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.zRV);
      }
      paramInt = f.a.a.b.b.a.fY(24);
      AppMethodBeat.o(32248);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(32248);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32248);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avo localavo = (avo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32248);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32248);
          return 0;
        case 2: 
          localavo.DuT = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32248);
          return 0;
        case 3: 
          localavo.DuU = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32248);
          return 0;
        case 4: 
          localavo.DuV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 5: 
          localavo.DuW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 6: 
          localavo.DuX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32248);
          return 0;
        case 7: 
          localavo.DuY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 8: 
          localavo.DuZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32248);
          return 0;
        case 9: 
          localavo.nrr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 10: 
          localavo.dyd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 11: 
          localavo.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 12: 
          localavo.nrs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 13: 
          localavo.nrt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 14: 
          localavo.nsK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 15: 
          localavo.gGR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 16: 
          localavo.gHT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 17: 
          localavo.wmr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32248);
          return 0;
        case 18: 
          localavo.wms = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 19: 
          localavo.wmt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 20: 
          localavo.wmu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 21: 
          localavo.nrv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32248);
          return 0;
        case 22: 
          localavo.wmw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 23: 
          localavo.zRV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32248);
          return 0;
        }
        localavo.wmx = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(32248);
        return 0;
      }
      AppMethodBeat.o(32248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avo
 * JD-Core Version:    0.7.0.1
 */