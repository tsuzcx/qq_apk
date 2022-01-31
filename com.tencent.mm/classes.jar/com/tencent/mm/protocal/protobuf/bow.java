package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bow
  extends buy
{
  public long appid;
  public int coO;
  public int platform;
  public int scene;
  public long wyE;
  public int xCW;
  public long xCX;
  public int xCY;
  public long xCZ;
  public long xDa;
  public String xzN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11794);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xCW);
      paramVarArgs.am(3, this.xCX);
      paramVarArgs.am(4, this.appid);
      paramVarArgs.am(5, this.wyE);
      paramVarArgs.aO(6, this.xCY);
      paramVarArgs.aO(7, this.scene);
      paramVarArgs.aO(8, this.coO);
      paramVarArgs.am(9, this.xCZ);
      paramVarArgs.am(10, this.xDa);
      paramVarArgs.aO(11, this.platform);
      if (this.xzN != null) {
        paramVarArgs.e(12, this.xzN);
      }
      AppMethodBeat.o(11794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label824;
      }
    }
    label824:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xCW) + e.a.a.b.b.a.p(3, this.xCX) + e.a.a.b.b.a.p(4, this.appid) + e.a.a.b.b.a.p(5, this.wyE) + e.a.a.b.b.a.bl(6, this.xCY) + e.a.a.b.b.a.bl(7, this.scene) + e.a.a.b.b.a.bl(8, this.coO) + e.a.a.b.b.a.p(9, this.xCZ) + e.a.a.b.b.a.p(10, this.xDa) + e.a.a.b.b.a.bl(11, this.platform);
      paramInt = i;
      if (this.xzN != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xzN);
      }
      AppMethodBeat.o(11794);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bow localbow = (bow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11794);
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
            localbow.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11794);
          return 0;
        case 2: 
          localbow.xCW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11794);
          return 0;
        case 3: 
          localbow.xCX = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(11794);
          return 0;
        case 4: 
          localbow.appid = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(11794);
          return 0;
        case 5: 
          localbow.wyE = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(11794);
          return 0;
        case 6: 
          localbow.xCY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11794);
          return 0;
        case 7: 
          localbow.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11794);
          return 0;
        case 8: 
          localbow.coO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11794);
          return 0;
        case 9: 
          localbow.xCZ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(11794);
          return 0;
        case 10: 
          localbow.xDa = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(11794);
          return 0;
        case 11: 
          localbow.platform = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11794);
          return 0;
        }
        localbow.xzN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(11794);
        return 0;
      }
      AppMethodBeat.o(11794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bow
 * JD-Core Version:    0.7.0.1
 */