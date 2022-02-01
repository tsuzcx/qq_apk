package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dng
  extends cpx
{
  public boolean FUS;
  public int fZy;
  public String hOf;
  public int ndH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123666);
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
      paramVarArgs.aR(3, this.ndH);
      paramVarArgs.bl(4, this.FUS);
      paramVarArgs.aR(5, this.fZy);
      AppMethodBeat.o(123666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hOf);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.ndH);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.bx(5, this.fZy);
      AppMethodBeat.o(123666);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dng localdng = (dng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123666);
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
            localdng.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123666);
          return 0;
        case 2: 
          localdng.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123666);
          return 0;
        case 3: 
          localdng.ndH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123666);
          return 0;
        case 4: 
          localdng.FUS = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123666);
          return 0;
        }
        localdng.fZy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123666);
        return 0;
      }
      AppMethodBeat.o(123666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dng
 * JD-Core Version:    0.7.0.1
 */