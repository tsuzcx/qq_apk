package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anv
  extends cvw
{
  public String GDP;
  public alw GEg;
  public LinkedList<String> GFF;
  public int GFG;
  public LinkedList<aml> GFH;
  public LinkedList<amk> GFI;
  public LinkedList<ami> GFJ;
  
  public anv()
  {
    AppMethodBeat.i(189334);
    this.GFF = new LinkedList();
    this.GFH = new LinkedList();
    this.GFI = new LinkedList();
    this.GFJ = new LinkedList();
    AppMethodBeat.o(189334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189335);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GEg != null)
      {
        paramVarArgs.lJ(2, this.GEg.computeSize());
        this.GEg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 1, this.GFF);
      paramVarArgs.aS(4, this.GFG);
      if (this.GDP != null) {
        paramVarArgs.d(5, this.GDP);
      }
      paramVarArgs.e(6, 8, this.GFH);
      paramVarArgs.e(7, 8, this.GFI);
      paramVarArgs.e(8, 8, this.GFJ);
      AppMethodBeat.o(189335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GEg != null) {
        i = paramInt + f.a.a.a.lI(2, this.GEg.computeSize());
      }
      i = i + f.a.a.a.c(3, 1, this.GFF) + f.a.a.b.b.a.bz(4, this.GFG);
      paramInt = i;
      if (this.GDP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GDP);
      }
      i = f.a.a.a.c(6, 8, this.GFH);
      int j = f.a.a.a.c(7, 8, this.GFI);
      int k = f.a.a.a.c(8, 8, this.GFJ);
      AppMethodBeat.o(189335);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFF.clear();
        this.GFH.clear();
        this.GFI.clear();
        this.GFJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189335);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anv localanv = (anv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189335);
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
            localanv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189335);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanv.GEg = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189335);
          return 0;
        case 3: 
          localanv.GFF.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(189335);
          return 0;
        case 4: 
          localanv.GFG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189335);
          return 0;
        case 5: 
          localanv.GDP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189335);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aml();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanv.GFH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189335);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanv.GFI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189335);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ami();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ami)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localanv.GFJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189335);
        return 0;
      }
      AppMethodBeat.o(189335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anv
 * JD-Core Version:    0.7.0.1
 */