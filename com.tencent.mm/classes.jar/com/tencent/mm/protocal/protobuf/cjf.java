package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjf
  extends cvp
{
  public cji HcY;
  public ciu HcZ;
  public LinkedList<cit> Hda;
  public int Hdb;
  public int qel;
  public String qem;
  
  public cjf()
  {
    AppMethodBeat.i(91591);
    this.Hda = new LinkedList();
    AppMethodBeat.o(91591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qel);
      if (this.qem != null) {
        paramVarArgs.d(3, this.qem);
      }
      if (this.HcY != null)
      {
        paramVarArgs.lC(4, this.HcY.computeSize());
        this.HcY.writeFields(paramVarArgs);
      }
      if (this.HcZ != null)
      {
        paramVarArgs.lC(5, this.HcZ.computeSize());
        this.HcZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.Hda);
      paramVarArgs.aS(7, this.Hdb);
      AppMethodBeat.o(91592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qel);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qem);
      }
      i = paramInt;
      if (this.HcY != null) {
        i = paramInt + f.a.a.a.lB(4, this.HcY.computeSize());
      }
      paramInt = i;
      if (this.HcZ != null) {
        paramInt = i + f.a.a.a.lB(5, this.HcZ.computeSize());
      }
      i = f.a.a.a.c(6, 8, this.Hda);
      int j = f.a.a.b.b.a.bz(7, this.Hdb);
      AppMethodBeat.o(91592);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hda.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjf localcjf = (cjf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91592);
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
            localcjf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 2: 
          localcjf.qel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91592);
          return 0;
        case 3: 
          localcjf.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91592);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cji();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cji)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjf.HcY = ((cji)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjf.HcZ = ((ciu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cit();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cit)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjf.Hda.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        }
        localcjf.Hdb = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91592);
        return 0;
      }
      AppMethodBeat.o(91592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjf
 * JD-Core Version:    0.7.0.1
 */