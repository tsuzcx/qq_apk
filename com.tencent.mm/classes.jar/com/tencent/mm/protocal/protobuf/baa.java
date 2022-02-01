package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baa
  extends com.tencent.mm.bx.a
{
  public int DesignerUin;
  public int Geg;
  public SKBuiltinBuffer_t Gxi;
  public String Gxj;
  public int Gxk;
  public long Gxl;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104784);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.OpCode);
      paramVarArgs.aS(2, this.DesignerUin);
      if (this.Gxi != null)
      {
        paramVarArgs.lC(3, this.Gxi.computeSize());
        this.Gxi.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Geg);
      if (this.Gxj != null) {
        paramVarArgs.d(5, this.Gxj);
      }
      paramVarArgs.aS(6, this.Gxk);
      paramVarArgs.aY(7, this.Gxl);
      AppMethodBeat.o(104784);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.OpCode) + 0 + f.a.a.b.b.a.bz(2, this.DesignerUin);
      paramInt = i;
      if (this.Gxi != null) {
        paramInt = i + f.a.a.a.lB(3, this.Gxi.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Geg);
      paramInt = i;
      if (this.Gxj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gxj);
      }
      i = f.a.a.b.b.a.bz(6, this.Gxk);
      int j = f.a.a.b.b.a.p(7, this.Gxl);
      AppMethodBeat.o(104784);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(104784);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      baa localbaa = (baa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104784);
        return -1;
      case 1: 
        localbaa.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104784);
        return 0;
      case 2: 
        localbaa.DesignerUin = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104784);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbaa.Gxi = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104784);
        return 0;
      case 4: 
        localbaa.Geg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104784);
        return 0;
      case 5: 
        localbaa.Gxj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(104784);
        return 0;
      case 6: 
        localbaa.Gxk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104784);
        return 0;
      }
      localbaa.Gxl = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(104784);
      return 0;
    }
    AppMethodBeat.o(104784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baa
 * JD-Core Version:    0.7.0.1
 */