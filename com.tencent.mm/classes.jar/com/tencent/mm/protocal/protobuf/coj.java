package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class coj
  extends buy
{
  public int niE;
  public SKBuiltinBuffer_t pIA;
  public int pIx;
  public int pIy;
  public int pIz;
  public bwc xXd;
  public bwc xXe;
  public int xXf;
  public int xXg;
  public int xXh;
  public int xXi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116809);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xXd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientMediaId");
        AppMethodBeat.o(116809);
        throw paramVarArgs;
      }
      if (this.xXe == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataMD5");
        AppMethodBeat.o(116809);
        throw paramVarArgs;
      }
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(116809);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xXd != null)
      {
        paramVarArgs.iQ(2, this.xXd.computeSize());
        this.xXd.writeFields(paramVarArgs);
      }
      if (this.xXe != null)
      {
        paramVarArgs.iQ(3, this.xXe.computeSize());
        this.xXe.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.pIx);
      paramVarArgs.aO(5, this.pIy);
      paramVarArgs.aO(6, this.pIz);
      if (this.pIA != null)
      {
        paramVarArgs.iQ(7, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.niE);
      paramVarArgs.aO(9, this.xXf);
      paramVarArgs.aO(10, this.xXg);
      paramVarArgs.aO(11, this.xXh);
      paramVarArgs.aO(12, this.xXi);
      AppMethodBeat.o(116809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1286;
      }
    }
    label1286:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xXd != null) {
        paramInt = i + e.a.a.a.iP(2, this.xXd.computeSize());
      }
      i = paramInt;
      if (this.xXe != null) {
        i = paramInt + e.a.a.a.iP(3, this.xXe.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(4, this.pIx) + e.a.a.b.b.a.bl(5, this.pIy) + e.a.a.b.b.a.bl(6, this.pIz);
      paramInt = i;
      if (this.pIA != null) {
        paramInt = i + e.a.a.a.iP(7, this.pIA.computeSize());
      }
      i = e.a.a.b.b.a.bl(8, this.niE);
      int j = e.a.a.b.b.a.bl(9, this.xXf);
      int k = e.a.a.b.b.a.bl(10, this.xXg);
      int m = e.a.a.b.b.a.bl(11, this.xXh);
      int n = e.a.a.b.b.a.bl(12, this.xXi);
      AppMethodBeat.o(116809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xXd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientMediaId");
          AppMethodBeat.o(116809);
          throw paramVarArgs;
        }
        if (this.xXe == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataMD5");
          AppMethodBeat.o(116809);
          throw paramVarArgs;
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(116809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        coj localcoj = (coj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116809);
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
            localcoj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116809);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoj.xXd = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116809);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoj.xXe = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116809);
          return 0;
        case 4: 
          localcoj.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116809);
          return 0;
        case 5: 
          localcoj.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116809);
          return 0;
        case 6: 
          localcoj.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116809);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoj.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116809);
          return 0;
        case 8: 
          localcoj.niE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116809);
          return 0;
        case 9: 
          localcoj.xXf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116809);
          return 0;
        case 10: 
          localcoj.xXg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116809);
          return 0;
        case 11: 
          localcoj.xXh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116809);
          return 0;
        }
        localcoj.xXi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116809);
        return 0;
      }
      AppMethodBeat.o(116809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coj
 * JD-Core Version:    0.7.0.1
 */