package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class atd
  extends com.tencent.mm.bx.a
{
  public long ABa;
  public int AJo;
  public bui Auc;
  public FinderCommentInfo ZDD;
  public djn ZDE;
  public djo ZDF;
  public FinderCommentInfo ZDG;
  public int ZDH;
  public LinkedList<avc> ZDI;
  public int actionType;
  
  public atd()
  {
    AppMethodBeat.i(258250);
    this.ZDI = new LinkedList();
    AppMethodBeat.o(258250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168935);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.actionType);
      if (this.ZDD != null)
      {
        paramVarArgs.qD(2, this.ZDD.computeSize());
        this.ZDD.writeFields(paramVarArgs);
      }
      if (this.ZDE != null)
      {
        paramVarArgs.qD(3, this.ZDE.computeSize());
        this.ZDE.writeFields(paramVarArgs);
      }
      if (this.ZDF != null)
      {
        paramVarArgs.qD(4, this.ZDF.computeSize());
        this.ZDF.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.ABa);
      if (this.ZDG != null)
      {
        paramVarArgs.qD(6, this.ZDG.computeSize());
        this.ZDG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.AJo);
      if (this.Auc != null)
      {
        paramVarArgs.qD(8, this.Auc.computeSize());
        this.Auc.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.ZDH);
      paramVarArgs.e(10, 8, this.ZDI);
      AppMethodBeat.o(168935);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.actionType) + 0;
      paramInt = i;
      if (this.ZDD != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZDD.computeSize());
      }
      i = paramInt;
      if (this.ZDE != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZDE.computeSize());
      }
      paramInt = i;
      if (this.ZDF != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZDF.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ABa);
      paramInt = i;
      if (this.ZDG != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZDG.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.AJo);
      paramInt = i;
      if (this.Auc != null) {
        paramInt = i + i.a.a.a.qC(8, this.Auc.computeSize());
      }
      i = i.a.a.b.b.a.cJ(9, this.ZDH);
      int j = i.a.a.a.c(10, 8, this.ZDI);
      AppMethodBeat.o(168935);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZDI.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      atd localatd = (atd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168935);
        return -1;
      case 1: 
        localatd.actionType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168935);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localatd.ZDD = ((FinderCommentInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new djn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((djn)localObject2).parseFrom((byte[])localObject1);
          }
          localatd.ZDE = ((djn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new djo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((djo)localObject2).parseFrom((byte[])localObject1);
          }
          localatd.ZDF = ((djo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 5: 
        localatd.ABa = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(168935);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localatd.ZDG = ((FinderCommentInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 7: 
        localatd.AJo = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168935);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bui();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bui)localObject2).parseFrom((byte[])localObject1);
          }
          localatd.Auc = ((bui)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 9: 
        localatd.ZDH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168935);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new avc();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((avc)localObject2).parseFrom((byte[])localObject1);
        }
        localatd.ZDI.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    AppMethodBeat.o(168935);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atd
 * JD-Core Version:    0.7.0.1
 */