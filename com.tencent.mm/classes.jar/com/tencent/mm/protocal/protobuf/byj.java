package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class byj
  extends com.tencent.mm.bv.a
{
  public zd wrJ;
  public SKBuiltinBuffer_t wrK;
  public SKBuiltinBuffer_t wrL;
  public int wrZ;
  public SKBuiltinBuffer_t wsc;
  public SKBuiltinBuffer_t wsd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58930);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wrL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(58930);
        throw paramVarArgs;
      }
      if (this.wrJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(58930);
        throw paramVarArgs;
      }
      if (this.wrK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(58930);
        throw paramVarArgs;
      }
      if (this.wrL != null)
      {
        paramVarArgs.iQ(1, this.wrL.computeSize());
        this.wrL.writeFields(paramVarArgs);
      }
      if (this.wrJ != null)
      {
        paramVarArgs.iQ(2, this.wrJ.computeSize());
        this.wrJ.writeFields(paramVarArgs);
      }
      if (this.wrK != null)
      {
        paramVarArgs.iQ(3, this.wrK.computeSize());
        this.wrK.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wrZ);
      if (this.wsc != null)
      {
        paramVarArgs.iQ(5, this.wsc.computeSize());
        this.wsc.writeFields(paramVarArgs);
      }
      if (this.wsd != null)
      {
        paramVarArgs.iQ(6, this.wsd.computeSize());
        this.wsd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wrL == null) {
        break label1118;
      }
    }
    label1118:
    for (int i = e.a.a.a.iP(1, this.wrL.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wrJ != null) {
        paramInt = i + e.a.a.a.iP(2, this.wrJ.computeSize());
      }
      i = paramInt;
      if (this.wrK != null) {
        i = paramInt + e.a.a.a.iP(3, this.wrK.computeSize());
      }
      i += e.a.a.b.b.a.bl(4, this.wrZ);
      paramInt = i;
      if (this.wsc != null) {
        paramInt = i + e.a.a.a.iP(5, this.wsc.computeSize());
      }
      i = paramInt;
      if (this.wsd != null) {
        i = paramInt + e.a.a.a.iP(6, this.wsd.computeSize());
      }
      AppMethodBeat.o(58930);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wrL == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(58930);
          throw paramVarArgs;
        }
        if (this.wrJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(58930);
          throw paramVarArgs;
        }
        if (this.wrK == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(58930);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58930);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byj localbyj = (byj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58930);
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
            localbyj.wrL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58930);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyj.wrJ = ((zd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58930);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyj.wrK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58930);
          return 0;
        case 4: 
          localbyj.wrZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58930);
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
            localbyj.wsc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58930);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbyj.wsd = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58930);
        return 0;
      }
      AppMethodBeat.o(58930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byj
 * JD-Core Version:    0.7.0.1
 */