package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbz
  extends cpx
{
  public int FLo;
  public int FLp;
  public int scene;
  public String znE;
  public String znF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91696);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.scene);
      if (this.znE != null) {
        paramVarArgs.d(3, this.znE);
      }
      if (this.znF != null) {
        paramVarArgs.d(4, this.znF);
      }
      paramVarArgs.aR(5, this.FLo);
      paramVarArgs.aR(6, this.FLp);
      AppMethodBeat.o(91696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.scene);
      paramInt = i;
      if (this.znE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.znE);
      }
      i = paramInt;
      if (this.znF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.znF);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.FLo);
      int j = f.a.a.b.b.a.bx(6, this.FLp);
      AppMethodBeat.o(91696);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbz localdbz = (dbz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91696);
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
            localdbz.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91696);
          return 0;
        case 2: 
          localdbz.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91696);
          return 0;
        case 3: 
          localdbz.znE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 4: 
          localdbz.znF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 5: 
          localdbz.FLo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91696);
          return 0;
        }
        localdbz.FLp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91696);
        return 0;
      }
      AppMethodBeat.o(91696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbz
 * JD-Core Version:    0.7.0.1
 */