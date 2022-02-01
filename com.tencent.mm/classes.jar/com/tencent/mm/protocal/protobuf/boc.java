package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boc
  extends com.tencent.mm.bx.a
{
  public LinkedList<bod> GIJ;
  public LinkedList<bod> Gse;
  public LinkedList<dwc> Gsf;
  public int aHQ;
  public int count;
  public String dtL;
  public long duration;
  public String dyV;
  public long startTime;
  
  public boc()
  {
    AppMethodBeat.i(122512);
    this.dtL = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.dyV = "";
    this.Gse = new LinkedList();
    this.count = 1;
    this.GIJ = new LinkedList();
    this.Gsf = new LinkedList();
    AppMethodBeat.o(122512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dtL != null) {
        paramVarArgs.d(1, this.dtL);
      }
      paramVarArgs.aY(2, this.startTime);
      paramVarArgs.aY(3, this.duration);
      if (this.dyV != null) {
        paramVarArgs.d(4, this.dyV);
      }
      paramVarArgs.e(5, 8, this.Gse);
      paramVarArgs.aS(6, this.count);
      paramVarArgs.e(7, 8, this.GIJ);
      paramVarArgs.e(8, 8, this.Gsf);
      paramVarArgs.aS(9, this.aHQ);
      AppMethodBeat.o(122513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dtL == null) {
        break label886;
      }
    }
    label886:
    for (paramInt = f.a.a.b.b.a.e(1, this.dtL) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.startTime) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.dyV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dyV);
      }
      i = f.a.a.a.c(5, 8, this.Gse);
      int j = f.a.a.b.b.a.bz(6, this.count);
      int k = f.a.a.a.c(7, 8, this.GIJ);
      int m = f.a.a.a.c(8, 8, this.Gsf);
      int n = f.a.a.b.b.a.bz(9, this.aHQ);
      AppMethodBeat.o(122513);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gse.clear();
        this.GIJ.clear();
        this.Gsf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        boc localboc = (boc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122513);
          return -1;
        case 1: 
          localboc.dtL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 2: 
          localboc.startTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122513);
          return 0;
        case 3: 
          localboc.duration = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122513);
          return 0;
        case 4: 
          localboc.dyV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboc.Gse.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 6: 
          localboc.count = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122513);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboc.GIJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboc.Gsf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        }
        localboc.aHQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122513);
        return 0;
      }
      AppMethodBeat.o(122513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boc
 * JD-Core Version:    0.7.0.1
 */