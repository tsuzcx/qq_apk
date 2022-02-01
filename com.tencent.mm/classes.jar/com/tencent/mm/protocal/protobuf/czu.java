package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czu
  extends com.tencent.mm.bx.a
{
  public LinkedList<czv> aaFk;
  public LinkedList<czv> aajQ;
  public LinkedList<fxz> aajR;
  public int cHb;
  public int count;
  public long duration;
  public String hJW;
  public String hQR;
  public long startTime;
  
  public czu()
  {
    AppMethodBeat.i(122512);
    this.hJW = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.hQR = "";
    this.aajQ = new LinkedList();
    this.count = 1;
    this.aaFk = new LinkedList();
    this.aajR = new LinkedList();
    AppMethodBeat.o(122512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122513);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hJW != null) {
        paramVarArgs.g(1, this.hJW);
      }
      paramVarArgs.bv(2, this.startTime);
      paramVarArgs.bv(3, this.duration);
      if (this.hQR != null) {
        paramVarArgs.g(4, this.hQR);
      }
      paramVarArgs.e(5, 8, this.aajQ);
      paramVarArgs.bS(6, this.count);
      paramVarArgs.e(7, 8, this.aaFk);
      paramVarArgs.e(8, 8, this.aajR);
      paramVarArgs.bS(9, this.cHb);
      AppMethodBeat.o(122513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hJW == null) {
        break label816;
      }
    }
    label816:
    for (paramInt = i.a.a.b.b.a.h(1, this.hJW) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.startTime) + i.a.a.b.b.a.q(3, this.duration);
      paramInt = i;
      if (this.hQR != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hQR);
      }
      i = i.a.a.a.c(5, 8, this.aajQ);
      int j = i.a.a.b.b.a.cJ(6, this.count);
      int k = i.a.a.a.c(7, 8, this.aaFk);
      int m = i.a.a.a.c(8, 8, this.aajR);
      int n = i.a.a.b.b.a.cJ(9, this.cHb);
      AppMethodBeat.o(122513);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aajQ.clear();
        this.aaFk.clear();
        this.aajR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        czu localczu = (czu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122513);
          return -1;
        case 1: 
          localczu.hJW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 2: 
          localczu.startTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(122513);
          return 0;
        case 3: 
          localczu.duration = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(122513);
          return 0;
        case 4: 
          localczu.hQR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czv)localObject2).parseFrom((byte[])localObject1);
            }
            localczu.aajQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 6: 
          localczu.count = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(122513);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czv)localObject2).parseFrom((byte[])localObject1);
            }
            localczu.aaFk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxz)localObject2).parseFrom((byte[])localObject1);
            }
            localczu.aajR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        }
        localczu.cHb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122513);
        return 0;
      }
      AppMethodBeat.o(122513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czu
 * JD-Core Version:    0.7.0.1
 */