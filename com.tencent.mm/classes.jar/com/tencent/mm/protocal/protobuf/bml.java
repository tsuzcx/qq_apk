package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bml
  extends com.tencent.mm.bw.a
{
  public int KXD;
  public doo LVf;
  public cju LVg;
  public int LVh;
  public boolean LVi;
  public boolean LVj;
  public int LVk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LVf != null)
      {
        paramVarArgs.ni(1, this.LVf.computeSize());
        this.LVf.writeFields(paramVarArgs);
      }
      if (this.LVg != null)
      {
        paramVarArgs.ni(2, this.LVg.computeSize());
        this.LVg.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LVh);
      paramVarArgs.aM(4, this.KXD);
      paramVarArgs.cc(5, this.LVi);
      paramVarArgs.cc(6, this.LVj);
      paramVarArgs.aM(7, this.LVk);
      AppMethodBeat.o(175244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LVf == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.nh(1, this.LVf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LVg != null) {
        i = paramInt + g.a.a.a.nh(2, this.LVg.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.LVh);
      int j = g.a.a.b.b.a.bu(4, this.KXD);
      int k = g.a.a.b.b.a.fS(5);
      int m = g.a.a.b.b.a.fS(6);
      int n = g.a.a.b.b.a.bu(7, this.LVk);
      AppMethodBeat.o(175244);
      return i + paramInt + j + (k + 1) + (m + 1) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(175244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bml localbml = (bml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175244);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((doo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbml.LVf = ((doo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cju();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cju)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbml.LVg = ((cju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 3: 
          localbml.LVh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(175244);
          return 0;
        case 4: 
          localbml.KXD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(175244);
          return 0;
        case 5: 
          localbml.LVi = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(175244);
          return 0;
        case 6: 
          localbml.LVj = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(175244);
          return 0;
        }
        localbml.LVk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(175244);
        return 0;
      }
      AppMethodBeat.o(175244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bml
 * JD-Core Version:    0.7.0.1
 */