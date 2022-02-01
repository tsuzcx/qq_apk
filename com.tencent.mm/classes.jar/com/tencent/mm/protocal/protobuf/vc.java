package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vc
  extends cvw
{
  public String FOg;
  public String GmU;
  public String GmV;
  public String GmX;
  public String dwj;
  public int vxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwj != null) {
        paramVarArgs.d(2, this.dwj);
      }
      if (this.GmX != null) {
        paramVarArgs.d(3, this.GmX);
      }
      if (this.FOg != null) {
        paramVarArgs.d(4, this.FOg);
      }
      paramVarArgs.aS(5, this.vxx);
      if (this.GmV != null) {
        paramVarArgs.d(6, this.GmV);
      }
      if (this.GmU != null) {
        paramVarArgs.d(7, this.GmU);
      }
      AppMethodBeat.o(72435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwj);
      }
      i = paramInt;
      if (this.GmX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GmX);
      }
      paramInt = i;
      if (this.FOg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FOg);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.vxx);
      paramInt = i;
      if (this.GmV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GmV);
      }
      i = paramInt;
      if (this.GmU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GmU);
      }
      AppMethodBeat.o(72435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vc localvc = (vc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72435);
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
            localvc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72435);
          return 0;
        case 2: 
          localvc.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 3: 
          localvc.GmX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 4: 
          localvc.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 5: 
          localvc.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72435);
          return 0;
        case 6: 
          localvc.GmV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72435);
          return 0;
        }
        localvc.GmU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72435);
        return 0;
      }
      AppMethodBeat.o(72435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vc
 * JD-Core Version:    0.7.0.1
 */