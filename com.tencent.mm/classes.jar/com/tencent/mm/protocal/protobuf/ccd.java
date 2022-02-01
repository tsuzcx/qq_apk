package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccd
  extends com.tencent.mm.bw.a
{
  public LinkedList<ccd> BNo;
  public String FqA;
  public LinkedList<ccc> FqB;
  public int FqC;
  public int FqD;
  public int oxC;
  public String type;
  public String vyz;
  
  public ccd()
  {
    AppMethodBeat.i(117537);
    this.FqB = new LinkedList();
    this.BNo = new LinkedList();
    AppMethodBeat.o(117537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FqA != null) {
        paramVarArgs.d(1, this.FqA);
      }
      if (this.vyz != null) {
        paramVarArgs.d(2, this.vyz);
      }
      paramVarArgs.e(3, 8, this.FqB);
      paramVarArgs.aR(4, this.oxC);
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.BNo);
      paramVarArgs.aR(7, this.FqC);
      paramVarArgs.aR(8, this.FqD);
      AppMethodBeat.o(117538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FqA == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.b.b.a.e(1, this.FqA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vyz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vyz);
      }
      i = i + f.a.a.a.c(3, 8, this.FqB) + f.a.a.b.b.a.bx(4, this.oxC);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.type);
      }
      i = f.a.a.a.c(6, 8, this.BNo);
      int j = f.a.a.b.b.a.bx(7, this.FqC);
      int k = f.a.a.b.b.a.bx(8, this.FqD);
      AppMethodBeat.o(117538);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FqB.clear();
        this.BNo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccd localccd = (ccd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117538);
          return -1;
        case 1: 
          localccd.FqA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 2: 
          localccd.vyz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccd.FqB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 4: 
          localccd.oxC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117538);
          return 0;
        case 5: 
          localccd.type = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccd.BNo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 7: 
          localccd.FqC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117538);
          return 0;
        }
        localccd.FqD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117538);
        return 0;
      }
      AppMethodBeat.o(117538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccd
 * JD-Core Version:    0.7.0.1
 */