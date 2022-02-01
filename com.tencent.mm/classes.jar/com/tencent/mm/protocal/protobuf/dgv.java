package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgv
  extends cvp
{
  public String Hve;
  public int OpCode;
  public int nDi;
  public LinkedList<dgt> nDj;
  public int zib;
  
  public dgv()
  {
    AppMethodBeat.i(125819);
    this.nDj = new LinkedList();
    AppMethodBeat.o(125819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125820);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      if (this.Hve != null) {
        paramVarArgs.d(3, this.Hve);
      }
      paramVarArgs.aS(4, this.nDi);
      paramVarArgs.e(5, 8, this.nDj);
      paramVarArgs.aS(6, this.zib);
      AppMethodBeat.o(125820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode);
      paramInt = i;
      if (this.Hve != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hve);
      }
      i = f.a.a.b.b.a.bz(4, this.nDi);
      int j = f.a.a.a.c(5, 8, this.nDj);
      int k = f.a.a.b.b.a.bz(6, this.zib);
      AppMethodBeat.o(125820);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nDj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgv localdgv = (dgv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125820);
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
            localdgv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        case 2: 
          localdgv.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125820);
          return 0;
        case 3: 
          localdgv.Hve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125820);
          return 0;
        case 4: 
          localdgv.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125820);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgv.nDj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        }
        localdgv.zib = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125820);
        return 0;
      }
      AppMethodBeat.o(125820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgv
 * JD-Core Version:    0.7.0.1
 */