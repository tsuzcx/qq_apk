package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgn
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public SKBuiltinBuffer_t HNI;
  public int Height;
  public String Md5;
  public int Width;
  public int nJv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125784);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.HNI != null)
      {
        paramVarArgs.lJ(2, this.HNI.computeSize());
        this.HNI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Width);
      paramVarArgs.aS(4, this.Height);
      paramVarArgs.aS(5, this.nJv);
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
      if (this.HNI != null) {
        i = paramInt + f.a.a.a.lI(2, this.HNI.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.Width) + f.a.a.b.b.a.bz(4, this.Height) + f.a.a.b.b.a.bz(5, this.nJv);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Desc);
      }
      AppMethodBeat.o(125784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgn localdgn = (dgn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125784);
          return -1;
        case 1: 
          localdgn.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125784);
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
            localdgn.HNI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125784);
          return 0;
        case 3: 
          localdgn.Width = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125784);
          return 0;
        case 4: 
          localdgn.Height = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125784);
          return 0;
        case 5: 
          localdgn.nJv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125784);
          return 0;
        }
        localdgn.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125784);
        return 0;
      }
      AppMethodBeat.o(125784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgn
 * JD-Core Version:    0.7.0.1
 */