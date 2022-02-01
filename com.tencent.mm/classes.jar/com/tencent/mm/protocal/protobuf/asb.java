package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class asb
  extends cqk
{
  public bla ELH;
  public blb ELI;
  public int dkl;
  public String dkm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72477);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dkl);
      if (this.dkm != null) {
        paramVarArgs.d(3, this.dkm);
      }
      if (this.ELH != null)
      {
        paramVarArgs.ln(4, this.ELH.computeSize());
        this.ELH.writeFields(paramVarArgs);
      }
      if (this.ELI != null)
      {
        paramVarArgs.ln(5, this.ELI.computeSize());
        this.ELI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dkl);
      paramInt = i;
      if (this.dkm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dkm);
      }
      i = paramInt;
      if (this.ELH != null) {
        i = paramInt + f.a.a.a.lm(4, this.ELH.computeSize());
      }
      paramInt = i;
      if (this.ELI != null) {
        paramInt = i + f.a.a.a.lm(5, this.ELI.computeSize());
      }
      AppMethodBeat.o(72477);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72477);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asb localasb = (asb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72477);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        case 2: 
          localasb.dkl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72477);
          return 0;
        case 3: 
          localasb.dkm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72477);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bla();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bla)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasb.ELH = ((bla)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasb.ELI = ((blb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      AppMethodBeat.o(72477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asb
 * JD-Core Version:    0.7.0.1
 */