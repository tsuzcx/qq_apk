package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwx
  extends dop
{
  public int KFC;
  public boolean McF;
  public LinkedList<String> McG;
  public String dNI;
  public int source;
  
  public bwx()
  {
    AppMethodBeat.i(147765);
    this.McG = new LinkedList();
    AppMethodBeat.o(147765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147766);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      paramVarArgs.cc(3, this.McF);
      paramVarArgs.e(4, 1, this.McG);
      paramVarArgs.aM(5, this.source);
      paramVarArgs.aM(6, this.KFC);
      AppMethodBeat.o(147766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.a.c(4, 1, this.McG);
      int k = g.a.a.b.b.a.bu(5, this.source);
      int m = g.a.a.b.b.a.bu(6, this.KFC);
      AppMethodBeat.o(147766);
      return i + (paramInt + 1) + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.McG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwx localbwx = (bwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147766);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbwx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147766);
          return 0;
        case 2: 
          localbwx.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147766);
          return 0;
        case 3: 
          localbwx.McF = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(147766);
          return 0;
        case 4: 
          localbwx.McG.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(147766);
          return 0;
        case 5: 
          localbwx.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147766);
          return 0;
        }
        localbwx.KFC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(147766);
        return 0;
      }
      AppMethodBeat.o(147766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwx
 * JD-Core Version:    0.7.0.1
 */