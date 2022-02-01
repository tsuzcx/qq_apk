package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ib
  extends cvw
{
  public int FST;
  public LinkedList<abj> FSU;
  public String FSV;
  public String FSW;
  public String FSX;
  public String FSY;
  public int Scene;
  public long nIX;
  
  public ib()
  {
    AppMethodBeat.i(32131);
    this.FSU = new LinkedList();
    AppMethodBeat.o(32131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32132);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FST);
      paramVarArgs.e(3, 8, this.FSU);
      if (this.FSV != null) {
        paramVarArgs.d(4, this.FSV);
      }
      if (this.FSW != null) {
        paramVarArgs.d(5, this.FSW);
      }
      paramVarArgs.aS(6, this.Scene);
      paramVarArgs.aZ(7, this.nIX);
      if (this.FSX != null) {
        paramVarArgs.d(8, this.FSX);
      }
      if (this.FSY != null) {
        paramVarArgs.d(9, this.FSY);
      }
      AppMethodBeat.o(32132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FST) + f.a.a.a.c(3, 8, this.FSU);
      paramInt = i;
      if (this.FSV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FSV);
      }
      i = paramInt;
      if (this.FSW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FSW);
      }
      i = i + f.a.a.b.b.a.bz(6, this.Scene) + f.a.a.b.b.a.p(7, this.nIX);
      paramInt = i;
      if (this.FSX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FSX);
      }
      i = paramInt;
      if (this.FSY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FSY);
      }
      AppMethodBeat.o(32132);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FSU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32132);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ib localib = (ib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32132);
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
            localib.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32132);
          return 0;
        case 2: 
          localib.FST = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32132);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localib.FSU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32132);
          return 0;
        case 4: 
          localib.FSV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32132);
          return 0;
        case 5: 
          localib.FSW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32132);
          return 0;
        case 6: 
          localib.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32132);
          return 0;
        case 7: 
          localib.nIX = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32132);
          return 0;
        case 8: 
          localib.FSX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32132);
          return 0;
        }
        localib.FSY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32132);
        return 0;
      }
      AppMethodBeat.o(32132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ib
 * JD-Core Version:    0.7.0.1
 */