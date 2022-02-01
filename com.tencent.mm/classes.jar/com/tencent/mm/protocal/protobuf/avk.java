package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avk
  extends cvw
{
  public String GMx;
  public int GMy;
  public LinkedList<avm> GMz;
  public int SetType;
  
  public avk()
  {
    AppMethodBeat.i(190421);
    this.GMz = new LinkedList();
    AppMethodBeat.o(190421);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74654);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.SetType);
      if (this.GMx != null) {
        paramVarArgs.d(3, this.GMx);
      }
      paramVarArgs.aS(4, this.GMy);
      paramVarArgs.e(5, 8, this.GMz);
      AppMethodBeat.o(74654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.SetType);
      paramInt = i;
      if (this.GMx != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GMx);
      }
      i = f.a.a.b.b.a.bz(4, this.GMy);
      int j = f.a.a.a.c(5, 8, this.GMz);
      AppMethodBeat.o(74654);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GMz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avk localavk = (avk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74654);
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
            localavk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74654);
          return 0;
        case 2: 
          localavk.SetType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74654);
          return 0;
        case 3: 
          localavk.GMx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(74654);
          return 0;
        case 4: 
          localavk.GMy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74654);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavk.GMz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      AppMethodBeat.o(74654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avk
 * JD-Core Version:    0.7.0.1
 */