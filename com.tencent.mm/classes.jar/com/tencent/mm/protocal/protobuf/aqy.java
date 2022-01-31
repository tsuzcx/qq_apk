package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aqy
  extends bvk
{
  public int xge;
  public String xgf;
  public int xgg;
  public String xgh;
  public int xgi;
  public LinkedList<bwc> xgj;
  public String xgk;
  public int xgl;
  public String xgm;
  public int xgn;
  public SKBuiltinBuffer_t xgo;
  
  public aqy()
  {
    AppMethodBeat.i(80102);
    this.xgj = new LinkedList();
    AppMethodBeat.o(80102);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80103);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80103);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xge);
      if (this.xgf != null) {
        paramVarArgs.e(3, this.xgf);
      }
      paramVarArgs.aO(4, this.xgg);
      if (this.xgh != null) {
        paramVarArgs.e(5, this.xgh);
      }
      paramVarArgs.aO(6, this.xgi);
      paramVarArgs.e(7, 8, this.xgj);
      if (this.xgk != null) {
        paramVarArgs.e(8, this.xgk);
      }
      paramVarArgs.aO(9, this.xgl);
      if (this.xgm != null) {
        paramVarArgs.e(10, this.xgm);
      }
      paramVarArgs.aO(11, this.xgn);
      if (this.xgo != null)
      {
        paramVarArgs.iQ(12, this.xgo.computeSize());
        this.xgo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(80103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xge);
      paramInt = i;
      if (this.xgf != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xgf);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xgg);
      paramInt = i;
      if (this.xgh != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xgh);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xgi) + e.a.a.a.c(7, 8, this.xgj);
      paramInt = i;
      if (this.xgk != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xgk);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.xgl);
      paramInt = i;
      if (this.xgm != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xgm);
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.xgn);
      paramInt = i;
      if (this.xgo != null) {
        paramInt = i + e.a.a.a.iP(12, this.xgo.computeSize());
      }
      AppMethodBeat.o(80103);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xgj.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(80103);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80103);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqy localaqy = (aqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80103);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80103);
          return 0;
        case 2: 
          localaqy.xge = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80103);
          return 0;
        case 3: 
          localaqy.xgf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80103);
          return 0;
        case 4: 
          localaqy.xgg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80103);
          return 0;
        case 5: 
          localaqy.xgh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80103);
          return 0;
        case 6: 
          localaqy.xgi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80103);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqy.xgj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80103);
          return 0;
        case 8: 
          localaqy.xgk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80103);
          return 0;
        case 9: 
          localaqy.xgl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80103);
          return 0;
        case 10: 
          localaqy.xgm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80103);
          return 0;
        case 11: 
          localaqy.xgn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80103);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaqy.xgo = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80103);
        return 0;
      }
      AppMethodBeat.o(80103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqy
 * JD-Core Version:    0.7.0.1
 */