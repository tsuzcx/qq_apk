package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tw
  extends cld
{
  public String CAM;
  public int dcG;
  public String nTK;
  public String vuN;
  public String vuO;
  public String vuP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72453);
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
      if (this.vuN != null) {
        paramVarArgs.d(4, this.vuN);
      }
      if (this.vuO != null) {
        paramVarArgs.d(5, this.vuO);
      }
      if (this.vuP != null) {
        paramVarArgs.d(6, this.vuP);
      }
      if (this.CAM != null) {
        paramVarArgs.d(7, this.CAM);
      }
      AppMethodBeat.o(72453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.vuN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vuN);
      }
      paramInt = i;
      if (this.vuO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vuO);
      }
      i = paramInt;
      if (this.vuP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vuP);
      }
      paramInt = i;
      if (this.CAM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CAM);
      }
      AppMethodBeat.o(72453);
      return paramInt;
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
          AppMethodBeat.o(72453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tw localtw = (tw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72453);
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
            localtw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72453);
          return 0;
        case 2: 
          localtw.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72453);
          return 0;
        case 3: 
          localtw.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 4: 
          localtw.vuN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 5: 
          localtw.vuO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 6: 
          localtw.vuP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72453);
          return 0;
        }
        localtw.CAM = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72453);
        return 0;
      }
      AppMethodBeat.o(72453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tw
 * JD-Core Version:    0.7.0.1
 */