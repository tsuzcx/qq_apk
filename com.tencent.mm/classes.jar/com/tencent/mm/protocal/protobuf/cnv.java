package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cnv
  extends buy
{
  public SKBuiltinBuffer_t pIA;
  public String pIw;
  public int pIx;
  public int pIy;
  public int pIz;
  public String wPh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(136946);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(136946);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pIw != null) {
        paramVarArgs.e(2, this.pIw);
      }
      paramVarArgs.aO(3, this.pIx);
      paramVarArgs.aO(4, this.pIy);
      paramVarArgs.aO(5, this.pIz);
      if (this.pIA != null)
      {
        paramVarArgs.iQ(6, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      if (this.wPh != null) {
        paramVarArgs.e(7, this.wPh);
      }
      AppMethodBeat.o(136946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pIw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.pIw);
      }
      i = i + e.a.a.b.b.a.bl(3, this.pIx) + e.a.a.b.b.a.bl(4, this.pIy) + e.a.a.b.b.a.bl(5, this.pIz);
      paramInt = i;
      if (this.pIA != null) {
        paramInt = i + e.a.a.a.iP(6, this.pIA.computeSize());
      }
      i = paramInt;
      if (this.wPh != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wPh);
      }
      AppMethodBeat.o(136946);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(136946);
          throw paramVarArgs;
        }
        AppMethodBeat.o(136946);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cnv localcnv = (cnv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(136946);
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
            localcnv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(136946);
          return 0;
        case 2: 
          localcnv.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(136946);
          return 0;
        case 3: 
          localcnv.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(136946);
          return 0;
        case 4: 
          localcnv.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(136946);
          return 0;
        case 5: 
          localcnv.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(136946);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcnv.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(136946);
          return 0;
        }
        localcnv.wPh = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(136946);
        return 0;
      }
      AppMethodBeat.o(136946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnv
 * JD-Core Version:    0.7.0.1
 */