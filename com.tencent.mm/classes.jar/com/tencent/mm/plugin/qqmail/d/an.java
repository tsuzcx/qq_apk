package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class an
  extends com.tencent.mm.cd.a
{
  public String BDX;
  public LinkedList<al> Hnh;
  public LinkedList<al> Hni;
  public LinkedList<al> Hnj;
  public int Hnp;
  public al Hnq;
  public LinkedList<ak> Hnr;
  public LinkedList<ak> Hns;
  public String Hnt;
  public boolean Hnu;
  public String content;
  
  public an()
  {
    AppMethodBeat.i(250116);
    this.Hnh = new LinkedList();
    this.Hni = new LinkedList();
    this.Hnj = new LinkedList();
    this.Hnr = new LinkedList();
    this.Hns = new LinkedList();
    AppMethodBeat.o(250116);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Hnp);
      if (this.Hnq != null)
      {
        paramVarArgs.oE(2, this.Hnq.computeSize());
        this.Hnq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Hnh);
      paramVarArgs.e(4, 8, this.Hni);
      paramVarArgs.e(5, 8, this.Hnj);
      if (this.BDX != null) {
        paramVarArgs.f(6, this.BDX);
      }
      if (this.content != null) {
        paramVarArgs.f(7, this.content);
      }
      paramVarArgs.e(8, 8, this.Hnr);
      paramVarArgs.e(9, 8, this.Hns);
      if (this.Hnt != null) {
        paramVarArgs.f(10, this.Hnt);
      }
      paramVarArgs.co(11, this.Hnu);
      AppMethodBeat.o(250120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Hnp) + 0;
      paramInt = i;
      if (this.Hnq != null) {
        paramInt = i + g.a.a.a.oD(2, this.Hnq.computeSize());
      }
      i = paramInt + g.a.a.a.c(3, 8, this.Hnh) + g.a.a.a.c(4, 8, this.Hni) + g.a.a.a.c(5, 8, this.Hnj);
      paramInt = i;
      if (this.BDX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.BDX);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.content);
      }
      i = i + g.a.a.a.c(8, 8, this.Hnr) + g.a.a.a.c(9, 8, this.Hns);
      paramInt = i;
      if (this.Hnt != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Hnt);
      }
      i = g.a.a.b.b.a.gL(11);
      AppMethodBeat.o(250120);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hnh.clear();
      this.Hni.clear();
      this.Hnj.clear();
      this.Hnr.clear();
      this.Hns.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(250120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      an localan = (an)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(250120);
        return -1;
      case 1: 
        localan.Hnp = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(250120);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localan.Hnq = ((al)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250120);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localan.Hnh.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250120);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localan.Hni.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250120);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localan.Hnj.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250120);
        return 0;
      case 6: 
        localan.BDX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(250120);
        return 0;
      case 7: 
        localan.content = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(250120);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localan.Hnr.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250120);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localan.Hns.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250120);
        return 0;
      case 10: 
        localan.Hnt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(250120);
        return 0;
      }
      localan.Hnu = ((g.a.a.a.a)localObject1).abFh.AB();
      AppMethodBeat.o(250120);
      return 0;
    }
    AppMethodBeat.o(250120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.an
 * JD-Core Version:    0.7.0.1
 */