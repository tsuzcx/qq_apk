package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class csm
  extends buy
{
  public int wQP;
  public long wQQ;
  public SKBuiltinBuffer_t wtq;
  public int xCv;
  public int yaZ;
  public int yba;
  public int ybb;
  public int ybc;
  public int ybd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5242);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wtq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(5242);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.xCv);
      paramVarArgs.aO(5, this.yaZ);
      paramVarArgs.aO(6, this.yba);
      paramVarArgs.aO(7, this.ybb);
      paramVarArgs.aO(8, this.ybc);
      paramVarArgs.aO(9, this.ybd);
      if (this.wtq != null)
      {
        paramVarArgs.iQ(10, this.wtq.computeSize());
        this.wtq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5242);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wQP) + e.a.a.b.b.a.p(3, this.wQQ) + e.a.a.b.b.a.bl(4, this.xCv) + e.a.a.b.b.a.bl(5, this.yaZ) + e.a.a.b.b.a.bl(6, this.yba) + e.a.a.b.b.a.bl(7, this.ybb) + e.a.a.b.b.a.bl(8, this.ybc) + e.a.a.b.b.a.bl(9, this.ybd);
      paramInt = i;
      if (this.wtq != null) {
        paramInt = i + e.a.a.a.iP(10, this.wtq.computeSize());
      }
      AppMethodBeat.o(5242);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wtq == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(5242);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5242);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csm localcsm = (csm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5242);
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
            localcsm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5242);
          return 0;
        case 2: 
          localcsm.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5242);
          return 0;
        case 3: 
          localcsm.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5242);
          return 0;
        case 4: 
          localcsm.xCv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5242);
          return 0;
        case 5: 
          localcsm.yaZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5242);
          return 0;
        case 6: 
          localcsm.yba = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5242);
          return 0;
        case 7: 
          localcsm.ybb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5242);
          return 0;
        case 8: 
          localcsm.ybc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5242);
          return 0;
        case 9: 
          localcsm.ybd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5242);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcsm.wtq = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5242);
        return 0;
      }
      AppMethodBeat.o(5242);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csm
 * JD-Core Version:    0.7.0.1
 */