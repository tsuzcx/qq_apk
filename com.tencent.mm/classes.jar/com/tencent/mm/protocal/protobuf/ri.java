package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ri
  extends buy
{
  public String fMs;
  public String nul;
  public String num;
  public String wDo;
  public String wJA;
  public String wJB;
  public long wJz;
  public int wrs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135752);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.num != null) {
        paramVarArgs.e(2, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(3, this.nul);
      }
      paramVarArgs.am(4, this.wJz);
      if (this.wDo != null) {
        paramVarArgs.e(5, this.wDo);
      }
      if (this.wJA != null) {
        paramVarArgs.e(6, this.wJA);
      }
      paramVarArgs.aO(7, this.wrs);
      if (this.wJB != null) {
        paramVarArgs.e(8, this.wJB);
      }
      if (this.fMs != null) {
        paramVarArgs.e(9, this.fMs);
      }
      AppMethodBeat.o(135752);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label766;
      }
    }
    label766:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nul);
      }
      i += e.a.a.b.b.a.p(4, this.wJz);
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wDo);
      }
      i = paramInt;
      if (this.wJA != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wJA);
      }
      i += e.a.a.b.b.a.bl(7, this.wrs);
      paramInt = i;
      if (this.wJB != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wJB);
      }
      i = paramInt;
      if (this.fMs != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.fMs);
      }
      AppMethodBeat.o(135752);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(135752);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ri localri = (ri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(135752);
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
            localri.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135752);
          return 0;
        case 2: 
          localri.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135752);
          return 0;
        case 3: 
          localri.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135752);
          return 0;
        case 4: 
          localri.wJz = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135752);
          return 0;
        case 5: 
          localri.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135752);
          return 0;
        case 6: 
          localri.wJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135752);
          return 0;
        case 7: 
          localri.wrs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135752);
          return 0;
        case 8: 
          localri.wJB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135752);
          return 0;
        }
        localri.fMs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(135752);
        return 0;
      }
      AppMethodBeat.o(135752);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ri
 * JD-Core Version:    0.7.0.1
 */