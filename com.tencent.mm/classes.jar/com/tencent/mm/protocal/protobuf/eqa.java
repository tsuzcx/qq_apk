package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqa
  extends com.tencent.mm.bw.a
{
  public String Cyk;
  public int KJS;
  public String LRO;
  public String LRe;
  public String MSG;
  public String NnA;
  public int NnB;
  public SKBuiltinBuffer_t NnC;
  public SKBuiltinBuffer_t NnD;
  public String Nnv;
  public int Nnw;
  public String Nnx;
  public String Nny;
  public int Nnz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cyk != null) {
        paramVarArgs.e(1, this.Cyk);
      }
      if (this.Nnv != null) {
        paramVarArgs.e(2, this.Nnv);
      }
      if (this.LRO != null) {
        paramVarArgs.e(3, this.LRO);
      }
      paramVarArgs.aM(4, this.Nnw);
      if (this.MSG != null) {
        paramVarArgs.e(5, this.MSG);
      }
      if (this.Nnx != null) {
        paramVarArgs.e(6, this.Nnx);
      }
      if (this.Nny != null) {
        paramVarArgs.e(7, this.Nny);
      }
      paramVarArgs.aM(8, this.Nnz);
      if (this.NnA != null) {
        paramVarArgs.e(9, this.NnA);
      }
      paramVarArgs.aM(10, this.NnB);
      if (this.NnC != null)
      {
        paramVarArgs.ni(11, this.NnC.computeSize());
        this.NnC.writeFields(paramVarArgs);
      }
      if (this.LRe != null) {
        paramVarArgs.e(12, this.LRe);
      }
      paramVarArgs.aM(13, this.KJS);
      if (this.NnD != null)
      {
        paramVarArgs.ni(14, this.NnD.computeSize());
        this.NnD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cyk == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = g.a.a.b.b.a.f(1, this.Cyk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nnv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nnv);
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LRO);
      }
      i += g.a.a.b.b.a.bu(4, this.Nnw);
      paramInt = i;
      if (this.MSG != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MSG);
      }
      i = paramInt;
      if (this.Nnx != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Nnx);
      }
      paramInt = i;
      if (this.Nny != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Nny);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.Nnz);
      paramInt = i;
      if (this.NnA != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.NnA);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.NnB);
      paramInt = i;
      if (this.NnC != null) {
        paramInt = i + g.a.a.a.nh(11, this.NnC.computeSize());
      }
      i = paramInt;
      if (this.LRe != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.LRe);
      }
      i += g.a.a.b.b.a.bu(13, this.KJS);
      paramInt = i;
      if (this.NnD != null) {
        paramInt = i + g.a.a.a.nh(14, this.NnD.computeSize());
      }
      AppMethodBeat.o(152723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqa localeqa = (eqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152723);
          return -1;
        case 1: 
          localeqa.Cyk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 2: 
          localeqa.Nnv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 3: 
          localeqa.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 4: 
          localeqa.Nnw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152723);
          return 0;
        case 5: 
          localeqa.MSG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 6: 
          localeqa.Nnx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 7: 
          localeqa.Nny = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 8: 
          localeqa.Nnz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152723);
          return 0;
        case 9: 
          localeqa.NnA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 10: 
          localeqa.NnB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152723);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqa.NnC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152723);
          return 0;
        case 12: 
          localeqa.LRe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 13: 
          localeqa.KJS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152723);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeqa.NnD = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      AppMethodBeat.o(152723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqa
 * JD-Core Version:    0.7.0.1
 */