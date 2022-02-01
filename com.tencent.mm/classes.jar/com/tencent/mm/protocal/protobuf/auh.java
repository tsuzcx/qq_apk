package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class auh
  extends cld
{
  public long Dql;
  public String Duf;
  public pi Dug;
  public cs Duh;
  public int Dui;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114788);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114788);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.aG(3, this.Dql);
      if (this.Duh != null)
      {
        paramVarArgs.kX(4, this.Duh.computeSize());
        this.Duh.writeFields(paramVarArgs);
      }
      if (this.Duf != null) {
        paramVarArgs.d(5, this.Duf);
      }
      paramVarArgs.aR(6, this.Dui);
      if (this.Dug != null)
      {
        paramVarArgs.kX(7, this.Dug.computeSize());
        this.Dug.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode) + f.a.a.b.b.a.q(3, this.Dql);
      paramInt = i;
      if (this.Duh != null) {
        paramInt = i + f.a.a.a.kW(4, this.Duh.computeSize());
      }
      i = paramInt;
      if (this.Duf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Duf);
      }
      i += f.a.a.b.b.a.bA(6, this.Dui);
      paramInt = i;
      if (this.Dug != null) {
        paramInt = i + f.a.a.a.kW(7, this.Dug.computeSize());
      }
      AppMethodBeat.o(114788);
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
          AppMethodBeat.o(114788);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auh localauh = (auh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114788);
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
            localauh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 2: 
          localauh.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114788);
          return 0;
        case 3: 
          localauh.Dql = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(114788);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauh.Duh = ((cs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 5: 
          localauh.Duf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114788);
          return 0;
        case 6: 
          localauh.Dui = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114788);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localauh.Dug = ((pi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      AppMethodBeat.o(114788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auh
 * JD-Core Version:    0.7.0.1
 */