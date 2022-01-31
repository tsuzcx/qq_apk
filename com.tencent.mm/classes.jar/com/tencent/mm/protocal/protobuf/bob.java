package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bob
  extends buy
{
  public String xCn;
  public String xCo;
  public String xCp;
  public String xCq;
  public String xCr;
  public int xCs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28577);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xCn != null) {
        paramVarArgs.e(2, this.xCn);
      }
      if (this.xCo != null) {
        paramVarArgs.e(3, this.xCo);
      }
      if (this.xCp != null) {
        paramVarArgs.e(4, this.xCp);
      }
      if (this.xCq != null) {
        paramVarArgs.e(5, this.xCq);
      }
      if (this.xCr != null) {
        paramVarArgs.e(6, this.xCr);
      }
      paramVarArgs.aO(7, this.xCs);
      AppMethodBeat.o(28577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label671;
      }
    }
    label671:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xCn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xCn);
      }
      i = paramInt;
      if (this.xCo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xCo);
      }
      paramInt = i;
      if (this.xCp != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xCp);
      }
      i = paramInt;
      if (this.xCq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xCq);
      }
      paramInt = i;
      if (this.xCr != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xCr);
      }
      i = e.a.a.b.b.a.bl(7, this.xCs);
      AppMethodBeat.o(28577);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28577);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bob localbob = (bob)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28577);
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
            localbob.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28577);
          return 0;
        case 2: 
          localbob.xCn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28577);
          return 0;
        case 3: 
          localbob.xCo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28577);
          return 0;
        case 4: 
          localbob.xCp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28577);
          return 0;
        case 5: 
          localbob.xCq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28577);
          return 0;
        case 6: 
          localbob.xCr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28577);
          return 0;
        }
        localbob.xCs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28577);
        return 0;
      }
      AppMethodBeat.o(28577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bob
 * JD-Core Version:    0.7.0.1
 */