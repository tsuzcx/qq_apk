package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bct
  extends com.tencent.mm.bw.a
{
  public bob FVo;
  public int GSm;
  public int Ret;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      if (this.FVo != null)
      {
        paramVarArgs.lJ(2, this.FVo.computeSize());
        this.FVo.writeFields(paramVarArgs);
      }
      if (this.xrf != null) {
        paramVarArgs.d(3, this.xrf);
      }
      paramVarArgs.aS(4, this.GSm);
      AppMethodBeat.o(82415);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.a.lI(2, this.FVo.computeSize());
      }
      i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xrf);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GSm);
      AppMethodBeat.o(82415);
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
      AppMethodBeat.o(82415);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bct localbct = (bct)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82415);
        return -1;
      case 1: 
        localbct.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(82415);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bob();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbct.FVo = ((bob)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82415);
        return 0;
      case 3: 
        localbct.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82415);
        return 0;
      }
      localbct.GSm = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(82415);
      return 0;
    }
    AppMethodBeat.o(82415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bct
 * JD-Core Version:    0.7.0.1
 */