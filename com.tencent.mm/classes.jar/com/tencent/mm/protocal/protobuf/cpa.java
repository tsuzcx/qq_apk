package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpa
  extends cpx
{
  public String Ebg;
  public LinkedList<String> EmotionList;
  public cou FBO;
  public cpq FBP;
  public int ndI;
  
  public cpa()
  {
    AppMethodBeat.i(115964);
    this.EmotionList = new LinkedList();
    AppMethodBeat.o(115964);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndI);
      if (this.FBO != null)
      {
        paramVarArgs.ln(3, this.FBO.computeSize());
        this.FBO.writeFields(paramVarArgs);
      }
      if (this.FBP != null)
      {
        paramVarArgs.ln(4, this.FBP.computeSize());
        this.FBP.writeFields(paramVarArgs);
      }
      if (this.Ebg != null) {
        paramVarArgs.d(5, this.Ebg);
      }
      paramVarArgs.e(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI);
      paramInt = i;
      if (this.FBO != null) {
        paramInt = i + f.a.a.a.lm(3, this.FBO.computeSize());
      }
      i = paramInt;
      if (this.FBP != null) {
        i = paramInt + f.a.a.a.lm(4, this.FBP.computeSize());
      }
      paramInt = i;
      if (this.Ebg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ebg);
      }
      i = f.a.a.a.c(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpa localcpa = (cpa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115965);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpa.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 2: 
          localcpa.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115965);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cou();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cou)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpa.FBO = ((cou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpa.FBP = ((cpq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 5: 
          localcpa.Ebg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115965);
          return 0;
        }
        localcpa.EmotionList.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(115965);
        return 0;
      }
      AppMethodBeat.o(115965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpa
 * JD-Core Version:    0.7.0.1
 */