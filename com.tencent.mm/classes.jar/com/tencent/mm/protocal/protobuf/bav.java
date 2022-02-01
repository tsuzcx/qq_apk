package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bav
  extends com.tencent.mm.cd.a
{
  public String RFk;
  public aza SJM;
  public long SMD;
  public String SnB;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199311);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RFk != null) {
        paramVarArgs.f(1, this.RFk);
      }
      paramVarArgs.bm(2, this.SMD);
      if (this.SnB != null) {
        paramVarArgs.f(3, this.SnB);
      }
      if (this.SJM != null)
      {
        paramVarArgs.oE(4, this.SJM.computeSize());
        this.SJM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.status);
      AppMethodBeat.o(199311);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RFk == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.b.b.a.g(1, this.RFk) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SMD);
      paramInt = i;
      if (this.SnB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SnB);
      }
      i = paramInt;
      if (this.SJM != null) {
        i = paramInt + g.a.a.a.oD(4, this.SJM.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(5, this.status);
      AppMethodBeat.o(199311);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199311);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bav localbav = (bav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199311);
          return -1;
        case 1: 
          localbav.RFk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(199311);
          return 0;
        case 2: 
          localbav.SMD = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(199311);
          return 0;
        case 3: 
          localbav.SnB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(199311);
          return 0;
        case 4: 
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
            localbav.SJM = localaza;
            paramInt += 1;
          }
          AppMethodBeat.o(199311);
          return 0;
        }
        localbav.status = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(199311);
        return 0;
      }
      AppMethodBeat.o(199311);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bav
 * JD-Core Version:    0.7.0.1
 */