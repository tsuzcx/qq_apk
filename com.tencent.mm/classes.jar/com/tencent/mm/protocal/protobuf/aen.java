package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aen
  extends cld
{
  public aeq DeC;
  public aek DeD;
  public ael DeE;
  public String DeF;
  public int DeG;
  public int DeH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DeC != null)
      {
        paramVarArgs.kX(2, this.DeC.computeSize());
        this.DeC.writeFields(paramVarArgs);
      }
      if (this.DeD != null)
      {
        paramVarArgs.kX(3, this.DeD.computeSize());
        this.DeD.writeFields(paramVarArgs);
      }
      if (this.DeE != null)
      {
        paramVarArgs.kX(4, this.DeE.computeSize());
        this.DeE.writeFields(paramVarArgs);
      }
      if (this.DeF != null) {
        paramVarArgs.d(5, this.DeF);
      }
      paramVarArgs.aR(6, this.DeG);
      paramVarArgs.aR(7, this.DeH);
      AppMethodBeat.o(32202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label991;
      }
    }
    label991:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DeC != null) {
        paramInt = i + f.a.a.a.kW(2, this.DeC.computeSize());
      }
      i = paramInt;
      if (this.DeD != null) {
        i = paramInt + f.a.a.a.kW(3, this.DeD.computeSize());
      }
      paramInt = i;
      if (this.DeE != null) {
        paramInt = i + f.a.a.a.kW(4, this.DeE.computeSize());
      }
      i = paramInt;
      if (this.DeF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DeF);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.DeG);
      int j = f.a.a.b.b.a.bA(7, this.DeH);
      AppMethodBeat.o(32202);
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
          AppMethodBeat.o(32202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aen localaen = (aen)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32202);
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
            localaen.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaen.DeC = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaen.DeD = ((aek)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ael();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ael)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaen.DeE = ((ael)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 5: 
          localaen.DeF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32202);
          return 0;
        case 6: 
          localaen.DeG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32202);
          return 0;
        }
        localaen.DeH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32202);
        return 0;
      }
      AppMethodBeat.o(32202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aen
 * JD-Core Version:    0.7.0.1
 */