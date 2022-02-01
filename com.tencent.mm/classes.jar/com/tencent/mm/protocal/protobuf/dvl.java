package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvl
  extends com.tencent.mm.cd.a
{
  public String EyH;
  public String EyI;
  public int Tkq;
  public String Ubp;
  public LinkedList<eno> Ubq;
  public String Ubr;
  public dvj Ubs;
  public String Ubt;
  public int Ubu;
  public int Ubv;
  public int Ubw;
  public String description;
  public String llH;
  public String llI;
  public String llJ;
  public String title;
  public int tpK;
  
  public dvl()
  {
    AppMethodBeat.i(168759);
    this.Ubq = new LinkedList();
    AppMethodBeat.o(168759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168760);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.llI != null) {
        paramVarArgs.f(2, this.llI);
      }
      if (this.llJ != null) {
        paramVarArgs.f(3, this.llJ);
      }
      if (this.description != null) {
        paramVarArgs.f(4, this.description);
      }
      if (this.Ubp != null) {
        paramVarArgs.f(9, this.Ubp);
      }
      paramVarArgs.e(10, 8, this.Ubq);
      paramVarArgs.aY(11, this.tpK);
      if (this.EyH != null) {
        paramVarArgs.f(12, this.EyH);
      }
      if (this.EyI != null) {
        paramVarArgs.f(13, this.EyI);
      }
      if (this.Ubr != null) {
        paramVarArgs.f(14, this.Ubr);
      }
      if (this.llH != null) {
        paramVarArgs.f(15, this.llH);
      }
      if (this.Ubs != null)
      {
        paramVarArgs.oE(16, this.Ubs.computeSize());
        this.Ubs.writeFields(paramVarArgs);
      }
      if (this.Ubt != null) {
        paramVarArgs.f(17, this.Ubt);
      }
      paramVarArgs.aY(18, this.Ubu);
      paramVarArgs.aY(19, this.Ubv);
      paramVarArgs.aY(20, this.Ubw);
      paramVarArgs.aY(100, this.Tkq);
      AppMethodBeat.o(168760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1322;
      }
    }
    label1322:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.llI);
      }
      i = paramInt;
      if (this.llJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.llJ);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.description);
      }
      i = paramInt;
      if (this.Ubp != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Ubp);
      }
      i = i + g.a.a.a.c(10, 8, this.Ubq) + g.a.a.b.b.a.bM(11, this.tpK);
      paramInt = i;
      if (this.EyH != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.EyH);
      }
      i = paramInt;
      if (this.EyI != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.EyI);
      }
      paramInt = i;
      if (this.Ubr != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Ubr);
      }
      i = paramInt;
      if (this.llH != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.llH);
      }
      paramInt = i;
      if (this.Ubs != null) {
        paramInt = i + g.a.a.a.oD(16, this.Ubs.computeSize());
      }
      i = paramInt;
      if (this.Ubt != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.Ubt);
      }
      paramInt = g.a.a.b.b.a.bM(18, this.Ubu);
      int j = g.a.a.b.b.a.bM(19, this.Ubv);
      int k = g.a.a.b.b.a.bM(20, this.Ubw);
      int m = g.a.a.b.b.a.bM(100, this.Tkq);
      AppMethodBeat.o(168760);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ubq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvl localdvl = (dvl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168760);
          return -1;
        case 1: 
          localdvl.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 2: 
          localdvl.llI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 3: 
          localdvl.llJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 4: 
          localdvl.description = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 9: 
          localdvl.Ubp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eno();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eno)localObject2).parseFrom((byte[])localObject1);
            }
            localdvl.Ubq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 11: 
          localdvl.tpK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168760);
          return 0;
        case 12: 
          localdvl.EyH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 13: 
          localdvl.EyI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 14: 
          localdvl.Ubr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 15: 
          localdvl.llH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvj)localObject2).parseFrom((byte[])localObject1);
            }
            localdvl.Ubs = ((dvj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 17: 
          localdvl.Ubt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 18: 
          localdvl.Ubu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168760);
          return 0;
        case 19: 
          localdvl.Ubv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168760);
          return 0;
        case 20: 
          localdvl.Ubw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168760);
          return 0;
        }
        localdvl.Tkq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168760);
        return 0;
      }
      AppMethodBeat.o(168760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvl
 * JD-Core Version:    0.7.0.1
 */