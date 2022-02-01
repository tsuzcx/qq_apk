package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tc
  extends cld
{
  public String CUD;
  public String CUJ;
  public String CUM;
  public String CUO;
  public String CUP;
  public String CUS;
  public String CUT;
  public String CUU;
  public LinkedList<Integer> CUr;
  public int CUt;
  public int dcG;
  public String desc;
  public String nTK;
  public String vAM;
  
  public tc()
  {
    AppMethodBeat.i(72440);
    this.CUr = new LinkedList();
    AppMethodBeat.o(72440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.CUJ != null) {
        paramVarArgs.d(4, this.CUJ);
      }
      paramVarArgs.e(5, 2, this.CUr);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      if (this.CUS != null) {
        paramVarArgs.d(7, this.CUS);
      }
      if (this.vAM != null) {
        paramVarArgs.d(8, this.vAM);
      }
      if (this.CUM != null) {
        paramVarArgs.d(9, this.CUM);
      }
      if (this.CUO != null) {
        paramVarArgs.d(10, this.CUO);
      }
      if (this.CUP != null) {
        paramVarArgs.d(11, this.CUP);
      }
      paramVarArgs.aR(12, this.CUt);
      if (this.CUD != null) {
        paramVarArgs.d(13, this.CUD);
      }
      if (this.CUT != null) {
        paramVarArgs.d(14, this.CUT);
      }
      if (this.CUU != null) {
        paramVarArgs.d(15, this.CUU);
      }
      AppMethodBeat.o(72441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1189;
      }
    }
    label1189:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.CUJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CUJ);
      }
      i += f.a.a.a.c(5, 2, this.CUr);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt;
      if (this.CUS != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CUS);
      }
      paramInt = i;
      if (this.vAM != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.vAM);
      }
      i = paramInt;
      if (this.CUM != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CUM);
      }
      paramInt = i;
      if (this.CUO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CUO);
      }
      i = paramInt;
      if (this.CUP != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CUP);
      }
      i += f.a.a.b.b.a.bA(12, this.CUt);
      paramInt = i;
      if (this.CUD != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CUD);
      }
      i = paramInt;
      if (this.CUT != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.CUT);
      }
      paramInt = i;
      if (this.CUU != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CUU);
      }
      AppMethodBeat.o(72441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CUr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tc localtc = (tc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72441);
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
            localtc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72441);
          return 0;
        case 2: 
          localtc.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72441);
          return 0;
        case 3: 
          localtc.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 4: 
          localtc.CUJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 5: 
          localtc.CUr.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(72441);
          return 0;
        case 6: 
          localtc.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 7: 
          localtc.CUS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 8: 
          localtc.vAM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 9: 
          localtc.CUM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 10: 
          localtc.CUO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 11: 
          localtc.CUP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 12: 
          localtc.CUt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72441);
          return 0;
        case 13: 
          localtc.CUD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 14: 
          localtc.CUT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72441);
          return 0;
        }
        localtc.CUU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72441);
        return 0;
      }
      AppMethodBeat.o(72441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tc
 * JD-Core Version:    0.7.0.1
 */