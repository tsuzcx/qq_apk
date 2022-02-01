package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvl
  extends cvw
{
  public long HGk;
  public String HGl;
  public int HGm;
  public int HGn;
  public int HGo;
  public long HGp;
  public int HhL;
  public long Hzw;
  public int Scene;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.HGk);
      if (this.HGl != null) {
        paramVarArgs.d(3, this.HGl);
      }
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aS(5, this.HGm);
      paramVarArgs.aS(6, this.HhL);
      paramVarArgs.aS(7, this.HGn);
      paramVarArgs.aZ(8, this.Hzw);
      paramVarArgs.aS(9, this.HGo);
      if (this.ikm != null) {
        paramVarArgs.d(10, this.ikm);
      }
      paramVarArgs.aZ(11, this.HGp);
      AppMethodBeat.o(117902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HGk);
      paramInt = i;
      if (this.HGl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HGl);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Scene) + f.a.a.b.b.a.bz(5, this.HGm) + f.a.a.b.b.a.bz(6, this.HhL) + f.a.a.b.b.a.bz(7, this.HGn) + f.a.a.b.b.a.p(8, this.Hzw) + f.a.a.b.b.a.bz(9, this.HGo);
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ikm);
      }
      i = f.a.a.b.b.a.p(11, this.HGp);
      AppMethodBeat.o(117902);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvl localcvl = (cvl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117902);
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
            localcvl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117902);
          return 0;
        case 2: 
          localcvl.HGk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(117902);
          return 0;
        case 3: 
          localcvl.HGl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117902);
          return 0;
        case 4: 
          localcvl.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 5: 
          localcvl.HGm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 6: 
          localcvl.HhL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 7: 
          localcvl.HGn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 8: 
          localcvl.Hzw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(117902);
          return 0;
        case 9: 
          localcvl.HGo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 10: 
          localcvl.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117902);
          return 0;
        }
        localcvl.HGp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117902);
        return 0;
      }
      AppMethodBeat.o(117902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvl
 * JD-Core Version:    0.7.0.1
 */