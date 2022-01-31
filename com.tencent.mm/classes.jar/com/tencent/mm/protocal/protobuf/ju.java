package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ju
  extends buy
{
  public SKBuiltinBuffer_t wuh;
  public String wvL;
  public String wvM;
  public String wvW;
  public int wwi;
  public String wwj;
  public String wwk;
  public String wwl;
  public int wwm;
  public bwc wwn;
  public SKBuiltinBuffer_t wwo;
  public int wwp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73695);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wwi);
      if (this.wvW != null) {
        paramVarArgs.e(3, this.wvW);
      }
      if (this.wwj != null) {
        paramVarArgs.e(4, this.wwj);
      }
      if (this.wwk != null) {
        paramVarArgs.e(5, this.wwk);
      }
      if (this.wwl != null) {
        paramVarArgs.e(6, this.wwl);
      }
      paramVarArgs.aO(7, this.wwm);
      if (this.wwn != null)
      {
        paramVarArgs.iQ(8, this.wwn.computeSize());
        this.wwn.writeFields(paramVarArgs);
      }
      if (this.wwo != null)
      {
        paramVarArgs.iQ(9, this.wwo.computeSize());
        this.wwo.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.wwp);
      if (this.wvL != null) {
        paramVarArgs.e(11, this.wvL);
      }
      if (this.wvM != null) {
        paramVarArgs.e(12, this.wvM);
      }
      if (this.wuh != null)
      {
        paramVarArgs.iQ(13, this.wuh.computeSize());
        this.wuh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(73695);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wwi);
      paramInt = i;
      if (this.wvW != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wvW);
      }
      i = paramInt;
      if (this.wwj != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wwj);
      }
      paramInt = i;
      if (this.wwk != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wwk);
      }
      i = paramInt;
      if (this.wwl != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wwl);
      }
      i += e.a.a.b.b.a.bl(7, this.wwm);
      paramInt = i;
      if (this.wwn != null) {
        paramInt = i + e.a.a.a.iP(8, this.wwn.computeSize());
      }
      i = paramInt;
      if (this.wwo != null) {
        i = paramInt + e.a.a.a.iP(9, this.wwo.computeSize());
      }
      i += e.a.a.b.b.a.bl(10, this.wwp);
      paramInt = i;
      if (this.wvL != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wvL);
      }
      i = paramInt;
      if (this.wvM != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wvM);
      }
      paramInt = i;
      if (this.wuh != null) {
        paramInt = i + e.a.a.a.iP(13, this.wuh.computeSize());
      }
      AppMethodBeat.o(73695);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73695);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ju localju = (ju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73695);
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
            localju.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73695);
          return 0;
        case 2: 
          localju.wwi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73695);
          return 0;
        case 3: 
          localju.wvW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73695);
          return 0;
        case 4: 
          localju.wwj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73695);
          return 0;
        case 5: 
          localju.wwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73695);
          return 0;
        case 6: 
          localju.wwl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73695);
          return 0;
        case 7: 
          localju.wwm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73695);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localju.wwn = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73695);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localju.wwo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73695);
          return 0;
        case 10: 
          localju.wwp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73695);
          return 0;
        case 11: 
          localju.wvL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73695);
          return 0;
        case 12: 
          localju.wvM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73695);
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
          localju.wuh = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73695);
        return 0;
      }
      AppMethodBeat.o(73695);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ju
 * JD-Core Version:    0.7.0.1
 */