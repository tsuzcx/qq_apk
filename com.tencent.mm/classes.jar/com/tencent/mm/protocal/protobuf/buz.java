package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class buz
  extends buy
{
  public String poq;
  public int qgh;
  public String qgu;
  public String qgv;
  public int wBk;
  public String wry;
  public int xID;
  public String xIE;
  public int xIF;
  public int xIG;
  public b xIH;
  public String xxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48955);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qgu != null) {
        paramVarArgs.e(2, this.qgu);
      }
      if (this.qgv != null) {
        paramVarArgs.e(3, this.qgv);
      }
      if (this.poq != null) {
        paramVarArgs.e(4, this.poq);
      }
      paramVarArgs.aO(5, this.qgh);
      paramVarArgs.aO(6, this.xID);
      if (this.xIE != null) {
        paramVarArgs.e(7, this.xIE);
      }
      paramVarArgs.aO(8, this.xIF);
      paramVarArgs.aO(9, this.xIG);
      if (this.wry != null) {
        paramVarArgs.e(10, this.wry);
      }
      if (this.xxV != null) {
        paramVarArgs.e(11, this.xxV);
      }
      if (this.xIH != null) {
        paramVarArgs.c(12, this.xIH);
      }
      paramVarArgs.aO(13, this.wBk);
      AppMethodBeat.o(48955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qgu != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.qgu);
      }
      i = paramInt;
      if (this.qgv != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.qgv);
      }
      paramInt = i;
      if (this.poq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.poq);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.qgh) + e.a.a.b.b.a.bl(6, this.xID);
      paramInt = i;
      if (this.xIE != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xIE);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xIF) + e.a.a.b.b.a.bl(9, this.xIG);
      paramInt = i;
      if (this.wry != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wry);
      }
      i = paramInt;
      if (this.xxV != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.xxV);
      }
      paramInt = i;
      if (this.xIH != null) {
        paramInt = i + e.a.a.b.b.a.b(12, this.xIH);
      }
      i = e.a.a.b.b.a.bl(13, this.wBk);
      AppMethodBeat.o(48955);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        buz localbuz = (buz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48955);
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
            localbuz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48955);
          return 0;
        case 2: 
          localbuz.qgu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48955);
          return 0;
        case 3: 
          localbuz.qgv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48955);
          return 0;
        case 4: 
          localbuz.poq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48955);
          return 0;
        case 5: 
          localbuz.qgh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48955);
          return 0;
        case 6: 
          localbuz.xID = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48955);
          return 0;
        case 7: 
          localbuz.xIE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48955);
          return 0;
        case 8: 
          localbuz.xIF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48955);
          return 0;
        case 9: 
          localbuz.xIG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48955);
          return 0;
        case 10: 
          localbuz.wry = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48955);
          return 0;
        case 11: 
          localbuz.xxV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48955);
          return 0;
        case 12: 
          localbuz.xIH = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(48955);
          return 0;
        }
        localbuz.wBk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48955);
        return 0;
      }
      AppMethodBeat.o(48955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buz
 * JD-Core Version:    0.7.0.1
 */