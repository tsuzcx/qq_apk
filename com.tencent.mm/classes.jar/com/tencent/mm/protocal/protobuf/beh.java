package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beh
  extends cvw
{
  public int GTE;
  public int GTF;
  public float GgZ;
  public float Gha;
  public int Height;
  public int Width;
  public String qkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.y(2, this.GgZ);
      paramVarArgs.y(3, this.Gha);
      paramVarArgs.aS(4, this.Width);
      paramVarArgs.aS(5, this.Height);
      if (this.qkN != null) {
        paramVarArgs.d(6, this.qkN);
      }
      paramVarArgs.aS(7, this.GTE);
      paramVarArgs.aS(8, this.GTF);
      AppMethodBeat.o(56247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amE(2) + f.a.a.b.b.a.amE(3) + f.a.a.b.b.a.bz(4, this.Width) + f.a.a.b.b.a.bz(5, this.Height);
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.qkN);
      }
      i = f.a.a.b.b.a.bz(7, this.GTE);
      int j = f.a.a.b.b.a.bz(8, this.GTF);
      AppMethodBeat.o(56247);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(56247);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        beh localbeh = (beh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56247);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56247);
          return 0;
        case 2: 
          localbeh.GgZ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(56247);
          return 0;
        case 3: 
          localbeh.Gha = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(56247);
          return 0;
        case 4: 
          localbeh.Width = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56247);
          return 0;
        case 5: 
          localbeh.Height = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56247);
          return 0;
        case 6: 
          localbeh.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56247);
          return 0;
        case 7: 
          localbeh.GTE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56247);
          return 0;
        }
        localbeh.GTF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(56247);
        return 0;
      }
      AppMethodBeat.o(56247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beh
 * JD-Core Version:    0.7.0.1
 */