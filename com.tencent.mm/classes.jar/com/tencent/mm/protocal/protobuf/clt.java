package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class clt
  extends cqk
{
  public clq FyZ;
  public int Fzn;
  public int Fzo;
  public String Fzp;
  public String pIw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FyZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.FyZ != null)
      {
        paramVarArgs.ln(1, this.FyZ.computeSize());
        this.FyZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Fzn);
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pIw != null) {
        paramVarArgs.d(4, this.pIw);
      }
      paramVarArgs.aR(5, this.Fzo);
      if (this.Fzp != null) {
        paramVarArgs.d(6, this.Fzp);
      }
      AppMethodBeat.o(32404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FyZ == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lm(1, this.FyZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fzn);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lm(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.pIw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pIw);
      }
      i += f.a.a.b.b.a.bx(5, this.Fzo);
      paramInt = i;
      if (this.Fzp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fzp);
      }
      AppMethodBeat.o(32404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FyZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clt localclt = (clt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32404);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclt.FyZ = ((clq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 2: 
          localclt.Fzn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32404);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 4: 
          localclt.pIw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32404);
          return 0;
        case 5: 
          localclt.Fzo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32404);
          return 0;
        }
        localclt.Fzp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32404);
        return 0;
      }
      AppMethodBeat.o(32404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clt
 * JD-Core Version:    0.7.0.1
 */