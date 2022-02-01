package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csf
  extends com.tencent.mm.cd.a
{
  public String AtN;
  public String AtP;
  public boolean Btc;
  public boolean Btd;
  public bfg TzP;
  public String TzQ;
  public LinkedList<csg> mediaList;
  public String musicFeedId;
  public int soundTrackType;
  
  public csf()
  {
    AppMethodBeat.i(169078);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(169078);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169079);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.mediaList);
      if (this.TzP != null)
      {
        paramVarArgs.oE(2, this.TzP.computeSize());
        this.TzP.writeFields(paramVarArgs);
      }
      if (this.AtP != null) {
        paramVarArgs.f(3, this.AtP);
      }
      if (this.AtN != null) {
        paramVarArgs.f(4, this.AtN);
      }
      if (this.TzQ != null) {
        paramVarArgs.f(5, this.TzQ);
      }
      paramVarArgs.co(6, this.Btc);
      paramVarArgs.co(7, this.Btd);
      paramVarArgs.aY(8, this.soundTrackType);
      if (this.musicFeedId != null) {
        paramVarArgs.f(9, this.musicFeedId);
      }
      AppMethodBeat.o(169079);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.mediaList) + 0;
      paramInt = i;
      if (this.TzP != null) {
        paramInt = i + g.a.a.a.oD(2, this.TzP.computeSize());
      }
      i = paramInt;
      if (this.AtP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.AtP);
      }
      paramInt = i;
      if (this.AtN != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.AtN);
      }
      i = paramInt;
      if (this.TzQ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TzQ);
      }
      i = i + (g.a.a.b.b.a.gL(6) + 1) + (g.a.a.b.b.a.gL(7) + 1) + g.a.a.b.b.a.bM(8, this.soundTrackType);
      paramInt = i;
      if (this.musicFeedId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.musicFeedId);
      }
      AppMethodBeat.o(169079);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mediaList.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169079);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      csf localcsf = (csf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169079);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new csg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((csg)localObject2).parseFrom((byte[])localObject1);
          }
          localcsf.mediaList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169079);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfg)localObject2).parseFrom((byte[])localObject1);
          }
          localcsf.TzP = ((bfg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169079);
        return 0;
      case 3: 
        localcsf.AtP = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 4: 
        localcsf.AtN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 5: 
        localcsf.TzQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 6: 
        localcsf.Btc = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(169079);
        return 0;
      case 7: 
        localcsf.Btd = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(169079);
        return 0;
      case 8: 
        localcsf.soundTrackType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169079);
        return 0;
      }
      localcsf.musicFeedId = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(169079);
      return 0;
    }
    AppMethodBeat.o(169079);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csf
 * JD-Core Version:    0.7.0.1
 */