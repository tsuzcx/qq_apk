package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bki
  extends com.tencent.mm.bv.a
{
  public String czq;
  public long endTime = 0L;
  public long startTime = 0L;
  public String userName = "";
  public long xyE = 0L;
  public int xyJ = 0;
  public String xyK;
  public int xyL = -1;
  public bkf xyM;
  public String xyN = "";
  public boolean xyO = false;
  public String xyP = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152452);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.czq != null) {
        paramVarArgs.e(1, this.czq);
      }
      paramVarArgs.am(2, this.xyE);
      paramVarArgs.aO(3, this.xyJ);
      if (this.xyK != null) {
        paramVarArgs.e(4, this.xyK);
      }
      paramVarArgs.aO(5, this.xyL);
      paramVarArgs.am(6, this.startTime);
      paramVarArgs.am(7, this.endTime);
      if (this.xyM != null)
      {
        paramVarArgs.iQ(8, this.xyM.computeSize());
        this.xyM.writeFields(paramVarArgs);
      }
      if (this.xyN != null) {
        paramVarArgs.e(9, this.xyN);
      }
      paramVarArgs.aS(10, this.xyO);
      if (this.userName != null) {
        paramVarArgs.e(11, this.userName);
      }
      if (this.xyP != null) {
        paramVarArgs.e(12, this.xyP);
      }
      AppMethodBeat.o(152452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.czq == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = e.a.a.b.b.a.f(1, this.czq) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.xyE) + e.a.a.b.b.a.bl(3, this.xyJ);
      paramInt = i;
      if (this.xyK != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xyK);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xyL) + e.a.a.b.b.a.p(6, this.startTime) + e.a.a.b.b.a.p(7, this.endTime);
      paramInt = i;
      if (this.xyM != null) {
        paramInt = i + e.a.a.a.iP(8, this.xyM.computeSize());
      }
      i = paramInt;
      if (this.xyN != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xyN);
      }
      i += e.a.a.b.b.a.eW(10) + 1;
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.userName);
      }
      i = paramInt;
      if (this.xyP != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xyP);
      }
      AppMethodBeat.o(152452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bki localbki = (bki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152452);
          return -1;
        case 1: 
          localbki.czq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152452);
          return 0;
        case 2: 
          localbki.xyE = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(152452);
          return 0;
        case 3: 
          localbki.xyJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(152452);
          return 0;
        case 4: 
          localbki.xyK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152452);
          return 0;
        case 5: 
          localbki.xyL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(152452);
          return 0;
        case 6: 
          localbki.startTime = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(152452);
          return 0;
        case 7: 
          localbki.endTime = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(152452);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bkf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbki.xyM = ((bkf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152452);
          return 0;
        case 9: 
          localbki.xyN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152452);
          return 0;
        case 10: 
          localbki.xyO = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(152452);
          return 0;
        case 11: 
          localbki.userName = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152452);
          return 0;
        }
        localbki.xyP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(152452);
        return 0;
      }
      AppMethodBeat.o(152452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bki
 * JD-Core Version:    0.7.0.1
 */