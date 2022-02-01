package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cos
  extends cpx
{
  public String FBE;
  public String FpO;
  public int dtw;
  public String uhB;
  public String ulT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uhB != null) {
        paramVarArgs.d(2, this.uhB);
      }
      if (this.FpO != null) {
        paramVarArgs.d(3, this.FpO);
      }
      paramVarArgs.aR(4, this.dtw);
      if (this.ulT != null) {
        paramVarArgs.d(5, this.ulT);
      }
      if (this.FBE != null) {
        paramVarArgs.d(6, this.FBE);
      }
      AppMethodBeat.o(116341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uhB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uhB);
      }
      i = paramInt;
      if (this.FpO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FpO);
      }
      i += f.a.a.b.b.a.bx(4, this.dtw);
      paramInt = i;
      if (this.ulT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ulT);
      }
      i = paramInt;
      if (this.FBE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FBE);
      }
      AppMethodBeat.o(116341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cos localcos = (cos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116341);
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
            localcos.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116341);
          return 0;
        case 2: 
          localcos.uhB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 3: 
          localcos.FpO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 4: 
          localcos.dtw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116341);
          return 0;
        case 5: 
          localcos.ulT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116341);
          return 0;
        }
        localcos.FBE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116341);
        return 0;
      }
      AppMethodBeat.o(116341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cos
 * JD-Core Version:    0.7.0.1
 */