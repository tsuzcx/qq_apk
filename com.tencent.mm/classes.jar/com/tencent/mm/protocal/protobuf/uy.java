package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class uy
  extends cvw
{
  public int Ggx = 4;
  public b Gmx;
  public b Gmy;
  public String phC;
  public int vxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.vxx);
      if (this.Gmx != null) {
        paramVarArgs.c(3, this.Gmx);
      }
      if (this.Gmy != null) {
        paramVarArgs.c(4, this.Gmy);
      }
      if (this.phC != null) {
        paramVarArgs.d(5, this.phC);
      }
      paramVarArgs.aS(6, this.Ggx);
      AppMethodBeat.o(91410);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.vxx);
      paramInt = i;
      if (this.Gmx != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Gmx);
      }
      i = paramInt;
      if (this.Gmy != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Gmy);
      }
      paramInt = i;
      if (this.phC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.phC);
      }
      i = f.a.a.b.b.a.bz(6, this.Ggx);
      AppMethodBeat.o(91410);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91410);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uy localuy = (uy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91410);
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
            localuy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91410);
          return 0;
        case 2: 
          localuy.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91410);
          return 0;
        case 3: 
          localuy.Gmx = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91410);
          return 0;
        case 4: 
          localuy.Gmy = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91410);
          return 0;
        case 5: 
          localuy.phC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91410);
          return 0;
        }
        localuy.Ggx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91410);
        return 0;
      }
      AppMethodBeat.o(91410);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uy
 * JD-Core Version:    0.7.0.1
 */