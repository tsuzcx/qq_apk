package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axi
  extends cvp
{
  public lx GvA;
  public long Gvx;
  public com.tencent.mm.bx.b Gvy;
  public ccd Gvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104368);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104368);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Gvx);
      if (this.Gvy != null) {
        paramVarArgs.c(3, this.Gvy);
      }
      if (this.Gvz != null)
      {
        paramVarArgs.lC(4, this.Gvz.computeSize());
        this.Gvz.writeFields(paramVarArgs);
      }
      if (this.GvA != null)
      {
        paramVarArgs.lC(5, this.GvA.computeSize());
        this.GvA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gvx);
      paramInt = i;
      if (this.Gvy != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Gvy);
      }
      i = paramInt;
      if (this.Gvz != null) {
        i = paramInt + f.a.a.a.lB(4, this.Gvz.computeSize());
      }
      paramInt = i;
      if (this.GvA != null) {
        paramInt = i + f.a.a.a.lB(5, this.GvA.computeSize());
      }
      AppMethodBeat.o(104368);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104368);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axi localaxi = (axi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104368);
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
            localaxi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 2: 
          localaxi.Gvx = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(104368);
          return 0;
        case 3: 
          localaxi.Gvy = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(104368);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxi.Gvz = ((ccd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaxi.GvA = ((lx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104368);
        return 0;
      }
      AppMethodBeat.o(104368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axi
 * JD-Core Version:    0.7.0.1
 */