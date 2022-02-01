package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agq
  extends cpx
{
  public float Eht;
  public float Ehu;
  public String Ewu;
  public String EyJ;
  public int EyK;
  public String EyL;
  public String EyM;
  public int EyN;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      if (this.EyJ != null) {
        paramVarArgs.d(3, this.EyJ);
      }
      paramVarArgs.x(4, this.Eht);
      paramVarArgs.x(5, this.Ehu);
      paramVarArgs.aR(6, this.EyK);
      if (this.EyL != null) {
        paramVarArgs.d(7, this.EyL);
      }
      if (this.EyM != null) {
        paramVarArgs.d(8, this.EyM);
      }
      paramVarArgs.aR(9, this.EyN);
      if (this.Ewu != null) {
        paramVarArgs.d(10, this.Ewu);
      }
      AppMethodBeat.o(32207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label796;
      }
    }
    label796:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.OpCode);
      paramInt = i;
      if (this.EyJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EyJ);
      }
      i = paramInt + (f.a.a.b.b.a.fK(4) + 4) + (f.a.a.b.b.a.fK(5) + 4) + f.a.a.b.b.a.bx(6, this.EyK);
      paramInt = i;
      if (this.EyL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EyL);
      }
      i = paramInt;
      if (this.EyM != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EyM);
      }
      i += f.a.a.b.b.a.bx(9, this.EyN);
      paramInt = i;
      if (this.Ewu != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ewu);
      }
      AppMethodBeat.o(32207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agq localagq = (agq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32207);
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
            localagq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32207);
          return 0;
        case 2: 
          localagq.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32207);
          return 0;
        case 3: 
          localagq.EyJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 4: 
          localagq.Eht = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32207);
          return 0;
        case 5: 
          localagq.Ehu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32207);
          return 0;
        case 6: 
          localagq.EyK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32207);
          return 0;
        case 7: 
          localagq.EyL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 8: 
          localagq.EyM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 9: 
          localagq.EyN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32207);
          return 0;
        }
        localagq.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32207);
        return 0;
      }
      AppMethodBeat.o(32207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agq
 * JD-Core Version:    0.7.0.1
 */