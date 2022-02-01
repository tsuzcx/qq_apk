package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvz
  extends cvw
{
  public int FIh;
  public int HGL;
  public int HGM;
  public long HsL;
  public String dwb;
  public int vvv;
  public String vvw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      paramVarArgs.aS(3, this.vvv);
      paramVarArgs.aS(4, this.FIh);
      paramVarArgs.aZ(5, this.HsL);
      paramVarArgs.aS(6, this.HGL);
      if (this.vvw != null) {
        paramVarArgs.d(7, this.vvw);
      }
      paramVarArgs.aS(8, this.HGM);
      AppMethodBeat.o(91671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = i + f.a.a.b.b.a.bz(3, this.vvv) + f.a.a.b.b.a.bz(4, this.FIh) + f.a.a.b.b.a.p(5, this.HsL) + f.a.a.b.b.a.bz(6, this.HGL);
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vvw);
      }
      i = f.a.a.b.b.a.bz(8, this.HGM);
      AppMethodBeat.o(91671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvz localcvz = (cvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91671);
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
            localcvz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91671);
          return 0;
        case 2: 
          localcvz.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91671);
          return 0;
        case 3: 
          localcvz.vvv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91671);
          return 0;
        case 4: 
          localcvz.FIh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91671);
          return 0;
        case 5: 
          localcvz.HsL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91671);
          return 0;
        case 6: 
          localcvz.HGL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91671);
          return 0;
        case 7: 
          localcvz.vvw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91671);
          return 0;
        }
        localcvz.HGM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91671);
        return 0;
      }
      AppMethodBeat.o(91671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvz
 * JD-Core Version:    0.7.0.1
 */