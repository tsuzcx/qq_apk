package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czu
  extends cvw
{
  public String Gdj;
  public long HGk;
  public long HGp;
  public int HJl;
  public long HJm;
  public boolean HJn;
  public eje HJo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gdj != null) {
        paramVarArgs.d(2, this.Gdj);
      }
      paramVarArgs.aZ(3, this.HGk);
      paramVarArgs.aS(4, this.HJl);
      paramVarArgs.aZ(5, this.HJm);
      paramVarArgs.bC(6, this.HJn);
      if (this.HJo != null)
      {
        paramVarArgs.lJ(7, this.HJo.computeSize());
        this.HJo.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(8, this.HGp);
      AppMethodBeat.o(117921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gdj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gdj);
      }
      i = i + f.a.a.b.b.a.p(3, this.HGk) + f.a.a.b.b.a.bz(4, this.HJl) + f.a.a.b.b.a.p(5, this.HJm) + f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.HJo != null) {
        paramInt = i + f.a.a.a.lI(7, this.HJo.computeSize());
      }
      i = f.a.a.b.b.a.p(8, this.HGp);
      AppMethodBeat.o(117921);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czu localczu = (czu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117921);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        case 2: 
          localczu.Gdj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117921);
          return 0;
        case 3: 
          localczu.HGk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(117921);
          return 0;
        case 4: 
          localczu.HJl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117921);
          return 0;
        case 5: 
          localczu.HJm = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(117921);
          return 0;
        case 6: 
          localczu.HJn = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(117921);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eje();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eje)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczu.HJo = ((eje)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        }
        localczu.HGp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117921);
        return 0;
      }
      AppMethodBeat.o(117921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czu
 * JD-Core Version:    0.7.0.1
 */