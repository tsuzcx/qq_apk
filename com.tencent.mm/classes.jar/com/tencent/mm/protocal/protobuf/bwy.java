package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bwy
  extends cld
{
  public int DTp;
  public int DTq;
  public String DTr;
  public String DTs;
  public int DTt;
  public int DTu;
  public int dcG;
  public String iau;
  public String iav;
  public String nTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72539);
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
      paramVarArgs.aR(4, this.DTp);
      paramVarArgs.aR(5, this.DTq);
      if (this.iau != null) {
        paramVarArgs.d(6, this.iau);
      }
      if (this.iav != null) {
        paramVarArgs.d(7, this.iav);
      }
      if (this.DTr != null) {
        paramVarArgs.d(8, this.DTr);
      }
      if (this.DTs != null) {
        paramVarArgs.d(9, this.DTs);
      }
      paramVarArgs.aR(10, this.DTt);
      paramVarArgs.aR(11, this.DTu);
      AppMethodBeat.o(72539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DTp) + f.a.a.b.b.a.bA(5, this.DTq);
      paramInt = i;
      if (this.iau != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iau);
      }
      i = paramInt;
      if (this.iav != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iav);
      }
      paramInt = i;
      if (this.DTr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DTr);
      }
      i = paramInt;
      if (this.DTs != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DTs);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.DTt);
      int j = f.a.a.b.b.a.bA(11, this.DTu);
      AppMethodBeat.o(72539);
      return i + paramInt + j;
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
          AppMethodBeat.o(72539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwy localbwy = (bwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72539);
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
            localbwy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72539);
          return 0;
        case 2: 
          localbwy.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72539);
          return 0;
        case 3: 
          localbwy.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 4: 
          localbwy.DTp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72539);
          return 0;
        case 5: 
          localbwy.DTq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72539);
          return 0;
        case 6: 
          localbwy.iau = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 7: 
          localbwy.iav = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 8: 
          localbwy.DTr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 9: 
          localbwy.DTs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 10: 
          localbwy.DTt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72539);
          return 0;
        }
        localbwy.DTu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72539);
        return 0;
      }
      AppMethodBeat.o(72539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwy
 * JD-Core Version:    0.7.0.1
 */