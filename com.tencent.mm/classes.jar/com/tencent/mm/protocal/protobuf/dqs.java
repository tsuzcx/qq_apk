package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqs
  extends com.tencent.mm.bw.a
{
  public String Eee;
  public SKBuiltinBuffer_t FUI;
  public int FXY;
  public int hNR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(148667);
        throw paramVarArgs;
      }
      if (this.FUI != null)
      {
        paramVarArgs.ln(1, this.FUI.computeSize());
        this.FUI.writeFields(paramVarArgs);
      }
      if (this.Eee != null) {
        paramVarArgs.d(2, this.Eee);
      }
      paramVarArgs.aR(3, this.hNR);
      paramVarArgs.aR(4, this.FXY);
      AppMethodBeat.o(148667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUI == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lm(1, this.FUI.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eee != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eee);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.hNR);
      int j = f.a.a.b.b.a.bx(4, this.FXY);
      AppMethodBeat.o(148667);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FUI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(148667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148667);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqs localdqs = (dqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148667);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqs.FUI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148667);
          return 0;
        case 2: 
          localdqs.Eee = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148667);
          return 0;
        case 3: 
          localdqs.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148667);
          return 0;
        }
        localdqs.FXY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148667);
        return 0;
      }
      AppMethodBeat.o(148667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqs
 * JD-Core Version:    0.7.0.1
 */