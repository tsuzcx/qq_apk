package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwx
  extends buy
{
  public String cwc;
  public String state;
  public int wOS;
  public String xKa;
  public int xvR;
  public LinkedList<String> xvS;
  
  public bwx()
  {
    AppMethodBeat.i(10234);
    this.xvS = new LinkedList();
    AppMethodBeat.o(10234);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10235);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xvR);
      paramVarArgs.e(4, 1, this.xvS);
      if (this.cwc != null) {
        paramVarArgs.e(5, this.cwc);
      }
      if (this.state != null) {
        paramVarArgs.e(6, this.state);
      }
      if (this.xKa != null) {
        paramVarArgs.e(7, this.xKa);
      }
      paramVarArgs.aO(8, this.wOS);
      AppMethodBeat.o(10235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label659;
      }
    }
    label659:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(3, this.xvR) + e.a.a.a.c(4, 1, this.xvS);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cwc);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.state);
      }
      paramInt = i;
      if (this.xKa != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xKa);
      }
      i = e.a.a.b.b.a.bl(8, this.wOS);
      AppMethodBeat.o(10235);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xvS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bwx localbwx = (bwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(10235);
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
            localbwx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10235);
          return 0;
        case 3: 
          localbwx.xvR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10235);
          return 0;
        case 4: 
          localbwx.xvS.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(10235);
          return 0;
        case 5: 
          localbwx.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10235);
          return 0;
        case 6: 
          localbwx.state = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10235);
          return 0;
        case 7: 
          localbwx.xKa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10235);
          return 0;
        }
        localbwx.wOS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10235);
        return 0;
      }
      AppMethodBeat.o(10235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwx
 * JD-Core Version:    0.7.0.1
 */