package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byn
  extends buy
{
  public int cpt;
  public String cwc;
  public int scene;
  public String url;
  public int wAy;
  public String wFW;
  public String wMy;
  public String xKU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56967);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wMy != null) {
        paramVarArgs.e(2, this.wMy);
      }
      if (this.cwc != null) {
        paramVarArgs.e(3, this.cwc);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      if (this.xKU != null) {
        paramVarArgs.e(5, this.xKU);
      }
      paramVarArgs.aO(6, this.scene);
      paramVarArgs.aO(7, this.cpt);
      if (this.wFW != null) {
        paramVarArgs.e(8, this.wFW);
      }
      paramVarArgs.aO(9, this.wAy);
      AppMethodBeat.o(56967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wMy != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wMy);
      }
      i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cwc);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt;
      if (this.xKU != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xKU);
      }
      i = i + e.a.a.b.b.a.bl(6, this.scene) + e.a.a.b.b.a.bl(7, this.cpt);
      paramInt = i;
      if (this.wFW != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wFW);
      }
      i = e.a.a.b.b.a.bl(9, this.wAy);
      AppMethodBeat.o(56967);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56967);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byn localbyn = (byn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56967);
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
            localbyn.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56967);
          return 0;
        case 2: 
          localbyn.wMy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56967);
          return 0;
        case 3: 
          localbyn.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56967);
          return 0;
        case 4: 
          localbyn.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56967);
          return 0;
        case 5: 
          localbyn.xKU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56967);
          return 0;
        case 6: 
          localbyn.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56967);
          return 0;
        case 7: 
          localbyn.cpt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56967);
          return 0;
        case 8: 
          localbyn.wFW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56967);
          return 0;
        }
        localbyn.wAy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56967);
        return 0;
      }
      AppMethodBeat.o(56967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byn
 * JD-Core Version:    0.7.0.1
 */