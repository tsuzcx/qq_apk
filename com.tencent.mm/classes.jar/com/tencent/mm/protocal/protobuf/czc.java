package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czc
  extends com.tencent.mm.bx.a
{
  public afp FyS;
  public SKBuiltinBuffer_t FyT;
  public SKBuiltinBuffer_t FyU;
  public int Fzi;
  public SKBuiltinBuffer_t Fzl;
  public SKBuiltinBuffer_t Fzm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FyU == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.FyS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.FyT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.FyU != null)
      {
        paramVarArgs.lC(1, this.FyU.computeSize());
        this.FyU.writeFields(paramVarArgs);
      }
      if (this.FyS != null)
      {
        paramVarArgs.lC(2, this.FyS.computeSize());
        this.FyS.writeFields(paramVarArgs);
      }
      if (this.FyT != null)
      {
        paramVarArgs.lC(3, this.FyT.computeSize());
        this.FyT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Fzi);
      if (this.Fzl != null)
      {
        paramVarArgs.lC(5, this.Fzl.computeSize());
        this.Fzl.writeFields(paramVarArgs);
      }
      if (this.Fzm != null)
      {
        paramVarArgs.lC(6, this.Fzm.computeSize());
        this.Fzm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FyU == null) {
        break label1118;
      }
    }
    label1118:
    for (int i = f.a.a.a.lB(1, this.FyU.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FyS != null) {
        paramInt = i + f.a.a.a.lB(2, this.FyS.computeSize());
      }
      i = paramInt;
      if (this.FyT != null) {
        i = paramInt + f.a.a.a.lB(3, this.FyT.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.Fzi);
      paramInt = i;
      if (this.Fzl != null) {
        paramInt = i + f.a.a.a.lB(5, this.Fzl.computeSize());
      }
      i = paramInt;
      if (this.Fzm != null) {
        i = paramInt + f.a.a.a.lB(6, this.Fzm.computeSize());
      }
      AppMethodBeat.o(133194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FyU == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.FyS == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.FyT == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czc localczc = (czc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133194);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczc.FyU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczc.FyS = ((afp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczc.FyT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 4: 
          localczc.Fzi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133194);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczc.Fzl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localczc.Fzm = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133194);
        return 0;
      }
      AppMethodBeat.o(133194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czc
 * JD-Core Version:    0.7.0.1
 */