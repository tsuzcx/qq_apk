package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ix
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t FBT;
  public eas FBU;
  public efr FBV;
  public int FBW;
  public SKBuiltinBuffer_t FyZ;
  public SKBuiltinBuffer_t Fza;
  public String Fzf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBT != null)
      {
        paramVarArgs.lC(1, this.FBT.computeSize());
        this.FBT.writeFields(paramVarArgs);
      }
      if (this.FBU != null)
      {
        paramVarArgs.lC(2, this.FBU.computeSize());
        this.FBU.writeFields(paramVarArgs);
      }
      if (this.FBV != null)
      {
        paramVarArgs.lC(3, this.FBV.computeSize());
        this.FBV.writeFields(paramVarArgs);
      }
      if (this.FyZ != null)
      {
        paramVarArgs.lC(4, this.FyZ.computeSize());
        this.FyZ.writeFields(paramVarArgs);
      }
      if (this.Fza != null)
      {
        paramVarArgs.lC(5, this.Fza.computeSize());
        this.Fza.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FBW);
      if (this.Fzf != null) {
        paramVarArgs.d(7, this.Fzf);
      }
      AppMethodBeat.o(133155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FBT == null) {
        break label1034;
      }
    }
    label1034:
    for (int i = f.a.a.a.lB(1, this.FBT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FBU != null) {
        paramInt = i + f.a.a.a.lB(2, this.FBU.computeSize());
      }
      i = paramInt;
      if (this.FBV != null) {
        i = paramInt + f.a.a.a.lB(3, this.FBV.computeSize());
      }
      paramInt = i;
      if (this.FyZ != null) {
        paramInt = i + f.a.a.a.lB(4, this.FyZ.computeSize());
      }
      i = paramInt;
      if (this.Fza != null) {
        i = paramInt + f.a.a.a.lB(5, this.Fza.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.FBW);
      paramInt = i;
      if (this.Fzf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fzf);
      }
      AppMethodBeat.o(133155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ix localix = (ix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133155);
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
            localix.FBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eas();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eas)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FBU = ((eas)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FBV = ((efr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FyZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
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
            localix.Fza = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 6: 
          localix.FBW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133155);
          return 0;
        }
        localix.Fzf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133155);
        return 0;
      }
      AppMethodBeat.o(133155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ix
 * JD-Core Version:    0.7.0.1
 */