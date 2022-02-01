package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbc
  extends cvw
{
  public int HhT;
  public LinkedList<cxn> HhU;
  public String xrf;
  
  public dbc()
  {
    AppMethodBeat.i(155461);
    this.HhU = new LinkedList();
    AppMethodBeat.o(155461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xrf != null) {
        paramVarArgs.d(2, this.xrf);
      }
      paramVarArgs.aS(3, this.HhT);
      paramVarArgs.e(4, 8, this.HhU);
      AppMethodBeat.o(155462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xrf);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HhT);
      int j = f.a.a.a.c(4, 8, this.HhU);
      AppMethodBeat.o(155462);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HhU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbc localdbc = (dbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155462);
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
            localdbc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155462);
          return 0;
        case 2: 
          localdbc.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155462);
          return 0;
        case 3: 
          localdbc.HhT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155462);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbc.HhU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155462);
        return 0;
      }
      AppMethodBeat.o(155462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbc
 * JD-Core Version:    0.7.0.1
 */