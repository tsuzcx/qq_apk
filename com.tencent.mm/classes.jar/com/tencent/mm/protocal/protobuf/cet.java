package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cet
  extends com.tencent.mm.bw.a
{
  public int FUA;
  public com.tencent.mm.bw.b FUz;
  public int HrA;
  public int Hrw;
  public String Hrx;
  public SKBuiltinBuffer_t Hry;
  public int Hrz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hry == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Hrw);
      if (this.FUz != null) {
        paramVarArgs.c(2, this.FUz);
      }
      if (this.Hrx != null) {
        paramVarArgs.d(3, this.Hrx);
      }
      if (this.Hry != null)
      {
        paramVarArgs.lJ(4, this.Hry.computeSize());
        this.Hry.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Hrz);
      paramVarArgs.aS(6, this.HrA);
      paramVarArgs.aS(7, this.FUA);
      AppMethodBeat.o(32359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hrw) + 0;
      paramInt = i;
      if (this.FUz != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FUz);
      }
      i = paramInt;
      if (this.Hrx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hrx);
      }
      paramInt = i;
      if (this.Hry != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hry.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.Hrz);
      int j = f.a.a.b.b.a.bz(6, this.HrA);
      int k = f.a.a.b.b.a.bz(7, this.FUA);
      AppMethodBeat.o(32359);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Hry == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cet localcet = (cet)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32359);
        return -1;
      case 1: 
        localcet.Hrw = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32359);
        return 0;
      case 2: 
        localcet.FUz = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(32359);
        return 0;
      case 3: 
        localcet.Hrx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32359);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcet.Hry = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32359);
        return 0;
      case 5: 
        localcet.Hrz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32359);
        return 0;
      case 6: 
        localcet.HrA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32359);
        return 0;
      }
      localcet.FUA = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(32359);
      return 0;
    }
    AppMethodBeat.o(32359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cet
 * JD-Core Version:    0.7.0.1
 */