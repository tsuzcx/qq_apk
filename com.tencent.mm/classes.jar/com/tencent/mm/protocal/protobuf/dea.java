package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dea
  extends cvw
{
  public diy FJR;
  public String GPt;
  public int HLA;
  public det HLB;
  public String Hgn;
  public int dJd;
  public LinkedList<dec> hFT;
  
  public dea()
  {
    AppMethodBeat.i(114070);
    this.hFT = new LinkedList();
    AppMethodBeat.o(114070);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114071);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HLA);
      paramVarArgs.e(3, 8, this.hFT);
      if (this.Hgn != null) {
        paramVarArgs.d(4, this.Hgn);
      }
      if (this.GPt != null) {
        paramVarArgs.d(5, this.GPt);
      }
      if (this.HLB != null)
      {
        paramVarArgs.lJ(6, this.HLB.computeSize());
        this.HLB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.dJd);
      if (this.FJR != null)
      {
        paramVarArgs.lJ(8, this.FJR.computeSize());
        this.FJR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HLA) + f.a.a.a.c(3, 8, this.hFT);
      paramInt = i;
      if (this.Hgn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hgn);
      }
      i = paramInt;
      if (this.GPt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GPt);
      }
      paramInt = i;
      if (this.HLB != null) {
        paramInt = i + f.a.a.a.lI(6, this.HLB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.dJd);
      paramInt = i;
      if (this.FJR != null) {
        paramInt = i + f.a.a.a.lI(8, this.FJR.computeSize());
      }
      AppMethodBeat.o(114071);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hFT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dea localdea = (dea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114071);
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
            localdea.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 2: 
          localdea.HLA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114071);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dec();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dec)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdea.hFT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 4: 
          localdea.Hgn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 5: 
          localdea.GPt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new det();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdea.HLB = ((det)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 7: 
          localdea.dJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114071);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new diy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((diy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdea.FJR = ((diy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      AppMethodBeat.o(114071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dea
 * JD-Core Version:    0.7.0.1
 */