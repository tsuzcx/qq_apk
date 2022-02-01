package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnd
  extends cvw
{
  public int HUn;
  public LinkedList<dnc> HUo;
  public int Scene;
  
  public dnd()
  {
    AppMethodBeat.i(32468);
    this.HUo = new LinkedList();
    AppMethodBeat.o(32468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HUn);
      paramVarArgs.e(3, 8, this.HUo);
      paramVarArgs.aS(4, this.Scene);
      AppMethodBeat.o(32469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HUn);
      int j = f.a.a.a.c(3, 8, this.HUo);
      int k = f.a.a.b.b.a.bz(4, this.Scene);
      AppMethodBeat.o(32469);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HUo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnd localdnd = (dnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32469);
          return 0;
        case 2: 
          localdnd.HUn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32469);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnd.HUo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32469);
          return 0;
        }
        localdnd.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32469);
        return 0;
      }
      AppMethodBeat.o(32469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnd
 * JD-Core Version:    0.7.0.1
 */