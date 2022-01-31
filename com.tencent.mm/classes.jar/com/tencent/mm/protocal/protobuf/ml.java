package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ml
  extends buy
{
  public int cCy;
  public int okH;
  public int qiP;
  public String qiQ;
  public String qiR;
  public String qkk;
  public String qkn;
  public String wAX;
  public int wAY;
  public String wpt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56720);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.okH);
      paramVarArgs.aO(3, this.cCy);
      paramVarArgs.aO(4, this.qiP);
      if (this.wAX != null) {
        paramVarArgs.e(5, this.wAX);
      }
      if (this.qkk != null) {
        paramVarArgs.e(6, this.qkk);
      }
      if (this.qiQ != null) {
        paramVarArgs.e(7, this.qiQ);
      }
      if (this.qkn != null) {
        paramVarArgs.e(8, this.qkn);
      }
      if (this.wpt != null) {
        paramVarArgs.e(9, this.wpt);
      }
      if (this.qiR != null) {
        paramVarArgs.e(10, this.qiR);
      }
      paramVarArgs.aO(11, this.wAY);
      AppMethodBeat.o(56720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.okH) + e.a.a.b.b.a.bl(3, this.cCy) + e.a.a.b.b.a.bl(4, this.qiP);
      paramInt = i;
      if (this.wAX != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wAX);
      }
      i = paramInt;
      if (this.qkk != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.qkk);
      }
      paramInt = i;
      if (this.qiQ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.qiQ);
      }
      i = paramInt;
      if (this.qkn != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.qkn);
      }
      paramInt = i;
      if (this.wpt != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wpt);
      }
      i = paramInt;
      if (this.qiR != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.qiR);
      }
      paramInt = e.a.a.b.b.a.bl(11, this.wAY);
      AppMethodBeat.o(56720);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ml localml = (ml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56720);
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
            localml.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56720);
          return 0;
        case 2: 
          localml.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56720);
          return 0;
        case 3: 
          localml.cCy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56720);
          return 0;
        case 4: 
          localml.qiP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56720);
          return 0;
        case 5: 
          localml.wAX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56720);
          return 0;
        case 6: 
          localml.qkk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56720);
          return 0;
        case 7: 
          localml.qiQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56720);
          return 0;
        case 8: 
          localml.qkn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56720);
          return 0;
        case 9: 
          localml.wpt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56720);
          return 0;
        case 10: 
          localml.qiR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56720);
          return 0;
        }
        localml.wAY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56720);
        return 0;
      }
      AppMethodBeat.o(56720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ml
 * JD-Core Version:    0.7.0.1
 */