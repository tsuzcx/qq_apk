package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asy
  extends com.tencent.mm.bx.a
{
  public int Ddx;
  public int DesignerUin;
  public SKBuiltinBuffer_t Dta;
  public String Dtb;
  public int Dtc;
  public long Dtd;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104784);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.OpCode);
      paramVarArgs.aR(2, this.DesignerUin);
      if (this.Dta != null)
      {
        paramVarArgs.kX(3, this.Dta.computeSize());
        this.Dta.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Ddx);
      if (this.Dtb != null) {
        paramVarArgs.d(5, this.Dtb);
      }
      paramVarArgs.aR(6, this.Dtc);
      paramVarArgs.aG(7, this.Dtd);
      AppMethodBeat.o(104784);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.OpCode) + 0 + f.a.a.b.b.a.bA(2, this.DesignerUin);
      paramInt = i;
      if (this.Dta != null) {
        paramInt = i + f.a.a.a.kW(3, this.Dta.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Ddx);
      paramInt = i;
      if (this.Dtb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dtb);
      }
      i = f.a.a.b.b.a.bA(6, this.Dtc);
      int j = f.a.a.b.b.a.q(7, this.Dtd);
      AppMethodBeat.o(104784);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(104784);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      asy localasy = (asy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104784);
        return -1;
      case 1: 
        localasy.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104784);
        return 0;
      case 2: 
        localasy.DesignerUin = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104784);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasy.Dta = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104784);
        return 0;
      case 4: 
        localasy.Ddx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104784);
        return 0;
      case 5: 
        localasy.Dtb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(104784);
        return 0;
      case 6: 
        localasy.Dtc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104784);
        return 0;
      }
      localasy.Dtd = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(104784);
      return 0;
    }
    AppMethodBeat.o(104784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asy
 * JD-Core Version:    0.7.0.1
 */