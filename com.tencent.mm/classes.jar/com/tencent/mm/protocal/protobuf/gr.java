package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gr
  extends cpx
{
  public int DOv;
  public LinkedList<String> DTU;
  public boolean DTV;
  public int DTW;
  public int dbL;
  public String djj;
  
  public gr()
  {
    AppMethodBeat.i(147758);
    this.DTU = new LinkedList();
    AppMethodBeat.o(147758);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147759);
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
      paramVarArgs.e(3, 1, this.DTU);
      paramVarArgs.bl(4, this.DTV);
      paramVarArgs.aR(5, this.DTW);
      paramVarArgs.aR(6, this.dbL);
      paramVarArgs.aR(7, this.DOv);
      AppMethodBeat.o(147759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djj);
      }
      paramInt = f.a.a.a.c(3, 1, this.DTU);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.bx(5, this.DTW);
      int m = f.a.a.b.b.a.bx(6, this.dbL);
      int n = f.a.a.b.b.a.bx(7, this.DOv);
      AppMethodBeat.o(147759);
      return i + paramInt + (j + 1) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gr localgr = (gr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147759);
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
            localgr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147759);
          return 0;
        case 2: 
          localgr.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147759);
          return 0;
        case 3: 
          localgr.DTU.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(147759);
          return 0;
        case 4: 
          localgr.DTV = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(147759);
          return 0;
        case 5: 
          localgr.DTW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147759);
          return 0;
        case 6: 
          localgr.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147759);
          return 0;
        }
        localgr.DOv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(147759);
        return 0;
      }
      AppMethodBeat.o(147759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gr
 * JD-Core Version:    0.7.0.1
 */