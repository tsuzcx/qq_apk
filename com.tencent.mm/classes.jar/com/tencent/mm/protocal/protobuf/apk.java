package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class apk
  extends com.tencent.mm.cd.a
{
  public FinderCommentInfo SCL;
  public csl SCM;
  public csm SCN;
  public FinderCommentInfo SCO;
  public int SCP;
  public int actionType;
  public long xbP;
  public bid xbu;
  public int xkX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168935);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.actionType);
      if (this.SCL != null)
      {
        paramVarArgs.oE(2, this.SCL.computeSize());
        this.SCL.writeFields(paramVarArgs);
      }
      if (this.SCM != null)
      {
        paramVarArgs.oE(3, this.SCM.computeSize());
        this.SCM.writeFields(paramVarArgs);
      }
      if (this.SCN != null)
      {
        paramVarArgs.oE(4, this.SCN.computeSize());
        this.SCN.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(5, this.xbP);
      if (this.SCO != null)
      {
        paramVarArgs.oE(6, this.SCO.computeSize());
        this.SCO.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.xkX);
      if (this.xbu != null)
      {
        paramVarArgs.oE(8, this.xbu.computeSize());
        this.xbu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.SCP);
      AppMethodBeat.o(168935);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.actionType) + 0;
      paramInt = i;
      if (this.SCL != null) {
        paramInt = i + g.a.a.a.oD(2, this.SCL.computeSize());
      }
      i = paramInt;
      if (this.SCM != null) {
        i = paramInt + g.a.a.a.oD(3, this.SCM.computeSize());
      }
      paramInt = i;
      if (this.SCN != null) {
        paramInt = i + g.a.a.a.oD(4, this.SCN.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.xbP);
      paramInt = i;
      if (this.SCO != null) {
        paramInt = i + g.a.a.a.oD(6, this.SCO.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.xkX);
      paramInt = i;
      if (this.xbu != null) {
        paramInt = i + g.a.a.a.oD(8, this.xbu.computeSize());
      }
      i = g.a.a.b.b.a.bM(9, this.SCP);
      AppMethodBeat.o(168935);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      apk localapk = (apk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168935);
        return -1;
      case 1: 
        localapk.actionType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168935);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localapk.SCL = ((FinderCommentInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new csl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((csl)localObject2).parseFrom((byte[])localObject1);
          }
          localapk.SCM = ((csl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new csm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((csm)localObject2).parseFrom((byte[])localObject1);
          }
          localapk.SCN = ((csm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 5: 
        localapk.xbP = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(168935);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localapk.SCO = ((FinderCommentInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 7: 
        localapk.xkX = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168935);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bid();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bid)localObject2).parseFrom((byte[])localObject1);
          }
          localapk.xbu = ((bid)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      }
      localapk.SCP = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(168935);
      return 0;
    }
    AppMethodBeat.o(168935);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apk
 * JD-Core Version:    0.7.0.1
 */