package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afm
  extends cqk
{
  public afp ExI;
  public afj ExJ;
  public afk ExK;
  public String ExL;
  public int ExM;
  public int ExN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ExI != null)
      {
        paramVarArgs.ln(2, this.ExI.computeSize());
        this.ExI.writeFields(paramVarArgs);
      }
      if (this.ExJ != null)
      {
        paramVarArgs.ln(3, this.ExJ.computeSize());
        this.ExJ.writeFields(paramVarArgs);
      }
      if (this.ExK != null)
      {
        paramVarArgs.ln(4, this.ExK.computeSize());
        this.ExK.writeFields(paramVarArgs);
      }
      if (this.ExL != null) {
        paramVarArgs.d(5, this.ExL);
      }
      paramVarArgs.aR(6, this.ExM);
      paramVarArgs.aR(7, this.ExN);
      AppMethodBeat.o(32202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label991;
      }
    }
    label991:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ExI != null) {
        paramInt = i + f.a.a.a.lm(2, this.ExI.computeSize());
      }
      i = paramInt;
      if (this.ExJ != null) {
        i = paramInt + f.a.a.a.lm(3, this.ExJ.computeSize());
      }
      paramInt = i;
      if (this.ExK != null) {
        paramInt = i + f.a.a.a.lm(4, this.ExK.computeSize());
      }
      i = paramInt;
      if (this.ExL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ExL);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.ExM);
      int j = f.a.a.b.b.a.bx(7, this.ExN);
      AppMethodBeat.o(32202);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afm localafm = (afm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32202);
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
            localafm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafm.ExI = ((afp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafm.ExJ = ((afj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafm.ExK = ((afk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 5: 
          localafm.ExL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32202);
          return 0;
        case 6: 
          localafm.ExM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32202);
          return 0;
        }
        localafm.ExN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32202);
        return 0;
      }
      AppMethodBeat.o(32202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afm
 * JD-Core Version:    0.7.0.1
 */