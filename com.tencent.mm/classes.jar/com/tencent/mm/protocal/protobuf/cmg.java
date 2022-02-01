package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cmg
  extends com.tencent.mm.bw.a
{
  public aif KLY;
  public SKBuiltinBuffer_t KPW;
  public String KQi;
  public String KQv;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KPW == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.KLY == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.KPW != null)
      {
        paramVarArgs.ni(1, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      if (this.KLY != null)
      {
        paramVarArgs.ni(2, this.KLY.computeSize());
        this.KLY.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      if (this.KQi != null) {
        paramVarArgs.e(4, this.KQi);
      }
      if (this.KQv != null) {
        paramVarArgs.e(5, this.KQv);
      }
      AppMethodBeat.o(133178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KPW == null) {
        break label742;
      }
    }
    label742:
    for (int i = g.a.a.a.nh(1, this.KPW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLY != null) {
        paramInt = i + g.a.a.a.nh(2, this.KLY.computeSize());
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UserName);
      }
      paramInt = i;
      if (this.KQi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KQi);
      }
      i = paramInt;
      if (this.KQv != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KQv);
      }
      AppMethodBeat.o(133178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KPW == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        if (this.KLY == null)
        {
          paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cmg localcmg = (cmg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133178);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcmg.KPW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aif();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aif)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcmg.KLY = ((aif)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 3: 
          localcmg.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133178);
          return 0;
        case 4: 
          localcmg.KQi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133178);
          return 0;
        }
        localcmg.KQv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133178);
        return 0;
      }
      AppMethodBeat.o(133178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmg
 * JD-Core Version:    0.7.0.1
 */