package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcb
  extends com.tencent.mm.cd.a
{
  public cke RRh;
  public qr RRi;
  public dca RRj;
  public int TJD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133180);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RRh != null)
      {
        paramVarArgs.oE(1, this.RRh.computeSize());
        this.RRh.writeFields(paramVarArgs);
      }
      if (this.RRj != null)
      {
        paramVarArgs.oE(2, this.RRj.computeSize());
        this.RRj.writeFields(paramVarArgs);
      }
      if (this.RRi != null)
      {
        paramVarArgs.oE(3, this.RRi.computeSize());
        this.RRi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.TJD);
      AppMethodBeat.o(133180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RRh == null) {
        break label596;
      }
    }
    label596:
    for (int i = g.a.a.a.oD(1, this.RRh.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRj != null) {
        paramInt = i + g.a.a.a.oD(2, this.RRj.computeSize());
      }
      i = paramInt;
      if (this.RRi != null) {
        i = paramInt + g.a.a.a.oD(3, this.RRi.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.TJD);
      AppMethodBeat.o(133180);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcb localdcb = (dcb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133180);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cke)localObject2).parseFrom((byte[])localObject1);
            }
            localdcb.RRh = ((cke)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dca();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dca)localObject2).parseFrom((byte[])localObject1);
            }
            localdcb.RRj = ((dca)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qr)localObject2).parseFrom((byte[])localObject1);
            }
            localdcb.RRi = ((qr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        }
        localdcb.TJD = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133180);
        return 0;
      }
      AppMethodBeat.o(133180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcb
 * JD-Core Version:    0.7.0.1
 */