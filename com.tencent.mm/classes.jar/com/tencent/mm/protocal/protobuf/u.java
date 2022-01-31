package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class u
  extends buy
{
  public int scene;
  public String sign;
  public int ver;
  public String wjW;
  public String wjX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56689);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wjW != null) {
        paramVarArgs.e(2, this.wjW);
      }
      paramVarArgs.aO(3, this.scene);
      if (this.wjX != null) {
        paramVarArgs.e(4, this.wjX);
      }
      if (this.sign != null) {
        paramVarArgs.e(5, this.sign);
      }
      paramVarArgs.aO(6, this.ver);
      AppMethodBeat.o(56689);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wjW != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wjW);
      }
      i += e.a.a.b.b.a.bl(3, this.scene);
      paramInt = i;
      if (this.wjX != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wjX);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.sign);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.ver);
      AppMethodBeat.o(56689);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56689);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56689);
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
            localu.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56689);
          return 0;
        case 2: 
          localu.wjW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56689);
          return 0;
        case 3: 
          localu.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56689);
          return 0;
        case 4: 
          localu.wjX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56689);
          return 0;
        case 5: 
          localu.sign = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56689);
          return 0;
        }
        localu.ver = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56689);
        return 0;
      }
      AppMethodBeat.o(56689);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.u
 * JD-Core Version:    0.7.0.1
 */