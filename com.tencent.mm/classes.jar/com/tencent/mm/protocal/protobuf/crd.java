package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crd
  extends cvw
{
  public float GgZ;
  public float Gha;
  public int Gzf;
  public String Gzg;
  public String Gzh;
  public int Gzi;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127296);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.y(3, this.GgZ);
      paramVarArgs.y(4, this.Gha);
      paramVarArgs.aS(5, this.Gzf);
      if (this.Gzg != null) {
        paramVarArgs.d(6, this.Gzg);
      }
      if (this.Gzh != null) {
        paramVarArgs.d(7, this.Gzh);
      }
      paramVarArgs.aS(8, this.Gzi);
      AppMethodBeat.o(127296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.amE(3) + f.a.a.b.b.a.amE(4) + f.a.a.b.b.a.bz(5, this.Gzf);
      paramInt = i;
      if (this.Gzg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gzg);
      }
      i = paramInt;
      if (this.Gzh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gzh);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.Gzi);
      AppMethodBeat.o(127296);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127296);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crd localcrd = (crd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127296);
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
            localcrd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127296);
          return 0;
        case 2: 
          localcrd.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127296);
          return 0;
        case 3: 
          localcrd.GgZ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(127296);
          return 0;
        case 4: 
          localcrd.Gha = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(127296);
          return 0;
        case 5: 
          localcrd.Gzf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127296);
          return 0;
        case 6: 
          localcrd.Gzg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127296);
          return 0;
        case 7: 
          localcrd.Gzh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127296);
          return 0;
        }
        localcrd.Gzi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127296);
        return 0;
      }
      AppMethodBeat.o(127296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crd
 * JD-Core Version:    0.7.0.1
 */