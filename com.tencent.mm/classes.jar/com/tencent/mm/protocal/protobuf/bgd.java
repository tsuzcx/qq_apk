package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bgd
  extends buy
{
  public int Scene;
  public int wzU;
  public int xuW;
  public b xuX;
  public int xuY;
  public b xuZ;
  public String xva;
  public String xvb;
  public String xvc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(81502);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wzU);
      paramVarArgs.aO(3, this.xuW);
      if (this.xuX != null) {
        paramVarArgs.c(4, this.xuX);
      }
      paramVarArgs.aO(5, this.xuY);
      if (this.xuZ != null) {
        paramVarArgs.c(6, this.xuZ);
      }
      if (this.xva != null) {
        paramVarArgs.e(7, this.xva);
      }
      if (this.xvb != null) {
        paramVarArgs.e(8, this.xvb);
      }
      if (this.xvc != null) {
        paramVarArgs.e(9, this.xvc);
      }
      paramVarArgs.aO(10, this.Scene);
      AppMethodBeat.o(81502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wzU) + e.a.a.b.b.a.bl(3, this.xuW);
      paramInt = i;
      if (this.xuX != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xuX);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xuY);
      paramInt = i;
      if (this.xuZ != null) {
        paramInt = i + e.a.a.b.b.a.b(6, this.xuZ);
      }
      i = paramInt;
      if (this.xva != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xva);
      }
      paramInt = i;
      if (this.xvb != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xvb);
      }
      i = paramInt;
      if (this.xvc != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xvc);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.Scene);
      AppMethodBeat.o(81502);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(81502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bgd localbgd = (bgd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(81502);
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
            localbgd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(81502);
          return 0;
        case 2: 
          localbgd.wzU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(81502);
          return 0;
        case 3: 
          localbgd.xuW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(81502);
          return 0;
        case 4: 
          localbgd.xuX = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(81502);
          return 0;
        case 5: 
          localbgd.xuY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(81502);
          return 0;
        case 6: 
          localbgd.xuZ = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(81502);
          return 0;
        case 7: 
          localbgd.xva = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(81502);
          return 0;
        case 8: 
          localbgd.xvb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(81502);
          return 0;
        case 9: 
          localbgd.xvc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(81502);
          return 0;
        }
        localbgd.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(81502);
        return 0;
      }
      AppMethodBeat.o(81502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgd
 * JD-Core Version:    0.7.0.1
 */