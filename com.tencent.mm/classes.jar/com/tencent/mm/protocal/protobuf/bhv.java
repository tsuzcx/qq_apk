package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhv
  extends buy
{
  public int cCc;
  public int cHp;
  public String poq;
  public String ubQ;
  public String wvn;
  public String wvo;
  public boolean xwO;
  public String xwP;
  public String xwQ;
  public int xwR;
  public String xwS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48905);
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
      if (this.xwP != null) {
        paramVarArgs.e(4, this.xwP);
      }
      if (this.xwQ != null) {
        paramVarArgs.e(5, this.xwQ);
      }
      if (this.ubQ != null) {
        paramVarArgs.e(6, this.ubQ);
      }
      if (this.poq != null) {
        paramVarArgs.e(7, this.poq);
      }
      paramVarArgs.aO(8, this.cCc);
      paramVarArgs.aO(9, this.xwR);
      paramVarArgs.aS(10, this.xwO);
      paramVarArgs.aO(11, this.cHp);
      if (this.xwS != null) {
        paramVarArgs.e(12, this.xwS);
      }
      AppMethodBeat.o(48905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
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
      if (this.xwP != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xwP);
      }
      i = paramInt;
      if (this.xwQ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xwQ);
      }
      paramInt = i;
      if (this.ubQ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ubQ);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.poq);
      }
      i = i + e.a.a.b.b.a.bl(8, this.cCc) + e.a.a.b.b.a.bl(9, this.xwR) + (e.a.a.b.b.a.eW(10) + 1) + e.a.a.b.b.a.bl(11, this.cHp);
      paramInt = i;
      if (this.xwS != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xwS);
      }
      AppMethodBeat.o(48905);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48905);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bhv localbhv = (bhv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48905);
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
            localbhv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48905);
          return 0;
        case 2: 
          localbhv.wvn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48905);
          return 0;
        case 3: 
          localbhv.wvo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48905);
          return 0;
        case 4: 
          localbhv.xwP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48905);
          return 0;
        case 5: 
          localbhv.xwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48905);
          return 0;
        case 6: 
          localbhv.ubQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48905);
          return 0;
        case 7: 
          localbhv.poq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48905);
          return 0;
        case 8: 
          localbhv.cCc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48905);
          return 0;
        case 9: 
          localbhv.xwR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48905);
          return 0;
        case 10: 
          localbhv.xwO = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(48905);
          return 0;
        case 11: 
          localbhv.cHp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48905);
          return 0;
        }
        localbhv.xwS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48905);
        return 0;
      }
      AppMethodBeat.o(48905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhv
 * JD-Core Version:    0.7.0.1
 */