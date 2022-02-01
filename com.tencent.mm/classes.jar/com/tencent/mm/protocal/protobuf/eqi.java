package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eqi
  extends dop
{
  public SKBuiltinBuffer_t KPW;
  public int MPQ;
  public int MPS;
  public String Mdm;
  public esi NnN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32496);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NnN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Piece");
        AppMethodBeat.o(32496);
        throw paramVarArgs;
      }
      if (this.KPW == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(32496);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NnN != null)
      {
        paramVarArgs.ni(2, this.NnN.computeSize());
        this.NnN.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MPQ);
      paramVarArgs.aM(4, this.MPS);
      if (this.Mdm != null) {
        paramVarArgs.e(5, this.Mdm);
      }
      if (this.KPW != null)
      {
        paramVarArgs.ni(6, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NnN != null) {
        i = paramInt + g.a.a.a.nh(2, this.NnN.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.MPQ) + g.a.a.b.b.a.bu(4, this.MPS);
      paramInt = i;
      if (this.Mdm != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mdm);
      }
      i = paramInt;
      if (this.KPW != null) {
        i = paramInt + g.a.a.a.nh(6, this.KPW.computeSize());
      }
      AppMethodBeat.o(32496);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NnN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Piece");
          AppMethodBeat.o(32496);
          throw paramVarArgs;
        }
        if (this.KPW == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(32496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqi localeqi = (eqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32496);
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
            localeqi.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32496);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqi.NnN = ((esi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32496);
          return 0;
        case 3: 
          localeqi.MPQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32496);
          return 0;
        case 4: 
          localeqi.MPS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32496);
          return 0;
        case 5: 
          localeqi.Mdm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32496);
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
          localeqi.KPW = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32496);
        return 0;
      }
      AppMethodBeat.o(32496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqi
 * JD-Core Version:    0.7.0.1
 */