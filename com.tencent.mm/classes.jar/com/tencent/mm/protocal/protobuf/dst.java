package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dst
  extends cvc
{
  public int FAt;
  public String FDJ;
  public LinkedList<bzf> GOu;
  public int HFx;
  public int HFy;
  public LinkedList<bwc> HFz;
  public String nDo;
  
  public dst()
  {
    AppMethodBeat.i(155474);
    this.GOu = new LinkedList();
    this.HFz = new LinkedList();
    AppMethodBeat.o(155474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      paramVarArgs.aS(3, this.FAt);
      if (this.FDJ != null) {
        paramVarArgs.d(4, this.FDJ);
      }
      paramVarArgs.aS(5, this.HFx);
      paramVarArgs.e(6, 8, this.GOu);
      paramVarArgs.aS(7, this.HFy);
      paramVarArgs.e(8, 8, this.HFz);
      AppMethodBeat.o(155475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nDo);
      }
      i += f.a.a.b.b.a.bz(3, this.FAt);
      paramInt = i;
      if (this.FDJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDJ);
      }
      i = f.a.a.b.b.a.bz(5, this.HFx);
      int j = f.a.a.a.c(6, 8, this.GOu);
      int k = f.a.a.b.b.a.bz(7, this.HFy);
      int m = f.a.a.a.c(8, 8, this.HFz);
      AppMethodBeat.o(155475);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GOu.clear();
        this.HFz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dst localdst = (dst)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155475);
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
            localdst.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 2: 
          localdst.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 3: 
          localdst.FAt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155475);
          return 0;
        case 4: 
          localdst.FDJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 5: 
          localdst.HFx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155475);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdst.GOu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 7: 
          localdst.HFy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155475);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdst.HFz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      AppMethodBeat.o(155475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dst
 * JD-Core Version:    0.7.0.1
 */