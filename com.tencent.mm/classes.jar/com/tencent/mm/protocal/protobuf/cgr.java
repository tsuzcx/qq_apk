package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cgr
  extends com.tencent.mm.bw.a
{
  public String LtA;
  public String LtL;
  public LinkedList<String> LtM;
  public boolean LtN;
  public int MlY;
  public cgm MlZ;
  
  public cgr()
  {
    AppMethodBeat.i(256415);
    this.LtM = new LinkedList();
    AppMethodBeat.o(256415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LtA == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(256416);
        throw paramVarArgs;
      }
      if (this.LtA != null) {
        paramVarArgs.e(1, this.LtA);
      }
      if (this.LtL != null) {
        paramVarArgs.e(2, this.LtL);
      }
      paramVarArgs.e(3, 1, this.LtM);
      paramVarArgs.cc(4, this.LtN);
      paramVarArgs.aM(5, this.MlY);
      if (this.MlZ != null)
      {
        paramVarArgs.ni(6, this.MlZ.computeSize());
        this.MlZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LtA == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = g.a.a.b.b.a.f(1, this.LtA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LtL != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LtL);
      }
      i = i + g.a.a.a.c(3, 1, this.LtM) + (g.a.a.b.b.a.fS(4) + 1) + g.a.a.b.b.a.bu(5, this.MlY);
      paramInt = i;
      if (this.MlZ != null) {
        paramInt = i + g.a.a.a.nh(6, this.MlZ.computeSize());
      }
      AppMethodBeat.o(256416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LtM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LtA == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(256416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgr localcgr = (cgr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256416);
          return -1;
        case 1: 
          localcgr.LtA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256416);
          return 0;
        case 2: 
          localcgr.LtL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256416);
          return 0;
        case 3: 
          localcgr.LtM.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(256416);
          return 0;
        case 4: 
          localcgr.LtN = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(256416);
          return 0;
        case 5: 
          localcgr.MlY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256416);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cgm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcgr.MlZ = ((cgm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256416);
        return 0;
      }
      AppMethodBeat.o(256416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgr
 * JD-Core Version:    0.7.0.1
 */