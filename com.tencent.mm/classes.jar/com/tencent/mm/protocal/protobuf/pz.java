package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pz
  extends cld
{
  public String CCm;
  public String COE;
  public String COP;
  public int COU;
  public int CreateTime;
  public String CxC;
  public String sdP;
  public String sdQ;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152512);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.COE != null) {
        paramVarArgs.d(3, this.COE);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(4, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(5, this.sdP);
      }
      paramVarArgs.aR(9, this.CreateTime);
      paramVarArgs.aG(10, this.uKZ);
      if (this.COP != null) {
        paramVarArgs.d(11, this.COP);
      }
      if (this.CCm != null) {
        paramVarArgs.d(12, this.CCm);
      }
      if (this.CxC != null) {
        paramVarArgs.d(13, this.CxC);
      }
      paramVarArgs.aR(14, this.COU);
      AppMethodBeat.o(152512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.COE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.COE);
      }
      i = paramInt;
      if (this.sdQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sdQ);
      }
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sdP);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.CreateTime) + f.a.a.b.b.a.q(10, this.uKZ);
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.COP);
      }
      i = paramInt;
      if (this.CCm != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CCm);
      }
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CxC);
      }
      i = f.a.a.b.b.a.bA(14, this.COU);
      AppMethodBeat.o(152512);
      return paramInt + i;
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
          AppMethodBeat.o(152512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pz localpz = (pz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152512);
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
            localpz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152512);
          return 0;
        case 3: 
          localpz.COE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 4: 
          localpz.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 5: 
          localpz.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 9: 
          localpz.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152512);
          return 0;
        case 10: 
          localpz.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(152512);
          return 0;
        case 11: 
          localpz.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 12: 
          localpz.CCm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 13: 
          localpz.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152512);
          return 0;
        }
        localpz.COU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152512);
        return 0;
      }
      AppMethodBeat.o(152512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pz
 * JD-Core Version:    0.7.0.1
 */