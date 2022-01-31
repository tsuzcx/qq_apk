package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gt
  extends buy
{
  public int Scene;
  public long jJO;
  public int wta;
  public LinkedList<vd> wtb;
  public String wtc;
  public String wtd;
  public String wte;
  public String wtf;
  
  public gt()
  {
    AppMethodBeat.i(28327);
    this.wtb = new LinkedList();
    AppMethodBeat.o(28327);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28328);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wta);
      paramVarArgs.e(3, 8, this.wtb);
      if (this.wtc != null) {
        paramVarArgs.e(4, this.wtc);
      }
      if (this.wtd != null) {
        paramVarArgs.e(5, this.wtd);
      }
      paramVarArgs.aO(6, this.Scene);
      paramVarArgs.am(7, this.jJO);
      if (this.wte != null) {
        paramVarArgs.e(8, this.wte);
      }
      if (this.wtf != null) {
        paramVarArgs.e(9, this.wtf);
      }
      AppMethodBeat.o(28328);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wta) + e.a.a.a.c(3, 8, this.wtb);
      paramInt = i;
      if (this.wtc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wtc);
      }
      i = paramInt;
      if (this.wtd != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wtd);
      }
      i = i + e.a.a.b.b.a.bl(6, this.Scene) + e.a.a.b.b.a.p(7, this.jJO);
      paramInt = i;
      if (this.wte != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wte);
      }
      i = paramInt;
      if (this.wtf != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wtf);
      }
      AppMethodBeat.o(28328);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wtb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28328);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        gt localgt = (gt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28328);
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
            localgt.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28328);
          return 0;
        case 2: 
          localgt.wta = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28328);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localgt.wtb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28328);
          return 0;
        case 4: 
          localgt.wtc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28328);
          return 0;
        case 5: 
          localgt.wtd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28328);
          return 0;
        case 6: 
          localgt.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28328);
          return 0;
        case 7: 
          localgt.jJO = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28328);
          return 0;
        case 8: 
          localgt.wte = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28328);
          return 0;
        }
        localgt.wtf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28328);
        return 0;
      }
      AppMethodBeat.o(28328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gt
 * JD-Core Version:    0.7.0.1
 */