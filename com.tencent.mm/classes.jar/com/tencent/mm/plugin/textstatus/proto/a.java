package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class a
  extends com.tencent.mm.cd.a
{
  public TextStatusExtInfo MEA;
  public boolean MEB = true;
  public long MEC;
  public int MED;
  public int MEE;
  public int MEF;
  public int MEG;
  public String MEH;
  public int MEI;
  public String MEJ;
  public boolean MEK;
  public long enterTime;
  public String fileUrl;
  public String mediaPath;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243675);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MEA != null)
      {
        paramVarArgs.oE(1, this.MEA.computeSize());
        this.MEA.writeFields(paramVarArgs);
      }
      if (this.mediaPath != null) {
        paramVarArgs.f(2, this.mediaPath);
      }
      if (this.fileUrl != null) {
        paramVarArgs.f(3, this.fileUrl);
      }
      paramVarArgs.co(4, this.MEB);
      if (this.sessionId != null) {
        paramVarArgs.f(5, this.sessionId);
      }
      paramVarArgs.bm(6, this.MEC);
      paramVarArgs.bm(7, this.enterTime);
      paramVarArgs.aY(8, this.MED);
      paramVarArgs.aY(9, this.MEE);
      paramVarArgs.aY(10, this.MEF);
      paramVarArgs.aY(11, this.MEG);
      if (this.MEH != null) {
        paramVarArgs.f(12, this.MEH);
      }
      paramVarArgs.aY(13, this.MEI);
      if (this.MEJ != null) {
        paramVarArgs.f(14, this.MEJ);
      }
      paramVarArgs.co(15, this.MEK);
      AppMethodBeat.o(243675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEA == null) {
        break label992;
      }
    }
    label992:
    for (int i = g.a.a.a.oD(1, this.MEA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mediaPath != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mediaPath);
      }
      i = paramInt;
      if (this.fileUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fileUrl);
      }
      i += g.a.a.b.b.a.gL(4) + 1;
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.sessionId);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.MEC) + g.a.a.b.b.a.p(7, this.enterTime) + g.a.a.b.b.a.bM(8, this.MED) + g.a.a.b.b.a.bM(9, this.MEE) + g.a.a.b.b.a.bM(10, this.MEF) + g.a.a.b.b.a.bM(11, this.MEG);
      paramInt = i;
      if (this.MEH != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.MEH);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.MEI);
      paramInt = i;
      if (this.MEJ != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.MEJ);
      }
      i = g.a.a.b.b.a.gL(15);
      AppMethodBeat.o(243675);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243675);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            TextStatusExtInfo localTextStatusExtInfo = new TextStatusExtInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localTextStatusExtInfo.parseFrom((byte[])localObject);
            }
            locala.MEA = localTextStatusExtInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(243675);
          return 0;
        case 2: 
          locala.mediaPath = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243675);
          return 0;
        case 3: 
          locala.fileUrl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243675);
          return 0;
        case 4: 
          locala.MEB = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(243675);
          return 0;
        case 5: 
          locala.sessionId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243675);
          return 0;
        case 6: 
          locala.MEC = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(243675);
          return 0;
        case 7: 
          locala.enterTime = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(243675);
          return 0;
        case 8: 
          locala.MED = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243675);
          return 0;
        case 9: 
          locala.MEE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243675);
          return 0;
        case 10: 
          locala.MEF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243675);
          return 0;
        case 11: 
          locala.MEG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243675);
          return 0;
        case 12: 
          locala.MEH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243675);
          return 0;
        case 13: 
          locala.MEI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243675);
          return 0;
        case 14: 
          locala.MEJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243675);
          return 0;
        }
        locala.MEK = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(243675);
        return 0;
      }
      AppMethodBeat.o(243675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.a
 * JD-Core Version:    0.7.0.1
 */