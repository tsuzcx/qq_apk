package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuu
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public SKBuiltinBuffer_t Emy;
  public int Height;
  public String Md5;
  public int Width;
  public int mBC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125784);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.Emy != null)
      {
        paramVarArgs.kX(2, this.Emy.computeSize());
        this.Emy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Width);
      paramVarArgs.aR(4, this.Height);
      paramVarArgs.aR(5, this.mBC);
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
      if (this.Emy != null) {
        i = paramInt + f.a.a.a.kW(2, this.Emy.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.Width) + f.a.a.b.b.a.bA(4, this.Height) + f.a.a.b.b.a.bA(5, this.mBC);
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
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuu localcuu = (cuu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125784);
          return -1;
        case 1: 
          localcuu.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125784);
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
            localcuu.Emy = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125784);
          return 0;
        case 3: 
          localcuu.Width = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125784);
          return 0;
        case 4: 
          localcuu.Height = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125784);
          return 0;
        case 5: 
          localcuu.mBC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125784);
          return 0;
        }
        localcuu.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125784);
        return 0;
      }
      AppMethodBeat.o(125784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuu
 * JD-Core Version:    0.7.0.1
 */