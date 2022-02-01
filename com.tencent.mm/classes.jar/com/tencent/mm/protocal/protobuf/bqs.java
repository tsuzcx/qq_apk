package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqs
  extends cvp
{
  public bql GKP;
  public LinkedList<duo> GLg;
  public LinkedList<String> GLh;
  public String GLi;
  public LinkedList<bqx> GLj;
  
  public bqs()
  {
    AppMethodBeat.i(82440);
    this.GLg = new LinkedList();
    this.GLh = new LinkedList();
    this.GLj = new LinkedList();
    AppMethodBeat.o(82440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GKP != null)
      {
        paramVarArgs.lC(2, this.GKP.computeSize());
        this.GKP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.GLg);
      paramVarArgs.e(4, 1, this.GLh);
      if (this.GLi != null) {
        paramVarArgs.d(5, this.GLi);
      }
      paramVarArgs.e(6, 8, this.GLj);
      AppMethodBeat.o(82441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GKP != null) {
        i = paramInt + f.a.a.a.lB(2, this.GKP.computeSize());
      }
      i = i + f.a.a.a.c(3, 8, this.GLg) + f.a.a.a.c(4, 1, this.GLh);
      paramInt = i;
      if (this.GLi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GLi);
      }
      i = f.a.a.a.c(6, 8, this.GLj);
      AppMethodBeat.o(82441);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLg.clear();
        this.GLh.clear();
        this.GLj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqs localbqs = (bqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82441);
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
            localbqs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqs.GKP = ((bql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((duo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqs.GLg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 4: 
          localbqs.GLh.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(82441);
          return 0;
        case 5: 
          localbqs.GLi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82441);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbqs.GLj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      AppMethodBeat.o(82441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqs
 * JD-Core Version:    0.7.0.1
 */