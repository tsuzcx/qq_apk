package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class be
  extends com.tencent.mm.bv.a
{
  public int flags = -1;
  public int state = -1;
  public ckn wnr;
  public String wns = "";
  public String wnt = "";
  public String wnu = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73644);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wnr != null)
      {
        paramVarArgs.iQ(1, this.wnr.computeSize());
        this.wnr.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.flags);
      paramVarArgs.aO(3, this.state);
      if (this.wns != null) {
        paramVarArgs.e(4, this.wns);
      }
      if (this.wnt != null) {
        paramVarArgs.e(5, this.wnt);
      }
      if (this.wnu != null) {
        paramVarArgs.e(6, this.wnu);
      }
      AppMethodBeat.o(73644);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wnr == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = e.a.a.a.iP(1, this.wnr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.flags) + e.a.a.b.b.a.bl(3, this.state);
      paramInt = i;
      if (this.wns != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wns);
      }
      i = paramInt;
      if (this.wnt != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wnt);
      }
      paramInt = i;
      if (this.wnu != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wnu);
      }
      AppMethodBeat.o(73644);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73644);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        be localbe = (be)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73644);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ckn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbe.wnr = ((ckn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73644);
          return 0;
        case 2: 
          localbe.flags = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73644);
          return 0;
        case 3: 
          localbe.state = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73644);
          return 0;
        case 4: 
          localbe.wns = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73644);
          return 0;
        case 5: 
          localbe.wnt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73644);
          return 0;
        }
        localbe.wnu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73644);
        return 0;
      }
      AppMethodBeat.o(73644);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.be
 * JD-Core Version:    0.7.0.1
 */