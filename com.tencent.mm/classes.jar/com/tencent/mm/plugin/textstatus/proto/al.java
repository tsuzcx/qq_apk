package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class al
  extends com.tencent.mm.cd.a
{
  public String MEN;
  public TextStatusExtInfo MFN;
  public LinkedList<String> MFO;
  public boolean MFP;
  public String MFQ;
  public int MFR;
  public int MFS;
  public long MFT;
  public boolean MFU;
  public String MFV;
  public String MFW;
  public String errMsg;
  public String thumbPath;
  
  public al()
  {
    AppMethodBeat.i(232954);
    this.MFO = new LinkedList();
    AppMethodBeat.o(232954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232956);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFN != null)
      {
        paramVarArgs.oE(1, this.MFN.computeSize());
        this.MFN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.MFO);
      paramVarArgs.co(3, this.MFP);
      if (this.MFQ != null) {
        paramVarArgs.f(4, this.MFQ);
      }
      if (this.thumbPath != null) {
        paramVarArgs.f(5, this.thumbPath);
      }
      paramVarArgs.aY(6, this.MFR);
      paramVarArgs.aY(7, this.MFS);
      paramVarArgs.bm(8, this.MFT);
      paramVarArgs.co(9, this.MFU);
      if (this.errMsg != null) {
        paramVarArgs.f(10, this.errMsg);
      }
      if (this.MFV != null) {
        paramVarArgs.f(11, this.MFV);
      }
      if (this.MEN != null) {
        paramVarArgs.f(12, this.MEN);
      }
      if (this.MFW != null) {
        paramVarArgs.f(13, this.MFW);
      }
      AppMethodBeat.o(232956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFN == null) {
        break label932;
      }
    }
    label932:
    for (paramInt = g.a.a.a.oD(1, this.MFN.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.MFO) + (g.a.a.b.b.a.gL(3) + 1);
      paramInt = i;
      if (this.MFQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.MFQ);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.thumbPath);
      }
      i = i + g.a.a.b.b.a.bM(6, this.MFR) + g.a.a.b.b.a.bM(7, this.MFS) + g.a.a.b.b.a.p(8, this.MFT) + (g.a.a.b.b.a.gL(9) + 1);
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.errMsg);
      }
      i = paramInt;
      if (this.MFV != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.MFV);
      }
      paramInt = i;
      if (this.MEN != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.MEN);
      }
      i = paramInt;
      if (this.MFW != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.MFW);
      }
      AppMethodBeat.o(232956);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(232956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(232956);
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
            localal.MFN = localTextStatusExtInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(232956);
          return 0;
        case 2: 
          localal.MFO.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(232956);
          return 0;
        case 3: 
          localal.MFP = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(232956);
          return 0;
        case 4: 
          localal.MFQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(232956);
          return 0;
        case 5: 
          localal.thumbPath = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(232956);
          return 0;
        case 6: 
          localal.MFR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(232956);
          return 0;
        case 7: 
          localal.MFS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(232956);
          return 0;
        case 8: 
          localal.MFT = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(232956);
          return 0;
        case 9: 
          localal.MFU = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(232956);
          return 0;
        case 10: 
          localal.errMsg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(232956);
          return 0;
        case 11: 
          localal.MFV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(232956);
          return 0;
        case 12: 
          localal.MEN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(232956);
          return 0;
        }
        localal.MFW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(232956);
        return 0;
      }
      AppMethodBeat.o(232956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.al
 * JD-Core Version:    0.7.0.1
 */