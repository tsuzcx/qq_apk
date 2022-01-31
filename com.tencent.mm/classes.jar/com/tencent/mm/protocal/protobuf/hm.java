package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hm
  extends com.tencent.mm.bv.a
{
  public SKBuiltinBuffer_t wrQ;
  public SKBuiltinBuffer_t wrR;
  public String wrW;
  public SKBuiltinBuffer_t wuh;
  public cvg wui;
  public czg wuj;
  public int wuk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58891);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wuh != null)
      {
        paramVarArgs.iQ(1, this.wuh.computeSize());
        this.wuh.writeFields(paramVarArgs);
      }
      if (this.wui != null)
      {
        paramVarArgs.iQ(2, this.wui.computeSize());
        this.wui.writeFields(paramVarArgs);
      }
      if (this.wuj != null)
      {
        paramVarArgs.iQ(3, this.wuj.computeSize());
        this.wuj.writeFields(paramVarArgs);
      }
      if (this.wrQ != null)
      {
        paramVarArgs.iQ(4, this.wrQ.computeSize());
        this.wrQ.writeFields(paramVarArgs);
      }
      if (this.wrR != null)
      {
        paramVarArgs.iQ(5, this.wrR.computeSize());
        this.wrR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wuk);
      if (this.wrW != null) {
        paramVarArgs.e(7, this.wrW);
      }
      AppMethodBeat.o(58891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wuh == null) {
        break label1034;
      }
    }
    label1034:
    for (int i = e.a.a.a.iP(1, this.wuh.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wui != null) {
        paramInt = i + e.a.a.a.iP(2, this.wui.computeSize());
      }
      i = paramInt;
      if (this.wuj != null) {
        i = paramInt + e.a.a.a.iP(3, this.wuj.computeSize());
      }
      paramInt = i;
      if (this.wrQ != null) {
        paramInt = i + e.a.a.a.iP(4, this.wrQ.computeSize());
      }
      i = paramInt;
      if (this.wrR != null) {
        i = paramInt + e.a.a.a.iP(5, this.wrR.computeSize());
      }
      i += e.a.a.b.b.a.bl(6, this.wuk);
      paramInt = i;
      if (this.wrW != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wrW);
      }
      AppMethodBeat.o(58891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        hm localhm = (hm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58891);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localhm.wuh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58891);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localhm.wui = ((cvg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58891);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localhm.wuj = ((czg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58891);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localhm.wrQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58891);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localhm.wrR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58891);
          return 0;
        case 6: 
          localhm.wuk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58891);
          return 0;
        }
        localhm.wrW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58891);
        return 0;
      }
      AppMethodBeat.o(58891);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hm
 * JD-Core Version:    0.7.0.1
 */