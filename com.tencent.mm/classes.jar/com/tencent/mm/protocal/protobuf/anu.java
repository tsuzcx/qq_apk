package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anu
  extends com.tencent.mm.cd.a
{
  public String ROZ;
  public anv SAt;
  public int duration;
  public String fzT;
  public int llp = -1;
  public int llq;
  public int llr = 0;
  public int lls;
  public int llt;
  public String lpC;
  public String lpK;
  public String vid;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.llp);
      paramVarArgs.aY(2, this.llr);
      paramVarArgs.aY(3, this.videoWidth);
      paramVarArgs.aY(4, this.videoHeight);
      paramVarArgs.aY(5, this.llq);
      paramVarArgs.aY(6, this.duration);
      if (this.vid != null) {
        paramVarArgs.f(7, this.vid);
      }
      if (this.fzT != null) {
        paramVarArgs.f(8, this.fzT);
      }
      if (this.lpC != null) {
        paramVarArgs.f(9, this.lpC);
      }
      paramVarArgs.aY(10, this.llt);
      if (this.SAt != null)
      {
        paramVarArgs.oE(11, this.SAt.computeSize());
        this.SAt.writeFields(paramVarArgs);
      }
      if (this.lpK != null) {
        paramVarArgs.f(12, this.lpK);
      }
      if (this.ROZ != null) {
        paramVarArgs.f(13, this.ROZ);
      }
      if (this.videoUrl != null) {
        paramVarArgs.f(14, this.videoUrl);
      }
      paramVarArgs.aY(15, this.lls);
      AppMethodBeat.o(127467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.llp) + 0 + g.a.a.b.b.a.bM(2, this.llr) + g.a.a.b.b.a.bM(3, this.videoWidth) + g.a.a.b.b.a.bM(4, this.videoHeight) + g.a.a.b.b.a.bM(5, this.llq) + g.a.a.b.b.a.bM(6, this.duration);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.vid);
      }
      i = paramInt;
      if (this.fzT != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.fzT);
      }
      paramInt = i;
      if (this.lpC != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.lpC);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.llt);
      paramInt = i;
      if (this.SAt != null) {
        paramInt = i + g.a.a.a.oD(11, this.SAt.computeSize());
      }
      i = paramInt;
      if (this.lpK != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.lpK);
      }
      paramInt = i;
      if (this.ROZ != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.ROZ);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.videoUrl);
      }
      paramInt = g.a.a.b.b.a.bM(15, this.lls);
      AppMethodBeat.o(127467);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      anu localanu = (anu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127467);
        return -1;
      case 1: 
        localanu.llp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127467);
        return 0;
      case 2: 
        localanu.llr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127467);
        return 0;
      case 3: 
        localanu.videoWidth = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127467);
        return 0;
      case 4: 
        localanu.videoHeight = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127467);
        return 0;
      case 5: 
        localanu.llq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127467);
        return 0;
      case 6: 
        localanu.duration = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127467);
        return 0;
      case 7: 
        localanu.vid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 8: 
        localanu.fzT = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 9: 
        localanu.lpC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 10: 
        localanu.llt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127467);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          anv localanv = new anv();
          if ((localObject != null) && (localObject.length > 0)) {
            localanv.parseFrom((byte[])localObject);
          }
          localanu.SAt = localanv;
          paramInt += 1;
        }
        AppMethodBeat.o(127467);
        return 0;
      case 12: 
        localanu.lpK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 13: 
        localanu.ROZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 14: 
        localanu.videoUrl = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127467);
        return 0;
      }
      localanu.lls = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(127467);
      return 0;
    }
    AppMethodBeat.o(127467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anu
 * JD-Core Version:    0.7.0.1
 */