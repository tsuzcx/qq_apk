package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bam
  extends com.tencent.mm.cd.a
{
  public b SDI;
  public int SMt;
  public LinkedList<bal> SMu;
  public long liveId;
  public String objectNonceId;
  public int xFI;
  public long xbk;
  
  public bam()
  {
    AppMethodBeat.i(231284);
    this.SMu = new LinkedList();
    AppMethodBeat.o(231284);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231286);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SMt);
      paramVarArgs.e(2, 8, this.SMu);
      paramVarArgs.bm(3, this.liveId);
      paramVarArgs.bm(4, this.xbk);
      if (this.objectNonceId != null) {
        paramVarArgs.f(5, this.objectNonceId);
      }
      paramVarArgs.aY(7, this.xFI);
      if (this.SDI != null) {
        paramVarArgs.c(8, this.SDI);
      }
      AppMethodBeat.o(231286);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SMt) + 0 + g.a.a.a.c(2, 8, this.SMu) + g.a.a.b.b.a.p(3, this.liveId) + g.a.a.b.b.a.p(4, this.xbk);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.xFI);
      paramInt = i;
      if (this.SDI != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.SDI);
      }
      AppMethodBeat.o(231286);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SMu.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(231286);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bam localbam = (bam)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 6: 
      default: 
        AppMethodBeat.o(231286);
        return -1;
      case 1: 
        localbam.SMt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231286);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bal localbal = new bal();
          if ((localObject != null) && (localObject.length > 0)) {
            localbal.parseFrom((byte[])localObject);
          }
          localbam.SMu.add(localbal);
          paramInt += 1;
        }
        AppMethodBeat.o(231286);
        return 0;
      case 3: 
        localbam.liveId = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(231286);
        return 0;
      case 4: 
        localbam.xbk = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(231286);
        return 0;
      case 5: 
        localbam.objectNonceId = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231286);
        return 0;
      case 7: 
        localbam.xFI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231286);
        return 0;
      }
      localbam.SDI = ((g.a.a.a.a)localObject).abFh.iUw();
      AppMethodBeat.o(231286);
      return 0;
    }
    AppMethodBeat.o(231286);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bam
 * JD-Core Version:    0.7.0.1
 */