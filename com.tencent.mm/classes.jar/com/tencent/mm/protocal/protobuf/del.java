package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class del
  extends cvw
{
  public LinkedList<Integer> FUE;
  public String HLG;
  public int Scene;
  public int nID;
  
  public del()
  {
    AppMethodBeat.i(127502);
    this.FUE = new LinkedList();
    AppMethodBeat.o(127502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HLG != null) {
        paramVarArgs.d(2, this.HLG);
      }
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.aS(4, this.nID);
      paramVarArgs.f(5, 2, this.FUE);
      AppMethodBeat.o(127503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label537;
      }
    }
    label537:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HLG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HLG);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Scene);
      int j = f.a.a.b.b.a.bz(4, this.nID);
      int k = f.a.a.a.d(5, 2, this.FUE);
      AppMethodBeat.o(127503);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        del localdel = (del)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127503);
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
            localdel.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127503);
          return 0;
        case 2: 
          localdel.HLG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127503);
          return 0;
        case 3: 
          localdel.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127503);
          return 0;
        case 4: 
          localdel.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127503);
          return 0;
        }
        localdel.FUE = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
        AppMethodBeat.o(127503);
        return 0;
      }
      AppMethodBeat.o(127503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.del
 * JD-Core Version:    0.7.0.1
 */