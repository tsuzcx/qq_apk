package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmq
  extends cpx
{
  public LinkedList<String> FbP;
  public int FbR;
  public eat FbS;
  public String FbU;
  public String hOf;
  
  public bmq()
  {
    AppMethodBeat.i(123607);
    this.FbP = new LinkedList();
    AppMethodBeat.o(123607);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      paramVarArgs.e(3, 1, this.FbP);
      paramVarArgs.aR(4, this.FbR);
      if (this.FbS != null)
      {
        paramVarArgs.ln(5, this.FbS.computeSize());
        this.FbS.writeFields(paramVarArgs);
      }
      if (this.FbU != null) {
        paramVarArgs.d(6, this.FbU);
      }
      AppMethodBeat.o(123608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = i + f.a.a.a.c(3, 1, this.FbP) + f.a.a.b.b.a.bx(4, this.FbR);
      paramInt = i;
      if (this.FbS != null) {
        paramInt = i + f.a.a.a.lm(5, this.FbS.computeSize());
      }
      i = paramInt;
      if (this.FbU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FbU);
      }
      AppMethodBeat.o(123608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FbP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmq localbmq = (bmq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123608);
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
            localbmq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123608);
          return 0;
        case 2: 
          localbmq.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123608);
          return 0;
        case 3: 
          localbmq.FbP.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(123608);
          return 0;
        case 4: 
          localbmq.FbR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123608);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eat();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmq.FbS = ((eat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123608);
          return 0;
        }
        localbmq.FbU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123608);
        return 0;
      }
      AppMethodBeat.o(123608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmq
 * JD-Core Version:    0.7.0.1
 */