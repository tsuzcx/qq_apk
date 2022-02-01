package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vt
  extends cvw
{
  public String FMg;
  public String GnD;
  public boolean GnE;
  public int GnF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FMg != null) {
        paramVarArgs.d(2, this.FMg);
      }
      if (this.GnD != null) {
        paramVarArgs.d(3, this.GnD);
      }
      paramVarArgs.bC(4, this.GnE);
      paramVarArgs.aS(5, this.GnF);
      AppMethodBeat.o(125716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FMg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FMg);
      }
      i = paramInt;
      if (this.GnD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GnD);
      }
      paramInt = f.a.a.b.b.a.amF(4);
      int j = f.a.a.b.b.a.bz(5, this.GnF);
      AppMethodBeat.o(125716);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vt localvt = (vt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125716);
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
            localvt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125716);
          return 0;
        case 2: 
          localvt.FMg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 3: 
          localvt.GnD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 4: 
          localvt.GnE = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(125716);
          return 0;
        }
        localvt.GnF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125716);
        return 0;
      }
      AppMethodBeat.o(125716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vt
 * JD-Core Version:    0.7.0.1
 */