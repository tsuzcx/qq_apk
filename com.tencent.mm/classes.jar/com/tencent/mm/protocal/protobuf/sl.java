package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sl
  extends cqk
{
  public String Emr;
  public LinkedList<afr> Ems;
  public int Emt;
  public int dae;
  public String oxf;
  public String oxg;
  
  public sl()
  {
    AppMethodBeat.i(91401);
    this.Ems = new LinkedList();
    AppMethodBeat.o(91401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91402);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.Emr != null) {
        paramVarArgs.d(4, this.Emr);
      }
      if (this.oxg != null) {
        paramVarArgs.d(5, this.oxg);
      }
      paramVarArgs.e(6, 8, this.Ems);
      paramVarArgs.aR(7, this.Emt);
      AppMethodBeat.o(91402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.Emr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Emr);
      }
      paramInt = i;
      if (this.oxg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oxg);
      }
      i = f.a.a.a.c(6, 8, this.Ems);
      int j = f.a.a.b.b.a.bx(7, this.Emt);
      AppMethodBeat.o(91402);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ems.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sl localsl = (sl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91402);
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
            localsl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        case 2: 
          localsl.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91402);
          return 0;
        case 3: 
          localsl.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 4: 
          localsl.Emr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 5: 
          localsl.oxg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsl.Ems.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        }
        localsl.Emt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91402);
        return 0;
      }
      AppMethodBeat.o(91402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sl
 * JD-Core Version:    0.7.0.1
 */