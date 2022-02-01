package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aia
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public int CNg;
  public dza RXU;
  public String SsO;
  public String SsP;
  public int SsQ;
  public String SsR;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117866);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RXU != null)
      {
        paramVarArgs.oE(1, this.RXU.computeSize());
        this.RXU.writeFields(paramVarArgs);
      }
      if (this.CMD != null) {
        paramVarArgs.f(2, this.CMD);
      }
      if (this.SsO != null) {
        paramVarArgs.f(3, this.SsO);
      }
      paramVarArgs.aY(4, this.CNg);
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      if (this.SsP != null) {
        paramVarArgs.f(6, this.SsP);
      }
      paramVarArgs.aY(7, this.SsQ);
      if (this.SsR != null) {
        paramVarArgs.f(8, this.SsR);
      }
      AppMethodBeat.o(117866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RXU == null) {
        break label684;
      }
    }
    label684:
    for (int i = g.a.a.a.oD(1, this.RXU.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMD);
      }
      i = paramInt;
      if (this.SsO != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SsO);
      }
      i += g.a.a.b.b.a.bM(4, this.CNg);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UserName);
      }
      i = paramInt;
      if (this.SsP != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SsP);
      }
      i += g.a.a.b.b.a.bM(7, this.SsQ);
      paramInt = i;
      if (this.SsR != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SsR);
      }
      AppMethodBeat.o(117866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aia localaia = (aia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117866);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dza localdza = new dza();
            if ((localObject != null) && (localObject.length > 0)) {
              localdza.parseFrom((byte[])localObject);
            }
            localaia.RXU = localdza;
            paramInt += 1;
          }
          AppMethodBeat.o(117866);
          return 0;
        case 2: 
          localaia.CMD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 3: 
          localaia.SsO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 4: 
          localaia.CNg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117866);
          return 0;
        case 5: 
          localaia.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 6: 
          localaia.SsP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 7: 
          localaia.SsQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117866);
          return 0;
        }
        localaia.SsR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117866);
        return 0;
      }
      AppMethodBeat.o(117866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aia
 * JD-Core Version:    0.7.0.1
 */