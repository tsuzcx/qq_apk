package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eps
  extends dop
{
  public SKBuiltinBuffer_t KNX;
  public SKBuiltinBuffer_t KQA;
  public String KQv;
  public dqi KQz;
  public int MWU;
  public dqi Mdj;
  public String Nnm;
  public dqi Nnn;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43133);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.OpCode);
      if (this.Nnm != null) {
        paramVarArgs.e(3, this.Nnm);
      }
      if (this.KQv != null) {
        paramVarArgs.e(4, this.KQv);
      }
      if (this.Mdj != null)
      {
        paramVarArgs.ni(5, this.Mdj.computeSize());
        this.Mdj.writeFields(paramVarArgs);
      }
      if (this.Nnn != null)
      {
        paramVarArgs.ni(6, this.Nnn.computeSize());
        this.Nnn.writeFields(paramVarArgs);
      }
      if (this.KQz != null)
      {
        paramVarArgs.ni(7, this.KQz.computeSize());
        this.KQz.writeFields(paramVarArgs);
      }
      if (this.KQA != null)
      {
        paramVarArgs.ni(8, this.KQA.computeSize());
        this.KQA.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.MWU);
      if (this.KNX != null)
      {
        paramVarArgs.ni(10, this.KNX.computeSize());
        this.KNX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.OpCode);
      paramInt = i;
      if (this.Nnm != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Nnm);
      }
      i = paramInt;
      if (this.KQv != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KQv);
      }
      paramInt = i;
      if (this.Mdj != null) {
        paramInt = i + g.a.a.a.nh(5, this.Mdj.computeSize());
      }
      i = paramInt;
      if (this.Nnn != null) {
        i = paramInt + g.a.a.a.nh(6, this.Nnn.computeSize());
      }
      paramInt = i;
      if (this.KQz != null) {
        paramInt = i + g.a.a.a.nh(7, this.KQz.computeSize());
      }
      i = paramInt;
      if (this.KQA != null) {
        i = paramInt + g.a.a.a.nh(8, this.KQA.computeSize());
      }
      i += g.a.a.b.b.a.bu(9, this.MWU);
      paramInt = i;
      if (this.KNX != null) {
        paramInt = i + g.a.a.a.nh(10, this.KNX.computeSize());
      }
      AppMethodBeat.o(43133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eps localeps = (eps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43133);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeps.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 2: 
          localeps.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43133);
          return 0;
        case 3: 
          localeps.Nnm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 4: 
          localeps.KQv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeps.Mdj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeps.Nnn = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeps.KQz = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeps.KQA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 9: 
          localeps.MWU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43133);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeps.KNX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      AppMethodBeat.o(43133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eps
 * JD-Core Version:    0.7.0.1
 */