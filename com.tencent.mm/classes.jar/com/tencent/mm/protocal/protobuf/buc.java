package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buc
  extends buy
{
  public String cHn;
  public String kml;
  public double latitude;
  public double longitude;
  public int xHu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89129);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.f(2, this.longitude);
      paramVarArgs.f(3, this.latitude);
      paramVarArgs.aO(4, this.xHu);
      if (this.kml != null) {
        paramVarArgs.e(5, this.kml);
      }
      if (this.cHn != null) {
        paramVarArgs.e(6, this.cHn);
      }
      AppMethodBeat.o(89129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 8) + (e.a.a.b.b.a.eW(3) + 8) + e.a.a.b.b.a.bl(4, this.xHu);
      paramInt = i;
      if (this.kml != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.kml);
      }
      i = paramInt;
      if (this.cHn != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.cHn);
      }
      AppMethodBeat.o(89129);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89129);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        buc localbuc = (buc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89129);
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
            localbuc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89129);
          return 0;
        case 2: 
          localbuc.longitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(89129);
          return 0;
        case 3: 
          localbuc.latitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(89129);
          return 0;
        case 4: 
          localbuc.xHu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89129);
          return 0;
        case 5: 
          localbuc.kml = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89129);
          return 0;
        }
        localbuc.cHn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89129);
        return 0;
      }
      AppMethodBeat.o(89129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buc
 * JD-Core Version:    0.7.0.1
 */