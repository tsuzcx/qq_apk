package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aic
  extends buy
{
  public int cHp;
  public String kWU;
  public String kWn;
  public String sign;
  public String wZY;
  public String wlF;
  public String wlG;
  public int wlH;
  public LinkedList<ot> wlK;
  
  public aic()
  {
    AppMethodBeat.i(89079);
    this.wlK = new LinkedList();
    AppMethodBeat.o(89079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89080);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wlK);
      paramVarArgs.aO(3, this.cHp);
      if (this.kWU != null) {
        paramVarArgs.e(4, this.kWU);
      }
      if (this.kWn != null) {
        paramVarArgs.e(5, this.kWn);
      }
      if (this.sign != null) {
        paramVarArgs.e(6, this.sign);
      }
      if (this.wlF != null) {
        paramVarArgs.e(7, this.wlF);
      }
      if (this.wlG != null) {
        paramVarArgs.e(8, this.wlG);
      }
      if (this.wZY != null) {
        paramVarArgs.e(9, this.wZY);
      }
      paramVarArgs.aO(10, this.wlH);
      AppMethodBeat.o(89080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wlK) + e.a.a.b.b.a.bl(3, this.cHp);
      paramInt = i;
      if (this.kWU != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kWU);
      }
      i = paramInt;
      if (this.kWn != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.kWn);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.sign);
      }
      i = paramInt;
      if (this.wlF != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wlF);
      }
      paramInt = i;
      if (this.wlG != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wlG);
      }
      i = paramInt;
      if (this.wZY != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wZY);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.wlH);
      AppMethodBeat.o(89080);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wlK.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aic localaic = (aic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89080);
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
            localaic.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89080);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ot();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ot)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaic.wlK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89080);
          return 0;
        case 3: 
          localaic.cHp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89080);
          return 0;
        case 4: 
          localaic.kWU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89080);
          return 0;
        case 5: 
          localaic.kWn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89080);
          return 0;
        case 6: 
          localaic.sign = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89080);
          return 0;
        case 7: 
          localaic.wlF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89080);
          return 0;
        case 8: 
          localaic.wlG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89080);
          return 0;
        case 9: 
          localaic.wZY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89080);
          return 0;
        }
        localaic.wlH = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89080);
        return 0;
      }
      AppMethodBeat.o(89080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aic
 * JD-Core Version:    0.7.0.1
 */