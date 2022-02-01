package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmh
  extends cvw
{
  public dmi Hym;
  public boolean Hyn;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153290);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hym != null)
      {
        paramVarArgs.lJ(2, this.Hym.computeSize());
        this.Hym.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(3, this.Hyn);
      paramVarArgs.aS(4, this.scene);
      AppMethodBeat.o(153290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hym != null) {
        i = paramInt + f.a.a.a.lI(2, this.Hym.computeSize());
      }
      paramInt = f.a.a.b.b.a.amF(3);
      int j = f.a.a.b.b.a.bz(4, this.scene);
      AppMethodBeat.o(153290);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153290);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmh localcmh = (cmh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153290);
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
            localcmh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153290);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmh.Hym = ((dmi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153290);
          return 0;
        case 3: 
          localcmh.Hyn = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153290);
          return 0;
        }
        localcmh.scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153290);
        return 0;
      }
      AppMethodBeat.o(153290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmh
 * JD-Core Version:    0.7.0.1
 */