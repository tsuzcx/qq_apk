package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class axe
  extends com.tencent.mm.cd.a
{
  public aza SJC;
  public long SJD;
  public b SJE;
  public axv SJF;
  public LinkedList<aza> SJG;
  public aza SJH;
  public String SJI;
  public String SJs;
  public int msg_type;
  public long seq;
  public String session_id;
  
  public axe()
  {
    AppMethodBeat.i(231006);
    this.SJG = new LinkedList();
    AppMethodBeat.o(231006);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231007);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SJC != null)
      {
        paramVarArgs.oE(1, this.SJC.computeSize());
        this.SJC.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.msg_type);
      if (this.SJs != null) {
        paramVarArgs.f(3, this.SJs);
      }
      paramVarArgs.bm(4, this.SJD);
      if (this.SJE != null) {
        paramVarArgs.c(5, this.SJE);
      }
      if (this.SJF != null)
      {
        paramVarArgs.oE(6, this.SJF.computeSize());
        this.SJF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.SJG);
      if (this.session_id != null) {
        paramVarArgs.f(51, this.session_id);
      }
      paramVarArgs.bm(101, this.seq);
      if (this.SJH != null)
      {
        paramVarArgs.oE(102, this.SJH.computeSize());
        this.SJH.writeFields(paramVarArgs);
      }
      if (this.SJI != null) {
        paramVarArgs.f(103, this.SJI);
      }
      AppMethodBeat.o(231007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SJC == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = g.a.a.a.oD(1, this.SJC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.msg_type);
      paramInt = i;
      if (this.SJs != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SJs);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.SJD);
      paramInt = i;
      if (this.SJE != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SJE);
      }
      i = paramInt;
      if (this.SJF != null) {
        i = paramInt + g.a.a.a.oD(6, this.SJF.computeSize());
      }
      i += g.a.a.a.c(7, 8, this.SJG);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(51, this.session_id);
      }
      i = paramInt + g.a.a.b.b.a.p(101, this.seq);
      paramInt = i;
      if (this.SJH != null) {
        paramInt = i + g.a.a.a.oD(102, this.SJH.computeSize());
      }
      i = paramInt;
      if (this.SJI != null) {
        i = paramInt + g.a.a.b.b.a.g(103, this.SJI);
      }
      AppMethodBeat.o(231007);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SJG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        axe localaxe = (axe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231007);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localaxe.SJC = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231007);
          return 0;
        case 2: 
          localaxe.msg_type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231007);
          return 0;
        case 3: 
          localaxe.SJs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231007);
          return 0;
        case 4: 
          localaxe.SJD = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231007);
          return 0;
        case 5: 
          localaxe.SJE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231007);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axv)localObject2).parseFrom((byte[])localObject1);
            }
            localaxe.SJF = ((axv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231007);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localaxe.SJG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231007);
          return 0;
        case 51: 
          localaxe.session_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231007);
          return 0;
        case 101: 
          localaxe.seq = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231007);
          return 0;
        case 102: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localaxe.SJH = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231007);
          return 0;
        }
        localaxe.SJI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(231007);
        return 0;
      }
      AppMethodBeat.o(231007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axe
 * JD-Core Version:    0.7.0.1
 */