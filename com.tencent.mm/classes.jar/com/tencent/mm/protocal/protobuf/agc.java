package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class agc
  extends buy
{
  public String app_id;
  public String kml;
  public b koK;
  public int kwG;
  public String kwH;
  public String kwI;
  public String kwJ;
  public String kwK;
  public int time_stamp;
  public int wZe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89067);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.e(2, this.app_id);
      }
      paramVarArgs.aO(3, this.kwG);
      if (this.kwH != null) {
        paramVarArgs.e(4, this.kwH);
      }
      if (this.kwI != null) {
        paramVarArgs.e(5, this.kwI);
      }
      paramVarArgs.aO(6, this.time_stamp);
      if (this.kwJ != null) {
        paramVarArgs.e(7, this.kwJ);
      }
      if (this.kml != null) {
        paramVarArgs.e(8, this.kml);
      }
      if (this.kwK != null) {
        paramVarArgs.e(9, this.kwK);
      }
      if (this.koK != null) {
        paramVarArgs.c(10, this.koK);
      }
      paramVarArgs.aO(11, this.wZe);
      AppMethodBeat.o(89067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.app_id);
      }
      i += e.a.a.b.b.a.bl(3, this.kwG);
      paramInt = i;
      if (this.kwH != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kwH);
      }
      i = paramInt;
      if (this.kwI != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.kwI);
      }
      i += e.a.a.b.b.a.bl(6, this.time_stamp);
      paramInt = i;
      if (this.kwJ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.kwJ);
      }
      i = paramInt;
      if (this.kml != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.kml);
      }
      paramInt = i;
      if (this.kwK != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.kwK);
      }
      i = paramInt;
      if (this.koK != null) {
        i = paramInt + e.a.a.b.b.a.b(10, this.koK);
      }
      paramInt = e.a.a.b.b.a.bl(11, this.wZe);
      AppMethodBeat.o(89067);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89067);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agc localagc = (agc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89067);
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
            localagc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89067);
          return 0;
        case 2: 
          localagc.app_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89067);
          return 0;
        case 3: 
          localagc.kwG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89067);
          return 0;
        case 4: 
          localagc.kwH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89067);
          return 0;
        case 5: 
          localagc.kwI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89067);
          return 0;
        case 6: 
          localagc.time_stamp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89067);
          return 0;
        case 7: 
          localagc.kwJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89067);
          return 0;
        case 8: 
          localagc.kml = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89067);
          return 0;
        case 9: 
          localagc.kwK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89067);
          return 0;
        case 10: 
          localagc.koK = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(89067);
          return 0;
        }
        localagc.wZe = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89067);
        return 0;
      }
      AppMethodBeat.o(89067);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agc
 * JD-Core Version:    0.7.0.1
 */