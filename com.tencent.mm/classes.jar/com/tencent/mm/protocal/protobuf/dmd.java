package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmd
  extends com.tencent.mm.bx.a
{
  public int CYY;
  public SKBuiltinBuffer_t CYZ;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115870);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CYZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(115870);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.CYY);
      if (this.CYZ != null)
      {
        paramVarArgs.kX(2, this.CYZ.computeSize());
        this.CYZ.writeFields(paramVarArgs);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(3, this.sdQ);
      }
      AppMethodBeat.o(115870);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CYY) + 0;
      paramInt = i;
      if (this.CYZ != null) {
        paramInt = i + f.a.a.a.kW(2, this.CYZ.computeSize());
      }
      i = paramInt;
      if (this.sdQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdQ);
      }
      AppMethodBeat.o(115870);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CYZ == null)
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
      dmd localdmd = (dmd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115870);
        return -1;
      case 1: 
        localdmd.CYY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115870);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmd.CYZ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115870);
        return 0;
      }
      localdmd.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(115870);
      return 0;
    }
    AppMethodBeat.o(115870);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmd
 * JD-Core Version:    0.7.0.1
 */