package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ben
  extends cvw
{
  public int GTH;
  public LinkedList<bzz> GTI;
  public int GTJ;
  public LinkedList<bww> GTK;
  public String MD5;
  public int Scene;
  public int gvx;
  
  public ben()
  {
    AppMethodBeat.i(155408);
    this.GTI = new LinkedList();
    this.GTK = new LinkedList();
    AppMethodBeat.o(155408);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.gvx);
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      paramVarArgs.aS(4, this.GTH);
      paramVarArgs.e(5, 8, this.GTI);
      paramVarArgs.aS(6, this.GTJ);
      paramVarArgs.e(7, 8, this.GTK);
      paramVarArgs.aS(8, this.Scene);
      AppMethodBeat.o(155409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.gvx);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.MD5);
      }
      i = f.a.a.b.b.a.bz(4, this.GTH);
      int j = f.a.a.a.c(5, 8, this.GTI);
      int k = f.a.a.b.b.a.bz(6, this.GTJ);
      int m = f.a.a.a.c(7, 8, this.GTK);
      int n = f.a.a.b.b.a.bz(8, this.Scene);
      AppMethodBeat.o(155409);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTI.clear();
        this.GTK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ben localben = (ben)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155409);
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
            localben.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 2: 
          localben.gvx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155409);
          return 0;
        case 3: 
          localben.MD5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155409);
          return 0;
        case 4: 
          localben.GTH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155409);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localben.GTI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 6: 
          localben.GTJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155409);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localben.GTK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        }
        localben.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155409);
        return 0;
      }
      AppMethodBeat.o(155409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ben
 * JD-Core Version:    0.7.0.1
 */