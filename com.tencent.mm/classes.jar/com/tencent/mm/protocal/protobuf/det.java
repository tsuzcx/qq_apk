package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class det
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t DpV;
  public int Ewl;
  public String Ewo;
  public String Ewp;
  public int Ewq;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ewl);
      if (this.Ewo != null) {
        paramVarArgs.d(2, this.Ewo);
      }
      paramVarArgs.aR(3, this.Ret);
      if (this.Ewp != null) {
        paramVarArgs.d(4, this.Ewp);
      }
      if (this.DpV != null)
      {
        paramVarArgs.kX(5, this.DpV.computeSize());
        this.DpV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Ewq);
      AppMethodBeat.o(152716);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Ewl) + 0;
      paramInt = i;
      if (this.Ewo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ewo);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.Ret);
      paramInt = i;
      if (this.Ewp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ewp);
      }
      i = paramInt;
      if (this.DpV != null) {
        i = paramInt + f.a.a.a.kW(5, this.DpV.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Ewq);
      AppMethodBeat.o(152716);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152716);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      det localdet = (det)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152716);
        return -1;
      case 1: 
        localdet.Ewl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152716);
        return 0;
      case 2: 
        localdet.Ewo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 3: 
        localdet.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152716);
        return 0;
      case 4: 
        localdet.Ewp = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdet.DpV = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152716);
        return 0;
      }
      localdet.Ewq = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(152716);
      return 0;
    }
    AppMethodBeat.o(152716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.det
 * JD-Core Version:    0.7.0.1
 */