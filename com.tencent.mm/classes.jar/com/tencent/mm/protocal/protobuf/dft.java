package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dft
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public int Height;
  public SKBuiltinBuffer_t Huf;
  public String Md5;
  public int Width;
  public int nEa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125784);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.Huf != null)
      {
        paramVarArgs.lC(2, this.Huf.computeSize());
        this.Huf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Width);
      paramVarArgs.aS(4, this.Height);
      paramVarArgs.aS(5, this.nEa);
      if (this.Desc != null) {
        paramVarArgs.d(6, this.Desc);
      }
      AppMethodBeat.o(125784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Huf != null) {
        i = paramInt + f.a.a.a.lB(2, this.Huf.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.Width) + f.a.a.b.b.a.bz(4, this.Height) + f.a.a.b.b.a.bz(5, this.nEa);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Desc);
      }
      AppMethodBeat.o(125784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dft localdft = (dft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125784);
          return -1;
        case 1: 
          localdft.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125784);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdft.Huf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125784);
          return 0;
        case 3: 
          localdft.Width = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125784);
          return 0;
        case 4: 
          localdft.Height = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125784);
          return 0;
        case 5: 
          localdft.nEa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125784);
          return 0;
        }
        localdft.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125784);
        return 0;
      }
      AppMethodBeat.o(125784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dft
 * JD-Core Version:    0.7.0.1
 */