package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dld
  extends cpx
{
  public String Ebl;
  public String Ebs;
  public mn FTV;
  public mn FTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebs == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124570);
        throw paramVarArgs;
      }
      if (this.Ebl == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(124570);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ebs != null) {
        paramVarArgs.d(2, this.Ebs);
      }
      if (this.Ebl != null) {
        paramVarArgs.d(3, this.Ebl);
      }
      if (this.FTV != null)
      {
        paramVarArgs.ln(4, this.FTV.computeSize());
        this.FTV.writeFields(paramVarArgs);
      }
      if (this.FTW != null)
      {
        paramVarArgs.ln(5, this.FTW.computeSize());
        this.FTW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ebs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ebs);
      }
      i = paramInt;
      if (this.Ebl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ebl);
      }
      paramInt = i;
      if (this.FTV != null) {
        paramInt = i + f.a.a.a.lm(4, this.FTV.computeSize());
      }
      i = paramInt;
      if (this.FTW != null) {
        i = paramInt + f.a.a.a.lm(5, this.FTW.computeSize());
      }
      AppMethodBeat.o(124570);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Ebs == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        if (this.Ebl == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dld localdld = (dld)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124570);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdld.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        case 2: 
          localdld.Ebs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 3: 
          localdld.Ebl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdld.FTV = ((mn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdld.FTW = ((mn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      AppMethodBeat.o(124570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dld
 * JD-Core Version:    0.7.0.1
 */