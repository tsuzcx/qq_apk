package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ve
  extends cvw
{
  public int GmY;
  public String GmZ;
  public b Gmw;
  public int Gna;
  public String url;
  public int vxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GmY);
      paramVarArgs.aS(3, this.vxx);
      if (this.GmZ != null) {
        paramVarArgs.d(4, this.GmZ);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.Gna);
      if (this.Gmw != null) {
        paramVarArgs.c(7, this.Gmw);
      }
      AppMethodBeat.o(197185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GmY) + f.a.a.b.b.a.bz(3, this.vxx);
      paramInt = i;
      if (this.GmZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GmZ);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      i += f.a.a.b.b.a.bz(6, this.Gna);
      paramInt = i;
      if (this.Gmw != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.Gmw);
      }
      AppMethodBeat.o(197185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ve localve = (ve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197185);
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
            localve.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197185);
          return 0;
        case 2: 
          localve.GmY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197185);
          return 0;
        case 3: 
          localve.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197185);
          return 0;
        case 4: 
          localve.GmZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197185);
          return 0;
        case 5: 
          localve.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197185);
          return 0;
        case 6: 
          localve.Gna = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197185);
          return 0;
        }
        localve.Gmw = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(197185);
        return 0;
      }
      AppMethodBeat.o(197185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ve
 * JD-Core Version:    0.7.0.1
 */