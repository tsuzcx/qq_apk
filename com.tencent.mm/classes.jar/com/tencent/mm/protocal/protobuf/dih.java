package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dih
  extends cld
{
  public int CJI;
  public int CLA;
  public int CNt;
  public int COU;
  public int CreateTime;
  public String CyF;
  public int DcP;
  public int hno;
  public String sdP;
  public String sdQ;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148662);
        throw paramVarArgs;
      }
      if (this.sdQ != null) {
        paramVarArgs.d(1, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(2, this.sdP);
      }
      paramVarArgs.aR(3, this.CNt);
      paramVarArgs.aR(4, this.CJI);
      paramVarArgs.aR(5, this.CreateTime);
      if (this.CyF != null) {
        paramVarArgs.d(6, this.CyF);
      }
      paramVarArgs.aR(7, this.uKX);
      paramVarArgs.aR(8, this.CLA);
      paramVarArgs.aR(9, this.hno);
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.DcP);
      paramVarArgs.aG(12, this.uKZ);
      paramVarArgs.aR(13, this.COU);
      AppMethodBeat.o(148662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdQ == null) {
        break label946;
      }
    }
    label946:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdP);
      }
      i = i + f.a.a.b.b.a.bA(3, this.CNt) + f.a.a.b.b.a.bA(4, this.CJI) + f.a.a.b.b.a.bA(5, this.CreateTime);
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CyF);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.uKX) + f.a.a.b.b.a.bA(8, this.CLA) + f.a.a.b.b.a.bA(9, this.hno);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.kW(10, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bA(11, this.DcP);
      int j = f.a.a.b.b.a.q(12, this.uKZ);
      int k = f.a.a.b.b.a.bA(13, this.COU);
      AppMethodBeat.o(148662);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(148662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dih localdih = (dih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148662);
          return -1;
        case 1: 
          localdih.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 2: 
          localdih.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 3: 
          localdih.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148662);
          return 0;
        case 4: 
          localdih.CJI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148662);
          return 0;
        case 5: 
          localdih.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148662);
          return 0;
        case 6: 
          localdih.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 7: 
          localdih.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148662);
          return 0;
        case 8: 
          localdih.CLA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148662);
          return 0;
        case 9: 
          localdih.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148662);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdih.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148662);
          return 0;
        case 11: 
          localdih.DcP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148662);
          return 0;
        case 12: 
          localdih.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(148662);
          return 0;
        }
        localdih.COU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148662);
        return 0;
      }
      AppMethodBeat.o(148662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dih
 * JD-Core Version:    0.7.0.1
 */