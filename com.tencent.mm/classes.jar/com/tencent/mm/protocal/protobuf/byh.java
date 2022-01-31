package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byh
  extends buy
{
  public String xHR;
  public long xIh;
  public long xIm;
  public int xKC;
  public long xKD;
  public boolean xKE;
  public dav xKF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151927);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xHR != null) {
        paramVarArgs.e(2, this.xHR);
      }
      paramVarArgs.am(3, this.xIh);
      paramVarArgs.aO(4, this.xKC);
      paramVarArgs.am(5, this.xKD);
      paramVarArgs.aS(6, this.xKE);
      if (this.xKF != null)
      {
        paramVarArgs.iQ(7, this.xKF.computeSize());
        this.xKF.writeFields(paramVarArgs);
      }
      paramVarArgs.am(8, this.xIm);
      AppMethodBeat.o(151927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xHR != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xHR);
      }
      i = i + e.a.a.b.b.a.p(3, this.xIh) + e.a.a.b.b.a.bl(4, this.xKC) + e.a.a.b.b.a.p(5, this.xKD) + (e.a.a.b.b.a.eW(6) + 1);
      paramInt = i;
      if (this.xKF != null) {
        paramInt = i + e.a.a.a.iP(7, this.xKF.computeSize());
      }
      i = e.a.a.b.b.a.p(8, this.xIm);
      AppMethodBeat.o(151927);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byh localbyh = (byh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151927);
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
            localbyh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151927);
          return 0;
        case 2: 
          localbyh.xHR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151927);
          return 0;
        case 3: 
          localbyh.xIh = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(151927);
          return 0;
        case 4: 
          localbyh.xKC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151927);
          return 0;
        case 5: 
          localbyh.xKD = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(151927);
          return 0;
        case 6: 
          localbyh.xKE = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(151927);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dav();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dav)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyh.xKF = ((dav)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151927);
          return 0;
        }
        localbyh.xIm = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(151927);
        return 0;
      }
      AppMethodBeat.o(151927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byh
 * JD-Core Version:    0.7.0.1
 */