package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jf
  extends com.tencent.mm.bw.a
{
  public LinkedList<dlw> KNM;
  public dys KNN;
  public String KNw;
  
  public jf()
  {
    AppMethodBeat.i(91357);
    this.KNM = new LinkedList();
    AppMethodBeat.o(91357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91358);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KNw != null) {
        paramVarArgs.e(1, this.KNw);
      }
      paramVarArgs.e(2, 8, this.KNM);
      if (this.KNN != null)
      {
        paramVarArgs.ni(3, this.KNN.computeSize());
        this.KNN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KNw == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.b.b.a.f(1, this.KNw) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KNM);
      paramInt = i;
      if (this.KNN != null) {
        paramInt = i + g.a.a.a.nh(3, this.KNN.computeSize());
      }
      AppMethodBeat.o(91358);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KNM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        jf localjf = (jf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91358);
          return -1;
        case 1: 
          localjf.KNw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91358);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjf.KNM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91358);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dys();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dys)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localjf.KNN = ((dys)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      AppMethodBeat.o(91358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jf
 * JD-Core Version:    0.7.0.1
 */