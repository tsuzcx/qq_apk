package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aga
  extends cvp
{
  public bor FEc;
  public pv FEd;
  public ccc FEe;
  public deh Fze;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155403);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xbo != null) {
        paramVarArgs.d(2, this.xbo);
      }
      if (this.FEd != null)
      {
        paramVarArgs.lC(3, this.FEd.computeSize());
        this.FEd.writeFields(paramVarArgs);
      }
      if (this.FEc != null)
      {
        paramVarArgs.lC(4, this.FEc.computeSize());
        this.FEc.writeFields(paramVarArgs);
      }
      if (this.Fze != null)
      {
        paramVarArgs.lC(5, this.Fze.computeSize());
        this.Fze.writeFields(paramVarArgs);
      }
      if (this.FEe != null)
      {
        paramVarArgs.lC(6, this.FEe.computeSize());
        this.FEe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xbo);
      }
      i = paramInt;
      if (this.FEd != null) {
        i = paramInt + f.a.a.a.lB(3, this.FEd.computeSize());
      }
      paramInt = i;
      if (this.FEc != null) {
        paramInt = i + f.a.a.a.lB(4, this.FEc.computeSize());
      }
      i = paramInt;
      if (this.Fze != null) {
        i = paramInt + f.a.a.a.lB(5, this.Fze.computeSize());
      }
      paramInt = i;
      if (this.FEe != null) {
        paramInt = i + f.a.a.a.lB(6, this.FEe.computeSize());
      }
      AppMethodBeat.o(155403);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155403);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aga localaga = (aga)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155403);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaga.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 2: 
          localaga.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155403);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaga.FEd = ((pv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bor();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bor)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaga.FEc = ((bor)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaga.Fze = ((deh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaga.FEe = ((ccc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      AppMethodBeat.o(155403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aga
 * JD-Core Version:    0.7.0.1
 */