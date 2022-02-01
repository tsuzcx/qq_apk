package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class id
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FSZ;
  public String FTa;
  public int FTb;
  public String ID;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32135);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.FSZ != null)
      {
        paramVarArgs.lJ(2, this.FSZ.computeSize());
        this.FSZ.writeFields(paramVarArgs);
      }
      if (this.FTa != null) {
        paramVarArgs.d(3, this.FTa);
      }
      paramVarArgs.aS(4, this.FTb);
      if (this.ID != null) {
        paramVarArgs.d(5, this.ID);
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FSZ != null) {
        paramInt = i + f.a.a.a.lI(2, this.FSZ.computeSize());
      }
      i = paramInt;
      if (this.FTa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FTa);
      }
      i += f.a.a.b.b.a.bz(4, this.FTb);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ID);
      }
      AppMethodBeat.o(32135);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FSZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      id localid = (id)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32135);
        return -1;
      case 1: 
        localid.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32135);
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
          localid.FSZ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32135);
        return 0;
      case 3: 
        localid.FTa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32135);
        return 0;
      case 4: 
        localid.FTb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32135);
        return 0;
      }
      localid.ID = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(32135);
      return 0;
    }
    AppMethodBeat.o(32135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.id
 * JD-Core Version:    0.7.0.1
 */