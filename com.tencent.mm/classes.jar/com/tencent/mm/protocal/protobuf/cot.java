package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cot
  extends cld
{
  public String COP;
  public int COU;
  public int CreateTime;
  public String CyF;
  public String hnC;
  public int mBH;
  public String sdP;
  public String sdQ;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32427);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32427);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(3, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(4, this.sdP);
      }
      paramVarArgs.aR(5, this.uKX);
      if (this.CyF != null) {
        paramVarArgs.d(6, this.CyF);
      }
      paramVarArgs.aR(7, this.CreateTime);
      paramVarArgs.aR(8, this.mBH);
      paramVarArgs.aG(9, this.uKZ);
      if (this.COP != null) {
        paramVarArgs.d(10, this.COP);
      }
      paramVarArgs.aR(12, this.COU);
      AppMethodBeat.o(32427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label911;
      }
    }
    label911:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.sdQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdQ);
      }
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sdP);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.uKX);
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CyF);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CreateTime) + f.a.a.b.b.a.bA(8, this.mBH) + f.a.a.b.b.a.q(9, this.uKZ);
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.COP);
      }
      i = f.a.a.b.b.a.bA(12, this.COU);
      AppMethodBeat.o(32427);
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
          AppMethodBeat.o(32427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cot localcot = (cot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(32427);
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
            localcot.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32427);
          return 0;
        case 2: 
          localcot.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 3: 
          localcot.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 4: 
          localcot.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 5: 
          localcot.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32427);
          return 0;
        case 6: 
          localcot.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 7: 
          localcot.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32427);
          return 0;
        case 8: 
          localcot.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32427);
          return 0;
        case 9: 
          localcot.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32427);
          return 0;
        case 10: 
          localcot.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32427);
          return 0;
        }
        localcot.COU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32427);
        return 0;
      }
      AppMethodBeat.o(32427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cot
 * JD-Core Version:    0.7.0.1
 */