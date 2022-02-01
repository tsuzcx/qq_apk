package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzl
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public long Idp;
  public String Ieu;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      if (this.Ieu != null) {
        paramVarArgs.d(4, this.Ieu);
      }
      paramVarArgs.aS(5, this.nJA);
      paramVarArgs.aZ(6, this.Idp);
      AppMethodBeat.o(115878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.p(3, this.Gxr);
      paramInt = i;
      if (this.Ieu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ieu);
      }
      i = f.a.a.b.b.a.bz(5, this.nJA);
      int j = f.a.a.b.b.a.p(6, this.Idp);
      AppMethodBeat.o(115878);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzl localdzl = (dzl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115878);
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
            localdzl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115878);
          return 0;
        case 2: 
          localdzl.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115878);
          return 0;
        case 3: 
          localdzl.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115878);
          return 0;
        case 4: 
          localdzl.Ieu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115878);
          return 0;
        case 5: 
          localdzl.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115878);
          return 0;
        }
        localdzl.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(115878);
        return 0;
      }
      AppMethodBeat.o(115878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzl
 * JD-Core Version:    0.7.0.1
 */