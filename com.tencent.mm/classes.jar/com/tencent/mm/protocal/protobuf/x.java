package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class x
  extends cpx
{
  public String DLl;
  public int DLm;
  public int DLn;
  public String DLo;
  public int limit;
  public int offset;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.limit);
      paramVarArgs.aR(3, this.offset);
      paramVarArgs.aR(4, this.type);
      if (this.DLl != null) {
        paramVarArgs.d(5, this.DLl);
      }
      paramVarArgs.aR(6, this.DLm);
      paramVarArgs.aR(7, this.DLn);
      if (this.DLo != null) {
        paramVarArgs.d(8, this.DLo);
      }
      AppMethodBeat.o(91336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.limit) + f.a.a.b.b.a.bx(3, this.offset) + f.a.a.b.b.a.bx(4, this.type);
      paramInt = i;
      if (this.DLl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DLl);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.DLm) + f.a.a.b.b.a.bx(7, this.DLn);
      paramInt = i;
      if (this.DLo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DLo);
      }
      AppMethodBeat.o(91336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91336);
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
            localx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91336);
          return 0;
        case 2: 
          localx.limit = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91336);
          return 0;
        case 3: 
          localx.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91336);
          return 0;
        case 4: 
          localx.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91336);
          return 0;
        case 5: 
          localx.DLl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91336);
          return 0;
        case 6: 
          localx.DLm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91336);
          return 0;
        case 7: 
          localx.DLn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91336);
          return 0;
        }
        localx.DLo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91336);
        return 0;
      }
      AppMethodBeat.o(91336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.x
 * JD-Core Version:    0.7.0.1
 */