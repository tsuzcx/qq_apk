package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjk
  extends com.tencent.mm.bw.a
{
  public azk MoJ;
  public String MoK;
  public LinkedList<cjl> mediaList;
  public int soundTrackType;
  public String vMV;
  public String vMX;
  public boolean wCu;
  public boolean wCv;
  
  public cjk()
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
      if (this.MoJ != null)
      {
        paramVarArgs.ni(2, this.MoJ.computeSize());
        this.MoJ.writeFields(paramVarArgs);
      }
      if (this.vMX != null) {
        paramVarArgs.e(3, this.vMX);
      }
      if (this.vMV != null) {
        paramVarArgs.e(4, this.vMV);
      }
      if (this.MoK != null) {
        paramVarArgs.e(5, this.MoK);
      }
      paramVarArgs.cc(6, this.wCu);
      paramVarArgs.cc(7, this.wCv);
      paramVarArgs.aM(8, this.soundTrackType);
      AppMethodBeat.o(169079);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.mediaList) + 0;
      paramInt = i;
      if (this.MoJ != null) {
        paramInt = i + g.a.a.a.nh(2, this.MoJ.computeSize());
      }
      i = paramInt;
      if (this.vMX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.vMX);
      }
      paramInt = i;
      if (this.vMV != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.vMV);
      }
      i = paramInt;
      if (this.MoK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MoK);
      }
      paramInt = g.a.a.b.b.a.fS(6);
      int j = g.a.a.b.b.a.fS(7);
      int k = g.a.a.b.b.a.bu(8, this.soundTrackType);
      AppMethodBeat.o(169079);
      return i + (paramInt + 1) + (j + 1) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mediaList.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169079);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cjk localcjk = (cjk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169079);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjk.mediaList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169079);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjk.MoJ = ((azk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169079);
        return 0;
      case 3: 
        localcjk.vMX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 4: 
        localcjk.vMV = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 5: 
        localcjk.MoK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 6: 
        localcjk.wCu = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(169079);
        return 0;
      case 7: 
        localcjk.wCv = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(169079);
        return 0;
      }
      localcjk.soundTrackType = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(169079);
      return 0;
    }
    AppMethodBeat.o(169079);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjk
 * JD-Core Version:    0.7.0.1
 */