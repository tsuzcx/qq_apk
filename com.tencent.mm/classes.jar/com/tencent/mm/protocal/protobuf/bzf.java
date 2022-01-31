package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bzf
  extends com.tencent.mm.bv.a
{
  public String cqq;
  public String ewj;
  public int fWd;
  public int fXx;
  public int fgQ;
  public int fgR;
  public String rlS;
  public String url;
  public LinkedList<ckl> xLi;
  public int xLj;
  
  public bzf()
  {
    AppMethodBeat.i(51002);
    this.xLi = new LinkedList();
    AppMethodBeat.o(51002);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51003);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.rlS == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(51003);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.xLi);
      if (this.rlS != null) {
        paramVarArgs.e(2, this.rlS);
      }
      if (this.cqq != null) {
        paramVarArgs.e(3, this.cqq);
      }
      if (this.ewj != null) {
        paramVarArgs.e(4, this.ewj);
      }
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      paramVarArgs.aO(6, this.fXx);
      paramVarArgs.aO(7, this.fWd);
      paramVarArgs.aO(8, this.xLj);
      paramVarArgs.aO(9, this.fgQ);
      paramVarArgs.aO(10, this.fgR);
      AppMethodBeat.o(51003);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.xLi) + 0;
      paramInt = i;
      if (this.rlS != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.rlS);
      }
      i = paramInt;
      if (this.cqq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cqq);
      }
      paramInt = i;
      if (this.ewj != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ewj);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.url);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.fXx);
      int j = e.a.a.b.b.a.bl(7, this.fWd);
      int k = e.a.a.b.b.a.bl(8, this.xLj);
      int m = e.a.a.b.b.a.bl(9, this.fgQ);
      int n = e.a.a.b.b.a.bl(10, this.fgR);
      AppMethodBeat.o(51003);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xLi.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.rlS == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(51003);
        throw paramVarArgs;
      }
      AppMethodBeat.o(51003);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bzf localbzf = (bzf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(51003);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ckl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbzf.xLi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(51003);
        return 0;
      case 2: 
        localbzf.rlS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(51003);
        return 0;
      case 3: 
        localbzf.cqq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(51003);
        return 0;
      case 4: 
        localbzf.ewj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(51003);
        return 0;
      case 5: 
        localbzf.url = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(51003);
        return 0;
      case 6: 
        localbzf.fXx = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51003);
        return 0;
      case 7: 
        localbzf.fWd = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51003);
        return 0;
      case 8: 
        localbzf.xLj = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51003);
        return 0;
      case 9: 
        localbzf.fgQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51003);
        return 0;
      }
      localbzf.fgR = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(51003);
      return 0;
    }
    AppMethodBeat.o(51003);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzf
 * JD-Core Version:    0.7.0.1
 */