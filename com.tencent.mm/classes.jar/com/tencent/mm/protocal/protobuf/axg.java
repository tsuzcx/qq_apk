package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axg
  extends com.tencent.mm.cd.a
{
  public int SJK;
  public crw SJL;
  public aza SJM;
  public long SJN;
  public String SnB;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230213);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SnB != null) {
        paramVarArgs.f(1, this.SnB);
      }
      paramVarArgs.aY(51, this.SJK);
      if (this.SJL != null)
      {
        paramVarArgs.oE(101, this.SJL.computeSize());
        this.SJL.writeFields(paramVarArgs);
      }
      if (this.SJM != null)
      {
        paramVarArgs.oE(102, this.SJM.computeSize());
        this.SJM.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(103, this.SJN);
      paramVarArgs.bm(104, this.seq);
      AppMethodBeat.o(230213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SnB == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.b.b.a.g(1, this.SnB) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(51, this.SJK);
      paramInt = i;
      if (this.SJL != null) {
        paramInt = i + g.a.a.a.oD(101, this.SJL.computeSize());
      }
      i = paramInt;
      if (this.SJM != null) {
        i = paramInt + g.a.a.a.oD(102, this.SJM.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(103, this.SJN);
      int j = g.a.a.b.b.a.p(104, this.seq);
      AppMethodBeat.o(230213);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230213);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        axg localaxg = (axg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230213);
          return -1;
        case 1: 
          localaxg.SnB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230213);
          return 0;
        case 51: 
          localaxg.SJK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230213);
          return 0;
        case 101: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crw)localObject2).parseFrom((byte[])localObject1);
            }
            localaxg.SJL = ((crw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230213);
          return 0;
        case 102: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localaxg.SJM = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230213);
          return 0;
        case 103: 
          localaxg.SJN = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230213);
          return 0;
        }
        localaxg.seq = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(230213);
        return 0;
      }
      AppMethodBeat.o(230213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axg
 * JD-Core Version:    0.7.0.1
 */