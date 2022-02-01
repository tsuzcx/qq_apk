package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyl
  extends com.tencent.mm.bw.a
{
  public int MDm = 0;
  public String MDn;
  public int MDo = -1;
  public cyi MDp;
  public String MDq = "";
  public boolean MDr = false;
  public String MDs = "";
  public boolean MDt = false;
  public int MDu = 0;
  public long endTime = 0L;
  public int iOu = -1;
  public String kvy = "";
  public long seq = 0L;
  public String sessionId;
  public long startTime = 0L;
  public String userName = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122525);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.e(1, this.sessionId);
      }
      paramVarArgs.bb(2, this.seq);
      paramVarArgs.aM(3, this.MDm);
      if (this.MDn != null) {
        paramVarArgs.e(4, this.MDn);
      }
      paramVarArgs.aM(5, this.MDo);
      paramVarArgs.bb(6, this.startTime);
      paramVarArgs.bb(7, this.endTime);
      if (this.MDp != null)
      {
        paramVarArgs.ni(8, this.MDp.computeSize());
        this.MDp.writeFields(paramVarArgs);
      }
      if (this.MDq != null) {
        paramVarArgs.e(9, this.MDq);
      }
      paramVarArgs.cc(10, this.MDr);
      if (this.userName != null) {
        paramVarArgs.e(11, this.userName);
      }
      if (this.MDs != null) {
        paramVarArgs.e(12, this.MDs);
      }
      paramVarArgs.aM(13, this.iOu);
      paramVarArgs.cc(14, this.MDt);
      paramVarArgs.aM(15, this.MDu);
      if (this.kvy != null) {
        paramVarArgs.e(16, this.kvy);
      }
      AppMethodBeat.o(122525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = g.a.a.b.b.a.f(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.seq) + g.a.a.b.b.a.bu(3, this.MDm);
      paramInt = i;
      if (this.MDn != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MDn);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MDo) + g.a.a.b.b.a.r(6, this.startTime) + g.a.a.b.b.a.r(7, this.endTime);
      paramInt = i;
      if (this.MDp != null) {
        paramInt = i + g.a.a.a.nh(8, this.MDp.computeSize());
      }
      i = paramInt;
      if (this.MDq != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MDq);
      }
      i += g.a.a.b.b.a.fS(10) + 1;
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.userName);
      }
      i = paramInt;
      if (this.MDs != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MDs);
      }
      i = i + g.a.a.b.b.a.bu(13, this.iOu) + (g.a.a.b.b.a.fS(14) + 1) + g.a.a.b.b.a.bu(15, this.MDu);
      paramInt = i;
      if (this.kvy != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.kvy);
      }
      AppMethodBeat.o(122525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyl localcyl = (cyl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122525);
          return -1;
        case 1: 
          localcyl.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 2: 
          localcyl.seq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122525);
          return 0;
        case 3: 
          localcyl.MDm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122525);
          return 0;
        case 4: 
          localcyl.MDn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 5: 
          localcyl.MDo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122525);
          return 0;
        case 6: 
          localcyl.startTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122525);
          return 0;
        case 7: 
          localcyl.endTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122525);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cyi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcyl.MDp = ((cyi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122525);
          return 0;
        case 9: 
          localcyl.MDq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 10: 
          localcyl.MDr = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122525);
          return 0;
        case 11: 
          localcyl.userName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 12: 
          localcyl.MDs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 13: 
          localcyl.iOu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122525);
          return 0;
        case 14: 
          localcyl.MDt = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122525);
          return 0;
        case 15: 
          localcyl.MDu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122525);
          return 0;
        }
        localcyl.kvy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122525);
        return 0;
      }
      AppMethodBeat.o(122525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyl
 * JD-Core Version:    0.7.0.1
 */