package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aop
  extends cvw
{
  public alw GFS;
  public String GFT;
  public long GFU;
  public long GFV;
  public String oBN;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189350);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.scene);
      if (this.oBN != null) {
        paramVarArgs.d(3, this.oBN);
      }
      if (this.GFS != null)
      {
        paramVarArgs.lJ(4, this.GFS.computeSize());
        this.GFS.writeFields(paramVarArgs);
      }
      if (this.GFT != null) {
        paramVarArgs.d(5, this.GFT);
      }
      paramVarArgs.aZ(6, this.GFU);
      paramVarArgs.aZ(7, this.GFV);
      AppMethodBeat.o(189350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.scene);
      paramInt = i;
      if (this.oBN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oBN);
      }
      i = paramInt;
      if (this.GFS != null) {
        i = paramInt + f.a.a.a.lI(4, this.GFS.computeSize());
      }
      paramInt = i;
      if (this.GFT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GFT);
      }
      i = f.a.a.b.b.a.p(6, this.GFU);
      int j = f.a.a.b.b.a.p(7, this.GFV);
      AppMethodBeat.o(189350);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189350);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aop localaop = (aop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189350);
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
            localaop.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189350);
          return 0;
        case 2: 
          localaop.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189350);
          return 0;
        case 3: 
          localaop.oBN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189350);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaop.GFS = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189350);
          return 0;
        case 5: 
          localaop.GFT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189350);
          return 0;
        case 6: 
          localaop.GFU = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189350);
          return 0;
        }
        localaop.GFV = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(189350);
        return 0;
      }
      AppMethodBeat.o(189350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aop
 * JD-Core Version:    0.7.0.1
 */