package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cik
  extends buy
{
  public String crs;
  public String cwc;
  public LinkedList<Integer> xLl;
  public String xLm;
  
  public cik()
  {
    AppMethodBeat.i(96296);
    this.xLl = new LinkedList();
    AppMethodBeat.o(96296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96297);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      paramVarArgs.e(3, 2, this.xLl);
      if (this.xLm != null) {
        paramVarArgs.e(4, this.xLm);
      }
      if (this.crs != null) {
        paramVarArgs.e(5, this.crs);
      }
      AppMethodBeat.o(96297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label553;
      }
    }
    label553:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cwc);
      }
      i += e.a.a.a.c(3, 2, this.xLl);
      paramInt = i;
      if (this.xLm != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xLm);
      }
      i = paramInt;
      if (this.crs != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.crs);
      }
      AppMethodBeat.o(96297);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLl.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cik localcik = (cik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96297);
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
            localcik.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96297);
          return 0;
        case 2: 
          localcik.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96297);
          return 0;
        case 3: 
          localcik.xLl.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(96297);
          return 0;
        case 4: 
          localcik.xLm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96297);
          return 0;
        }
        localcik.crs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96297);
        return 0;
      }
      AppMethodBeat.o(96297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cik
 * JD-Core Version:    0.7.0.1
 */