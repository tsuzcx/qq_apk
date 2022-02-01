package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ad
  extends com.tencent.mm.cd.a
{
  public long MFC;
  public LinkedList<ab> MFD;
  public LinkedList<ab> MFE;
  public int MFF;
  public int endTime;
  public String groupId;
  public int order;
  public String url;
  
  public ad()
  {
    AppMethodBeat.i(243659);
    this.MFD = new LinkedList();
    this.MFE = new LinkedList();
    AppMethodBeat.o(243659);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243661);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      paramVarArgs.bm(2, this.MFC);
      paramVarArgs.e(3, 8, this.MFD);
      paramVarArgs.e(4, 8, this.MFE);
      paramVarArgs.aY(5, this.MFF);
      paramVarArgs.aY(6, this.endTime);
      if (this.groupId != null) {
        paramVarArgs.f(7, this.groupId);
      }
      paramVarArgs.aY(8, this.order);
      AppMethodBeat.o(243661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.MFC) + g.a.a.a.c(3, 8, this.MFD) + g.a.a.a.c(4, 8, this.MFE) + g.a.a.b.b.a.bM(5, this.MFF) + g.a.a.b.b.a.bM(6, this.endTime);
      paramInt = i;
      if (this.groupId != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.groupId);
      }
      i = g.a.a.b.b.a.bM(8, this.order);
      AppMethodBeat.o(243661);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFD.clear();
        this.MFE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        ab localab;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243661);
          return -1;
        case 1: 
          localad.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243661);
          return 0;
        case 2: 
          localad.MFC = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(243661);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localab = new ab();
            if ((localObject != null) && (localObject.length > 0)) {
              localab.parseFrom((byte[])localObject);
            }
            localad.MFD.add(localab);
            paramInt += 1;
          }
          AppMethodBeat.o(243661);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localab = new ab();
            if ((localObject != null) && (localObject.length > 0)) {
              localab.parseFrom((byte[])localObject);
            }
            localad.MFE.add(localab);
            paramInt += 1;
          }
          AppMethodBeat.o(243661);
          return 0;
        case 5: 
          localad.MFF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243661);
          return 0;
        case 6: 
          localad.endTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243661);
          return 0;
        case 7: 
          localad.groupId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243661);
          return 0;
        }
        localad.order = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(243661);
        return 0;
      }
      AppMethodBeat.o(243661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ad
 * JD-Core Version:    0.7.0.1
 */