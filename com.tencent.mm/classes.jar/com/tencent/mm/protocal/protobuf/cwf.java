package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwf
  extends com.tencent.mm.cd.a
{
  public int ARI;
  public int ASA;
  public LinkedList<cwy> ASi;
  public String ASz;
  public int SFr;
  public int SFs;
  public int SFt;
  public int SFw;
  public int SFy;
  public int SFz;
  public int TFc;
  public int TFd;
  public int TFe;
  public long TFf;
  public int duration;
  public String fPD;
  public long feedId;
  public int networkId;
  public int pxV;
  public int scene;
  public String zKY;
  
  public cwf()
  {
    AppMethodBeat.i(206334);
    this.ASi = new LinkedList();
    AppMethodBeat.o(206334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206337);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.feedId);
      paramVarArgs.aY(2, this.SFr);
      paramVarArgs.aY(3, this.scene);
      paramVarArgs.aY(4, this.SFs);
      paramVarArgs.aY(5, this.pxV);
      paramVarArgs.aY(6, this.SFt);
      paramVarArgs.aY(7, this.duration);
      paramVarArgs.aY(8, this.TFc);
      paramVarArgs.aY(9, this.TFd);
      paramVarArgs.aY(10, this.SFw);
      paramVarArgs.e(11, 8, this.ASi);
      paramVarArgs.aY(12, this.TFe);
      paramVarArgs.aY(13, this.ARI);
      paramVarArgs.aY(14, this.SFy);
      if (this.zKY != null) {
        paramVarArgs.f(15, this.zKY);
      }
      paramVarArgs.bm(16, this.TFf);
      paramVarArgs.aY(17, this.SFz);
      paramVarArgs.aY(18, this.networkId);
      if (this.ASz != null) {
        paramVarArgs.f(19, this.ASz);
      }
      paramVarArgs.aY(20, this.ASA);
      if (this.fPD != null) {
        paramVarArgs.f(21, this.fPD);
      }
      AppMethodBeat.o(206337);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.feedId) + 0 + g.a.a.b.b.a.bM(2, this.SFr) + g.a.a.b.b.a.bM(3, this.scene) + g.a.a.b.b.a.bM(4, this.SFs) + g.a.a.b.b.a.bM(5, this.pxV) + g.a.a.b.b.a.bM(6, this.SFt) + g.a.a.b.b.a.bM(7, this.duration) + g.a.a.b.b.a.bM(8, this.TFc) + g.a.a.b.b.a.bM(9, this.TFd) + g.a.a.b.b.a.bM(10, this.SFw) + g.a.a.a.c(11, 8, this.ASi) + g.a.a.b.b.a.bM(12, this.TFe) + g.a.a.b.b.a.bM(13, this.ARI) + g.a.a.b.b.a.bM(14, this.SFy);
      paramInt = i;
      if (this.zKY != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.zKY);
      }
      i = paramInt + g.a.a.b.b.a.p(16, this.TFf) + g.a.a.b.b.a.bM(17, this.SFz) + g.a.a.b.b.a.bM(18, this.networkId);
      paramInt = i;
      if (this.ASz != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.ASz);
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.ASA);
      paramInt = i;
      if (this.fPD != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.fPD);
      }
      AppMethodBeat.o(206337);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ASi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(206337);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      cwf localcwf = (cwf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(206337);
        return -1;
      case 1: 
        localcwf.feedId = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(206337);
        return 0;
      case 2: 
        localcwf.SFr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 3: 
        localcwf.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 4: 
        localcwf.SFs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 5: 
        localcwf.pxV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 6: 
        localcwf.SFt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 7: 
        localcwf.duration = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 8: 
        localcwf.TFc = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 9: 
        localcwf.TFd = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 10: 
        localcwf.SFw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cwy localcwy = new cwy();
          if ((localObject != null) && (localObject.length > 0)) {
            localcwy.parseFrom((byte[])localObject);
          }
          localcwf.ASi.add(localcwy);
          paramInt += 1;
        }
        AppMethodBeat.o(206337);
        return 0;
      case 12: 
        localcwf.TFe = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 13: 
        localcwf.ARI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 14: 
        localcwf.SFy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 15: 
        localcwf.zKY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(206337);
        return 0;
      case 16: 
        localcwf.TFf = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(206337);
        return 0;
      case 17: 
        localcwf.SFz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 18: 
        localcwf.networkId = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      case 19: 
        localcwf.ASz = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(206337);
        return 0;
      case 20: 
        localcwf.ASA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206337);
        return 0;
      }
      localcwf.fPD = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(206337);
      return 0;
    }
    AppMethodBeat.o(206337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwf
 * JD-Core Version:    0.7.0.1
 */