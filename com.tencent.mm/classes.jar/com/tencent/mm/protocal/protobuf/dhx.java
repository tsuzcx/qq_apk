package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhx
  extends com.tencent.mm.cd.a
{
  public int TOV = 0;
  public String TOW;
  public int TOX = -1;
  public dhu TOY;
  public String TOZ = "";
  public boolean TPa = false;
  public String TPb = "";
  public boolean TPc = false;
  public int TPd = 0;
  public long endTime = 0L;
  public int lEK = -1;
  public String nnJ = "";
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
        paramVarArgs.f(1, this.sessionId);
      }
      paramVarArgs.bm(2, this.seq);
      paramVarArgs.aY(3, this.TOV);
      if (this.TOW != null) {
        paramVarArgs.f(4, this.TOW);
      }
      paramVarArgs.aY(5, this.TOX);
      paramVarArgs.bm(6, this.startTime);
      paramVarArgs.bm(7, this.endTime);
      if (this.TOY != null)
      {
        paramVarArgs.oE(8, this.TOY.computeSize());
        this.TOY.writeFields(paramVarArgs);
      }
      if (this.TOZ != null) {
        paramVarArgs.f(9, this.TOZ);
      }
      paramVarArgs.co(10, this.TPa);
      if (this.userName != null) {
        paramVarArgs.f(11, this.userName);
      }
      if (this.TPb != null) {
        paramVarArgs.f(12, this.TPb);
      }
      paramVarArgs.aY(13, this.lEK);
      paramVarArgs.co(14, this.TPc);
      paramVarArgs.aY(15, this.TPd);
      if (this.nnJ != null) {
        paramVarArgs.f(16, this.nnJ);
      }
      AppMethodBeat.o(122525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label1052;
      }
    }
    label1052:
    for (paramInt = g.a.a.b.b.a.g(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.seq) + g.a.a.b.b.a.bM(3, this.TOV);
      paramInt = i;
      if (this.TOW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TOW);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TOX) + g.a.a.b.b.a.p(6, this.startTime) + g.a.a.b.b.a.p(7, this.endTime);
      paramInt = i;
      if (this.TOY != null) {
        paramInt = i + g.a.a.a.oD(8, this.TOY.computeSize());
      }
      i = paramInt;
      if (this.TOZ != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TOZ);
      }
      i += g.a.a.b.b.a.gL(10) + 1;
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.userName);
      }
      i = paramInt;
      if (this.TPb != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TPb);
      }
      i = i + g.a.a.b.b.a.bM(13, this.lEK) + (g.a.a.b.b.a.gL(14) + 1) + g.a.a.b.b.a.bM(15, this.TPd);
      paramInt = i;
      if (this.nnJ != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.nnJ);
      }
      AppMethodBeat.o(122525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dhx localdhx = (dhx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122525);
          return -1;
        case 1: 
          localdhx.sessionId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 2: 
          localdhx.seq = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122525);
          return 0;
        case 3: 
          localdhx.TOV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122525);
          return 0;
        case 4: 
          localdhx.TOW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 5: 
          localdhx.TOX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122525);
          return 0;
        case 6: 
          localdhx.startTime = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122525);
          return 0;
        case 7: 
          localdhx.endTime = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122525);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dhu localdhu = new dhu();
            if ((localObject != null) && (localObject.length > 0)) {
              localdhu.parseFrom((byte[])localObject);
            }
            localdhx.TOY = localdhu;
            paramInt += 1;
          }
          AppMethodBeat.o(122525);
          return 0;
        case 9: 
          localdhx.TOZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 10: 
          localdhx.TPa = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122525);
          return 0;
        case 11: 
          localdhx.userName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 12: 
          localdhx.TPb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 13: 
          localdhx.lEK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122525);
          return 0;
        case 14: 
          localdhx.TPc = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122525);
          return 0;
        case 15: 
          localdhx.TPd = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122525);
          return 0;
        }
        localdhx.nnJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(122525);
        return 0;
      }
      AppMethodBeat.o(122525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhx
 * JD-Core Version:    0.7.0.1
 */