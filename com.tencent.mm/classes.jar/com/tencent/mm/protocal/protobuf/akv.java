package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class akv
  extends com.tencent.mm.bw.a
  implements dfi
{
  public int GeQ;
  public SKBuiltinBuffer_t GjQ;
  public zy GjT;
  public int Ret;
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127483);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GjT == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.GjT != null)
      {
        paramVarArgs.lJ(2, this.GjT.computeSize());
        this.GjT.writeFields(paramVarArgs);
      }
      if (this.GjQ != null)
      {
        paramVarArgs.lJ(3, this.GjQ.computeSize());
        this.GjQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GeQ);
      AppMethodBeat.o(127483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.GjT != null) {
        paramInt = i + f.a.a.a.lI(2, this.GjT.computeSize());
      }
      i = paramInt;
      if (this.GjQ != null) {
        i = paramInt + f.a.a.a.lI(3, this.GjQ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GeQ);
      AppMethodBeat.o(127483);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GjT == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      akv localakv = (akv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127483);
        return -1;
      case 1: 
        localakv.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127483);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakv.GjT = ((zy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakv.GjQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
        return 0;
      }
      localakv.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(127483);
      return 0;
    }
    AppMethodBeat.o(127483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akv
 * JD-Core Version:    0.7.0.1
 */