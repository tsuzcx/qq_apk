package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzf
  extends com.tencent.mm.bw.a
{
  public int Gru;
  public SKBuiltinBuffer_t Grv;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115870);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Grv == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(115870);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Gru);
      if (this.Grv != null)
      {
        paramVarArgs.lJ(2, this.Grv.computeSize());
        this.Grv.writeFields(paramVarArgs);
      }
      if (this.uvG != null) {
        paramVarArgs.d(3, this.uvG);
      }
      AppMethodBeat.o(115870);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gru) + 0;
      paramInt = i;
      if (this.Grv != null) {
        paramInt = i + f.a.a.a.lI(2, this.Grv.computeSize());
      }
      i = paramInt;
      if (this.uvG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvG);
      }
      AppMethodBeat.o(115870);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Grv == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(115870);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115870);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dzf localdzf = (dzf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115870);
        return -1;
      case 1: 
        localdzf.Gru = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115870);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzf.Grv = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115870);
        return 0;
      }
      localdzf.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(115870);
      return 0;
    }
    AppMethodBeat.o(115870);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzf
 * JD-Core Version:    0.7.0.1
 */