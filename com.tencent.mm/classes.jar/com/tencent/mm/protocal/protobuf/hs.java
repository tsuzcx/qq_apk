package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hs
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t CCL;
  public String CCM;
  public int CCN;
  public String ID;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32135);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CCL == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ret);
      if (this.CCL != null)
      {
        paramVarArgs.kX(2, this.CCL.computeSize());
        this.CCL.writeFields(paramVarArgs);
      }
      if (this.CCM != null) {
        paramVarArgs.d(3, this.CCM);
      }
      paramVarArgs.aR(4, this.CCN);
      if (this.ID != null) {
        paramVarArgs.d(5, this.ID);
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Ret) + 0;
      paramInt = i;
      if (this.CCL != null) {
        paramInt = i + f.a.a.a.kW(2, this.CCL.computeSize());
      }
      i = paramInt;
      if (this.CCM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CCM);
      }
      i += f.a.a.b.b.a.bA(4, this.CCN);
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
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CCL == null)
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
      hs localhs = (hs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32135);
        return -1;
      case 1: 
        localhs.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32135);
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
          localhs.CCL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32135);
        return 0;
      case 3: 
        localhs.CCM = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32135);
        return 0;
      case 4: 
        localhs.CCN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32135);
        return 0;
      }
      localhs.ID = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(32135);
      return 0;
    }
    AppMethodBeat.o(32135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hs
 * JD-Core Version:    0.7.0.1
 */