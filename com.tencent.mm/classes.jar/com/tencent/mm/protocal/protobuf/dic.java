package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dic
  extends cld
{
  public String COP;
  public int COU;
  public String CxC;
  public String CyF;
  public int DMp;
  public int Eyg;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127181);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127181);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CyF != null) {
        paramVarArgs.d(2, this.CyF);
      }
      paramVarArgs.aR(3, this.uKX);
      paramVarArgs.aR(4, this.DMp);
      paramVarArgs.aR(5, this.Eyg);
      paramVarArgs.aG(6, this.uKZ);
      if (this.COP != null) {
        paramVarArgs.d(7, this.COP);
      }
      if (this.CxC != null) {
        paramVarArgs.d(8, this.CxC);
      }
      paramVarArgs.aR(9, this.COU);
      AppMethodBeat.o(127181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CyF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CyF);
      }
      i = i + f.a.a.b.b.a.bA(3, this.uKX) + f.a.a.b.b.a.bA(4, this.DMp) + f.a.a.b.b.a.bA(5, this.Eyg) + f.a.a.b.b.a.q(6, this.uKZ);
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.COP);
      }
      i = paramInt;
      if (this.CxC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CxC);
      }
      paramInt = f.a.a.b.b.a.bA(9, this.COU);
      AppMethodBeat.o(127181);
      return i + paramInt;
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
          AppMethodBeat.o(127181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dic localdic = (dic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127181);
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
            localdic.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127181);
          return 0;
        case 2: 
          localdic.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 3: 
          localdic.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127181);
          return 0;
        case 4: 
          localdic.DMp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127181);
          return 0;
        case 5: 
          localdic.Eyg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127181);
          return 0;
        case 6: 
          localdic.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(127181);
          return 0;
        case 7: 
          localdic.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 8: 
          localdic.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127181);
          return 0;
        }
        localdic.COU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127181);
        return 0;
      }
      AppMethodBeat.o(127181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dic
 * JD-Core Version:    0.7.0.1
 */