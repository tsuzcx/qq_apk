package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class byp
  extends buy
{
  public String Md5;
  public String gwS;
  public int wDq;
  public int wQz;
  public int wrs;
  public dx xKW;
  public String xKX;
  public String xKY;
  public int xKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28629);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xKW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(28629);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xKW != null)
      {
        paramVarArgs.iQ(2, this.xKW.computeSize());
        this.xKW.writeFields(paramVarArgs);
      }
      if (this.xKX != null) {
        paramVarArgs.e(3, this.xKX);
      }
      paramVarArgs.aO(4, this.wQz);
      if (this.Md5 != null) {
        paramVarArgs.e(5, this.Md5);
      }
      paramVarArgs.aO(6, this.wrs);
      if (this.gwS != null) {
        paramVarArgs.e(7, this.gwS);
      }
      if (this.xKY != null) {
        paramVarArgs.e(8, this.xKY);
      }
      paramVarArgs.aO(9, this.xKZ);
      paramVarArgs.aO(10, this.wDq);
      AppMethodBeat.o(28629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xKW != null) {
        paramInt = i + e.a.a.a.iP(2, this.xKW.computeSize());
      }
      i = paramInt;
      if (this.xKX != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xKX);
      }
      i += e.a.a.b.b.a.bl(4, this.wQz);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.Md5);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wrs);
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.gwS);
      }
      i = paramInt;
      if (this.xKY != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xKY);
      }
      paramInt = e.a.a.b.b.a.bl(9, this.xKZ);
      int j = e.a.a.b.b.a.bl(10, this.wDq);
      AppMethodBeat.o(28629);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xKW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(28629);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byp localbyp = (byp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28629);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28629);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyp.xKW = ((dx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28629);
          return 0;
        case 3: 
          localbyp.xKX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28629);
          return 0;
        case 4: 
          localbyp.wQz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28629);
          return 0;
        case 5: 
          localbyp.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28629);
          return 0;
        case 6: 
          localbyp.wrs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28629);
          return 0;
        case 7: 
          localbyp.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28629);
          return 0;
        case 8: 
          localbyp.xKY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28629);
          return 0;
        case 9: 
          localbyp.xKZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28629);
          return 0;
        }
        localbyp.wDq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28629);
        return 0;
      }
      AppMethodBeat.o(28629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byp
 * JD-Core Version:    0.7.0.1
 */