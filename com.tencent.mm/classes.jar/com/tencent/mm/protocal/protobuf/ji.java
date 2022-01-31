package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ji
  extends buy
{
  public int cCc;
  public String uld;
  public String wvn;
  public String wvo;
  public String wvp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48780);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wvn != null) {
        paramVarArgs.e(2, this.wvn);
      }
      if (this.wvo != null) {
        paramVarArgs.e(3, this.wvo);
      }
      if (this.uld != null) {
        paramVarArgs.e(4, this.uld);
      }
      if (this.wvp != null) {
        paramVarArgs.e(5, this.wvp);
      }
      paramVarArgs.aO(7, this.cCc);
      AppMethodBeat.o(48780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wvn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wvn);
      }
      i = paramInt;
      if (this.wvo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvo);
      }
      paramInt = i;
      if (this.uld != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.uld);
      }
      i = paramInt;
      if (this.wvp != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wvp);
      }
      paramInt = e.a.a.b.b.a.bl(7, this.cCc);
      AppMethodBeat.o(48780);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ji localji = (ji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(48780);
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
            localji.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48780);
          return 0;
        case 2: 
          localji.wvn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48780);
          return 0;
        case 3: 
          localji.wvo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48780);
          return 0;
        case 4: 
          localji.uld = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48780);
          return 0;
        case 5: 
          localji.wvp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48780);
          return 0;
        }
        localji.cCc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48780);
        return 0;
      }
      AppMethodBeat.o(48780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ji
 * JD-Core Version:    0.7.0.1
 */