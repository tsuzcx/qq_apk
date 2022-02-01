package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csa
  extends cld
{
  public String dyd;
  public String gGR;
  public String gHT;
  public String nrr;
  public String nrs;
  public String nrt;
  public int nrv;
  public String nsK;
  public int ntg;
  public String title;
  public int wmo;
  public int wmr;
  public String wms;
  public String wmt;
  public String wmu;
  public String wmv;
  public String wmw;
  public boolean wmx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32439);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntg);
      if (this.nrr != null) {
        paramVarArgs.d(3, this.nrr);
      }
      if (this.dyd != null) {
        paramVarArgs.d(4, this.dyd);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.nrs != null) {
        paramVarArgs.d(6, this.nrs);
      }
      if (this.nrt != null) {
        paramVarArgs.d(7, this.nrt);
      }
      if (this.nsK != null) {
        paramVarArgs.d(8, this.nsK);
      }
      if (this.gGR != null) {
        paramVarArgs.d(9, this.gGR);
      }
      if (this.gHT != null) {
        paramVarArgs.d(10, this.gHT);
      }
      paramVarArgs.aR(11, this.wmo);
      paramVarArgs.aR(12, this.wmr);
      if (this.wms != null) {
        paramVarArgs.d(13, this.wms);
      }
      if (this.wmt != null) {
        paramVarArgs.d(14, this.wmt);
      }
      if (this.wmu != null) {
        paramVarArgs.d(19, this.wmu);
      }
      if (this.wmv != null) {
        paramVarArgs.d(21, this.wmv);
      }
      paramVarArgs.aR(22, this.nrv);
      if (this.wmw != null) {
        paramVarArgs.d(23, this.wmw);
      }
      paramVarArgs.bg(24, this.wmx);
      AppMethodBeat.o(32439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1431;
      }
    }
    label1431:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntg);
      paramInt = i;
      if (this.nrr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nrr);
      }
      i = paramInt;
      if (this.dyd != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dyd);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.nrs != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nrs);
      }
      paramInt = i;
      if (this.nrt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nrt);
      }
      i = paramInt;
      if (this.nsK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nsK);
      }
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.gGR);
      }
      i = paramInt;
      if (this.gHT != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.gHT);
      }
      i = i + f.a.a.b.b.a.bA(11, this.wmo) + f.a.a.b.b.a.bA(12, this.wmr);
      paramInt = i;
      if (this.wms != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.wms);
      }
      i = paramInt;
      if (this.wmt != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.wmt);
      }
      paramInt = i;
      if (this.wmu != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.wmu);
      }
      i = paramInt;
      if (this.wmv != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.wmv);
      }
      i += f.a.a.b.b.a.bA(22, this.nrv);
      paramInt = i;
      if (this.wmw != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.wmw);
      }
      i = f.a.a.b.b.a.fY(24);
      AppMethodBeat.o(32439);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(32439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csa localcsa = (csa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          AppMethodBeat.o(32439);
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
            localcsa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32439);
          return 0;
        case 2: 
          localcsa.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32439);
          return 0;
        case 3: 
          localcsa.nrr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 4: 
          localcsa.dyd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 5: 
          localcsa.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 6: 
          localcsa.nrs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 7: 
          localcsa.nrt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 8: 
          localcsa.nsK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 9: 
          localcsa.gGR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 10: 
          localcsa.gHT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 11: 
          localcsa.wmo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32439);
          return 0;
        case 12: 
          localcsa.wmr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32439);
          return 0;
        case 13: 
          localcsa.wms = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 14: 
          localcsa.wmt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 19: 
          localcsa.wmu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 21: 
          localcsa.wmv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 22: 
          localcsa.nrv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32439);
          return 0;
        case 23: 
          localcsa.wmw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32439);
          return 0;
        }
        localcsa.wmx = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(32439);
        return 0;
      }
      AppMethodBeat.o(32439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csa
 * JD-Core Version:    0.7.0.1
 */