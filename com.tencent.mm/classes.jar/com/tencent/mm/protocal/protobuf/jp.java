package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jp
  extends cvc
{
  public LinkedList<String> FCs;
  public LinkedList<cva> FCt;
  public long FCu;
  public int FCv;
  public int FCw;
  public String orm;
  
  public jp()
  {
    AppMethodBeat.i(6394);
    this.FCs = new LinkedList();
    this.FCt = new LinkedList();
    AppMethodBeat.o(6394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.FCs);
      paramVarArgs.e(3, 8, this.FCt);
      if (this.orm != null) {
        paramVarArgs.d(4, this.orm);
      }
      paramVarArgs.aY(5, this.FCu);
      paramVarArgs.aS(6, this.FCv);
      paramVarArgs.aS(7, this.FCw);
      AppMethodBeat.o(6395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label719;
      }
    }
    label719:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.FCs) + f.a.a.a.c(3, 8, this.FCt);
      paramInt = i;
      if (this.orm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.orm);
      }
      i = f.a.a.b.b.a.p(5, this.FCu);
      int j = f.a.a.b.b.a.bz(6, this.FCv);
      int k = f.a.a.b.b.a.bz(7, this.FCw);
      AppMethodBeat.o(6395);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FCs.clear();
        this.FCt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        jp localjp = (jp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localjp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 2: 
          localjp.FCs.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(6395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cva();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cva)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localjp.FCt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 4: 
          localjp.orm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6395);
          return 0;
        case 5: 
          localjp.FCu = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(6395);
          return 0;
        case 6: 
          localjp.FCv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6395);
          return 0;
        }
        localjp.FCw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(6395);
        return 0;
      }
      AppMethodBeat.o(6395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jp
 * JD-Core Version:    0.7.0.1
 */