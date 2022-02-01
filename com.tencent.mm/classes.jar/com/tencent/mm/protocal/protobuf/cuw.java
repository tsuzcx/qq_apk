package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuw
  extends cpx
{
  public String DUi;
  public LinkedList<Integer> FGa;
  public String FGb;
  public String FGc;
  public String cZz;
  public String ddJ;
  public String djj;
  
  public cuw()
  {
    AppMethodBeat.i(123645);
    this.FGa = new LinkedList();
    AppMethodBeat.o(123645);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123646);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      paramVarArgs.e(3, 2, this.FGa);
      if (this.FGb != null) {
        paramVarArgs.d(4, this.FGb);
      }
      if (this.DUi != null) {
        paramVarArgs.d(5, this.DUi);
      }
      if (this.ddJ != null) {
        paramVarArgs.d(6, this.ddJ);
      }
      if (this.cZz != null) {
        paramVarArgs.d(7, this.cZz);
      }
      if (this.FGc != null) {
        paramVarArgs.d(8, this.FGc);
      }
      AppMethodBeat.o(123646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label737;
      }
    }
    label737:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djj);
      }
      i += f.a.a.a.c(3, 2, this.FGa);
      paramInt = i;
      if (this.FGb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FGb);
      }
      i = paramInt;
      if (this.DUi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DUi);
      }
      paramInt = i;
      if (this.ddJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ddJ);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.cZz);
      }
      paramInt = i;
      if (this.FGc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FGc);
      }
      AppMethodBeat.o(123646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FGa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123646);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuw localcuw = (cuw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123646);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123646);
          return 0;
        case 2: 
          localcuw.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 3: 
          localcuw.FGa.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(123646);
          return 0;
        case 4: 
          localcuw.FGb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 5: 
          localcuw.DUi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 6: 
          localcuw.ddJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 7: 
          localcuw.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123646);
          return 0;
        }
        localcuw.FGc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123646);
        return 0;
      }
      AppMethodBeat.o(123646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuw
 * JD-Core Version:    0.7.0.1
 */