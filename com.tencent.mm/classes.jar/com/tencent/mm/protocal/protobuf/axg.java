package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axg
  extends cvp
{
  public bph Gvs;
  public String Gvt;
  public bpc Gvu;
  public int result;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gvs != null)
      {
        paramVarArgs.lC(2, this.Gvs.computeSize());
        this.Gvs.writeFields(paramVarArgs);
      }
      if (this.Gvt != null) {
        paramVarArgs.d(3, this.Gvt);
      }
      if (this.Gvu != null)
      {
        paramVarArgs.lC(4, this.Gvu.computeSize());
        this.Gvu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.result);
      AppMethodBeat.o(82408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gvs != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gvs.computeSize());
      }
      i = paramInt;
      if (this.Gvt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gvt);
      }
      paramInt = i;
      if (this.Gvu != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gvu.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.result);
      AppMethodBeat.o(82408);
      return paramInt + i;
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
          AppMethodBeat.o(82408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axg localaxg = (axg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82408);
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
            localaxg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bph();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bph)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxg.Gvs = ((bph)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 3: 
          localaxg.Gvt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82408);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxg.Gvu = ((bpc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        }
        localaxg.result = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(82408);
        return 0;
      }
      AppMethodBeat.o(82408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axg
 * JD-Core Version:    0.7.0.1
 */