package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbp
  extends cwj
{
  public int FNv;
  public String GRA;
  public int GRB;
  public int GRC;
  public LinkedList<Integer> GRD;
  public LinkedList<ahv> GRE;
  public int GRF;
  
  public bbp()
  {
    AppMethodBeat.i(196263);
    this.GRD = new LinkedList();
    this.GRE = new LinkedList();
    AppMethodBeat.o(196263);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196264);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(196264);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GRB);
      paramVarArgs.aS(3, this.GRC);
      paramVarArgs.aS(4, this.FNv);
      paramVarArgs.e(5, 2, this.GRD);
      paramVarArgs.e(6, 8, this.GRE);
      paramVarArgs.aS(7, this.GRF);
      if (this.GRA != null) {
        paramVarArgs.d(8, this.GRA);
      }
      AppMethodBeat.o(196264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label793;
      }
    }
    label793:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GRB) + f.a.a.b.b.a.bz(3, this.GRC) + f.a.a.b.b.a.bz(4, this.FNv) + f.a.a.a.c(5, 2, this.GRD) + f.a.a.a.c(6, 8, this.GRE) + f.a.a.b.b.a.bz(7, this.GRF);
      paramInt = i;
      if (this.GRA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GRA);
      }
      AppMethodBeat.o(196264);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GRD.clear();
        this.GRE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(196264);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196264);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbp localbbp = (bbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196264);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196264);
          return 0;
        case 2: 
          localbbp.GRB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196264);
          return 0;
        case 3: 
          localbbp.GRC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196264);
          return 0;
        case 4: 
          localbbp.FNv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196264);
          return 0;
        case 5: 
          localbbp.GRD.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(196264);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbp.GRE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196264);
          return 0;
        case 7: 
          localbbp.GRF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196264);
          return 0;
        }
        localbbp.GRA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(196264);
        return 0;
      }
      AppMethodBeat.o(196264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbp
 * JD-Core Version:    0.7.0.1
 */