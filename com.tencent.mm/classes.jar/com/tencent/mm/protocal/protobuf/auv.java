package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auv
  extends cvw
{
  public String GLP;
  public LinkedList<String> GLQ;
  public String usS;
  
  public auv()
  {
    AppMethodBeat.i(42633);
    this.GLQ = new LinkedList();
    AppMethodBeat.o(42633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GLP != null) {
        paramVarArgs.d(2, this.GLP);
      }
      paramVarArgs.e(3, 1, this.GLQ);
      if (this.usS != null) {
        paramVarArgs.d(4, this.usS);
      }
      AppMethodBeat.o(42634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GLP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GLP);
      }
      i += f.a.a.a.c(3, 1, this.GLQ);
      paramInt = i;
      if (this.usS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.usS);
      }
      AppMethodBeat.o(42634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(42634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auv localauv = (auv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42634);
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
            localauv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42634);
          return 0;
        case 2: 
          localauv.GLP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42634);
          return 0;
        case 3: 
          localauv.GLQ.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(42634);
          return 0;
        }
        localauv.usS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(42634);
        return 0;
      }
      AppMethodBeat.o(42634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auv
 * JD-Core Version:    0.7.0.1
 */