package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfk
  extends buy
{
  public String Username;
  public int niK;
  public String xOk;
  public long xOl;
  public long xPt;
  public int xPu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94623);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xOk != null) {
        paramVarArgs.e(2, this.xOk);
      }
      if (this.Username != null) {
        paramVarArgs.e(3, this.Username);
      }
      paramVarArgs.am(4, this.xOl);
      paramVarArgs.aO(5, this.niK);
      paramVarArgs.am(6, this.xPt);
      paramVarArgs.aO(7, this.xPu);
      AppMethodBeat.o(94623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xOk != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xOk);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Username);
      }
      paramInt = e.a.a.b.b.a.p(4, this.xOl);
      int j = e.a.a.b.b.a.bl(5, this.niK);
      int k = e.a.a.b.b.a.p(6, this.xPt);
      int m = e.a.a.b.b.a.bl(7, this.xPu);
      AppMethodBeat.o(94623);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfk localcfk = (cfk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94623);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94623);
          return 0;
        case 2: 
          localcfk.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94623);
          return 0;
        case 3: 
          localcfk.Username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94623);
          return 0;
        case 4: 
          localcfk.xOl = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94623);
          return 0;
        case 5: 
          localcfk.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94623);
          return 0;
        case 6: 
          localcfk.xPt = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94623);
          return 0;
        }
        localcfk.xPu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94623);
        return 0;
      }
      AppMethodBeat.o(94623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfk
 * JD-Core Version:    0.7.0.1
 */