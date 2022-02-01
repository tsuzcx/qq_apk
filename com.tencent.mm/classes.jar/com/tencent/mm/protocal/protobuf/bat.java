package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bat
  extends com.tencent.mm.cd.a
{
  public String RFk;
  public int SJK;
  public aza SJM;
  public long SMD;
  public String SnB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SJM != null)
      {
        paramVarArgs.oE(1, this.SJM.computeSize());
        this.SJM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SJK);
      if (this.SnB != null) {
        paramVarArgs.f(3, this.SnB);
      }
      if (this.RFk != null) {
        paramVarArgs.f(4, this.RFk);
      }
      paramVarArgs.bm(5, this.SMD);
      AppMethodBeat.o(204510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SJM == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.SJM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SJK);
      paramInt = i;
      if (this.SnB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SnB);
      }
      i = paramInt;
      if (this.RFk != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RFk);
      }
      paramInt = g.a.a.b.b.a.p(5, this.SMD);
      AppMethodBeat.o(204510);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bat localbat = (bat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204510);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aza localaza = new aza();
            if ((localObject != null) && (localObject.length > 0)) {
              localaza.parseFrom((byte[])localObject);
            }
            localbat.SJM = localaza;
            paramInt += 1;
          }
          AppMethodBeat.o(204510);
          return 0;
        case 2: 
          localbat.SJK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(204510);
          return 0;
        case 3: 
          localbat.SnB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204510);
          return 0;
        case 4: 
          localbat.RFk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204510);
          return 0;
        }
        localbat.SMD = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(204510);
        return 0;
      }
      AppMethodBeat.o(204510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bat
 * JD-Core Version:    0.7.0.1
 */