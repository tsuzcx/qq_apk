package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amx
  extends cvw
{
  public alw GEg;
  public int actionType;
  public LinkedList<aio> rSz;
  public String sbR;
  
  public amx()
  {
    AppMethodBeat.i(189323);
    this.rSz = new LinkedList();
    AppMethodBeat.o(189323);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sbR != null) {
        paramVarArgs.d(2, this.sbR);
      }
      paramVarArgs.aS(3, this.actionType);
      paramVarArgs.e(4, 8, this.rSz);
      if (this.GEg != null)
      {
        paramVarArgs.lJ(5, this.GEg.computeSize());
        this.GEg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(189324);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sbR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sbR);
      }
      i = i + f.a.a.b.b.a.bz(3, this.actionType) + f.a.a.a.c(4, 8, this.rSz);
      paramInt = i;
      if (this.GEg != null) {
        paramInt = i + f.a.a.a.lI(5, this.GEg.computeSize());
      }
      AppMethodBeat.o(189324);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rSz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189324);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amx localamx = (amx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189324);
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
            localamx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189324);
          return 0;
        case 2: 
          localamx.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189324);
          return 0;
        case 3: 
          localamx.actionType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189324);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamx.rSz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189324);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamx.GEg = ((alw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189324);
        return 0;
      }
      AppMethodBeat.o(189324);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amx
 * JD-Core Version:    0.7.0.1
 */