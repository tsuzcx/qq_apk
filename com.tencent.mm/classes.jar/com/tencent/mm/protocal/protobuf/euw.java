package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class euw
  extends dop
{
  public int Leu;
  public SKBuiltinBuffer_t Lev;
  public int LsZ;
  public long Lta;
  public String MKC;
  public long NpN;
  public etn NsX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lev == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.NsX == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpLog");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MKC != null) {
        paramVarArgs.e(2, this.MKC);
      }
      paramVarArgs.aM(3, this.LsZ);
      if (this.Lev != null)
      {
        paramVarArgs.ni(4, this.Lev.computeSize());
        this.Lev.writeFields(paramVarArgs);
      }
      if (this.NsX != null)
      {
        paramVarArgs.ni(5, this.NsX.computeSize());
        this.NsX.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.Lta);
      paramVarArgs.aM(7, this.Leu);
      paramVarArgs.bb(8, this.NpN);
      AppMethodBeat.o(115925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MKC != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MKC);
      }
      i += g.a.a.b.b.a.bu(3, this.LsZ);
      paramInt = i;
      if (this.Lev != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lev.computeSize());
      }
      i = paramInt;
      if (this.NsX != null) {
        i = paramInt + g.a.a.a.nh(5, this.NsX.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(6, this.Lta);
      int j = g.a.a.b.b.a.bu(7, this.Leu);
      int k = g.a.a.b.b.a.r(8, this.NpN);
      AppMethodBeat.o(115925);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lev == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        if (this.NsX == null)
        {
          paramVarArgs = new b("Not all required fields were included: OpLog");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        euw localeuw = (euw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115925);
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
            localeuw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 2: 
          localeuw.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115925);
          return 0;
        case 3: 
          localeuw.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115925);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuw.Lev = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new etn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((etn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuw.NsX = ((etn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 6: 
          localeuw.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115925);
          return 0;
        case 7: 
          localeuw.Leu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115925);
          return 0;
        }
        localeuw.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(115925);
        return 0;
      }
      AppMethodBeat.o(115925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euw
 * JD-Core Version:    0.7.0.1
 */