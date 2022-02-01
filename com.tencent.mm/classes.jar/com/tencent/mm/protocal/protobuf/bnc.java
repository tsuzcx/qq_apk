package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnc
  extends com.tencent.mm.cd.a
{
  public boolean Aaj;
  public LinkedList<efi> SXW;
  public efi SXX;
  public LinkedList<bnb> SXY;
  public boolean SXZ;
  public String SYa;
  public long SYb;
  public String fLj;
  
  public bnc()
  {
    AppMethodBeat.i(122501);
    this.SXW = new LinkedList();
    this.SXY = new LinkedList();
    this.SXZ = false;
    this.Aaj = false;
    AppMethodBeat.o(122501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122502);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fLj != null) {
        paramVarArgs.f(1, this.fLj);
      }
      paramVarArgs.e(2, 8, this.SXW);
      if (this.SXX != null)
      {
        paramVarArgs.oE(3, this.SXX.computeSize());
        this.SXX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.SXY);
      paramVarArgs.co(5, this.SXZ);
      paramVarArgs.co(6, this.Aaj);
      if (this.SYa != null) {
        paramVarArgs.f(7, this.SYa);
      }
      paramVarArgs.bm(8, this.SYb);
      AppMethodBeat.o(122502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fLj == null) {
        break label776;
      }
    }
    label776:
    for (paramInt = g.a.a.b.b.a.g(1, this.fLj) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SXW);
      paramInt = i;
      if (this.SXX != null) {
        paramInt = i + g.a.a.a.oD(3, this.SXX.computeSize());
      }
      i = paramInt + g.a.a.a.c(4, 8, this.SXY) + (g.a.a.b.b.a.gL(5) + 1) + (g.a.a.b.b.a.gL(6) + 1);
      paramInt = i;
      if (this.SYa != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SYa);
      }
      i = g.a.a.b.b.a.p(8, this.SYb);
      AppMethodBeat.o(122502);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SXW.clear();
        this.SXY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnc localbnc = (bnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122502);
          return -1;
        case 1: 
          localbnc.fLj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(122502);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efi)localObject2).parseFrom((byte[])localObject1);
            }
            localbnc.SXW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efi)localObject2).parseFrom((byte[])localObject1);
            }
            localbnc.SXX = ((efi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnb)localObject2).parseFrom((byte[])localObject1);
            }
            localbnc.SXY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 5: 
          localbnc.SXZ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(122502);
          return 0;
        case 6: 
          localbnc.Aaj = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(122502);
          return 0;
        case 7: 
          localbnc.SYa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(122502);
          return 0;
        }
        localbnc.SYb = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(122502);
        return 0;
      }
      AppMethodBeat.o(122502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnc
 * JD-Core Version:    0.7.0.1
 */