package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hl
  extends dop
{
  public int KFC;
  public LinkedList<String> KLt;
  public boolean KLu;
  public int KLv;
  public String dNI;
  public int source;
  
  public hl()
  {
    AppMethodBeat.i(147758);
    this.KLt = new LinkedList();
    AppMethodBeat.o(147758);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147759);
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
      paramVarArgs.e(3, 1, this.KLt);
      paramVarArgs.cc(4, this.KLu);
      paramVarArgs.aM(5, this.KLv);
      paramVarArgs.aM(6, this.source);
      paramVarArgs.aM(7, this.KFC);
      AppMethodBeat.o(147759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      paramInt = g.a.a.a.c(3, 1, this.KLt);
      int j = g.a.a.b.b.a.fS(4);
      int k = g.a.a.b.b.a.bu(5, this.KLv);
      int m = g.a.a.b.b.a.bu(6, this.source);
      int n = g.a.a.b.b.a.bu(7, this.KFC);
      AppMethodBeat.o(147759);
      return i + paramInt + (j + 1) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KLt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hl localhl = (hl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147759);
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
            localhl.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147759);
          return 0;
        case 2: 
          localhl.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147759);
          return 0;
        case 3: 
          localhl.KLt.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(147759);
          return 0;
        case 4: 
          localhl.KLu = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(147759);
          return 0;
        case 5: 
          localhl.KLv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147759);
          return 0;
        case 6: 
          localhl.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147759);
          return 0;
        }
        localhl.KFC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(147759);
        return 0;
      }
      AppMethodBeat.o(147759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hl
 * JD-Core Version:    0.7.0.1
 */