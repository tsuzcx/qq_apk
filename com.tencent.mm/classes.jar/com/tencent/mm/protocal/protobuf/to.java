package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class to
  extends cvw
{
  public float dBu;
  public String dJb;
  public float dzE;
  public String oEo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oEo != null) {
        paramVarArgs.d(2, this.oEo);
      }
      paramVarArgs.y(3, this.dBu);
      paramVarArgs.y(4, this.dzE);
      if (this.dJb != null) {
        paramVarArgs.d(5, this.dJb);
      }
      AppMethodBeat.o(113970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oEo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oEo);
      }
      i = i + f.a.a.b.b.a.amE(3) + f.a.a.b.b.a.amE(4);
      paramInt = i;
      if (this.dJb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dJb);
      }
      AppMethodBeat.o(113970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        to localto = (to)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113970);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localto.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113970);
          return 0;
        case 2: 
          localto.oEo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113970);
          return 0;
        case 3: 
          localto.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(113970);
          return 0;
        case 4: 
          localto.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(113970);
          return 0;
        }
        localto.dJb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113970);
        return 0;
      }
      AppMethodBeat.o(113970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.to
 * JD-Core Version:    0.7.0.1
 */