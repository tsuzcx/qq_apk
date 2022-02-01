package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class apo
  extends cld
{
  public int CtB;
  public int Ctn;
  public int Ctr;
  public String Cts;
  public ctl Ctt;
  public hj rky;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32220);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32220);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ctr);
      paramVarArgs.aR(3, this.CtB);
      if (this.Cts != null) {
        paramVarArgs.d(4, this.Cts);
      }
      if (this.Ctt != null)
      {
        paramVarArgs.kX(5, this.Ctt.computeSize());
        this.Ctt.writeFields(paramVarArgs);
      }
      if (this.rky != null)
      {
        paramVarArgs.kX(6, this.rky.computeSize());
        this.rky.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Ctn);
      AppMethodBeat.o(32220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label875;
      }
    }
    label875:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ctr) + f.a.a.b.b.a.bA(3, this.CtB);
      paramInt = i;
      if (this.Cts != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cts);
      }
      i = paramInt;
      if (this.Ctt != null) {
        i = paramInt + f.a.a.a.kW(5, this.Ctt.computeSize());
      }
      paramInt = i;
      if (this.rky != null) {
        paramInt = i + f.a.a.a.kW(6, this.rky.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.Ctn);
      AppMethodBeat.o(32220);
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
          AppMethodBeat.o(32220);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32220);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apo localapo = (apo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32220);
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
            localapo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 2: 
          localapo.Ctr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32220);
          return 0;
        case 3: 
          localapo.CtB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32220);
          return 0;
        case 4: 
          localapo.Cts = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32220);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapo.Ctt = ((ctl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapo.rky = ((hj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        }
        localapo.Ctn = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32220);
        return 0;
      }
      AppMethodBeat.o(32220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apo
 * JD-Core Version:    0.7.0.1
 */