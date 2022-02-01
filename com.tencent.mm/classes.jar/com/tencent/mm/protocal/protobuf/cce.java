package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cce
  extends cqk
{
  public String FqA;
  public cch FqE;
  public LinkedList<cce> FqF;
  public int FqG;
  public String type;
  public String vyz;
  
  public cce()
  {
    AppMethodBeat.i(117539);
    this.FqF = new LinkedList();
    AppMethodBeat.o(117539);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FqE != null)
      {
        paramVarArgs.ln(2, this.FqE.computeSize());
        this.FqE.writeFields(paramVarArgs);
      }
      if (this.FqA != null) {
        paramVarArgs.d(3, this.FqA);
      }
      if (this.vyz != null) {
        paramVarArgs.d(4, this.vyz);
      }
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.FqF);
      paramVarArgs.aR(7, this.FqG);
      AppMethodBeat.o(117540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FqE != null) {
        paramInt = i + f.a.a.a.lm(2, this.FqE.computeSize());
      }
      i = paramInt;
      if (this.FqA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FqA);
      }
      paramInt = i;
      if (this.vyz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vyz);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.type);
      }
      paramInt = f.a.a.a.c(6, 8, this.FqF);
      int j = f.a.a.b.b.a.bx(7, this.FqG);
      AppMethodBeat.o(117540);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FqF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cce localcce = (cce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117540);
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
            localcce.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cch();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcce.FqE = ((cch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 3: 
          localcce.FqA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 4: 
          localcce.vyz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 5: 
          localcce.type = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cce();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cce)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcce.FqF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        }
        localcce.FqG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117540);
        return 0;
      }
      AppMethodBeat.o(117540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cce
 * JD-Core Version:    0.7.0.1
 */