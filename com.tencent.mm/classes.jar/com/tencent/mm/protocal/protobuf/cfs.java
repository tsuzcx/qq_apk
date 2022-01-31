package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfs
  extends buy
{
  public String cxF;
  public int xPV;
  public int xPW;
  public String xPY;
  public String xPZ;
  public String xQa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(59393);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xPZ != null) {
        paramVarArgs.e(2, this.xPZ);
      }
      if (this.xPY != null) {
        paramVarArgs.e(3, this.xPY);
      }
      if (this.xQa != null) {
        paramVarArgs.e(4, this.xQa);
      }
      if (this.cxF != null) {
        paramVarArgs.e(5, this.cxF);
      }
      paramVarArgs.aO(6, this.xPV);
      paramVarArgs.aO(7, this.xPW);
      AppMethodBeat.o(59393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xPZ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xPZ);
      }
      i = paramInt;
      if (this.xPY != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xPY);
      }
      paramInt = i;
      if (this.xQa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xQa);
      }
      i = paramInt;
      if (this.cxF != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.cxF);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.xPV);
      int j = e.a.a.b.b.a.bl(7, this.xPW);
      AppMethodBeat.o(59393);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(59393);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfs localcfs = (cfs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(59393);
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
            localcfs.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(59393);
          return 0;
        case 2: 
          localcfs.xPZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59393);
          return 0;
        case 3: 
          localcfs.xPY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59393);
          return 0;
        case 4: 
          localcfs.xQa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59393);
          return 0;
        case 5: 
          localcfs.cxF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59393);
          return 0;
        case 6: 
          localcfs.xPV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(59393);
          return 0;
        }
        localcfs.xPW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(59393);
        return 0;
      }
      AppMethodBeat.o(59393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfs
 * JD-Core Version:    0.7.0.1
 */