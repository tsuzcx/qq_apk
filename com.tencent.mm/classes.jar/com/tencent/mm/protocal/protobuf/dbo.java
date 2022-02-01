package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbo
  extends com.tencent.mm.cd.a
{
  public int GiZ;
  public LinkedList<FinderObject> SGC;
  public FinderObject TIV;
  public String TIW;
  public bdp TIX;
  public long localId;
  public int scene;
  
  public dbo()
  {
    AppMethodBeat.i(202214);
    this.SGC = new LinkedList();
    AppMethodBeat.o(202214);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202238);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIV != null)
      {
        paramVarArgs.oE(1, this.TIV.computeSize());
        this.TIV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SGC);
      if (this.TIW != null) {
        paramVarArgs.f(3, this.TIW);
      }
      paramVarArgs.aY(4, this.scene);
      paramVarArgs.bm(5, this.localId);
      if (this.TIX != null)
      {
        paramVarArgs.oE(6, this.TIX.computeSize());
        this.TIX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.GiZ);
      AppMethodBeat.o(202238);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIV == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = g.a.a.a.oD(1, this.TIV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SGC);
      paramInt = i;
      if (this.TIW != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TIW);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.scene) + g.a.a.b.b.a.p(5, this.localId);
      paramInt = i;
      if (this.TIX != null) {
        paramInt = i + g.a.a.a.oD(6, this.TIX.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.GiZ);
      AppMethodBeat.o(202238);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202238);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbo localdbo = (dbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202238);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localdbo.TIV = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202238);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localdbo.SGC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202238);
          return 0;
        case 3: 
          localdbo.TIW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(202238);
          return 0;
        case 4: 
          localdbo.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(202238);
          return 0;
        case 5: 
          localdbo.localId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(202238);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdp)localObject2).parseFrom((byte[])localObject1);
            }
            localdbo.TIX = ((bdp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202238);
          return 0;
        }
        localdbo.GiZ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(202238);
        return 0;
      }
      AppMethodBeat.o(202238);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbo
 * JD-Core Version:    0.7.0.1
 */